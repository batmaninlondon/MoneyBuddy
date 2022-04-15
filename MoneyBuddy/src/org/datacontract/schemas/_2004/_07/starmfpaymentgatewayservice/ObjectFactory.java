
package org.datacontract.schemas._2004._07.starmfpaymentgatewayservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.starmfpaymentgatewayservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Response_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "Response");
    private final static QName _PasswordRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "PasswordRequest");
    private final static QName _RequestParam_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "RequestParam");
    private final static QName _PasswordRequestMemberId_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "MemberId");
    private final static QName _PasswordRequestUserId_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "UserId");
    private final static QName _PasswordRequestPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "Password");
    private final static QName _PasswordRequestPassKey_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "PassKey");
    private final static QName _RequestParamOrders_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "Orders");
    private final static QName _RequestParamAccNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "AccNo");
    private final static QName _RequestParamMode_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "Mode");
    private final static QName _RequestParamEncryptedPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "EncryptedPassword");
    private final static QName _RequestParamTotalAmount_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "TotalAmount");
    private final static QName _RequestParamClientCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "ClientCode");
    private final static QName _RequestParamIFSC_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "IFSC");
    private final static QName _RequestParamLogOutURL_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "LogOutURL");
    private final static QName _RequestParamMemberCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "MemberCode");
    private final static QName _RequestParamBankID_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "BankID");
    private final static QName _ResponseStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "Status");
    private final static QName _ResponseFiller_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "Filler");
    private final static QName _ResponseResponseString_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", "ResponseString");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.starmfpaymentgatewayservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestParam }
     * 
     */
    public RequestParam createRequestParam() {
        return new RequestParam();
    }

    /**
     * Create an instance of {@link PasswordRequest }
     * 
     */
    public PasswordRequest createPasswordRequest() {
        return new PasswordRequest();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "Response")
    public JAXBElement<Response> createResponse(Response value) {
        return new JAXBElement<Response>(_Response_QNAME, Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "PasswordRequest")
    public JAXBElement<PasswordRequest> createPasswordRequest(PasswordRequest value) {
        return new JAXBElement<PasswordRequest>(_PasswordRequest_QNAME, PasswordRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "RequestParam")
    public JAXBElement<RequestParam> createRequestParam(RequestParam value) {
        return new JAXBElement<RequestParam>(_RequestParam_QNAME, RequestParam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "MemberId", scope = PasswordRequest.class)
    public JAXBElement<String> createPasswordRequestMemberId(String value) {
        return new JAXBElement<String>(_PasswordRequestMemberId_QNAME, String.class, PasswordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "UserId", scope = PasswordRequest.class)
    public JAXBElement<String> createPasswordRequestUserId(String value) {
        return new JAXBElement<String>(_PasswordRequestUserId_QNAME, String.class, PasswordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "Password", scope = PasswordRequest.class)
    public JAXBElement<String> createPasswordRequestPassword(String value) {
        return new JAXBElement<String>(_PasswordRequestPassword_QNAME, String.class, PasswordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "PassKey", scope = PasswordRequest.class)
    public JAXBElement<String> createPasswordRequestPassKey(String value) {
        return new JAXBElement<String>(_PasswordRequestPassKey_QNAME, String.class, PasswordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "Orders", scope = RequestParam.class)
    public JAXBElement<ArrayOfstring> createRequestParamOrders(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_RequestParamOrders_QNAME, ArrayOfstring.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "AccNo", scope = RequestParam.class)
    public JAXBElement<String> createRequestParamAccNo(String value) {
        return new JAXBElement<String>(_RequestParamAccNo_QNAME, String.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "Mode", scope = RequestParam.class)
    public JAXBElement<String> createRequestParamMode(String value) {
        return new JAXBElement<String>(_RequestParamMode_QNAME, String.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "EncryptedPassword", scope = RequestParam.class)
    public JAXBElement<String> createRequestParamEncryptedPassword(String value) {
        return new JAXBElement<String>(_RequestParamEncryptedPassword_QNAME, String.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "TotalAmount", scope = RequestParam.class)
    public JAXBElement<String> createRequestParamTotalAmount(String value) {
        return new JAXBElement<String>(_RequestParamTotalAmount_QNAME, String.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "ClientCode", scope = RequestParam.class)
    public JAXBElement<String> createRequestParamClientCode(String value) {
        return new JAXBElement<String>(_RequestParamClientCode_QNAME, String.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "IFSC", scope = RequestParam.class)
    public JAXBElement<String> createRequestParamIFSC(String value) {
        return new JAXBElement<String>(_RequestParamIFSC_QNAME, String.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "LogOutURL", scope = RequestParam.class)
    public JAXBElement<String> createRequestParamLogOutURL(String value) {
        return new JAXBElement<String>(_RequestParamLogOutURL_QNAME, String.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "MemberCode", scope = RequestParam.class)
    public JAXBElement<String> createRequestParamMemberCode(String value) {
        return new JAXBElement<String>(_RequestParamMemberCode_QNAME, String.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "BankID", scope = RequestParam.class)
    public JAXBElement<String> createRequestParamBankID(String value) {
        return new JAXBElement<String>(_RequestParamBankID_QNAME, String.class, RequestParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "Status", scope = Response.class)
    public JAXBElement<String> createResponseStatus(String value) {
        return new JAXBElement<String>(_ResponseStatus_QNAME, String.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "Filler", scope = Response.class)
    public JAXBElement<String> createResponseFiller(String value) {
        return new JAXBElement<String>(_ResponseFiller_QNAME, String.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFPaymentGatewayService", name = "ResponseString", scope = Response.class)
    public JAXBElement<String> createResponseResponseString(String value) {
        return new JAXBElement<String>(_ResponseResponseString_QNAME, String.class, Response.class, value);
    }

}
