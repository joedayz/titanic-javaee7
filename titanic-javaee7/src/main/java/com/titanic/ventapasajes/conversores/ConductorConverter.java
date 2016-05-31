package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.modelo.Conductor;
import com.titanic.ventapasajes.repositorio.ClienteRepositorio;
import com.titanic.ventapasajes.repositorio.ConductorRepositorio;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by josediaz on 12/18/15.
 */

@FacesConverter(forClass=Conductor.class)
public class ConductorConverter implements Converter {


    private ConductorRepositorio conductorRepositorio;

    public ConductorConverter() {
        this.conductorRepositorio = (ConductorRepositorio) CDIServiceLocator.getBean(ConductorRepositorio.class);
    }


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Conductor retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.conductorRepositorio.buscarConductorporId(new Long(value));
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if(value!=null){
            Conductor conductor = (Conductor) value;
            return conductor.getIdeConductor() == null ? null :  conductor.getIdeConductor().toString();
        }

        return "";
    }
}
