package com.titanic.ventapasajes.modelo;

/**
 * Created by josediaz on 12/11/15.
 */
public enum EstadoAsiento {

    LIBRE("LIBRE"), RESERVADO("RESERVADO"), PAGADO("PAGADO"), NO_DISPONIBLE("NO DISPONIBLE");



    private String descripcion;

    EstadoAsiento(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
