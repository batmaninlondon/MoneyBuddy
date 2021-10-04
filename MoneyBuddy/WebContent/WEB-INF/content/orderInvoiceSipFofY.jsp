<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.DAOClasses.Trading"%>
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
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>
        
        <link href="assets/css/material-bootstrap-wizard.css" rel="stylesheet" /> -->

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <!-- <link href="css/material-kit.css" rel="stylesheet"/> -->

		<script>
		
		$(document).ready( function addCommas() {
			var num = document.getElementById("sip-amt").innerHTML;
       		var parts = num.toString().split(".");
       		parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
       		var newSipAmount =  parts.join(".");
       		document.getElementById("sip-amt").innerHTML = newSipAmount;

		    $('#sipInvestmentData').DataTable( {
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

<body style="background-color:#cecece">
    
   <div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
		</a>
	</div>
	<div class="row">
		<div class=" col-xs-1"></div>
		<div class=" col-xs-10  g-height-70--xs g-height-80--lg g-bg-color--dark " >
	    	<div class="profile">
	        	<div class="name">
	                	<h3 class="title g-font-size-14--xs g-font-size-24--lg g-color--white">Thank you for investing with MoneyBuddy</h3>
						<h6 class="g-font-size-12--xs g-font-size-16--lg g-color--white">Your SIP investment details </h6>
	            </div>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
	<div class="row g-height-auto--lg" >
		<div class="col-xs-1" ></div>
		<div class="col-xs-10  g-bg-color--white " >
		<%-- <p>MIn SIP amount <s:property value="#session.minSipAmount"/></p> --%>
			<div id="customer-cart-list" class="g-margin-t-20--xs g-margin-b-30--lg g-margin-t-30--lg g-margin-r-100--lg g-margin-l-100--lg">
					<table id="sipInvestmentData" class="table table-bordered stripe ">
						<thead class="table-head g-font-size-12--xs g-font-size-14--lg center text-center g-bg-color--gray-light">
							<tr>
								<th class="col-xs-4">Fund Name</th>
								<th class="col-xs-4">Amount</th>
								<th class="col-xs-4">FolioNum</th>
							</tr>
						</thead>
						<tbody class="table-body g-font-size-10--xs g-font-size-14--lg center  text-center">
							<s:iterator value="#session.customerCartSipList" var="customerCartSipListElement">
								
									<s:if test="schemeName.equals('Total')">
									<tr class=" g-bg-color--gray-light">
									    <td>
									    	<b><s:property value="#customerCartSipListElement.schemeName"/></b>
									    </td>
									    <td>
									    	<b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartSipListElement.sipAmount]})}"/>&nbsp;/month</b>
								    	</td>
								    	<td></td>
								    	</tr>
							    	</s:if>
							    	<s:else>
							    	<tr>
							    		<td><s:property value="#customerCartSipListElement.schemeName"/></td>
									    <td>
									    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartSipListElement.sipAmount]})}"/>&nbsp;/month
								    	</td>
								    	<td><s:property value="#customerCartSipListElement.folioNumber"/></td>
					    			</tr>
							    	</s:else>
								
							</s:iterator>
						</tbody>
					</table>
			</div>
	     </div>
	     <div class="col-xs-1" ></div>
	</div>
	<div class="row">
		<div class="col-xs-1"></div>
		<div class="col-xs-10  g-bg-color--dark " style="height:100px;">
	    	<div class="profile">
	        	<div class="name">
	        		<h5 class="title g-color--white"> 
                		 We have received your first SIP instalment of Rs. <u id="sip-amt"><s:property value="sipAmount"/></u>
               		</h5>
                	<%-- <h5 class="title g-color--white"> 
                		Going forward, your SIP will be auto-debited on <u><s:property value="returnDate.substring(0,4)"/></u> of every month, starting from <u><s:property value="returnDate"/></u>
               		</h5> --%>
	            </div>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>

	<% 
	if(null != session.getAttribute("orderDataModel")) {
		System.out.println("orderDataModel is not null ");
		session.removeAttribute("orderDataModel");
	}
	else {
		System.out.println("orderDataModel is  null ");
	}
	/* System.out.println("calling trading ");
	Trading trading = new Trading();
	trading.checkPaymentStatus(); */
	
	%> 


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
