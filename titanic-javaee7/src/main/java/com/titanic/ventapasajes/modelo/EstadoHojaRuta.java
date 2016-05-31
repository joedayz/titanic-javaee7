package com.titanic.ventapasajes.modelo;

/**
 * Created by josediaz on 1/11/16.
 */
public enum EstadoHojaRuta {

    NUEVA("NUEVA"), SINCRONIZADA("REGISTRADA"), PAGADO("FINALIZADA"), NO_DISPONIBLE("ANULADA");



    private String descripcion;

    EstadoHojaRuta(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
