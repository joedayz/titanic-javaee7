package com.titanic.ventapasajes.controller;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.titanic.ventapasajes.modelo.Boleto;
import com.titanic.ventapasajes.repositorio.BoletoRepositorio;
import com.titanic.ventapasajes.util.math.Util;

@Named
@RequestScoped
public class BoletoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boleto boleto;

	private String dia;
	private String mes;
	private String anho;

	@Inject
	private BoletoRepositorio boletoRepositorio;

	@Inject
	private HttpServletRequest request;

	@PostConstruct
	public void init() {

		String boletoId = request.getParameter("boleto");

		if (boletoId != null) {
			boleto = boletoRepositorio.buscarBoletoporId(Long.valueOf(boletoId));

			if (boleto != null) {
				if (boleto.getFechaVenta() != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(boleto.getFechaVenta());
					anho = String.valueOf(cal.get(Calendar.YEAR));
					int intMes = cal.get(Calendar.MONTH);
					mes = Util.obtenerNombreMes(intMes + 1);
					dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
				}
			}
		}

	}


	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public String getNumeroEnLetras() {
		return Util.convertirNumeroALetra(boleto.getPrecio().toString(), true);
	}

	public String getDia() {
		return dia;
	}

	public String getMes() {
		return mes;
	}

	public String getAnho() {
		return anho;
	}

}
