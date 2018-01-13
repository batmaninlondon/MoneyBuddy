/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class GeneratePackageAction extends ActionSupport implements SessionAware  {

	
	
	Logger logger = Logger.getLogger(GeneratePackageAction.class);
	private Map<String, Object> sessionMap;
    
    private InputStream stream;

    public String execute() {
    	
		System.out.println("generatePackageAction call called ");
		
	
    	logger.debug("EstimateAction class : execute method : start");
    	
    	try {

	    	QueryProducts queryProduct = new QueryProducts();

	   	 	HashMap<String,Double> productRatioList = queryProduct.getProductList("3","SAVE_TAX");
			

			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    

	   	    Iterator it = productRatioList.entrySet().iterator();

	   	    while (it.hasNext()) {
	   	        Map.Entry pair = (Map.Entry)it.next();
	   	        if ("minLumsumAmount".equals(pair.getKey())) {
	   	        	sessionMap.put("minLumsumAmt", pair.getValue());
	   	        	it.remove();
	   	        }
	   	        else  if ("minSipAmount".equals(pair.getKey())) {
	   	        	sessionMap.put("minSipAmount", pair.getValue());
	   	        	it.remove();
	   	        }
	   	        else  if ("minSipDuration".equals(pair.getKey())) {
	   	        	int i = (int) Double.parseDouble(pair.getValue().toString());
	   	        
	   	        	if ((i%12)!= 0 )  {
	   	        		i = (i /12) +1;
	   	        	}
	   	        	else {
	   	        		i = (i/12);
	   	        	}
	   	        	System.out.println("minSipDuration : "+i);
	   	        	sessionMap.put("minSipDuration",i);
	   	        	it.remove();
	   	        }
	   	        
	   	        
	   	        /*Double amount = ((   Double.valueOf(pair.getValue().toString()) * Double.valueOf("4000") ) /100);
	   	        pair.setValue(amount);*/

	   	        
	   	    }
	   	    it = productRatioList.entrySet().iterator();
		   	 while (it.hasNext()) {
		   		Map.Entry pair = (Map.Entry)it.next();
		   		System.out.println(" Entry in productRatioList : "+pair.getKey() + " = " + pair.getValue()); 
		   	 }
	   	 	sessionMap.put("productRatioList", productRatioList);
   	 	
	   	 	logger.debug("EstimateAction class : execute method : stored productRatioList in session id : "+sessionMap.getClass().getName());

			logger.debug("EstimateAction class : execute method : end");
			return SUCCESS;
		} catch (MoneyBuddyException e) {	
			logger.debug("EstimateAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
			logger.debug("EstimateAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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


	public static String theMonth(int month){
	    String[] monthNames = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	    return monthNames[month];
	}

}
