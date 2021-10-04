<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="en">
<head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy - Top Performing Mutual Funds</title>
        <meta http-equiv="Cache-control" content="max-age=2592000, public">
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">

		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		
        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->
        
       <!--  <link href="css/material-bootstrap-wizard.css" rel="stylesheet" /> -->

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/material-kit.css" rel="stylesheet"/>

    </head>

<body style="background-color:#cecece">
    
   <div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
		</a>
	</div>
	<br/>
	<br/>
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:120px;">
	    	<div class="profile">
	        	<div class="name">
	                	<h3 class="title g-color--white"><s:property value="#session.emailId" /></h3>
						<h6 style="color:white;"><s:property value="#session.customerMobileNumber" /></h6>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<div class="row" >
		<div class="col-md-1 col-xs-1" style="height:500px"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " style="height:500px">
	    	<div class="profile">
	        	<div class="name">
	                	<h3 class="title"><s:property value="#session.emailId" /></h3>
						<h6><s:property value="#session.customerMobileNumber" /></h6>
						<br/>
						
	            </div>
	       	</div>
	       	
	       	<s:form action="panCardVerificationAction" method="post" >
	       	<div class="row">
				<label for="pancard-number" style="font-family:Aparajita;font-size:25px;color:black;" >&nbsp;&nbsp;&nbsp;PAN </label>
			</div>
			<div  class="row" >
				<div class="col-md-3 col-xs-3">
					<s:fielderror fieldName="panCard" class="g-color--red" />
			  		<s:textfield class="form-control" id="pancard-number" placeholder="Enter Pancard Number" name="panCard" style="margin-top:-10px;" /> 
					<!-- <input class="form-control" id="pancard-number" type="text" placeholder="Enter Pancard Number" style="margin-top:-10px;"> -->
			  	</div>
			</div>
			<div  class="row" >
				<p id="panCardStats"></p>
			</div>
			<div  class="row" >
				&nbsp;&nbsp;&nbsp;<s:submit class="btn btn-primary" value="Verify" style="padding:5px 15px 5px 15px;"/>
				<!-- &nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-primary" onClick="verifyPancard();" style="padding:5px 15px 5px 15px;">Verify</button> -->
			</div>
			</s:form>
	     </div>
	     <div class="col-md-1 col-xs-1" style="height:500px"></div>
	</div>


	<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script src="assets/js/jquery.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
     <script src="assets/js/sly.min.js"></script>
    <script src="assets/js/jquery.prettyPhoto.js"></script>
    <script src="assets/js/jquery.isotope.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <script src="assets/js/index.js"></script>
  
  	<script type="text/javascript" src="assets/js/jquery-latest.js"></script>
</body>
	

</html>
