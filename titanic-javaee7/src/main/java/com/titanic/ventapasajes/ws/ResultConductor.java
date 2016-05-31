
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultConductor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultConductor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Return" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Errores" type="{http://wshr.mtc.gob.pe/}ArrayOfErrores" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultConductor", propOrder = {
    "_return",
    "errores"
})
public class ResultConductor {

    @XmlElement(name = "Return")
    protected boolean _return;
    @XmlElement(name = "Errores")
    protected ArrayOfErrores errores;

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
     *     {@link ArrayOfErrores }
     *     
     */
    public ArrayOfErrores getErrores() {
        return errores;
    }

    /**
     * Sets the value of the errores property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfErrores }
     *     
     */
    public void setErrores(ArrayOfErrores value) {
        this.errores = value;
    }

}
