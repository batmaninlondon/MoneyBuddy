/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.myMoneyBuddy.mailerClasses.DesEncrypter;
import com.myMoneyBuddy.mailerClasses.SendMail;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotPasswordAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(ForgotPasswordAction.class);
	private Map<String, Object> sessionMap;
    private String emailId;
    
    /*static final String FROM = "info@quantwealth.in";
    static final String FROMNAME = "MoneyBuddy";*/
	
    // Replace recipient@example.com with a "To" address. If your account 
    // is still in the sandbox, this address must be verified.
    //static final String TO = "emailwadhwani@gmail.com";
    
    // Replace smtp_username with your Amazon SES SMTP user name.
    //static final String SMTP_USERNAME = "AKIAIWUUSWP7Q6ZULO5Q";
    
    // Replace smtp_password with your Amazon SES SMTP password.
    //static final String SMTP_PASSWORD = "AsZxWpOv37ISx5HD/SSD6NkKgcf5qD165ORDlzXSiCvr";
    
    // The name of the Configuration Set to use for this message.
    // If you comment out or remove this variable, you will also need to
    // comment out or remove the header below.
    //static final String CONFIGSET = "ConfigSet";
    
    // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
    // See http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
    // for more information.
    //static final String HOST = "email-smtp.us-east-1.amazonaws.com";
    
    // The port you will connect to on the Amazon SES SMTP endpoint. 
    //static final int PORT = 587;
    
    //static final String SUBJECT = "Money Buddy is here!!";
    
/*    static final String BODY = String.join(
    	    System.getProperty("line.separator"),
    	    "<h1>Coming Soon</h1>",
    	    "<p>We are excited to annouce that we are launching our platform soon", 
    	    "  <a href='http://www.quantwealth.in'>MnoeyBuddy.in</a>."
    	);*/

    

    public final String MAIL_ResetPassword_SITE_LINK = "www.quantwealth.in/resetPassword";

    QueryCustomer customer = new QueryCustomer();
    
    String regexEmail = "^(.+)@(.+)$";
    Pattern patternEmail = Pattern.compile(regexEmail);
    
    private InputStream stream;
    
    /*@Override
    public void validate()  {
    	logger.debug("ForgotPasswordAction class : validate method : start");
    	if(StringUtils.isEmpty(getEmailId()) )
    		addFieldError("emailId","Email Id can't be blank!");
    	else if (!patternEmail.matcher(emailId).matches())
            addFieldError("emailId","Please enter a valid emil address");
    	else if (!customer.existsCustomer(getEmailId()))
    		addFieldError("emailId"," User does not exists.");
    	logger.debug("ForgotPasswordAction class : validate method : end");
    	
    }*/

    @Override
    public String execute() {
    	
    	try {
	    	logger.debug("ForgotPasswordAction class : execute method : start");
	    	System.out.println("ForgotPasswordAction class : execute method called ");
	
	    	if (!customer.existsCustomer(getEmailId())) {
	    		System.out.println("Verification not done for this email id ");
	    		logger.debug("ForgotPasswordAction class : execute method : Email Id does not exists "+getEmailId());
	    		String str = "emailIdDoesNotExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	if (customer.getVerificationStatus(getEmailId()).equalsIgnoreCase("N"))  {
	    		System.out.println("Verification not done for this email id ");
	    		logger.debug("ForgotPasswordAction class : execute method : verification is not done for "+getEmailId());
	    		String str = "verificationNotDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	sessionMap.put("emailId", getEmailId());
	    	logger.debug("ForgotPasswordAction class : execute method : stored emailId : "+getEmailId()+" in session id : "+sessionMap.getClass().getName());
	    	
	    	String subject="Reset your MoneyBuddy password.";
	    	SendMail sendMail = new SendMail();
	    	String hashedPassword = customer.getPassword(getEmailId());
	    	String link = MAIL_ResetPassword_SITE_LINK+"?emailId="+emailId+"&hashedPassword="+hashedPassword;
	    	StringBuilder bodyText = new StringBuilder();
	    	bodyText.append("<div>")
	    	.append(" <br/><br/> <h1>Dear User</h1><br/><br/>")
	    	.append("  <p>Here's the link you requested to reset your MoneyBuddy password.</p><br/><br/><br/>")
	    	.append(" <h3> Please click <a href=\""+link+"\">here</a> or open below link in browser</h3><br/><br/>")
	    	.append("  <a href=\""+link+"\">"+link+"</a>")
	    	.append("  <br/><br/><br/><p>If you didn't request a password reset, please ignore this message and your password will stay the same.</p><br/><br/> <br/>")
	    	.append("  <h3>Thanks,</h3><br/><br/>")
	    	.append("  <h3>MoneyBuddy Team</h3>")
	    	.append("</div>");
	    	
	    	
	    	
	    	
	    	
/*	    	


	        // Create a Properties object to contain connection configuration information.
	    	Properties props = System.getProperties();
	    	props.put("mail.transport.protocol", "smtp");
	    	props.put("mail.smtp.port", PORT); 
	    	props.put("mail.smtp.starttls.enable", "true");
	    	props.put("mail.smtp.auth", "true");

	        // Create a Session object to represent a mail session with the specified properties. 
	    	Session session = Session.getDefaultInstance(props);

	        // Create a message with the specified information. 
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(FROM,FROMNAME));
	        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
	        msg.setSubject(subject);
	        msg.setContent(bodyText.toString(),"text/html");
	        
	        // Add a configuration set header. Comment or delete the 
	        // next line if you are not using a configuration set
	        //msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
	            
	        // Create a transport.
	        Transport transport = session.getTransport();
	                    
	        // Send the message.
	        try
	        {
	            System.out.println("Sending...");
	            
	            // Connect to Amazon SES using the SMTP username and password you specified above.
	            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
	        	
	            // Send the email.
	            transport.sendMessage(msg, msg.getAllRecipients());
	            System.out.println("Email sent!");
	        }
	        catch (Exception ex) {
	            System.out.println("The email was not sent.");
	            System.out.println("Error message: " + ex.getMessage());
	        }
	        finally
	        {
	            // Close and terminate the connection.
	            transport.close();
	        }
	    
	    	
	    	
	    	*/
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	//sendMail.MailSending(getEmailId(), bodyText,subject);
	    	sendMail.MailSending(bodyText,subject);
	    	
	    	logger.debug("ForgotPasswordAction class : execute method : mail sent to "+getEmailId()+" to reset password for session id : "+sessionMap.getClass().getName());
	    	logger.debug("ForgotPasswordAction class : execute method : end");
	    	
	    	String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());
	    	return SUCCESS;
		} catch (MoneyBuddyException e) {	
    		logger.debug("EstimateAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("EstimateAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		}
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    

    public Map<String, Object> getSession() {
		return sessionMap;
	}
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

}
