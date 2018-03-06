/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceStarMF;
import com.ndml.kra.pan.webservice.service.GetPasscode;
import com.ndml.kra.pan.webservice.service.GetPasscodeResponse;
import com.ndml.kra.pan.webservice.service.ObjectFactory;
import com.ndml.kra.pan.webservice.service.PANServiceImpl;
import com.ndml.kra.pan.webservice.service.PANServiceImplService;
import com.ndml.kra.pan.webservice.service.PanInquiryDetails;
import com.ndml.kra.pan.webservice.service.PanInquiryDetailsResponse;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.PasswordRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.tempuri.IStarMFWebService;
import org.tempuri.MFOrderEntry;

/**
 *
 * @author Savita Wadhwani
 */
public class PanCardVerificationAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(PanCardVerificationAction.class);
	private Map<String, Object> sessionMap;
	
    private String panCard;

    private InputStream stream;

    public String execute() {
    	    	
    	try {
    		logger.debug("PanCardVerificationAction class : execute method : start");
        	System.out.println(" PanCardVerificationAction execute method Called !!");
        	System.out.println(" PanCardVerificationAction execute method : panCard : "+getPanCard());
    		
    		UpdateCustomer updatecustomerPancard = new UpdateCustomer();
    		
    		String customerId = sessionMap.get("customerId").toString();
    		
    	

    	System.out.println(" PanCardVerificationAction execute method : PanCard : "+getPanCard());

    	// Savita Wadhwani - We need to update this piece of code with real API - start
    	
		Properties configProperties = new Properties();
		String configPropFilePath = "../../../config/config.properties";

		configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));
		
		/*String password = configProperties.getProperty("KYC_PASSWORD");
		String userId = configProperties.getProperty("KYC_USER_ID");
		String miId = configProperties.getProperty("KYC_MI_ID");
		String mobileNo = configProperties.getProperty("KYC_MOBILE_NO");
		String encryptionKey = configProperties.getProperty("KYC_ENCRYPTION_KEY");*/
		
		
		String password = "NDML@1234";
		String userId = "TEST";
		String miId = "Z0589";
		String mobileNo = "7875898574";
		String encryptionKey = "83";
		
		
    	PANServiceImplService wbPanService = new PANServiceImplService();
    	PANServiceImpl panServiceImpl = wbPanService.getPANServiceImplPort();

    	String encryptedPassword = panServiceImpl.getPasscode(password,encryptionKey);

		System.out.println("encryptedPassword : "  +encryptedPassword);
		
		String panCard = "AAXPW9277C";
		String requestNum = "1234512346";
		
		String requestXml = "<APP_REQ_ROOT>"
								+ "<APP_PAN_INQ>"
									+ "<APP_PAN_NO>"+panCard+"</APP_PAN_NO>"
									+ "<APP_MOBILE_NO>"+mobileNo+"</APP_MOBILE_NO>"
									+ "<APP_REQ_NO>"+requestNum+"</APP_REQ_NO>"
								+ "</APP_PAN_INQ>"
							+ "</APP_REQ_ROOT>";		
		
		String res = panServiceImpl.panInquiryDetails(requestXml, userId, encryptedPassword, miId);
		
		System.out.println("RES is "+res);
		
		
		
		
		String num1 = getPanCard().substring(5,9);
		String str;
		System.out.println(" num1 is : "+num1);
		System.out.println(" (Integer.parseInt(num1) % 2) is : "+(Integer.parseInt(num1) % 2));
		String kycStatus = null;
		if ( (Integer.parseInt(num1) % 2) != 0) {
			
			kycStatus= "DONE";
			sessionMap.put("kycStatus", "DONE");
			str = "kycDone";
		}
		else {
			kycStatus = "NOTDONE";
			sessionMap.put("kycStatus", "NOTDONE");
			str = "kycNotDone";
			
		}
		
		updatecustomerPancard.updatePancard(customerId, getPanCard(), kycStatus);
		
		sessionMap.put("panCard", panCard);
    	logger.debug("PanCardVerificationAction class : execute method : stored panCard : "+panCard+" in session id : "+sessionMap.getClass().getName());
    	
    	sessionMap.put("kycStatus", kycStatus);
    	logger.debug("PanCardVerificationAction class : execute method : stored kycStatus : "+kycStatus+" in session id : "+sessionMap.getClass().getName());
    	
		// Savita Wadhwani - We need to update this piece of code with real API - end

    	logger.debug("PanCardVerificationAction class : execute method : end");
    	
    	System.out.println(" Returned Success !!");

    	stream = new ByteArrayInputStream(str.getBytes());

    	return SUCCESS;
    	} 
    	/*catch ( MoneyBuddyException e )  {
    		logger.error("KycCheckAction class : execute method : caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}*/
    	catch ( Exception e )  {
    		logger.error("PanCardVerificationAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    

    public Map<String, Object> getSession() {
		return sessionMap;
	}
    
	public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

}
