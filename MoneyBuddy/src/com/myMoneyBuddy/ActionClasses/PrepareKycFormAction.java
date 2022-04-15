/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.InsertAdditionalCustomerDetails;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.opensymphony.xwork2.ActionSupport;

public class PrepareKycFormAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(PrepareKycFormAction.class);
	private SessionMap<String,Object> sessionMap;	
	private String fatherName ;
	private String maritalStatus;
    private String nationality;
    private String status;
    private String grossAnnualIncome;
    private String politicallyExposed;
    //private String tranDetailId;
	
    public String execute() {
    	
    	String customerId = null;
    	try {
    	
        	customerId = sessionMap.get("customerId").toString();
        	logger.debug("PrepareKycFormAction class - execute method - customerId - "+customerId+" - start ");
        	
	    	System.out.println(" PrepareKycFormAction execute method Called !!");
			
			InsertAdditionalCustomerDetails InsertAddCustDetails = new InsertAdditionalCustomerDetails();
	    	InsertAddCustDetails.insertAddCusDetails(customerId, getFatherName(), getMaritalStatus(), getNationality(), getStatus(), 
	    				getGrossAnnualIncome(), getPoliticallyExposed());
						
			UpdateCustomer updateCustomer = new UpdateCustomer();
			updateCustomer.updateAddCusDetUploadedStatus(customerId, "Y");
		
	    	/*GenerateKycForm generateKycForm = new GenerateKycForm();
	    	generateKycForm.generateKycForm(customerId);	*/

	    	System.out.println(" Returned Success !!");
	    	
	    	logger.debug("PrepareKycFormAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("PrepareKycFormAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	//setTranDetailId("KycNotDone");
	    	return "aofNotDone";
    	} 
    	catch ( Exception e )  {
    		logger.error("PrepareKycFormAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("PrepareKycFormAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
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

/*	public String getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(String tranDetailId) {
		this.tranDetailId = tranDetailId;
	}
*/

}
