/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.ndml.kra.pan.webservice.service.PANServiceImpl;
import com.ndml.kra.pan.webservice.service.PANServiceImplService;
import com.opensymphony.xwork2.ActionSupport;

public class PanCardVerificationAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(PanCardVerificationAction.class);
	private SessionMap<String,Object> sessionMap;
	
    private String panCard;

    //private InputStream stream;

    public String execute() {
    	    	
    	try {
    		logger.debug("PanCardVerificationAction class : execute method : start");
        	System.out.println(" PanCardVerificationAction execute method Called !!");
        	System.out.println(" PanCardVerificationAction execute method : panCard : "+getPanCard());
    		
    		UpdateCustomer updatecustomer = new UpdateCustomer();
    		
    		String customerId = sessionMap.get("customerId").toString();
    		
    	

    	System.out.println(" PanCardVerificationAction execute method : PanCard : "+getPanCard());

    	// Savita Wadhwani - We need to update this piece of code with real API - start
    	
		Properties configProperties = new Properties();
		String configPropFilePath = "../../../config/config.properties";

		configProperties.load(PanCardVerificationAction.class.getResourceAsStream(configPropFilePath));
		
		String password = configProperties.getProperty("KYC_PASSWORD");
		String userId = configProperties.getProperty("KYC_USER_ID");
		String miId = configProperties.getProperty("KYC_MI_ID");
		String mobileNo = configProperties.getProperty("KYC_MOBILE_NO");
		String encryptionKey = configProperties.getProperty("KYC_ENCRYPTION_KEY");
		
		
		/*String password = "NDML@1234";
		String userId = "TEST";
		String miId = "Z0589";
		String mobileNo = "7875898574";
		String encryptionKey = "83";*/
		
		/*String certificatesTrustStorePath = "C://Program Files/Java/jdk1.8.0_161/jre/lib/security/cacerts";
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");*/
		
		System.setProperty("com.sun.security.enableAIAcaIssuers", "true");
		
		//java.net.URL wsdlURL = new URL("https://kra.ndml.in/sms-ws/PANServiceImplService/PANServiceImplService");
		
		//ObjectFactory objectFac = new ObjectFactory();
    	PANServiceImplService wbPanService = new PANServiceImplService();
    	PANServiceImpl panServiceImpl = wbPanService.getPANServiceImplPort();

    	
    	//System.out.println(" service name is : "+wbPanService.getServiceName());
    	BindingProvider bindingProvider = (BindingProvider) panServiceImpl;
    	bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://kra.ndml.in/sms-ws/PANServiceImplService");

    	
    	/*GetPasscode abc = objectFac.createGetPasscode();
    	abc.setArg0(password);
    	abc.setArg1(encryptionKey);
    	
    	objectFac.createGetPasscode(abc);
    	
    	
    	GetPasscodeResponse abcRes = objectFac.createGetPasscodeResponse();
   
    	
    	System.out.println("arg 0 is : "+abc.getArg0());
    	System.out.println("arg 1 is : "+abc.getArg1());
    	*/
    	
    	/*System.out.println(" Hello abcRes : "+abcRes.getReturn().toString());*/

    	/*String encryptedPassword = panServiceImpl.getPasscode(abc.getArg0(),abc.getArg1());*/
    	
    	String encryptedPassword = panServiceImpl.getPasscode(password,encryptionKey);

		System.out.println("encryptedPassword : "  +encryptedPassword);

		String requestNum = "1234512346";
		
		String requestXml = "<APP_REQ_ROOT>"
								+ "<APP_PAN_INQ>"
									+ "<APP_PAN_NO>"+getPanCard()+"</APP_PAN_NO>"
									+ "<APP_MOBILE_NO>"+mobileNo+"</APP_MOBILE_NO>"
									+ "<APP_REQ_NO>"+requestNum+"</APP_REQ_NO>"
								+ "</APP_PAN_INQ>"
							+ "</APP_REQ_ROOT>";		
		
		//String res = panServiceImpl.panInquiryDetails(requestXml, userId, encryptedPassword, miId);
		String res = panServiceImpl.panInquiryDetails(requestXml, userId, encryptedPassword, encryptionKey);
		
		
		
		
		
/*		
		 SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		 URL url = new URL("https://kra.ndml.in/sms-ws/PANServiceImplService");
		  URL url = new URL(null, "https://kra.ndml.in/sms-ws/PANServiceImplService", new sun.net.www.protocol.https.Handler());
		  HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
		  conn.setSSLSocketFactory(sslsocketfactory);
		  System.setProperty("javax.net.ssl.trustStoreType", "jks");
		  System.setProperty("javax.net.ssl.keyStore", "C:\\Users\\Work-PC\\Desktop\\cake print\\kra.cer"); 	  
		  Certificate provided by ndml. Provide Path to that
		   * Then create a keystore from the Pfx provided
		   
		  System.setProperty("javax.net.ssl.trustStore","C:\\Program Files\\Java\\jre1.8.0_161\\bin\\keystore.jks");
		  
		  PANServiceImplProxy proxyClientService =new PANServiceImplService();
		  PANServiceImpl proxyClient = proxyClientService.getPANServiceImplPort();
			// Get the encrypted password using getPassCode function
			// Parameters are: your mi password and passkey
			// Passkey can be any 3 characters
			String encryptedPassword=proxyClient.getPasscode(password, encryptionKey);
			System.out.println("### ENCRYPTED PASSWORD IS: " + encryptedPassword + " ###");
			String requestXMl="<APP_REQ_ROOT><APP_PAN_INQ>	<APP_PAN_NO>"+panCard+"</APP_PAN_NO>	<APP_MOBILE_NO>"+mobileNo+"</APP_MOBILE_NO>	<APP_REQ_NO>1234567890</APP_REQ_NO>	</APP_PAN_INQ></APP_REQ_ROOT>";
			System.out.println("### REQUEST XML IS: " + requestXMl + " ###");
			
					// 	Inquire the pan using panInquiryDetails function
					// Parameters are: xml request, mi user id, encrypted password recieved from getPasscode function and 
					// passkey that was use earlier.
			String inquiryResponse=proxyClient.panInquiryDetails(requestXMl, userId, encryptedPassword, encryptionKey);
			System.out.println("RESPONSE IS: " + inquiryResponse + "");*/
			
			
			
		
		
		
		
		
		
		
		System.out.println("RES is "+res);
		
		
		
		
		String num1 = getPanCard().substring(5,9);
		//String str;
		System.out.println(" num1 is : "+num1);
		System.out.println(" (Integer.parseInt(num1) % 2) is : "+(Integer.parseInt(num1) % 2));
		String kycStatus = null;
		/*if ( (Integer.parseInt(num1) % 2) != 0) {
			
			kycStatus= "DONE";
			//sessionMap.put("kycStatus", "DONE");
			//str = "kycDone";
		}
		else {
			kycStatus = "NOTDONE";
			//sessionMap.put("kycStatus", "NOTDONE");
			//str = "kycNotDone";
			
		}*/
		kycStatus= "DONE";
		
		//updatecustomer.updatePancardAndKycStatus(customerId, getPanCard(), kycStatus);
		
		/*sessionMap.put("panCard", getPanCard());
    	logger.debug("PanCardVerificationAction class : execute method : stored panCard : "+getPanCard()+" in session id : "+sessionMap.getClass().getName());*/
    	
    	/*sessionMap.put("kycStatus", kycStatus);
    	logger.debug("PanCardVerificationAction class : execute method : stored kycStatus : "+kycStatus+" in session id : "+sessionMap.getClass().getName());
    	*/
		// Savita Wadhwani - We need to update this piece of code with real API - end

    	logger.debug("PanCardVerificationAction class : execute method : end");
    	
    	System.out.println(" Returned Success !!");

    	//stream = new ByteArrayInputStream(str.getBytes());

    	return SUCCESS;
    	}
    	catch ( Exception e )  {
    		logger.error("PanCardVerificationAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }
    
	public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }
/*
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/

}
