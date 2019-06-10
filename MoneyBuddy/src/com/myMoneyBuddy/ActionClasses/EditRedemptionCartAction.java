/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.InsertCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerRedemptionCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerRedemptionCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class EditRedemptionCartAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(EditRedemptionCartAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<String> redOptionArr;
	private List<String> redTypeArr;
	private List<String> folioNumArr;
	private List<String> redCartIdArr;
	private List<String> productIdArr;
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
	    		for (int i=0;i<redCartIdArr.size();i++)  {
	    			
	    			String amount = "0";
	    			String units = "0";
	    			String redOption = "Select";
	    			String redType = "Select";
	    			
	    			if ("Full".equals(redOptionArr.get(i)))  {
	    				amount = totalAmountArr.get(i);
	    				units = totalUnitsArr.get(i);
	    				redOption = "Full";
	    			}
	    			else if ("Partial".equals(redOptionArr.get(i)))  {
	    				redOption="Partial";
	    				if ("Amount".equals(redTypeArr.get(i))) {
	    					redType="Amount";
	    					amount = amountArr.get(i);
	    				}
	    				else if ("Units".equals(redTypeArr.get(i))) {
	    					redType="Units";
	    					units = unitsArr.get(i);
	    				}
	    			}
	    			
	    			updateCustomerRedemptionCart.updateCustomerRedCartEntry(customerId, redCartIdArr.get(i),amount, units,redOption, redType);
	    		
	    		}
	    		
	    		
	    		QueryCustomerRedemptionCart  queryCustomerRedemptionCart = new QueryCustomerRedemptionCart();
	    		
	    		List<RedemptionCart> customerRedemptionCartList = queryCustomerRedemptionCart.getCustomerRedemptionCart(customerId);

		    	sessionMap.put("customerRedemptionCartList", customerRedemptionCartList);
		    	logger.debug("EditRedemptionCartAction class - execute method - customerId - "+customerId+" - stored customerRedemptionCartList in sessionMap"); 
	    		
    		}
    		
    		if ("OrderInvoice".equals(getReturnType()))
	
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

	public List<String> getProductIdArr() {
		return productIdArr;
	}

	public void setProductIdArr(List<String> productIdArr) {
		this.productIdArr = productIdArr;
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
