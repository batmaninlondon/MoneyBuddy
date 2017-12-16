/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.PortfolioDataModel;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class PortfolioAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(PortfolioAction.class);
	private Map<String, Object> session;

	private List<PortfolioDataModel> portfolioDataModel;
	private String dummyMsg;
	
	private InputStream stream;

	public String execute() {

		try {
		logger.debug("PortfolioAction class : execute method : start");
		dummyMsg = "Portfolio representation";

		QueryProducts queryProducts = new QueryProducts();
		/*dashboardDataModel = queryProducts.getDashboardData(sessionMap.get("customerId").toString(),investmentTypeName);*/
		
		System.out.println("portfolio action class called - start ");

		//session.remove("portfolioDataModel");
		portfolioDataModel = queryProducts.getPortfolioData(session.get("customerId").toString());
		setPortfolioDataModel(portfolioDataModel);
		//session.put("portfolioDataModel", null);
		session.put("portfolioDataModel", portfolioDataModel);
		logger.debug("PortfolioAction class : execute method : stored portfolioDataModel in session id : "+session.getClass().getName());

		/*Double TotalInvestedAmount = 0.0;
		Double TotalCurrentAmount = 0.0;
		for ( PortfolioDataModel portfolioDataModelElement : portfolioDataModel )  {
			
			
			TotalInvestedAmount = TotalInvestedAmount + Double.parseDouble(portfolioDataModelElement.getInvestedAmount());
			TotalCurrentAmount = TotalCurrentAmount + Double.parseDouble(portfolioDataModelElement.getCurrentAmount());
		}
		
		Double TotalrateOfGrowth = ((TotalCurrentAmount - TotalInvestedAmount)/TotalInvestedAmount)*100;
	
		
		session.put("TotalInvestedAmount", String.format("%.2f", TotalInvestedAmount));
		logger.debug("PortfolioAction class : execute method : stored TotalInvestedAmount in session id : "+session.getClass().getName());

		session.put("TotalCurrentAmount", String.format("%.2f", TotalCurrentAmount));
		logger.debug("PortfolioAction class : execute method : stored TotalCurrentAmount in session id : "+session.getClass().getName());
		
		session.put("TotalrateOfGrowth", String.format("%.2f", TotalrateOfGrowth));
		logger.debug("PortfolioAction class : execute method : stored TotalrateOfGrowth in session id : "+session.getClass().getName());
		
		System.out.println("Vivek printing session information "+session.get("portfolioDataModel"));
		System.out.println("portfolio action class called - end ");*/
		
		logger.debug("PortfolioAction class : execute method : end");

		String str = "success";
    	stream = new ByteArrayInputStream(str.getBytes());
    	
		return SUCCESS;
		}
		catch (MoneyBuddyException e) {	
			logger.debug("PortfolioAction class : execute method : Caught MoneyBuddyException for customerId : "+session.get("customerId").toString());
			e.printStackTrace();
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("PortfolioAction class : execute method : Caught Exception for customerId : "+session.get("customerId").toString());
			e.printStackTrace();
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
	}


	public List<PortfolioDataModel> getPortfolioDataModel() {
		return portfolioDataModel;
	}

	public void setPortfolioDataModel(
			List<PortfolioDataModel> pMdl) {
		this.portfolioDataModel = pMdl;
	}

	public String getDummyMsg() {
		return dummyMsg;
	}

	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

}
