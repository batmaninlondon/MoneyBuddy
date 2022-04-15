/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.ModelClasses.InvestmentDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.TaxRecordsDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class TaxRecordsDataAction extends ActionSupport implements SessionAware{
	
	Logger logger = LogManager.getLogger(TaxRecordsDataAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel;


	public String execute()   {
		System.out.println(" Called TaxRecordsDataAction execute method");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		String customerId = sessionMap.get("customerId").toString();
		
		try {
			
			
			hibernateSession.beginTransaction();
			
			Query taxData = hibernateSession.createQuery("select  quantity,unitPrice, transactionDate,fundId,transactionFolioNum,buySell, "
					+ " if(transactionDate > curdate() - interval 1 month, 'SHORT', 'LONG') "
					+ " from TransactionDetails where transactionStatus='8' and customerId= :customerId and quantity is not null and unitPrice is not null "
					+ " and fundId = :fundId and transactionFolioNum = :transactionFolioNum "
					+ " and fundId in (select fundId from PrimaryFundDetails where schemeType = :schemeType ) order by fundId,transactionFolioNum");
			
			taxData.setParameter("customerId","201");
			taxData.setParameter("fundId","60");
			taxData.setParameter("transactionFolioNum","91062653742");
			taxData.setParameter("schemeType","DEBT");
			
			hibernateSession.getTransaction().commit();
			

			List<TaxRecordsDataModel> taxRecordsDataList = new LinkedList<TaxRecordsDataModel>();
			
			int i =1;
			for (Iterator taxDataIt=taxData.iterate(); taxDataIt.hasNext();)  {
		
				Object[] taxDataRow = (Object[]) taxDataIt.next();
				/*String pnlLong="0";
				String pnlShort="0";
				if ( ("LONG").equals(taxDataRow[6].toString()) ) {
					pnlLong="LONG";
				}
				else {
					pnlShort="SHORT";
				}*/
				
				if ( ("SELL").equals(taxDataRow[5].toString()) ) {
					taxRecordsDataList.add(new TaxRecordsDataModel(i,taxDataRow[2].toString(),Double.parseDouble(taxDataRow[1].toString()),
							Double.parseDouble(taxDataRow[0].toString()),"",0.0,0.0,"NA","NA"));
				}
			}
			int currentSize = taxRecordsDataList.size();
			
			System.out.println("currentSize : "+currentSize);
			
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}

	public List<InvestmentDetailsDataModel> getAllFundsInvestmentDetailsDataModel() {
		return allFundsInvestmentDetailsDataModel;
	}


	public void setAllFundsInvestmentDetailsDataModel(List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel) {
		this.allFundsInvestmentDetailsDataModel = allFundsInvestmentDetailsDataModel;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}
