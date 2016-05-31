package com.titanic.ventapasajes.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.repositorio.TerminalRepositorio;

@Named
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject private FacesContext facesContext;
	@Inject private HttpServletRequest request;
	@Inject private HttpServletResponse response;

	@Inject
	private TerminalRepositorio terminalRepositorio;

	private String email;
	private String localVenta;
	
	public void preRender(){



		if("true".equals(request.getParameter("invalid"))){
			FacesUtil.adicionarMensajeError("Email y/o Contraseña no es correcta.");
		}
	}
	
	public void login() throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(request, response);
		
		facesContext.responseComplete();
	}

	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocalVenta() {
		return localVenta;
	}

	public void setLocalVenta(String localVenta) {
		this.localVenta = localVenta;
	}

	public List<Terminal> getTerminales(){

		return terminalRepositorio.listarTerminales();
	}
}
