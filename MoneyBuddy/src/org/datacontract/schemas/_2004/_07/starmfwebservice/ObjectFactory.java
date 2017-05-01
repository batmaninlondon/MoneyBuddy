
package org.datacontract.schemas._2004._07.starmfwebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.starmfwebservice package. 
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

    private final static QName _MFAPIRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "MFAPIRequest");
    private final static QName _PasswordRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "PasswordRequest");
    private final static QName _Response_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "Response");
    private final static QName _MFAPIRequestUserId_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "UserId");
    private final static QName _MFAPIRequestEncryptedPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "EncryptedPassword");
    private final static QName _MFAPIRequestParam_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "param");
    private final static QName _MFAPIRequestFlag_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "Flag");
    private final static QName _PasswordRequestMemberId_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "MemberId");
    private final static QName _PasswordRequestPassKey_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "PassKey");
    private final static QName _PasswordRequestPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "Password");
    private final static QName _ResponseResponseString_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "ResponseString");
    private final static QName _ResponseFiller_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "Filler");
    private final static QName _ResponseStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/StarMFWebService", "Status");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.starmfwebservice
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link MFAPIRequest }
     * 
     */
    public MFAPIRequest createMFAPIRequest() {
        return new MFAPIRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MFAPIRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "MFAPIRequest")
    public JAXBElement<MFAPIRequest> createMFAPIRequest(MFAPIRequest value) {
        return new JAXBElement<MFAPIRequest>(_MFAPIRequest_QNAME, MFAPIRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "PasswordRequest")
    public JAXBElement<PasswordRequest> createPasswordRequest(PasswordRequest value) {
        return new JAXBElement<PasswordRequest>(_PasswordRequest_QNAME, PasswordRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "Response")
    public JAXBElement<Response> createResponse(Response value) {
        return new JAXBElement<Response>(_Response_QNAME, Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "UserId", scope = MFAPIRequest.class)
    public JAXBElement<String> createMFAPIRequestUserId(String value) {
        return new JAXBElement<String>(_MFAPIRequestUserId_QNAME, String.class, MFAPIRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "EncryptedPassword", scope = MFAPIRequest.class)
    public JAXBElement<String> createMFAPIRequestEncryptedPassword(String value) {
        return new JAXBElement<String>(_MFAPIRequestEncryptedPassword_QNAME, String.class, MFAPIRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "param", scope = MFAPIRequest.class)
    public JAXBElement<String> createMFAPIRequestParam(String value) {
        return new JAXBElement<String>(_MFAPIRequestParam_QNAME, String.class, MFAPIRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "Flag", scope = MFAPIRequest.class)
    public JAXBElement<String> createMFAPIRequestFlag(String value) {
        return new JAXBElement<String>(_MFAPIRequestFlag_QNAME, String.class, MFAPIRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "MemberId", scope = PasswordRequest.class)
    public JAXBElement<String> createPasswordRequestMemberId(String value) {
        return new JAXBElement<String>(_PasswordRequestMemberId_QNAME, String.class, PasswordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "UserId", scope = PasswordRequest.class)
    public JAXBElement<String> createPasswordRequestUserId(String value) {
        return new JAXBElement<String>(_MFAPIRequestUserId_QNAME, String.class, PasswordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "PassKey", scope = PasswordRequest.class)
    public JAXBElement<String> createPasswordRequestPassKey(String value) {
        return new JAXBElement<String>(_PasswordRequestPassKey_QNAME, String.class, PasswordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "Password", scope = PasswordRequest.class)
    public JAXBElement<String> createPasswordRequestPassword(String value) {
        return new JAXBElement<String>(_PasswordRequestPassword_QNAME, String.class, PasswordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "ResponseString", scope = Response.class)
    public JAXBElement<String> createResponseResponseString(String value) {
        return new JAXBElement<String>(_ResponseResponseString_QNAME, String.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "Filler", scope = Response.class)
    public JAXBElement<String> createResponseFiller(String value) {
        return new JAXBElement<String>(_ResponseFiller_QNAME, String.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/StarMFWebService", name = "Status", scope = Response.class)
    public JAXBElement<String> createResponseStatus(String value) {
        return new JAXBElement<String>(_ResponseStatus_QNAME, String.class, Response.class, value);
    }

}
