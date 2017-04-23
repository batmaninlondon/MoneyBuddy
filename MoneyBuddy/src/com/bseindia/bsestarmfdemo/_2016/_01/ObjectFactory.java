
package com.bseindia.bsestarmfdemo._2016._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bseindia.bsestarmfdemo._2016._01 package. 
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

    private final static QName _GetPasswordResponseGetPasswordResult_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "getPasswordResult");
    private final static QName _MFAPIResponseMFAPIResult_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "MFAPIResult");
    private final static QName _MFAPIFlag_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "Flag");
    private final static QName _MFAPIParam_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "param");
    private final static QName _MFAPIEncryptedPassword_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "EncryptedPassword");
    private final static QName _MFAPIUserId_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "UserId");
    private final static QName _GetPasswordPassword_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "Password");
    private final static QName _GetPasswordPassKey_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "PassKey");
    private final static QName _GetPasswordMemberId_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "MemberId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bseindia.bsestarmfdemo._2016._01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPasswordResponse }
     * 
     */
    public GetPasswordResponse createGetPasswordResponse() {
        return new GetPasswordResponse();
    }

    /**
     * Create an instance of {@link MFAPIResponse }
     * 
     */
    public MFAPIResponse createMFAPIResponse() {
        return new MFAPIResponse();
    }

    /**
     * Create an instance of {@link MFAPI }
     * 
     */
    public MFAPI createMFAPI() {
        return new MFAPI();
    }

    /**
     * Create an instance of {@link GetPassword }
     * 
     */
    public GetPassword createGetPassword() {
        return new GetPassword();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "getPasswordResult", scope = GetPasswordResponse.class)
    public JAXBElement<String> createGetPasswordResponseGetPasswordResult(String value) {
        return new JAXBElement<String>(_GetPasswordResponseGetPasswordResult_QNAME, String.class, GetPasswordResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "MFAPIResult", scope = MFAPIResponse.class)
    public JAXBElement<String> createMFAPIResponseMFAPIResult(String value) {
        return new JAXBElement<String>(_MFAPIResponseMFAPIResult_QNAME, String.class, MFAPIResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "Flag", scope = MFAPI.class)
    public JAXBElement<String> createMFAPIFlag(String value) {
        return new JAXBElement<String>(_MFAPIFlag_QNAME, String.class, MFAPI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "param", scope = MFAPI.class)
    public JAXBElement<String> createMFAPIParam(String value) {
        return new JAXBElement<String>(_MFAPIParam_QNAME, String.class, MFAPI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "EncryptedPassword", scope = MFAPI.class)
    public JAXBElement<String> createMFAPIEncryptedPassword(String value) {
        return new JAXBElement<String>(_MFAPIEncryptedPassword_QNAME, String.class, MFAPI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "UserId", scope = MFAPI.class)
    public JAXBElement<String> createMFAPIUserId(String value) {
        return new JAXBElement<String>(_MFAPIUserId_QNAME, String.class, MFAPI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "Password", scope = GetPassword.class)
    public JAXBElement<String> createGetPasswordPassword(String value) {
        return new JAXBElement<String>(_GetPasswordPassword_QNAME, String.class, GetPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "PassKey", scope = GetPassword.class)
    public JAXBElement<String> createGetPasswordPassKey(String value) {
        return new JAXBElement<String>(_GetPasswordPassKey_QNAME, String.class, GetPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "UserId", scope = GetPassword.class)
    public JAXBElement<String> createGetPasswordUserId(String value) {
        return new JAXBElement<String>(_MFAPIUserId_QNAME, String.class, GetPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bsestarmfdemo.bseindia.com/2016/01/", name = "MemberId", scope = GetPassword.class)
    public JAXBElement<String> createGetPasswordMemberId(String value) {
        return new JAXBElement<String>(_GetPasswordMemberId_QNAME, String.class, GetPassword.class, value);
    }

}
