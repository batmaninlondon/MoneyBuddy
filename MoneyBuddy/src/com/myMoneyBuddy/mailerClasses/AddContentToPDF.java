package com.myMoneyBuddy.mailerClasses;

/* requires itextpdf-5.1.2.jar or similar */
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

public class AddContentToPDF {

    public static void main(String[] args) throws IOException, DocumentException {

        /* example inspired from "iText in action" (2006), chapter 2 */

    	/*String userName = "Savvy";
    	Document document = new Document();*/


           /*PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D://DelMe/Invoice_Template.pdf"));
           document.open();
           document.add(new Paragraph("Hello "+userName));
           document.close();
           writer.close();*/
    	
    	try {
           PdfReader reader = new PdfReader("D://DelMe/KYC.pdf");
           //Rectangle pagesize = reader.getPageSize(1);
           String directoryName = "D://DelMe/123";
           File directory = new File(String.valueOf(directoryName));
           
           if(!directory.exists()){

               directory.mkdir();
           }
           
           PdfStamper stamper = new PdfStamper(reader,
        	          new FileOutputStream(directoryName+"/KYC_Application_Form.pdf")); // output PDF
           AcroFields form = stamper.getAcroFields();
           
           HashMap map = new HashMap();
           map = (HashMap) form.getFields();
           Iterator iterator = map.keySet().iterator();
           System.out.println("iterator size : "+map.size());
          /* while(iterator.hasNext())
               System.out.println("Field is >>>"+iterator.next());*/
           
           form.setField("Name", "Savita wadhwani");
           form.setField("FathersSpouse Name", "BhagChandra Wadhwani");           
           form.setField("F ema","On");
           form.setField("Marr","On");
           form.setField("Indian","On");
           form.setField("5 PAN", "AAXAB4321A");
           
          
          stamper.setFormFlattening(true);
          stamper.close();
          reader.close();
          System.out.println("End!!");
          
    	} catch (Exception e )  {
    		
    		System.out.println("Caught Exception");
    	}
          
           /*form.setField("Your Company Name", "MoneyBuddy");
           form.setField("Your Name", "MoneyBuddy");
           form.removeField("Address Line 1");
           form.removeField("Address Line 2");
           form.removeField("City, State, Zip Code");
           form.setField("Client's Name", "Kamal Wadhwani");
           form.removeField("Client: Address Line 1");
           form.removeField("Client: Address Line 2");
           form.removeField("Client: City, State, Zip Code");
           form.removeField("Invoice ID");
           form.removeField("Issue Date");
           form.removeField("PO Number");
           form.removeField("Due Date");
           form.removeField("Subject");*/

           
          
           
           /*PdfPTable table = new PdfPTable(2);
           table.addCell("#");
           table.addCell("description");
           
           table.setHeaderRows(1);
          
           table.setWidths(new int[]{ 10, 15 });
           for (int i = 1; i <= 10; i++) {
               table.addCell(String.valueOf(i));
               table.addCell("test " + i);
           }
          
           ColumnText column = new ColumnText(stamper.getOverContent(1));
           Rectangle rectPage1 = new Rectangle(36, 200, 559, 700);
           column.setSimpleColumn(rectPage1);
           column.addElement(table);
           
           int pagecount = 1;
           Rectangle rectPage2 = new Rectangle(36, 36, 559, 806);
           int status = column.go();
           while (ColumnText.hasMoreText(status)) {
               status = triggerNewPage(stamper, pagesize, column, rectPage2, ++pagecount);
           }*/
           
           
          
    	
    	
        /*PdfReader reader = new PdfReader("D://DelMe/test.pdf"); // input PDF
        Rectangle pagesize = reader.getPageSize(1);
        
        PdfStamper stamper = new PdfStamper(reader,
          new FileOutputStream("D://DelMe/test_modified.pdf")); // output PDF
        BaseFont bf = BaseFont.createFont(
                BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font

        //loop on pages (1-based)
        
        PdfContentByte over = stamper.getOverContent(1);

        // write text
        over.beginText();
        over.setFontAndSize(bf, 10);    // set font and size
        over.setTextMatrix(200, 600);   // set x,y position (0,0 is at the bottom left)
        over.showText("I can write at page " + 1);  // set text
        over.endText();
     */
        /*AcroFields form = stamper.getAcroFields();
        
        form.setField("Table of Contents", "Jennifer");
        form.setField("Company", "iText's next customer");
        form.setField("Country", "No Man's Land");
        PdfPTable table = new PdfPTable(2);
        table.addCell("#");
        table.addCell("description");
        table.setHeaderRows(1);
        table.setWidths(new int[]{ 1, 15 });
        for (int i = 1; i <= 10; i++) {
            table.addCell(String.valueOf(i));
            table.addCell("test " + i);
        }
        ColumnText column = new ColumnText(stamper.getOverContent(1));
        Rectangle rectPage1 = new Rectangle(36, 36, 559, 540);
        column.setSimpleColumn(rectPage1);
        column.addElement(table);
        
        int pagecount = 1;
        Rectangle rectPage2 = new Rectangle(36, 36, 559, 806);
        int status = column.go();
        while (ColumnText.hasMoreText(status)) {
            status = triggerNewPage(stamper, pagesize, column, rectPage2, ++pagecount);
        }*/
        
/*        for (int i=1; i<=reader.getNumberOfPages(); i++){

            // get object for writing over the existing content;
            // you can also use getUnderContent for writing in the bottom layer
            PdfContentByte over = stamper.getOverContent(i);

            // write text
            over.beginText();
            over.setFontAndSize(bf, 10);    // set font and size
            over.setTextMatrix(107, 740);   // set x,y position (0,0 is at the bottom left)
            over.showText("I can write at page " + i);  // set text
            over.endText();

            // draw a red circle
            over.setRGBColorStroke(0xFF, 0x00, 0x00);
            over.setLineWidth(5f);
            over.ellipse(250, 450, 350, 550);
            over.stroke();
        }*/

/*        stamper.setFormFlattening(true);
        stamper.close();
        reader.close();
*/
           
          
    }
    
    public static int triggerNewPage(PdfStamper stamper, Rectangle pagesize, ColumnText column, Rectangle rect, int pagecount) throws DocumentException {
        stamper.insertPage(pagecount, pagesize);
        PdfContentByte canvas = stamper.getOverContent(pagecount);
        column.setCanvas(canvas);
        column.setSimpleColumn(rect);
        return column.go();
    }
    
}
