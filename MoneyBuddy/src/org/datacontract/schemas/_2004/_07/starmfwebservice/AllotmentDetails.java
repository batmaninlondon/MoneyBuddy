
package org.datacontract.schemas._2004._07.starmfwebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AllotmentDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AllotmentDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AllottedAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AllottedNav" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AllottedUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BeneficiaryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DPCFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DPTrans" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EUIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EUINDecl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FolioNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InternalRefNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KYCFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemberCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Qty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RTASchemeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RTATransNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIPRegnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIPRegnNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SchemeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubBrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubOrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllotmentDetails", propOrder = {
    "allottedAmt",
    "allottedNav",
    "allottedUnit",
    "amount",
    "beneficiaryId",
    "branchCode",
    "clientCode",
    "clientName",
    "dpcFlag",
    "dpTrans",
    "euin",
    "euinDecl",
    "folioNo",
    "isin",
    "internalRefNo",
    "kycFlag",
    "memberCode",
    "orderDate",
    "orderNo",
    "orderType",
    "qty",
    "rtaSchemeCode",
    "rtaTransNo",
    "remarks",
    "reportDate",
    "sipRegnDate",
    "sipRegnNo",
    "stt",
    "schemeCode",
    "settNo",
    "settType",
    "subBrCode",
    "subOrderType",
    "userId",
    "validFlag"
})
public class AllotmentDetails {

    @XmlElementRef(name = "AllottedAmt", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> allottedAmt;
    @XmlElementRef(name = "AllottedNav", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> allottedNav;
    @XmlElementRef(name = "AllottedUnit", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> allottedUnit;
    @XmlElementRef(name = "Amount", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> amount;
    @XmlElementRef(name = "BeneficiaryId", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficiaryId;
    @XmlElementRef(name = "BranchCode", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> branchCode;
    @XmlElementRef(name = "ClientCode", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> clientCode;
    @XmlElementRef(name = "ClientName", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> clientName;
    @XmlElementRef(name = "DPCFlag", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dpcFlag;
    @XmlElementRef(name = "DPTrans", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dpTrans;
    @XmlElementRef(name = "EUIN", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> euin;
    @XmlElementRef(name = "EUINDecl", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> euinDecl;
    @XmlElementRef(name = "FolioNo", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> folioNo;
    @XmlElementRef(name = "ISIN", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isin;
    @XmlElementRef(name = "InternalRefNo", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> internalRefNo;
    @XmlElementRef(name = "KYCFlag", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> kycFlag;
    @XmlElementRef(name = "MemberCode", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> memberCode;
    @XmlElementRef(name = "OrderDate", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderDate;
    @XmlElementRef(name = "OrderNo", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderNo;
    @XmlElementRef(name = "OrderType", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderType;
    @XmlElementRef(name = "Qty", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> qty;
    @XmlElementRef(name = "RTASchemeCode", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rtaSchemeCode;
    @XmlElementRef(name = "RTATransNo", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rtaTransNo;
    @XmlElementRef(name = "Remarks", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remarks;
    @XmlElementRef(name = "ReportDate", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportDate;
    @XmlElementRef(name = "SIPRegnDate", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sipRegnDate;
    @XmlElementRef(name = "SIPRegnNo", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sipRegnNo;
    @XmlElementRef(name = "STT", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stt;
    @XmlElementRef(name = "SchemeCode", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> schemeCode;
    @XmlElementRef(name = "SettNo", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> settNo;
    @XmlElementRef(name = "SettType", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> settType;
    @XmlElementRef(name = "SubBrCode", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subBrCode;
    @XmlElementRef(name = "SubOrderType", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subOrderType;
    @XmlElementRef(name = "UserId", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userId;
    @XmlElementRef(name = "ValidFlag", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> validFlag;

    /**
     * Gets the value of the allottedAmt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAllottedAmt() {
        return allottedAmt;
    }

    /**
     * Sets the value of the allottedAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAllottedAmt(JAXBElement<String> value) {
        this.allottedAmt = value;
    }

    /**
     * Gets the value of the allottedNav property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAllottedNav() {
        return allottedNav;
    }

    /**
     * Sets the value of the allottedNav property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAllottedNav(JAXBElement<String> value) {
        this.allottedNav = value;
    }

    /**
     * Gets the value of the allottedUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAllottedUnit() {
        return allottedUnit;
    }

    /**
     * Sets the value of the allottedUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAllottedUnit(JAXBElement<String> value) {
        this.allottedUnit = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAmount(JAXBElement<String> value) {
        this.amount = value;
    }

    /**
     * Gets the value of the beneficiaryId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficiaryId() {
        return beneficiaryId;
    }

    /**
     * Sets the value of the beneficiaryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficiaryId(JAXBElement<String> value) {
        this.beneficiaryId = value;
    }

    /**
     * Gets the value of the branchCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBranchCode() {
        return branchCode;
    }

    /**
     * Sets the value of the branchCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBranchCode(JAXBElement<String> value) {
        this.branchCode = value;
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
     * Gets the value of the clientName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getClientName() {
        return clientName;
    }

    /**
     * Sets the value of the clientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setClientName(JAXBElement<String> value) {
        this.clientName = value;
    }

    /**
     * Gets the value of the dpcFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDPCFlag() {
        return dpcFlag;
    }

    /**
     * Sets the value of the dpcFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDPCFlag(JAXBElement<String> value) {
        this.dpcFlag = value;
    }

    /**
     * Gets the value of the dpTrans property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDPTrans() {
        return dpTrans;
    }

    /**
     * Sets the value of the dpTrans property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDPTrans(JAXBElement<String> value) {
        this.dpTrans = value;
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
     * Gets the value of the euinDecl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEUINDecl() {
        return euinDecl;
    }

    /**
     * Sets the value of the euinDecl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEUINDecl(JAXBElement<String> value) {
        this.euinDecl = value;
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
     * Gets the value of the isin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getISIN() {
        return isin;
    }

    /**
     * Sets the value of the isin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setISIN(JAXBElement<String> value) {
        this.isin = value;
    }

    /**
     * Gets the value of the internalRefNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInternalRefNo() {
        return internalRefNo;
    }

    /**
     * Sets the value of the internalRefNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInternalRefNo(JAXBElement<String> value) {
        this.internalRefNo = value;
    }

    /**
     * Gets the value of the kycFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKYCFlag() {
        return kycFlag;
    }

    /**
     * Sets the value of the kycFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKYCFlag(JAXBElement<String> value) {
        this.kycFlag = value;
    }

    /**
     * Gets the value of the memberCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMemberCode() {
        return memberCode;
    }

    /**
     * Sets the value of the memberCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMemberCode(JAXBElement<String> value) {
        this.memberCode = value;
    }

    /**
     * Gets the value of the orderDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the value of the orderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderDate(JAXBElement<String> value) {
        this.orderDate = value;
    }

    /**
     * Gets the value of the orderNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderNo() {
        return orderNo;
    }

    /**
     * Sets the value of the orderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderNo(JAXBElement<String> value) {
        this.orderNo = value;
    }

    /**
     * Gets the value of the orderType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderType() {
        return orderType;
    }

    /**
     * Sets the value of the orderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderType(JAXBElement<String> value) {
        this.orderType = value;
    }

    /**
     * Gets the value of the qty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQty() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQty(JAXBElement<String> value) {
        this.qty = value;
    }

    /**
     * Gets the value of the rtaSchemeCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRTASchemeCode() {
        return rtaSchemeCode;
    }

    /**
     * Sets the value of the rtaSchemeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRTASchemeCode(JAXBElement<String> value) {
        this.rtaSchemeCode = value;
    }

    /**
     * Gets the value of the rtaTransNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRTATransNo() {
        return rtaTransNo;
    }

    /**
     * Sets the value of the rtaTransNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRTATransNo(JAXBElement<String> value) {
        this.rtaTransNo = value;
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
     * Gets the value of the reportDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportDate() {
        return reportDate;
    }

    /**
     * Sets the value of the reportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportDate(JAXBElement<String> value) {
        this.reportDate = value;
    }

    /**
     * Gets the value of the sipRegnDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSIPRegnDate() {
        return sipRegnDate;
    }

    /**
     * Sets the value of the sipRegnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSIPRegnDate(JAXBElement<String> value) {
        this.sipRegnDate = value;
    }

    /**
     * Gets the value of the sipRegnNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSIPRegnNo() {
        return sipRegnNo;
    }

    /**
     * Sets the value of the sipRegnNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSIPRegnNo(JAXBElement<String> value) {
        this.sipRegnNo = value;
    }

    /**
     * Gets the value of the stt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSTT() {
        return stt;
    }

    /**
     * Sets the value of the stt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSTT(JAXBElement<String> value) {
        this.stt = value;
    }

    /**
     * Gets the value of the schemeCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSchemeCode() {
        return schemeCode;
    }

    /**
     * Sets the value of the schemeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSchemeCode(JAXBElement<String> value) {
        this.schemeCode = value;
    }

    /**
     * Gets the value of the settNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSettNo() {
        return settNo;
    }

    /**
     * Sets the value of the settNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSettNo(JAXBElement<String> value) {
        this.settNo = value;
    }

    /**
     * Gets the value of the settType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSettType() {
        return settType;
    }

    /**
     * Sets the value of the settType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSettType(JAXBElement<String> value) {
        this.settType = value;
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
     * Gets the value of the subOrderType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubOrderType() {
        return subOrderType;
    }

    /**
     * Sets the value of the subOrderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubOrderType(JAXBElement<String> value) {
        this.subOrderType = value;
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
     * Gets the value of the validFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getValidFlag() {
        return validFlag;
    }

    /**
     * Sets the value of the validFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setValidFlag(JAXBElement<String> value) {
        this.validFlag = value;
    }

}
