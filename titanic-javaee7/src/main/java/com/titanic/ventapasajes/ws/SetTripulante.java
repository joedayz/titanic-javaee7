
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oTripulante" type="{http://wshr.mtc.gob.pe/}Tripulante" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "oTripulante"
})
@XmlRootElement(name = "setTripulante")
public class SetTripulante {

    protected Tripulante oTripulante;

    /**
     * Gets the value of the oTripulante property.
     * 
     * @return
     *     possible object is
     *     {@link Tripulante }
     *     
     */
    public Tripulante getOTripulante() {
        return oTripulante;
    }

    /**
     * Sets the value of the oTripulante property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tripulante }
     *     
     */
    public void setOTripulante(Tripulante value) {
        this.oTripulante = value;
    }

}
