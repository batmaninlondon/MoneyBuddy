<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.net.URL" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Logoff Page</title>
    <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="assets/stylesheet.css" />
</head>
    <body>
    <!-- <p> LogOff Page </p> -->
        <%
        session.invalidate();
        String redirectURL = "/MoneyBuddy/myIndex";
	    response.sendRedirect(redirectURL);
	    %>
		<script type="text/javascript" src="assets/js/JQuery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
    </body>
</html>
