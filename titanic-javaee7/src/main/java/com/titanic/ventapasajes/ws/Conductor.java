
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Conductor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Conductor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Seguridad" type="{http://wshr.mtc.gob.pe/}Seguridad" minOccurs="0"/>
 *         &lt;element name="TpoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Conductor", propOrder = {
    "seguridad",
    "tpoDocumento",
    "nroDocumento"
})
public class Conductor {

    @XmlElement(name = "Seguridad")
    protected Seguridad seguridad;
    @XmlElement(name = "TpoDocumento")
    protected String tpoDocumento;
    @XmlElement(name = "NroDocumento")
    protected String nroDocumento;

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
     * Gets the value of the tpoDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpoDocumento() {
        return tpoDocumento;
    }

    /**
     * Sets the value of the tpoDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpoDocumento(String value) {
        this.tpoDocumento = value;
    }

    /**
     * Gets the value of the nroDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroDocumento() {
        return nroDocumento;
    }

    /**
     * Sets the value of the nroDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroDocumento(String value) {
        this.nroDocumento = value;
    }

}
