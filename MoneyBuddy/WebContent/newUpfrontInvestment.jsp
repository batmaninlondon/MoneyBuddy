<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Investment Details Page | Money Buddy</title>
<!-- core CSS -->
<link type="text/css" rel="stylesheet"
	href="assets/bootstrap/css/bootstrap.min.css" />
<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
<link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
<link href="assets/bootstrap/css/main.css" rel="stylesheet">
<link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
<script type="text/javascript" src="assets/js/javaScript.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
<script>
	window.Modernizr
			|| document
					.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');
</script>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
<script type="text/javascript" src="assets/js/main.js"></script>
<script type="text/javascript" src="assets/js/wow.min.js"></script>
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57-precomposed.png">

</head>

<body class="homepage bg-warning"
	onload="showNewUpfrontInvestment('<s:property value="#session.minLumsumAmt"/>');">
	<header id="header">
		<nav class="navbar navbar-inverse" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="myIndex"><img
						src="images/logo.png" alt="logo"></a>
				</div>

				<div class="collapse navbar-collapse navbar-right">
					<ul class="nav navbar-nav">
						<li class="active" id="header-nav-li"><a href="myIndex">Home</a></li>
                        <li id="header-nav-li"><a href="startSip">Start SIP</a></li>
                        <li id="header-nav-li"><a href="saveTax">Save Tax</a></li>
                        <li id="header-nav-li"><a href="aboutUs">About Us</a></li>
                        <li id="header-nav-li"><a href="blog">Blog</a></li> 
                        <li id="header-nav-li"><a href="help">Contact Us</a></li> 

						<%
							if (session.getAttribute("customerId") == null) {
						%>
						<li id="header-nav-li"><a href="login">Sign in</a></li>
						<li id="header-nav-li"><a href="register">Sign up</a></li>
						<%
							} else {
						%>
						<li id="header-nav-li"><a href="bseDashboard">Dashboard</a></li>
						<li id="header-nav-li"><a href="logOff">Log Out</a></li>
						<%
							}
						%>

					</ul>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->

	</header>
	<%
		session.setAttribute("transactionType", "UPFRONT");
	%>
	<input type="hidden" id="transactionType" value="UPFRONT" />
	<section id="one">
		<div class="row">
			<div id="investment-options" class="col-md-6 ">
				<div id="upfront-text" class="row row-fourth"
					style="margin-top: 40px; margin-bottom: 35px;">
					<div class="col-md-2"></div>
					<div class="col-md-10">
						<p style="font-size: 18px;">How much do you want to invest now?</p>
					</div>
				</div>
				
				
				
				<div id="upfront-value" class="row row-input row-fifth">
				<div class="col-md-2"></div>
				<div>
					<div class="col-md-6">
						<!-- <input id="range" type="range" min="2000" max="150000" step="500"
							value="4000" onchange="showNewUpfrontInvestment(this.value)" /> -->
						<input id="range" type="range" min="<s:property value="#session.minLumsumAmt"/>" max="150000" step="500"
							value="<s:property value="#session.minLumsumAmt"/>" onchange="showNewUpfrontInvestment(this.value)"/>
					</div>
					<div class="col-md-2"></div>
					<div class="underline small-text col-md-2"  style="padding:1px;margin-left:20px;margin-top:-10px;">
						<p>Rs. <span id="upfrontInvestment"></span></p>
						<!-- <input type="number" min="2000" max="1000000" step="500" value="4000"></input> -->
					</div>
				</div>
			</div>


				<div class="row row-second" style="margin-top: 30px;">
					<div class="col-md-2"></div>
					<div class="col-md-10">
						<h3>** Use Slider to select the Amount</h3>
					</div>
				</div>
				<div class="row row-third"></div>
			</div>
			
			<div  id="login-page" class="col-md-6 hidden" style="margin-top: 30px; margin-bottom: 35px;">
		
               		<%-- <s:textfield label="Email address" key="emailId" size="90" width="1000" id="email-id"/> --%>
	                <div class="row">
	                	<div class="col-md-1"></div>
						<div class="col-md-3">
							<label for="email-id" class="small-text" >Enter Email Id </label> 
						</div> 
						<div class="col-md-7" style="margin-top:-10px;">  	
	            			<input class="form-control" name="emailId" id="email-id" type="text" placeholder="Email Id">
	            		</div>
	            		<div class="col-md-1"></div>
	                </div>
	                <div class="row" style="margin-top:20px;">
	                	<div class="col-md-1"></div>
						<div class="col-md-3">
							<label for="password" class="small-text" >Enter Password </label> 
						</div> 
						<div class="col-md-7" style="margin-top:-10px;">  	
	            			<input class="form-control" name="password" id="password" type="password" placeholder="Password">
	            		</div>
	            		<div class="col-md-1"></div>
	                </div>

	            	<div id="button-5" class="row">
	            		<div class="col-md-5"></div>
	            		<div class="col-md-4">
							<button type="button" id="submit-button-5" class="btn btn-primary readmore" onClick="newLogin();" style="margin-top:20px;padding:5px 15px 5px 15px;">Sign in</button>
						</div>
<!-- 						<div class="col-md-2"></div> -->
						<div class="col-md-3">
							<button type="button" id="submit-button-5" class="btn btn-primary readmore" onClick="signUp();" style="margin-top:20px;padding:5px 15px 5px 15px;">Sign up</button>
						</div>
						<!-- <div class="col-md-1"></div> -->
					</div>
					<div class="row">
						<div class="col-md-5"></div>
						<div class="col-md-7">
						</br>
							<a href="forgottenPassword" id="forgot-password-submit-button" class="small-text" style="height:40px;width:300px;color:blue;">Forgot Password?</a>		
						</div>
					</div>
				
                
		
			</div> 
			
			
			
			
			<div id="invested-fund-list" class="col-md-6"
				style="margin-top: 10px; padding-left: 70px; padding-right: 70px;">
				<div id="investment-fund-list-data" class="row col-md-12">
					<div id="investmentFundData">
					<table class="table table-bordered">
						<thead class="table-head">
							<tr>
								<th class="center col-md-10">Fund Name</th>
								<!-- <th class="center">Percentage</th> -->
								<th class="center col-md-2">Amount</th>
							</tr>
						</thead>
						<tbody class="table-body">


						<s:iterator value="#session.productList" var="productListElement">
							<tr>
							    <td class="center"><s:property value="#productListElement.key"/></td>
							    <td class="center"><s:property value="#productListElement.value"/></td>
							</tr>
						</s:iterator> 


						</tbody>
					</table>
					</div>
				</div>

			</div>


			<div id="predicted-values-list" class="col-md-12"
				style="margin-top: 20px; padding-left: 130px; padding-right: 70px;">
				<div id="predicted-values-list-data" class="row col-md-12">

					<table class="table table-bordered" style="width: 1200px;">
						<thead class="table-head">
							<tr>
								<th rowspan="2" class="center col-md-3"
									style="vertical-align: middle; padding: 0px;">Invested
									Amount</th>
								<th colspan="3" rowspan="1" class="center col-md-9"
									style="padding: 1px;">Predicted Future Value</th>
							</tr>
							<tr>
								<th colspan="1" rowspan="1" class="center"
									style="font-size: 17px; padding: 0px;"><p>After 1 year</p></th>
								<th colspan="1" rowspan="1" class="center"
									style="font-size: 17px; padding: 0px;"><p>After 3 year</p></th>
								<th colspan="1" rowspan="1" class="center"
									style="font-size: 17px; padding: 0px;"><p>After 5 year</p></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="center">
									<p>
										Rs. <span id="investedAmount"></span>
									</p>
								</td>
								<td class="center">
									<div id="predictedValue1">
									<p>
										Rs. <span id="predicted-value-for-one-year"><s:property
												value="#session.predictedValueList1" /></span>
									</p>
									</div>
								</td>
								<td class="center">
									<div id="predictedValue2">
									<p>
										Rs. <span id="predicted-value-for-three-year"><s:property
												value="#session.predictedValueList3" /></span>
									</p>
									</div>
								</td>
								<td class="center">
									<div id="predictedValue3">
									<p>
										Rs. <span id="predicted-value-for-five-year"><s:property
												value="#session.predictedValueList5" /></span>
									</p>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				
				

			</div>
			
			<div class="row ">


								<%
								System.out.println("kycStaus in session in jsp: "+session.getAttribute("kycStatus"));
						    	System.out.println("custDetUploaded in session in jsp : "+session.getAttribute("custDetUploaded"));
						    	System.out.println("addCustDetUploaded in session in jsp : "+session.getAttribute("addCustDetUploaded"));
								if ("NC".equals(session.getAttribute("kycStatus"))) {
									
								
								%>
							
									<input type="hidden" id="redirectingPage" value="panCardVerifiction" />
								<%
								} else if ("DONE".equals(session.getAttribute("kycStatus"))) {
									if ("Y".equals(session.getAttribute("custDetUploaded")))  {
								%>
										<input type="hidden" id="redirectingPage" value="bankDetails" />
								<%
									}
									else {
								%>
										<input type="hidden" id="redirectingPage" value="customerDetails" />
								<%
									}
								} else  {
									if ("Y".equals(session.getAttribute("custDetUploaded")))  {
										if("Y".equals(session.getAttribute("addCustDetUploaded"))) {
											System.out.println("DownloadKycForm page ");
								%>
											<input type="hidden" id="redirectingPage" value="downloadKycForm" />
								<%
										}
										else {
											System.out.println("addCustomerDetails page ");
								%>
											<input type="hidden" id="redirectingPage" value="addCustomerDetails" />
								<%		
										}
									}
									else {
										System.out.println("customerDetails page ");
								%>
										<input type="hidden" id="redirectingPage" value="customerDetails" />
								<%
									}
									
								}
								%>
				</div>
				

			<div class="row">
				<div class="col-md-5"></div>
				<div class="col-md-2">\
					<!-- <button type="button" id="submit-button-2" class="btn btn-primary readmore"
						 onClick="showCustomerDetails();" style="width: 200px;">Continue</button> -->
					<button type="button" id="submit-button-2" class="btn btn-primary readmore"
						 onClick="openCustomerDetailsPage();" style="width: 200px;">Continue</button>
				</div>
				<div class="col-md-5"></div>
			</div>


		</div>
	</section>
	<footer id="footer" class="midnight-blue navbar navbar-fixed-bottom">
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

</body>
</html>