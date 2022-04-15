package com.myMoneyBuddy.Utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
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
import com.myMoneyBuddy.DAOClasses.CalculateTaxRecords;
/*import com.itextpdf.text.List;*/
import com.myMoneyBuddy.ModelClasses.TaxRecordsDataModel;

public class CapitalGainStatement {

	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE);

	private static Font smallBoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 12);
	private static Font verySmallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
	private static Font verySmall = new Font(Font.FontFamily.TIMES_ROMAN, 10);

	public static void main(String... args) throws Exception {

		System.out.println(" Called TaxRecordsDataAction main method");

		// To generate the capital gain statements of some other year or some other dates, 
		// one will have to change following start and end dates 
		String startDate = "2020-04-01";
		String endDate = "2020-08-07";
		List<String> schemeTypeList = Arrays.asList(new String[] { "EQUITY", "DEBT" });
		DecimalFormat df = new DecimalFormat("###.###");

		CalculateTaxRecords calculateTaxRecords = new CalculateTaxRecords();

		List<String> customerIdList = calculateTaxRecords.getInvestorCustomerIds(startDate,endDate);

		customerIdList.forEach((customerId) -> {
		
		/*String customerId = "204";*/

			String customerName = calculateTaxRecords.getCustomerName(customerId);
			Document document = new Document();
			try {
				PdfWriter.getInstance(document, new FileOutputStream("c:/Pdfs/CapitalGainStatements/"+customerId+"_"+customerName+"_CapitalGain.pdf"));
			} catch (FileNotFoundException | DocumentException e1) {
				e1.printStackTrace();
			}
			document.open();

			Paragraph preface = new Paragraph();
			
			Paragraph title = new Paragraph("Capital gain statement for " + customerName, subFont);
			title.setAlignment(Element.ALIGN_CENTER);
			preface.add(title);

			Chapter catPart = new Chapter(new Paragraph(""), 0);
			catPart.setNumberDepth(0);

			catPart.add(preface);
			Double[] equityPnlLong = { 0.0 };
			Double[] equityPnlShort = { 0.0 };
			Double[] debtPnlLong = { 0.0 };
			Double[] debtPnlShort = { 0.0 };

			schemeTypeList.forEach((schemeType) -> {

				Paragraph prefaceNew = new Paragraph();
				addEmptyLine(prefaceNew, 1);
				prefaceNew.add(new Paragraph(schemeType + " Mutual Fund", smallBoldUnderline));
				catPart.add(prefaceNew);
				boolean[] noDataForThisScheme = { true };

				List<String> fundIdList = calculateTaxRecords.getRedemptionFundIds(customerId, schemeType);
				fundIdList.forEach((fundId) -> {
					List<String> folioNumList = calculateTaxRecords.getRedemptionFolioNums(customerId, fundId);
					folioNumList.forEach((folioNum) -> {

						List<TaxRecordsDataModel> taxRecordsDataList = calculateTaxRecords.getTaxDetails(customerId,
								fundId, folioNum, schemeType, startDate, endDate);
						Double pnlLong = 0.0;
						Double pnlShort = 0.0;
						System.out.println(
								"taxRecordsDataList size is :" + taxRecordsDataList.size() + " for " + " fundId : "
										+ fundId + " and folioNum : " + folioNum + " and schemeType : " + schemeType);
						if (taxRecordsDataList.size() != 0) {
							noDataForThisScheme[0] = false;
							for (int i = 0; i < taxRecordsDataList.size(); i++) {
								if (!"NA".equalsIgnoreCase(taxRecordsDataList.get(i).getPnlLongTerm())) {
									pnlLong = Double.parseDouble(taxRecordsDataList.get(i).getPnlLongTerm());
									if ("EQUITY".equalsIgnoreCase(schemeType))
										equityPnlLong[0] += pnlLong;
									else
										debtPnlLong[0] += pnlLong;
								}
								if (!"NA".equalsIgnoreCase(taxRecordsDataList.get(i).getPnlShortTerm())) {
									pnlShort = Double.parseDouble(taxRecordsDataList.get(i).getPnlShortTerm());
									if ("EQUITY".equalsIgnoreCase(schemeType))
										equityPnlShort[0] += pnlShort;
									else
										debtPnlShort[0] += pnlShort;
								}
							}
						}
						try {

							if (taxRecordsDataList.size() != 0) {

								Paragraph parag = new Paragraph();
								addEmptyLine(parag, 1);
								String fundName = calculateTaxRecords.getFundName(fundId);
								parag.add(new Paragraph("Fund Name : " + fundName, small));
								parag.add(new Paragraph("Folio Num : " + folioNum, small));
								addEmptyLine(parag, 1);
								catPart.add(parag);

								createTable(catPart, taxRecordsDataList);

							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
					System.out.println(" I am out of forEach loop for fundId : " + fundId);
				});
				
				if ( noDataForThisScheme[0])   {
					Paragraph parag = new Paragraph();
					addEmptyLine(parag, 1);
					if ("Equity".equalsIgnoreCase(schemeType))
						parag.add(new Paragraph("No redemption were done in equity mutual funds in FY 19-20", small));
					else 
						parag.add(new Paragraph("No redemption were done in debt mutual funds in FY 19-20", small));
					addEmptyLine(parag, 2);
					catPart.add(parag);
				}
				System.out.println(" I am out of forEach loop for schemeType: " + schemeType);
			});

			equityPnlLong[0] = Double.parseDouble(df.format(equityPnlLong[0]));
			equityPnlShort[0] = Double.parseDouble(df.format(equityPnlShort[0]));
			debtPnlLong[0] = Double.parseDouble(df.format(debtPnlLong[0]));
			debtPnlShort[0] = Double.parseDouble(df.format(debtPnlShort[0]));

			Paragraph parag = new Paragraph();
			addEmptyLine(parag, 2);
			parag.add(new Paragraph("Summary: ", smallBoldUnderline));
			addEmptyLine(parag, 1);
			parag.add(new Paragraph("Total Long Term Debt Capital Gains :   " + debtPnlLong[0], smallBold));
			parag.add(new Paragraph("Total Short Term Debt Capital Gains :   " + debtPnlShort[0], smallBold));
			parag.add(new Paragraph("Total Long Term Equity Capital Gains :   " + equityPnlLong[0], smallBold));
			parag.add(new Paragraph("Total Short Term Equity Capital Gains :   " + equityPnlShort[0], smallBold));
			addEmptyLine(parag, 1);
			catPart.add(parag);

			try {
				document.add(catPart);
			} catch (DocumentException e) {
				e.printStackTrace();
			}

			document.close();
		});

		System.out.println(" END !! ");

	}

	private static void createTable(Section subCatPart, List<TaxRecordsDataModel> taxRecordsDataList)
			throws BadElementException {
		PdfPTable table = new PdfPTable(new float[] { 1, 3, 3, 3, 3, 3, 3, 3, 3 });
		table.setWidthPercentage(100);
		
		PdfPCell c1 = new PdfPCell(new Phrase("Sl. No.", verySmallBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Redemption Date", verySmallBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Redemption Price", verySmallBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Redemption Units", verySmallBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Purchase Date", verySmallBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Purchase Price", verySmallBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Purchase Unit", verySmallBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("PnL(Long Term)(Rs.)", verySmallBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("PnL(Short Term)(Rs.)", verySmallBold));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(new BaseColor(164, 194, 244));
		table.addCell(c1);
		table.setHeaderRows(1);

		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);

		for (int j = 0; j < taxRecordsDataList.size(); j++) {

			c1 = new PdfPCell(new Phrase(Integer.toString(taxRecordsDataList.get(j).getSerialNum()), verySmall));
			table.addCell(c1);
			if (taxRecordsDataList.get(j).getRedemptionDate() == null) {
				c1 = new PdfPCell(new Phrase("", verySmall));
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase(taxRecordsDataList.get(j).getRedemptionDate(), verySmall));
				table.addCell(c1);
			}
			if (taxRecordsDataList.get(j).getRedemptionPrice() == null) {
				c1 = new PdfPCell(new Phrase("", verySmall));
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase(taxRecordsDataList.get(j).getRedemptionPrice().toString(), verySmall));
				table.addCell(c1);
			}
			if (taxRecordsDataList.get(j).getRedemptionUnits() == null) {
				c1 = new PdfPCell(new Phrase("", verySmall));
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase(taxRecordsDataList.get(j).getRedemptionUnits().toString(), verySmall));
				table.addCell(c1);
			}

			if (taxRecordsDataList.get(j).getPurchaseDate() == null) {
				c1 = new PdfPCell(new Phrase("", verySmall));
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase(taxRecordsDataList.get(j).getPurchaseDate(), verySmall));
				table.addCell(c1);
			}
			if (taxRecordsDataList.get(j).getPurchasePrice() == null) {
				c1 = new PdfPCell(new Phrase("", verySmall));
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase(taxRecordsDataList.get(j).getPurchasePrice().toString(), verySmall));
				table.addCell(c1);
			}
			if (taxRecordsDataList.get(j).getPurchaseUnits() == null) {
				c1 = new PdfPCell(new Phrase("", verySmall));
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase(taxRecordsDataList.get(j).getPurchaseUnits().toString(), verySmall));
				table.addCell(c1);
			}

			c1 = new PdfPCell(new Phrase(taxRecordsDataList.get(j).getPnlLongTerm(), verySmall));
			table.addCell(c1);
			c1 = new PdfPCell(new Phrase(taxRecordsDataList.get(j).getPnlShortTerm(), verySmall));
			table.addCell(c1);
		}

		subCatPart.add(table);

	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
