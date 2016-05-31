package com.titanic.ventapasajes.modelo;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
public enum TipoProgramacion {

    VENDIDO("Vendido"), ABIERTO("Abierto"), CANCELADO("Cancelado");

    private String descripcion;

    TipoProgramacion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
