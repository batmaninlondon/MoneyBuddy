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
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.PaymentDetails;
import com.myMoneyBuddy.EntityClasses.SecondaryFundDetails;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.StpDetails;
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
			String clientAdd, String clientCity, String clientState, String clientPinCode, String clientCountry, String customerId, 
			String clientAppName1, String clientEmail, String clientPan, String clientNominee, String clientNomineeRelation, String clientMobile) throws MoneyBuddyException {
		
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
			
			/*dob = clientDob.substring(8,10)+"/"+clientDob.substring(5,7)+"/"+clientDob.substring(0,4);
			System.out.println("dob : "+dob);*/
			
			String[] clientDetailsArray = {customerId,clientHolding,taxStatus,occupation,clientAppName1,clientProperties.getProperty("CLIENT_APPNAME2"),
					clientProperties.getProperty("CLIENT_APPNAME3"),clientDob,clientGender,clientProperties.getProperty("CLIENT_GUARDIAN"),clientPan,
					clientNominee,clientNomineeRelation,clientProperties.getProperty("CLIENT_GUARDIANPAN"),
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

	public String executeTrade(String customerId, String panCard, List<CustomerCart> customerCartList,
			String transactionCode, String buySell, String accountNum, String bankId, String ifsc, String bankMode, 
			String firstOrderFlag,  String mandateId, String tranDetailId,  Map<String, Object> sessionMap) throws MoneyBuddyException {


		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Double totalUpfrontAmount = 0.0;
		Double totalSipAmount = 0.0;
		String buySellValue; 
		String buySellType ;
		String transactionDetailId;
		Query query;
		TransactionDetails tempTransactionDetail;
		SipDetails tempSipDetail;
		List<OrderDataModel> orderDataModel;
		boolean anyPaymentToday = false;

		try {
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - start");

			orderDataModel = new LinkedList<OrderDataModel>();

			Properties clientProperties = new Properties();
			String clientPropFilePath = "../../../config/client.properties";

			clientProperties.load(Trading.class.getResourceAsStream(clientPropFilePath));
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - Loaded clientProperties file.");
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));

			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - Loaded configProperties file.");
			
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
				
				String nextTransactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
				
				
				hibernateSession.getTransaction().commit();

				Date currentDate = new Date();
				Calendar c = Calendar.getInstance();
		        c.setTime(currentDate);
				
				String sipBufferDays = null;
				
				if ("Y".equals(firstOrderFlag))  {
					sipBufferDays = configProperties.getProperty("SIP_BUFFER_DAYS_YES");
				}
				else {
					sipBufferDays = configProperties.getProperty("SIP_BUFFER_DAYS_NO");
					
				}
				c.add(Calendar.DATE, Integer.parseInt(sipBufferDays));
				
			    Date minSipStartDate = c.getTime();
					
			    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			    
			    minSipStartDate = sdf.parse(sdf.format(minSipStartDate));
			    
			    Calendar cal = Calendar.getInstance();
			    
			    String sipStartMonth="";
				String sipEndMonth="";
				
			for (int i = 0; i < customerCartList.size(); i++) {	
				
				String frmtdStartDateForSip = null;
				String frmtdEndDateForSip = null;
						
				if (!"Total".equals(customerCartList.get(i).getSchemeName()))  {
				String schemeCode = null;
				String amcCode = null;
				String schemeType = null;
				String category = null;
				buySellType = "FRESH";
				String selFolioNum = customerCartList.get(i).getFolioNumber();
				
				if ("UPFRONT".equals(customerCartList.get(i).getTransactionType()))
					totalUpfrontAmount += Double.parseDouble(customerCartList.get(i).getUpfrontAmount());
				else
					totalSipAmount += Double.parseDouble(customerCartList.get(i).getSipAmount());

				QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
				SecondaryFundDetails secondaryFundDetails = querySecondaryFundDetails.getSecondaryFundDetails(customerCartList.get(i).getFundId());
				
				List<Object[]> primaryFundDetailsResult;
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("select schemeType,category "
										+ " from PrimaryFundDetails where fundId = :fundId ");
				query.setParameter("fundId", customerCartList.get(i).getFundId());
				
				primaryFundDetailsResult = query.list();
				
				hibernateSession.getTransaction().commit();
				
				schemeType = primaryFundDetailsResult.get(0)[0].toString();
				category = primaryFundDetailsResult.get(0)[1].toString();
				
				if (secondaryFundDetails != null) {
					schemeCode = secondaryFundDetails.getSchemeCode();
					amcCode = secondaryFundDetails.getAmcCode();
				}

				System.out.println(" schemeCode :  "+schemeCode +" for fund Id : "+customerCartList.get(i).getFundId());

				Double currentTransactionAmount ;
				if ("UPFRONT".equals(customerCartList.get(i).getTransactionType()))
					currentTransactionAmount = Double.parseDouble(customerCartList.get(i).getUpfrontAmount());
				else 
					currentTransactionAmount = Double.parseDouble(customerCartList.get(i).getSipAmount());
				
				System.out.println("Trading class : executeTrade method : currentTransactionAmount : "+currentTransactionAmount);

				if ( !"New".equalsIgnoreCase(selFolioNum) )  {
					
						buySellType = "ADDITIONAL";

				}
				else {
					selFolioNum = null;
				}
				
				hibernateSession.beginTransaction();
				
				tempTransactionDetail  = new TransactionDetails(nextTransactionId, null,null,null, customerId,customerCartList.get(i).getTransactionType(),
						transactionCode,buySell, buySellType, Double.toString(currentTransactionAmount),
						"1", null,null,"N",customerCartList.get(i).getFundId(), null,null,frmtdDateForDB, frmtdDateForDB,"N",
						selFolioNum,null,"N"); 		

				hibernateSession.save(tempTransactionDetail);

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+customerCartList.get(i).getTransactionType()+
						" - inserted new row in TransactionDetails table with transactionId - "+nextTransactionId);

				hibernateSession.getTransaction().commit();
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("delete from CustomerCart where customerId = :customerId and transactionType = :transactionType and fundId = :fundId and folioNumber = :folioNumber ");
				query.setParameter("customerId", customerId);
				query.setParameter("transactionType", customerCartList.get(i).getTransactionType());
				query.setParameter("fundId", customerCartList.get(i).getFundId());
				query.setParameter("folioNumber", selFolioNum);
				
				query.executeUpdate();
				
				hibernateSession.getTransaction().commit();

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - and transactionType - "+customerCartList.get(i).getTransactionType()+""
						+ " - deleted row from CustomerCart table for fundId - "+customerCartList.get(i).getFundId()+" and folioNumber - "+selFolioNum);
				
				transactionDetailId = tempTransactionDetail.getTransactionDetailId();
				
				//transactionDetailIdList.add(transactionDetailId);
						
				passwordMFOrder = mfOrderEntry.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

				resultsMFOrder = passwordMFOrder.split("\\|");


				PASSWORD_MFORDER = resultsMFOrder[1];

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - fetched encrypted password from mfOrderEntry API ");
				
								
				if ("New".equals(selFolioNum)) {
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
					if ( Double.parseDouble(customerCartList.get(i).getUpfrontAmount()) >= 200000.00 ) {
						schemeCode = schemeCode+"-L1" ;	
					}
				}
				
				System.out.println(" SCHEME CODE : "+schemeCode);
				
				if ("UPFRONT".equals(customerCartList.get(i).getTransactionType()))  {
					
					anyPaymentToday = true;

					if (buySell == "BUY")  {
						buySellValue = "P";
					}
					else {
						buySellValue = "R";
					}
					
					
					
					
					System.out.println(" transactionDetailId : "+transactionDetailId+
							" and upfront amount : "+customerCartList.get(i).getUpfrontAmount());
					entryParam = mfOrderEntry.orderEntryParam(transactionCode,transactionDetailId,clientProperties.getProperty("ORDER_ID"),configProperties.getProperty("USER_ID"),
							configProperties.getProperty("MEMBER_ID"),customerId,schemeCode,buySellValue,buySellType,
							clientProperties.getProperty("DP_TXN"),customerCartList.get(i).getUpfrontAmount(),clientProperties.getProperty("QTY"),
							clientProperties.getProperty("ALL_REDEEM"),selFolioNum,clientProperties.getProperty("REMARKS"),
							clientProperties.getProperty("KYC_STATUS"),clientProperties.getProperty("REF_NO"),clientProperties.getProperty("SUB_BR_CODE"),
							clientProperties.getProperty("EUIN"),clientProperties.getProperty("EUIN_FLAG"),clientProperties.getProperty("MIN_REDEEM"),clientProperties.getProperty("DPC"),
							clientProperties.getProperty("IP_ADDRESS"),PASSWORD_MFORDER,configProperties.getProperty("PASS_KEY"),clientProperties.getProperty("PARAM_1"),
							clientProperties.getProperty("PARAM_2"),clientProperties.getProperty("PARAM_3"));
				
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - "+buySell+" -order for schemeCode - "+schemeCode+" - placed to BSE for transactionDetailId - "+transactionDetailId);
					
				}
				else {

					CommonUtil commonUtil = new CommonUtil();
					
					if ( Integer.parseInt(customerCartList.get(i).getSipDate()) <=   (cal.get(Calendar.DATE)) ) {
						System.out.println(" Inside if case of date compare .....");
						sipStartMonth = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? commonUtil.theMonth(0) : commonUtil.theMonth(cal.get(Calendar.MONTH)+1));
						sipEndMonth = commonUtil.theMonth(cal.get(Calendar.MONTH));
					}
					else {
						System.out.println(" Inside else case of date compare .....");
						sipStartMonth = commonUtil.theMonth(cal.get(Calendar.MONTH));
						sipEndMonth = (("0".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? commonUtil.theMonth(11) : commonUtil.theMonth(cal.get(Calendar.MONTH)-1));
					}
					System.out.println(" sipStartMonth : "+sipStartMonth);
					System.out.println(" sipEndMonth : "+sipEndMonth);
					System.out.println(" date.getYear() : "+cal.get(Calendar.YEAR));
					System.out.println("customerCartList.get(i).getSipDuration() : "+customerCartList.get(i).getSipDuration());
					String sipEndYear = Integer.toString(cal.get(Calendar.YEAR)+Integer.parseInt(customerCartList.get(i).getSipDuration()));
					String sipStartYear = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? Integer.toString(cal.get(Calendar.YEAR)+1) : Integer.toString(cal.get(Calendar.YEAR)));
					System.out.println(" sipEndYear : "+sipEndYear);
					
					String sipStartDate = sipStartMonth+"/"+customerCartList.get(i).getSipDate()+"/"+sipStartYear;
					String sipEndDate = sipEndMonth+"/"+customerCartList.get(i).getSipDate()+"/"+sipEndYear;
					
				    Date curSipStartDate = sdf.parse(sipStartDate);
				    Date curSipEndDate = sdf.parse(sipEndDate);
				    
				    if (minSipStartDate.after(curSipStartDate)) {
				    	c.setTime(curSipStartDate);
				    	c.add(Calendar.MONTH,+1);
				    	curSipStartDate = c.getTime();
				    	
				    	c.setTime(curSipEndDate);
				    	c.add(Calendar.MONTH,+1);
				    	curSipEndDate = c.getTime();
				    	
				    }
				    					
					System.out.println("customerId for SipDetails is : "+customerId);
					System.out.println("transactionDetailId for SipDetails is : "+transactionDetailId);
					System.out.println("sipDate for selSipDate is : "+customerCartList.get(i).getSipDate());
					System.out.println("Integer.toString(cal.get(Calendar.MONTH)) : "+Integer.toString(cal.get(Calendar.MONTH)));
					System.out.println("sipStartDate for SipDetails is : "+ sdf.format(curSipStartDate));
					System.out.println("sipEndDate for SipDetails is : "+sdf.format(curSipEndDate));
					
					frmtdStartDateForSip = sdf.format(curSipStartDate).substring(6,10)+
							"-"+sdf.format(curSipStartDate).substring(0,2)+
							"-"+sdf.format(curSipStartDate).substring(3,5);
					frmtdEndDateForSip = sdf.format(curSipEndDate).substring(6,10)+
							"-"+sdf.format(curSipEndDate).substring(0,2)+
							"-"+sdf.format(curSipEndDate).substring(3,5);
					
					System.out.println(" frmtdStartDateForSip : "+frmtdStartDateForSip+" and frmtdEndDateForSip : "+frmtdEndDateForSip);
					
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - inserted new row in SipDetails table");

					String startDate = sdf.format(curSipStartDate).substring(3,5)+
							"/"+sdf.format(curSipStartDate).substring(0,2)+
							"/"+sdf.format(curSipStartDate).substring(6,10);
				
					System.out.println(" startDate  : "+startDate );
					System.out.println(" numOfInstallments  : "+Integer.toString(Integer.parseInt(customerCartList.get(i).getSipDuration())*12) );
					
					entryParam = mfOrderEntry.xsipOrderEntryParam(transactionCode, transactionDetailId, schemeCode, configProperties.getProperty("MEMBER_ID"),
							customerId, configProperties.getProperty("USER_ID"), clientProperties.getProperty("INTERNAL_REF_NUM"), clientProperties.getProperty("TRANSMODE"), 
							clientProperties.getProperty("DP_TXN"), startDate,clientProperties.getProperty("FREQUENCY_TYPE"),clientProperties.getProperty("FREQUENCY_ALLOWED"),
							customerCartList.get(i).getSipAmount(),Integer.toString(Integer.parseInt(customerCartList.get(i).getSipDuration())*12),clientProperties.getProperty("REMARKS"),
							selFolioNum,"Y",clientProperties.getProperty("BROKERAGE"),"",clientProperties.getProperty("SUB_BR_CODE"),
							clientProperties.getProperty("EUIN"),
							clientProperties.getProperty("EUIN_FLAG"),clientProperties.getProperty("DPC"),clientProperties.getProperty("REGID"),clientProperties.getProperty("IP_ADDRESS"),
							PASSWORD_MFORDER,configProperties.getProperty("PASS_KEY"),clientProperties.getProperty("PARAM_1"),mandateId,
							clientProperties.getProperty("PARAM_3"));
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - new Sip start order for schemeCode - "+schemeCode+" - placed to BSE for transactionDetailId - "+transactionDetailId);
					
				}

				resultsEntryParam = entryParam.split("\\|");

				for (int j = 0 ; j <resultsEntryParam.length ; j++ )   {
					System.out.println("resultsEntryParam : "+j+" : " +resultsEntryParam[j]);
				}
				
				String bseOrderId = null;
				String bseRegNum = null;
				hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("update TransactionDetails set bseOrderId = :bseOrderId , bseRegistrationNumber = :bseRegistrationNumber , "
																	+ "uniqueReferenceNumber = :uniqueReferenceNumber, transactionStatus =:transactionStatus ,"
																	+ " bseRemarks = :bseRemarks , bseSuccessFlag = :bseSuccessFlag " + " "
																			+ " where transactionDetailId = :transactionDetailId");
				
				if ("UPFRONT".equals(customerCartList.get(i).getTransactionType()) ) {
					bseOrderId = resultsEntryParam[2].toString();
					totalPaymentAmount += Double.parseDouble(customerCartList.get(i).getUpfrontAmount());
					
				}
				else {
					
					bseRegNum = resultsEntryParam[5].toString();
					
					if ("Y".equals(firstOrderFlag)) {
						
						totalPaymentAmount += Double.parseDouble(customerCartList.get(i).getSipAmount());
						
						anyPaymentToday = true;
						WebServiceStarMF wbStarMF = new WebServiceStarMF();		
						in.bsestarmf._2016._01.IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();
						
						ChildOrderRequest childOrderRequest = new ChildOrderRequest();
						
						org.datacontract.schemas._2004._07.starmfwebservice.ObjectFactory objFact = org.datacontract.schemas._2004._07.starmfwebservice.ObjectFactory.class.newInstance();
						
						SimpleDateFormat childReqDateFormat = new SimpleDateFormat("dd MMM yyyy");
						date = new Date();
						String frmtdChildReqDate = childReqDateFormat.format(date);
						
						System.out.println("bseRegNum is : "+bseRegNum);
						System.out.println("customerId is : "+customerId);
						
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
					
					}
					
				}
				query.setParameter("bseOrderId", bseOrderId);
				query.setParameter("bseRegistrationNumber", bseRegNum);
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - bseOrderId - "+bseOrderId+" recived from BSE for transactionDetailId - "+transactionDetailId);
			

				if ( resultsEntryParam[7].equals("1") ) {
					query.setParameter("transactionStatus", "2");
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - order failed with BSE for transactionDetailId - "+transactionDetailId);
				}
				else  
				{
					if (bseOrderId != null)  {
						orderNums.getString().add(bseOrderId);
						System.out.println(bseOrderId+" added in orderNums");
						logger.debug("Trading class - executeTrade method - customerId - "+customerId+" for bseOrderId - "+bseOrderId+"added in orderNums hashMap for payment ");
					}

					query.setParameter("transactionStatus", "3");
					allOrderFailed = false;
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - order successfully placed to BSE for transactionDetailId - "+transactionDetailId);
				}

				query.setParameter("uniqueReferenceNumber", resultsEntryParam[1]);
				query.setParameter("bseRemarks", resultsEntryParam[6]);
				query.setParameter("bseSuccessFlag", resultsEntryParam[7]);
				query.setParameter("transactionDetailId", transactionDetailId);
				int updateResult = query.executeUpdate();
				System.out.println(updateResult + " rows updated in transactionDetails table ");
				hibernateSession.getTransaction().commit();
				
				if ( resultsEntryParam[7].equals("0") ) {
					
					hibernateSession.beginTransaction();
					
					tempSipDetail = new SipDetails(customerId, bseRegNum, transactionDetailId,
							customerCartList.get(i).getSipDate(), frmtdStartDateForSip, frmtdEndDateForSip,
							customerCartList.get(i).getSipDuration(),"N","Y");
	
					hibernateSession.save(tempSipDetail);
					hibernateSession.getTransaction().commit();
				}
				
				}
				
				
			}
			
			System.out.println("anyPaymentToday : "+anyPaymentToday+" and allOrderFailed : "+allOrderFailed);
			if (!anyPaymentToday)  {
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
				
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - fetched encrypted password from passwordStarMFPaymentGateway API ");

				Iterator it = orderNums.getString().iterator();
				
				/*while(it.hasNext())  {
					System.out.println("oredrNums : "+it.next().toString());
				}*/
				
				System.out.println("accountNum : "+accountNum+" : ifsc : "+ifsc+" : bankId : "+bankId+" : bankMode : "+bankMode);
				DesEncrypter desEncrypter = new DesEncrypter();
				RequestParam requestParam = new RequestParam();
				requestParam.setAccNo(objFact.createRequestParamAccNo( accountNum));
				requestParam.setBankID(objFact.createRequestParamBankID(bankId));
				requestParam.setClientCode(objFact.createRequestParamClientCode(customerId));
				requestParam.setEncryptedPassword(objFact.createRequestParamEncryptedPassword(PASSWORD_STARMF));
				requestParam.setIFSC(objFact.createRequestParamIFSC(ifsc));
				
				/*if ("UPFRONT".equals(transactionType))  {
					
					System.out.println(" LOGOUT_URL_UPFRONT set to ............ : "+configProperties.getProperty("LOGOUT_URL_UPFRONT"));*/
					requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(configProperties.getProperty("LOGOUT_URL_UPFRONT")));
					
				/*}
				else
					requestParam.setLogOutURL(objFact.createRequestParamLogOutURL(configProperties.getProperty("LOGOUT_URL_SIP")));*/
				
				requestParam.setMemberCode(objFact.createRequestParamMemberCode(configProperties.getProperty("MEMBER_ID")));
				requestParam.setMode(objFact.createRequestParamMode(bankMode));
				requestParam.setOrders(objFact.createRequestParamOrders(orderNums));
				requestParam.setTotalAmount(objFact.createRequestParamTotalAmount(Double.toString(totalPaymentAmount)));

				System.out.println("requestParam : getAccNo : "+requestParam.getAccNo().getValue());
				Response paymentGateway = iStarMFPaymentGatewayService.paymentGatewayAPI(requestParam);

				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"initiated");
				
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
					query.setParameter("transactionId", nextTransactionId);
					int updateResult = query.executeUpdate();
					hibernateSession.getTransaction().commit();
					
					System.out.println("Payment gateway failure reason : "+paymentUrl);
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - payment for totalAmount - "+Double.toString(totalPaymentAmount)+"failed with paymentGateway");
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
					
					logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - subscriberType changed to INVESTOR");
				
					
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
					
					query = hibernateSession.createQuery("select fundId,transactionAmount,transactionDate,transactionStatus,transactionDetailId,transactionType"
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
					
					if ("UPFRONT".equals(transactionDetailQueryResult.get(0)[5].toString()))
						orderDataModel.add(new OrderDataModel(transactionDetailQueryResult.get(0)[4].toString(), schemeName, 
											transactionDetailQueryResult.get(0)[1].toString(),"0", transactionDetailQueryResult.get(0)[2].toString(),
											userStatus ));
					else 
						orderDataModel.add(new OrderDataModel(transactionDetailQueryResult.get(0)[4].toString(), schemeName, 
								"0", transactionDetailQueryResult.get(0)[1].toString(), transactionDetailQueryResult.get(0)[2].toString(),
								userStatus ));
					
					
				}
				
				orderDataModel.add(new OrderDataModel("", "Total", Double.toString(totalUpfrontAmount), Double.toString(totalSipAmount),  "",""));
				
				for ( int i =0;i<orderDataModel.size();i++)  {
					
					System.out.println("orderDataModel.get("+i+").getSchemeName()"+orderDataModel.get(i).getSchemeName());
					
				}
				sessionMap.put("orderDataModel", orderDataModel);
		    	
				logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - stored orderDataModel in sessionMap");
		    			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - user will be re-directed to payment page");
			
			logger.debug("Trading class - executeTrade method - customerId - "+customerId+" - end");

			return paymentUrl;
			
		} catch (NumberFormatException | HibernateException e) {
			logger.error("Trading class - executeTrade method - customerId - "+customerId+" - Caught some Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Trading class - executeTrade method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

	
	public void executeRedemption(String customerId, String panCard, String fundId, Double amount, Double quantity, String allRedeem, String transactionCode,  
			String transactionType, String buySell, String folioNum
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
			
			
			System.out.println("Trading class - executeRedemption method - amount - "+amount);
			logger.debug("Trading class - executeRedemption method - customerId - "+customerId+" - start");

			totalAmount = amount;

			Properties clientProperties = new Properties();
			String clientPropFilePath = "../../../config/client.properties";

			clientProperties.load(Trading.class.getResourceAsStream(clientPropFilePath));
			
			logger.debug("Trading class - executeRedemption method - customerId - "+customerId+" - Loaded clientProperties file.");
			
			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));

			logger.debug("Trading class - executeRedemption method - customerId - "+customerId+" - Loaded configProperties file.");
			
			WebServiceMFOrder wbMFOrder = new WebServiceMFOrder();	
			MFOrderEntry mfOrderEntry = wbMFOrder.getWSHttpBindingMFOrderEntry();
			String passwordMFOrder;
			String[] resultsMFOrder;
			String PASSWORD_MFORDER;
			WebServiceStarMFPaymentGateway webServiceStarMFPaymentGateway = new WebServiceStarMFPaymentGateway();		
			String entryParam;
			String[] resultsEntryParam = null;

				logger.debug("Trading class - executeRedemption method - customerId - "+customerId+" - flow for redemption order start");
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String frmtdDateForDB = dateFormat.format(date);
	
				System.out.println("frmtdDateForDB : "+frmtdDateForDB);
				
				/*dateFormat = new SimpleDateFormat("yyyy-MM-dd");*/
	
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = new Date();
				/*String frmtdDate = dateFormat.format(date);*/
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("select max(transactionId) from TransactionDetails");
				
				String transactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);

				hibernateSession.getTransaction().commit();

				String schemeCode = null;
				String amcCode = null;
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

				
				Double currentTransactionAmount = amount;

				System.out.println("Trading class : executeRedemption method : currentTransactionAmount : "+currentTransactionAmount);

				hibernateSession.beginTransaction();
				
				tempTransactionDetail  = new TransactionDetails(transactionId, null,null,null, customerId,transactionType,
						transactionCode,buySell, buySellType, Double.toString(currentTransactionAmount),
						"1", null,null,"N",fundId, null,null,frmtdDateForDB, frmtdDateForDB,"N",folioNum,"0","N"); 		

				hibernateSession.save(tempTransactionDetail);

				logger.debug("Trading class - executeRedemption method - customerId - "+customerId+" - inserted new row in TransactionDetails table with transactionId - "+transactionId);

				hibernateSession.getTransaction().commit();
				
				transactionDetailId = tempTransactionDetail.getTransactionDetailId();

				passwordMFOrder = mfOrderEntry.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

				resultsMFOrder = passwordMFOrder.split("\\|");


				PASSWORD_MFORDER = resultsMFOrder[1];

				logger.debug("Trading class - executeRedemption method - customerId - "+customerId+" - fetched encrypted password from mfOrderEntry API ");

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
				
					logger.debug("Trading class - executeRedemption method - customerId - "+customerId+" redemption order for schemeCode - "+schemeCode+" - placed to BSE for transactionDetailId - "+transactionDetailId);

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
					query.setParameter("transactionStatus", "7");
				else 
					query.setParameter("transactionStatus", "2");
				query.setParameter("bseRemarks", resultsEntryParam[6].toString());
				query.setParameter("bseSuccessFlag", resultsEntryParam[7].toString());
				query.setParameter("transactionDetailId", transactionDetailId);
				
				Object result = query.executeUpdate();
				hibernateSession.getTransaction().commit();
				
				
			logger.debug("Trading class - executeRedemption method - customerId - "+customerId+" - end");

		} catch (NumberFormatException | HibernateException e) {
			logger.error("Trading class - executeRedemption method - customerId - "+customerId+" - Caught some Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Trading class - executeRedemption method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}


	
	public void executeStp(String customerId, String withdrawalFundId, String stpFolioNum, String purchaseFundId, String stpAmount, String stpDuration,  
								String stpDate, String stpCartId ) throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		TransactionDetails tempTransactionDetail;
		
		WebServiceStarMF wbStarMF = new WebServiceStarMF();	
		in.bsestarmf._2016._01.IStarMFWebService iStarMFWebService = wbStarMF.getWSHttpBindingIStarMFService();
		String PASSWORD_STARMF;
		String passwordStarMF;
		String[] resultsStarMF;
		StpDetails tempStpDetails;
		String stpDetails;

		try {
			
			logger.debug("Trading class - executeStp method - customerId - "+customerId+" - start");
			
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select max(transactionId) from TransactionDetails");
			
			String nextTransactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
			
			
			hibernateSession.getTransaction().commit();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);
			
			hibernateSession.beginTransaction();
			
			tempTransactionDetail  = new TransactionDetails(nextTransactionId, null,null,null, customerId,"STP",
					"NEW","BUY", "FRESH", stpAmount,
					"1", null,null,"N",withdrawalFundId, null,null,frmtdDateForDB, frmtdDateForDB,"N",
					stpFolioNum,null,"N"); 		

			hibernateSession.save(tempTransactionDetail);

			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			
			query = hibernateSession.createQuery("delete from StpCart where stpCartId = :stpCartId ");
			query.setParameter("stpCartId", stpCartId);
			
			query.executeUpdate();
			
			hibernateSession.getTransaction().commit();

			Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));

			
			CommonUtil commonUtil = new CommonUtil();
	    	Map<Date,Date> stpDateAndDuration = commonUtil.getStpDates(stpDate, stpDuration);
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    	
	    	Date curStpStartDate = (Date) stpDateAndDuration.keySet().toArray()[0];
	    	Date curStpEndDate = stpDateAndDuration.get(stpDateAndDuration.keySet().toArray()[0]);
	    	
	    	String frmtdStartDateForStp = sdf.format(curStpStartDate).substring(6,10)+
					"-"+sdf.format(curStpStartDate).substring(0,2)+
					"-"+sdf.format(curStpStartDate).substring(3,5);
			String frmtdEndDateForStp = sdf.format(curStpEndDate).substring(6,10)+
					"-"+sdf.format(curStpEndDate).substring(0,2)+
					"-"+sdf.format(curStpEndDate).substring(3,5);
			
			System.out.println(" frmtdStartDateForStp : "+frmtdStartDateForStp+" and frmtdEndDateForStp : "+frmtdEndDateForStp);
			
			
			String startDate = sdf.format(curStpStartDate).substring(3,5)+
					"/"+sdf.format(curStpStartDate).substring(0,2)+
					"/"+sdf.format(curStpStartDate).substring(6,10);
			
	    	String numOfInstallment = Integer.toString(Integer.parseInt(stpDuration)*12) ;
			
			QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
			String withdrawalFundName = querySecondaryFundDetails.getSchemeCode(withdrawalFundId);
			String purchaseFundName = querySecondaryFundDetails.getSchemeCode(purchaseFundId);

			String[] stpDetailsArray = {customerId,withdrawalFundName,purchaseFundName,"Fresh","P",stpFolioNum,nextTransactionId,startDate,"Monthly",
					numOfInstallment,stpAmount,"N","","Y",configProperties.getProperty("EUIN"),"STP Initiated",""};
			stpDetails = String.join("|",stpDetailsArray);


			passwordStarMF = iStarMFWebService.getPassword(configProperties.getProperty("USER_ID"),configProperties.getProperty("MEMBER_ID"),configProperties.getProperty("PASSWORD"),configProperties.getProperty("PASS_KEY"));

			resultsStarMF = passwordStarMF.split("\\|");

			PASSWORD_STARMF = resultsStarMF[1];

			String stpResponse = iStarMFWebService.mfapi("07",configProperties.getProperty("USER_ID"),PASSWORD_STARMF,stpDetails);

			System.out.println("stpResponse : "+stpResponse);

			String[] resultsStpResponse = stpResponse.split("\\|");
			
			for ( int i =0 ; i< resultsStpResponse.length ; i++)   {
				
				System.out.println("resultsStpResponse["+i+"] : "+resultsStpResponse[i]);
			}
			
			String transactionDetailId = tempTransactionDetail.getTransactionDetailId();
			
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("update TransactionDetails set bseRegistrationNumber = :bseRegistrationNumber , "
																+ "transactionStatus =:transactionStatus ,"
																+ " bseRemarks = :bseRemarks , bseSuccessFlag = :bseSuccessFlag " + " "
																		+ " where transactionDetailId = :transactionDetailId");
			
			String bseRegNum = "";
			if ( resultsStpResponse[0].equals("101") ) {
				query.setParameter("transactionStatus", "2");
				query.setParameter("bseSuccessFlag", "1");
				logger.debug("Trading class - executeStp method - customerId - "+customerId+" - order failed with BSE for transactionDetailId - "+transactionDetailId);
			}
			else  
			{
				bseRegNum = resultsStpResponse[2];
				query.setParameter("transactionStatus", "3");
				query.setParameter("bseSuccessFlag", "0");
				logger.debug("Trading class - executeStp method - customerId - "+customerId+" - order successfully placed to BSE for transactionDetailId - "+transactionDetailId);
			}

			query.setParameter("bseRegistrationNumber", bseRegNum);
			query.setParameter("bseRemarks", resultsStpResponse[1]);
			query.setParameter("transactionDetailId", transactionDetailId);
			int updateResult = query.executeUpdate();
			
			hibernateSession.getTransaction().commit();
			
			if ( resultsStpResponse[0].equals("100") )  {
			
				hibernateSession.beginTransaction();
			
				tempStpDetails = new StpDetails(transactionDetailId,customerId, bseRegNum, stpDate,
					frmtdStartDateForStp, frmtdEndDateForStp, stpDuration,"N",withdrawalFundId,purchaseFundId,stpAmount);

				hibernateSession.save(tempStpDetails);
				hibernateSession.getTransaction().commit();
			}
			
		
			logger.debug("Trading class - executeStp method - customerId - "+customerId+" - end");
		
		} catch (NumberFormatException | HibernateException e) {
			logger.error("Trading class - executeStp method - customerId - "+customerId+" - Caught some Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Trading class - executeStp method - customerId - "+customerId+" - Caught Exception");
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
			query = hibernateSession.createQuery("select transactionId, transactionDetailId, transactionDate, bseOrderId , fundId , quantity, transactionAmount,customerId from TransactionDetails where transactionStatus='5'");

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
							System.out.println("Payment Failed");
							hibernateSession.beginTransaction();
							hibernateSession.createQuery("update TransactionDetails set transactionStatus='6' where transactionDetailId='"+transactionDetail[1].toString()+"'").executeUpdate();
							hibernateSession.getTransaction().commit();
							
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
