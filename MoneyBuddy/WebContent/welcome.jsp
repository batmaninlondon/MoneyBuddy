<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html lang="en">
<head>

	
</head>

<body >
		
		<%-- <jsp:forward page="/fundDetails.action" /> --%>
		
		<s:action name="fetchPopularFundDetailsAction" namespace="/" executeResult="true" />
</body>
   
</html>