package com.titanic.ventapasajes.repositorio;

import com.titanic.ventapasajes.modelo.Bus;
import com.titanic.ventapasajes.repositorio.filtros.BusFiltros;
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
 * Created by josediaz on 7/20/14.
 */
public class BusRepositorio implements Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public Bus buscarBusporId(Long ideBus) {
        return this.entityManager.find(Bus.class, ideBus);
    }



    public Bus buscarUsuarioporPlaca(String placa) {

        Bus bus = null;
        try{
            bus =  this.entityManager.createQuery("from Bus where lower(placa) = :placa", Bus.class)
                    .setParameter("placa", placa).getSingleResult();
        }catch(NoResultException e){

        }
        return bus;
    }

    @SuppressWarnings("unchecked")
    public List<Bus> listarBusesFiltrados(BusFiltros busFiltros) {


        Session session = entityManager.unwrap(Session.class);
        Criteria criteria =  session.createCriteria(Bus.class);
        if(StringUtils.isNotBlank(busFiltros.getPlaca())){
            criteria.add(Restrictions.eq("placa", busFiltros.getPlaca()));
        }


        return criteria.addOrder(Order.asc("descripcionBus")).list();

    }

    public Bus getFilasWithBusById(Long busId)
    {
        Session session = entityManager.unwrap(Session.class);

        Bus bus = (Bus) session.createCriteria(Bus.class).add(Restrictions.idEq(busId)).uniqueResult();
        // this will force SQL to execute the query that will join with the user's profile and populate
        //  the appropriate information into the user object.
        //Hibernate.initialize(bus.getFilasSuperiores());
        //Hibernate.initialize(bus.getFilasInferiores());

        return bus;
    }

    @Transaccion
    public void removerBus(Bus bus) {

        try{
            bus = obtenerBus(bus.getIdeBus());
            entityManager.remove(bus);
            entityManager.flush();
        }catch(PersistenceException e){
            throw new NegocioExcepciones("El bus no puede ser eliminado.");
        }

    }

    public Bus obtenerBus(Long id){
        return entityManager.find(Bus.class, id);
    }

    public Bus adicionarBus(Bus bus) {
        return entityManager.merge(bus);
    }


}