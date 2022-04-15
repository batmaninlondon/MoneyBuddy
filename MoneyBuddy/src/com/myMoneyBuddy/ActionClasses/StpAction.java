/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryStpCart;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerStpCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.StpCart;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class StpAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(StpAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		QueryStpCart queryStpCart = new QueryStpCart();
    		List<StpCart> customerStpCartList = queryStpCart.getCustomerStpCart(customerId);
    		sessionMap.put("customerStpCartList", customerStpCartList);
    		
    		QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
	    	
    		logger.debug("StpAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" StpAction execute method Called !!");

	    	for (int i =0;i<customerStpCartList.size()-1;i++)  {

		    	Trading trading = new Trading();
		    	trading.executeStp(customerId, customerStpCartList.get(i).getWithdrawalFundId(), customerStpCartList.get(i).getFolioNumber(),
		    			customerStpCartList.get(i).getPurchaseFundId(), customerStpCartList.get(i).getStpAmount(), customerStpCartList.get(i).getStpDuration(),
		    			customerStpCartList.get(i).getStpDate(), customerStpCartList.get(i).getStpCartId());
		    	
		    	
	    	}

	    	SendMail sendMail = new SendMail();

	    	NumberFormat myFormat = NumberFormat.getIntegerInstance();
	        myFormat.setGroupingUsed(true);
	        
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
			dataTable += htmlTdStart + "Details " + htmlTdEnd;
			dataTable += htmlHeaderRowEnd;
			
			String stpDate="";
			for ( StpCart stpCart : customerStpCartList)   {
					if (!"Total".equalsIgnoreCase(stpCart.getWithdrawalSchemeName()))  {
						if ("1".equals(stpCart.getStpDate()))  {
							stpDate = stpCart.getStpDate()+"<sup>st</sup>";
						}
						else {
							stpDate = stpCart.getStpDate()+"<sup>th</sup>";
						}
						
					dataTable += htmlTrStart;
					dataTable += htmlTdStart 
							+ stpCart.getWithdrawalSchemeName() +"<p class=\"text-center\"><b>&#9660;</b></p>"+ stpCart.getPurchaseFundSchemeName()
							+ htmlTdEnd;
					//dataTable += htmlTdStart + stpCart.getPurchaseFundSchemeName() + htmlTdEnd;
					dataTable += htmlTdStart 
								+ "Amount: Rs." + 	myFormat.format((int) Double.parseDouble(stpCart.getStpAmount()))
								+ "<br/>Date: " + stpDate 
								+ htmlTdEnd;
					dataTable += htmlTrEnd; 
					//totalAmount += Double.parseDouble(stpCart.getStpAmount());
					}
				
			}
			/*dataTable += htmlTrStart;
			//dataTable += htmlTdStart + "" + htmlTdEnd;
			dataTable += htmlTdStart + "<b>" + "Total" + "</b>" + htmlTdEnd;
			dataTable += htmlTdStart + "<b>" + totalAmount + "</b>" + htmlTdEnd;
			dataTable += htmlTrEnd; */
		         		 
			dataTable += htmlTableEnd;
			
	    	Properties configProperties = new Properties();
	    	String configPropFilePath = "../../../config/config.properties";

	    	configProperties.load(RedeemAction.class.getResourceAsStream(configPropFilePath));

	    	String mailLink = configProperties.getProperty("MAIL_STP_REGISTERED_LINK");
	    	System.out.println("mailLink is : "+mailLink);

	    	String subject = configProperties.getProperty("MAIL_STP_REGISTERED_SUBJECT");

	    	sendMail.MailSending(customer.getEmailId(),subject,"StpRegisteredMail","StpRegistered.txt",mailLink,"",customer.getCustomerName(),dataTable);
	    	
	    	
	    	UpdateCustomerStpCart updateCustomerStpCart = new UpdateCustomerStpCart();
	    	updateCustomerStpCart.emptyCustomerStpCart(customerId);
	
    	    logger.debug("StpAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("StpAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("StpAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("StpAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}
