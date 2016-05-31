package com.titanic.ventapasajes.controller;


import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.repositorio.ProgramacionRepositorio;
import com.titanic.ventapasajes.repositorio.TerminalRepositorio;
import com.titanic.ventapasajes.security.Seguridad;
import com.titanic.ventapasajes.service.RegistroVentaService;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringEscapeUtils;


/**
 * Created by josediaz on 12/27/15.
 */

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@Named
@RequestScoped
public class SeleccionarAsientosBean implements Serializable {

    private static final long serialVersionUID = 1L;



    @Inject
    private RegistroVentaService ventaService;

    @Inject
    private ProgramacionRepositorio programacionRepositorio;

    @Inject
    private TerminalRepositorio terminalRepositorio;

    @Inject
    private HttpServletRequest request;

    @Inject
    private Seguridad seguridad;

    private Programacion programacion;

    private Venta venta;


    @PostConstruct
    public void init() {

        String programacionReq = request.getParameter("programacion");

        String programacionId = null;

        if (programacionReq != null) {
            request.getSession().setAttribute("programacionId", programacionReq);
            programacionId = programacionReq;
        } else {
            programacionId = (String) request.getSession().getAttribute("programacionId");
        }

        programacion = programacionRepositorio.obtenerProgramacion(Long.valueOf(programacionId));

        venta = ventaService.obtenerVenta(programacion);
        if (venta == null) {
            nuevaVenta();
        }
    }


    private void nuevaVenta() {

        try {

            venta = new Venta();
            venta.setProgramacion(programacion);
            venta.setTotalVenta(BigDecimal.ZERO);

            List<FilaBoleto> filasBoletos = new ArrayList<>();


            venta.setFilasBoletos(clonarFilas(filasBoletos));


            ventaService.registrarVenta(venta);
        } catch (Exception ex) {

            venta.setFilasBoletos(new ArrayList<FilaBoleto>());


            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nueva Venta",
                    "No se pudo crear la venta. Contactar a Sistemas.");

            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }

    private List<FilaBoleto> clonarFilas(List<FilaBoleto> filasBoletos) {

        for (Fila fila : programacion.getBus().getFilas()) {

            FilaBoleto filaBoleto = new FilaBoleto();
            filaBoleto.setPrimerPiso(fila.isPrimerPiso());
            filaBoleto.setVenta(venta);
            filaBoleto.setBoletos(new ArrayList<Boleto>());

            for (Asiento asiento : fila.getAsientos()) {

                Boleto boleto = new Boleto();
                boleto.setCalidad(asiento.getTipoAsiento());
                if(asiento.getTipoAsiento()!= TipoAsiento.NO_APLICA){
                    boleto.setEstadoBoleto(EstadoAsiento.LIBRE);
                    boleto.setAsiento(true);
                }else{
                    boleto.setEstadoBoleto(EstadoAsiento.NO_DISPONIBLE);

                }
                boleto.setPresentoCartaNotarial(false);
                boleto.setFilaBoleto(filaBoleto);
                boleto.setNumeroBoleto(asiento.getNumeroAsiento());
                boleto.setPrecio(BigDecimal.ZERO);
                boleto.setPrimerPiso(asiento.isPrimerPiso());
                setPrecioBoleto(boleto);
                boleto.setOrigen(programacion.getRuta().getOrigen().getNombreTerminal());
                boleto.setDestino(programacion.getRuta().getDestino().getNombreTerminal());
                filaBoleto.getBoletos().add(boleto);
            }

            filasBoletos.add(filaBoleto);
        }

        return filasBoletos;
    }


    private void setPrecioBoleto(Boleto boleto) {
        Recorrido ruta = programacion.getRuta();
        for (TarifaGeneral tarifaGeneral : ruta.getPrecios()) {
            if (tarifaGeneral.getTipoAsiento().equals(boleto.getCalidad())) {
                boleto.setPrecio(tarifaGeneral.getPrecio());
                break;
            }
        }

    }




    public void reservar(Boleto boleto) {

        Usuario vendedor = seguridad.getUsuarioLogeado().getUsuario();

        if (boleto.getUsuario() == null
                || boleto.getUsuario().getIdeUsuario() == vendedor.getIdeUsuario()) {

            reservadoBoletoPorVendedor(boleto);

        } else {
            FacesUtil.adicionarMensajeError(
                    "Este boleto ya ha sido reservador/vendido por " + boleto.getUsuario().getNombreUsuario());
        }

    }

    @Transaccion
    private void reservadoBoletoPorVendedor(Boleto boleto) {
        try {

            if (boleto.getEstadoBoleto() == EstadoAsiento.LIBRE) {
                boleto.setEstadoBoleto(EstadoAsiento.RESERVADO);
            } else if (boleto.getEstadoBoleto() == EstadoAsiento.RESERVADO) {
                boleto.setEstadoBoleto(EstadoAsiento.LIBRE);
            }

            boleto.setUsuario(seguridad.getUsuarioLogeado().getUsuario());
            Long ideTerminal = Long.valueOf(seguridad.getTerminal().getIdeTerminal());
            boleto.setTerminal(terminalRepositorio.obtenerTerminal(ideTerminal));

            this.venta = ventaService.registrarVenta(this.venta);
            notificarPUSH();

        } catch (Exception ex) {
            ex.printStackTrace();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Reservar Boleto",
                    "No se pudo reservar el Boleto. Contactar a Sistemas.");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }





    public void notificarPUSH() {
        String summary = "Reservar Reservado";
        String detail = "Nuevo asiento reservado";
        String CHANNEL = "/notify";

        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(CHANNEL,
                new FacesMessage(StringEscapeUtils.escapeHtml3(summary), StringEscapeUtils.escapeHtml3(detail)));
    }

    public List<FilaBoleto> getFilasInferiores(){
        return venta.getFilasBoletos().stream().filter(f -> f.isPrimerPiso()).collect(Collectors.toCollection(() ->
                new ArrayList<>()));


    }


    public List<FilaBoleto> getFilasSuperiores(){
        return venta.getFilasBoletos().stream().filter(f -> !f.isPrimerPiso()).collect(Collectors.toCollection(() ->
                new ArrayList<>()));

    }

    public String boletoStyleReservado(Boleto boleto) {
        return boleto.getUsuario().getColorPopup();
    }


    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }


    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
