package com.myMoneyBuddy.webServices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import com.bsestarmf._2016._01.GetPassword;

import in.bsestarmf._2016._01.IStarMFWebService;


@WebServiceClient(name = "IStarMFWebService", targetNamespace = "http://www.bsestarmf.in/2016/01/", wsdlLocation = "https://www.bsestarmf.in/StarMFWebService/StarMFWebService.svc?singleWsdl")
public class WebServiceStarMF extends Service{

	protected WebServiceStarMF(URL wsdlDocumentLocation, QName serviceName) {
		super(wsdlDocumentLocation, serviceName);
		// TODO Auto-generated constructor stub
	}

	
	private final static URL MFORDER_WSDL_LOCATION;
    private final static WebServiceException MFORDER_EXCEPTION;
    private final static QName MFORDER_QNAME = new QName("http://www.bsestarmf.in/2016/01/", "StarMFWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://www.bsestarmf.in/StarMFWebService/StarMFWebService.svc?singleWsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MFORDER_WSDL_LOCATION = url;
        MFORDER_EXCEPTION = e;
    }

    public WebServiceStarMF() {
        super(__getWsdlLocation(), MFORDER_QNAME);
    }

    public WebServiceStarMF(WebServiceFeature... features) {
        super(__getWsdlLocation(), MFORDER_QNAME, features);
    }

    public WebServiceStarMF(URL wsdlLocation) {
        super(wsdlLocation, MFORDER_QNAME);
    }

    public WebServiceStarMF(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MFORDER_QNAME, features);
    }


    public WebServiceStarMF(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_IStarMFWebService")
    public IStarMFWebService getWSHttpBindingIStarMFService() {
        return super.getPort(new QName("http://www.bsestarmf.in/2016/01/", "WSHttpBinding_IStarMFWebService"), IStarMFWebService.class, new javax.xml.ws.soap.AddressingFeature());
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_IStarMFWebService")
    public IStarMFWebService getWSHttpBindingIStarMFService(WebServiceFeature... features) {
    	System.out.println("Inside getWSHttpBindingIStarMFService : start ");
        return super.getPort(new QName("http://www.bsestarmf.in/2016/01/", "WSHttpBinding_IStarMFWebService"), IStarMFWebService.class, new javax.xml.ws.soap.AddressingFeature());
        
    }
    
    /**
     * 
     * @returns
     *     returns RelevancePortType
     */
    @WebEndpoint(name = "http://www.bsestarmf.in/2016/01//IStarMFWebService/getPassword")
    public GetPassword getRelevancePort() {
        return super.getPort(new QName("http://www.bsestarmf.in/2016/01//IStarMFWebService/getPassword", "GetPassword"), GetPassword.class, new javax.xml.ws.soap.AddressingFeature());
    }

    

    /**
     * 
     * @return
     *     returns IStarMFWebService
     */
    @WebEndpoint(name = "WSHttpBinding_IStarMFWebService1")
    public IStarMFWebService getWSHttpBindingIStarMFWebService1() {
        return super.getPort(new QName("http://www.bsestarmf.in/2016/01/", "WSHttpBinding_IStarMFWebService1"), IStarMFWebService.class,new javax.xml.ws.soap.AddressingFeature());
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IStarMFWebService
     */
    @WebEndpoint(name = "WSHttpBinding_IStarMFWebService1")
    public IStarMFWebService getWSHttpBindingIStarMFWebService1(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.bsestarmf.in/2016/01/", "WSHttpBinding_IStarMFWebService1"), IStarMFWebService.class, new javax.xml.ws.soap.AddressingFeature());
    }
    
    
    
    private static URL __getWsdlLocation() {
        if (MFORDER_EXCEPTION!= null) {
            throw MFORDER_EXCEPTION;
        }
        return MFORDER_WSDL_LOCATION;
    }
	

}
