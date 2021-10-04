package com.myMoneyBuddy.webServices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import org.tempuri.MFOrderEntry;

import in.bsestarmf.GetPassword;


@WebServiceClient(name = "MFOrder", targetNamespace = "http://tempuri.org/", wsdlLocation = "https://www.bsestarmf.in/MFOrderEntry/MFOrder.svc")
public class WebServiceMFOrder extends Service{

	protected WebServiceMFOrder(URL wsdlDocumentLocation, QName serviceName) {
		super(wsdlDocumentLocation, serviceName);
		// TODO Auto-generated constructor stub
	}

	
	private final static URL MFORDER_WSDL_LOCATION;
    private final static WebServiceException MFORDER_EXCEPTION;
    private final static QName MFORDER_QNAME = new QName("http://tempuri.org/", "MFOrder");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://www.bsestarmf.in/MFOrderEntry/MFOrder.svc");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MFORDER_WSDL_LOCATION = url;
        MFORDER_EXCEPTION = e;
    }

    public WebServiceMFOrder() {
        super(__getWsdlLocation(), MFORDER_QNAME);
    }

    public WebServiceMFOrder(WebServiceFeature... features) {
        super(__getWsdlLocation(), MFORDER_QNAME, features);
    }

    public WebServiceMFOrder(URL wsdlLocation) {
        super(wsdlLocation, MFORDER_QNAME);
    }

    public WebServiceMFOrder(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MFORDER_QNAME, features);
    }


    public WebServiceMFOrder(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_MFOrderEntry")
    public MFOrderEntry getWSHttpBindingMFOrderEntry() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_MFOrderEntry"), MFOrderEntry.class, new javax.xml.ws.soap.AddressingFeature());
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_MFOrderEntry")
    public MFOrderEntry getWSHttpBindingMFOrderEntry(WebServiceFeature... features) {
    	System.out.println("Inside getWSHttpBindingMFOrderEntry : start ");
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_MFOrderEntry"), MFOrderEntry.class, new javax.xml.ws.soap.AddressingFeature());
        
    }
    
    

    /**
     * 
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_MFOrderEntry1")
    public MFOrderEntry getWSHttpBindingMFOrderEntry1() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_MFOrderEntry1"), MFOrderEntry.class, new javax.xml.ws.soap.AddressingFeature());
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_MFOrderEntry1")
    public MFOrderEntry getWSHttpBindingMFOrderEntry1(WebServiceFeature... features) {
    	System.out.println("Inside getWSHttpBindingMFOrderEntry1 : start ");
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_MFOrderEntry1"), MFOrderEntry.class, new javax.xml.ws.soap.AddressingFeature());
        
    }
    
    /**
     * 
     * @returns
     *     returns RelevancePortType
     */
    @WebEndpoint(name = "http://bsestarmf.in/MFOrderEntry/getPassword")
    public GetPassword getRelevancePort() {
        return super.getPort(new QName("http://bsestarmf.in/MFOrderEntry/getPassword", "GetPassword"), GetPassword.class, new javax.xml.ws.soap.AddressingFeature());
    }

    
    private static URL __getWsdlLocation() {
        if (MFORDER_EXCEPTION!= null) {
            throw MFORDER_EXCEPTION;
        }
        return MFORDER_WSDL_LOCATION;
    }
	

}
