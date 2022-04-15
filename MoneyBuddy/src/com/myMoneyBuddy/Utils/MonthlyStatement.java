package com.myMoneyBuddy.Utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.myMoneyBuddy.DAOClasses.CalculateTaxRecords;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ModelClasses.PortfolioDataModel;

public class MonthlyStatement {

	private static Font largeBold = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD | Font.UNDERLINE);
	private static Font mediumBold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD );
	private static Font medium = new Font(Font.FontFamily.TIMES_ROMAN, 14);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 12);
	private static Font smallBlueUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL  | Font.UNDERLINE, BaseColor.BLUE);
	private static Font verySmall = new Font(Font.FontFamily.TIMES_ROMAN, 10);
	private static Font verySmallUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 10,  Font.UNDERLINE);
	private static Font tiny6 = new Font(Font.FontFamily.TIMES_ROMAN, 6);
	private static Font tiny2 = new Font(Font.FontFamily.TIMES_ROMAN, 2);
	
	public static void main(String... args) throws Exception {

		
		
		
		System.out.println(" Called MonthlyStatement main method");
		
		CalculateTaxRecords calculateTaxRecords = new CalculateTaxRecords();
		List<String> customerIdList = calculateTaxRecords.getAllInvestorCustomerIds();
		

		for (String customerId : customerIdList)  {
	      
			String customerName;
			String profitDir;
			String profitValue = "";
			String totalRateOfGrowth = "";
			String totalCurrentAmount = "";
			String totalProfitAmount = "";
			boolean showRateOfGrowth = false;
			boolean showTotalRateOfGrowth = false;
			List<PortfolioDataModel> portfolioDataModel;
			
		/*String customerId = "205";*/
		
		QueryCustomer queryCustomer = new QueryCustomer(); 
		Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
		
		customerName = customer.getCustomerName();
		
		QueryProducts queryProducts = new QueryProducts();

		portfolioDataModel = queryProducts.getPortfolioData(customerId);
		
		
		
		PortfolioDataModel portfolioDataModelTotalElement = portfolioDataModel.get(portfolioDataModel.size()-1);
		if ("Total".equals(portfolioDataModelTotalElement.getSchemeName())) {
			totalCurrentAmount = portfolioDataModelTotalElement.getCurrentAmount();
			totalRateOfGrowth = portfolioDataModelTotalElement.getRateOfGrowth();
			totalProfitAmount = portfolioDataModelTotalElement.getProfit();
			
		}
		
		NumberFormat myFormat = NumberFormat.getIntegerInstance();
        myFormat.setGroupingUsed(true);
		
		if (! "0".equalsIgnoreCase(myFormat.format((int)Double.parseDouble(totalCurrentAmount))))  {
			
			for (PortfolioDataModel portfolioDataModelElement : portfolioDataModel) {
				System.out.println(" HELLO : value of Rate of Growth :  "+portfolioDataModelElement.getRateOfGrowth());
				if ( !"NA".equalsIgnoreCase(portfolioDataModelElement.getRateOfGrowth())) { 
					showRateOfGrowth = true;
					System.out.println(" HELLO : showRateOfGrowth has been changed to true  ");
				}
			}
			System.out.println(" HELLO : showRateOfGrowth after for loop is : "+showRateOfGrowth);

		if ( !"NA".equalsIgnoreCase(totalRateOfGrowth))
			showTotalRateOfGrowth = true;
		if (Double.valueOf(totalProfitAmount) < 0)  
			profitDir = "down";
		else 
			profitDir = "up";
		
		profitValue = totalProfitAmount;
		
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:/Pdfs/AccountStatements/"+customerId+"_"+customerName+"_AccountStament.pdf"));
		} catch (FileNotFoundException | DocumentException e1) {
			e1.printStackTrace();
		}
		document.open();

		Paragraph preface = new Paragraph();
		
		Paragraph header = new Paragraph("MoneyBuddy, Advisory by: Kamal Wadhwani", largeBold);
		header.setAlignment(Element.ALIGN_CENTER);
		preface.add(header);
		
		header = new Paragraph("( SEBI RIA: INA000013581 )", mediumBold);
		header.setAlignment(Element.ALIGN_CENTER);
		preface.add(header);
		
		
		Chunk glue = new Chunk(new VerticalPositionMark());
	    //PdfPTable table = new PdfPTable(1);
	    Phrase p = new Phrase();
		Paragraph leftText = new Paragraph("Email: Kamal.Wadhwani@gmail.com",verySmall);
		p.add(leftText);
		p.add(glue);
		Paragraph rightText = new Paragraph("Phone: +91-9971648736",verySmall);
		p.add(rightText);
		
		preface.add(p);
		
	    /*table.addCell(p);
	    preface.add(table);*/
	    
	    /*
		header = new Paragraph("Phone: +91-9971648736", verySmall);
		header.setAlignment(Element.ALIGN_LEFT);
		preface.add(header);*/
		
		/*header = new Paragraph("", verySmall);
		header.setAlignment(Element.ALIGN_RIGHT);
		
		preface.add(header);*/
		
		Paragraph thin2Line = new Paragraph(" ",tiny2);
		preface.add(thin2Line);
		
		preface.add(new LineSeparator());    
		
		Paragraph thin6Line = new Paragraph(" ",tiny6);
		preface.add(thin6Line);
		//addEmptyLine(preface, 1);
		Paragraph title = new Paragraph("Account statement of " + customerName, subFont);
		title.setAlignment(Element.ALIGN_CENTER);
		preface.add(title);
		
		preface.add(thin6Line);
		//addEmptyLine(preface, 1);
		
		Chapter catPart = new Chapter(new Paragraph(""), 0);
		catPart.setNumberDepth(0);
		
		Paragraph parag = new Paragraph("Given below is a quick summary of your investment with us as on "+getTodayDate(), small);
		
		parag.setAlignment(Element.ALIGN_CENTER);
		preface.add(parag);
		
		addEmptyLine(preface, 1);
		
		
		catPart.add(preface);

		createTable(catPart, portfolioDataModel, totalCurrentAmount, profitDir, profitValue, totalRateOfGrowth,showRateOfGrowth,showTotalRateOfGrowth);
		
		//addEmptyLine(preface, 2);
		
		//catPart.add(preface);
		Paragraph prefaceNew  = new Paragraph();
		addEmptyLine(prefaceNew, 2);
		Paragraph p1  = new Paragraph();
		
		p1.add(new Chunk("Please reach us at ", small));
		p1.add(new Chunk("kamal.wadhwani@gmail.com ", smallBlueUnderline));
		p1.add(new Chunk("/ 9971648736 for any query ", small));
		p1.setAlignment(Element.ALIGN_CENTER);
		prefaceNew.add(p1);
		
		catPart.add(prefaceNew);

		/*preface = new Paragraph("kamal.wadhwani@gmail.com ", smallBlue);
		preface.setAlignment(Element.ALIGN_CENTER);
		catPart.add(preface);
		
		preface = new Paragraph("/ 9971648736 for any query ", small);
		preface.setAlignment(Element.ALIGN_CENTER);
		catPart.add(preface);*/
		
		//addEmptyLine(preface, 1);
		
		/*Paragraph summary = (new Paragraph("Current Value of your investments :   " + totalCurrentAmount + " Rs.", medium));
		summary.setAlignment(Element.ALIGN_CENTER);
		preface.add(summary);
		addEmptyLine(preface, 1);
		if ("up".equalsIgnoreCase(profitDir))
			summary = (new Paragraph("Your Investments are up by :   " + profitValue + " Rs.", medium));
		else
			summary = (new Paragraph("Your Investments are down by :   " + profitValue.substring(1) + " Rs.", medium));
		summary.setAlignment(Element.ALIGN_CENTER);
		preface.add(summary);
		addEmptyLine(preface, 1);
		
		summary = (new Paragraph("Your Investments have grown at a rate of :   " + totalRateOfGrowth, medium));
		
		summary.setAlignment(Element.ALIGN_CENTER);
		preface.add(summary);*/
		//addEmptyLine(preface, 1);
		
		/*preface.add(new LineSeparator()); */   
		
		/*Paragraph footer = new Paragraph("Please reach us at kamal.wadhwani@gmail.com / 9971648736 for any query " , small);
		footer.setAlignment(Element.ALIGN_CENTER);
		preface.add(footer);*/
		
		

		try {
			document.add(catPart);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		document.close();
		}

		}
		System.out.println(" END !! ");

	}
	
	private static String getTodayDate()  {
		
		Date dateNow = new Date( );
		SimpleDateFormat dateFormat = 
		new SimpleDateFormat ("dd MMM yyyy");
		
		String todayDate = dateFormat.format(dateNow);
		
		int date = Integer.parseInt(todayDate.substring(0,2));
			    
		switch (date) {
        case 1:
        case 21:
        case 31:
            return "" + date +  "st"+todayDate.substring(2);

        case 2:
        case 22:
            return "" + date + "nd"+todayDate.substring(2);

        case 3:
        case 23:
            return "" + date + "rd"+todayDate.substring(2);

        default:
            return "" + date + "th"+todayDate.substring(2);
		}
	}

	private static void createTable(Section subCatPart, List<PortfolioDataModel> portfolioDataModelList, String totalCurrentAmount, String profitDir,
			String profitValue, String totalRateOfGrowth, boolean showRateOfGrowth, boolean showTotalRateOfGrowth)
			throws BadElementException {
		
		PdfPTable table;
		if (showRateOfGrowth)
			table = new PdfPTable(new float[] { 1, 10, 4, 4, 4, 3});
		else 
			table = new PdfPTable(new float[] { 1, 10, 4, 4, 4});
		table.setWidthPercentage(100);
		
		PdfPCell c1 = new PdfPCell(new Phrase("Sl.", mediumBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Fund Name", mediumBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Folio", mediumBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Investment", mediumBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Current", mediumBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);
		
		if (showRateOfGrowth)  {
			c1 = new PdfPCell(new Phrase("Growth", mediumBold));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setBackgroundColor(new BaseColor(164, 194, 244));
			table.addCell(c1);
		}
		
		table.setHeaderRows(1);

		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);

		int i = 1;
		NumberFormat myFormat = NumberFormat.getIntegerInstance();
        myFormat.setGroupingUsed(true);
        
		for (int j = 0; j < portfolioDataModelList.size(); j++) {

			if ( i == portfolioDataModelList.size())  
				c1 = new PdfPCell(new Phrase("", small));
			else
				c1 = new PdfPCell(new Phrase(Integer.toString(i++), small));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			if (portfolioDataModelList.get(j).getSchemeName() == null) {
				c1 = new PdfPCell(new Phrase("", small));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase(portfolioDataModelList.get(j).getSchemeName(), small));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			}
			if (portfolioDataModelList.get(j).getFolioNumber() == null) {
				c1 = new PdfPCell(new Phrase("", small));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase(portfolioDataModelList.get(j).getFolioNumber().toString(), small));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			}
			if (portfolioDataModelList.get(j).getInvestedAmount() == null) {
				c1 = new PdfPCell(new Phrase("", small));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			} else {				
				c1 = new PdfPCell(new Phrase(myFormat.format((int)Double.parseDouble(portfolioDataModelList.get(j).getInvestedAmount())), small));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			}
			if (portfolioDataModelList.get(j).getCurrentAmount() == null) {
				c1 = new PdfPCell(new Phrase("", small));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase(myFormat.format((int)Double.parseDouble(portfolioDataModelList.get(j).getCurrentAmount())), small));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			}
			if (showRateOfGrowth) 
				if (portfolioDataModelList.get(j).getRateOfGrowth() == null) {
					c1 = new PdfPCell(new Phrase("", small));
					c1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(c1);
				} else {
					c1 = new PdfPCell(new Phrase(portfolioDataModelList.get(j).getRateOfGrowth().toString(), small));
					c1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(c1);
				}
			
		}
		
		
		
		Paragraph p1 = new Paragraph();
		
		Paragraph summary = (new Paragraph("\nTotal Portfolio value : ", medium));
		summary.setAlignment(Element.ALIGN_CENTER);
		p1.add(summary);
		
		summary = (new Paragraph("Rs. " +myFormat.format((int)Double.parseDouble(totalCurrentAmount)) + " \n\n", medium));
		summary.setAlignment(Element.ALIGN_CENTER);
		p1.add(summary);
		
		if ("up".equalsIgnoreCase(profitDir))  {
			summary = (new Paragraph("Portfolio is up by : ", medium));
			summary.setAlignment(Element.ALIGN_CENTER);
			p1.add(summary);
			
			summary = (new Paragraph("Rs. " + myFormat.format((int)Double.parseDouble(profitValue)) + " \n\n", medium));
			summary.setAlignment(Element.ALIGN_CENTER);
			p1.add(summary);
		}
		else   {
			summary = (new Paragraph("Portfolio is down by : ", medium));
			summary.setAlignment(Element.ALIGN_CENTER);
			p1.add(summary);
			
			summary = (new Paragraph("Rs. " + myFormat.format((int)Double.parseDouble(profitValue.substring(1))) + " \n\n", medium));
			summary.setAlignment(Element.ALIGN_CENTER);
			p1.add(summary);
		}
		
		
		
		if (showTotalRateOfGrowth)  {
			summary = (new Paragraph("Portfolio growth rate : ", medium));
			
			summary.setAlignment(Element.ALIGN_CENTER);
			p1.add(summary);
			
			summary = (new Paragraph(totalRateOfGrowth+" \n\n\n", medium));
			
			summary.setAlignment(Element.ALIGN_CENTER);
			p1.add(summary);
		}
		
		PdfPCell totalCell = new PdfPCell(new Phrase(p1));
		totalCell.setColspan(6);

		totalCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(totalCell);
		
		
		subCatPart.add(table);

	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
