
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MTripulante complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MTripulante">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TpoDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MTripulante", propOrder = {
    "tpoDoc",
    "nroDoc"
})
public class MTripulante {

    @XmlElement(name = "TpoDoc")
    protected String tpoDoc;
    @XmlElement(name = "NroDoc")
    protected String nroDoc;

    /**
     * Gets the value of the tpoDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpoDoc() {
        return tpoDoc;
    }

    /**
     * Sets the value of the tpoDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpoDoc(String value) {
        this.tpoDoc = value;
    }

    /**
     * Gets the value of the nroDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroDoc() {
        return nroDoc;
    }

    /**
     * Sets the value of the nroDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroDoc(String value) {
        this.nroDoc = value;
    }

}
