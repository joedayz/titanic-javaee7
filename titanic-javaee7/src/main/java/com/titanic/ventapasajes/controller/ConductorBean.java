package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.Conductor;
import com.titanic.ventapasajes.repositorio.ConductorRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.ConductorFiltros;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by josediaz on 12/18/15.
 */
@Named
@ViewScoped
public class ConductorBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private ConductorRepositorio conductorRepositorio;

    @PostConstruct
    public void init(){
        filtros = new ConductorFiltros();
        buscarConductoresFiltrados();
    }

    private List<Conductor> conductoresFiltrados;
    private ConductorFiltros filtros;

    private Conductor conductorSeleccionado;


    public void buscarConductoresFiltrados(){
        conductoresFiltrados = conductorRepositorio.listarConductoresFiltrados(filtros);
    }


    public void eliminarConductor(){
        conductorRepositorio.removerConductor(conductorSeleccionado);
        conductoresFiltrados.remove(conductorSeleccionado);
        FacesUtil.adicionarMensajeInfo("Conductor "+conductorSeleccionado.getNombreConductor() +" eliminado.");
    }



    public List<Conductor> getConductoresFiltrados() {
        return conductoresFiltrados;
    }

    public void setConductoresFiltrados(List<Conductor> conductoresFiltrados) {
        this.conductoresFiltrados = conductoresFiltrados;
    }

    public ConductorFiltros getFiltros() {
        return filtros;
    }

    public void setFiltros(ConductorFiltros filtros) {
        this.filtros = filtros;
    }

    public Conductor getConductorSeleccionado() {
        return conductorSeleccionado;
    }

    public void setConductorSeleccionado(Conductor conductorSeleccionado) {
        this.conductorSeleccionado = conductorSeleccionado;
    }
}
