package com.titanic.ventapasajes.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.titanic.ventapasajes.modelo.Usuario;
import com.titanic.ventapasajes.repositorio.UsuarioRepositorio;
import com.titanic.ventapasajes.util.jpa.Transaccion;

public class RegistroUsuarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepositorio usuarioRepositorio;
	
	@Transaccion
	public Usuario registrarUsuario(Usuario usuario){
		
		Usuario usuarioExistente = usuarioRepositorio.buscarUsuarioporEmail(usuario.getEmail());
		
		if(usuarioExistente!=null && !usuarioExistente.equals(usuario)){
			throw new NegocioExcepciones("Ya existe un usuario con ese Email, verificar"); 
		}
		
		return usuarioRepositorio.adicionarUsuario(usuario);
	}

}
