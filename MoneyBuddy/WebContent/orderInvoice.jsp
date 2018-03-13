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
        
        <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />

        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/material-kit.css" rel="stylesheet"/>
        
        
        

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

<body style="background-color:#cecece">
    
   <div class="container ">
   		<a href="nhome.jsp" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
		</a>
	</div>
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:100px;">
	    	<div class="profile">
	        	<div class="name">
	                	<h3 class="title g-color--white">thank you </h3>
						<h6 style="color:white;">you order invoice details</h6>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<div class="row g-height-auto--lg" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
		<p>MIn SIP amount <s:property value="#session.minSipAmount"/></p>
			<div id="customer-cart-list" class=" g-margin-b-30--xs g-margin-t-30--xs g-margin-r-100--xs g-margin-l-100--xs">
					<table id="cartData" class="table table-bordered stripe ">
						<thead class="table-head g-font-size-14--xs">
							<tr>
								<th class="center col-md-4 g-bg-color--gray-light">Id</th>
								<th class="center col-md-4 g-bg-color--gray-light">Fund Name</th>
								<th class="center col-md-4 g-bg-color--gray-light">Amount</th>
								<th class="center col-md-4 g-bg-color--gray-light">Date</th>
								<th class="center col-md-4 g-bg-color--gray-light">Status</th>
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs">
							<s:iterator value="#session.orderDataModel" var="orderDataModelElement">
								<tr>
								    <td class="center g-font-size-14--xs"><s:property value="#orderDataModelElement.transactionId"/></td>
								    <td class="center g-font-size-14--xs"><s:property value="#orderDataModelElement.fundName"/></td>
								    <td class="center g-font-size-14--xs"><s:property value="#orderDataModelElement.amount"/></td>
								    <td class="center g-font-size-14--xs"><s:property value="#orderDataModelElement.transactionDate"/></td>
								    <td class="center g-font-size-14--xs"><s:property value="#orderDataModelElement.transactionStatus"/></td>
								</tr>
							</s:iterator> 
						</tbody>
					</table>
			</div>
	     </div>
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	
	
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:60px;">
	    	<div class="profile">
	        	<div class="name g-text-right--xs g-margin-r-10--xs" >
	                	<button type="button"  class="btn " onClick="openCustomerDetailsPage();" style="background-color:black; ">Pay Now</button>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
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

</body>
	

</html>
