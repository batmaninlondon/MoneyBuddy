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
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
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
	
	private String customerName;
	private String gender;
    private String panCard;
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
    	
    	Session session = null;
    	
    	try {
    		
    	logger.debug("KycCheckAction class : execute method : start");
    	System.out.println(" KycCheckAction execute method Called !!");
    	
    	System.out.println(" KycCheckAction execute method : First Name : "+getCustomerName());
    	System.out.println(" KycCheckAction execute method : Gender : "+getGender());
    	System.out.println(" KycCheckAction execute method : PanCard : "+getPanCard());
    	System.out.println(" KycCheckAction execute method : Occupation : "+getOccupation());
    	System.out.println(" PrepareKycFormAction execute method :dateOfBirth : "+getDateOfBirth());
    	System.out.println(" PrepareKycFormAction execute method :addressLineOne : "+getAddressLineOne());
    	System.out.println(" PrepareKycFormAction execute method :addressLineTwo : "+getAddressLineTwo());
    	System.out.println(" PrepareKycFormAction execute method :residentialCity : "+getResidentialCity());
    	System.out.println(" PrepareKycFormAction execute method :residentialState : "+getResidentialState());
    	System.out.println(" PrepareKycFormAction execute method :residentialPin : "+getResidentialPin());
    	System.out.println(" PrepareKycFormAction execute method :residentialCountry : "+getResidentialCountry());
    	System.out.println(" PrepareKycFormAction execute method :taxStatus : "+getTaxStatus());
    	
    	// Savita Wadhwani - Start - Added this block to validate input panCard through ajax call
    	
    	/*if (!kyc.existsPanCard(getPanCard())) {
    		System.out.println(" Returned invalid !!");
    		
    		String str = "invalid";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return "invalid";
    		return SUCCESS;
    	}
    	
    	// Savita Wadhwani - End - Added this block to validate input panCard through ajax call
    	
    	if (kyc.getKycStatusForPanCard(getPanCard()).equalsIgnoreCase("N"))  {
    		logger.debug("KycCheckAction class : execute method : KYC is not done for "+getPanCard());
    		System.out.println(" Returned KYC not done !!");
    		String str = "kycNotDone";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return SUCCESS;
    	}*/

    	
    	/*DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Date frmtDateOfBirth = format.parse(getDateOfBirth());*/ 
    	
    	session = HibernateUtil.getSessionAnnotationFactory().openSession(); 
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	    String dob = getDateOfBirth().substring(6,10)+"-"+getDateOfBirth().substring(3,5)+"-"+getDateOfBirth().substring(0,2);
		Date date = dateFormat.parse(dob);
		
		String frmtdDateForDB = dateFormat.format(date);
	    
    	/*Customers customer = new Customers();
    	customer.setCustomerId(sessionMap.get("customerId").toString());
    	customer.setCustomerName(getCustomerName());
    	customer.setDateOfBirth(frmtdDateForDB);
    	customer.setAddressLineOne(getAddressLineOne());
    	customer.setAddressLineTwo(getAddressLineTwo());
    	customer.setAddressLineThree(getAddressLineThree());
    	customer.setResidentialCity(getResidentialCity());
    	customer.setResidentialState(getResidentialState());
    	customer.setResidentialCountry(getResidentialCountry());
    	customer.setResidentialPin(getResidentialPin());
    	customer.setTaxStatus(getTaxStatus());
    	customer.setGender(getGender());
    	customer.setOccupation(getOccupation());
    	customer.setPanCard(getPanCard());
    	
    	session.beginTransaction();
    	
    	session.update(customer);
    	
    	session.getTransaction().commit();*/
    	
		/*Query query = session.createQuery("update Customers set firstName = :firstName , lastName = :lastName , gender = :gender ,panCard = :panCard ,occupation = :occupation ,grossAnnualIncome = :grossAnnualIncome ,politicallyExposed = :politicallyExposed  where customerId = :customerId");
		
		query.setParameter("firstName", getFirstName());
		query.setParameter("lastName", getLastName());
		query.setParameter("gender", getGender()); 
		query.setParameter("panCard", getPanCard());
		query.setParameter("occupation", getOccupation());
		query.setParameter("grossAnnualIncome", getGrossAnnualIncome()); 
		query.setParameter("politicallyExposed", getPoliticallyExposed());
		query.setParameter("customerId", sessionMap.get("customerId").toString());*/
		
		/*int updateResult = query.executeUpdate();
		System.out.println(updateResult + " rows updated in Customers table ");*/

		sessionMap.put("customerName", getCustomerName());
    	logger.debug("KycCheckAction class : execute method : updated customerName : "+customerName+" in session id : "+sessionMap.getClass().getName());
		
		
		// Savita Wadhwani - We need to update this piece of code with real API - start 
		
		String num1 = getPanCard().substring(5,9);
		String str;
		System.out.println(" num1 is : "+num1);
		System.out.println(" (Integer.parseInt(num1) % 2) is : "+(Integer.parseInt(num1) % 2));
		String kycStatus = null;
		if ( (Integer.parseInt(num1) % 2) != 0) {
			
			kycStatus= "DONE";
			//str = "kycDone";
			sessionMap.put("kycStatus", "DONE");
			str = "kycDone";
		}
		else {
			kycStatus = "NOT DONE";
			//str = "kycNotDone";
			sessionMap.put("kycStatus", "NOT_DONE");
			str = "kycNotDone";
		}
		// Savita Wadhwani - We need to update this piece of code with real API - end
		
		session.beginTransaction();
		Query query = session.createQuery("update Customers set kycStatus = :kycStatus , customerName = :customerName , dateOfBirth = :dateOfBirth ,"
				+ " addressLineOne = :addressLineOne , addressLineTwo = :addressLineTwo , addressLineThree = :addressLineThree , "
				+ "residentialCity = :residentialCity , residentialState = :residentialState , residentialCountry = :residentialCountry , "
				+ "residentialPin = :residentialPin , taxStatus = :taxStatus , gender = :gender , occupation = :occupation , "
				+ "panCard = :panCard where customerId = :customerId");
		
		query.setParameter("customerName", getCustomerName());
		query.setParameter("dateOfBirth", frmtdDateForDB);
		query.setParameter("addressLineOne", getAddressLineOne());
		query.setParameter("addressLineTwo", getAddressLineTwo());
		query.setParameter("addressLineThree", getAddressLineThree());
		query.setParameter("residentialCity", getResidentialCity());
		query.setParameter("residentialState", getResidentialState());
		query.setParameter("residentialCountry", getResidentialCountry());
		query.setParameter("residentialPin", getResidentialPin());
		query.setParameter("taxStatus", getTaxStatus());
		query.setParameter("gender", getGender());
		query.setParameter("occupation", getOccupation());
		query.setParameter("panCard", getPanCard());
		query.setParameter("kycStatus", kycStatus);

		

		query.setParameter("customerId", sessionMap.get("customerId").toString());
		
		int updateResult = query.executeUpdate();
		System.out.println(updateResult + " rows updated in Customers table ");
		
    	sessionMap.put("panCard", panCard);
    	System.out.println("Kyc is done for panCard : "+panCard);
    	
    	logger.debug("KycCheckAction class : execute method : stored panCard : "+panCard+" in session id : "+sessionMap.getClass().getName());
    	
    	session.getTransaction().commit();
    	logger.debug("KycCheckAction class : execute method : end");
    	
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
