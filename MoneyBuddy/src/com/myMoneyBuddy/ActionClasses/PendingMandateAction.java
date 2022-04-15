/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.ModelClasses.PendingMandateOrders;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PendingMandateAction extends ActionSupport implements Action  {

	Logger logger = LogManager.getLogger(PendingMandateAction.class);
	
	private List<PendingMandateOrders> pendingMandateOrders;

    public String execute() {

    	try {
    		logger.debug("PendingMandateAction class - execute method - start ");
			System.out.println("Calling PendingMandateAction class - start ");
			
			QueryCustomer queryCustomers = new QueryCustomer();
			pendingMandateOrders = queryCustomers.getPendingMandate();

			/*Iterator it = pendingNavOrders.entrySet().iterator();
			 
			while ( it.hasNext() )  {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println("PendingNavsAction class : execute method : key : "+pair.getKey()+" and value : "+pair.getValue());
				
			}*/
			
			System.out.println("Returning success !! ");
			logger.debug("PendingMandateAction class - execute method - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("PendingMandateAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("PendingMandateAction class - execute method - returned error");
			return ERROR;
		} 

    }

	public List<PendingMandateOrders> getPendingMandateOrders() {
		return pendingMandateOrders;
	}

	public void setPendingMandateOrders(List<PendingMandateOrders> pendingMandateOrders) {
		this.pendingMandateOrders = pendingMandateOrders;
	}
	

}
