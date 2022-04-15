/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadStatusChangeAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(FileUploadStatusChangeAction.class);
	private SessionMap<String,Object> sessionMap;
	private String date;
	private String rta;
	private String fileType;
	private InputStream stream;
	
    public String execute() {
	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	try {

    		logger.debug("FileUploadStatusChangeAction class - execute method - start");
    		System.out.println("FileUploadStatusChangeAction class - execute method - date : "+getDate());
    		

    		hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update DbfFileStatusDetails set uploadedStatus = :uploadedStatus where dbfDataDate = :dbfDataDate and rta = :rta and dbfFileType = :dbfFileType");
			query.setParameter("uploadedStatus", "Y");
			query.setParameter("dbfDataDate", getDate());
			query.setParameter("rta", getRta());
			query.setParameter("dbfFileType", getFileType());
			
			int updateResult = query.executeUpdate();
			System.out.println(updateResult + " rows updated in DbfFileStatusDetails table ");
			hibernateSession.getTransaction().commit();

			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    
    	    logger.debug("FileUploadStatusChangeAction class - execute method - returned success");
	    	logger.debug("FileUploadStatusChangeAction class - execute method - end");
	    	
			return SUCCESS;
		} 
    	catch (Exception e) {	
    		logger.error("FileUploadStatusChangeAction class - execute method - Caught Exception");
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.error("FileUploadStatusChangeAction class - execute method - returned error");
    	    
			return ERROR;
		} 
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
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
