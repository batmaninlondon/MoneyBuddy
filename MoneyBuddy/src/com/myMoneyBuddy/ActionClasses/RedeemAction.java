/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerRedemptionCart;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerRedemptionCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class RedeemAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(RedeemAction.class);
	private SessionMap<String,Object> sessionMap;
	
/*	private String fundId;
	private String schemeName;
	private String folioNumber;
	private String totalAmount;
	private String totalQuantity;
	private String redeemAmount;
	private String redeemQuantity;;
	private String redeemType;
	private String amtOrQuan;*/

    public String execute() {
    	
    	String customerId = null;
    	String allRedeem = "N";
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		QueryCustomerRedemptionCart queryCustomerRedemptionCart = new QueryCustomerRedemptionCart();
    		List<RedemptionCart> customerRedemptionCartList = queryCustomerRedemptionCart.getCustomerRedemptionCart(customerId);
    		sessionMap.put("customerRedemptionCartList", customerRedemptionCartList);
    		
    		QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
	    	
    		logger.debug("RedeemAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" RedeemAction execute method Called !!");

	    	for (int i =0;i<customerRedemptionCartList.size()-1;i++)  {
	    	
		    	if ("Full".equalsIgnoreCase(customerRedemptionCartList.get(i).getRedemptionOption()))  {
		    		allRedeem = "Y";
		    	}
		    	Trading trading = new Trading();
		    	
		    	trading.executeRedemption(customerId, customer.getPanCard(), customerRedemptionCartList.get(i).getFundId(), Double.valueOf(customerRedemptionCartList.get(i).getRedAmount() ), 
		    					Double.valueOf(customerRedemptionCartList.get(i).getRedUnits()), allRedeem, "NEW", "REDEMPTION",customerRedemptionCartList.get(i).getRedemptionOption(),
		    					customerRedemptionCartList.get(i).getRedemptionType(),"SELL", customerRedemptionCartList.get(i).getFolioNumber() );
	    	
	    	}

	    	SendMail sendMail = new SendMail();

	    	Double totalAmount = 0.0;
			String dataTable = "";
			String htmlTableStart = "<table style=\"border-collapse:collapse; text-align:center;width:100%\" >";
			String htmlTableEnd = "</table>";
			String htmlHeaderRowStart = "<tr style =\"background-color:#13b1cd; color:#ffffff;\">";
			String htmlHeaderRowEnd = "</tr>";
			String htmlTrStart = "<tr style =\"color:#555555;\">";
			String htmlTrEnd = "</tr>";
			String htmlTdStart = "<td style=\" border-color:#13b1cd; border-style:solid; border-width:thin; padding: 5px;\">";
			String htmlTdEnd = "</td>";

			dataTable += htmlTableStart;
			dataTable += htmlHeaderRowStart;
			dataTable += htmlTdStart + "Fund Name " + htmlTdEnd;
			dataTable += htmlTdStart + "Amount* " + htmlTdEnd;
			dataTable += htmlHeaderRowEnd;
			
			for ( RedemptionCart redCart : customerRedemptionCartList)   {
					dataTable += htmlTrStart;
					if ("Total".equalsIgnoreCase(redCart.getSchemeName()))   {
						dataTable += htmlTdStart + "<b>"+ redCart.getSchemeName() +"</b>"+ htmlTdEnd;
						dataTable += htmlTdStart + "<b>"+ redCart.getRedAmount() +"</b>" + htmlTdEnd;
					}
					else {
						dataTable += htmlTdStart + redCart.getSchemeName() + htmlTdEnd;
						dataTable += htmlTdStart + redCart.getRedAmount() + htmlTdEnd;
					}
					dataTable += htmlTrEnd; 
					totalAmount += Double.parseDouble(redCart.getRedAmount());
				
			}
			/*dataTable += htmlTrStart;
			dataTable += htmlTdStart + "Total" + htmlTdEnd;
			dataTable += htmlTdStart + totalAmount + htmlTdEnd;
			dataTable += htmlTrEnd; */
		         		 
			dataTable += htmlTableEnd;
			
	    	Properties configProperties = new Properties();
	    	String configPropFilePath = "../../../config/config.properties";

	    	configProperties.load(RedeemAction.class.getResourceAsStream(configPropFilePath));

	    	String mailLink = configProperties.getProperty("MAIL_REDEMPTION_REGISTERED_LINK");
	    	System.out.println("mailLink is : "+mailLink);

	    	String subject = configProperties.getProperty("MAIL_REDEMPTION_REGISTERED_SUBJECT");

	    	sendMail.MailSending(customer.getEmailId(),subject,"RedemptionRegisteredMail","RedemptionRegistered.txt",mailLink,"",customer.getCustomerName(),dataTable);
	    	
	    	
	    	UpdateCustomerRedemptionCart updateCustomerRedemptionCart = new UpdateCustomerRedemptionCart();
	    	updateCustomerRedemptionCart.emptyCustomerRedCart(customerId);
	
    	    logger.debug("RedeemAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("RedeemAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("RedeemAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("RedeemAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}
