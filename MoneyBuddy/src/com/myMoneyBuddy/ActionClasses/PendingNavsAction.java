/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class PendingNavsAction extends ActionSupport implements SessionAware  {

	
	
	Logger logger = Logger.getLogger(PendingNavsAction.class);
	private Map<String, Object> sessionMap;

	private InputStream stream;
	
	private List<FundDetailsDataModel> fundDetailsDataModel;
	
    public String execute() {

    	logger.debug("PendingNavsAction class : execute method : start");
    	
    	try {
			System.out.println("Calling FetchFundDetailsAction class - start ");
			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();

			fundDetailsDataModel = queryPrimaryFundDetails.getFundDetailsData();
			setFundDetailsDataModel(fundDetailsDataModel);
			
			sessionMap.put("fundDetailsDataModel", fundDetailsDataModel);
			logger.debug("FetchFundDetailsAction class : execute method : stored fundDetailsDataModel in session id : "+sessionMap.getClass().getName());
			
			logger.debug("FetchFundDetailsAction class : execute method : end");
			
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.debug("FetchFundDetailsAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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


	public List<FundDetailsDataModel> getFundDetailsDataModel() {
		return fundDetailsDataModel;
	}


	public void setFundDetailsDataModel(List<FundDetailsDataModel> fundDetailsDataModel) {
		this.fundDetailsDataModel = fundDetailsDataModel;
	}


}
