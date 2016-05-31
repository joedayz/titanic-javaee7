package com.titanic.ventapasajes.modelo;

public enum TipoDestino {

	INTERMEDIO ("Intermedio"), TERMINAL ("Terminal");

    private String descripcion;

    TipoDestino(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
