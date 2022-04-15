/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.InsertBankDetails;
import com.myMoneyBuddy.DAOClasses.InsertCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerDetails;
import com.myMoneyBuddy.DAOClasses.UpdateNriCustomerDetails;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.ndml.kra.pan.webservice.service.PANServiceImpl;
import com.ndml.kra.pan.webservice.service.PANServiceImplService;
import com.opensymphony.xwork2.ActionSupport;

public class KycCheckAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(KycCheckAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String panCard;
	private String customerName;
	private String mobileNumber;
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
    
    private String addressLineOneNri;
	private String addressLineTwoNri;
	private String addressLineThreeNri;
	private String residentialCityNri;
    private String residentialStateNri;
    private String residentialPinNri;
    private String residentialCountryNri;
	private String mobileNumberNri;
    
    private String placeOfBirth;
	private String countryOfBirth;
	private String taxResidency;
	private String incomeSlab;
    private String politicallyExposed;
    private String taxIdentificationNumber;
    
    private String bankName;
    private String accountType;
	private String accountNumber;
	private String reAccountNumber;
	private String ifscCode;
    
    //private String tranDetailId;
    
   // private InputStream stream;
	
    public String execute() {
    	
    	String customerId = null;
    	try {
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - start ");
    		
	    	System.out.println(" KycCheckAction execute method Called !!");
	    	
	    	//setTranDetailId("NotSet");
	    	
	    	System.out.println(" KycCheckAction execute method : Pan acrd : "+getPanCard());
	    	
	    	// KYC API CALL - START
	    	
	    	Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(PanCardVerificationAction.class.getResourceAsStream(configPropFilePath));
			
			String password = configProperties.getProperty("KYC_PASSWORD");
			String userId = configProperties.getProperty("KYC_USER_ID");
			String miId = configProperties.getProperty("KYC_MI_ID");
			String mobileNo = configProperties.getProperty("KYC_MOBILE_NO");
			String encryptionKey = configProperties.getProperty("KYC_ENCRYPTION_KEY");
			
			System.setProperty("com.sun.security.enableAIAcaIssuers", "true");
			
			PANServiceImplService wbPanService = new PANServiceImplService();
	    	PANServiceImpl panServiceImpl = wbPanService.getPANServiceImplPort();
	    	BindingProvider bindingProvider = (BindingProvider) panServiceImpl;
	    	bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://kra.ndml.in/sms-ws/PANServiceImplService");
	    	
	    	String encryptedPassword = panServiceImpl.getPasscode(password,encryptionKey);

			System.out.println("encryptedPassword : "  +encryptedPassword);

			String requestNum = "1234512346";
			
			String requestXml = "<APP_REQ_ROOT>"
									+ "<APP_PAN_INQ>"
										+ "<APP_PAN_NO>"+getPanCard()+"</APP_PAN_NO>"
										+ "<APP_MOBILE_NO>"+mobileNo+"</APP_MOBILE_NO>"
										+ "<APP_REQ_NO>"+requestNum+"</APP_REQ_NO>"
									+ "</APP_PAN_INQ>"
								+ "</APP_REQ_ROOT>";		
			
			//String res = panServiceImpl.panInquiryDetails(requestXml, userId, encryptedPassword, miId);
			String res = panServiceImpl.panInquiryDetails(requestXml, userId, encryptedPassword, encryptionKey);
			
			System.out.println("RES is "+res);
			
			// This will be set, depending upon the response coming from KYC API
			String kycStatus= "DONE";
			
			// KYC API CALL - END
			
			InsertCustomerDetails insertCustomerDetails = new InsertCustomerDetails();
			insertCustomerDetails.updateMobileNum(getMobileNumber(), customerId);
			
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
		    String dob = getDateOfBirth().substring(6)+"-"+getDateOfBirth().substring(3,5)+"-"+getDateOfBirth().substring(0,2);
			Date date = dateFormat.parse(dob);
			
			String frmtdDateForDB = dateFormat.format(date);
	
			sessionMap.put("customerName", getCustomerName());
			logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - stored customerName in sessionMap");
			    	
			UpdateCustomerDetails updateCustomerDetails = new UpdateCustomerDetails();
			updateCustomerDetails.updateCustomerDetails(customerId, frmtdDateForDB, getAddressLineOne(), getAddressLineTwo(), getAddressLineThree(), 
					getResidentialCity(), getResidentialState(), getResidentialCountry(), getResidentialPin(), getTaxStatus(), getGender(), getOccupation(),
					getNomineeName(), getNomineeRelationship(),getPlaceOfBirth(),getCountryOfBirth(),getTaxResidency(),getIncomeSlab(),getPoliticallyExposed());
	    	
			if ( !"Individual".equalsIgnoreCase(getTaxStatus()))   {
			UpdateNriCustomerDetails updateNriCustomerDetails = new UpdateNriCustomerDetails();
			updateNriCustomerDetails.updateNriCustomerDetails(customerId, getMobileNumberNri(), getAddressLineOneNri(), getAddressLineTwoNri(),
					getAddressLineThreeNri(),getResidentialCityNri(), getResidentialStateNri(), getResidentialCountryNri(), getResidentialPinNri(),
					getTaxIdentificationNumber());
			}
	    	
			
			UpdateCustomer updateCustomer = new UpdateCustomer();	
			updateCustomer.updateCustomerData(customerId, getPanCard(), kycStatus,getCustomerName(), "Y");
	    	 
	   
	    	InsertBankDetails bankDetails = new InsertBankDetails();
	    	DesEncrypter desEncrypter = new DesEncrypter();
	    	bankDetails.insertBankDetail(customerId, getBankName(), getAccountType(), desEncrypter.encrypt(getAccountNumber()), getIfscCode());
		    	
	    	if (("DONE").equalsIgnoreCase(kycStatus))  {
	    		
	    	    logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - returned kycDone");
		    	logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - end");
		    	
		    	String CLIENT_HOLDING = "SI"; // Considering Single account
		    	
		    	Trading trading = new Trading();
	    		
	    		QueryCustomer queryCustomer = new QueryCustomer();
	    		String cusEmailId = queryCustomer.getCustomerEmailId(customerId);
	    		String ucc = "";
	    		if ( "Individual".equalsIgnoreCase(getTaxStatus()))   {
					ucc = trading.createClient(CLIENT_HOLDING, getTaxStatus(), getOccupation(), getDateOfBirth(),
			    			getGender(), "", getAccountType(), getAccountNumber(), getIfscCode(),
			    			getAddressLineOne(),getAddressLineTwo(),getAddressLineThree(), getResidentialCity(), 
			    			getResidentialState(), getResidentialPin(), getResidentialCountry(),
			    			customerId, getCustomerName(), cusEmailId, getPanCard(), getNomineeName(),getNomineeRelationship(), getMobileNumber(),
			    			"","","","","","","","");
	    		}
	    		else {
    				ucc = trading.createClient(CLIENT_HOLDING, getTaxStatus(), getOccupation(), getDateOfBirth(),
			    			getGender(), "", getAccountType(), getAccountNumber(), getIfscCode(),
			    			getAddressLineOne(),getAddressLineTwo(),getAddressLineThree(), getResidentialCity(), 
			    			getResidentialState(), getResidentialPin(), getResidentialCountry(),
							customerId, getCustomerName(), cusEmailId, getPanCard(), getNomineeName(),getNomineeRelationship(), getMobileNumber(),
							getAddressLineOneNri(),getAddressLineTwoNri(),getAddressLineThreeNri(),getResidentialCityNri(),getResidentialStateNri(),
							getResidentialPinNri(),getResidentialCountryNri(),getMobileNumberNri());
	    		}
		    	String[] uccSpilts = ucc.split("\\|");
		    	
		    	System.out.println("uccSpilts[0] : "+uccSpilts[0]);
		    	
		    	if(uccSpilts[0].equals("100") ) {
		    		
		    		if(uccSpilts[1].contains("SUCCESSFULLY") ) {
			    		updateCustomer.updateBseClientCreationStatus(customerId, "Y");
		    		}
		    		else {
		    			return ERROR;
		    		}
		    		
		    	}
		    	else {
	    			return ERROR;
	    		}
		    	
		    	boolean fatcaCreated = trading.fatcaUpload(customerId);
		    	
		    	if ( !fatcaCreated)
		    		return ERROR;
	    	
		    	
		    	// Generate Mandate Id block - START
		    	
		    	if ( queryCustomer.getIsipMandateId(customerId)  == null )  {
		    	String mandateIdResponse = trading.generateMandateId(customerId, "I", getAccountNumber(), getAccountType(), getIfscCode());
				
				String[] mandateIdResponseSpilts = mandateIdResponse.split("\\|"); 
		    	
		    	System.out.println("mandateIdResponseSpilts[0] : "+mandateIdResponseSpilts[0]);
		    	System.out.println("mandateIdResponseSpilts[1] : "+mandateIdResponseSpilts[1]);
		    	System.out.println("mandateIdResponseSpilts[2] : "+mandateIdResponseSpilts[2]);
		    	
		    	if(mandateIdResponseSpilts[0].equals("100") ) {
			    	String mandateId = mandateIdResponseSpilts[2];
			    	
			    	insertCustomerDetails.updateMandateId(mandateId, customerId);
		    	}
		    	else 
		    		return ERROR;
		    	
		    	}
		    	// Generate Mandate Id block - END
		    	
	    	
	    		return "aofNotDone";
	    	}
	    	else {
	    		
			    logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - returned kycNotDone");
		    	logger.debug("KycCheckAction class - execute method - customerId - "+customerId+" - end");

				return "kycNotDone";
	    	}

    	} 
    	catch ( Exception e )  {
    		logger.error("KycCheckAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("KycCheckAction class - execute method - customerId - "+customerId+" - returned error");

    		return ERROR;
    	}
    }

    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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


	public String getPlaceOfBirth() {
		return placeOfBirth;
	}


	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}


	public String getCountryOfBirth() {
		return countryOfBirth;
	}


	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}


	public String getTaxResidency() {
		return taxResidency;
	}


	public void setTaxResidency(String taxResidency) {
		this.taxResidency = taxResidency;
	}


	public String getIncomeSlab() {
		return incomeSlab;
	}


	public void setIncomeSlab(String incomeSlab) {
		this.incomeSlab = incomeSlab;
	}


	public String getPoliticallyExposed() {
		return politicallyExposed;
	}


	public void setPoliticallyExposed(String politicallyExposed) {
		this.politicallyExposed = politicallyExposed;
	}


	public String getAddressLineOneNri() {
		return addressLineOneNri;
	}


	public void setAddressLineOneNri(String addressLineOneNri) {
		this.addressLineOneNri = addressLineOneNri;
	}


	public String getAddressLineTwoNri() {
		return addressLineTwoNri;
	}


	public void setAddressLineTwoNri(String addressLineTwoNri) {
		this.addressLineTwoNri = addressLineTwoNri;
	}


	public String getAddressLineThreeNri() {
		return addressLineThreeNri;
	}


	public void setAddressLineThreeNri(String addressLineThreeNri) {
		this.addressLineThreeNri = addressLineThreeNri;
	}


	public String getResidentialCityNri() {
		return residentialCityNri;
	}


	public void setResidentialCityNri(String residentialCityNri) {
		this.residentialCityNri = residentialCityNri;
	}


	public String getResidentialStateNri() {
		return residentialStateNri;
	}


	public void setResidentialStateNri(String residentialStateNri) {
		this.residentialStateNri = residentialStateNri;
	}


	public String getResidentialPinNri() {
		return residentialPinNri;
	}


	public void setResidentialPinNri(String residentialPinNri) {
		this.residentialPinNri = residentialPinNri;
	}


	public String getResidentialCountryNri() {
		return residentialCountryNri;
	}


	public void setResidentialCountryNri(String residentialCountryNri) {
		this.residentialCountryNri = residentialCountryNri;
	}


	public String getMobileNumberNri() {
		return mobileNumberNri;
	}


	public void setMobileNumberNri(String mobileNumberNri) {
		this.mobileNumberNri = mobileNumberNri;
	}


	public String getTaxIdentificationNumber() {
		return taxIdentificationNumber;
	}


	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		this.taxIdentificationNumber = taxIdentificationNumber;
	}


/*	public String getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(String tranDetailId) {
		this.tranDetailId = tranDetailId;
	}*/

}
