package com.titanic.ventapasajes.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.titanic.ventapasajes.modelo.Recorrido;
import com.titanic.ventapasajes.repositorio.RecorridoRepositorio;
import com.titanic.ventapasajes.util.jpa.Transaccion;

/**
 * Created by josediaz on 7/25/14.
 */
public class RegistroRecorridoService implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private RecorridoRepositorio recorridoRepositorio;

    @Transaccion
    public Recorrido registrarRecorrido(Recorrido recorrido){

        Recorrido recorridoExistente = recorridoRepositorio.obtenerRecorridoPorRuta(recorrido.getRuta());

        if(recorridoExistente!=null && !recorridoExistente.equals(recorrido)){
            throw new NegocioExcepciones("Ya existe un recorrido con esa Ruta, verificar");
        }

        return recorridoRepositorio.adicionarRecorrido(recorrido);
    }
}
