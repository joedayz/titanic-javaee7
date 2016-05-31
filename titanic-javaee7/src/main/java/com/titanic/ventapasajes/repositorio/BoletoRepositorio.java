package com.titanic.ventapasajes.repositorio;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.titanic.ventapasajes.modelo.Boleto;

public class BoletoRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public Boleto buscarBoletoporId(Long ideBoleto) {
		return this.entityManager.find(Boleto.class, ideBoleto);
	}

}