/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.ModelClasses.DbfStatusDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class PopulateAdminDashboardDataAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(PopulateAdminDashboardDataAction.class);
	private SessionMap<String,Object> sessionMap;

	private InputStream stream;
	
    public String execute() {

    	logger.debug("PopulateAdminDashboardDataAction class : execute method : start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	
    	List<DbfStatusDataModel> dbfStatusDataModel = new LinkedList<DbfStatusDataModel>();
    	
    	HashMap<String,String> dbfDataList = new HashMap<String,String>();
    	
    	try {

    		hibernateSession.beginTransaction();
							
				Query query =  hibernateSession.createQuery(" from DbfFileStatusDetails where uploadedStatus = :uploadedStatus ");
				query.setParameter("uploadedStatus", "N");
				List<DbfFileStatusDetails> dbfFileStatusDetailsList = query.list();
				hibernateSession.getTransaction().commit();
				
				for (DbfFileStatusDetails dbfFileStatusDetails : dbfFileStatusDetailsList)  {
					System.out.println(" date in list is : "+dbfFileStatusDetails.getDbfDataDate()+" rta : "+dbfFileStatusDetails.getRta()+ " file type : "+dbfFileStatusDetails.getDbfFileType());
					dbfStatusDataModel.add(new DbfStatusDataModel(dbfFileStatusDetails.getDbfDataDate(),dbfFileStatusDetails.getRta(),dbfFileStatusDetails.getDbfFileType()));
					dbfDataList.put(dbfFileStatusDetails.getDbfDataDate(), dbfFileStatusDetails.getRta()+"-"+dbfFileStatusDetails.getDbfFileType());
				}
				System.out.println(" dbfDataList size : "+dbfDataList.size()); 
				
				sessionMap.put("dbfStatusDataModel", dbfStatusDataModel);
				logger.debug("PopulateAdminDashboardDataAction class : execute method : stored dbfStatusDataModel in session id : "+sessionMap.getClass().getName());
				
				sessionMap.put("dbfDataList", dbfDataList);
				logger.debug("PopulateAdminDashboardDataAction class : execute method : stored dbfDataList in session id : "+sessionMap.getClass().getName());
				//session.getTransaction().commit();
				
			logger.debug("PopulateAdminDashboardDataAction class : execute method : end");
			
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("PopulateAdminDashboardDataAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
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
    
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}


}
