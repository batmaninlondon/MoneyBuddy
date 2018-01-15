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

import com.myMoneyBuddy.DAOClasses.GenerateKycForm;
import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.EntityClasses.AdditionalCustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.mailerClasses.SendMail;
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
public class PrepareKycFormAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(PrepareKycFormAction.class);
	private Map<String, Object> sessionMap;
	
	private String fatherName ;
	private String maritalStatus;
    private String nationality;
    private String status;
    private String grossAnnualIncome;
    private String politicallyExposed;
    
    QueryKycStatus kyc = new QueryKycStatus();

    private InputStream stream;
	
    public String execute() {
    	Session session = null;
    	
    	try {
    		
    	logger.debug("PrepareKycFormAction class : execute method : start");
    	System.out.println(" PrepareKycFormAction execute method Called !!");
    	
	    System.out.println(" PrepareKycFormAction execute method :fatherName : "+getFatherName());
    	System.out.println(" PrepareKycFormAction execute method :maritalStatus : "+getMaritalStatus());
    	System.out.println(" PrepareKycFormAction execute method :nationality : "+getNationality());
    	System.out.println(" PrepareKycFormAction execute method :status : "+getStatus());
    	System.out.println(" PrepareKycFormAction execute method :status : "+getGrossAnnualIncome());
    	System.out.println(" PrepareKycFormAction execute method :status : "+getPoliticallyExposed());
    	
    	String customerId = sessionMap.get("customerId").toString();
    	
    	session = HibernateUtil.getSessionAnnotationFactory().openSession();
	    
	    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	    //String dob = getDateOfBirth().substring(6,10)+"-"+getDateOfBirth().substring(3,5)+"-"+getDateOfBirth().substring(0,2);
		//Date date = dateFormat.parse(dob);
		
		//String frmtdDateForDB = dateFormat.format(date);
		
	    AdditionalCustomerDetails tempAdditionalCustomer = new AdditionalCustomerDetails(customerId, getFatherName(), getMaritalStatus(),
				getNationality(), getStatus(), getGrossAnnualIncome(),getPoliticallyExposed());
		session.beginTransaction();
		session.saveOrUpdate(tempAdditionalCustomer);
		session.getTransaction().commit();
		
		sessionMap.put("addCustDetUploaded", "Y");
		logger.debug("PrepareKycFormAction class : execute method : stored addCustDetUploaded : Y in session id : "+sessionMap.getClass().getName());
		
		String str = null;
		
	    	GenerateKycForm generateKycForm = new GenerateKycForm();
	    	generateKycForm.generateKycFormAndSendMail(customerId);	
	    	str = "success";


    	logger.debug("PrepareKycFormAction class : execute method : end");
    	
    	System.out.println(" Returned Success !!");
    	
    	
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
    	finally {
    		/*if(factory!=null)
			factory.close();*/
    		//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    

    public Map<String, Object> getSession() {
		return sessionMap;
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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(String grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getPoliticallyExposed() {
		return politicallyExposed;
	}

	public void setPoliticallyExposed(String politicallyExposed) {
		this.politicallyExposed = politicallyExposed;
	}


}
