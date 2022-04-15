package com.myMoneyBuddy.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

public class MbUtil {
	
	Logger logger = LogManager.getLogger(MbUtil.class);
	
	 public boolean isCaptchaValid(String googleResponse) throws MoneyBuddyException
	    {
		 	logger.debug("MbUtil class - isCaptchaValid method - start");
		    try {
		    	
		    	System.out.println("googleResponse: inside isCaptchaValid : "+googleResponse);
		    	Properties configProperties = new Properties();
				String configPropFilePath = "../../../config/config.properties";

				configProperties.load(MbUtil.class.getResourceAsStream(configPropFilePath));
				
		        String url = "https://www.google.com/recaptcha/api/siteverify?"
		                + "secret=" + configProperties.getProperty("RECAPTHA_SECRET_KEY")
		                + "&response=" + googleResponse;
		        InputStream res = new URL(url).openStream();
		        BufferedReader rd = new BufferedReader(new InputStreamReader(res, Charset.forName("UTF-8")));

		        StringBuilder sb = new StringBuilder();
		        int cp;
		        while ((cp = rd.read()) != -1) {
		            sb.append((char) cp);
		        }
		        String jsonText = sb.toString();
		        res.close();

		        JSONObject json = new JSONObject(jsonText);
		        
		        logger.debug("MbUtil class - isCaptchaValid method - end");
		        
		        return json.getBoolean("success");
		        
		    }catch (IOException e) {
	    		logger.error("MbUtil class - isCaptchaValid method - Caught IOException");
	    		e.printStackTrace();
				throw new MoneyBuddyException(e.getMessage(),e);
	    	}
	        catch (Exception e ) {
	        	logger.error("MbUtil class - isCaptchaValid method - Caught Exception");
				e.printStackTrace();
				throw new MoneyBuddyException(e.getMessage(),e);
			}
		
		}

	public MbUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
}
