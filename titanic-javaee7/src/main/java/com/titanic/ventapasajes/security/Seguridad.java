package com.titanic.ventapasajes.security;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@Named
@RequestScoped
public class Seguridad {

	@Inject
	private ExternalContext externalContext;

	public String getNombreUsuario(){
		String nombreUsuario = null;
		UsuarioSistema usuarioLogeado = getUsuarioLogeado();

		if(usuarioLogeado != null){
			nombreUsuario = usuarioLogeado.getUsuario().getNombreUsuario();
		}
		return nombreUsuario;
	}

	public String getLocalVenta(){
		final CustomWebAuthenticationDetails cwad = (CustomWebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		return cwad.getyourParameter();
	}
	
	
	@Produces @UsuarioLogeado
	public UsuarioSistema getUsuarioLogeado() {
		
		UsuarioSistema usuario = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		if(auth!=null && auth.getPrincipal()!=null){
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
	

}
