
package org.datacontract.schemas._2004._07.starmfwebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Filler1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Filler2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Filler3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FromDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemberCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubOrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ToDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderRequest", propOrder = {
    "clientCode",
    "filler1",
    "filler2",
    "filler3",
    "fromDate",
    "memberCode",
    "orderNo",
    "orderStatus",
    "orderType",
    "password",
    "settType",
    "subOrderType",
    "toDate",
    "transType",
    "userId"
})
public class OrderRequest {

    @XmlElementRef(name = "ClientCode", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> clientCode;
    @XmlElementRef(name = "Filler1", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> filler1;
    @XmlElementRef(name = "Filler2", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> filler2;
    @XmlElementRef(name = "Filler3", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> filler3;
    @XmlElementRef(name = "FromDate", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fromDate;
    @XmlElementRef(name = "MemberCode", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> memberCode;
    @XmlElementRef(name = "OrderNo", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderNo;
    @XmlElementRef(name = "OrderStatus", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderStatus;
    @XmlElementRef(name = "OrderType", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderType;
    @XmlElementRef(name = "Password", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> password;
    @XmlElementRef(name = "SettType", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> settType;
    @XmlElementRef(name = "SubOrderType", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subOrderType;
    @XmlElementRef(name = "ToDate", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> toDate;
    @XmlElementRef(name = "TransType", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transType;
    @XmlElementRef(name = "UserId", namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userId;

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
     * Gets the value of the filler1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFiller1() {
        return filler1;
    }

    /**
     * Sets the value of the filler1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFiller1(JAXBElement<String> value) {
        this.filler1 = value;
    }

    /**
     * Gets the value of the filler2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFiller2() {
        return filler2;
    }

    /**
     * Sets the value of the filler2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFiller2(JAXBElement<String> value) {
        this.filler2 = value;
    }

    /**
     * Gets the value of the filler3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFiller3() {
        return filler3;
    }

    /**
     * Sets the value of the filler3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFiller3(JAXBElement<String> value) {
        this.filler3 = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFromDate(JAXBElement<String> value) {
        this.fromDate = value;
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
     * Gets the value of the orderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderStatus(JAXBElement<String> value) {
        this.orderStatus = value;
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
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setToDate(JAXBElement<String> value) {
        this.toDate = value;
    }

    /**
     * Gets the value of the transType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransType() {
        return transType;
    }

    /**
     * Sets the value of the transType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransType(JAXBElement<String> value) {
        this.transType = value;
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

}
