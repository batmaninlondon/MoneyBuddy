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
import java.util.Calendar;
import java.util.Date;
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
    private String sipAmount;
    private String sipDuration; // in years
    private String sipDate;
    private String riskCategory;
    private String planName;
    private String totalInvestment;
    //private String numberOfYears;

/*    String predictedValueForOneYear;
    String predictedValueForThreeYear;
    String predictedValueForFiveYear;*/
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
			
			upfrontInvestment = Double.toString(Math.round( Double.parseDouble(getUpfrontInvestment()) * 100.0 ) / 100.0);
			sipAmount = Double.toString(Math.round( Double.parseDouble(getSipAmount()) * 100.0 ) / 100.0); 

			PredictedValueCalculation calculatedValue = new PredictedValueCalculation();
			
    	    
	    	QueryProducts queryProduct = new QueryProducts();
	    	System.out.println("EstimateAction class : execute method : riskCategory : "+getRiskCategory());
	    	System.out.println("EstimateAction class : execute method : planName : "+getPlanName());
	    	
	    	// Changes to generate productList at the click of "try it out" button in myIndex page - start
	    	
	   	 	//HashMap<String,Double> productList = queryProduct.getProductList(getRiskCategory(),getPlanName());
	    	
	    	HashMap<String,Double> productRatioList =  (HashMap<String,Double>)sessionMap.get("productRatioList");
	    	
	    	HashMap<String,Double> productList = new HashMap<String,Double>();
	    			
	    	// Changes to generate productList at the click of "try it out" button in myIndex page - end
	   	 	
	    	//System.out.println("FetchProductListAction Hi There 1 ");
	   	 

	   	 
			if (Double.parseDouble(getSipAmount()) == 0 ) {
				totalInvestment = Double.toString(Double.parseDouble(getUpfrontInvestment())) ;
				
				predictedValueList.put(1, calculatedValue.predictedAmount(Double.parseDouble(getUpfrontInvestment()), getRiskCategory(), 1,getPlanName()));    
				predictedValueList.put(3, calculatedValue.predictedAmount(Double.parseDouble(getUpfrontInvestment()), getRiskCategory(), 3,getPlanName()));    
				predictedValueList.put(5, calculatedValue.predictedAmount(Double.parseDouble(getUpfrontInvestment()), getRiskCategory(), 5,getPlanName()));    
				
				sessionMap.put("predictedValueList1", Double.toString(predictedValueList.get(1)));
				sessionMap.put("predictedValueList3", Double.toString(predictedValueList.get(3)));
				sessionMap.put("predictedValueList5", Double.toString(predictedValueList.get(5)));
				logger.debug("EstimateAction class : execute method : stored predictedValueList1 : "+predictedValueList.get(1)+" in session id : "+sessionMap.getClass().getName());
				logger.debug("EstimateAction class : execute method : stored predictedValueList3 : "+predictedValueList.get(3)+" in session id : "+sessionMap.getClass().getName());
				logger.debug("EstimateAction class : execute method : stored predictedValueList5 : "+predictedValueList.get(5)+" in session id : "+sessionMap.getClass().getName());
			
			}
			else {
				//totalInvestment = Double.toString( (Double.parseDouble(getSipAmount())* Integer.parseInt(getSipDuration())*12)+Double.parseDouble(getSipAmount()) );
				totalInvestment = Double.toString( Double.parseDouble(getSipAmount()));
				predictedValueList = calculatedValue.predictedSipAmountList(Double.parseDouble(getSipAmount()), getRiskCategory(), getPlanName());
				sessionMap.put("predictedValueList1", Double.toString(predictedValueList.get(1)));
				sessionMap.put("predictedValueList3", Double.toString(predictedValueList.get(3)));
				sessionMap.put("predictedValueList5", Double.toString(predictedValueList.get(5)));
				logger.debug("EstimateAction class : execute method : stored predictedValueList1 : "+predictedValueList.get(1)+" in session id : "+sessionMap.getClass().getName());
				logger.debug("EstimateAction class : execute method : stored predictedValueList3 : "+predictedValueList.get(3)+" in session id : "+sessionMap.getClass().getName());
				logger.debug("EstimateAction class : execute method : stored predictedValueList5 : "+predictedValueList.get(5)+" in session id : "+sessionMap.getClass().getName());
			}
			sessionMap.put("upfrontInvestment", getUpfrontInvestment());
			sessionMap.put("sipAmount", getSipAmount());
			sessionMap.put("sipDuration", getSipDuration());
			sessionMap.put("sipDate", getSipDate());
			
			Calendar cal = Calendar.getInstance();

			//DateTime datetime = new DateTime(date);
			String sipDate = getSipDate();
			if (sipDate.length() == 1) {
				sipDate = "0"+sipDate;
			}
			System.out.println(" sipDate : "+sipDate);
			String sipStartMonth = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? theMonth(0) : theMonth(cal.get(Calendar.MONTH)+1));
			String sipEndMonth = theMonth(cal.get(Calendar.MONTH));
			System.out.println(" sipEndMonth : "+sipEndMonth);
			System.out.println(" date.getYear() : "+cal.get(Calendar.YEAR));
			String sipEndYear = Integer.toString(cal.get(Calendar.YEAR)+Integer.parseInt(getSipDuration()));
			String sipStartYear = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? Integer.toString(cal.get(Calendar.YEAR)+1) : Integer.toString(cal.get(Calendar.YEAR)));
			System.out.println(" sipEndYear : "+sipEndYear);
			String sipStartDate = sipStartMonth+"/"+sipDate+"/"+sipStartYear;
			String sipEndDate = sipEndMonth+"/"+sipDate+"/"+sipEndYear;
			sessionMap.put("sipStartDate", sipStartDate);
			sessionMap.put("sipEndDate", sipEndDate);
			
			System.out.println(" sipStartDate : "+sipStartDate);
			System.out.println(" sipEndDate : "+sipEndDate);
			
			sessionMap.put("riskCategory", getRiskCategory());
			sessionMap.put("planName", getPlanName());
			sessionMap.put("totalInvestment", totalInvestment);
			
			System.out.println("predictedValueList.get(1) : "+predictedValueList.get(1));
			System.out.println("predictedValueList.get(3) : "+predictedValueList.get(3));
			System.out.println("predictedValueList.get(5) : "+predictedValueList.get(5));
			

			logger.debug("EstimateAction class : execute method : stored upfrontInvestment : "+getUpfrontInvestment()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored sipAmount : "+getSipAmount()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored sipDuration : "+getSipDuration()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored sipDate : "+getSipDate()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored riskCategory : "+getRiskCategory()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored planName : "+getPlanName()+" in session id : "+sessionMap.getClass().getName());
			logger.debug("EstimateAction class : execute method : stored totalInvestment : "+totalInvestment+" in session id : "+sessionMap.getClass().getName());

			//System.out.println("EstimateAction class : execute method : years : "+sessionMap.get("years").toString());
			System.out.println("EstimateAction class : execute method : upfrontInvestment : "+sessionMap.get("upfrontInvestment").toString());
			System.out.println("EstimateAction class : execute method : sip : "+sessionMap.get("sipAmount").toString()); 
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    
    	    System.out.println("EstimateAction class : execute method : end : transactionType : "+sessionMap.get("transactionType").toString());

	   	    Iterator it = productRatioList.entrySet().iterator();
	   	    String productName;
	   	    String key;
	   	    while (it.hasNext()) {
	   	        Map.Entry pair = (Map.Entry)it.next();
	   	        Double amount = ((   Double.valueOf(pair.getValue().toString()) * Double.valueOf(totalInvestment) ) /100);
	   	        //pair.setValue(amount);
	   	        
	   	        productList.put(pair.getKey().toString(), amount);

	   	        
	   	    }
	   	    it = productList.entrySet().iterator();
		   	 while (it.hasNext()) {
		   		Map.Entry pair = (Map.Entry)it.next();
		   		System.out.println(" Entry in productList : "+pair.getKey() + " = " + pair.getValue()); 
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


	public static String theMonth(int month){
	    String[] monthNames = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	    return monthNames[month];
	}

}
