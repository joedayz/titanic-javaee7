package com.titanic.ventapasajes.controller;

import java.io.Serializable;

import java.util.List;
import java.util.StringTokenizer;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.service.RegistroTerminalService;
import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.util.cdi.InjectedConfiguration;
import com.titanic.ventapasajes.ws.*;


/**
 * Created by josediaz on 7/24/14.
 */
@Named
@ViewScoped
public class RegistroTerminalBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    @InjectedConfiguration(key="ruc")
    String ruc;

    @Inject
    @InjectedConfiguration(key="usuario")
    String usuario;

    @Inject
    @InjectedConfiguration(key="clave")
    String clave;

    @Inject
    @InjectedConfiguration(key="partida")
    String partida;


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

        StringTokenizer tokens=new StringTokenizer(terminal.getNombreTerminal(), "|");

        this.terminal.setCodeTerminal(tokens.nextToken());
        this.terminal.setNombreTerminal(tokens.nextToken());


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


    public List<com.titanic.ventapasajes.ws.Terminal> getTerminales(){



        WSServiciosHR mtc = new WSServiciosHR();
        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();



        Seguridad seguridad = new Seguridad();
        seguridad.setRuc(ruc);
        seguridad.setUsuario(usuario);
        seguridad.setClave(clave);
        seguridad.setPartida(partida);


        Parametro oParametro = new Parametro();
        oParametro.setSeguridad(seguridad);

        ResultParametro resultado = mtcClient.getParametro(oParametro);
        ArrayOfTerminal arrayOfTerminal = resultado.getTerminales();
        List<com.titanic.ventapasajes.ws.Terminal> terminales = arrayOfTerminal.getTerminal();

        return terminales;
    }

}
