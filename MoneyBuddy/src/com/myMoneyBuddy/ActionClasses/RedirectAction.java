/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryBankDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class RedirectAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(RedirectAction.class);
	private SessionMap<String,Object> sessionMap;

	private String transactionType;
	private String tranDetailId;
	
    public String execute() {
    	
    	System.out.println("RedirectAction : execute method : transactionType : "+getTransactionType());
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();

    		if ("".equals(getTranDetailId()) || null == getTranDetailId())   {
    			setTranDetailId("NotSet");
    		}
    		
    		logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - start ");
	    	
    		QueryCustomer queryCustomer = new QueryCustomer();
    		Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
    		// System.out.println("kycStaus : "+customer.getKycStatus());
    		
    		if ("ACTIVATED".equals(customer.getAofFormStatus()))  {
    			logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned bankDetails");
		    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
		    	
				return "bankDetails";
    		}
    		else {
    			if ("N".equals(customer.getCusDetailsUploaded()))  {
    				logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned panCardVerifiction");
    		    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
    				return "customerDetails";
    			}
    			else {
    				if ("DONE".equals(customer.getKycStatus()))  {
						logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned downloadKycForm");
				    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
						return "aofNotDone";
    				}
    				else {
    					if ("Y".equals(customer.getAddCusDetailsUploaded()))  {
    						logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned downloadKycForm");
    				    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
    						return "aofNotDone";
    					}
    					else {
    						logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned addCustomerDetails");
    				    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
    						return "addCustomerDetails";
    					}
    				}
    			}
    		}
			
    	} 
    	catch ( Exception e )  {
    		logger.error("RedirectAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    	    logger.error("RedirectAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(String tranDetailId) {
		this.tranDetailId = tranDetailId;
	}

}
