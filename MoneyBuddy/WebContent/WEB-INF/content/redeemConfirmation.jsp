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

    </head>

<body >
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
	                	<h3 class="title g-color--white"><s:property value="redeemSchemeName"/></h3>
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
    						<li class="active"><a data-toggle="tab" href="#stp" onClick="setTransactionType('UPFRONT');">Start Redemption</a></li>
 						</ul>
  					</div>
  				</div>
  			</div>
  		</div>
  		<div class="col-md-1 col-xs-1" ></div>
  	</div>
  	
<%--   	<s:form  action="newEstimateAction" method="post" name="formEstimate">
  		<s:hidden id="upfront-investment-value" name="upfrontInvestment"></s:hidden>
		<s:hidden id="sip-amount-value" name="sipAmount"></s:hidden>
		<s:hidden id="sip-duration-value" name="sipDuration"></s:hidden>
		<s:hidden id="sip-date-value" name="sipDate"></s:hidden>
		<s:hidden id="transaction-type-value" name="transactionType"></s:hidden>
  	</s:form> --%>
  	
  	<div class="row "  >
		<div class="col-md-1 col-xs-1" > </div>
		<div class="col-md-10 col-xs-10  g-bg-color--white ">
	    <div class="tab-content">
    		<div id="stp" class="tab-pane fade in active g-margin-t-30--xs">
      			<div id="upfrontInvestmentDetails">
	    			<!-- <input type="hidden" id="transactionType" value="UPFRONT" /> -->
	        		<div class="name g-margin-t-40--xs">
						<%-- <div class="row g-margin-t-50--xs g-margin-b-50--xs">
							<div id="investment-options" class="col-md-4 col-xs-12">
								<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Fund Name</p>
							</div>
							<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
							
								<p><s:property value="redeemSchemeName"/></p>
							</div>
							<div class="col-md-5"></div>
						</div> --%>
						
						<s:form  action="redeem" method="post" name="formRedeem">
						
						 <div class="row g-text-left--xs" >
				        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs">How much do you want to redeem</div>
				        	<div class="col-md-6 col-xs-6 ">
								<s:radio list="#{'1':'Full','2':'Partial'}" value="1" name="redeemType" multiple="false" onClick="showAmtQuanOptions(this.value);"></s:radio>
				        	</div>
				        	<div class="col-md-6 col-xs-6 "></div>
				        </div>
				        <div class="row g-text-left--xs hidden" id="amount-or-quantity" >
				        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs">Select either amount or quantity</div>
				        	<div class="col-md-6 col-xs-6 ">
								<s:radio list="#{'1':'Amount','2':'Quantity'}" value="1" name="amtOrQuan" multiple="false" onClick="showAmtOrQuanOptions(this.value);"></s:radio>
				        	</div>
				        	<div class="col-md-6 col-xs-6 "></div>
				        </div>
						<div class="row g-margin-t-50--xs g-margin-b-50--xs hidden" id="redeem-amount-option">
								<div id="stp-investment-options" class="col-md-4 col-xs-12">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " > redeem amount?</p>
								</div>
								<div class="col-md-4  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								<s:fielderror fieldName="redeemAmount" class="g-color--red" />
								<s:textfield id="redeem-amount" type="number" name="redeemAmount" class="field left" value="0" required="required" min="500" step="100"/>
								</div>
								
								<div class="col-md-4"></div>
						</div>
						<div class="row g-margin-t-50--xs g-margin-b-50--xs hidden" id="redeem-quantity-option">
								<div id="stp-investment-options" class="col-md-4 col-xs-12">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " > redeem quantity?</p>
								</div>
								<div class="col-md-4  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								<s:fielderror fieldName="redeemQuantity" class="g-color--red" />
								<s:textfield id="redeem-quantity" type="number" name="redeemQuantity" class="field left" value="0" required="required" min="0" step=".50"/>
								</div>
								
								<div class="col-md-4"></div>
						</div>
						
						
							<div class="row">
								<div class="col-md-1 col-xs-1"></div>
								<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:60px;">
							    	<div class="profile">
							        	<div class="name g-text-right--xs g-margin-r-10--xs" >
						        			<button type="button"  id="redeem-button" class=" btn g-color--white g-margin-t-15--xs " 
						        					onClick="redeem('<s:property value="redeemFundId"/>','<s:property value="redeemSchemeName"/>','<s:property value="folioNum"/>','<s:property value="totalAmount"/>','<s:property value="totalQuantity"/>');" style="background-color:black; ">Continuuue</button>
							            </div>
							       	</div>
							     </div>
							     <div class="col-md-1 col-xs-1"></div>
							</div>
							<s:hidden id="redeem-fund-id" name="fundId"></s:hidden>
							<s:hidden id="redeem-scheme-name" name="schemeName"></s:hidden>
							<s:hidden id="redeem-folio-num" name="folioNumber"></s:hidden>
							<s:hidden id="redeem-total-amount" name="totalAmount"></s:hidden>
							<s:hidden id="redeem-total-quantity" name="totalQuantity"></s:hidden>
							
						</s:form>
	
						<%-- <s:form action="createCartAction" method="post" >
		  					<div class="row">
								<div class="g-bg-color--gray-lighter " style="height:60px;">
		    						<div class="profile" >
		        						<div class="name g-text-right--xs g-margin-r-10--xs" >
		        							<s:hidden id="tot-investment-id-value" name="totalInvestment"></s:hidden>
		        							<s:submit class="tn  g-color--white g-margin-t-15--xs" style="background-color:black;" value="Add to Cart" />
		        							<button type="button" class="btn  g-color--white g-margin-t-15--xs" onClick="newUpdate();"  style="background-color:black;" >Continue</button>
		            					</div>
		       						</div>
		     					</div>
							</div>
						</s:form> --%>
						
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