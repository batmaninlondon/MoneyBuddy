/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;

public class GenerateAofForm {

	Logger logger = LogManager.getLogger(GenerateAofForm.class);
	
    public void generateAofForm (String customerId) throws MoneyBuddyException
    {

    	logger.debug("GenerateAofForm class : generateAofForm method : start");
    	PdfReader reader = null;
    	PdfStamper stamper = null;
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	
    	try {
    		
    		hibernateSession.beginTransaction();
    		Customers customer = (Customers) hibernateSession.get(Customers.class, customerId);
    		CustomerDetails customerDetail = (CustomerDetails) hibernateSession.get(CustomerDetails.class, customerId);
    		System.out.println("state :"+customerDetail.getResidentialState());
    		hibernateSession.getTransaction().commit();  
    		
    		hibernateSession.beginTransaction();
    		Query query = hibernateSession.createQuery("from BankDetails where customerId = :customerId ");
    		query.setParameter("customerId", customerId);
    		BankDetails bankDetails = (BankDetails) query.uniqueResult();
    		hibernateSession.getTransaction().commit();  
    		System.out.println("bankName before :"+bankDetails.getBankName());
    		System.out.println("AccountType  :"+bankDetails.getAccountType());
    		System.out.println("IfscCode  :"+bankDetails.getIfscCode());
    		System.out.println("Mobile num  :"+customer.getMobileNumber());
    		System.out.println("PanCard  :"+customer.getPanCard().toUpperCase());
    		System.out.println("Date of birth  :"+customerDetail.getDateOfBirth());
    		System.out.println("Pin Code  :"+customerDetail.getResidentialPin());

    		
    		QueryDisplayName queryDisplayName = new QueryDisplayName();
    		DesEncrypter desEncrypter = new DesEncrypter();
    		System.out.println("bankName after :"+queryDisplayName.displayBankName(bankDetails.getBankName()));
	    	
			ClassLoader cl = getClass().getClassLoader();
			
			String directoryName = cl.getResource("./../../assets/AofForms").getPath().substring(1);

    		System.out.println("directoryName is : "+directoryName);
    		
    		reader = new PdfReader("/"+directoryName+"AoF_Original.pdf");
    		
            File directory = new File(String.valueOf(directoryName));
            
            if(!directory.exists()){

                directory.mkdir();
                
            }
            
            stamper = new PdfStamper(reader,
         	          new FileOutputStream("/"+directoryName+"AoF_Form_"+customerId+".pdf")); // output PDF
            AcroFields form = stamper.getAcroFields();
            
            HashMap map = new HashMap();
            map = (HashMap) form.getFields();
            Iterator iterator = map.keySet().iterator();

            while(iterator.hasNext())
                System.out.println("Field is >>>"+iterator.next()+"<<");
            
            String customerName = customer.getCustomerName();
            form.setField("Category", "Individual - Resident Indian");
            form.setField("Name", customerName.toUpperCase());
            if ("F".equals(customerDetail.getGender().toUpperCase()))
            	form.setField("Gender", "Female");  
            else 
            	form.setField("Gender", "Male");
            if ("IN".equals(customerDetail.getTaxResidency()))
            	form.setField("CountryofTaxResidency", "India");
            else 
            	form.setField("CountryofTaxResidency", "Other");
            form.setField("PhoneNo", customer.getMobileNumber());  
            form.setField("EmailID", customer.getEmailId());  
            form.setField("PanCard", customer.getPanCard().toUpperCase());  
            form.setField("Occupation", queryDisplayName.displayOccupation(customerDetail.getOccupation()));  
            form.setField("DateofBirth", customerDetail.getDateOfBirth());  
            form.setField("Addressline1", customerDetail.getAddressLineOne());  
            form.setField("Addressline2", customerDetail.getAddressLineTwo());  
            form.setField("City", customerDetail.getResidentialCity());  
            form.setField("PinCode", customerDetail.getResidentialPin());
            form.setField("State", customerDetail.getResidentialState());  
            form.setField("Country", customerDetail.getResidentialCountry());  
            form.setField("BankName", queryDisplayName.displayBankName(bankDetails.getBankName())); 
            String accType = null;
            if ("SB".equals(bankDetails.getAccountType()))
            	accType = "Saving";
            else if ("CB".equals(bankDetails.getAccountType()))
            	accType="Current";
            else if ("NE".equals(bankDetails.getAccountType()))
            	accType = "NRE";
            else 
            	accType="NRO";
            
            form.setField("TypeSBorCurrent", accType);  
            
            /*
             * 'SB':'Saving', 'CB':'Current', 'NE':'NRE', 
			        'NO':'NRO'
             */
            form.setField("AccountNumber", desEncrypter.decrypt(bankDetails.getAccountNumber()));  
            form.setField("IFSCCode", bankDetails.getIfscCode());  
            form.setField("NomineesName", customerDetail.getNomineeName().toUpperCase());  
            form.setField("Relationship", customerDetail.getNomineeRelationship());
            form.setField("URNNumber", customer.getIsipMandateId());  
            
           
           stamper.setFormFlattening(true);
           stamper.close();
           reader.close();
           
           logger.debug("GenerateAofForm class : generateAofForm method : end");
           System.out.println("End of file creation!!");
           
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

    public void sendAofFormMail (String customerId) throws MoneyBuddyException
    {

    	logger.debug("GenerateAofForm class : sendAofFormMail method : start");
    	
    	try {
           
    		QueryCustomer queryCustomer = new QueryCustomer();
    		
    		String emailId = queryCustomer.getCustomerEmailId(customerId);
    		
    		Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateAofForm.class.getResourceAsStream(configPropFilePath));
			
           String mailLink = configProperties.getProperty("MAIL_AOF_FORM_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_AOF_FORM_SUBJECT");
	    	
	    	String directoryName = configProperties.getProperty("AOF_PDF_DIRECTORY");
       		SendMail sendMail = new SendMail();
       		sendMail.sendKycFormMail(directoryName+"/AccountOpeningForm_"+customerId+".pdf", emailId,subject,"AccountOpeningForm.txt",mailLink,"");
       	
           System.out.println("End!!");
           
    	}
		catch (Exception e ) {
			logger.error("GenerateAofForm class : sendAofFormMail method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}

    }
    

}

