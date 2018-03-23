/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.InsertCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class CreateCartAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(CreateCartAction.class);
	private SessionMap<String,Object> sessionMap;
	private InputStream stream;

    public String execute() {
    	
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" CreateCartAction execute method Called !!");
	    	
	    	sessionMap.put("transactionType", "UPFRONT");
	    	logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - stored transactionType as UPFRONT in sessionMap");
	    	
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
	
	    	QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
	    	List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);
	    	
	    	System.out.println(" size of customerCartList is : "+customerCartList.size());
	    	
	    	sessionMap.put("customerCartList", customerCartList);
	    	logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - stored customerCartList in sessionMap");    	
	
	    	String str = "success";
	    	stream = new ByteArrayInputStream(str.getBytes());
	
    	    logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
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

}
