
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
 *         &lt;element name="TransCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FromSchemeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ToSchemeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuySell" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuySellType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DPTxn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SwitchUnits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AllUnitsFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FolioNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KYCStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubBrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EUIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EUINVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MinRedeem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IPAdd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PassKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Parma1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Param2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Param3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "transCode",
    "transNo",
    "orderId",
    "userId",
    "memberId",
    "clientCode",
    "fromSchemeCd",
    "toSchemeCd",
    "buySell",
    "buySellType",
    "dpTxn",
    "orderVal",
    "switchUnits",
    "allUnitsFlag",
    "folioNo",
    "remarks",
    "kycStatus",
    "subBrCode",
    "euin",
    "euinVal",
    "minRedeem",
    "ipAdd",
    "password",
    "passKey",
    "parma1",
    "param2",
    "param3"
})
@XmlRootElement(name = "switchOrderEntryParam")
public class SwitchOrderEntryParam {

    @XmlElementRef(name = "TransCode", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transCode;
    @XmlElementRef(name = "TransNo", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transNo;
    @XmlElementRef(name = "OrderId", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderId;
    @XmlElementRef(name = "UserId", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userId;
    @XmlElementRef(name = "MemberId", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> memberId;
    @XmlElementRef(name = "ClientCode", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> clientCode;
    @XmlElementRef(name = "FromSchemeCd", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fromSchemeCd;
    @XmlElementRef(name = "ToSchemeCd", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> toSchemeCd;
    @XmlElementRef(name = "BuySell", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> buySell;
    @XmlElementRef(name = "BuySellType", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> buySellType;
    @XmlElementRef(name = "DPTxn", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dpTxn;
    @XmlElementRef(name = "OrderVal", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderVal;
    @XmlElementRef(name = "SwitchUnits", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> switchUnits;
    @XmlElementRef(name = "AllUnitsFlag", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> allUnitsFlag;
    @XmlElementRef(name = "FolioNo", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> folioNo;
    @XmlElementRef(name = "Remarks", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remarks;
    @XmlElementRef(name = "KYCStatus", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> kycStatus;
    @XmlElementRef(name = "SubBrCode", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subBrCode;
    @XmlElementRef(name = "EUIN", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> euin;
    @XmlElementRef(name = "EUINVal", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> euinVal;
    @XmlElementRef(name = "MinRedeem", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> minRedeem;
    @XmlElementRef(name = "IPAdd", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ipAdd;
    @XmlElementRef(name = "Password", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> password;
    @XmlElementRef(name = "PassKey", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> passKey;
    @XmlElementRef(name = "Parma1", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> parma1;
    @XmlElementRef(name = "Param2", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> param2;
    @XmlElementRef(name = "Param3", namespace = "http://bsestarmf.in/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> param3;

    /**
     * Gets the value of the transCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransCode() {
        return transCode;
    }

    /**
     * Sets the value of the transCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransCode(JAXBElement<String> value) {
        this.transCode = value;
    }

    /**
     * Gets the value of the transNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransNo() {
        return transNo;
    }

    /**
     * Sets the value of the transNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransNo(JAXBElement<String> value) {
        this.transNo = value;
    }

    /**
     * Gets the value of the orderId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderId(JAXBElement<String> value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserId(JAXBElement<String> value) {
        this.userId = value;
    }

    /**
     * Gets the value of the memberId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMemberId(JAXBElement<String> value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the clientCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getClientCode() {
        return clientCode;
    }

    /**
     * Sets the value of the clientCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setClientCode(JAXBElement<String> value) {
        this.clientCode = value;
    }

    /**
     * Gets the value of the fromSchemeCd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFromSchemeCd() {
        return fromSchemeCd;
    }

    /**
     * Sets the value of the fromSchemeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFromSchemeCd(JAXBElement<String> value) {
        this.fromSchemeCd = value;
    }

    /**
     * Gets the value of the toSchemeCd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getToSchemeCd() {
        return toSchemeCd;
    }

    /**
     * Sets the value of the toSchemeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setToSchemeCd(JAXBElement<String> value) {
        this.toSchemeCd = value;
    }

    /**
     * Gets the value of the buySell property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBuySell() {
        return buySell;
    }

    /**
     * Sets the value of the buySell property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBuySell(JAXBElement<String> value) {
        this.buySell = value;
    }

    /**
     * Gets the value of the buySellType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBuySellType() {
        return buySellType;
    }

    /**
     * Sets the value of the buySellType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBuySellType(JAXBElement<String> value) {
        this.buySellType = value;
    }

    /**
     * Gets the value of the dpTxn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDPTxn() {
        return dpTxn;
    }

    /**
     * Sets the value of the dpTxn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDPTxn(JAXBElement<String> value) {
        this.dpTxn = value;
    }

    /**
     * Gets the value of the orderVal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderVal() {
        return orderVal;
    }

    /**
     * Sets the value of the orderVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderVal(JAXBElement<String> value) {
        this.orderVal = value;
    }

    /**
     * Gets the value of the switchUnits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSwitchUnits() {
        return switchUnits;
    }

    /**
     * Sets the value of the switchUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSwitchUnits(JAXBElement<String> value) {
        this.switchUnits = value;
    }

    /**
     * Gets the value of the allUnitsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAllUnitsFlag() {
        return allUnitsFlag;
    }

    /**
     * Sets the value of the allUnitsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAllUnitsFlag(JAXBElement<String> value) {
        this.allUnitsFlag = value;
    }

    /**
     * Gets the value of the folioNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFolioNo() {
        return folioNo;
    }

    /**
     * Sets the value of the folioNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFolioNo(JAXBElement<String> value) {
        this.folioNo = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemarks(JAXBElement<String> value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the kycStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKYCStatus() {
        return kycStatus;
    }

    /**
     * Sets the value of the kycStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKYCStatus(JAXBElement<String> value) {
        this.kycStatus = value;
    }

    /**
     * Gets the value of the subBrCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubBrCode() {
        return subBrCode;
    }

    /**
     * Sets the value of the subBrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubBrCode(JAXBElement<String> value) {
        this.subBrCode = value;
    }

    /**
     * Gets the value of the euin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEUIN() {
        return euin;
    }

    /**
     * Sets the value of the euin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEUIN(JAXBElement<String> value) {
        this.euin = value;
    }

    /**
     * Gets the value of the euinVal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEUINVal() {
        return euinVal;
    }

    /**
     * Sets the value of the euinVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEUINVal(JAXBElement<String> value) {
        this.euinVal = value;
    }

    /**
     * Gets the value of the minRedeem property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMinRedeem() {
        return minRedeem;
    }

    /**
     * Sets the value of the minRedeem property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMinRedeem(JAXBElement<String> value) {
        this.minRedeem = value;
    }

    /**
     * Gets the value of the ipAdd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIPAdd() {
        return ipAdd;
    }

    /**
     * Sets the value of the ipAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIPAdd(JAXBElement<String> value) {
        this.ipAdd = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassword(JAXBElement<String> value) {
        this.password = value;
    }

    /**
     * Gets the value of the passKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassKey() {
        return passKey;
    }

    /**
     * Sets the value of the passKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassKey(JAXBElement<String> value) {
        this.passKey = value;
    }

    /**
     * Gets the value of the parma1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParma1() {
        return parma1;
    }

    /**
     * Sets the value of the parma1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParma1(JAXBElement<String> value) {
        this.parma1 = value;
    }

    /**
     * Gets the value of the param2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParam2() {
        return param2;
    }

    /**
     * Sets the value of the param2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParam2(JAXBElement<String> value) {
        this.param2 = value;
    }

    /**
     * Gets the value of the param3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParam3() {
        return param3;
    }

    /**
     * Sets the value of the param3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParam3(JAXBElement<String> value) {
        this.param3 = value;
    }

}
