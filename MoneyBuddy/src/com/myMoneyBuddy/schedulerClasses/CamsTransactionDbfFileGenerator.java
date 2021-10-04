package com.myMoneyBuddy.schedulerClasses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.EntityClasses.SecondaryFundDetails;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class CamsTransactionDbfFileGenerator implements org.quartz.Job{

	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {	
			
			DbfFileStatusDetails tempDbfFileStatusDetails;
			hibernateSession.beginTransaction();
		   
		   Query query =  hibernateSession.createQuery("from TransactionDetails where rtaFileGenerated = :rtaFileGenerated and transactionStatus = :transactionStatus and fundId in (select fundId from SecondaryFundDetails where rta = :rta)");
		   query.setParameter("rta", "CAMS");
		   query.setParameter("transactionStatus", "COMPLETE");
		   query.setParameter("rtaFileGenerated", "N");
		   List<TransactionDetails> transactionDetailsList = query.list();
		   hibernateSession.getTransaction().commit();
			   
		   if (transactionDetailsList.size() != 0)  {

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String frmtdDate = dateFormat.format(date);
	    		
			  	DBFField fields[] = new DBFField[130];
			  
			  	fields[0] = new DBFField();
			    fields[0].setFieldName("AMC_Code");
			    fields[0].setDataType( DBFField.FIELD_TYPE_C);
			    fields[0].setFieldLength(3);
	
			    fields[1] = new DBFField();
			    fields[1].setFieldName("BrokerCode");
			    //fields[1].setFieldName("Broker Code");
			    fields[1].setDataType( DBFField.FIELD_TYPE_C);
			    fields[1].setFieldLength(20);
	
			    fields[2] = new DBFField();
			    fields[2].setFieldName("SubBroCode");
			    //fields[2].setFieldName("Sub Broker Code");
			    fields[2].setDataType( DBFField.FIELD_TYPE_C);
			    fields[2].setFieldLength(15);
			    
			    fields[3] = new DBFField();
			    fields[3].setFieldName("User Code");
			    fields[3].setDataType( DBFField.FIELD_TYPE_C);
			    fields[3].setFieldLength(10);
			    
			    fields[4] = new DBFField();
			    fields[4].setFieldName("UserTrxnNo");
			    //fields[4].setFieldName("User Trxn No");
			    fields[4].setDataType( DBFField.FIELD_TYPE_C);
			    fields[4].setFieldLength(8);
	
			    fields[5] = new DBFField();
			    fields[5].setFieldName("AppNumber");
			    //fields[5].setFieldName("Application Number");
			    fields[5].setDataType( DBFField.FIELD_TYPE_C);
			    fields[5].setFieldLength(20);
			    
			    fields[6] = new DBFField();
			    fields[6].setFieldName("FolNumber");
			    //fields[6].setFieldName("Folio Number");
			    fields[6].setDataType( DBFField.FIELD_TYPE_C);
			    fields[6].setFieldLength(25);
			    
			    fields[7] = new DBFField();
			    fields[7].setFieldName("ChecDigNum");
			    //fields[7].setFieldName("Check Digit Number");
			    fields[7].setDataType( DBFField.FIELD_TYPE_C);
			    fields[7].setFieldLength(2);
			    
			    fields[8] = new DBFField();
			    fields[8].setFieldName("Trxn Type");
			    fields[8].setDataType( DBFField.FIELD_TYPE_C);
			    fields[8].setFieldLength(7);
			    
			    fields[9] = new DBFField();
			    fields[9].setFieldName("SchemeCode");
			    //fields[9].setFieldName("Scheme Code");
			    fields[9].setDataType( DBFField.FIELD_TYPE_C);
			    fields[9].setFieldLength(5);
			    
			    fields[10] = new DBFField();
			    fields[10].setFieldName("FirstName");
			    //fields[10].setFieldName("Investor First Name");
			    fields[10].setDataType( DBFField.FIELD_TYPE_C);
			    fields[10].setFieldLength(70);
			    
				fields[11] = new DBFField();
			    fields[11].setFieldName("JointName");
			    //fields[11].setFieldName("Joint Name 1");
			    fields[11].setDataType( DBFField.FIELD_TYPE_C);
			    fields[11].setFieldLength(35);
	                   
			    fields[12] = new DBFField();
			    fields[12].setFieldName("JointName");
			    fields[12].setDataType( DBFField.FIELD_TYPE_C);
			    fields[12].setFieldLength(35);
				       
				fields[13] = new DBFField();
			    fields[13].setFieldName("AddLine");
			    fields[13].setDataType( DBFField.FIELD_TYPE_C);
			    fields[13].setFieldLength(55);
				       
				fields[14] = new DBFField();
			    fields[14].setFieldName("AddLine");
			    fields[14].setDataType( DBFField.FIELD_TYPE_C);
			    fields[14].setFieldLength(55);
				       
				fields[15] = new DBFField();
			    fields[15].setFieldName("AddLine");
			    fields[15].setDataType( DBFField.FIELD_TYPE_C);
			    fields[15].setFieldLength(55);
				       
				fields[16] = new DBFField();
			    fields[16].setFieldName("City");
			    fields[16].setDataType( DBFField.FIELD_TYPE_C);
			    fields[16].setFieldLength(35);
	                   
			    fields[17] = new DBFField();
			    fields[17].setFieldName("Pincode");
			    fields[17].setDataType( DBFField.FIELD_TYPE_C);
			    fields[17].setFieldLength(15);
				       
				fields[18] = new DBFField();
			    fields[18].setFieldName("PhoneOff");
			    fields[18].setDataType( DBFField.FIELD_TYPE_C);
			    fields[18].setFieldLength(35);
				       
				fields[19] = new DBFField();
			    fields[19].setFieldName("TxnDate");
			    fields[19].setDataType( DBFField.FIELD_TYPE_C);
			    fields[19].setFieldLength(10);
				       
				fields[20] = new DBFField();
			    fields[20].setFieldName("TxnTime");
			    fields[20].setDataType( DBFField.FIELD_TYPE_C);
			    fields[20].setFieldLength(10);
				       
				fields[21] = new DBFField();
			    fields[21].setFieldName("Units");
			    fields[21].setDataType( DBFField.FIELD_TYPE_C);
			    fields[21].setFieldLength(25);
	                   
			    fields[22] = new DBFField();
			    fields[22].setFieldName("Amount");
			    fields[22].setDataType( DBFField.FIELD_TYPE_C);
			    fields[22].setFieldLength(25);
				       
				fields[23] = new DBFField();
			    fields[23].setFieldName("Close AC");
			    fields[23].setDataType( DBFField.FIELD_TYPE_C);
			    fields[23].setFieldLength(1);
				       
				fields[24] = new DBFField();
			    fields[24].setFieldName("DateOfBir");
			    fields[24].setDataType( DBFField.FIELD_TYPE_C);
			    fields[24].setFieldLength(10);
				       
				fields[25] = new DBFField();
			    fields[25].setFieldName("GuarName");
			    fields[25].setDataType( DBFField.FIELD_TYPE_C);
			    fields[25].setFieldLength(120);
				       
				fields[26] = new DBFField();
			    fields[26].setFieldName("PAN NO");
			    fields[26].setDataType( DBFField.FIELD_TYPE_C);
			    fields[26].setFieldLength(40);
	                   
			    fields[27] = new DBFField();
			    fields[27].setFieldName("PhoneRes");
			    fields[27].setDataType( DBFField.FIELD_TYPE_C);
			    fields[27].setFieldLength(35);
				       
				fields[28] = new DBFField();
			    fields[28].setFieldName("FaxOffice");
			    fields[28].setDataType( DBFField.FIELD_TYPE_C);
			    fields[28].setFieldLength(35);
				       
				fields[29] = new DBFField();
			    fields[29].setFieldName("FaxRes");
			    fields[29].setDataType( DBFField.FIELD_TYPE_C);
			    fields[29].setFieldLength(35);
				       
				fields[30] = new DBFField();
			    fields[30].setFieldName("Email ID");
			    fields[30].setDataType( DBFField.FIELD_TYPE_C);
			    fields[30].setFieldLength(200);
				       
				fields[31] = new DBFField();
			    fields[31].setFieldName("AccNumber");
			    fields[31].setDataType( DBFField.FIELD_TYPE_C);
			    fields[31].setFieldLength(40);
	                   
			    fields[32] = new DBFField();
			    fields[32].setFieldName("AccType");
			    fields[32].setDataType( DBFField.FIELD_TYPE_C);
			    fields[32].setFieldLength(5);
				       
				fields[33] = new DBFField();
			    fields[33].setFieldName("BankName");
			    fields[33].setDataType( DBFField.FIELD_TYPE_C);
			    fields[33].setFieldLength(40);
				       
				fields[34] = new DBFField();
			    fields[34].setFieldName("BrnName");
			    fields[34].setDataType( DBFField.FIELD_TYPE_C);
			    fields[34].setFieldLength(40);
				       
				fields[35] = new DBFField();
			    fields[35].setFieldName("BankCity");
			    fields[35].setDataType( DBFField.FIELD_TYPE_C);
			    fields[35].setFieldLength(35);
				       
				fields[36] = new DBFField();
			    fields[36].setFieldName("ReinvestOp");
			    fields[36].setDataType( DBFField.FIELD_TYPE_C);
			    fields[36].setFieldLength(1);
	                   
			    fields[37] = new DBFField();
			    fields[37].setFieldName("HoldNat");
			    fields[37].setDataType( DBFField.FIELD_TYPE_C);
			    fields[37].setFieldLength(2);
				       
				fields[38] = new DBFField();
			    fields[38].setFieldName("OccuCode");
			    fields[38].setDataType( DBFField.FIELD_TYPE_C);
			    fields[38].setFieldLength(2);
				       
				fields[39] = new DBFField();
			    fields[39].setFieldName("TaxStaCode");
			    fields[39].setDataType( DBFField.FIELD_TYPE_C);
			    fields[39].setFieldLength(2);
				       
				fields[40] = new DBFField();
			    fields[40].setFieldName("Remarks");
			    fields[40].setDataType( DBFField.FIELD_TYPE_C);
			    fields[40].setFieldLength(200);
				       
				fields[41] = new DBFField();
			    fields[41].setFieldName("State");
			    fields[41].setDataType( DBFField.FIELD_TYPE_C);
			    fields[41].setFieldLength(2);
	                   
			    fields[42] = new DBFField();
			    fields[42].setFieldName("SubTrxnTyp");
			    fields[42].setDataType( DBFField.FIELD_TYPE_C);
			    fields[42].setFieldLength(6);
				       
				fields[43] = new DBFField();
			    fields[43].setFieldName("DivPayMech");
			    fields[43].setDataType( DBFField.FIELD_TYPE_C);
			    fields[43].setFieldLength(7);
				       
				fields[44] = new DBFField();
			    fields[44].setFieldName("ECSNumber");
			    fields[44].setDataType( DBFField.FIELD_TYPE_C);
			    fields[44].setFieldLength(9);
				       
				fields[45] = new DBFField();
			    fields[45].setFieldName("BankCode");
			    fields[45].setDataType( DBFField.FIELD_TYPE_C);
			    fields[45].setFieldLength(15);
				       
				fields[46] = new DBFField();
			    fields[46].setFieldName("AltFolioNo");
			    fields[46].setDataType( DBFField.FIELD_TYPE_C);
			    fields[46].setFieldLength(10);
	                   
			    fields[47] = new DBFField();
			    fields[47].setFieldName("AltBroCode");
			    fields[47].setDataType( DBFField.FIELD_TYPE_C);
			    fields[47].setFieldLength(20);
				       
				fields[48] = new DBFField();
			    fields[48].setFieldName("LocCode");
			    fields[48].setDataType( DBFField.FIELD_TYPE_C);
			    fields[48].setFieldLength(10);
				       
				fields[49] = new DBFField();
			    fields[49].setFieldName("RedPayMech");
			    fields[49].setDataType( DBFField.FIELD_TYPE_C);
			    fields[49].setFieldLength(7);
				       
				fields[50] = new DBFField();
			    fields[50].setFieldName("Pricing");
			    fields[50].setDataType( DBFField.FIELD_TYPE_C);
			    fields[50].setFieldLength(1);
				       
				fields[51] = new DBFField();
			    fields[51].setFieldName("JoHold1PAN");
			    fields[51].setDataType( DBFField.FIELD_TYPE_C);
			    fields[51].setFieldLength(40);
	                   
			    fields[52] = new DBFField();
			    fields[52].setFieldName("JoHold2PAN");
			    fields[52].setDataType( DBFField.FIELD_TYPE_C);
			    fields[52].setFieldLength(40);
				       
				fields[53] = new DBFField();
			    fields[53].setFieldName("NomName");
			    fields[53].setDataType( DBFField.FIELD_TYPE_C);
			    fields[53].setFieldLength(40);
				       
				fields[54] = new DBFField();
			    fields[54].setFieldName("NomRelati");
			    fields[54].setDataType( DBFField.FIELD_TYPE_C);
			    fields[54].setFieldLength(40);
				       
				fields[55] = new DBFField();
			    fields[55].setFieldName("GuarPAN");
			    fields[55].setDataType( DBFField.FIELD_TYPE_C);
			    fields[55].setFieldLength(45);
				       
				fields[56] = new DBFField();
			    fields[56].setFieldName("Instrm No");
			    fields[56].setDataType( DBFField.FIELD_TYPE_C);
			    fields[56].setFieldLength(15);
	                   
			    fields[57] = new DBFField();
			    fields[57].setFieldName("UINNumber");
			    fields[57].setDataType( DBFField.FIELD_TYPE_C);
			    fields[57].setFieldLength(15);
				       
				fields[58] = new DBFField();
			    fields[58].setFieldName("PAN Valid");
			    fields[58].setDataType( DBFField.FIELD_TYPE_C);
			    fields[58].setFieldLength(1);
				       
				fields[59] = new DBFField();
			    fields[59].setFieldName("GuarPANVal");
			    fields[59].setDataType( DBFField.FIELD_TYPE_C);
			    fields[59].setFieldLength(1);
				       
				fields[60] = new DBFField();
			    fields[60].setFieldName("JH1PANVal");
			    fields[60].setDataType( DBFField.FIELD_TYPE_C);
			    fields[60].setFieldLength(1);
				       
				fields[61] = new DBFField();
			    fields[61].setFieldName("JH2PANVal");
			    fields[61].setDataType( DBFField.FIELD_TYPE_C);
			    fields[61].setFieldLength(1);
	                   
			    fields[62] = new DBFField();
			    fields[62].setFieldName("Dummy");
			    fields[62].setDataType( DBFField.FIELD_TYPE_C);
			    fields[62].setFieldLength(1);
				       
				fields[63] = new DBFField();
			    fields[63].setFieldName("Dummy");
			    fields[63].setDataType( DBFField.FIELD_TYPE_C);
			    fields[63].setFieldLength(1);
				       
				fields[64] = new DBFField();
			    fields[64].setFieldName("Dummy");
			    fields[64].setDataType( DBFField.FIELD_TYPE_C);
			    fields[64].setFieldLength(1);
				       
				fields[65] = new DBFField();
			    fields[65].setFieldName("Dummy");
			    fields[65].setDataType( DBFField.FIELD_TYPE_C);
			    fields[65].setFieldLength(1);
				       
				fields[66] = new DBFField();
			    fields[66].setFieldName("DUMMY(Re)");
			    fields[66].setDataType( DBFField.FIELD_TYPE_C);
			    fields[66].setFieldLength(30);
	                   
			    fields[67] = new DBFField();
			    fields[67].setFieldName("SIPRegDate");
			    fields[67].setDataType( DBFField.FIELD_TYPE_C);
			    fields[67].setFieldLength(10);
				       
				fields[68] = new DBFField();
			    fields[68].setFieldName("FH_MIN");
			    fields[68].setDataType( DBFField.FIELD_TYPE_C);
			    fields[68].setFieldLength(10);
				       
				fields[69] = new DBFField();
			    fields[69].setFieldName("JH1_MIN");
			    fields[69].setDataType( DBFField.FIELD_TYPE_C);
			    fields[69].setFieldLength(10);
				       
				fields[70] = new DBFField();
			    fields[70].setFieldName("JH2_min");
			    fields[70].setDataType( DBFField.FIELD_TYPE_C);
			    fields[70].setFieldLength(10);
				       
				fields[71] = new DBFField();
			    fields[71].setFieldName("Guard_min");
			    fields[71].setDataType( DBFField.FIELD_TYPE_C);
			    fields[71].setFieldLength(10);
	                   
			    fields[72] = new DBFField();
			    fields[72].setFieldName("NEFT_CODE");
			    fields[72].setDataType( DBFField.FIELD_TYPE_C);
			    fields[72].setFieldLength(11);
				       
				fields[73] = new DBFField();
			    fields[73].setFieldName("RTGS_CODE");
			    fields[73].setDataType( DBFField.FIELD_TYPE_C);
			    fields[73].setFieldLength(11);
				       
				fields[74] = new DBFField();
			    fields[74].setFieldName("EMAIL_ACST");
			    fields[74].setDataType( DBFField.FIELD_TYPE_C);
			    fields[74].setFieldLength(1);
				       
				fields[75] = new DBFField();
			    fields[75].setFieldName("MOBILE_NO");
			    fields[75].setDataType( DBFField.FIELD_TYPE_C);
			    fields[75].setFieldLength(15);
				       
				fields[76] = new DBFField();
			    fields[76].setFieldName("DP_ID");
			    fields[76].setDataType( DBFField.FIELD_TYPE_C);
			    fields[76].setFieldLength(16);
	                   
			    fields[77] = new DBFField();
			    fields[77].setFieldName("POA_type");
			    fields[77].setDataType( DBFField.FIELD_TYPE_C);
			    fields[77].setFieldLength(1);
				       
				fields[78] = new DBFField();
			    fields[78].setFieldName("Trxn Mode");
			    fields[78].setDataType( DBFField.FIELD_TYPE_C);
			    fields[78].setFieldLength(1);
				       
				fields[79] = new DBFField();
			    fields[79].setFieldName("TxnSigConf");
			    fields[79].setDataType( DBFField.FIELD_TYPE_C);
			    fields[79].setFieldLength(1);
				       
				fields[80] = new DBFField();
			    fields[80].setFieldName("AddlAdd1");
			    fields[80].setDataType( DBFField.FIELD_TYPE_C);
			    fields[80].setFieldLength(55);
				       
				fields[81] = new DBFField();
			    fields[81].setFieldName("AddAdd2");
			    fields[81].setDataType( DBFField.FIELD_TYPE_C);
			    fields[81].setFieldLength(55);
	                   
			    fields[82] = new DBFField();
			    fields[82].setFieldName("AddlAdd3");
			    fields[82].setDataType( DBFField.FIELD_TYPE_C);
			    fields[82].setFieldLength(55);
				       
				fields[83] = new DBFField();
			    fields[83].setFieldName("City");
			    fields[83].setDataType( DBFField.FIELD_TYPE_C);
			    fields[83].setFieldLength(35);
				       
				fields[84] = new DBFField();
			    fields[84].setFieldName("State");
			    fields[84].setDataType( DBFField.FIELD_TYPE_C);
			    fields[84].setFieldLength(2);
				       
				fields[85] = new DBFField();
			    fields[85].setFieldName("Country");
			    fields[85].setDataType( DBFField.FIELD_TYPE_C);
			    fields[85].setFieldLength(35);
				       
				fields[86] = new DBFField();
			    fields[86].setFieldName("Pincode");
			    fields[86].setDataType( DBFField.FIELD_TYPE_C);
			    fields[86].setFieldLength(35);
	                   
			    fields[87] = new DBFField();
			    fields[87].setFieldName("Nom1AppPer");
			    fields[87].setDataType( DBFField.FIELD_TYPE_C);
			    fields[87].setFieldLength(5);
				       
				fields[88] = new DBFField();
			    fields[88].setFieldName("Nom2Name");
			    fields[88].setDataType( DBFField.FIELD_TYPE_C);
			    fields[88].setFieldLength(40);
				       
				fields[89] = new DBFField();
			    fields[89].setFieldName("Nom2Rel");
			    fields[89].setDataType( DBFField.FIELD_TYPE_C);
			    fields[89].setFieldLength(40);
				       
				fields[90] = new DBFField();
			    fields[90].setFieldName("Nom2AppPer");
			    fields[90].setDataType( DBFField.FIELD_TYPE_C);
			    fields[90].setFieldLength(5);
				       
				fields[91] = new DBFField();
			    fields[91].setFieldName("Nom3Name");
			    fields[91].setDataType( DBFField.FIELD_TYPE_C);
			    fields[91].setFieldLength(40);
	                   
			    fields[92] = new DBFField();
			    fields[92].setFieldName("Nom3Rel");
			    fields[92].setDataType( DBFField.FIELD_TYPE_C);
			    fields[92].setFieldLength(40);
				       
				fields[93] = new DBFField();
			    fields[93].setFieldName("Nom3AppPer");
			    fields[93].setDataType( DBFField.FIELD_TYPE_C);
			    fields[93].setFieldLength(5);
				       
				fields[94] = new DBFField();
			    fields[94].setFieldName("CheckFlag");
			    fields[94].setDataType( DBFField.FIELD_TYPE_C);
			    fields[94].setFieldLength(1);
				       
				fields[95] = new DBFField();
			    fields[95].setFieldName("ThiParPay");
			    fields[95].setDataType( DBFField.FIELD_TYPE_C);
			    fields[95].setFieldLength(1);
				       
				fields[96] = new DBFField();
			    fields[96].setFieldName("KYCStatus");
			    fields[96].setDataType( DBFField.FIELD_TYPE_C);
			    fields[96].setFieldLength(1);
	                   
			    fields[97] = new DBFField();
			    fields[97].setFieldName("FIRCStatus");
			    fields[97].setDataType( DBFField.FIELD_TYPE_C);
			    fields[97].setFieldLength(1);
				       
				fields[98] = new DBFField();
			    fields[98].setFieldName("SIPRegNum");
			    fields[98].setDataType( DBFField.FIELD_TYPE_C);
			    fields[98].setFieldLength(15);
				       
				fields[99] = new DBFField();
			    fields[99].setFieldName("NoOfInstal");
			    fields[99].setDataType( DBFField.FIELD_TYPE_C);
			    fields[99].setFieldLength(10);
				       
				fields[100] = new DBFField();
			    fields[100].setFieldName("SIPFreque");
			    fields[100].setDataType( DBFField.FIELD_TYPE_C);
			    fields[100].setFieldLength(5);
				       
				fields[101] = new DBFField();
			    fields[101].setFieldName("StartDate");
			    fields[101].setDataType( DBFField.FIELD_TYPE_C);
			    fields[101].setFieldLength(10);
	                   
			    fields[102] = new DBFField();
			    fields[102].setFieldName("EndDate");
			    fields[102].setDataType( DBFField.FIELD_TYPE_C);
			    fields[102].setFieldLength(10);
				       
				fields[103] = new DBFField();
			    fields[103].setFieldName("InsNumber");
			    fields[103].setDataType( DBFField.FIELD_TYPE_C);
			    fields[103].setFieldLength(10);
				       
				fields[104] = new DBFField();
			    fields[104].setFieldName("NomDaOfBir");
			    fields[104].setDataType( DBFField.FIELD_TYPE_C);
			    fields[104].setFieldLength(11);
				       
				fields[105] = new DBFField();
			    fields[105].setFieldName("NomMinFlag");
			    fields[105].setDataType( DBFField.FIELD_TYPE_C);
			    fields[105].setFieldLength(1);
				       
				fields[106] = new DBFField();
			    fields[106].setFieldName("NomGaurNam");
			    fields[106].setDataType( DBFField.FIELD_TYPE_C);
			    fields[106].setFieldLength(35);
	                   
			    fields[107] = new DBFField();
			    fields[107].setFieldName("Dummy 1");
			    fields[107].setDataType( DBFField.FIELD_TYPE_C);
			    fields[107].setFieldLength(10);
				       
				fields[108] = new DBFField();
			    fields[108].setFieldName("Dummy 2");
			    fields[108].setDataType( DBFField.FIELD_TYPE_C);
			    fields[108].setFieldLength(25);
				       
				fields[109] = new DBFField();
			    fields[109].setFieldName("Dummy 3");
			    fields[109].setDataType( DBFField.FIELD_TYPE_C);
			    fields[109].setFieldLength(25);
				       
				fields[110] = new DBFField();
			    fields[110].setFieldName("Dummy 4");
			    fields[110].setDataType( DBFField.FIELD_TYPE_C);
			    fields[110].setFieldLength(5);
				       
				fields[111] = new DBFField();
			    fields[111].setFieldName("Dummy 5");
			    fields[111].setDataType( DBFField.FIELD_TYPE_C);
			    fields[111].setFieldLength(1);
	                    
			    fields[112] = new DBFField();
			    fields[112].setFieldName("Dummy 6");
			    fields[112].setDataType( DBFField.FIELD_TYPE_C);
			    fields[112].setFieldLength(3);
				        
				fields[113] = new DBFField();
			    fields[113].setFieldName("FiHldPANEx");
			    fields[113].setDataType( DBFField.FIELD_TYPE_C);
			    fields[113].setFieldLength(1);
				        
				fields[114] = new DBFField();
			    fields[114].setFieldName("JH1PanEx");
			    fields[114].setDataType( DBFField.FIELD_TYPE_C);
			    fields[114].setFieldLength(1);
				        
				fields[115] = new DBFField();
			    fields[115].setFieldName("JH2PanEx");
			    fields[115].setDataType( DBFField.FIELD_TYPE_C);
			    fields[115].setFieldLength(1);
				        
				fields[116] = new DBFField();
			    fields[116].setFieldName("GuarPANEx");
			    fields[116].setDataType( DBFField.FIELD_TYPE_C);
			    fields[116].setFieldLength(1);
	                    
			    fields[117] = new DBFField();
			    fields[117].setFieldName("FiHldExCat");
			    fields[117].setDataType( DBFField.FIELD_TYPE_C);
			    fields[117].setFieldLength(2);
				        
				fields[118] = new DBFField();
			    fields[118].setFieldName("JH1ExCat");
			    fields[118].setDataType( DBFField.FIELD_TYPE_C);
			    fields[118].setFieldLength(2);
				        
				fields[119] = new DBFField();
			    fields[119].setFieldName("JH2ExCat");
			    fields[119].setDataType( DBFField.FIELD_TYPE_C);
			    fields[119].setFieldLength(2);
				        
				fields[120] = new DBFField();
			    fields[120].setFieldName("GaurExCat");
			    fields[120].setDataType( DBFField.FIELD_TYPE_C);
			    fields[120].setFieldLength(2);
				        
				fields[121] = new DBFField();
			    fields[121].setFieldName("FHKRAExRNo");
			    fields[121].setDataType( DBFField.FIELD_TYPE_C);
			    fields[121].setFieldLength(10);
	                    
			    fields[122] = new DBFField();
			    fields[122].setFieldName("JH1KRAExRN");
			    fields[122].setDataType( DBFField.FIELD_TYPE_C);
			    fields[122].setFieldLength(10);
				        
				fields[123] = new DBFField();
			    fields[123].setFieldName("JH2KRAExRN");
			    fields[123].setDataType( DBFField.FIELD_TYPE_C);
			    fields[123].setFieldLength(10);
				        
				fields[124] = new DBFField();
			    fields[124].setFieldName("GaurExRN");
			    fields[124].setDataType( DBFField.FIELD_TYPE_C);
			    fields[124].setFieldLength(10);
				        
				fields[125] = new DBFField();
			    fields[125].setFieldName("EUINOpted");
			    fields[125].setDataType( DBFField.FIELD_TYPE_C);
			    fields[125].setFieldLength(1);
				        
				fields[126] = new DBFField();
			    fields[126].setFieldName("EUIN");
			    fields[126].setDataType( DBFField.FIELD_TYPE_C);
			    fields[126].setFieldLength(10);
	                    
			    fields[127] = new DBFField();
			    fields[127].setFieldName("NomNotOptd");
			    fields[127].setDataType( DBFField.FIELD_TYPE_C);
			    fields[127].setFieldLength(1);
				        
				fields[128] = new DBFField();
			    fields[128].setFieldName("SubBroARN");
			    fields[128].setDataType( DBFField.FIELD_TYPE_C);
			    fields[128].setFieldLength(20);
				        
				fields[129] = new DBFField();
			    fields[129].setFieldName("BankPrfSub");
			    fields[129].setDataType( DBFField.FIELD_TYPE_C);
			    fields[129].setFieldLength(1);
	
	
			    
			    DBFWriter writer = new DBFWriter();
			    writer.setFields( fields);
	
			    Properties properties = new Properties();
				String propFilePath = "../../../config/config.properties";
	
				properties.load(CamsTransactionDbfFileGenerator.class.getResourceAsStream(propFilePath));
				
				System.out.println("BATCH_IMAGE_NUMBER : "+properties.getProperty("BATCH_IMAGE_NUMBER"));
	
					
	
	
				   //session.getTransaction().commit();
					
					
					Object rowData[] = new Object[130];
					
					int i = 1;
					String transactionDetailDate;
					String transactionDate;
					String transactionTime;
					for(TransactionDetails transactionDetail : transactionDetailsList){
	
						//session.beginTransaction();
						
						/*query = session.createQuery("from Customers where customerId = :customerId");
						query.setParameter("customerId", transactionDetail.getCustomerId());	
						Customers customer =  (Customers) query.uniqueResult();*/
						//session.getTransaction().commit();
						
						//session.beginTransaction();
						
						/*query = session.createQuery("from AdditionalCustomerDetails where customerId = :customerId");
						query.setParameter("customerId", transactionDetail.getCustomerId());
						AdditionalCustomerDetails additionalCustomerDetails =  (AdditionalCustomerDetails) query.uniqueResult();*/
						//session.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						Customers customer = (Customers) hibernateSession.get(Customers.class, transactionDetail.getCustomerId());
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
			    		CustomerDetails customerDetail = (CustomerDetails) hibernateSession.get(CustomerDetails.class,  transactionDetail.getCustomerId());
			    		hibernateSession.getTransaction().commit();
			    		//AdditionalCustomerDetails additionalDetails = (AdditionalCustomerDetails) session.get(AdditionalCustomerDetails.class,  transactionDetail.getCustomerId());
			    		
			    		hibernateSession.beginTransaction();
						
						query = hibernateSession.createQuery("from SecondaryFundDetails where fundId = :fundId");
						query.setParameter("fundId", transactionDetail.getFundId());	
						SecondaryFundDetails secondaryFundDetails =  (SecondaryFundDetails) query.uniqueResult();
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						
						query = hibernateSession.createQuery("from BankDetails where customerId = :customerId");
						query.setParameter("customerId", transactionDetail.getCustomerId());
						BankDetails bankDetails =  (BankDetails) query.uniqueResult();
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						
						query = hibernateSession.createQuery("from SipDetails where transactionDetailId = :transactionDetailId");
						query.setParameter("transactionDetailId", transactionDetail.getTransactionDetailId());	
						SipDetails sipDetails =  (SipDetails) query.uniqueResult();
						hibernateSession.getTransaction().commit();
						
						Object result;
						
						hibernateSession.beginTransaction();
						
						String  occuCode;
						query = hibernateSession.createQuery("select camsCode from RtaSpecificCodes where fieldType = :fieldType and fieldValue = :fieldValue");
						query.setParameter("fieldType", "Occupation");	
						query.setParameter("fieldValue", customerDetail.getOccupation());	
						result = query.uniqueResult();
						occuCode = result.toString();
						hibernateSession.getTransaction().commit();
						
						String  schemeName;
						
						hibernateSession.beginTransaction();
						query = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId = :fundId");
						query.setParameter("fundId", transactionDetail.getFundId());		
						result = query.uniqueResult();
						schemeName = result.toString();
						
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						
						String  taxStatus;
						query =   hibernateSession.createQuery("select camsCode from RtaSpecificCodes where fieldType = :fieldType and fieldValue = :fieldValue");
						query.setParameter("fieldType", "TaxStatus");	
						query.setParameter("fieldValue", customerDetail.getTaxStatus());	
						result = query.uniqueResult();
						taxStatus = result.toString();
						
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						
						String  state;
						query =   hibernateSession.createQuery("select camsCode from RtaSpecificCodes where fieldType = :fieldType and fieldValue = :fieldValue");
						query.setParameter("fieldType", "State");	
						query.setParameter("fieldValue", customerDetail.getResidentialState());	
						result = query.uniqueResult();
						state = result.toString();
						
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						
						String  locationCode;
						query =   hibernateSession.createQuery("select camsCode from RtaSpecificCodes where fieldType = :fieldType and fieldValue = :fieldValue");
						query.setParameter("fieldType", "LocationCode");	
						query.setParameter("fieldValue", customerDetail.getResidentialCity());	
						result = query.uniqueResult();
						locationCode = result.toString();
						
						hibernateSession.getTransaction().commit();
						   
						rowData[0] = secondaryFundDetails.getAmcCode(); 
						System.out.println("Broke code : "+properties.getProperty("ARN_CODE"));
						rowData[1] = properties.getProperty("ARN_CODE"); 
						rowData[2] = null; 
						rowData[3] = properties.getProperty("USER_ID"); 
						rowData[4] = transactionDetail.getTransactionDetailId(); 
						rowData[5] = null; 
						rowData[6] = "FOLIO_NUMBER";
						rowData[7] = null; 
						rowData[8] = (("BUY".equals(transactionDetail.getBuySell())) ? "P" : "R"); 
						rowData[9] = schemeName; 
	
						rowData[10] = customer.getCustomerName(); 
						rowData[11] = null; 
						rowData[12] = null; 
						rowData[13] = customerDetail.getAddressLineOne(); 
						rowData[14] = customerDetail.getAddressLineTwo(); 
						rowData[15] = customerDetail.getAddressLineThree(); 
						rowData[16] = customerDetail.getResidentialCity(); 
						rowData[17] = customerDetail.getResidentialPin(); 
						rowData[18] = null; 
						
						transactionDetailDate = transactionDetail.getTransactionDate();
						transactionDate = transactionDetailDate.substring(5,7)+"/"+transactionDetailDate.substring(8,10)+"/"+transactionDetailDate.substring(0,4);
						transactionTime = transactionDetailDate.substring(11,19);
						
						System.out.println("transactionDate : "+transactionDate);
						System.out.println("transactionTime : "+transactionTime);
						
						rowData[19] = transactionDate; 
	
						rowData[20] = transactionTime; 
						rowData[21] = (("BUY".equals(transactionDetail.getBuySell())) ? null : transactionDetail.getQuantity()); 
						rowData[22] = transactionDetail.getTransactionAmount(); 
						rowData[23] = null;
						rowData[24] = customerDetail.getDateOfBirth(); 
						rowData[25] = null;
						rowData[26] = customer.getPanCard();  
						rowData[27] = null;
						rowData[28] = null; 
						rowData[29] = null; 
						        
						rowData[30] = customer.getEmailId();  
						rowData[31] = bankDetails.getAccountNumber();
						rowData[32] = bankDetails.getAccountType();
						rowData[33] = null; 
						rowData[34] = null; 
						rowData[35] = null; 
						rowData[36] = "Z"; 
						rowData[37] = "SI"; 
						rowData[38] = occuCode; 
						rowData[39] = taxStatus;
						        
						rowData[40] = null;
						rowData[41] = state; 
						rowData[42] = null; 
						rowData[43] = null; 
						rowData[44] = null; 
						rowData[45] = null; 
						rowData[46] = null; 
						rowData[47] = null;
						rowData[48] = locationCode; 
						rowData[49] = null; 
						        
						rowData[50] = null; 
						rowData[51] = null; 
						rowData[52] = null; 
						rowData[53] = null; 
						rowData[54] = null; 
						rowData[55] = null; 
						rowData[56] = null; 
						rowData[57] = null; 
						rowData[58] = "Y"; 
						rowData[59] = null;
						        
						rowData[60] = null;
						rowData[61] = null;
						rowData[62] = null; 
						rowData[63] = null; 
						rowData[64] = null; 
						rowData[65] = null; 
						rowData[66] = null; 
						rowData[67] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? null : "25"); 
						rowData[68] = null;
						rowData[69] = null; 
						        
						rowData[70] = null; 
						rowData[71] = null; 
						rowData[72] = null; 
						rowData[73] = null; 
						rowData[74] = "E"; 
						rowData[75] = customer.getEmailId(); 
						rowData[76] = null; 
						rowData[77] = "Y"; 
						rowData[78] = "W"; 
						rowData[79] = "Y"; 
						        
						rowData[80] = null; 
						rowData[81] = null; 
						rowData[82] = null; 
						rowData[83] = null; 
						rowData[84] = null; 
						rowData[85] = null; 
						rowData[86] = null; 
						rowData[87] = null; 
						rowData[88] = null; 
						rowData[89] = null; 
						        
						rowData[90] = null; 
						rowData[91] = null; 
						rowData[92] = null; 
						rowData[93] = null; 
						rowData[94] = null; 
						rowData[95] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? "N" : null); 
						rowData[96] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? "Y" : null); 
						rowData[97] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? "Y" : null); 
						rowData[98] = null;
						rowData[99] = null; 
	
						rowData[100] = null; 
						rowData[101] = null;
						rowData[102] = null; 
						rowData[103] = null; 
						rowData[104] = null;
						rowData[105] = null;
						rowData[106] = null;
						rowData[107] = null;
						rowData[108] = null;
						rowData[109] = null;
	
						rowData[110] = null;
						rowData[111] = null;
						rowData[112] = null;
						rowData[113] = "Y";
						rowData[114] = "N";
						rowData[115] = "N";
						rowData[116] = "N"; 
						rowData[117] = null;
						rowData[118] = null; 
						rowData[119] = null;
	
						rowData[120] = null;
						rowData[121] = null;
						rowData[122] = null; 
						rowData[123] = null;
						rowData[124] = null;
						rowData[125] = "N";
						rowData[126] = null;
						rowData[127] = "Y";
						rowData[128] = null;
						rowData[129] = "Y";
	
					    writer.addRecord( rowData);
	
						rowData = new Object[130];
					    
					}
					
					
					
					String srcDirName = properties.getProperty("SRC_DIR_NAME");
	
				    FileOutputStream fos = new FileOutputStream(srcDirName+"Cams_Transaction"+frmtdDate+".dbf");
				    writer.write( fos);
				    fos.close();
					
				    hibernateSession.beginTransaction();
				    tempDbfFileStatusDetails = new DbfFileStatusDetails("CAMS", "TRANSACTION",frmtdDate,"N");

				    hibernateSession.save(tempDbfFileStatusDetails);
				    hibernateSession.getTransaction().commit();
					
					System.out.println("Done ! ");
		   		}

			}
			catch ( HibernateException e ) {

				e.printStackTrace();
				//throw new MoneyBuddyException(e.getMessage(),e);
			}
		   catch (IOException e ) {

				e.printStackTrace();
				//throw new MoneyBuddyException(e.getMessage(),e);
		   }
			catch (Exception e ) {

				e.printStackTrace();
				//throw new MoneyBuddyException(e.getMessage(),e);
			}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

		} 

	}

