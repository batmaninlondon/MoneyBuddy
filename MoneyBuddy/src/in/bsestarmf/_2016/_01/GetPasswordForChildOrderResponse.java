
package in.bsestarmf._2016._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.datacontract.schemas._2004._07.starmfwebservice.Response;


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
 *         &lt;element name="GetPasswordForChildOrderResult" type="{http://schemas.datacontract.org/2004/07/StarMFWebService}Response" minOccurs="0"/>
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
    "getPasswordForChildOrderResult"
})
@XmlRootElement(name = "GetPasswordForChildOrderResponse")
public class GetPasswordForChildOrderResponse {

    @XmlElementRef(name = "GetPasswordForChildOrderResult", namespace = "http://www.bsestarmf.in/2016/01/", type = JAXBElement.class, required = false)
    protected JAXBElement<Response> getPasswordForChildOrderResult;

    /**
     * Gets the value of the getPasswordForChildOrderResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Response }{@code >}
     *     
     */
    public JAXBElement<Response> getGetPasswordForChildOrderResult() {
        return getPasswordForChildOrderResult;
    }

    /**
     * Sets the value of the getPasswordForChildOrderResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Response }{@code >}
     *     
     */
    public void setGetPasswordForChildOrderResult(JAXBElement<Response> value) {
        this.getPasswordForChildOrderResult = value;
    }

}
