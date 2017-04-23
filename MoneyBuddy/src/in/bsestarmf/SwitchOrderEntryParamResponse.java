
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
 *         &lt;element name="switchOrderEntryParamResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "switchOrderEntryParamResult"
})
@XmlRootElement(name = "switchOrderEntryParamResponse")
public class SwitchOrderEntryParamResponse {

    @XmlElementRef(name = "switchOrderEntryParamResult", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> switchOrderEntryParamResult;

    /**
     * Gets the value of the switchOrderEntryParamResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSwitchOrderEntryParamResult() {
        return switchOrderEntryParamResult;
    }

    /**
     * Sets the value of the switchOrderEntryParamResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSwitchOrderEntryParamResult(JAXBElement<String> value) {
        this.switchOrderEntryParamResult = value;
    }

}
