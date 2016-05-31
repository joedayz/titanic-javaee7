package com.titanic.ventapasajes.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.modelo.HojaRuta;
import com.titanic.ventapasajes.repositorio.HojaRutaRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.HojaRutaFiltros;

/**
 * Created by josediaz on 1/11/16.
 */
@Named
@ViewScoped
public class HojaRutaBean implements Serializable {



    private static final long serialVersionUID = 1592771145764176840L;

    @Inject
    private HojaRutaRepositorio hojaRutaRepositorio;
    private HojaRutaFiltros filtros;
    private List<HojaRuta> hojaRutasFiltrados;
    private HojaRuta hojaRutaSeleccionada;


    @PostConstruct
    public void init(){
        filtros = new HojaRutaFiltros();

        Calendar calendar = Calendar.getInstance();
        filtros.setFechaHasta(calendar.getTime());
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        filtros.setFechaDesde(calendar.getTime());


        buscarHojaRutaFiltros();
    }

    public void buscarHojaRutaFiltros() {
        hojaRutasFiltrados = hojaRutaRepositorio.listarHojaRutaFiltrados(filtros);
    }


    public void eliminarHojaRuta(){
        hojaRutaRepositorio.removerHojaRuta(hojaRutaSeleccionada);
        hojaRutasFiltrados.remove(hojaRutaSeleccionada);
        FacesUtil.adicionarMensajeInfo("Hoja Ruta "+hojaRutaSeleccionada.getCodigoHojaRuta() +" eliminada.");
    }

    public List<HojaRuta> getHojaRutasFiltrados() {
        return hojaRutasFiltrados;
    }

    public HojaRutaFiltros getFiltros() {
        return filtros;
    }

    public HojaRuta getHojaRutaSeleccionada() {
        return hojaRutaSeleccionada;
    }

    public void setHojaRutaSeleccionada(HojaRuta hojaRutaSeleccionada) {
        this.hojaRutaSeleccionada = hojaRutaSeleccionada;
    }
}
