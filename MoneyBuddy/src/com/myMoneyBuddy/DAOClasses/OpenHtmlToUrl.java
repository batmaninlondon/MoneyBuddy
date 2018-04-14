package com.myMoneyBuddy.DAOClasses;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class OpenHtmlToUrl extends JFrame {

	public void openPage(String htmlContent)  {
		
		try { 
			
			JEditorPane ed1=new JEditorPane("text/html",htmlContent); 
			add(ed1); 
			setVisible(true); 
			setSize(600,600); 
			setDefaultCloseOperation(EXIT_ON_CLOSE); 
			} 
		catch(Exception e) { 
			e.printStackTrace(); 
			System.out.println("Some problem has occured"+e.getMessage()); 
		}

		
	}
	
}
