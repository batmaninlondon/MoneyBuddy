<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<!DOCTYPE html >
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

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>

        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
	    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
	    
	    
	    <link rel="stylesheet" href="css/style4.css">
</head>

<body style="background: url(img/1920x1080/10.jpg) 50% 0 no-repeat fixed;" onload="showNewUpfrontInvestment('<s:property value="#session.minLumsumAmt"/>');fillSipData('<s:property value="#session.minSipAmount"/>','<s:property value="#session.minSipDuration"/>');">
	<%session.setAttribute("transactionType", "SIP");%>;

	<%
	
	    if ("TRUE".equals(request.getParameter("OnetimeInvestment"))) {
	    	session.setAttribute("OnetimeInvestment", "TRUE");
	    	System.out.println("In login jsp : OnetimeInvestment set to TRUE .");
	    } else if ("FALSE".equals(request.getParameter("OnetimeInvestment"))) {
	    	session.setAttribute("OnetimeInvestment", "FALSE");
	    	System.out.println("In login jsp : OnetimeInvestment set to FALSE .");
	    }
	%>
	
	<input type="hidden" id="investmentType" value="<s:property value="#session.OnetimeInvestment"/>" />
   <div class="container ">
   		<a href="nhome.jsp" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
		</a>
	</div>
	<s:set var="fundDetails" value="#session.selectedFundDetailsDataModel" />
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:100px;">
	    	<div class="profile">
	        	<div class="name">
	        			<s:iterator value="#session.productList" var="productListElement">
	        			</s:iterator> 
	                	<h3 class="title g-color--white"><s:property value="#fundDetails.fundName"/></h3>
						<h6 style="color:white;">Payment Page</h6>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<div class="row" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " style="height:400px">
	    	<div class="row" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " style="height:500px">
			<div class="form">
				<ul class="tab-group">
	       			<li class="tab active"><a href="#upfrontInvestmentDetails">One Time</a></li>
	        		<li class="tab"><a href="#sipInvestmentDetails">SIP</a></li>
	      		</ul>
	      	</div>
      		<div class="tab-content">
	    		<div  id="upfrontInvestmentDetails" >
	    			<input type="hidden" id="transactionType" value="UPFRONT" />
	        		<div class="name">
						<div class="row">
							<div id="investment-options" class="col-md-6 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 35px;">Select slider to enter amount you want to Invest</h6>
							</div>
	  					</div>
						<div id="investment-options">
							<div id="upfront-value" >
								<div class="row">
									<div class="col-md-4 g-color--primary">
										<input id="range" type="range" min="<s:property value="#session.minLumsumAmt"/>" max="150000" step="500"
												 value="<s:property value="#session.minLumsumAmt"/>" onchange="showNewUpfrontInvestment(this.value)"/>
									</div>
									<div class="col-md-4"  style="padding:1px;margin-left:20px;margin-top:-10px;">
									<p>Rs. <span id="upfrontInvestment" class="g-color--black"></span></p>
									</div>
									<div class="col-md-2"></div>
								</div>
							</div>
	  					</div>
	  					<div class="row">
							<div id="investment-options" class="col-md-6 ">
								<button type="button" class="btn  " onClick="createCart();" style="background-color:black; margin-top: 20px; margin-bottom: 35px;color:white;">Add to Cart</button>
							</div>
	  					</div>
					</div>
	       		</div>
	       		<div  id="sipInvestmentDetails" >
   					<input type="hidden" id="transactionType" value="SIP" />
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
	  					
					</div>
	       	
	       	</div>
	       	</div>
	       	
	     </div>
	     <div class="col-md-1 col-xs-1" style="height:500px"></div>
	</div>
	     </div>
	     <div class="col-md-1 col-xs-1" style="height:400px"></div>
	</div>
	
	
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:60px;">
	    	<div class="profile">
	        	<div class="name g-text-right--xs g-margin-r-10--xs" >
	                <button type="button" id="submit-button-2" class="btn " onClick="openCustomerDetailsPage();" style="background-color:black; ">Continue</button>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	

<script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
    	<script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
   	 	<script src="assets/js/main.js"></script>
    	<script src="assets/js/wow.min.js"></script>


        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.parallax.min.js"></script>
        <script type="text/javascript" src="vendor/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>

        <!-- General Components and Settings -->
        <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="js/components/faq.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
         <script  src="js/index.js"></script>	
</body>
	

</html>
