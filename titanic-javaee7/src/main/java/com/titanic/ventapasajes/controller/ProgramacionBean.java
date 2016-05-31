package com.titanic.ventapasajes.controller;

/**
 * Created by josediaz on 12/26/15.
 */
import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.repositorio.ProgramacionRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.ProgramacionFiltros;
import com.titanic.ventapasajes.repositorio.filtros.UsuarioFiltros;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@Named
@ViewScoped
public class ProgramacionBean  implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1592771145764176840L;


    private List<Programacion> programacionesFiltradas;
    private ProgramacionFiltros filtros;

    private Programacion programacionSeleccionada;

    @Inject
    private ProgramacionRepositorio programacionRepositorio;


    @PostConstruct
    public void init(){
        filtros = new ProgramacionFiltros();
        buscarProgramacionesFiltradas();
    }



    public void buscarProgramacionesFiltradas(){
        programacionesFiltradas = programacionRepositorio.listarProgramacionesFiltradas(filtros);
    }

    public void eliminarProgramacion(){
        programacionRepositorio.removerProgramacion(programacionSeleccionada);
        programacionesFiltradas.remove(programacionSeleccionada);
        //FacesUtil.adicionarMensajeInfo("Programacion " + programacionSeleccionada.getHoraSalida()
        //        + " " + programacionSeleccionada.getHoraLlegada()+ " eliminada.");
    }


    public List<Programacion> getProgramacionesFiltradas() {
        return programacionesFiltradas;
    }

    public void setProgramacionesFiltradas(List<Programacion> programacionesFiltradas) {
        this.programacionesFiltradas = programacionesFiltradas;
    }


    public ProgramacionFiltros getFiltros() {
        return filtros;
    }

    public void setFiltros(ProgramacionFiltros filtros) {
        this.filtros = filtros;
    }

    public Programacion getProgramacionSeleccionada() {
        return programacionSeleccionada;
    }

    public void setProgramacionSeleccionada(Programacion programacionSeleccionada) {
        this.programacionSeleccionada = programacionSeleccionada;
    }
}