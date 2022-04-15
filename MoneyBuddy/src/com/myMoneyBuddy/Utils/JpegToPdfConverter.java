package com.myMoneyBuddy.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class JpegToPdfConverter {
	
	private static String FILE = "c:/Pdfs/MATH/Project/MathProject_AeshaMittal_3B.pdf";
	private static String IMAGE_1 = "c:/Pdfs/MATH/Project/1.jpeg";
	private static String IMAGE_2 = "c:/Pdfs/MATH/Project/2.jpeg";
	private static String IMAGE_3 = "c:/Pdfs/MATH/Project/3.jpeg";
	/*private static String IMAGE_2 = "c:/Pdfs/SST/Project/2.jpeg";*/
	//private static String IMAGE_3 = "c:/Pdfs/SCI/Project/3.jpeg";
	//private static String IMAGE_2 = "c:/Pdfs/FA2/Marathi/2.jpeg";
	//private static String IMAGE_3 = "c:/Pdfs/ENG/Pro/3.jpeg";
	/*private static String IMAGE_4 = "c:/Pdfs/ENG/4.jpeg";
	private static String IMAGE_5 = "c:/Pdfs/ENG/5.jpeg";
	private static String IMAGE_6 = "c:/Pdfs/ENG/6.jpeg";
	private static String IMAGE_7 = "c:/Pdfs/ENG/7.jpeg";
	private static String IMAGE_8 = "c:/Pdfs/ENG/8.jpeg";
	private static String IMAGE_9 = "c:/Pdfs/ENG/9.jpeg";
	private static String IMAGE_10 = "c:/Pdfs/ENG/10.jpeg";
	private static String IMAGE_11 = "c:/Pdfs/ENG/11.jpeg";*/
	
	public static void main(String args[]) throws DocumentException, MalformedURLException, IOException   {
		
		//create the image file
		/*File imageFile = new File("C:\\path\\to\\image\\exampleImage.png");*/

		//create a new PDF file
		/*File pdfFile = new File("C:\\path\\to\\pdf\\examplePDF.pdf");
		pdfFile.createNewFile();

		//write the image to the pdf
		PdfEncodings encoder = new PdfEncodings();
		((Object) encoder).write(imageFile, pdfFile);*/
		
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(FILE));
		document.open();
		Image firstImage = Image.getInstance(IMAGE_1);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        firstImage = Image.getInstance(IMAGE_2);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        firstImage = Image.getInstance(IMAGE_3);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        /*firstImage = Image.getInstance(IMAGE_4);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        firstImage = Image.getInstance(IMAGE_5);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        firstImage = Image.getInstance(IMAGE_6);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        firstImage = Image.getInstance(IMAGE_7);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        firstImage = Image.getInstance(IMAGE_8);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        firstImage = Image.getInstance(IMAGE_9);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        firstImage = Image.getInstance(IMAGE_10);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);
        
        firstImage = Image.getInstance(IMAGE_11);
		firstImage.scaleAbsolute(550f, 800f);
        document.add(firstImage);*/
        
        /*Image secondImg = Image.getInstance(SECOND_IMAGE);
		secondImg.scaleAbsolute(550f, 800f);
        document.add(secondImg);*/
        
		document.close();
		
		System.out.println("DONE ");
		
	}

}
