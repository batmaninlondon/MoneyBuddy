
package org.datacontract.schemas._2004._07.starmfwebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AOFPanSearchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AOFPanSearchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BSERemarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageResponseStatus" type="{http://schemas.datacontract.org/2004/07/StarMFWebService}ImageResponseStatus" minOccurs="0"/>
 *         &lt;element name="imageUploadStatus" type="{http://schemas.datacontract.org/2004/07/StarMFWebService}ImageUploadStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AOFPanSearchResponse", propOrder = {
    "bseRemarks",
    "pan",
    "status",
    "imageResponseStatus",
    "imageUploadStatus"
})
public class AOFPanSearchResponse {

    @XmlElementRef(name = "BSERemarks", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bseRemarks;
    @XmlElementRef(name = "PAN", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pan;
    @XmlElementRef(name = "Status", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "imageResponseStatus", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ImageResponseStatus> imageResponseStatus;
    @XmlElementRef(name = "imageUploadStatus", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ImageUploadStatus> imageUploadStatus;

    /**
     * Gets the value of the bseRemarks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBSERemarks() {
        return bseRemarks;
    }

    /**
     * Sets the value of the bseRemarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBSERemarks(JAXBElement<String> value) {
        this.bseRemarks = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPAN(JAXBElement<String> value) {
        this.pan = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

    /**
     * Gets the value of the imageResponseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ImageResponseStatus }{@code >}
     *     
     */
    public JAXBElement<ImageResponseStatus> getImageResponseStatus() {
        return imageResponseStatus;
    }

    /**
     * Sets the value of the imageResponseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ImageResponseStatus }{@code >}
     *     
     */
    public void setImageResponseStatus(JAXBElement<ImageResponseStatus> value) {
        this.imageResponseStatus = value;
    }

    /**
     * Gets the value of the imageUploadStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ImageUploadStatus }{@code >}
     *     
     */
    public JAXBElement<ImageUploadStatus> getImageUploadStatus() {
        return imageUploadStatus;
    }

    /**
     * Sets the value of the imageUploadStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ImageUploadStatus }{@code >}
     *     
     */
    public void setImageUploadStatus(JAXBElement<ImageUploadStatus> value) {
        this.imageUploadStatus = value;
    }

}
