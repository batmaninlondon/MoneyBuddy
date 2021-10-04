package com.myMoneyBuddy.webServices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import org.tempuri.IStarMFPaymentGatewayService;

import com.bsestarmf._2016._01.GetPassword;


@WebServiceClient(name = "StarMFPaymentGatewayService", targetNamespace = "http://tempuri.org/", wsdlLocation = "https://www.bsestarmf.in/StarMFPaymentGatewayService/StarMFPaymentGatewayService.svc?singleWsdl")
public class WebServiceStarMFPaymentGateway extends Service{

	protected WebServiceStarMFPaymentGateway(URL wsdlDocumentLocation, QName serviceName) {
		super(wsdlDocumentLocation, serviceName);
		// TODO Auto-generated constructor stub
	}

	
	private final static URL MFORDER_WSDL_LOCATION;
    private final static WebServiceException MFORDER_EXCEPTION;
    private final static QName MFORDER_QNAME = new QName("http://tempuri.org/", "StarMFPaymentGatewayService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://www.bsestarmf.in/StarMFPaymentGatewayService/StarMFPaymentGatewayService.svc?singleWsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MFORDER_WSDL_LOCATION = url;
        MFORDER_EXCEPTION = e;
    }

    public WebServiceStarMFPaymentGateway() {
        super(__getWsdlLocation(), MFORDER_QNAME);
    }

    public WebServiceStarMFPaymentGateway(WebServiceFeature... features) {
        super(__getWsdlLocation(), MFORDER_QNAME, features);
    }

    public WebServiceStarMFPaymentGateway(URL wsdlLocation) {
        super(wsdlLocation, MFORDER_QNAME);
    }

    public WebServiceStarMFPaymentGateway(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MFORDER_QNAME, features);
    }


    public WebServiceStarMFPaymentGateway(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_IStarMFPaymentGatewayService")
    public IStarMFPaymentGatewayService getWSHttpBindingIStarMFPaymentGatewayService() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IStarMFPaymentGatewayService"), IStarMFPaymentGatewayService.class, new javax.xml.ws.soap.AddressingFeature());
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MFOrderEntry
     */
    @WebEndpoint(name = "WSHttpBinding_IStarMFPaymentGatewayService")
    public IStarMFPaymentGatewayService getWSHttpBindingIStarMFPaymentGatewayService(WebServiceFeature... features) {
    	System.out.println("Inside getWSHttpBindingIStarMFService : start ");
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IStarMFPaymentGatewayService"), IStarMFPaymentGatewayService.class, new javax.xml.ws.soap.AddressingFeature());
        
    }
    
    /**
     * 
     * @return
     *     returns IStarMFPaymentGatewayService
     */
    @WebEndpoint(name = "WSHttpBinding_IStarMFPaymentGatewayService1")
    public IStarMFPaymentGatewayService getWSHttpBindingIStarMFPaymentGatewayService1() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IStarMFPaymentGatewayService1"), IStarMFPaymentGatewayService.class, new javax.xml.ws.soap.AddressingFeature());
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IStarMFPaymentGatewayService
     */
    @WebEndpoint(name = "WSHttpBinding_IStarMFPaymentGatewayService1")
    public IStarMFPaymentGatewayService getWSHttpBindingIStarMFPaymentGatewayService1(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IStarMFPaymentGatewayService1"), IStarMFPaymentGatewayService.class,  new javax.xml.ws.soap.AddressingFeature());
    }
    
    /**
     * 
     * @returns
     *     returns RelevancePortType
     */
    @WebEndpoint(name = "http://tempuri.org/IStarMFPaymentGatewayService/getPassword")
    public GetPassword getRelevancePort() {
        return super.getPort(new QName("http://tempuri.org/IStarMFPaymentGatewayService/getPassword", "GetPassword"), GetPassword.class, new javax.xml.ws.soap.AddressingFeature());
    }

    
    private static URL __getWsdlLocation() {
        if (MFORDER_EXCEPTION!= null) {
            throw MFORDER_EXCEPTION;
        }
        return MFORDER_WSDL_LOCATION;
    }
	

}
