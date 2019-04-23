<%@page import="com.myMoneyBuddy.DAOClasses.InsertCustomerDetails"%>
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
	    String hashedPassword = (String)request.getParameter("hashedPassword");
	    System.out.println("hello from  jsp : value of hashedPassword : "+hashedPassword);
	    InsertCustomerDetails customer = new InsertCustomerDetails();
	    String emailId = customer.updateVerificationStatusAndGetEmail(hashedPassword);
	    //}
	    request.getSession().setAttribute("name", emailId);
	    String redirectURL = "login";
	    response.sendRedirect(redirectURL);
	%>

	<script type="text/javascript" src="assets/js/jquery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- <script type="text/javascript" src="assets/js/javaScript.js"></script> -->	
</body>
</html>