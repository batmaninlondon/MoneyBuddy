/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.NriCustomerDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class UpdateNriCustomerDetails {
	
	Logger logger = LogManager.getLogger(UpdateNriCustomerDetails.class);

	public void updateNriCustomerDetails (String customerId, String mobileNumber, String addressLineOne, String addressLineTwo,
				String addressLineThree, String residentialCity, String residentialState, String residentialCountry,
				String residentialPin, String taxIdentificationNumber) throws MoneyBuddyException {

		logger.debug("UpdateNriCustomerDetails class - updateNriCustomerDetails method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			hibernateSession.beginTransaction();

			NriCustomerDetails tempNriCustomerDetails  = new NriCustomerDetails(customerId, mobileNumber, addressLineOne,
					addressLineTwo, addressLineThree, residentialCity,residentialState,residentialPin,residentialCountry,
					taxIdentificationNumber); 		

			hibernateSession.saveOrUpdate(tempNriCustomerDetails);
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateNriCustomerDetails class - updateNriCustomerDetails method - customerId - "+customerId+" - updated CustomerDetails record ");

			logger.debug("UpdateNriCustomerDetails class - updateNriCustomerDetails method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateNriCustomerDetails class - updateNriCustomerDetails method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateNriCustomerDetails class - updateNriCustomerDetails method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}

