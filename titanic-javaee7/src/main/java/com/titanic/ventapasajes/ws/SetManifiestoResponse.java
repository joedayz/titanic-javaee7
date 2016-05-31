
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
 *         &lt;element name="setManifiestoResult" type="{http://wshr.mtc.gob.pe/}ResultManifiesto" minOccurs="0"/>
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
    "setManifiestoResult"
})
@XmlRootElement(name = "setManifiestoResponse")
public class SetManifiestoResponse {

    protected ResultManifiesto setManifiestoResult;

    /**
     * Gets the value of the setManifiestoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultManifiesto }
     *     
     */
    public ResultManifiesto getSetManifiestoResult() {
        return setManifiestoResult;
    }

    /**
     * Sets the value of the setManifiestoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultManifiesto }
     *     
     */
    public void setSetManifiestoResult(ResultManifiesto value) {
        this.setManifiestoResult = value;
    }

}
