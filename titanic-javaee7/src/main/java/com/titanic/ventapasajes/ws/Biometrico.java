
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Biometrico complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Biometrico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Seguridad" type="{http://wshr.mtc.gob.pe/}Seguridad" minOccurs="0"/>
 *         &lt;element name="NroEmp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HueDer" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Biometrico", propOrder = {
    "seguridad",
    "nroEmp",
    "nroDoc",
    "hueDer"
})
public class Biometrico {

    @XmlElement(name = "Seguridad")
    protected Seguridad seguridad;
    @XmlElement(name = "NroEmp")
    protected String nroEmp;
    @XmlElement(name = "NroDoc")
    protected String nroDoc;
    @XmlElement(name = "HueDer")
    protected byte[] hueDer;

    /**
     * Gets the value of the seguridad property.
     * 
     * @return
     *     possible object is
     *     {@link Seguridad }
     *     
     */
    public Seguridad getSeguridad() {
        return seguridad;
    }

    /**
     * Sets the value of the seguridad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Seguridad }
     *     
     */
    public void setSeguridad(Seguridad value) {
        this.seguridad = value;
    }

    /**
     * Gets the value of the nroEmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroEmp() {
        return nroEmp;
    }

    /**
     * Sets the value of the nroEmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroEmp(String value) {
        this.nroEmp = value;
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

    /**
     * Gets the value of the hueDer property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getHueDer() {
        return hueDer;
    }

    /**
     * Sets the value of the hueDer property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setHueDer(byte[] value) {
        this.hueDer = value;
    }

}
