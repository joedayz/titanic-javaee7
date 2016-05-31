
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MConductor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MConductor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TpoDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FecInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HorInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FecTermino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HorTermino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MConductor", propOrder = {
    "tpoDoc",
    "nroDoc",
    "fecInicio",
    "horInicio",
    "fecTermino",
    "horTermino"
})
public class MConductor {

    @XmlElement(name = "TpoDoc")
    protected String tpoDoc;
    @XmlElement(name = "NroDoc")
    protected String nroDoc;
    @XmlElement(name = "FecInicio")
    protected String fecInicio;
    @XmlElement(name = "HorInicio")
    protected String horInicio;
    @XmlElement(name = "FecTermino")
    protected String fecTermino;
    @XmlElement(name = "HorTermino")
    protected String horTermino;

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
     * Gets the value of the fecInicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecInicio() {
        return fecInicio;
    }

    /**
     * Sets the value of the fecInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecInicio(String value) {
        this.fecInicio = value;
    }

    /**
     * Gets the value of the horInicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHorInicio() {
        return horInicio;
    }

    /**
     * Sets the value of the horInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHorInicio(String value) {
        this.horInicio = value;
    }

    /**
     * Gets the value of the fecTermino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecTermino() {
        return fecTermino;
    }

    /**
     * Sets the value of the fecTermino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecTermino(String value) {
        this.fecTermino = value;
    }

    /**
     * Gets the value of the horTermino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHorTermino() {
        return horTermino;
    }

    /**
     * Sets the value of the horTermino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHorTermino(String value) {
        this.horTermino = value;
    }

}
