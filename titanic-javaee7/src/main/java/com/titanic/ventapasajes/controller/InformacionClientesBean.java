package com.titanic.ventapasajes.controller;


import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.security.Seguridad;
import com.titanic.ventapasajes.service.RegistroClienteService;
import com.titanic.ventapasajes.service.RegistroProgramacionService;
import com.titanic.ventapasajes.service.RegistroVentaService;
import com.titanic.ventapasajes.util.jpa.Transaccion;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by josediaz on 1/3/16.
 */
@Named
@ViewScoped
public class InformacionClientesBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private RegistroVentaService ventaService;

    @Inject
    private RegistroProgramacionService programacionService;

    @Inject
    private RegistroClienteService clienteService;

    @Inject
    private HttpServletRequest request;


    @Inject
    private Seguridad seguridad;


    private Programacion programacion;

    private Venta venta;


    private List<Boleto> boletosReservados = new ArrayList<>();
    private List<Boleto> boletosPagados = new ArrayList<>();

    @PostConstruct
    public void init() {

        String programacionId = (String) request.getSession().getAttribute("programacionId");

        programacion = programacionService.obtenerProgramacion(Long.valueOf(programacionId));

        venta = ventaService.obtenerVenta(programacion);

        obtenerBoletosReservadosYPagados();

    }

    private void obtenerBoletosReservadosYPagados() {


        for (FilaBoleto filaBoleto : venta.getFilasBoletos()) {

            for (Boleto boleto : filaBoleto.getBoletos()) {

                if (boleto.getEstadoBoleto() == EstadoAsiento.RESERVADO) {

                    if (boleto.getUsuario().getIdeUsuario() == seguridad.getUsuarioLogeado().getUsuario().getIdeUsuario()) {
                        Cliente cliente = new Cliente();
                        cliente.setEdad(0);
                        cliente.setSexo(Sexo.FEMENINO);
                        cliente.setTipoDocumento(TipoDocumento.DNI);
                        cliente.setTipoPersona(TipoPersona.NATURAL);
                        cliente.setDebePresentarCartaNotarial(false);
                        boleto.setCliente(cliente);
                        boletosReservados.add(boleto);
                    }
                }

                if (boleto.getEstadoBoleto() == EstadoAsiento.PAGADO) {
                    boletosPagados.add(boleto);
                }
            }
        }

    }


    public List<String> completeClientes(String query) {
        List<Cliente> todosLosClientes = clienteService.buscarTodos();
        List<String> dnisFiltrados = new ArrayList<>();

        for (Cliente cliente : todosLosClientes) {
            if (cliente.getNumeroDocumento().toLowerCase().startsWith(query)) {
                dnisFiltrados.add(cliente.getNumeroDocumento());
            }
        }
        return dnisFiltrados;
    }


    public void setearCliente(Boleto boleto) {

        Cliente cliente = boleto.getCliente();

        if (cliente != null) {
            Cliente clienteBD = clienteService.obtenerClientePorNumeroDocumento(cliente.getNumeroDocumento());
            cliente.setNumeroDocumento(clienteBD.getNumeroDocumento());
            cliente.setEdad(clienteBD.getEdad());
            cliente.setSexo(clienteBD.getSexo());
            cliente.setNombreCliente(clienteBD.getNombreCliente());
            cliente.setIdeCliente(clienteBD.getIdeCliente());
            cliente.setNumeroTelefono(clienteBD.getNumeroTelefono());
        }


    }


    @Transaccion
    public void registrarVentaConCliente() {

        try {
            if (boletosReservados.size() > 0) {

                for (int i = 0; i < boletosReservados.size(); i++) {

                    Cliente cliente = boletosReservados.get(i).getCliente();
                    cliente = clienteService.adicionarCliente(cliente);
                    boletosReservados.get(i).setCliente(cliente);
                    boletosReservados.get(i).setEstadoBoleto(EstadoAsiento.PAGADO);
                    Calendar fechaVenta = Calendar.getInstance();
                    boletosReservados.get(i).setFechaVenta(fechaVenta.getTime());
                    //boletosReservados.get(i).setHoraSalida(programacion.getHoraSalida());


                }


                this.venta = ventaService.registrarVenta(venta);


                this.boletosReservados = new ArrayList<>();

                this.boletosPagados = new ArrayList<>();

                obtenerBoletosReservadosYPagados();

                //printSilentPDF();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta Satisfactoria", "Venta Satisfactoria");

                FacesContext.getCurrentInstance().addMessage(null, message);


            }


        } catch (Exception ex) {
            ex.printStackTrace();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Venta de Boletos", "No se pudo vender los Boletos. Contactar a Sistemas.");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }


    public Sexo[] getSexo() {
        return Sexo.values();
    }


    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    public List<Boleto> getBoletosReservados() {
        return boletosReservados;
    }

    public void setBoletosReservados(List<Boleto> boletosReservados) {
        this.boletosReservados = boletosReservados;
    }

    public List<Boleto> getBoletosPagados() {
        return boletosPagados;
    }

    public void setBoletosPagados(List<Boleto> boletosPagados) {
        this.boletosPagados = boletosPagados;
    }
}
