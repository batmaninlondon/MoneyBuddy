/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.mailerClasses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.myMoneyBuddy.DAOClasses.insertCustomerAccountDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;


public class sendMail {

	Logger logger = Logger.getLogger(sendMail.class);
	
	private int port =587;
    private String host ="smtp.gmail.com";
    private String username ="mf.moneybuddy@gmail.com";
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

    public void sendMailwithAttachement(HashMap<String,String> fundDetails, String pdfName, String emailId) throws MoneyBuddyException{
    	
           PdfReader reader;
		try {
			reader = new PdfReader("D://DelMe/"+pdfName+".pdf");


           PdfStamper stamper = new PdfStamper(reader,
        	          new FileOutputStream("D://DelMe/investment_details.pdf")); // output PDF

           AcroFields form = stamper.getAcroFields();
           
           HashMap map = new HashMap();
           map = (HashMap) form.getFields();
           //Iterator iterator = map.keySet().iterator();
           System.out.println("iterator size : "+map.size());
           /*while(iterator.hasNext())
               System.out.println("Field is >>>"+iterator.next());*/
           
           form.setField("Your Company Name", "MoneyBuddy");
           form.setField("Your Name", "MoneyBuddy");
           form.removeField("Address Line 1");
           form.removeField("Address Line 2");
           form.removeField("City, State, Zip Code");
           form.setField("Client's Name", "Kamal Wadhwani");
           form.removeField("Client: Address Line 1");
           form.removeField("Client: Address Line 2");
           form.removeField("Client: City, State, Zip Code");
           form.removeField("Invoice ID");
           form.removeField("Issue Date");
           form.removeField("PO Number");
           form.removeField("Due Date");
           form.removeField("Subject");

           int i =0;
           for (String key : fundDetails.keySet()) {

        	   System.out.println("Fund description : "+key+" and fund amount : "+fundDetails.get(key));
        	   i++;
        	   String arg1 = "Item "+i+": Description";
        	   form.setField(arg1, key);
        	   
        	   String arg2 = "Item "+i+": Amount";
        	   form.setField(arg2, fundDetails.get(key));

           }
               
           
           stamper.setFormFlattening(true);
           stamper.close();
           
           
       	
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


       		// Create a default MimeMessage object.
       		Message message = new MimeMessage(session);

       		// Set From: header field of the header.
       		message.setFrom(new InternetAddress(getUsername()));

       		// Set To: header field of the header.

       		message.setRecipients(Message.RecipientType.TO,
       				InternetAddress.parse(emailId));

       		// Set Subject: header field
       		String subject ="Investment Details";
       		message.setSubject(subject);


       		BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("Please find attached pdf, which has your investment details."); 
            System.out.println("Hi There 3 ");

            //4) create new MimeBodyPart object and set DataHandler object to this object        
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
            String filename = "D://DelMe/investment_details.pdf";//change accordingly
            System.out.println("Hi There 4 ");
            DataSource source = new FileDataSource(filename);    
            messageBodyPart2.setDataHandler(new DataHandler(source));    
            messageBodyPart2.setFileName("investment_details");    
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
           
           
		} catch (IOException e) {
			logger.error("sendMail class : MailSending method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		} catch (DocumentException e) {
			logger.error("sendMail class : MailSending method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
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
    
    
    public int triggerNewPage(PdfStamper stamper, Rectangle pagesize, ColumnText column, Rectangle rect, int pagecount) throws DocumentException {
        stamper.insertPage(pagecount, pagesize);
        PdfContentByte canvas = stamper.getOverContent(pagecount);
        column.setCanvas(canvas);
        column.setSimpleColumn(rect);
        return column.go();
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

