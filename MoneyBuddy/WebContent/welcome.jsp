<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html lang="en">
<head>	
<!-- <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"> -->
<!-- <link rel="shortcut icon" href="favicon.ico"> -->

</head>

<body>
		
		<s:action name="fetchPopularFundDetailsAction" namespace="/" executeResult="true" />
</body>
   
</html>