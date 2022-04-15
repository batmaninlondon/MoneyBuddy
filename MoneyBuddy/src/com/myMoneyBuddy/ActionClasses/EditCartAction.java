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

import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.opensymphony.xwork2.ActionSupport;

public class EditCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(EditCartAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<String> upfrontAmtArr;
	private List<String> sipAmtArr;
	private List<String> folioNumArr;
	private List<String> cartIdArr;
	private List<String> fundIdArr;
	private List<String> sipTenureArr;
	private List<String> sipDateArr;
	private String returnType;
	private String anySipOrder;
	private String anyUpfrontOrder;
	

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		
    		System.out.println(" Called EditCartAction class : value of returnType : "+getReturnType());
    		customerId = sessionMap.get("customerId").toString();
    		UpdateCustomerCart updateCustomerCart = new UpdateCustomerCart();
    		String upfrontInvestment;
    		
    		if (cartIdArr != null)  {
	    		for (int i=0;i<cartIdArr.size();i++)  {
	    			System.out.println(" Called EditCartAction class : value of sipTenure : "+i+" is : "+sipTenureArr.get(i));
	    			System.out.println(" Called EditCartAction class : value of sipDate : "+i+" is : "+sipDateArr.get(i));
	    			updateCustomerCart.updateCustomerCartEntry(customerId, cartIdArr.get(i), fundIdArr.get(i), upfrontAmtArr.get(i), sipAmtArr.get(i),
	    															sipTenureArr.get(i), sipDateArr.get(i), folioNumArr.get(i));
	    		}
	    		
	    		QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
	    		
	    		List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);
	
		    	sessionMap.put("customerCartList", customerCartList);
		    	logger.debug("EditCartAction class - execute method - customerId - "+customerId+" - stored customerCartList in sessionMap"); 
		    	
		    	if (customerCartList.stream().anyMatch(o -> "UPFRONT".equalsIgnoreCase(o.getTransactionType())))
		    		setAnyUpfrontOrder("TRUE");
		    	else
		    		setAnyUpfrontOrder("FALSE");
				if (customerCartList.stream().anyMatch(o -> "SIP".equalsIgnoreCase(o.getTransactionType())))
					setAnySipOrder("TRUE");
				else
					setAnySipOrder("FALSE");
				
	    		System.out.println("anySipOrder : "+anySipOrder);
	    		System.out.println("anyUpfrontOrder : "+anyUpfrontOrder);
	    		sessionMap.put("anySipOrder", anySipOrder);
	    		sessionMap.put("anyUpfrontOrder", anyUpfrontOrder);
	    		
    		}
    		
    		if ("FundExplorer".equals(getReturnType()))
	
    			return SUCCESS;
    		
    		else 
    			return "redirect";
	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("EditCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("EditCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public String getReturnType() {
		return returnType;
	}


	public List<String> getUpfrontAmtArr() {
		return upfrontAmtArr;
	}

	public void setUpfrontAmtArr(List<String> upfrontAmtArr) {
		this.upfrontAmtArr = upfrontAmtArr;
	}

	public List<String> getSipAmtArr() {
		return sipAmtArr;
	}

	public void setSipAmtArr(List<String> sipAmtArr) {
		this.sipAmtArr = sipAmtArr;
	}

	public List<String> getFolioNumArr() {
		return folioNumArr;
	}

	public void setFolioNumArr(List<String> folioNumArr) {
		this.folioNumArr = folioNumArr;
	}

	public List<String> getCartIdArr() {
		return cartIdArr;
	}

	public void setCartIdArr(List<String> cartIdArr) {
		this.cartIdArr = cartIdArr;
	}

	public List<String> getFundIdArr() {
		return fundIdArr;
	}

	public void setFundIdArr(List<String> fundIdArr) {
		this.fundIdArr = fundIdArr;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public List<String> getSipTenureArr() {
		return sipTenureArr;
	}

	public void setSipTenureArr(List<String> sipTenureArr) {
		this.sipTenureArr = sipTenureArr;
	}

	public List<String> getSipDateArr() {
		return sipDateArr;
	}

	public void setSipDateArr(List<String> sipDateArr) {
		this.sipDateArr = sipDateArr;
	}

	public String getAnySipOrder() {
		return anySipOrder;
	}

	public void setAnySipOrder(String anySipOrder) {
		this.anySipOrder = anySipOrder;
	}

	public String getAnyUpfrontOrder() {
		return anyUpfrontOrder;
	}

	public void setAnyUpfrontOrder(String anyUpfrontOrder) {
		this.anyUpfrontOrder = anyUpfrontOrder;
	}



}
