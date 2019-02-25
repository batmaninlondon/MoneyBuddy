<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Investment Details Page | Money Buddy</title>
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css"/>
 	<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
 	<link href="assets/css/bootstrap/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/bootstrap/animate.min.css" rel="stylesheet">
    <link href="assets/prettyPhoto.css" rel="stylesheet">
    <link href="assets/css/bootstrap/main.css" rel="stylesheet">
    <link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
	<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
	
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <!-- <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png"> -->

</head>

<body class="homepage bg-warning" onload="setInitialUpfrontInvestment();">
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
                    <a class="navbar-brand" href="welcome"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="welcome" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="saveTax" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="MFexplorer"/>" class="s-header-v2__nav-link">Funds Explorer</a></li>
                                    <li class="s-header-v2__nav-item"><a href="contactUs" class="s-header-v2__nav-link">Contact Us</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
										 			<li id="dropdown-selector" class=" btn-group s-header-v2__nav-item dropdown">
				                                        <a href="#" class="s-header-v2__nav-link -is-active dropdown-toggle" data-toggle="dropdown" role="button" >List <span class="caret"></span></a>
				                                    	<ul  id="dropdown-selection" class="dropdown-menu g-margin-t-o-30--xs " role="menu">
				                                    		<li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="aboutUs">About Us</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="blog">Blog</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link  g-color--white" href="FAQs">FAQs</a></li>
													      </ul>
				                                    
				                                    </li>
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/Register</a></li>
										<%	} else 
										 	{	%>
										 			<li class="s-header-v2__nav-item"><a href="customerDashboard" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li class="s-header-v2__nav-item"><a href="<s:url action="customerCartAction"/>" class="s-header-v2__nav-link">Cart</a></li>
										 			 <li id="dropdown-selected" class=" btn-group s-header-v2__nav-item dropdown">
				                                        <a href="#" class="s-header-v2__nav-link -is-active dropdown-toggle" data-toggle="dropdown" role="button" >List <span class="caret"></span></a>
				                                    	<ul  id="dropdown-selection" class="dropdown-menu g-margin-t-o-30--xs " role="menu">
				                                    		<li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="aboutUs">About Us</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="blog">Blog</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link  g-color--white" href="FAQs">FAQs</a></li>
													      </ul>
				                                    
				                                    </li>
										 			 <li class="s-header-v2__nav-item"><a href="logOff" class="s-header-v2__nav-link">Log Out</a></li>
										<%	}	%>  
                                </ul>
                            </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>

    <div class="row" style="margin-top:50px;">
		<div class="center">
			<h2 style="font-family:Aparajita;font-size:35px;"><b>RESET PASSWORD</b></h2>
		</div>
	</div>
	
	
<%
    String hashedPassword = (String)session.getAttribute("hashedPassword");
    String emailId = (String)session.getAttribute("emailId");

%>
	
	<s:form  action="resetPasswordAction" method="post" >
	<s:set var="cusEmailId" ><%=emailId%></s:set>
	<s:set var="cusPswd" ><%=hashedPassword%></s:set>
	<s:hidden id="email-id" name="emailId" value="#cusEmailId" />
	<s:hidden id="hashed-password" name="hashedPassword" value="#cusPswd" />
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<div class="input-group input-group-lg">
    			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    			<s:fielderror fieldName="newPassword" class="g-color--red" />
			  	<s:password class="form-control" id="new-password" placeholder="Password" name="newPassword" style="width:600px;"/>
    			<!-- <input id="new-password" type="password" class="form-control" name="newPassword" placeholder="Password" style="width:600px;"> -->
	
  			</div>
		</div>
	</div>
	<div class="row">
	
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<div class="input-group input-group-lg">
    			<span class="input-group-addon" ><i class="glyphicon glyphicon-lock"></i></span>
    			<s:fielderror fieldName="confirmPassword" class="g-color--red" />
			  	<s:password class="form-control" id="confirm-password" placeholder="Confirm Password" name="confirmPassword" style="width:600px;"/>
    			<!-- <input id="confirm-password" type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" style="width:600px;"> -->
  			</div>
		</div>
	</div>
	<div class="row">
	
		<div class="col-md-5"></div>
		<div class="col-md-7">
			<div id="button-5" class="row">
				<s:submit id="submit-button-5" class="center btn btn-primary readmore submit-button-1" value="RESET PASSWORD" style="margin-top:50px; width:200px;" />
				<!-- <button type="button" id="submit-button-5" class="btn btn-primary readmore" onClick="resetPassword();" style="margin-top:50px; width:200px;">RESET PASSWORD</button> -->
			</div>
		</div>
	</div>
	</s:form>
	
   </section>
      <footer id="footer" class="midnight-blue navbar navbar-fixed-bottom" >
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a target="_blank" href="http://quantwealth.in/" title="MoneyBuddy">MoneyBuddy</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="welcome">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="saveTax">Save Tax</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="allFunds">Funds Explorer</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="FAQs">Help</a></li>
                            </ul>
                </div>
            </div>
        </div>
    </footer>

		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
	 	<script type="text/javascript"  src="assets/js/jquery.js"></script>
	    <script type="text/javascript"  src="assets/js/bootstrap/bootstrap.min.js"></script>
	    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
	    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
	    <script type="text/javascript" src="assets/js/main.js"></script>
	    <script type="text/javascript" src="assets/js/wow.min.js"></script>

		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
</body>
</html>