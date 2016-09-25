<%-- 
    Document   : userVerification
    Created on : 18 Aug, 2016, 2:00:32 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.myMoneyBuddy.queryClasses.UpdateUserVerification" %>
<%@ page import="java.net.URL" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>userVerification Page</title>
    </head>
    <body>

<%
    //URL url = new URL(request.getRequestURL());
    //if (request.getAttribute("hash")!=null) {
    String hash = (String)request.getParameter("hash");
    System.out.println("hello from jsp : value of hash : "+hash);
    UpdateUserVerification user = new UpdateUserVerification();
    user.UserVerification(hash);
    //}
    String redirectURL = "http://localhost:8080/MoneyBuddy/loginPage.jsp";
    response.sendRedirect(redirectURL);
%>


    </body>
</html>
