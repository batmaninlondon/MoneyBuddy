/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryBankDetails;
import com.myMoneyBuddy.DAOClasses.QueryBankName;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class RedirectRedeemAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(RedirectRedeemAction.class);
	private SessionMap<String,Object> sessionMap;

	private String displayBankName;
	
    public String execute() {
    	
    	System.out.println("RedirectRedeemAction : execute method -start ");
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();

    		
    		logger.debug("RedirectRedeemAction class - execute method - customerId - "+customerId+" - start ");
	    	

	    	QueryBankDetails queryBankDetails = new QueryBankDetails();
	    	BankDetails bankDetails = queryBankDetails.fetchBankDetails(customerId);
	    	String bankName = bankDetails.getBankName();
	    	QueryBankName queryBankName = new QueryBankName();
	    	DesEncrypter desEncrypter = new DesEncrypter();
			String accNum = desEncrypter.decrypt(bankDetails.getAccountNumber());
			
			setDisplayBankName(queryBankName.displayBankName(bankName)+"********"+accNum.substring(accNum.length()-4));
			
			logger.debug("RedirectRedeemAction class - execute method - customerId - "+customerId+" - returned orderInvoiceForRed");
	    	logger.debug("RedirectRedeemAction class - execute method - customerId - "+customerId+" - end");
	    	
			return "orderInvoiceForRed";
			
    	} 
    	catch ( Exception e )  {
    		logger.error("RedirectRedeemAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    	    logger.error("RedirectRedeemAction class - execute method - customerId - "+customerId+" - returned error");
    	    
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
