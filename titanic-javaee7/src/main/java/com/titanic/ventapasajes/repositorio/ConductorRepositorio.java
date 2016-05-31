package com.titanic.ventapasajes.repositorio;


import com.titanic.ventapasajes.modelo.Conductor;
import com.titanic.ventapasajes.repositorio.filtros.ConductorFiltros;
import com.titanic.ventapasajes.service.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by josediaz on 12/18/15.
 */
public class ConductorRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private EntityManager entityManager;

    public Conductor buscarConductorporId(Long ideConductor) {
        return this.entityManager.find(Conductor.class, ideConductor);
    }


    public List<Conductor> buscarTodos() {
        return this.entityManager.createQuery("from Conductor").getResultList();
    }


    @SuppressWarnings("unchecked")
    public List<Conductor> listarConductoresFiltrados(ConductorFiltros conductorFiltros) {


        Session session = entityManager.unwrap(Session.class);
        Criteria criteria =  session.createCriteria(Conductor.class);
        if(StringUtils.isNotBlank(conductorFiltros.getNumeroDocumento())){
            criteria.add(Restrictions.eq("numeroDocumento", conductorFiltros.getNumeroDocumento()));
        }


        if(StringUtils.isNotBlank(conductorFiltros.getNombre())){
            criteria.add(Restrictions.ilike("nombreConductor", conductorFiltros.getNombre(),
                    MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("nombreConductor")).list();

    }

    @Transaccion
    public void removerConductor(Conductor conductor) {

        try{
            conductor = obtenerConductor(conductor.getIdeConductor());
            entityManager.remove(conductor);
            entityManager.flush();
        }catch(PersistenceException e){
            throw new NegocioExcepciones("El conductor no puede ser eliminado.");
        }

    }


    public Conductor obtenerConductor(Long id){
        return entityManager.find(Conductor.class, id);
    }


    public Conductor obtenerConductorPorNumeroDocumento(String numeroDocumento){
        try{
            return entityManager.createQuery("from Conductor where numeroDocumento = :numeroDocumento", Conductor.class)
                    .setParameter("numeroDocumento", numeroDocumento)
                    .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Transaccion
    public Conductor adicionarConductor(Conductor conductor) {
        return entityManager.merge(conductor);
    }

}
