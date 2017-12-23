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
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script type="text/javascript"  src="assets/js/jquery.js"></script>
    <script type="text/javascript"  src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    <script type="text/javascript" src="assets/js/wow.min.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">

</head>

<body class="homepage bg-warning" onload="setInitialUpfrontInvestment();">
   <header id="header">
<!--         <div class="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-4">
                        <div class="top-number"><p><i class="fa fa-phone-square"></i>  +91 9971648736</p></div>
                    </div>
                    <div class="col-sm-6 col-xs-8">
                       <div class="social">
                            <ul class="social-share">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li> 
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-skype"></i></a></li>
                            </ul>
                       </div>
                    </div>
                </div>
            </div>/.container
        </div>/.top-bar -->

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="myIndex"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="active" id="header-nav-li"><a href="myIndex">Home</a></li>
                        <li id="header-nav-li"><a href="startSip">Start SIP</a></li>
                        <li id="header-nav-li"><a href="saveTax">Save Tax</a></li>
                        <li id="header-nav-li"><a href="aboutUs">About Us</a></li>
                        <li id="header-nav-li"><a href="blog">Blog</a></li> 
                        <li id="header-nav-li"><a href="help">Contact Us</a></li>  
                       
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li id="header-nav-li"><a href="login" >Sign in</a></li>
										<li id="header-nav-li"><a href="register" >Sign up</a></li> 
							<%	} else 
							 	{	%>
							 			 <li id="header-nav-li"><a href="bseDashboard" >Dashboard</a></li> 
							 			 <li id="header-nav-li"><a href="logOff" >Log Out</a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
	
	<section id="bankDetails">
	
	<div class="row" style="margin-top:-60px;margin-bottom:50px;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h2 style="font-family:Aparajita;font-size:35px;"><b>Let's link your bank account with your Mutual funds</b></h2>
		</div>
		<div class="col-md-3"></div>
	</div>	
	<div class="row" style="margin-top:-20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="bank-name" style="font-family:Aparajita;font-size:25px;" class="pull-right">Select your Bank </label></div>
			<div  class="col-md-6" >				  
				<select class="form-control" id="bank-name" name="bankName">
			        <option value="ICICI">ICICI Bank</option>
			        <option value="SBI">SBI Bank</option>
			        <option value="HDFC">HDFC Bank</option>
			        <option value="KOTAK">KOTAK Bank</option>
	      		</select>
			</div>
		</div>
		<div class="col-md-3">

		</div>

	</div>
	
	<div class="row" style="margin-top:-20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="account-type" style="font-family:Aparajita;font-size:25px;" class="pull-right">Account Type </label></div>
			<div  class="col-md-6" >				  
				<select class="form-control" id="account-type" name="accountType">
			        <option value="CB">Current Account</option>
			        <option value="SB">Saving Account</option>
			        <option value="NE">NRI - Repatriable (NRE)</option>
			        <option value="NO">NRI - Repatriable (NRO)</option>
	      		</select>
			</div>
		</div>
		<div class="col-md-3">

		</div>

	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="account-number" style="font-family:Aparajita;font-size:25px;" class="pull-right" >Account Number </label></div>
			<div  class="col-md-6" >
				  
				  <input class="form-control" id="account-number" type="text" placeholder="Enter Account Number" style="margin-top:-10px;">
			</div>
		</div>
		<div class="col-md-3">
		</div>
	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="re-account-number" style="font-family:Aparajita;font-size:25px;" class="pull-right" >Re-enter Account Number </label></div>
			<div class="col-md-6" >
				  
				  <input class="form-control" id="re-account-number" type="password" placeholder="Enter Account Number" style="margin-top:-10px;">
			</div>
		</div>
		<div class="col-md-3">
		</div>
	</div>

	<div class="row" style="margin-top:20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="ifsc-code" style="font-family:Aparajita;font-size:25px;" class="pull-right" >IFSC Code </label></div>
			<div class="col-md-6" >
				  
				  <input class="form-control" id="ifsc-code" type="text" placeholder="Enter IFSC Code" style="margin-top:-10px;">
			</div>
		</div>
		<div class="col-md-3">
		</div>
	</div>
		<div  id="invested-fund-list" class="row" style="margin-top:20px;padding-left:70px;padding-right:70px;">
			<div class="col-md-2"></div>
			<div id = "investment-fund-list-data" class ="col-md-8">
			<table class="table table-bordered" >
				<thead class="table-head">
					<tr>
						<th class="center col-md-9">Fund Name</th>
						<!-- <th class="center">Percentage</th> -->
						<th class="center col-md-3">Amount</th>
					</tr>
				</thead>
				<tbody class="table-body" >

						<s:iterator value="#session.productList" var="productListElement">
							<tr>
							    <td class="center"><s:property value="#productListElement.key"/></td>
							    <td class="center"><s:property value="#productListElement.value"/></td>
							</tr>
						</s:iterator>
						<tr>
						    <td class="center" style="padding:0px;vertical-align: middle;"><b>Total : Rs. <s:property value="#session.totalInvestment"/></b></td>
						    <%-- <td class="center"><s:property value="#productListElement.value"/></td> --%>
						    <td class="center" style="padding:0px;">
						    <button type="button" id="submit-button-1" class="btn btn-primary readmore submit-button-1" onClick="populateBankDetails();">Pay Now</button>
						    </td>
						</tr>


				</tbody>
   			</table>
   			</div>
			<div class="col-md-2"></div>
		</div>
   </section>
      <footer id="footer" class="midnight-blue navbar navbar-fixed-bottom" >
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a target="_blank" href="http://quantwealth.in/" title="MoneyBuddy">MoneyBuddy</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="myIndex">Home</a></li>
                        <li><a href="aboutUs">About Us</a></li>
                        <li><a href="help">Contact Us</a></li>
                        <li><a href="register">Sign Up</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>



		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</body>
</html>