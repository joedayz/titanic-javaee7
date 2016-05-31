
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Manifiesto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Manifiesto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Seguridad" type="{http://wshr.mtc.gob.pe/}Seguridad" minOccurs="0"/>
 *         &lt;element name="NroRuta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroPlaca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TerSalida" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TerLlegada" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FecSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HorSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FecEstLlegada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HorEstLlegada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Conductores" type="{http://wshr.mtc.gob.pe/}ArrayOfMConductor" minOccurs="0"/>
 *         &lt;element name="Tripulantes" type="{http://wshr.mtc.gob.pe/}ArrayOfMTripulante" minOccurs="0"/>
 *         &lt;element name="Pasajeros" type="{http://wshr.mtc.gob.pe/}ArrayOfMPasajero" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Manifiesto", propOrder = {
    "seguridad",
    "nroRuta",
    "nroPlaca",
    "terSalida",
    "terLlegada",
    "fecSalida",
    "horSalida",
    "fecEstLlegada",
    "horEstLlegada",
    "conductores",
    "tripulantes",
    "pasajeros"
})
public class Manifiesto {

    @XmlElement(name = "Seguridad")
    protected Seguridad seguridad;
    @XmlElement(name = "NroRuta")
    protected String nroRuta;
    @XmlElement(name = "NroPlaca")
    protected String nroPlaca;
    @XmlElement(name = "TerSalida")
    protected int terSalida;
    @XmlElement(name = "TerLlegada")
    protected int terLlegada;
    @XmlElement(name = "FecSalida")
    protected String fecSalida;
    @XmlElement(name = "HorSalida")
    protected String horSalida;
    @XmlElement(name = "FecEstLlegada")
    protected String fecEstLlegada;
    @XmlElement(name = "HorEstLlegada")
    protected String horEstLlegada;
    @XmlElement(name = "Conductores")
    protected ArrayOfMConductor conductores;
    @XmlElement(name = "Tripulantes")
    protected ArrayOfMTripulante tripulantes;
    @XmlElement(name = "Pasajeros")
    protected ArrayOfMPasajero pasajeros;

    /**
     * Gets the value of the seguridad property.
     * 
     * @return
     *     possible object is
     *     {@link Seguridad }
     *     
     */
    public Seguridad getSeguridad() {
        return seguridad;
    }

    /**
     * Sets the value of the seguridad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Seguridad }
     *     
     */
    public void setSeguridad(Seguridad value) {
        this.seguridad = value;
    }

    /**
     * Gets the value of the nroRuta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroRuta() {
        return nroRuta;
    }

    /**
     * Sets the value of the nroRuta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroRuta(String value) {
        this.nroRuta = value;
    }

    /**
     * Gets the value of the nroPlaca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroPlaca() {
        return nroPlaca;
    }

    /**
     * Sets the value of the nroPlaca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroPlaca(String value) {
        this.nroPlaca = value;
    }

    /**
     * Gets the value of the terSalida property.
     * 
     */
    public int getTerSalida() {
        return terSalida;
    }

    /**
     * Sets the value of the terSalida property.
     * 
     */
    public void setTerSalida(int value) {
        this.terSalida = value;
    }

    /**
     * Gets the value of the terLlegada property.
     * 
     */
    public int getTerLlegada() {
        return terLlegada;
    }

    /**
     * Sets the value of the terLlegada property.
     * 
     */
    public void setTerLlegada(int value) {
        this.terLlegada = value;
    }

    /**
     * Gets the value of the fecSalida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecSalida() {
        return fecSalida;
    }

    /**
     * Sets the value of the fecSalida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecSalida(String value) {
        this.fecSalida = value;
    }

    /**
     * Gets the value of the horSalida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHorSalida() {
        return horSalida;
    }

    /**
     * Sets the value of the horSalida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHorSalida(String value) {
        this.horSalida = value;
    }

    /**
     * Gets the value of the fecEstLlegada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecEstLlegada() {
        return fecEstLlegada;
    }

    /**
     * Sets the value of the fecEstLlegada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecEstLlegada(String value) {
        this.fecEstLlegada = value;
    }

    /**
     * Gets the value of the horEstLlegada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHorEstLlegada() {
        return horEstLlegada;
    }

    /**
     * Sets the value of the horEstLlegada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHorEstLlegada(String value) {
        this.horEstLlegada = value;
    }

    /**
     * Gets the value of the conductores property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMConductor }
     *     
     */
    public ArrayOfMConductor getConductores() {
        return conductores;
    }

    /**
     * Sets the value of the conductores property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMConductor }
     *     
     */
    public void setConductores(ArrayOfMConductor value) {
        this.conductores = value;
    }

    /**
     * Gets the value of the tripulantes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMTripulante }
     *     
     */
    public ArrayOfMTripulante getTripulantes() {
        return tripulantes;
    }

    /**
     * Sets the value of the tripulantes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMTripulante }
     *     
     */
    public void setTripulantes(ArrayOfMTripulante value) {
        this.tripulantes = value;
    }

    /**
     * Gets the value of the pasajeros property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMPasajero }
     *     
     */
    public ArrayOfMPasajero getPasajeros() {
        return pasajeros;
    }

    /**
     * Sets the value of the pasajeros property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMPasajero }
     *     
     */
    public void setPasajeros(ArrayOfMPasajero value) {
        this.pasajeros = value;
    }

}
