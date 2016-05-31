
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
 *         &lt;element name="getConductorResult" type="{http://wshr.mtc.gob.pe/}ResultConductor" minOccurs="0"/>
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
    "getConductorResult"
})
@XmlRootElement(name = "getConductorResponse")
public class GetConductorResponse {

    protected ResultConductor getConductorResult;

    /**
     * Gets the value of the getConductorResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultConductor }
     *     
     */
    public ResultConductor getGetConductorResult() {
        return getConductorResult;
    }

    /**
     * Sets the value of the getConductorResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultConductor }
     *     
     */
    public void setGetConductorResult(ResultConductor value) {
        this.getConductorResult = value;
    }

}
