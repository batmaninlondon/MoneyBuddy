/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class PaymentStatusAction extends ActionSupport implements SessionAware  {

	Logger logger = Logger.getLogger(PaymentStatusAction.class);
	private Map<String, Object> sessionMap;
	
    private InputStream stream;

        public String execute() {
    	
		System.out.println("PaymentStatusAction class : execute method : transactionType : "+sessionMap.get("transactionType").toString());

    	logger.debug("PaymentStatusAction class : execute method : start");
    	
    	try {
    		
    		Trading trading = new Trading();
    		trading.checkPaymentStatus(sessionMap.get("customerId").toString());
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    
    	    logger.debug("PaymentStatusAction class : execute method : end");
			return SUCCESS;
		} /*catch (MoneyBuddyException e) {	
			logger.debug("EstimateAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		}*/ 
    	catch (Exception e) {	
			logger.debug("PaymentStatusAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

}
