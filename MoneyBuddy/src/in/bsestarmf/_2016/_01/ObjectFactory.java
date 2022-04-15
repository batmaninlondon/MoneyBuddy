
package in.bsestarmf._2016._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.datacontract.schemas._2004._07.starmfwebservice.ChildOrderRequest;
import org.datacontract.schemas._2004._07.starmfwebservice.ChildOrderResponse;
import org.datacontract.schemas._2004._07.starmfwebservice.MFAPIRequest;
import org.datacontract.schemas._2004._07.starmfwebservice.MandateDetailsRequest;
import org.datacontract.schemas._2004._07.starmfwebservice.PasswordRequest;
import org.datacontract.schemas._2004._07.starmfwebservice.Response;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the in.bsestarmf._2016._01 package. 
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

    private final static QName _ChildOrderDetailsResponseChildOrderDetailsResult_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "ChildOrderDetailsResult");
    private final static QName _GetPasswordUserId_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "UserId");
    private final static QName _GetPasswordMemberId_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "MemberId");
    private final static QName _GetPasswordPassKey_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "PassKey");
    private final static QName _GetPasswordPassword_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "Password");
    private final static QName _MFAPIParam_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "param");
    private final static QName _MFAPIFlag_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "Flag");
    private final static QName _MFAPIEncryptedPassword_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "EncryptedPassword");
    private final static QName _GetPasswordMobileResponseGetPasswordMobileResult_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "GetPasswordMobileResult");
    private final static QName _GetAccessTokenParam_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "Param");
    private final static QName _GetPasswordForChildOrderResponseGetPasswordForChildOrderResult_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "GetPasswordForChildOrderResult");
    private final static QName _MFAPIMobileResponseMFAPIMobileResult_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "MFAPIMobileResult");
    private final static QName _MFAPIResponseMFAPIResult_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "MFAPIResult");
    private final static QName _GetPasswordResponseGetPasswordResult_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "getPasswordResult");
    private final static QName _GetAccessTokenResponseGetAccessTokenResult_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "GetAccessTokenResult");
    private final static QName _MandateDetailsResponseMandateDetailsResult_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "MandateDetailsResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: in.bsestarmf._2016._01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MFAPIMobileResponse }
     * 
     */
    public MFAPIMobileResponse createMFAPIMobileResponse() {
        return new MFAPIMobileResponse();
    }

    /**
     * Create an instance of {@link GetAccessToken }
     * 
     */
    public GetAccessToken createGetAccessToken() {
        return new GetAccessToken();
    }

    /**
     * Create an instance of {@link GetPasswordMobileResponse }
     * 
     */
    public GetPasswordMobileResponse createGetPasswordMobileResponse() {
        return new GetPasswordMobileResponse();
    }

    /**
     * Create an instance of {@link ChildOrderDetailsResponse }
     * 
     */
    public ChildOrderDetailsResponse createChildOrderDetailsResponse() {
        return new ChildOrderDetailsResponse();
    }

    /**
     * Create an instance of {@link MFAPIMobile }
     * 
     */
    public MFAPIMobile createMFAPIMobile() {
        return new MFAPIMobile();
    }

    /**
     * Create an instance of {@link GetAccessTokenResponse }
     * 
     */
    public GetAccessTokenResponse createGetAccessTokenResponse() {
        return new GetAccessTokenResponse();
    }

    /**
     * Create an instance of {@link GetPassword }
     * 
     */
    public GetPassword createGetPassword() {
        return new GetPassword();
    }

    /**
     * Create an instance of {@link MFAPIResponse }
     * 
     */
    public MFAPIResponse createMFAPIResponse() {
        return new MFAPIResponse();
    }

    /**
     * Create an instance of {@link GetPasswordMobile }
     * 
     */
    public GetPasswordMobile createGetPasswordMobile() {
        return new GetPasswordMobile();
    }

    /**
     * Create an instance of {@link GetPasswordForChildOrder }
     * 
     */
    public GetPasswordForChildOrder createGetPasswordForChildOrder() {
        return new GetPasswordForChildOrder();
    }

    /**
     * Create an instance of {@link ChildOrderDetails }
     * 
     */
    public ChildOrderDetails createChildOrderDetails() {
        return new ChildOrderDetails();
    }

    /**
     * Create an instance of {@link GetPasswordForChildOrderResponse }
     * 
     */
    public GetPasswordForChildOrderResponse createGetPasswordForChildOrderResponse() {
        return new GetPasswordForChildOrderResponse();
    }

    /**
     * Create an instance of {@link in.bsestarmf._2016._01.MandateDetailsResponse }
     * 
     */
    public in.bsestarmf._2016._01.MandateDetailsResponse createMandateDetailsResponse() {
        return new in.bsestarmf._2016._01.MandateDetailsResponse();
    }

    /**
     * Create an instance of {@link GetPasswordResponse }
     * 
     */
    public GetPasswordResponse createGetPasswordResponse() {
        return new GetPasswordResponse();
    }

    /**
     * Create an instance of {@link MFAPI }
     * 
     */
    public MFAPI createMFAPI() {
        return new MFAPI();
    }

    /**
     * Create an instance of {@link MandateDetails }
     * 
     */
    public MandateDetails createMandateDetails() {
        return new MandateDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChildOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "ChildOrderDetailsResult", scope = ChildOrderDetailsResponse.class)
    public JAXBElement<ChildOrderResponse> createChildOrderDetailsResponseChildOrderDetailsResult(ChildOrderResponse value) {
        return new JAXBElement<ChildOrderResponse>(_ChildOrderDetailsResponseChildOrderDetailsResult_QNAME, ChildOrderResponse.class, ChildOrderDetailsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "UserId", scope = GetPassword.class)
    public JAXBElement<String> createGetPasswordUserId(String value) {
        return new JAXBElement<String>(_GetPasswordUserId_QNAME, String.class, GetPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "MemberId", scope = GetPassword.class)
    public JAXBElement<String> createGetPasswordMemberId(String value) {
        return new JAXBElement<String>(_GetPasswordMemberId_QNAME, String.class, GetPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "PassKey", scope = GetPassword.class)
    public JAXBElement<String> createGetPasswordPassKey(String value) {
        return new JAXBElement<String>(_GetPasswordPassKey_QNAME, String.class, GetPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "Password", scope = GetPassword.class)
    public JAXBElement<String> createGetPasswordPassword(String value) {
        return new JAXBElement<String>(_GetPasswordPassword_QNAME, String.class, GetPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "param", scope = MFAPI.class)
    public JAXBElement<String> createMFAPIParam(String value) {
        return new JAXBElement<String>(_MFAPIParam_QNAME, String.class, MFAPI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "UserId", scope = MFAPI.class)
    public JAXBElement<String> createMFAPIUserId(String value) {
        return new JAXBElement<String>(_GetPasswordUserId_QNAME, String.class, MFAPI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "Flag", scope = MFAPI.class)
    public JAXBElement<String> createMFAPIFlag(String value) {
        return new JAXBElement<String>(_MFAPIFlag_QNAME, String.class, MFAPI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "EncryptedPassword", scope = MFAPI.class)
    public JAXBElement<String> createMFAPIEncryptedPassword(String value) {
        return new JAXBElement<String>(_MFAPIEncryptedPassword_QNAME, String.class, MFAPI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "GetPasswordMobileResult", scope = GetPasswordMobileResponse.class)
    public JAXBElement<Response> createGetPasswordMobileResponseGetPasswordMobileResult(Response value) {
        return new JAXBElement<Response>(_GetPasswordMobileResponseGetPasswordMobileResult_QNAME, Response.class, GetPasswordMobileResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "Param", scope = GetAccessToken.class)
    public JAXBElement<PasswordRequest> createGetAccessTokenParam(PasswordRequest value) {
        return new JAXBElement<PasswordRequest>(_GetAccessTokenParam_QNAME, PasswordRequest.class, GetAccessToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "GetPasswordForChildOrderResult", scope = GetPasswordForChildOrderResponse.class)
    public JAXBElement<Response> createGetPasswordForChildOrderResponseGetPasswordForChildOrderResult(Response value) {
        return new JAXBElement<Response>(_GetPasswordForChildOrderResponseGetPasswordForChildOrderResult_QNAME, Response.class, GetPasswordForChildOrderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "Param", scope = GetPasswordMobile.class)
    public JAXBElement<PasswordRequest> createGetPasswordMobileParam(PasswordRequest value) {
        return new JAXBElement<PasswordRequest>(_GetAccessTokenParam_QNAME, PasswordRequest.class, GetPasswordMobile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MFAPIRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "Param", scope = MFAPIMobile.class)
    public JAXBElement<MFAPIRequest> createMFAPIMobileParam(MFAPIRequest value) {
        return new JAXBElement<MFAPIRequest>(_GetAccessTokenParam_QNAME, MFAPIRequest.class, MFAPIMobile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "MFAPIMobileResult", scope = MFAPIMobileResponse.class)
    public JAXBElement<Response> createMFAPIMobileResponseMFAPIMobileResult(Response value) {
        return new JAXBElement<Response>(_MFAPIMobileResponseMFAPIMobileResult_QNAME, Response.class, MFAPIMobileResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "MFAPIResult", scope = MFAPIResponse.class)
    public JAXBElement<String> createMFAPIResponseMFAPIResult(String value) {
        return new JAXBElement<String>(_MFAPIResponseMFAPIResult_QNAME, String.class, MFAPIResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MandateDetailsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "Param", scope = MandateDetails.class)
    public JAXBElement<MandateDetailsRequest> createMandateDetailsParam(MandateDetailsRequest value) {
        return new JAXBElement<MandateDetailsRequest>(_GetAccessTokenParam_QNAME, MandateDetailsRequest.class, MandateDetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "getPasswordResult", scope = GetPasswordResponse.class)
    public JAXBElement<String> createGetPasswordResponseGetPasswordResult(String value) {
        return new JAXBElement<String>(_GetPasswordResponseGetPasswordResult_QNAME, String.class, GetPasswordResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "GetAccessTokenResult", scope = GetAccessTokenResponse.class)
    public JAXBElement<Response> createGetAccessTokenResponseGetAccessTokenResult(Response value) {
        return new JAXBElement<Response>(_GetAccessTokenResponseGetAccessTokenResult_QNAME, Response.class, GetAccessTokenResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChildOrderRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "Param", scope = ChildOrderDetails.class)
    public JAXBElement<ChildOrderRequest> createChildOrderDetailsParam(ChildOrderRequest value) {
        return new JAXBElement<ChildOrderRequest>(_GetAccessTokenParam_QNAME, ChildOrderRequest.class, ChildOrderDetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.starmfwebservice.MandateDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "MandateDetailsResult", scope = in.bsestarmf._2016._01.MandateDetailsResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.starmfwebservice.MandateDetailsResponse> createMandateDetailsResponseMandateDetailsResult(org.datacontract.schemas._2004._07.starmfwebservice.MandateDetailsResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.starmfwebservice.MandateDetailsResponse>(_MandateDetailsResponseMandateDetailsResult_QNAME, org.datacontract.schemas._2004._07.starmfwebservice.MandateDetailsResponse.class, in.bsestarmf._2016._01.MandateDetailsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bsestarmf.in/2016/01/", name = "Param", scope = GetPasswordForChildOrder.class)
    public JAXBElement<PasswordRequest> createGetPasswordForChildOrderParam(PasswordRequest value) {
        return new JAXBElement<PasswordRequest>(_GetAccessTokenParam_QNAME, PasswordRequest.class, GetPasswordForChildOrder.class, value);
    }

}
