/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.InsertBankDetails;
import com.myMoneyBuddy.DAOClasses.QueryBankDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerDetails;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class KycCheckAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(KycCheckAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String customerName;
	private String gender;
	private String occupation;
	private String dateOfBirth;
    private String taxStatus;
    private String nomineeName;
    private String nomineeRelationship;
    
    private String addressLineOne;
	private String addressLineTwo;
	private String addressLineThree;
	private String residentialCity;
    private String residentialState;
    private String residentialPin;
    private String residentialCountry;
    
    private String bankName;
    private String accountType;
	private String accountNumber;
	private String reAccountNumber;
	private String ifscCode;
    
    private String respMsg;
    private String tranDetailId;
   // private String selectedBankName;
   /* private String selectedAccType;
    private String selectedAccNum;
    private String selectedIfscCode;
    private String displayAccType ;
    private String displayBankName;*/
    
   // private InputStream stream;
	
    public String execute() {
    	
    	String customerId = null;
    	try {
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - start ");
    		
	    	System.out.println(" KycCheckAction execute method Called !!");
	    	
	    	setTranDetailId("NotSet");
	    	
	    	System.out.println(" KycCheckAction execute method : First Name : "+getCustomerName());
	    	System.out.println(" KycCheckAction execute method : Gender : "+getGender());
	    	System.out.println(" KycCheckAction execute method : Occupation : "+getOccupation());
	    	System.out.println(" KycCheckAction execute method :dateOfBirth : "+getDateOfBirth());
	    	System.out.println(" KycCheckAction execute method :addressLineOne : "+getAddressLineOne());
	    	System.out.println(" KycCheckAction execute method :addressLineTwo : "+getAddressLineTwo());
	    	System.out.println(" KycCheckAction execute method :residentialCity : "+getResidentialCity());
	    	System.out.println(" KycCheckAction execute method :residentialState : "+getResidentialState());
	    	System.out.println(" KycCheckAction execute method :residentialPin : "+getResidentialPin());
	    	System.out.println(" KycCheckAction execute method :residentialCountry : "+getResidentialCountry());
	    	System.out.println(" KycCheckAction execute method :taxStatus : "+getTaxStatus());
	    	System.out.println(" KycCheckAction execute method :nomineeName : "+getNomineeName());
	    	System.out.println(" KycCheckAction execute method :nomineeRelationship : "+getNomineeRelationship());
	    	
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
		    String dob = getDateOfBirth().substring(6)+"-"+getDateOfBirth().substring(3,5)+"-"+getDateOfBirth().substring(0,2);
			Date date = dateFormat.parse(dob);
			
			String frmtdDateForDB = dateFormat.format(date);
	
			sessionMap.put("customerName", getCustomerName());
			logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - stored customerName in sessionMap");
			
			
	    	//UpdateCustomer UpdateCustomer = new UpdateCustomer();
	    	/*int updateResult =  UpdateCustomer.updateNameAndCustDetUploadedStatus(customerId, getCustomerName(), "Y");
	
	    	if (updateResult == 1) 
				sessionMap.put("CustDetUploaded", "Y");
			else 
				sessionMap.put("CustDetUploaded", "N");

			logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - stored CustDetUploaded in sessionMap");*/
	    	
			UpdateCustomerDetails updateCustomerDetails = new UpdateCustomerDetails();
			updateCustomerDetails.updateCustomerDetails(customerId, frmtdDateForDB, getAddressLineOne(), getAddressLineTwo(), getAddressLineThree(), 
					getResidentialCity(), getResidentialState(), getResidentialCountry(), getResidentialPin(), getTaxStatus(), getGender(),
					getOccupation(),getNomineeName(), getNomineeRelationship());
	    	
			UpdateCustomer updateCustomer = new UpdateCustomer();
	    	updateCustomer.updateNameAndCustDetUploadedStatus(customerId, getCustomerName(), "Y");
	    	 
	   
	    	InsertBankDetails bankDetails = new InsertBankDetails();
	    	DesEncrypter desEncrypter = new DesEncrypter();
	    	bankDetails.insertBankDetail(customerId, getBankName(), getAccountType(), desEncrypter.encrypt(getAccountNumber()), getIfscCode());
	    	
	    	//System.out.println(" Returned Success !!");
	
	    	QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	if (("DONE").equalsIgnoreCase(queryCustomer.getKycStatus(customerId)))  {
	    		System.out.println(" Returned KYC  done !!");
	    		setRespMsg("bankDetailsNotExists");
	    		
	    		/*QueryBankDetails queryBankDetails = new QueryBankDetails();
	    		
	    		boolean bankDetailsExists = queryBankDetails.existsBankDetails(customerId);
	    		
	    		if (bankDetailsExists)  {
	    			
	    			BankDetails bankDetails = queryBankDetails.fetchBankDetails(customerId);
	    			
	    			String bankName = bankDetails.getBankName();
	    			
	    			switch (bankName)  {
	    				case "ICI" :
	    					displayBankName = "ICICI Bank";
	    					break;
	    				case "SBI" :
	    					displayBankName = "SBI Bank";
	    					break;
	    				case "HDF" :
	    					displayBankName = "HDFC Bank";
	    					break;
	    				case "162" :
	    					displayBankName = "KOTAK Bank";
	    					break;
	    				case "UTI" :
	    					displayBankName = "Axis Bank";
	    					break;
	    				case "PNB" :
	    					displayBankName = "Punjab National Bank";
	    					break;
	    				case "SIB" :
	    					displayBankName = "South Indian Bank";
	    					break;
	    				case "SCB" :
	    					displayBankName = "Standard Chartered Bank";
	    					break;
	    				case "UBI" :
	    					displayBankName = "Union Bank Of India";
	    					break;
	    				case "UNI" :
	    					displayBankName = "United Bank Of India";
	    					break;
	    				case "YBK" :
	    					displayBankName = "Yes Bank Ltd";
	    					break;
	    				case "RBL" :
	    					displayBankName = "Ratnakar Bank";
	    					break;
	    				case "DCB" :
	    					displayBankName = "DCB";
	    					break;
    			
    			}
	    			
	    			String accType = bankDetails.getAccountType();
	    			
	    			switch (accType)  {
	    				case "CB" :
	    					displayAccType = "Current Account";
	    					break;
	    				case "SB" :
	    					displayAccType = "Saving Account";
	    					break;
	    				case "NE" :
	    					displayAccType = "NRI - Repatriable (NRE)";
	    					break;
	    				default :
	    					displayAccType = "NRI - Repatriable (NRO)";
	    					break;
	    			
	    			}
	    			
	    			DesEncrypter desEncrypter = new DesEncrypter();
	    			System.out.println("Acc num m: "+bankDetails.getAccountNumber());
	    			String accNum = desEncrypter.decrypt(bankDetails.getAccountNumber());
	    							
	    			setSelectedBankName(bankDetails.getBankName());
	    			setDisplayBankName(displayBankName);
	    			setSelectedAccType(bankDetails.getAccountType());
	    			setDisplayAccType(displayAccType);
	    			setSelectedAccNum(accNum);
	    			setSelectedIfscCode(bankDetails.getIfscCode());
	    			
	    			setRespMsg("bankDetailsExists");
	    			//return "bankDetailsExists";
	    			
	    		}*/
	    	    //stream = new ByteArrayInputStream(str.getBytes());
	    	    logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - returned kycDone");
		    	logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - end");
		    	
		    	
	    		return SUCCESS;
	    	}
	    	else {
				System.out.println(" Returned KYC not done !!");
				//String str = "kycNotDone";
			    //stream = new ByteArrayInputStream(str.getBytes());
			    logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - returned kycNotDone");
		    	logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - end");

				return "kycNotDone";
	    	}

    	} 
    	catch ( Exception e )  {
    		logger.error("KycCheckAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    		//String str = "error";
    	    //stream = new ByteArrayInputStream(str.getBytes());
    	    logger.error("KycCheckAction class - execute method - customerId - "+customerId+" - returned error");

    		return ERROR;
    	}
    }
    
    
   /* public boolean isUserAlreadyInDatabase(String name)  {
    	 if (name.startsWith("s"))  {
    		 System.out.println("name starts with s");
    		 return true;
    	 }
    	 
    	 return false;
    }*/
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

/*	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}
*/
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

	public String getNomineeName() {
		return nomineeName;
	}


	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}


	public String getNomineeRelationship() {
		return nomineeRelationship;
	}


	public void setNomineeRelationship(String nomineeRelationship) {
		this.nomineeRelationship = nomineeRelationship;
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

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	
	
	

/*	public String getSelectedBankName() {
		return selectedBankName;
	}

	public void setSelectedBankName(String selectedBankName) {
		this.selectedBankName = selectedBankName;
	}*/

/*	public String getSelectedAccType() {
		return selectedAccType;
	}

	public void setSelectedAccType(String selectedAccType) {
		this.selectedAccType = selectedAccType;
	}

	public String getSelectedAccNum() {
		return selectedAccNum;
	}

	public void setSelectedAccNum(String selectedAccNum) {
		this.selectedAccNum = selectedAccNum;
	}

	public String getSelectedIfscCode() {
		return selectedIfscCode;
	}

	public void setSelectedIfscCode(String selectedIfscCode) {
		this.selectedIfscCode = selectedIfscCode;
	}

	public String getDisplayAccType() {
		return displayAccType;
	}

	public void setDisplayAccType(String displayAccType) {
		this.displayAccType = displayAccType;
	}

	public String getDisplayBankName() {
		return displayBankName;
	}

	public void setDisplayBankName(String displayBankName) {
		this.displayBankName = displayBankName;
	}*/

	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getReAccountNumber() {
		return reAccountNumber;
	}


	public void setReAccountNumber(String reAccountNumber) {
		this.reAccountNumber = reAccountNumber;
	}


	public String getIfscCode() {
		return ifscCode;
	}


	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


	public String getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(String tranDetailId) {
		this.tranDetailId = tranDetailId;
	}

}
