package com.titanic.ventapasajes.repositorio.filtros;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by josediaz on 1/11/16.
 */
public class HojaRutaFiltros implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date fechaDesde;
    private Date fechaHasta;


    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
}
