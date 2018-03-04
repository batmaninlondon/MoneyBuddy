package com.myMoneyBuddy.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONObject;

public class MbUtil {
	 public boolean isCaptchaValid(String googleResponse2) 
	    {
		    try {
		        String url = "https://www.google.com/recaptcha/api/siteverify?"
		                + "secret=" + "6LfzbkoUAAAAAM4RRocJaTgXIHtcLkEROYS2MVgy"
		                + "&response=" + googleResponse2;
		        System.out.println(url);
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
		        System.out.println(json);
		        return json.getBoolean("success");
		    } catch (Exception e) {
		        return false;
		    }
		
		}

	public MbUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
}
