package com.titanic.ventapasajes.repositorio.filtros;

import java.io.Serializable;

/**
 * Created by josediaz on 7/24/14.
 */
public class TerminalFiltros implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String nombre;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
