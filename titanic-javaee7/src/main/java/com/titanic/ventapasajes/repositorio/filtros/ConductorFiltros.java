package com.titanic.ventapasajes.repositorio.filtros;

import java.io.Serializable;

/**
 * Created by josediaz on 12/18/15.
 */
public class ConductorFiltros  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String numeroDocumento;
    private String nombre;


    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}
