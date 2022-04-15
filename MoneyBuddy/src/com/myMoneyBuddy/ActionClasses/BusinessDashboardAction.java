/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.myMoneyBuddy.DAOClasses.QueryBussinessData;
import com.myMoneyBuddy.ModelClasses.BusinessDashboardDataModel;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BusinessDashboardAction extends ActionSupport implements Action  {

	Logger logger = LogManager.getLogger(BusinessDashboardAction.class);
	
	private String errorMsg;
	private BusinessDashboardDataModel businessDashboardData;

    public String execute() {

    	try {
			
			QueryBussinessData queryBussinessData = new QueryBussinessData();
			businessDashboardData = queryBussinessData.getBusinessData();
			
			System.out.println("Returning success from BusinessDashboardAction !! ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("BusinessDashboardAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("BusinessDashboardAction class - execute method - returned error");
			return ERROR;
		} 

    }

	public BusinessDashboardDataModel getBusinessDashboardData() {
		return businessDashboardData;
	}

	public void setBusinessDashboardData(BusinessDashboardDataModel businessDashboardData) {
		this.businessDashboardData = businessDashboardData;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
