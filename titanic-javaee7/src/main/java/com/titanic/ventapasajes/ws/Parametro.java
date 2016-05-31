
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Parametro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Parametro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Seguridad" type="{http://wshr.mtc.gob.pe/}Seguridad" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parametro", propOrder = {
    "seguridad"
})
public class Parametro {

    @XmlElement(name = "Seguridad")
    protected Seguridad seguridad;

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

}
