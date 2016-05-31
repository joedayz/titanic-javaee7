package com.titanic.ventapasajes.ws;



import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by josediaz on 1/5/16.
 */
public class GetIdentidadTest {


    @Test @Ignore
    public void debeValidarIdentidadCorrecta() {


        WSServiciosHR mtc = new WSServiciosHR();
        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();



        Seguridad seguridad = new Seguridad();
        seguridad.setRuc("20301040301");
        seguridad.setUsuario("059956");
        seguridad.setClave("123456");
        seguridad.setPartida("000396PNR");


        Identidad identidad = new Identidad();
        identidad.setNroDoc("16631064");
        identidad.setNroEmp("29724451");
        identidad.setSeguridad(seguridad);
        ResultIdentidad resultado = mtcClient.getIdentidad(identidad);

        assertNull(resultado.getErrores());
        assertEquals("DIAZ", resultado.getPaterno().toUpperCase());
    }

}
