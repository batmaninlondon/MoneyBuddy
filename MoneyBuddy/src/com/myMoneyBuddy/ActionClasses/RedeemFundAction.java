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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class RedeemFundAction extends ActionSupport  {

	Logger logger = Logger.getLogger(RedeemFundAction.class);
	private String redeemFundId;
	private String redeemFundName;
	private String folioNum;
	private String totalAmount;
	private String totalQuantity;
	
	
    public String execute() {
  	
    	try {
    		logger.debug("RedeemFundAction class - execute method - start");
			System.out.println("Calling RedeemFundAction class - start ");
			System.out.println("RedeemFundAction class - redeemFundId : "+getRedeemFundId());

			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
			redeemFundName = queryPrimaryFundDetails.getFundName(getRedeemFundId());
		
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


	public String getRedeemFundName() {
		return redeemFundName;
	}


	public void setRedeemFundName(String redeemFundName) {
		this.redeemFundName = redeemFundName;
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
