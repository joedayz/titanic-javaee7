package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.modelo.HojaRuta;
import com.titanic.ventapasajes.repositorio.HojaRutaRepositorio;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by josediaz on 1/11/16.
 */
@FacesConverter(forClass=HojaRuta.class)
public class HojaRutaConverter implements Converter  {

    private HojaRutaRepositorio hojaRutaRepositorio;

    public HojaRutaConverter() {
        this.hojaRutaRepositorio =  CDIServiceLocator.getBean(HojaRutaRepositorio.class);
    }


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        HojaRuta retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.hojaRutaRepositorio.buscarHojaRutaPorId(new Long(value));
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if(value!=null){
            HojaRuta hojaRuta = (HojaRuta) value;
            return hojaRuta.getIdeHojaRuta() == null ? null :  hojaRuta.getIdeHojaRuta().toString();
        }

        return "";
    }
}
