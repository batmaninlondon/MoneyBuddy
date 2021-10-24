
package in.bsestarmf._2016._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EMandateAuthURLResult" type="{http://schemas.datacontract.org/2004/07/StarMFWebService}EMandateAuthURLResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "eMandateAuthURLResult"
})
@XmlRootElement(name = "EMandateAuthURLResponse")
public class EMandateAuthURLResponse {

    @XmlElementRef(name = "EMandateAuthURLResult", namespace = "http://www.bsestarmf.in/2016/01/", type = JAXBElement.class, required = false)
    protected JAXBElement<org.datacontract.schemas._2004._07.starmfwebservice.EMandateAuthURLResponse> eMandateAuthURLResult;

    /**
     * Gets the value of the eMandateAuthURLResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.starmfwebservice.EMandateAuthURLResponse }{@code >}
     *     
     */
    public JAXBElement<org.datacontract.schemas._2004._07.starmfwebservice.EMandateAuthURLResponse> getEMandateAuthURLResult() {
        return eMandateAuthURLResult;
    }

    /**
     * Sets the value of the eMandateAuthURLResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.starmfwebservice.EMandateAuthURLResponse }{@code >}
     *     
     */
    public void setEMandateAuthURLResult(JAXBElement<org.datacontract.schemas._2004._07.starmfwebservice.EMandateAuthURLResponse> value) {
        this.eMandateAuthURLResult = value;
    }

}
