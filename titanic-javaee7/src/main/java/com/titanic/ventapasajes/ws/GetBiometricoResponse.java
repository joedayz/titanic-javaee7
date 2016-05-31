
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
 *         &lt;element name="getBiometricoResult" type="{http://wshr.mtc.gob.pe/}ResultBiometrico" minOccurs="0"/>
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
    "getBiometricoResult"
})
@XmlRootElement(name = "getBiometricoResponse")
public class GetBiometricoResponse {

    protected ResultBiometrico getBiometricoResult;

    /**
     * Gets the value of the getBiometricoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultBiometrico }
     *     
     */
    public ResultBiometrico getGetBiometricoResult() {
        return getBiometricoResult;
    }

    /**
     * Sets the value of the getBiometricoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultBiometrico }
     *     
     */
    public void setGetBiometricoResult(ResultBiometrico value) {
        this.getBiometricoResult = value;
    }

}
