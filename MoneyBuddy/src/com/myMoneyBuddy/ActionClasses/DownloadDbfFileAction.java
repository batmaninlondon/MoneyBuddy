/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.Utils.CommonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadDbfFileAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(DownloadDbfFileAction.class);
	private SessionMap<String,Object> sessionMap;
	private String date;
	private InputStream stream;
	
    public String execute() {
    	logger.debug("DownloadDbfFileAction class : execute method : start");
    	
    	try {
    		System.out.println("DownloadDbfFileAction class : execute method : date : "+date);
    		    		
    		Properties properties = new Properties();
			String propFilePath = "../../../config/config.properties";

			properties.load(Trading.class.getResourceAsStream(propFilePath));
    		
      		 String srcDirName = properties.getProperty("SRC_DIR_NAME");
       		 String fileName = getDate()+".dbf";
       		 String destDirName = properties.getProperty("DEST_DIR_NAME");

       		System.out.println("DownloadDbfFileAction class : Downloading DBF File");

       		CommonUtil commonUtil= new CommonUtil();
       		
       		commonUtil.copyFileUsingFileUtils(srcDirName+fileName,destDirName+fileName);


       		 System.out.println("DownloadDbfFileAction class : Downloaded DBF File");
 

			logger.debug("DownloadDbfFileAction class : execute method : end");
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("EstimateAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
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

}
