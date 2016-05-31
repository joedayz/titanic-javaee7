package com.titanic.ventapasajes.controller;

/**
 * Created by josediaz on 12/27/15.
 */

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.repositorio.ProgramacionRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.ProgramacionFiltros;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Named
@ViewScoped
public class SeleccionarBusBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull
    private Date fechaVenta = new Date();


    @Inject
    private ProgramacionRepositorio programacionRepositorio;




    private List<Programacion> programaciones;



    public void inicializar() {
        ProgramacionFiltros filtros = new ProgramacionFiltros();
        filtros.setFechaProgramacion(fechaVenta);
        this.programaciones = programacionRepositorio.listarProgramacionesFiltradas(filtros);
    }



    public void onFechaSeleccionada(SelectEvent event) {
        Date nuevaFecha = (Date) event.getObject();

        this.setFechaVenta(nuevaFecha);


        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Modificada", "Fecha Venta:" + fechaVenta);

        FacesContext.getCurrentInstance().addMessage(null, message);
    }



    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public List<Programacion> getProgramaciones() {
        return programaciones;
    }

    public void setProgramaciones(List<Programacion> programaciones) {
        this.programaciones = programaciones;
    }
}