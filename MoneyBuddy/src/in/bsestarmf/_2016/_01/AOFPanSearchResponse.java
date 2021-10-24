
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
 *         &lt;element name="AOFPanSearchResult" type="{http://schemas.datacontract.org/2004/07/StarMFWebService}AOFPanSearchResponse" minOccurs="0"/>
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
    "aofPanSearchResult"
})
@XmlRootElement(name = "AOFPanSearchResponse")
public class AOFPanSearchResponse {

    @XmlElementRef(name = "AOFPanSearchResult", namespace = "http://www.bsestarmf.in/2016/01/", type = JAXBElement.class, required = false)
    protected JAXBElement<org.datacontract.schemas._2004._07.starmfwebservice.AOFPanSearchResponse> aofPanSearchResult;

    /**
     * Gets the value of the aofPanSearchResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.starmfwebservice.AOFPanSearchResponse }{@code >}
     *     
     */
    public JAXBElement<org.datacontract.schemas._2004._07.starmfwebservice.AOFPanSearchResponse> getAOFPanSearchResult() {
        return aofPanSearchResult;
    }

    /**
     * Sets the value of the aofPanSearchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.starmfwebservice.AOFPanSearchResponse }{@code >}
     *     
     */
    public void setAOFPanSearchResult(JAXBElement<org.datacontract.schemas._2004._07.starmfwebservice.AOFPanSearchResponse> value) {
        this.aofPanSearchResult = value;
    }

}
