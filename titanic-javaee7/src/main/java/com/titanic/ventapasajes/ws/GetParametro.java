
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
 *         &lt;element name="oParametro" type="{http://wshr.mtc.gob.pe/}Parametro" minOccurs="0"/>
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
    "oParametro"
})
@XmlRootElement(name = "getParametro")
public class GetParametro {

    protected Parametro oParametro;

    /**
     * Gets the value of the oParametro property.
     * 
     * @return
     *     possible object is
     *     {@link Parametro }
     *     
     */
    public Parametro getOParametro() {
        return oParametro;
    }

    /**
     * Sets the value of the oParametro property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parametro }
     *     
     */
    public void setOParametro(Parametro value) {
        this.oParametro = value;
    }

}
