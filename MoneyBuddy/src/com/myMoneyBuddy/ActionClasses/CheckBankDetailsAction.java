/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.myMoneyBuddy.DAOClasses.QueryBankDetails;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class CheckBankDetailsAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(CheckBankDetailsAction.class);
	private SessionMap<String,Object> sessionMap;
    
    private String respMsg;
    private String tranDetailId;
    private String selectedBankName;
    private String selectedAccType;
    private String selectedAccNum;
    private String selectedIfscCode;
    private String displayAccType ;
    private String displayBankName;
	
    public String execute() {
    	
    	String customerId = null;
    	try {
    		customerId = sessionMap.get("customerId").toString();
    		
    		if (customerId == null || "".equals(customerId))  {
    			
    			throw new MoneyBuddyException("customerId is not set ");
    		}
    		
    		logger.debug("CheckBankDetailsAction class - execute method - customerId - "+customerId+" - start ");
    		
	    	System.out.println(" CheckBankDetailsAction execute method Called !!");
	    	System.out.println("tranDetailId : "+getTranDetailId());
	    	
	    	//tranDetailId = ServletActionContext.getRequest().getParameter("tranDetailId");
	    	
	    	
	    	/* HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	    	    String idUser = request.getParameter("tranDetailId");
	    	    System.out.println(" idUser : "+idUser);*/
	    	    
	    	    
	    	//System.out.println("tranDetailId from request set to : "+tranDetailId);
	    	setTranDetailId(getTranDetailId());
	    	
	    	logger.debug("CheckBankDetailsAction class - execute method - customerId - "+customerId+" - tranDetailId set to - "+getTranDetailId());
	    	
	    	System.out.println(" tranDetailId set to : "+getTranDetailId());
   		
	    	setRespMsg("bankDetailsNotExists");
	    	
	    		QueryBankDetails queryBankDetails = new QueryBankDetails();
	    		
	    		boolean bankDetailsExists = queryBankDetails.existsBankDetails(customerId);
	    		
	    		if (bankDetailsExists)  {
	    			
	    			BankDetails bankDetails = queryBankDetails.fetchBankDetails(customerId);
	    			
	    			String bankName = bankDetails.getBankName();
	    			
	    			switch (bankName)  {
	    				case "ICI" :
	    					displayBankName = "ICICI Bank";
	    					break;
	    				case "SBI" :
	    					displayBankName = "SBI Bank";
	    					break;
	    				case "HDF" :
	    					displayBankName = "HDFC Bank";
	    					break;
	    				case "162" :
	    					displayBankName = "KOTAK Bank";
	    					break;
	    				case "UTI" :
	    					displayBankName = "Axis Bank";
	    					break;
	    				case "PNB" :
	    					displayBankName = "Punjab National Bank";
	    					break;
	    				case "SIB" :
	    					displayBankName = "South Indian Bank";
	    					break;
	    				case "SCB" :
	    					displayBankName = "Standard Chartered Bank";
	    					break;
	    				case "UBI" :
	    					displayBankName = "Union Bank Of India";
	    					break;
	    				case "UNI" :
	    					displayBankName = "United Bank Of India";
	    					break;
	    				case "YBK" :
	    					displayBankName = "Yes Bank Ltd";
	    					break;
	    				case "RBL" :
	    					displayBankName = "Ratnakar Bank";
	    					break;
	    				case "DCB" :
	    					displayBankName = "DCB";
	    					break;
	    			
	    			}
	    			
	    			String accType = bankDetails.getAccountType();
	    			
	    			switch (accType)  {
	    				case "CB" :
	    					displayAccType = "Current Account";
	    					break;
	    				case "SB" :
	    					displayAccType = "Saving Account";
	    					break;
	    				case "NE" :
	    					displayAccType = "NRI - Repatriable (NRE)";
	    					break;
	    				default :
	    					displayAccType = "NRI - Repatriable (NRO)";
	    					break;
	    			
	    			}
	    			
	    			DesEncrypter desEncrypter = new DesEncrypter();
	    			System.out.println("Acc num m: "+bankDetails.getAccountNumber());
	    			String accNum = desEncrypter.decrypt(bankDetails.getAccountNumber());
	    							
	    			setSelectedBankName(bankDetails.getBankName());
	    			setDisplayBankName(displayBankName);
	    			setSelectedAccType(bankDetails.getAccountType());
	    			setDisplayAccType(displayAccType);
	    			setSelectedAccNum(accNum);
	    			setSelectedIfscCode(bankDetails.getIfscCode());
	    			
	    			setRespMsg("bankDetailsExists");
	    		}
	    		
	    	   
		    	logger.debug("CheckBankDetailsAction class - execute method - customerId - "+customerId+" - end");

		    	logger.debug("CheckBankDetailsAction class - execute method - customerId - "+customerId+" - respMsg set to - "+getRespMsg());
		    	
	    		return SUCCESS;


    	}
    	catch ( MoneyBuddyException e )  {
    		logger.error("CheckBankDetailsAction class - execute method - customerId - "+customerId+" - Caught MoneyBuddyException");
    	    logger.error("CheckBankDetailsAction class - execute method - customerId - "+customerId+" - returned error");

    		return ERROR;
    	}
    	catch ( Exception e )  {
    		logger.error("CheckBankDetailsAction class - execute method - customerId - "+customerId+" - Caught Exception");
    	    logger.error("CheckBankDetailsAction class - execute method - customerId - "+customerId+" - returned error");

    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getSelectedBankName() {
		return selectedBankName;
	}

	public void setSelectedBankName(String selectedBankName) {
		this.selectedBankName = selectedBankName;
	}

	public String getSelectedAccType() {
		return selectedAccType;
	}

	public void setSelectedAccType(String selectedAccType) {
		this.selectedAccType = selectedAccType;
	}

	public String getSelectedAccNum() {
		return selectedAccNum;
	}

	public void setSelectedAccNum(String selectedAccNum) {
		this.selectedAccNum = selectedAccNum;
	}

	public String getSelectedIfscCode() {
		return selectedIfscCode;
	}

	public void setSelectedIfscCode(String selectedIfscCode) {
		this.selectedIfscCode = selectedIfscCode;
	}

	public String getDisplayAccType() {
		return displayAccType;
	}

	public void setDisplayAccType(String displayAccType) {
		this.displayAccType = displayAccType;
	}

	public String getDisplayBankName() {
		return displayBankName;
	}

	public void setDisplayBankName(String displayBankName) {
		this.displayBankName = displayBankName;
	}

	public String getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(String tranDetailId) {
		this.tranDetailId = tranDetailId;
	}

}
