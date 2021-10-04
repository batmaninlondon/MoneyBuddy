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
import com.myMoneyBuddy.EntityClasses.AdditionalCustomerDetails;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.EntityClasses.SecondaryFundDetails;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class KarvyTransactionDbfFileGenerator implements org.quartz.Job{

	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	    
	    
		try {	

			
			DbfFileStatusDetails tempDbfFileStatusDetails;
			hibernateSession.beginTransaction();
			   
		   Query query =  hibernateSession.createQuery("from TransactionDetails where rtaFileGenerated = :rtaFileGenerated and transactionStatus = :transactionStatus and fundId in (select fundId from SecondaryFundDetails where rta = :rta)");
		   query.setParameter("rta", "KARVY");
		   query.setParameter("transactionStatus", "COMPLETE");
		   query.setParameter("rtaFileGenerated", "N");
		   List<TransactionDetails> transactionDetailsList = query.list();

		   hibernateSession.getTransaction().commit();
		   
		   if (transactionDetailsList.size()!=0) {
	
				   
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String frmtdDate = dateFormat.format(date);
	    		
			  	DBFField fields[] = new DBFField[130];
			  
			  	fields[0] = new DBFField();
			    fields[0].setFieldName("AMC_CODE");
			    fields[0].setDataType( DBFField.FIELD_TYPE_C);
			    fields[0].setFieldLength(3);
	
			    fields[1] = new DBFField();
			    fields[1].setFieldName("BROKE_CO");
			    fields[1].setDataType( DBFField.FIELD_TYPE_C);
			    fields[1].setFieldLength(20);
	
			    fields[2] = new DBFField();
			    fields[2].setFieldName("SBBR_CODE");
			    fields[2].setDataType( DBFField.FIELD_TYPE_C);
			    fields[2].setFieldLength(15);
			    
			    fields[3] = new DBFField();
			    fields[3].setFieldName("User_Code");
			    fields[3].setDataType( DBFField.FIELD_TYPE_C);
			    fields[3].setFieldLength(10);
			    
			    fields[4] = new DBFField();
			    fields[4].setFieldName("USR_TXN_NO");
			    fields[4].setDataType( DBFField.FIELD_TYPE_C);
			    fields[4].setFieldLength(8);
	
			    fields[5] = new DBFField();
			    fields[5].setFieldName("Appl_No");
			    fields[5].setDataType( DBFField.FIELD_TYPE_C);
			    fields[5].setFieldLength(10);
			    
			    fields[6] = new DBFField();
			    fields[6].setFieldName("FOLIO_NO");
			    fields[6].setDataType( DBFField.FIELD_TYPE_C);
			    fields[6].setFieldLength(15);
			    
			    fields[7] = new DBFField();
			    fields[7].setFieldName("Ck_DIG_NO");
			    fields[7].setDataType( DBFField.FIELD_TYPE_C);
			    fields[7].setFieldLength(10);
			    
			    fields[8] = new DBFField();
			    fields[8].setFieldName("TRXN_TYPE");
			    fields[8].setDataType( DBFField.FIELD_TYPE_C);
			    fields[8].setFieldLength(7);
			    
			    fields[9] = new DBFField();
			    fields[9].setFieldName("SCH_CODE");
			    fields[9].setDataType( DBFField.FIELD_TYPE_C);
			    fields[9].setFieldLength(5);
			    
			    fields[10] = new DBFField();
			    fields[10].setFieldName("FIRST_NAME");
			    fields[10].setDataType( DBFField.FIELD_TYPE_C);
			    fields[10].setFieldLength(70);
			    
				fields[11] = new DBFField();
			    fields[11].setFieldName("JONY_NAME1");
			    fields[11].setDataType( DBFField.FIELD_TYPE_C);
			    fields[11].setFieldLength(35);
	                   
			    fields[12] = new DBFField();
			    fields[12].setFieldName("JONT_NAME2");
			    fields[12].setDataType( DBFField.FIELD_TYPE_C);
			    fields[12].setFieldLength(35);
				       
				fields[13] = new DBFField();
			    fields[13].setFieldName("ADD1");
			    fields[13].setDataType( DBFField.FIELD_TYPE_C);
			    fields[13].setFieldLength(40);
				       
				fields[14] = new DBFField();
			    fields[14].setFieldName("ADD2");
			    fields[14].setDataType( DBFField.FIELD_TYPE_C);
			    fields[14].setFieldLength(40);
				       
				fields[15] = new DBFField();
			    fields[15].setFieldName("ADD3");
			    fields[15].setDataType( DBFField.FIELD_TYPE_C);
			    fields[15].setFieldLength(40);
				       
				fields[16] = new DBFField();
			    fields[16].setFieldName("CITY");
			    fields[16].setDataType( DBFField.FIELD_TYPE_C);
			    fields[16].setFieldLength(35);
	                   
			    fields[17] = new DBFField();
			    fields[17].setFieldName("PINCODE");
			    fields[17].setDataType( DBFField.FIELD_TYPE_C);
			    fields[17].setFieldLength(15);
				       
				fields[18] = new DBFField();
			    fields[18].setFieldName("PHONE_OFF");
			    fields[18].setDataType( DBFField.FIELD_TYPE_C);
			    fields[18].setFieldLength(15);
				       
				fields[19] = new DBFField();
			    fields[19].setFieldName("MOBILE_NO");
			    fields[19].setDataType( DBFField.FIELD_TYPE_C);
			    fields[19].setFieldLength(15);
				       
				fields[20] = new DBFField();
			    fields[20].setFieldName("TRXN_DATE");
			    fields[20].setDataType( DBFField.FIELD_TYPE_C);
			    fields[20].setFieldLength(8);
				       
				fields[21] = new DBFField();
			    fields[21].setFieldName("TRXN_TIME");
			    fields[21].setDataType( DBFField.FIELD_TYPE_C);
			    fields[21].setFieldLength(10);
	                   
			    fields[22] = new DBFField();
			    fields[22].setFieldName("UNITS");
			    fields[22].setDataType( DBFField.FIELD_TYPE_C);
			    fields[22].setFieldLength(25);
				       
				fields[23] = new DBFField();
			    fields[23].setFieldName("AMOUNT");
			    fields[23].setDataType( DBFField.FIELD_TYPE_C);
			    fields[23].setFieldLength(25);
				       
				fields[24] = new DBFField();
			    fields[24].setFieldName("CLOS_AC_CH");
			    fields[24].setDataType( DBFField.FIELD_TYPE_C);
			    fields[24].setFieldLength(1);
				       
				fields[25] = new DBFField();
			    fields[25].setFieldName("DOB");
			    fields[25].setDataType( DBFField.FIELD_TYPE_C);
			    fields[25].setFieldLength(20);
				       
				fields[26] = new DBFField();
			    fields[26].setFieldName("GUARDIAN");
			    fields[26].setDataType( DBFField.FIELD_TYPE_C);
			    fields[26].setFieldLength(35);
	                   
			    fields[27] = new DBFField();
			    fields[27].setFieldName("TAX_NUMBER");
			    fields[27].setDataType( DBFField.FIELD_TYPE_C);
			    fields[27].setFieldLength(40);
				       
				fields[28] = new DBFField();
			    fields[28].setFieldName("PHONE_RES");
			    fields[28].setDataType( DBFField.FIELD_TYPE_C);
			    fields[28].setFieldLength(15);
				       
				fields[29] = new DBFField();
			    fields[29].setFieldName("FAX_OFF");
			    fields[29].setDataType( DBFField.FIELD_TYPE_C);
			    fields[29].setFieldLength(15);
				       
				fields[30] = new DBFField();
			    fields[30].setFieldName("FAX_RES");
			    fields[30].setDataType( DBFField.FIELD_TYPE_C);
			    fields[30].setFieldLength(15);
				       
				fields[31] = new DBFField();
			    fields[31].setFieldName("EMAIL");
			    fields[31].setDataType( DBFField.FIELD_TYPE_C);
			    fields[31].setFieldLength(50);
	                   
			    fields[32] = new DBFField();
			    fields[32].setFieldName("ACCT_NO");
			    fields[32].setDataType( DBFField.FIELD_TYPE_C);
			    fields[32].setFieldLength(40);
				       
				fields[33] = new DBFField();
			    fields[33].setFieldName("ACCT_TYPE");
			    fields[33].setDataType( DBFField.FIELD_TYPE_C);
			    fields[33].setFieldLength(5);
				       
				fields[34] = new DBFField();
			    fields[34].setFieldName("BANK_NAME");
			    fields[34].setDataType( DBFField.FIELD_TYPE_C);
			    fields[34].setFieldLength(60);
				       
				fields[35] = new DBFField();
			    fields[35].setFieldName("BR_NAME");
			    fields[35].setDataType( DBFField.FIELD_TYPE_C);
			    fields[35].setFieldLength(40);
				       
				fields[36] = new DBFField();
			    fields[36].setFieldName("BANK_CITY");
			    fields[36].setDataType( DBFField.FIELD_TYPE_C);
			    fields[36].setFieldLength(35);
	                   
			    fields[37] = new DBFField();
			    fields[37].setFieldName("REINV_TAG");
			    fields[37].setDataType( DBFField.FIELD_TYPE_C);
			    fields[37].setFieldLength(1);
				       
				fields[38] = new DBFField();
			    fields[38].setFieldName("HOLD_NATUR");
			    fields[38].setDataType( DBFField.FIELD_TYPE_C);
			    fields[38].setFieldLength(2);
				       
				fields[39] = new DBFField();
			    fields[39].setFieldName("OCC_CODE");
			    fields[39].setDataType( DBFField.FIELD_TYPE_C);
			    fields[39].setFieldLength(2);
				       
				fields[40] = new DBFField();
			    fields[40].setFieldName("TAX_STATUS");
			    fields[40].setDataType( DBFField.FIELD_TYPE_C);
			    fields[40].setFieldLength(2);
				       
				fields[41] = new DBFField();
			    fields[41].setFieldName("REMARKS");
			    fields[41].setDataType( DBFField.FIELD_TYPE_C);
			    fields[41].setFieldLength(250);
	                   
			    fields[42] = new DBFField();
			    fields[42].setFieldName("STATE");
			    fields[42].setDataType( DBFField.FIELD_TYPE_C);
			    fields[42].setFieldLength(2);
				       
				fields[43] = new DBFField();
			    fields[43].setFieldName("PAN_2_HLDR");
			    fields[43].setDataType( DBFField.FIELD_TYPE_C);
			    fields[43].setFieldLength(40);
				       
				fields[44] = new DBFField();
			    fields[44].setFieldName("PAN_3_HLDR");
			    fields[44].setDataType( DBFField.FIELD_TYPE_C);
			    fields[44].setFieldLength(40);
				       
				fields[45] = new DBFField();
			    fields[45].setFieldName("Guard_PAN");
			    fields[45].setDataType( DBFField.FIELD_TYPE_C);
			    fields[45].setFieldLength(40);
				       
				fields[46] = new DBFField();
			    fields[46].setFieldName("LOCATION");
			    fields[46].setDataType( DBFField.FIELD_TYPE_C);
			    fields[46].setFieldLength(10);
	                   
			    fields[47] = new DBFField();
			    fields[47].setFieldName("UINno");
			    fields[47].setDataType( DBFField.FIELD_TYPE_C);
			    fields[47].setFieldLength(10);
				       
				fields[48] = new DBFField();
			    fields[48].setFieldName("FORM6061");
			    fields[48].setDataType( DBFField.FIELD_TYPE_C);
			    fields[48].setFieldLength(1);
				       
				fields[49] = new DBFField();
			    fields[49].setFieldName("FORM6061J1");
			    fields[49].setDataType( DBFField.FIELD_TYPE_C);
			    fields[49].setFieldLength(1);
				       
				fields[50] = new DBFField();
			    fields[50].setFieldName("FORM6061J2");
			    fields[50].setDataType( DBFField.FIELD_TYPE_C);
			    fields[50].setFieldLength(1);
				       
				fields[51] = new DBFField();
			    fields[51].setFieldName("PAY_MEC");
			    fields[51].setDataType( DBFField.FIELD_TYPE_C);
			    fields[51].setFieldLength(1);
	                   
			    fields[52] = new DBFField();
			    fields[52].setFieldName("RTGS_CD");
			    fields[52].setDataType( DBFField.FIELD_TYPE_C);
			    fields[52].setFieldLength(11);
				       
				fields[53] = new DBFField();
			    fields[53].setFieldName("NEFT_CD");
			    fields[53].setDataType( DBFField.FIELD_TYPE_C);
			    fields[53].setFieldLength(11);
				       
				fields[54] = new DBFField();
			    fields[54].setFieldName("MICR_CD");
			    fields[54].setDataType( DBFField.FIELD_TYPE_C);
			    fields[54].setFieldLength(9);
				       
				fields[55] = new DBFField();
			    fields[55].setFieldName("DEPBANK");
			    fields[55].setDataType( DBFField.FIELD_TYPE_C);
			    fields[55].setFieldLength(60);
				       
				fields[56] = new DBFField();
			    fields[56].setFieldName("DEP_ACNO");
			    fields[56].setDataType( DBFField.FIELD_TYPE_C);
			    fields[56].setFieldLength(50);
	                   
			    fields[57] = new DBFField();
			    fields[57].setFieldName("DEP_DATE");
			    fields[57].setDataType( DBFField.FIELD_TYPE_C);
			    fields[57].setFieldLength(20);
				       
				fields[58] = new DBFField();
			    fields[58].setFieldName("DEP_RFNo");
			    fields[58].setDataType( DBFField.FIELD_TYPE_C);
			    fields[58].setFieldLength(25);
				       
				fields[59] = new DBFField();
			    fields[59].setFieldName("SUB_TRXN_T");
			    fields[59].setDataType( DBFField.FIELD_TYPE_C);
			    fields[59].setFieldLength(6);
				       
				fields[60] = new DBFField();
			    fields[60].setFieldName("SIP_RFNO");
			    fields[60].setDataType( DBFField.FIELD_TYPE_C);
			    fields[60].setFieldLength(8);
				       
				fields[61] = new DBFField();
			    fields[61].setFieldName("SIP_RGDT");
			    fields[61].setDataType( DBFField.FIELD_TYPE_C);
			    fields[61].setFieldLength(20);
	                   
			    fields[62] = new DBFField();
			    fields[62].setFieldName("NOM_NAME");
			    fields[62].setDataType( DBFField.FIELD_TYPE_C);
			    fields[62].setFieldLength(40);
				       
				fields[63] = new DBFField();
			    fields[63].setFieldName("NOM_RELA");
			    fields[63].setDataType( DBFField.FIELD_TYPE_C);
			    fields[63].setFieldLength(40);
				       
				fields[64] = new DBFField();
			    fields[64].setFieldName("KYC_FLG");
			    fields[64].setDataType( DBFField.FIELD_TYPE_C);
			    fields[64].setFieldLength(1);
				       
				fields[65] = new DBFField();
			    fields[65].setFieldName("POA_STAT");
			    fields[65].setDataType( DBFField.FIELD_TYPE_C);
			    fields[65].setFieldLength(1);
				       
				fields[66] = new DBFField();
			    fields[66].setFieldName("MOD_TRXN");
			    fields[66].setDataType( DBFField.FIELD_TYPE_C);
			    fields[66].setFieldLength(1);
	                   
			    fields[67] = new DBFField();
			    fields[67].setFieldName("SIGN_VF");
			    fields[67].setDataType( DBFField.FIELD_TYPE_C);
			    fields[67].setFieldLength(1);
				       
				fields[68] = new DBFField();
			    fields[68].setFieldName("CUST_ID");
			    fields[68].setDataType( DBFField.FIELD_TYPE_C);
			    fields[68].setFieldLength(12);
				       
				fields[69] = new DBFField();
			    fields[69].setFieldName("LOG_WT");
			    fields[69].setDataType( DBFField.FIELD_TYPE_C);
			    fields[69].setFieldLength(70);
				       
				fields[70] = new DBFField();
			    fields[70].setFieldName("LOG_PE");
			    fields[70].setDataType( DBFField.FIELD_TYPE_C);
			    fields[70].setFieldLength(70);
				       
				fields[71] = new DBFField();
			    fields[71].setFieldName("DPID");
			    fields[71].setDataType( DBFField.FIELD_TYPE_C);
			    fields[71].setFieldLength(25);
	                   
			    fields[72] = new DBFField();
			    fields[72].setFieldName("ClientID");
			    fields[72].setDataType( DBFField.FIELD_TYPE_C);
			    fields[72].setFieldLength(25);
				       
				fields[73] = new DBFField();
			    fields[73].setFieldName("NRI_SOF");
			    fields[73].setDataType( DBFField.FIELD_TYPE_C);
			    fields[73].setFieldLength(25);
				       
				fields[74] = new DBFField();
			    fields[74].setFieldName("EUIN");
			    fields[74].setDataType( DBFField.FIELD_TYPE_C);
			    fields[74].setFieldLength(16);
				       
				fields[75] = new DBFField();
			    fields[75].setFieldName("EUIN_OPT");
			    fields[75].setDataType( DBFField.FIELD_TYPE_C);
			    fields[75].setFieldLength(1);
				       
				fields[76] = new DBFField();
			    fields[76].setFieldName("INCSLAB");
			    fields[76].setDataType( DBFField.FIELD_TYPE_C);
			    fields[76].setFieldLength(30);
	                   
			    fields[77] = new DBFField();
			    fields[77].setFieldName("NET_WOR_");
			    fields[77].setDataType( DBFField.FIELD_TYPE_C);
			    fields[77].setFieldLength(25);
				       
				fields[78] = new DBFField();
			    fields[78].setFieldName("NETWOR_DT");
			    fields[78].setDataType( DBFField.FIELD_TYPE_C);
			    fields[78].setFieldLength(8);
				       
				fields[79] = new DBFField();
			    fields[79].setFieldName("INCSLAB_J1");
			    fields[79].setDataType( DBFField.FIELD_TYPE_C);
			    fields[79].setFieldLength(30);
				       
				fields[80] = new DBFField();
			    fields[80].setFieldName("NET_WOR_J1");
			    fields[80].setDataType( DBFField.FIELD_TYPE_C);
			    fields[80].setFieldLength(25);
				       
				fields[81] = new DBFField();
			    fields[81].setFieldName("NETDATE_J1");
			    fields[81].setDataType( DBFField.FIELD_TYPE_C);
			    fields[81].setFieldLength(8);
	                   
			    fields[82] = new DBFField();
			    fields[82].setFieldName("PEP_J1");
			    fields[82].setDataType( DBFField.FIELD_TYPE_C);
			    fields[82].setFieldLength(1);
				       
				fields[83] = new DBFField();
			    fields[83].setFieldName("INCSLAB_J2");
			    fields[83].setDataType( DBFField.FIELD_TYPE_C);
			    fields[83].setFieldLength(30);
				       
				fields[84] = new DBFField();
			    fields[84].setFieldName("NET_WOR_J2");
			    fields[84].setDataType( DBFField.FIELD_TYPE_C);
			    fields[84].setFieldLength(25);
				       
				fields[85] = new DBFField();
			    fields[85].setFieldName("NETDATE_J2");
			    fields[85].setDataType( DBFField.FIELD_TYPE_C);
			    fields[85].setFieldLength(8);
				       
				fields[86] = new DBFField();
			    fields[86].setFieldName("PEP_J2");
			    fields[86].setDataType( DBFField.FIELD_TYPE_C);
			    fields[86].setFieldLength(1);
	                   
			    fields[87] = new DBFField();
			    fields[87].setFieldName("INCSLAB_J3");
			    fields[87].setDataType( DBFField.FIELD_TYPE_C);
			    fields[87].setFieldLength(30);
				       
				fields[88] = new DBFField();
			    fields[88].setFieldName("NET_WOR_J3");
			    fields[88].setDataType( DBFField.FIELD_TYPE_C);
			    fields[88].setFieldLength(25);
				       
				fields[89] = new DBFField();
			    fields[89].setFieldName("NETDATE_J3");
			    fields[89].setDataType( DBFField.FIELD_TYPE_C);
			    fields[89].setFieldLength(8);
				       
				fields[90] = new DBFField();
			    fields[90].setFieldName("PEP_J3");
			    fields[90].setDataType( DBFField.FIELD_TYPE_C);
			    fields[90].setFieldLength(1);
				       
				fields[91] = new DBFField();
			    fields[91].setFieldName("INCSLAB_GR");
			    fields[91].setDataType( DBFField.FIELD_TYPE_C);
			    fields[91].setFieldLength(30);
	                   
			    fields[92] = new DBFField();
			    fields[92].setFieldName("NET_WOR_GR");
			    fields[92].setDataType( DBFField.FIELD_TYPE_C);
			    fields[92].setFieldLength(25);
				       
				fields[93] = new DBFField();
			    fields[93].setFieldName("NETDATE_GR");
			    fields[93].setDataType( DBFField.FIELD_TYPE_C);
			    fields[93].setFieldLength(8);
				       
				fields[94] = new DBFField();
			    fields[94].setFieldName("PEP_GR");
			    fields[94].setDataType( DBFField.FIELD_TYPE_C);
			    fields[94].setFieldLength(1);
				       
				fields[95] = new DBFField();
			    fields[95].setFieldName("Forex_MCS");
			    fields[95].setDataType( DBFField.FIELD_TYPE_C);
			    fields[95].setFieldLength(1);
				       
				fields[96] = new DBFField();
			    fields[96].setFieldName("GAME_GABLE");
			    fields[96].setDataType( DBFField.FIELD_TYPE_C);
			    fields[96].setFieldLength(1);
	                   
			    fields[97] = new DBFField();
			    fields[97].setFieldName("LS_ML_PA");
			    fields[97].setDataType( DBFField.FIELD_TYPE_C);
			    fields[97].setFieldLength(1);
				       
				fields[98] = new DBFField();
			    fields[98].setFieldName("SIP_ST_DT");
			    fields[98].setDataType( DBFField.FIELD_TYPE_C);
			    fields[98].setFieldLength(8);
				       
				fields[99] = new DBFField();
			    fields[99].setFieldName("SIP_END_DT");
			    fields[99].setDataType( DBFField.FIELD_TYPE_C);
			    fields[99].setFieldLength(8);
				       
				fields[100] = new DBFField();
			    fields[100].setFieldName("SIP_FQ");
			    fields[100].setDataType( DBFField.FIELD_TYPE_C);
			    fields[100].setFieldLength(3);
				       
				fields[101] = new DBFField();
			    fields[101].setFieldName("SIP_amt");
			    fields[101].setDataType( DBFField.FIELD_TYPE_C);
			    fields[101].setFieldLength(25);
	                   
			    fields[102] = new DBFField();
			    fields[102].setFieldName("NRI_ADD1");
			    fields[102].setDataType( DBFField.FIELD_TYPE_C);
			    fields[102].setFieldLength(40);
				       
				fields[103] = new DBFField();
			    fields[103].setFieldName("NRI_ADD2");
			    fields[103].setDataType( DBFField.FIELD_TYPE_C);
			    fields[103].setFieldLength(40);
				       
				fields[104] = new DBFField();
			    fields[104].setFieldName("NRI_ADD3");
			    fields[104].setDataType( DBFField.FIELD_TYPE_C);
			    fields[104].setFieldLength(40);
				       
				fields[105] = new DBFField();
			    fields[105].setFieldName("NRI_CITY");
			    fields[105].setDataType( DBFField.FIELD_TYPE_C);
			    fields[105].setFieldLength(35);
				       
				fields[106] = new DBFField();
			    fields[106].setFieldName("NRI_State");
			    fields[106].setDataType( DBFField.FIELD_TYPE_C);
			    fields[106].setFieldLength(35);
	                   
			    fields[107] = new DBFField();
			    fields[107].setFieldName("NRI_CON");
			    fields[107].setDataType( DBFField.FIELD_TYPE_C);
			    fields[107].setFieldLength(35);
				       
				fields[108] = new DBFField();
			    fields[108].setFieldName("NRI_PIN");
			    fields[108].setDataType( DBFField.FIELD_TYPE_C);
			    fields[108].setFieldLength(15);
				       
				fields[109] = new DBFField();
			    fields[109].setFieldName("NOM2_NAME");
			    fields[109].setDataType( DBFField.FIELD_TYPE_C);
			    fields[109].setFieldLength(40);
				       
				fields[110] = new DBFField();
			    fields[110].setFieldName("NOM2_REL");
			    fields[110].setDataType( DBFField.FIELD_TYPE_C);
			    fields[110].setFieldLength(40);
				       
				fields[111] = new DBFField();
			    fields[111].setFieldName("NOM3_NAME");
			    fields[111].setDataType( DBFField.FIELD_TYPE_C);
			    fields[111].setFieldLength(40);
	                    
			    fields[112] = new DBFField();
			    fields[112].setFieldName("NOM3_REL");
			    fields[112].setDataType( DBFField.FIELD_TYPE_C);
			    fields[112].setFieldLength(40);
				        
				fields[113] = new DBFField();
			    fields[113].setFieldName("NOM_PER");
			    fields[113].setDataType( DBFField.FIELD_TYPE_C);
			    fields[113].setFieldLength(3);
				        
				fields[114] = new DBFField();
			    fields[114].setFieldName("NOM2_PER");
			    fields[114].setDataType( DBFField.FIELD_TYPE_C);
			    fields[114].setFieldLength(3);
				        
				fields[115] = new DBFField();
			    fields[115].setFieldName("NOM3_PER");
			    fields[115].setDataType( DBFField.FIELD_TYPE_C);
			    fields[115].setFieldLength(3);
				        
				fields[116] = new DBFField();
			    fields[116].setFieldName("EMP_CODE");
			    fields[116].setDataType( DBFField.FIELD_TYPE_C);
			    fields[116].setFieldLength(10);
	                    
			    fields[117] = new DBFField();
			    fields[117].setFieldName("SUB_ARN");
			    fields[117].setDataType( DBFField.FIELD_TYPE_C);
			    fields[117].setFieldLength(20);
				        
				fields[118] = new DBFField();
			    fields[118].setFieldName("FATCA_FLAG");
			    fields[118].setDataType( DBFField.FIELD_TYPE_C);
			    fields[118].setFieldLength(1);
				        
				fields[119] = new DBFField();
			    fields[119].setFieldName("Dummy1");
			    fields[119].setDataType( DBFField.FIELD_TYPE_C);
			    fields[119].setFieldLength(20);
				        
				fields[120] = new DBFField();
			    fields[120].setFieldName("Dummy2");
			    fields[120].setDataType( DBFField.FIELD_TYPE_C);
			    fields[120].setFieldLength(20);
				        
				fields[121] = new DBFField();
			    fields[121].setFieldName("Dummy3");
			    fields[121].setDataType( DBFField.FIELD_TYPE_C);
			    fields[121].setFieldLength(20);
	                    
			    fields[122] = new DBFField();
			    fields[122].setFieldName("Dummy4");
			    fields[122].setDataType( DBFField.FIELD_TYPE_C);
			    fields[122].setFieldLength(14);
				        
				fields[123] = new DBFField();
			    fields[123].setFieldName("Dummy5");
			    fields[123].setDataType( DBFField.FIELD_TYPE_C);
			    fields[123].setFieldLength(14);
				        
				fields[124] = new DBFField();
			    fields[124].setFieldName("Dummy6");
			    fields[124].setDataType( DBFField.FIELD_TYPE_C);
			    fields[124].setFieldLength(14);
				        
				fields[125] = new DBFField();
			    fields[125].setFieldName("Dummy7");
			    fields[125].setDataType( DBFField.FIELD_TYPE_C);
			    fields[125].setFieldLength(14);
				        
				fields[126] = new DBFField();
			    fields[126].setFieldName("Dummy8");
			    fields[126].setDataType( DBFField.FIELD_TYPE_C);
			    fields[126].setFieldLength(20);
	                    
			    fields[127] = new DBFField();
			    fields[127].setFieldName("Dummy9");
			    fields[127].setDataType( DBFField.FIELD_TYPE_C);
			    fields[127].setFieldLength(20);
				        
				fields[128] = new DBFField();
			    fields[128].setFieldName("Dummy10");
			    fields[128].setDataType( DBFField.FIELD_TYPE_C);
			    fields[128].setFieldLength(20);
				        
				fields[129] = new DBFField();
			    fields[129].setFieldName("Dummy11");
			    fields[129].setDataType( DBFField.FIELD_TYPE_C);
			    fields[129].setFieldLength(20);
	
	
			    
			    DBFWriter writer = new DBFWriter();
			    writer.setFields( fields);
	
			    Properties properties = new Properties();
				String propFilePath = "../../../config/config.properties";
	
				properties.load(KarvyTransactionDbfFileGenerator.class.getResourceAsStream(propFilePath));
				
				System.out.println("BATCH_IMAGE_NUMBER : "+properties.getProperty("BATCH_IMAGE_NUMBER"));
				
	        
	
				
				   			
					
					Object rowData[] = new Object[130];
					
					int i = 1;
					String transactionDetailDate;
					String transactionDate;
					String transactionTime;
					for(TransactionDetails transactionDetail : transactionDetailsList){
						System.out.println("customerId : "+transactionDetail.getCustomerId());
						//session.beginTransaction();
						
						/*query =   session.createQuery("from Customers where customerId = :customerId");
						
						query.setParameter("customerId", transactionDetail.getCustomerId());
						Customers customer = (Customers) query.uniqueResult(); 
						//session.getTransaction().commit();
						System.out.println("gender : "+customer.getGender());*/
						
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
			    		
			    		hibernateSession.beginTransaction();
			    		AdditionalCustomerDetails additionalDetails = (AdditionalCustomerDetails) hibernateSession.get(AdditionalCustomerDetails.class,  transactionDetail.getCustomerId());
			    		hibernateSession.getTransaction().commit();
			    		
			    		hibernateSession.beginTransaction();
						query = hibernateSession.createQuery("from SecondaryFundDetails where fundId = :fundId");
						query.setParameter("fundId", transactionDetail.getFundId());	
						SecondaryFundDetails secondaryFundDetails =  (SecondaryFundDetails) query.uniqueResult();
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						
						query = hibernateSession.createQuery("from BankDetails where customerId = :customerId and updateDate= (select max(updateDate) from BankDetails where customerId= :customerId)");
						query.setParameter("customerId", transactionDetail.getCustomerId());
						BankDetails bankDetails =  (BankDetails) query.uniqueResult();
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						System.out.println("transactionDetailId : "+transactionDetail.getTransactionDetailId());
						query = hibernateSession.createQuery("from SipDetails where transactionDetailId = :transactionDetailId");
						query.setParameter("transactionDetailId", "101");	
						SipDetails sipDetails =  (SipDetails) query.uniqueResult();
						hibernateSession.getTransaction().commit();
						
						Object result;
						hibernateSession.beginTransaction();
						
						String  occuCode;
						query = hibernateSession.createQuery("select karvyCode from RtaSpecificCodes where fieldType = :fieldType and fieldValue = :fieldValue");
						query.setParameter("fieldType", "Occupation");	
						query.setParameter("fieldValue", customerDetail.getOccupation());	
						result =  query.uniqueResult();
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
						query = hibernateSession.createQuery("select karvyCode from RtaSpecificCodes where fieldType = :fieldType and fieldValue = :fieldValue");
						query.setParameter("fieldType", "TaxStatus");	
						query.setParameter("fieldValue", customerDetail.getTaxStatus());	
						result =  query.uniqueResult();
						taxStatus = result.toString();
						
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						
						String  state;
						query = hibernateSession.createQuery("select karvyCode from RtaSpecificCodes where fieldType = :fieldType and fieldValue = :fieldValue");
						query.setParameter("fieldType", "State");	
						query.setParameter("fieldValue", customerDetail.getResidentialState());	
						result = query.uniqueResult();  
						state = result.toString();
						
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						
						String  locationCode;
						query =   hibernateSession.createQuery("select karvyCode from RtaSpecificCodes where fieldType = :fieldType and fieldValue = :fieldValue");
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
						rowData[19] = customer.getMobileNumber(); 
	
						transactionDetailDate = transactionDetail.getTransactionDate();
						transactionDate = transactionDetailDate.substring(5,7)+"/"+transactionDetailDate.substring(8,10)+"/"+transactionDetailDate.substring(0,4);
						transactionTime = transactionDetailDate.substring(11,19);
						
						System.out.println("transactionDate : "+transactionDate);
						System.out.println("transactionTime : "+transactionTime);
						
						rowData[20] = transactionDate; 
						rowData[21] = transactionTime; 
						rowData[22] = ""; 
						rowData[23] = transactionDetail.getTransactionAmount(); 
						rowData[24] = "";
						String dateOfBirth = customerDetail.getDateOfBirth();
						rowData[25] = dateOfBirth.substring(5,7)+"/"+dateOfBirth.substring(8,10)+"/"+dateOfBirth.substring(0,4);
						rowData[26] = null; 
						rowData[27] = customer.getPanCard(); 
						rowData[28] = null; 
						rowData[29] = null; 
						        
						rowData[30] = null; 
						rowData[31] = customer.getEmailId(); 
						rowData[32] = bankDetails.getAccountNumber(); 
						rowData[33] = bankDetails.getAccountType();
						rowData[34] = null; 
						rowData[35] = null; 
						rowData[36] = null; 
						rowData[37] = "Z"; 
						rowData[38] = "SI"; 
						rowData[39] = occuCode; 
						        
						rowData[40] = taxStatus; 
						rowData[41] = null; 
						rowData[42] = state; 
						rowData[43] = null; 
						rowData[44] = null; 
						rowData[45] = null; 
						rowData[46] = locationCode; 
						rowData[47] = null; 
						rowData[48] = null; 
						rowData[49] = null; 
						        
						rowData[50] = null; 
						rowData[51] = "Blank"; 
						rowData[52] = null; 
						rowData[53] = null; 
						rowData[54] = null; 
						rowData[55] = ""; 
						rowData[56] = ""; 
						rowData[57] = transactionDate; 
						rowData[58] = transactionDetail.getTransactionDetailId(); 
						rowData[59] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? "Normal" : "S");
						        
						rowData[60] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? null : transactionDetail.getTransactionDetailId());
						rowData[61] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? null : transactionDate);
						rowData[62] = null; 
						rowData[63] = null; 
						rowData[64] = "Y"; 
						rowData[65] = "Y"; 
						rowData[66] = "W"; 
						rowData[67] = "Y"; 
						rowData[68] = customer.getCustomerId(); 
						rowData[69] = ""; 
						        
						rowData[70] = null; 
						rowData[71] = null; 
						rowData[72] = null; 
						rowData[73] = ""; 
						rowData[74] = null; 
						rowData[75] = "N"; 
						rowData[76] = null; 
						rowData[77] = null; 
						rowData[78] = null; 
						rowData[79] = null; 
						        
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
						rowData[95] = null; 
						rowData[96] = null; 
						rowData[97] = null; 
						rowData[98] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? null : "2017/11/25");
						rowData[99] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? null : "2019/11/25"); 
	
						rowData[100] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? null : "M"); 
						rowData[101] = (("UPFRONT".equalsIgnoreCase(transactionDetail.getTransactionType())) ? null : transactionDetail.getTransactionAmount());
						rowData[102] = (("NonResInd".equals(additionalDetails.getStatus())) ? customerDetail.getAddressLineOne() : null);  
						rowData[103] = (("NonResInd".equals(additionalDetails.getStatus())) ? customerDetail.getAddressLineTwo() : null); 
						rowData[104] = (("NonResInd".equals(additionalDetails.getStatus())) ? customerDetail.getAddressLineThree() : null);
						rowData[105] = (("NonResInd".equals(additionalDetails.getStatus())) ? customerDetail.getResidentialCity() : null);
						rowData[106] = (("NonResInd".equals(additionalDetails.getStatus())) ? customerDetail.getResidentialState() : null);
						rowData[107] = (("NonResInd".equals(additionalDetails.getStatus())) ? customerDetail.getResidentialCountry() : null);
						rowData[108] = (("NonResInd".equals(additionalDetails.getStatus())) ? customerDetail.getResidentialPin() : null);
						rowData[109] = null;
	
						rowData[110] = null;
						rowData[111] = null;
						rowData[112] = null;
						rowData[113] = null;
						rowData[114] = null;
						rowData[115] = null;
						rowData[116] = properties.getProperty("MEMBER_ID"); 
						rowData[117] = null;
						rowData[118] = null; 
						rowData[119] = null;
	
						rowData[120] = null;
						rowData[121] = null;
						rowData[122] = null; 
						rowData[123] = null;
						rowData[124] = null;
						rowData[125] = null;
						rowData[126] = null;
						rowData[127] = null;
						rowData[128] = null;
						rowData[129] = null;
	
					    writer.addRecord( rowData);
	
						rowData = new Object[130];
					    
					}
					
					
					
					String srcDirName = properties.getProperty("SRC_DIR_NAME");
	
				    FileOutputStream fos = new FileOutputStream(srcDirName+"Kyc_Transaction"+frmtdDate+".dbf");
				    writer.write( fos);
				    fos.close();
					
				    hibernateSession.beginTransaction();
				    tempDbfFileStatusDetails = new DbfFileStatusDetails("KARVY", "TRANSACTION",frmtdDate,"N");

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

