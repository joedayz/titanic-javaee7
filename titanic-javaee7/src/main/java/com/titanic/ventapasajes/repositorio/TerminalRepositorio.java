package com.titanic.ventapasajes.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.repositorio.filtros.TerminalFiltros;
import com.titanic.ventapasajes.service.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;

/**
 * Created by josediaz on 7/24/14.
 */
public class TerminalRepositorio implements Serializable {



    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public Terminal buscarTerminalporId(Long ideTerminal) {
        return this.entityManager.find(Terminal.class, ideTerminal);
    }





    @Transaccion
    public void removerTerminal(Terminal terminal) {

        try{
            terminal = obtenerTerminal(terminal.getIdeTerminal());
            entityManager.remove(terminal);
            entityManager.flush();
        }catch(PersistenceException e){
            throw new NegocioExcepciones("El terminal no puede ser eliminado.");
        }

    }

    public Terminal obtenerTerminal(Long id){
        return entityManager.find(Terminal.class, id);
    }

    public Terminal adicionarTerminal(Terminal terminal) {
        return entityManager.merge(terminal);
    }

    public Terminal buscarTerminalPorNombre(String nombreTerminal) {

        Terminal terminal = null;
        try{
            terminal =  this.entityManager.createQuery("from Terminal where lower(nombreTerminal) = :terminal", Terminal.class)
                    .setParameter("terminal", nombreTerminal.toLowerCase()).getSingleResult();
        }catch(NoResultException e){

        }
        return terminal;
    }

    public List<Terminal> listarTerminales() {
        return entityManager.createQuery("from Terminal ", Terminal.class)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
	public List<Terminal> listarTerminalesFiltrados(TerminalFiltros terminalFiltros) {


        Session session = entityManager.unwrap(Session.class);
        Criteria criteria =  session.createCriteria(Terminal.class);
        if(StringUtils.isNotBlank(terminalFiltros.getNombre())){
            criteria.add(Restrictions.eq("nombreTerminal", terminalFiltros.getNombre()));
        }



        return criteria.addOrder(Order.asc("nombreTerminal")).list();

    }
}
