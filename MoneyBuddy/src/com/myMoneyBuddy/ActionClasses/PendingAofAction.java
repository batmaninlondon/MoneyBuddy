/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.ModelClasses.PendingAofOrders;
import com.myMoneyBuddy.ModelClasses.PendingMandateOrders;
import com.myMoneyBuddy.ModelClasses.PendingNavOrders;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class PendingAofAction extends ActionSupport implements Action  {

	Logger logger = Logger.getLogger(PendingAofAction.class);
	
	private List<PendingAofOrders> pendingAofOrders;

    public String execute() {

    	try {
    		logger.debug("PendingAofAction class - execute method - start ");
			System.out.println("Calling PendingAofAction class - start ");
			
			QueryCustomer queryCustomers = new QueryCustomer();
			pendingAofOrders = queryCustomers.getPendingAof();

			/*Iterator it = pendingNavOrders.entrySet().iterator();
			 
			while ( it.hasNext() )  {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println("PendingNavsAction class : execute method : key : "+pair.getKey()+" and value : "+pair.getValue());
				
			}*/
			
			System.out.println("Returning success !! ");
			logger.debug("PendingAofAction class - execute method - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("PendingAofAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("PendingAofAction class - execute method - returned error");
			return ERROR;
		} 

    }

	public List<PendingAofOrders> getPendingAofOrders() {
		return pendingAofOrders;
	}

	public void setPendingAofOrders(List<PendingAofOrders> pendingAofOrders) {
		this.pendingAofOrders = pendingAofOrders;
	}

}
