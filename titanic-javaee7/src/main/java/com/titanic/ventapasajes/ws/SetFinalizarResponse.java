
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
 *         &lt;element name="setFinalizarResult" type="{http://wshr.mtc.gob.pe/}ResultFinalizar" minOccurs="0"/>
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
    "setFinalizarResult"
})
@XmlRootElement(name = "setFinalizarResponse")
public class SetFinalizarResponse {

    protected ResultFinalizar setFinalizarResult;

    /**
     * Gets the value of the setFinalizarResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultFinalizar }
     *     
     */
    public ResultFinalizar getSetFinalizarResult() {
        return setFinalizarResult;
    }

    /**
     * Sets the value of the setFinalizarResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultFinalizar }
     *     
     */
    public void setSetFinalizarResult(ResultFinalizar value) {
        this.setFinalizarResult = value;
    }

}
