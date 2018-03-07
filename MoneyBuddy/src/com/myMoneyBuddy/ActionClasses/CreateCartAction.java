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
public class CreateCartAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(CreateCartAction.class);
	private Map<String, Object> sessionMap;

	private InputStream stream;

    public String execute() {
    	
    	try {
    		
    	logger.debug("CreateCartAction class : execute method : start");
    	System.out.println(" CreateCartAction execute method Called !!");
    	
    	sessionMap.put("transactionType", "UPFRONT");
    	
    	String customerId = sessionMap.get("customerId").toString();
    	String totalInvestment = sessionMap.get("totalInvestment").toString();
    	HashMap<String,Double> productRatioList = (HashMap<String,Double>)sessionMap.get("productRatioList");

    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String frmtdDate = dateFormat.format(date);

		Iterator it = productRatioList.entrySet().iterator();
		Double amount = 0.0;
		InsertCustomerCart insertCustomerCart = new InsertCustomerCart();
		QueryProducts queryProduct = new QueryProducts();
   	    while (it.hasNext()) {
   	    	
   	        Map.Entry pair = (Map.Entry)it.next();
   	        amount = ((   Double.valueOf(pair.getValue().toString()) * Double.valueOf(totalInvestment) ) /100);
   	        insertCustomerCart.addCustomerCart(customerId,pair.getKey().toString(),queryProduct.getProductName(pair.getKey().toString()),amount.toString(),frmtdDate,"Pending");
   	        
   	    }
		  
    	logger.debug("CreateCartAction class : execute method : end");
    	
    	System.out.println(" Returned Success !!");

    	QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
    	List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);
    	
    	System.out.println(" size of customerCartList is : "+customerCartList.size());
    	
    	sessionMap.put("customerCartList", customerCartList);
    	logger.debug("CreateCartAction class : execute method : stored customerCartList in session id : "+sessionMap.getClass().getName());
    	
    	/*List<CustomerCart> sessionCustomerCartList = (List<CustomerCart>) sessionMap.get("customerCartList");
    	
    	System.out.println(" size of sessionCustomerCartList is : "+sessionCustomerCartList.size());
    	
    	for (int i=0; i<sessionCustomerCartList.size(); i++){
    			CustomerCart row = (CustomerCart) sessionCustomerCartList.get(i);
    		   System.out.println("Entry of fundId in customerCartList is : "+row.getProductId());
    		   System.out.println("Entry of amount in customerCartList is : "+row.getAmount());
    		   System.out.println("Entry of date in customerCartList is : "+row.getCartCreationDate());
    		}*/
    	

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
    		logger.error("CreateCartAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
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

}
