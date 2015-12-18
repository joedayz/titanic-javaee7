package com.titanic.ventapasajes.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.service.RegistroTerminalService;
import com.titanic.ventapasajes.jsf.FacesUtil;

/**
 * Created by josediaz on 7/24/14.
 */
@Named
@ViewScoped
public class RegistroTerminalBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private RegistroTerminalService terminalService;

    private Terminal terminal;

    public RegistroTerminalBean(){
        terminal = new Terminal();
    }

    public void inicializar(){

        if (this.terminal == null) {
            this.terminal = new Terminal();
        }
    }


    public Terminal getTerminal() {
        return terminal;
    }




    public void registrarTerminal(){
        this.terminal = terminalService.registrarTerminal(this.terminal);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("El terminal se registro correctamente");
    }

    private void limpiarFormulario(){
        terminal = new Terminal();

    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;


    }

    public boolean isEditando(){
        return this.terminal.getIdeTerminal() !=null;
    }



}
