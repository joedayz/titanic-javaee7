package com.titanic.ventapasajes.components;

import javax.faces.component.*;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by josediaz on 7/27/14.
 */
@FacesComponent("asientoButton")
public class AsientoButton extends UIInput implements NamingContainer {


    private UICommand add;
    private String customStyle;


    @Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
       
//        String estado = getAttributeValue("estado", String.valueOf(EstadoBoleto.LIBRE));
//
//        if(estado.equals(String.valueOf(EstadoBoleto.RESERVADO))){
//            customStyle = "botonReservado";
//        }else if(estado.equals(String.valueOf(EstadoBoleto.PAGADO))){
//            customStyle ="botonPagado";
//        }else if (estado.equals(String.valueOf(EstadoBoleto.NO_DISPONIBLE))) {
//            customStyle ="botonNoDisponible";
//        }else if (estado.equals(String.valueOf(EstadoBoleto.LIBRE))){
//            customStyle ="";
//        }
//


        super.encodeBegin(context);
    }




    @SuppressWarnings("unchecked")
    private <T> T getAttributeValue(String key, T defaultValue) {
        T value = (T) getAttributes().get(key);
        return (value != null) ? value : defaultValue;
    }

    public UICommand getAdd() {
        return add;
    }

    public void setAdd(UICommand add) {
        this.add = add;
    }

    public String getCustomStyle() {
        return customStyle;
    }

    public void setCustomStyle(String customStyle) {
        this.customStyle = customStyle;
    }
}
