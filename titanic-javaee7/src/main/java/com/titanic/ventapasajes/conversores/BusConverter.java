package com.titanic.ventapasajes.conversores;


 import javax.faces.component.UIComponent;
 import javax.faces.context.FacesContext;
 import javax.faces.convert.Converter;
 import javax.faces.convert.FacesConverter;

 import com.titanic.ventapasajes.modelo.Bus;
 import com.titanic.ventapasajes.repositorio.BusRepositorio;
 import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

 /**
 * Created by josediaz on 7/20/14.
 */
@FacesConverter(forClass=Bus.class)
public class BusConverter implements Converter {

    private BusRepositorio busRepositorio;

    public BusConverter() {
        this.busRepositorio = CDIServiceLocator.getBean(BusRepositorio.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Bus retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.busRepositorio.buscarBusporId(new Long(value));
        }

        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            Bus bus = (Bus) value;
            return bus.getIdeBus() == null ? null :  bus.getIdeBus().toString();
        }
        return "";
    }

}