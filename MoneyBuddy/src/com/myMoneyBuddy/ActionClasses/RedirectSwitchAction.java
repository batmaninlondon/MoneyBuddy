/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryBankDetails;
import com.myMoneyBuddy.DAOClasses.QueryDisplayName;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.opensymphony.xwork2.ActionSupport;

public class RedirectSwitchAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(RedirectSwitchAction.class);
	private SessionMap<String,Object> sessionMap;

	private String displayBankName;
	
    public String execute() {
    	
    	System.out.println("RedirectSwitchAction : execute method -start ");
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();

    		
    		logger.debug("RedirectSwitchAction class - execute method - customerId - "+customerId+" - start ");
	    	

	    	QueryBankDetails queryBankDetails = new QueryBankDetails();
	    	BankDetails bankDetails = queryBankDetails.fetchBankDetails(customerId);
	    	String bankName = bankDetails.getBankName();
	    	QueryDisplayName queryDisplayName = new QueryDisplayName();
	    	DesEncrypter desEncrypter = new DesEncrypter();
			String accNum = desEncrypter.decrypt(bankDetails.getAccountNumber());
			
			setDisplayBankName(queryDisplayName.displayBankName(bankName)+"********"+accNum.substring(accNum.length()-4));
			
			logger.debug("RedirectSwitchAction class - execute method - customerId - "+customerId+" - returned orderConfirmationForSwitch");
	    	logger.debug("RedirectSwitchAction class - execute method - customerId - "+customerId+" - end");
	    	
			return "orderConfirmationForSwitch";
			
    	} 
    	catch ( Exception e )  {
    		logger.error("RedirectSwitchAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    	    logger.error("RedirectSwitchAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getDisplayBankName() {
		return displayBankName;
	}

	public void setDisplayBankName(String displayBankName) {
		this.displayBankName = displayBankName;
	}

}
