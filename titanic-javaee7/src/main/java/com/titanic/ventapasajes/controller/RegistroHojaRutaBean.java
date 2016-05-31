package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.jsf.FacesUtil;

import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.modelo.HConductor;
import com.titanic.ventapasajes.modelo.HojaRuta;
import com.titanic.ventapasajes.modelo.Seguridad;
import com.titanic.ventapasajes.modelo.Tripulante;
import com.titanic.ventapasajes.repositorio.ConductorRepositorio;
import com.titanic.ventapasajes.repositorio.HojaRutaRepositorio;
import com.titanic.ventapasajes.repositorio.ProgramacionRepositorio;
import com.titanic.ventapasajes.ws.*;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by josediaz on 1/11/16.
 */

@Named
@ViewScoped
public class RegistroHojaRutaBean implements Serializable {


    private HojaRuta hojaRuta;

    private Programacion programacionSeleccionada;

    private HConductor hConductor;

    private Tripulante tripulante;

    @Inject
    private HojaRutaRepositorio hojaRutaRepositorio;

    @Inject
    private ProgramacionRepositorio programacionRepositorio;

    @Inject
    private ConductorRepositorio conductorRepositorio;

    public void inicializar() {


        if (this.hojaRuta == null) {
            this.hojaRuta = new HojaRuta();
            this.hojaRuta.setEstadoHojaRuta(EstadoHojaRuta.NUEVA);
            this.hojaRuta.setConductores(new ArrayList<>());
            this.hojaRuta.setTripulantes(new ArrayList<>());
            this.hConductor = new HConductor();
            this.tripulante = new Tripulante();
            this.programacionSeleccionada = new Programacion();
        }else{
            if(hConductor==null) hConductor = new HConductor();
            if(tripulante==null) tripulante = new Tripulante();
            if(programacionSeleccionada==null) programacionSeleccionada = this.hojaRuta.getProgramacion();
        }
    }


    public List<Programacion> getProgramaciones() {

        return programacionRepositorio.buscarTodos();
    }


    public void registrarHojaRuta() {
        if (!isEditando()) {
            this.hojaRuta.setFechaRegistro(new Date());
            this.hojaRuta.setProgramacion(programacionSeleccionada);
        }

        try {
            this.hojaRuta = hojaRutaRepositorio.adicionarHojaRuta(this.hojaRuta);
        } catch (Exception ex) {
            FacesUtil.adicionarMensajeError("Error al registrar hoja de ruta.");
        }
        FacesUtil.adicionarMensajeInfo("La hoja de ruta se registro correctamente");
    }

    public void buscarConductor() {


        if (programacionSeleccionada == null || programacionSeleccionada.getIdeProgramacion() ==null) {
            FacesUtil.adicionarMensajeError("Debe Seleccionar un Viaje.");
            return;
        }

        WSServiciosHR mtc = new WSServiciosHR();
        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();


        com.titanic.ventapasajes.ws.Conductor conductor = new com.titanic.ventapasajes.ws.Conductor();
        com.titanic.ventapasajes.ws.Seguridad seguridad = new com.titanic.ventapasajes.ws.Seguridad();
        seguridad.setRuc("20301040301");
        seguridad.setUsuario("059956");
        seguridad.setClave("123456");
        seguridad.setPartida("000396PNR");


        conductor.setSeguridad(seguridad);
        conductor.setTpoDocumento(hConductor.getTipoDocumento().getDescripcion());
        conductor.setNroDocumento(hConductor.getNroDocumento());

        ResultConductor resultado = mtcClient.getConductor(conductor);
        if (resultado.isReturn()) {

            com.titanic.ventapasajes.modelo.Conductor conductorEncontrado =
                    conductorRepositorio.obtenerConductorPorNumeroDocumento(hConductor.getNroDocumento());
            hConductor.setNroDocumento(conductorEncontrado.getNumeroDocumento());
            hConductor.setNombreConductor(conductorEncontrado.getNombreConductor());
            hConductor.setNroLicencia(conductorEncontrado.getNumeroLicencia());


            hConductor.setFechaInicio(programacionSeleccionada.getFechaSalida());
            hConductor.setFechaTermino(programacionSeleccionada.getFechaEstLlegada());

            hConductor.setHojaRuta(this.hojaRuta);
            hConductor.setTurno(this.hojaRuta.getConductores().size() + 1);




        } else {
            FacesUtil.adicionarMensajeError("El Conductor no esta registrado en la nomina de conductores.");
        }


    }


    public void sincronizarHojaRuta(){


        WSServiciosHR mtc = new WSServiciosHR();
        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();


        com.titanic.ventapasajes.ws.Seguridad seguridad = new com.titanic.ventapasajes.ws.Seguridad();
        seguridad.setRuc("20301040301");
        seguridad.setUsuario("059956");
        seguridad.setClave("123456");
        seguridad.setPartida("000396PNR");

        com.titanic.ventapasajes.ws.HojaRuta oHojaRuta = new com.titanic.ventapasajes.ws.HojaRuta();
        oHojaRuta.setSeguridad(seguridad);
        oHojaRuta.setNroRuta(programacionSeleccionada.getRuta().getCodeRuta());
        oHojaRuta.setNroPlaca(programacionSeleccionada.getBus().getPlaca());
        oHojaRuta.setTerSalida(Integer.parseInt(programacionSeleccionada.getRuta().getOrigen().getCodeTerminal()));
        oHojaRuta.setTerLlegada(Integer.parseInt(programacionSeleccionada.getRuta().getDestino().getCodeTerminal()));


        String DATE_FORMAT_MTC= "dd/MM/yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_MTC);
        String strFechaSalida = sdf.format(programacionSeleccionada.getFechaSalida());
        String strFecEstLlegada = sdf.format(programacionSeleccionada.getFechaEstLlegada());
        oHojaRuta.setFecSalida(strFechaSalida);
        oHojaRuta.setFecEstLlegada(strFecEstLlegada);

        String TIME_FORMAT_MTC="HH:mm:ss";

        SimpleDateFormat localDateFormat = new SimpleDateFormat(TIME_FORMAT_MTC);
        String strHoraSalida = localDateFormat.format(programacionSeleccionada.getFechaSalida());
        String strHoraLlegada = localDateFormat.format(programacionSeleccionada.getFechaEstLlegada());
        oHojaRuta.setHorSalida(strHoraSalida.substring(0, 5));
        oHojaRuta.setHorEstLlegada(strHoraLlegada.substring(0, 5));


        ArrayOfHConductor conductores = oHojaRuta.getConductores();
        if (conductores == null) {
            conductores = new ArrayOfHConductor();
            oHojaRuta.setConductores(conductores);
        }


        List<com.titanic.ventapasajes.ws.HConductor> hConductores = conductores.getHConductor();


        for(HConductor hConductor: this.hojaRuta.getConductores()){

            com.titanic.ventapasajes.ws.HConductor hConductorWS= new com.titanic.ventapasajes.ws.HConductor();

            hConductorWS.setTpoDocumento(hConductor.getTipoDocumento().getDescripcion());
            hConductorWS.setNroDocumento(hConductor.getNroDocumento());

            hConductorWS.setFecInicio(sdf.format(hConductor.getFechaInicio()));
            hConductorWS.setFecTermino(sdf.format(hConductor.getFechaTermino()));


            localDateFormat = new SimpleDateFormat(TIME_FORMAT_MTC);
            strHoraSalida = localDateFormat.format(hConductor.getFechaInicio());
            strHoraLlegada = localDateFormat.format(hConductor.getFechaTermino());
            hConductorWS.setHorInicio(strHoraSalida.substring(0, 5));
            hConductorWS.setHorTermino(strHoraLlegada.substring(0, 5));



            hConductores.add(hConductorWS);
        }






//        ArrayOfHTripulante tripulantes = oHojaRuta.getTripulantes();
//        if(tripulantes==null) {
//            tripulantes = new ArrayOfHTripulante();
//            oHojaRuta.tripulantes = tripulantes;
//        }
//
//        List<HTripulante> hTripulantes = tripulantes.getHTripulante();
//
//
//        HTripulante hTripulante1 = new HTripulante();
//        hTripulante1.setTpoDocumento("L.E.");
//        hTripulante1.setNroDocumento("25725353");
//        hTripulantes.add(hTripulante1);


//        Tripulante oTripulante = new Tripulante();
//        oTripulante.setTpoDocumento("L.E.");
//        oTripulante.setNroDocumento("80317970");
//        oTripulante.setSeguridad(seguridad);
//        oTripulante.setNombre("Elmer ");
//        oTripulante.setApellido("Flores");
//        oTripulante.setSexo("Masculino");
//        oTripulante.setFecNac("06/11/1978");
//        ResultTripulante resultTripulante = mtcClient.setTripulante(oTripulante);
//
//
//        assertNull(resultTripulante.getErrores());
//        assertTrue(resultTripulante.isReturn());


        ResultHojaRuta resultHojaRuta = mtcClient.setHojaRuta(oHojaRuta);
        System.out.println("Código Hoja de Ruta = " + resultHojaRuta.getCode());

        String strErrores  = "";
        if(resultHojaRuta.getErrores().getErrores().size()>0){
            for(Errores errores: resultHojaRuta.getErrores().getErrores()){
                strErrores += errores.getCode() + " " + errores.getInfo();
            }
            FacesUtil.adicionarMensajeError("Error al registrar hoja de ruta: " + strErrores);
        }
        else{

            try {
                this.hojaRuta.setCodigoHojaRuta(resultHojaRuta.getCode());
                this.hojaRuta = hojaRutaRepositorio.adicionarHojaRuta(this.hojaRuta);
            } catch (Exception ex) {
                FacesUtil.adicionarMensajeError("Error al sincronizar hoja de ruta.");
            }
            FacesUtil.adicionarMensajeInfo("La hoja de ruta se sincronizó correctamente con el código " + resultHojaRuta.getCode());

        }



    }


    public void limpiarConductor() {
        this.hConductor = new HConductor();
    }

    public void agregarConductor() {

        this.hojaRuta.getConductores().add(hConductor);
        this.hConductor = new HConductor();

    }

    public void agregarTripulante() {
        this.tripulante.setHojaRuta(this.hojaRuta);
        this.hojaRuta.getTripulantes().add(tripulante);
        this.tripulante = new Tripulante();
    }

    public void limpiarTripulante() {
        this.tripulante = new Tripulante();
    }


    public HojaRuta getHojaRuta() {
        return hojaRuta;
    }

    public void setHojaRuta(HojaRuta hojaRuta) {
        this.hojaRuta = hojaRuta;
    }

    public Programacion getProgramacionSeleccionada() {
        return programacionSeleccionada;
    }

    public void setProgramacionSeleccionada(Programacion programacionSeleccionada) {
        this.programacionSeleccionada = programacionSeleccionada;
    }

    public HConductor gethConductor() {
        return hConductor;
    }

    public void sethConductor(HConductor hConductor) {
        this.hConductor = hConductor;
    }

    public Sexo[] getSexo() {
        return Sexo.values();
    }


    public TipoDocumento[] getTiposDocumento() {
        return TipoDocumento.values();
    }

    public Tripulante getTripulante() {
        return tripulante;
    }

    public void setTripulante(Tripulante tripulante) {
        this.tripulante = tripulante;
    }

    public boolean isEditando() {
        return this.hojaRuta.getIdeHojaRuta() != null;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Programacion Seleccionada", ((Programacion) event.getObject()).getIdeProgramacion().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Programacion Liberada", ((Programacion) event.getObject()).getIdeProgramacion().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Conductor Editada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Conductor Eliminado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.hojaRuta.getConductores().remove(event.getObject());
    }


    public void onEditTripulante(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Tripulante Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancelTripulante(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Tripulante Eliminado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.hojaRuta.getTripulantes().remove(event.getObject());
    }

}
