/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.ObjectFactory;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.PasswordRequest;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.RequestParam;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.Response;
import org.datacontract.schemas._2004._07.starmfwebservice.ChildOrderDetails;
import org.datacontract.schemas._2004._07.starmfwebservice.ChildOrderRequest;
import org.datacontract.schemas._2004._07.starmfwebservice.ChildOrderResponse;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.tempuri.IStarMFPaymentGatewayService;
import org.tempuri.MFOrderEntry;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import com.myMoneyBuddy.EntityClasses.PaymentDetails;
import com.myMoneyBuddy.EntityClasses.SecondaryFundDetails;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.OrderDataModel;
import com.myMoneyBuddy.Utils.CommonUtil;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceStarMF;
import com.myMoneyBuddy.webServices.WebServiceStarMFPaymentGateway;

public class Trading {

	Logger logger = Logger.getLogger(Trading.class);

	public String createClient(String clientHolding, String clientTaxStatus, String clientOccupationCode, String clientDob,
			String clientGender, String clientGuardian, String clientAccType1, String clientAccNo1, String clientNeftIfscCode1,
			String clientAdd, String clientCity, String clientState, String clientPinCode, String clientCountry,
			String customerId, String clientAppName1, String clientEmail, String clientPan, String clientMobile) throws MoneyBuddyException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {
			
			logger.debug("Trading class - createClient method - customerId - "+customerId+" - start");
			hibernateSession.beginTransaction();
			
			Properties clientProperties = new Properties();
			String clientPropFilePath = "../../../config/client.properties";

			clientProperties.load(Trading.class.getResourceAsStream(clientPropFilePath));
			
			logger.debug("Trading class - createClient method - customerId - "+customerId+" - Loaded clientProperties file.");
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));
			
			logger.debug("Trading class - createClient method - customerId - "+customerId+" - Loaded configProperties file.");
			
			WebServiceStarMF wbStarMF = new WebServiceStarMF();		
			in.bsestarmf._2016._01.IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();
			
			String taxStatus,state,occupation,dob,clientDetails,getPasswordResp,passwordStartMf,ucc;

			
			// Savita Wadhwani - Self Comment - Start 
			// Check if we can get rid of re-writing same query again and agian 
			
			Query query = hibernateSession.createQuery("select bseCode from RtaSpecificCodes where fieldType = 'taxstatus' and fieldValue = :fieldValue ");
			query.setParameter("fieldValue", clientTaxStatus);
			
			taxStatus = query.uniqueResult().toString();
			
			query = hibernateSession.createQuery("select bseCode from RtaSpecificCodes where fieldType = 'state' and fieldValue = :fieldValue ");
			query.setParameter("fieldValue", clientState);
			
			state = query.uniqueResult().toString();
			
			query = hibernateSession.createQuery("select bseCode from RtaSpecificCodes where fieldType = 'Occupation' and fieldValue = :fieldValue ");
			query.setParameter("fieldValue", clientOccupationCode);
			
			occupation = query.uniqueResult().toString();
			hibernateSession.getTransaction().commit();
			
			dob = clientDob.substring(8,10)+"/"+clientDob.substring(5,7)+"/"+clientDob.substring(0,4);
			System.out.println("dob : "+dob);
			
			String[] clientDetailsArray = {customerId,clientHolding,taxStatus,occupation,clientAppName1,clientProperties.getProperty("CLIENT_APPNAME2"),
					clientProperties.getProperty("CLIENT_APPNAME3"),dob,clientGender,clientProperties.getProperty("CLIENT_GUARDIAN"),clientPan,
					clientProperties.getProperty("CLIENT_NOMINEE"),clientProperties.getProperty("CLIENT_NOMINEE_RELATION"),clientProperties.getProperty("CLIENT_GUARDIANPAN"),
					clientProperties.getProperty("CLIENT_TYPE"),clientProperties.getProperty("CLIENT_DEFAULTDP"),clientProperties.getProperty("CLIENT_CDSLDPID"),
					clientProperties.getProperty("CLIENT_CDSLCLTID"),clientProperties.getProperty("CLIENT_NSDLDPID"),clientProperties.getProperty("CLIENT_NSDLCLTID"),
					clientAccType1,clientAccNo1,clientProperties.getProperty("CLIENT_MICRNO_1"),clientNeftIfscCode1,clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_1"),
					clientProperties.getProperty("CLIENT_ACCTYPE_2"),clientProperties.getProperty("CLIENT_ACCNO_2"),clientProperties.getProperty("CLIENT_MICRNO_2"),
					clientProperties.getProperty("CLIENT_NEFT_IFSCCODE_2"),clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_2"),clientProperties.getProperty("CLIENT_ACCTYPE_3"),
					clientProperties.getProperty("CLIENT_ACCNO_3"),clientProperties.getProperty("CLIENT_MICRNO_3"),clientProperties.getProperty("CLIENT_NEFT_IFSCCODE_3"),
					clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_3"),clientProperties.getProperty("CLIENT_ACCTYPE_4"),clientProperties.getProperty("CLIENT_ACCNO_4"),
					clientProperties.getProperty("CLIENT_MICRNO_4"),clientProperties.getProperty("CLIENT_NEFT_IFSCCODE_4"),clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_4"),
					clientProperties.getProperty("CLIENT_ACCTYPE_5"),clientProperties.getProperty("CLIENT_ACCNO_5"),clientProperties.getProperty("CLIENT_MICRNO_5"),
					clientProperties.getProperty("CLIENT_NEFT_IFSCCODE_5"),clientProperties.getProperty("CLIENT_DEFAULT_BANK_FLAG_5"),clientProperties.getProperty("CLIENT_CHEQUENAME_5"),
					clientAdd,clientProperties.getProperty("CLIENT_ADD_2"),clientProperties.getProperty("CLIENT_ADD_3"),clientCity,state,clientPinCode,clientCountry,
					clientProperties.getProperty("CLIENT_RESIPHONE"),clientProperties.getProperty("CLIENT_RESIFAX"),clientProperties.getProperty("CLIENT_OFFICEPHONE"),
					clientProperties.getProperty("CLIENT_OFFICEFAX"),clientEmail,clientProperties.getProperty("CLIENT_COMMMODE"),clientProperties.getProperty("CLIENT_DIVPAYMODE"), 
					clientProperties.getProperty("CLIENT_PAN_2"),clientProperties.getProperty("CLIENT_PAN_3"),clientProperties.getProperty("CLIENT_MAPIN_NO"),
					clientProperties.getProperty("CLIENT_CM_FORADD_1"),clientProperties.getProperty("CLIENT_CM_FORADD_2"),clientProperties.getProperty("CLIENT_CM_FORADD_3"),
					clientProperties.getProperty("CLIENT_CM_FORCITY"),clientProperties.getProperty("CLIENT_CM_FORPINCODE"),clientProperties.getProperty("CLIENT_CM_FORSTATE"),
					clientProperties.getProperty("CLIENT_CM_FORCOUNTRY"),clientProperties.getProperty("CLIENT_CM_FORRESIPHONE"),clientProperties.getProperty("CLIENT_CM_FORRESIFAX"),
					clientProperties.getProperty("CLIENT_CM_FOROFFPHONE"),clientProperties.getProperty("CLIENT_CM_FOROFFFAX"),clientMobile};

			clientDetails = String.join("|",clientDetailsArray);

			logger.debug("Trading class - createClient method - customerId - "+customerId+" - cleint details array created ");
			logger.debug("Trading class - createClient method - customerId - "+customerId+" - cleint details array - "+clientDetails);
			System.out.println("clientDetails : "+clientDetails);

			getPasswordResp = iStarMFWebService.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("MEMBER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

			String[] resultsStarMF = getPasswordResp.split("\\|");

			for (int i = 0 ; i <resultsStarMF.length ; i++ )   {
				System.out.println("resultsStarMF : "+i+" : " +resultsStarMF[i]);
			}

			logger.debug("Trading class - createClient method - customerId - "+customerId+" - fetched encrypted password from iStarMFWebService API ");
			
			passwordStartMf = resultsStarMF[1];

			ucc = iStarMFWebService.mfapi("02",configProperties.getProperty("USER_ID"),passwordStartMf,clientDetails);

			logger.debug("Trading class - createClient method - customerId - "+customerId+" - client created through iStarMFWebService API on BSE");
			
			System.out.println("iStarMFWebService - mfapi response ucc : "+ucc);

			logger.debug("Trading class - createClient method - customerId - "+customerId+" - end");
			
			return ucc;

		}catch (IOException e) {
			logger.error("Trading class - createClient method - customerId - "+customerId+" - Caught IOException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Trading class - createClient method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String generateMandateId(String customerId, String mandateType, String accountNum, String accountType, 
						String ifscCode) throws MoneyBuddyException {

		try {
			
			logger.debug("Trading class - generateMandateId method - customerId - "+customerId+" - start");
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));
			
			logger.debug("Trading class - generateMandateId method - customerId - "+customerId+" - Loaded configProperties file.");
			
			String PASSWORD_STARMF;

			/*StarMFWebService starMFWebService= new StarMFWebService();
			in.bsestarmf._2016._01.IStarMFWebService iStarMFWebService = starMFWebService.getWSHttpBindingIStarMFWebService();*/
			
			WebServiceStarMF wbStarMF = new WebServiceStarMF();		
			in.bsestarmf._2016._01.IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();

			Date date = new Date();
			String mandateIdStartDate= new SimpleDateFormat("dd/MM/yyyy").format(date);
			
			Calendar today = Calendar.getInstance();
			
			Calendar hundredYearsFromToday = today;
			
			hundredYearsFromToday.add(Calendar.YEAR, 100); // to get previous year add -1
			date = hundredYearsFromToday.getTime();
			String mandateIdEndDate= new SimpleDateFormat("dd/MM/yyyy").format(date);
			
			System.out.println("MANDATE ID START DATE : "+mandateIdStartDate);
			System.out.println("MANDATE ID END DATE : "+mandateIdEndDate);
			
			
			
			//String frmtdStartDateForMandateId = sipStartDate.substring(3,5)+"/"+sipStartDate.substring(0,2)+"/"+sipStartDate.substring(6,10);
			//String frmtdEndDateForMandateId = sipEndDate.substring(3,5)+"/"+sipEndDate.substring(0,2)+"/"+sipEndDate.substring(6,10);
			
			String[] mandateIdDetailsArray = {customerId,"120000",mandateType,accountNum,accountType,ifscCode,"",mandateIdStartDate,mandateIdEndDate};

			String mandateIdDetails = String.join("|",mandateIdDetailsArray);

			String passwordStarMF = iStarMFWebService.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("MEMBER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

			String[] resultsStarMF = passwordStarMF.split("\\|");

			for (int i = 0 ; i <resultsStarMF.length ; i++ )   {
				System.out.println("resultsStarMF : "+i+" : " +resultsStarMF[i]);
			}

			logger.debug("Trading class - generateMandateId method - customerId - "+customerId+" - fetched encrypted password from iStarMFWebService API ");
			System.out.println("passwordStarMF : "+passwordStarMF);

			PASSWORD_STARMF = resultsStarMF[1];

			String mandateIdResponse = iStarMFWebService.mfapi("06",configProperties.getProperty("USER_ID"),PASSWORD_STARMF,mandateIdDetails);

			System.out.println("mandateIdResponse : "+mandateIdResponse);
			logger.debug("Trading class - generateMandateId method - customerId - "+customerId+" - generated mandateId - "+mandateIdResponse);

			logger.debug("Trading class - generateMandateId method - customerId - "+customerId+" - end");
			
			return mandateIdResponse;

		}catch (IOException e) {
			logger.error("Trading class - generateMandateId method - customerId - "+customerId+" - Caught IOException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Trading class - generateMandateId method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		}

	}

	public String executeTrade(String customerId, String panCard, Map<String, Double> productDetailsMap, 
			String transactionCode, String transactionType, String buySell, String accountNum, String bankId, String ifsc, String bankMode, 
			String firstOrderFlag, String paymentGatewayComment, String mandateId, String tranDetailId,  Map<String, Object> sessionMap) throws MoneyBuddyException {


		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Double totalAmount = 0.0;
		String buySellValue; 
		String buySellType ;
		String transactionDetailId;
		Query query;
		TransactionDetails tempTransactionDetail;
		SipDetails tempSipDetail;
		List<OrderDataModel> orderDataModel;
		

		try {
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - start");
			
			System.out.println("Trading class : executeTade method : transactionType : "+transactionType);
			//System.out.println("Trading class : executeTade method : years : "+years);
			
			orderDataModel = new LinkedList<OrderDataModel>();

			for ( Double currentAmount : productDetailsMap.values())  {
				System.out.println("currentAmount : "+currentAmount);
				totalAmount = totalAmount + currentAmount;
			}

			Properties clientProperties = new Properties();
			String clientPropFilePath = "../../../config/client.properties";

			clientProperties.load(Trading.class.getResourceAsStream(clientPropFilePath));
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - Loaded clientProperties file.");
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));

			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - Loaded configProperties file.");
			
			WebServiceMFOrder wbMFOrder = new WebServiceMFOrder();	
			MFOrderEntry mfOrderEntry = wbMFOrder.getWSHttpBindingMFOrderEntry();
			String passwordMFOrder;
			String[] resultsMFOrder;
			String PASSWORD_MFORDER;
			WebServiceStarMFPaymentGateway webServiceStarMFPaymentGateway = new WebServiceStarMFPaymentGateway();		
			IStarMFPaymentGatewayService iStarMFPaymentGatewayService = webServiceStarMFPaymentGateway.getWSHttpBindingIStarMFPaymentGatewayService();
			String PASSWORD_STARMF;
			Response passwordStarMFPaymentGateway;
			String[] resultsStarMFPaymentGateway;
			String entryParam;
			String[] resultsEntryParam = null;

			boolean allOrderFailed = true ;
			String paymentUrl;
			
			ArrayOfstring orderNums = new ArrayOfstring();
			
			Double totalPaymentAmount = 0.0;

			//String path = ServletActionContext.getServletContext().getRealPath("");
			//System.out.println("Path : "+path);
			//System.out.println("Real Path : "+ ServletActionContext.getRequest().getSession().getServletContext().getRealPath("") );
			
			//String paymentUrlFile = ServletActionContext.getServletContext().getRealPath("")+"payment.html";
			
			if ("NotSet".equals(tranDetailId))  {
				
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - flow for fresh order start");
				System.out.println("Inside if case : tranDetailId is "+tranDetailId);
			
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String frmtdDateForDB = dateFormat.format(date);
	
				System.out.println("frmtdDateForDB : "+frmtdDateForDB);
				
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date dateForDbf = new Date();
	
	
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = new Date();
				String frmtdDate = dateFormat.format(date);
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("select max(transactionId) from TransactionDetails");
				
				String transactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
				
				
				hibernateSession.getTransaction().commit();

				
				
			for ( String currentProductDetails : productDetailsMap.keySet())  {
				String schemeCode = null;
				String amcCode = null;
				//String folioNum = null;
				String schemeType = null;
				String category = null;
				buySellType = "FRESH";
				
				String[] proIdAndFunId = currentProductDetails.split(":");
				String selFundId = proIdAndFunId[0];
				String selFolioNum = proIdAndFunId[1];
				String selSipDuration = null;
				String selSipDate = null;
				String selSipStartDate = null;
				String selSipEndDate = null;
				
				if ("SIP".equals(transactionType ))  {
					selSipDuration = proIdAndFunId[2];
					selSipDate = proIdAndFunId[3];
					selSipStartDate = proIdAndFunId[4];
					selSipEndDate = proIdAndFunId[5];
				}
				
				
				/*Calendar cal = Calendar.getInstance();
				
				
				if (selSipDate.length() == 1) {
					selSipDate = "0"+selSipDate;
				}
				
				String sipStartMonth;
				String sipEndMonth;
				
				CommonUtil commonUtil= new CommonUtil();
				
				if ( Integer.parseInt(selSipDate) <=   (cal.get(Calendar.DATE)) ) {
					sipStartMonth = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? commonUtil.theMonth(0) : commonUtil.theMonth(cal.get(Calendar.MONTH)+1));
					sipEndMonth = commonUtil.theMonth(cal.get(Calendar.MONTH));
				}
				else {
					sipStartMonth = commonUtil.theMonth(cal.get(Calendar.MONTH));
					sipEndMonth = (("0".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? commonUtil.theMonth(11) : commonUtil.theMonth(cal.get(Calendar.MONTH)-1));
				}
				System.out.println(" sipEndMonth : "+sipEndMonth);
				System.out.println(" date.getYear() : "+cal.get(Calendar.YEAR));
				String sipEndYear = Integer.toString(cal.get(Calendar.YEAR)+Integer.parseInt(selSipDuration));
				String sipStartYear = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? Integer.toString(cal.get(Calendar.YEAR)+1) : Integer.toString(cal.get(Calendar.YEAR)));
				System.out.println(" sipEndYear : "+sipEndYear);
				*/
				//String sipStartDate = sipStartMonth+"/"+selSipDate+"/"+sipStartYear;
				//String sipEndDate = sipEndMonth+"/"+selSipDate+"/"+sipEndYear;
				
				
				System.out.println("selFundId : "+selFundId+" and selFolioNum : "+selFolioNum+" and selSipStartDate : "+selSipStartDate+" and selSipEndDate : "+selSipEndDate);

				QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
				SecondaryFundDetails secondaryFundDetails = querySecondaryFundDetails.getSecondaryFundDetails(selFundId);
				
				List<Object[]> primaryFundDetailsResult;
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("select schemeType,category "
										+ " from PrimaryFundDetails where fundId = :fundId ");
				query.setParameter("fundId", selFundId);
				
				primaryFundDetailsResult = query.list();
				
				hibernateSession.getTransaction().commit();
				
				schemeType = primaryFundDetailsResult.get(0)[0].toString();
				category = primaryFundDetailsResult.get(0)[1].toString();
				
				if (secondaryFundDetails != null) {
					schemeCode = secondaryFundDetails.getSchemeCode();
					amcCode = secondaryFundDetails.getAmcCode();
				}

				System.out.println(" schemeCode :  "+schemeCode +" for fund Id : "+selFundId);

				/*hibernateSession.beginTransaction();
				
				Object result = null;
				query = hibernateSession.createQuery("select folioNum from FolioDetails where amcCode = :amcCode and customerId = :customerId and panCard = :panCard and generatedBy = :generatedBy ");
				query.setParameter("amcCode", amcCode);
				query.setParameter("customerId", customerId);
				query.setParameter("panCard", panCard);
				query.setParameter("generatedBy", "MoneyBuddy");
				
				result = query.uniqueResult();
				hibernateSession.getTransaction().commit();*/
				
				/*if (result != null)  {
					folioNum= result.toString();
				}*/
				/*else {
					hibernateSession.beginTransaction();
					query = hibernateSession.createQuery("select folioNum from FolioDetails where amcCode = :amcCode and customerId = :customerId and panCard = :panCard and generatedBy = :generatedBy ");
					query.setParameter("amcCode", amcCode);
					query.setParameter("customerId", customerId);
					query.setParameter("panCard", panCard);
					query.setParameter("generatedBy", "Others");
					
					result = query.uniqueResult();
					hibernateSession.getTransaction().commit();
					
					if (result != null)  {
						folioNum= result.toString();
					}
					
				}*/
				
				

				Double currentTransactionAmount = productDetailsMap.get(currentProductDetails);

				System.out.println("Trading class : executeTrade method : currentTransactionAmount : "+currentTransactionAmount);

				if ( !"NEW".equals(selFolioNum) )  {
					
						buySellType = "ADDITIONAL";
						
					
					
				}
				
				hibernateSession.beginTransaction();
				
				tempTransactionDetail  = new TransactionDetails(transactionId, null,null,null, customerId,transactionType,
						transactionCode,buySell, buySellType, Double.toString(currentTransactionAmount),
						"1", null,null,"N",selFundId, null,null,frmtdDateForDB, frmtdDateForDB,"N",selFolioNum); 		

				hibernateSession.save(tempTransactionDetail);

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - inserted new row in TransactionDetails table with transactionId - "+transactionId);

				hibernateSession.getTransaction().commit();
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("delete from CustomerCart where customerId = :customerId and transactionType = :transactionType and productId = :productId and folioNumber = :folioNumber ");
				query.setParameter("customerId", customerId);
				query.setParameter("transactionType", transactionType);
				query.setParameter("productId", selFundId);
				query.setParameter("folioNumber", selFolioNum);
				
				query.executeUpdate();
				
				hibernateSession.getTransaction().commit();

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - deleted row from CustomerCart table for productId - "+selFundId+" and folioNumber - "+selFolioNum);
				
				transactionDetailId = tempTransactionDetail.getTransactionDetailId();
				
				//transactionDetailIdList.add(transactionDetailId);

				if ("SIP".equals(transactionType ))  {
					hibernateSession.beginTransaction();
					
					System.out.println("customerId for SipDetails is : "+customerId);
					System.out.println("transactionDetailId for SipDetails is : "+transactionDetailId);
					System.out.println("sipDate for selSipDate is : "+selSipDate);
					System.out.println("sipStartDate for SipDetails is : "+selSipStartDate);
					System.out.println("sipEndDate for SipDetails is : "+selSipEndDate);
					
					String frmtdStartDateForSip = selSipStartDate.substring(6,10)+"-"+selSipStartDate.substring(0,2)+"-"+selSipStartDate.substring(3,5);
					String frmtdEndDateForSip = selSipEndDate.substring(6,10)+"-"+selSipEndDate.substring(0,2)+"-"+selSipEndDate.substring(3,5);
					
					tempSipDetail = new SipDetails(customerId, transactionDetailId,
							selSipDate, frmtdStartDateForSip, frmtdEndDateForSip,selSipDuration,"N","N");
	
					hibernateSession.save(tempSipDetail);
					hibernateSession.getTransaction().commit();
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - inserted new row in SipDetails table");
				}
				
				// Commented dbf specific code - start 
				
				/*dateFormat = new SimpleDateFormat("HH:mm:ss");
				Date CurrentTime = dateFormat.parse(dateFormat.format(new Date()));
				
				String closingTimeStr = configProperties.getProperty("CLOSING_TIME");
				Date closingTime = dateFormat.parse(closingTimeStr);

				String frmtdDateForDBF;
				if (CurrentTime.after(closingTime))
				{
					dateForDbf = DateUtils.addDays(dateForDbf, 1);
					frmtdDateForDBF = dateFormat.format(dateForDbf);
				}
				else
				{
					frmtdDateForDBF = dateFormat.format(dateForDbf);
				}*/

				// Commented dbf specific code - end
				
				passwordMFOrder = mfOrderEntry.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

				resultsMFOrder = passwordMFOrder.split("\\|");


				PASSWORD_MFORDER = resultsMFOrder[1];

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - fetched encrypted password from mfOrderEntry API ");
				
								
				if ("NEW".equals(selFolioNum)) {
					selFolioNum = clientProperties.getProperty("FOLIO_NUMBER");
					System.out.println("FOLIO_NUMBER fetched from client properties file ..........");
				}
					
				
				if ("Debt".equals(schemeType) && "Liquid".equals(category))   {
					
					SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
					Date oneFifteenPm = parser.parse("13:15");
					Date threePm = parser.parse("15:00");
					
					
					if (date.after(oneFifteenPm) && date.before(threePm)) {
				    
						schemeCode = schemeCode+"-L0" ;
					}
				}
				else {
					if ( productDetailsMap.get(currentProductDetails) >= 200000.00 ) {
						schemeCode = schemeCode+"-L1" ;	
					}
				}
				
				System.out.println(" SCHEME CODE : "+schemeCode);
				
				if ("UPFRONT".equals(transactionType))  {

					if (buySell == "BUY")  {
						buySellValue = "P";
					}
					else {
						buySellValue = "R";
					}
					
					
					
					
					System.out.println(" transactionDetailId : "+transactionDetailId+" and amount : "+Double.toString(productDetailsMap.get(currentProductDetails)));
					entryParam = mfOrderEntry.orderEntryParam(transactionCode,transactionDetailId,clientProperties.getProperty("ORDER_ID"),configProperties.getProperty("USER_ID"),
							configProperties.getProperty("MEMBER_ID"),customerId,schemeCode,buySellValue,buySellType,
							clientProperties.getProperty("DP_TXN"),Double.toString(productDetailsMap.get(currentProductDetails)),clientProperties.getProperty("QTY"),
							clientProperties.getProperty("ALL_REDEEM"),selFolioNum,clientProperties.getProperty("REMARKS"),
							clientProperties.getProperty("KYC_STATUS"),clientProperties.getProperty("REF_NO"),clientProperties.getProperty("SUB_BR_CODE"),
							clientProperties.getProperty("EUIN"),clientProperties.getProperty("EUIN_FLAG"),clientProperties.getProperty("MIN_REDEEM"),clientProperties.getProperty("DPC"),
							clientProperties.getProperty("IP_ADDRESS"),PASSWORD_MFORDER,configProperties.getProperty("PASS_KEY"),clientProperties.getProperty("PARAM_1"),
							clientProperties.getProperty("PARAM_2"),clientProperties.getProperty("PARAM_3"));
				
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - "+buySell+" -order for schemeCode - "+schemeCode+" - placed to BSE for transactionDetailId - "+transactionDetailId);
					
				}
				else {

					System.out.println(" transactionDetailId : "+transactionDetailId+" and amount : "+Double.toString(productDetailsMap.get(currentProductDetails)));
					System.out.println(" start Date  : "+frmtdDate );
					System.out.println(" sip start Date  : "+selSipStartDate );

					String startDate = selSipStartDate.substring(3,5)+"/"+selSipStartDate.substring(0,2)+"/"+selSipStartDate.substring(6,10);
				
					System.out.println(" startDate  : "+startDate );
					System.out.println(" numOfInstallments  : "+Integer.toString(Integer.parseInt(selSipDuration)*12) );
					
					entryParam = mfOrderEntry.xsipOrderEntryParam(transactionCode, transactionDetailId, schemeCode, configProperties.getProperty("MEMBER_ID"),
							customerId, configProperties.getProperty("USER_ID"), clientProperties.getProperty("INTERNAL_REF_NUM"), clientProperties.getProperty("TRANSMODE"), 
							clientProperties.getProperty("DP_TXN"), startDate,clientProperties.getProperty("FREQUENCY_TYPE"),clientProperties.getProperty("FREQUENCY_ALLOWED"),
							Double.toString(productDetailsMap.get(currentProductDetails)),Integer.toString(Integer.parseInt(selSipDuration)*12),clientProperties.getProperty("REMARKS"),
							selFolioNum,"Y",clientProperties.getProperty("BROKERAGE"),"",clientProperties.getProperty("SUB_BR_CODE"),
							clientProperties.getProperty("EUIN"),
							clientProperties.getProperty("EUIN_FLAG"),clientProperties.getProperty("DPC"),clientProperties.getProperty("REGID"),clientProperties.getProperty("IP_ADDRESS"),
							PASSWORD_MFORDER,configProperties.getProperty("PASS_KEY"),clientProperties.getProperty("PARAM_1"),mandateId,
							clientProperties.getProperty("PARAM_3"));
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - new Sip start order for schemeCode - "+schemeCode+" - placed to BSE for transactionDetailId - "+transactionDetailId);
					
				}

				System.out.println(" transactionType :!!!!!!!!!!!!!!!!............................... "+transactionType);
				resultsEntryParam = entryParam.split("\\|");

				for (int i = 0 ; i <resultsEntryParam.length ; i++ )   {
					System.out.println("resultsEntryParam : "+i+" : " +resultsEntryParam[i]);
				}
				
				String bseOrderId = null;
				String bseRegNum = null;
				hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("update TransactionDetails set bseOrderId = :bseOrderId , bseRegistrationNumber = :bseRegistrationNumber , "
																	+ "uniqueReferenceNumber = :uniqueReferenceNumber, transactionStatus =:transactionStatus ,"
																	+ " bseRemarks = :bseRemarks , bseSuccessFlag = :bseSuccessFlag " + " "
																			+ " where transactionDetailId = :transactionDetailId");
				
				System.out.println(" transactionType :!!!!!!!!!!!!!!!!.................................. "+transactionType);
				
				if ("UPFRONT".equals(transactionType) ) {
					bseOrderId = resultsEntryParam[2].toString();
					
				}
				else {
					
					bseRegNum = resultsEntryParam[5].toString();
					
					if ("Y".equals(firstOrderFlag)) {
						
						
						WebServiceStarMF wbStarMF = new WebServiceStarMF();		
						in.bsestarmf._2016._01.IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();
						
						ChildOrderRequest childOrderRequest = new ChildOrderRequest();
						
						org.datacontract.schemas._2004._07.starmfwebservice.ObjectFactory objFact = org.datacontract.schemas._2004._07.starmfwebservice.ObjectFactory.class.newInstance();
						
						SimpleDateFormat childReqDateFormat = new SimpleDateFormat("dd MMM yyyy");
						date = new Date();
						String frmtdChildReqDate = childReqDateFormat.format(date);
						
						System.out.println("bseRegNum is : "+bseRegNum);
						System.out.println("customerId is : "+customerId);
						
						/*String passwordStarMF = iStarMFWebService.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("MEMBER_ID"),
								configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));
	
						
						String[] resultsStarMF = passwordStarMF.split("\\|");
	
						for (int i = 0 ; i <resultsStarMF.length ; i++ )   {
							System.out.println("resultsStarMF : "+i+" : " +resultsStarMF[i]);
						}
	
						logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - fetched encrypted password from iStarMFWebService API ");
						System.out.println("passwordStarMF : "+passwordStarMF);
	
						PASSWORD_STARMF = resultsStarMF[1];*/
						
						org.datacontract.schemas._2004._07.starmfwebservice.PasswordRequest passwordRequest = new org.datacontract.schemas._2004._07.starmfwebservice.PasswordRequest();
						
						passwordRequest.setMemberId(objFact.createPasswordRequestMemberId(configProperties.getProperty("MEMBER_ID")));
						passwordRequest.setUserId(objFact.createPasswordRequestUserId(configProperties.getProperty("USER_ID")));
						passwordRequest.setPassword(objFact.createPasswordRequestPassword(configProperties.getProperty("PASSWORD")));
						passwordRequest.setPassKey(objFact.createPasswordRequestPassKey(configProperties.getProperty("PASS_KEY")));
						
						org.datacontract.schemas._2004._07.starmfwebservice.Response getPasswordForChildOrderResponse = iStarMFWebService.getPasswordForChildOrder(passwordRequest);
						
						String password = getPasswordForChildOrderResponse.getResponseString().getValue().toString();
						
						System.out.println("password  :  "+password);
						
						childOrderRequest.setClientCode(objFact.createChildOrderRequestClientCode(customerId));
						childOrderRequest.setMemberCode(objFact.createChildOrderRequestMemberCode(configProperties.getProperty("MEMBER_ID")));
						childOrderRequest.setSystematicPlanType(objFact.createChildOrderRequestSystematicPlanType("ISIP"));
						childOrderRequest.setRegnNo(objFact.createChildOrderRequestRegnNo(bseRegNum));
						childOrderRequest.setEncryptedPassword(objFact.createChildOrderRequestEncryptedPassword(password));
						childOrderRequest.setDate(objFact.createChildOrderRequestDate(frmtdChildReqDate));
						
						System.out.println("CHILD ORDER REQUEST CLIENT CODE Is : "+childOrderRequest.getClientCode().getValue());
						System.out.println("CHILD ORDER REQUEST MEMBER CODE Is : "+childOrderRequest.getMemberCode().getValue());
						System.out.println("CHILD ORDER REQUEST REQ DATE Is : "+childOrderRequest.getDate().getValue());
						System.out.println("CHILD ORDER REQUEST PASSWORD Is : "+childOrderRequest.getEncryptedPassword().getValue());
						System.out.println("CHILD ORDER REQUEST systematic plan type Is : "+childOrderRequest.getSystematicPlanType().getValue());
						System.out.println("CHILD ORDER REQUEST REGISTRATION NUM Is : "+childOrderRequest.getRegnNo().getValue());
						
						ChildOrderResponse childOrderResponse =  iStarMFWebService.childOrderDetails(childOrderRequest);
						
						System.out.println("BSE ORDER ID FOR ISIP is : "+childOrderResponse.getChildOrderDetails().isNil() );
						
						System.out.println("BSE ORDER ID FOR ISIP Message is : "+childOrderResponse.getMessage().getValue().toString()  );
						
						System.out.println("BSE ORDER ID FOR ISIP Status is : "+childOrderResponse.getStatus().getValue().toString() );
						
						List<ChildOrderDetails> childOrderDetailsArray = childOrderResponse.getChildOrderDetails().getValue().getChildOrderDetails() ;
						
						if (!childOrderResponse.getChildOrderDetails().isNil() )  {
							System.out.println("order number : "+childOrderDetailsArray.get(0).getOrderNumber().getValue());
							
							bseOrderId = childOrderDetailsArray.get(0).getOrderNumber().getValue();
						}
						
	
						/*for (int i = 0 ; i < childOrderDetailsArray.size() ; i++ )   {
							
							System.out.println("abc  : "+i+" : "+ childOrderDetailsArray.get(i).getAmount().getValue() );
						}*/
					
					}
					
				}
				query.setParameter("bseOrderId", bseOrderId);
				query.setParameter("bseRegistrationNumber", bseRegNum);
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - bseOrderId - "+bseOrderId+" recived from BSE for transactionDetailId - "+transactionDetailId);
			

				if ( resultsEntryParam[7].equals("1") ) {
					query.setParameter("transactionStatus", "2");
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - order failed with BSE for transactionDetailId - "+transactionDetailId);
				}
				else  
				{
					if (bseOrderId != null)  {
						orderNums.getString().add(bseOrderId);
						System.out.println(bseOrderId+" added in orderNums");
						logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - amount - "+Double.toString(productDetailsMap.get(currentProductDetails))+" for bseOrderId - "+bseOrderId+"added in orderNums hashMap for payment ");
					}
					
					totalPaymentAmount += productDetailsMap.get(currentProductDetails);
					query.setParameter("transactionStatus", "3");
					allOrderFailed = false;
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - order successfully placed to BSE for transactionDetailId - "+transactionDetailId);
				}

				query.setParameter("uniqueReferenceNumber", resultsEntryParam[1]);
				query.setParameter("bseRemarks", resultsEntryParam[6]);
				query.setParameter("bseSuccessFlag", resultsEntryParam[7]);
				query.setParameter("transactionDetailId", transactionDetailId);
				int updateResult = query.executeUpdate();
				System.out.println(updateResult + " rows updated in transactionDetails table ");
				hibernateSession.getTransaction().commit();
				
				if ("N".equals(firstOrderFlag)) {
					return null;
				}

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

				String status = passwordStarMFPaymentGateway.getStatus().getValue();

				System.out.println("status : "+status);
				
				PASSWORD_STARMF = passwordStarMFPaymentGateway.getResponseString().getValue();
				System.out.println("Response String (Encrypted Password) : "+PASSWORD_STARMF);
				
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - fetched encrypted password from passwordStarMFPaymentGateway API ");

				Iterator it = orderNums.getString().iterator();
				
				/*while(it.hasNext())  {
					System.out.println("oredrNums : "+it.next().toString());
				}*/
				
				System.out.println("accountNum : "+accountNum+" : ifsc : "+ifsc+" : bankId : "+bankId+" : bankMode : "+bankMode);
				DesEncrypter desEncrypter = new DesEncrypter();
				RequestParam requestParam = new RequestParam();
				requestParam.setAccNo(objFact.createRequestParamAccNo( desEncrypter.decrypt(accountNum)));
				requestParam.setBankID(objFact.createRequestParamBankID(bankId));
				requestParam.setClientCode(objFact.createRequestParamClientCode(customerId));
				requestParam.setEncryptedPassword(objFact.createRequestParamEncryptedPassword(PASSWORD_STARMF));
				requestParam.setIFSC(objFact.createRequestParamIFSC(ifsc));
				
				if ("UPFRONT".equals(transactionType))  {
					
					System.out.println(" LOGOUT_URL_UPFRONT set to ............ : "+configProperties.getProperty("LOGOUT_URL_UPFRONT"));
					requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(configProperties.getProperty("LOGOUT_URL_UPFRONT")));
					
				}
				else
					requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(configProperties.getProperty("LOGOUT_URL_SIP")));
				
				requestParam.setMemberCode(objFact.createRequestParamMemberCode(configProperties.getProperty("MEMBER_ID")));
				requestParam.setMode(objFact.createRequestParamMode(bankMode));
				requestParam.setOrders(objFact.createRequestParamOrders(orderNums));
				requestParam.setTotalAmount(objFact.createRequestParamTotalAmount(Double.toString(totalPaymentAmount)));

				System.out.println("requestParam : getAccNo : "+requestParam.getAccNo().getValue());
				Response paymentGateway = iStarMFPaymentGatewayService.paymentGatewayAPI(requestParam);

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"initiated");
				
				String[] resultsPaymentGateway = paymentGateway.toString().split("\\|");

				for (int i = 0 ; i <resultsPaymentGateway.length ; i++ )   {
					System.out.println("resultsPaymentGateway : "+i+" : " +resultsPaymentGateway[i]);
				}

				paymentUrl = paymentGateway.getResponseString().getValue();
				
				String responseStatus = paymentGateway.getStatus().getValue();
				System.out.println("responseStatus : "+responseStatus);
				
				if ("101".equals(responseStatus))  {
					hibernateSession.beginTransaction();
					query = hibernateSession.createQuery("update TransactionDetails set transactionStatus ='4' where transactionId = :transactionId");
					query.setParameter("transactionId", transactionId);
					int updateResult = query.executeUpdate();
					hibernateSession.getTransaction().commit();
					
					System.out.println("Payment gateway failure reason : "+paymentUrl);
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"failed with paymentGateway");
				}
				else {
					
					//File newHtmlFile = new File(paymentUrlFile);
					//FileUtils.writeStringToFile(newHtmlFile, paymentUrl);
					
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
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - subscriberType changed to INVESTOR");
				
					
				}

			}
			else {
				paymentUrl = "NotSet";
				System.out.println("paymentUrl: "+paymentUrl);
			}

				Iterator it = orderNums.getString().iterator();
				
				/*while(it.hasNext())  {
					System.out.println("oredrNums : "+it.next().toString());
				}*/
				
				String bseOrderId = null;
				int result;
				List<Object[]> transactionDetailQueryResult;
				String schemeName;
				
				while(it.hasNext())  {
					
					
					bseOrderId = it.next().toString();
					System.out.println("bseOrderId added in orderNums : "+bseOrderId);
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
					
					query = hibernateSession.createQuery("select productId,transactionAmount,transactionDate,transactionStatus,transactionDetailId"
											+ " from TransactionDetails where bseOrderId = :bseOrderId and customerId = :customerId ");
					query.setParameter("bseOrderId", bseOrderId);
					query.setParameter("customerId", customerId);
					transactionDetailQueryResult = query.list();
					
					hibernateSession.getTransaction().commit();
					
					hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId = :fundId");
					query.setParameter("fundId", transactionDetailQueryResult.get(0)[0]);
					schemeName = query.uniqueResult().toString();
					
					hibernateSession.getTransaction().commit();
					
					System.out.println(" Adding a new row in orderDataModelList for schemeName : "+schemeName+" and fund id : "+transactionDetailQueryResult.get(0)[0]);
					
					QueryOrderStatus queryOrderStatus = new QueryOrderStatus();
					
					String userStatus = queryOrderStatus.getStatusDetail(transactionDetailQueryResult.get(0)[3].toString());
					orderDataModel.add(new OrderDataModel(transactionDetailQueryResult.get(0)[4].toString(), schemeName, 
											transactionDetailQueryResult.get(0)[1].toString(), transactionDetailQueryResult.get(0)[2].toString(),
											userStatus ));
					
					
				}
				
				orderDataModel.add(new OrderDataModel("", "Total", Double.toString(totalAmount), "",""));
				
				for ( int i =0;i<orderDataModel.size();i++)  {
					
					System.out.println("orderDataModel.get("+i+").getSchemeName()"+orderDataModel.get(i).getSchemeName());
					
				}
				sessionMap.put("orderDataModel", orderDataModel);
		    	
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - stored orderDataModel in sessionMap");
		    	
		    	logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - flow for fresh order end");
		    	
			}
			else {
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+"  - flow for re-try payment for existing failed order - start");
				System.out.println("Inside else case : tranDetailId is "+tranDetailId);
				
				
				QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
				TransactionDetails transactionDetails =  queryTransactionDetails.getTransactionDetails(tranDetailId);
				
				transactionType = transactionDetails.getTransactionType();
				orderNums.getString().add(transactionDetails.getBseOrderId());
				
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

				String status = passwordStarMFPaymentGateway.getStatus().getValue();

				System.out.println("status : "+status);
				
				PASSWORD_STARMF = passwordStarMFPaymentGateway.getResponseString().getValue();
				System.out.println("Response String (Encrypted Password) : "+PASSWORD_STARMF);

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - fetched encrypted password from passwordStarMFPaymentGateway API ");
				
				Iterator it = orderNums.getString().iterator();
				
				/*while(it.hasNext())  {
					System.out.println("oredrNums : "+it.next().toString());
				}*/
				
				System.out.println("accountNum : "+accountNum+" : ifsc : "+ifsc+" : bankId : "+bankId+" : bankMode : "+bankMode);
				RequestParam requestParam = new RequestParam();
				requestParam.setAccNo(objFact.createRequestParamAccNo(accountNum));
				requestParam.setBankID(objFact.createRequestParamBankID(bankId));
				requestParam.setClientCode(objFact.createRequestParamClientCode(customerId));
				requestParam.setEncryptedPassword(objFact.createRequestParamEncryptedPassword(PASSWORD_STARMF));
				requestParam.setIFSC(objFact.createRequestParamIFSC(ifsc));
				requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(configProperties.getProperty("LOGOUT_URL")));
				requestParam.setMemberCode(objFact.createRequestParamMemberCode(configProperties.getProperty("MEMBER_ID")));
				requestParam.setMode(objFact.createRequestParamMode(bankMode));
				requestParam.setOrders(objFact.createRequestParamOrders(orderNums));
				requestParam.setTotalAmount(objFact.createRequestParamTotalAmount(transactionDetails.getTransactionAmount()));

				System.out.println("requestParam : getAccNo : "+requestParam.getAccNo().getValue());
				Response paymentGateway = iStarMFPaymentGatewayService.paymentGatewayAPI(requestParam);

				String[] resultsPaymentGateway = paymentGateway.toString().split("\\|");

				for (int i = 0 ; i <resultsPaymentGateway.length ; i++ )   {
					System.out.println("resultsPaymentGateway : "+i+" : " +resultsPaymentGateway[i]);
				}

				paymentUrl = paymentGateway.getResponseString().getValue();
				
				String responseStatus = paymentGateway.getStatus().getValue();
				System.out.println("responseStatus : "+responseStatus);
				
				QueryOrderStatus queryOrderStatus = new QueryOrderStatus();
				
				String userStatus = queryOrderStatus.getStatusDetail(transactionDetails.getTransactionStatus());
				
				QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
				
				String schemeName = queryPrimaryFundDetails.getSchemeName(transactionDetails.getProductId());
				
				orderDataModel.add(new OrderDataModel(tranDetailId, schemeName, 
									transactionDetails.getTransactionAmount(), transactionDetails.getTransactionDate(),userStatus ));
				
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"initiated");
				
				if ("101".equals(responseStatus))  {
					hibernateSession.beginTransaction();
					query = hibernateSession.createQuery("update TransactionDetails set transactionStatus ='6' where transactionId = :transactionId");
					query.setParameter("transactionId", tranDetailId);
					int updateResult = query.executeUpdate();
					hibernateSession.getTransaction().commit();
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"failed with paymentGateway");
					
				}
				else {
					/*File newHtmlFile = new File(paymentUrlFile);
					FileUtils.writeStringToFile(newHtmlFile, paymentUrl);*/
					
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
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - subscriberType changed to INVESTOR");
				}

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - flow for re-try payment for existing failed order - end");
			}
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - user will be re-directed to payment page");
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - end");

			return paymentUrl;
		} catch (NumberFormatException | HibernateException e) {
			logger.error("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - Caught some Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}


	public void executeRedemption(String customerId, String panCard, String fundId, Double amount, Double quantity, String allRedeem, String transactionCode,  
			String transactionType, String buySell
			   ) throws MoneyBuddyException {


		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Double totalAmount = 0.0;
		String buySellValue="R"; 
		String buySellType ;
		String transactionDetailId;
		Query query;
		TransactionDetails tempTransactionDetail;
		SipDetails tempSipDetail;
		//List<OrderDataModel> orderDataModel;
		String amt="";
		String quan="";
		

		try {
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - start");
			
			System.out.println("Trading class : executeTade method : transactionType : "+transactionType);
			//System.out.println("Trading class : executeTade method : years : "+years);
			
			//orderDataModel = new LinkedList<OrderDataModel>();

			/*for ( Double currentAmount : productDetailsMap.values())  {
				System.out.println("currentAmount : "+currentAmount);
				totalAmount = totalAmount + currentAmount;
			}*/
			totalAmount = amount;

			Properties clientProperties = new Properties();
			String clientPropFilePath = "../../../config/client.properties";

			clientProperties.load(Trading.class.getResourceAsStream(clientPropFilePath));
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - Loaded clientProperties file.");
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));

			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - Loaded configProperties file.");
			
			WebServiceMFOrder wbMFOrder = new WebServiceMFOrder();	
			MFOrderEntry mfOrderEntry = wbMFOrder.getWSHttpBindingMFOrderEntry();
			String passwordMFOrder;
			String[] resultsMFOrder;
			String PASSWORD_MFORDER;
			WebServiceStarMFPaymentGateway webServiceStarMFPaymentGateway = new WebServiceStarMFPaymentGateway();		
			IStarMFPaymentGatewayService iStarMFPaymentGatewayService = webServiceStarMFPaymentGateway.getWSHttpBindingIStarMFPaymentGatewayService();
			String PASSWORD_STARMF;
			Response passwordStarMFPaymentGateway;
			String[] resultsStarMFPaymentGateway;
			String entryParam;
			String[] resultsEntryParam = null;

			boolean allOrderFailed = true ;
			String paymentUrl;
			
			ArrayOfstring orderNums = new ArrayOfstring();
			
			Double totalPaymentAmount = 0.0;

			//String path = ServletActionContext.getServletContext().getRealPath("");
			//System.out.println("Path : "+path);
			//System.out.println("Real Path : "+ ServletActionContext.getRequest().getSession().getServletContext().getRealPath("") );
			
			//String paymentUrlFile = ServletActionContext.getServletContext().getRealPath("")+"payment.html";
			

				
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - flow for fresh order start");
				//System.out.println("Inside if case : tranDetailId is "+tranDetailId);
			
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String frmtdDateForDB = dateFormat.format(date);
	
				System.out.println("frmtdDateForDB : "+frmtdDateForDB);
				
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date dateForDbf = new Date();
	
	
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = new Date();
				String frmtdDate = dateFormat.format(date);
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("select max(transactionId) from TransactionDetails");
				
				String transactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
				
				
				hibernateSession.getTransaction().commit();

				
				
			
				String schemeCode = null;
				String amcCode = null;
				String folioNum = null;
				String schemeType = null;
				String category = null;
				buySellType = "FRESH";
				
				System.out.println("fundId : "+fundId);

				QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
				SecondaryFundDetails secondaryFundDetails = querySecondaryFundDetails.getSecondaryFundDetails(fundId);
				
				List<Object[]> primaryFundDetailsResult;
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("select schemeType,category "
										+ " from PrimaryFundDetails where fundId = :fundId ");
				query.setParameter("fundId", fundId);
				
				primaryFundDetailsResult = query.list();
				
				hibernateSession.getTransaction().commit();
				
				schemeType = primaryFundDetailsResult.get(0)[0].toString();
				category = primaryFundDetailsResult.get(0)[1].toString();
				
				if (secondaryFundDetails != null) {
					schemeCode = secondaryFundDetails.getSchemeCode();
					amcCode = secondaryFundDetails.getAmcCode();
				}

				System.out.println(" schemeCode :  "+schemeCode +" for fund Id : "+fundId);

				hibernateSession.beginTransaction();
				
				Object result = null;
				query = hibernateSession.createQuery("select folioNum from FolioDetails where amcCode = :amcCode and customerId = :customerId and panCard = :panCard and generatedBy = :generatedBy ");
				query.setParameter("amcCode", amcCode);
				query.setParameter("customerId", customerId);
				query.setParameter("panCard", panCard);
				query.setParameter("generatedBy", "MoneyBuddy");
				
				result = query.uniqueResult();
				hibernateSession.getTransaction().commit();
				
				if (result != null)  {
					folioNum= result.toString();
				}
				else {
					hibernateSession.beginTransaction();
					query = hibernateSession.createQuery("select folioNum from FolioDetails where amcCode = :amcCode and customerId = :customerId and panCard = :panCard and generatedBy = :generatedBy ");
					query.setParameter("amcCode", amcCode);
					query.setParameter("customerId", customerId);
					query.setParameter("panCard", panCard);
					query.setParameter("generatedBy", "Others");
					
					result = query.uniqueResult();
					hibernateSession.getTransaction().commit();
					
					if (result != null)  {
						folioNum= result.toString();
					}
					
				}
				System.out.println("folioNum :  "+folioNum);
				
				

				Double currentTransactionAmount = amount;

				System.out.println("Trading class : executeTrade method : currentTransactionAmount : "+currentTransactionAmount);

				/*if ( "UPFRONT".equals(transactionType) )  {
					hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery("select count(*) from TransactionDetails  where customerId= :customerId and productId= :productId and transactionType='UPFRONT' ");
					query.setParameter("customerId", customerId);
					query.setParameter("productId", currentProductId);
					hibernateSession.getTransaction().commit();
					
					String count = query.uniqueResult().toString();
					
					if ( Integer.valueOf(count) != 0)  {
						buySellType = "ADDITIONAL";
						
					}
					
				}*/
				
				hibernateSession.beginTransaction();
				
				tempTransactionDetail  = new TransactionDetails(transactionId, null,null,null, customerId,transactionType,
						transactionCode,buySell, buySellType, Double.toString(currentTransactionAmount),
						"1", null,null,"N",fundId, null,null,frmtdDateForDB, frmtdDateForDB,"N",folioNum); 		

				hibernateSession.save(tempTransactionDetail);

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - inserted new row in TransactionDetails table with transactionId - "+transactionId);

				hibernateSession.getTransaction().commit();
				
				/*hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("delete from CustomerCart where customerId = :customerId and productId = :productId ");
				query.setParameter("customerId", customerId);
				query.setParameter("productId", currentProductId);
				
				query.executeUpdate();
				
				hibernateSession.getTransaction().commit();*/

				//logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - deleted row from CustomerCart table for productId - "+currentProductId);
				
				transactionDetailId = tempTransactionDetail.getTransactionDetailId();
				
				//transactionDetailIdList.add(transactionDetailId);

				/*if ("SIP".equals(transactionType ))  {
					hibernateSession.beginTransaction();
					
					System.out.println("customerId for SipDetails is : "+customerId);
					System.out.println("transactionDetailId for SipDetails is : "+transactionDetailId);
					System.out.println("sipDate for SipDetails is : "+sipDate);
					System.out.println("sipStartDate for SipDetails is : "+sipStartDate);
					System.out.println("sipEndDate for SipDetails is : "+sipEndDate);
					
					String frmtdStartDateForSip = sipStartDate.substring(6,10)+"-"+sipStartDate.substring(0,2)+"-"+sipStartDate.substring(3,5);
					String frmtdEndDateForSip = sipEndDate.substring(6,10)+"-"+sipEndDate.substring(0,2)+"-"+sipEndDate.substring(3,5);
					
					tempSipDetail = new SipDetails(customerId, transactionDetailId,
							sipDate, frmtdStartDateForSip, frmtdEndDateForSip,Integer.toString(years),"N","N");
	
					hibernateSession.save(tempSipDetail);
					hibernateSession.getTransaction().commit();
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - inserted new row in SipDetails table");
				}*/
				
				// Commented dbf specific code - start 
				
				/*dateFormat = new SimpleDateFormat("HH:mm:ss");
				Date CurrentTime = dateFormat.parse(dateFormat.format(new Date()));
				
				String closingTimeStr = configProperties.getProperty("CLOSING_TIME");
				Date closingTime = dateFormat.parse(closingTimeStr);

				String frmtdDateForDBF;
				if (CurrentTime.after(closingTime))
				{
					dateForDbf = DateUtils.addDays(dateForDbf, 1);
					frmtdDateForDBF = dateFormat.format(dateForDbf);
				}
				else
				{
					frmtdDateForDBF = dateFormat.format(dateForDbf);
				}*/

				// Commented dbf specific code - end
				
				passwordMFOrder = mfOrderEntry.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

				resultsMFOrder = passwordMFOrder.split("\\|");


				PASSWORD_MFORDER = resultsMFOrder[1];

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - fetched encrypted password from mfOrderEntry API ");
				
								
				if (folioNum == null) {
					folioNum = clientProperties.getProperty("FOLIO_NUMBER");
					System.out.println("FOLIO_NUMBER fetched from client properties file ..........");
				}
					
				
				/*if ("Debt".equals(schemeType) && "Liquid".equals(category))   {
					
					SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
					Date oneFifteenPm = parser.parse("13:15");
					Date threePm = parser.parse("15:00");
					
					
					if (date.after(oneFifteenPm) && date.before(threePm)) {
				    
						schemeCode = schemeCode+"-L0" ;
					}
				}
				else {
					if ( productDetailsMap.get(currentProductId) >= 200000.00 ) {
						schemeCode = schemeCode+"-L1" ;	
					}
				}*/
				
				System.out.println(" SCHEME CODE : "+schemeCode);
				
			
					
					if (!"Y".equals(allRedeem))  {
						if ( amount == 0 ) {
							quan = Double.toString(quantity);
							amt = "";
						}
						else {
							amt = Double.toString(amount);
							quan = "";
						}
					}
					else {
						amt = "";
						quan = "";
					}
					
					
					System.out.println(" transactionDetailId : "+transactionDetailId+" and amount : "+ amount +" allRedeem : "+allRedeem);
					entryParam = mfOrderEntry.orderEntryParam(transactionCode,transactionDetailId,clientProperties.getProperty("ORDER_ID"),configProperties.getProperty("USER_ID"),
							configProperties.getProperty("MEMBER_ID"),customerId,schemeCode,buySellValue,buySellType,
							clientProperties.getProperty("DP_TXN"),amt,quan,
							allRedeem,folioNum,clientProperties.getProperty("REMARKS"),
							clientProperties.getProperty("KYC_STATUS"),clientProperties.getProperty("REF_NO"),clientProperties.getProperty("SUB_BR_CODE"),
							clientProperties.getProperty("EUIN"),clientProperties.getProperty("EUIN_FLAG"),"Y",clientProperties.getProperty("DPC"),
							clientProperties.getProperty("IP_ADDRESS"),PASSWORD_MFORDER,configProperties.getProperty("PASS_KEY"),clientProperties.getProperty("PARAM_1"),
							clientProperties.getProperty("PARAM_2"),clientProperties.getProperty("PARAM_3"));
				
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - "+buySell+" -order for schemeCode - "+schemeCode+" - placed to BSE for transactionDetailId - "+transactionDetailId);
					

				/*else {

					System.out.println(" transactionDetailId : "+transactionDetailId+" and amount : "+Double.toString(productDetailsMap.get(currentProductId)));
					System.out.println(" start Date  : "+frmtdDate );
					System.out.println(" sip start Date  : "+sipStartDate );

					String startDate = sipStartDate.substring(3,5)+"/"+sipStartDate.substring(0,2)+"/"+sipStartDate.substring(6,10);
				
					System.out.println(" startDate  : "+startDate );
					System.out.println(" numOfInstallments  : "+Integer.toString(years*12) );
					
					entryParam = mfOrderEntry.xsipOrderEntryParam(transactionCode, transactionDetailId, schemeCode, configProperties.getProperty("MEMBER_ID"),
							customerId, configProperties.getProperty("USER_ID"), clientProperties.getProperty("INTERNAL_REF_NUM"), clientProperties.getProperty("TRANSMODE"), 
							clientProperties.getProperty("DP_TXN"), startDate,clientProperties.getProperty("FREQUENCY_TYPE"),clientProperties.getProperty("FREQUENCY_ALLOWED"),
							Double.toString(productDetailsMap.get(currentProductId)),Integer.toString(years*12),clientProperties.getProperty("REMARKS"),
							folioNum,"Y",clientProperties.getProperty("BROKERAGE"),"",clientProperties.getProperty("SUB_BR_CODE"),
							clientProperties.getProperty("EUIN"),
							clientProperties.getProperty("EUIN_FLAG"),clientProperties.getProperty("DPC"),clientProperties.getProperty("REGID"),clientProperties.getProperty("IP_ADDRESS"),
							PASSWORD_MFORDER,configProperties.getProperty("PASS_KEY"),clientProperties.getProperty("PARAM_1"),mandateId,
							clientProperties.getProperty("PARAM_3"));
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - new Sip start order for schemeCode - "+schemeCode+" - placed to BSE for transactionDetailId - "+transactionDetailId);
					
				}*/

				resultsEntryParam = entryParam.split("\\|");

				for (int i = 0 ; i <resultsEntryParam.length ; i++ )   {
					System.out.println("resultsEntryParam : "+i+" : " +resultsEntryParam[i]);
				}
				
				hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("update TransactionDetails set bseOrderId = :bseOrderId , "
																	+ "uniqueReferenceNumber = :uniqueReferenceNumber, transactionStatus =:transactionStatus ,"
																	+ " bseRemarks = :bseRemarks , bseSuccessFlag = :bseSuccessFlag " + " "
																			+ " where transactionDetailId = :transactionDetailId");
				query.setParameter("bseOrderId", resultsEntryParam[2].toString());
				query.setParameter("uniqueReferenceNumber", transactionDetailId);
				if ("0".equals(resultsEntryParam[7].toString()))
					query.setParameter("transactionStatus", "8");
				else 
					query.setParameter("transactionStatus", "7");
				query.setParameter("bseRemarks", resultsEntryParam[6].toString());
				query.setParameter("bseSuccessFlag", resultsEntryParam[7].toString());
				query.setParameter("transactionDetailId", transactionDetailId);
				
				result = query.executeUpdate();
				hibernateSession.getTransaction().commit();
				
				/*String bseOrderId = null;
				String bseRegNum = null;
				hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("update TransactionDetails set bseOrderId = :bseOrderId , bseRegistrationNumber = :bseRegistrationNumber , "
																	+ "uniqueReferenceNumber = :uniqueReferenceNumber, transactionStatus =:transactionStatus ,"
																	+ " bseRemarks = :bseRemarks , bseSuccessFlag = :bseSuccessFlag " + " "
																			+ " where transactionDetailId = :transactionDetailId");
				if (transactionType == "UPFRONT") {
					bseOrderId = resultsEntryParam[2].toString();
					
				}
				else {
					
					bseRegNum = resultsEntryParam[5].toString();
					
					if ("Y".equals(firstOrderFlag)) {
						
						
						WebServiceStarMF wbStarMF = new WebServiceStarMF();		
						in.bsestarmf._2016._01.IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();
						
						ChildOrderRequest childOrderRequest = new ChildOrderRequest();
						
						org.datacontract.schemas._2004._07.starmfwebservice.ObjectFactory objFact = org.datacontract.schemas._2004._07.starmfwebservice.ObjectFactory.class.newInstance();
						
						SimpleDateFormat childReqDateFormat = new SimpleDateFormat("dd MMM yyyy");
						date = new Date();
						String frmtdChildReqDate = childReqDateFormat.format(date);
						
						System.out.println("bseRegNum is : "+bseRegNum);
						System.out.println("customerId is : "+customerId);
						
						String passwordStarMF = iStarMFWebService.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("MEMBER_ID"),
								configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));
	
						
						String[] resultsStarMF = passwordStarMF.split("\\|");
	
						for (int i = 0 ; i <resultsStarMF.length ; i++ )   {
							System.out.println("resultsStarMF : "+i+" : " +resultsStarMF[i]);
						}
	
						logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - fetched encrypted password from iStarMFWebService API ");
						System.out.println("passwordStarMF : "+passwordStarMF);
	
						PASSWORD_STARMF = resultsStarMF[1];
						
						org.datacontract.schemas._2004._07.starmfwebservice.PasswordRequest passwordRequest = new org.datacontract.schemas._2004._07.starmfwebservice.PasswordRequest();
						
						passwordRequest.setMemberId(objFact.createPasswordRequestMemberId(configProperties.getProperty("MEMBER_ID")));
						passwordRequest.setUserId(objFact.createPasswordRequestUserId(configProperties.getProperty("USER_ID")));
						passwordRequest.setPassword(objFact.createPasswordRequestPassword(configProperties.getProperty("PASSWORD")));
						passwordRequest.setPassKey(objFact.createPasswordRequestPassKey(configProperties.getProperty("PASS_KEY")));
						
						org.datacontract.schemas._2004._07.starmfwebservice.Response getPasswordForChildOrderResponse = iStarMFWebService.getPasswordForChildOrder(passwordRequest);
						
						String password = getPasswordForChildOrderResponse.getResponseString().getValue().toString();
						
						System.out.println("password  :  "+password);
						
						childOrderRequest.setClientCode(objFact.createChildOrderRequestClientCode(customerId));
						childOrderRequest.setMemberCode(objFact.createChildOrderRequestMemberCode(configProperties.getProperty("MEMBER_ID")));
						childOrderRequest.setSystematicPlanType(objFact.createChildOrderRequestSystematicPlanType("ISIP"));
						childOrderRequest.setRegnNo(objFact.createChildOrderRequestRegnNo(bseRegNum));
						childOrderRequest.setEncryptedPassword(objFact.createChildOrderRequestEncryptedPassword(password));
						childOrderRequest.setDate(objFact.createChildOrderRequestDate(frmtdChildReqDate));
						
						System.out.println("CHILD ORDER REQUEST CLIENT CODE Is : "+childOrderRequest.getClientCode().getValue());
						System.out.println("CHILD ORDER REQUEST MEMBER CODE Is : "+childOrderRequest.getMemberCode().getValue());
						System.out.println("CHILD ORDER REQUEST REQ DATE Is : "+childOrderRequest.getDate().getValue());
						System.out.println("CHILD ORDER REQUEST PASSWORD Is : "+childOrderRequest.getEncryptedPassword().getValue());
						System.out.println("CHILD ORDER REQUEST systematic plan type Is : "+childOrderRequest.getSystematicPlanType().getValue());
						System.out.println("CHILD ORDER REQUEST REGISTRATION NUM Is : "+childOrderRequest.getRegnNo().getValue());
						
						ChildOrderResponse childOrderResponse =  iStarMFWebService.childOrderDetails(childOrderRequest);
						
						System.out.println("BSE ORDER ID FOR ISIP is : "+childOrderResponse.getChildOrderDetails().isNil() );
						
						System.out.println("BSE ORDER ID FOR ISIP Message is : "+childOrderResponse.getMessage().getValue().toString()  );
						
						System.out.println("BSE ORDER ID FOR ISIP Status is : "+childOrderResponse.getStatus().getValue().toString() );
						
						List<ChildOrderDetails> childOrderDetailsArray = childOrderResponse.getChildOrderDetails().getValue().getChildOrderDetails() ;
						
						if (!childOrderResponse.getChildOrderDetails().isNil() )  {
							System.out.println("order number : "+childOrderDetailsArray.get(0).getOrderNumber().getValue());
							
							bseOrderId = childOrderDetailsArray.get(0).getOrderNumber().getValue();
						}
						
	
						for (int i = 0 ; i < childOrderDetailsArray.size() ; i++ )   {
							
							System.out.println("abc  : "+i+" : "+ childOrderDetailsArray.get(i).getAmount().getValue() );
						}
					
					}
					
				}
				query.setParameter("bseOrderId", bseOrderId);
				query.setParameter("bseRegistrationNumber", bseRegNum);
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - bseOrderId - "+bseOrderId+" recived from BSE for transactionDetailId - "+transactionDetailId);
			

				if ( resultsEntryParam[7].equals("1") ) {
					query.setParameter("transactionStatus", "2");
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - order failed with BSE for transactionDetailId - "+transactionDetailId);
				}
				else  
				{
					if (bseOrderId != null)  {
						orderNums.getString().add(bseOrderId);
						System.out.println(bseOrderId+" added in orderNums");
						logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - amount - "+Double.toString(productDetailsMap.get(currentProductId))+" for bseOrderId - "+bseOrderId+"added in orderNums hashMap for payment ");
					}
					
					totalPaymentAmount += productDetailsMap.get(currentProductId);
					query.setParameter("transactionStatus", "3");
					allOrderFailed = false;
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - order successfully placed to BSE for transactionDetailId - "+transactionDetailId);
				}

				query.setParameter("uniqueReferenceNumber", resultsEntryParam[1]);
				query.setParameter("bseRemarks", resultsEntryParam[6]);
				query.setParameter("bseSuccessFlag", resultsEntryParam[7]);
				query.setParameter("transactionDetailId", transactionDetailId);
				int updateResult = query.executeUpdate();
				System.out.println(updateResult + " rows updated in transactionDetails table ");
				hibernateSession.getTransaction().commit();
				
				if ("N".equals(firstOrderFlag)) {
					return null;
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

				String status = passwordStarMFPaymentGateway.getStatus().getValue();

				System.out.println("status : "+status);
				
				PASSWORD_STARMF = passwordStarMFPaymentGateway.getResponseString().getValue();
				System.out.println("Response String (Encrypted Password) : "+PASSWORD_STARMF);
				
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - fetched encrypted password from passwordStarMFPaymentGateway API ");

				Iterator it = orderNums.getString().iterator();
				
				while(it.hasNext())  {
					System.out.println("oredrNums : "+it.next().toString());
				}
				
				System.out.println("accountNum : "+accountNum+" : ifsc : "+ifsc+" : bankId : "+bankId+" : bankMode : "+bankMode);
				RequestParam requestParam = new RequestParam();
				requestParam.setAccNo(objFact.createRequestParamAccNo(accountNum));
				requestParam.setBankID(objFact.createRequestParamBankID(bankId));
				requestParam.setClientCode(objFact.createRequestParamClientCode(customerId));
				requestParam.setEncryptedPassword(objFact.createRequestParamEncryptedPassword(PASSWORD_STARMF));
				requestParam.setIFSC(objFact.createRequestParamIFSC(ifsc));
				
				if ("UPFRONT".equals(transactionType))
					requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(configProperties.getProperty("LOGOUT_URL_UPFRONT")));
				else
					requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(configProperties.getProperty("LOGOUT_URL_SIP")));
				
				requestParam.setMemberCode(objFact.createRequestParamMemberCode(configProperties.getProperty("MEMBER_ID")));
				requestParam.setMode(objFact.createRequestParamMode(bankMode));
				requestParam.setOrders(objFact.createRequestParamOrders(orderNums));
				requestParam.setTotalAmount(objFact.createRequestParamTotalAmount(Double.toString(totalPaymentAmount)));

				System.out.println("requestParam : getAccNo : "+requestParam.getAccNo().getValue());
				Response paymentGateway = iStarMFPaymentGatewayService.paymentGatewayAPI(requestParam);

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"initiated");
				
				String[] resultsPaymentGateway = paymentGateway.toString().split("\\|");

				for (int i = 0 ; i <resultsPaymentGateway.length ; i++ )   {
					System.out.println("resultsPaymentGateway : "+i+" : " +resultsPaymentGateway[i]);
				}

				paymentUrl = paymentGateway.getResponseString().getValue();
				
				String responseStatus = paymentGateway.getStatus().getValue();
				System.out.println("responseStatus : "+responseStatus);
				
				if ("101".equals(responseStatus))  {
					hibernateSession.beginTransaction();
					query = hibernateSession.createQuery("update TransactionDetails set transactionStatus ='4' where transactionId = :transactionId");
					query.setParameter("transactionId", transactionId);
					int updateResult = query.executeUpdate();
					hibernateSession.getTransaction().commit();
					
					System.out.println("Payment gateway failure reason : "+paymentUrl);
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"failed with paymentGateway");
				}
				else {
					
					//File newHtmlFile = new File(paymentUrlFile);
					//FileUtils.writeStringToFile(newHtmlFile, paymentUrl);
					
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
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - subscriberType changed to INVESTOR");
				
					
				}

			}
			else {
				paymentUrl = "NotSet";
				System.out.println("paymentUrl: "+paymentUrl);
			}

				Iterator it = orderNums.getString().iterator();
				
				while(it.hasNext())  {
					System.out.println("oredrNums : "+it.next().toString());
				}
				
				String bseOrderId = null;
				int result;
				List<Object[]> transactionDetailQueryResult;
				String schemeName;
				
				while(it.hasNext())  {
					
					
					bseOrderId = it.next().toString();
					System.out.println("bseOrderId added in orderNums : "+bseOrderId);
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
					
					query = hibernateSession.createQuery("select productId,transactionAmount,transactionDate,transactionStatus,transactionDetailId"
											+ " from TransactionDetails where bseOrderId = :bseOrderId and customerId = :customerId ");
					query.setParameter("bseOrderId", bseOrderId);
					query.setParameter("customerId", customerId);
					transactionDetailQueryResult = query.list();
					
					hibernateSession.getTransaction().commit();
					
					hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId = :fundId");
					query.setParameter("fundId", transactionDetailQueryResult.get(0)[0]);
					schemeName = query.uniqueResult().toString();
					
					hibernateSession.getTransaction().commit();
					
					System.out.println(" Adding a new row in orderDataModelList for schemeName : "+schemeName+" and fund id : "+transactionDetailQueryResult.get(0)[0]);
					
					QueryOrderStatus queryOrderStatus = new QueryOrderStatus();
					
					String userStatus = queryOrderStatus.getStatusDetail(transactionDetailQueryResult.get(0)[3].toString());
					orderDataModel.add(new OrderDataModel(transactionDetailQueryResult.get(0)[4].toString(), schemeName, 
											transactionDetailQueryResult.get(0)[1].toString(), transactionDetailQueryResult.get(0)[2].toString(),
											userStatus ));
					
					
				}
				
				for ( int i =0;i<orderDataModel.size();i++)  {
					
					System.out.println("orderDataModel.get("+i+").getSchemeName()"+orderDataModel.get(i).getSchemeName());
					
				}
				sessionMap.put("orderDataModel", orderDataModel);
		    	
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - stored orderDataModel in sessionMap");
		    	
		    	logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - flow for fresh order end");
		    	
			}
			else {
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+"  - flow for re-try payment for existing failed order - start");
				System.out.println("Inside else case : tranDetailId is "+tranDetailId);
				
				
				QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
				TransactionDetails transactionDetails =  queryTransactionDetails.getTransactionDetails(tranDetailId);
				
				transactionType = transactionDetails.getTransactionType();
				orderNums.getString().add(transactionDetails.getBseOrderId());
				
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

				String status = passwordStarMFPaymentGateway.getStatus().getValue();

				System.out.println("status : "+status);
				
				PASSWORD_STARMF = passwordStarMFPaymentGateway.getResponseString().getValue();
				System.out.println("Response String (Encrypted Password) : "+PASSWORD_STARMF);

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - fetched encrypted password from passwordStarMFPaymentGateway API ");
				
				Iterator it = orderNums.getString().iterator();
				
				while(it.hasNext())  {
					System.out.println("oredrNums : "+it.next().toString());
				}
				
				System.out.println("accountNum : "+accountNum+" : ifsc : "+ifsc+" : bankId : "+bankId+" : bankMode : "+bankMode);
				RequestParam requestParam = new RequestParam();
				requestParam.setAccNo(objFact.createRequestParamAccNo(accountNum));
				requestParam.setBankID(objFact.createRequestParamBankID(bankId));
				requestParam.setClientCode(objFact.createRequestParamClientCode(customerId));
				requestParam.setEncryptedPassword(objFact.createRequestParamEncryptedPassword(PASSWORD_STARMF));
				requestParam.setIFSC(objFact.createRequestParamIFSC(ifsc));
				requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(configProperties.getProperty("LOGOUT_URL")));
				requestParam.setMemberCode(objFact.createRequestParamMemberCode(configProperties.getProperty("MEMBER_ID")));
				requestParam.setMode(objFact.createRequestParamMode(bankMode));
				requestParam.setOrders(objFact.createRequestParamOrders(orderNums));
				requestParam.setTotalAmount(objFact.createRequestParamTotalAmount(transactionDetails.getTransactionAmount()));

				System.out.println("requestParam : getAccNo : "+requestParam.getAccNo().getValue());
				Response paymentGateway = iStarMFPaymentGatewayService.paymentGatewayAPI(requestParam);

				String[] resultsPaymentGateway = paymentGateway.toString().split("\\|");

				for (int i = 0 ; i <resultsPaymentGateway.length ; i++ )   {
					System.out.println("resultsPaymentGateway : "+i+" : " +resultsPaymentGateway[i]);
				}

				paymentUrl = paymentGateway.getResponseString().getValue();
				
				String responseStatus = paymentGateway.getStatus().getValue();
				System.out.println("responseStatus : "+responseStatus);
				
				QueryOrderStatus queryOrderStatus = new QueryOrderStatus();
				
				String userStatus = queryOrderStatus.getStatusDetail(transactionDetails.getTransactionStatus());
				
				QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
				
				String schemeName = queryPrimaryFundDetails.getSchemeName(transactionDetails.getProductId());
				
				orderDataModel.add(new OrderDataModel(tranDetailId, schemeName, 
									transactionDetails.getTransactionAmount(), transactionDetails.getTransactionDate(),userStatus ));
				
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"initiated");
				
				if ("101".equals(responseStatus))  {
					hibernateSession.beginTransaction();
					query = hibernateSession.createQuery("update TransactionDetails set transactionStatus ='6' where transactionId = :transactionId");
					query.setParameter("transactionId", tranDetailId);
					int updateResult = query.executeUpdate();
					hibernateSession.getTransaction().commit();
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"failed with paymentGateway");
					
				}
				else {
					File newHtmlFile = new File(paymentUrlFile);
					FileUtils.writeStringToFile(newHtmlFile, paymentUrl);
					
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
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - subscriberType changed to INVESTOR");
				}

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - flow for re-try payment for existing failed order - end");
			}
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - user will be re-directed to payment page");
			*/
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - end");

		} catch (NumberFormatException | HibernateException e) {
			logger.error("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - Caught some Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+transactionType+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

	public void checkPaymentStatus() throws MoneyBuddyException {
		
	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	Query query;
	List<Object[]> transactionDetails;
	List<String> customerIds;
	PaymentDetails tempPaymentDetail;
	HashMap<String,String> successfulPayment = new HashMap<String, String>();
	HashMap<String,String> pendingPayment = new HashMap<String, String>();

	
	WebServiceStarMF wbStarMF = new WebServiceStarMF();	
	in.bsestarmf._2016._01.IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();
	String PASSWORD_STARMF;
	String passwordStarMF;
	String[] resultsStarMF;

	String paymentStatusDetails;

	try {
		
		logger.debug("Trading class - checkPaymentStatus method - start");

		System.out.println("Trading class : checkPaymentStatus method - start ");

		/*hibernateSession.beginTransaction();
		query = hibernateSession.createQuery("select distinct(customerId) from Customers");

		customerIds = query.list();

		hibernateSession.getTransaction().commit();

		for (String customerid : customerIds)  {
			System.out.println("customerid : "+customerid);


		}*/
		hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select transactionId, transactionDetailId, transactionDate, bseOrderId , productId , quantity, transactionAmount,customerId from TransactionDetails where transactionStatus='5'");

			transactionDetails = query.list();

			hibernateSession.getTransaction().commit();
			
			if (!transactionDetails.isEmpty())  {

			for (Object[]  transactionDetail : transactionDetails)  {

				System.out.println("BSE Order Id : "+transactionDetail[3]);

				long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date startDate;

				startDate = dateFormat.parse(transactionDetail[2].toString());

				Date date = new Date();
				String frmtdDate = dateFormat.format(date);
				Date todayDate = dateFormat.parse(frmtdDate);

				boolean lessThanToday = Math.abs(todayDate.getTime() - startDate.getTime()) > MILLIS_PER_DAY;
				System.out.println("lessThanToday is : "+lessThanToday+" for transactionDetailId : "+transactionDetail[1]);

				/*if (lessThanToday)  {

					hibernateSession.beginTransaction();
					hibernateSession.createQuery("update TransactionDetails set transactionStatus='6' where transactionDetailId='"+transactionDetail[1].toString()+"'").executeUpdate();
					hibernateSession.getTransaction().commit();

				}

				else {*/
					Properties configProperties = new Properties();
					String configPropFilePath = "../../../config/config.properties";

					configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));



					String[] paymentStatusDetailsArray = {transactionDetail[7].toString(),transactionDetail[3].toString(),"BSEMF"};
					paymentStatusDetails = String.join("|",paymentStatusDetailsArray);


					passwordStarMF = iStarMFWebService.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("MEMBER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

					resultsStarMF = passwordStarMF.split("\\|");

					PASSWORD_STARMF = resultsStarMF[1];

					String paymentStatusResponse = iStarMFWebService.mfapi("11",configProperties.getProperty("USER_ID"),PASSWORD_STARMF,paymentStatusDetails);

					System.out.println("paymentStatusResponse : "+paymentStatusResponse);

					String[] resultsPaymentStatusResponse = paymentStatusResponse.split("\\|");

					dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					date = new Date();
					String frmtdDateForDB = dateFormat.format(date);

					String refNumber = null;
					List<String> paymentDetailsList;
					if (resultsPaymentStatusResponse[0].equals("100"))  {

						hibernateSession.beginTransaction();

						query = hibernateSession.createQuery("select paymentDetailsId from PaymentDetails where transactionDetailId='"+transactionDetail[1].toString()+"' and bseOrderID='"+transactionDetail[3].toString()+"'");
						paymentDetailsList = query.list();

						hibernateSession.getTransaction().commit();

						hibernateSession.beginTransaction();

						if (paymentDetailsList.isEmpty())  {
							tempPaymentDetail = new PaymentDetails( transactionDetail[1].toString(), transactionDetail[3].toString(),
									resultsPaymentStatusResponse[1], transactionDetail[2].toString(),frmtdDateForDB);
							hibernateSession.save(tempPaymentDetail);
						}
						else 
						{
							for (String paymentDetail : paymentDetailsList)  {
								refNumber = paymentDetail;
							}
							hibernateSession.createQuery("update PaymentDetails set paymentGatewayComment='"+resultsPaymentStatusResponse[1]+"' , updateDate='"+frmtdDateForDB+"' where paymentDetailsId='"+refNumber+"'").executeUpdate();;
						}

						hibernateSession.getTransaction().commit();

						if (resultsPaymentStatusResponse[1].startsWith("APPROVED"))  {
							System.out.println("Payment Successful");
							hibernateSession.beginTransaction();
							hibernateSession.createQuery("update TransactionDetails set transactionStatus='7' where transactionDetailId='"+transactionDetail[1].toString()+"'").executeUpdate();
							hibernateSession.getTransaction().commit();

							//Double quantity = Double.parseDouble(transactionDetail[5].toString());

							hibernateSession.beginTransaction();
							Object result = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId='"+transactionDetail[4].toString()+"'").uniqueResult();
							String schemeName = null;

							if (result != null) 
								schemeName = result.toString();
							hibernateSession.getTransaction().commit();

							successfulPayment.put(schemeName, transactionDetail[6].toString());
							
						}
						else {
							hibernateSession.beginTransaction();
							Object result = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId='"+transactionDetail[4].toString()+"'").uniqueResult();
							String schemeName = null;

							if (result != null) 
								schemeName = result.toString();
							hibernateSession.getTransaction().commit();
							
							pendingPayment.put(schemeName, transactionDetail[6].toString());
							
						}

					}

				/*}*/
			}

/*					if (!successfulPayment.isEmpty())
			{
				hibernateSession.beginTransaction();
				Object result = hibernateSession.createQuery("select emailId from Customers where customerId='"+customerId+"'").uniqueResult();
				String emailId = null;

				if (result != null) 
					emailId = result.toString();

				hibernateSession.getTransaction().commit();

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

				//sendMail.MailSending(emailId,bodyText,subject);

			}*/
			
			}
		logger.debug("Trading class : checkPaymentStatus method : end");

	} catch (NumberFormatException | HibernateException e) {
		logger.error("Trading class : checkPaymentStatus method : Caught exception  ");
		e.printStackTrace();
		throw new MoneyBuddyException(e.getMessage(), e);
	} catch (Exception e) {
		logger.error("Trading class : checkPaymentStatus method : Caught exception  ");
		e.printStackTrace();
		throw new MoneyBuddyException(e.getMessage(), e);
	}
	finally {
		if(hibernateSession !=null )
				hibernateSession.close();
	}}

}
