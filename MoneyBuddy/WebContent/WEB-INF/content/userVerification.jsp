<%@page import="com.myMoneyBuddy.DAOClasses.InsertCustomerDetails"%>
<%@page import="com.myMoneyBuddy.DAOClasses.QueryCustomer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.net.URL" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Verification Page</title>
<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="assets/stylesheet.css" />


</head>
<body>

	<%
	    //URL url = new URL(request.getRequestURL());
	    //if (request.getAttribute("hash")!=null) {
	    String hashedPassword = (String)request.getParameter("Hp");
	    System.out.println("hello from  jsp : value of hashedPassword : "+hashedPassword);
	    QueryCustomer queryCustomer = new QueryCustomer();
	    String emailId = queryCustomer.getEmailId(hashedPassword);
	    
	    System.out.println("emailId : " +emailId);
	    
	    if (!"NotExist".equalsIgnoreCase(emailId))  {
	    	/* request.getSession().setAttribute("actionMsg", "Link has been expired"); */
	    	
	    	String verificationStatus = queryCustomer.getVerificationStatus(emailId);
	    	System.out.println("verificationStatus : " +verificationStatus);
	    	if ("Y".equalsIgnoreCase(verificationStatus))  {
	    		 %>
             	<h3 class="text-center g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs">
             	<b>Verification already done!!</b>
             	</h3>
             <%
	    	}
	    	else {
	    		InsertCustomerDetails customer = new InsertCustomerDetails();
	    		customer.updateVerificationStatusFromEmailId(emailId);
		    	request.getSession().setAttribute("name", emailId);
			    String redirectURL = "login";
			    response.sendRedirect(redirectURL);
	    		 
	    	}
	    	
	    	
	    	
	    }
	   	else {
									
                %>
                	<h3 class="text-center g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs"><b>Link has expired</b></h3>
                <%
			}
                %>

	<script type="text/javascript" src="assets/js/jquery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- <script type="text/javascript" src="assets/js/javaScript.js"></script> -->	
</body>
</html>