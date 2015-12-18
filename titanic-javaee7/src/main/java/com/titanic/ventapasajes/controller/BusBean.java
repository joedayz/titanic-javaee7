package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.modelo.Bus;
import com.titanic.ventapasajes.repositorio.BusRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.BusFiltros;
import com.titanic.ventapasajes.jsf.FacesUtil;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by josediaz on 12/14/15.
 */
@Named
@ViewScoped
public class BusBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private BusRepositorio busRepositorio;

    private List<Bus> busesFiltrados;
    private BusFiltros filtros;

    private Bus busSeleccionado;


    @PostConstruct
    public void init(){
        filtros = new BusFiltros();
        buscarBusFiltros();
    }


    public void buscarBusFiltros(){
        busesFiltrados = busRepositorio.listarBusesFiltrados(filtros);

    }

    public void eliminarBus(){
        busRepositorio.removerBus(busSeleccionado);
        busesFiltrados.remove(busSeleccionado);
        FacesUtil.adicionarMensajeInfo("Bus " + busSeleccionado.getDescripcionBus() + " eliminado.");
    }


    public void selectBusFromDialog(Bus bus) {
        RequestContext.getCurrentInstance().closeDialog(bus);
    }

    public Bus getBusSeleccionado() {
        return busSeleccionado;
    }

    public void setBusSeleccionado(Bus busSeleccionado) {
        this.busSeleccionado = busSeleccionado;
    }

    public BusFiltros getFiltros() {
        return filtros;
    }

    public List<Bus> getBusesFiltrados() {
        return busesFiltrados;
    }
}
