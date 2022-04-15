/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.ActionClasses.ForgotPasswordAction;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.FolioDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;

public class UploadCustomerNav {
	
	Logger logger = LogManager.getLogger(UploadCustomerNav.class);

	public void uploadCusNav ( String bseOrderId, String bseRegNum, String folNum,String navValue, String units) throws MoneyBuddyException {

		logger.debug("UploadCustomerNav class - uploadCusNav method - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			Query query ;
			String transactionDetailId ="";
			if ( !"0".equals(bseRegNum))
				
			{
				
				hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("select max(transactionDetailId) from TransactionDetails  where bseRegistrationNumber = :bseRegistrationNumber");
				query.setParameter("bseRegistrationNumber",bseRegNum);
				
				if (query.list().size() != 0) {
					transactionDetailId = query.uniqueResult().toString();
				}

				System.out.println("transactionDetailId -----------------------------------------------------------------------------"+transactionDetailId);
				hibernateSession.getTransaction().commit();
				
			}
		hibernateSession.beginTransaction();
		
		if ("0".equals(bseRegNum))  {
			
			query = hibernateSession.createQuery("select t.fundId, c.panCard, t.customerId, t.transactionFolioNum,s.amcCode,t.transactionType,t.transactionDetailId,"
					+ "t.transactionAmount, t.transactionUnit, t.selOption, t.selType , t.buySell, t.transactionId "
					+ "from Customers c, TransactionDetails t, SecondaryFundDetails s "
					+ "where t.customerId = c.customerId and t.fundId = s.fundId and t.bseOrderId= :bseOrderId ");
			
			System.out.println(" bseRegNum is 0 "+bseRegNum);
			query.setParameter("bseOrderId", bseOrderId);
		}
		else {
			
			
			
			System.out.println(" bseOrderId is :  "+bseOrderId+" and bseRegNumis :  "+bseRegNum);
			query = hibernateSession.createQuery("select t.fundId, c.panCard, t.customerId, t.transactionFolioNum,s.amcCode,t.transactionType,t.transactionDetailId,"
					+ "t.transactionAmount, t.transactionUnit, t.selOption, t.selType , t.buySell, t.transactionId "
					+ "from Customers c, TransactionDetails t, SecondaryFundDetails s "
					+ "where t.customerId = c.customerId and t.fundId = s.fundId and t.transactionDetailId= :transactionDetailId ");
			
			query.setParameter("transactionDetailId", transactionDetailId);
		}
		
		List<Object[]> queryResult = query.list(); 
		
		System.out.println(" queryResult size is "+queryResult.size());
		
		String fundId = queryResult.get(0)[0].toString();
		String panCard = queryResult.get(0)[1].toString();
		String customerId = queryResult.get(0)[2].toString();
		String folioNum = null;
		if (queryResult.get(0)[3] != null )  {
			folioNum = queryResult.get(0)[3].toString();	
		}
		String amcCode = queryResult.get(0)[4].toString();
		String transactionType = queryResult.get(0)[5].toString();
		transactionDetailId = queryResult.get(0)[6].toString();
		String transactionAmount = queryResult.get(0)[7].toString();
		String transactionUnit = queryResult.get(0)[8].toString();
		String selOption = queryResult.get(0)[9].toString();
		String selType = queryResult.get(0)[10].toString();
		String buySell = queryResult.get(0)[11].toString();
		String transactionIdForSwitch = queryResult.get(0)[12].toString();
		
		System.out.println(" panCard : "+panCard+" : customerId : "+customerId+" : folioNum : "+folNum+" : amcCode : "+amcCode);
		
		hibernateSession.getTransaction().commit();
		
		boolean executeCode = true;
		Double expectedAmount = Double.parseDouble(transactionAmount);
		Double onePercentage = expectedAmount/100;
		Double fivePercentage = onePercentage * 5;
		Double actualAmount = Double.parseDouble(units) * Double.parseDouble(navValue);
		
		String transactionStatus ="";
		String transactionSwitchAmount = "";
		if ( "SWITCH".equalsIgnoreCase(transactionType) && "BUY".equalsIgnoreCase(buySell)   )   {
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select transactionStatus,transactionAmount from TransactionDetails where transactionId = :transactionId and buySell='SELL' ");
			query.setParameter("transactionId",transactionIdForSwitch);
			
			List<Object[]> queryRes = query.list(); 
			
			if (queryRes.size() != 0) {
				transactionStatus = queryRes.get(0)[0].toString();
				transactionSwitchAmount = queryRes.get(0)[1].toString();
			}

			hibernateSession.getTransaction().commit();
			if (!"8".equalsIgnoreCase(transactionStatus))   {
				System.out.println(" UPLOAD THE SWITCH OUT FOR THIS TRANSACTION FIRST  !!!!! ");
				
			}
			else  {
				
				Double expectedSwitchAmount = Double.parseDouble(transactionSwitchAmount);
				Double oneSwitchPercentage = expectedSwitchAmount/100;
				
				if ((actualAmount < (expectedSwitchAmount - oneSwitchPercentage)) || (actualAmount > (expectedSwitchAmount + oneSwitchPercentage)))   {
					/*addActionMessage(" email Id does not exists! ");*/
					/*return "amountDoesNotMatch";*/
					executeCode = false;
					System.out.println(" AMOUNT DOES NOT MATCH !!!!! ");
				}
				
			}
		}
				
		else if ( "REDEMPTION".equalsIgnoreCase(transactionType) )   {
			if ("FULL".equalsIgnoreCase(selOption))   {
				if (Double.parseDouble(transactionUnit) != Double.parseDouble(units))  {
					executeCode = false;
					System.out.println(" UNITS DOES NOT MATCH !!!!! ");
				}
			}
			else if ("AMOUNT".equalsIgnoreCase(selType))  {
				
				
				if ((actualAmount < (expectedAmount - fivePercentage)) || (actualAmount > (expectedAmount + fivePercentage)))   {
					/*addActionMessage(" email Id does not exists! ");*/
					/*return "amountDoesNotMatch";*/
					executeCode = false;
					System.out.println(" AMOUNT DOES NOT MATCH !!!!! ");
				}
			}
			else {
				if (Double.parseDouble(transactionUnit) != Double.parseDouble(units))  {
					executeCode = false;
					System.out.println(" UNITS DOES NOT MATCH !!!!! ");
				}
			}
		}
		else if ( "SWITCH".equalsIgnoreCase(transactionType) && "SELL".equalsIgnoreCase(buySell)   )   {
			if ("FULL".equalsIgnoreCase(selOption))   {
				if (Double.parseDouble(transactionUnit) != Double.parseDouble(units))  {
					executeCode = false;
					System.out.println(" UNITS DOES NOT MATCH !!!!! ");
				}
			}
			else if ("AMOUNT".equalsIgnoreCase(selType))  {
				
				
				if ((actualAmount < (expectedAmount - fivePercentage)) || (actualAmount > (expectedAmount + fivePercentage)))   {
					/*addActionMessage(" email Id does not exists! ");*/
					/*return "amountDoesNotMatch";*/
					executeCode = false;
					System.out.println(" AMOUNT DOES NOT MATCH !!!!! ");
				}
			}
			else {
				if (Double.parseDouble(transactionUnit) != Double.parseDouble(units))  {
					executeCode = false;
					System.out.println(" UNITS DOES NOT MATCH !!!!! ");
				}
			}
		}
		else {
			if (!("SIP".equalsIgnoreCase(transactionType) && "NA".equalsIgnoreCase(bseOrderId))) {
				if ((actualAmount < (expectedAmount - fivePercentage)) || (actualAmount > (expectedAmount + fivePercentage)))   {
					/*addActionMessage(" email Id does not exists! ");*/
					/*return "amountDoesNotMatch";*/
					executeCode = false;
					System.out.println(" AMOUNT DOES NOT MATCH !!!!! ");
				}
			}
		}
		
		if (executeCode) {
			if ("".equals(folioNum) || folioNum == null)  {
				
				hibernateSession.beginTransaction();
	
				FolioDetails tempFolioDetails = new FolioDetails( folNum, customerId, panCard,fundId,amcCode,"MoneyBuddy");
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
			query = hibernateSession.createQuery("update TransactionDetails set bseOrderId = :bseOrderId, "
					+ "transactionFolioNum = :transactionFolioNum , "
					+ "unitPrice = :unitPrice , quantity = :quantity , "
					+ "transactionAmount = :transactionAmount, transactionStatus = :transactionStatus , "
					+ " reverseFeed = :reverseFeed, updateDate = :updateDate, transactionType = :transactionType, "
					+ " buySell = :buySell  "
					+ " where transactionDetailId = :transactionDetailId");
	
			query.setParameter("bseOrderId", bseOrderId);
			query.setParameter("transactionFolioNum", folNum);
			query.setParameter("unitPrice", navValue);
			query.setParameter("quantity", units);
			query.setParameter("transactionDetailId", transactionDetailId);
			query.setParameter("transactionAmount", actualAmount);
			query.setParameter("transactionStatus", "8");
			query.setParameter("reverseFeed", "Y");
			query.setParameter("updateDate", frmtdDateForDB);
			
			if ("SIP".equalsIgnoreCase(transactionType) && "NA".equalsIgnoreCase(bseOrderId)) {
				query.setParameter("transactionType", "SIPMissed");
				query.setParameter("buySell", "SIPMissed");
			}
			else {
				query.setParameter("transactionType", transactionType);
				query.setParameter("buySell", buySell);
			}
			
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
		
			    	sendMail.MailSending(emailId,subject,"UpfrontTransactionExecutedMail","UpfrontTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
				else if ("SIP".equalsIgnoreCase(transactionType) && !("NA".equalsIgnoreCase(bseOrderId))){
					String mailLink = configProperties.getProperty("MAIL_SIP_TRANSACTION_EXECUTED_LINK");
					System.out.println("mailLink is : "+mailLink);
			    	
			    	String subject = configProperties.getProperty("MAIL_SIP_TRANSACTION_EXECUTED_SUBJECT");
		
			    	sendMail.MailSending(emailId,subject,"SipTransactionExecutedMail","SipTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
				else if ("REDEMPTION".equalsIgnoreCase(transactionType)){
					String mailLink = configProperties.getProperty("MAIL_REDEMPTION_TRANSACTION_EXECUTED_LINK");
					System.out.println("mailLink is : "+mailLink);
			    	
			    	String subject = configProperties.getProperty("MAIL_REDEMPTION_TRANSACTION_EXECUTED_SUBJECT");
		
			    	sendMail.MailSending(emailId,subject,"RedemptionTransactionExecutedMail","RedemptionTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
				else if ("STP".equalsIgnoreCase(transactionType)){
					String mailLink = configProperties.getProperty("MAIL_STP_TRANSACTION_EXECUTED_LINK");
					System.out.println("mailLink is : "+mailLink);
			    	
			    	String subject = configProperties.getProperty("MAIL_STP_TRANSACTION_EXECUTED_SUBJECT");
		
			    	sendMail.MailSending(emailId,subject,"StpTransactionExecutedMail","StpTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
				
				else if ("SWITCH".equalsIgnoreCase(transactionType)){
					String mailLink = configProperties.getProperty("MAIL_SWITCH_TRANSACTION_EXECUTED_LINK");
					System.out.println("mailLink is : "+mailLink);
			    	
			    	String subject = configProperties.getProperty("MAIL_SWITCH_TRANSACTION_EXECUTED_SUBJECT");
		
			    	sendMail.MailSending(emailId,subject,"SwitchTransactionExecutedMail","SwitchTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName,"");
				}
		
					logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - end");
			}
		}

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerCart class - deleteCustomerCartEntry method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerCart class - deleteCustomerCartEntry method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void emptyCustomerCart (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerCart class - emptyCustomerCart method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in emptyCustomerCart : "+customerId);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("delete from CustomerCart where customerId = :customerId ");

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerCart class - emptyCustomerCart method - customerId - "+customerId+" - deleted all rows from CustomerCart table ");

			logger.debug("UpdateCustomerCart class - emptyCustomerCart method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerCart class - emptyCustomerCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerCart class - emptyCustomerCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void updateCustomerCartEntry (String customerId, String cartId, String fundId, String upfrontAmount, String sipAmount,
											String sipTenure, String sipDate, String folioNum) 
														throws MoneyBuddyException {

		logger.debug("UpdateCustomerCart class - updateCustomerCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateCustomerCartEntry : "+customerId);
		System.out.println("cartId : in updateCustomerCartEntry : "+cartId);

		try {
			
			/*if ("untilStopped".equals(sipTenure))  {
				sipTenure="99";
			}*/
			
			hibernateSession.beginTransaction();
			Query query ;
			if (sipTenure == null || "".equals(sipTenure) )  {
				System.out.println(" Inside NULL loop : value of sipTenure is :"+sipTenure+":");
				if (upfrontAmount == null || "".equals(upfrontAmount) )  
					upfrontAmount = "0";
				query = hibernateSession.createQuery("select cartId, upfrontAmount from CustomerCart where customerId=:customerId"
						+ " and fundId=:fundId and folioNumber=:folioNumber and cartId != :cartId  and transactionType='UPFRONT' ");
			}
			else {
				System.out.println(" Inside NOT NULL loop : value of sipTenure is :"+sipTenure+":");
				if (sipAmount == null || "".equals(sipAmount) )  
					sipAmount = "0";
				query = hibernateSession.createQuery("select cartId, sipAmount from CustomerCart where customerId=:customerId"
						+ " and fundId=:fundId and folioNumber=:folioNumber and sipDuration=:sipDuration "
						+ " and sipDate=:sipDate and cartId != :cartId  and transactionType='SIP' ");
				query.setParameter("sipDuration",sipTenure);
				query.setParameter("sipDate",sipDate);
			}
			
			query.setParameter("customerId",customerId);
			query.setParameter("fundId",fundId);
			query.setParameter("folioNumber",folioNum);
			query.setParameter("cartId",cartId);
			
			Iterator it=query.iterate();
			hibernateSession.getTransaction().commit();
			
			if (it.hasNext())  {
				Object[] row = (Object[]) it.next();
				
				System.out.println("sipTenure is : "+sipTenure);
				hibernateSession.beginTransaction();
				if (sipTenure == null || "".equals(sipTenure) )  {
					query = hibernateSession.createQuery("update CustomerCart set upfrontAmount = :amount, folioNumber=:folioNumber where cartId = :cartId"
							+ " and transactionType='UPFRONT' ");
					query.setParameter("amount", Integer.toString((Integer.parseInt(row[1].toString())+Integer.parseInt(upfrontAmount))));
				}
				else {
					query = hibernateSession.createQuery("update CustomerCart set sipAmount = :amount, folioNumber=:folioNumber,"
    						+ " sipDuration=:sipDuration, sipDate=:sipDate where cartId = :cartId and transactionType='SIP'");
    				query.setParameter("sipDuration",sipTenure);
    				query.setParameter("sipDate",sipDate);
    				query.setParameter("amount", Integer.toString((Integer.parseInt(row[1].toString())+Integer.parseInt(sipAmount))));
				}
	
				
				query.setParameter("folioNumber", folioNum);
				query.setParameter("cartId", row[0].toString());
				query.executeUpdate();
				hibernateSession.getTransaction().commit();
				
				hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("delete from CustomerCart where cartId = :cartId and customerId = :customerId ");

				query.setParameter("cartId", cartId);
				query.setParameter("customerId", customerId);

				query.executeUpdate();
				hibernateSession.getTransaction().commit();
				
			}
			else {
    			hibernateSession.beginTransaction();
    			if (sipTenure == null || "".equals(sipTenure) )  {
    				query = hibernateSession.createQuery("update CustomerCart set upfrontAmount = :amount, folioNumber=:folioNumber where cartId = :cartId");
    				query.setParameter("amount", upfrontAmount);
    			}
    			else {
    				query = hibernateSession.createQuery("update CustomerCart set sipAmount = :amount, folioNumber=:folioNumber,"
    						+ " sipDuration=:sipDuration, sipDate=:sipDate where cartId = :cartId");
    				query.setParameter("sipDuration",sipTenure);
    				query.setParameter("sipDate",sipDate);
    				query.setParameter("amount", sipAmount);
    			}
	
				
				query.setParameter("folioNumber", folioNum);
				query.setParameter("cartId", cartId);
				query.executeUpdate();
				hibernateSession.getTransaction().commit();
			}


			logger.debug("UpdateCustomerCart class - updateCustomerCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerCart class - updateCustomerCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerCart class - updateCustomerCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}

