package com.titanic.ventapasajes.modelo;

public enum TipoDocumento {

	DNI("DNI"), RUC("RUC"), PASAPORTE("PASAPORTE"), LICENCIA_CONDUCIR("LICENCIA CONDUCIR");

    private String descripcion;

    TipoDocumento(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
