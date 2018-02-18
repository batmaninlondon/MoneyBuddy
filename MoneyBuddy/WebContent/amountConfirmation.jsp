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
        <title>Megakit - HTML5 Theme</title>
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="Megakit - HTML5 Theme">
        <meta name="author" content="keenthemes.com">
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
        
        <!-- <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />
 -->
        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
        <!-- <link href="css/material-kit.css" rel="stylesheet"/> -->
        
        
        

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        
        
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
     <script src="assets/js/sly.min.js"></script>
    <script src="assets/js/jquery.prettyPhoto.js"></script>
    <script src="assets/js/jquery.isotope.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <script src="assets/js/index.js"></script>
  
  	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
  
  
  
  	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		
		<script>
		
		$(document).ready(function() {
		    $('#cartData').DataTable( {
		        "paging":   true,
		        "ordering": false,
		        "info":     true,
		        "searching": false,
		        "responsive": true,
		        "lengthMenu": [ [5, 10, 25, 50, -1], [5, 10, 25, 50, "All"] ]
		        
		        
		    } );
		} );
		
		</script>
    </head>

<body style="background: url(img/1920x1080/10.jpg) 50% 0 no-repeat fixed;" onload="filldata('<s:property value="#session.minSipAmount"/>','<s:property value="#session.minSipDuration"/>','<s:property value="#session.minLumsumAmount"/>');">
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
   		<a href="myIndex" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="Dublin Logo">
		</a>
	</div>
	
	
	<s:set var="fundDetails" value="#session.selectedFundDetailsDataModel" />
	
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:100px;">
	    	<div class="profile">
	    		<s:iterator value="#session.productList" var="productListElement">
	        	</s:iterator> 
	        	<div class="name">
	                	<h3 class="title g-color--white"><s:property value="#fundDetails.fundName"/></h3>
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
    						<li class="active"><a data-toggle="tab" href="#onetime" onClick="newUpdate('UPFRONT');">Invest Lumsum</a></li>
   							<li><a data-toggle="tab" href="#sip" onClick="newUpdate('SIP');">Start SIP</a></li>
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
    		<div id="onetime" class="tab-pane fade in active g-margin-t-30--xs">
      			<div id="upfrontInvestmentDetails">
	    			<!-- <input type="hidden" id="transactionType" value="UPFRONT" /> -->
	        		<div class="name g-margin-t-40--xs">
						<div class="row g-margin-t-50--xs g-margin-b-50--xs">
								<div id="investment-options" class="col-md-4 col-xs-12">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Enter the amount you want to invest</p>
								</div>
								<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								<input id="upfront-investment-range" type="range" min="<s:property value="#session.minLumsumAmount"/>" max="150000" step="500"
												 value="<s:property value="#session.minLumsumAmount"/>" onchange="showNewUpfrontInvestment(this.value)"/>
								</div>
								<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Rs. <span id="upfrontInvestment" class="g-color--black"></span></p>
								<div class="col-md-5"></div>
							</div>
	  					<div class="row">
							<div class="g-bg-color--gray-lighter " style="height:60px;">
	    						<div class="profile" >
	        						<div class="name g-text-right--xs g-margin-r-10--xs" >
	        							<button type="button" class="btn  g-color--white g-margin-t-15--xs" onClick="createCart();"  style="background-color:black;" >Add to Cart</button>
	            					</div>
	       						</div>
	     					</div>
						</div>
						
					</div>
	       		</div>
    		</div>
   		 	<div id="sip" class="tab-pane fade">
      			<div  id="sipInvestmentDetails" >
   					<!-- <input type="hidden" id="transactionType" value="SIP" /> -->
	       				<div class="name">
							<div class="row g-margin-t-50--xs g-margin-b-50--xs">
								<div id="investment-options" class="col-md-5 col-xs-12">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " >How much do you want to invest monthly?</p>
								</div>
								<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								<input id="sip-amount-range" type="range" min="<s:property value="#session.minSipAmount"/>" max="150000" step="500"
												 value="<s:property value="#session.minSipAmount"/>" onchange="showSipAmountPerMonth(this.value)"/>
								</div>
								<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Rs. <span id="sipPerMonth" class="g-color--black"></span></p>
								<div class="col-md-4"></div>
							</div>
							<div class="row g-margin-t-50--xs g-margin-b-50--xs">
								<div id="investment-options" class="col-md-5 col-xs-12">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " >How long do you expect to invest for?</p>
								</div>
								<div id="duration-value"  class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								<input id="sip-duration-range" type="range" min="<s:property value="#session.minSipDuration"/>" max="50" step="1"
												 value="<s:property value="#session.minSipDuration"/>" onchange="showDuration(this.value)"/>
								</div>
								<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Yr. <span id="sip-duration" class="g-color--black"></span></p>
								<div class="col-md-4"></div>
							</div>
							<div class="row g-margin-t-50--xs g-margin-b-50--xs">
								<div id="investment-options" class="col-md-5 col-xs-12">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Select SIP installment Date</p>
								</div>
								<div id="duration-value"  class="col-md-3   col-xs-6 g-margin-l-20--xs">
									<select class="form-control" id="sip-date" name="sipDate" onChange="showDate()">
								        <option value="1">1</option>
								        <option value="5" selected>5</option>
								        <option value="10">10</option>
								        <option value="15">15</option>
								        <option value="20">20</option>
								        <option value="25">25</option>
					      			</select>
								</div>
								<div class="col-md-4"></div>
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
								<div class=" g-bg-color--gray-lighter " style="height:60px;">
	    							<div class="profile" >
	        							<div class="name g-text-right--xs g-margin-r-10--xs " >
	        								<button type="button" class="btn g-color--white g-margin-t-15--xs" onClick="openCustomerDetailsPage();"  style="background-color:black;" >Continue</button>
	            						</div>
	       							</div>
	     						</div>
							</div>
							
	  						
					</div>
	       		</div>
    </div>
    
  </div>	
  		</div>
  		<div class="col-md-1 col-xs-1" ></div>
  	</div>
  
</body>
</html>