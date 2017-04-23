package com.myMoneyBuddy.webServices;
import com.bseindia.bsestarmfdemo._2016._01.GetPassword;

import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import org.tempuri.IMFUploadService;

import org.tempuri.MFUploadService;


@WebServiceClient(name = "IMFUploadService", targetNamespace = "http://bsestarmfdemo.bseindia.com/2016/01/", wsdlLocation = "http://bsestarmfdemo.bseindia.com/MFUploadService/MFUploadService.svc?singleWsdl")
public class WebServiceMFUpload extends Service{

	protected WebServiceMFUpload(URL wsdlDocumentLocation, QName serviceName) {
		super(wsdlDocumentLocation, serviceName);
		// TODO Auto-generated constructor stub
	}

	
	private final static URL MFORDER_WSDL_LOCATION;
    private final static WebServiceException MFORDER_EXCEPTION;
    private final static QName MFORDER_QNAME = new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "MFUploadService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://bsestarmfdemo.bseindia.com/MFUploadService/MFUploadService.svc?singleWsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MFORDER_WSDL_LOCATION = url;
        MFORDER_EXCEPTION = e;
    }

    public WebServiceMFUpload() {
        super(__getWsdlLocation(), MFORDER_QNAME);
    }

    public WebServiceMFUpload(WebServiceFeature... features) {
        super(__getWsdlLocation(), MFORDER_QNAME, features);
    }

    public WebServiceMFUpload(URL wsdlLocation) {
        super(wsdlLocation, MFORDER_QNAME);
    }

    public WebServiceMFUpload(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MFORDER_QNAME, features);
    }


    public WebServiceMFUpload(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_IMFUploadService")
    public IMFUploadService getWSHttpBindingIMFUploadService() {
        return super.getPort(new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "WSHttpBinding_IMFUploadService"), IMFUploadService.class, new javax.xml.ws.soap.AddressingFeature());
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_IMFUploadService")
    public IMFUploadService getWSHttpBindingIMFUploadService(WebServiceFeature... features) {
    	System.out.println("Inside getWSHttpBindingIMFUploadService : start ");
        return super.getPort(new QName("http://bsestarmfdemo.bseindia.com/2016/01/", "WSHttpBinding_IMFUploadService"), IMFUploadService.class, new javax.xml.ws.soap.AddressingFeature());
        
    }
    
    /**
     * 
     * @returns
     *     returns RelevancePortType
     */
    @WebEndpoint(name = "http://bsestarmfdemo.bseindia.com/2016/01/IMFUploadService/getPassword")
    public GetPassword getRelevancePort() {
        return super.getPort(new QName("http://bsestarmfdemo.bseindia.com/2016/01/IMFUploadService/getPassword", "GetPassword"), GetPassword.class, new javax.xml.ws.soap.AddressingFeature());
    }

    
    private static URL __getWsdlLocation() {
        if (MFORDER_EXCEPTION!= null) {
            throw MFORDER_EXCEPTION;
        }
        return MFORDER_WSDL_LOCATION;
    }
	

}