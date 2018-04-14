/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.EntityClasses.PrimaryFundDetails;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class BuyFundAction extends ActionSupport implements SessionAware  {

	Logger logger = Logger.getLogger(BuyFundAction.class);
	private SessionMap<String,Object> sessionMap;
	private InputStream stream;
	private String fundId;
	private FundDetailsDataModel selectedFundDetailsDataModel;
	
    public String execute() {

    	
    	
    	try {
    		
    		logger.debug("BuyFundAction class - execute method - start ");
    		
    		QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
    		PrimaryFundDetails primaryFundDetails = queryPrimaryFundDetails.getPrimaryFundDetail(getFundId());
    		HashMap<String,Double> productRatioList =  new HashMap<String,Double>();
    		    		
	    	System.out.println("MIN LUMSUM AMOUNT ........ "+primaryFundDetails.getMinLumsumAmount());
	    	sessionMap.put("minLumsumAmount", primaryFundDetails.getMinLumsumAmount());
	    	logger.debug("BuyFundAction class - execute method - fetched minLumsumAmount from primaryFundDetails and stored it in session");
	    	
	    	System.out.println("MIN SIP AMOUNT ........ "+primaryFundDetails.getMinSipAmount());
	    	sessionMap.put("minSipAmount", primaryFundDetails.getMinSipAmount());
	    	logger.debug("BuyFundAction class - execute method - fetched minSipAmount from primaryFundDetails and stored it in session");
	    	
	    	String minSipDuration = primaryFundDetails.getMinSipDuration(); 	

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
        	logger.debug("BuyFundAction class - execute method - fetched minSipDuration from primaryFundDetails and stored it in sessionMap");	
	    	
	    	productRatioList.put(getFundId(),Double.parseDouble("100"));
	    	logger.debug("BuyFundAction class - execute method - added fund id: "+getFundId()+"and percentage: 100 in productRatioList ");
	    	
	    	sessionMap.put("productRatioList", productRatioList);
	    	logger.debug("BuyFundAction class - execute method - stored productRatioList in sessionMap");
	    	
	    	System.out.println("productId : "+getFundId());

	    	selectedFundDetailsDataModel = queryPrimaryFundDetails.getSelectedFundDetailsData(getFundId());
			setSelectedFundDetailsDataModel(selectedFundDetailsDataModel);
			
			sessionMap.put("selectedFundDetailsDataModel", selectedFundDetailsDataModel);
			logger.debug("BuyFundAction class - execute method - stored selectedFundDetailsDataModel in sessionMap ");

			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    
    	    logger.debug("BuyFundAction class - execute method - returned success");
	    	logger.debug("BuyFundAction class - execute method - end");
	    	
			return SUCCESS;
			
    	}

    	catch (Exception e) {	
			logger.error("BuyFundAction class - execute method - Caught Exception");
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.error("BuyFundAction class - execute method - returned error");
			return ERROR;
		}

    }
    
	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
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

	public FundDetailsDataModel getSelectedFundDetailsDataModel() {
		return selectedFundDetailsDataModel;
	}

	public void setSelectedFundDetailsDataModel(FundDetailsDataModel selectedFundDetailsDataModel) {
		this.selectedFundDetailsDataModel = selectedFundDetailsDataModel;
	}

}
