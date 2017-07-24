package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;

public class FetchProductListAction  extends ActionSupport implements SessionAware{

	Logger logger = Logger.getLogger(FetchProductListAction.class);
	private Map<String, Object> sessionMap;
	
	private String riskCategory;
	
	private InputStream stream;
    public String execute()  {
    	
    	try {
    		logger.debug("LoginAction class : execute method : start");
    	
	    	System.out.println("FetchProductListAction called ");
	    	System.out.println("FetchProductListAction: execute method : transactionType : "+sessionMap.get("transactionType").toString());
	    	//System.out.println("FetchProductListAction value of riskCategory : "+getRiskCategory());
	    	
	    	QueryProducts queryProduct = new QueryProducts();
	    	//System.out.println("LoginAction class : execute method : riskCategory : "+getRiskCategory());
	    	//System.out.println("LoginAction class : execute method : planName : "+sessionMap.get("planName").toString());
	   	 	HashMap<String,Double> productList = queryProduct.getProductList(getRiskCategory(),sessionMap.get("planName").toString());
	   	 	
	    	//System.out.println("FetchProductListAction Hi There 1 ");
	   	 
	   	 	sessionMap.put("productList", productList);
	   	 	logger.debug("LoginAction class : execute method : stored groupNamesList in session id : "+sessionMap.getClass().getName());
	       	logger.debug("LoginAction class : execute method : end");
	  
	       	
		   	 /*for (String key : productList.keySet()) {
		   		 System.out.println("key : "+key);
		   		System.out.println("value : "+productList.get(key));
		
			 }*/
	   	 
	   	 
	    	//System.out.println("FetchProductListAction Hi There 2 ");
	    	
	    	String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());
	    	return SUCCESS;
	    	
		} catch (MoneyBuddyException e) {	
    		logger.debug("FetchProductListAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("FetchProductListAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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

	public String getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}
    

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}   

}
