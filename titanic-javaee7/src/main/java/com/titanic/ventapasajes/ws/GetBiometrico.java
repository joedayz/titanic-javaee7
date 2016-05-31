
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
 *         &lt;element name="oBiometrico" type="{http://wshr.mtc.gob.pe/}Biometrico" minOccurs="0"/>
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
    "oBiometrico"
})
@XmlRootElement(name = "getBiometrico")
public class GetBiometrico {

    protected Biometrico oBiometrico;

    /**
     * Gets the value of the oBiometrico property.
     * 
     * @return
     *     possible object is
     *     {@link Biometrico }
     *     
     */
    public Biometrico getOBiometrico() {
        return oBiometrico;
    }

    /**
     * Sets the value of the oBiometrico property.
     * 
     * @param value
     *     allowed object is
     *     {@link Biometrico }
     *     
     */
    public void setOBiometrico(Biometrico value) {
        this.oBiometrico = value;
    }

}
