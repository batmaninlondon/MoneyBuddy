/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.InsertOldPortfolioRecords;
import com.myMoneyBuddy.DAOClasses.QueryOldPortfolioRecords;
import com.opensymphony.xwork2.ActionSupport;

public class AddOldPortfoioRecordAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(AddOldPortfoioRecordAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String schemeName;
	private String otherSchemeName;
	private String isin;
	private String currentAmount;
	private String currentUnits;
	private String customerIdOldPortfolio;
	private String folioNumber;

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		
    		customerId = customerIdOldPortfolio;
    		InsertOldPortfolioRecords insertOldPortfolioRecords = new InsertOldPortfolioRecords();
    		
    		String selSchemeName = schemeName;
    		String selIsin ;
    		if ( "Others".equalsIgnoreCase(selSchemeName))  {
    			selSchemeName = otherSchemeName;
    			selIsin = isin;
    		}
    		else 
    		{
    			QueryOldPortfolioRecords queryOldPortfolioRecords = new QueryOldPortfolioRecords();
    			selIsin = queryOldPortfolioRecords.fetchIsin(customerId, selSchemeName);
    			
    		}
    		
    		QueryOldPortfolioRecords queryOldPortfolioRecords = new QueryOldPortfolioRecords();
    		
    		if ( queryOldPortfolioRecords.existSameRow(customerId, selSchemeName, folioNumber) ) {
    			
    			addActionMessage(" Same Row Exists, Please try again !");
    		}
    		else {
    			insertOldPortfolioRecords.insertRow(customerId, selSchemeName, selIsin, currentAmount, currentUnits, folioNumber, currentAmount);
    		
    		addActionMessage(" New Portfolio Record added successfully !");
    		}
	
	    	return SUCCESS;
	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("AddOldPortfoioRecordAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("AddOldPortfoioRecordAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getOtherSchemeName() {
		return otherSchemeName;
	}

	public void setOtherSchemeName(String otherSchemeName) {
		this.otherSchemeName = otherSchemeName;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(String currentAmount) {
		this.currentAmount = currentAmount;
	}

	public String getCurrentUnits() {
		return currentUnits;
	}

	public void setCurrentUnits(String currentUnits) {
		this.currentUnits = currentUnits;
	}

	public String getCustomerIdOldPortfolio() {
		return customerIdOldPortfolio;
	}

	public void setCustomerIdOldPortfolio(String customerIdOldPortfolio) {
		this.customerIdOldPortfolio = customerIdOldPortfolio;
	}

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}



}
