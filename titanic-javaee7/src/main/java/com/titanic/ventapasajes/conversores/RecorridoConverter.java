package com.titanic.ventapasajes.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.Recorrido;
import com.titanic.ventapasajes.repositorio.RecorridoRepositorio;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

/**
 * Created by josediaz on 7/25/14.
 */


@FacesConverter(forClass=Recorrido.class)
public class RecorridoConverter implements Converter {

    private RecorridoRepositorio recorridoRepositorio;

    public RecorridoConverter() {
        this.recorridoRepositorio = (RecorridoRepositorio) CDIServiceLocator.getBean(RecorridoRepositorio.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Recorrido retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.recorridoRepositorio.buscarRecorridoporId(new Long(value));
        }

        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            Recorrido recorrido = (Recorrido) value;
            return recorrido.getIdeRecorrido() == null ? null :  recorrido.getIdeRecorrido().toString();
        }
        return "";
    }

}
