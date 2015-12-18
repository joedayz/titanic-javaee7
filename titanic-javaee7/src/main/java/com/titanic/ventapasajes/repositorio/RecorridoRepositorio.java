package com.titanic.ventapasajes.repositorio;

import com.titanic.ventapasajes.modelo.Recorrido;
import com.titanic.ventapasajes.repositorio.filtros.RecorridoFiltros;
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
 * Created by josediaz on 7/25/14.
 */
public class RecorridoRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;



    public Recorrido buscarRecorridoporId(Long ideRecorrido) {
        return this.entityManager.find(Recorrido.class, ideRecorrido);
    }

    public List<Recorrido> buscarRecorridoPorRuta(String ruta) {
        return this.entityManager.createQuery("from Recorrido " +
                "where upper(ruta) like :ruta", Recorrido.class)
                .setParameter("ruta", ruta.toUpperCase() + "%")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
	public List<Recorrido> listarRecorridosFiltrados(RecorridoFiltros filtros) {

        Session session = entityManager.unwrap(Session.class);
        Criteria criteria =  session.createCriteria(Recorrido.class);
        if(StringUtils.isNotBlank(filtros.getOrigen())){
            criteria.add(Restrictions.eq("origen.ideTerminal", Long.valueOf(filtros.getOrigen())));
        }

        if(StringUtils.isNotBlank(filtros.getDestino())){
            criteria.add(Restrictions.eq("destino.ideTerminal", Long.valueOf(filtros.getDestino())));
        }

        if(StringUtils.isNotBlank(filtros.getRuta())){
            criteria.add(Restrictions.like("ruta", filtros.getRuta(), MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("ruta")).list();
    }

    @Transaccion
    public void removerRecorrido(Recorrido recorrido) {

        try{
            recorrido  = obtenerRecorrido(recorrido.getIdeRecorrido());
            entityManager.remove(recorrido);
            entityManager.flush();
        }catch(PersistenceException e){
            throw new NegocioExcepciones("El recorrido no puede ser eliminado.");
        }
    }


    public Recorrido obtenerRecorrido(Long id){
        return entityManager.find(Recorrido.class, id);
    }

    public Recorrido obtenerRecorridoPorOrigen(String origen){
        try{
            return entityManager.createQuery("from Recorrido where origen.ideTerminal = :origen", Recorrido.class)
                    .setParameter("origen", origen)
                    .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    public Recorrido adicionarRecorrido(Recorrido recorrido) {
        return entityManager.merge(recorrido);
    }

    public Recorrido obtenerRecorridoPorRuta(String ruta) {

        try{
            return entityManager.createQuery("from Recorrido where ruta = :ruta", Recorrido.class)
                    .setParameter("ruta", ruta)
                    .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
}
