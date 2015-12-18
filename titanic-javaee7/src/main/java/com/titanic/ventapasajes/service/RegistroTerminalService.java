package com.titanic.ventapasajes.service;

import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.repositorio.TerminalRepositorio;
import com.titanic.ventapasajes.util.jpa.Transaccion;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by josediaz on 7/24/14.
 */
public class RegistroTerminalService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private TerminalRepositorio terminalRepositorio;

    @Transaccion
    public Terminal registrarTerminal(Terminal terminal){

        Terminal terminalExistente = terminalRepositorio.buscarTerminalPorNombre(terminal.getNombreTerminal());

        if(terminalExistente!=null && !terminalExistente.equals(terminal)){
            throw new NegocioExcepciones("Ya existe una terminal con ese nombre, verificar");
        }


        return terminalRepositorio.adicionarTerminal(terminal);
    }
}
