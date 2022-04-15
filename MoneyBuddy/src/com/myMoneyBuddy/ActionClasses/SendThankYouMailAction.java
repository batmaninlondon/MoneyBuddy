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

import com.myMoneyBuddy.DAOClasses.GenerateKycForm;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class SendThankYouMailAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(SendThankYouMailAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	String emailId = null;
    	String customerName = null;
    	String firstOrderFlag = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		System.out.println("Testing 1 - customerId : "+customerId);
    		
    		logger.debug("SendThankYouMailAction class - execute method - customerId - "+customerId+" - start ");
    		
    		emailId = sessionMap.get("emailId").toString();
    		System.out.println("Testing 2 - emailId : "+emailId);
    		customerName = sessionMap.get("customerName").toString();
    		System.out.println("Testing 3 - customerName : "+customerName);
    		
    		firstOrderFlag = sessionMap.get("firstOrderFlag").toString();
    		System.out.println("Testing 4 - firstOrderFlag : "+firstOrderFlag);
    		
			List<CustomerCart> customerCartList = (List<CustomerCart>) sessionMap.get("customerCartList");
			
			boolean anySipOrder = customerCartList.stream().anyMatch(o -> "SIP".equalsIgnoreCase(o.getTransactionType()));
			
			boolean anyUpfrontOrder = customerCartList.stream().anyMatch(o -> "UPFRONT".equalsIgnoreCase(o.getTransactionType()));
			/*boolean anyUpfrontOrder = true;*/
			
    		System.out.println("anySipOrder : "+anySipOrder);
    		System.out.println("anyUpfrontOrder : "+anyUpfrontOrder);
    		
    		
    		Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateKycForm.class.getResourceAsStream(configPropFilePath));
			String mailLink = null;
			String subject = null;
			SendMail sendMail = new SendMail();
			
			NumberFormat myFormat = NumberFormat.getIntegerInstance();
	        myFormat.setGroupingUsed(true);
	        
			if (anySipOrder)  {
				
				if ("Y".equals(firstOrderFlag)) {
					mailLink = configProperties.getProperty("MAIL_SIP_REGISTERED_Y_LINK");
					System.out.println("mailLink is : "+mailLink);
					subject = configProperties.getProperty("MAIL_SIP_REGISTERED_Y_SUBJECT");
					sendMail.MailSending(emailId,subject,"SipRegisteredYesCaseMail","SipRegisteredY.txt",mailLink,"",customerName,"");
				}
				/*else {
					mailLink = configProperties.getProperty("MAIL_SIP_REGISTERED_N_LINK");
					System.out.println("mailLink is : "+mailLink);
					subject = configProperties.getProperty("MAIL_SIP_REGISTERED_N_SUBJECT");
					sendMail.MailSending(emailId,subject,"SipRegisteredNoCaseMail","SipRegisteredN.txt",mailLink,"",customerName);
				}*/
			}
			if (anyUpfrontOrder)  {
				
				
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
				dataTable += htmlTdStart + "Amount " + htmlTdEnd;
				dataTable += htmlHeaderRowEnd;
				
				for ( CustomerCart customerCart : customerCartList)   {
					if ( "UPFRONT".equalsIgnoreCase(customerCart.getTransactionType()) )  {
						dataTable += htmlTrStart;
						dataTable += htmlTdStart + customerCart.getSchemeName() + htmlTdEnd;
						dataTable += htmlTdStart + "Rs. "+myFormat.format((int) Double.parseDouble(customerCart.getUpfrontAmount())) + htmlTdEnd;
						dataTable += htmlTrEnd; 
						totalAmount += Double.parseDouble(customerCart.getUpfrontAmount());
					}
				}
				dataTable += htmlTrStart;
				dataTable += htmlTdStart + "Total" + htmlTdEnd;
				dataTable += htmlTdStart + totalAmount + htmlTdEnd;
				dataTable += htmlTrEnd; 
    		         		 
				dataTable += htmlTableEnd;
		         
		         		         
				mailLink = configProperties.getProperty("MAIL_UPFRONT_REGISTERED_LINK");
				System.out.println("mailLink is : "+mailLink);
				subject = configProperties.getProperty("MAIL_UPFRONT_REGISTERED_SUBJECT");
				sendMail.MailSending(emailId,subject,"UpfrontRegisteredMail","UpfrontPaymentReceived.txt",mailLink,"",customerName,dataTable);
			}

	    	logger.debug("SendThankYouMailAction class - execute method - customerId - "+customerId+" - end"); 
	
	    	return SUCCESS;
	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("SendThankYouMailAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}
