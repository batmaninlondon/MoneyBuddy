/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.myMoneyBuddy.DAOClasses.GenerateKycForm;
import com.myMoneyBuddy.DAOClasses.InsertCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class SendThankYouMailAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(SendThankYouMailAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	String emailId = null;
    	String customerName = null;
    	String firstOrderFlag = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("SendThankYouMailAction class - execute method - customerId - "+customerId+" - start ");
    		
    		emailId = sessionMap.get("emailId").toString();
    		customerName = sessionMap.get("customerName").toString();
    		
    		firstOrderFlag = sessionMap.get("firstOrderFlag").toString();
    		
			List<CustomerCart> customerCartList = (List<CustomerCart>) sessionMap.get("customerCartList");
			
			boolean anySipOrder = customerCartList.stream().anyMatch(o -> "SIP".equals(o.getTransactionType()));
			
			boolean anyUpfrontOrder = customerCartList.stream().anyMatch(o -> "UPFRONT".equals(o.getTransactionType()));
			/*boolean anyUpfrontOrder = true;*/
			
    		System.out.println("anySipOrder : "+anySipOrder);
    		System.out.println("anyUpfrontOrder : "+anyUpfrontOrder);
    		
    		
    		Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateKycForm.class.getResourceAsStream(configPropFilePath));
			String mailLink = null;
			String subject = null;
			SendMail sendMail = new SendMail();
			if (anySipOrder)  {
				
				if ("Y".equals(firstOrderFlag)) {
					mailLink = configProperties.getProperty("MAIL_SIP_REGISTERED_Y_LINK");
					System.out.println("mailLink is : "+mailLink);
					subject = configProperties.getProperty("MAIL_SIP_REGISTERED_y_SUBJECT");
					sendMail.MailSending(emailId,subject,"SipRegisteredYesCaseMail","SipRegisteredY.txt",mailLink,"",customerName);
				}
				else {
					mailLink = configProperties.getProperty("MAIL_SIP_REGISTERED_N_LINK");
					System.out.println("mailLink is : "+mailLink);
					subject = configProperties.getProperty("MAIL_SIP_REGISTERED_N_SUBJECT");
					sendMail.MailSending(emailId,subject,"SipRegisteredNoCaseMail","SipRegisteredN.txt",mailLink,"",customerName);
				}
			}
			if (anyUpfrontOrder)  {
				mailLink = configProperties.getProperty("MAIL_UPFRONT_REGISTERED_LINK");
				System.out.println("mailLink is : "+mailLink);
				subject = configProperties.getProperty("MAIL_UPFRONT_REGISTERED_SUBJECT");
				sendMail.MailSending(emailId,subject,"UpfrontRegisteredMail","UpfrontPaymentReceived.txt",mailLink,"",customerName);
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
