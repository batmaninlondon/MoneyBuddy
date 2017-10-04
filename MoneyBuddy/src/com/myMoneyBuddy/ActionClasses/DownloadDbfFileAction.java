/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.Trading;
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
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class DownloadDbfFileAction extends ActionSupport implements SessionAware  {

	
	
	Logger logger = Logger.getLogger(DownloadDbfFileAction.class);
	private Map<String, Object> sessionMap;
	
	private String date;
	private InputStream stream;
	
    public String execute() {
    	
		System.out.println("DownloadDbfFileAction class : execute method : date : "+date);
		
	
    	logger.debug("DownloadDbfFileAction class : execute method : start");
    	
    	try {
    		
    		Properties properties = new Properties();
			String propFilePath = "../../../config/config.properties";

			properties.load(Trading.class.getResourceAsStream(propFilePath));
    		
      		 String srcDirName = properties.getProperty("SRC_DIR_NAME");
       		 String fileName = getDate()+".dbf";
       		 String destDirName = properties.getProperty("DEST_DIR_NAME");

       		System.out.println("DownloadDbfFileAction class : Downloading DBF File");

       		copyFileUsingFileUtils(srcDirName+fileName,destDirName+fileName);


       		 System.out.println("DownloadDbfFileAction class : Downloaded DBF File");
 

			logger.debug("DownloadDbfFileAction class : execute method : end");
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.debug("EstimateAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
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




}
