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
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.Subscriber;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.mailerClasses.SendMail;
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
public class OngoingSipListAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(OngoingSipListAction.class);
	private Map<String, Object> sessionMap;

    private InputStream stream;

    public String execute() {
    	
    	Session hibernateSession = null;
    	List<SipDetails>  sipDetailsList ;
    	
    	try {
    		
    	logger.debug("OngoingSipListAction class : execute method : start");
    	System.out.println(" OngoingSipListAction execute method Called !!");
    	
    	hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession(); 
	    
    	/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String frmtdDate = dateFormat.format(date);*/
		
    	hibernateSession.beginTransaction();
		Query query = hibernateSession.createQuery(" from SipDetails where customerId = :customerId and sipCompletionStatus = 'N' ");
		query.setParameter("customerId", sessionMap.get("customerId").toString());
		
		sipDetailsList = query.list();
		
		sessionMap.put("sipDetailsList", sipDetailsList);
		
    	logger.debug("OngoingSipListAction class : execute method : end");
    	
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
    		logger.error("OngoingSipListAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}
    	finally {
    		/*if(factory!=null)
			factory.close();*/
    		//HibernateUtil.getSessionAnnotationFactory().close();
    		hibernateSession.close();
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    public Map<String, Object> getSession() {
		return sessionMap;
	}

}
