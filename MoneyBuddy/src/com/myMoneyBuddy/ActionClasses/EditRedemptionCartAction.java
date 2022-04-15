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

import com.myMoneyBuddy.DAOClasses.QueryCustomerRedemptionCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerRedemptionCart;
import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.opensymphony.xwork2.ActionSupport;

public class EditRedemptionCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(EditRedemptionCartAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<String> redOptionArr;
	private List<String> redTypeArr;
	private List<String> folioNumArr;
	private List<String> redCartIdArr;
	private List<String> fundIdArr;
	private List<String> amountArr;
	private List<String> unitsArr;
	private List<String> totalAmountArr;
	private List<String> totalUnitsArr;
	private String returnType;
	

    public String execute() {
    	
    	String customerId = null;
    	
    	try {

    		System.out.println(" Called EditRedemptionCartAction class : value of returnType : "+getReturnType());
    		customerId = sessionMap.get("customerId").toString();
    		UpdateCustomerRedemptionCart updateCustomerRedemptionCart = new UpdateCustomerRedemptionCart();
    		
    		if (redCartIdArr != null)  {
    			
    			System.out.println("redCartIdArr.size() : "+redCartIdArr.size());
    			
	    		for (int i=0;i<redCartIdArr.size();i++)  {
	    			System.out.println("unitsArr.get("+i+") : "+unitsArr.get(i)+" and redTypeArr.get("+i+") : "+redTypeArr.get(i)+" and amountArr.get("+i+") : "+amountArr.get(i));
	    			
	    			updateCustomerRedemptionCart.updateCustomerRedCartEntry(customerId, redCartIdArr.get(i),amountArr.get(i), unitsArr.get(i),redOptionArr.get(i), redTypeArr.get(i));
	    		
	    		}
	    		
	    		
	    		QueryCustomerRedemptionCart  queryCustomerRedemptionCart = new QueryCustomerRedemptionCart();
	    		
	    		List<RedemptionCart> customerRedemptionCartList = queryCustomerRedemptionCart.getCustomerRedemptionCart(customerId);

		    	sessionMap.put("customerRedemptionCartList", customerRedemptionCartList);
		    	logger.debug("EditRedemptionCartAction class - execute method - customerId - "+customerId+" - stored customerRedemptionCartList in sessionMap"); 
	    		
    		}
    		
    		if ("orderConfirmation".equals(getReturnType()))
	
    			return "redirectRedeem";
    		
    		else 
    			
    			return SUCCESS;

	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("EditRedemptionCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("EditRedemptionCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public List<String> getRedOptionArr() {
		return redOptionArr;
	}

	public void setRedOptionArr(List<String> redOptionArr) {
		this.redOptionArr = redOptionArr;
	}

	public List<String> getRedTypeArr() {
		return redTypeArr;
	}

	public void setRedTypeArr(List<String> redTypeArr) {
		this.redTypeArr = redTypeArr;
	}

	public List<String> getFolioNumArr() {
		return folioNumArr;
	}

	public void setFolioNumArr(List<String> folioNumArr) {
		this.folioNumArr = folioNumArr;
	}

	public List<String> getRedCartIdArr() {
		return redCartIdArr;
	}

	public void setRedCartIdArr(List<String> redCartIdArr) {
		this.redCartIdArr = redCartIdArr;
	}

	public List<String> getFundIdArr() {
		return fundIdArr;
	}

	public void setFundIdArr(List<String> fundIdArr) {
		this.fundIdArr = fundIdArr;
	}

	public List<String> getAmountArr() {
		return amountArr;
	}

	public void setAmountArr(List<String> amountArr) {
		this.amountArr = amountArr;
	}

	public List<String> getUnitsArr() {
		return unitsArr;
	}

	public void setUnitsArr(List<String> unitsArr) {
		this.unitsArr = unitsArr;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public List<String> getTotalAmountArr() {
		return totalAmountArr;
	}

	public void setTotalAmountArr(List<String> totalAmountArr) {
		this.totalAmountArr = totalAmountArr;
	}

	public List<String> getTotalUnitsArr() {
		return totalUnitsArr;
	}

	public void setTotalUnitsArr(List<String> totalUnitsArr) {
		this.totalUnitsArr = totalUnitsArr;
	}


}
