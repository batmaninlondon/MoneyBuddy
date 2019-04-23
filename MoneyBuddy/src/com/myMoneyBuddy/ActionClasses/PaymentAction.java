/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.myMoneyBuddy.DAOClasses.QueryBankDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.QuerySecondaryFundDetails;
import com.myMoneyBuddy.DAOClasses.QuerySipDetails;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.DAOClasses.GenerateAofForm;
import com.myMoneyBuddy.DAOClasses.InsertBankDetails;
import com.myMoneyBuddy.DAOClasses.InsertCustomerDetails;
import com.myMoneyBuddy.EntityClasses.BankDetails;
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
	/*private String accountType;
	private String accountNumber;
	private String reAccountNumber;
	private String ifscCode;*/
	private String firstOrderFlag;
	/*private String bankName;*/
	private String tranDetailId;
	//private InputStream stream;
	private String paymentUrl;
	//private String returnDate;
	private String sipAmount;
	private String actionMsg;
	
	
	   
    public String getActionMsg() {
		return actionMsg;
	}

	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}

	public String execute()  {

    	String CLIENT_HOLDING = "SI"; // Considering Single account
    	//String str = null;
    	String customerId = null;
    	
    	try {

    		System.out.println(" HI THERE FROM PAYMENT ACTION !!!! ");
    		System.out.println("firstOrderFlag : "+getFirstOrderFlag());
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		String transactionType = null;
    		TransactionDetails transactionDetails = null;
    		
    		QueryBankDetails queryBankDetails = new QueryBankDetails();
    		BankDetails bankDetails = queryBankDetails.fetchBankDetails(customerId);
	    	/*boolean insertBankDetails = queryBankDetails.sameBankDetailsExists(customerId, getBankName(), getAccountType(), 
	    										getAccountNumber(), getIfscCode());
	    	if ( insertBankDetails)  {
		    	InsertBankDetails bankDetails = new InsertBankDetails();
		    	DesEncrypter desEncrypter = new DesEncrypter();
		    	bankDetails.insertBankDetail(customerId, getBankName(), getAccountType(), desEncrypter.encrypt(getAccountNumber()), getIfscCode());
	    	}
	    	*/
	    	QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
	    	
	    	System.out.println(" customer.getAofFormStatus() is : .................................................."+customer.getAofFormStatus()+"!!!!!!!!!!");
	    	/*if ("NOT_ACTIVATED".equals(customer.getAofFormStatus()) && "NOT_DONE".equals(customer.getKycStatus()))  {
	    		System.out.println(" Inside the loop of NOT_ACTIVATED aof form status !!!!!! ");
	    		GenerateAofForm generateAofForm = new GenerateAofForm();
	    		generateAofForm.generateAofForm(customerId);
	    	}*/
	    	

	    	if ("NOT_ACTIVATED".equals(customer.getAofFormStatus()) )  {
	    		return "aofNotDone";
	    	}
	    	if ("NotSet".equals(getTranDetailId()))  {
    			transactionType = sessionMap.get("transactionType").toString();
    		}
    		else {
    			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
    			transactionDetails = queryTransactionDetails.getTransactionDetails(getTranDetailId());
    			transactionType = transactionDetails.getTransactionType();
    		}
    		System.out.println("Payment Action class : execute method : transactionType : "+transactionType);

		    

	    	QueryProducts queryProducts = new QueryProducts();
	    	Map<String, Double> productDetailsMapForBuy = new HashMap<String, Double>();
	    	//Map<String, String> folioNumMapForBuy = new HashMap<String, String>();

	    	
	    	Trading trading = new Trading();
	    	
	    	String bseClientCreatedStatus = customer.getBseClientCreated();
	    	
	    	if ("N".equals(bseClientCreatedStatus))  {
	    		
	    		QueryCustomerDetails queryCustomerDetails = new QueryCustomerDetails();
	    		CustomerDetails customerDetails = queryCustomerDetails.getCustomerDetails(customerId);
	    		
		    	String ucc = trading.createClient(CLIENT_HOLDING, customerDetails.getTaxStatus(), customerDetails.getOccupation(), customerDetails.getDateOfBirth(),
		    			customerDetails.getGender(), "", bankDetails.getAccountType(), bankDetails.getAccountNumber(), bankDetails.getIfscCode(),
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
			
			if ("NOT_ACTIVATED".equals(customer.getAofFormStatus()) ) {
				boolean anyCamsFund;
				if ("NotSet".equals(getTranDetailId()))    {
					
					QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
					if ("UPFRONT".equals(transactionType))  {
						anyCamsFund = queryCustomerCart.existsCamsFund(customerId, "UPFRONT");
					}
					else {
						anyCamsFund = queryCustomerCart.existsCamsFund(customerId, "SIP");
					}	
				}
				else {
					QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
					if ("CAMS".equals(querySecondaryFundDetails.getRta(transactionDetails.getProductId()))) {
						anyCamsFund = true;
					}else {
						anyCamsFund = false;
					}
					
				}
				
				if (anyCamsFund )  {
					return "aofNotDone";
				}
			}
			
			
			String paymentUrl = null;
			
			String amount;
			System.out.println("transactionType : "+transactionType);
			
			CommonUtil commonUtil = new CommonUtil();
			
			if ("UPFRONT".equals(transactionType))  {
							
				if ("NotSet".equals(getTranDetailId()))    {
					List<CustomerCart> customerCartList = (List<CustomerCart>) sessionMap.get("customerCartUpfrontList");
					for (int i =0 ; i< customerCartList.size() ;i++) {
			    		System.out.println("Value of i is : "+i+" customerCartList.get(i).getProductName : "+customerCartList.get(i).getProductName());
			    		if ( !"Total".equals(customerCartList.get(i).getProductName()))  {
			    			productDetailsMapForBuy.put(customerCartList.get(i).getProductId()+":"+customerCartList.get(i).getFolioNumber(), Double.parseDouble(customerCartList.get(i).getAmount()));
			    			//folioNumMapForBuy.put(customerCartList.get(i).getProductId(), customerCartList.get(i).getFolioNumber());
			    		}
			    	}
				}
				else {
					productDetailsMapForBuy.put(transactionDetails.getProductId()+":"+transactionDetails.getTransactionFolioNum(), Double.parseDouble(transactionDetails.getTransactionAmount()));
					//folioNumMapForBuy.put(transactionDetails.getProductId(), transactionDetails.getTransactionFolioNum());
				}
				
		    	paymentUrl = trading.executeTrade(customerId, customer.getPanCard(),productDetailsMapForBuy,
						"NEW",transactionType,"BUY",bankDetails.getAccountNumber(),bankDetails.getBankName(),bankDetails.getIfscCode(),commonUtil.getBankMode(bankDetails.getBankName()),"Y",
						"Customer bought some mutual funds",null,getTranDetailId(), sessionMap);
		    	
		    	System.out.println("paymentUrl : "+paymentUrl);
		    	
			}
			else if ("SIP".equals(transactionType)) {
				
				/*String sipDate = null;
				String sipStartDate = null;
				String sipEndDate = null;*/
				//String sipDuration= null;
				
				Date currentDate = new Date();
				Calendar c = Calendar.getInstance();
		        c.setTime(currentDate);
		        Properties configProperties = new Properties();
				String configPropFilePath = "../../../config/config.properties";

				configProperties.load(PaymentAction.class.getResourceAsStream(configPropFilePath));
				
				String sipBufferDays = null;
				
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
			    
			    Calendar cal = Calendar.getInstance();
			    
				if ("NotSet".equals(getTranDetailId()))    {
					/*amount = sessionMap.get("sipAmount").toString();
					sipAmount = amount;*/
					/*sipDate = sessionMap.get("sipDate").toString();
					sipStartDate = sessionMap.get("sipStartDate").toString();
					sipEndDate = sessionMap.get("sipEndDate").toString();*/
					
					
				    
					/*sipDuration = sessionMap.get("sipDuration").toString();*/
					
					List<CustomerCart> customerCartList = (List<CustomerCart>) sessionMap.get("customerCartSipList");
					
				    
			        for (int i =0 ; i< customerCartList.size() ;i++) {
			    		System.out.println("Value of i is : "+i+" customerCartList.get(i).getProductName : "+customerCartList.get(i).getProductName());
			    		if ( !"Total".equals(customerCartList.get(i).getProductName()))  {

			    			String sipStartMonth;
							String sipEndMonth;
							
							//CommonUtil commonUtil= new CommonUtil();
							
							if ( Integer.parseInt(customerCartList.get(i).getSipDate()) <=   (cal.get(Calendar.DATE)) ) {
								sipStartMonth = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? commonUtil.theMonth(0) : commonUtil.theMonth(cal.get(Calendar.MONTH)+1));
								sipEndMonth = commonUtil.theMonth(cal.get(Calendar.MONTH));
							}
							else {
								sipStartMonth = commonUtil.theMonth(cal.get(Calendar.MONTH));
								sipEndMonth = (("0".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? commonUtil.theMonth(11) : commonUtil.theMonth(cal.get(Calendar.MONTH)-1));
							}
							System.out.println(" sipEndMonth : "+sipEndMonth);
							System.out.println(" date.getYear() : "+cal.get(Calendar.YEAR));
							String sipEndYear = Integer.toString(cal.get(Calendar.YEAR)+Integer.parseInt(customerCartList.get(i).getSipDuration()));
							String sipStartYear = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? Integer.toString(cal.get(Calendar.YEAR)+1) : Integer.toString(cal.get(Calendar.YEAR)));
							System.out.println(" sipEndYear : "+sipEndYear);
							
							String sipStartDate = sipStartMonth+"/"+customerCartList.get(i).getSipDate()+"/"+sipStartYear;
							String sipEndDate = sipEndMonth+"/"+customerCartList.get(i).getSipDate()+"/"+sipEndYear;
							
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
			    			productDetailsMapForBuy.put(customerCartList.get(i).getProductId()+":"+customerCartList.get(i).getFolioNumber()+
			    					":"+customerCartList.get(i).getSipDuration()+":"+customerCartList.get(i).getSipDate()+
			    					":"+sdf.format(curSipStartDate)+":"+sdf.format(curSipEndDate),
			    					Double.parseDouble(customerCartList.get(i).getAmount()));
			    			//folioNumMapForBuy.put(customerCartList.get(i).getProductId(), customerCartList.get(i).getFolioNumber());
			    		}
			    	}
					
					/*productDetailsMapForBuy = queryProducts.getProductAmountList((HashMap<String,Double>)sessionMap.get("productRatioList"),
			    			Double.parseDouble(amount),sessionMap.get("sipFolioNum").toString());*/
					
					
				}
				else {
					amount = transactionDetails.getTransactionAmount();
					sipAmount = amount;
					QuerySipDetails querySipDetails = new QuerySipDetails();
					SipDetails sipDetails = querySipDetails.getSipDetails(getTranDetailId());
					String sipDate = sipDetails.getSipDate();
					String sipStartDate = sipDetails.getSipStartDate();
					String sipEndDate = sipDetails.getSipEndDate();
					
					System.out.println("Before change : sipStartDate : "+sipStartDate+" and sipEndDate : "+sipEndDate);
					sipStartDate = sipStartDate.substring(5,7)+"/"+sipStartDate.substring(8,10)+"/"+sipStartDate.substring(0,4);
					sipEndDate = sipEndDate.substring(5,7)+"/"+sipEndDate.substring(8,10)+"/"+sipEndDate.substring(0,4);
					System.out.println("After change : sipStartDate : "+sipStartDate+" and sipEndDate : "+sipEndDate);
					
					
					//sipDuration= sipDetails.getSipDuration();
					
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
					
					productDetailsMapForBuy.put(transactionDetails.getProductId()+":"+transactionDetails.getTransactionFolioNum()+
								":"+sipDetails.getSipDuration()+":"+sipDate+":"+sdf.format(curSipStartDate)+":"+sdf.format(curSipEndDate), 
							Double.parseDouble(transactionDetails.getTransactionAmount()));
				}
				
				/*Properties configProperties = new Properties();
				String configPropFilePath = "../../../config/config.properties";

				configProperties.load(PaymentAction.class.getResourceAsStream(configPropFilePath));
				
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
			    	
			    }*/
			    
				String mandateId = customer.getIsipMandateId();
				
				if ( "NOT_GENERATED".equals(mandateId))  {
										
					String mandateIdResponse = trading.generateMandateId(customerId, "I", bankDetails.getAccountNumber(), bankDetails.getAccountType(), bankDetails.getIfscCode());
					
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
						"NEW",transactionType,"BUY",
						bankDetails.getAccountNumber(),bankDetails.getBankName(),bankDetails.getIfscCode(),commonUtil.getBankMode(bankDetails.getBankName()),getFirstOrderFlag(),
						"Customer bought some mutual funds",mandateId,getTranDetailId(),sessionMap);
		    	
		    	/*SimpleDateFormat returnDateFormat = new SimpleDateFormat("dd MMMM yy");
		    	
		    	returnDate = returnDateFormat.format("12/01/2019");
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
		    	System.out.println("returnDate after editing :  "+returnDate);*/
		    	
		    	if ("N".equals(getFirstOrderFlag()))
		    		return "sipOrderFofN";
		    	/*else
		    		return "sipOrderFofN";*/
		    		
			}

			
			if ( !paymentUrl.equals("NotSet")) {
			
				if (!paymentUrl.contains("<html>"))  {
					setActionMsg("ActionMsg-"+paymentUrl);
					return "failedWithPaymentGateway";
				}
				setPaymentUrl(paymentUrl);
				return SUCCESS;
				
			}
			else {
				//addActionMessage("allOrderFailed with BSE");
				setActionMsg("ActionMsg-allOrderFailed with BSE");
				return "allOrderFailed";
			}
			
    	    //stream = new ByteArrayInputStream(str.getBytes());
    		

		}
		else {
			/*str = "clientCreationFailure";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
			setActionMsg("ActionMsg-clientCreationFailed with BSE");
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
	
/*	public String getBankName() {
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
	}*/

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
	
/*	public String getReAccountNumber() {
		return reAccountNumber;
	}

	public void setReAccountNumber(String reAccountNumber) {
		this.reAccountNumber = reAccountNumber;
	}*/
/*
	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}*/

	public String getSipAmount() {
		return sipAmount;
	}

	public void setSipAmount(String sipAmount) {
		this.sipAmount = sipAmount;
	}


	
}
