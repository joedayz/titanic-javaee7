package com.titanic.ventapasajes.repositorio.filtros;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
public class ProgramacionFiltros implements Serializable {


    private static final long serialVersionUID = 1L;

    private Date fechaProgramacion;

    public Date getFechaProgramacion() {
        return fechaProgramacion;
    }

    public void setFechaProgramacion(Date fechaProgramacion) {
        this.fechaProgramacion = fechaProgramacion;
    }
}
