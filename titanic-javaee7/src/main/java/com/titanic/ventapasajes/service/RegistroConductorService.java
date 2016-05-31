package com.titanic.ventapasajes.service;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.modelo.Conductor;
import com.titanic.ventapasajes.repositorio.ClienteRepositorio;
import com.titanic.ventapasajes.repositorio.ConductorRepositorio;
import com.titanic.ventapasajes.util.jpa.Transaccion;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by josediaz on 12/18/15.
 */
public class RegistroConductorService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private ConductorRepositorio conductorRepositorio;

    @Transaccion
    public Conductor registrarConductor(Conductor conductor){

        Conductor conductorExistente = conductorRepositorio.obtenerConductorPorNumeroDocumento(conductor.getNumeroDocumento());

        if(conductorExistente!=null && !conductorExistente.equals(conductor)){
            throw new NegocioExcepciones("Ya existe un conductor con ese Numero de Documento, verificar");
        }

        return conductorRepositorio.adicionarConductor(conductor);
    }


    public List<Conductor> buscarTodos(){
        return conductorRepositorio.buscarTodos();
    }

    public Conductor obtenerConductorPorNumeroDocumento(String numeroDocumento){
        return conductorRepositorio.obtenerConductorPorNumeroDocumento(numeroDocumento);
    }

    @Transaccion
    public Conductor adicionarConductor(Conductor conductor) {

        Conductor conductorExistente = conductorRepositorio.obtenerConductorPorNumeroDocumento(conductor.getNumeroDocumento());
        if(conductorExistente!=null) {
            conductorExistente.setNombreConductor(conductor.getNombreConductor());
            conductorExistente.setFechaNacimiento(conductor.getFechaNacimiento());
            conductorExistente.setNumeroLicencia(conductor.getNumeroLicencia());
            conductorExistente.setFechaExpedicion(conductor.getFechaExpedicion());
            conductorExistente.setFechaRevalidacion(conductor.getFechaRevalidacion());
            conductorExistente.setEstado(conductor.isEstado());
            conductorExistente.setEntidad(conductor.getEntidad());
            conductorExistente.setLocalidad(conductor.getLocalidad());
            conductorExistente.setNumeroCertificado(conductor.getNumeroCertificado());
            conductorExistente.setFechaCaducidad(conductor.getFechaCaducidad());
            conductorExistente.setEstadoCapacitacion(conductor.isEstadoCapacitacion());

        }else{
            conductorExistente = conductor;
        }

        return conductorRepositorio.adicionarConductor(conductorExistente);
    }
}
