/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;


public class UploadCustomerNavAction extends ActionSupport implements SessionAware {
	
	Logger logger = Logger.getLogger(UploadCustomerNavAction.class);
	private Map<String, Object> sessionMap;
	
    private String bseOrderId;
    private String navValue;
    private String unitsPurchased;
 
    
    private InputStream stream;

    public String execute() {
    	
    	Session session = null;
		
    	try {
    		
    		logger.debug("UploadCustomerNavAction class : execute method : end");

    		session = HibernateUtil.getSessionAnnotationFactory().openSession();
    		session.beginTransaction();
			Query query = session.createQuery("update TransactionDetails set unitPrice = :unitPrice , quantity = :quantity , transactionStatus = :transactionStatus where bseOrderId = :bseOrderId");

			query.setParameter("unitPrice", getNavValue());
			query.setParameter("quantity", getUnitsPurchased());
			query.setParameter("bseOrderId", getBseOrderId());
			query.setParameter("transactionStatus", "COMPLETE");
			int updateResult = query.executeUpdate();
			System.out.println(updateResult + " rows updated in transactionDetails table ");
			session.getTransaction().commit();
			
			
 
	    	logger.debug("UploadCustomerNavAction class : execute method : end");
	    	
	    	System.out.println(" Action complete !!");
	    	String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());
	    	return SUCCESS;
	    	
    	}
    	catch (Exception e) {	
    		System.out.println(" Cought Exception !!");
    		logger.debug("NewLoginAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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



	public String getBseOrderId() {
		return bseOrderId;
	}

	public void setBseOrderId(String bseOrderId) {
		this.bseOrderId = bseOrderId;
	}

	public String getNavValue() {
		return navValue;
	}

	public void setNavValue(String navValue) {
		this.navValue = navValue;
	}

	public String getUnitsPurchased() {
		return unitsPurchased;
	}

	public void setUnitsPurchased(String unitsPurchased) {
		this.unitsPurchased = unitsPurchased;
	}


	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	

}
