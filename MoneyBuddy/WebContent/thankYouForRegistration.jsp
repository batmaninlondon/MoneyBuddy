<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ThankYou Page</title>
<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="assets/stylesheet.css" />
</head>
<body>

	<div id="wrap">
		<img class="bgfade" src="images/backgroundImage1.jpg" /> 
		<img class="bgfade" src="images/backgroundImage2.jpg" />
		<img class="bgfade" src="images/backgroundImage3.jpg" /> 
		<img class="bgfade" src="images/backgroundImage4.jpg" /> 
		<img class="bgfade" src="images/backgroundImage5.jpg" />
	</div>
	<div class="row row-first">
		<div class="col-md-12" id="header">
			<%  if(session.getAttribute("customerId") == null)
			 	{   %> 
			<%@ include file="headerLoggedOff.jsp"%>
			<%	} else 
			 	{	%>
			<%@ include file="headerLoggedIn.jsp"%>
			<%	}	%>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 well-sm large-text blog-row-1" >
			<p>Registration Successful</p>
		</div>
	</div>
	
	<div class="row col-md-12" style="margin-top:100px;margin-left:50px;">
		<p class="large-text"> THANKS</p>
	</div>
	<div class="row col-md-12" style="margin-left:50px;">
		<p class="medium-text">We've sent you a verification mail.</p>
	</div>
	<div class="row col-md-12" style="margin-left:50px;">
		<p class="medium-text">Kindly check your mail box, and click the verification link to activate your account.</p>
	</div>

	<script type="text/javascript" src="assets/js/JQuery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/javaScript.js"></script>	
</body>
</html>