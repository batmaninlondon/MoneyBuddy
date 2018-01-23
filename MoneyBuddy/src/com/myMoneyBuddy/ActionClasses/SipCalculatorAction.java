/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class SipCalculatorAction extends ActionSupport implements SessionAware  {

	Logger logger = Logger.getLogger(SipCalculatorAction.class);
	private Map<String, Object> sessionMap;

    private String sipAmount;
    private String fundId;
    
    HashMap<Integer,Double> predictedValueList = new HashMap<Integer,Double>();
    
    private InputStream stream;

    public String execute() {

    	logger.debug("SipCalculatorAction class : execute method : start");
    	
    	try {
    		
			sipAmount = Double.toString(Math.round( Double.parseDouble(getSipAmount()) * 100.0 ) / 100.0); 

			PredictedValueCalculation calculatedValue = new PredictedValueCalculation();

			predictedValueList = calculatedValue.predictedSipOfOneFundList(Double.parseDouble(getSipAmount()), getFundId());
			sessionMap.put("sipAmount", getSipAmount());
			sessionMap.put("predictedValueForOneYear", Double.toString(predictedValueList.get(1)));
			sessionMap.put("predictedValueForThreeYear", Double.toString(predictedValueList.get(3)));
			sessionMap.put("predictedValueForFiveYear", Double.toString(predictedValueList.get(5)));
			logger.debug("SipCalculatorAction class : execute method : stored sipAmount : "+getSipAmount()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("SipCalculatorAction class : execute method : stored predictedValueForOneYear : "+predictedValueList.get(1)+" in session id : "+sessionMap.getClass().getName());
			logger.debug("SipCalculatorAction class : execute method : stored predictedValueForThreeYear : "+predictedValueList.get(3)+" in session id : "+sessionMap.getClass().getName());
			logger.debug("SipCalculatorAction class : execute method : stored predictedValueForFiveYear : "+predictedValueList.get(5)+" in session id : "+sessionMap.getClass().getName());

			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());

			logger.debug("SipCalculatorAction class : execute method : end");
			return SUCCESS;
		} catch (MoneyBuddyException e) {	
			logger.debug("SipCalculatorAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
			logger.debug("SipCalculatorAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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

    public String getSipAmount() {
		return sipAmount;
	}

	public void setSipAmount(String sipAmount) {
		this.sipAmount = sipAmount;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}


}
