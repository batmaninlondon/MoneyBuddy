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
    <meta http-equiv="Cache-control" content="max-age=2592000, public">
    <title>Investment Details Page | Money Buddy</title>
    <!-- Font Awesome -->
    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"> -->
    <!-- Google Fonts Roboto -->
    <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"> -->
    <!-- Bootstrap core CSS -->
    <!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
    <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="assets/css/stylePieChart.css">
    
    <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
    <!-- Material Design Bootstrap -->
    <<!-- link rel="stylesheet" href="css/mdb.min.css"> -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    
    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
     <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
	<!-- <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/> -->
 	<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
 	<link rel="stylesheet" href="css/mdb.min.css">
 	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/prettyPhoto.css" rel="stylesheet">
    <link href="assets/css/bootstrap/main.css" rel="stylesheet">
    <link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
    
    <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
    
    
    
    </head>
<body class="homepage " onload="abc();">
<header id="header">

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <div class="s-header-v2__logo">
                        <a href="<s:url action="adminHome"/>" class="s-header-v2__logo-link">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
                        </a>
                    </div>
                </div>
				
                <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item col-sm-push-7"><a href="<s:url action="adminHome"/>" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item col-sm-push-8"><a href="<s:url action="logOut"/>" class="s-header-v2__nav-link">Log Out</a></li>
                                </ul>
                            </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
      <div class="container my-4">

    <hr class="my-4">
			<s:property value="businessDashboardData.signUps"/>
    <div>
      <canvas id="pieChart" style="max-width: 500px;"></canvas>
    </div>

  </div>
    <script type="text/javascript"  src="assets/js/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script type="text/javascript"  src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
    <script type="text/javascript" src="assets/js/script.js"></script>
    
    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    <script type="text/javascript" src="assets/js/wow.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.js"></script>
	
</body>
</html>