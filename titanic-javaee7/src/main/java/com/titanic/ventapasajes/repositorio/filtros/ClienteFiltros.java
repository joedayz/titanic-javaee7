package com.titanic.ventapasajes.repositorio.filtros;

import java.io.Serializable;

public class ClienteFiltros implements Serializable{

	private static final long serialVersionUID = 1L;

	private String numeroDocumento;
	private String nombre;
	private String email;
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	
}