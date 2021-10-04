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
        
        <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
	
        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->
        
        <!-- <link href="css/material-bootstrap-wizard.css" rel="stylesheet" /> -->

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style2.css" rel="stylesheet" type="text/css"/>
        <!-- <link href="css/material-kit.css" rel="stylesheet"/> -->

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
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="MoneyBuddy Logo">
		</a>
	</div>
	<div class="row">
		<div class="col-xs-1"></div>
		<div class="col-xs-10  g-height-70--xs g-height-80--lg g-bg-color--dark ">
	    	<div class="profile">
	        	<div class="name">
	                	<h3 class="title g-font-size-14--xs g-font-size-24--lg g-color--white text-center  g-ver-center--xs ">Thank you for investing with MoneyBuddy</h3>
						<!-- <h6 class="g-font-size-12--xs g-font-size-16--lg g-color--white">Your Investment details </h6> -->
	            </div>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
	<div class="row g-height-auto--lg" >
		<div class="col-xs-1" ></div>
		<div class="col-xs-10  g-bg-color--white " >
			<div class="row text-center g-margin-t-5--xs g-margin-b-15--lg">
				<h3 class=" g-font-size-15--xs g-font-size-22--lg "><b>Payment Confirmation</b></h3>
			</div>
		<%-- <p>MIn SIP amount <s:property value="#session.minSipAmount"/></p> --%>
			<div id="customer-cart-list" class=" g-margin-t-5--xs g-margin-b-30--lg   g-margin-r-100--lg g-margin-l-100--lg">
					<s:set var="anyUpfront" value="#session.anyUpfrontOrder" />
			  		<s:set var="anySip" value="#session.anySipOrder" />
			  		<table id="cartData" class="table table-bordered stripe">
										<thead class="table-head g-font-size-12--xs g-font-size-14--lg center text-center g-bg-color--gray-light">
											<tr>
												<th class="col-xs-4 text-center">Fund Name</th>
												<th class="col-xs-2 text-center">Transaction Type</th>
												<s:if test="'TRUE'.equals(#anyUpfront) ">
													<th class="col-xs-3 text-center">Lumpsum Amount</th>
												</s:if>
												<s:else>
													<th class="col-xs-3 hidden">Lumpsum Amount</th>
												</s:else>
												<s:if test="'TRUE'.equals(#anySip) ">
													<th class="col-xs-3 text-center">SIP Amount</th>
												</s:if>
												<s:else>
													<th class="col-xs-3 hidden">SIP Amount</th>
												</s:else>
												
											</tr>
										</thead>
										<tbody class="table-body g-font-size-10--xs g-font-size-14--lg center  text-center">
												<s:iterator value="#session.customerCartList" var="customerCartListElement">
													
													    <s:if test="schemeName.equals('Total')">
													    <tr class=" g-bg-color--gray-light">
														    <td>
														    	<b><s:property value="#customerCartListElement.schemeName"/></b>
													    	</td>
														    <td>
												    		</td>
												    		<s:if test="'TRUE'.equals(#anyUpfront) ">
															    <td>
															    	<b>Rs. <s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/></b>
														    	</td>
													    	</s:if>
													    	<s:else>
														    	<td class="hidden">
															    	<b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/></b>
														    	</td>
													    	</s:else>
													    	<s:if test="'TRUE'.equals(#anySip) ">
														    	<td>
														    		<b>Rs. <s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/></b>
														    	</td>
													    	</s:if>
													    	<s:else>
														    	<td class="hidden">
														    		<b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/></b>
														    	</td>
													    	</s:else>
												    		<%-- <td>
														    	<b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/></b>
													    	</td>
													    	<td>
													    		<b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/></b>
													    	</td> --%>
													    	
												    		</tr>
												    	</s:if>
												    	<s:else>
												    	<tr>
												    		<td>
												    			<s:property value="#customerCartListElement.schemeName"/>
											    			</td>
											    			<td>
													    		<s:property value="#customerCartListElement.transactionType"/>
												    		</td>
											    			<s:if test="('TRUE'.equals(#anyUpfront)) && ('TRUE'.equals(#anySip)) ">
												    			<s:if test="transactionType.equals('UPFRONT')">
																   <td>
																    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/>
															    	</td>
															    	<td>NA</td>
														    	</s:if>
														    	<s:else>
															    	<td>NA</td>
															    	<td>
																    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/>
															    	</td>
													    		</s:else>
													    	</s:if>
													    	<s:else>
														    	<s:if test="'TRUE'.equals(#anyUpfront) ">
														    		<td>
																    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/>
															    	</td>
															    	<td class="hidden"></td>
																    	
														    	</s:if>
														    	<s:else>
														    		<td class="hidden"></td>
															    	<td>
																    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/>
															    	</td>
														    	</s:else>
												    		</s:else>
												    		<%-- <s:if test="transactionType.equals('UPFRONT')">
															    <td>
															    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/>
														    	</td>
														    	<td>
														    		NA
														    	</td>
													    	</s:if>
													    	<s:else>
														    	<td>
														    		NA
														    	</td>
														    	<td>
															    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/>
														    	</td>
													    	</s:else> --%>
													    	
												    		<s:set var="transactionType" value="#customerCartListElement.transactionType" />
												    		</tr>
												    	</s:else>
													
												</s:iterator>
											 
										</tbody>
									</table>
			</div>
	     </div>
	     <div class="col-xs-1" ></div>
	</div>
	<div class="row g-margin-t-o-20--xs">
		<div class=" col-xs-12 text-center">
		<a class="btn btn-home " href="<s:url action="Dashboard"/>" >Dashboard</a>&nbsp;&nbsp;
		<a class="btn btn-home " href="<s:url action="logOut"/>" >Log Out</a>
			<!-- <button type="button"  id="pay-now-button" class="g-display-table--xs btn btn-home g-color--white g-margin-t-15--xs " onClick=href="<s:url action="Dashboard"/>" >Invest Now</button> -->
		</div>
	</div>
<br/>
	<br/>
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
