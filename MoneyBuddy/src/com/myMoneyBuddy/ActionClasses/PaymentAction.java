/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.myMoneyBuddy.DAOClasses.QueryBankDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.QuerySipDetails;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.DAOClasses.InsertBankDetails;
import com.myMoneyBuddy.DAOClasses.InsertCustomerDetails;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.CommonUtil;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class PaymentAction extends ActionSupport implements SessionAware {

	Logger logger = Logger.getLogger(PaymentAction.class);
	private SessionMap<String,Object> sessionMap;
	private String accountType;
	private String accountNumber;
	private String reAccountNumber;
	private String ifscCode;
	private String firstOrderFlag;
	private String bankName;
	private String tranDetailId;
	//private InputStream stream;
	private String paymentUrl;
	private String returnDate;
	private String sipAmount;
	   
    public String execute()  {

    	String CLIENT_HOLDING = "SI"; // Considering Single account
    	//String str = null;
    	String customerId = null;
    	
    	try {
    		
    		System.out.println("tranDetailId : "+getTranDetailId()+" and accountNumber : "+getAccountNumber()+" reAccountNumber : "+getReAccountNumber()); 
    		System.out.println("accountType : "+getAccountType()+" and ifscCode : "+getIfscCode()+" and bankName : "+getBankName());
    		System.out.println("firstOrderFlag : "+getFirstOrderFlag());
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		String transactionType = null;
    		TransactionDetails transactionDetails = null;
    		
    		QueryBankDetails queryBankDetails = new QueryBankDetails();
	    	boolean insertBankDetails = queryBankDetails.sameBankDetailsExists(customerId, getBankName(), getAccountType(), 
	    										getAccountNumber(), getIfscCode());
	    	if ( insertBankDetails)  {
		    	InsertBankDetails bankDetails = new InsertBankDetails();
		    	DesEncrypter desEncrypter = new DesEncrypter();
		    	bankDetails.insertBankDetail(customerId, getBankName(), getAccountType(), desEncrypter.encrypt(getAccountNumber()), getIfscCode());
	    	}
	    	
	    	if ("KycNotDone".equals(getTranDetailId()))  {
    			return "kycNotDone";
    		}
    		else if ("NotSet".equals(getTranDetailId()))  {
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

	    	
	    	Trading trading = new Trading();
	    	
	    	String bseClientCreatedStatus = customer.getBseClientCreated();
	    	
	    	if ("N".equals(bseClientCreatedStatus))  {
	    		
	    		QueryCustomerDetails queryCustomerDetails = new QueryCustomerDetails();
	    		CustomerDetails customerDetails = queryCustomerDetails.getCustomerDetails(customerId);
	    		
		    	String ucc = trading.createClient(CLIENT_HOLDING, customerDetails.getTaxStatus(), customerDetails.getOccupation(), customerDetails.getDateOfBirth(),
		    			customerDetails.getGender(), "", getAccountType(), getAccountNumber(), getIfscCode(),
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
			
			CommonUtil commonUtil = new CommonUtil();
			
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
				
		    	paymentUrl = trading.executeTrade(customerId, customer.getPanCard(),productDetailsMapForBuy,
						"NEW",null,null,null,transactionType,"BUY",0,getAccountNumber(),getBankName(),getIfscCode(),commonUtil.getBankMode(getBankName()),"Y",
						"Customer bought some mutual funds",null,getTranDetailId(), sessionMap);
		    	
		    	System.out.println("paymentUrl : "+paymentUrl);
		    	
			}
			else {
				
				String sipDate = null;
				String sipStartDate = null;
				String sipEndDate = null;
				String sipDuration= null;
				
				if ("NotSet".equals(getTranDetailId()))    {
					amount = sessionMap.get("sipAmount").toString();
					sipAmount = amount;
					sipDate = sessionMap.get("sipDate").toString();
					sipStartDate = sessionMap.get("sipStartDate").toString();
					sipEndDate = sessionMap.get("sipEndDate").toString();
					
					
				    
					sipDuration = sessionMap.get("sipDuration").toString();
					
					productDetailsMapForBuy = queryProducts.getProductAmountList((HashMap<String,Double>)sessionMap.get("productRatioList"),
			    			Double.parseDouble(amount));
				}
				else {
					amount = transactionDetails.getTransactionAmount();
					sipAmount = amount;
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
				
				Properties configProperties = new Properties();
				String configPropFilePath = "../../../config/config.properties";

				configProperties.load(PanCardVerificationAction.class.getResourceAsStream(configPropFilePath));
				
				String sipBufferDays = null;
				
				Date currentDate = new Date();
				Calendar c = Calendar.getInstance();
		        c.setTime(currentDate);
		        
				if ("Y".equals(getFirstOrderFlag()))  {
					sipBufferDays = configProperties.getProperty("SIP_BUFFER_DAYS_YES");
				}
				else {
					sipBufferDays = configProperties.getProperty("SIP_BUFFER_DAYS_NO");
					
				}
			     
				c.add(Calendar.DATE, Integer.parseInt(sipBufferDays));
				
			    Date minSipStartDate = c.getTime();
					
			    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			    
			    minSipStartDate = sdf.parse(sdf.format(minSipStartDate));
			    
			    Date curSipStartDate = sdf.parse(sipStartDate);
			    Date curSipEndDate = sdf.parse(sipEndDate);
			    
			    if (minSipStartDate.after(curSipStartDate)) {
			    	c.setTime(curSipStartDate);
			    	c.add(Calendar.MONTH,+1);
			    	curSipStartDate = c.getTime();
			    	
			    	c.setTime(curSipEndDate);
			    	c.add(Calendar.MONTH,+1);
			    	curSipEndDate = c.getTime();
			    	
			    }
			    
				String mandateId = customer.getIsipMandateId();
				
				if ( "NOT_GENERATED".equals(mandateId))  {
										
					String mandateIdResponse = trading.generateMandateId(customerId, "I", getAccountNumber(), getAccountType(), getIfscCode());
					
					String[] mandateIdResponseSpilts = mandateIdResponse.split("\\|"); 
			    	
			    	System.out.println("mandateIdResponseSpilts[0] : "+mandateIdResponseSpilts[0]);
			    	System.out.println("mandateIdResponseSpilts[1] : "+mandateIdResponseSpilts[1]);
			    	System.out.println("mandateIdResponseSpilts[2] : "+mandateIdResponseSpilts[2]);
			    	
			    	mandateId = mandateIdResponseSpilts[2];
			    	
			    	InsertCustomerDetails insertCustomerDetails = new InsertCustomerDetails();
			    	insertCustomerDetails.updateMandateId(mandateId, customerId);
				}
		    	
		    	System.out.println("mandateId : "+mandateId);
		    	
		    	paymentUrl = trading.executeTrade(customerId, customer.getPanCard(),productDetailsMapForBuy,
						"NEW",sipDate,sdf.format(curSipStartDate),sdf.format(curSipEndDate),
						transactionType,"BUY",Integer.parseInt(sipDuration),
						getAccountNumber(),getBankName(),getIfscCode(),commonUtil.getBankMode(getBankName()),getFirstOrderFlag(),
						"Customer bought some mutual funds",mandateId,getTranDetailId(),sessionMap);
		    	
		    	if ("SIP".equals(transactionType))   {
			    	SimpleDateFormat returnDateFormat = new SimpleDateFormat("dd MMMM yy");
			    	
			    	returnDate = returnDateFormat.format(curSipStartDate);
			    	String formatting = "";
			    	if ("01".equals(returnDate.substring(0,2)))  
			    		formatting = "st";
			    	else if ("02".equals(returnDate.substring(0,2)))
			    		formatting = "nd";
			    	else if ("03".equals(returnDate.substring(0,2)))
			    		formatting = "rd";
			    	else 
			    		formatting = "th";
			    	
			    	System.out.println("returnDate befor editing : "+returnDate);
			    	returnDate = returnDate.substring(0,2)+formatting+returnDate.substring(2,returnDate.length()-3)+"'"+returnDate.substring(returnDate.length()-2);
			    	System.out.println("returnDate after editing :  "+returnDate);
			    	
			    	if ("Y".equals(getFirstOrderFlag()))
			    		return "sipOrderFofY";
			    	else
			    		return "sipOrderFofN";
		    	}	
			}

			
			if ( !paymentUrl.equals("NotSet")) {
			
				if (!paymentUrl.contains("<html>"))  {
					addActionMessage(paymentUrl);
					return "failedWithPaymentGateway";
				}
				setPaymentUrl(paymentUrl);
				return SUCCESS;
				
			}
			else {
				addActionMessage("allOrderFailed with BSE");
				return "allOrderFailed";
			}
			
    	    //stream = new ByteArrayInputStream(str.getBytes());
    		

		}
		else {
			/*str = "clientCreationFailure";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
			addActionMessage("clientCreationFailed with BSE");
    		return "clientCreationFailure";
		}

		} catch (MoneyBuddyException e) {	
    		logger.error("PaymentAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			/*str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("PaymentAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			/*str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
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

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(String tranDetailId) {
		this.tranDetailId = tranDetailId;
	}

	public String getFirstOrderFlag() {
		return firstOrderFlag;
	}

	public void setFirstOrderFlag(String firstOrderFlag) {
		this.firstOrderFlag = firstOrderFlag;
	}

	public String getPaymentUrl() {
		return paymentUrl;
	}

	public void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

	/*public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/
	
	public String getReAccountNumber() {
		return reAccountNumber;
	}

	public void setReAccountNumber(String reAccountNumber) {
		this.reAccountNumber = reAccountNumber;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getSipAmount() {
		return sipAmount;
	}

	public void setSipAmount(String sipAmount) {
		this.sipAmount = sipAmount;
	}


	
}
