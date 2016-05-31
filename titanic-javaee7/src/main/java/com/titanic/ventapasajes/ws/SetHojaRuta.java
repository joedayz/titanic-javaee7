
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
 *         &lt;element name="oHojaRuta" type="{http://wshr.mtc.gob.pe/}HojaRuta" minOccurs="0"/>
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
    "oHojaRuta"
})
@XmlRootElement(name = "setHojaRuta")
public class SetHojaRuta {

    protected HojaRuta oHojaRuta;

    /**
     * Gets the value of the oHojaRuta property.
     * 
     * @return
     *     possible object is
     *     {@link HojaRuta }
     *     
     */
    public HojaRuta getOHojaRuta() {
        return oHojaRuta;
    }

    /**
     * Sets the value of the oHojaRuta property.
     * 
     * @param value
     *     allowed object is
     *     {@link HojaRuta }
     *     
     */
    public void setOHojaRuta(HojaRuta value) {
        this.oHojaRuta = value;
    }

}
