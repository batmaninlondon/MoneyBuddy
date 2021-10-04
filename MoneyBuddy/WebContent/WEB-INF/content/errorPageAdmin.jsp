<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Investment Details Page | Money Buddy</title>
    <meta http-equiv="Cache-control" content="max-age=2592000, public">
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
 	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/prettyPhoto.css" rel="stylesheet">
    <link href="assets/css/bootstrap/main.css" rel="stylesheet">
    <link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
	<!-- <script type="text/javascript" src="assets/js/javaScript.js"></script> -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
	
	<link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
        
        
 	<script type="text/javascript"  src="assets/js/jquery.js"></script>
    <script type="text/javascript"  src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
    <!-- <script type="text/javascript" src="assets/js/main.js"></script> -->
    <script type="text/javascript" src="assets/js/wow.min.js"></script>


	<style>
	    body, html {
		    height: 90%;
		    margin: 0;
		}
	
		#errorPage #container{
			/* The image used */
		    /* background-image: url('images/errorPage/error2.jpg'); */
		
		    /* Full height */
		    height: 100%; 
		
		    /* Center and scale the image nicely */
		    background-position: center;
		    background-repeat: no-repeat;
		    background-size: cover;
    
	        /* height:  1000px;
	        width:  1000px;
	        background-image: url('images/errorPage/error1.jpg') */
	    }
	    
		.center-div
		{
		     position: absolute;
		     margin: auto;
		     top: 0;
		     right: 0;
		     bottom: 0;
		     left: 0;
		     width: 500px;
		     height: 100px;
		}

	</style>


</head>

<body id="errorPage">

   <header id="header">

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="adminHome"><img src="img/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="s-header-v2__nav">
                        <li class="s-header-v2__nav-item col-sm-push-7"><a href="<s:url action="adminHome"/>" class="s-header-v2__nav-link">Home</a></li>
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
    
    <div id="container">
    
    	<div class="center-div">
    	
    		<p class="text-center g-font-size-20--xs">
    			<b>Oops!</b>
   			</p>
   			<p class="text-center g-font-size-20--xs">
   				It's not you. It's us. Give it another try, please.
   			</p>
   			<br/>
   			<div class="text-center">
   				<a href="adminHome" role="button" class=" btn btn-default ">Try Again</a>
			</div>
			
    	</div>
    </div>

      


		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<!-- <script type="text/javascript" src="assets/js/javaScript.js"></script> -->
</body>
</html>