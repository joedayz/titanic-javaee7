package com.titanic.ventapasajes.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.titanic.ventapasajes.modelo.Usuario;
import com.titanic.ventapasajes.repositorio.UsuarioRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.ClienteFiltros;
import com.titanic.ventapasajes.repositorio.filtros.UsuarioFiltros;
import com.titanic.ventapasajes.jsf.FacesUtil;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;




	@Inject
	private UsuarioRepositorio usuarioRepositorio;

	private List<Usuario> usuariosFiltrados;
	private UsuarioFiltros filtros;

	private Usuario usuarioSeleccionado;


	@PostConstruct
	public void init(){
		filtros = new UsuarioFiltros();
		buscarUsuarioFiltros();
	}


	public void buscarUsuarioFiltros() {
		usuariosFiltrados = usuarioRepositorio.listarUsuariosFiltrados(filtros);

	}

	public void eliminarUsuario() {

		usuarioRepositorio.removerUsuario(usuarioSeleccionado);

		usuariosFiltrados.remove(usuarioSeleccionado);
		FacesUtil.adicionarMensajeInfo("Usuario " + usuarioSeleccionado.getNombreUsuario() + " eliminado.");
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public UsuarioFiltros getFiltros() {
		return filtros;
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
}
