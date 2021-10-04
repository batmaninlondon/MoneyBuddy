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
        
        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
         <link type="text/css" rel="stylesheet" href="assets/css/style2.css">

    </head>

<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;">
   <div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="MoneyBuddy Logo">
		</a>
	</div>
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:70px;">
	    	<div class="profile">
	        	<div class="name pagination">
	                	<%  
	                	if(session.getAttribute("customerName") == null || "".equals(session.getAttribute("customerName")))
					 	{   
					 	%>
					 	<h3 class="title g-color--white">Your Investment will be linked with:&nbsp;&nbsp;&nbsp;&nbsp;<b><s:property value="#session.emailId" /></b></h3>
					 	<%
					 	}
	                	else 
	                	{
					 	%>
					 	<h3 class="title g-color--white">Investor Name:&nbsp;&nbsp;&nbsp;&nbsp;<b><s:property value="#session.customerName" /></b></h3>
					 	<%
	                	}
					 	%>
						<%-- <h6 style="color:white;"><s:property value="#session.customerMobileNumber" /></h6> --%>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<div class="row g-height-auto--lg" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
			<div class="row text-center g-margin-t-10--xs">
				<h3><b><u>Portfolio Cart for Lumpsum Investment</u></b></h3>
			</div>
			<div id="customer-cart-list" class=" g-margin-b-30--xs g-margin-t-30--xs g-margin-r-100--xs g-margin-l-100--xs">
					<table id="cartData" class="table table-bordered stripe ">
						<thead class="table-head g-font-size-14--xs">
							<tr>
								<th class="text-center col-md-3 g-bg-color--gray-light">Fund Name</th>
								<th class="text-center col-md-3 g-bg-color--gray-light">Amount</th>
								 <s:set var="allFolio" value="allNewFolio" />
								 
								  <s:if test="'FALSE'.equals(#allFolio) ">
									<th class="text-center col-md-3 g-bg-color--gray-light">Folio No.</th>
									</s:if>
								<th class="text-center col-md-3 g-bg-color--gray-light"></th>
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs">
							<s:iterator value="#session.customerCartUpfrontList" var="customerCartListElement">
								<tr>
								    <s:if test="schemeName.equals('Total')">
								    	<td class="text-center g-font-size-14--xs g-bg-color--gray-light"><b><s:property value="#customerCartListElement.schemeName"/></b></td>
								    	<td class="text-center g-font-size-14--xs g-bg-color--gray-light "><b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.amount]})}"/></b></td>
								    	<s:if test="'FALSE'.equals(#allFolio) ">
								    		<td class="g-bg-color--gray-light"></td>
							    		</s:if>
								    	<td class="g-bg-color--gray-light"></td>
								    </s:if>
									<s:else>
								    	<s:set var="selectedCartId" value="#customerCartListElement.cartId" />
								    	<s:set var="folios" value="#customerCartListElement.folioNumber" />
								    	<td class="text-center g-font-size-14--xs"><s:property value="#customerCartListElement.schemeName"/></td>
								    	<td class="text-center g-font-size-14--xs "><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.amount]})}"/></td>
								    	<s:if test="'FALSE'.equals(#allFolio) ">
									    	<td class="text-center g-font-size-14--xs ">
									    		<s:if test="folioNumber.equals('New')">
									    			new folio
								    			</s:if>
								    			<s:else>
								    				<s:property value="#customerCartListElement.folioNumber"/>
								    			</s:else>
	
								    		</td>
							    		</s:if>
							    		<td class="text-center">
							    			<button type="button" class="text-center btn-link" onClick="deleteCartEntry(<s:property value="selectedCartId" />);" >Remove</button>
							    		</td>
								    </s:else>
								</tr>
							</s:iterator> 
						</tbody>
					</table>
			</div>
				<s:form  action="deleteCartEntryAction" method="post" name="formDeleteCart">
			  		<s:hidden id="cart-id-value" name="cartId"></s:hidden>
  				</s:form>
	     </div>
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:40px;">
			

	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="<s:url action="MFexplorer"/>" class="btn btn-home g-color--white "   >Back</a>
		</div>
		<div class="col-md-2">
			<a href="<s:url action="MFexplorer"/>" class="btn btn-home g-color--white "  >Add more</a>
		</div>
		<div class="col-md-2">
			<s:form action="redirectAction" method="post">
	        			
      			<s:if test="#session.customerCartUpfrontList.size() == 1 ">
      				<button type="button"  class="btn btn-home g-color--white disabled"  >Continue</button>
      			</s:if>
      			<s:else>
      				<s:submit class="btn btn-home g-color--white  " value="Continue" />
      			</s:else>
      			<s:hidden name="transactionType" value="UPFRONT"/>
      		</s:form>
		</div>
		<div class="col-md-3"></div>
	</div>
	
</body>
	
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
    <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
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
</html>
