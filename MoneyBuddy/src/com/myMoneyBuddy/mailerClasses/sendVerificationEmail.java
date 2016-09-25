/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.mailerClasses;

/**
 *
 * @author Savita Wadhwani
 */

//import com.sun.mail.smtp.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class sendVerificationEmail {

private int port =465;
private String host ="smtp.gmail.com";
private String from="wadhwani.mail100@gmail.com";
private boolean auth=true;
private String username ="wadhwani.mail100@gmail.com";
private String password="Wadhwani@123";
//private Protocol protocol = Protocol.
private boolean debug=true;

  public final String MAIL_REGISTRATION_SITE_LINK = "http://localhost:8080/MoneyBuddy/userVerification.jsp";


//public static void main(String args[]) {
  //  sendVerificationEmail email = new sendVerificationEmail();
    //System.out.println(" Calling send email function.");
    //email.sendEmail("savita.wadhwani@gmail.com", "Test mail", "Hi there from java code.");
    //email.MailSending();
   // System.out.println(" send email function completed.");
//}



   public  void MailSending(String email, String hash) {
      // Recipient's email ID needs to be mentioned.
      //String to = "savita.wadhwani@gmail.com";

      // Sender's email ID needs to be mentioned
      //String from = "wadhwani.mail100@gmail.com";
      final String username = "wadhwani.mail100@gmail.com";//change accordingly
      final String password = "Wadhwani@123";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      //String host = "relay.jangosmtp.net";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      System.out.println(" hello dear 1");
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });
System.out.println(" hello dear 2");
      try {
	   // Create a default MimeMessage object.
	   Message message = new MimeMessage(session);

	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress("wadhwani.mail100@gmail.com"));

	   // Set To: header field of the header.

	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(email));

	   // Set Subject: header field
	   message.setSubject("Testing Subject");
          // String hash = "12345";
           //DesEncrypter desEncrypter = new DesEncrypter(username);
           //String hash = desEncrypter.encrypt(password);
	   // Now set the actual message
           String link = MAIL_REGISTRATION_SITE_LINK+"?hash="+hash;
                     StringBuilder bodyText = new StringBuilder();
            bodyText.append("<div>")
                 .append("  Dear User<br/><br/>")
                 .append("  Thank you for registration. Your mail ("+username+") is under verification<br/>")
                 .append("  Please click <a href=\""+link+"\">here</a> or open below link in browser<br/>")
                 .append("  <a href=\""+link+"\">"+link+"</a>")
                 .append("  <br/><br/>")
                 .append("  Thanks,<br/>")
                 .append("  SodhanaLibrary Team")
                 .append("</div>");

	   message.setContent(bodyText.toString(), "text/html; charset=utf-8");

	   // Send message
           System.out.println(" hello dear 3");
	   Transport.send(message);
           System.out.println(" hello dear 4");

	   System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }

    public static URI appendUri(String uri, String appendQuery) throws URISyntaxException {
        URI oldUri = new URI(uri);

        String newQuery = oldUri.getQuery();
        if (newQuery == null) {
            newQuery = appendQuery;
        } else {
            newQuery += "&" + appendQuery;
        }

        URI newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(),
                oldUri.getPath(), newQuery, oldUri.getFragment());

        return newUri;
    }


}
