
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
 *         &lt;element name="setHojaRutaResult" type="{http://wshr.mtc.gob.pe/}ResultHojaRuta" minOccurs="0"/>
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
    "setHojaRutaResult"
})
@XmlRootElement(name = "setHojaRutaResponse")
public class SetHojaRutaResponse {

    protected ResultHojaRuta setHojaRutaResult;

    /**
     * Gets the value of the setHojaRutaResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultHojaRuta }
     *     
     */
    public ResultHojaRuta getSetHojaRutaResult() {
        return setHojaRutaResult;
    }

    /**
     * Sets the value of the setHojaRutaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultHojaRuta }
     *     
     */
    public void setSetHojaRutaResult(ResultHojaRuta value) {
        this.setHojaRutaResult = value;
    }

}
