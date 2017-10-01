package com.myMoneyBuddy.mailerClasses;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.net.ssl.HttpsURLConnection;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import static java.nio.file.StandardCopyOption.*;

public class FetchMail {
	
 	private static int port =587;
    private static String host ="smtp.gmail.com";
    private static String username ="mf.moneybuddy@gmail.com";
    private static String password="Money@Buddy";
    private static boolean debug=true;
    

   public static void fetch(String pop3Host, String storeType, String user,
      String password) {
      try {
         // create properties field
         Properties properties = new Properties();
         

        
        
         properties.put("mail.store.protocol", "pop3");
         properties.put("mail.pop3.host", getHost() );
         properties.put("mail.pop3.port", getPort());
         properties.put("mail.pop3.starttls.enable", "true");
         Session emailSession = Session.getDefaultInstance(properties);
         // emailSession.setDebug(true);

         // create the POP3 store object and connect with the pop server
         Store store = emailSession.getStore("imaps");

         store.connect(pop3Host, user, password);

         
         // create the folder object and open it
         Folder emailFolder = store.getFolder("INBOX");
         

         emailFolder.open(Folder.HOLDS_MESSAGES);
         int count = emailFolder.getMessageCount();
         System.out.println("count : "+count);
         
         System.out.println(" emailFolder : "+emailFolder.HOLDS_MESSAGES);
         //emailFolder.open(Folder.READ_ONLY);

         BufferedReader reader = new BufferedReader(new InputStreamReader(
	      System.in));

         // retrieve the messages from the folder in an array and print it
         Message[] messages = emailFolder.getMessages();
         System.out.println("messages.length---" + messages.length);

         for (int i = 0; i < messages.length; i++) {
            Message message = messages[i];
            //System.out.println("---------------------------------");
            //System.out.println(i+ " message subject : "+message.getSubject());

            Address[] a;
            String subject;
            // SUBJECT
            if (message.getSubject() != null)  {
            	subject = message.getSubject();
            	if (subject.contains("Subscribed Transaction Feeds Report for Reference No.: WBTRN2210159"))  {
            		System.out.println("Contains the mentioned subject ! ");
            		System.out.println(i+ " message subject : "+message.getSubject());

            		String content = message.getContent().toString();
            		List<String> extractedUrls = extractUrls(content);
            		for (String urlFound : extractedUrls)  {
            			System.out.println("urlFound : "+urlFound);
            		}
            		
            		//check if the content is plain text
            	      if (message.isMimeType("text/plain")) {
            	         System.out.println("This is plain text");
            	         System.out.println("---------------------------");
            	         System.out.println((String) message.getContent());
            	      } 
            	      //check if the content has attachment
            	      else if (message.isMimeType("multipart/*")) {
            	         System.out.println("This is a Multipart");
            	         System.out.println("---------------------------");
            	         Multipart mp = (Multipart) message.getContent();
            	         int count_new = mp.getCount();
            	         //for (int j = 0; j < count_new; j++)
            	            //writePart(mp.getBodyPart(j));
            	      } 
            	      //check if the content is a nested message
            	      else if (message.isMimeType("message/rfc822")) {
            	         System.out.println("This is a Nested Message");
            	         System.out.println("---------------------------");
            	         writePart((Part) message.getContent());
            	      } 
            	      

            	      
            	}
            }
            //String line = reader.readLine();
            /*if ("YES".equals(line)) {
            	
               //message.writeTo(System.out);
            } else if ("QUIT".equals(line)) {
               break;
            }*/
         }

         // close the store and folder objects
         emailFolder.close(false);
         store.close();
         
         String urlName = "https://www.karvymfs.com/karvy/Subreports/7C7F797C6EWBTRN22101598620644.zip";
         String zipFileName = "D://DelMe/"+urlName.substring(42);
         //System.out.println("File name is : "+zipFileName);
         
 	    //zip password
	      String pass="MoneyBuddy123";

	          ZipFile zipFile = new ZipFile(zipFileName);
	            if (zipFile.isEncrypted()) {
	               zipFile.setPassword(pass);
	          }
	      //extract somewhere in directory
	      zipFile.extractAll("D://DelMe/xlsFiles");
	      
         URL url = new URL(urlName);
         HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

         // Check for errors
         int responseCode = con.getResponseCode();
         InputStream inputStream;
         if (responseCode == HttpURLConnection.HTTP_OK) {
             inputStream = con.getInputStream();
             //System.out.println("ok");
         } else {
             inputStream = con.getErrorStream();
             //System.out.println("not ok");
         }
         
         Files.copy(inputStream, Paths.get(zipFileName) , REPLACE_EXISTING);
      

         /*OutputStream output = new FileOutputStream("test.zip");

         // Process the response
         BufferedReader reader_new;
         String line = null;
         reader_new = new BufferedReader(new InputStreamReader(inputStream));
         while ((line = reader_new.readLine()) != null) {
             output.write(line.getBytes());
         }

         output.close();*/
         inputStream.close();
         
         

      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (ZipException e) {
	     e.printStackTrace();
	  }/*catch (IOException e) {
         e.printStackTrace();
      }*/ catch (Exception e) {
         e.printStackTrace();
      }
   }
   public static void main(String[] args) {

      String host = getHost();// change accordingly
      String mailStoreType = "pop3";
      String username = 
         "mf.moneybuddy@gmail.com";// change accordingly
      String password = "Money@Buddy";// change accordingly

      //Call method fetch
      fetch(host, mailStoreType, username, password);

   }
   
   public static List<String> extractUrls(String input) {
       List<String> result = new ArrayList<String>();

       System.out.println("Inside extractUrls method !");
       System.out.println("inout : "+input);
       /*Pattern pattern = Pattern.compile(
           "\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" + 
           "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" + 
           "|mil|biz|info|mobi|name|aero|jobs|museum" + 
           "|travel|[a-z]{2}))(:[\\d]{1,5})?" + 
           "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" + 
           "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + 
           "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" + 
           "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + 
           "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" + 
           "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");*/
       
       Pattern pattern = Pattern.compile("https://www*");

       Matcher matcher = pattern.matcher(input);
       while (matcher.find()) {
    	   System.out.println("Match found! "+matcher.group());
           result.add(matcher.group());
       }

       return result;
   }
   

   /*
   * This method checks for content-type 
   * based on which, it processes and
   * fetches the content of the message
   */
   public static void writePart(Part p) throws Exception {
      if (p instanceof Message)
         //Call methos writeEnvelope
         writeEnvelope((Message) p);

      System.out.println("----------------------------");
      System.out.println("CONTENT-TYPE: " + p.getContentType());

      //check if the content is plain text
      if (p.isMimeType("text/plain")) {
         System.out.println("This is plain text");
         System.out.println("---------------------------");
         System.out.println((String) p.getContent());
      } 
      //check if the content has attachment
      else if (p.isMimeType("multipart/*")) {
         System.out.println("This is a Multipart");
         System.out.println("---------------------------");
         Multipart mp = (Multipart) p.getContent();
         int count = mp.getCount();
         for (int i = 0; i < count; i++)
            writePart(mp.getBodyPart(i));
      } 
      //check if the content is a nested message
      else if (p.isMimeType("message/rfc822")) {
         System.out.println("This is a Nested Message");
         System.out.println("---------------------------");
         writePart((Part) p.getContent());
      } 
      //check if the content is an inline image
      else if (p.isMimeType("image/jpeg")) {
         System.out.println("--------> image/jpeg");
         Object o = p.getContent();

         InputStream x = (InputStream) o;
         // Construct the required byte array
         System.out.println("x.length = " + x.available());
         int i = 0;
         byte[] bArray = new byte[x.available()];
         
         while ((i = (int) ((InputStream) x).available()) > 0) {
            int result = (int) (((InputStream) x).read(bArray));
            if (result == -1)
         
         
            break;
         }
         FileOutputStream f2 = new FileOutputStream("/tmp/image.jpg");
         f2.write(bArray);
      } 
      else if (p.getContentType().contains("image/")) {
         System.out.println("content type" + p.getContentType());
         File f = new File("image" + new Date().getTime() + ".jpg");
         DataOutputStream output = new DataOutputStream(
            new BufferedOutputStream(new FileOutputStream(f)));
            com.sun.mail.util.BASE64DecoderStream test = 
                 (com.sun.mail.util.BASE64DecoderStream) p
                  .getContent();
         byte[] buffer = new byte[1024];
         int bytesRead;
         while ((bytesRead = test.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
         }
      } 
      else {
         Object o = p.getContent();
         if (o instanceof String) {
            System.out.println("This is a string");
            System.out.println("---------------------------");
            System.out.println((String) o);
         } 
         else if (o instanceof InputStream) {
            System.out.println("This is just an input stream");
            System.out.println("---------------------------");
            InputStream is = (InputStream) o;
            is = (InputStream) o;
            int c;
            while ((c = is.read()) != -1)
               System.out.write(c);
         } 
         else {
            System.out.println("This is an unknown type");
            System.out.println("---------------------------");
            System.out.println(o.toString());
         }
      }

   }
   /*
   * This method would print FROM,TO and SUBJECT of the message
   */
   public static void writeEnvelope(Message m) throws Exception {
      System.out.println("This is the message envelope");
      System.out.println("---------------------------");
      Address[] a;

      // FROM
      if ((a = m.getFrom()) != null) {
         for (int j = 0; j < a.length; j++)
         System.out.println("FROM: " + a[j].toString());
      }

      // TO
      if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
         for (int j = 0; j < a.length; j++)
         System.out.println("TO: " + a[j].toString());
      }

      // SUBJECT
      if (m.getSubject() != null)
         System.out.println("SUBJECT: " + m.getSubject());

   }
public static int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}
public static String getHost() {
	return host;
}
public void setHost(String host) {
	this.host = host;
}
public static String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public static String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

   
}