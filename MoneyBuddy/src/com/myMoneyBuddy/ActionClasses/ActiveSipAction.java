/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class ActiveSipAction extends ActionSupport implements SessionAware{
	
	Logger logger = LogManager.getLogger(ActiveSipAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<SipDataModel> sipDataModel = new LinkedList<SipDataModel>();
	private String totalSips;
	
	public String execute() {

		String customerId = sessionMap.get("customerId").toString();
		
		try {
		
		QueryProducts queryProducts = new QueryProducts();
		
		if ( sessionMap.get("totalSips") != null ) {
			setTotalSips(queryProducts.getTotalSipTransactions(customerId));
			if ( !getTotalSips().equals("0") )  {
				sipDataModel = queryProducts.getSipData(customerId);
			}
			setSipDataModel(sipDataModel);
			sessionMap.put("totalSips", getTotalSips());
		}
		
		    	
		return SUCCESS;
		}
		catch (MoneyBuddyException e) {	
			logger.error("PortfolioAction class : execute method : Caught MoneyBuddyException for customerId : "+customerId);
			e.printStackTrace();
			
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("PortfolioAction class : execute method : Caught Exception for customerId : "+customerId);
			e.printStackTrace();
			
			return ERROR;
		} 
	}


	public List<SipDataModel> getSipDataModel() {
		return sipDataModel;
	}


	public void setSipDataModel(List<SipDataModel> sipDataModel) {
		this.sipDataModel = sipDataModel;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }



	public String getTotalSips() {
		return totalSips;
	}


	public void setTotalSips(String totalSips) {
		this.totalSips = totalSips;
	}

}
