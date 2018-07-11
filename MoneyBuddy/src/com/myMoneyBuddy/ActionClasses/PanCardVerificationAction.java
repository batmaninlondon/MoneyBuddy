/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.ndml.kra.pan.webservice.service.PANServiceImpl;
import com.ndml.kra.pan.webservice.service.PANServiceImplService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class PanCardVerificationAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(PanCardVerificationAction.class);
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
		
		
    	PANServiceImplService wbPanService = new PANServiceImplService();
    	PANServiceImpl panServiceImpl = wbPanService.getPANServiceImplPort();

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
		
		System.out.println("RES is "+res);
		
		
		
		
		String num1 = getPanCard().substring(5,9);
		//String str;
		System.out.println(" num1 is : "+num1);
		System.out.println(" (Integer.parseInt(num1) % 2) is : "+(Integer.parseInt(num1) % 2));
		String kycStatus = null;
		if ( (Integer.parseInt(num1) % 2) != 0) {
			
			kycStatus= "DONE";
			//sessionMap.put("kycStatus", "DONE");
			//str = "kycDone";
		}
		else {
			kycStatus = "NOTDONE";
			//sessionMap.put("kycStatus", "NOTDONE");
			//str = "kycNotDone";
			
		}
		
		updatecustomer.updatePancardAndKycStatus(customerId, getPanCard(), kycStatus);
		
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
