package com.titanic.ventapasajes.ws;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by josediaz on 1/6/16.
 */
public class SetRutaTest {


    @Test
    public void debeCrearHojaRuta() {


        WSServiciosHR mtc = new WSServiciosHR();
        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();


        Seguridad seguridad = new Seguridad();
        seguridad.setRuc("20301040301");
        seguridad.setUsuario("059956");
        seguridad.setClave("123456");
        seguridad.setPartida("000396PNR");

        HojaRuta oHojaRuta = new HojaRuta();
        oHojaRuta.setSeguridad(seguridad);
        oHojaRuta.setNroRuta("0001");
        oHojaRuta.setNroPlaca("A4F958");
        oHojaRuta.setTerSalida(2593);
        oHojaRuta.setTerLlegada(2591);

        oHojaRuta.setFecSalida("06/01/2016");
        oHojaRuta.setFecEstLlegada("07/01/2016");
        oHojaRuta.setHorSalida("23:00");
        oHojaRuta.setHorEstLlegada("11:00");

        ArrayOfHConductor conductores = oHojaRuta.getConductores();
        if (conductores == null) {
            conductores = new ArrayOfHConductor();
            oHojaRuta.conductores = conductores;
        }


        List<HConductor> hConductores = conductores.getHConductor();
        HConductor hConductor1 = new HConductor();
        hConductor1.setTpoDocumento("L.E.");
        hConductor1.setNroDocumento("16776068");
        hConductor1.setFecInicio("06/01/2016");
        hConductor1.setFecTermino("06/01/2016");
        hConductor1.setHorInicio("18:00");
        hConductor1.setHorTermino("22:00");

        HConductor hConductor2 = new HConductor();
        hConductor2.setTpoDocumento("L.E.");
        hConductor2.setNroDocumento("17633458");
        hConductor2.setFecInicio("06/01/2016");
        hConductor2.setFecTermino("07/01/2016");
        hConductor2.setHorInicio("22:00");
        hConductor2.setHorTermino("02:00");

        HConductor hConductor3 = new HConductor();
        hConductor3.setTpoDocumento("L.E.");
        hConductor3.setNroDocumento("16776068");
        hConductor3.setFecInicio("07/01/2016");
        hConductor3.setFecTermino("07/01/2016");
        hConductor3.setHorInicio("02:00");
        hConductor3.setHorTermino("06:00");


        hConductores.add(hConductor1);
        hConductores.add(hConductor2);
        hConductores.add(hConductor3);


//        ArrayOfHTripulante tripulantes = oHojaRuta.getTripulantes();
//        if(tripulantes==null) {
//            tripulantes = new ArrayOfHTripulante();
//            oHojaRuta.tripulantes = tripulantes;
//        }
//
//        List<HTripulante> hTripulantes = tripulantes.getHTripulante();
//
//
//        HTripulante hTripulante1 = new HTripulante();
//        hTripulante1.setTpoDocumento("L.E.");
//        hTripulante1.setNroDocumento("25725353");
//        hTripulantes.add(hTripulante1);


//        Tripulante oTripulante = new Tripulante();
//        oTripulante.setTpoDocumento("L.E.");
//        oTripulante.setNroDocumento("80317970");
//        oTripulante.setSeguridad(seguridad);
//        oTripulante.setNombre("Elmer ");
//        oTripulante.setApellido("Flores");
//        oTripulante.setSexo("Masculino");
//        oTripulante.setFecNac("06/11/1978");
//        ResultTripulante resultTripulante = mtcClient.setTripulante(oTripulante);
//
//
//        assertNull(resultTripulante.getErrores());
//        assertTrue(resultTripulante.isReturn());


        ResultHojaRuta resultHojaRuta = mtcClient.setHojaRuta(oHojaRuta);





        assertNull(resultHojaRuta.getErrores());
        System.out.println(resultHojaRuta.getCode());
        assertNotNull(resultHojaRuta.getCode());

    }
}
