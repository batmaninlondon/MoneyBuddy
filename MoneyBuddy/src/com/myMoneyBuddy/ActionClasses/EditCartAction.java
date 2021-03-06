/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.opensymphony.xwork2.ActionSupport;

public class EditCartAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(EditCartAction.class);
	private SessionMap<String,Object> sessionMap;
/*
	private String cartId;
	private String upfrontInvestment;
	private String folioNum;
	private String updatedField;*/
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
    		
    		/*System.out.println("EDIT CART ACTION CLASS CALLED !!!!!");
    		System.out.println(" upfrontAmtArr size is : "+upfrontAmtArr.size());
    		System.out.println(" upfrontFolioArr size is : "+upfrontFolioArr.size());
    		System.out.println(" upfrontFolioArr size is : "+upfrontCartIdArr.size());*/
    		System.out.println(" Called EditCartAction class : value of returnType : "+getReturnType());
    		customerId = sessionMap.get("customerId").toString();
    		UpdateCustomerCart updateCustomerCart = new UpdateCustomerCart();
    		String upfrontInvestment;
    		
    		/*for (int i=0;i<upfrontAmtArr.size();i++)  {
    			System.out.println("upfrontAmtArr [ "+i+" ] : value is : "+upfrontAmtArr.get(i));
    		}
    		for (int i=0;i<upfrontFolioArr.size();i++)  {
    			System.out.println("upfrontFolioArr [ "+i+" ] : value is : "+upfrontFolioArr.get(i));
    		}*/
    		if (cartIdArr != null)  {
	    		for (int i=0;i<cartIdArr.size();i++)  {
	    			System.out.println(" Called EditCartAction class : value of sipTenure : "+i+" is : "+sipTenureArr.get(i));
	    			System.out.println(" Called EditCartAction class : value of sipDate : "+i+" is : "+sipDateArr.get(i));
	    			/*System.out.println("upfrontCartIdArr [ "+i+" ] : value is : "+upfrontCartIdArr.get(i));*/
	    			/*upfrontInvestment = Double.toString(Math.round( Double.parseDouble(upfrontAmtArr.get(i)) * 100.0 ) / 100.0);*/
	    			updateCustomerCart.updateCustomerCartEntry(customerId, cartIdArr.get(i), fundIdArr.get(i), upfrontAmtArr.get(i), sipAmtArr.get(i),
	    															sipTenureArr.get(i), sipDateArr.get(i), folioNumArr.get(i));
	    		}
	    		
	    		
	    		
	    		/*System.out.println("Selected Cart Id : "+getCartId()+" and selected updatedField is : "+getUpdatedField());
	    		System.out.println(" Selected upfront amount before format : "+getUpfrontInvestment());*/
	    		/*upfrontInvestment = Double.toString(Math.round( Double.parseDouble(getUpfrontInvestment()) * 100.0 ) / 100.0);*/
	    		/*System.out.println(" Selected upfront amount after format : "+getUpfrontInvestment());*/
	    		
	    		
	    		/*updateCustomerCart.updateCustomerCartEntry(customerId, getCartId(), getUpfrontInvestment(), folioNum, getUpdatedField());*/
	    		
	    		QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
	    		
	    		List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);
	
		    	sessionMap.put("customerCartList", customerCartList);
		    	logger.debug("EditCartAction class - execute method - customerId - "+customerId+" - stored customerCartList in sessionMap"); 
		    	
		    	if (customerCartList.stream().anyMatch(o -> "UPFRONT".equals(o.getTransactionType())))
		    		setAnyUpfrontOrder("TRUE");
		    	else
		    		setAnyUpfrontOrder("FALSE");
				if (customerCartList.stream().anyMatch(o -> "SIP".equals(o.getTransactionType())))
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
/*
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getUpfrontInvestment() {
		return upfrontInvestment;
	}

	public void setUpfrontInvestment(String upfrontInvestment) {
		this.upfrontInvestment = upfrontInvestment;
	}

	public String getFolioNum() {
		return folioNum;
	}

	public void setFolioNum(String folioNum) {
		this.folioNum = folioNum;
	}

	public String getUpdatedField() {
		return updatedField;
	}

	public void setUpdatedField(String updatedField) {
		this.updatedField = updatedField;
	}*/


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
