
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
 *         &lt;element name="oConductor" type="{http://wshr.mtc.gob.pe/}Conductor" minOccurs="0"/>
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
    "oConductor"
})
@XmlRootElement(name = "getConductor")
public class GetConductor {

    protected Conductor oConductor;

    /**
     * Gets the value of the oConductor property.
     * 
     * @return
     *     possible object is
     *     {@link Conductor }
     *     
     */
    public Conductor getOConductor() {
        return oConductor;
    }

    /**
     * Sets the value of the oConductor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Conductor }
     *     
     */
    public void setOConductor(Conductor value) {
        this.oConductor = value;
    }

}
