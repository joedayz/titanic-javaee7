package com.titanic.ventapasajes.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.titanic.ventapasajes.modelo.*;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import com.titanic.ventapasajes.jsf.FacesUtil;
import com.titanic.ventapasajes.service.RegistroBusService;

/**
 * Created by josediaz on 7/20/14.
 */

@Named
@ViewScoped
public class RegistroBusBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private RegistroBusService busService;

    private Bus bus;

    private String asiento1, asiento11;
    private String asiento2, asiento22;
    private String asiento3, asiento33;
    private String asiento4, asiento44;
    private String asiento5, asiento55;

    private TipoAsiento tipoAsiento1, tipoAsiento11;
    private TipoAsiento tipoAsiento2, tipoAsiento22;
    private TipoAsiento tipoAsiento3, tipoAsiento33;
    private TipoAsiento tipoAsiento4, tipoAsiento44;
    private TipoAsiento tipoAsiento5, tipoAsiento55;


    public void inicializar() {

        if (this.bus == null) {
            this.bus = new Bus();
            bus.setFilas(new ArrayList<Fila>());
        }
    }


    public Bus getBus() {
        return bus;
    }


    public void registrarBus() {
        this.bus = busService.registrarBus(this.bus);
        FacesUtil.adicionarMensajeInfo("El Bus se registro correctamente");
    }


    public void setBus(Bus bus) {
        this.bus = bus;

    }

    public boolean isEditando() {
        return this.bus.getIdeBus() != null;
    }


    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {


            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ubicacion cambiada", "Anterior: " + oldValue + ", Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }


    public void agregarFilaSuperior() {

        Fila fila = new Fila();
        fila.setPrimerPiso(false);
        fila.setAsientos(new ArrayList<>());
        fila.setBus(bus);

        Asiento asiento11 = new Asiento(this.asiento11, this.tipoAsiento11, this.tipoAsiento11 == TipoAsiento.NO_APLICA ? false : true, false, fila);
        Asiento asiento22 = new Asiento(this.asiento22, this.tipoAsiento22, this.tipoAsiento22 == TipoAsiento.NO_APLICA ? false : true, false, fila);
        Asiento asiento33 = new Asiento(this.asiento33, this.tipoAsiento33, this.tipoAsiento33 == TipoAsiento.NO_APLICA ? false : true, false, fila);
        Asiento asiento44 = new Asiento(this.asiento44, this.tipoAsiento44, this.tipoAsiento44 == TipoAsiento.NO_APLICA ? false : true, false, fila);
        Asiento asiento55 = new Asiento(this.asiento55, this.tipoAsiento55, this.tipoAsiento55 == TipoAsiento.NO_APLICA ? false : true, false, fila);
        fila.getAsientos().add(asiento11);
        fila.getAsientos().add(asiento22);
        fila.getAsientos().add(asiento33);
        fila.getAsientos().add(asiento44);
        fila.getAsientos().add(asiento55);

        bus.getFilas().add(fila);

        resetFilaSuperior();

    }

    private void resetFilaSuperior() {
        this.asiento11 = "";
        this.tipoAsiento11 = null;
        this.asiento22 = "";
        this.tipoAsiento22 = null;
        this.asiento33 = "";
        this.tipoAsiento33 = null;
        this.asiento44 = "";
        this.tipoAsiento44 = null;
        this.asiento55 = "";
        this.tipoAsiento55 = null;
    }

    public void agregarFilaInferior() {

        Fila fila = new Fila();
        fila.setPrimerPiso(true);
        fila.setAsientos(new ArrayList<>());
        fila.setBus(bus);

        Asiento asiento1 = new Asiento(this.asiento1, this.tipoAsiento1, this.tipoAsiento1 == TipoAsiento.NO_APLICA ? false : true, true, fila);
        Asiento asiento2 = new Asiento(this.asiento2, this.tipoAsiento2, this.tipoAsiento2 == TipoAsiento.NO_APLICA ? false : true, true, fila);
        Asiento asiento3 = new Asiento(this.asiento3, this.tipoAsiento3, this.tipoAsiento3 == TipoAsiento.NO_APLICA ? false : true, true, fila);
        Asiento asiento4 = new Asiento(this.asiento4, this.tipoAsiento4, this.tipoAsiento4 == TipoAsiento.NO_APLICA ? false : true, true, fila);
        Asiento asiento5 = new Asiento(this.asiento5, this.tipoAsiento5, this.tipoAsiento5 == TipoAsiento.NO_APLICA ? false : true, true, fila);
        fila.getAsientos().add(asiento1);
        fila.getAsientos().add(asiento2);
        fila.getAsientos().add(asiento3);
        fila.getAsientos().add(asiento4);
        fila.getAsientos().add(asiento5);

        bus.getFilas().add(fila);

        resetFilaInferior();

    }

    private void resetFilaInferior() {
        this.asiento1 = "";
        this.tipoAsiento1 = null;
        this.asiento2 = "";
        this.tipoAsiento2 = null;
        this.asiento3 = "";
        this.tipoAsiento3 = null;
        this.asiento4 = "";
        this.tipoAsiento4 = null;
        this.asiento5 = "";
        this.tipoAsiento5 = null;
    }

    public List<Fila> getFilasInferiores() {
        return bus.getFilas().stream().filter(f -> f.isPrimerPiso()).collect(Collectors.toCollection(() ->
                new ArrayList<>()));


    }


    public List<Fila> getFilasSuperiores() {
        return bus.getFilas().stream().filter(f -> !f.isPrimerPiso()).collect(Collectors.toCollection(() ->
                new ArrayList<>()));

    }


    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Fila Editada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Fila Eliminada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.bus.getFilas().remove((Fila) event.getObject());
    }


    public void onEdit2(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Fila Editada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel2(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Fila Eliminada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.bus.getFilas().remove((Fila) event.getObject());
    }


    public TipoPlanta[] getTiposPlantas() {
        return TipoPlanta.values();
    }


    public String getAsiento11() {
        return asiento11;
    }

    public void setAsiento11(String asiento11) {
        this.asiento11 = asiento11;
    }

    public String getAsiento22() {
        return asiento22;
    }

    public void setAsiento22(String asiento22) {
        this.asiento22 = asiento22;
    }

    public String getAsiento33() {
        return asiento33;
    }

    public void setAsiento33(String asiento33) {
        this.asiento33 = asiento33;
    }

    public String getAsiento44() {
        return asiento44;
    }

    public void setAsiento44(String asiento44) {
        this.asiento44 = asiento44;
    }

    public String getAsiento55() {
        return asiento55;
    }

    public void setAsiento55(String asiento55) {
        this.asiento55 = asiento55;
    }

    public TipoAsiento getTipoAsiento11() {
        return tipoAsiento11;
    }

    public void setTipoAsiento11(TipoAsiento tipoAsiento11) {
        this.tipoAsiento11 = tipoAsiento11;
    }

    public TipoAsiento getTipoAsiento22() {
        return tipoAsiento22;
    }

    public void setTipoAsiento22(TipoAsiento tipoAsiento22) {
        this.tipoAsiento22 = tipoAsiento22;
    }

    public TipoAsiento getTipoAsiento33() {
        return tipoAsiento33;
    }

    public void setTipoAsiento33(TipoAsiento tipoAsiento33) {
        this.tipoAsiento33 = tipoAsiento33;
    }

    public TipoAsiento getTipoAsiento44() {
        return tipoAsiento44;
    }

    public void setTipoAsiento44(TipoAsiento tipoAsiento44) {
        this.tipoAsiento44 = tipoAsiento44;
    }

    public TipoAsiento getTipoAsiento55() {
        return tipoAsiento55;
    }

    public void setTipoAsiento55(TipoAsiento tipoAsiento55) {
        this.tipoAsiento55 = tipoAsiento55;
    }

    public String getAsiento1() {
        return asiento1;
    }

    public void setAsiento1(String asiento1) {
        this.asiento1 = asiento1;
    }

    public String getAsiento2() {
        return asiento2;
    }

    public void setAsiento2(String asiento2) {
        this.asiento2 = asiento2;
    }

    public String getAsiento3() {
        return asiento3;
    }

    public void setAsiento3(String asiento3) {
        this.asiento3 = asiento3;
    }

    public String getAsiento4() {
        return asiento4;
    }

    public void setAsiento4(String asiento4) {
        this.asiento4 = asiento4;
    }

    public String getAsiento5() {
        return asiento5;
    }

    public void setAsiento5(String asiento5) {
        this.asiento5 = asiento5;
    }

    public TipoAsiento[] getTipoAsientos() {
        return TipoAsiento.values();
    }


    public TipoAsiento getTipoAsiento1() {
        return tipoAsiento1;
    }

    public void setTipoAsiento1(TipoAsiento tipoAsiento1) {
        this.tipoAsiento1 = tipoAsiento1;
    }

    public TipoAsiento getTipoAsiento2() {
        return tipoAsiento2;
    }

    public void setTipoAsiento2(TipoAsiento tipoAsiento2) {
        this.tipoAsiento2 = tipoAsiento2;
    }

    public TipoAsiento getTipoAsiento3() {
        return tipoAsiento3;
    }

    public void setTipoAsiento3(TipoAsiento tipoAsiento3) {
        this.tipoAsiento3 = tipoAsiento3;
    }

    public TipoAsiento getTipoAsiento4() {
        return tipoAsiento4;
    }

    public void setTipoAsiento4(TipoAsiento tipoAsiento4) {
        this.tipoAsiento4 = tipoAsiento4;
    }

    public TipoAsiento getTipoAsiento5() {
        return tipoAsiento5;
    }

    public void setTipoAsiento5(TipoAsiento tipoAsiento5) {
        this.tipoAsiento5 = tipoAsiento5;
    }

    public void reset() {
        resetFilaInferior();
        getFilasInferiores();
    }

    public void reset2() {
        resetFilaSuperior();
        getFilasSuperiores();
    }

}
