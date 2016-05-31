package com.titanic.ventapasajes.ws;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by josediaz on 1/5/16.
 */
public class GetParametroTest {


    @Test
    public void debeValidarObtenerParametros() {


        WSServiciosHR mtc = new WSServiciosHR();
        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();



        Seguridad seguridad = new Seguridad();
        seguridad.setRuc("20301040301");
        seguridad.setUsuario("059956");
        seguridad.setClave("123456");
        seguridad.setPartida("000396PNR");


        Parametro oParametro = new Parametro();
        oParametro.setSeguridad(seguridad);

        ResultParametro resultado = mtcClient.getParametro(oParametro);

        assertNull(resultado.getErrores());
        assertNotNull(resultado.getDocumentos());
        assertNotNull(resultado.getRutas());
        assertNotNull(resultado.getTerminales());
        assertTrue(resultado.isReturn());



    }
}
