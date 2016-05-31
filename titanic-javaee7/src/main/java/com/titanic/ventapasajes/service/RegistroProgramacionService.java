package com.titanic.ventapasajes.service;

/**
 * Created by josediaz on 12/26/15.
 */

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.repositorio.ProgramacionRepositorio;
import com.titanic.ventapasajes.util.jpa.Transaccion;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
public class RegistroProgramacionService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private ProgramacionRepositorio programacionRepositorio;

    @Transaccion
    public Programacion registrarProgramacion(Programacion programacion){
        return programacionRepositorio.adicionarProgramacion(programacion);
    }

    public Programacion obtenerProgramacion(Long id){
        return programacionRepositorio.obtenerProgramacion(id);
    }
}
