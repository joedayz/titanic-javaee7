package com.titanic.ventapasajes.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.repositorio.TerminalRepositorio;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

/**
 * Created by josediaz on 7/24/14.
 */
@FacesConverter(forClass=Terminal.class)
public class TerminalConverter  implements Converter {

    private TerminalRepositorio terminalRepositorio;

    public TerminalConverter() {
        this.terminalRepositorio = (TerminalRepositorio) CDIServiceLocator.getBean(TerminalRepositorio.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Terminal retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.terminalRepositorio.buscarTerminalporId(new Long(value));
        }

        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            Terminal terminal = (Terminal) value;
            return terminal.getIdeTerminal() == null ? null :  terminal.getIdeTerminal().toString();
        }
        return "";


    }

}
