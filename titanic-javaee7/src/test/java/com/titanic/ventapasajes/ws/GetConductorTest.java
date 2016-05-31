package com.titanic.ventapasajes.ws;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by josediaz on 1/5/16.
 */
public class GetConductorTest {


    @Test
    public void debeValidarConductorAutorizado(){



        WSServiciosHR mtc = new WSServiciosHR();
        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();


        Conductor conductor = new Conductor();
        Seguridad seguridad = new Seguridad();
        seguridad.setRuc("20301040301");
        seguridad.setUsuario("059956");
        seguridad.setClave("123456");
        seguridad.setPartida("000396PNR");


        conductor.setSeguridad(seguridad);
        conductor.setTpoDocumento("L.E.");
        conductor.setNroDocumento("16621736");

        ResultConductor resultado = mtcClient.getConductor(conductor);
        assertNull(resultado.getErrores());
        assertTrue(resultado.isReturn());
    }
}
