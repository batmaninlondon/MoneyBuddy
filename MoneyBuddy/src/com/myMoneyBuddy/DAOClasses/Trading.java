/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.xml.bind.JAXBElement;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.json.JSONObject;
import org.tempuri.IStarMFPaymentGatewayService;
import org.tempuri.IStarMFWebService;
import org.tempuri.MFOrderEntry;

import org.tempuri.StarMFPaymentGatewayService;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import com.myMoneyBuddy.ActionClasses.PaymentAction;
import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.NavHistory;
import com.myMoneyBuddy.EntityClasses.PaymentDetails;
import com.myMoneyBuddy.EntityClasses.ProductDetails;
//import com.myMoneyBuddy.EntityClasses.PriceHistory;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.EntityClasses.Transactions;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.mailerClasses.sendMail;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceStarMF;
import com.myMoneyBuddy.webServices.WebServiceStarMFPaymentGateway;
import com.mysql.fabric.xmlrpc.base.Array;

import org.apache.derby.iapi.services.info.ProductGenusNames;
import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.ObjectFactory;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.PasswordRequest;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.RequestParam;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.Response;

public class Trading {

	Logger logger = Logger.getLogger(Trading.class);

	public String createClient(String CLIENT_HOLDING, String CLIENT_TAXSTATUS, String CLIENT_OCCUPATIONCODE, String CLIENT_DOB,
			String CLIENT_GENDER, String CLIENT_GUARDIAN, String CLIENT_ACCTYPE_1, String CLIENT_ACCNO_1, String CLIENT_NEFT_IFSCCODE_1,
			String CLIENT_ADD_1, String CLIENT_CITY, String CLIENT_STATE, String CLIENT_PINCODE, String CLIENT_COUNTRY,
			String customerId, String CLIENT_APPNAME1, String CLIENT_EMAIL, String CLIENT_PAN, String CLIENT_CM_MOBILE) throws MoneyBuddyException {


		try {
			String PASSWORD_STARMF;

			Properties properties = new Properties();
			String propFilePath = "../../../config/client.properties";

			properties.load(Trading.class.getResourceAsStream(propFilePath));

			WebServiceStarMF wbStarMF = new WebServiceStarMF();		
			IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();

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

			String passwordStarMF = iStarMFWebService.getPassword(properties.getProperty("USER_ID"),properties.getProperty("MEMBER_ID"),properties.getProperty("PASSWORD"),properties.getProperty("PASS_KEY"));

			String[] resultsStarMF = passwordStarMF.split("\\|");

			for (int i = 0 ; i <resultsStarMF.length ; i++ )   {
				System.out.println("resultsStarMF : "+i+" : " +resultsStarMF[i]);
			}


			System.out.println("passwordStarMF : "+passwordStarMF);

			PASSWORD_STARMF = resultsStarMF[1];

			String ucc = iStarMFWebService.mfapi("02",properties.getProperty("USER_ID"),PASSWORD_STARMF,clientDetails);

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

	public String executeTrade(String customerId, String amount, Map<String, Double> productDetailsMap, String transactionCode, 
			String transactionType, String buySell, int years, String firstOrderFlag, String paymentGatewayComment, String groupName) throws MoneyBuddyException {


		System.out.println("Trading class : executeTade method : transactionType : "+transactionType);

		SessionFactory factory = null;
		Session session = null;

		Double totalAmount = 0.0;
		String buySellType;
		int quantity; 
		String transactionDetailId;
		String currentPrice;
		double pendingOrders;
		Query query;
		//List<PriceHistory> priceHistory;
		Transactions tempTransaction;
		TransactionDetails tempTransactionDetail;

		CustomerPortfolio tempCustomerPortfolio;

		try {

			logger.debug("Trading class : executeTrade method : start");
			factory = new AnnotationConfiguration()
					.configure()
					.addAnnotatedClass(Transactions.class).addAnnotatedClass(TransactionDetails.class).addAnnotatedClass(PaymentDetails.class)
					.addAnnotatedClass(CustomerPortfolio.class).addAnnotatedClass(ProductDetails.class).addAnnotatedClass(NavHistory.class)
					.buildSessionFactory();
			session = factory.openSession();


			session.beginTransaction();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);

			System.out.println("frmtdDateForDB : "+frmtdDateForDB);

			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = new Date();
			String frmtdDate = dateFormat.format(date);

			for ( Double currentAmount : productDetailsMap.values())  {
				System.out.println("currentAmount : "+currentAmount);
				totalAmount = totalAmount + currentAmount;
			}

			tempTransaction = new Transactions(customerId, Double.toString(totalAmount),
					transactionType, "Pending",frmtdDateForDB,frmtdDateForDB);

			session.save(tempTransaction);
			session.getTransaction().commit();

			logger.debug("Trading class : executeTrade method : inserted data to Transactions table for customerId : "+customerId);

			String transactionId = tempTransaction.getTransactionId();

			Properties properties = new Properties();
			String propFilePath = "../../../config/client.properties";

			properties.load(PaymentAction.class.getResourceAsStream(propFilePath));

			WebServiceMFOrder wbMFOrder = new WebServiceMFOrder();	
			MFOrderEntry mfOrderEntry = wbMFOrder.getWSHttpBindingMFOrderEntry();
			String passwordMFOrder;
			String[] resultsMFOrder;
			String PASSWORD_MFORDER;
			String LOGOUT_URL = "http://www.quantwealth.in/thankYou";
			WebServiceStarMFPaymentGateway webServiceStarMFPaymentGateway = new WebServiceStarMFPaymentGateway();		
			IStarMFPaymentGatewayService iStarMFPaymentGatewayService = webServiceStarMFPaymentGateway.getWSHttpBindingIStarMFPaymentGatewayService();
			String PASSWORD_STARMF;
			Response passwordStarMFPaymentGateway;
			String[] resultsStarMFPaymentGateway;

			String paymentDetails;
			String entryParam;
			String[] resultsEntryParam;
			String[] paymentDetailsArray = {properties.getProperty("MEMBER_ID"),customerId,LOGOUT_URL};
			paymentDetails = String.join("|",paymentDetailsArray);

			boolean allOrderFailed = true ;
			String paymentUrl;

			for ( String currentProductId : productDetailsMap.keySet())  {

				/*query = sessionPriceHistory.createQuery("from PriceHistory where productId = :productId and date = curdate()");
			    query.setParameter("productId",currentProductId);

			    priceHistory = query.list();
			    currentPrice = priceHistory.get(0).getPrice();*/
				//quantity = (int)(productDetailsMap.get(currentProductId)/Double.parseDouble(currentPrice));



				//List<CustomerPortfolio> customerPortfolio = query.list();

				session.beginTransaction();
				String productName = null;
				Object result;
				result = (session.createQuery("select productName from ProductDetails where productId = :productId").setParameter("productId",currentProductId).uniqueResult());

				if (result != null) 
					productName = result.toString();

				System.out.println(" productName :  "+productName +" for product Id : "+currentProductId);

				session.getTransaction().commit();

				session.beginTransaction();

				result = session.createQuery("select navValue from NavHistory where schemeCode = '"+productName+"' and navDate = (select max(navDate) from NavHistory) ").uniqueResult();
				String latestNav = null;

				if (result != null)  
					latestNav = result.toString();

				session.getTransaction().commit();

				Double currentTransactionAmount = productDetailsMap.get(currentProductId);
				Double currentTransactionQuantity = currentTransactionAmount / Double.parseDouble(latestNav);
				//currentTransactionQuantity = (Math.round( currentTransactionQuantity * 10000.0 ) / 10000.0);

				System.out.println("Trading class : executeTrade method : currentTransactionAmount : "+currentTransactionAmount);
				System.out.println("Trading class : executeTrade method : unitPrice : "+latestNav);
				System.out.println("Trading class : executeTrade method : currentTransactionQuantity : "+currentTransactionQuantity);

				tempTransactionDetail  = new TransactionDetails(transactionId, null,null, customerId,transactionType,
						transactionCode,buySell, Double.toString(currentTransactionAmount),
						null, null,null,"NO",currentProductId, String.format("%.4f", currentTransactionQuantity),latestNav,frmtdDateForDB, frmtdDateForDB); 		

				session.beginTransaction();
				session.save(tempTransactionDetail);

				logger.debug("Trading class : executeTrade method : inserted data to TransactionDetails table for customerId : "+customerId);

				session.getTransaction().commit();

				transactionDetailId = tempTransactionDetail.getTransactionDetailId();



				passwordMFOrder = mfOrderEntry.getPassword(properties.getProperty("USER_ID"),properties.getProperty("PASSWORD"),properties.getProperty("PASS_KEY"));

				resultsMFOrder = passwordMFOrder.split("\\|");

				/*for (int i = 0 ; i <resultsMFOrder.length ; i++ )   {
					System.out.println("resultsMFOrder : "+i+" : " +resultsMFOrder[i]);
				}

				System.out.println("passwordMFOrder : "+passwordMFOrder);*/

				PASSWORD_MFORDER = resultsMFOrder[1];



				/*		orderEntryParam(TransactionCode, UniqueReferenceNumber, OrderId, UserID
					, MemberId, ClientCode, SchemeCode, BuySell, BuySellType, DPTxn, Amount, Qty, AllRedeem, FolioNo
						, Remarks, KYCStatus, RefNo, SubBrCode, EUIN, EUINFlag, MinRedeem, DPC, IPAdd, Password
						, PassKey, Param1 (Sub Broker ARN ), Param2, Param3 )*/

				if (transactionType == "UPFRONT")  {

					if (buySell == "BUY")  {
						buySellType = "P";
					}
					else {
						buySellType = "R";
					}
					System.out.println(" transactionDetailId : "+transactionDetailId+" and amount : "+Double.toString(productDetailsMap.get(currentProductId)));
					entryParam = mfOrderEntry.orderEntryParam(transactionCode,transactionDetailId,properties.getProperty("ORDER_ID"),properties.getProperty("USER_ID"),properties.getProperty("MEMBER_ID"),customerId,productName,buySellType,properties.getProperty("BUY_SELL_TYPE"),properties.getProperty("DP_TXN"),
							Double.toString(productDetailsMap.get(currentProductId)),properties.getProperty("QTY"),properties.getProperty("ALL_REDEEM"),properties.getProperty("FOLIO_NUMBER"),properties.getProperty("REMARKS"),properties.getProperty("KYC_STATUS"),properties.getProperty("REF_NO"),properties.getProperty("SUB_BR_CODE"),properties.getProperty("EUIN"),properties.getProperty("EUIN_FLAG"),
							properties.getProperty("MIN_REDEEM"),properties.getProperty("DPC"),properties.getProperty("IP_ADDRESS"),PASSWORD_MFORDER,properties.getProperty("PASS_KEY"),properties.getProperty("PARAM_1"),properties.getProperty("PARAM_2"),properties.getProperty("PARAM_3"));
				}
				else {

					System.out.println(" transactionDetailId : "+transactionDetailId+" and amount : "+Double.toString(productDetailsMap.get(currentProductId)));
					entryParam = mfOrderEntry.sipOrderEntryParam(transactionCode, transactionDetailId, productName, properties.getProperty("MEMBER_ID"),
							customerId, properties.getProperty("USER_ID"), properties.getProperty("INTERNAL_REF_NUM"), properties.getProperty("TRANSMODE"), properties.getProperty("DP_TXN"), frmtdDate, 
							properties.getProperty("FREQUENCY_TYPE"),properties.getProperty("FREQUENCY_ALLOWED"),Double.toString(productDetailsMap.get(currentProductId)),Integer.toString(years*12),properties.getProperty("REMARKS"),properties.getProperty("FOLIO_NUMBER"),firstOrderFlag,properties.getProperty("SUB_BR_CODE"),properties.getProperty("EUIN"),properties.getProperty("EUIN_FLAG"),
							properties.getProperty("DPC"),properties.getProperty("REGID"),properties.getProperty("IP_ADDRESS"),PASSWORD_MFORDER,properties.getProperty("PASS_KEY"),properties.getProperty("PARAM_1"),properties.getProperty("PARAM_2"),properties.getProperty("PARAM_3"));

					//System.out.println("Trading class : executeTade method : inside SIP loop  ");

					System.out.println("Trading class : executeTade method : start Date : "+frmtdDateForDB);


				}

				System.out.println("entryParam : "+entryParam);


				resultsEntryParam = entryParam.split("\\|");

				/*for (int i = 0 ; i <resultsEntryParam.length ; i++ )   {
					System.out.println("resultsEntryParam : "+i+" : " +resultsEntryParam[i]);
				}*/


				session.beginTransaction();
				query = session.createQuery("update TransactionDetails set bseOrderId = :bseOrderId , uniqueReferenceNumber = :uniqueReferenceNumber, transactionStatus =:transactionStatus , bseRemarks = :bseRemarks , bseSuccessFlag = :bseSuccessFlag " + " where transactionDetailId = :transactionDetailId");
				if (transactionType == "UPFRONT")
					query.setParameter("bseOrderId", resultsEntryParam[2]);
				else 
					query.setParameter("bseOrderId", resultsEntryParam[5]);

				if ( resultsEntryParam[7].equals("1") ) 
					query.setParameter("transactionStatus", "Failed");
				else  
				{
					query.setParameter("transactionStatus", "Pending");
					allOrderFailed = false;
				}

				query.setParameter("uniqueReferenceNumber", resultsEntryParam[1]);
				query.setParameter("bseRemarks", resultsEntryParam[6]);
				query.setParameter("bseSuccessFlag", resultsEntryParam[7]);
				query.setParameter("transactionDetailId", transactionDetailId);
				int updateResult = query.executeUpdate();
				System.out.println(updateResult + " rows updated in transactionDetails table ");
				session.getTransaction().commit();

				session.beginTransaction();
				query = session.createQuery("from CustomerPortfolio where productId = :productId and customerId = :customerId and investmentTypeName = :groupName");
				query.setParameter("productId",currentProductId);
				query.setParameter("customerId",customerId);
				query.setParameter("groupName",groupName);

				List<CustomerPortfolio> customerPortfolio = query.list();

				pendingOrders = 0.0;

				/*			    if ("SELL".equals(transactionType))  
					pendingOrders -= quantity;
				else 
					pendingOrders += quantity;*/

				session.getTransaction().commit();
				session.beginTransaction();
				if (query.list().size() != 0)  {
					pendingOrders = Double.parseDouble(customerPortfolio.get(0).getPendingOrders()) + currentTransactionQuantity;

					customerPortfolio.get(0).setPendingOrders(Double.toString(pendingOrders));
					customerPortfolio.get(0).setTransactionDetailId(transactionDetailId);
					customerPortfolio.get(0).setUpdateDate(frmtdDateForDB);

				}
				else {

					tempCustomerPortfolio = new CustomerPortfolio(customerId, currentProductId,
							"0",Double.toString(currentTransactionQuantity),transactionDetailId,
							null,groupName,null,frmtdDateForDB,frmtdDateForDB);

					session.save(tempCustomerPortfolio);

				}
				session.getTransaction().commit();

				logger.debug("Trading class : executeTrade method : inserted data to CustomerPortfolio table for customerId : "+customerId);



			}


			if (!allOrderFailed) {
				
				PasswordRequest passwordRequest = new PasswordRequest();
				ObjectFactory objFact = ObjectFactory.class.newInstance();
				//JAXBElement<String> memberId = objFact.createPasswordRequestMemberId(properties.getProperty("MEMBER_ID")); 
				
				passwordRequest.setMemberId(objFact.createPasswordRequestMemberId(properties.getProperty("MEMBER_ID")));
				passwordRequest.setPassKey(objFact.createPasswordRequestPassKey(properties.getProperty("PASS_KEY")));
				passwordRequest.setPassword(objFact.createPasswordRequestPassword("Money@1"));
				passwordRequest.setUserId(objFact.createPasswordRequestUserId("1239801"));	
				
				passwordStarMFPaymentGateway = iStarMFPaymentGatewayService.getPassword(passwordRequest);
							
				/*resultsStarMFPaymentGateway = passwordStarMFPaymentGateway.split("\\|");

				for (int i = 0 ; i <resultsStarMFPaymentGateway.length ; i++ )   {
					System.out.println("resultsStarMF : "+i+" : " +resultsStarMFPaymentGateway[i]);
				}*/
				
				System.out.println("UserId Passed : "+ passwordRequest.getUserId().getValue());
				System.out.println("MemberId Passed : "+ passwordRequest.getMemberId().getValue());
				System.out.println("PassKey Passed : "+ passwordRequest.getPassKey().getValue());
				System.out.println("Password Passed : "+ passwordRequest.getPassword().getValue());

				//System.out.println("passwordStarMFPaymentGateway : "+passwordStarMFPaymentGateway.getFiller().getValue());
				
				
				String status = passwordStarMFPaymentGateway.getStatus().getValue();
				//PASSWORD_STARMF = resultsStarMFPaymentGateway[1];
				
				System.out.println("status : "+status);
				
				PASSWORD_STARMF = passwordStarMFPaymentGateway.getResponseString().getValue();
				System.out.println("Response String (Encrypted Password) : "+PASSWORD_STARMF);
				
				ArrayOfstring orderNums = new ArrayOfstring();
				orderNums.getString().add("1234");
				orderNums.getString().add("5678");
				

				
				RequestParam requestParam = new RequestParam();
				requestParam.setAccNo(objFact.createRequestParamAccNo("1234567890"));
				requestParam.setBankID(objFact.createRequestParamBankID("ICI"));
				requestParam.setClientCode(objFact.createRequestParamClientCode(customerId));
				requestParam.setEncryptedPassword(objFact.createRequestParamEncryptedPassword(PASSWORD_STARMF));
				requestParam.setIFSC(objFact.createRequestParamIFSC("ICIC0000073"));
				requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(LOGOUT_URL));
				requestParam.setMemberCode(objFact.createRequestParamMemberCode(properties.getProperty("MEMBER_ID")));
				requestParam.setMode(objFact.createRequestParamMode("DIRECT"));
				requestParam.setOrders(objFact.createRequestParamOrders(orderNums));
				requestParam.setTotalAmount(objFact.createRequestParamTotalAmount("2"));

				Response paymentGateway = iStarMFPaymentGatewayService.paymentGatewayAPI(requestParam);

				System.out.println("paymentGateway : "+paymentGateway);

				/*String[] resultsPaymentGateway = paymentGateway.split("\\|");

				for (int i = 0 ; i <resultsPaymentGateway.length ; i++ )   {
					System.out.println("resultsPaymentGateway : "+i+" : " +resultsPaymentGateway[i]);
				}*/

				paymentUrl = paymentGateway.getResponseString().getValue();
				System.out.println("paymentUrl: "+paymentUrl);

			}
			else {
				paymentUrl = "NotSet";
				System.out.println("paymentUrl: "+paymentUrl);
			}

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
			if(session!=null)
				session.close();

		}

	}





	public void checkPaymentStatus(String customerId) throws MoneyBuddyException {

		SessionFactory factory = null;
		Session session = null;
		Query query;
		List<Object[]> transactionDetails;
		List<String> customerIds;
		PaymentDetails tempPaymentDetail;
		HashMap<String,String> successfulPayment = new HashMap<String, String>();
		HashMap<String,String> pendingPayment = new HashMap<String, String>();

		System.out.println("Trading class : checkPaymentStatus method - start ");

		WebServiceStarMF wbStarMF = new WebServiceStarMF();	
		IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();
		String PASSWORD_STARMF;
		String passwordStarMF;
		String[] resultsStarMF;

		String paymentStatusDetails;

		try {

			logger.debug("Trading class : checkPaymentStatus method : start");

			factory = new AnnotationConfiguration()
					.configure()
					.addAnnotatedClass(TransactionDetails.class).addAnnotatedClass(PaymentDetails.class)
					.addAnnotatedClass(CustomerPortfolio.class).addAnnotatedClass(Customers.class)
					.addAnnotatedClass(ProductDetails.class)
					.buildSessionFactory();
			session = factory.openSession();


			session.beginTransaction();
			query = session.createQuery("select distinct(customerId) from Customers");

			customerIds = query.list();

			session.getTransaction().commit();

			for (String customerid : customerIds)  {
				System.out.println("customerid : "+customerid);


			}
				session.beginTransaction();
				query = session.createQuery("select transactionId, transactionDetailId, transactionDate, bseOrderId , productId , quantity, transactionAmount from TransactionDetails where customerId='"+customerId+"' and transactionStatus='Pending'");

				transactionDetails = query.list();

				session.getTransaction().commit();

				for (Object[]  transactionDetail : transactionDetails)  {

					System.out.println("Order number : "+transactionDetail[3]);

					long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;

					//String startDateString = "06/27/2007";
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date startDate;

					startDate = dateFormat.parse(transactionDetail[2].toString());
					/*String newDateString = dateFormat.format(startDate);
				    System.out.println(newDateString);*/

					Date date = new Date();
					String frmtdDate = dateFormat.format(date);
					Date todayDate = dateFormat.parse(frmtdDate);

					boolean moreThanDay = Math.abs(todayDate.getTime() - startDate.getTime()) > MILLIS_PER_DAY;
					System.out.println("moreThanDay is : "+moreThanDay+" for transactionDetailId : "+transactionDetail[1]);

					if (moreThanDay)  {

						session.beginTransaction();
						session.createQuery("update TransactionDetails set transactionStatus='Rejected' where transactionDetailId='"+transactionDetail[1].toString()+"'").executeUpdate();
						session.getTransaction().commit();

					}

					else {
						Properties properties = new Properties();
						String propFilePath = "../../../config/client.properties";

						properties.load(PaymentAction.class.getResourceAsStream(propFilePath));



						String[] paymentStatusDetailsArray = {customerId,transactionDetail[3].toString(),"BSEMF"};
						paymentStatusDetails = String.join("|",paymentStatusDetailsArray);



						passwordStarMF = iStarMFWebService.getPassword(properties.getProperty("USER_ID"),properties.getProperty("MEMBER_ID"),properties.getProperty("PASSWORD"),properties.getProperty("PASS_KEY"));

						resultsStarMF = passwordStarMF.split("\\|");

						/*for (int i = 0 ; i <resultsStarMF.length ; i++ )   {
					System.out.println("resultsStarMF : "+i+" : " +resultsStarMF[i]);
				}*/


						//System.out.println("passwordStarMF : "+passwordStarMF);

						PASSWORD_STARMF = resultsStarMF[1];

						String paymentStatusResponse = iStarMFWebService.mfapi("11",properties.getProperty("USER_ID"),PASSWORD_STARMF,paymentStatusDetails);

						System.out.println("paymentStatusResponse : "+paymentStatusResponse);

						String[] resultsPaymentStatusResponse = paymentStatusResponse.split("\\|");

						/*				for (int i = 0 ; i <resultsPaymentStatusResponse.length ; i++ )   {
					System.out.println("resultsPaymentStatusResponse : "+i+" : " +resultsPaymentStatusResponse[i]);
				}*/

						dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						date = new Date();
						String frmtdDateForDB = dateFormat.format(date);

						String refNumber = null;
						List<String> paymentDetailsList;
						if (resultsPaymentStatusResponse[0].equals("100"))  {

							session.beginTransaction();

							query = session.createQuery("select paymentRefNum from PaymentDetails where transactionDetailId='"+transactionDetail[1].toString()+"' and bseOrderID='"+transactionDetail[3].toString()+"'");
							paymentDetailsList = query.list();

							session.getTransaction().commit();

							session.beginTransaction();

							if (paymentDetailsList.isEmpty())  {
								tempPaymentDetail = new PaymentDetails( transactionDetail[0].toString(), transactionDetail[1].toString(), transactionDetail[3].toString(),
										resultsPaymentStatusResponse[1], transactionDetail[2].toString(),frmtdDateForDB);
								session.save(tempPaymentDetail);
							}
							else 
							{
								for (String paymentDetail : paymentDetailsList)  {
									refNumber = paymentDetail;
								}
								session.createQuery("update PaymentDetails set paymentGatewayComment='"+resultsPaymentStatusResponse[1]+"' , updateDate='"+frmtdDateForDB+"' where PAYMENT_REF_NUM='"+refNumber+"'").executeUpdate();;
							}

							session.getTransaction().commit();

							if (resultsPaymentStatusResponse[1].startsWith("APPROVED"))  {
								System.out.println("Payment Successful");
								session.beginTransaction();
								session.createQuery("update TransactionDetails set transactionStatus='Complete' where transactionDetailId='"+transactionDetail[1].toString()+"'").executeUpdate();
								session.getTransaction().commit();

								Double quantity = Double.parseDouble(transactionDetail[5].toString());

								session.beginTransaction();

								Object result = session.createQuery("select pendingOrders from ebdb.CUSTOMER_PORTFOLIO where PRODUCT_ID='"+transactionDetail[4].toString()+"' and TRANSACTION_DETAIL_ID='"+transactionDetail[1].toString()+"'").uniqueResult();
								Double pendingOrder = 0.0;
								Double totalQuantity = 0.0;
								if (result != null) 
									pendingOrder = Double.parseDouble(result.toString());

								session.getTransaction().commit();
								
								session.beginTransaction();
								result = session.createQuery("select totalQuantity from ebdb.CUSTOMER_PORTFOLIO where PRODUCT_ID='"+transactionDetail[4].toString()+"' and TRANSACTION_DETAIL_ID='"+transactionDetail[1].toString()+"'").uniqueResult();

								if (result != null)
									totalQuantity  = Double.parseDouble(result.toString());

								pendingOrder -= quantity;
								totalQuantity += quantity;
								session.getTransaction().commit();


								session.beginTransaction();
								session.createQuery("update ebdb.CUSTOMER_PORTFOLIO set PENDING_ORDERS='"+pendingOrder+"', TOTAL_QUANTITY='"+totalQuantity+"' where PRODUCT_ID='"+transactionDetail[4].toString()+"' and TRANSACTION_DETAIL_ID='"+transactionDetail[1].toString()+"'").executeUpdate();
								session.getTransaction().commit();

								session.beginTransaction();
								result = session.createQuery("select productName from ProductDetails where productId='"+transactionDetail[4].toString()+"'").uniqueResult();
								String productName = null;

								if (result != null) 
									productName = result.toString();
								session.getTransaction().commit();

								successfulPayment.put(productName, transactionDetail[6].toString());
								
							}
							else {
								session.beginTransaction();
								Object result = session.createQuery("select productName from ProductDetails where productId='"+transactionDetail[4].toString()+"'").uniqueResult();
								String productName = null;

								if (result != null) 
									productName = result.toString();
								session.getTransaction().commit();
								
								pendingPayment.put(productName, transactionDetail[6].toString());
								
							}

						}

					}
					/*paymentUrl = resultsPaymentGateway[1];
				System.out.println("paymentUrl: "+paymentUrl);*/
				}

				if (!successfulPayment.isEmpty())
				{
					session.beginTransaction();
					Object result = session.createQuery("select emailId from Customers where customerId='"+customerId+"'").uniqueResult();
					String emailId = null;

					if (result != null) 
						emailId = result.toString();

					session.getTransaction().commit();

					String subject="[MoneyBuddy] Thank you for the payment.";
					sendMail sendMail = new sendMail();
					StringBuilder bodyText = new StringBuilder();
					bodyText.append("<div>")
					.append("  Dear User<br/><br/>")
					.append("  Thank you for the payment of following records.")
					.append("  <br/>");
					
					Set set = successfulPayment.entrySet();
					
					Iterator iterator = set.iterator();
					
					while(iterator.hasNext()) {
						Map.Entry mentry = (Map.Entry)iterator.next();
						bodyText.append("Fund Name : "+ mentry.getKey())
						.append("Amount : "+mentry.getValue())
						.append("  <br/>");
					}
					
					bodyText.append("  <br/><br/>")
					.append("  Thanks,<br/>")
					.append("  MoneyBuddy Team")
					.append("</div>");

					sendMail.MailSending(emailId,bodyText,subject);

				}
				/*if (!pendingPayment.isEmpty())
				{
					session.beginTransaction();
					Object result = session.createQuery("select emailId from Customers where customerId='"+customerId+"'").uniqueResult();
					String emailId = null;

					if (result != null) 
						emailId = result.toString();

					session.getTransaction().commit();

					String subject="[MoneyBuddy] Pending Orders";
					sendMail sendMail = new sendMail();
					StringBuilder bodyText = new StringBuilder();
					bodyText.append("<div>")
					.append("  Dear User<br/><br/>")
					.append("  Please make payment for following orders. ")
					.append("  <br/>");
					
					Set set = pendingPayment.entrySet();
					
					Iterator iterator = set.iterator();
					
					while(iterator.hasNext()) {
						Map.Entry mentry = (Map.Entry)iterator.next();
						bodyText.append("Fund Name : "+ mentry.getKey())
						.append("Amount : "+mentry.getValue())
						.append("  <br/>");
					}
					
					bodyText.append("  <br/><br/>")
					.append("  Thanks,<br/>")
					.append("  MoneyBuddy Team")
					.append("</div>");

					sendMail.MailSending(emailId,bodyText,subject);

				}*/

			logger.debug("Trading class : checkPaymentStatus method : end");

		} catch (NumberFormatException | HibernateException e) {
			logger.debug("Trading class : checkPaymentStatus method : Caught exception  ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.debug("Trading class : checkPaymentStatus method : Caught exception  ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
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
