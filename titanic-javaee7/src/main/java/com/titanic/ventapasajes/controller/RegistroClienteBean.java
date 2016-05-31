package com.titanic.ventapasajes.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.service.RegistroClienteService;
import com.titanic.ventapasajes.jsf.FacesUtil;


@Named
@ViewScoped
public class RegistroClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RegistroClienteService clienteService;
	
	private Cliente cliente;

	public void inicializar(){


		if (this.cliente == null) {
			this.cliente = new Cliente();
		}
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public TipoPersona[] getTiposPersona() {
		return TipoPersona.values();
	}

    public TipoDocumento[] getTiposDocumento() {
        return TipoDocumento.values();
    }


    public Sexo[] getSexo() {
        return Sexo.values();
    }
	
	public void registrarCliente(){
		this.cliente = clienteService.registrarCliente(this.cliente);
		FacesUtil.adicionarMensajeInfo("El cliente se registro correctamente");
	}


	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		 
		
	}
	
	public boolean isEditando(){
		return this.cliente.getIdeCliente() !=null;
	}
		
	
}
