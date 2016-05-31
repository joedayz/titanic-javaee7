package com.titanic.ventapasajes.modelo;

import java.io.Serializable;

/**
 * Created by josediaz on 1/11/16.
 */
public class Seguridad implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ruc;
    private String usuario;
    private String clave;
    private String partida;

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Seguridad{" +
                "ruc='" + ruc + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", partida='" + partida + '\'' +
                '}';
    }
}
