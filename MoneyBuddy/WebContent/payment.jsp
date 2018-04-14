<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
	window.onload = function openPaymentUrl()  {
		
		//alert('Hello World !! ');
		var payment = document.getElementById("check-id").innerHTML;
		//alert('payment : '+payment);
		var wnd = window.open("", "_self");
		wnd.document.write(payment);
		 wnd.document.close(); 
		 
	}
</script>
</head>
<body >
	<p> HELLOOOOO </p>
	
	<s:set var="payUrl" value="paymentUrl" />
	
	<%-- <s:hidden id="check-id" ><s:property value="#payUrl"/></s:hidden> --%>
	
	<p id="check-id"><s:property value="#payUrl"/></p>
	
	
</body>
</html>