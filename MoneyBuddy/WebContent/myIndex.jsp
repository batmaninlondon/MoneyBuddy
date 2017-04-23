<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html >
<html lang="en">
<head>
<!-- <meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" /> -->


    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    
    
<title>Index page</title>

<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="assets/stylesheet.css" />

<script type="text/javascript" src="assets/js/JQuery.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/javaScript.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
    
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
		<div  class="col-md-1">
		</div>
		<div   class="col-md-7">
			<p id="slogan-1" class="larger-text"> MAKE YOUR DREAMS REALITY</p>
			<p id="slogan-2" class="medium-text"> The best thing money can buy is .....</p>
			<p id="slogan-3" class="medium-text"> MORE MONEY</p>
			<a href="investmentStyle" id="MyLogin-submit-button-1" class="btn btn-info btn-lg submit-button-1 sharp raised large-text" style="height:70px;width:300px;">TRY IT OUT</a>
			<br/><p id="slogan-4" class="small-text box" style="margin-top:50px;"> with investing your capital is at risk</p>
		</div>
		<div  class="col-md-4">
		</div>
		
	</div>
	
	<%-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/bluebird/3.3.4/bluebird.min.js"></script>

		<script>
		
		'use strict';
		
		var promise = new Promise(function(resolve) {
		    setTimeout(function() {
		        resolve("result");
		    }, 1000);
		});
		
		promise.then(function(result) {
		    alert("Fulfilled: " + result);
		}, function(error) {
		    alert("Rejected: " + error);
		});

</script> --%>
</body>
</html>