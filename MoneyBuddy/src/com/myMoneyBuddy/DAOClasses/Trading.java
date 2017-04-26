/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.tempuri.IMFUploadService;
import org.tempuri.MFOrderEntry;

import com.myMoneyBuddy.ActionClasses.PaymentAction;
import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.EntityClasses.PaymentDetails;
//import com.myMoneyBuddy.EntityClasses.PriceHistory;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.EntityClasses.Transactions;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceMFUpload;

import org.apache.log4j.Logger;

public class Trading {
	
	Logger logger = Logger.getLogger(Trading.class);

	public String createClient(String CLIENT_HOLDING, String CLIENT_TAXSTATUS, String CLIENT_OCCUPATIONCODE, String CLIENT_DOB,
							String CLIENT_GENDER, String CLIENT_GUARDIAN, String CLIENT_ACCTYPE_1, String CLIENT_ACCNO_1, String CLIENT_NEFT_IFSCCODE_1,
							String CLIENT_ADD_1, String CLIENT_CITY, String CLIENT_STATE, String CLIENT_PINCODE, String CLIENT_COUNTRY,
							String customerId, String CLIENT_APPNAME1, String CLIENT_EMAIL, String CLIENT_PAN, String CLIENT_CM_MOBILE) throws MoneyBuddyException {
		

		try {
			String PASSWORD_MFUPLOAD;
		
		Properties properties = new Properties();
		String propFilePath = "../../../config/client.properties";

	    properties.load(Trading.class.getResourceAsStream(propFilePath));

	    WebServiceMFUpload wbMFUpload = new WebServiceMFUpload();		
		IMFUploadService imfUploadService = wbMFUpload.getWSHttpBindingIMFUploadService();
		
		String[] clientDetailsArray = {customerId,CLIENT_HOLDING,CLIENT_TAXSTATUS,CLIENT_OCCUPATIONCODE,CLIENT_APPNAME1,properties.getProperty("CLIENT_APPNAME2"),properties.getProperty("CLIENT_APPNAME3"),CLIENT_DOB,CLIENT_GENDER,properties.getProperty("CLIENT_GUARDIAN"),
				CLIENT_PAN,properties.getProperty("CLIENT_NOMINEE"),properties.getProperty("CLIENT_NOMINEE_RELATION"),properties.getProperty("CLIENT_GUARDIANPAN"),properties.getProperty("CLIENT_TYPE"),properties.getProperty("CLIENT_DEFAULTDP"),properties.getProperty("CLIENT_CDSLDPID"),properties.getProperty("CLIENT_CDSLCLTID"),properties.getProperty("CLIENT_NSDLDPID"),properties.getProperty("CLIENT_NSDLCLTID"),
				CLIENT_ACCTYPE_1,CLIENT_ACCNO_1,properties.getProperty("CLIENT_MICRNO_1"),CLIENT_NEFT_IFSCCODE_1,properties.getProperty("CLIENT_DEFAULT_BANK_FLAG_1"),properties.getProperty("CLIENT_ACCTYPE_2"),properties.getProperty("CLIENT_ACCNO_2"),properties.getProperty("CLIENT_MICRNO_2"),properties.getProperty("CLIENT_NEFT_IFSCCODE_2"),properties.getProperty("CLIENT_DEFAULT_BANK_FLAG_2"),
				properties.getProperty("CLIENT_ACCTYPE_3"),properties.getProperty("CLIENT_ACCNO_3"),properties.getProperty("CLIENT_MICRNO_3"),properties.getProperty("CLIENT_NEFT_IFSCCODE_3"),properties.getProperty("CLIENT_DEFAULT_BANK_FLAG_3"),properties.getProperty("CLIENT_ACCTYPE_4"),properties.getProperty("CLIENT_ACCNO_4"),properties.getProperty("CLIENT_MICRNO_4"),properties.getProperty("CLIENT_NEFT_IFSCCODE_4"),properties.getProperty("CLIENT_DEFAULT_BANK_FLAG_4"),
				properties.getProperty("CLIENT_ACCTYPE_5"),properties.getProperty("CLIENT_ACCNO_5"),properties.getProperty("CLIENT_MICRNO_5"),properties.getProperty("CLIENT_NEFT_IFSCCODE_5"),properties.getProperty("CLIENT_DEFAULT_BANK_FLAG_5"),properties.getProperty("CLIENT_CHEQUENAME_5"),CLIENT_ADD_1,properties.getProperty("CLIENT_ADD_2"),properties.getProperty("CLIENT_ADD_3"),CLIENT_CITY,
				CLIENT_STATE,CLIENT_PINCODE,CLIENT_COUNTRY,properties.getProperty("CLIENT_RESIPHONE"),properties.getProperty("CLIENT_RESIFAX"),properties.getProperty("CLIENT_OFFICEPHONE"),properties.getProperty("CLIENT_OFFICEFAX"),CLIENT_EMAIL,properties.getProperty("CLIENT_COMMMODE"),properties.getProperty("CLIENT_DIVPAYMODE"), 
				properties.getProperty("CLIENT_PAN_2"),properties.getProperty("CLIENT_PAN_3"),properties.getProperty("CLIENT_MAPIN_NO"),properties.getProperty("CLIENT_CM_FORADD_1"),properties.getProperty("CLIENT_CM_FORADD_2"),properties.getProperty("CLIENT_CM_FORADD_3"),properties.getProperty("CLIENT_CM_FORCITY"),properties.getProperty("CLIENT_CM_FORPINCODE"),properties.getProperty("CLIENT_CM_FORSTATE"),properties.getProperty("CLIENT_CM_FORCOUNTRY"),
				properties.getProperty("CLIENT_CM_FORRESIPHONE"),properties.getProperty("CLIENT_CM_FORRESIFAX"),properties.getProperty("CLIENT_CM_FOROFFPHONE"),properties.getProperty("CLIENT_CM_FOROFFFAX"),CLIENT_CM_MOBILE};
		
		String clientDetails = String.join("|",clientDetailsArray);

		System.out.println("clientDetails : "+clientDetails);
	
		String passwordMFUpload = imfUploadService.getPassword(properties.getProperty("USER_ID"),properties.getProperty("MEMBER_ID"),properties.getProperty("PASSWORD"),properties.getProperty("PASS_KEY"));
		
		String[] resultsMFUpload = passwordMFUpload.split("\\|");
		
		for (int i = 0 ; i <resultsMFUpload.length ; i++ )   {
			System.out.println("resultsMFUpload : "+i+" : " +resultsMFUpload[i]);
		}
		
		
		System.out.println("passwordMFUpload : "+passwordMFUpload);
		
		PASSWORD_MFUPLOAD = resultsMFUpload[1];
		
		String ucc = imfUploadService.mfapi("02",properties.getProperty("USER_ID"),PASSWORD_MFUPLOAD,clientDetails);

		System.out.println("ucc : "+ucc);

		return ucc;
		
		}catch (IOException e) {
			logger.debug("Trading class : executeTrade method : Caught exception for customerId : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.debug("Trading class : executeTrade method : Caught exception for customerId : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		}
		
	}
	
	public String executeTrade(String customerId, String amount, Map<String, Double> productDetailsMap, String transactionType, String paymentGatewayComment, String groupName) throws MoneyBuddyException {
		
		SessionFactory factoryTransactions = null;
		//SessionFactory factoryPriceHistory = null;
		SessionFactory factoryTransactionDetails = null;
		SessionFactory factoryPaymentDetails = null;
		SessionFactory factoryCustomerPortfolio = null;
		Session sessionTransactions = null;
		//Session sessionPriceHistory = null;
		Session sessionTransactionDetails = null;
		Session sessionPaymentDetails = null;
		Session sessionCustomerPortfolio = null;
		Double totalAmount = 0.0;
		int quantity; 
		String transactionDetailId;
		String currentPrice;
		int pendingOrders;
		Query query;
		//List<PriceHistory> priceHistory;
		Transactions tempTransaction;
		TransactionDetails tempTransactionDetail;
		PaymentDetails tempPaymentDetail;
		CustomerPortfolio tempCustomerPortfolio;
		
		try {
			//TODO there should be no need to create so many SessionFactory objects, it is taken care by JPA/HIbernate by default... this needs changing
			logger.debug("Trading class : executeTrade method : start");
			factoryTransactions = new AnnotationConfiguration()
											.configure()
											.addAnnotatedClass(Transactions.class)
											.buildSessionFactory();
			sessionTransactions = factoryTransactions.openSession();
			
			/*factoryPriceHistory = new AnnotationConfiguration()
														.configure()
														.addAnnotatedClass(PriceHistory.class)
														.buildSessionFactory();
			sessionPriceHistory = factoryPriceHistory.openSession();*/
			
			factoryTransactionDetails = new AnnotationConfiguration()
														.configure()
														.addAnnotatedClass(TransactionDetails.class)
														.buildSessionFactory();
			sessionTransactionDetails = factoryTransactionDetails.openSession();
			
			factoryPaymentDetails = new AnnotationConfiguration()
															.configure()
															.addAnnotatedClass(PaymentDetails.class)
															.buildSessionFactory();
			sessionPaymentDetails = factoryPaymentDetails.openSession();

			factoryCustomerPortfolio = new AnnotationConfiguration()
															.configure()
															.addAnnotatedClass(CustomerPortfolio.class)
															.buildSessionFactory();
			sessionCustomerPortfolio = factoryCustomerPortfolio.openSession();
	
			sessionTransactions.beginTransaction();
			//sessionPriceHistory.beginTransaction();
			
			sessionPaymentDetails.beginTransaction();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);
			     
			for ( Double currentAmount : productDetailsMap.values())  {
				totalAmount = totalAmount + currentAmount;
			}
			
			tempTransaction = new Transactions(customerId, Double.toString(totalAmount),
					transactionType, "Pending",frmtdDate,frmtdDate);
			
			sessionTransactions.save(tempTransaction);
			sessionTransactions.getTransaction().commit();
			
			logger.debug("Trading class : executeTrade method : inserted data to Transactions table for customerId : "+customerId);
			
			String transactionId = tempTransaction.getTransactionId();
			
			tempPaymentDetail = new PaymentDetails( transactionId, 
					paymentGatewayComment, frmtdDate,frmtdDate);

			sessionPaymentDetails.save(tempPaymentDetail);
			sessionPaymentDetails.getTransaction().commit();
			
			Properties properties = new Properties();
			String propFilePath = "../../../config/client.properties";

		    properties.load(PaymentAction.class.getResourceAsStream(propFilePath));
		    
			WebServiceMFOrder wbMFOrder = new WebServiceMFOrder();	
			MFOrderEntry mfOrderEntry = wbMFOrder.getWSHttpBindingMFOrderEntry();
			String passwordMFOrder;
			String[] resultsMFOrder;
			String PASSWORD_MFORDER;
			String LOGOUT_URL = "http://www.quantwealth.in/thankYou";
			WebServiceMFUpload wbMFUpload = new WebServiceMFUpload();		
			IMFUploadService imfUploadService = wbMFUpload.getWSHttpBindingIMFUploadService();
			String PASSWORD_MFUPLOAD;
	    	String passwordMFUpload;
	    	String[] resultsMFUpload;
	    	
	    	String paymentDetails;
	    	String entryParam;
	    	String[] resultsEntryParam;
	    	String[] paymentDetailsArray = {properties.getProperty("MEMBER_ID"),customerId,LOGOUT_URL};
			paymentDetails = String.join("|",paymentDetailsArray);
			 
			for ( String currentProductId : productDetailsMap.keySet())  {
									
				/*query = sessionPriceHistory.createQuery("from PriceHistory where productId = :productId and date = curdate()");
			    query.setParameter("productId",currentProductId);
			    
			    priceHistory = query.list();
			    currentPrice = priceHistory.get(0).getPrice();*/
			    //quantity = (int)(productDetailsMap.get(currentProductId)/Double.parseDouble(currentPrice));
				
			    tempTransactionDetail  = new TransactionDetails(transactionId, null, customerId,
										transactionType, Double.toString(productDetailsMap.get(currentProductId)),
						"Pending", null,null,"NO",currentProductId, frmtdDate, frmtdDate); 		
				
			    sessionTransactionDetails.beginTransaction();
			    sessionTransactionDetails.save(tempTransactionDetail);

			    logger.debug("Trading class : executeTrade method : inserted data to TransactionDetails table for customerId : "+customerId);
			    
			    sessionTransactionDetails.getTransaction().commit();
			    
			    transactionDetailId = tempTransactionDetail.getTransactionDetailId();
			    
			    
			    
			    passwordMFOrder = mfOrderEntry.getPassword(properties.getProperty("USER_ID"),properties.getProperty("PASSWORD"),properties.getProperty("PASS_KEY"));
				
				resultsMFOrder = passwordMFOrder.split("\\|");
				
				for (int i = 0 ; i <resultsMFOrder.length ; i++ )   {
					System.out.println("resultsMFOrder : "+i+" : " +resultsMFOrder[i]);
				}
				
				System.out.println("passwordMFOrder : "+passwordMFOrder);
				
				PASSWORD_MFORDER = resultsMFOrder[1];
				
				
		/*		orderEntryParam(TransactionCode, UniqueReferenceNumber, OrderId, UserID
					, MemberId, ClientCode, SchemeCode, BuySell, BuySellType, DPTxn, Amount, Qty, AllRedeem, FolioNo
						, Remarks, KYCStatus, RefNo, SubBrCode, EUIN, EUINFlag, MinRedeem, DPC, IPAdd, Password
						, PassKey, Param1 (Sub Broker ARN ), Param2, Param3 )*/
				 
				
				entryParam = mfOrderEntry.orderEntryParam(properties.getProperty("TRANSACTION_CODE"),transactionDetailId,properties.getProperty("ORDER_ID"),properties.getProperty("USER_ID"),properties.getProperty("MEMBER_ID"),customerId,properties.getProperty("SCHEME_CODE"),properties.getProperty("BUY_SELL"),properties.getProperty("BUY_SELL_TYPE"),properties.getProperty("DP_TXN"),
						amount,properties.getProperty("QTY"),properties.getProperty("ALL_REDEEM"),properties.getProperty("FOLIO_NUMBER"),properties.getProperty("REMARKS"),properties.getProperty("KYC_STATUS"),properties.getProperty("REF_NO"),properties.getProperty("SUB_BR_CODE"),properties.getProperty("EUIN"),properties.getProperty("EUIN_FLAG"),
						properties.getProperty("MIN_REDEEM"),properties.getProperty("DPC"),properties.getProperty("IP_ADDRESS"),PASSWORD_MFORDER,properties.getProperty("PASS_KEY"),properties.getProperty("PARAM_1"),properties.getProperty("PARAM_2"),properties.getProperty("PARAM_3"));
				
				System.out.println("entryParam : "+entryParam);
				
				resultsEntryParam = entryParam.split("\\|");
				
				for (int i = 0 ; i <resultsMFOrder.length ; i++ )   {
					System.out.println("resultsEntryParam : "+i+" : " +resultsEntryParam[i]);
				}

				sessionTransactionDetails.getTransaction().begin();
				query = sessionTransactionDetails.createQuery("update TransactionDetails set bseOrderId = :bseOrderId , bseRemarks = :bseRemarks , bseSuccessFlag = :bseSuccessFlag " + " where transactionDetailId = :transactionDetailId");
				query.setParameter("bseOrderId", resultsEntryParam[2]);
				query.setParameter("bseRemarks", resultsEntryParam[6]);
				query.setParameter("bseSuccessFlag", resultsEntryParam[7]);
				query.setParameter("transactionDetailId", transactionDetailId);
				int result = query.executeUpdate();
				System.out.print(result + " rows updated in transactionDetails table ");
				sessionTransactionDetails.getTransaction().commit();
			    
			    query = sessionCustomerPortfolio.createQuery("from CustomerPortfolio where productId = :productId and customerId = :customerId and investmentTypeName = :groupName");
			    query.setParameter("productId",currentProductId);
			    query.setParameter("customerId",customerId);
			    query.setParameter("groupName",groupName);
			    
			    List<CustomerPortfolio> customerPortfolio = query.list();
			    
			    pendingOrders = 0;
			    
/*			    if ("SELL".equals(transactionType))  
					pendingOrders -= quantity;
				else 
					pendingOrders += quantity;*/
				
				sessionCustomerPortfolio.beginTransaction();
			    if (query.list().size() != 0)  {
			    	pendingOrders += Integer.parseInt(customerPortfolio.get(0).getPendingOrders());

			    	customerPortfolio.get(0).setPendingOrders(Integer.toString(pendingOrders));
			    	customerPortfolio.get(0).setTransactionDetailId(transactionDetailId);
			    	customerPortfolio.get(0).setUpdateDate(frmtdDate);
			    	
			    }
			    else {

			    	tempCustomerPortfolio = new CustomerPortfolio(customerId, currentProductId,
			    				"0", Integer.toString(pendingOrders),transactionDetailId,
			    				null,groupName,null,frmtdDate,frmtdDate);

			    	
			    	sessionCustomerPortfolio.save(tempCustomerPortfolio);
			    	
			    }
			    sessionCustomerPortfolio.getTransaction().commit();
			    
			    logger.debug("Trading class : executeTrade method : inserted data to CustomerPortfolio table for customerId : "+customerId);
			    
			    

			}
			
			passwordMFUpload = imfUploadService.getPassword(properties.getProperty("USER_ID"),properties.getProperty("MEMBER_ID"),properties.getProperty("PASSWORD"),properties.getProperty("PASS_KEY"));
			
			resultsMFUpload = passwordMFUpload.split("\\|");
			
			for (int i = 0 ; i <resultsMFUpload.length ; i++ )   {
				System.out.println("resultsMFUpload : "+i+" : " +resultsMFUpload[i]);
			}
			
			
			System.out.println("passwordMFUpload : "+passwordMFUpload);
			
			PASSWORD_MFUPLOAD = resultsMFUpload[1];

			String paymentGateway = imfUploadService.mfapi("03",properties.getProperty("USER_ID"),PASSWORD_MFUPLOAD,paymentDetails);

			System.out.println("paymentGateway : "+paymentGateway);
			
			String[] resultsPaymentGateway = paymentGateway.split("\\|");
			
			for (int i = 0 ; i <resultsPaymentGateway.length ; i++ )   {
				System.out.println("resultsPaymentGateway : "+i+" : " +resultsPaymentGateway[i]);
			}
			
			String paymentUrl = resultsPaymentGateway[1];
			System.out.println("paymentUrl: "+paymentUrl);


			
			logger.debug("Trading class : executeTrade method : end");
			return paymentUrl;
		} catch (NumberFormatException | HibernateException e) {
			logger.debug("Trading class : executeTrade method : Caught exception for customerId : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.debug("Trading class : executeTrade method : Caught exception for customerId : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		}
		finally {
			if(sessionTransactions!=null)
				sessionTransactions.close();
			
			/*if(sessionPriceHistory!=null)
				sessionPriceHistory.close();*/
			
			if(sessionTransactionDetails!=null)
				sessionTransactionDetails.close();
			
			if(sessionPaymentDetails!=null)
				sessionPaymentDetails.close();
			
			if(sessionCustomerPortfolio!=null)
				sessionCustomerPortfolio.close();
		}

	}
	
	/*public double calculateProfit(String productId, String fromDate, String toDate) throws MoneyBuddyException {
		
		SessionFactory factoryPriceHistory = null;
		Session sessionPriceHistory = null;
		Query query;
		List<PriceHistory> priceHistory;
		double fromDatePrice ;
		double toDatePrice;
		double profit = 0.0;
		
		try {
			logger.debug("Trading class : calculateProfit method : start");
		
		factoryPriceHistory = new AnnotationConfiguration()
													.configure()
													.addAnnotatedClass(PriceHistory.class)
													.buildSessionFactory();
		sessionPriceHistory = factoryPriceHistory.openSession();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = dateFormat.parse(fromDate);
			fromDate = dateFormat.format(date);

			date = dateFormat.parse(toDate);
			toDate = dateFormat.format(date);

			query = sessionPriceHistory.createQuery("from PriceHistory where productId = :productId and date = :fromDate");

			query.setParameter("productId",productId);
	        query.setParameter("fromDate",fromDate);

	        priceHistory = query.list();

	        if ( priceHistory.size() == 0)  {
	        	//TODO : Savita : need to think on what shall be returned here
	        	return profit;
	        }
	        
	        fromDatePrice = Double.parseDouble(priceHistory.get(0).getPrice());
			
	        query = sessionPriceHistory.createQuery("from PriceHistory where productId = :productId and date = :toDate");
	        query.setParameter("productId",productId);
	        query.setParameter("toDate",toDate);
	        priceHistory = query.list();
        
	        if ( priceHistory.size() == 0)  {
	        	//TODO : Savita : need to think on what shall be returned here
	        	return profit;
	        }
	        
	        
	        toDatePrice = Double.parseDouble(priceHistory.get(0).getPrice());
			
	        profit = toDatePrice - fromDatePrice;

	        logger.debug("Trading class : calculateProfit method : end");	        
			
		} catch (ParseException | NumberFormatException | HibernateException e) {
			logger.debug("Trading class : calculateProfit method : Caught exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		}
		finally {
			if(sessionPriceHistory!=null)
				sessionPriceHistory.close();
		}
		return profit;
	}*/


}
