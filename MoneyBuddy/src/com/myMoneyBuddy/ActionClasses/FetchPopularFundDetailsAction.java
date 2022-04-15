/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class FetchPopularFundDetailsAction extends ActionSupport   {

	Logger logger = LogManager.getLogger(FetchPopularFundDetailsAction.class);
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
