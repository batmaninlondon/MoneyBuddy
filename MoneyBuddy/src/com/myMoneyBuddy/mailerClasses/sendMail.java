/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.mailerClasses;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.myMoneyBuddy.DAOClasses.insertCustomerAccountDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;


public class sendMail {

	Logger logger = Logger.getLogger(sendMail.class);
	
	private int port =587;
    private String host ="smtp.gmail.com";
    private String username ="info.moneybuddy@gmail.com";
    private String password="Money@Buddy";
    private boolean debug=true;

    

    public void MailSending(String emailId, StringBuilder bodyText, String subject) throws MoneyBuddyException {

    	logger.debug("sendMail class : MailSending method : start");
    	
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.host", getHost());
    	props.put("mail.smtp.port", getPort());

    	// Get the Session object.

    	Session session = Session.getInstance(props,
    			new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(getUsername(), getPassword());
    		}
    	});

    	try {
    		// Create a default MimeMessage object.
    		Message message = new MimeMessage(session);

    		// Set From: header field of the header.
    		message.setFrom(new InternetAddress(getUsername()));

    		// Set To: header field of the header.

    		message.setRecipients(Message.RecipientType.TO,
    				InternetAddress.parse(emailId));

    		// Set Subject: header field
    		message.setSubject(subject);

    		message.setContent(bodyText.toString(), "text/html; charset=utf-8");

    		// Send message
    		Transport.send(message);
    		
    		logger.debug("sendMail class : MailSending method : end");

    	} 
    	catch (MessagingException e) {
    		logger.error("sendMail class : MailSending method : Caught Exception");
    		e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
    	}
   	
        catch (Exception e ) {
        	logger.error("sendMail class : MailSending method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    }

    
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}

