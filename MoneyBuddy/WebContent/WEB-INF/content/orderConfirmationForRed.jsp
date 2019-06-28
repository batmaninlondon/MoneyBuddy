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
        
        <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" /> -->
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <!-- <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet"> -->
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
	
        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->
        
       <!--  <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />
 -->
        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style2.css" rel="stylesheet" type="text/css"/>
       <!--  <link href="css/material-kit.css" rel="stylesheet"/> -->
        
        
        

        <!-- Favicon -->
        <!-- <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/> -->
        
        
        
		
		<script>

		
		$(document).ready(function() {
			
			 
			 $('#cartData').DataTable( {
		        "paging":   false,
		        "ordering": false,
		        "info":     false,
		        "searching": false,
		        "responsive": true,
		        "lengthMenu": [ [5, 10, 25, 50, -1], [5, 10, 25, 50, "All"] ]
		        
		        
		    } ); 
		} );
		
		</script>
	
    </head>

<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;">
   <div class="container ">
   		<a href="welcome.jsp" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="Dublin Logo">
		</a>
	</div>
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:90px;">
	    	<div class="profile">
	        	<div class="name pagination">
	                	<s:set var="disBankName" value="displayBankName" />
	                	<h3 class="title g-color--white">Investor Name:&nbsp;&nbsp;&nbsp;&nbsp;<b><s:property value="#session.customerName" /></b>
	                	
	                	
						<!-- <h3></h3> -->
						<%-- <h6 style="color:white;"><s:property value="#session.customerMobileNumber" /></h6> --%>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	
	<s:form  action="redeemAction" method="post" name="formRedemption">
	
	
	<div class="row g-height-auto--lg" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
			<div class="row text-center g-margin-t-15--xs">
				<h3><b><u>Order Confirmation</u></b></h3>
			</div>
			<div id="customer-cart-list" class=" g-margin-b-30--xs g-margin-t-10--xs g-margin-r-100--xs g-margin-l-100--xs">
					<s:set var="anyUpfront" value="#session.anyUpfrontOrder" />
			  		<s:set var="anySip" value="#session.anySipOrder" />
				  		<table id="cartData" class="table table-bordered stripe ">
										<thead class="table-head g-font-size-14--xs">
											<tr>
												<th class="center col-md-3 g-bg-color--gray-light text-center">Fund Name</th>
												<th class="center col-md-3 g-bg-color--gray-light text-center">Redemption Type</th>
												<th class="center col-md-3 g-bg-color--gray-light text-center">Units</th>
												<th class="center col-md-3 g-bg-color--gray-light text-center">Amount*</th>
											</tr>
										</thead>
										<tbody class="table-body g-font-size-14--xs">
												<s:iterator value="#session.customerRedemptionCartList" var="redCartListElement">
													<tr>
													    <s:if test="schemeName.equals('Total')">
													    	<td class="center g-font-size-14--xs text-center">
														    	<b><s:property value="#redCartListElement.schemeName"/></b>
													    	</td>
													    	<td class="center g-font-size-14--xs text-center">
												    		</td>
													    	<td class="center g-font-size-14--xs text-center">
														    	<b><s:property value="#redCartListElement.redAmount"/></b>
												    		</td>
												    		<td class="center g-font-size-14--xs text-center">
												    		</td>
												    			
													    </s:if>
													    <s:else>
													    	
													    	<td class="center g-font-size-14--xs text-center">
														    	<b><s:property value="#redCartListElement.schemeName"/></b>
													    	</td>
													    	<td class="center g-font-size-14--xs text-center">
														    	<b><s:property value="#redCartListElement.redemptionOption"/></b>
													    	</td>
													    	<td class="center g-font-size-14--xs text-center">
														    	<b><s:property value="#redCartListElement.redAmount"/></b>
												    		</td>
												    		<td class="center g-font-size-14--xs text-center">
														    	<b><s:property value="#redCartListElement.redUnits"/></b>
												    		</td>
													    		
												    	</s:else>
													</tr>
												</s:iterator>
											 
										</tbody>
									</table>
			</div>
			
			<%-- <div class="row text-center g-margin-t-10--xs">
				<s:set var="disBankName" value="displayBankName" />
				<h3><b>Paying via:&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#disBankName"/></b></h3>
			</div> --%>
			<br/>
	     </div>
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 cold-xs-10 g-bg-color--white ">
			<div class="col-md-1 col-xs-1"></div>
			<div class="col-md-8 col-xs-8">
				<div class="row">
					<div id="investment-options" class="col-md-3 g-margin-b-20--xs">
						<b>Money will be creadited to </b>
					</div>
					<div class="col-md-2">
						<b><s:property value="#disBankName"/></b>
					</div>
		        </div>
 			</div>
					
					
		</div>
		<div class="col-md-1 col-xs-1"></div>
 					
	</div>
	
	<div class="row" >
		<div class="col-md-6 col-xs-4">
			<s:actionmessage class="small-text g-color--red"/> 
		</div>
		<div class="col-md-6 col-xs-6"></div>
	</div>
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:40px;">

	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<div class="row g-margin-t-40--xs">
		<div class="text-center">
			<a href="terms" >I agree to MoneyBuddy's Terms & Privacy Policy  <input id="iAccept" type="checkbox" onchange="activatePayNowButton();" /></a><br>
		</div>
	</div>
	
	<div class="row g-margin-t-o-20--xs">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<button type="button"  id="pay-now-button" class="text-center disabled btn btn-home g-color--white g-margin-t-15--xs " onClick="callRedemptionAction();" >Redeem Now</button>
		</div>
		<div class="col-md-5">
		</div>
	</div>
	
	</s:form>
	
	
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
		<script>
		
		
		</script>
		
</body>


</html>
