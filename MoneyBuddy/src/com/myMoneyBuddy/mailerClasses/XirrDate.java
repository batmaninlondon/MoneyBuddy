package com.myMoneyBuddy.mailerClasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XirrDate {

    public static final double tol = 0.001;    

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
           System.out.println("sdf.parse(str) : "+sdf.parse(str));
        	return sdf.parse(str);
            
        } catch (ParseException ex) {
            return null;
        }
    }

    public static void main(String... args) throws ParseException {
    	List<Double> list = new ArrayList<Double>();
    	list.add(-2598.4886);
    	list.add(-120.0);
    	list.add(-126.0);
    	list.add(100.0);
    	list.add(64.0);
    	list.add(3900.0);
    	
    	List<Date> dates = new ArrayList<Date>();
    	dates.add(strToDate("13/12/2017"));
    	dates.add(strToDate("15/01/2017"));
    	dates.add(strToDate("20/01/2017"));
    	dates.add(strToDate("01/01/2017"));
    	dates.add(strToDate("10/01/2017"));
    	dates.add(strToDate("15/01/2017"));
    	
    	/*DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate ld = LocalDate.parse("2017-01-15", DATEFORMATTER);
    	System.out.println("ld : "+ld);*/
    	
    	
    	String start_dt = "2017-01-15";
    	DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD"); 
    	Date date = (Date)formatter.parse(start_dt);
    	SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
    	String finalString = newFormat.format(date);
    	System.out.println("finalString : "+finalString);
    	
    	System.out.println("Date :    "+strToDate("15/01/2017"));
    	
    	
    	/*String oldstring = "2017-01-15";
        LocalDate datetime = LocalDate.parse(oldstring, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
        System.out.println("datetime : "+datetime);*/
        double[] payments = {-1151250,232912,233123,233336,233551,233768}; // payments
        Date[] days = {strToDate("15/01/2017"),strToDate("25/11/2015"),strToDate("25/12/2015"),strToDate("25/01/2016"),strToDate("25/02/2016"),strToDate("25/03/2016")}; // days of payment (as day of year)
        double xirr = Newtons_method(0.1, list, dates);

        System.out.println("XIRR value is " + xirr);    
    }
	
}
