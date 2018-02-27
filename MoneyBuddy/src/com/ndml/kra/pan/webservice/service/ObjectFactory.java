
package com.ndml.kra.pan.webservice.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ndml.kra.pan.webservice.service package. 
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

    private final static QName _PanDownloadDetailsComplete_QNAME = new QName("http://service.webservice.pan.kra.ndml.com/", "panDownloadDetailsComplete");
    private final static QName _PanInquiryDetailsResponse_QNAME = new QName("http://service.webservice.pan.kra.ndml.com/", "panInquiryDetailsResponse");
    private final static QName _PanDownloadDetailsCompleteResponse_QNAME = new QName("http://service.webservice.pan.kra.ndml.com/", "panDownloadDetailsCompleteResponse");
    private final static QName _GetPasscode_QNAME = new QName("http://service.webservice.pan.kra.ndml.com/", "getPasscode");
    private final static QName _GetPasscodeResponse_QNAME = new QName("http://service.webservice.pan.kra.ndml.com/", "getPasscodeResponse");
    private final static QName _PanDownloadDetailsResponse_QNAME = new QName("http://service.webservice.pan.kra.ndml.com/", "panDownloadDetailsResponse");
    private final static QName _PanInquiryDetails_QNAME = new QName("http://service.webservice.pan.kra.ndml.com/", "panInquiryDetails");
    private final static QName _PanDownloadDetails_QNAME = new QName("http://service.webservice.pan.kra.ndml.com/", "panDownloadDetails");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ndml.kra.pan.webservice.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PanDownloadDetailsCompleteResponse }
     * 
     */
    public PanDownloadDetailsCompleteResponse createPanDownloadDetailsCompleteResponse() {
        return new PanDownloadDetailsCompleteResponse();
    }

    /**
     * Create an instance of {@link PanDownloadDetailsComplete }
     * 
     */
    public PanDownloadDetailsComplete createPanDownloadDetailsComplete() {
        return new PanDownloadDetailsComplete();
    }

    /**
     * Create an instance of {@link PanInquiryDetailsResponse }
     * 
     */
    public PanInquiryDetailsResponse createPanInquiryDetailsResponse() {
        return new PanInquiryDetailsResponse();
    }

    /**
     * Create an instance of {@link PanDownloadDetails }
     * 
     */
    public PanDownloadDetails createPanDownloadDetails() {
        return new PanDownloadDetails();
    }

    /**
     * Create an instance of {@link PanInquiryDetails }
     * 
     */
    public PanInquiryDetails createPanInquiryDetails() {
        return new PanInquiryDetails();
    }

    /**
     * Create an instance of {@link GetPasscodeResponse }
     * 
     */
    public GetPasscodeResponse createGetPasscodeResponse() {
        return new GetPasscodeResponse();
    }

    /**
     * Create an instance of {@link PanDownloadDetailsResponse }
     * 
     */
    public PanDownloadDetailsResponse createPanDownloadDetailsResponse() {
        return new PanDownloadDetailsResponse();
    }

    /**
     * Create an instance of {@link GetPasscode }
     * 
     */
    public GetPasscode createGetPasscode() {
        return new GetPasscode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PanDownloadDetailsComplete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.pan.kra.ndml.com/", name = "panDownloadDetailsComplete")
    public JAXBElement<PanDownloadDetailsComplete> createPanDownloadDetailsComplete(PanDownloadDetailsComplete value) {
        return new JAXBElement<PanDownloadDetailsComplete>(_PanDownloadDetailsComplete_QNAME, PanDownloadDetailsComplete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PanInquiryDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.pan.kra.ndml.com/", name = "panInquiryDetailsResponse")
    public JAXBElement<PanInquiryDetailsResponse> createPanInquiryDetailsResponse(PanInquiryDetailsResponse value) {
        return new JAXBElement<PanInquiryDetailsResponse>(_PanInquiryDetailsResponse_QNAME, PanInquiryDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PanDownloadDetailsCompleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.pan.kra.ndml.com/", name = "panDownloadDetailsCompleteResponse")
    public JAXBElement<PanDownloadDetailsCompleteResponse> createPanDownloadDetailsCompleteResponse(PanDownloadDetailsCompleteResponse value) {
        return new JAXBElement<PanDownloadDetailsCompleteResponse>(_PanDownloadDetailsCompleteResponse_QNAME, PanDownloadDetailsCompleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPasscode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.pan.kra.ndml.com/", name = "getPasscode")
    public JAXBElement<GetPasscode> createGetPasscode(GetPasscode value) {
        return new JAXBElement<GetPasscode>(_GetPasscode_QNAME, GetPasscode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPasscodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.pan.kra.ndml.com/", name = "getPasscodeResponse")
    public JAXBElement<GetPasscodeResponse> createGetPasscodeResponse(GetPasscodeResponse value) {
        return new JAXBElement<GetPasscodeResponse>(_GetPasscodeResponse_QNAME, GetPasscodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PanDownloadDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.pan.kra.ndml.com/", name = "panDownloadDetailsResponse")
    public JAXBElement<PanDownloadDetailsResponse> createPanDownloadDetailsResponse(PanDownloadDetailsResponse value) {
        return new JAXBElement<PanDownloadDetailsResponse>(_PanDownloadDetailsResponse_QNAME, PanDownloadDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PanInquiryDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.pan.kra.ndml.com/", name = "panInquiryDetails")
    public JAXBElement<PanInquiryDetails> createPanInquiryDetails(PanInquiryDetails value) {
        return new JAXBElement<PanInquiryDetails>(_PanInquiryDetails_QNAME, PanInquiryDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PanDownloadDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.pan.kra.ndml.com/", name = "panDownloadDetails")
    public JAXBElement<PanDownloadDetails> createPanDownloadDetails(PanDownloadDetails value) {
        return new JAXBElement<PanDownloadDetails>(_PanDownloadDetails_QNAME, PanDownloadDetails.class, null, value);
    }

}
