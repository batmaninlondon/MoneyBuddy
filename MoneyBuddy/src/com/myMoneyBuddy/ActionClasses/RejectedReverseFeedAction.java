/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.myMoneyBuddy.DAOClasses.InsertTransactionDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class RejectedReverseFeedAction extends ActionSupport implements Action  {

	Logger logger = LogManager.getLogger(RejectedReverseFeedAction.class);
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
			insertTransactionDetails.insertRejectedTransactionDetails(transactionDetails.getTransactionDetailId());
			
			SendMail sendMail = new SendMail();

	    	Properties configProperties = new Properties();
	    	String configPropFilePath = "../../../config/config.properties";

	    	configProperties.load(RedeemAction.class.getResourceAsStream(configPropFilePath));

	    	String mailLink = configProperties.getProperty("MAIL_SIP_REJECTED_LINK");
	    	System.out.println("mailLink is : "+mailLink);

	    	QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	String subject = configProperties.getProperty("MAIL_SIP_REJECTED_SUBJECT");

	    	sendMail.MailSending(queryCustomer.getCustomerEmailId(transactionDetails.getCustomerId()),subject,"SipRejectedMail","SipRejected.txt",mailLink,"",queryCustomer.getCustomerNameFromId(transactionDetails.getCustomerId()),"");
	    	
			
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
