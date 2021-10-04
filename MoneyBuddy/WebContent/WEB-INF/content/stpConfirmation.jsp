<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="en">
<head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy - Top Performing Mutual Funds</title>
        <meta http-equiv="Cache-control" content="max-age=2592000, public">
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">

		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		
        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->
        
        <!-- <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />
 -->
        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <!-- <link href="css/material-kit.css" rel="stylesheet"/> -->

        <!-- <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>  -->

    </head>

<body style="background: url(img/1920x1080/10.jpg) 50% 0 no-repeat fixed;" onload="filldata('<s:property value="#session.minSipAmount"/>','<s:property value="#session.minSipDuration"/>','<s:property value="#session.minPurchaseAmount"/>');">
<%-- <%session.setAttribute("transactionType", "SIP");%>; --%>
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
	<!-- <input type="hidden" id="transactionType" value="UPFRONT" /> -->
	
	<div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="MoneyBuddy Logo">
		</a>
	</div>
	
	<s:set var="schemeNameA" value="schemeName" />
	
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:100px;">
	    	<div class="profile">
	    		<s:iterator value="#session.productList" var="productListElement">
	        	</s:iterator> 
	        	<div class="name">
	                	<h3 class="title g-color--white"><s:property value="#schemeNameA"/></h3>
						<h6 style="color:white;"><s:property value="#session.customerMobileNumber" /></h6>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>

	<div class="row" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white ">
	    	<div class="profile">
				<div class="name">
			    	<div class="container">
			    	<br/>
  						<ul class="nav nav-tabs">
    						<li class="active"><a data-toggle="tab" href="#stp" onClick="setTransactionType('UPFRONT');">Start STP</a></li>
 						</ul>
  					</div>
  				</div>
  			</div>
  		</div>
  		<div class="col-md-1 col-xs-1" ></div>
  	</div>
  	
 	
  	<div class="row "  >
		<div class="col-md-1 col-xs-1" > </div>
		<div class="col-md-10 col-xs-10  g-bg-color--white ">
	    <div class="tab-content">
    		<div id="stp" class="tab-pane fade in active g-margin-t-30--xs">
      			<div id="upfrontInvestmentDetails">
	    			<!-- <input type="hidden" id="transactionType" value="UPFRONT" /> -->
	        		<div class="name g-margin-t-40--xs">
						<div class="row g-margin-t-50--xs g-margin-b-50--xs">
							<div id="investment-options" class="col-md-4 col-xs-12">
								<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Fund A</p>
							</div>
							<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
							
							<s:textfield id="scheme-name-a" name="schemeNameA" value="%{schemeNameA}" class="field left" readonly="true" style="width:400px" />
							</div>
							<div class="col-md-5"></div>
						</div>
						<div class="row g-margin-t-50--xs g-margin-b-50--xs">
							<div id="investment-options" class="col-md-4 col-xs-12">
								<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Fund B</p>
							</div>
							<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								<%-- <s:select class="form-control"  id="gender"
								list="#{'M':'Male', 'F':'Female'}" 
								name="gender" 
								value="M" /> --%>
								<s:select class="form-control"  label="Some label"          
								list="%{availableFundsList}"
								name="fundB" style="width:400px"/>
							</div>
							<div class="col-md-5"></div>
						</div>
						<div class="row g-margin-t-50--xs g-margin-b-50--xs">
								<div id="stp-investment-options" class="col-md-4 col-xs-12">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " > monthly STP amount?</p>
								</div>
								<div class="col-md-4  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								<input id="stp-amount-range" type="range" min="0" max="50000" step="500"
												 value="1000" onchange="showStpAmountPerMonth(this.value)"/>
								</div>
								<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Rs. <span id="stpPerMonth" class="g-color--black">1000</span></p>
								<div class="col-md-4"></div>
							</div>
						<s:form action="createCartAction" method="post" >
		  					<div class="row">
								<div class="g-bg-color--gray-lighter " style="height:60px;">
		    						<div class="profile" >
		        						<div class="name g-text-right--xs g-margin-r-10--xs" >
		        							<s:hidden id="tot-investment-id-value" name="totalInvestment"></s:hidden>
		        							<%-- <s:submit class="tn  g-color--white g-margin-t-15--xs" style="background-color:black;" value="Add to Cart" /> --%>
		        							<button type="button" class="btn  g-color--white g-margin-t-15--xs" onClick="newUpdate();"  style="background-color:black;" >Continue</button>
		            					</div>
		       						</div>
		     					</div>
							</div>
						</s:form>
						
					</div>
	       		</div>
    		</div>
    
  </div>	
  		</div>
  		<div class="col-md-1 col-xs-1" ></div>
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
</html>