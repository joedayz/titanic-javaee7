package com.titanic.ventapasajes.modelo;

/**
 * Created by josediaz on 12/11/15.
 */
public enum TipoAsiento {


    COMUN("Comun"), SEMI_CAMA ("SemiCama"), CAMA ("Cama"), SUIT ("Suit"), NO_APLICA("No Aplica");


    private String descripcion;

    TipoAsiento(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
