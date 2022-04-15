/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ExistingOldFundDataAction extends ActionSupport   {

	Logger logger = LogManager.getLogger(ExistingOldFundDataAction.class);
	List<String> availableSchemeNames = new ArrayList<String>();
	private String emailIdOldPortfolio;
	private String customerIdOldPortfolio;

    public String execute() {

    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	
    	try 
    	{
    		
    		logger.debug("existingOldFundData class - execute method - start ");
			System.out.println("Calling existingOldFundData class - start ");
			
			QueryCustomer queryCustomer = new QueryCustomer();
			
			if (!queryCustomer.existsCustomer(emailIdOldPortfolio)) {
				addActionMessage(" email Id does not exists! ");
				return "emailIdNotExist" ;
			}
			
			setCustomerIdOldPortfolio(Integer.toString(queryCustomer.getCustomerId(emailIdOldPortfolio)));
		
			hibernateSession.beginTransaction();	   
			   			
			Query schemeCodesData = hibernateSession.createQuery("select distinct(schemeName) from OldPortfolioRecords ");
			
			hibernateSession.getTransaction().commit();
			
			availableSchemeNames = schemeCodesData.list();
			availableSchemeNames.add("Others");
			
			System.out.println("Returning success !! ");
			logger.debug("existingOldFundData class - execute method - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("existingOldFundData class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("existingOldFundData class - execute method - returned error");
			return ERROR;
		} 
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
    
    public String getDefaultSchemeName() {
		return "Others";
		
	}
    

	public List<String> getAvailableSchemeNames() {
		return availableSchemeNames;
	}

	public void setAvailableSchemeNames(List<String> availableSchemeNames) {
		this.availableSchemeNames = availableSchemeNames;
	}

	public String getEmailIdOldPortfolio() {
		return emailIdOldPortfolio;
	}

	public void setEmailIdOldPortfolio(String emailIdOldPortfolio) {
		this.emailIdOldPortfolio = emailIdOldPortfolio;
	}

	public String getCustomerIdOldPortfolio() {
		return customerIdOldPortfolio;
	}

	public void setCustomerIdOldPortfolio(String customerIdOldPortfolio) {
		this.customerIdOldPortfolio = customerIdOldPortfolio;
	}



 
}
