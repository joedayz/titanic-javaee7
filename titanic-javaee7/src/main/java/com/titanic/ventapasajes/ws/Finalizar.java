
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Finalizar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Finalizar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Seguridad" type="{http://wshr.mtc.gob.pe/}Seguridad" minOccurs="0"/>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FecLlegada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HorLlegada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Finalizar", propOrder = {
    "seguridad",
    "code",
    "fecLlegada",
    "horLlegada"
})
public class Finalizar {

    @XmlElement(name = "Seguridad")
    protected Seguridad seguridad;
    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "FecLlegada")
    protected String fecLlegada;
    @XmlElement(name = "HorLlegada")
    protected String horLlegada;

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
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the fecLlegada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecLlegada() {
        return fecLlegada;
    }

    /**
     * Sets the value of the fecLlegada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecLlegada(String value) {
        this.fecLlegada = value;
    }

    /**
     * Gets the value of the horLlegada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHorLlegada() {
        return horLlegada;
    }

    /**
     * Sets the value of the horLlegada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHorLlegada(String value) {
        this.horLlegada = value;
    }

}
