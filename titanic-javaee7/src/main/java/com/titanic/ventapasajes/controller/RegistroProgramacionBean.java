package com.titanic.ventapasajes.controller;

/**
 * Created by josediaz on 12/26/15.
 */

import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.repositorio.BusRepositorio;
import com.titanic.ventapasajes.service.RegistroProgramacionService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class RegistroProgramacionBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private RegistroProgramacionService programacionService;

    @Inject
    private BusRepositorio busRepositorio;

    private Programacion programacion;


    public void inicializar(){

        if (this.programacion == null) {
            this.programacion = new Programacion();
            programacion.setTipoProgramacion(TipoProgramacion.ABIERTO);
        }
    }



    public void registrarProgramacion(){

        if(programacion.getRuta() ==null || programacion.getBus() == null){

            FacesUtil.adicionarMensajeError("Ud. debe ingresar Ruta y Bus para este viaje");
            return;
        }

        this.programacion = programacionService.registrarProgramacion(this.programacion);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("La programación se registro correctamente");
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }



    private void limpiarFormulario(){
        programacion = new Programacion();

    }

    public boolean isEditando(){
        return this.programacion.getIdeProgramacion() !=null;
    }

    public void seleccionarBus() {
        RequestContext.getCurrentInstance().openDialog("seleccionarBus");
    }


    public void seleccionarRuta() {
        RequestContext.getCurrentInstance().openDialog("seleccionarRuta");
    }



    public TipoProgramacion[] getTipoProgramacion() {
        return TipoProgramacion.values();
    }





    public void onRutaSeleccionada(SelectEvent event) {
        Recorrido recorrido = (Recorrido) event.getObject();

        this.programacion.setRuta(recorrido);


        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ruta Seleccionada", "Id:" + recorrido.getRuta());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void onBusSeleccionado(SelectEvent event) {
        Bus busSeleccionado = (Bus) event.getObject();

        this.programacion.setBus(busRepositorio.getFilasWithBusById(busSeleccionado.getIdeBus()));


        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bus Seleccionado", "Id:" + busSeleccionado.getDescripcionBus());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}