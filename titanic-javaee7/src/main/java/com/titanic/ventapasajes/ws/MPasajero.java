
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MPasajero complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MPasajero">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TpoDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Paterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Materno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SerBol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumBol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MtoBol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AsiBol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MPasajero", propOrder = {
    "tpoDoc",
    "nroDoc",
    "nombre",
    "paterno",
    "materno",
    "serBol",
    "numBol",
    "mtoBol",
    "asiBol"
})
public class MPasajero {

    @XmlElement(name = "TpoDoc")
    protected String tpoDoc;
    @XmlElement(name = "NroDoc")
    protected String nroDoc;
    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "Paterno")
    protected String paterno;
    @XmlElement(name = "Materno")
    protected String materno;
    @XmlElement(name = "SerBol")
    protected String serBol;
    @XmlElement(name = "NumBol")
    protected String numBol;
    @XmlElement(name = "MtoBol")
    protected String mtoBol;
    @XmlElement(name = "AsiBol")
    protected String asiBol;

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

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the paterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     * Sets the value of the paterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaterno(String value) {
        this.paterno = value;
    }

    /**
     * Gets the value of the materno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * Sets the value of the materno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterno(String value) {
        this.materno = value;
    }

    /**
     * Gets the value of the serBol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerBol() {
        return serBol;
    }

    /**
     * Sets the value of the serBol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerBol(String value) {
        this.serBol = value;
    }

    /**
     * Gets the value of the numBol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumBol() {
        return numBol;
    }

    /**
     * Sets the value of the numBol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumBol(String value) {
        this.numBol = value;
    }

    /**
     * Gets the value of the mtoBol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMtoBol() {
        return mtoBol;
    }

    /**
     * Sets the value of the mtoBol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMtoBol(String value) {
        this.mtoBol = value;
    }

    /**
     * Gets the value of the asiBol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsiBol() {
        return asiBol;
    }

    /**
     * Sets the value of the asiBol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsiBol(String value) {
        this.asiBol = value;
    }

}
