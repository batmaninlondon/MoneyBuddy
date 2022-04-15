/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class UpdateCustomer {
	
	Logger logger = LogManager.getLogger(UpdateCustomer.class);

	public void updateCustomerData (String customerId, String panCard, String kycStatus, String customerName, String cusDetailsUploaded)
							throws MoneyBuddyException {

		logger.debug("UpdateCustomer class - updatePancardAndKycStatus method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update Customers set panCard = :panCard , kycStatus = :kycStatus, "
								+ "customerName = :customerName, cusDetailsUploaded = :cusDetailsUploaded where customerId = :customerId");

			query.setParameter("panCard", panCard);
			query.setParameter("kycStatus", kycStatus);
			query.setParameter("customerName", customerName);
			query.setParameter("cusDetailsUploaded", cusDetailsUploaded);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomer class - updatePancardAndKycStatus method - customerId - "+customerId+" - updated data of Customers table");

			logger.debug("UpdateCustomer class - updatePancardAndKycStatus method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomer class - updatePancardAndKycStatus method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomer class - updatePancardAndKycStatus method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void updateAddCusDetUploadedStatus (String customerId, String status) throws MoneyBuddyException {

		logger.debug("UpdateCustomer class - updateAddCusDetUploadedStatus method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateAddCusDetUploadedStatus : "+customerId);
		System.out.println("status : in updateAddCusDetUploadedStatus : "+status);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update Customers set addCusDetailsUploaded = :addCusDetailsUploaded where customerId = :customerId");
			
			query.setParameter("addCusDetailsUploaded", status);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomer class - updateAddCusDetUploadedStatus method - customerId - "+customerId+" - updated data of Customers table to set addCusDetailsUploaded status ");

			logger.debug("UpdateCustomer class - updateAddCusDetUploadedStatus method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomer class - updateAddCusDetUploadedStatus method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomer class - updateAddCusDetUploadedStatus method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	/*public int updateNameAndCustDetUploadedStatus (String customerId, String customerName, String cusDetailsUploaded) throws MoneyBuddyException {

		logger.debug("UpdateCustomer class - updateNameAndCustDetUploadedStatus method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateNameAndCustDetUploadedStatus : "+customerId);
		System.out.println("customerName : in updateNameAndCustDetUploadedStatus : "+customerName);
		System.out.println("cusDetailsUploaded : in updateNameAndCustDetUploadedStatus : "+cusDetailsUploaded);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update Customers set customerName = :customerName, cusDetailsUploaded = :cusDetailsUploaded where customerId = :customerId");
			query.setParameter("customerName", customerName);
			query.setParameter("cusDetailsUploaded", cusDetailsUploaded);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomer class - updateNameAndCustDetUploadedStatus method - customerId - "+customerId+" - updated data of Customers table to set customerName and cusDetailsUploaded ");

			logger.debug("UpdateCustomer class - updateNameAndCustDetUploadedStatus method - customerId - "+customerId+" - end");
			
			return result;

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomer class - updateNameAndCustDetUploadedStatus method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomer class - updateNameAndCustDetUploadedStatus method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}*/
	
	public void updateBseClientCreationStatus (String customerId, String bseClientCreationStatus) throws MoneyBuddyException {

		logger.debug("UpdateCustomer class - updateBseClientCreationStatus method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateBseClientCreationStatus : "+customerId);
		System.out.println("bseClientCreationStatus : in updateBseClientCreationStatus : "+bseClientCreationStatus);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update Customers set bseClientCreated = :bseClientCreated where customerId = :customerId");

			query.setParameter("bseClientCreated", bseClientCreationStatus);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomer class - updateBseClientCreationStatus method - customerId - "+customerId+" - updated data of Customers table to set bseClientCreated ");

			logger.debug("UpdateCustomer class - updateBseClientCreationStatus method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomer class - updateBseClientCreationStatus method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomer class - updateBseClientCreationStatus method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

	
	public void updateAofFormStatus (String customerId, String aofFormStatus) throws MoneyBuddyException {

		logger.debug("UpdateCustomer class - updateAofFormStatus method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateAofFormStatus : "+customerId);
		System.out.println("aofFormStatus : in updateAofFormStatus : "+aofFormStatus);

		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);
			
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update Customers set aofFormStatus = :aofFormStatus, aofCreationDate = :aofCreationDate where customerId = :customerId");

			query.setParameter("aofCreationDate", frmtdDateForDB);
			query.setParameter("aofFormStatus", aofFormStatus);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomer class - updateAofFormStatus method - customerId - "+customerId+" - updated data of Customers table to set aofFormStatus ");

			logger.debug("UpdateCustomer class - updateAofFormStatus method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomer class - updateAofFormStatus method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomer class - updateAofFormStatus method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}


}

