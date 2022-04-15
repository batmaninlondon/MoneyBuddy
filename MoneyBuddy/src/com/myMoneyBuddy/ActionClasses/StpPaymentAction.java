/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class StpPaymentAction extends ActionSupport implements SessionAware {

	Logger logger = LogManager.getLogger(StpPaymentAction.class);
	private SessionMap<String,Object> sessionMap;
	private String fundIdA;
	private String fundIdB;
	private String installmentAmount;
	private String stpDate;
	private String firstOrderFlag;
	   
    public String execute()  {

    	String customerId = null;
    	
    	try {
    		
    		System.out.println("firstOrderFlag : "+getFirstOrderFlag());
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		return SUCCESS;

		} /*catch (MoneyBuddyException e) {	
    		logger.error("PaymentAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			return ERROR;
		} */
    	catch (Exception e) {	
    		logger.error("StpPaymentAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			return ERROR;
		}

    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getFundIdA() {
		return fundIdA;
	}

	public void setFundIdA(String fundIdA) {
		this.fundIdA = fundIdA;
	}

	public String getFundIdB() {
		return fundIdB;
	}

	public void setFundIdB(String fundIdB) {
		this.fundIdB = fundIdB;
	}

	public String getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(String installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public String getStpDate() {
		return stpDate;
	}

	public void setStpDate(String stpDate) {
		this.stpDate = stpDate;
	}

	public String getFirstOrderFlag() {
		return firstOrderFlag;
	}

	public void setFirstOrderFlag(String firstOrderFlag) {
		this.firstOrderFlag = firstOrderFlag;
	}
	

	
}
