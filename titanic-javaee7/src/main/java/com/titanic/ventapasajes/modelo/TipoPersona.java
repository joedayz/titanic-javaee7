package com.titanic.ventapasajes.modelo;

public enum TipoPersona {

	NATURAL("Natural"), JURIDICA("Juridica");
	
	private String descripcion;
	
	TipoPersona(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
}
