/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
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
	
	Logger logger = Logger.getLogger(UploadCustomerNav.class);

	public void uploadCusNav ( String bseOrderId,String folNum,String navValue, String units) throws MoneyBuddyException {

		logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
		hibernateSession.beginTransaction();

		Query query = hibernateSession.createQuery("select t.fundId, c.panCard, t.customerId, t.transactionFolioNum,s.amcCode,t.transactionType,t.transactionDetailId "
								+ "from Customers c, TransactionDetails t, SecondaryFundDetails s "
								+ "where t.customerId = c.customerId and t.fundId = s.fundId and t.bseOrderId= :bseOrderId");
		

		query.setParameter("bseOrderId", bseOrderId);
		
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
		String transactionDetailId = queryResult.get(0)[6].toString();
		
		System.out.println(" panCard : "+panCard+" : customerId : "+customerId+" : folioNum : "+folNum+" : amcCode : "+amcCode);
		
		hibernateSession.getTransaction().commit();
		
		if ("".equals(folioNum) || folioNum == null)  {
			
			hibernateSession.beginTransaction();

			FolioDetails tempFolioDetails = new FolioDetails( folNum, customerId, panCard,fundId,amcCode,"MoneyBuddy");
			hibernateSession.save(tempFolioDetails);
			
			hibernateSession.getTransaction().commit();

		}

		hibernateSession.beginTransaction();
		query = hibernateSession.createQuery("update TransactionDetails set transactionFolioNum = :transactionFolioNum , "
				+ "unitPrice = :unitPrice , quantity = :quantity , bseOrderId = :bseOrderId, transactionStatus = :transactionStatus , reverseFeed = :reverseFeed "
				+ " where transactionDetailId = :transactionDetailId");

		query.setParameter("transactionFolioNum", folNum);
		query.setParameter("unitPrice", navValue);
		query.setParameter("quantity", units);
		query.setParameter("bseOrderId", bseOrderId);
		query.setParameter("transactionDetailId", transactionDetailId);
		query.setParameter("transactionStatus", "8");
		query.setParameter("reverseFeed", "Y");
		
		int updateResult = query.executeUpdate();
		System.out.println(updateResult + " rows updated in transactionDetails table ");
		hibernateSession.getTransaction().commit();	
		
		Customers customers = new QueryCustomer().getCustomerFromCustomerId(customerId);
    	
    	String emailId = customers.getEmailId();
    	String customerName = customers.getCustomerName();
    	
    	SendMail sendMail = new SendMail();

    	Properties configProperties = new Properties();
		String configPropFilePath = "../../../config/config.properties";

		configProperties.load(ForgotPasswordAction.class.getResourceAsStream(configPropFilePath));
		
		if ("UPFRONT".equals(transactionType))  {
 			String mailLink = configProperties.getProperty("MAIL_UPFRONT_TRANSACTION_EXECUTED_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_UPFRONT_TRANSACTION_EXECUTED_SUBJECT");

	    	sendMail.MailSending(emailId,subject,"UpfrontTransactionExecutedMail","UpfrontTransactionExecutedMail.txt",mailLink,"LoginToMoneyBuddy",customerName);
		}
		else {
			String mailLink = configProperties.getProperty("MAIL_SIP_TRANSACTION_EXECUTED_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_SIP_TRANSACTION_EXECUTED_SUBJECT");

	    	sendMail.MailSending(emailId,subject,"SipTransactionExecutedMail","SipTransactionExecutedMail.txt",mailLink,"LoginToMoneyBuddy",customerName);
		}

			logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - end");

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

