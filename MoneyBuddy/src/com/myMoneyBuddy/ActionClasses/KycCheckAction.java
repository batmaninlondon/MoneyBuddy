/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceMFUpload;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.tempuri.IStarMFWebService;
import org.tempuri.MFOrderEntry;

/**
 *
 * @author Savita Wadhwani
 */
public class KycCheckAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(KycCheckAction.class);
	private Map<String, Object> sessionMap;
	
    private String panCard;
    QueryKycStatus kyc = new QueryKycStatus();

    private InputStream stream;
	
/*    public void validate() {
    	
    	logger.debug("KycCheckAction class : validate method : start");
        try {
        	
        if(StringUtils.isEmpty(getPanCard()) )
            addFieldError("panCard","PAN Card number can't be blank!");

        else if (!kyc.existsPanCard(getPanCard()))
            addFieldError("panCard"," PAN Card does not exists.");
        } catch ( MoneyBuddyException e )  {
        	logger.debug("KycCheckAction class : validate method : end");
        	e.printStackTrace();
        }
        logger.debug("KycCheckAction class : validate method : end");

    }*/
    public String execute() {
    	try {
    		
    	logger.debug("KycCheckAction class : execute method : start");
    	System.out.println(" KycCheckAction execute method Called !!");
    	
    	// Savita Wadhwani - Start - Added this block to validate input panCard through ajax call
    	
    	/*if (!kyc.existsPanCard(getPanCard())) {
    		System.out.println(" Returned invalid !!");
    		
    		String str = "invalid";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return "invalid";
    		return SUCCESS;
    	}
    	
    	// Savita Wadhwani - End - Added this block to validate input panCard through ajax call
    	
    	if (kyc.getKycStatusForPanCard(getPanCard()).equalsIgnoreCase("NO"))  {
    		logger.debug("KycCheckAction class : execute method : KYC is not done for "+getPanCard());
    		System.out.println(" Returned KYC not done !!");
    		String str = "kycNotDone";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return SUCCESS;
    	}*/

    	sessionMap.put("panCard", panCard);
    	System.out.println("Kyc is done for panCard : "+panCard);
    	
    	logger.debug("KycCheckAction class : execute method : stored panCard : "+panCard+" in session id : "+sessionMap.getClass().getName());
    	logger.debug("KycCheckAction class : execute method : end");
    	
    	System.out.println(" Returned Success !!");

    	String str = "success";
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
    		logger.error("KycCheckAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
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
