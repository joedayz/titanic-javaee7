package com.titanic.ventapasajes.repositorio.filtros;

import java.io.Serializable;

/**
 * Created by josediaz on 7/25/14.
 */
public class RecorridoFiltros implements Serializable{


    private static final long serialVersionUID = 1L;

    private String origen;
    private String destino;
    private String ruta;

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
