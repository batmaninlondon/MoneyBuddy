<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Investment Details Page | Money Buddy</title>
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
 	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/prettyPhoto.css" rel="stylesheet">
    <link href="assets/css/bootstrap/main.css" rel="stylesheet">
    <link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
    
    <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
    
	<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
	<%-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
 	
    <!-- <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png"> -->

<style>

hr { 
  display: block;
  margin-top: 0.5em;
  margin-bottom: 0.5em;
  margin-left: 200px;
  margin-right: 100px;
  border-style: inset;
  border-width: 1px;
} 

</style>

</head>

<body class="homepage bg-warning">
   <header id="header">

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <div class="s-header-v2__logo">
                        <a href="<s:url action="adminHome"/>" class="s-header-v2__logo-link">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
                        </a>
                    </div>
                </div>
				
                <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item col-sm-push-7"><a href="<s:url action="adminHome"/>" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item col-sm-push-8"><a href="<s:url action="logOffAction"/>" class="s-header-v2__nav-link">Log Out</a></li>
                                </ul>
                            </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
	
	<section id="one">
	
	<div class="row" style="margin-top:-60px;margin-bottom:50px;">
		<h2 class="text-center" style="font-family:Aparajita;font-size:35px; "><b>Admin Dashboard</b></h2>
		
	</div>	
	<p class="text-center"><b><s:actionmessage class="small-text text-center"/></b> </p>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-3">
			<a href="<s:url action="pendingNavsAction"/>">
				<button type="button"  class="btn btn-home g-margin-t-15--xs " style="padding:5px 15px 5px 15px;width:300px;">UploadCustomerNav</button>
			</a>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-3">
			<a href="<s:url action="pendingMandateAction"/>">
				<button type="button"  class="btn btn-home g-margin-t-15--xs " style="padding:5px 15px 5px 15px;width:300px;">UpdateCustomerMandate</button>
			</a>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-3">
			<a href="<s:url action="pendingAofAction"/>">
				<button type="button"  class="btn btn-home g-margin-t-15--xs " style="padding:5px 15px 5px 15px;width:300px;">UpdateCustomerAof</button>
			</a>
		</div>
	</div>
	<hr >
	<div class="row">
		<div class="col-md-2"></div>
		<s:form  action="displayDashboardAction"  method="post" namespace="/">
		<div class="col-md-3" >
  			<s:textfield name="emailIdDashboard" class="form-control" placeholder="Enter Customer email Id"/>
		</div>
		<div class="col-md-3" >
			
          	<s:submit class="btn btn-home g-margin-t-o-5--sm" value="ViewCustomersDashboard" style="padding:5px 15px 5px 15px;width:300px;"/>
       	</div>
		</s:form>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-2"></div>
		<s:form  action="rejectedReverseFeedAction"  method="post" namespace="/">
		<div class="col-md-3" >
  			<s:textfield name="bseOrderIdDashboard" class="form-control" placeholder="Enter BSE Order Id"/>
		</div>
		<div class="col-md-3" >
			
          	<s:submit class="btn btn-home g-margin-t-o-5--sm" value="UpdateRejectedTransaction" style="padding:5px 15px 5px 15px;width:300px;"/>
       	</div>
		</s:form>
	</div>
	<hr>

   </section>
      <footer id="footer" class="midnight-blue navbar navbar-fixed-bottom" >
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a target="_blank" href="https://moneybuddy.co.in/" title="MoneyBuddy">MoneyBuddy</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="welcome">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="saveTax">Save Tax</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="<s:url action="MFexplorer"/>">Funds Explorer</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="contactUs">Contact Us</a></li>
                            </ul>
                </div>
            </div>
        </div>
    </footer>


		<script type="text/javascript"  src="assets/js/jquery.js"></script>
	    <script type="text/javascript"  src="assets/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
	    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
	    <script type="text/javascript" src="assets/js/main.js"></script>
	    <script type="text/javascript" src="assets/js/wow.min.js"></script>
		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
</body>
</html>