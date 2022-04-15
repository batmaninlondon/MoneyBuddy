/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.myMoneyBuddy.EntityClasses.AdditionalCustomerDetails;
import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;

public class GenerateKycForm {

	Logger logger = LogManager.getLogger(GenerateKycForm.class);
	
    public void generateKycForm (String customerId) throws MoneyBuddyException
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

    		/*String pdfFilePath = "../../../editablePdfs/"+"KYC_Application_Form_Original.pdf";
    		InputStream is = RegisterAction.class.getResourceAsStream(pdfFilePath);
    		reader = new PdfReader(is);*/
    		
	    	
			ClassLoader cl = getClass().getClassLoader();
			
			String directoryName = cl.getResource("./../../assets/KycForms").getPath().substring(1);

    		System.out.println(" directoryName is : "+directoryName);
    		
    		reader = new PdfReader(directoryName+"/KYC_Application_Form_Original.pdf");
    		
    		
    		
    		//reader = new PdfReader("../../../editablePdfs/KYC_Application_Form.pdf");
    		
    		/*String pdfFilePath = "../../../editablePdfs/";
    		InputStream is = RegisterAction.class.getResourceAsStream(mailContentFilePath);*/
    		
    		//String directoryName = "../../../editablePdfs/"+customerId;
    		//String directoryName = new File(GenerateKycForm.class.getProtectionDomain(). getCodeSource().getLocation().getPath()).getCanonicalPath();
    		
    		/*Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateKycForm.class.getResourceAsStream(configPropFilePath));*/
	    	
	    	//String directoryName = configProperties.getProperty("KYC_PDF_DIRECTORY");


            File directory = new File(String.valueOf(directoryName));
            
            if(!directory.exists()){

                directory.mkdir();
                
            }
            
            System.out.println("directory : "+directory.getAbsolutePath());
            
            stamper = new PdfStamper(reader,
         	          new FileOutputStream(directoryName+"/KYC_Application_Form_"+customerId+".pdf")); // output PDF
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
            String[] states = form.getAppearanceStates("Female");
            
            System.out.println(Arrays.toString(states));
            
            //form.setField("Female","On");
            
            //form.setField("Single", "On");
            
            if ( "F".equals(customerDetail.getGender())) {
            	form.setField("F ema","On");
            	form.setField("Ma","Off");
            }
            else {
            	form.setField("Ma","On");
            	form.setField("F ema","Off");
            }
            
            if ( "Married".equals(additionalDetails.getMaritalStatus())) {
            	form.setField("Married","On");
            	form.setField("Single","Off");
            }
            else {
            	form.setField("Single","On");
            	form.setField("Married","Off");
            }
            
            // assuming dob will come in dd/mm/yyyy format
            
            String dob = customerDetail.getDateOfBirth();
            
            System.out.println("Date : "+dob.substring(8,10));
            System.out.println(" Month : "+dob.substring(5,7));
            System.out.println("Year : "+dob.substring(0,4));
            form.setField("Date",dob.substring(8,10));
            form.setField("Month",dob.substring(5,7));
            form.setField("Year",dob.substring(0,4));
            
            if ( "Indian".equals(additionalDetails.getNationality())) {
            	form.setField("Indian","On");
            	form.setField("Foreigner","Off");
            }
            else {
            	form.setField("Foreigner","On");
            	form.setField("Indian","Off");
            }
            
            if ( "LivInInd".equals(additionalDetails.getStatus())) {
            	form.setField("Resident Indian","On");
            	form.setField("NRI","Off");
            	form.setField("Foreign National","Off");
            }
            else if ("NonResInd".equals(additionalDetails.getStatus())) {
            	form.setField("NRI","On");
            	form.setField("Resident Indian","Off");
            	form.setField("Foreign National","Off");
            }
            else {
            	form.setField("Foreign National","On");
            	form.setField("NRI","Off");
            	form.setField("Resident Indian","Off");
            }
            
            System.out.println(" Customer PAN card num in Upper case : "+customer.getPanCard().toUpperCase());
            System.out.println(" Customer Res State num in Upper case : "+customerDetail.getResidentialState().toUpperCase());
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
           
           System.out.println("End!!");
           
    	}
    	catch ( HibernateException e ) {
    		
			logger.error("insertCustomerDetails class : insertCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("insertCustomerDetails class : insertCustomer method : Caught Exception");
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

    public void sendKycFormMail (String customerId) throws MoneyBuddyException
    {

    	logger.debug("GenerateKycForm class : sendKycFormMail method : start");
    	
    	try {
           
    		QueryCustomer queryCustomer = new QueryCustomer();
    		
    		String emailId = queryCustomer.getCustomerEmailId(customerId);
    		
    		Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateKycForm.class.getResourceAsStream(configPropFilePath));
			
           String mailLink = configProperties.getProperty("MAIL_KYC_FORM_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_KYC_FORM_SUBJECT");
	    	
	    	String directoryName = configProperties.getProperty("KYC_PDF_DIRECTORY");
       		SendMail sendMail = new SendMail();
       		sendMail.sendKycFormMail(directoryName+"/KYC_Application_Form_"+customerId+".pdf", emailId,subject,"KycNotDone.txt",mailLink,"");
       	
           System.out.println("End!!");
           
    	}
		catch (Exception e ) {
			logger.error("insertCustomerDetails class : insertCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}

    }
    

}

