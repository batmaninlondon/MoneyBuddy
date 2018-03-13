/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class PendingNavsAction extends ActionSupport implements SessionAware,Action  {

	
	
	Logger logger = Logger.getLogger(PendingNavsAction.class);
	private Map<String, Object> sessionMap;

	private InputStream stream;
	
	private HashMap<String,String>  pendingNavOrders ;
	
	private String dummyValue;
	
	
    public String execute() {

    	logger.debug("PendingNavsAction class : execute method : start");

    	
    	dummyValue = "Hello";
    	
    	try {
			System.out.println("Calling PendingNavsAction class - start ");
			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();

			pendingNavOrders = queryTransactionDetails.getPendingNavsOrders();

			Iterator it = pendingNavOrders.entrySet().iterator();
			 
			while ( it.hasNext() )  {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println("PendingNavsAction class : execute method : key : "+pair.getKey()+" and value : "+pair.getValue());
				
			}
			
			logger.debug("PendingNavsAction class : execute method : end");
			
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.debug("PendingNavsAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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


	public HashMap<String, String> getPendingNavOrders() {
		return pendingNavOrders;
	}


	public void setPendingNavOrders(HashMap<String, String> pendingNavOrders) {
		this.pendingNavOrders = pendingNavOrders;
	}


	public String getDummyValue() {
		return dummyValue;
	}


	public void setDummyValue(String dummyValue) {
		this.dummyValue = dummyValue;
	}




}
