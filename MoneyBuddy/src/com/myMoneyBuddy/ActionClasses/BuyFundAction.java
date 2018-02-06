/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;

public class BuyFundAction extends ActionSupport implements SessionAware  {

	
	Logger logger = Logger.getLogger(BuyFundAction.class);
	private Map<String, Object> sessionMap;

	private InputStream stream;
	
	
	private String fundId;
	
	private FundDetailsDataModel selectedFundDetailsDataModel;
	
    public String execute() {

    	logger.debug("BuyFundAction class : execute method : start");
    	Session hibernateSession = null;
    	
    	try {
    		
	    	hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	    	
	    	hibernateSession.beginTransaction();
	    	
	    	HashMap<String,Double> productRatioList =  new HashMap<String,Double>();

	    	Query query = hibernateSession.createQuery("select minLumsumAmount from PrimaryFundDetails where fundId = :fundId");
	    	
	    	query.setParameter("fundId", fundId);
	    	String minLumsumAmount = query.uniqueResult().toString(); 	
	    	
	    	System.out.println("MIN LUMSUM AMOUNT ........ "+minLumsumAmount);
	    	sessionMap.put("minLumsumAmount", minLumsumAmount);
	    	
	    	query = hibernateSession.createQuery("select minSipAmount from PrimaryFundDetails where fundId = :fundId");
	    	
	    	query.setParameter("fundId", fundId);
	    	String minSipAmount = query.uniqueResult().toString(); 	
	    	
	    	System.out.println("MIN SIP AMOUNT ........ "+minSipAmount);
	    	sessionMap.put("minSipAmount", minSipAmount);
	    	
	    	query = hibernateSession.createQuery("select minSipDuration from PrimaryFundDetails where fundId = :fundId");
	    	
	    	query.setParameter("fundId", fundId);
	    	String minSipDuration = query.uniqueResult().toString(); 	
	    	
	    	int i = (int)Double.parseDouble(minSipDuration);
   	        
	    	
	        	if ((i%12)!= 0 )  {
	        		i = (i /12) +1;
	        	}
	        	else {
	        		i = (i/12);
	        	}
	        	System.out.println("minSipDuration : "+i);
	    	
	        	System.out.println("MIN SIP DURATION ........ "+i);
	    	sessionMap.put("minSipDuration", i);
	    	
	    	
	    	
	    	productRatioList.put(fundId,Double.parseDouble("100"));
	    	
	    	sessionMap.put("productRatioList", productRatioList);
	    	
	    	System.out.println("productId : "+fundId);
	    	
	    	QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();

	    	selectedFundDetailsDataModel = queryPrimaryFundDetails.getSelectedFundDetailsData(getFundId());
			setSelectedFundDetailsDataModel(selectedFundDetailsDataModel);
			
			sessionMap.put("selectedFundDetailsDataModel", selectedFundDetailsDataModel);
			logger.debug("BuyFundAction class : execute method : stored selectedFundDetailsDataModel in session id : "+sessionMap.getClass().getName());
	    	//System.out.println("amount : "+amount);
	    	
	    	logger.debug("BuyFundAction class : execute method : end");
	    	
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
			
    	}

    	catch (Exception e) {	
			logger.debug("BuyFundAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		}
    	finally {
    		/*if(factory!=null)
			factory.close();*/
    		//HibernateUtil.getSessionAnnotationFactory().close();
			hibernateSession.close();
    	}

    }
    

	public String getFundId() {
		return fundId;
	}




	public void setFundId(String fundId) {
		this.fundId = fundId;
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


	public FundDetailsDataModel getSelectedFundDetailsDataModel() {
		return selectedFundDetailsDataModel;
	}


	public void setSelectedFundDetailsDataModel(FundDetailsDataModel selectedFundDetailsDataModel) {
		this.selectedFundDetailsDataModel = selectedFundDetailsDataModel;
	}




}
