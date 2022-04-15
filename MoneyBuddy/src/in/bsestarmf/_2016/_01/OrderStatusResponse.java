
package in.bsestarmf._2016._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.datacontract.schemas._2004._07.starmfwebservice.OrderResponse;


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
 *         &lt;element name="OrderStatusResult" type="{http://schemas.datacontract.org/2004/07/StarMFWebService}OrderResponse" minOccurs="0"/>
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
    "orderStatusResult"
})
@XmlRootElement(name = "OrderStatusResponse")
public class OrderStatusResponse {

    @XmlElementRef(name = "OrderStatusResult", namespace = "http://www.bsestarmf.in/2016/01/", type = JAXBElement.class, required = false)
    protected JAXBElement<OrderResponse> orderStatusResult;

    /**
     * Gets the value of the orderStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrderResponse }{@code >}
     *     
     */
    public JAXBElement<OrderResponse> getOrderStatusResult() {
        return orderStatusResult;
    }

    /**
     * Sets the value of the orderStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrderResponse }{@code >}
     *     
     */
    public void setOrderStatusResult(JAXBElement<OrderResponse> value) {
        this.orderStatusResult = value;
    }

}
