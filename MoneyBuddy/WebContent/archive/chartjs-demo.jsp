<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html> --%>

<html lang="en">
<head>

<%
response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
response.setHeader("Pragma","no-cache");
%>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
    <!-- <meta charset="utf-8"/> -->
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Dashboard | Money Buddy</title>
    <!-- core CSS -->
    
  
  
  
  
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
<!-- 	<script src="assets/js/jquery.js"></script> -->
 	<%-- <script src="assets/js/jquery.js"></script> --%>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.prettyPhoto.js"></script>
    <script src="assets/js/jquery.isotope.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    

<script src="assets/js/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<%-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	
</script> --%>


    

</head>

<body class="homepage " >

<div id="preloader">
      <div id="status">
        <img alt="logo" src="images/logo.png">
      </div>
    </div>


   <header id="header">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="welcome"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li id="header-nav-li"><a href="welcome"><b>Home</b></a></li>
                        <li  id="header-nav-li"><a href="saveTax"><b>Save Tax</b></a></li>
                        <li id="header-nav-li"><a href="aboutUs"><b>About Us</b></a></li>
                        <li id="header-nav-li"><a href="blog"><b>Blog</b></a></li> 
                        <li id="header-nav-li"><a href="help"><b>FAQs</b></a></li> 
                        <li id="header-nav-li"><a href="contactUs"><b>Contact Us</b></a></li>
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li id="header-nav-li"><a href="login" ><b>Sign in</b></a></li>
										<li id="header-nav-li"><a href="register" ><b>Sign up</b></a></li> 
							<%	} else 
							 	{	%>
							 			 <li class="active" id="header-nav-li"><a href="bseDashboard" ><b>Dashboard</b></a></li> 
							 			 <li id="header-nav-li"><a href="logOff" ><b>Log Out</b></a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
    <section id="bseDashboard">

	<ul class="nav nav-tabs">
	    <li class="active"><a data-toggle="tab" href="#dashboard">Portfolio</a></li>

  	</ul>
  <div class="tab-content">
	
	<div id="dashboard" class="tab-pane active" style="" >
		<div class="row" id="dashboard-data-list">
			<div class="col-md-12" style="margin:20px;">
				<div class="tab-pane fade-in active">
				
					<canvas id="canvas" style="position: relative; height:40vh; width:80vw"></canvas>

				</div>
			</div>
		</div>

	</div>
  </div>
   </section>
        <footer id="footer" class="midnight-blue  navbar navbar-fixed-bottom">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a href="#" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
                </div>
                
                
                
                <div class="col-sm-6">
                    <ul class="pull-right">
                       <li><a href="https://www.facebook.com/MoneyBuddyIndia"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="https://twitter.com/MoneyBuddyIndia"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="https://www.linkedin.com/in/money-buddy-94a73814a/"><i class="fa fa-linkedin"></i></a></li> 
                                <li><a href="https://www.YouTube.com/MoneyBuddy"><i class="fa fa-youtube"></i></a></li>
                                
                    </ul>
                </div>
            </div>
        </div>
    </footer>


	<script type="text/javascript" src="assets/js/Chart.min.js"></script>
	<script type="text/javascript" src="assets/js/ts-chart-script.js"></script>
	
</body>
</html>


<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <script src="assets/js/jquery-3.2.1.min"></script>
  <script type="text/javascript" src="assets/js/Chart.min.js"></script>
  <script type="text/javascript" src="assets/js/ts-chart-script.js"></script>
<title>Insert title here</title>
</head>
<body>

<h1>Hello </h1>
<canvas id="canvas" height="500" width="500"></canvas>
 <h1>Hello </h1> 

</body>
</html> --%>