<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html >
<html lang="en">
<head>
<title>Investment Style	Page</title>

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
		<div   class="col-md-2"></div>
		<div   class="col-md-8">
			<p id="InvestmentStyle-slogan-1" class="large-text" style="margin-top:80px;margin-left:80px;"> What Kind of Investment You are looking for </p>
		</div>
		<div   class="col-md-2"></div>
	</div>
	<div class="row">
		<div   class="col-md-3"></div>
		<div  class="InvestmentStyle-diamond-img col-md-3">
			<!-- <img src="images/pattern.jpg" id="pattern-image"> -->
			<p class="diamond-text" ><a href="upfrontInvestment" >Looking for One time Investment</a></p> 
		</div>
		<!-- <div   class="col-md-2"></div> -->
		<div   class="InvestmentStyle-diamond-img col-md-3">
			<!-- <img src="images/pattern1.jpg" id="pattern-image"> -->
			<p class="diamond-text"><a href="sipInvestment" >Looking for Monthly Investment</a></p>
		</div>
		<div   class="col-md-3"></div>
	</div>
	
		<script type="text/javascript" src="assets/js/JQuery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</body>
</html>