/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.EntityClasses.PrimaryFundDetails;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class BuyFundAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(BuyFundAction.class);
	private SessionMap<String,Object> sessionMap;
	private InputStream stream;
	private String fundId;
	private String folioNum;
	private FundDetailsDataModel selectedFundDetailsDataModel;
	
    public String execute() {

    	try {
    		
    		QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
    		PrimaryFundDetails primaryFundDetails = queryPrimaryFundDetails.getPrimaryFundDetail(getFundId());
    		HashMap<String,Double> productRatioList =  new HashMap<String,Double>();
    		    		
	    	System.out.println("MIN LUMPSUM PURCHASE AMOUNT ........ "+primaryFundDetails.getMinPurchaseAmount());
	    	sessionMap.put("minPurchaseAmount", primaryFundDetails.getMinPurchaseAmount());
	    	logger.debug("BuyFundAction class - execute method - fetched minPurchaseAmount from primaryFundDetails and stored it in session");

	    	System.out.println("MIN SIP AMOUNT ........ "+primaryFundDetails.getMinSipAmount());
	    	sessionMap.put("minSipAmount", primaryFundDetails.getMinSipAmount());
	    	System.out.println("folio num :"+getFolioNum());

	    	if (null != getFolioNum() && !("".equals(getFolioNum())) && !("undefined".equals(getFolioNum())))  {
	    		System.out.println("FOLIO NUMBER IS NOT NULL ........................");
	    		sessionMap.put("FolioNumList", getFolioNum());
	    	}
	    	else {
	    		System.out.println("FOLIO NUMBER IS NULL ........................");
	    	
		    	if (sessionMap.get("customerId") != null)  {
	    			    			
	    			System.out.println("CURRENT PRODUCT ID IS : "+getFundId());
	    			
	    			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
	    			String folioNumList = queryTransactionDetails.getFolioNumsList(sessionMap.get("customerId").toString(), getFundId());
	    			System.out.println("CURRENT FOLIO NUM LIST IS : "+folioNumList);
	    			sessionMap.put("FolioNumList", folioNumList);
	    		}
	    	}

	    	
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
	    	
	    	System.out.println("fundId : "+getFundId());

	    	selectedFundDetailsDataModel = queryPrimaryFundDetails.getSelectedFundDetailsData(getFundId());
			setSelectedFundDetailsDataModel(selectedFundDetailsDataModel);
			
			sessionMap.put("selectedFundDetailsDataModel", selectedFundDetailsDataModel);
			/*sessionMap.put("sipFlag", primaryFundDetails.getSipFlag());*/
			logger.debug("BuyFundAction class - execute method - stored selectedFundDetailsDataModel in sessionMap ");

			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    
    	    logger.debug("BuyFundAction class - execute method - returned success");
	    	
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

	public String getFolioNum() {
		return folioNum;
	}

	public void setFolioNum(String folioNum) {
		this.folioNum = folioNum;
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
