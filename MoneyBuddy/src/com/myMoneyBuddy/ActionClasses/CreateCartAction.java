/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

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
	
	private String totalInvestment;
	
	//private InputStream stream;

    public String execute() {
    	
    	String customerId = null;
    	String folioNum = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
			folioNum = sessionMap.get("selectFolioNum").toString();
			
			sessionMap.remove("FolioNumList");
			System.out.println("FolioNumList has been removed from the session "+sessionMap.get("FolioNumList"));
			sessionMap.remove("selectFolioNum");
    		System.out.println("selectFolioNum has been removed from the session "+sessionMap.get("selectFolioNum"));
    		logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" CreateCartAction execute method Called !!");
	    	System.out.println("CreateCartAction execute method : totalInvestment : "+getTotalInvestment());

	    	sessionMap.put("transactionType", "UPFRONT");
	    	logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - stored transactionType as UPFRONT in sessionMap");
	    	
	    	//String totalInvestment = sessionMap.get("totalInvestment").toString();
	    	HashMap<String,Double> productRatioList = (HashMap<String,Double>)sessionMap.get("productRatioList");
	
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);
	
			Iterator it = productRatioList.entrySet().iterator();
			Double amount = 0.0;
			InsertCustomerCart insertCustomerCart = new InsertCustomerCart();
			QueryProducts queryProduct = new QueryProducts();
			
			// This has been done for the current scenario, in whcih user is selecing one fund at a time, and not the group of funds together

	   	    while (it.hasNext()) {
	   	    	
	   	        Map.Entry pair = (Map.Entry)it.next();
	   	        amount = ((   Double.valueOf(pair.getValue().toString()) * Double.valueOf(getTotalInvestment()) ) /100);
	   	        insertCustomerCart.addCustomerCart(customerId,pair.getKey().toString(),queryProduct.getProductName(pair.getKey().toString()),amount.toString(),
	   	        		folioNum,frmtdDate,"Pending");
	   	        
	   	    }
	
	    	QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
	    	List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);
	    	
	    	System.out.println(" size of customerCartList is : "+customerCartList.size());
	    	
	    	sessionMap.put("customerCartList", customerCartList);
	    	logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - stored customerCartList in sessionMap");    	
	
	    	/*String str = "success";
	    	stream = new ByteArrayInputStream(str.getBytes());*/
	
    	    logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("CreateCartAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("CreateCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    		/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("CreateCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(String totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
    
/*	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/

}
