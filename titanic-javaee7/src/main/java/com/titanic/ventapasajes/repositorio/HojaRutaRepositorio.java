package com.titanic.ventapasajes.repositorio;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.modelo.HojaRuta;
import com.titanic.ventapasajes.repositorio.filtros.HojaRutaFiltros;
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
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by josediaz on 1/11/16.
 */
public class HojaRutaRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private EntityManager entityManager;


    public HojaRuta buscarHojaRutaPorId(Long id) {
        return this.entityManager.find(HojaRuta.class, id);
    }



    public List<HojaRuta> buscarTodos() {
        return this.entityManager.createQuery("from HojaRuta").getResultList();
    }


    public List<HojaRuta> listarHojaRutaFiltrados(HojaRutaFiltros hojaRutaFiltros) {

        Session session = entityManager.unwrap(Session.class);
        Criteria criteria =  session.createCriteria(HojaRuta.class);
        criteria.add(Restrictions.between("fechaRegistro", hojaRutaFiltros.getFechaDesde(), hojaRutaFiltros.getFechaHasta()));

        return criteria.addOrder(Order.asc("fechaRegistro")).list();
    }

    @Transaccion
    public void removerHojaRuta(HojaRuta hojaRuta) {

        try{
            hojaRuta = buscarHojaRutaPorId(hojaRuta.getIdeHojaRuta());
            entityManager.remove(hojaRuta);
            entityManager.flush();
        }catch(PersistenceException e){
            throw new NegocioExcepciones("La Hoja Ruta no puede ser eliminada.");
        }

    }


    @Transaccion
    public HojaRuta adicionarHojaRuta(HojaRuta hojaRuta) {
        return entityManager.merge(hojaRuta);
    }


}
