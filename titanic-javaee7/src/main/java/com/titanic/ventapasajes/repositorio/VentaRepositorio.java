package com.titanic.ventapasajes.repositorio;

/**
 * Created by josediaz on 12/27/15.
 */
import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.modelo.Venta;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.Serializable;

/**
 * Created by josediaz on 7/28/14.
 */
public class VentaRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public Venta obtenerVenta(Long id){
        return entityManager.find(Venta.class, id);
    }


    public Venta adicionarVenta(Venta venta) {

        return entityManager.merge(venta);
    }


    public Venta obtenerVenta(Programacion programacion) {

        try{

            Venta venta = entityManager.createQuery("from Venta where " +
                    "programacion.ideProgramacion = :ideProgramacion ",Venta.class)
                    .setParameter("ideProgramacion", programacion.getIdeProgramacion())
                    .getSingleResult();

            return venta;
        }catch(NoResultException e){
            return null;
        }


    }
}