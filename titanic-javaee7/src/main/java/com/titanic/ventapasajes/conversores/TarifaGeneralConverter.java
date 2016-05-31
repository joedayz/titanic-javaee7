package com.titanic.ventapasajes.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.TarifaGeneral;
import com.titanic.ventapasajes.repositorio.TarifaGeneralRepositorio;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

/**
 * Created by josediaz on 7/25/14.
 */
@FacesConverter(forClass=TarifaGeneral.class)
public class TarifaGeneralConverter implements Converter{


    private TarifaGeneralRepositorio repositorio;

    public TarifaGeneralConverter() {
        this.repositorio = (TarifaGeneralRepositorio) CDIServiceLocator.getBean(TarifaGeneralRepositorio.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        TarifaGeneral retorno = null;

        if (value != null) {
            retorno = this.repositorio.buscarTarifaGeneralporId(new Long(value));
        }

        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            TarifaGeneral tarifaGeneral = (TarifaGeneral) value;
            return tarifaGeneral.getIdeTarifaGeneral() == null ? null :  tarifaGeneral.getIdeTarifaGeneral().toString();
        }
        return "";


    }
}
