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
	private String dateOfBirth;
	private String maritalStatus;
    private String nationality;
    private String status;
    private String taxStatus;
    private String addressLineOne;
	private String addressLineTwo;
	private String addressLineThree;
	private String residentialCity;
    private String residentialState;
    private String residentialPin;
    private String residentialCountry;
    
    QueryKycStatus kyc = new QueryKycStatus();

    private InputStream stream;
	
    public String execute() {
    	Session session = null;
    	
    	try {
    		
    	logger.debug("PrepareKycFormAction class : execute method : start");
    	System.out.println(" PrepareKycFormAction execute method Called !!");
    	
	    System.out.println(" PrepareKycFormAction execute method :fatherName : "+getFatherName());
    	System.out.println(" PrepareKycFormAction execute method :dateOfBirth : "+getDateOfBirth());
    	System.out.println(" PrepareKycFormAction execute method :maritalStatus : "+getMaritalStatus());
    	System.out.println(" PrepareKycFormAction execute method :nationality : "+getNationality());
    	System.out.println(" PrepareKycFormAction execute method :status : "+getStatus());
    	System.out.println(" PrepareKycFormAction execute method :addressLineOne : "+getAddressLineOne());
    	System.out.println(" PrepareKycFormAction execute method :addressLineTwo : "+getAddressLineTwo());
    	System.out.println(" PrepareKycFormAction execute method :residentialCity : "+getResidentialCity());
    	System.out.println(" PrepareKycFormAction execute method :residentialState : "+getResidentialState());
    	System.out.println(" PrepareKycFormAction execute method :residentialPin : "+getResidentialPin());
    	System.out.println(" PrepareKycFormAction execute method :residentialCountry : "+getResidentialCountry());
    	System.out.println(" PrepareKycFormAction execute method :taxStatus : "+getTaxStatus());
    	
    	String customerId = sessionMap.get("customerId").toString();
    	
    	session = HibernateUtil.getSessionAnnotationFactory().openSession();
	    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(getDateOfBirth());
		String frmtdDateForDB = dateFormat.format(date);
		
	    AdditionalCustomerDetails tempAdditionalCustomer = new AdditionalCustomerDetails(customerId, getFatherName(), frmtdDateForDB, getMaritalStatus(),
				getNationality(), getStatus(), getAddressLineOne(), getAddressLineTwo(), getAddressLineThree(), getResidentialCity(),
				getResidentialState(), getResidentialPin(),getResidentialCountry(), getTaxStatus());
		session.beginTransaction();
		session.saveOrUpdate(tempAdditionalCustomer);
		session.getTransaction().commit();
		
		
    	GenerateKycForm generateKycForm = new GenerateKycForm();
    	generateKycForm.generateKycFormAndSendMail(customerId);

    	logger.debug("PrepareKycFormAction class : execute method : end");
    	
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getAddressLineThree() {
		return addressLineThree;
	}

	public void setAddressLineThree(String addressLineThree) {
		this.addressLineThree = addressLineThree;
	}

	public String getResidentialCity() {
		return residentialCity;
	}

	public void setResidentialCity(String residentialCity) {
		this.residentialCity = residentialCity;
	}

	public String getResidentialState() {
		return residentialState;
	}

	public void setResidentialState(String residentialState) {
		this.residentialState = residentialState;
	}

	public String getResidentialPin() {
		return residentialPin;
	}

	public void setResidentialPin(String residentialPin) {
		this.residentialPin = residentialPin;
	}

	public String getResidentialCountry() {
		return residentialCountry;
	}

	public void setResidentialCountry(String residentialCountry) {
		this.residentialCountry = residentialCountry;
	}

	public String getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
	}


}
