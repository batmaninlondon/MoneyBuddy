/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;
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
	
    public String execute() {
    	
    	System.out.println("RedirectAction : execute method : transactionType : "+getTransactionType());
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - start ");
	    	
    		QueryCustomer queryCustomer = new QueryCustomer();
    		Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
    		System.out.println("kycStaus : "+customer.getKycStatus());
	    	/*System.out.println("custDetUploaded : "+customer.getCusDetailsUploaded());
	    	System.out.println("addCustDetUploaded : "+customer.getAddCusDetailsUploaded());*/
			if ("NC".equals(customer.getKycStatus())) {
				logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned panCardVerifiction");
		    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
				return "panCardVerifiction";
			}
			else if ("DONE".equals(customer.getKycStatus())) {
				if ("Y".equals(customer.getCusDetailsUploaded()))  {
					System.out.println("bankDetails page ");
					logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned bankDetails");
			    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
					return "bankDetails";
				}
				else {
					System.out.println("customerDetails page ");
					logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned customerDetails");
			    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
					return "customerDetails";
				}
			} else  {
				if ("Y".equals(customer.getCusDetailsUploaded()))  {
					if("Y".equals(customer.getAddCusDetailsUploaded())) {
						System.out.println("DownloadKycForm page ");
						logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned downloadKycForm");
				    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
						return "downloadKycForm";
					}
					else {
						System.out.println("addCustomerDetails page ");
						logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned addCustomerDetails");
				    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
						return "addCustomerDetails";
					}
				}
				else {
					System.out.println("customerDetails page ");
					logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - returned customerDetails");
			    	logger.debug("RedirectAction class - execute method - customerId - "+customerId+" - end");
					return "customerDetails";
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

}
