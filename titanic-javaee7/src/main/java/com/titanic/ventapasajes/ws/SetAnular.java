
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
 *         &lt;element name="oAnular" type="{http://wshr.mtc.gob.pe/}Anular" minOccurs="0"/>
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
    "oAnular"
})
@XmlRootElement(name = "setAnular")
public class SetAnular {

    protected Anular oAnular;

    /**
     * Gets the value of the oAnular property.
     * 
     * @return
     *     possible object is
     *     {@link Anular }
     *     
     */
    public Anular getOAnular() {
        return oAnular;
    }

    /**
     * Sets the value of the oAnular property.
     * 
     * @param value
     *     allowed object is
     *     {@link Anular }
     *     
     */
    public void setOAnular(Anular value) {
        this.oAnular = value;
    }

}
