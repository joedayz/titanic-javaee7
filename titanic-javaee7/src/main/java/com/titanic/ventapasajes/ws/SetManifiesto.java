
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
 *         &lt;element name="oManifiesto" type="{http://wshr.mtc.gob.pe/}Manifiesto" minOccurs="0"/>
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
    "oManifiesto"
})
@XmlRootElement(name = "setManifiesto")
public class SetManifiesto {

    protected Manifiesto oManifiesto;

    /**
     * Gets the value of the oManifiesto property.
     * 
     * @return
     *     possible object is
     *     {@link Manifiesto }
     *     
     */
    public Manifiesto getOManifiesto() {
        return oManifiesto;
    }

    /**
     * Sets the value of the oManifiesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Manifiesto }
     *     
     */
    public void setOManifiesto(Manifiesto value) {
        this.oManifiesto = value;
    }

}
