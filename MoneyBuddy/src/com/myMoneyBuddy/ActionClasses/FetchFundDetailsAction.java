/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerPortfolio;
import com.myMoneyBuddy.DAOClasses.QueryFundDetails;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.EntityClasses.Transactions;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.PortfolioDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.mailerClasses.SendMail;
import com.opensymphony.xwork2.ActionSupport;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class FetchFundDetailsAction extends ActionSupport implements SessionAware  {

	
	
	Logger logger = Logger.getLogger(FetchFundDetailsAction.class);
	private Map<String, Object> sessionMap;

	private InputStream stream;
	
	private List<FundDetailsDataModel> fundDetailsDataModel;
	
    public String execute() {

    	logger.debug("FetchFundDetailsAction class : execute method : start");
    	
    	try {
				
			QueryFundDetails queryFundDetails = new QueryFundDetails();

			fundDetailsDataModel = queryFundDetails.getFundDetailsData();
			setFundDetailsDataModel(fundDetailsDataModel);
			
			sessionMap.put("fundDetailsDataModel", fundDetailsDataModel);
			logger.debug("FetchFundDetailsAction class : execute method : stored fundDetailsDataModel in session id : "+sessionMap.getClass().getName());
			
			logger.debug("FetchFundDetailsAction class : execute method : end");
			
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.debug("FetchFundDetailsAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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


	public List<FundDetailsDataModel> getFundDetailsDataModel() {
		return fundDetailsDataModel;
	}


	public void setFundDetailsDataModel(List<FundDetailsDataModel> fundDetailsDataModel) {
		this.fundDetailsDataModel = fundDetailsDataModel;
	}


}
