/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.mailerClasses;

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

/**
 *
 * @author Savita Wadhwani
 */
public class sendMail {

    private int port =465;
    private String host ="smtp.gmail.com";
    private String from="wadhwani.mail100@gmail.com";
    private boolean auth=true;
    private String username ="wadhwani.mail100@gmail.com";
    private String password="Wadhwani@123";
    private boolean debug=true;

    

    public  void    MailSending(String email, String hash, String link, StringBuilder bodyText, String subject) {

      final String username = "wadhwani.mail100@gmail.com";//change accordingly
      final String password = "Wadhwani@123";//change accordingly

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
	   message.setSubject(subject);

           //link = link+"?hash="+hash;
           /*StringBuilder bodyText = new StringBuilder();
            bodyText.append("<div>")
                 .append("  Dear User<br/><br/>")
                 .append("  Thank you for registration. Your mail ("+username+") is under verification<br/>")
                 .append("  Please click <a href=\""+link+"\">here</a> or open below link in browser<br/>")
                 .append("  <a href=\""+link+"\">"+link+"</a>")
                 .append("  <br/><br/>")
                 .append("  Thanks,<br/>")
                 .append("  SodhanaLibrary Team")
                 .append("</div>");
                 */
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

//    public static URI appendUri(String uri, String appendQuery) throws URISyntaxException {
//        URI oldUri = new URI(uri);
//
//        String newQuery = oldUri.getQuery();
//        if (newQuery == null) {
//            newQuery = appendQuery;
//        } else {
//            newQuery += "&" + appendQuery;
//        }
//
//        URI newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(),
//                oldUri.getPath(), newQuery, oldUri.getFragment());
//
//        return newUri;
//    }


}

