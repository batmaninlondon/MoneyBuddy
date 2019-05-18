<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy-Top Performing Mutual Funds</title>
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
	
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
        <script type="text/javascript" src="assets/js/jquery-latest.js"></script>

    </head>
    <!-- End Head -->

    <!-- Body -->
   <body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;">
   <div class="container ">
   		<a href="welcome.jsp" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="Dublin Logo">
		</a>
	</div>
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:70px;">
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>

	<div class="row g-height-auto--lg" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
		
			
			<div class="row g-margin-t-15--xs">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<h4 class="title ">Dear <s:property value="#session.customerName" />,</h4>
				</div>
			</div>
			<br/>
				
			<div class="row text-center g-margin-t-15--xs">
				<h4 class="title g-margin-l-120--md g-margin-l-20--xs text-center">To ensure the safety of your investments, we require two-step verification</h4>
			</div>
			<div id="customer-cart-list" class=" g-margin-b-30--xs g-margin-t-10--xs g-margin-r-100--xs g-margin-l-100--xs">
					
			</div>
			
				
				<h5 class="text-center"> Kindly download your Account Opening Form for the same</h5>
				<br/>
				<div class="row g-margin-t-o-20--xs">
					<div class="col-md-5"></div>
					<div class="col-md-2">
						
						<button type="button"  id="pay-now-button" class="text-center btn btn-home g-color--white g-margin-t-15--xs " 
						onClick="window.open('${pageContext.request.contextPath}/assets/AofForms/<s:property value="aofForm"/>')">
						Download AoF</button>
					</div>
					<div class="col-md-5">
					</div>
				</div> 
				<br/>
				<br/>
				<h5 class="text-center"> Please verify your details and email signed form to admin@MoneyBuddy.co.in</h5>
				<br/>
				<h5 class="text-center"> PS: This is a one time process, required as per the govt. regulations</h5>
				
			<br/>
	     </div>
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	

	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:40px;">

	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
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
	  	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		
</body>
    <!-- End Body -->
</html>
