package com.myMoneyBuddy.mailerClasses;

//import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;  



//import java.io.IOException;
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


public class SendAttachment {

	

    

    //public void MailSending(String emailId, StringBuilder bodyText, String subject) throws MoneyBuddyException {
/*    
    public static void main(String args[]) {

    	//Logger logger = Logger.getLogger(sendMail.class);
    	
    	int port =587;
        String host ="smtp.gmail.com";
        String username ="mf.moneybuddy@gmail.com";
        String password="Money@Buddy";
        boolean debug=true;
        String emailId = "savita.wadhwani@gmail.com";
        String subject = "Test mail with attachment";
        
    	//logger.debug("sendMail class : MailSending method : start");
    	
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.host", host);
    	props.put("mail.smtp.port", port);

    	// Get the Session object.

    	Session session = Session.getInstance(props,
    			new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(username, password);
    		}
    	});

    	try {
    		// Create a default MimeMessage object.

    		System.out.println("Hi There 1 ");
    		
    		Message message = new MimeMessage(session);

    		// Set From: header field of the header.
    		message.setFrom(new InternetAddress(username));

    		// Set To: header field of the header.

    		message.setRecipients(Message.RecipientType.TO,
    				InternetAddress.parse(emailId));

    		// Set Subject: header field
    		message.setSubject(subject);
    		
    		System.out.println("Hi There 2 ");

    		BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("This is message body"); 
            System.out.println("Hi There 3 ");

            //4) create new MimeBodyPart object and set DataHandler object to this object        
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
            String filename = "D://test.txt";//change accordingly
            System.out.println("Hi There 4 ");
            DataSource source = new FileDataSource(filename);    
            messageBodyPart2.setDataHandler(new DataHandler(source));    
            messageBodyPart2.setFileName("Savvy");    
            System.out.println("Hi There 5 ");

            //5) create Multipart object and add MimeBodyPart objects to this object        
            Multipart multipart = new MimeMultipart();    
            multipart.addBodyPart(messageBodyPart1);     
            multipart.addBodyPart(messageBodyPart2); 
            
            System.out.println("Hi There 6 ");
    		//message.setContent(bodyText.toString(), "text/html; charset=utf-8");

            message.setContent(multipart );  
            
    		// Send message
    		Transport.send(message);
    		
    		System.out.println("Hi There 7 ");
    		//logger.debug("sendMail class : MailSending method : end");

    	} 
    	catch (MessagingException e) {
    		//logger.error("sendMail class : MailSending method : Caught Exception");
    		e.printStackTrace();
			//throw new MoneyBuddyException(e.getMessage(),e);
    	}
   	
        catch (Exception e ) {
        	//logger.error("sendMail class : MailSending method : Caught Exception");
			e.printStackTrace();
			//throw new MoneyBuddyException(e.getMessage(),e);
		}
    }*/

    

    
}

/*class SendAttachment
{ 
    public static void main(String [] args)
    {    
        String to="savita.wadhwani@gmail.com";//change accordingly   
        final String user="mf.moneybuddy@gmail.com";//change accordingly   
        final String password="Money@Buddy";//change accordingly     

        //1) get the session object      
        Properties properties = System.getProperties();  
        properties.setProperty("mail.smtp.host", "mail.javatpoint.com");   
        properties.put("mail.smtp.auth", "true");    

        Session session = Session.getDefaultInstance(properties,   
                new javax.mail.Authenticator() {   
            protected PasswordAuthentication getPasswordAuthentication() {   
                return new PasswordAuthentication(user,password);    }   });       

        //2) compose message      
        try{    
            MimeMessage message = new MimeMessage(session);    
            message.setFrom(new InternetAddress(user));     
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
            message.setSubject("Message Alert");         

            //3) create MimeBodyPart object and set your message text        
            BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("This is message body");          

            //4) create new MimeBodyPart object and set DataHandler object to this object        
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
            String filename = "D://test.txt";//change accordingly     
            DataSource source = new FileDataSource(filename);    
            messageBodyPart2.setDataHandler(new DataHandler(source));    
            messageBodyPart2.setFileName(filename);             

            //5) create Multipart object and add MimeBodyPart objects to this object        
            Multipart multipart = new MimeMultipart();    
            multipart.addBodyPart(messageBodyPart1);     
            multipart.addBodyPart(messageBodyPart2);      

            //6) set the multiplart object to the message object    
            message.setContent(multipart );        

            //7) send message    
            Transport.send(message);      
            System.out.println("message sent....");   

        }catch (MessagingException ex) {ex.printStackTrace();}  
    }
} */
