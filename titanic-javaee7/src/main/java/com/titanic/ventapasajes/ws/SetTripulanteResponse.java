
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
 *         &lt;element name="setTripulanteResult" type="{http://wshr.mtc.gob.pe/}ResultTripulante" minOccurs="0"/>
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
    "setTripulanteResult"
})
@XmlRootElement(name = "setTripulanteResponse")
public class SetTripulanteResponse {

    protected ResultTripulante setTripulanteResult;

    /**
     * Gets the value of the setTripulanteResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultTripulante }
     *     
     */
    public ResultTripulante getSetTripulanteResult() {
        return setTripulanteResult;
    }

    /**
     * Sets the value of the setTripulanteResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultTripulante }
     *     
     */
    public void setSetTripulanteResult(ResultTripulante value) {
        this.setTripulanteResult = value;
    }

}
