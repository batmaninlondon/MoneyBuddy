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
        <title>Megakit - HTML5 Theme</title>
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="Megakit - HTML5 Theme">
        <meta name="author" content="keenthemes.com">
    	<link rel="icon" type="image/png" href="../assets/img/favicon.png">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>
        
        <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />

        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/material-kit.css" rel="stylesheet"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
     <script src="assets/js/sly.min.js"></script>
    <script src="assets/js/jquery.prettyPhoto.js"></script>
    <script src="assets/js/jquery.isotope.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <script src="assets/js/index.js"></script>
  
  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    </head>

<body style="background-color:#cecece">
    
   <div class="container ">
   		<a href="nhome.jsp" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
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
	       	<div class="row">
				<label for="pancard-number" style="font-family:Aparajita;font-size:25px;color:black;" >&nbsp;&nbsp;&nbsp;PAN </label>
			</div>
			<div  class="row" >
				<div class="col-md-3 col-xs-3">  
				  <input class="form-control" id="pancard-number" type="text" placeholder="Enter Pancard Number" style="margin-top:-10px;">
			  	</div>
			</div>
			<div  class="row" >
				<p id="panCardStats"></p>
			</div>
			<div  class="row" >
				
				&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-primary" onClick="verifyPancard();" style="padding:5px 15px 5px 15px;">Verify</button>
			</div>
	     </div>
	     <div class="col-md-1 col-xs-1" style="height:500px"></div>
	</div>

</body>
	

</html>