/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.myMoneyBuddy.Utils.HibernateUtil;
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

public class FileUploadStatusChangeAction extends ActionSupport implements SessionAware  {

	
	
	Logger logger = Logger.getLogger(FileUploadStatusChangeAction.class);
	private Map<String, Object> sessionMap;
	
	private String date;
	private String rta;
	private String fileType;
	private InputStream stream;
	
    public String execute() {
	
    	System.out.println("FileUploadStatusChangeAction class : execute method : date : "+date);
    	logger.debug("FileUploadStatusChangeAction class : execute method : start");
    	Session hibernateSession = null;
    	try {

    		hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

    		hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update DbfFileStatusDetails set uploadedStatus = :uploadedStatus where dbfDataDate = :dbfDataDate and rta = :rta and dbfFileType = :dbfFileType");
			query.setParameter("uploadedStatus", "Y");
			query.setParameter("dbfDataDate", getDate());
			query.setParameter("rta", getRta());
			query.setParameter("dbfFileType", getFileType());
			
			int updateResult = query.executeUpdate();
			System.out.println(updateResult + " rows updated in DbfFileStatusDetails table ");
			hibernateSession.getTransaction().commit();

			logger.debug("FileUploadStatusChangeAction class : execute method : end");
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.debug("FileUploadStatusChangeAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	finally {
    		hibernateSession.close();
    	}

    }
    

	public static boolean copyFileUsingFileUtils(String srcFilePath, String destFilePath){
		boolean isFileCopied = false;
		
		try {
			FileUtils.copyFile(new File(srcFilePath), new File(destFilePath),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isFileCopied;
	}
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    

    public Map<String, Object> getSession() {
		return sessionMap;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}


	public String getRta() {
		return rta;
	}


	public void setRta(String rta) {
		this.rta = rta;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}




}
