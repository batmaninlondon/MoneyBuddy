/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

/**
 *
 * @author ADMIN
 */
import com.myMoneyBuddy.queryClasses.QueryFund;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.Action;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.util.Rotation;

public class JfreeChartAction implements Action {

    private String riskCategory;
    private JFreeChart chart;

     public String execute() throws Exception {

        System.out.println(" Value of riskCategory in JFreeChart class  : "+getRiskCategory());
        QueryFund queryFund = new QueryFund();
        HashMap<String,Double> hashMap = queryFund.getFundList(getRiskCategory());
        DefaultPieDataset dataSet = new DefaultPieDataset();
        RingPlot ringplot;
        List<String> colorList = new ArrayList<String>();
        colorList.add("#008080");
        colorList.add("#20B2AA");
        colorList.add("#00CED1");
        colorList.add("#40E0D0");
        colorList.add("#7FFFD4");

        for (String key : hashMap.keySet()) {
            dataSet.setValue(key, hashMap.get(key));
         }
        chart = ChartFactory.createRingChart("Investment Type", dataSet, false, true, false);

        ringplot = (RingPlot)chart.getPlot();
        ringplot.setLabelFont(new Font("SansSerif", 0, 12));
        ringplot.setNoDataMessage("No data available");
        ringplot.setSectionDepth(0.4D);
        ringplot.setCenterText("Ring Chart");
        ringplot.setIgnoreZeroValues(true);
        ringplot.setInnerSeparatorExtension(.02);
        ringplot.setShadowXOffset(10.0);
        ringplot.setLabelGap(0.02D);
        chart.setBackgroundPaint(Color.white);
        ringplot.setBackgroundPaint(Color.white);

        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ringplot.setLabelGenerator(gen);

         int i=0;
        for (String key : hashMap.keySet()) {
            ringplot.setSectionPaint(key, Color.decode(colorList.get(i)));
            i++;
         }
        return SUCCESS;
        }

     // This method will get called if we specify <param name="value">chart</param>
     public JFreeChart getChart() {
        return chart;
     }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }


}
