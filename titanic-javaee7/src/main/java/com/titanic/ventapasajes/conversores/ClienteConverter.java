package com.titanic.ventapasajes.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.repositorio.ClienteRepositorio;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter{

	private ClienteRepositorio clienteRepositorio;

	public ClienteConverter() {
		this.clienteRepositorio = (ClienteRepositorio) CDIServiceLocator.getBean(ClienteRepositorio.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.clienteRepositorio.buscarClienteporId(new Long(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			Cliente cliente = (Cliente) value;
			return cliente.getIdeCliente() == null ? null :  cliente.getIdeCliente().toString();
		}
		
		return "";
	}
	
}
