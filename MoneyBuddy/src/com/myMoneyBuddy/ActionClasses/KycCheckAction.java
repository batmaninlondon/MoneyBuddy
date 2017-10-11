/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfDataDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceStarMF;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.tempuri.IStarMFWebService;
import org.tempuri.MFOrderEntry;

/**
 *
 * @author Savita Wadhwani
 */
public class KycCheckAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(KycCheckAction.class);
	private Map<String, Object> sessionMap;
	
	private String fatherName;
	private String motherName;
	private String dateOfBirth;
    private String panCard;
    QueryKycStatus kyc = new QueryKycStatus();

    private InputStream stream;
	
/*    public void validate() {
    	
    	logger.debug("KycCheckAction class : validate method : start");
        try {
        	
        if(StringUtils.isEmpty(getPanCard()) )
            addFieldError("panCard","PAN Card number can't be blank!");

        else if (!kyc.existsPanCard(getPanCard()))
            addFieldError("panCard"," PAN Card does not exists.");
        } catch ( MoneyBuddyException e )  {
        	logger.debug("KycCheckAction class : validate method : end");
        	e.printStackTrace();
        }
        logger.debug("KycCheckAction class : validate method : end");

    }*/
    public String execute() {
    	try {
    		
    	logger.debug("KycCheckAction class : execute method : start");
    	System.out.println(" KycCheckAction execute method Called !!");
    	
    	System.out.println(" KycCheckAction execute method : Father Name : "+getFatherName());
    	System.out.println(" KycCheckAction execute method : Mother Name : "+getMotherName());
    	System.out.println(" KycCheckAction execute method : Date Of Birth : "+getDateOfBirth());
    	System.out.println(" KycCheckAction execute method : Pan Card : "+getPanCard());
    	
    	// Savita Wadhwani - Start - Added this block to validate input panCard through ajax call
    	
    	/*if (!kyc.existsPanCard(getPanCard())) {
    		System.out.println(" Returned invalid !!");
    		
    		String str = "invalid";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return "invalid";
    		return SUCCESS;
    	}
    	
    	// Savita Wadhwani - End - Added this block to validate input panCard through ajax call
    	
    	if (kyc.getKycStatusForPanCard(getPanCard()).equalsIgnoreCase("NO"))  {
    		logger.debug("KycCheckAction class : execute method : KYC is not done for "+getPanCard());
    		System.out.println(" Returned KYC not done !!");
    		String str = "kycNotDone";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return SUCCESS;
    	}*/

    	
    	/*DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Date frmtDateOfBirth = format.parse(getDateOfBirth());*/ 
    	
	    SessionFactory factory = new AnnotationConfiguration()
				.configure()
				.addAnnotatedClass(Customers.class)
				.buildSessionFactory();
	    Session session = factory.openSession(); 
	    
    	session.beginTransaction();
		Query query = session.createQuery("update Customers set fatherName = :fatherName , motherName = :motherName , dateOfBirth = :dateOfBirth ,panCard = :panCard  where customerId = :customerId");
		
		query.setParameter("fatherName", getFatherName());
		query.setParameter("motherName", getMotherName());
		query.setParameter("dateOfBirth", getDateOfBirth()); 
		query.setParameter("panCard", getPanCard());
		query.setParameter("customerId", sessionMap.get("customerId").toString());
		
		int updateResult = query.executeUpdate();
		System.out.println(updateResult + " rows updated in Customers table ");
		session.getTransaction().commit();
		
		
		// UPDATE ONLY IN CASE OF KYC DONE FOR CUSTOMER 
		
		session.beginTransaction();
		query = session.createQuery("update Customers set kycStatus = :kycStatus where customerId = :customerId");
		
		query.setParameter("kycStatus", "DONE");
		query.setParameter("customerId", sessionMap.get("customerId").toString());
		
		updateResult = query.executeUpdate();
		System.out.println(updateResult + " rows updated in Customers table ");
		session.getTransaction().commit();
		
		
    	
    	sessionMap.put("panCard", panCard);
    	System.out.println("Kyc is done for panCard : "+panCard);
    	
    	logger.debug("KycCheckAction class : execute method : stored panCard : "+panCard+" in session id : "+sessionMap.getClass().getName());
    	logger.debug("KycCheckAction class : execute method : end");
    	
    	System.out.println(" Returned Success !!");

    	String str = "success";
    	stream = new ByteArrayInputStream(str.getBytes());

    	return SUCCESS;
    	} 
    	/*catch ( MoneyBuddyException e )  {
    		logger.error("KycCheckAction class : execute method : caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}*/
    	catch ( Exception e )  {
    		logger.error("KycCheckAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    

    public Map<String, Object> getSession() {
		return sessionMap;
	}
    
	public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



}
