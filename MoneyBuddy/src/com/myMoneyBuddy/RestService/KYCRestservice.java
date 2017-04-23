package com.myMoneyBuddy.RestService;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.myMoneyBuddy.ActionClasses.KycCheckAction;
import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

@Path("/KYCRestservice")
public class KYCRestservice {
	Logger logger = Logger.getLogger(KYCRestservice.class);
	private Map<String, Object> sessionMap;
	
    private String panCard;
    QueryKycStatus kyc = new QueryKycStatus();

    
	@GET
	@Path("/validateKyc")
	@Produces(MediaType.APPLICATION_JSON)
	public String validateKyc(@QueryParam("pan") String pan){
    	try {
    		
    	
    	logger.debug("KycCheckAction class : execute method : start");
    	System.out.println(" KycCheckAction execute method Called !!");
    	System.out.println(" KycCheckAction execute method : PanCard number : "+pan);
    	
    	// Savita Wadhwani - Start - Added this block to validate input panCard through ajax call
    	
    	if (!kyc.existsPanCard(pan)) {
    		System.out.println(" Returned invalid !!");
    		/*return "invalid";*/
    		throw new Exception(" Invalid input supplied!!");
    	}
    	
    	// Savita Wadhwani - End - Added this block to validate input panCard through ajax call
    	
    	if (kyc.getKycStatusForPanCard(pan).equalsIgnoreCase("NO"))  {
    		logger.debug("KycCheckAction class : execute method : KYC is not done for "+pan);
    		System.out.println(" Returned error !!");
    		return "{'result':'error'}";
    	}

    	sessionMap.put("panCard", panCard);
    	System.out.println("Kyc is done for panCard : "+panCard);
    	
    //	logger.debug("KycCheckAction class : execute method : stored panCard : "+panCard+" in session id : "+sessionMap.getClass().getName());
    	logger.debug("KycCheckAction class : execute method : end");
    	} 
    	catch ( MoneyBuddyException e )  {
    	//	logger.error("KycCheckAction class : execute method : caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
    		//e.printStackTrace();
    		return "{'result':'input'}";
    	}
    	catch ( Exception e )  {
    		//logger.error("KycCheckAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
    		//e.printStackTrace();
    		return "{'result':'error'}";
    	}
    	System.out.println(" Returned Success !!");
    	return "{'result':'success'}";
    }

}
