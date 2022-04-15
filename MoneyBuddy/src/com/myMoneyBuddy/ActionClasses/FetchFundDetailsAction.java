/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class FetchFundDetailsAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(FetchFundDetailsAction.class);
	private SessionMap<String,Object> sessionMap;
	private InputStream stream;
	private List<FundDetailsDataModel> fundDetailsDataModel;
	
    public String execute() {
  	
    	try {
    		logger.debug("FetchFundDetailsAction class - execute method - start");

    		System.out.println("Calling FetchFundDetailsAction class - start ");
			
			
			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();

			fundDetailsDataModel = queryPrimaryFundDetails.getFundDetailsData();
			//setFundDetailsDataModel(fundDetailsDataModel);
			
			//sessionMap.put("fundDetailsDataModel", fundDetailsDataModel);
			//logger.debug("FetchFundDetailsAction class - execute method - stored fundDetailsDataModel in sessionMap");

			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    
    	    logger.debug("FetchFundDetailsAction class - execute method - returned success");
    	    logger.debug("FetchFundDetailsAction class - execute method - end");
    	    
			return SUCCESS;
		} 
    	catch (Exception e) {	
    		logger.error("FetchFundDetailsAction class - execute method - Caught Exception");
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.error("FetchFundDetailsAction class - execute method - returned error");
    	    
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


	public List<FundDetailsDataModel> getFundDetailsDataModel() {
		return fundDetailsDataModel;
	}


	public void setFundDetailsDataModel(List<FundDetailsDataModel> fundDetailsDataModel) {
		this.fundDetailsDataModel = fundDetailsDataModel;
	}


}
