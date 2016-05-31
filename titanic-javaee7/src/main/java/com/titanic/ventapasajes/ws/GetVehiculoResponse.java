
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
 *         &lt;element name="getVehiculoResult" type="{http://wshr.mtc.gob.pe/}ResultVehiculo" minOccurs="0"/>
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
    "getVehiculoResult"
})
@XmlRootElement(name = "getVehiculoResponse")
public class GetVehiculoResponse {

    protected ResultVehiculo getVehiculoResult;

    /**
     * Gets the value of the getVehiculoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultVehiculo }
     *     
     */
    public ResultVehiculo getGetVehiculoResult() {
        return getVehiculoResult;
    }

    /**
     * Sets the value of the getVehiculoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultVehiculo }
     *     
     */
    public void setGetVehiculoResult(ResultVehiculo value) {
        this.getVehiculoResult = value;
    }

}
