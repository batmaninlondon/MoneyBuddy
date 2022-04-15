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
import com.myMoneyBuddy.DAOClasses.QuerySwitchCart;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerSwitchCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.SwitchCart;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class SwitchAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(SwitchAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		QuerySwitchCart querySwitchCart = new QuerySwitchCart();
    		List<SwitchCart> customerSwitchCartList = querySwitchCart.getCustomerSwitchCart(customerId);
    		sessionMap.put("customerSwitchCartList", customerSwitchCartList);
    		
    		QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
	    	
    		logger.debug("SwitchAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" SwitchAction execute method Called !!");

	    	for (int i =0;i<customerSwitchCartList.size()-1;i++)  {

		    	Trading trading = new Trading();
		    	trading.executeSwitch(customerId, customerSwitchCartList.get(i).getSwitchOption(), customerSwitchCartList.get(i).getSwitchType(),
		    			customerSwitchCartList.get(i).getWithdrawalFundId(), customerSwitchCartList.get(i).getFolioNumber(),
		    			customerSwitchCartList.get(i).getPurchaseFundId(), customerSwitchCartList.get(i).getSwitchAmount(),
		    			customerSwitchCartList.get(i).getSwitchUnit(),customerSwitchCartList.get(i).getSwitchOption(),
		    			customerSwitchCartList.get(i).getSwitchType(), customerSwitchCartList.get(i).getSwitchCartId());
		    	
		    	
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
			String htmlTdBoldStart = "<td style=\" border-color:#13b1cd; border-style:solid; border-width:thin; padding: 5px; font-weight: bold;\">";
			String htmlTdEnd = "</td>";

			dataTable += htmlTableStart;
			dataTable += htmlHeaderRowStart;
			dataTable += htmlTdStart + "Fund Name " + htmlTdEnd;
			/*dataTable += htmlTdStart + "Purchase Fund Name " + htmlTdEnd;*/
			dataTable += htmlTdStart + "Details " + htmlTdEnd;
			dataTable += htmlHeaderRowEnd;
			
			for ( SwitchCart switchCart : customerSwitchCartList)   {
					
					if (!"TOTAL".equalsIgnoreCase(switchCart.getWithdrawalSchemeName()))  { 
						dataTable += htmlTrStart;
						dataTable += htmlTdStart 
								+ switchCart.getWithdrawalSchemeName() +"<p class=\"text-center\"><b>&#9660;</b></p>"+ switchCart.getPurchaseFundSchemeName()
								+ htmlTdEnd;
						//dataTable += htmlTdStart + switchCart.getPurchaseFundSchemeName() + htmlTdEnd;
						
						if ("Full".equalsIgnoreCase(switchCart.getSwitchOption()))
							dataTable += htmlTdStart + "All units" + htmlTdEnd;
						else {
							if ("Units".equalsIgnoreCase(switchCart.getSwitchType()))  {
								dataTable += htmlTdStart + "Units: "+switchCart.getSwitchUnit() + htmlTdEnd;
							}
							else {
								dataTable += htmlTdStart + "Amount: "+switchCart.getSwitchAmount() + htmlTdEnd;
							}
						}
						dataTable += htmlTrEnd;
					}
					 
					//totalAmount += Double.parseDouble(switchCart.getSwitchAmount());
				
			}
			/*dataTable += htmlTrStart;
			dataTable += htmlTdStart + "" + htmlTdEnd;
			dataTable += htmlTdStart + "Total" + htmlTdEnd;
			dataTable += htmlTdStart + totalAmount + htmlTdEnd;
			dataTable += htmlTrEnd; */
		         		 
			dataTable += htmlTableEnd;
			
	    	Properties configProperties = new Properties();
	    	String configPropFilePath = "../../../config/config.properties";

	    	configProperties.load(RedeemAction.class.getResourceAsStream(configPropFilePath));

	    	String mailLink = configProperties.getProperty("MAIL_SWITCH_REGISTERED_LINK");
	    	System.out.println("mailLink is : "+mailLink);

	    	String subject = configProperties.getProperty("MAIL_SWITCH_REGISTERED_SUBJECT");

	    	sendMail.MailSending(customer.getEmailId(),subject,"SwitchRegisteredMail","SwitchRegistered.txt",mailLink,"",customer.getCustomerName(),dataTable);
	    	
	    	
	    	UpdateCustomerSwitchCart updateCustomerSwitchCart = new UpdateCustomerSwitchCart();
	    	updateCustomerSwitchCart.emptyCustomerSwitchCart(customerId);
	
    	    logger.debug("SwitchAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("SwitchAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("SwitchAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("SwitchAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}
