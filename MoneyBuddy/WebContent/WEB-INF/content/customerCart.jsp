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
        
        <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" /> -->
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <!-- <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet"> -->

		<link type="text/css" rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="assets/css/bootstrap/font-awesome.min.css" >
	
        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->
        
        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <!-- <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/> -->

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
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:100px;">
	    	<div class="profile">
	        	<div class="name">
	                	<h3 class="title g-color--white"><s:property value="#session.emailId" /></h3>
						<h6 style="color:white;"><s:property value="#session.customerMobileNumber" /></h6>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<div class="row g-height-auto--lg" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
			<div id="customer-cart-list" class=" g-margin-b-30--xs g-margin-t-30--xs g-margin-r-100--xs g-margin-l-100--xs">
					<table id="cartData" class="table table-bordered stripe ">
						<thead class="table-head g-font-size-14--xs">
							<tr>
								<th class="center col-md-3 g-bg-color--gray-light">Fund Name</th>
								<th class="center col-md-3 g-bg-color--gray-light">Amount</th>
								<th class="center col-md-3 g-bg-color--gray-light">Folio No.</th>
								<th class="center col-md-3 g-bg-color--gray-light"></th>
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs">
							<s:iterator value="#session.customerCartList" var="customerCartListElement">
								<tr>
								    <s:if test="productName.equals('Total')">
								    	<td class="center g-font-size-14--xs g-bg-color--gray-light"><b><s:property value="#customerCartListElement.productName"/></b></td>
								    	<td class="center g-font-size-14--xs g-bg-color--gray-light g-text-right--xs"><b><s:property value="#customerCartListElement.amount"/></b></td>
								    	<td class="g-bg-color--gray-light"></td>
								    	<td class="g-bg-color--gray-light"></td>
								    </s:if>
									<s:else>
								    	<s:set var="selectedCartId" value="#customerCartListElement.cartId" />
								    	<s:set var="folios" value="#customerCartListElement.folioNumber" />
								    	<td class="center g-font-size-14--xs"><s:property value="#customerCartListElement.productName"/></td>
								    	<td class="center g-font-size-14--xs g-text-right--xs"><s:property value="#customerCartListElement.amount"/></td>
								    	<td class="center g-font-size-14--xs g-text-right--xs">
								    		<s:property value="#customerCartListElement.folioNumber"/>

							    		</td>
							    		<td class="center">
							    			<button type="button" class=" btn-link" onClick="deleteCartEntry(<s:property value="selectedCartId" />);" >Delete from cart</button>
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
		
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:60px;">
			
	    	<div class="profile">
	        	<div class="name g-text-right--xs g-margin-r-9--xs" >
	        		<s:form action="redirectAction" method="post">
	        			<s:if test="#session.customerCartList.size() == 1 ">
	        				<a href="<s:url action="MFexplorer"/>" class="btn g-color--white "  style="background-color:black;" >Back</a>
	        				<button type="button"  class="btn g-color--white g-margin-t-15--xs disabled"  style="background-color:black; ">Continue</button>
	        				<%-- <s:submit class="btn g-color--white g-margin-t-15--xs disabled" value="Continue" style="background-color:black; "/> --%>
	        			
	        			</s:if>
	        			<s:else>
	        			<a href="<s:url action="MFexplorer"/>" class="btn g-color--white "  style="background-color:black;" >Add more to Cart</a>
	        			<!-- <button type="button"  class="btn g-color--white "  style="background-color:black;" onClick="allFunds.jsp" >Back</button> -->
	        				<s:submit class="btn g-color--white g-margin-t-15--xs " value="Continue" style="background-color:black; "/>
	        			</s:else>
	        		</s:form>
	                	<%-- <button type="button"  class="btn g-color--white g-margin-t-15--xs <s:if test="#session.customerCartList.size() == 1 ">disabled</s:if>" onClick="openCustomerDetailsPage();" style="background-color:black; ">Continue</button> --%>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	
</body>
	
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
    <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
 	<script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>
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
