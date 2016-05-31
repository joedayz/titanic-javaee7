package com.titanic.ventapasajes.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.repositorio.ClienteRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.BusFiltros;
import com.titanic.ventapasajes.repositorio.filtros.ClienteFiltros;
import com.titanic.ventapasajes.jsf.FacesUtil;


@Named
@ViewScoped
public class ClienteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1592771145764176840L;

	@Inject
	private ClienteRepositorio clienteRepositorio;




	@PostConstruct
	public void init(){
		filtros = new ClienteFiltros();
		buscarClientesFiltros();
	}

	private List<Cliente> clientesFiltrados;
	private ClienteFiltros filtros;
	
	private Cliente clienteSeleccionado;
	


	
	public void buscarClientesFiltros(){
		clientesFiltrados = clienteRepositorio.listarClientesFiltrados(filtros);
	}

	public void eliminarCliente(){
		clienteRepositorio.removerCliente(clienteSeleccionado);
		clientesFiltrados.remove(clienteSeleccionado);
		FacesUtil.adicionarMensajeInfo("Cliente "+clienteSeleccionado.getNombreCliente() +" eliminado.");
	}	
	
	public Cliente getClienteSeleccionado() {
		return clienteSeleccionado;
	}

	public void setClienteSeleccionado(Cliente clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}
	
	public ClienteFiltros getFiltros() {
		return filtros;
	}
	
	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}
}
