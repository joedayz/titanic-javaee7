package com.titanic.ventapasajes.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.Usuario;
import com.titanic.ventapasajes.repositorio.UsuarioRepositorio;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter{

	private UsuarioRepositorio usuarioRepositorio;

	public UsuarioConverter() {
		this.usuarioRepositorio = (UsuarioRepositorio) CDIServiceLocator.getBean(UsuarioRepositorio.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.usuarioRepositorio.buscarUsuarioporId(new Long(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			Usuario Usuario = (Usuario) value;
			return Usuario.getIdeUsuario() == null ? null :  Usuario.getIdeUsuario().toString();
		}
		return "";
	}
	
}
