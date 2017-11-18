/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfDataDetails;
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
public class KycStatusCheckAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(KycStatusCheckAction.class);
	private Map<String, Object> sessionMap;
	
    QueryKycStatus kyc = new QueryKycStatus();

    private InputStream stream;

    public String execute() {
    	
    	Session session = null;
    	
    	try {
    		
    	logger.debug("KycStatusCheckAction class : execute method : start");
    	System.out.println(" KycStatusCheckAction execute method Called !!");


    	session = HibernateUtil.getSessionAnnotationFactory().openSession();
	    	
		session.beginTransaction();
		
		
		Object result = session.createQuery("select kycStatus from Customers where customerId = '"+sessionMap.get("customerId").toString()+"'").uniqueResult();
		String kycStatus = null;

		if (result != null)  
			kycStatus = result.toString();

		//session.getTransaction().commit();
		
    	if ("NOT DONE".equalsIgnoreCase(kycStatus))  {
    		System.out.println("KYC is not done for this customer ");
    		logger.debug("KycStatusCheckAction class : execute method : kyc is not done for "+sessionMap.get("customerId").toString());
    		String str = "kycNotDone";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return SUCCESS;
    	}
    	
    	logger.debug("KycStatusCheckAction class : execute method : end");
    	
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
    		logger.error("KycStatusCheckAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
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





}
