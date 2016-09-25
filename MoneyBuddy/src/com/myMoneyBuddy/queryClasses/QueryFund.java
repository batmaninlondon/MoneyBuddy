package com.myMoneyBuddy.queryClasses;

/**
 *
 * @author Savita Wadhwani
 */

import com.myMoneyBuddy.EntityClasses.SaveTaxEquityFund;
import com.myMoneyBuddy.EntityClasses.WealthPlanBondFund;
import com.myMoneyBuddy.EntityClasses.WealthPlanCashFund;
import com.myMoneyBuddy.EntityClasses.WealthPlanEquityFund;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class QueryFund {

    public double getWealthPlanInterestRates(String riskCategory) {
        SessionFactory factory_cash = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(WealthPlanCashFund.class)
                                        .buildSessionFactory();
        Session session_cash = factory_cash.openSession();

        SessionFactory factory_bond = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(WealthPlanBondFund.class)
                                        .buildSessionFactory();
        Session session_bond = factory_bond.openSession();

        SessionFactory factory_equity = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(WealthPlanEquityFund.class)
                                        .buildSessionFactory();
        Session session_equity = factory_equity.openSession();

        double avgInterestRate = 0.0;

        try
        {
            session_cash.beginTransaction();
            Query query = session_cash.createQuery("from WealthPlanCashFund where riskCategory = :riskCategory");
            query.setParameter("riskCategory",riskCategory);
            List<WealthPlanCashFund> cashPlanList = query.list();
            
            System.out.println(" Inside for loop of cash.");
            for(WealthPlanCashFund plan : cashPlanList){
                System.out.println("Cash Fund Name : "+plan.getCashFundName()+"Cash Fund interest rate : "+plan.getCashFundInterestRate()+
                        "Cash Fund percentage : "+plan.getCashFundPercentage());
                avgInterestRate = avgInterestRate+(Double.parseDouble(plan.getCashFundPercentage()) * Double.parseDouble(plan.getCashFundInterestRate()));
            }
            session_cash.getTransaction().commit();

            session_bond.beginTransaction();
            query = session_bond.createQuery("from WealthPlanBondFund where riskCategory = :riskCategory");
            query.setParameter("riskCategory",riskCategory);
            List<WealthPlanBondFund> bondPlanList = query.list();

            System.out.println(" Inside for loop of bond.");
            for(WealthPlanBondFund plan : bondPlanList){
                System.out.println("Bond Fund Name : "+plan.getBondFundName()+"Bond Fund interest rate : "+plan.getBondFundInterestRate()+
                        "Bond Fund percentage : "+plan.getBondFundPercentage());
                avgInterestRate = avgInterestRate+(Double.parseDouble(plan.getBondFundPercentage()) * Double.parseDouble(plan.getBondFundInterestRate()));
            }
            session_bond.getTransaction().commit();

            session_equity.beginTransaction();
            query = session_equity.createQuery("from WealthPlanEquityFund where riskCategory = :riskCategory");
            query.setParameter("riskCategory",riskCategory);
            List<WealthPlanEquityFund> equityPlanList = query.list();

            System.out.println(" Inside for loop of equity.");
            for(WealthPlanEquityFund plan : equityPlanList){
                System.out.println("Equity Fund Name : "+plan.getEquityFundName()+"Equity Fund interest rate : "+plan.getEquityFundInterestRate()+
                        "Equity Fund percentage : "+plan.getEquityFundPercentage());
                avgInterestRate = avgInterestRate+(Double.parseDouble(plan.getEquityFundPercentage()) * Double.parseDouble(plan.getEquityFundInterestRate()));
            }
            session_equity.getTransaction().commit();

            avgInterestRate = avgInterestRate/100;
            return avgInterestRate;
        }
        finally {
            factory_cash.close();
            factory_bond.close();
            factory_equity.close();
        }
        
    }

    public double getSaveTaxPlanInterestRates(String riskCategory) {
        /*
        SessionFactory factory_cash = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(SaveTaxCashFund.class)
                                        .buildSessionFactory();
        Session session_cash = factory_cash.openSession();

        SessionFactory factory_bond = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(SaveTaxBondFund.class)
                                        .buildSessionFactory();
        Session session_bond = factory_bond.openSession();
         
         */

        SessionFactory factory_equity = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(SaveTaxEquityFund.class)
                                        .buildSessionFactory();
        Session session_equity = factory_equity.openSession();

        double avgInterestRate = 0.0;

        try
        {
            Query query;
            /*
            session_cash.beginTransaction();
            query = session_cash.createQuery("from WealthPlanCashFund where riskCategory = :riskCategory");
            query.setParameter("riskCategory",riskCategory);
            List<WealthPlanCashFund> cashPlanList = query.list();

            System.out.println(" Inside for loop of cash.");
            for(WealthPlanCashFund plan : cashPlanList){
                System.out.println("Cash Fund Name : "+plan.getCashFundName()+"Cash Fund interest rate : "+plan.getCashFundInterestRate()+
                        "Cash Fund percentage : "+plan.getCashFundPercentage());
                avgInterestRate = avgInterestRate+(Double.parseDouble(plan.getCashFundPercentage()) * Double.parseDouble(plan.getCashFundInterestRate()));
            }
            session_cash.getTransaction().commit();

            session_bond.beginTransaction();
            query = session_bond.createQuery("from WealthPlanBondFund where riskCategory = :riskCategory");
            query.setParameter("riskCategory",riskCategory);
            List<WealthPlanBondFund> bondPlanList = query.list();

            System.out.println(" Inside for loop of bond.");
            for(WealthPlanBondFund plan : bondPlanList){
                System.out.println("Bond Fund Name : "+plan.getBondFundName()+"Bond Fund interest rate : "+plan.getBondFundInterestRate()+
                        "Bond Fund percentage : "+plan.getBondFundPercentage());
                avgInterestRate = avgInterestRate+(Double.parseDouble(plan.getBondFundPercentage()) * Double.parseDouble(plan.getBondFundInterestRate()));
            }
            session_bond.getTransaction().commit();

             * 
             */
            session_equity.beginTransaction();
            query = session_equity.createQuery("from SaveTaxEquityFund where riskCategory = :riskCategory");
            query.setParameter("riskCategory",riskCategory);
            List<SaveTaxEquityFund> equityPlanList = query.list();

            System.out.println(" Inside for loop of equity.");
            for(SaveTaxEquityFund plan : equityPlanList){
                System.out.println("Equity Fund Name : "+plan.getEquityFundName()+"Equity Fund interest rate : "+plan.getEquityFundInterestRate()+
                        "Equity Fund percentage : "+plan.getEquityFundPercentage());
                avgInterestRate = avgInterestRate+(Double.parseDouble(plan.getEquityFundPercentage()) * Double.parseDouble(plan.getEquityFundInterestRate()));
            }
            session_equity.getTransaction().commit();

            avgInterestRate = avgInterestRate/100;
            return avgInterestRate;
        }
        finally {
            /*
            factory_cash.close();
            factory_bond.close();
             * 
             */
            factory_equity.close();
        }

    }

    public HashMap<String,Double> getFundList(String riskCategory) {
        SessionFactory factory_cash = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(WealthPlanCashFund.class)
                                        .buildSessionFactory();
        Session session_cash = factory_cash.openSession();

        SessionFactory factory_bond = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(WealthPlanBondFund.class)
                                        .buildSessionFactory();
        Session session_bond = factory_bond.openSession();

        SessionFactory factory_equity = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(WealthPlanEquityFund.class)
                                        .buildSessionFactory();
        Session session_equity = factory_equity.openSession();

        try
        {
            session_cash.beginTransaction();
            Query query = session_cash.createQuery("from WealthPlanCashFund where riskCategory = :riskCategory");
            query.setParameter("riskCategory",riskCategory);
            List<WealthPlanCashFund> cashPlanList = query.list();
            HashMap<String,Double> hashMap = new HashMap<String,Double>();

            System.out.println(" Inside for loop of cash.");
            for(WealthPlanCashFund plan : cashPlanList){
                System.out.println("Cash Fund Name : "+plan.getCashFundName()+"Cash Fund interest rate : "+plan.getCashFundInterestRate()+
                        "Cash Fund percentage : "+plan.getCashFundPercentage());
                hashMap.put("Cash-"+plan.getCashFundName(),Double.parseDouble(plan.getCashFundPercentage()));
            }
            session_cash.getTransaction().commit();

            session_bond.beginTransaction();
            query = session_bond.createQuery("from WealthPlanBondFund where riskCategory = :riskCategory");
            query.setParameter("riskCategory",riskCategory);
            List<WealthPlanBondFund> bondPlanList = query.list();

            System.out.println(" Inside for loop of bond.");
            for(WealthPlanBondFund plan : bondPlanList){
                System.out.println("Bond Fund Name : "+plan.getBondFundName()+"Bond Fund interest rate : "+plan.getBondFundInterestRate()+
                        "Bond Fund percentage : "+plan.getBondFundPercentage());
                hashMap.put("Bond-"+plan.getBondFundName(),Double.parseDouble(plan.getBondFundPercentage()));
            }
            session_bond.getTransaction().commit();

            session_equity.beginTransaction();
            query = session_equity.createQuery("from WealthPlanEquityFund where riskCategory = :riskCategory");
            query.setParameter("riskCategory",riskCategory);
            List<WealthPlanEquityFund> equityPlanList = query.list();

            System.out.println(" Inside for loop of equity.");
            for(WealthPlanEquityFund plan : equityPlanList){
                System.out.println("Equity Fund Name : "+plan.getEquityFundName()+"Equity Fund interest rate : "+plan.getEquityFundInterestRate()+
                        "Equity Fund percentage : "+plan.getEquityFundPercentage());
                hashMap.put("Equity-"+plan.getEquityFundName(),Double.parseDouble(plan.getEquityFundPercentage()));
                System.out.println("HI there from QueryFund class 1 . ");
            }
            System.out.println("HI there from QueryFund class 2 . ");
            session_equity.getTransaction().commit();
            System.out.println("HI there from QueryFund class 3 . ");

            int i =0 ;
            System.out.println("HI there from QueryFund class 4 . ");
            System.out.println("Inside QueryFund class . ");
            for (String key : hashMap.keySet()) {
                //dataSet.setValue(key, hashMap.get(key));
                //ringplot.setSectionPaint(key, Color.decode(colorList.get(i)));
            System.out.println(" Hi there : "+i+"key : "+key+" value : "+hashMap.get(key));
                i++;
         }
            System.out.println("HI there from QueryFund class 5 . ");
            return hashMap;
        }
        finally {
            factory_cash.close();
            factory_bond.close();
            factory_equity.close();
        }

    }


}
