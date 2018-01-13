/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.EntityClasses.FundDetails;
import com.myMoneyBuddy.EntityClasses.NavHistory;
import com.myMoneyBuddy.EntityClasses.ProductDetails;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
/*import com.myMoneyBuddy.EntityClasses.PriceHistory;*/
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.DashboardDataModel;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.InvestmentDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.PortfolioDataModel;
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



public class QueryFundDetails {
	
	Logger logger = Logger.getLogger(QueryFundDetails.class);
	
	
	public List<FundDetailsDataModel> getFundDetailsData() throws MoneyBuddyException {
		
		Session session  = null;
	       
		try
		{
			logger.debug("QueryFundDetails class : getFundDetailsData method : start");
			
			session = HibernateUtil.getSessionAnnotationFactory().openSession();
		
			session.beginTransaction();

			List<FundDetailsDataModel> fundDetailsDataModel = new LinkedList<FundDetailsDataModel>();

			Query query = session.createQuery("from FundDetails");

			
			List<FundDetails> fundDetailsList = query.list();

			for (FundDetails fundDetailsListElement : fundDetailsList)  {
				
				fundDetailsDataModel.add(new FundDetailsDataModel(fundDetailsListElement.getFundId(),fundDetailsListElement.getFundName(),fundDetailsListElement.getSector(),
						fundDetailsListElement.getSubSector(),fundDetailsListElement.getFundStartDate(),fundDetailsListElement.getRating(),fundDetailsListElement.getRisk(),
						fundDetailsListElement.getReturnsThreeYears(),fundDetailsListElement.getMinSipAmount(),fundDetailsListElement.getMinLumsumAmount(),
						fundDetailsListElement.getMinSipDuration()));
			}

			//session.getTransaction().commit();

			logger.debug("QueryFundDetails class : getFundDetailsData method : end");
			
			return fundDetailsDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryFundDetails class : getFundDetailsData method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryFundDetails class : getFundDetailsData method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryFundDetails class : getFundDetailsData method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();

		}

	}
	
}
