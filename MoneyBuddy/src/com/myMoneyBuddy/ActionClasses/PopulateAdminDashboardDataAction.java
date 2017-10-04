/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfDataDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.opensymphony.xwork2.ActionSupport;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class PopulateAdminDashboardDataAction extends ActionSupport implements SessionAware  {

	
	
	Logger logger = Logger.getLogger(PopulateAdminDashboardDataAction.class);
	private Map<String, Object> sessionMap;

	private InputStream stream;
	
    public String execute() {

    	logger.debug("PopulateAdminDashboardDataAction class : execute method : start");
    	
    	try {
    		
/*    		Properties properties = new Properties();
			String propFilePath = "../../../config/config.properties";

			properties.load(Trading.class.getResourceAsStream(propFilePath));*/

 
			SessionFactory factory = new AnnotationConfiguration()
					.configure()
					.addAnnotatedClass(DbfDataDetails.class)
					.buildSessionFactory();
		    Session session = factory.openSession();

				session.beginTransaction();
				
				
				Query query =  session.createQuery("select dbfDataDate from DbfDataDetails where uploadedStatus='NO' group by dbfDataDate");
				List<String> dbfDataDateList = query.list();
				
				for (String date : dbfDataDateList)  {
					System.out.println(" date in list is : "+date);
				}
				
				sessionMap.put("dbfDataDateList", dbfDataDateList);
				logger.debug("PopulateAdminDashboardDataAction class : execute method : stored dbfDataDateList in session id : "+sessionMap.getClass().getName());
				session.getTransaction().commit();
				
			logger.debug("PopulateAdminDashboardDataAction class : execute method : end");
			
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.debug("PopulateAdminDashboardDataAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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


	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}




}
