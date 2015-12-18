package com.titanic.ventapasajes.service;

import com.titanic.ventapasajes.modelo.TarifaGeneral;
import com.titanic.ventapasajes.repositorio.TarifaGeneralRepositorio;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by Celeritech Peru on 31/03/2015.
 */
public class TarifaGeneralService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private TarifaGeneralRepositorio tarifaGeneralRepositorio;


    public TarifaGeneral buscarTarifaGeneral(String tipoBus, Long ideRecorrido){
        return tarifaGeneralRepositorio.buscarTarifaGeneral(tipoBus, ideRecorrido);
    }
}
