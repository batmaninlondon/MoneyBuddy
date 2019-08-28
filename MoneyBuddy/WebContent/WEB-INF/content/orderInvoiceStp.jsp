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
	
	<script>
    (function(h,o,t,j,a,r){
        h.hj=h.hj||function(){(h.hj.q=h.hj.q||[]).push(arguments)};
        h._hjSettings={hjid:1416665,hjsv:6};
        a=o.getElementsByTagName('head')[0];
        r=o.createElement('script');r.async=1;
        r.src=t+h._hjSettings.hjid+j+h._hjSettings.hjsv;
        a.appendChild(r);
    })(window,document,'https://static.hotjar.com/c/hotjar-','.js?sv=');
</script>


    </head>

<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;">
   <div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="MoneyBuddy Logo">
		</a>
	</div>
	<div class="row">
		<div class="col-xs-1"></div>
		<div class="col-xs-10  g-height-50--xs g-height-80--lg g-bg-color--dark ">
	    	<div class="profile text-center">
	        	<div class="name pagination text-center">
	                	<h3 class="title g-font-size-14--xs g-font-size-24--lg g-color--white">Thank you for STP </h3>
	                	<h6 class="g-font-size-12--xs g-font-size-16--lg g-color--white">Your STP details </h6>
	            </div>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
	
	<div class="row g-height-auto--lg" >
		<div class="col-xs-1" ></div>
		<div class="col-xs-10  g-bg-color--white " >
			<div id="customer-stp-cart-list" class="g-margin-t-20--xs g-margin-b-30--lg g-margin-t-10--lg g-margin-r-100--lg g-margin-l-100--lg">
					
				  		<table id="cartData" class="table table-bordered stripe ">
										<thead class="table-head g-font-size-12--xs g-font-size-14--lg center text-center g-bg-color--gray-light">
											<tr>
												<th class="col-xs-2">Fund Name A</th>
												<th class="col-xs-2">Folio Num</th>
												<th class="col-xs-2">Fund NameB</th>
												<th class="col-xs-2">Amount</th>
												<th class="col-xs-2">Tenure</th>
												<th class="col-xs-2">Debit Date</th>
											</tr>
										</thead>
										<tbody class="table-body g-font-size-10--xs g-font-size-14--lg center  text-center">
												<s:iterator value="#session.customerStpCartList" var="stpCartListElement">
													<tr>
													    <s:if test="schemeName.equals('Total')">
													    	<td>
														    	<b><s:property value="#stpCartListElement.withdrawalSchemeName"/></b>
													    	</td>
													    	<td>
												    		</td>
												    		<td>
												    		</td>
													    	<td>
														    	<b><s:property value="#redCartListElement.stpAmount"/></b>
												    		</td>
												    		<td>
												    		</td>
												    		<td>
												    		</td>
													    </s:if>
													    <s:else>
													    	
													    	<td>
														    	<b><s:property value="#stpCartListElement.withdrawalSchemeName"/></b>
													    	</td>
													    	<td>
														    	<b><s:property value="#stpCartListElement.folioNumber"/></b>
													    	</td>
													    	<td>
														    	<b><s:property value="#stpCartListElement.purchaseFundSchemeName"/></b>
												    		</td>
												    		<td>
														    	<b><s:property value="#stpCartListElement.stpAmount"/></b>
												    		</td>
													    	<td>
														    	<b><s:property value="#stpCartListElement.stpDuration"/></b>
												    		</td>
												    		<td>
														    	<b><s:property value="#stpCartListElement.stpDate"/></b>
												    		</td>
												    	</s:else>
													</tr>
												</s:iterator>
											 
										</tbody>
									</table>
			</div>
			
			<br/>
	     </div>
	     <div class="col-xs-1" ></div>
	</div>
	
	<div class="row">
		<div class="col-xs-1"></div>
		
		<div class="col-xs-10  g-bg-color--gray-lighter " style="height:40px;">

	     </div>
	     <div class="col-xs-1"></div>
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
		<script>
		
		
		</script>
		
</body>


</html>
