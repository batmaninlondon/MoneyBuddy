/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.myMoneyBuddy.EntityClasses.SwitchCart;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class InsertCustomerSwitchCart {

	Logger logger = LogManager.getLogger(InsertCustomerSwitchCart.class);
	
	
	public void insertRow (String customerId, String withdrawalFundId,  String folioNumber, String totalWithdrawalAmount, String totalWithdrawalUnit) throws MoneyBuddyException
    {

    	logger.debug("InsertCustomerSwitchCart class - insertRow method - customerId - "+customerId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	SwitchCart tempSwitchCart = null;
    	try {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);
			
			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
			String withdrawalSchemeName = queryPrimaryFundDetails.getSchemeName(withdrawalFundId);
			
			
			String availableFundsList = queryPrimaryFundDetails.getAvailableSwitchFundsList(withdrawalFundId);
			String purchaseFundID = queryPrimaryFundDetails.getFundId(availableFundsList.substring(0,availableFundsList.indexOf(":")));
			
			String minSwitchAmount = queryPrimaryFundDetails.getMinSwitchAmount(withdrawalFundId);
			
			hibernateSession.beginTransaction();
			String latestNavValue = hibernateSession.createQuery("select navValue from NavHistory where fundId='"+withdrawalFundId+"' and NAV_DATE = "
					+ " (select max(navDate) from NavHistory where fundId='"+withdrawalFundId+"')").uniqueResult().toString();
			hibernateSession.getTransaction().commit();
			
    		hibernateSession.beginTransaction();
    		tempSwitchCart = new SwitchCart(customerId,withdrawalFundId,withdrawalSchemeName,totalWithdrawalAmount,totalWithdrawalUnit,folioNumber,
    					purchaseFundID,availableFundsList.substring(0,availableFundsList.indexOf(":")),
    				 availableFundsList,minSwitchAmount,"0","0",null,null,frmtdDate,latestNavValue);
    		
    		
   	        hibernateSession.save(tempSwitchCart);
   	        hibernateSession.flush();
   	        hibernateSession.refresh(tempSwitchCart);
   	        
   	        hibernateSession.getTransaction().commit();
   	        logger.debug("InsertCustomerSwitchCart class - insertRow method - customerId - "+customerId+" - new record inserted in CustomerCart table");

    		logger.debug("InsertCustomerSwitchCart class - insertRow method - customerId - "+customerId+" - end");

    	}
    	catch ( HibernateException e ) {
    		logger.error("InsertCustomerSwitchCart class - insertRow method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerSwitchCart class - insertRow method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
	
	
	public void addCustomerSwitchCart (String customerId, String fundId, String schemeName, String minRedAmount, String redAmount, String redUnits,
			String totalRedAmount, String totalRedUnits, String redemptionOption, String redemptionType, String folioNumber) throws MoneyBuddyException
    {

    	logger.debug("InsertCustomerSwitchCart class - addCustomerSwitchCart method - customerId - "+customerId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	RedemptionCart tempRedemptionCart = null;
    	Query query ;
    	try {
    		
    		hibernateSession.beginTransaction();
    		

    		query = hibernateSession.createQuery("from RedemptionCart where customerId = :customerId and fundId = :fundId "
    				+ " and folioNumber = :folioNumber ");
    		
    		
    		query.setParameter("customerId", customerId);
    		query.setParameter("fundId", fundId);
    		query.setParameter("folioNumber", folioNumber);
    		
    		List<RedemptionCart> cartList = query.list();
    		
    		hibernateSession.getTransaction().commit();
			
    		
    		if ( cartList.size() != 0)  {

    			System.out.println(fundId+" exist in customerCart");
    			
    			Double updatedAmount;
    			
				updatedAmount = Double.parseDouble(cartList.get(0).getRedAmount()) + Double.parseDouble(redAmount);
				System.out.println("Existed amount : "+cartList.get(0).getRedAmount()+" currentAmount: "+redAmount+" updated amount : "+updatedAmount);
   
    			hibernateSession.beginTransaction();
    			
    			System.out.println(" amount : "+updatedAmount+" and folioNumber : "+folioNumber+"  has to be updated for customerId : "+customerId+" and fundId : "+fundId);
    			
				query = hibernateSession.createQuery("update RedemptionCart set redAmount = :redAmount, redUnits = :redUnits, redemptionOption = :redemptionOption, "
						+ " redemptionType = :redemptionType where customerId = :customerId and fundId = :fundId and folioNumber = :folioNumber ");
			
    			query.setParameter("redAmount", redAmount);
    			query.setParameter("redUnits", redUnits);
    			query.setParameter("redemptionOption", redemptionOption);
    			query.setParameter("redemptionType", redemptionType);
    			query.setParameter("folioNumber", folioNumber);
    			query.setParameter("customerId", customerId);
    			query.setParameter("fundId", fundId);
    			
    			query.executeUpdate();
    			
    			hibernateSession.getTransaction().commit();
    			logger.debug("InsertCustomerSwitchCart class - addCustomerSwitchCart method - customerId - "+customerId+" - record updated in CustomerCart table for fundId - "+fundId);
    			
    		}
    		else {
    			System.out.println(fundId+" does not exist in customerCart");
    			
    			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			Date date = new Date();
    			String frmtdDate = dateFormat.format(date);
    			
    			hibernateSession.beginTransaction();
    			String latestNavValue = hibernateSession.createQuery("select navValue from NavHistory where fundId='"+fundId+"' and NAV_DATE = "
    					+ " (select max(navDate) from NavHistory where fundId='"+fundId+"')").uniqueResult().toString();
    			hibernateSession.getTransaction().commit();
    			
    			
    			tempRedemptionCart = new RedemptionCart(customerId,fundId,schemeName,minRedAmount,redAmount,redUnits,totalRedAmount,
    					totalRedUnits,redemptionOption,redemptionType,folioNumber,frmtdDate,"Pending",latestNavValue);
	    	
	    		
	   	        hibernateSession.save(tempRedemptionCart);
	   	        hibernateSession.flush();
	   	        hibernateSession.refresh(tempRedemptionCart);
	   	        
	   	        hibernateSession.getTransaction().commit();
	   	        logger.debug("InsertCustomerSwitchCart class - addCustomerSwitchCart method - customerId - "+customerId+" - new record inserted in CustomerCart table");
   	        
    		}
    		
    		logger.debug("InsertCustomerSwitchCart class - addCustomerSwitchCart method - customerId - "+customerId+" - end");

    	}
    	catch ( HibernateException e ) {
    		logger.error("InsertCustomerSwitchCart class - addCustomerSwitchCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerSwitchCart class - addCustomerRedemptionCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
 
}




