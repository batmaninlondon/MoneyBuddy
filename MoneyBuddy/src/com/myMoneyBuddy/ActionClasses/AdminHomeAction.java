/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.InsertCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class AdminHomeAction extends ActionSupport  implements SessionAware  {

	private SessionMap<String,Object> sessionMap;
	
    public String execute() {

    	
    	try {
    		
    		sessionMap.remove("customerIdFromAdmin");
    		return SUCCESS;
    		
    	} 
    	catch ( Exception e )  {
    		
    		e.printStackTrace();
    		return ERROR;
    	}
    }
    
	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

}
