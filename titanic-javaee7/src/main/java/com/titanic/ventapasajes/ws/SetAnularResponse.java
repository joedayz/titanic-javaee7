
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
 *         &lt;element name="setAnularResult" type="{http://wshr.mtc.gob.pe/}ResultAnular" minOccurs="0"/>
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
    "setAnularResult"
})
@XmlRootElement(name = "setAnularResponse")
public class SetAnularResponse {

    protected ResultAnular setAnularResult;

    /**
     * Gets the value of the setAnularResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultAnular }
     *     
     */
    public ResultAnular getSetAnularResult() {
        return setAnularResult;
    }

    /**
     * Sets the value of the setAnularResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultAnular }
     *     
     */
    public void setSetAnularResult(ResultAnular value) {
        this.setAnularResult = value;
    }

}
