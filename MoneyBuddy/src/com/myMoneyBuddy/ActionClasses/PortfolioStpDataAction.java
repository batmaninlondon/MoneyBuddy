/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.myMoneyBuddy.ModelClasses.StpDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class PortfolioStpDataAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(PortfolioStpDataAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<StpDataModel> stpDataModel;


	public String execute()   {
		System.out.println(" Called getActiveStpData  ...........................................................................................");
		String customerId = sessionMap.get("customerId").toString();
		QueryProducts queryProducts = new QueryProducts();
		try {
			stpDataModel = queryProducts.getStpData(customerId);
			setStpDataModel(stpDataModel);
			return SUCCESS;
		} catch (MoneyBuddyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}


	public List<StpDataModel> getStpDataModel() {
		return stpDataModel;
	}


	public void setStpDataModel(List<StpDataModel> stpDataModel) {
		this.stpDataModel = stpDataModel;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}
