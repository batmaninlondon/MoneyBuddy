/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.myMoneyBuddy.ActionClasses.RegisterAction;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;


public class SendMail {

	Logger logger = LogManager.getLogger(SendMail.class);   

	public void MailSending(String emailId, String subject, String mailType,String fileName,
    		String mailLink,String displayLinkName, String customerName, String dataTable) throws MoneyBuddyException {
    	
    	
    	logger.debug("sendMail class : MailSending method : start");
    	logger.debug(mailType+" has been sent to "+emailId);
    	
    	System.out.println(mailType+" has been sent to "+emailId);
    	
    	String bccEmailId = "kamalwadhwani@gmail.com";
    	try {    	
    	
    		String mailContentFilePath = "../../../mailContents/"+fileName;
    		InputStream is = RegisterAction.class.getResourceAsStream(mailContentFilePath);
        	
        	
        	StringBuilder bodyText = new StringBuilder();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
            	
            	if (strLine.contains("LinkForEmail")) {
            		
            		System.out.println("contains LinkForEmail ");
            		strLine = strLine.replace("LinkForEmail", "<a href=\""+mailLink+"\">"+displayLinkName+"</a>");

            	}
            	if (strLine.contains("customerName")) {
		    		
		    		System.out.println("contains customerName ");
		    		strLine = strLine.replace("customerName", customerName);
		
		    	}
            	if (strLine.contains("DATATABLE")) {
		    		
		    		System.out.println("contains DATATABLE ");
		    		strLine = strLine.replace("DATATABLE", dataTable);
		
		    	}
            	
            	bodyText.append(strLine);
            }
    	Properties configProperties = new Properties();
		String configPropFilePath = "../../../config/config.properties";

		configProperties.load(SendMail.class.getResourceAsStream(configPropFilePath));
		
		//System.setProperty("com.sun.security.enableAIAcaIssuers", "true");
    	
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.host", configProperties.getProperty("GMAIL_HOST"));
    	props.put("mail.smtp.port", configProperties.getProperty("GMAIL_PORT"));

    	System.out.println(" GMAIL PORT IS :  "+configProperties.getProperty("GMAIL_PORT"));
    	// Get the Session object.

    	Session session = Session.getInstance(props,
    			new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(configProperties.getProperty("GMAIL_USERNAME"), configProperties.getProperty("GMAIL_PASSWORD"));
    		}
    	});

    		// Create a default MimeMessage object.
    		Message message = new MimeMessage(session);
    		// Set From: header field of the header.
    		//message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME")));
    		message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME"),configProperties.getProperty("GMAIL_NAME")));

    		// Set To: header field of the header.

    		message.setRecipients(Message.RecipientType.TO,
    				InternetAddress.parse(emailId));
    		
    		message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(bccEmailId));

    		// Set Subject: header field
    		message.setSubject(subject);

    		message.setContent(bodyText.toString(), "text/html; charset=utf-8");

    		// Send message
    		
    		Transport.send(message);
    		
    		logger.debug("sendMail class : MailSending method : end");

    	} 
    	catch (IOException e) {
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
    
    
    
    public void FaultyIdMailSending(String bseOrderIds, String bseRegNums) throws MoneyBuddyException {
    	
    	System.out.println("sendMail class : FaultyIdMailSending method : start");
    	logger.debug("sendMail class : FaultyIdMailSending method : start");
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    	Date date = new Date();
    	String todayDate = dateFormat.format(date);
    	
    	
    	String bccEmailId = "savita.wadhwani@gmail.com";
    	String subject = "faulty Bse OrderIds and Bse RegNums for Date - "+todayDate;
    	try {  
    		
        	StringBuilder bodyText = new StringBuilder();
        	bodyText.append("<p>Date : "+todayDate+"</p>" );
        	if (! "".equals(bseOrderIds))
        		bodyText.append("<p>bseOrderIds : "+bseOrderIds.substring(0,bseOrderIds.length()-1)+"</p>");
        	if (! "".equals(bseRegNums))
        		bodyText.append("<p>BseRegNums : "+bseRegNums.substring(0,bseRegNums.length()-1)+"</p>");

    	Properties configProperties = new Properties();
		String configPropFilePath = "../../../config/config.properties";

		configProperties.load(SendMail.class.getResourceAsStream(configPropFilePath));
		
		//System.setProperty("com.sun.security.enableAIAcaIssuers", "true");
    	
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.host", configProperties.getProperty("GMAIL_HOST"));
    	props.put("mail.smtp.port", configProperties.getProperty("GMAIL_PORT"));

    	System.out.println(" GMAIL PORT IS :  "+configProperties.getProperty("GMAIL_PORT"));
    	// Get the Session object.

    	Session session = Session.getInstance(props,
    			new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(configProperties.getProperty("GMAIL_USERNAME"), configProperties.getProperty("GMAIL_PASSWORD"));
    		}
    	});

    		// Create a default MimeMessage object.
    		Message message = new MimeMessage(session);
    		// Set From: header field of the header.
    		//message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME")));
    		//message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME")));
    		message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME"),configProperties.getProperty("GMAIL_NAME")));

    		// Set To: header field of the header.

    		message.setRecipients(Message.RecipientType.TO,
    				InternetAddress.parse("kamalwadhwani@gmail.com"));
    		
    		message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(bccEmailId));

    		// Set Subject: header field
    		message.setSubject(subject);

    		message.setContent(bodyText.toString(), "text/html; charset=utf-8");

    		// Send message
    		
    		Transport.send(message);
    		
    		logger.debug("sendMail class : FaultyIdMailSending method : end");
    		System.out.println("sendMail class : FaultyIdMailSending method : end");

    	} 
    	catch (IOException e) {
    		logger.error("sendMail class : FaultyIdMailSending method : Caught Exception");
    		e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
    	}
    	catch (MessagingException e) {
    		logger.error("sendMail class : FaultyIdMailSending method : Caught Exception");
    		e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
    	}
   	
        catch (Exception e ) {
        	logger.error("sendMail class : FaultyIdMailSending method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    }

    /*public void sendMailwithAttachement(HashMap<String,String> fundDetails, String pdfName, String emailId) throws MoneyBuddyException{
    	
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
           while(iterator.hasNext())
               System.out.println("Field is >>>"+iterator.next());
           
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
       	props.put("mail.smtp.host", getGmailHost());
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

            //4) create new MimeBodyPart object and set DataHandler object to this object        
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
            String filename = "D://DelMe/investment_details.pdf";//change accordingly
            DataSource source = new FileDataSource(filename);    
            messageBodyPart2.setDataHandler(new DataHandler(source));    
            messageBodyPart2.setFileName("investment_details");    

            //5) create Multipart object and add MimeBodyPart objects to this object        
            Multipart multipart = new MimeMultipart();    
            multipart.addBodyPart(messageBodyPart1);     
            multipart.addBodyPart(messageBodyPart2); 
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

    }*/
    
    public void sendMailwithAttachement(String fileName) throws MoneyBuddyException{
    	
		try {
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(SendMail.class.getResourceAsStream(configPropFilePath));
			
			//System.setProperty("com.sun.security.enableAIAcaIssuers", "true");
	    	
	    	Properties props = new Properties();
	    	props.put("mail.smtp.auth", "true");
	    	props.put("mail.smtp.starttls.enable", "true");
	    	props.put("mail.smtp.host", configProperties.getProperty("GMAIL_HOST"));
	    	props.put("mail.smtp.port", configProperties.getProperty("GMAIL_PORT"));

    	// Get the Session object.

	    	Session session = Session.getInstance(props,
	    			new javax.mail.Authenticator() {
	    		protected PasswordAuthentication getPasswordAuthentication() {
	    			return new PasswordAuthentication(configProperties.getProperty("GMAIL_USERNAME"), configProperties.getProperty("GMAIL_PASSWORD"));
	    		}
	    	});


    		// Create a default MimeMessage object.
    		Message message = new MimeMessage(session);

    		// Set From: header field of the header.
    		
    		//message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME")));
    		message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME"),configProperties.getProperty("GMAIL_NAME")));

    		// Set To: header field of the header.

    		message.setRecipients(Message.RecipientType.TO,
    				InternetAddress.parse("kamalwadhwani@gmail.com"));
    		
    		String bccEmailId = "savita.wadhwani@gmail.com";
    		//message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(bccEmailId));
    		
    		/*message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(bccEmailId));*/
    		// Set To: header field of the header.


    		// Set Subject: header field
    		String subject ="Customers Investment Details";
    		message.setSubject(subject);

    		

    		BodyPart messageBodyPart1 = new MimeBodyPart();     
         messageBodyPart1.setText("Please find attached xls, which has our customer investment details"); 

         //4) create new MimeBodyPart object and set DataHandler object to this object        
         MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
         /*String filename = "ClientRecords.xlsx";//change accordingly
*/         
         /*ClassLoader cl = getClass().getClassLoader();
			
         System.out.println(" cl :::::: "+cl);
         
			String directoryName = cl.getResource("./../../assets/ClientRecord").getPath().substring(1);

 		System.out.println("directoryName is : "+directoryName);
 		
 		String filePath = directoryName+"ClientRecords.xlsx";
 		
 		System.out.println("filePath is : "+filePath);*/
 		
 		File f1 = new File(fileName); 
 		
         //ClassLoader cl = getClass().getClassLoader();
         /*String kycDirectoryName = cl.getResource("./../../../WebContent/").getPath().substring(1);*/
         /*File file = new File(cl.getResource("./docs/doc.pdf").getFile());*/
         
         /*System.out.println(" cl :::::: "+cl+" and kycDirectoryName :::: "+kycDirectoryName);*/
         
      /*   String filename = "/home/manisha/file.txt";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));*/
         String sourceFileName = fileName;//change accordingly
		 
		 DataSource source = new FileDataSource(sourceFileName);    
		 messageBodyPart2.setDataHandler(new DataHandler(source));    
		 /*messageBodyPart2.setFileName("AccountOpeningForm.pdf");*/
		 
		 
         /*System.out.println(" File name is : "+fileName);
         DataSource source = new FileDataSource("/"+fileName);    
         messageBodyPart2.setDataHandler(new DataHandler(source));    */
         messageBodyPart2.setFileName("clientRecords.xlsX");

         //5) create Multipart object and add MimeBodyPart objects to this object        
         Multipart multipart = new MimeMultipart();    
         multipart.addBodyPart(messageBodyPart1);     
         multipart.addBodyPart(messageBodyPart2); 
         
 		//message.setContent(bodyText.toString(), "text/html; charset=utf-8");

         message.setContent(multipart ); 
         
    		// Send message
    		Transport.send(message);
        
        
		} catch (IOException e) {
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
    
    public void sendKycFormMail(String pdfFile, String emailId, String subject, String fileName,
    				String mailLink,String displayLinkName) throws MoneyBuddyException{
    	
		try {
	
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(SendMail.class.getResourceAsStream(configPropFilePath));
			
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.host", configProperties.getProperty("GMAIL_HOST"));
    	props.put("mail.smtp.port", configProperties.getProperty("GMAIL_PORT"));

    	// Get the Session object.

    	Session session = Session.getInstance(props,
    			new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(configProperties.getProperty("GMAIL_USERNAME"), configProperties.getProperty("GMAIL_PASSWORD"));
    		}
    	});


    		// Create a default MimeMessage object.
    		Message message = new MimeMessage(session);

    		// Set From: header field of the header.
    		//message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME")));
    		message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME"),configProperties.getProperty("GMAIL_NAME")));

    		// Set To: header field of the header.

    		message.setRecipients(Message.RecipientType.TO,
    				InternetAddress.parse(emailId));

    		// Set Subject: header field

    		message.setSubject(subject);
    		
    		String mailContentFilePath = "../../../mailContents/"+fileName;
    		InputStream is = RegisterAction.class.getResourceAsStream(mailContentFilePath);
        	
    		
        	StringBuilder bodyText = new StringBuilder();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
            	
            	if (strLine.contains("LinkForEmail")) {
            		
            		System.out.println("contains LinkForEmail ");
            		strLine = strLine.replace("LinkForEmail", "<a href=\""+mailLink+"\">"+displayLinkName+"</a>");

            	}
            	bodyText.append(strLine);
            }

            
         BodyPart messageBodyPart1 = new MimeBodyPart(); 	    
         messageBodyPart1.setContent(bodyText.toString(),"text/html; charset=utf-8");

         //create new MimeBodyPart object and set DataHandler object to this object        
         MimeBodyPart messageBodyPart2 = new MimeBodyPart(); 
         
         System.out.println("pdfFile : "+pdfFile);
         //String sourceFileName = pdfFile;//change accordingly
         
         DataSource source = new FileDataSource(pdfFile);    
         messageBodyPart2.setDataHandler(new DataHandler(source));    
         messageBodyPart2.setFileName("AccountOpeningForm.pdf");

         //create Multipart object and add MimeBodyPart objects to this object        
         Multipart multipart = new MimeMultipart();    
         multipart.addBodyPart(messageBodyPart1);     
         multipart.addBodyPart(messageBodyPart2); 

         message.setContent(multipart );  
         
    		// Send message
    		Transport.send(message);
        
        
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
    
    public void sendAofAndKycFormMail(String aofPdfFile, String kycPdfFile, String emailId, String subject, 
    										String textFileName ) throws MoneyBuddyException{

    	
		try {
		
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";
		
			configProperties.load(SendMail.class.getResourceAsStream(configPropFilePath));
			System.setProperty("com.sun.security.enableAIAcaIssuers", "true");
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", configProperties.getProperty("GMAIL_HOST"));
			props.put("mail.smtp.port", configProperties.getProperty("GMAIL_PORT"));
			System.out.println(" GMAIL PORT IS  : "+ configProperties.getProperty("GMAIL_PORT"));
			
			// Get the Session object.
			
			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(configProperties.getProperty("GMAIL_USERNAME"), configProperties.getProperty("GMAIL_PASSWORD"));
				}
			});
		
		
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
		
			// Set From: header field of the header.
			//message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME")));
			message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME"),configProperties.getProperty("GMAIL_NAME")));
		
			// Set To: header field of the header.
		
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailId));
		
			// Set Subject: header field
		
			message.setSubject(subject);
			
			String mailContentFilePath = "../../../mailContents/"+textFileName;
			InputStream is = RegisterAction.class.getResourceAsStream(mailContentFilePath);
			
			
			StringBuilder bodyText = new StringBuilder();
		
		    BufferedReader br = new BufferedReader(new InputStreamReader(is));
		    
		    String strLine;
				    
			 BodyPart messageBodyPart1 = new MimeBodyPart(); 	    
			 messageBodyPart1.setContent(bodyText.toString(),"text/html; charset=utf-8");
			
			 //create new MimeBodyPart object and set DataHandler object to this object        
			 MimeBodyPart messageBodyPart2 = new MimeBodyPart(); 
			 
			 System.out.println("aofPdfFile : "+aofPdfFile+" : kycPdfFile : "+kycPdfFile);
			 
			 String sourceFileName = aofPdfFile;//change accordingly
			 
			 DataSource source = new FileDataSource(sourceFileName);    
			 messageBodyPart2.setDataHandler(new DataHandler(source));    
			 messageBodyPart2.setFileName("AccountOpeningForm.pdf");
			 
			 sourceFileName = kycPdfFile;//change accordingly
			 
			 source = new FileDataSource(sourceFileName);    
			 messageBodyPart2.setDataHandler(new DataHandler(source));    
			 messageBodyPart2.setFileName("KYC_Application_Form.pdf");
			
			 //create Multipart object and add MimeBodyPart objects to this object        
			 Multipart multipart = new MimeMultipart();    
			 multipart.addBodyPart(messageBodyPart1);     
			 multipart.addBodyPart(messageBodyPart2); 
			
			 message.setContent(multipart );  
		 
			// Send message
			Transport.send(message);
		
		
		} 
		catch (MessagingException e) {
			logger.error("sendMail class : sendAofAndKycFormMail method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
	
		catch (Exception e ) {
			logger.error("sendMail class : sendAofAndKycFormMail method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
	
    }
 
    
    public void sendAofFormMail(String pdfFile, String emailId, String subject, String fileName,
			String mailLink,String displayLinkName,String customerName) throws MoneyBuddyException{

    	
		try {
		
			String bccEmailId = "kamalwadhwani@gmail.com";
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";
		
			configProperties.load(SendMail.class.getResourceAsStream(configPropFilePath));
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", configProperties.getProperty("GMAIL_HOST"));
			props.put("mail.smtp.port", configProperties.getProperty("GMAIL_PORT"));
			
			// Get the Session object.
			
			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(configProperties.getProperty("GMAIL_USERNAME"), configProperties.getProperty("GMAIL_PASSWORD"));
				}
			});
		
		
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
		
			// Set From: header field of the header.
			//message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME")));
			message.setFrom(new InternetAddress(configProperties.getProperty("GMAIL_USERNAME"),configProperties.getProperty("GMAIL_NAME")));
		
			// Set To: header field of the header.
		
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailId));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(bccEmailId));
		
			// Set Subject: header field
		
			message.setSubject(subject);
			
			String mailContentFilePath = "../../../mailContents/"+fileName;
			InputStream is = RegisterAction.class.getResourceAsStream(mailContentFilePath);
			
			
			StringBuilder bodyText = new StringBuilder();
		
		    BufferedReader br = new BufferedReader(new InputStreamReader(is));
		    
		    String strLine;
		
		    //Read File Line By Line
		    while ((strLine = br.readLine()) != null)   {
		    	
		    	if (strLine.contains("LinkForEmail")) {
		    		
		    		System.out.println("contains LinkForEmail ");
		    		strLine = strLine.replace("LinkForEmail", "<a href=\""+mailLink+"\">"+displayLinkName+"</a>");
		
		    	}
		    	if (strLine.contains("customerName")) {
		    		
		    		System.out.println("contains customerName ");
		    		strLine = strLine.replace("customerName", customerName);
		
		    	}
		    	bodyText.append(strLine);
		    }
		
		    
			 BodyPart messageBodyPart1 = new MimeBodyPart(); 	    
			 messageBodyPart1.setContent(bodyText.toString(),"text/html; charset=utf-8");
			
			 //create new MimeBodyPart object and set DataHandler object to this object        
			 MimeBodyPart messageBodyPart2 = new MimeBodyPart(); 
			 
			 /*ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	    	 
	    	File file = new File(classLoader.getResource("Account_Opening_Form_1.pdf").getFile());*/
		    	
			 //System.out.println("pdfFile : "+file.getPath().toString());
			 String sourceFileName = pdfFile;//change accordingly
			 
			 DataSource source = new FileDataSource(sourceFileName);    
			 messageBodyPart2.setDataHandler(new DataHandler(source));    
			 messageBodyPart2.setFileName("AccountOpeningForm.pdf");
			
			 //create Multipart object and add MimeBodyPart objects to this object        
			 Multipart multipart = new MimeMultipart();    
			 multipart.addBodyPart(messageBodyPart1);     
			 multipart.addBodyPart(messageBodyPart2); 
			
			 message.setContent(multipart );  
		 
			// Send message
			Transport.send(message);
		
		
		} 
		catch (MessagingException e) {
			logger.error("sendMail class : sendAofFormMail method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
	
		catch (Exception e ) {
			logger.error("sendMail class : sendAofFormMail method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
	
    }
 
    
/*    public int triggerNewPage(PdfStamper stamper, Rectangle pagesize, ColumnText column, Rectangle rect, int pagecount) throws DocumentException {
        stamper.insertPage(pagecount, pagesize);
        PdfContentByte canvas = stamper.getOverContent(pagecount);
        column.setCanvas(canvas);
        column.setSimpleColumn(rect);
        return column.go();
    
    	return 0;
    }*/
    
/*	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMailerName() {
		return mailerName;
	}

	public void setMailerName(String mailerName) {
		this.mailerName = mailerName;
	}

	public String getHOST() {
		return HOST;
	}

	public void setHOST(String hOST) {
		HOST = hOST;
	}*/

/*	public String getSMTP_USERNAME() {
		return SMTP_USERNAME;
	}

	public void setSMTP_USERNAME(String sMTP_USERNAME) {
		SMTP_USERNAME = sMTP_USERNAME;
	}

	public String getSMTP_PASSWORD() {
		return SMTP_PASSWORD;
	}

	public void setSMTP_PASSWORD(String sMTP_PASSWORD) {
		SMTP_PASSWORD = sMTP_PASSWORD;
	}*/
/*
	public String getGmailHost() {
		return gmailHost;
	}

	public void setGmailHost(String gmailHost) {
		this.gmailHost = gmailHost;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/
    
    
    
}

