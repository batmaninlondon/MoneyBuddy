/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.opensymphony.xwork2.ActionSupport;

public class FetchAvailableStpFundsAction extends ActionSupport  {

	Logger logger = Logger.getLogger(FetchAvailableStpFundsAction.class);
	private String stpFundId;
	private String stpAmount;
	private String schemeName;
	private HashMap<String,String> availableFundsList;
	
    public String execute() {
  	
    	try {
    		logger.debug("FetchAvailableStpFundsAction class - execute method - start");
			System.out.println("Calling FetchAvailableStpFundsAction class - start ");
			System.out.println("FetchAvailableStpFundsAction class - stpAmount : "+getStpAmount());
			
			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
			
			schemeName = queryPrimaryFundDetails.getSchemeName(getStpFundId());
			
			availableFundsList = queryPrimaryFundDetails.getAvailableStpFundsList(getStpFundId());
			
			
			int rangeAmount = (( Double.valueOf(getStpAmount()).intValue())/100);
			
			setStpAmount(Integer.toString(rangeAmount*100));
			
			System.out.println("FetchAvailableStpFundsAction class - stpAmount after change : "+getStpAmount());
			
    	    logger.debug("FetchAvailableStpFundsAction class - execute method - returned success");
    	    logger.debug("FetchAvailableStpFundsAction class - execute method - end");
    	    
			return SUCCESS;
		} 
    	catch (Exception e) {	
    		logger.error("FetchAvailableStpFundsAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("FetchAvailableStpFundsAction class - execute method - returned error");
    	    
			return ERROR;
		} 

    }


	public String getStpFundId() {
		return stpFundId;
	}


	public void setStpFundId(String stpFundId) {
		this.stpFundId = stpFundId;
	}


	public String getStpAmount() {
		return stpAmount;
	}


	public void setStpAmount(String stpAmount) {
		this.stpAmount = stpAmount;
	}

	public String getSchemeName() {
		return schemeName;
	}


	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}


	public HashMap<String, String> getAvailableFundsList() {
		return availableFundsList;
	}

	public void setAvailableFundsList(HashMap<String, String> availableFundsList) {
		this.availableFundsList = availableFundsList;
	}


}
