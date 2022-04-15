/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class UpdateCustomerDetails {
	
	Logger logger = LogManager.getLogger(UpdateCustomerDetails.class);

	public void updateCustomerDetails (String customerId, String dateOfBirth, String addressLineOne, String addressLineTwo,
				String addressLineThree, String residentialCity, String residentialState, String residentialCountry,
				String residentialPin, String taxStatus, String gender, String occupation, String nomineeName, 
				String nomineeRelationship, String placeOfBirth, String countryOfBirth, String taxResidency, String incomeSlab, 
				String politicallyExposed) throws MoneyBuddyException {

		logger.debug("UpdateCustomerDetails class - updateCustomerDetails method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			hibernateSession.beginTransaction();

			CustomerDetails tempCustomerDetails  = new CustomerDetails(customerId, gender, occupation, dateOfBirth, addressLineOne,
					addressLineTwo, addressLineThree, residentialCity, residentialState, residentialPin, residentialCountry, taxStatus, 
					nomineeName, nomineeRelationship,placeOfBirth,countryOfBirth,taxResidency,incomeSlab,politicallyExposed); 		

			hibernateSession.saveOrUpdate(tempCustomerDetails);
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerDetails class - updateCustomerDetails method - customerId - "+customerId+" - updated CustomerDetails record ");

			logger.debug("UpdateCustomerDetails class - updateCustomerDetails method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerDetails class - updateCustomerDetails method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerDetails class - updateCustomerDetails method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}

