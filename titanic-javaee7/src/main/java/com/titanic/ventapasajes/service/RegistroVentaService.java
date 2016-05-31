package com.titanic.ventapasajes.service;

/**
 * Created by josediaz on 12/27/15.
 */

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.modelo.Venta;
import com.titanic.ventapasajes.repositorio.VentaRepositorio;
import com.titanic.ventapasajes.util.jpa.Transaccion;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by josediaz on 7/28/14.
 */
public class RegistroVentaService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private VentaRepositorio ventaRepositorio;


    @Transaccion
    public Venta registrarVenta(Venta venta) {


        return ventaRepositorio.adicionarVenta(venta);
    }


    public Venta obtenerVenta(Programacion programacion) {
        return ventaRepositorio.obtenerVenta(programacion);
    }
}