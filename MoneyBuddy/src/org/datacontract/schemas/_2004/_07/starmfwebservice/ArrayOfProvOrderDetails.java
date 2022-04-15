
package org.datacontract.schemas._2004._07.starmfwebservice;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProvOrderDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProvOrderDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProvOrderDetails" type="{http://schemas.datacontract.org/2004/07/StarMFWebService}ProvOrderDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProvOrderDetails", propOrder = {
    "provOrderDetails"
})
public class ArrayOfProvOrderDetails {

    @XmlElement(name = "ProvOrderDetails", nillable = true)
    protected List<ProvOrderDetails> provOrderDetails;

    /**
     * Gets the value of the provOrderDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the provOrderDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProvOrderDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProvOrderDetails }
     * 
     * 
     */
    public List<ProvOrderDetails> getProvOrderDetails() {
        if (provOrderDetails == null) {
            provOrderDetails = new ArrayList<ProvOrderDetails>();
        }
        return this.provOrderDetails;
    }

}
