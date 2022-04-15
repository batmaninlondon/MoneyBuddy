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
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.FolioDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class UploadCustomerNavAction extends ActionSupport {
	
	Logger logger = LogManager.getLogger(UploadCustomerNavAction.class);	
    private String bseRegNum;
    private String bseOrderId;
    private String transactionType;
    private String folioNum;
    private String navValue;
    private String unitsPurchased;
    private String transactionDate;
    private HashMap<String,String>  pendingNavOrders ;
    
    //private InputStream stream;
   
    public String execute() {
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
    	try {
    		
    		logger.debug("UploadCustomerNavAction class - execute method - bseRegNum - "+getBseRegNum()+" and bseOrderId - "+getBseOrderId()+" - start ");

    		System.out.println("UploadCustomerNavAction class : execute method : called ");
    		
    		System.out.println("transactionFolioNum : "+getFolioNum()+" : unitPrice : "+getNavValue()+" : quantity : "+getUnitsPurchased()+""
    				+ " : bseOrderId : "+getBseOrderId()+" : bseRegNum : "+getBseRegNum()+" : transactionDate : "+getTransactionDate());
    		   		
    		hibernateSession.beginTransaction();
    		
    		Query query;
    		String buySellSwitch="";
    		if ("SIP".equals(getTransactionType()))  {

        		query = hibernateSession.createQuery("select transactionDetailId, transactionAmount, transactionId, transactionUnit, selOption, selType "
        				+ " from TransactionDetails where bseRegistrationNumber = :bseRegistrationNumber"
        				+ " and transactionDate = :transactionDate ");
        		query.setParameter("bseRegistrationNumber", getBseRegNum());
        		query.setParameter("transactionDate", getTransactionDate());
        		
    		}
    		else if (getTransactionType().contains("STP"))  {
    			
    			//String tranType = getTransactionType().substring(0,3);
    			String buySell = getTransactionType().substring(4,getTransactionType().length());
    			
        		query = hibernateSession.createQuery("select transactionDetailId, transactionAmount, transactionId, transactionUnit, selOption, selType "
        				+ " from TransactionDetails where bseRegistrationNumber = :bseRegistrationNumber"
        				+ " and transactionDate = :transactionDate and buySell = :buySell ");
        		query.setParameter("bseRegistrationNumber", getBseRegNum());
        		query.setParameter("transactionDate", getTransactionDate());
        		query.setParameter("buySell", buySell);
        		
        		
    		}
    		else if (getTransactionType().contains("SWITCH"))  {
    			
    			//String tranType = getTransactionType().substring(0,3);
    			String buySellType = getTransactionType().substring(7,getTransactionType().length());
    			System.out.println(" buySellType IS ........................................ "+buySellType);
    			if ("IN".equalsIgnoreCase(buySellType))  {
    				buySellSwitch = "BUY";
    			}
    			else {
    				buySellSwitch = "SELL";
    			}
    			System.out.println(" buySellSwitch IS ........................................ "+buySellSwitch);
    			
        		query = hibernateSession.createQuery("select transactionDetailId, transactionAmount, transactionId, transactionUnit, selOption, selType "
        				+ " from TransactionDetails where transactionFolioNum = :transactionFolioNum"
        				+ " and transactionDate = :transactionDate and buySell = :buySell ");
        		query.setParameter("transactionFolioNum", getFolioNum());
        		query.setParameter("transactionDate", getTransactionDate());
        		query.setParameter("buySell", buySellSwitch);
        		
        		
    		}
    		else {
    		
    			query = hibernateSession.createQuery("select transactionDetailId, transactionAmount, transactionId, transactionUnit, selOption, selType "
    					+ " from TransactionDetails where bseOrderId = :bseOrderId ");
        		query.setParameter("bseOrderId", getBseOrderId());
        		
    		}
        		
    		List<Object[]> transactionDetailList = query.list();

			String transactionDetailId = transactionDetailList.get(0)[0].toString();
			
			Double transactionAmount = Double.valueOf(transactionDetailList.get(0)[1].toString());
			String transactionIdSwitch = transactionDetailList.get(0)[2].toString();
			String transactionUnit = transactionDetailList.get(0)[3].toString();
			String selOption = transactionDetailList.get(0)[4].toString();
			String selType = transactionDetailList.get(0)[5].toString();
			
			System.out.println("transactionDetailId is : "+transactionDetailId);

    		hibernateSession.getTransaction().commit();
    		
    		//boolean executeCode = true;
    		Double expectedAmount = transactionAmount;
    		Double onePercentage = expectedAmount/100;
    		//Double fivePercentage = onePercentage * 5;
    		Double actualAmount = Double.parseDouble(getUnitsPurchased()) * Double.parseDouble(getNavValue());
    		
    		System.out.println("expectedAmount : "+expectedAmount);
    		System.out.println("onePercentage : "+onePercentage);
    		System.out.println("actualAmount : "+actualAmount);
    		System.out.println(" transactionType: "+transactionType);
    		System.out.println(" buySellSwitch : "+buySellSwitch);
    		System.out.println(" selOption : "+selOption);
    		
    		    		
    		String transactionStatus ="";
    		String transactionSwitchAmount = "";
    		if ( getTransactionType().contains("SWITCH") && "BUY".equalsIgnoreCase(buySellSwitch)   )   {
    			hibernateSession.beginTransaction();
    			query = hibernateSession.createQuery("select transactionStatus,transactionAmount from TransactionDetails"
    											+ " where transactionId = :transactionId and buySell='SELL' ");
    			query.setParameter("transactionId",transactionIdSwitch);
    			
    			List<Object[]> queryRes = query.list(); 
    			
    			if (queryRes.size() != 0) {
    				transactionStatus = queryRes.get(0)[0].toString();
    				transactionSwitchAmount = queryRes.get(0)[1].toString();
    			}

    			hibernateSession.getTransaction().commit();
    			if (!"8".equalsIgnoreCase(transactionStatus))   {
    				addActionMessage(" UPLOAD THE SWITCH OUT FOR THIS TRANSACTION FIRST  !!!!! ");
    				return INPUT;
    				
    			}
    			else  {
    				
    				Double expectedSwitchAmount = Double.parseDouble(transactionSwitchAmount);
    				Double oneSwitchPercentage = expectedSwitchAmount/100;
    				
    				if ((actualAmount < (expectedSwitchAmount - oneSwitchPercentage)) || (actualAmount > (expectedSwitchAmount + oneSwitchPercentage)))   {
    					/*addActionMessage(" email Id does not exists! ");*/
    					/*return "amountDoesNotMatch";*/
    					//executeCode = false;
    					addActionMessage("  AMOUNT DOES NOT MATCH !!!!! ");
    					return INPUT;
    				}
    				
    			}
    		}
    				
    		else if ( "REDEMPTION".equalsIgnoreCase(transactionType) )   {
    			if ("FULL".equalsIgnoreCase(selOption))   {
    				if (Double.parseDouble(transactionUnit) != Double.parseDouble(getUnitsPurchased()))  {
    					//executeCode = false;
    					addActionMessage(" UNITS DOES NOT MATCH !!!!! ");
    					return INPUT;
    				}
    			}
    			else if ("AMOUNT".equalsIgnoreCase(selType))  {
    				
    				
    				if ((actualAmount < (expectedAmount - onePercentage)) || (actualAmount > (expectedAmount + onePercentage)))   {
    					/*addActionMessage(" email Id does not exists! ");*/
    					/*return "amountDoesNotMatch";*/
    					//executeCode = false;
    					addActionMessage(" AMOUNT DOES NOT MATCH !!!!! ");
    					return INPUT;
    				}
    			}
    			else {
    				if (Double.parseDouble(transactionUnit) != Double.parseDouble(getUnitsPurchased()))  {
    					//executeCode = false;
    					addActionMessage(" UNITS DOES NOT MATCH !!!!! ");
    					return INPUT;
    				}
    			}
    		}
    		else if ( getTransactionType().contains("SWITCH") && "SELL".equalsIgnoreCase(buySellSwitch)   )   {
    			if ("FULL".equalsIgnoreCase(selOption))   {
    				if (Double.parseDouble(transactionUnit) != Double.parseDouble(getUnitsPurchased()))  {
    					//executeCode = false;
    					addActionMessage(" UNITS DOES NOT MATCH !!!!! ");
    					return INPUT;
    				}
    			}
    			else if ("AMOUNT".equalsIgnoreCase(selType))  {
    				
    				
    				if ((actualAmount < (expectedAmount - onePercentage)) || (actualAmount > (expectedAmount + onePercentage)))   {
    					/*addActionMessage(" email Id does not exists! ");*/
    					/*return "amountDoesNotMatch";*/
    					//executeCode = false;
    					addActionMessage(" AMOUNT DOES NOT MATCH !!!!! ");
    					return INPUT;
    				}
    			}
    			else {
    				if (Double.parseDouble(transactionUnit) != Double.parseDouble(getUnitsPurchased()))  {
    					//executeCode = false;
    					addActionMessage(" UNITS DOES NOT MATCH !!!!! ");
    					return INPUT;
    				}
    			}
    		}
    		else {
    			
    			if (!("SIP".equalsIgnoreCase(getTransactionType()) && "NA".equalsIgnoreCase(getBseOrderId()))) {
    			
	    			if ((actualAmount < (expectedAmount - onePercentage)) || (actualAmount > (expectedAmount + onePercentage)))   {
	    				/*addActionMessage(" email Id does not exists! ");*/
	    				/*return "amountDoesNotMatch";*/
	    				//executeCode = false;
	    				addActionMessage(" AMOUNT DOES NOT MATCH !!!!! ");
	    				return INPUT;
	    			}
    			}
    		}
    		
    		
    		
    		
    		
    		
    		
    		

    		Double calculatedAmount = Double.valueOf(getNavValue()) * Double.valueOf(getUnitsPurchased());

    		System.out.println(" NAV value : "+getNavValue()+" : units : "+getUnitsPurchased());
    		
    		System.out.println("calculated amount : "+calculatedAmount+" : transactionAmount : "+transactionAmount);

    		
    		hibernateSession.beginTransaction();

			query = hibernateSession.createQuery("select t.fundId, c.panCard, t.customerId, t.transactionFolioNum,"
									+ "s.amcCode,t.transactionType, t.buySell "
									+ "from Customers c, TransactionDetails t, SecondaryFundDetails s "
									+ "where t.customerId = c.customerId and t.fundId = s.fundId and t.transactionDetailId= :transactionDetailId");
			

			query.setParameter("transactionDetailId", transactionDetailId);
			
			List<Object[]> queryResult = query.list(); 
			
			String fundId = queryResult.get(0)[0].toString();
			String panCard = queryResult.get(0)[1].toString();
			String customerId = queryResult.get(0)[2].toString();
			String folioNum = null;
			if (queryResult.get(0)[3] != null )  {
				folioNum = queryResult.get(0)[3].toString();	
			}
			
			String amcCode = queryResult.get(0)[4].toString();
			String transactionType = queryResult.get(0)[5].toString();
			
			System.out.println(" panCard : "+panCard+" : customerId : "+customerId+" : folioNum : "+folioNum+" : amcCode : "+amcCode);
			
			hibernateSession.getTransaction().commit();
			
			if ("".equals(folioNum) || folioNum == null)  {
				
				hibernateSession.beginTransaction();

				FolioDetails tempFolioDetails = new FolioDetails( getFolioNum(), customerId, panCard,fundId,amcCode,"MoneyBuddy");
				hibernateSession.save(tempFolioDetails);
				
				hibernateSession.getTransaction().commit();
	
			}

			Calendar today = Calendar.getInstance();
			today.add(Calendar.DATE, -1);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(today.getTimeInMillis());
			String frmtdDateForDB = dateFormat.format(date);
			
			System.out.println("frmtdDateForDB : "+frmtdDateForDB);
			
    		hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("update TransactionDetails set transactionFolioNum = :transactionFolioNum , "
					+ "unitPrice = :unitPrice , quantity = :quantity , transactionAmount = :transactionAmount, bseOrderId = :bseOrderId, transactionStatus = :transactionStatus ,"
					+ " reverseFeed = :reverseFeed, updateDate = :updateDate, transactionType = :transactionType, "
					+ " buySell = :buySell  "
					+ " where transactionDetailId = :transactionDetailId");

			query.setParameter("transactionFolioNum", getFolioNum());
			query.setParameter("unitPrice", getNavValue());
			query.setParameter("quantity", getUnitsPurchased());
			query.setParameter("bseOrderId", getBseOrderId());
			query.setParameter("transactionDetailId", transactionDetailId);
			query.setParameter("transactionAmount", Double.toString(actualAmount));
			query.setParameter("transactionStatus", "8");
			query.setParameter("reverseFeed", "Y");
			query.setParameter("updateDate", frmtdDateForDB);
			if ("SIP".equalsIgnoreCase(getTransactionType()) && "NA".equalsIgnoreCase(getBseOrderId())) {
				System.out.println(" Inside IF ");
				query.setParameter("transactionType", "SIPMissed");
				query.setParameter("buySell", "SIPMissed");
			}
			else {
				System.out.println(" Inside ELSE ");
				query.setParameter("transactionType", getTransactionType());
				query.setParameter("buySell", queryResult.get(0)[6].toString());
			}
			
			System.out.println("transactionDetailId : "+transactionDetailId);
			
			int updateResult = query.executeUpdate();
			System.out.println(updateResult + " rows updated in transactionDetails table ");
			hibernateSession.getTransaction().commit();	
			
			hibernateSession.beginTransaction();
			
			query = hibernateSession.createQuery("select transactionId from TransactionDetails where transactionDetailId = :transactionDetailId");
			query.setParameter("transactionDetailId", transactionDetailId );
			String transactionId = query.uniqueResult().toString();
		
			hibernateSession.getTransaction().commit();
 		    
			hibernateSession.beginTransaction();
			
			query = hibernateSession.createQuery("select count(*) from TransactionDetails where transactionId = :transactionId and transactionStatus != '8'");
			query.setParameter("transactionId", transactionId );
			String count = query.uniqueResult().toString();
			
			if ("0".equals(count))  {
					
				hibernateSession.getTransaction().commit();
				
		    	Customers customers = new QueryCustomer().getCustomerFromCustomerId(customerId);
		    	
		    	String emailId = customers.getEmailId();
		    	String customerName = customers.getCustomerName();
		    	
		    	SendMail sendMail = new SendMail();
	
		    	Properties configProperties = new Properties();
				String configPropFilePath = "../../../config/config.properties";
	
				configProperties.load(ForgotPasswordAction.class.getResourceAsStream(configPropFilePath));
				
				if ("UPFRONT".equalsIgnoreCase(transactionType))  {
		 			String mailLink = configProperties.getProperty("MAIL_UPFRONT_TRANSACTION_EXECUTED_LINK");
					System.out.println("mailLink is : "+mailLink);
			    	
			    	String subject = configProperties.getProperty("MAIL_UPFRONT_TRANSACTION_EXECUTED_SUBJECT");
		
			    	//sendMail.MailSending(emailId,subject,"UpfrontTransactionExecutedMail","UpfrontTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
				else if ("SIP".equalsIgnoreCase(transactionType) && !("NA".equalsIgnoreCase(getBseOrderId()))){
					String mailLink = configProperties.getProperty("MAIL_SIP_TRANSACTION_EXECUTED_LINK");
					System.out.println("mailLink is : "+mailLink);
			    	
			    	String subject = configProperties.getProperty("MAIL_SIP_TRANSACTION_EXECUTED_SUBJECT");
		
			    	//sendMail.MailSending(emailId,subject,"SipTransactionExecutedMail","SipTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
				else if ("REDEMPTION".equalsIgnoreCase(transactionType)){
					String mailLink = configProperties.getProperty("MAIL_REDEMPTION_TRANSACTION_EXECUTED_LINK");
					System.out.println("mailLink is : "+mailLink);
			    	
			    	String subject = configProperties.getProperty("MAIL_REDEMPTION_TRANSACTION_EXECUTED_SUBJECT");
		
			    	//sendMail.MailSending(emailId,subject,"RedemptionTransactionExecutedMail","RedemptionTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
				else if ("STP".equalsIgnoreCase(transactionType)){
					String mailLink = configProperties.getProperty("MAIL_STP_TRANSACTION_EXECUTED_LINK");
					System.out.println("mailLink is : "+mailLink);
			    	
			    	String subject = configProperties.getProperty("MAIL_STP_TRANSACTION_EXECUTED_SUBJECT");
		
			    	//sendMail.MailSending(emailId,subject,"StpTransactionExecutedMail","StpTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
				
				else if ("SWITCH".equalsIgnoreCase(transactionType)){
					String mailLink = configProperties.getProperty("MAIL_SWITCH_TRANSACTION_EXECUTED_LINK");
					System.out.println("mailLink is : "+mailLink);
			    	
			    	String subject = configProperties.getProperty("MAIL_SWITCH_TRANSACTION_EXECUTED_SUBJECT");
		
			    	//sendMail.MailSending(emailId,subject,"SwitchTransactionExecutedMail","SwitchTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
				
		    	logger.debug("UploadCustomerNavAction class - execute method - customerId - "+customerId+" - mail sent to "+emailId+" for transaction execution");
		    	
			}
	    	/*String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());*/
		    logger.debug("UploadCustomerNavAction class - execute method - bseOrderId - "+getBseOrderId()+" - returned success");
	    	logger.debug("UploadCustomerNavAction class - execute method - bseOrderId - "+getBseOrderId()+" - end");
	    	
	    	return SUCCESS;
	    	
    	}
    	catch (Exception e) {	
    		logger.error("UploadCustomerNavAction class - execute method - bseOrderId - "+getBseOrderId()+" - Caught Exception");
    		e.printStackTrace();
    		
    		/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("UploadCustomerNavAction class - execute method - bseOrderId - "+getBseOrderId()+" - returned error");
    	    
    		return ERROR;
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
    }

	public String getBseOrderId() {
		return bseOrderId;
	}

	public void setBseOrderId(String bseOrderId) {
		this.bseOrderId = bseOrderId;
	}

	public String getBseRegNum() {
		return bseRegNum;
	}

	public void setBseRegNum(String bseRegNum) {
		this.bseRegNum = bseRegNum;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getFolioNum() {
		return folioNum;
	}

	public void setFolioNum(String folioNum) {
		this.folioNum = folioNum;
	}

	public String getNavValue() {
		return navValue;
	}

	public void setNavValue(String navValue) {
		this.navValue = navValue;
	}

	public String getUnitsPurchased() {
		return unitsPurchased;
	}

	public void setUnitsPurchased(String unitsPurchased) {
		this.unitsPurchased = unitsPurchased;
	}

	public HashMap<String, String> getPendingNavOrders() {
		return pendingNavOrders;
	}

	public void setPendingNavOrders(HashMap<String, String> pendingNavOrders) {
		this.pendingNavOrders = pendingNavOrders;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	
/*

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/
	

}
