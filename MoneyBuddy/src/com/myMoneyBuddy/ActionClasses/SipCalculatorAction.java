/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.opensymphony.xwork2.ActionSupport;

public class SipCalculatorAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(SipCalculatorAction.class);
	private SessionMap<String,Object> sessionMap;
    private String sipAmount;
    private String fundId;     
    private InputStream stream;

    public String execute() {

    	logger.debug("SipCalculatorAction class - execute method - start ");
    	
    	try {
    		HashMap<Integer,Double> predictedValueList = new HashMap<Integer,Double>();
    		
			sipAmount = Double.toString(Math.round( Double.parseDouble(getSipAmount()) * 100.0 ) / 100.0); 

			PredictedValueCalculation calculatedValue = new PredictedValueCalculation();

			predictedValueList = calculatedValue.predictedSipOfOneFundList(Double.parseDouble(getSipAmount()), getFundId());
			sessionMap.put("sipAmount", getSipAmount());
			sessionMap.put("predictedValueForOneYear", Double.toString(predictedValueList.get(1)));
			sessionMap.put("predictedValueForThreeYear", Double.toString(predictedValueList.get(3)));
			sessionMap.put("predictedValueForFiveYear", Double.toString(predictedValueList.get(5)));
			logger.debug("SipCalculatorAction class - execute method - stored sipAmount in sessionMap");
			logger.debug("SipCalculatorAction class - execute method - stored predictedValueForOneYear in sessionMap");
			logger.debug("SipCalculatorAction class - execute method - stored predictedValueForThreeYear in sessionMap");
			logger.debug("SipCalculatorAction class - execute method - stored predictedValueForFiveYear in sessionMap");
			
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.debug("SipCalculatorAction class - execute method - returned success");
	    	logger.debug("SipCalculatorAction class - execute method - end");
	    	
			return SUCCESS;
		} catch (MoneyBuddyException e) {	
			logger.error("SipCalculatorAction class - execute method - Caught Exception");
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.error("SipCalculatorAction class - execute method - returned error");
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("SipCalculatorAction class - execute method - Caught Exception");
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.error("SipCalculatorAction class - execute method - returned error");
			return ERROR;
		} 

    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
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
