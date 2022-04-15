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

import com.myMoneyBuddy.EntityClasses.CustomersAqb;
import com.myMoneyBuddy.ModelClasses.AqbDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayAllAqbAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(DisplayAllAqbAction.class);
	private SessionMap<String,Object> sessionMap;
	private String errorMsg;
	private List<AqbDataModel> aqbDataModelList = new LinkedList<AqbDataModel>();

    public String execute() {

    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	
    	try 
    	{
    		
    		logger.debug("DisplayAllAqbAction class - execute method - start ");
			System.out.println("Calling DisplayAllAqbAction class - start ");
		
			hibernateSession.beginTransaction();	   
			   			
			Query query = hibernateSession.createQuery("from CustomersAqb   order by quarterOfYear asc");
			
			List<CustomersAqb> customersAqbList = query.list();
			hibernateSession.getTransaction().commit();
			
			String quarter = "";
			String year = "";
			for ( CustomersAqb customersAqbElement :  customersAqbList)  {
				quarter = customersAqbElement.getQuarterOfYear().substring(0, 1);
				year = customersAqbElement.getQuarterOfYear().substring(2);
				aqbDataModelList.add(new AqbDataModel(customersAqbElement.getCustomerId(),quarter,year,customersAqbElement.getAqb(),customersAqbElement.getQuaterlyFess()));
				
			}
			
			System.out.println("Returning success !! ");
			logger.debug("DisplayAllAqbAction class - execute method - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("DisplayAllAqbAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("DisplayAllAqbAction class - execute method - returned error");
			return ERROR;
		} 

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
