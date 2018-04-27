/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.HashMap;
import java.util.List;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.EntityClasses.FolioDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class UploadCustomerNavAction extends ActionSupport {
	
	Logger logger = Logger.getLogger(UploadCustomerNavAction.class);	
    private String bseOrderId;
    private String folioNum;
    private String navValue;
    private String unitsPurchased;
    private HashMap<String,String>  pendingNavOrders ;
    
    //private InputStream stream;
   
    public String execute() {
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
    	try {
    		
    		logger.debug("UploadCustomerNavAction class - execute method - bseOrderId - "+getBseOrderId()+" - start ");

    		System.out.println("UploadCustomerNavAction class : execute method : called ");
    		
    		System.out.println("transactionFolioNum : "+getFolioNum()+" : unitPrice : "+getNavValue()+" : quantity : "+getUnitsPurchased()+" : bseOrderId : "+getBseOrderId());
    		
    		if (!NumberUtils.isNumber(getUnitsPurchased()))  {
    			
    			addActionMessage("Entered Units is not a number !! ");
    			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
    			pendingNavOrders = queryTransactionDetails.getPendingNavsOrders();
    			return INPUT;
    		}

    		if (!NumberUtils.isNumber(getNavValue()))  {
    			
    			addActionMessage("Entered Nav value is not a number !! ");
    			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
    			pendingNavOrders = queryTransactionDetails.getPendingNavsOrders();
    			return INPUT;
    		}
    		
    		hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select transactionAmount from TransactionDetails where bseOrderId = :bseOrderId ");
    		query.setParameter("bseOrderId", getBseOrderId());
    		
    		Double amount = Double.valueOf(query.uniqueResult().toString());
    		
    		hibernateSession.getTransaction().commit();
    		
    		Double calculatedAmount = Double.valueOf(getNavValue()) * Double.valueOf(getUnitsPurchased());

    		System.out.println(" NAV value : "+getNavValue()+" : units : "+getUnitsPurchased());
    		
    		System.out.println("calculated amount : "+calculatedAmount+" : amount : "+amount);
    		
    		if ( Double.compare(amount, calculatedAmount) != 0 )  {
    			addActionMessage("Entered values are not correct !! ");
    			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
    			pendingNavOrders = queryTransactionDetails.getPendingNavsOrders();
    			return INPUT;
    		}
    		
    		hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("update TransactionDetails set transactionFolioNum = :transactionFolioNum , "
					+ "unitPrice = :unitPrice , quantity = :quantity , transactionStatus = :transactionStatus where bseOrderId = :bseOrderId");

			query.setParameter("transactionFolioNum", getFolioNum());
			query.setParameter("unitPrice", getNavValue());
			query.setParameter("quantity", getUnitsPurchased());
			query.setParameter("bseOrderId", getBseOrderId());
			query.setParameter("transactionStatus", "8");
			
			int updateResult = query.executeUpdate();
			System.out.println(updateResult + " rows updated in transactionDetails table ");
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			
			String count ;
			query = hibernateSession.createQuery("select count(*) from FolioDetails where folioNum = :folioNum ");
			query.setParameter("folioNum", getFolioNum());
			
			count = query.uniqueResult().toString();
			hibernateSession.getTransaction().commit();
			
			
			if ("0".equals(count))  {
				
				hibernateSession.beginTransaction();

				query = hibernateSession.createQuery("select s.amcCode,c.panCard, t.customerId "
										+ "from Customers c, TransactionDetails t, SecondaryFundDetails s "
										+ "where t.customerId = c.customerId and t.productId = s.fundId and t.bseOrderId= :bseOrderId");
				query.setParameter("bseOrderId", getBseOrderId());
				
				List<Object[]> queryResult = query.list(); 
				
				String amcCode = queryResult.get(0)[0].toString();
				String panCard = queryResult.get(0)[1].toString();
				String customerId = queryResult.get(0)[2].toString();
				
				System.out.println("amcCode : "+amcCode+" : panCard : "+panCard+" : customerId : "+customerId);
				
				hibernateSession.getTransaction().commit();
				
				hibernateSession.beginTransaction();

				FolioDetails tempFolioDetails = new FolioDetails( getFolioNum(), customerId, amcCode, panCard);
				hibernateSession.save(tempFolioDetails);
				
				hibernateSession.getTransaction().commit();
				
				
			}
	    	
	    	System.out.println(" Action complete !!");
	    	/*String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());*/
		    logger.debug("UploadCustomerNavAction class - execute method - bseOrderId - "+getBseOrderId()+" - returned success");
	    	logger.debug("UploadCustomerNavAction class - execute method - bseOrderId - "+getBseOrderId()+" - end");
	    	
	    	return SUCCESS;
	    	
    	}
    	catch (Exception e) {	
    		logger.error("UploadCustomerNavAction class - execute method - bseOrderId - "+getBseOrderId()+" - Caught Exception");
    		e.printStackTrace();
    		
    		/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("UploadCustomerNavAction class - execute method - bseOrderId - "+getBseOrderId()+" - returned error");
    	    
    		return ERROR;
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
    }

	public String getBseOrderId() {
		return bseOrderId;
	}

	public void setBseOrderId(String bseOrderId) {
		this.bseOrderId = bseOrderId;
	}

	public String getFolioNum() {
		return folioNum;
	}

	public void setFolioNum(String folioNum) {
		this.folioNum = folioNum;
	}

	public String getNavValue() {
		return navValue;
	}

	public void setNavValue(String navValue) {
		this.navValue = navValue;
	}

	public String getUnitsPurchased() {
		return unitsPurchased;
	}

	public void setUnitsPurchased(String unitsPurchased) {
		this.unitsPurchased = unitsPurchased;
	}

	public HashMap<String, String> getPendingNavOrders() {
		return pendingNavOrders;
	}

	public void setPendingNavOrders(HashMap<String, String> pendingNavOrders) {
		this.pendingNavOrders = pendingNavOrders;
	}
	
/*

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/
	

}
