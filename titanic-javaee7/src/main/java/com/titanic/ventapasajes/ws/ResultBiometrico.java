
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultBiometrico complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultBiometrico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Return" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Errores" type="{http://wshr.mtc.gob.pe/}Errores" minOccurs="0"/>
 *         &lt;element name="Exception" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultBiometrico", propOrder = {
    "_return",
    "errores",
    "exception"
})
public class ResultBiometrico {

    @XmlElement(name = "Return")
    protected boolean _return;
    @XmlElement(name = "Errores")
    protected Errores errores;
    @XmlElement(name = "Exception")
    protected boolean exception;

    /**
     * Gets the value of the return property.
     * 
     */
    public boolean isReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     */
    public void setReturn(boolean value) {
        this._return = value;
    }

    /**
     * Gets the value of the errores property.
     * 
     * @return
     *     possible object is
     *     {@link Errores }
     *     
     */
    public Errores getErrores() {
        return errores;
    }

    /**
     * Sets the value of the errores property.
     * 
     * @param value
     *     allowed object is
     *     {@link Errores }
     *     
     */
    public void setErrores(Errores value) {
        this.errores = value;
    }

    /**
     * Gets the value of the exception property.
     * 
     */
    public boolean isException() {
        return exception;
    }

    /**
     * Sets the value of the exception property.
     * 
     */
    public void setException(boolean value) {
        this.exception = value;
    }

}
