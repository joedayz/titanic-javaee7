package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.modelo.Conductor;
import com.titanic.ventapasajes.modelo.Sexo;
import com.titanic.ventapasajes.service.RegistroClienteService;
import com.titanic.ventapasajes.service.RegistroConductorService;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by josediaz on 12/18/15.
 */


@Named
@ViewScoped
public class RegistroConductorBean implements Serializable{



    private static final long serialVersionUID = 1L;

    @Inject
    private RegistroConductorService registroConductorService;

    private Conductor conductor;


    public void inicializar(){


        if (this.conductor == null) {
            this.conductor = new Conductor();
        }
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public void registrarConductor(){
        this.conductor = registroConductorService.registrarConductor(this.conductor);
        FacesUtil.adicionarMensajeInfo("El conductor se registro correctamente");
    }

    public boolean isEditando(){
        return this.conductor.getIdeConductor() !=null;
    }

    public Sexo[] getSexo() {
        return Sexo.values();
    }
}
