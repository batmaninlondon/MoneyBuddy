/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.EntityClasses.CustomersAqb;
import com.myMoneyBuddy.ModelClasses.AqbDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayCustomerAqbAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(DisplayCustomerAqbAction.class);
	private SessionMap<String,Object> sessionMap;
	private String emailIdAqb;
	private String errorMsg;
	private List<AqbDataModel> aqbDataModelList = new LinkedList<AqbDataModel>();

    public String execute() {

    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	
    	try 
    	{
    		
    		logger.debug("DisplayCustomerAqbAction class - execute method - start ");
			System.out.println("Calling DisplayCustomerAqbAction class - start ");
			
			System.out.println("DisplayCustomerAqbAction emailId is : "+getEmailIdAqb());
			
			QueryCustomer queryCustomer = new QueryCustomer();
			String customerId= Integer.toString(queryCustomer.getCustomerId(getEmailIdAqb()));
			
			if ( "0".equals(customerId))  {
				setErrorMsg("EmailId does not exists!! ");
				addActionMessage("This email ID is not registered with MoneyBuddy");
				return "emailIdNotExist" ;
			}
			sessionMap.put("customerIdFromAdmin", customerId);
			
			
			
			hibernateSession.beginTransaction();	   
			   			
			Query query = hibernateSession.createQuery("from CustomersAqb where customerId =:customerId  order by quarterOfYear asc");
			query.setParameter("customerId", customerId);
			
			List<CustomersAqb> customersAqbList = query.list();
			hibernateSession.getTransaction().commit();
			
			String quarter = "";
			String year = "";
			for ( CustomersAqb customersAqbElement :  customersAqbList)  {
				
				quarter = customersAqbElement.getQuarterOfYear().substring(0, 1);
				year = customersAqbElement.getQuarterOfYear().substring(2);
				aqbDataModelList.add(new AqbDataModel(customerId,quarter,year,customersAqbElement.getAqb(),customersAqbElement.getQuaterlyFess()));
				
			}

			System.out.println("Returning success !! ");
			logger.debug("DisplayCustomerAqbAction class - execute method - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("DisplayCustomerAqbAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("DisplayCustomerAqbAction class - execute method - returned error");
			return ERROR;
		} 

    }


	public String getEmailIdAqb() {
		return emailIdAqb;
	}


	public void setEmailIdAqb(String emailIdAqb) {
		this.emailIdAqb = emailIdAqb;
	}


	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public List<AqbDataModel> getAqbDataModelList() {
		return aqbDataModelList;
	}


	public void setAqbDataModelList(List<AqbDataModel> aqbDataModelList) {
		this.aqbDataModelList = aqbDataModelList;
	}
    
 
}
