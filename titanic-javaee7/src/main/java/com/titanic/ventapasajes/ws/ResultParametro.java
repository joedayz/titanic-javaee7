
package com.titanic.ventapasajes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultParametro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultParametro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Return" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Errores" type="{http://wshr.mtc.gob.pe/}ArrayOfErrores" minOccurs="0"/>
 *         &lt;element name="Rutas" type="{http://wshr.mtc.gob.pe/}ArrayOfRuta" minOccurs="0"/>
 *         &lt;element name="Terminales" type="{http://wshr.mtc.gob.pe/}ArrayOfTerminal" minOccurs="0"/>
 *         &lt;element name="Documentos" type="{http://wshr.mtc.gob.pe/}ArrayOfDocumento" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultParametro", propOrder = {
    "_return",
    "errores",
    "rutas",
    "terminales",
    "documentos"
})
public class ResultParametro {

    @XmlElement(name = "Return")
    protected boolean _return;
    @XmlElement(name = "Errores")
    protected ArrayOfErrores errores;
    @XmlElement(name = "Rutas")
    protected ArrayOfRuta rutas;
    @XmlElement(name = "Terminales")
    protected ArrayOfTerminal terminales;
    @XmlElement(name = "Documentos")
    protected ArrayOfDocumento documentos;

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

    /**
     * Gets the value of the rutas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRuta }
     *     
     */
    public ArrayOfRuta getRutas() {
        return rutas;
    }

    /**
     * Sets the value of the rutas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRuta }
     *     
     */
    public void setRutas(ArrayOfRuta value) {
        this.rutas = value;
    }

    /**
     * Gets the value of the terminales property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTerminal }
     *     
     */
    public ArrayOfTerminal getTerminales() {
        return terminales;
    }

    /**
     * Sets the value of the terminales property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTerminal }
     *     
     */
    public void setTerminales(ArrayOfTerminal value) {
        this.terminales = value;
    }

    /**
     * Gets the value of the documentos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDocumento }
     *     
     */
    public ArrayOfDocumento getDocumentos() {
        return documentos;
    }

    /**
     * Sets the value of the documentos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDocumento }
     *     
     */
    public void setDocumentos(ArrayOfDocumento value) {
        this.documentos = value;
    }

}
