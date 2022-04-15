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

import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.PrimaryFundDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class InsertCustomerCart {

	Logger logger = LogManager.getLogger(InsertCustomerCart.class);
	
	
	public void insertRow (FundDetailsDataModel selectedFundDetailsDataModel, String customerId, String transactionType) throws MoneyBuddyException
    {

    	logger.debug("InsertCustomerCart class - insertRow method - customerId - "+customerId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	CustomerCart tempCustomerCart = null;
    	try {

    			
    			QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
    			
    			String rta = querySecondaryFundDetails.getRta(selectedFundDetailsDataModel.getFundId());
    			
    			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			Date date = new Date();
    			String frmtdDate = dateFormat.format(date);
    			
    			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
    			String folioNumList = queryTransactionDetails.getFolioNumsList(customerId, selectedFundDetailsDataModel.getFundId());
/*    			
    			hibernateSession.beginTransaction();
    			Query query = hibernateSession.createQuery("select transactionFolioNum from TransactionDetails "
    					+ " where customerId = :customerId and fundId = :fundId and  transactionDate = "
    					+ " (select max(transactionDate) from TransactionDetails where fundId = :fundId and transactionFolioNum is not null and "
    					+ " transactionFolioNum != 'New')");
    			
    			query.setParameter("customerId", customerId);
    			query.setParameter("fundId", selectedFundDetailsDataModel.getFundId());
    			 
    			Object obj = query.uniqueResult();*/
    			
    			System.out.println("LETS SET SEL FOLIO NUMBER AS : "+folioNumList);
    			String selFolioNum = "New";
    			int iend = folioNumList.indexOf(":"); 
    			if (iend != -1) 
    			{
    				selFolioNum= folioNumList.substring(0 , iend); //this will give abc
    			}
    			
    			
    			
    			
    		   /* if (obj != null) {
    		    	selFolioNum = obj.toString();
    		    }
    					 
    			hibernateSession.getTransaction().commit();*/
    			
	    		hibernateSession.beginTransaction();
	    		if ("UPFRONT".equalsIgnoreCase(transactionType))  {
	    			tempCustomerCart = new CustomerCart(customerId,selectedFundDetailsDataModel.getFundId(),selectedFundDetailsDataModel.getSchemeName(),
	    					selectedFundDetailsDataModel.getMinPurchaseAmount(),selectedFundDetailsDataModel.getUpfrontMultiplier(),selectedFundDetailsDataModel.getMinSipAmount(),"0","0",transactionType,null,null,null,selFolioNum,folioNumList,frmtdDate,"Pending",rta,
	    					selectedFundDetailsDataModel.getPdfFilePath());
	    		}
	    		else {
	    			tempCustomerCart = new CustomerCart(customerId,selectedFundDetailsDataModel.getFundId(),selectedFundDetailsDataModel.getSchemeName(),
	    					selectedFundDetailsDataModel.getMinPurchaseAmount(),selectedFundDetailsDataModel.getUpfrontMultiplier(),selectedFundDetailsDataModel.getMinSipAmount(),"0","0",transactionType,"99",null,
	    					"1",selFolioNum,folioNumList,frmtdDate,"Pending",rta,
	    					selectedFundDetailsDataModel.getPdfFilePath());
	    		}
	    		
	   	        hibernateSession.save(tempCustomerCart);
	   	        hibernateSession.flush();
	   	        hibernateSession.refresh(tempCustomerCart);
	   	        
	   	        hibernateSession.getTransaction().commit();
	   	        logger.debug("InsertCustomerCart class - insertRow method - customerId - "+customerId+" - new record inserted in CustomerCart table");
   	        

    		
    		logger.debug("InsertCustomerCart class - insertRow method - customerId - "+customerId+" - end");

    	}
    	catch ( HibernateException e ) {
    		logger.error("InsertCustomerCart class - insertRow method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerCart class - insertRow method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
	
	
	public void addCustomerCart (String customerId, String fundId, String schemeName, String amount,
    		String transactionType, String sipDuration, String sipPlan, String sipDate, String folioNum,
			String cartCreationDate, String status) throws MoneyBuddyException
    {

    	logger.debug("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	CustomerCart tempCustomerCart = null;
    	Query query ;
    	try {
    		
    		System.out.println("InsertCustomerCart class - addCustomerCart method - sipDuration : "+sipDuration+" and sipDate : "+sipDate);
    		hibernateSession.beginTransaction();
    		
    		if ("UPFRONT".equalsIgnoreCase(transactionType))  {

    		query = hibernateSession.createQuery("from CustomerCart where customerId = :customerId and fundId = :fundId "
    				+ " and folioNumber = :folioNumber and transactionType = :transactionType ");
    		
    		
    		}
    		else {
    			query = hibernateSession.createQuery("from CustomerCart where customerId = :customerId and fundId = :fundId "
        				+ " and folioNumber = :folioNumber and transactionType = :transactionType and sipDuration = :sipDuration and sipPlan = :sipPlan and sipDate = :sipDate ");
        		
        		query.setParameter("sipDuration", sipDuration);
        		query.setParameter("sipPlan", sipPlan);
        		query.setParameter("sipDate", sipDate);
    		}
    		
    		query.setParameter("customerId", customerId);
    		query.setParameter("fundId", fundId);
    		query.setParameter("folioNumber", folioNum);
    		query.setParameter("transactionType", transactionType);
    		
    		List<CustomerCart> cartList = query.list();
    		
    		hibernateSession.getTransaction().commit();
    		
    		
    		/*hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select distinct(folioNumber) from CustomerCart where customerId = :customerId and fundId = :fundId ");
			query.setParameter("customerId", customerId);
			query.setParameter("fundId", fundId);
			
			List<String> folioList = query.list();
			
			
			hibernateSession.getTransaction().commit();*/
			
    		System.out.println("folioNum is : "+folioNum);
    		
    		System.out.println("amount :"+amount);
    		if ( cartList.size() != 0)  {
    			
    			
    			
    			System.out.println(fundId+" exist in customerCart");
    			/*hibernateSession.beginTransaction();
    			query = hibernateSession.createQuery("select amount from CustomerCart where customerId = :customerId and fundId = :fundId  and folioNumber = :folioNumber");
    			query.setParameter("customerId", customerId);
    			query.setParameter("fundId", fundId);
    			query.setParameter("folioNumber", folioNum);
    			
    			Object result = query.uniqueResult();
    			
    			if (null == result) throw new MoneyBuddyException("amount not found, which fundId exsited ");*/
    			Double updatedAmount;
    			if ("UPFRONT".equalsIgnoreCase(cartList.get(0).getTransactionType()))  {
					updatedAmount = Double.parseDouble(cartList.get(0).getUpfrontAmount()) + Double.parseDouble(amount);
					System.out.println("Existed amount : "+cartList.get(0).getUpfrontAmount()+" currentAmount: "+amount+" updated amount : "+updatedAmount);
    			}
    			else {
    				updatedAmount = Double.parseDouble(cartList.get(0).getSipAmount()) + Double.parseDouble(amount);
    				System.out.println("Existed amount : "+cartList.get(0).getSipAmount()+" currentAmount: "+amount+" updated amount : "+updatedAmount);
    			}
    			
    			
    			/*hibernateSession.getTransaction().commit();*/
    			hibernateSession.beginTransaction();
    			
    			System.out.println(" amount : "+updatedAmount+" and folioNumber : "+folioNum+"  has to be updated for customerId : "+customerId+" and fundId : "+fundId);
    			
    			if ("UPFRONT".equalsIgnoreCase(transactionType))  {
    				query = hibernateSession.createQuery("update CustomerCart set upfrontAmount = :updatedAmount "
    					+ " where customerId = :customerId and fundId = :fundId and folioNumber = :folioNumber "
    					+ " and transactionType=:transactionType ");
    			}
    			else {
    				query = hibernateSession.createQuery("update CustomerCart set sipAmount = :updatedAmount "
        					+ " where customerId = :customerId and fundId = :fundId and folioNumber = :folioNumber "
        					+ " and transactionType=:transactionType and sipDuration=:sipDuration and sipPlan=:sipPlan and sipDate=:sipDate ");

        			query.setParameter("sipDuration", sipDuration);
        			query.setParameter("sipPlan", sipPlan);
        			query.setParameter("sipDate", sipDate);
        			
    			}
    			query.setParameter("updatedAmount", Double.toString(updatedAmount));
    			query.setParameter("transactionType", transactionType);
    			query.setParameter("folioNumber", folioNum);
    			query.setParameter("customerId", customerId);
    			query.setParameter("fundId", fundId);
    			
    			query.executeUpdate();
    			
    			hibernateSession.getTransaction().commit();
    			logger.debug("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - record updated in CustomerCart table for fundId - "+fundId);
    			
    		}
    		else {
    			System.out.println(fundId+" does not exist in customerCart");
    			
    			QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
    			
    			String rta = querySecondaryFundDetails.getRta(fundId);
    			
    			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
    			
    			PrimaryFundDetails primaryFundDetails = queryPrimaryFundDetails.getPrimaryFundDetail(fundId);
        		
	    		hibernateSession.beginTransaction();
	    		if ("UPFRONT".equalsIgnoreCase(transactionType))
	    			tempCustomerCart = new CustomerCart(customerId,fundId,schemeName,primaryFundDetails.getMinPurchaseAmount(),primaryFundDetails.getUpfrontMultiplier(),
	    					primaryFundDetails.getMinSipAmount(),amount,"0",transactionType,sipDuration,sipPlan,sipDate,folioNum,
	    					null,cartCreationDate,status,rta,primaryFundDetails.getPdfFilePath());
	    		else
	    			tempCustomerCart = new CustomerCart(customerId,fundId,schemeName,primaryFundDetails.getMinPurchaseAmount(),primaryFundDetails.getUpfrontMultiplier(),
	    					primaryFundDetails.getMinSipAmount(),"0",amount,transactionType,sipDuration,sipPlan,sipDate,folioNum,
	    					null,cartCreationDate,status,rta,primaryFundDetails.getPdfFilePath());
	    		
	   	        hibernateSession.save(tempCustomerCart);
	   	        hibernateSession.flush();
	   	        hibernateSession.refresh(tempCustomerCart);
	   	        
	   	        hibernateSession.getTransaction().commit();
	   	        logger.debug("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - new record inserted in CustomerCart table");
   	        
    		}
    		
    		logger.debug("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - end");

    	}
    	/*catch ( MoneyBuddyException e ) {
    		logger.error("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - Caught MoneyBuddyException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}*/
    	catch ( HibernateException e ) {
    		logger.error("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
 
}




