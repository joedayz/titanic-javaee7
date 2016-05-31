package com.titanic.ventapasajes.repositorio.filtros;

import java.io.Serializable;

/**
 * Created by josediaz on 7/20/14.
 */
public class BusFiltros implements Serializable{


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String placa;
    private String nombre;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
