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
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.repositorio.filtros.ClienteFiltros;
import com.titanic.ventapasajes.service.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;

public class ClienteRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public Cliente buscarClienteporId(Long ideCliente) {
		return this.entityManager.find(Cliente.class, ideCliente);
	}



	public List<Cliente> buscarTodos(){
        return this.entityManager.createQuery("from Cliente").getResultList();
    }

	public List<Cliente> buscarClientePorNombre(String nombreCliente) {
		return this.entityManager.createQuery("from Cliente " +
				"where upper(nombreCliente) like :nombreCliente", Cliente.class)
				.setParameter("nombreCliente", nombreCliente.toUpperCase() + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientesFiltrados(ClienteFiltros clienteFiltros) {

		
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria =  session.createCriteria(Cliente.class);
		if(StringUtils.isNotBlank(clienteFiltros.getNumeroDocumento())){
			criteria.add(Restrictions.eq("numeroDocumento", clienteFiltros.getNumeroDocumento()));
		}
		
		if(StringUtils.isNotBlank(clienteFiltros.getEmail())){
			criteria.add(Restrictions.eq("email", clienteFiltros.getEmail()));
		}
				
		
		if(StringUtils.isNotBlank(clienteFiltros.getNombre())){
			criteria.add(Restrictions.ilike("nombreCliente", clienteFiltros.getNombre(), 
							MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nombreCliente")).list();
		
	}

	@Transaccion
	public void removerCliente(Cliente cliente) {
		
		try{
			cliente = obtenerCliente(cliente.getIdeCliente());
			entityManager.remove(cliente);
			entityManager.flush();
		}catch(PersistenceException e){
			throw new NegocioExcepciones("El cliente no puede ser eliminado.");
		}
		
	}
	
	public Cliente obtenerCliente(Long id){
		return entityManager.find(Cliente.class, id);
	}
	
	public Cliente obtenerClientePorNumeroDocumento(String numeroDocumento){
		try{
			return entityManager.createQuery("from Cliente where numeroDocumento = :numeroDocumento", Cliente.class)
					.setParameter("numeroDocumento", numeroDocumento)
					.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Transaccion
	public Cliente adicionarCliente(Cliente cliente) {
		return entityManager.merge(cliente);
	}
}
