/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class UpdateCustomerPassword {
	
	Logger logger = LogManager.getLogger(UpdateCustomerPassword.class);

	public void updatePassword (String customerId, String emailId, String newPassword) throws MoneyBuddyException {

		logger.debug("UpdateCustomerPassword class - updatePassword method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			/*DesEncrypter desEncrypter = new DesEncrypter();*/
			newPassword = DesEncrypter.MONEYBUDDY.encrypt(customerId+newPassword);
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update CustomerPasswordsHistory set password = :newPassword" + " where customerId = :customerId");

			query.setParameter("newPassword", newPassword);

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerPassword class : UpdatePassword method : updated data of CustomerPasswordsHistory table to set password for customerId : "+customerId);
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("update Customers set password = :newPassword" + " where customerId = :customerId");

			query.setParameter("newPassword", newPassword);

			query.setParameter("customerId", customerId);

			result = query.executeUpdate();
			hibernateSession.getTransaction().commit();
			

			System.out.println("newPassword : "+newPassword);
			
			logger.debug("UpdateCustomerPassword class - updatePassword method - customerId - "+customerId+" - updated data of Customers table to set password ");
			logger.debug("UpdateCustomerPassword class - updatePassword method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerPassword class - updatePassword method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerPassword class - updatePassword method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}


}

