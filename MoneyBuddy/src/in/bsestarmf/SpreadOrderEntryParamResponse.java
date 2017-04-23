
package in.bsestarmf;

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
 *         &lt;element name="spreadOrderEntryParamResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "spreadOrderEntryParamResult"
})
@XmlRootElement(name = "spreadOrderEntryParamResponse")
public class SpreadOrderEntryParamResponse {

    @XmlElementRef(name = "spreadOrderEntryParamResult", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> spreadOrderEntryParamResult;

    /**
     * Gets the value of the spreadOrderEntryParamResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpreadOrderEntryParamResult() {
        return spreadOrderEntryParamResult;
    }

    /**
     * Sets the value of the spreadOrderEntryParamResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpreadOrderEntryParamResult(JAXBElement<String> value) {
        this.spreadOrderEntryParamResult = value;
    }

}
