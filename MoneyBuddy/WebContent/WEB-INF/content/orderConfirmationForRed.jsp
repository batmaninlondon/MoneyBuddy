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
        
       <!--  <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />
 -->
        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style2.css" rel="stylesheet" type="text/css"/>
       <!--  <link href="css/material-kit.css" rel="stylesheet"/> -->

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
 	  <!--========== HEADER ==========-->
  <div class="g-bg-color--dark">
            <div class="container g-padding-y-45--xs">
        <header class="navbar-fixed-top s-header-v2 js__header-sticky">
            <!-- Navbar -->
            <nav class="s-header-v2__navbar">
                <div class="g-padding-l-80-md g-display-table--lg">
                    <!-- Navbar Row -->
                    <div class="s-header-v2__navbar-row">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="s-header-v2__navbar-col">
                            <button type="button" class="collapsed s-header-v2__toggle" data-toggle="collapse" data-target="#nav-collapse" aria-expanded="false">
                                <span class="s-header-v2__toggle-icon-bar"></span>
                            </button>
                        </div>

                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col-width--180">
                            <!-- Logo -->
                            <div class="s-header-v2__logo">
                                <a href="welcome" class="s-header-v2__logo-link">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
                                </a>
                            </div>
                            <!-- End Logo -->
                        </div>
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col-width--180"></div>
                        
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col--right g-padding-l-80-md">
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="welcome" class="s-header-v2__nav-link">Home</a></li>
                                    <!-- <li class="s-header-v2__nav-item"><a href="Fees" class="s-header-v2__nav-link">Fees</a></li> -->
                                    <li class="s-header-v2__nav-item"><a href="saveTax" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="MFexplorer"/>" class="s-header-v2__nav-link">Funds Explorer</a></li>
                                    <!-- <li class="s-header-v2__nav-item"><a href="aboutUs" class="s-header-v2__nav-link">About Us</a></li> -->
                                    <li class="s-header-v2__nav-item"><a href="https://medium.com/@moneybuddyIndia" class="s-header-v2__nav-link">Blog</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/SignUp</a></li>
										<%	} else 
										 	{	%>
										 			<li class="s-header-v2__nav-item"><a href="<s:url action="Dashboard"/>" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li id="dropdown-selector" class="dropdown s-header-v2__nav-item s-header-v2__dropdown-on-hover">
			                                        	<a href="javascript:void(0);" class="dropdown-toggle s-header-v2__nav-link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cart<span class="g-font-size-10--xs g-margin-l-5--xs ti-angle-down"></span></a>
			                                        	<ul class="dropdown-menu s-header-v2__dropdown-menu" style="min-width: 60px;">
			                                            	<li><a href="<s:url action="Cart"/>" class="s-header-v2__dropdown-menu-link">Investment Cart</a></li>
			                                            	<li><a href="<s:url action="RedCart"/>" class="s-header-v2__dropdown-menu-link">Redemption Cart</a></li>
			                                        		<li><a href="<s:url action="customerStpCartAction"/>" class="s-header-v2__dropdown-menu-link">Stp Cart</a></li>
			                                        		<li><a href="<s:url action="customerSwitchCartAction"/>" class="s-header-v2__dropdown-menu-link">Switch Cart</a></li>
			                                        	</ul>
			                                    	</li>
										 			 <li class="s-header-v2__nav-item"><a href="<s:url action="logOut"/>" class="s-header-v2__nav-link">Log Out</a></li>
										<%	}	%>  
										<li id="dropdown-selector" class="dropdown s-header-v2__nav-item s-header-v2__dropdown-on-hover">
                                        	<a href="javascript:void(0);" class="dropdown-toggle s-header-v2__nav-link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Help <span class="g-font-size-10--xs g-margin-l-5--xs ti-angle-down"></span></a>
                                        	<ul class="dropdown-menu s-header-v2__dropdown-menu">
                                            	<li><a href="FAQs" class="s-header-v2__dropdown-menu-link">FAQ</a></li>
                                            	<li><a href="contactUs" class="s-header-v2__dropdown-menu-link">Contact Us</a></li>
                                        	</ul>
                                    	</li>
                                </ul>
                            </div>
                            <!-- End Nav Menu -->
                        </div>
                    </div>
                    <!-- End Navbar Row -->
                </div>
            </nav>
            <!-- End Navbar -->
        </header>
        </div>
        </div>
        <!--========== END HEADER ==========-->
        
            
        <div class="container g-padding-y-20--xs">
            </div>
  <!--  <div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="MoneyBuddy Logo">
		</a>
	</div> -->
	<div class="row">
		<div class="col-xs-1"></div>
		<div class="col-xs-10 g-height-70--xs g-height-80--lg  g-bg-color--dark " >
	    	<div class="profile">
	        	<div class="name ">
	                	<s:set var="disBankName" value="displayBankName" />
	                	<h3 class="title g-font-size-15--xs g-font-size-20--lg  g-color--white text-center  g-ver-center--xs ">Investor Name:&nbsp;&nbsp;&nbsp;&nbsp;<b><s:property value="#session.customerName" /></b></h3>
	                	
	                	
						<!-- <h3></h3> -->
						<%-- <h6 style="color:white;"><s:property value="#session.customerMobileNumber" /></h6> --%>
	            </div>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
	
	<s:form  action="redeem" method="post" name="formRedemption">
	
	
	<div class="row g-height-auto--lg g-height-auto--xs" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
			<div class="row text-center g-margin-t-5--xs g-margin-b-15--lg">
				<h3 class=" g-font-size-15--xs g-font-size-22--lg "><b>Order Confirmation</b></h3>
			</div>
			<div id="customer-cart-list" class=" g-margin-b-30--xs g-margin-t-10--xs g-margin-r-100--lg g-margin-l-100--lg">
					<s:set var="anyUpfront" value="#session.anyUpfrontOrder" />
			  		<s:set var="anySip" value="#session.anySipOrder" />
				  		<table id="cartData" class="table table-bordered stripe ">
										<thead class="table-head g-font-size-12--xs g-font-size-14--lg g-bg-color--gray-light center text-center">
											<tr>
												<th class="col-xs-6 text-center">Fund Name</th>
												<!-- <th class="col-xs-3">Redemption Type</th> -->
												<!-- <th class="col-xs-3">Units</th> -->
												<th class="col-xs-6 text-center">Details</th>
											</tr>
										</thead>
										<tbody class="table-body  g-font-size-12--xs g-font-size-14--lg center text-center">
												<s:iterator value="#session.customerRedemptionCartList" var="redCartListElement">
													<tr>
													    <s:if test="schemeName.equals('Total')">
													    	<%-- <td>
														    	<b><s:property value="#redCartListElement.schemeName"/></b>
													    	</td> --%>
													    	<!-- <td>
												    		</td> -->
													    	<%-- <td>
														    	<b>Rs. <s:property value="%{getText('{0,number,#,##0}',{#attr[#redCartListElement.redAmount]})}"/></b>
												    		</td> --%>
												    		<!-- <td>
												    		</td> -->
												    			
													    </s:if>
													    <s:else>
													    	
													    	<td>
														    	<s:property value="#redCartListElement.schemeName"/>
													    	</td>
													    	<%-- <td>
														    	<b><s:property value="#redCartListElement.redemptionOption"/></b>
													    	</td> --%>
													    	<td>
													    		<s:if test="redemptionOption.equals('Full')">
													    			All units
												    			</s:if>
												    			<s:else>
												    				<s:if test="redemptionType.equals('Amount')">
												    					Amount: Rs. <s:property value="%{getText('{0,number,#,##0}',{#attr[#redCartListElement.redAmount]})}"/>
												    				</s:if>
												    				<s:else>
												    					Units: <s:property value="%{getText('{0,number,#,##0}',{#attr[#redCartListElement.redUnits]})}"/>
												    				</s:else>
											    				</s:else>
												    		</td>
												    		<%-- <td>
														    	<b><s:property value="#redCartListElement.redUnits"/></b>
												    		</td> --%>
													    		
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
	     <div class="col-xs-1" ></div>
	</div>
	<%-- <div class="row">
		<div class="col-xs-1"></div>
		
		<div class="col-xs-10  g-bg-color--white g-margin-t-o-30--xs g-margin-t-o-0--lg" style="height:40px;">
			<div class="row g-font-size-10--xs g-font-size-14--lg">
					<div class="col-md-1 col-xs-0"></div>
					<div id="investment-options" class="col-md-3 col-xs-5 ">
						<b>Money will be creadited to </b>
					</div>
					<div class="col-md-3 col-xs-7">
						<b><s:property value="#disBankName"/></b>
					</div>
	        </div>
	     </div>
	     <div class="col-xs-1"></div>
	</div> --%>
	

	<div class="row">
		<div class="col-xs-1"></div>
		
		<div class="col-xs-10  g-bg-color--gray-lighter " style="height:40px;">

	     </div>
	     <div class="col-xs-1"></div>
	</div>
	<div class="row  g-margin-t-10--xs g-margin-t-40--lg ">
		<div class="text-center">
			<a href="MFDocuments" >I/We have read the scheme related document  <input id="mfDocuments" type="checkbox" onchange="activatePayNowButton();" checked/></a>
		</div>
	</div>
	<div class="row  g-margin-t-5--xs g-margin-t-20--lg">
		<div class="text-center">
			<a href="terms" >I/We agree to MoneyBuddy's Terms</a><a href="privacyPolicy" > & Privacy Policy  <input id="iAccept" type="checkbox" onchange="activatePayNowButton();" checked/></a><br>
		</div>
	</div>
	
	<div class="row g-margin-t-o-20--xs text-center">
		<div class=" col-xs-12">
			<button type="button"  id="pay-now-button" class="text-center btn btn-home g-color--white g-margin-t-15--xs " onClick="callRedemptionAction();" >Redeem Now</button>
		</div>
	</div>
	<br/>
	<br/>
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
