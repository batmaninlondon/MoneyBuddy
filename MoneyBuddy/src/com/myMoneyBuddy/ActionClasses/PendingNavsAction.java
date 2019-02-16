/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.ModelClasses.PendingNavOrders;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class PendingNavsAction extends ActionSupport implements Action  {

	Logger logger = Logger.getLogger(PendingNavsAction.class);
	private InputStream stream;
	//private HashMap<String,String>  pendingNavOrders ;
	private List<PendingNavOrders> pendingNavOrders;

    public String execute() {

    	try {
    		logger.debug("PendingNavsAction class - execute method - start ");
			System.out.println("Calling PendingNavsAction class - start ");
			
			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
			pendingNavOrders = queryTransactionDetails.getPendingNavsOrders();

			/*Iterator it = pendingNavOrders.entrySet().iterator();
			 
			while ( it.hasNext() )  {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println("PendingNavsAction class : execute method : key : "+pair.getKey()+" and value : "+pair.getValue());
				
			}*/
			
			System.out.println("Returning success !! ");
			logger.debug("PendingNavsAction class - execute method - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("PendingNavsAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("PendingNavsAction class - execute method - returned error");
			return ERROR;
		} 

    }
	
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public List<PendingNavOrders> getPendingNavOrders() {
		return pendingNavOrders;
	}

	public void setPendingNavOrders(List<PendingNavOrders> pendingNavOrders) {
		this.pendingNavOrders = pendingNavOrders;
	}




}
