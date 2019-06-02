/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import org.apache.log4j.Logger;

import com.myMoneyBuddy.DAOClasses.InsertTransactionDetails;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class RejectedReverseFeedAction extends ActionSupport implements Action  {

	Logger logger = Logger.getLogger(RejectedReverseFeedAction.class);
	private String bseOrderIdDashboard;

    public String execute() {
    	
    	try {
    		logger.debug("PendingNavsAction class - execute method - start ");
			
			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
			TransactionDetails transactionDetails = queryTransactionDetails.getTransactionDetailsFromBseOrderId(getBseOrderIdDashboard());

			if (transactionDetails == null)  {
				addActionMessage("This Bse Order Id does not exist !");
				return SUCCESS ;
			}
			InsertTransactionDetails insertTransactionDetails = new InsertTransactionDetails();
			insertTransactionDetails.insertRejectedTransactionDetails(transactionDetails);
			
			System.out.println("Returning success !! ");
			logger.debug("PendingNavsAction class - execute method - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("PendingNavsAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("PendingNavsAction class - execute method - returned error");
			return ERROR;
		} 

    }

	public String getBseOrderIdDashboard() {
		return bseOrderIdDashboard;
	}

	public void setBseOrderIdDashboard(String bseOrderIdDashboard) {
		this.bseOrderIdDashboard = bseOrderIdDashboard;
	}

}
