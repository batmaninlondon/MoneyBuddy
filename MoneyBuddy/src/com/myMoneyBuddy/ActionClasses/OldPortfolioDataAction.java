/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryOldPortfolioRecords;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.OldPortfolioDataModel;
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class OldPortfolioDataAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(OldPortfolioDataAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<OldPortfolioDataModel> oldPortfolioDataModel = new LinkedList<OldPortfolioDataModel>();


	public String execute()   {
		System.out.println(" Called getOldPortfolioData  ...........................................................................................");
		String customerId = sessionMap.get("customerId").toString();
		QueryOldPortfolioRecords queryOldPortfolioRecords = new QueryOldPortfolioRecords();
		try {
			String totalOldRecords = queryOldPortfolioRecords.getTotalOldRecords(customerId);
			
			if ( !"0".equals(totalOldRecords) )  {
			
				oldPortfolioDataModel = queryOldPortfolioRecords.getOldRecordsData(customerId);
			}
			return SUCCESS;
		} catch (MoneyBuddyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}

	public List<OldPortfolioDataModel> getOldPortfolioDataModel() {
		return oldPortfolioDataModel;
	}


	public void setOldPortfolioDataModel(List<OldPortfolioDataModel> oldPortfolioDataModel) {
		this.oldPortfolioDataModel = oldPortfolioDataModel;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}
