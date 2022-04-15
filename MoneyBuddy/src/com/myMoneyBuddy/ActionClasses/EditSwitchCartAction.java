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

import com.myMoneyBuddy.DAOClasses.QuerySwitchCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerSwitchCart;
import com.myMoneyBuddy.EntityClasses.SwitchCart;
import com.opensymphony.xwork2.ActionSupport;

public class EditSwitchCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(EditSwitchCartAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<String> switchOptionArr;
	private List<String> switchTypeArr;
	private List<String> folioNumArr;
	private List<String> switchCartIdArr;
	/*private List<String> withdrawalFundIdArr;*/
	private List<String> purchaseFundNameArr;
	private List<String> switchAmtArr;
	private List<String> switchUnitsArr;
	private List<String> totalAmountArr;
	private List<String> totalUnitsArr;
	private String returnType;
	

    public String execute() {
    	
    	String customerId = null;
    	
    	try {

    		System.out.println(" Called EditSwitchCartAction class : value of returnType : "+getReturnType());
    		customerId = sessionMap.get("customerId").toString();
    		UpdateCustomerSwitchCart updateCustomerSwitchCart = new UpdateCustomerSwitchCart();
    		
    		if (switchCartIdArr != null)  {
    			
    			System.out.println("switchCartIdArr.size() : "+switchCartIdArr.size());
    			
	    		for (int i=0;i<switchCartIdArr.size();i++)  {
	    			System.out.println("switchAmtArr.get("+i+") : "+switchAmtArr.get(i));
	    			System.out.println("switchUnitsArr.get("+i+") : "+switchUnitsArr.get(i));
	    			//System.out.println("unitsArr.get("+i+") : "+unitsArr.get(i)+" and redTypeArr.get("+i+") : "+redTypeArr.get(i)+" and amountArr.get("+i+") : "+amountArr.get(i));
	    			
	    			//updateCustomerSwitchCart.updateCustomerRedCartEntry(customerId, redCartIdArr.get(i),amountArr.get(i), unitsArr.get(i),redOptionArr.get(i), redTypeArr.get(i));
	    			updateCustomerSwitchCart.updateCustomerSwitchCartEntry(customerId, switchCartIdArr.get(i), purchaseFundNameArr.get(i), switchAmtArr.get(i), 
	    					switchUnitsArr.get(i), switchOptionArr.get(i), switchTypeArr.get(i));
	    		}
	    		
	    		
	    		QuerySwitchCart querySwitchCart = new QuerySwitchCart();
	    		
	    		List<SwitchCart> customerSwitchCartList = querySwitchCart.getCustomerSwitchCart(customerId);

		    	sessionMap.put("customerSwitchCartList", customerSwitchCartList);
		    	logger.debug("EditSwitchCartAction class - execute method - customerId - "+customerId+" - stored customerSwitchCartList in sessionMap"); 
	    		
    		}
    		
    		if ("orderConfirmation".equals(getReturnType()))
	
    			return "redirectSwitch";
    		
    		else 
    			
    			return SUCCESS;

	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("EditSwitchCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("EditSwitchCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public List<String> getSwitchCartIdArr() {
		return switchCartIdArr;
	}

	public void setSwitchCartIdArr(List<String> switchCartIdArr) {
		this.switchCartIdArr = switchCartIdArr;
	}

	/*public List<String> getWithdrawalFundIdArr() {
		return withdrawalFundIdArr;
	}

	public void setWithdrawalFundIdArr(List<String> withdrawalFundIdArr) {
		this.withdrawalFundIdArr = withdrawalFundIdArr;
	}*/

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

	public List<String> getSwitchAmtArr() {
		return switchAmtArr;
	}

	public void setSwitchAmtArr(List<String> switchAmtArr) {
		this.switchAmtArr = switchAmtArr;
	}

	public List<String> getSwitchOptionArr() {
		return switchOptionArr;
	}

	public void setSwitchOptionArr(List<String> switchOptionArr) {
		this.switchOptionArr = switchOptionArr;
	}

	public List<String> getSwitchTypeArr() {
		return switchTypeArr;
	}

	public void setSwitchTypeArr(List<String> switchTypeArr) {
		this.switchTypeArr = switchTypeArr;
	}

	public List<String> getSwitchUnitsArr() {
		return switchUnitsArr;
	}

	public void setSwitchUnitsArr(List<String> switchUnitsArr) {
		this.switchUnitsArr = switchUnitsArr;
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

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

    
}
