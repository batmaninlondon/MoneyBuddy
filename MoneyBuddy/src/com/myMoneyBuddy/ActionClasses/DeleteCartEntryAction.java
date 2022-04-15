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

public class DeleteCartEntryAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(DeleteCartEntryAction.class);
	private SessionMap<String,Object> sessionMap;
	//private InputStream stream;
	private String cartId;
	private String anySipOrder;
	private String anyUpfrontOrder;
	//private String allNewFolio;

    public String execute() {
    	
    	String customerId = null;
    	//String transactionType = null;
    	
    	try {
    		customerId = sessionMap.get("customerId").toString();
    		//transactionType = sessionMap.get("transactionType").toString();
    		
    		
    		logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" DeleteCartEntryAction execute method Called !!");

	    	UpdateCustomerCart updateCustomerCart = new UpdateCustomerCart();
	    	updateCustomerCart.deleteCustomerCartEntry(customerId, getCartId());
	    	
	    	QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
    		
    		List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);

	    	sessionMap.put("customerCartList", customerCartList);
	    	logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - stored customerCartList in sessionMap"); 
	    	
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
    		
	
	    	return SUCCESS;
	    	
	    	/*List<CustomerCart> customerCartList ;
	    	if ("UPFRONT".equals(transactionType))
	    		customerCartList = (List<CustomerCart>) sessionMap.get("customerCartUpfrontList");
	    	else 
	    		customerCartList = (List<CustomerCart>) sessionMap.get("customerCartSipList");
	    	
	    	int i = 0;
	    	Double totalAmount = 0.0;
	    	
	    	System.out.println("customerCartList size : "+customerCartList.size());
	    	
	    	for (int j = 0; j < customerCartList.size(); j++)  {
	    		System.out.println("customerCartList.get(j).getSchemeName() : "+customerCartList.get(j).getSchemeName());
	    	}
	    	System.out.println();
	    	while (customerCartList.get(i) != null)  {
	    		
	    		if ("Total".equals(customerCartList.get(i).getSchemeName()))  {
	    			totalAmount = Double.parseDouble(customerCartList.get(i).getAmount());
	    			customerCartList.remove(i);
	    			break;
	    		}
	    		i++;
	    		
	    	}
	    	
	    	System.out.println("Total amount : "+totalAmount);
	    	
	    	i = 0;
	    	
	    	System.out.println(" cartId : "+getCartId());
	    	while (customerCartList.get(i) != null)  {
	    		System.out.println("customerCartList product name : "+customerCartList.get(i).getSchemeName());
	    		if (getCartId().equals(customerCartList.get(i).getCartId()))  {
	    			System.out.println("customerCartList cartId removing : "+customerCartList.get(i).getSchemeName());
	    			totalAmount -= Double.parseDouble(customerCartList.get(i).getAmount());
	    			customerCartList.remove(i);
	    			
	    			break;
	    		}  		
	    		i++;
	    		
	    	}
	    	System.out.println("Total amount : "+totalAmount);
	    	customerCartList.add(new CustomerCart(null,null,"Total",totalAmount.toString(),null,null,null,null,null,null,null,null,null));
	    	
	    	setAllNewFolio("TRUE");
	    	for (int j = 0; j < (customerCartList.size()-1); j++) {
	    	    if ( !customerCartList.get(j).getFolioNumber().equals("New") )  {
	    	    	setAllNewFolio("FALSE");
	    	    }
	    	}
	    	
	    	if ("UPFRONT".equals(transactionType)) {
	    		sessionMap.put("customerCartUpfrontList",customerCartList);
	    		logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" -updated customerCartUpfrontList in sessionMap");
	    		logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - returned UPFRONT");
		    	logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - end");
		    	return "UPFRONT";
	    	}
	    	else {
	    		sessionMap.put("customerCartSipList",customerCartList);
	    		logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" -updated customerCartSipList in sessionMap");
	    		logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - returned SIP");
		    	logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - end");
		    	return "SIP";
	    	}
	    	
	    	
	    	*/
	    	

	    	/*String str = "success";
	    	stream = new ByteArrayInputStream(str.getBytes());*/
	
	    	
	    	
	    	
    	}
    	catch ( Exception e )  {
    		logger.error("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    		/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }
    
/*	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/

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

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
/*
	public String getAllNewFolio() {
		return allNewFolio;
	}

	public void setAllNewFolio(String allNewFolio) {
		this.allNewFolio = allNewFolio;
	}*/

}
