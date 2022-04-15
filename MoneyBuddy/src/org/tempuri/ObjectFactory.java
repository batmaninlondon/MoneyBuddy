
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.PasswordRequest;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.RequestParam;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.Response;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _GetPasswordParam_QNAME = new QName("http://tempuri.org/", "Param");
    private final static QName _PaymentGatewayAPIResponsePaymentGatewayAPIResult_QNAME = new QName("http://tempuri.org/", "PaymentGatewayAPIResult");
    private final static QName _GetPasswordResponseGetPasswordResult_QNAME = new QName("http://tempuri.org/", "GetPasswordResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentGatewayAPI }
     * 
     */
    public PaymentGatewayAPI createPaymentGatewayAPI() {
        return new PaymentGatewayAPI();
    }

    /**
     * Create an instance of {@link GetPassword }
     * 
     */
    public GetPassword createGetPassword() {
        return new GetPassword();
    }

    /**
     * Create an instance of {@link GetPasswordResponse }
     * 
     */
    public GetPasswordResponse createGetPasswordResponse() {
        return new GetPasswordResponse();
    }

    /**
     * Create an instance of {@link PaymentGatewayAPIResponse }
     * 
     */
    public PaymentGatewayAPIResponse createPaymentGatewayAPIResponse() {
        return new PaymentGatewayAPIResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Param", scope = GetPassword.class)
    public JAXBElement<PasswordRequest> createGetPasswordParam(PasswordRequest value) {
        return new JAXBElement<PasswordRequest>(_GetPasswordParam_QNAME, PasswordRequest.class, GetPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Param", scope = PaymentGatewayAPI.class)
    public JAXBElement<RequestParam> createPaymentGatewayAPIParam(RequestParam value) {
        return new JAXBElement<RequestParam>(_GetPasswordParam_QNAME, RequestParam.class, PaymentGatewayAPI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PaymentGatewayAPIResult", scope = PaymentGatewayAPIResponse.class)
    public JAXBElement<Response> createPaymentGatewayAPIResponsePaymentGatewayAPIResult(Response value) {
        return new JAXBElement<Response>(_PaymentGatewayAPIResponsePaymentGatewayAPIResult_QNAME, Response.class, PaymentGatewayAPIResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPasswordResult", scope = GetPasswordResponse.class)
    public JAXBElement<Response> createGetPasswordResponseGetPasswordResult(Response value) {
        return new JAXBElement<Response>(_GetPasswordResponseGetPasswordResult_QNAME, Response.class, GetPasswordResponse.class, value);
    }

}
