package com.titanic.ventapasajes.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.repositorio.ClienteRepositorio;
import com.titanic.ventapasajes.util.jpa.Transaccion;

public class RegistroClienteService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteRepositorio clienteRepositorio;
	
	@Transaccion
	public Cliente registrarCliente(Cliente cliente){
		
		Cliente clienteExistente = clienteRepositorio.obtenerClientePorNumeroDocumento(cliente.getNumeroDocumento());
		
		if(clienteExistente!=null && !clienteExistente.equals(cliente)){
			throw new NegocioExcepciones("Ya existe un cliente con ese Numero de Documento, verificar"); 
		}
		
		return clienteRepositorio.adicionarCliente(cliente);
	}


    public List<Cliente> buscarTodos(){
        return clienteRepositorio.buscarTodos();
    }

    public Cliente obtenerClientePorNumeroDocumento(String numeroDocumento){
        return clienteRepositorio.obtenerClientePorNumeroDocumento(numeroDocumento);
    }

    @Transaccion
    public Cliente adicionarCliente(Cliente cliente) {

        Cliente clienteExistente = clienteRepositorio.obtenerClientePorNumeroDocumento(cliente.getNumeroDocumento());
        if(clienteExistente!=null) {
            clienteExistente.setNombreCliente(cliente.getNombreCliente());
            clienteExistente.setEdad(cliente.getEdad());
            clienteExistente.setSexo(cliente.getSexo());
        }else{
            clienteExistente = cliente;
        }

        return clienteRepositorio.adicionarCliente(clienteExistente);
    }
}
