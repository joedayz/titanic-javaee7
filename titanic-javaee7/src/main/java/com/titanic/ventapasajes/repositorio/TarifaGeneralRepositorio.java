package com.titanic.ventapasajes.repositorio;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.titanic.ventapasajes.modelo.TarifaGeneral;

/**
 * Created by josediaz on 7/25/14.
 */
public class TarifaGeneralRepositorio implements Serializable {



    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public TarifaGeneral buscarTarifaGeneralporId(Long ideTarifaGeneral) {
        return this.entityManager.find(TarifaGeneral.class, ideTarifaGeneral);
    }


    public TarifaGeneral buscarTarifaGeneral(String tipoBus, Long ideRecorrido){

        try {

            TarifaGeneral tarifaGeneral = entityManager.createQuery("from TarifaGeneral where " +
                    "tipoAsiento = :tipoBus and " +
                    "recorrido.ideRecorrido = :ideRecorrido", TarifaGeneral.class)
                    .setParameter("tipoBus", tipoBus)
                    .setParameter("ideRecorrido", ideRecorrido)
                    .getSingleResult();




            return tarifaGeneral;
        }catch(NoResultException e){
            return null;
        }
    }


    public TarifaGeneral adicionarTarifaGeneral(TarifaGeneral tarifaGeneral) {
        return entityManager.merge(tarifaGeneral);
    }



}


