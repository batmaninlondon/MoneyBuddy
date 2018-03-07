/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.InsertCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.EntityClasses.Subscriber;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceStarMF;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.tempuri.IStarMFWebService;
import org.tempuri.MFOrderEntry;

/**
 *
 * @author Savita Wadhwani
 */
public class DeleteCartEntryAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(DeleteCartEntryAction.class);
	private Map<String, Object> sessionMap;

	private InputStream stream;
	
	private String cartId;

    public String execute() {
    	
    	try {
    		
    	logger.debug("DeleteCartEntryAction class : execute method : start");
    	System.out.println(" DeleteCartEntryAction execute method Called !!");
    	
    	String customerId = sessionMap.get("customerId").toString();

    	UpdateCustomerCart updateCustomerCart = new UpdateCustomerCart();
    	updateCustomerCart.deleteCustomerCartEntry(customerId, getCartId());
    	
    	logger.debug("DeleteCartEntryAction class : execute method : end");
    	
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
    	
    	logger.debug("DeleteCartEntryAction class : execute method : updated customerCartList in session id : "+sessionMap.getClass().getName());
    	
    	
    	
    	String str = "success";
    	stream = new ByteArrayInputStream(str.getBytes());

    	return SUCCESS;
    	} 
    	/*catch ( MoneyBuddyException e )  {
    		logger.error("KycCheckAction class : execute method : caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}*/
    	catch ( Exception e )  {
    		logger.error("DeleteCartEntryAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    

    public Map<String, Object> getSession() {
		return sessionMap;
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
