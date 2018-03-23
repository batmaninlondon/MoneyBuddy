/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class DeleteCartEntryAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(DeleteCartEntryAction.class);
	private SessionMap<String,Object> sessionMap;
	private InputStream stream;
	private String cartId;

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" DeleteCartEntryAction execute method Called !!");

	    	UpdateCustomerCart updateCustomerCart = new UpdateCustomerCart();
	    	updateCustomerCart.deleteCustomerCartEntry(customerId, getCartId());
	    	
	    	List<CustomerCart> customerCartList = (List<CustomerCart>) sessionMap.get("customerCartList");
	    	
	    	int i = 0;
	    	Double totalAmount = 0.0;
	    	while (customerCartList.get(i) != null)  {
	    		
	    		if ("Total".equals(customerCartList.get(i).getProductName()))  {
	    			totalAmount = Double.parseDouble(customerCartList.get(i).getAmount());
	    			customerCartList.remove(i);
	    			break;
	    		}
	    		i++;
	    		
	    	}
	    	
	    	System.out.println("Total amount : "+totalAmount);
	    	
	    	i = 0;
	    	
	    	while (customerCartList.get(i) != null)  {
	
	    		if (cartId.equals(customerCartList.get(i).getCartId()))  {
	    			totalAmount -= Double.parseDouble(customerCartList.get(i).getAmount());
	    			customerCartList.remove(i);
	    			break;
	    		}  		
	    		i++;
	    		
	    	}
	    	System.out.println("Total amount : "+totalAmount);
	    	customerCartList.add(new CustomerCart(null,null,"Total",totalAmount.toString(),null,null));
	    	
	    	sessionMap.put("customerCartList",customerCartList);
	    	
	    	logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" -updated customerCartList in sessionMap");

	    	String str = "success";
	    	stream = new ByteArrayInputStream(str.getBytes());
	
	    	logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
    	}
    	catch ( Exception e )  {
    		logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.debug("DeleteCartEntryAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }
    
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

}
