
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
 *         &lt;element name="getIdentidadResult" type="{http://wshr.mtc.gob.pe/}ResultIdentidad" minOccurs="0"/>
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
    "getIdentidadResult"
})
@XmlRootElement(name = "getIdentidadResponse")
public class GetIdentidadResponse {

    protected ResultIdentidad getIdentidadResult;

    /**
     * Gets the value of the getIdentidadResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultIdentidad }
     *     
     */
    public ResultIdentidad getGetIdentidadResult() {
        return getIdentidadResult;
    }

    /**
     * Sets the value of the getIdentidadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultIdentidad }
     *     
     */
    public void setGetIdentidadResult(ResultIdentidad value) {
        this.getIdentidadResult = value;
    }

}
