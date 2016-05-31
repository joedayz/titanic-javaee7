
package com.titanic.ventapasajes.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMTripulante complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMTripulante">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MTripulante" type="{http://wshr.mtc.gob.pe/}MTripulante" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMTripulante", propOrder = {
    "mTripulante"
})
public class ArrayOfMTripulante {

    @XmlElement(name = "MTripulante", nillable = true)
    protected List<MTripulante> mTripulante;

    /**
     * Gets the value of the mTripulante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mTripulante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMTripulante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MTripulante }
     * 
     * 
     */
    public List<MTripulante> getMTripulante() {
        if (mTripulante == null) {
            mTripulante = new ArrayList<MTripulante>();
        }
        return this.mTripulante;
    }

}
