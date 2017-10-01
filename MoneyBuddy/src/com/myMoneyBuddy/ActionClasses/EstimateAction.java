/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class EstimateAction extends ActionSupport implements SessionAware  {

	
	
	Logger logger = Logger.getLogger(EstimateAction.class);
	private Map<String, Object> sessionMap;
	
	private String upfrontInvestment;
    private String sip;
    //private String years;
    private String riskCategory;
    private String planName;
    private String totalInvestment;
    //private String numberOfYears;

    String predictedValueForOneYear;
    String predictedValueForThreeYear;
    String predictedValueForFiveYear;
    HashMap<Integer,Double> predictedValueList = new HashMap<Integer,Double>();
    String regexDecimal = "(\\d+(?:\\.\\d+)?)";
    Pattern patternDecimal = Pattern.compile(regexDecimal);
    
    private InputStream stream;

    /*public void validate() {
    	
    	System.out.println("Estimate Action class called..");
    	
    	System.out.println("Estimate Action class : upfrontInvestment : "+upfrontInvestment);
    	System.out.println("Estimate Action class : sip : "+sip);
    	System.out.println("Estimate Action class : years : "+years);
    	System.out.println("Estimate Action class : riskCategory : "+riskCategory);
    	System.out.println("Estimate Action class : planName : "+planName);
    	
    	
    	logger.debug("EstimateAction class : validate method : start");
    	
        if ( StringUtils.isEmpty(getUpfrontInvestment()) )
            addFieldError("upfrontInvestment","value of upfrontInvestment can't be blank");
        else if(!patternDecimal.matcher(getUpfrontInvestment()).matches())
            addFieldError("upfrontInvestment","Please enter a valid amount.");
        else if ( StringUtils.isEmpty(getSip()) )
            addFieldError("sip","value of sip can't be blank");
        else if(!patternDecimal.matcher(getSip()).matches())
            addFieldError("sip","Please enter a valid amount.");
        else if ( StringUtils.isEmpty(getYears()) )
            addFieldError("years","value of years can't be blank");
        
        logger.debug("EstimateAction class : validate method : end");
    }
*/    public String execute() {
    	
		System.out.println("EstimateAction class : execute method : transactionType : "+sessionMap.get("transactionType").toString());
		
	
    	logger.debug("EstimateAction class : execute method : start");
    	
    	try {
    		
    		//System.out.println("numberOfYears "+numberOfYears);
			
			upfrontInvestment = Double.toString(Math.round( Double.parseDouble(upfrontInvestment) * 100.0 ) / 100.0);
			sip = Double.toString(Math.round( Double.parseDouble(sip) * 100.0 ) / 100.0); 
			
			PredictedValueCalculation calculatedValue = new PredictedValueCalculation();
			
    	    
	    	QueryProducts queryProduct = new QueryProducts();
	    	System.out.println("LoginAction class : execute method : riskCategory : "+getRiskCategory());
	    	System.out.println("LoginAction class : execute method : planName : "+getPlanName());
	   	 	HashMap<String,Double> productList = queryProduct.getProductList(getRiskCategory(),getPlanName());
	   	 	
	    	//System.out.println("FetchProductListAction Hi There 1 ");
	   	 

	   	 
			if (Double.parseDouble(getSip()) == 0 ) {
				totalInvestment = Double.toString(Double.parseDouble(upfrontInvestment)) ;
				
				predictedValueForOneYear = Double.toString(calculatedValue.predictedAmount(Double.parseDouble(getUpfrontInvestment()), getRiskCategory(), 1,getPlanName()));    
				sessionMap.put("predictedValueForOneYear", predictedValueForOneYear);
				logger.debug("EstimateAction class : execute method : stored predictedValue : "+predictedValueForOneYear+" in session id : "+sessionMap.getClass().getName());
			
				predictedValueForThreeYear = Double.toString(calculatedValue.predictedAmount(Double.parseDouble(getUpfrontInvestment()), getRiskCategory(), 3,getPlanName()));    
				sessionMap.put("predictedValueForThreeYear", predictedValueForThreeYear);
				logger.debug("EstimateAction class : execute method : stored predictedValue : "+predictedValueForThreeYear+" in session id : "+sessionMap.getClass().getName());
			
				predictedValueForFiveYear = Double.toString(calculatedValue.predictedAmount(Double.parseDouble(getUpfrontInvestment()), getRiskCategory(), 5,getPlanName()));    
				sessionMap.put("predictedValueForFiveYear", predictedValueForFiveYear);
				logger.debug("EstimateAction class : execute method : stored predictedValue : "+predictedValueForFiveYear+" in session id : "+sessionMap.getClass().getName());
			
			}
			else {
				totalInvestment = Double.toString( Double.parseDouble(sip) );
				predictedValueList = calculatedValue.predictedSipAmountList(Double.parseDouble(getSip()), getRiskCategory(), getPlanName());
				sessionMap.put("predictedValueList1", Double.toString(predictedValueList.get(1)));
				sessionMap.put("predictedValueList3", Double.toString(predictedValueList.get(3)));
				sessionMap.put("predictedValueList5", Double.toString(predictedValueList.get(5)));
				logger.debug("EstimateAction class : execute method : stored predictedValueList1 : "+predictedValueList.get(1)+" in session id : "+sessionMap.getClass().getName());
				logger.debug("EstimateAction class : execute method : stored predictedValueList3 : "+predictedValueList.get(3)+" in session id : "+sessionMap.getClass().getName());
				logger.debug("EstimateAction class : execute method : stored predictedValueList5 : "+predictedValueList.get(5)+" in session id : "+sessionMap.getClass().getName());
			}
			sessionMap.put("upfrontInvestment", getUpfrontInvestment());
			sessionMap.put("sip", getSip());
			//sessionMap.put("years", getYears());
			sessionMap.put("riskCategory", getRiskCategory());
			sessionMap.put("planName", getPlanName());
			sessionMap.put("totalInvestment", totalInvestment);
			
			System.out.println("predictedValueList.get(1) : "+predictedValueList.get(1));
			System.out.println("predictedValueList.get(3) : "+predictedValueList.get(3));
			System.out.println("predictedValueList.get(5) : "+predictedValueList.get(5));
			

			logger.debug("EstimateAction class : execute method : stored upfrontInvestment : "+getUpfrontInvestment()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored sip : "+getSip()+" in session id : "+sessionMap.getClass().getName());
			//logger.debug("EstimateAction class : execute method : stored years : "+getYears()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored riskCategory : "+getRiskCategory()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored planName : "+getPlanName()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored totalInvestment : "+totalInvestment+" in session id : "+sessionMap.getClass().getName());

			
			System.out.println("Estimate Action class : predictedValueForOneYear : "+predictedValueForOneYear);
			System.out.println("Estimate Action class : predictedValueForThreeYear : "+predictedValueForThreeYear);
			System.out.println("Estimate Action class : predictedValueForFiveYear : "+predictedValueForFiveYear);
			//System.out.println("EstimateAction class : execute method : years : "+sessionMap.get("years").toString());
			System.out.println("EstimateAction class : execute method : upfrontInvestment : "+sessionMap.get("upfrontInvestment").toString());
			System.out.println("EstimateAction class : execute method : sip : "+sessionMap.get("sip").toString());
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    
    	    System.out.println("EstimateAction class : execute method : end : transactionType : "+sessionMap.get("transactionType").toString());

	   	    Iterator it = productList.entrySet().iterator();
	   	    String productName;
	   	    String key;
	   	    while (it.hasNext()) {
	   	        Map.Entry pair = (Map.Entry)it.next();
	   	        Double amount = ((   Double.valueOf(pair.getValue().toString()) * Double.valueOf(totalInvestment) ) /100);
	   	        pair.setValue(amount);

	   	        
	   	    }
	   	    it = productList.entrySet().iterator();
		   	 while (it.hasNext()) {
		   		Map.Entry pair = (Map.Entry)it.next();
		   		System.out.println(pair.getKey() + " = " + pair.getValue()); 
		   	 }
	   	 	sessionMap.put("productList", productList);
   	 	
	   	 	logger.debug("EstimateAction class : execute method : stored productList in session id : "+sessionMap.getClass().getName());

			logger.debug("EstimateAction class : execute method : end");
			return SUCCESS;
		} catch (MoneyBuddyException e) {	
			logger.debug("EstimateAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
			logger.debug("EstimateAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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
	public String getTotalInvestment() {
		return totalInvestment;
	}
	public void setTotalInvestment(String totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
	public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }


/*    public String getPredictedValue() {
        return predictedValue;
        
    }

    public void setPredictedValue(String predictedValue) {
        this.predictedValue = predictedValue;
    }*/

    public String getPredictedValueForOneYear() {
		return predictedValueForOneYear;
	}

	public void setPredictedValueForOneYear(String predictedValueForOneYear) {
		this.predictedValueForOneYear = predictedValueForOneYear;
	}

	public String getPredictedValueForThreeYear() {
		return predictedValueForThreeYear;
	}

	public void setPredictedValueForThreeYear(String predictedValueForThreeYear) {
		this.predictedValueForThreeYear = predictedValueForThreeYear;
	}

	public String getPredictedValueForFiveYear() {
		return predictedValueForFiveYear;
	}

	public void setPredictedValueForFiveYear(String predictedValueForFiveYear) {
		this.predictedValueForFiveYear = predictedValueForFiveYear;
	}

	public String getSip() {
        
        return sip;
        
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public String getUpfrontInvestment() {
        
        return upfrontInvestment;
        
    }

    public void setUpfrontInvestment(String upfrontInvestment) {
        this.upfrontInvestment = upfrontInvestment;
    }
/*
    public String getYears() {
        
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }*/

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}



}
