/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerDetails;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;

public class KycCheckAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(KycCheckAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String customerName;
	private String gender;
	private String occupation;
	private String dateOfBirth;
    private String taxStatus;
    private String addressLineOne;
	private String addressLineTwo;
	private String addressLineThree;
	private String residentialCity;
    private String residentialState;
    private String residentialPin;
    private String residentialCountry;

    private InputStream stream;
	
    public String execute() {
    	
    	String customerId = null;
    	try {
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - start ");
    		
	    	System.out.println(" KycCheckAction execute method Called !!");
	    	
	    	System.out.println(" KycCheckAction execute method : First Name : "+getCustomerName());
	    	System.out.println(" KycCheckAction execute method : Gender : "+getGender());
	    	System.out.println(" KycCheckAction execute method : Occupation : "+getOccupation());
	    	System.out.println(" PrepareKycFormAction execute method :dateOfBirth : "+getDateOfBirth());
	    	System.out.println(" PrepareKycFormAction execute method :addressLineOne : "+getAddressLineOne());
	    	System.out.println(" PrepareKycFormAction execute method :addressLineTwo : "+getAddressLineTwo());
	    	System.out.println(" PrepareKycFormAction execute method :residentialCity : "+getResidentialCity());
	    	System.out.println(" PrepareKycFormAction execute method :residentialState : "+getResidentialState());
	    	System.out.println(" PrepareKycFormAction execute method :residentialPin : "+getResidentialPin());
	    	System.out.println(" PrepareKycFormAction execute method :residentialCountry : "+getResidentialCountry());
	    	System.out.println(" PrepareKycFormAction execute method :taxStatus : "+getTaxStatus());
	    	
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
		    String dob = getDateOfBirth().substring(6,10)+"-"+getDateOfBirth().substring(3,5)+"-"+getDateOfBirth().substring(0,2);
			Date date = dateFormat.parse(dob);
			
			String frmtdDateForDB = dateFormat.format(date);
	
			sessionMap.put("customerName", getCustomerName());
			logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - stored customerName in sessionMap");
			
			
	    	UpdateCustomer UpdateCustomer = new UpdateCustomer();
	    	int updateResult =  UpdateCustomer.updateNameAndCustDetUploadedStatus(customerId, getCustomerName(), "Y");
	
	    	if (updateResult == 1) 
				sessionMap.put("CustDetUploaded", "Y");
			else 
				sessionMap.put("CustDetUploaded", "N");

			logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - stored CustDetUploaded in sessionMap");
	    	
			UpdateCustomerDetails updateCustomerDetails = new UpdateCustomerDetails();
			updateCustomerDetails.updateCustomerDetails(customerId, frmtdDateForDB, getAddressLineOne(), getAddressLineTwo(), getAddressLineThree(), 
					getResidentialCity(), getResidentialState(), getResidentialCountry(), getResidentialPin(), getTaxStatus(), getGender(), getOccupation());
	    	
	    	System.out.println(" Returned Success !!");
	
	    	if (sessionMap.get("kycStatus").toString().equalsIgnoreCase("DONE"))  {
	    		System.out.println(" Returned KYC  done !!");
	    		String str = "kycDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    	    logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - returned kycDone");
		    	logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - end");
		    	
	    		return SUCCESS;
	    	}
	    	else {
				System.out.println(" Returned KYC not done !!");
				String str = "kycNotDone";
			    stream = new ByteArrayInputStream(str.getBytes());
			    logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - returned kycNotDone");
		    	logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - end");
		    	
				return SUCCESS;
	    	}

    	} 
    	catch ( Exception e )  {
    		logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
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
	
}
