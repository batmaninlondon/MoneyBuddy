/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.opensymphony.xwork2.ActionSupport;

public class RedeemFundAction extends ActionSupport  {

	Logger logger = LogManager.getLogger(RedeemFundAction.class);
	private String redeemFundId;
	private String redeemSchemeName;
	private String folioNum;
	private String totalAmount;
	private String totalQuantity;
	
	
    public String execute() {
  	
    	try {
    		logger.debug("RedeemFundAction class - execute method - start");
			System.out.println("Calling RedeemFundAction class - start ");
			System.out.println("RedeemFundAction class - redeemFundId : "+getRedeemFundId());

			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
			redeemSchemeName = queryPrimaryFundDetails.getSchemeName(getRedeemFundId());
		
    	    logger.debug("RedeemFundAction class - execute method - returned success");
    	    logger.debug("RedeemFundAction class - execute method - end");
    	    
    	    return SUCCESS;
		} 
    	catch (Exception e) {	
    		logger.error("RedeemFundAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("RedeemFundAction class - execute method - returned error");
    	    
			return ERROR;
		} 

    }


	public String getRedeemFundId() {
		return redeemFundId;
	}

	public void setRedeemFundId(String redeemFundId) {
		this.redeemFundId = redeemFundId;
	}

	public String getRedeemSchemeName() {
		return redeemSchemeName;
	}


	public void setRedeemSchemeName(String redeemSchemeName) {
		this.redeemSchemeName = redeemSchemeName;
	}


	public String getFolioNum() {
		return folioNum;
	}


	public void setFolioNum(String folioNum) {
		this.folioNum = folioNum;
	}


	public String getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getTotalQuantity() {
		return totalQuantity;
	}


	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}




}
