/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.myMoneyBuddy.DAOClasses.QueryAdditionalCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.QuerySipDetails;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.DAOClasses.InsertBankDetails;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class PaymentAction extends ActionSupport implements SessionAware {

	Logger logger = Logger.getLogger(PaymentAction.class);
	private SessionMap<String,Object> sessionMap;
	private String accountType;
	private String accountNumber;
	private String neftCode;
	private String bankName;
	private String tranDetailId;
	private InputStream stream;
	   
    public String execute()  {

    	String CLIENT_HOLDING = "SI"; // Considering Single account
    	String str = null;
    	String customerId = null;
    	
    	try {
    		   
    		customerId = sessionMap.get("customerId").toString();
    		
    		String transactionType = null;
    		TransactionDetails transactionDetails = null;
    		if ("NotSet".equals(getTranDetailId()))  {
    			transactionType = sessionMap.get("transactionType").toString();
    		}
    		else {
    			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
    			transactionDetails = queryTransactionDetails.getTransactionDetails(getTranDetailId());
    			transactionType = transactionDetails.getTransactionType();
    		}
    		System.out.println("Payment Action class : execute method : transactionType : "+transactionType);

		    QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);

	    	QueryProducts queryProducts = new QueryProducts();
	    	Map<String, Double> productDetailsMapForBuy = new HashMap<String, Double>();

	    	InsertBankDetails bankDetails = new InsertBankDetails();
	    	bankDetails.insertBankDetail(customerId, getBankName(), getAccountType(), getAccountNumber(), getNeftCode());

	    	Trading trading = new Trading();
	    	
	    	String bseClientCreatedStatus = customer.getBseClientCreated();
	    	
	    	if ("N".equals(bseClientCreatedStatus))  {
	    		
	    		QueryCustomerDetails queryCustomerDetails = new QueryCustomerDetails();
	    		CustomerDetails customerDetails = queryCustomerDetails.getCustomerDetails(customerId);
	    		
		    	String ucc = trading.createClient(CLIENT_HOLDING, customerDetails.getTaxStatus(), customerDetails.getOccupation(), customerDetails.getDateOfBirth(),
		    			customerDetails.getGender(), "", getAccountType(), getAccountNumber(), getNeftCode(),
		    			customerDetails.getAddressLineOne()+" "+customerDetails.getAddressLineTwo()+" "+customerDetails.getAddressLineThree(), customerDetails.getResidentialCity(), 
		    			customerDetails.getResidentialState(), customerDetails.getResidentialPin(), customerDetails.getResidentialCountry(),
					customerId, customer.getCustomerName(), customer.getEmailId(), customer.getPanCard(), customer.getMobileNumber());
			
		    	String[] uccSpilts = ucc.split("\\|");
		    	
		    	System.out.println("uccSpilts[0] : "+uccSpilts[0]);
		    	
		    	if(uccSpilts[0].equals("100") ) {
		    		
		    		if(uccSpilts[1].contains("SUCCESSFULLY") ) {
			    		
			    		UpdateCustomer updateCustomer = new UpdateCustomer();
			    		updateCustomer.updateBseClientCreationStatus(customerId, "Y");
			    		bseClientCreatedStatus = "Y";
		    		}
		    		
		    	}
	    	
	    	}
	    	
	    	
		if("Y".equals(bseClientCreatedStatus)) {
			String paymentUrl = null;
			
			String amount;
			System.out.println("transactionType : "+transactionType);
			if ("UPFRONT".equals(transactionType))  {
				
				if ("NotSet".equals(getTranDetailId()))    {
					List<CustomerCart> customerCartList = (List<CustomerCart>) sessionMap.get("customerCartList");
					for (int i =0 ; i< customerCartList.size() ;i++) {
			    		System.out.println("Value of i is : "+i+" customerCartList.get(i).getProductName : "+customerCartList.get(i).getProductName());
			    		if ( !"Total".equals(customerCartList.get(i).getProductName()))  {
			    			productDetailsMapForBuy.put(customerCartList.get(i).getProductId(), Double.parseDouble(customerCartList.get(i).getAmount()));
			    		}
			    	}
				}
				else {
					productDetailsMapForBuy.put(transactionDetails.getProductId(), Double.parseDouble(transactionDetails.getTransactionAmount()));
				}
				
		    	paymentUrl = trading.executeTrade(customerId, productDetailsMapForBuy,
						"NEW",null,null,null,transactionType,"BUY",0,getAccountNumber(),getBankName(),getNeftCode(),getBankMode(getBankName()),"Y",
						"Customer bought some mutual funds",null,getTranDetailId(), sessionMap);
		    	
			}
			else {
				
				String sipDate = null;
				String sipStartDate = null;
				String sipEndDate = null;
				String sipDuration= null;
				if ("NotSet".equals(getTranDetailId()))    {
					amount = sessionMap.get("sipAmount").toString();
					sipDate = sessionMap.get("sipDate").toString();
					sipStartDate = sessionMap.get("sipStartDate").toString();
					sipEndDate = sessionMap.get("sipEndDate").toString();
					sipDuration = sessionMap.get("sipDuration").toString();
					
					productDetailsMapForBuy = queryProducts.getProductAmountList((HashMap<String,Double>)sessionMap.get("productRatioList"),
			    			Double.parseDouble(amount));
				}
				else {
					amount = transactionDetails.getTransactionAmount();
					QuerySipDetails querySipDetails = new QuerySipDetails();
					SipDetails sipDetails = querySipDetails.getSipDetails(getTranDetailId());
					sipDate = sipDetails.getSipDate();
					sipStartDate = sipDetails.getSipStartDate();
					sipEndDate = sipDetails.getSipEndDate();
					
					System.out.println("Before change : sipStartDate : "+sipStartDate+" and sipEndDate : "+sipEndDate);
					sipStartDate = sipStartDate.substring(5,7)+"/"+sipStartDate.substring(8,10)+"/"+sipStartDate.substring(0,4);
					sipEndDate = sipEndDate.substring(5,7)+"/"+sipEndDate.substring(8,10)+"/"+sipEndDate.substring(0,4);
					System.out.println("After change : sipStartDate : "+sipStartDate+" and sipEndDate : "+sipEndDate);
					
					
					sipDuration= sipDetails.getSipDuration();
					
					productDetailsMapForBuy.put(transactionDetails.getProductId(), Double.parseDouble(transactionDetails.getTransactionAmount()));
				}
				
				String mandateId = customer.getIsipMandateId();

				if ( "NOT_GENERATED".equals(mandateId))  {
					String mandateIdResponse = trading.generateMandateId(customerId, amount, "I", getAccountNumber(), getAccountType(), getNeftCode(), 
							sipStartDate, sipEndDate);
					
					String[] mandateIdResponseSpilts = mandateIdResponse.split("\\|"); 
			    	
			    	System.out.println("mandateIdResponseSpilts[0] : "+mandateIdResponseSpilts[0]);
			    	System.out.println("mandateIdResponseSpilts[1] : "+mandateIdResponseSpilts[1]);
			    	System.out.println("mandateIdResponseSpilts[2] : "+mandateIdResponseSpilts[2]);
			    	
			    	mandateId = mandateIdResponseSpilts[2];
				}
		    	
		    	System.out.println("mandateId : "+mandateId);
		    	
				
		    	
		    	
		    	paymentUrl = trading.executeTrade(customerId, productDetailsMapForBuy,
						"NEW",sipDate,sipStartDate,sipEndDate,
						transactionType,"BUY",Integer.parseInt(sipDuration),
						getAccountNumber(),getBankName(),getNeftCode(),getBankMode(getBankName()),"Y",
						"Customer bought some mutual funds",mandateId,getTranDetailId(),sessionMap);
			}

			if ( !paymentUrl.equals("NotSet")) {
		        	
		        	str = "success|"+paymentUrl;
			}
			else{
				str = "allOrderFailed";

			}
			
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return SUCCESS;

		}
		else {
			str = "clientCreationFailure";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return SUCCESS;
		}

		} catch (MoneyBuddyException e) {	
    		logger.debug("PaymentAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("PaymentAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		}

    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getNeftCode() {
		return neftCode;
	}

	public void setNeftCode(String neftCode) {
		this.neftCode = neftCode;
	}


	public String getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(String tranDetailId) {
		this.tranDetailId = tranDetailId;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	
	public String getBankMode(String bankName)  {
		
		String bankMode;
		
		switch (bankName)  {
			case "ICI" : 
			case "SBI" : 
			case "162" :
				bankMode="DIRECT";break;
			case "HDF" :
				bankMode="NODAL";break;
			default : 
				bankMode="INVALID";
		}
		return bankMode;
	}

	
}
