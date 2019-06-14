/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

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
