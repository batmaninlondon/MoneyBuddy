package com.myMoneyBuddy.mailerClasses;

import java.util.HashMap;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.mailerClasses.sendMail;;
public class SendingMailWithPdfTest {
	
	public static void main(String args[]) throws MoneyBuddyException  {
		
		HashMap<String,String>  map = new HashMap<String,String>();
		map.put("Fund1", "400");
		map.put("Fund2", "500");
		map.put("Fund3", "600");
		sendMail abc = new sendMail();
		abc.sendMailwithAttachement(map, "Invoice_Template","savita.wadhwani@gmail.com");
		
	}

}