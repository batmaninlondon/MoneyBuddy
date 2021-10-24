
package org.datacontract.schemas._2004._07.starmfwebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImageResponseStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageResponseStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BSELMNDP_MFD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BSELMNDR_RFD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BSENONDP_MFI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BSENONDR_RFI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageResponseStatus", propOrder = {
    "bselmndpmfd",
    "bselmndrrfd",
    "bsenondpmfi",
    "bsenondrrfi"
})
public class ImageResponseStatus {

    @XmlElementRef(name = "BSELMNDP_MFD", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bselmndpmfd;
    @XmlElementRef(name = "BSELMNDR_RFD", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bselmndrrfd;
    @XmlElementRef(name = "BSENONDP_MFI", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bsenondpmfi;
    @XmlElementRef(name = "BSENONDR_RFI", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bsenondrrfi;

    /**
     * Gets the value of the bselmndpmfd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBSELMNDPMFD() {
        return bselmndpmfd;
    }

    /**
     * Sets the value of the bselmndpmfd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBSELMNDPMFD(JAXBElement<String> value) {
        this.bselmndpmfd = value;
    }

    /**
     * Gets the value of the bselmndrrfd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBSELMNDRRFD() {
        return bselmndrrfd;
    }

    /**
     * Sets the value of the bselmndrrfd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBSELMNDRRFD(JAXBElement<String> value) {
        this.bselmndrrfd = value;
    }

    /**
     * Gets the value of the bsenondpmfi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBSENONDPMFI() {
        return bsenondpmfi;
    }

    /**
     * Sets the value of the bsenondpmfi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBSENONDPMFI(JAXBElement<String> value) {
        this.bsenondpmfi = value;
    }

    /**
     * Gets the value of the bsenondrrfi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBSENONDRRFI() {
        return bsenondrrfi;
    }

    /**
     * Sets the value of the bsenondrrfi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBSENONDRRFI(JAXBElement<String> value) {
        this.bsenondrrfi = value;
    }

}
