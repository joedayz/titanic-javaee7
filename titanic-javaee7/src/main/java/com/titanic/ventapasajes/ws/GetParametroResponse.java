
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
 *         &lt;element name="getParametroResult" type="{http://wshr.mtc.gob.pe/}ResultParametro" minOccurs="0"/>
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
    "getParametroResult"
})
@XmlRootElement(name = "getParametroResponse")
public class GetParametroResponse {

    protected ResultParametro getParametroResult;

    /**
     * Gets the value of the getParametroResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultParametro }
     *     
     */
    public ResultParametro getGetParametroResult() {
        return getParametroResult;
    }

    /**
     * Sets the value of the getParametroResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultParametro }
     *     
     */
    public void setGetParametroResult(ResultParametro value) {
        this.getParametroResult = value;
    }

}
