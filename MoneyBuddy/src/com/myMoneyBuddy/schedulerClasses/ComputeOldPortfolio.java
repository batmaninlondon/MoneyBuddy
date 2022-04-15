package com.myMoneyBuddy.schedulerClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.DAOClasses.QueryOldPortfolioRecords;
import com.myMoneyBuddy.EntityClasses.OldPortfolioRecords;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class ComputeOldPortfolio implements org.quartz.Job {
	
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {
		
		try {
    		
    		System.out.println("ComputeOldPortfolio CLASS EXECUTION -------  START");

			String output  = getUrlContents("https://www.amfiindia.com/spages/NAVAll.txt?t=09102018051155");
			
			System.out.println("ComputeOldPortfolio CLASS EXECUTION -------  END");

        }
		
        catch (Exception e){
        	e.printStackTrace(); 
        } 

	}
	
	
	private static String getUrlContents(String theUrl)
	  {
	    StringBuilder content = new StringBuilder();

	    // many of these calls can throw exceptions, so i've just
	    // wrapped them all in one try/catch statement.
	    Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	    try
	    {
	      // create a url object
	      URL url = new URL(theUrl);

	      // create a urlconnection object
	      URLConnection urlConnection = url.openConnection();

	      // wrap the urlconnection in a bufferedreader
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	      String fundData;

	      // read from the urlconnection via the bufferedreader
	      
	      String navDate="";
	        String navValue="";
	        /*String isin="";*/
	        
	        QueryOldPortfolioRecords queryOldPortfolioRecords = new QueryOldPortfolioRecords();
	        
	        List<String> allIsin = queryOldPortfolioRecords.fetchAllIsin();
	        	        
	        
	      while (( fundData = bufferedReader.readLine()) != null)
	      {
	    	  
	    	  String[] dataSpilts = fundData.split("\\;");
	    	  
	            if ( dataSpilts.length == 6 )  {
	            	
	            		String isin = dataSpilts[1];
			            navValue = dataSpilts[4];
			            navDate = dataSpilts[5];
	
			            
			            Query query = null;
		            
		            	
		            	if (allIsin.stream().anyMatch(str -> str.trim().equals(isin)))  {
		            		
		            		 Date dNow = new Date();
		            		  
		            		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        			
		        			String frmtdDate = dateFormat.format(dNow);
		        			
		        			hibernateSession.beginTransaction();
		        			
		        			query = hibernateSession.createQuery("from OldPortfolioRecords where isin = :isin ");
		        			query.setParameter("isin", isin);
		        			hibernateSession.getTransaction().commit();
		        			List<OldPortfolioRecords> oldPortfolioRecordsList = query.list();
		        			
		        			Double currentValue = 0.0;
		        			Double profit = 0.0;
		        			
		        			for (int i = 0; i < oldPortfolioRecordsList.size(); i++) {
		        				OldPortfolioRecords element = oldPortfolioRecordsList.get(i);
		        				
		        				
		        				currentValue = Double.parseDouble(element.getUnits()) * Double.parseDouble(navValue);
		        				
		        				
		        				profit = currentValue - Double.parseDouble(element.getInvestedValue());
		        				
		        				System.out.println("UNITS : "+element.getUnits()+" : NAV : "+navValue+" : currentValue : "+currentValue+" profit : "+profit);
		        				
		        				hibernateSession.beginTransaction();
		        				query = hibernateSession.createQuery("update OldPortfolioRecords set currentValue = :currentValue , profit = :profit, currentNav = :currentNav  "
		        						+ " where oldPortfolioRecordsId = :oldPortfolioRecordsId");

		        				query.setParameter("currentValue", String.format("%.2f", currentValue) );
		        				query.setParameter("profit", String.format("%.2f", profit) );
		        				query.setParameter("currentNav", navValue);
		        				query.setParameter("oldPortfolioRecordsId", element.getOldPortfolioRecordsId());

		        				int result = query.executeUpdate();
		        				hibernateSession.getTransaction().commit();
		        				
		        			}
		            	}
			    	
	            }
	      }
	      bufferedReader.close();
	    }
		
      
      
      catch (Exception e) {	
			e.printStackTrace();

		} 
      finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	    return content.toString();
	  }

    }