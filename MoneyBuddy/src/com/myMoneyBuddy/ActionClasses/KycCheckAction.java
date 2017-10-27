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
	
	private String firstName;
	private String lastName;
	private String gender;
    private String panCard;
	private String occupation;
	private String grossAnnualIncome;
    private String politicallyExposed; 
   
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
    	
    	System.out.println(" KycCheckAction execute method : First Name : "+getFirstName());
    	System.out.println(" KycCheckAction execute method : Last Name : "+getLastName());
    	System.out.println(" KycCheckAction execute method : Gender : "+getGender());
    	System.out.println(" KycCheckAction execute method : PanCard : "+getPanCard());
    	System.out.println(" KycCheckAction execute method : Occupation : "+getOccupation());
    	System.out.println(" KycCheckAction execute method : Gross Annual Income : "+getGrossAnnualIncome());
    	System.out.println(" KycCheckAction execute method : Politically Exposed : "+getPoliticallyExposed());
    	
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
		Query query = session.createQuery("update Customers set firstName = :firstName , lastName = :lastName , gender = :gender ,panCard = :panCard ,occupation = :occupation ,grossAnnualIncome = :grossAnnualIncome ,politicallyExposed = :politicallyExposed  where customerId = :customerId");
		
		query.setParameter("firstName", getFirstName());
		query.setParameter("lastName", getLastName());
		query.setParameter("gender", getGender()); 
		query.setParameter("panCard", getPanCard());
		query.setParameter("occupation", getOccupation());
		query.setParameter("grossAnnualIncome", getGrossAnnualIncome()); 
		query.setParameter("politicallyExposed", getPoliticallyExposed());
		query.setParameter("customerId", sessionMap.get("customerId").toString());
		
		int updateResult = query.executeUpdate();
		System.out.println(updateResult + " rows updated in Customers table ");
		session.getTransaction().commit();
		
		String customerName = getFirstName()+" "+getLastName();
		sessionMap.put("customerName", customerName);
    	logger.debug("KycCheckAction class : execute method : updated customerName : "+customerName+" in session id : "+sessionMap.getClass().getName());
		
		session.beginTransaction();
		query = session.createQuery("update Customers set kycStatus = :kycStatus where customerId = :customerId");
		
		// Savita Wadhwani - We need to update this piece of code with real API - start 
		
		String num1 = getPanCard().substring(5,9);
		String str;
		if ( (Integer.parseInt(num1) /2) == 0) {
			query.setParameter("kycStatus", "DONE");
			str = "kycDone";
		}
		else {
			query.setParameter("kycStatus", "NOT DONE");
			str = "kycNotDone";
		}
		// Savita Wadhwani - We need to update this piece of code with real API - end
		

		query.setParameter("customerId", sessionMap.get("customerId").toString());
		
		updateResult = query.executeUpdate();
		System.out.println(updateResult + " rows updated in Customers table ");
		session.getTransaction().commit();
		
		
    	
    	sessionMap.put("panCard", panCard);
    	System.out.println("Kyc is done for panCard : "+panCard);
    	
    	logger.debug("KycCheckAction class : execute method : stored panCard : "+panCard+" in session id : "+sessionMap.getClass().getName());
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
