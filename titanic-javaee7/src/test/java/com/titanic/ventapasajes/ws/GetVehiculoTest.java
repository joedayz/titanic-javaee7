package com.titanic.ventapasajes.ws;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by josediaz on 1/5/16.
 */
public class GetVehiculoTest {



    @Test
    public void debeValidarObtenerParametros() {


        WSServiciosHR mtc = new WSServiciosHR();
        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();



        Seguridad seguridad = new Seguridad();
        seguridad.setRuc("20301040301");
        seguridad.setUsuario("059956");
        seguridad.setClave("123456");
        seguridad.setPartida("000396PNR");


        Vehiculo oVehiculo = new Vehiculo();
        oVehiculo.setNroPlaca("A4F957");
        oVehiculo.setSeguridad(seguridad);
        ResultVehiculo resultado = mtcClient.getVehiculo(oVehiculo);

        assertNull(resultado.getErrores());
        assertTrue(resultado.isReturn());


    }
}
