
package com.titanic.ventapasajes.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMPasajero complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMPasajero">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MPasajero" type="{http://wshr.mtc.gob.pe/}MPasajero" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMPasajero", propOrder = {
    "mPasajero"
})
public class ArrayOfMPasajero {

    @XmlElement(name = "MPasajero", nillable = true)
    protected List<MPasajero> mPasajero;

    /**
     * Gets the value of the mPasajero property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mPasajero property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMPasajero().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MPasajero }
     * 
     * 
     */
    public List<MPasajero> getMPasajero() {
        if (mPasajero == null) {
            mPasajero = new ArrayList<MPasajero>();
        }
        return this.mPasajero;
    }

}
