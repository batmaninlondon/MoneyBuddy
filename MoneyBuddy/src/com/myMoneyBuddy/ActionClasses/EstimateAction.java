/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;

public class EstimateAction extends ActionSupport implements SessionAware  {

	
	
	Logger logger = LogManager.getLogger(EstimateAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String selectFolioNum;
	private String upfrontInvestment;
    private String sipAmount;
    private String sipDuration; // in years
    private String sipPlan;
    private String sipDate;
    //private String riskCategory;
    //private String planName;
    //private String totalInvestment;
    private String transactionType;
    private String totalInvestment;
    
    HashMap<Integer,Double> predictedValueList = new HashMap<Integer,Double>();
    String regexDecimal = "(\\d+(?:\\.\\d+)?)";
    Pattern patternDecimal = Pattern.compile(regexDecimal);
    
    //private InputStream stream;

    public String execute() {

    	try {
    		
    		logger.debug("EstimateAction class - execute method - start");
    		
    		System.out.println("EstimateAction class - execute method - start - sipPlan value :"+getSipPlan()+":");
    		System.out.println("EstimateAction class - execute method - sipDate : "+getSipDate());
    		System.out.println("EstimateAction class - execute method - sipDuration : "+getSipDuration());
    		System.out.println("EstimateAction class - execute method - transactionType : "+getTransactionType()+" - folio number is :"+getSelectFolioNum()+":");
    		
			System.out.println("Before calculation : upfrontInvestment : "+getUpfrontInvestment()+ " and sipAmount : "+getSipAmount());
			upfrontInvestment = Double.toString(Math.round( Double.parseDouble(getUpfrontInvestment()) * 100.0 ) / 100.0);
			sipAmount = Double.toString(Math.round( Double.parseDouble(getSipAmount()) * 100.0 ) / 100.0); 
			System.out.println("After calculation : upfrontInvestment : "+getUpfrontInvestment()+ " and sipAmount : "+getSipAmount());

	    	QueryProducts queryProduct = new QueryProducts();
	    	//System.out.println("EstimateAction class : execute method : riskCategory : "+getRiskCategory());
	    	//System.out.println("EstimateAction class : execute method : planName : "+getPlanName());
	    	
	    	HashMap<String,Double> productRatioList =  (HashMap<String,Double>)sessionMap.get("productRatioList");
	    	
	    	HashMap<String,Double> productList = new HashMap<String,Double>();
	    	
	    	System.out.println("transactionType in EstimateAction : "+getTransactionType());
	    	sessionMap.put("transactionType", getTransactionType());
			logger.debug("EstimateAction class - execute method - stored transactionType : "+getTransactionType()+" in sessionMap");
			
			System.out.println(" Value of selectFolioNum has been put into sessionMap : "+getSelectFolioNum());
			sessionMap.put("selectFolioNum", getSelectFolioNum());
			sessionMap.put("upfrontInvestment", getUpfrontInvestment());
			sessionMap.put("sipAmount", getSipAmount());
			sessionMap.put("sipDuration", getSipDuration());
			sessionMap.put("sipDate", getSipDate());
			
			logger.debug("EstimateAction class - execute method - stored upfrontInvestment : "+getUpfrontInvestment()+" in sessionMap");
			logger.debug("EstimateAction class - execute method - stored sipAmount : "+getSipAmount()+" in sessionMap");
			logger.debug("EstimateAction class - execute method - stored sipDuration : "+getSipDuration()+" in sessionMap");
			logger.debug("EstimateAction class - execute method - stored sipDate : "+getSipDate()+" in sessionMap");
			
			//Double totalInvestment= 0.0;
			if ("UPFRONT".equalsIgnoreCase(getTransactionType())) {
				System.out.println("EstimateAction class : execute method : Inside UPFRONT loop .... ");
				totalInvestment = Double.toString(Double.parseDouble(getUpfrontInvestment())) ;

			}
			else {
				System.out.println("EstimateAction class : execute method : Inside SIP loop .... ");
				totalInvestment = Double.toString(Double.parseDouble(getSipAmount()));

				Calendar cal = Calendar.getInstance();
				
				String sipDate = getSipDate();
				if (sipDate.length() == 1) {
					sipDate = "0"+sipDate;
				}
				System.out.println(" sipDate : "+sipDate);
				
				/*String sipStartMonth;
				String sipEndMonth;
				
				CommonUtil commonUtil= new CommonUtil();
				
				if ( Integer.parseInt(sipDate) <=   (cal.get(Calendar.DATE)) ) {
					sipStartMonth = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? commonUtil.theMonth(0) : commonUtil.theMonth(cal.get(Calendar.MONTH)+1));
					sipEndMonth = commonUtil.theMonth(cal.get(Calendar.MONTH));
				}
				else {
					sipStartMonth = commonUtil.theMonth(cal.get(Calendar.MONTH));
					sipEndMonth = (("0".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? commonUtil.theMonth(11) : commonUtil.theMonth(cal.get(Calendar.MONTH)-1));
				}
				System.out.println(" sipEndMonth : "+sipEndMonth);
				System.out.println(" date.getYear() : "+cal.get(Calendar.YEAR));
				String sipEndYear = Integer.toString(cal.get(Calendar.YEAR)+Integer.parseInt(getSipDuration()));
				String sipStartYear = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? Integer.toString(cal.get(Calendar.YEAR)+1) : Integer.toString(cal.get(Calendar.YEAR)));
				System.out.println(" sipEndYear : "+sipEndYear);
				
				String sipStartDate = sipStartMonth+"/"+sipDate+"/"+sipStartYear;
				String sipEndDate = sipEndMonth+"/"+sipDate+"/"+sipEndYear;*/
				
				List<String> fundIds = new ArrayList<String> (productRatioList.keySet());
				QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
				
				/*boolean changeSipDate = queryPrimaryFundDetails.checkBufferDays(sipStartDate,fundIds);

				System.out.println("changeSipDate : "+changeSipDate);
				if (changeSipDate) {
					
					System.out.println("BEFORE CHANGE : sipStartMonth : "+sipStartMonth+" and sipEndMonth : "+sipEndMonth);
					sipStartMonth = (("12".equals(sipStartMonth)) ? commonUtil.theMonth(0) : commonUtil.theMonth(Integer.parseInt(sipStartMonth)));
					sipEndMonth = (("12".equals(sipEndMonth)) ? commonUtil.theMonth(0) : commonUtil.theMonth(Integer.parseInt(sipEndMonth)));
					System.out.println("AFTER CHANGE : sipStartMonth : "+sipStartMonth+" and sipEndMonth : "+sipEndMonth);
					sipStartDate = sipStartMonth+"/"+sipDate+"/"+sipStartYear;
					sipEndDate = sipEndMonth+"/"+sipDate+"/"+sipEndYear;
				}*/
				
				/*sessionMap.put("sipStartDate", sipStartDate);
				sessionMap.put("sipEndDate", sipEndDate);
				
				System.out.println(" sipStartDate : "+sipStartDate);
				System.out.println(" sipEndDate : "+sipEndDate);*/
				}
			
			System.out.println("upfrontInvestment in sessionMap is : "+getUpfrontInvestment());
			System.out.println("sipAmount in sessionMap is : "+ getSipAmount());
			System.out.println("sipDuration in sessionMap is : "+ getSipDuration());
			System.out.println("sipDate in sessionMap is : "+ getSipDate());
			
			
			
			
			
			//sessionMap.put("riskCategory", getRiskCategory());
			//sessionMap.put("planName", getPlanName());
			//sessionMap.put("totalInvestment", totalInvestment);

			//logger.debug("EstimateAction class - execute method - stored riskCategory : "+getRiskCategory()+" in sessionMap");
			//logger.debug("EstimateAction class - execute method - stored planName : "+getPlanName()+" in sessionMap");
			//logger.debug("EstimateAction class - execute method - stored totalInvestment : "+totalInvestment+" in sessionMap");

			System.out.println("EstimateAction class : execute method : upfrontInvestment : "+sessionMap.get("upfrontInvestment").toString());
			System.out.println("EstimateAction class : execute method : sip : "+sessionMap.get("sipAmount").toString()); 
    	    
    	    System.out.println("EstimateAction class : execute method : end : transactionType : "+sessionMap.get("transactionType").toString());

	   	    Iterator it = productRatioList.entrySet().iterator();

	   	    while (it.hasNext()) {
	   	        Map.Entry pair = (Map.Entry)it.next();
	   	        Double amount = ((   Double.valueOf(pair.getValue().toString()) * Double.valueOf(totalInvestment) ) /100);

	   	        productList.put(queryProduct.getSchemeName(pair.getKey().toString()), amount);
 
	   	    }
	   	    it = productList.entrySet().iterator();
	   	    
		   	 while (it.hasNext()) {
		   		Map.Entry pair = (Map.Entry)it.next();
		   		System.out.println(" Entry in productList : "+pair.getKey() + " = " + pair.getValue()); 
		   	 }
	   	 	sessionMap.put("productList", productList);
	   	 	sessionMap.put("sipFolioNum", selectFolioNum);
   	 	
	   	 	logger.debug("EstimateAction class - execute method - stored productList in sessionMap");
	   	 	
			/*String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    
    	    logger.debug("EstimateAction class - execute method - returned success");
			logger.debug("EstimateAction class - execute method - end");
			
			System.out.println("EstimateAction : execute method : transactionType : "+getTransactionType());
			
			if ("SIP".equals(getTransactionType()))  {
				return "SIP";
			}
			else {
				System.out.println("EstimateAction execute method : totalInvestment : "+getTotalInvestment());
				return "UPFRONT";
			}
    	
		} catch (MoneyBuddyException e) {	
			logger.error("EstimateAction class - execute method - Caught MoneyBuddyException");
			e.printStackTrace();
			
			/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("EstimateAction class - execute method - returned error");
    	    
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("EstimateAction class - execute method - Caught Exception");
			e.printStackTrace();
			
			/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("EstimateAction class - execute method - returned error");
    	    
			return ERROR;
		} 

    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }
    
	/*public String getTotalInvestment() {
		return totalInvestment;
	}
	public void setTotalInvestment(String totalInvestment) {
		this.totalInvestment = totalInvestment;
	}*/
	/*public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }*/

    public String getSipAmount() {
		return sipAmount;
	}

	public void setSipAmount(String sipAmount) {
		this.sipAmount = sipAmount;
	}

	public String getUpfrontInvestment() {
        
        return upfrontInvestment;
        
    }

    public void setUpfrontInvestment(String upfrontInvestment) {
        this.upfrontInvestment = upfrontInvestment;
    }

    public String getSipDuration() {
		return sipDuration;
	}

	public void setSipDuration(String sipDuration) {
		this.sipDuration = sipDuration;
	}

	public String getSipDate() {
		return sipDate;
	}

	public void setSipDate(String sipDate) {
		this.sipDate = sipDate;
	}

	/*public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }*/

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
/*
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/


	public String getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(String totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public String getSelectFolioNum() {
		return selectFolioNum;
	}

	public void setSelectFolioNum(String selectFolioNum) {
		this.selectFolioNum = selectFolioNum;
	}

	public String getSipPlan() {
		return sipPlan;
	}

	public void setSipPlan(String sipPlan) {
		this.sipPlan = sipPlan;
	}

}
