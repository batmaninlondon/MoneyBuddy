/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

/**
 *
 * @author ADMIN
 */
public class TestAction {


    public static void main(String args[])  {
        System.out.println(" Hello there teting123 +change from london 2509 + this seems to be working now");
        System.out.println(" added on the night of 26/09 from London by supermanin London");
        System.out.println(" added directly fromt the github.com 123");
        System.out.println(" added from London by Supermaninlonodn on 27/09");
         System.out.println(" added directly at the file from github.com");

         System.out.println(" added locally");

         System.out.println(" added again directly at the file from github.com");
         
         Trading trading = new Trading();
         
        Map<String, Double> productDetailsMapForBUy = new LinkedHashMap<String, Double>();
         productDetailsMapForBUy.put("1", (double)100);
         productDetailsMapForBUy.put("2", (double)200);
         productDetailsMapForBUy.put("3", (double)300);
         
         
        
         
         
  /*       
         Map<String, Double> productDetailsMapForSell = new LinkedHashMap<String, Double>();
         productDetailsMapForSell.put("1", (double)50);
         productDetailsMapForSell.put("2", (double)100);
         productDetailsMapForSell.put("3", (double)150);
         
         trading.executeTrade("12", productDetailsMapForSell, "SELL", "Customer Sold some mutual funds");*/
         
         try {

        	 trading.executeTrade("000012","1000", productDetailsMapForBUy,"NEW","UPFRONT", "BUY", 5,"Y","Customer bought some mutual funds","abc");
         String fromDate = "2016-10-05";
         String toDate = "2016-10-07";
         
         String productId = "2";
        // Double profit = trading.calculateProfit(productId, fromDate, toDate);
        // System.out.println(" Calculted profit for product id "+productId+" from date "+fromDate+" to date "+toDate+" is : "+profit);
         
         
         } catch (MoneyBuddyException e)  {
        	 System.out.println(" Caught exception in TestAction "+e.toString() );
        	 e.printStackTrace();
         } catch (Exception e)  {
        	 System.out.println(" Caught exception in TestAction "+e.toString() );
        	 e.printStackTrace();
         }


    }
}
