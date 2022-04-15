/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayDashboardAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(DisplayDashboardAction.class);
	private SessionMap<String,Object> sessionMap;
	//private InputStream stream;
	private String emailIdDashboard;
	private String errorMsg;

    public String execute() {

    	try 
    	{
    		
    		logger.debug("DisplayDashboardAction class - execute method - start ");
			System.out.println("Calling DisplayDashboardAction class - start ");
			
			System.out.println("DisplayDashboardAction emailId is : "+getEmailIdDashboard());
			
			QueryCustomer queryCustomer = new QueryCustomer();
			String customerId= Integer.toString(queryCustomer.getCustomerId(getEmailIdDashboard()));
			
			if ( "0".equals(customerId))  {
				/*setErrorMsg("EmailId does not exists!! ");*/
				addActionMessage("This email ID is not registered with MoneyBuddy");
				return "emailIdNotExist" ;
			}
			sessionMap.put("customerIdFromAdmin", customerId);
			/*QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
			pendingNavOrders = queryTransactionDetails.getPendingNavsOrders();

			Iterator it = pendingNavOrders.entrySet().iterator();
			 
			while ( it.hasNext() )  {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println("PendingNavsAction class : execute method : key : "+pair.getKey()+" and value : "+pair.getValue());
				
			}*/
			
			System.out.println("Returning success !! ");
			logger.debug("DisplayDashboardAction class - execute method - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("DisplayDashboardAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("DisplayDashboardAction class - execute method - returned error");
			return ERROR;
		} 

    }

	public String getEmailIdDashboard() {
		return emailIdDashboard;
	}

	public void setEmailIdDashboard(String emailIdDashboard) {
		this.emailIdDashboard = emailIdDashboard;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
    
    
/*	
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}


	public HashMap<String, String> getPendingNavOrders() {
		return pendingNavOrders;
	}


	public void setPendingNavOrders(HashMap<String, String> pendingNavOrders) {
		this.pendingNavOrders = pendingNavOrders;
	}
*/
}
