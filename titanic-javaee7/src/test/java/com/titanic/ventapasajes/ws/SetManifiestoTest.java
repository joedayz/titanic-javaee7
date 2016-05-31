package com.titanic.ventapasajes.ws;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by josediaz on 1/6/16.
 */
public class SetManifiestoTest {


    @Test
    public void debeCrearManifiesto() {


        WSServiciosHR mtc = new WSServiciosHR();
        WSServiciosHRSoap mtcClient = mtc.getWSServiciosHRSoap();


        Seguridad seguridad = new Seguridad();
        seguridad.setRuc("20301040301");
        seguridad.setUsuario("059956");
        seguridad.setClave("123456");
        seguridad.setPartida("000396PNR");


        Manifiesto oManifiesto = new Manifiesto();
        oManifiesto.setSeguridad(seguridad);
        oManifiesto.setNroRuta("0001");
        oManifiesto.setNroPlaca("A4F958");
        oManifiesto.setTerSalida(2593);
        oManifiesto.setTerLlegada(2591);
        oManifiesto.setFecSalida("06/01/2016");
        oManifiesto.setFecEstLlegada("07/01/2016");
        oManifiesto.setHorSalida("23:00");
        oManifiesto.setHorEstLlegada("11:00");


        ArrayOfMConductor conductores = oManifiesto.getConductores();
        if (conductores == null) {
            conductores = new ArrayOfMConductor();
            oManifiesto.conductores = conductores;
        }


        List<MConductor> mConductores = conductores.getMConductor();
        MConductor mConductor1 = new MConductor();
        mConductor1.setTpoDoc("L.E.");
        mConductor1.setNroDoc("16776068");
        mConductor1.setFecInicio("06/01/2016");
        mConductor1.setFecTermino("06/01/2016");
        mConductor1.setHorInicio("18:00");
        mConductor1.setHorTermino("22:00");

        MConductor mConductor2 = new MConductor();
        mConductor2.setTpoDoc("L.E.");
        mConductor2.setNroDoc("17633458");
        mConductor2.setFecInicio("06/01/2016");
        mConductor2.setFecTermino("07/01/2016");
        mConductor2.setHorInicio("22:00");
        mConductor2.setHorTermino("02:00");

        MConductor mConductor3 = new MConductor();
        mConductor3.setTpoDoc("L.E.");
        mConductor3.setNroDoc("16776068");
        mConductor3.setFecInicio("07/01/2016");
        mConductor3.setFecTermino("07/01/2016");
        mConductor3.setHorInicio("02:00");
        mConductor3.setHorTermino("06:00");


        mConductores.add(mConductor1);
        mConductores.add(mConductor2);
        mConductores.add(mConductor3);


        ArrayOfMPasajero pasajeros = oManifiesto.getPasajeros();
        if (pasajeros == null) {
            pasajeros = new ArrayOfMPasajero();
            oManifiesto.pasajeros = pasajeros;
        }

        List<MPasajero> mPasajeros = pasajeros.getMPasajero();


        MPasajero mPasajero1 = new MPasajero();
        mPasajero1.setTpoDoc("L.E.");
        mPasajero1.setNroDoc("41191089");
        mPasajero1.setNombre("Miryan");
        mPasajero1.setPaterno("Ramirez");
        mPasajero1.setMaterno("Ortega");
        mPasajero1.setSerBol("001");
        mPasajero1.setNumBol("003");
        mPasajero1.setMtoBol("90.00");
        mPasajero1.setAsiBol("15");

        MPasajero mPasajero2 = new MPasajero();
        mPasajero2.setTpoDoc("L.E.");
        mPasajero2.setNroDoc("77720867");
        mPasajero2.setNombre("Daniel");
        mPasajero2.setPaterno("Diaz");
        mPasajero2.setMaterno("Ramirez");
        mPasajero2.setSerBol("001");
        mPasajero2.setNumBol("004");
        mPasajero2.setMtoBol("90.00");
        mPasajero2.setAsiBol("16");

        mPasajeros.add(mPasajero1);
        mPasajeros.add(mPasajero2);


        ResultManifiesto resultManifiesto = mtcClient.setManifiesto(oManifiesto);




        assertNull(resultManifiesto.getErrores());
        System.out.println(resultManifiesto.getCode());
        assertNotNull(resultManifiesto.getCode());
    }
}
