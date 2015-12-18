package com.titanic.ventapasajes.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.titanic.ventapasajes.modelo.Bus;
import com.titanic.ventapasajes.repositorio.BusRepositorio;
import com.titanic.ventapasajes.util.jpa.Transaccion;

/**
 * Created by josediaz on 7/20/14.
 */
public class RegistroBusService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private BusRepositorio busRepositorio;

    @Transaccion
    public Bus registrarBus(Bus bus){

        Bus busExistente = busRepositorio.buscarUsuarioporPlaca(bus.getPlaca());

        if(busExistente!=null && !busExistente.equals(bus)){
            throw new NegocioExcepciones("Ya existe un bus con esa Placa, verificar");
        }



        return busRepositorio.adicionarBus(bus);
    }

}