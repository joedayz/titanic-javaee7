package com.titanic.ventapasajes.modelo;

public enum TipoDocumento {

	DNI("L.E."), CARNET_DE_EXTRANJERIA("C.E."), CARNET_DE_POLICIA("C.P."),
                    PASAPORTE("P.S."), PARTIDA_DE_NACIMIENTO("P.N.");

    private String descripcion;

    TipoDocumento(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
