/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class FetchPopularFundDetailsAction extends ActionSupport   {

	Logger logger = Logger.getLogger(FetchPopularFundDetailsAction.class);
	private List<FundDetailsDataModel> popularFundDetailsDataModel;
	
    public String execute() {
  	
    	try {
    		logger.debug("FetchPopularFundDetailsAction class - execute method - start");
			System.out.println("Calling FetchPopularFundDetailsAction class - start ");
			
			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();

			popularFundDetailsDataModel = queryPrimaryFundDetails.getPopularFundDetailsData();

			/*for ( int i =0 ; i<popularFundDetailsDataModel.size() ; i++)  {
				
				System.out.println("popularFundDetailsDataModel : i: "+i+" : fundId : "+popularFundDetailsDataModel.get(i).getFundId()+" : Return1yr : "+popularFundDetailsDataModel.get(i).getReturnsOneYear());
				
			}*/
    	    
    	    logger.debug("FetchPopularFundDetailsAction class - execute method - returned success");
    	    logger.debug("FetchPopularFundDetailsAction class - execute method - end");
    	    
			return SUCCESS;
		} 
    	catch (Exception e) {	
    		logger.error("FetchPopularFundDetailsAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("FetchPopularFundDetailsAction class - execute method - returned error");
    	    
			return ERROR;
		} 

    }

	public List<FundDetailsDataModel> getPopularFundDetailsDataModel() {
		return popularFundDetailsDataModel;
	}


	public void setPopularFundDetailsDataModel(List<FundDetailsDataModel> popularFundDetailsDataModel) {
		this.popularFundDetailsDataModel = popularFundDetailsDataModel;
	}





}
