package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.repositorio.TerminalRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.TerminalFiltros;
import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.repositorio.filtros.UsuarioFiltros;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by josediaz on 7/24/14.
 */

@Named
@ViewScoped
public class TerminalBean implements Serializable{



    /**
     *
     */
    private static final long serialVersionUID = 1592771145764176840L;

    @Inject
    private TerminalRepositorio terminalRepositorio;



    private List<Terminal> terminalesFiltrados;
    private TerminalFiltros filtros;

    private Terminal terminalSeleccionado;



    @PostConstruct
    public void init(){
        filtros = new TerminalFiltros();
        buscarTerminalesFiltros();
    }

    public void buscarTerminalesFiltros(){
        terminalesFiltrados = terminalRepositorio.listarTerminalesFiltrados(filtros);
    }

    public void eliminarTerminal(){

        terminalRepositorio.removerTerminal(terminalSeleccionado);
        terminalesFiltrados.remove(terminalSeleccionado);
        FacesUtil.adicionarMensajeInfo("Terminal " + terminalSeleccionado.getNombreTerminal() + " eliminado.");
    }

    public Terminal getTerminalSeleccionado() {
        return terminalSeleccionado;
    }

    public void setTerminalSeleccionado(Terminal terminalSeleccionado) {
        this.terminalSeleccionado = terminalSeleccionado;
    }

    public TerminalFiltros getFiltros() {
        return filtros;
    }

    public List<Terminal> getTerminalesFiltrados() {
        return terminalesFiltrados;
    }
}
