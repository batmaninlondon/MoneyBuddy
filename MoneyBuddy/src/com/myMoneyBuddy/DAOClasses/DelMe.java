package com.myMoneyBuddy.DAOClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DelMe {

	public static final double tol = 0.001;  
	
	public static void main(String[] args) {
		
		List<Double> amounts = new ArrayList<Double>();
	     List<Date> dates = new ArrayList<Date>();
	     
		 Double testAmt = 5000.0;
	     amounts.add(testAmt);
	     dates.add(strToDate("20/01/2018"));
	     
	     testAmt = 6000.0;
	     amounts.add(testAmt);
	     dates.add(strToDate("20/02/2018"));
	     
	     testAmt = -7000.0;
	     amounts.add(testAmt);
	     dates.add(strToDate("20/03/2018"));
	     
	     testAmt = 3500.0;
	     amounts.add(testAmt*-1);
	     dates.add(strToDate("04/05/2018"));
	     
	     
         
	     Double xirr = Newtons_method(0.1, amounts, dates);
	     xirr = xirr*100;
	     System.out.println("XIRR : "+ String.format("%.2f", xirr));
	     

	}
	
	
	public static double dateDiff(Date d1, Date d2){
	    long day = 24*60*60*1000;
	
	    return (d1.getTime() - d2.getTime())/day;
	}
	
	public static double f_xirr(double p, Date dt, Date dt0, double x) {        
	    return p * Math.pow((1.0 + x), (dateDiff(dt0,dt) / 365.0));
	}
	
	public static double df_xirr(double p, Date dt, Date dt0, double x) {        
	    return (1.0 / 365.0) * dateDiff(dt0,dt) * p * Math.pow((x + 1.0), ((dateDiff(dt0,dt) / 365.0) - 1.0));
	}
	
	public static double total_f_xirr(List<Double> payments, List<Date> dates, double x) {
	    double resf = 0.0;
	
	    for (int i = 0; i < payments.size(); i++) {
	        resf = resf + f_xirr(payments.get(i), dates.get(i), dates.get(0), x);
	    }
	
	    return resf;
	}
	
	public static double total_df_xirr(List<Double> payments, List<Date> dates, double x) {
	    double resf = 0.0;
	
	    for (int i = 0; i < payments.size(); i++) {
	        resf = resf + df_xirr(payments.get(i), dates.get(i), dates.get(0), x);
	    }
	
	    return resf;
	}
	
	public static double Newtons_method(double guess, List<Double> payments, List<Date> dates) {
	    double x0 = guess;
	    double x1 = 0.0;
	    double err = 1e+100;
	
	    while (err > tol) {
	        x1 = x0 - total_f_xirr(payments, dates, x0) / total_df_xirr(payments, dates, x0);
	        err = Math.abs(x1 - x0);
	        x0 = x1;
	    }
	
	    return x0;
	}	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static Date strToDate(String str){
	    try {
	        return sdf.parse(str);
	    } catch (ParseException ex) {
	        return null;
	    }
	}
	

}
