/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.Trading;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentStatusAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(PaymentStatusAction.class);
	private SessionMap<String,Object> sessionMap;
	
    private InputStream stream;

        public String execute() {
    	
		System.out.println("PaymentStatusAction class : execute method : transactionType : "+sessionMap.get("transactionType").toString());

    	logger.debug("PaymentStatusAction class : execute method : start");
    	
    	try {
    		
    		Trading trading = new Trading();
    		//trading.checkPaymentStatus(sessionMap.get("customerId").toString());
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    
    	    logger.debug("PaymentStatusAction class : execute method : end");
			return SUCCESS;
		}  
    	catch (Exception e) {	
			logger.error("PaymentStatusAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 

    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

}
