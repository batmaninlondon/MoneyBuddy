/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryStpCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerStpCart;
import com.myMoneyBuddy.EntityClasses.StpCart;
import com.opensymphony.xwork2.ActionSupport;

public class EditStpCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(EditStpCartAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<String> stpCartIdArr;
	private List<String> withdrawalFundIdArr;
	private List<String> folioNumArr;
	private List<String> purchaseFundNameArr;
	private List<String> stpAmtArr;
	private List<String> stpTenureArr;
	private List<String> stpDateArr;
	private String returnType;
	

    public String execute() {
    	
    	String customerId = null;
    	
    	try {

    		System.out.println(" Called EditStpCartAction class : value of returnType : "+getReturnType());
    		customerId = sessionMap.get("customerId").toString();
    		UpdateCustomerStpCart updateCustomerStpCart = new UpdateCustomerStpCart();
    		
    		if (stpCartIdArr != null)  {
    			
    			System.out.println("stpCartIdArr.size() : "+stpCartIdArr.size());
    			
	    		for (int i=0;i<stpCartIdArr.size();i++)  {
	    			System.out.println("stpAmtArr.get("+i+") : "+stpAmtArr.get(i));
	    			//System.out.println("unitsArr.get("+i+") : "+unitsArr.get(i)+" and redTypeArr.get("+i+") : "+redTypeArr.get(i)+" and amountArr.get("+i+") : "+amountArr.get(i));
	    			
	    			//updateCustomerStpCart.updateCustomerRedCartEntry(customerId, redCartIdArr.get(i),amountArr.get(i), unitsArr.get(i),redOptionArr.get(i), redTypeArr.get(i));
	    			updateCustomerStpCart.updateCustomerStpCartEntry(customerId, stpCartIdArr.get(i), purchaseFundNameArr.get(i), 
	    					stpAmtArr.get(i), stpTenureArr.get(i), stpDateArr.get(i));
	    		}
	    		
	    		
	    		QueryStpCart queryStpCart = new QueryStpCart();
	    		
	    		List<StpCart> customerStpCartList = queryStpCart.getCustomerStpCart(customerId);

		    	sessionMap.put("customerStpCartList", customerStpCartList);
		    	logger.debug("EditStpCartAction class - execute method - customerId - "+customerId+" - stored customerStpCartList in sessionMap"); 
	    		
    		}
    		
    		if ("orderConfirmation".equals(getReturnType()))
	
    			return "redirectStp";
    		
    		else 
    			
    			return SUCCESS;

	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("EditStpCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("EditStpCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public List<String> getStpCartIdArr() {
		return stpCartIdArr;
	}

	public void setStpCartIdArr(List<String> stpCartIdArr) {
		this.stpCartIdArr = stpCartIdArr;
	}

	public List<String> getWithdrawalFundIdArr() {
		return withdrawalFundIdArr;
	}

	public void setWithdrawalFundIdArr(List<String> withdrawalFundIdArr) {
		this.withdrawalFundIdArr = withdrawalFundIdArr;
	}

	public List<String> getFolioNumArr() {
		return folioNumArr;
	}

	public void setFolioNumArr(List<String> folioNumArr) {
		this.folioNumArr = folioNumArr;
	}

	public List<String> getPurchaseFundNameArr() {
		return purchaseFundNameArr;
	}

	public void setPurchaseFundNameArr(List<String> purchaseFundNameArr) {
		this.purchaseFundNameArr = purchaseFundNameArr;
	}

	public List<String> getStpAmtArr() {
		return stpAmtArr;
	}

	public void setStpAmtArr(List<String> stpAmtArr) {
		this.stpAmtArr = stpAmtArr;
	}

	public List<String> getStpTenureArr() {
		return stpTenureArr;
	}

	public void setStpTenureArr(List<String> stpTenureArr) {
		this.stpTenureArr = stpTenureArr;
	}

	public List<String> getStpDateArr() {
		return stpDateArr;
	}

	public void setStpDateArr(List<String> stpDateArr) {
		this.stpDateArr = stpDateArr;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

    
}
