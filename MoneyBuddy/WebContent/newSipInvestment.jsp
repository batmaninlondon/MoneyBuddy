<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<!DOCTYPE html >
<html lang="en">
<head>
	<meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Investment Details Page | Money Buddy</title>
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

	<link rel="shortcut icon" href="images/ico/favicon.ico">
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
	
		<script type="text/javascript" src="assets/js/jquery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
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
	
</head>

<body style="background-color:#cecece"
	 onLoad="fillSipData('<s:property value="#session.minSipAmount"/>','<s:property value="#session.minSipDuration"/>');">
	
	<%
		session.setAttribute("transactionType", "SIP");
	%>
	<input type="hidden" id="transactionType" value="SIP" />
	
	<div class="container ">
   		<a href="nhome.jsp" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
		</a>
	</div>
	<br/>
	<br/>
	<s:set var="fundDetails" value="#session.selectedFundDetailsDataModel" />
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark ">
	    	<div class="profile">
	    		<s:iterator value="#session.productList" var="productListElement">
	        	</s:iterator> 
	        	<div class="name g-color--white">
	                	<h3 class="title g-color--white"><s:property value="#fundDetails.fundName"/> </h3>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<div class="row" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " style="height:500px">
	    	<div class="profile">
	        	<div class="name">
						<div class="row">
							<div id="investment-options" class="col-md-6 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 35px;">How much do you want to invest monthly?</h6>
							</div>
	  					</div>
						<div id="sip-value" >
							<div class="row">
								<div class="col-md-4 g-color--primary">
										<input id="range" type="range" min="<s:property value="#session.minSipAmount"/>" max="150000" step="500"
										 value="<s:property value="#session.minSipAmount"/>" onchange="showSipAmountPerMonth(this.value)"/>
								</div>
								
								<div class="col-md-4"  style="padding:1px;margin-left:20px;margin-top:-10px;">
											<p>Rs. <span id="sipPerMonth" class="g-color--black"></span></p>
								</div>
								<div class="col-md-2"></div>
							</div>
						</div>

						<div class="row">
							<div id="investment-options" class="col-md-6 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 35px;">How long do you expect to invest for?</h6>
							</div>
	  					</div>
						<div id="duration-value" >
							<div class="row">
								<div class="col-md-4 g-color--primary">
										<input id="range" type="range" min="<s:property value="#session.minSipDuration"/>" max="50" step="1"
										 value="<s:property value="#session.minSipDuration"/>" onchange="showDuration(this.value)"/>
								</div>
								
								<div class="col-md-4"  style="padding:1px;margin-left:20px;margin-top:-10px;">
											<p>Rs. <span id="sip-duration" class="g-color--black"></span></p>
								</div>
								<div class="col-md-2"></div>
							</div>
						</div>
						<div class="row">
							<div id="investment-options" class="col-md-6 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 35px;">Select SIP installment Date</h6>
							</div>
	  					</div>
						<div  class="row" >	
							<div class="col-md-2">			  
								<select class="form-control" id="sip-date" name="sipDate" onChange="showDate()">
							        <option value="1">1</option>
							        <option value="5" selected>5</option>
							        <option value="10">10</option>
							        <option value="15">15</option>
							        <option value="20">20</option>
							        <option value="25">25</option>
					      		</select>
				      		</div>
				      		<div class="col-md-10"></div>
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
										System.out.println("bankDetails page ");
								%>
										<input type="hidden" id="redirectingPage" value="bankDetails" />
								<%
									}
									else {
										System.out.println("customerDetails page ");
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
							<div id="investment-options" class="col-md-6 ">
								<button type="button" id="submit-button-2" class="btn  " onClick="openCustomerDetailsPage();" style="background-color:black; margin-top: 20px; margin-bottom: 35px;">Continue</button>
							</div>
	  					</div>
					</div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1" style="height:500px"></div>
	</div>



</body>
</html>