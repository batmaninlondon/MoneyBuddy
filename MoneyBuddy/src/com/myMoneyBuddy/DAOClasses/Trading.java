/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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

//import org.tempuri.StarMFPaymentGatewayService;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import com.myMoneyBuddy.ActionClasses.PaymentAction;
import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
//import com.myMoneyBuddy.EntityClasses.NavHistory;
import com.myMoneyBuddy.EntityClasses.PaymentDetails;
import com.myMoneyBuddy.EntityClasses.ProductDetails;
import com.myMoneyBuddy.EntityClasses.SipDetails;
//import com.myMoneyBuddy.EntityClasses.PriceHistory;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.OrderDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.mailerClasses.SendMail;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceStarMF;
import com.myMoneyBuddy.webServices.WebServiceStarMFPaymentGateway;
import com.mysql.fabric.xmlrpc.base.Array;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.derby.iapi.services.info.ProductGenusNames;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
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

		
			Session session = null;

		try {
			
			
			session = HibernateUtil.getSessionAnnotationFactory().openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("select bseCode from RtaSpecificCodes where fieldType = 'taxstatus' and fieldValue = :fieldValue ");
			query.setParameter("fieldValue", CLIENT_TAXSTATUS);
			
			String taxStatus = query.uniqueResult().toString();
			
			query = session.createQuery("select bseCode from RtaSpecificCodes where fieldType = 'state' and fieldValue = :fieldValue ");
			query.setParameter("fieldValue", CLIENT_STATE);
			
			String state = query.uniqueResult().toString();
			
			query = session.createQuery("select bseCode from RtaSpecificCodes where fieldType = 'Occupation' and fieldValue = :fieldValue ");
			query.setParameter("fieldValue", CLIENT_OCCUPATIONCODE);
			
			String occupation = query.uniqueResult().toString();

			
			String PASSWORD_STARMF;
			
			String dob = CLIENT_DOB.substring(8,10)+"/"+CLIENT_DOB.substring(5,7)+"/"+CLIENT_DOB.substring(0,4);
			System.out.println("dob : "+dob);

			Properties clientProperties = new Properties();
			String clientPropFilePath = "../../../config/client.properties";

			clientProperties.load(Trading.class.getResourceAsStream(clientPropFilePath));
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));

			WebServiceStarMF wbStarMF = new WebServiceStarMF();		
			IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();

			String[] clientDetailsArray = {customerId,CLIENT_HOLDING,taxStatus,occupation,CLIENT_APPNAME1,clientProperties.getProperty("CLIENT_APPNAME2"),
					clientProperties.getProperty("CLIENT_APPNAME3"),dob,CLIENT_GENDER,clientProperties.getProperty("CLIENT_GUARDIAN"),CLIENT_PAN,
					clientProperties.getProperty("CLIENT_NOMINEE"),clientProperties.getProperty("CLIENT_NOMINEE_RELATION"),clientProperties.getProperty("CLIENT_GUARDIANPAN"),
					clientProperties.getProperty("CLIENT_TYPE"),clientProperties.getProperty("CLIENT_DEFAULTDP"),clientProperties.getProperty("CLIENT_CDSLDPID"),
					clientProperties.getProperty("CLIENT_CDSLCLTID"),clientProperties.getProperty("CLIENT_NSDLDPID"),clientProperties.getProperty("CLIENT_NSDLCLTID"),
					CLIENT_ACCTYPE_1,CLIENT_ACCNO_1,clientProperties.getProperty("CLIENT_MICRNO_1"),CLIENT_NEFT_IFSCCODE_1,clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_1"),
					clientProperties.getProperty("CLIENT_ACCTYPE_2"),clientProperties.getProperty("CLIENT_ACCNO_2"),clientProperties.getProperty("CLIENT_MICRNO_2"),
					clientProperties.getProperty("CLIENT_NEFT_IFSCCODE_2"),clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_2"),clientProperties.getProperty("CLIENT_ACCTYPE_3"),
					clientProperties.getProperty("CLIENT_ACCNO_3"),clientProperties.getProperty("CLIENT_MICRNO_3"),clientProperties.getProperty("CLIENT_NEFT_IFSCCODE_3"),
					clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_3"),clientProperties.getProperty("CLIENT_ACCTYPE_4"),clientProperties.getProperty("CLIENT_ACCNO_4"),
					clientProperties.getProperty("CLIENT_MICRNO_4"),clientProperties.getProperty("CLIENT_NEFT_IFSCCODE_4"),clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_4"),
					clientProperties.getProperty("CLIENT_ACCTYPE_5"),clientProperties.getProperty("CLIENT_ACCNO_5"),clientProperties.getProperty("CLIENT_MICRNO_5"),
					clientProperties.getProperty("CLIENT_NEFT_IFSCCODE_5"),clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_5"),clientProperties.getProperty("CLIENT_CHEQUENAME_5"),
					CLIENT_ADD_1,clientProperties.getProperty("CLIENT_ADD_2"),clientProperties.getProperty("CLIENT_ADD_3"),CLIENT_CITY,state,CLIENT_PINCODE,CLIENT_COUNTRY,
					clientProperties.getProperty("CLIENT_RESIPHONE"),clientProperties.getProperty("CLIENT_RESIFAX"),clientProperties.getProperty("CLIENT_OFFICEPHONE"),
					clientProperties.getProperty("CLIENT_OFFICEFAX"),CLIENT_EMAIL,clientProperties.getProperty("CLIENT_COMMMODE"),clientProperties.getProperty("CLIENT_DIVPAYMODE"), 
					clientProperties.getProperty("CLIENT_PAN_2"),clientProperties.getProperty("CLIENT_PAN_3"),clientProperties.getProperty("CLIENT_MAPIN_NO"),
					clientProperties.getProperty("CLIENT_CM_FORADD_1"),clientProperties.getProperty("CLIENT_CM_FORADD_2"),clientProperties.getProperty("CLIENT_CM_FORADD_3"),
					clientProperties.getProperty("CLIENT_CM_FORCITY"),clientProperties.getProperty("CLIENT_CM_FORPINCODE"),clientProperties.getProperty("CLIENT_CM_FORSTATE"),
					clientProperties.getProperty("CLIENT_CM_FORCOUNTRY"),clientProperties.getProperty("CLIENT_CM_FORRESIPHONE"),clientProperties.getProperty("CLIENT_CM_FORRESIFAX"),
					clientProperties.getProperty("CLIENT_CM_FOROFFPHONE"),clientProperties.getProperty("CLIENT_CM_FOROFFFAX"),CLIENT_CM_MOBILE};

			String clientDetails = String.join("|",clientDetailsArray);

			System.out.println("clientDetails : "+clientDetails);
			
			System.out.println(" USER_ID : "+configProperties.getProperty("USER_ID"));
			System.out.println(" MEMBER_ID : "+configProperties.getProperty("MEMBER_ID"));
			System.out.println(" PASSWORD : "+configProperties.getProperty("PASSWORD"));
			System.out.println(" PASS_KEY : "+configProperties.getProperty("PASS_KEY"));

			String passwordStarMF = iStarMFWebService.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("MEMBER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

			String[] resultsStarMF = passwordStarMF.split("\\|");

			for (int i = 0 ; i <resultsStarMF.length ; i++ )   {
				System.out.println("resultsStarMF : "+i+" : " +resultsStarMF[i]);
			}


			System.out.println("passwordStarMF : "+passwordStarMF);

			PASSWORD_STARMF = resultsStarMF[1];

			String ucc = iStarMFWebService.mfapi("02",configProperties.getProperty("USER_ID"),PASSWORD_STARMF,clientDetails);

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
		finally {
			session.close();
		}

	}
	
	public String generateMandateId(String customerId, String amount, String mandateType, String accountNum, String accountType, 
						String ifscCode, String sipStartDate, String sipEndDate) throws MoneyBuddyException {

		try {
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));
			
			String PASSWORD_STARMF;

			WebServiceStarMF wbStarMF = new WebServiceStarMF();		
			IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();

			String[] mandateIdDetailsArray = {customerId,amount,mandateType,accountNum,accountType,ifscCode,"",sipStartDate,sipEndDate};

			String mandateIdDetails = String.join("|",mandateIdDetailsArray);

			System.out.println("customerId : "+customerId);
			System.out.println("amount : "+amount);
			System.out.println("mandateType : "+mandateType);
			System.out.println("accountNum : "+accountNum);
			System.out.println("accountType : "+accountType);
			System.out.println("ifscCode : "+ifscCode);
			System.out.println("sipStartDate : "+sipStartDate);
			System.out.println("sipEndDate : "+sipEndDate);
			System.out.println("mandateIdDetails : "+mandateIdDetails);
			
			System.out.println(" USER_ID : "+configProperties.getProperty("USER_ID"));
			System.out.println(" MEMBER_ID : "+configProperties.getProperty("MEMBER_ID"));
			System.out.println(" PASSWORD : "+configProperties.getProperty("PASSWORD"));
			System.out.println(" PASS_KEY : "+configProperties.getProperty("PASS_KEY"));

			String passwordStarMF = iStarMFWebService.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("MEMBER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

			String[] resultsStarMF = passwordStarMF.split("\\|");

			for (int i = 0 ; i <resultsStarMF.length ; i++ )   {
				System.out.println("resultsStarMF : "+i+" : " +resultsStarMF[i]);
			}


			System.out.println("passwordStarMF : "+passwordStarMF);

			PASSWORD_STARMF = resultsStarMF[1];

			String mandateIdResponse = iStarMFWebService.mfapi("06",configProperties.getProperty("USER_ID"),PASSWORD_STARMF,mandateIdDetails);

			System.out.println("mandateIdResponse : "+mandateIdResponse);


			return mandateIdResponse;

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


	public String executeTrade(String customerId, String amount, Map<String, Double> productDetailsMap, String transactionCode, String sipDate, 
			String sipStartDate, String sipEndDate,
			String transactionType, String buySell, int years, String accountNum, String bankId, String ifsc, String bankMode, 
			String firstOrderFlag, String paymentGatewayComment, String mandateId, SessionMap<String, Object> sessionMap) throws MoneyBuddyException {


		System.out.println("Trading class : executeTade method : transactionType : "+transactionType);
		System.out.println("Trading class : executeTade method : years : "+years);

		Session hibernateSession = null;

		Double totalAmount = 0.0;
		String buySellType; 
		String transactionDetailId;
		Query query;
		//Transactions tempTransaction;
		TransactionDetails tempTransactionDetail;
		SipDetails tempSipDetail;
		//ArrayList<String> transactionDetailIdList = new ArrayList<String>();
		List<OrderDataModel> orderDataModel;

		try {

			logger.debug("Trading class : executeTrade method : start");
			orderDataModel = new LinkedList<OrderDataModel>();
			
			hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

			//hibernateSession.beginTransaction();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);

			System.out.println("frmtdDateForDB : "+frmtdDateForDB);
			
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateForDbf = new Date();


			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = new Date();
			String frmtdDate = dateFormat.format(date);


			for ( Double currentAmount : productDetailsMap.values())  {
				System.out.println("currentAmount : "+currentAmount);
				totalAmount = totalAmount + currentAmount;
			}

			/*tempTransaction = new Transactions(customerId, Double.toString(totalAmount),
					transactionType, "Pending",frmtdDateForDB,frmtdDateForDB);

			hibernateSession.save(tempTransaction);
			hibernateSession.getTransaction().commit();*/
			
			
			
			//logger.debug("Trading class : executeTrade method : inserted data to Transactions table for customerId : "+customerId);

			//String transactionId = tempTransaction.getTransactionId();
			
			hibernateSession.beginTransaction();
			
			query = hibernateSession.createQuery("select max(transactionId) from TransactionDetails");
			
			String transactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
			
			
			hibernateSession.getTransaction().commit();
			
			
			Properties clientProperties = new Properties();
			String clientPropFilePath = "../../../config/client.properties";

			clientProperties.load(PaymentAction.class.getResourceAsStream(clientPropFilePath));
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(PaymentAction.class.getResourceAsStream(configPropFilePath));

			WebServiceMFOrder wbMFOrder = new WebServiceMFOrder();	
			MFOrderEntry mfOrderEntry = wbMFOrder.getWSHttpBindingMFOrderEntry();
			String passwordMFOrder;
			String[] resultsMFOrder;
			String PASSWORD_MFORDER;
			String LOGOUT_URL = "http://localhost:8080/MoneyBuddy/thankYou";
			WebServiceStarMFPaymentGateway webServiceStarMFPaymentGateway = new WebServiceStarMFPaymentGateway();		
			IStarMFPaymentGatewayService iStarMFPaymentGatewayService = webServiceStarMFPaymentGateway.getWSHttpBindingIStarMFPaymentGatewayService();
			String PASSWORD_STARMF;
			Response passwordStarMFPaymentGateway;
			String[] resultsStarMFPaymentGateway;

			//String paymentDetails;
			String entryParam;
			String[] resultsEntryParam = null;
			String[] paymentDetailsArray = {configProperties.getProperty("MEMBER_ID"),customerId,LOGOUT_URL};
			//paymentDetails = String.join("|",paymentDetailsArray);

			boolean allOrderFailed = true ;
			String paymentUrl;
			
			ArrayOfstring orderNums = new ArrayOfstring();
			
			Double totalPaymentAmount = 0.0;

			for ( String currentProductId : productDetailsMap.keySet())  {
				System.out.println("currentProductId : "+currentProductId);

				hibernateSession.beginTransaction();
				String fundName = null;
				Object result;
				result = (hibernateSession.createQuery("select fundName from PrimaryFundDetails where fundId = :fundId").setParameter("fundId",currentProductId).uniqueResult());

				if (result != null) 
					fundName = result.toString();

				System.out.println(" fundName :  "+fundName +" for fund Id : "+currentProductId);

				hibernateSession.getTransaction().commit();

				hibernateSession.beginTransaction();

				//session.getTransaction().commit();

				Double currentTransactionAmount = productDetailsMap.get(currentProductId);

				System.out.println("Trading class : executeTrade method : currentTransactionAmount : "+currentTransactionAmount);

				tempTransactionDetail  = new TransactionDetails(transactionId, null,null, customerId,transactionType,
						transactionCode,buySell, Double.toString(currentTransactionAmount),
						"1", null,null,"N",currentProductId, null,null,frmtdDateForDB, frmtdDateForDB,"N"); 		

				//session.beginTransaction();
				hibernateSession.save(tempTransactionDetail);

				logger.debug("Trading class : executeTrade method : inserted data to TransactionDetails table for customerId : "+customerId);

				hibernateSession.getTransaction().commit();
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("delete from CustomerCart where customerId = :customerId and productId = :productId ");
				query.setParameter("customerId", customerId);
				query.setParameter("productId", currentProductId);
				
				query.executeUpdate();
				
				hibernateSession.getTransaction().commit();

				transactionDetailId = tempTransactionDetail.getTransactionDetailId();
				
				//transactionDetailIdList.add(transactionDetailId);

				if ("SIP".equals(transactionType ))  {
					hibernateSession.beginTransaction();
					
					System.out.println("customerId for SipDetails is : "+customerId);
					System.out.println("transactionDetailId for SipDetails is : "+transactionDetailId);
					System.out.println("sipDate for SipDetails is : "+sipDate);
					System.out.println("sipStartDate for SipDetails is : "+sipStartDate);
					System.out.println("sipEndDate for SipDetails is : "+sipEndDate);
					
					String frmtdStartDateForSip = sipStartDate.substring(6,10)+"-"+sipStartDate.substring(0,2)+"-"+sipStartDate.substring(3,5);
					String frmtdEndDateForSip = sipEndDate.substring(6,10)+"-"+sipEndDate.substring(0,2)+"-"+sipEndDate.substring(3,5);
					
					tempSipDetail = new SipDetails(customerId, transactionDetailId,
							sipDate, frmtdStartDateForSip, frmtdEndDateForSip,"N","N");
	
					hibernateSession.save(tempSipDetail);
					hibernateSession.getTransaction().commit();
				}
				
				dateFormat = new SimpleDateFormat("HH:mm:ss");
				Date CurrentTime = dateFormat.parse(dateFormat.format(new Date()));
				
				Date closingTime = dateFormat.parse("14:30:00");

				String frmtdDateForDBF;
				if (CurrentTime.after(closingTime))
				{
					dateForDbf = DateUtils.addDays(dateForDbf, 1);
					frmtdDateForDBF = dateFormat.format(dateForDbf);
				}
				else
				{
					frmtdDateForDBF = dateFormat.format(dateForDbf);
				}

				//session.getTransaction().commit();

				passwordMFOrder = mfOrderEntry.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

				resultsMFOrder = passwordMFOrder.split("\\|");


				PASSWORD_MFORDER = resultsMFOrder[1];

				if (transactionType == "UPFRONT")  {

					if (buySell == "BUY")  {
						buySellType = "P";
					}
					else {
						buySellType = "R";
					}
					System.out.println(" transactionDetailId : "+transactionDetailId+" and amount : "+Double.toString(productDetailsMap.get(currentProductId)));
					entryParam = mfOrderEntry.orderEntryParam(transactionCode,transactionDetailId,clientProperties.getProperty("ORDER_ID"),configProperties.getProperty("USER_ID"),
							configProperties.getProperty("MEMBER_ID"),customerId,fundName,buySellType,clientProperties.getProperty("BUY_SELL_TYPE"),
							clientProperties.getProperty("DP_TXN"),Double.toString(productDetailsMap.get(currentProductId)),clientProperties.getProperty("QTY"),
							clientProperties.getProperty("ALL_REDEEM"),clientProperties.getProperty("FOLIO_NUMBER"),clientProperties.getProperty("REMARKS"),
							clientProperties.getProperty("KYC_STATUS"),clientProperties.getProperty("REF_NO"),clientProperties.getProperty("SUB_BR_CODE"),
							clientProperties.getProperty("EUIN"),clientProperties.getProperty("EUIN_FLAG"),clientProperties.getProperty("MIN_REDEEM"),clientProperties.getProperty("DPC"),
							clientProperties.getProperty("IP_ADDRESS"),PASSWORD_MFORDER,configProperties.getProperty("PASS_KEY"),clientProperties.getProperty("PARAM_1"),
							clientProperties.getProperty("PARAM_2"),clientProperties.getProperty("PARAM_3"));
				}
				else {

					System.out.println(" transactionDetailId : "+transactionDetailId+" and amount : "+Double.toString(productDetailsMap.get(currentProductId)));
					System.out.println(" start Date  : "+frmtdDate );
					System.out.println(" sip start Date  : "+sipStartDate );

					String startDate = sipStartDate.substring(3,5)+"/"+sipStartDate.substring(0,2)+"/"+sipStartDate.substring(6,10);
				
					System.out.println(" startDate  : "+startDate );
					System.out.println(" numOfInstallments  : "+Integer.toString(years*12) );
					
					entryParam = mfOrderEntry.xsipOrderEntryParam(transactionCode, transactionDetailId, fundName, configProperties.getProperty("MEMBER_ID"),
							customerId, configProperties.getProperty("USER_ID"), clientProperties.getProperty("INTERNAL_REF_NUM"), clientProperties.getProperty("TRANSMODE"), 
							clientProperties.getProperty("DP_TXN"), startDate,clientProperties.getProperty("FREQUENCY_TYPE"),clientProperties.getProperty("FREQUENCY_ALLOWED"),
							Double.toString(productDetailsMap.get(currentProductId)),Integer.toString(years*12),clientProperties.getProperty("REMARKS"),
							clientProperties.getProperty("FOLIO_NUMBER"),firstOrderFlag,clientProperties.getProperty("BROKERAGE"),"",clientProperties.getProperty("SUB_BR_CODE"),clientProperties.getProperty("EUIN"),
							clientProperties.getProperty("EUIN_FLAG"),clientProperties.getProperty("DPC"),clientProperties.getProperty("REGID"),clientProperties.getProperty("IP_ADDRESS"),
							PASSWORD_MFORDER,configProperties.getProperty("PASS_KEY"),clientProperties.getProperty("PARAM_1"),mandateId,
							clientProperties.getProperty("PARAM_3"));



				}

				System.out.println("entryParam : "+entryParam);

				resultsEntryParam = entryParam.split("\\|");

				for (int i = 0 ; i <resultsEntryParam.length ; i++ )   {
					System.out.println("resultsEntryParam : "+i+" : " +resultsEntryParam[i]);
				}


				hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("update TransactionDetails set bseOrderId = :bseOrderId , uniqueReferenceNumber = :uniqueReferenceNumber, transactionStatus =:transactionStatus , bseRemarks = :bseRemarks , bseSuccessFlag = :bseSuccessFlag " + " where transactionDetailId = :transactionDetailId");
				if (transactionType == "UPFRONT")
					query.setParameter("bseOrderId", resultsEntryParam[2]);
				else 
					query.setParameter("bseOrderId", resultsEntryParam[5]);

				if ( resultsEntryParam[7].equals("1") ) 
					query.setParameter("transactionStatus", "2");
				else  
				{
					if (transactionType == "UPFRONT") {
						orderNums.getString().add(resultsEntryParam[2].toString());
						System.out.println(resultsEntryParam[2].toString()+" added in orderNums");
					}
					else {
						orderNums.getString().add(resultsEntryParam[5].toString());
						System.out.println(resultsEntryParam[5].toString()+" added in orderNums");
					}
					totalPaymentAmount += productDetailsMap.get(currentProductId);
					query.setParameter("transactionStatus", "3");
					allOrderFailed = false;
				}

				query.setParameter("uniqueReferenceNumber", resultsEntryParam[1]);
				query.setParameter("bseRemarks", resultsEntryParam[6]);
				query.setParameter("bseSuccessFlag", resultsEntryParam[7]);
				query.setParameter("transactionDetailId", transactionDetailId);
				int updateResult = query.executeUpdate();
				System.out.println(updateResult + " rows updated in transactionDetails table ");
				hibernateSession.getTransaction().commit();

				//session.beginTransaction();

				logger.debug("Trading class : executeTrade method : inserted data to CustomerPortfolio table for customerId : "+customerId);

			}


			if (!allOrderFailed) {

				
				PasswordRequest passwordRequest = new PasswordRequest();
				ObjectFactory objFact = ObjectFactory.class.newInstance();

				passwordRequest.setMemberId(objFact.createPasswordRequestMemberId(configProperties.getProperty("MEMBER_ID")));
				passwordRequest.setPassKey(objFact.createPasswordRequestPassKey(configProperties.getProperty("PASS_KEY")));
				passwordRequest.setPassword(objFact.createPasswordRequestPassword(configProperties.getProperty("PASSWORD")));
				passwordRequest.setUserId(objFact.createPasswordRequestUserId(configProperties.getProperty("USER_ID")));	
				
				passwordStarMFPaymentGateway = iStarMFPaymentGatewayService.getPassword(passwordRequest);

				resultsStarMFPaymentGateway = passwordStarMFPaymentGateway.toString().split("\\|");

				for (int i = 0 ; i <resultsStarMFPaymentGateway.length ; i++ )   {
					System.out.println("resultsStarMF : "+i+" : " +resultsStarMFPaymentGateway[i]);
				}
				
				System.out.println("UserId Passed : "+ passwordRequest.getUserId().getValue());
				System.out.println("MemberId Passed : "+ passwordRequest.getMemberId().getValue());
				System.out.println("PassKey Passed : "+ passwordRequest.getPassKey().getValue());
				System.out.println("Password Passed : "+ passwordRequest.getPassword().getValue());

				String status = passwordStarMFPaymentGateway.getStatus().getValue();

				System.out.println("status : "+status);
				
				PASSWORD_STARMF = passwordStarMFPaymentGateway.getResponseString().getValue();
				System.out.println("Response String (Encrypted Password) : "+PASSWORD_STARMF);
				
				
				//orderNums.getString().add(resultsEntryParam[2].toString());

				Iterator it = orderNums.getString().iterator();
				
				while(it.hasNext())  {
					System.out.println("oredrNums : "+it.next().toString());
				}
				
				RequestParam requestParam = new RequestParam();
				requestParam.setAccNo(objFact.createRequestParamAccNo(accountNum));
				requestParam.setBankID(objFact.createRequestParamBankID(bankId));
				requestParam.setClientCode(objFact.createRequestParamClientCode(customerId));
				requestParam.setEncryptedPassword(objFact.createRequestParamEncryptedPassword(PASSWORD_STARMF));
				requestParam.setIFSC(objFact.createRequestParamIFSC(ifsc));
				requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(LOGOUT_URL));
				requestParam.setMemberCode(objFact.createRequestParamMemberCode(configProperties.getProperty("MEMBER_ID")));
				requestParam.setMode(objFact.createRequestParamMode(bankMode));
				requestParam.setOrders(objFact.createRequestParamOrders(orderNums));
				requestParam.setTotalAmount(objFact.createRequestParamTotalAmount(Double.toString(totalPaymentAmount)));

				Response paymentGateway = iStarMFPaymentGatewayService.paymentGatewayAPI(requestParam);

				String[] resultsPaymentGateway = paymentGateway.toString().split("\\|");

				for (int i = 0 ; i <resultsPaymentGateway.length ; i++ )   {
					System.out.println("resultsPaymentGateway : "+i+" : " +resultsPaymentGateway[i]);
				}

				paymentUrl = paymentGateway.getResponseString().getValue();
				
				hibernateSession.beginTransaction();

				query = hibernateSession.createQuery("update Customers set subscriberType = :subscriberType where customerId = :customerId");

				query.setParameter("subscriberType", "INVESTOR");

				query.setParameter("customerId", customerId);

				int result = query.executeUpdate();

				hibernateSession.getTransaction().commit();
				
				hibernateSession.beginTransaction();
				Object emailIdObj = hibernateSession.createQuery("select emailId from Customers where customerId = '"+customerId+"'").uniqueResult();
				String emailId = null;
				if (emailIdObj != null)
					emailId = emailIdObj.toString();
								
				hibernateSession.getTransaction().commit();
				
				hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("update Subscriber set subscriberType = :subscriberType where emailId = :emailId");

				query.setParameter("subscriberType", "INVESTOR");

				query.setParameter("emailId", emailId);

				result = query.executeUpdate();

				hibernateSession.getTransaction().commit();

			}
			else {
				paymentUrl = "NotSet";
				System.out.println("paymentUrl: "+paymentUrl);
			}

			//String paymentUrlFile = "http://localhost:8080/MoneyBuddy/thankYou.jsp";
			String paymentUrlFile = "D://HTMLFile/payment.html";
			File newHtmlFile = new File(paymentUrlFile);
			FileUtils.writeStringToFile(newHtmlFile, paymentUrl);
			
			// Savita Wadhwani - Somehow we need to check whether payment was successful or not - start 
			
			
				
				Iterator it = orderNums.getString().iterator();
				
				while(it.hasNext())  {
					System.out.println("oredrNums : "+it.next().toString());
				}
				
				String bseOrderId = null;
				int result;
				List<Object[]> transactionDetailQueryResult;
				String fundName;
				
				while(it.hasNext())  {
					
					bseOrderId = it.next().toString();
					System.out.println("bseOrderId : "+bseOrderId);
					hibernateSession.beginTransaction();
					query = hibernateSession.createQuery("update TransactionDetails set transactionStatus = :transactionStatus where bseOrderId = :bseOrderId and customerId = :customerId");

					if ( !"NotSet".equals(paymentUrl))  {
						query.setParameter("transactionStatus", "5");
					}
					else {
						query.setParameter("transactionStatus", "4");
					}

					query.setParameter("bseOrderId", bseOrderId);
					query.setParameter("customerId", customerId);

					result = query.executeUpdate();

					hibernateSession.getTransaction().commit();
					
					hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery("select productId,quantity,transactionAmount,transactionDate,transactionStatus,transactionDetailId"
											+ " from TransactionDetails where bseOrderId = :bseOrderId and customerId = :customerId ");
					query.setParameter("bseOrderId", bseOrderId);
					query.setParameter("customerId", customerId);
					transactionDetailQueryResult = query.list();
					
					query = hibernateSession.createQuery("select fundName from PrimaryFundDetails where fundId = :fundId");
					query.setParameter("fundId", transactionDetailQueryResult.get(0)[0]);
					fundName = query.uniqueResult().toString();
					
					hibernateSession.getTransaction().commit();
					
					System.out.println(" Adding a new row in orderDataModelList for fundName : "+fundName+" and fund id : "+transactionDetailQueryResult.get(0)[0]);
					orderDataModel.add(new OrderDataModel(transactionDetailQueryResult.get(0)[5].toString(), fundName, transactionDetailQueryResult.get(0)[1].toString(), 
											transactionDetailQueryResult.get(0)[2].toString(), transactionDetailQueryResult.get(0)[3].toString(),
											transactionDetailQueryResult.get(0)[4].toString()));
					
					
				}
				
			
				sessionMap.put("orderDataModel", orderDataModel);
		    	
		    	logger.debug("Trading class : executeTrade method : stored orderDataModel : in session id : "+sessionMap.getClass().getName());
			
			
			// Savita Wadhwani - Somehow we need to check whether payment was successful or not - end
			
			logger.debug("Trading class : executeTrade method : end");

			return paymentUrlFile;
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
			hibernateSession.close();

		}

	}

	public void checkPaymentStatus(String customerId) throws MoneyBuddyException {

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

			session = HibernateUtil.getSessionAnnotationFactory().openSession();


			session.beginTransaction();
			query = session.createQuery("select distinct(customerId) from Customers");

			customerIds = query.list();

			//session.getTransaction().commit();

			for (String customerid : customerIds)  {
				System.out.println("customerid : "+customerid);


			}
				//session.beginTransaction();
				query = session.createQuery("select transactionId, transactionDetailId, transactionDate, bseOrderId , productId , quantity, transactionAmount from TransactionDetails where customerId='"+customerId+"' and transactionStatus='5'");

				transactionDetails = query.list();

				//session.getTransaction().commit();

				for (Object[]  transactionDetail : transactionDetails)  {

					System.out.println("Order number : "+transactionDetail[3]);

					long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date startDate;

					startDate = dateFormat.parse(transactionDetail[2].toString());

					Date date = new Date();
					String frmtdDate = dateFormat.format(date);
					Date todayDate = dateFormat.parse(frmtdDate);

					boolean lessThanToday = Math.abs(todayDate.getTime() - startDate.getTime()) > MILLIS_PER_DAY;
					System.out.println("lessThanToday is : "+lessThanToday+" for transactionDetailId : "+transactionDetail[1]);

					if (lessThanToday)  {

						//session.beginTransaction();
						session.createQuery("update TransactionDetails set transactionStatus='6' where transactionDetailId='"+transactionDetail[1].toString()+"'").executeUpdate();
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

						PASSWORD_STARMF = resultsStarMF[1];

						String paymentStatusResponse = iStarMFWebService.mfapi("11",properties.getProperty("USER_ID"),PASSWORD_STARMF,paymentStatusDetails);

						System.out.println("paymentStatusResponse : "+paymentStatusResponse);

						String[] resultsPaymentStatusResponse = paymentStatusResponse.split("\\|");

						dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						date = new Date();
						String frmtdDateForDB = dateFormat.format(date);

						String refNumber = null;
						List<String> paymentDetailsList;
						if (resultsPaymentStatusResponse[0].equals("100"))  {

							session.beginTransaction();

							query = session.createQuery("select paymentRefNum from PaymentDetails where transactionDetailId='"+transactionDetail[1].toString()+"' and bseOrderID='"+transactionDetail[3].toString()+"'");
							paymentDetailsList = query.list();

							//session.getTransaction().commit();

							//session.beginTransaction();

							if (paymentDetailsList.isEmpty())  {
								tempPaymentDetail = new PaymentDetails( transactionDetail[1].toString(), transactionDetail[3].toString(),
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
								session.createQuery("update TransactionDetails set transactionStatus='7' where transactionDetailId='"+transactionDetail[1].toString()+"'").executeUpdate();
								session.getTransaction().commit();

								Double quantity = Double.parseDouble(transactionDetail[5].toString());

								session.beginTransaction();

								Object result = session.createQuery("select pendingOrders from ebdb.CUSTOMER_PORTFOLIO where PRODUCT_ID='"+transactionDetail[4].toString()+"' and TRANSACTION_DETAIL_ID='"+transactionDetail[1].toString()+"'").uniqueResult();
								Double pendingOrder = 0.0;
								Double totalQuantity = 0.0;
								if (result != null) 
									pendingOrder = Double.parseDouble(result.toString());

								//session.getTransaction().commit();
								
								//session.beginTransaction();
								result = session.createQuery("select totalQuantity from ebdb.CUSTOMER_PORTFOLIO where PRODUCT_ID='"+transactionDetail[4].toString()+"' and TRANSACTION_DETAIL_ID='"+transactionDetail[1].toString()+"'").uniqueResult();

								if (result != null)
									totalQuantity  = Double.parseDouble(result.toString());

								pendingOrder -= quantity;
								totalQuantity += quantity;
								//session.getTransaction().commit();


								//session.beginTransaction();
								session.createQuery("update ebdb.CUSTOMER_PORTFOLIO set PENDING_ORDERS='"+pendingOrder+"', TOTAL_QUANTITY='"+totalQuantity+"' where PRODUCT_ID='"+transactionDetail[4].toString()+"' and TRANSACTION_DETAIL_ID='"+transactionDetail[1].toString()+"'").executeUpdate();
								session.getTransaction().commit();

								session.beginTransaction();
								result = session.createQuery("select fundName from PrimaryFundDetails where fundId='"+transactionDetail[4].toString()+"'").uniqueResult();
								String fundName = null;

								if (result != null) 
									fundName = result.toString();
								//session.getTransaction().commit();

								successfulPayment.put(fundName, transactionDetail[6].toString());
								
							}
							else {
								//session.beginTransaction();
								Object result = session.createQuery("select fundName from PrimaryFundDetails where fundId='"+transactionDetail[4].toString()+"'").uniqueResult();
								String fundName = null;

								if (result != null) 
									fundName = result.toString();
								//session.getTransaction().commit();
								
								pendingPayment.put(fundName, transactionDetail[6].toString());
								
							}

						}

					}
				}

				if (!successfulPayment.isEmpty())
				{
					//session.beginTransaction();
					Object result = session.createQuery("select emailId from Customers where customerId='"+customerId+"'").uniqueResult();
					String emailId = null;

					if (result != null) 
						emailId = result.toString();

					//session.getTransaction().commit();

					String subject="[MoneyBuddy] Thank you for the payment.";
					SendMail sendMail = new SendMail();
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
		finally {
			session.close();
		}

	}

}
