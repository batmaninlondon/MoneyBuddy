/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.myMoneyBuddy.EntityClasses.AdditionalCustomerDetails;
import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class GenerateKycForm {

	Logger logger = Logger.getLogger(GenerateKycForm.class);
	
    public void generateKycFormAndSendMail (String customerId) throws MoneyBuddyException
    {

    	logger.debug("GenerateKycForm class : generateKycFormPdf method : start");
    	PdfReader reader = null;
    	PdfStamper stamper = null;
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	
    	try {
    		
    		hibernateSession.beginTransaction();
    		Customers customer = (Customers) hibernateSession.get(Customers.class, customerId);
    		CustomerDetails customerDetail = (CustomerDetails) hibernateSession.get(CustomerDetails.class, customerId);
    		AdditionalCustomerDetails additionalDetails = (AdditionalCustomerDetails) hibernateSession.get(AdditionalCustomerDetails.class, customerId);
    		hibernateSession.getTransaction().commit();

    		
    		reader = new PdfReader("D://PdfFiles/KYC.pdf");
    		
    		String directoryName = "D://PdfFiles/"+customerId;
            File directory = new File(String.valueOf(directoryName));
            
            if(!directory.exists()){

                directory.mkdir();
            }
            
            stamper = new PdfStamper(reader,
         	          new FileOutputStream(directoryName+"/KYC_Application_Form.pdf")); // output PDF
            AcroFields form = stamper.getAcroFields();
            
            HashMap map = new HashMap();
            map = (HashMap) form.getFields();
            Iterator iterator = map.keySet().iterator();
            System.out.println("iterator size : "+map.size());
            while(iterator.hasNext())
                System.out.println("Field is >>>"+iterator.next());

            String customerName = customer.getCustomerName();
            form.setField("Name", customerName.toUpperCase());
            form.setField("FathersSpouse Name", additionalDetails.getFatherName().toUpperCase());  
            
            if ( "F".equals(customerDetail.getGender()))
            	form.setField("Female","On");
            else 
            	form.setField("Male","On");
            
            if ( "Married".equals(additionalDetails.getMaritalStatus()))
            	form.setField("Married","On");
            else 
            	form.setField("Single","On");
            
            // assuming dob will come in dd/mm/yyyy format
            
            String dob = customerDetail.getDateOfBirth();
            
            System.out.println("Date : "+dob.substring(8,10));
            System.out.println(" Month : "+dob.substring(5,7));
            System.out.println("Year : "+dob.substring(0,4));
            form.setField("Date",dob.substring(8,10));
            form.setField("Month",dob.substring(5,7));
            form.setField("Year",dob.substring(0,4));
            
            if ( "Indian".equals(additionalDetails.getNationality()))
            	form.setField("Indian","On");
            else 
            	form.setField("Foreigner","On");
            
            if ( "LivInInd".equals(additionalDetails.getStatus()))
            	form.setField("Resident Indian","On");
            else if ("NonResInd".equals(additionalDetails.getStatus()))
            	form.setField("NRI","On");
            else 
            	form.setField("Foreign National","On");
            
            form.setField("PAN", customer.getPanCard().toUpperCase());
            
            form.setField("Address 1.0", "Updated");
            form.setField("Address 1.1", customerDetail.getAddressLineOne().toUpperCase()+" "+customerDetail.getAddressLineTwo().toUpperCase());
            form.setField("Address 1.2", customerDetail.getAddressLineThree().toUpperCase());
            form.setField("City", customerDetail.getResidentialCity().toUpperCase());
            form.setField("Pin Code", customerDetail.getResidentialPin());
            form.setField("State", customerDetail.getResidentialState().toUpperCase());
            form.setField("Country", customerDetail.getResidentialCountry().toUpperCase());
            form.setField("Mobile No",customer.getMobileNumber());
            form.setField("Email ID",customer.getEmailId());
            
            
            String grossAnnualIncome = additionalDetails.getGrossAnnualIncome();
            if ( "LesThaOneLak".equals(grossAnnualIncome))
            	form.setField("Below 1 lac","On");
            else if ( "OneToFivLak".equals(grossAnnualIncome))
            	form.setField("15 Lac","On");
            else if ( "FivToTenLak".equals(grossAnnualIncome))
            	form.setField("510 Lac","On");
            else if ( "TenToTweFivLak".equals(grossAnnualIncome))
            	form.setField("1025 Lac","On"); 	
            else 
            	form.setField("25 Lacs","On");
            
           
           String occupation = customerDetail.getOccupation();
           if ( "PriSecJob".equals(occupation))
        	   form.setField("Private Sector Service","On");
           else if ( "PubSecJob".equals(occupation))
        	   form.setField("Public Sector","On");
           else if ( "GovSer".equals(occupation))
        	   form.setField("Government Service","On");
           else if ( "Business".equals(occupation))
        	   form.setField("Business","On");
           else if ( "Professional".equals(occupation))
        	   form.setField("Professional","On");
           else if ( "Agriculturist".equals(occupation))
        	   form.setField("Agriculturist","On");
           else if ( "Retired".equals(occupation))
        	   form.setField("Retired","On");
           else if ( "Student".equals(occupation))
        	   form.setField("Student","On");
           else if ( "ForexDeal".equals(occupation))
        	   form.setField("Forex Dealer","On");
           else if ( "HouseWife".equals(occupation))
        	   form.setField("Housewife","On");
           else
        	   form.setField("Others Please specify","On");
           
           if ("PoliticExposed".equals(additionalDetails.getPoliticallyExposed()))
        	   form.setField("Politically Exposed Person","On");
           else if ("RelToPoliticExposed".equals(additionalDetails.getPoliticallyExposed()))
        	   form.setField("Related to a Politically Exposed Person","On");
           
           stamper.setFormFlattening(true);
           stamper.close();
           reader.close();
           
           Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateKycForm.class.getResourceAsStream(configPropFilePath));
			
           String mailLink = configProperties.getProperty("MAIL_KYC_FORM_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_KYC_FORM_SUBJECT");
	    	
       		SendMail sendMail = new SendMail();
       		sendMail.sendKycFormMail(directoryName+"/KYC_Application_Form.pdf", customer.getEmailId(),subject,"KycNotDone.txt",mailLink,"");
       	
           System.out.println("End!!");
           
    	}
    	catch ( HibernateException e ) {
    		
			logger.debug("insertCustomerDetails class : insertCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("insertCustomerDetails class : insertCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {

    		if(reader !=null)
    			reader.close();
			if(hibernateSession !=null )
					hibernateSession.close();
    			
    	}

    }
    

}

