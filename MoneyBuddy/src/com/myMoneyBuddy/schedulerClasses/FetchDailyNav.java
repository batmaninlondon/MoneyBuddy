package com.myMoneyBuddy.schedulerClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.DAOClasses.QuerySecondaryFundDetails;
import com.myMoneyBuddy.EntityClasses.NavHistory;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class FetchDailyNav implements org.quartz.Job {
	
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {
		
		try {
    		
    		System.out.println("FetchDailyNav CLASS EXECUTION -------  START");

			String output  = getUrlContents("https://www.amfiindia.com/spages/NAVAll.txt?t=09102018051155");
			
			System.out.println("FetchDailyNav CLASS EXECUTION -------  END");

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
	        String isin="";
	        
	        QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
	        
	        HashMap<String,String> schemeCodesAndFundIds = querySecondaryFundDetails.allSchemeCodesAndFundIds();
	        
	        
	      while (( fundData = bufferedReader.readLine()) != null)
	      {
	    	  
	    	  String[] dataSpilts = fundData.split("\\;");
	    	  
	            if ( dataSpilts.length == 6 )  {
		            isin = dataSpilts[1];
		            navValue = dataSpilts[4];
		            navDate = dataSpilts[5];

		            Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		            Query query = null;
		            try {
		            	
		            	if (schemeCodesAndFundIds.containsKey(isin))  {
		            		
		            		 Date dNow = new Date();
		            		  
		            		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        			
		        			String frmtdDate = dateFormat.format(dNow);
		        			
			            	hibernateSession.beginTransaction();
			    			
			    			NavHistory tempNavHistory = new NavHistory(frmtdDate,navValue,schemeCodesAndFundIds.get(isin));
			
			    			hibernateSession.save(tempNavHistory);
			
			    			hibernateSession.getTransaction().commit();
		            	}
			    			
		            }
		            
		            
		            catch (Exception e) {	
		    			e.printStackTrace();
		
		    		} 
		            finally {
		    			if(hibernateSession !=null )
		    					hibernateSession.close();
		    		}
	            }
	      }
	      bufferedReader.close();
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    return content.toString();
	  }

    }