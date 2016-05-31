package com.titanic.ventapasajes.service;

public class NegocioExcepciones extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NegocioExcepciones(String mensaje){
		super(mensaje);
	}
	
}
