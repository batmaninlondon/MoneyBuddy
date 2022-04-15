/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryBankDetails {

	Logger logger = LogManager.getLogger(QueryBankDetails.class);
	
	public BankDetails fetchBankDetails(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryBankDetails class - fetchBankDetails method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		String bankDetails ="";
		
		try
		{
			
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from BankDetails where customerId = :customerId ");
			query.setParameter("customerId", customerId );
			
			List<BankDetails> bankDetailsList = query.list();
			
			hibernateSession.getTransaction().commit();

			logger.debug("QueryBankDetails class - fetchBankDetails method - customerId - "+customerId+" - end");

			return bankDetailsList.get(0);
		}
		catch ( HibernateException e ) {
			logger.error("QueryBankDetails class - fetchBankDetails method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryBankDetails class - existsBankDetails method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public boolean existsBankDetails(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryBankDetails class - existsBankDetails method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		boolean bankDetailsExists = false;
		try
		{
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select count(*) from BankDetails where customerId = :customerId ");
			query.setParameter("customerId", customerId );
			String count = query.uniqueResult().toString();
			
			if (!"0".equals(count))  {
				bankDetailsExists = true;					
			}
	
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryBankDetails class - existsBankDetails method - customerId - "+customerId+" - bank details exists returns true");
			logger.debug("QueryBankDetails class - existsBankDetails method - customerId - "+customerId+" - end");
			
			return bankDetailsExists;
		}
		catch ( HibernateException e ) {
			logger.error("QueryBankDetails class - existsBankDetails method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryBankDetails class - existsBankDetails method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

	public boolean sameBankDetailsExists(String customerId,String bankName, String accountType, 
						String accountNumber, String ifscCode) throws MoneyBuddyException {
		
		logger.debug("QueryBankDetails class - sameBankDetailsExists method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		boolean insertBankDetails = true;
		try
		{
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from BankDetails where customerId = :customerId ");
			query.setParameter("customerId", customerId );
			List<BankDetails> bankDetailsList = query.list();
			hibernateSession.getTransaction().commit();
			
			DesEncrypter desEncrypter = new DesEncrypter();
			for (BankDetails bankDetailsListElement : bankDetailsList )  {
				
				String hashedAccNum = desEncrypter.encrypt(accountNumber);
				if ( hashedAccNum.equals(bankDetailsListElement.getAccountNumber()) &&
							bankName.equals(bankDetailsListElement.getBankName()) && 
							accountType.equals(bankDetailsListElement.getAccountType()) &&
							ifscCode.equals(bankDetailsListElement.getIfscCode()))  {
					
					insertBankDetails = false;
					
				}
				
			}

			logger.debug("QueryBankDetails class - sameBankDetailsExists method - customerId - "+customerId+" - bank details exists returns true");
			logger.debug("QueryBankDetails class - sameBankDetailsExists method - customerId - "+customerId+" - end");
			
			return insertBankDetails;
		}
		catch ( HibernateException e ) {
			logger.error("QueryBankDetails class - sameBankDetailsExists method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryBankDetails class - sameBankDetailsExists method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
}
