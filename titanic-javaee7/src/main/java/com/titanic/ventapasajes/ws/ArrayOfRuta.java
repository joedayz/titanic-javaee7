
package com.titanic.ventapasajes.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRuta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRuta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ruta" type="{http://wshr.mtc.gob.pe/}Ruta" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRuta", propOrder = {
    "ruta"
})
public class ArrayOfRuta {

    @XmlElement(name = "Ruta", nillable = true)
    protected List<Ruta> ruta;

    /**
     * Gets the value of the ruta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ruta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRuta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ruta }
     * 
     * 
     */
    public List<Ruta> getRuta() {
        if (ruta == null) {
            ruta = new ArrayList<Ruta>();
        }
        return this.ruta;
    }

}
