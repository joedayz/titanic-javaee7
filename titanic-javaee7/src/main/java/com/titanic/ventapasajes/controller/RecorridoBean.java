package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.repositorio.RecorridoRepositorio;
import com.titanic.ventapasajes.repositorio.TerminalRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.ClienteFiltros;
import com.titanic.ventapasajes.repositorio.filtros.RecorridoFiltros;
import com.titanic.ventapasajes.jsf.FacesUtil;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josediaz on 7/25/14.
 */

@Named
@ViewScoped
public class RecorridoBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private RecorridoRepositorio recorridoRepositorio;

    @Inject
    private TerminalRepositorio terminalRepositorio;

    private List<Terminal> terminales = new ArrayList<>();

    private List<Terminal> terminalesDestino = new ArrayList<>();

    public List<Terminal> getTerminalesDestino() {
        return terminalesDestino;
    }

    public void setTerminalesDestino(List<Terminal> terminalesDestino) {
        this.terminalesDestino = terminalesDestino;
    }

    public List<Terminal> getTerminales() {
        return terminales;
    }

    public void setTerminales(List<Terminal> terminales) {
        this.terminales = terminales;
    }

    private List<Recorrido> recorridosFiltrados;
    private RecorridoFiltros filtros;

    private Recorrido recorridoSeleccionado;


    @PostConstruct
    public void init() {

        terminales = terminalRepositorio.listarTerminales();
        terminalesDestino = terminalRepositorio.listarTerminales();

        filtros = new RecorridoFiltros();
        buscarRecorridosFiltros();


    }


    public void buscarRecorridosFiltros() {
        recorridosFiltrados = recorridoRepositorio.listarRecorridosFiltrados(filtros);
    }

    public void selectRecorridoFromDialog(Recorrido recorrido) {
        RequestContext.getCurrentInstance().closeDialog(recorrido);
    }

    public void eliminarRecorrido() {
        recorridoRepositorio.removerRecorrido(recorridoSeleccionado);
        recorridosFiltrados.remove(recorridoSeleccionado);
        FacesUtil.adicionarMensajeInfo("Recorrido " + recorridoSeleccionado.getRuta() + " eliminado.");
    }

    public Recorrido getRecorridoSeleccionado() {
        return recorridoSeleccionado;
    }

    public void setRecorridoSeleccionado(Recorrido recorridoSeleccionado) {
        this.recorridoSeleccionado = recorridoSeleccionado;
    }

    public RecorridoFiltros getFiltros() {
        return filtros;
    }

    public List<Recorrido> getRecorridosFiltrados() {
        return recorridosFiltrados;
    }
}
