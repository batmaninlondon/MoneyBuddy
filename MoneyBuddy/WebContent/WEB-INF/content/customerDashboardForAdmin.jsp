<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
    	<%
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma","no-cache");
		%>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy - Top Performing Mutual Funds</title>
     	<meta http-equiv="Cache-control" content="max-age=2592000, public">

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
         
        <%-- <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
        
		<script type="text/javascript" src="assets/js/jquery.min.js"></script>
        <script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script> --%>
		<link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
		<link href="assets/css/bootstrap/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.dataTables.min.css" />
  		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"/>	

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/> 
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">

    </head>

  
         <style>
	    
	    
	    /*custom font*/
@import url(http://fonts.googleapis.com/css?family=Montserrat);
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Raleway:400,500,700);
.snip1419 {
  font-family: 'Raleway', Arial, sans-serif;
  position: relative;
  float: left;
  overflow: hidden;
  margin: 10px 1%;
  text-align: left;
  color: #000000;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.9);
  font-size: 16px;
  -webkit-transform: translateZ(0);
  transform: translateZ(0);
  -webkit-perspective: 20em;
  perspective: 20em;
}
.snip1419 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.snip1419 figcaption {
  padding: 20px;
}
.snip1419 h3,
.snip1419 p {
  margin: 0;
}
.snip1419 h3 {
  font-size: 1em;
  font-weight: 700;
  margin-bottom: 10px;
  text-transform: uppercase;
}
.snip1419 p {
  font-size: 0.7em;
  letter-spacing: 1px;
  font-weight: 400;
}

/*form styles*/
#msform {
	margin: 50px auto;
	text-align: center;
	position: relative;
}
#msform fieldset {
	background: white;
	border: 0 none;
	border-radius: 3px;
	box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
	padding: 20px 30px;
	
	box-sizing: border-box;
	width: 80%;
	margin: 0 10%;
	
	/*stacking fieldsets above each other*/
	position: absolute;
}
/*Hide all except first fieldset*/
#msform fieldset:not(:first-of-type) {
	display: none;
}
/*inputs*/
#msform input, #msform textarea {
	padding: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
	margin-bottom: 10px;
	width: 100%;
	box-sizing: border-box;
	font-family: montserrat;
	color: #2C3E50;
	font-size: 13px;
}
/*buttons*/
#msform .action-button {
	background: #13b1cd; 
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 5px;
}
#msform .action-button:hover, #msform .action-button:focus {
	box-shadow: 0 0 0 2px white, 0 0 0 3px #13b1cd;
}
/*headings*/
.fs-title {
	font-size: 15px;
	text-transform: uppercase;
	color: #2C3E50;
	margin-bottom: 10px;
}
.fs-subtitle {
	font-weight: normal;
	font-size: 13px;
	color: #666;
	margin-bottom: 20px;
}
/*progressbar*/
#progressbar {
	margin-bottom: 30px;
	overflow: hidden;
	/*CSS counters to number the steps*/
	counter-reset: step;
}
#progressbar li {
	list-style-type: none;
	color: white;
	text-transform: uppercase;
	font-size: 9px;
	width: 33.33%;
	float: left;
	position: relative;
}
#progressbar li:before {
	content: counter(step);
	counter-increment: step;
	width: 20px;
	line-height: 20px;
	display: block;
	font-size: 10px;
	color: #333;
	background: white;
	border-radius: 3px;
	margin: 0 auto 5px auto;
}
/*progressbar connectors*/
#progressbar li:after {
	content: '';
	width: 100%;
	height: 2px;
	background: white;
	position: absolute;
	left: -50%;
	top: 9px;
	z-index: -1; /*put it behind the numbers*/
}
#progressbar li:first-child:after {
	/*connector not needed before the first step*/
	content: none; 
}
/*marking active/completed steps green*/
/*The number of the step and the connector before it = green*/
#progressbar li.active:before,  #progressbar li.active:after{
	background: #13b1cd;
	color: white;
}


}
	    </style> 

	    
    <!-- End Head -->

    <!-- Body -->
    <body>
    <div id="load" class="load"></div>

        <!--========== HEADER ==========-->
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
                                <a href="adminHome" class="s-header-v2__logo-link">
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
                                    <li class="s-header-v2__nav-item"><a href=adminHome class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="logOut"/>" class="s-header-v2__nav-link">Log Out</a></li>
									
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
        <!--========== END HEADER ==========-->
        
        
        
        
        <div class="g-bg-color--dark">
           <!-- <div class="container g-padding-y-80--xs g-padding-y-125--sm"> -->
             <div class="container"  >
               <div class="g-text-center--xs g-margin-b-10--xs">
					<br/><br/><br/><br/><br/>
                    <h3 class="text-center  g-font-size-16--xs g-font-size-32--lg g-font-family--playfair g-letter-spacing--1 g-color--primary font-weight-bold g-hor-divider__solid--white  ">Dashboard : <s:property value="#session.customerName" /></h3>
           			<br/>
           		</div> 
           		
              		<div class="row g-bg-color--gray-light g-margin-l-5--xs g-margin-l-0--lg g-margin-r-5--xs g-margin-r-0--lg">
              			<div class="card text-center ">
            				<div class="card-header g-font-size-10--xs g-margin-b-20--md">
						  	</div>
						  	
						  	<div class="card-body text-center ">
							    <div class="row">
							    <div class="col-xs-0 col-lg-1"></div>
							    <div class=" col-xs-12 col-lg-10">
							     <table class="table-bordered " cellspacing="0" width="100%">
										        <thead class="thead-light">
										            <tr class="g-bg-color--white g-font-size-10--xs g-font-size-20--lg g-font-family--playfair" >
										                <th class="text-center" ><span>Investment</span></th>
														<th class="text-center" ><span>Value</span></th>
														<th class="text-center" ><span>Profit</span></th>
														<th class="text-center" ><span>Growth(%)</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-bg-color--white g-font-size-12--xs g-font-size-20--lg g-color--primary " >
										                <td class="text-center" >
										                	<span class="g-font-family--playfair" >Rs.&nbsp; </span>
                                							<fmt:formatNumber type="number" maxFractionDigits="2">
                                								<s:property value="totalInvestedAmount"/>
                               								</fmt:formatNumber>
                                							<%-- <s:property value="totalInvestedAmount"/> --%>
                                							<!-- <figure id="tot-inv-amt" class="g-display-inline-block--xs g-font-family--brandonText js__counter"></figure> -->
                            							</td>
														<td class="text-center" >
															<span class=" g-font-family--playfair" >Rs.&nbsp; </span>
                                							<fmt:formatNumber type="number" maxFractionDigits="2">
                                								<s:property value="totalCurrentAmount"/>
                               								</fmt:formatNumber>
                                							<!-- <figure id="tot-cur-amt" class="g-display-inline-block--xs g-font-family--brandonText js__counter" ></figure> -->
                            							</td>
                            							<td class="text-center" >
															<span class="g-font-family--playfair" >Rs.&nbsp; </span>
                                							<s:if test="totalProfitAmount.equals('NA')">
                                								<s:property value="totalProfitAmount"/>
                               								</s:if>
                               								<s:else>
	                                							<fmt:formatNumber type="number" maxFractionDigits="2">
	                                								<s:property value="totalProfitAmount"/>
	                               								</fmt:formatNumber>
                               								</s:else>
                                							<!-- <figure id="tot-prof-amt" class="g-display-inline-block--xs g-font-family--brandonText js__counter" ></figure> -->
                            							</td>
														
														<td class="text-center" >
															<s:if test="totalRateOfGrowth.equals('NA')">
																<s:property value="totalRateOfGrowth"/>
															</s:if>
															<s:else>
																<fmt:formatNumber type="number" maxFractionDigits="2">
																	<s:property value="totalRateOfGrowth"/>
																</fmt:formatNumber>
															</s:else>
															<!-- <figure id="tot-grwth-amt" class="g-display-inline-block--xs g-font-family--brandonText js__counter" ></figure> -->
                            								<%-- <span class="g-font-size-30--xs g-font-family--playfair g-color--primary" style="line-height: 1;">&#37; </span> --%>
                            							</td>
										            </tr>
										        </tbody>
										    </table>
								    	</div>
								    	<div class="col-xs-0 col-lg-1"></div>
								    	</div>
						  	</div>
						  	<div class="card-footer g-font-size-10--xs g-margin-t-20--md "></div>
              			
              			</div>
              		
              		</div>
              
              		<div class="row g-bg-color--dark"></br></div>
              
              		<div class="row g-bg-color--gray-light">
              		
              			<div class="card text-center">
						  <div class="card-header">
						    <ul class="nav nav-pills ">
						       <li class="dropdown active">
    							<a  data-toggle="dropdown" id="dropdown-name" class="dropdown-toggle nav-link g-font-size-12--xs g-font-size-16--lg g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" href="#">Portfolio Summary
    							<span class="caret"></span></a>
      							<ul class="dropdown-menu">
   							  <li class="nav-item active">
						        <a class="nav-link g-font-size-12--xs g-font-size-16--lg g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" id="portfolioSummaryTable" href="#portfolioSummaryPane">Portfolio Summary</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link g-font-size-12--xs g-font-size-16--lg g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" id="activeSipTable" href="#activeSipPane" >Active SIP's</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link g-font-size-12--xs g-font-size-16--lg g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" id="activeStpTable" href="#activeStpPane" >Active STP's</a>
						      </li>
						      <li class="nav-item" >
						        <a class="nav-link g-font-size-12--xs g-font-size-16--lg g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" id="tranHistoryTable" href="#transactionHistoryPane" >Transaction History</a>
						      </li>
						      <li class="nav-item" id="hide-pending-orders" >
						        <a class="nav-link g-font-size-12--xs g-font-size-16--lg g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" id="pendingOrderTable" href="#pendingOrdersPane">Pending Orders</a>
						      </li>
						      <li class="nav-item" id="hide-old-portfolio" >
						        <a class="nav-link g-font-size-12--xs g-font-size-16--lg g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" id="oldPortTable" href="#olfPortfolioPane">Non MoneyBuddy Funds</a>
						      </li>
						      </ul>
						      </li>
						    </ul>
						  </div>
						  <div class="tab-content">
						  	<div id="portfolioSummaryPane" class="container tab-pane active">
						  		<!--  Portfolio Summary Table Start -->
                
                <div class="row" style=" margin: 10px 2px 20px 2px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs ">
                    		<p class=" g-font-size-16--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--primary font-weight-bold">
                    			Portfolio Details
                    		</p>
                		</div> 
							
							<div  class="row  g-padding-y-0--xs g-padding-y-10--sm   ">
							<s:if test="portfolioDataModel.size == 0">  
								<p><b>Start saving for your goals</b></p>
							</s:if>
							<s:else>
				<s:iterator value="portfolioDataModel" var="portfolioDataModelElement" status="ctr">
						
						<div id="myDiv3" class="col-xs-12 col-md-12  g-bg-color--white">
							<div  class="  g-line-height--normal  ">
							<s:set var="selectedFundId" value="#portfolioDataModelElement.fundId" />
							
							
								<figure class="snip1419 g-height-150--xs g-height-150--lg " style="width:100%"   >
									
				  					<!-- <figcaption > -->
				    					<article class=" panel panel-info panel-heading  g-height-60--xs " >
				    						<p class="g-color--black g-line-height--sm  g-font-size-12--xs g-font-size-16--lg " style="font-weight: bold; ">
				    						<s:property value="#portfolioDataModelElement.schemeName"/>
				    						&nbsp;&nbsp;&nbsp;&nbsp;
											
				    						</p>
				    						
											 <p class="g-color--black g-margin-t-10--xs g-line-height--lg  g-font-size-10--xs g-font-size-12--lg" ><b>Folio Number:</b> <s:property value="#portfolioDataModelElement.folioNumber"/></p>
				    						
				    					</article>
				    					<article class="g-margin-l-20--md " > 
									        <table  class="table-borderless g-margin-b-10--xs " cellspacing="0" width="100%">
										        <thead>
										            <tr class="g-bg-color--white g-font-family--playfair text-center " >
										                <th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Investment</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Value</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Profit</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Growth(%)</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" >
										                <td class="text-center " ><span class=" ">
										                	<fmt:formatNumber type="number" maxFractionDigits="2">
										                		<s:property value="#portfolioDataModelElement.investedAmount"/>
									                		</fmt:formatNumber>
									                		</span></td>
														<td class="text-center" ><span >
															<fmt:formatNumber type="number" maxFractionDigits="2">
																<s:property value="#portfolioDataModelElement.currentAmount"/>
															</fmt:formatNumber>
														</span></td>
														<td class="text-center" ><span >
															<s:if test="#portfolioDataModelElement.profit.equals('NA'.toString())">
																<s:property value="#portfolioDataModelElement.profit"/>
															</s:if>
															<s:else>
																<fmt:formatNumber type="number" maxFractionDigits="2">
																	<s:property value="#portfolioDataModelElement.profit"/>
																</fmt:formatNumber>
															</s:else>
														</span></td>
														<td class="text-center" ><span >
															<s:if test="#portfolioDataModelElement.rateOfGrowth.equals('NA'.toString())">
																<s:property value="#portfolioDataModelElement.rateOfGrowth"/>
															</s:if>
															<s:else>
																<fmt:formatNumber type="number" maxFractionDigits="2">
																	<s:property value="#portfolioDataModelElement.rateOfGrowth"/>
																</fmt:formatNumber>
															</s:else>
														</span></td>
										            </tr>
										        </tbody>
										    </table>
									       	</article>
									       	
		  						 <a href="#"></a>
								</figure>
								
							</div>
						</div>
			</s:iterator> 
			</s:else>
		</div>	
	              		</div>
                	</div>   
                <!-- Portfolio Summary Table End -->
						  	
						  	</div>
					
					
					
			  	<div id="activeSipPane" class="container tab-pane">
			  	</div>
						  	
				<div id="activeStpPane" class="container tab-pane">
				</div>
		  	
		  		<div id="transactionHistoryPane" class="container tab-pane ">
		  		<!-- Transaction Hidtory Start -->
                
                <div class="row" style="padding: 0px; margin: 20px 2px 20px 2px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-16--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--primary font-weight-bold">
                    			Transaction History 
                    		</h3>
                		</div> 
			     	<div class=" g-text-center--xs  table-responsive">
						<table id="transctionhistory" class="table-bordered" cellspacing="0" width="100%">
								<thead class="text-center">
									<tr class="g-bg-color--primary g-font-size-10--xs g-font-size-14--lg g-color--white">
										<th class="text-center no-sort" style="padding: 0px;">Sl. no.</th>
										<th class="text-center no-sort" style="padding: 0px;">Fund Name</th>
										<th class="text-center no-sort" style="padding: 0px;">Folio Num</th>
										<th class="text-center sort-date" style="padding: 0px;">Transaction Date</th>
										<th class="text-center no-sort add-comma" style="padding: 0px;">Amount</th>
										<th class="text-center no-sort add-comma" style="padding: 0px;">Units</th>
										<th class="text-center no-sort add-comma" style="padding: 0px;">NAV</th>
										<th class="text-center no-sort" style="padding: 0px;">Transaction Type</th>
									</tr>
								</thead>
				   			</table>
						</div> 
	              	</div>
	             </div>
                <!-- Transaction History End -->
				</div>
		  	
		  		<div id="pendingOrdersPane" class="container tab-pane ">
				</div>
			  	
			  	<div id="olfPortfolioPane" class="container tab-pane ">
				</div>
						  		
						  </div>
						</div>
 		
              		</div>
    
            </div>
       
        </div>

        <!--========== FOOTER ==========-->
        <footer class="g-bg-color--dark">
            <!-- Links -->
            <div class="g-hor-divider__dashed--white-opacity-lightest">
                <div class="container g-padding-y-40--xs">
                    <div class="row">
                    
                        <div class="col-xs-4 col-lg-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs ">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="welcome">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="saveTax">Save Tax</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="<s:url action="MFexplorer"/>">Funds Explorer</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="contactUs">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-4 col-lg-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://twitter.com/MoneyBuddyIndia">Twitter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.facebook.com/MoneyBuddyIndia">Facebook</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.linkedin.com/in/money-buddy-94a73814a/">Linkedin</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.YouTube.com/MoneyBuddy">YouTube</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-4 col-lg-2 g-margin-b-60--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="terms">Terms &amp; Conditions</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="privacyPolicy">Privacy Policy</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="MFDocuments">MFDocuments</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://medium.com/@moneybuddyIndia">Blog</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-12 col-md-4 col-lg-offset-2 s-footer__logo g-padding-y-50--xs g-padding-y-0--md">
                             <h3 class="text-center g-font-size-18--xs g-color--primary g-margin-l-o-25--xs">MoneyBuddy</h3>
                            <br/>
                            <p class="g-color--primary">
                            No complicated jargon, no daunting fees, just straightforward, effortless investing.</p>
                        </div>
                    </div>
                    <div class="row  g-font-size-12--xs g-color--white">
                    <br/>
                    	 Mutual fund investments are subject to market risks. Please read the scheme information and other related documents carefully before investing.
						<br/>Past performance is not indicative of future returns. Please consider your specific investment requirements, risk tolerance, investment goal and time frame associated with the investment before choosing a fund or designing a suitable portfolio.
                    	<br/>MoneyBuddy is the trade name used by Kamal Wadhwani to run his advisory business. SEBI Regn No: INA000013581
                    </div>
                </div>
            </div>
            <!-- End Links -->

            <!-- Copyright -->
            <div class="container g-padding-y-10--xs">
                <div class="row">
                    <div class="col-xs-6">
                        <a href="adminHome">
                            <img class="g-width-100--xs g-height-auto--xs" src="img/logo-white.png" alt="MoneyBuddy Logo">
                        </a>
                    </div>
                     <div class="col-xs-6 g-text-right--xs g-color--white">
                    &copy; 2020 <a href="adminHome" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
                </div>
                </div>
            </div>
            <!-- End Copyright -->
        </footer>
       
      </body>
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>

        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.scrollbar.min.js"></script>

        <!-- General Components and Settings -->
      	<script type="text/javascript" src="assets/js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="assets/js/components/scrollbar.min.js"></script>
        
        
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
    	<script src="assets/js/main.js"></script>
   	 	<script src="assets/js/wow.min.js"></script>
   	 
   	 
		    <!--========== Chart.js scripts ==========-->
		 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
		
		
		<!-- data table -->
		
		 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.print.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/datetime-moment.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/numeric-comma.js"></script>
		<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
		
	 <script>
		
		$(document).ready(function() {

			$('#portfolioSummaryTable').click(function(){
				
		    	$.ajax({
		            url: 'portfolioSummaryActi', // action to be perform
		           type: 'POST',       //type of posting the data
			       dataType: 'html',
			       success: function (html) {
			    	   document.getElementById("dropdown-name").innerHTML="Portfolio Summary <span class='caret'></span>";
			    	   document.getElementById("portfolioSummaryPane").innerHTML=html;
			       },
			       error: function(xhr, ajaxOptions, thrownError){
			          alert('An error occurred! ' + thrownError);
			       },
			  });
		    	
		    });
			
			$('#activeSipTable').click(function(){
		    					
		    	$.ajax({
		            url: 'portfolioSipDataActi', // action to be perform
		           type: 'POST',       //type of posting the data
			       dataType: 'html',
			       success: function (html) {
			    	   document.getElementById("dropdown-name").innerHTML="Active SIP's <span class='caret'></span>";
			    	   document.getElementById("activeSipPane").innerHTML=html;
			       },
			       error: function(xhr, ajaxOptions, thrownError){
			          alert('An error occurred! ' + thrownError);
			       },
			  });
		    	
		    });
		    $('#activeStpTable').click(function(){
		    	
		    	$.ajax({
		            url: 'PortfolioStpDataActi', // action to be perform
		           type: 'POST',       //type of posting the data
			       dataType: 'html',
			       success: function (html) {
			    	   document.getElementById("dropdown-name").innerHTML="Active STP <span class='caret'></span>";
			    	   document.getElementById("activeStpPane").innerHTML=html;
			       },
			       error: function(xhr, ajaxOptions, thrownError){
			          alert('An error occurred! ' + thrownError);
			       },
			  });
		    	
		    });
		   
		    $('#pendingOrderTable').click(function(){
		    	$.ajax({
		            url: 'portfolioPendingDataActi', // action to be perform
		           type: 'POST',       //type of posting the data
			       dataType: 'html',
			       success: function (html) {
			    	   document.getElementById("dropdown-name").innerHTML="Pending Orders <span class='caret'></span>";
			    	   document.getElementById("pendingOrdersPane").innerHTML=html;
			       },
			       error: function(xhr, ajaxOptions, thrownError){
			          alert('An error occurred! ' + thrownError);
			       },
			  });
		    	
		    });
		    $('#oldPortTable').click(function(){
		    	$.ajax({
		            url: 'oldPortfolioDataActi', // action to be perform
		           type: 'POST',       //type of posting the data
			       dataType: 'html',
			       success: function (html) {
			    	   document.getElementById("dropdown-name").innerHTML="Non MoneyBuddy Funds <span class='caret'></span>";
			    	   document.getElementById("olfPortfolioPane").innerHTML=html;
			       },
			       error: function(xhr, ajaxOptions, thrownError){
			          alert('An error occurred! ' + thrownError);
			       },
			  });
		    	
		    });
		    
		    $('#tranHistoryTable').click(function(){
		    	document.getElementById("dropdown-name").innerHTML="Transaction History <span class='caret'></span>";
		    	TUTORIAL_SAVVY.initHistory();
		    	
		    });
			
		} );
		
		var customerName;
		var profitDir;
		var profitValue;
		var curDate;
		var totalCurrAmt;
		var totalGrwthAmt;
		var totalInvAmt;
		var totalProAmt;
		var portfolioData;	
		var pendingOrderData;
		var oldPortfolioData;
		var sipData;
		var stpData;
		/* var investmentDetailData; */
		var allFundsInvestmentDetailsData;
		var portfolioDataArray = [];
		var pendingOrderDataArray = [];
		var oldPortfolioDataArray = [];
		var sipDataArray = [];
		var stpDataArray = [];
		var transctionhistoryDataArray = [];
	    
	    var TUTORIAL_SAVVY ={
	    		
	    
		  	initHistory : function() {
		  		TUTORIAL_SAVVY.loadTranHistoryData();
		  		TUTORIAL_SAVVY.createTransctionhistoryDataArray(allFundsInvestmentDetailsData);
		  		transctionhistoryTable = TUTORIAL_SAVVY.loadTransctionhistoryData();
		  	},
		  
		  addCommas : function ( num ) {
	        		var parts = num.toString().split(".");
	        		parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	        		return parts.join(".");
	        		
             },
		  			  
		  createTransctionhistoryDataArray : function(transctionhistoryData)
		  {
			  $.each(transctionhistoryData,function(index,dataElement){
				  transctionhistoryDataArray.push([dataElement.transactionId,dataElement.schemeName,dataElement.folioNumber,dataElement.transactionDate,dataElement.transactionAmount,dataElement.units,dataElement.navPurchased,dataElement.transactionType]);
				});
			  
		  },
		  
		  
		  
		  loadTransctionhistoryData : function()
		  {
			  $.fn.dataTable.moment( 'D MMM YYYY' );
			  
			  $('#transctionhistory').DataTable( {
				 
				 
			    	data: transctionhistoryDataArray,
			    	retrieve: true,
			    	"paging":   true,
			        "ordering": true,
			        "info":     false,
			        "searching": false,
			        "responsive": true,
			        "lengthMenu": [ [ 10, 25, 50, -1], [10, 25, 50, "All"] ],
			        "order": [[ 3, "desc" ]],
			        "columnDefs": [ 
			        	{ targets: [1], className: 'dt-body-left' },
		        		{ targets: [2, 4, 5, 6], className: 'dt-body-right' },
		        		{ targets: [0, 3, 7], className: 'dt-body-center' },
			  			{
			  	            "orderable": false,
			  	            "targets": 'no-sort'
			  	        },
			  	      	{
			  	        	 "mRender": function ( data, type, row ) {
			  	        		var parts = data.toString().split(".");
			  	        		parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			  	        		return parts.join(".");
			  	        		
			                 },
			                 "targets": 'add-comma'
			  	        }
			  	        ],
			  	      
			  	      "fnRowCallback": function (nRow, aData, iDisplayIndex) {
			  	        $("td:nth-child(1)", nRow).html(iDisplayIndex + 1);
			  	        return nRow;
			  	    },
			  		dom: 'Bfrtlip',
					"buttons": [
						/* {
			        	extend: 'excelHtml5',
			        	text: '<i class="fa fa-file-excel-o"></i> Download Transaction details in Excel format',
			        	titleAttr: 'Export to Excel',
			        	title: 'Money Buddy - Account Statement',
			        	exportOptions: {
			        	columns: ':not(:last-child)',
			        	}
			        	}, */
			        	{
			        	extend: 'pdfHtml5',
			        	text: '<i class="fa fa-file-pdf-o"></i> Download Transaction details as PDF',
			        	titleAttr: 'PDF',
			        	title: 'Money Buddy - Account Statement',
			        	exportOptions: {
			        	columns: ':not(:last-child)',
			        	},
			        	},
			        	],
			        
					"language": {
					            "lengthMenu": "Display _MENU_ records per page",
					            "zeroRecords": "Start saving for your goals",
					            "info": "Showing page _PAGE_ of _PAGES_",
					            "infoEmpty": "No records available",
					            "infoFiltered": "(filtered from _MAX_ total records)"
		        				},
		       		createdRow: function (row, data, index) {
		       						$(row).addClass("g-font-size-12--xs g-text-right--xs");
		        			        var totalRecords= data.length;
		        			        $('td', row).eq(totalRecords).addClass('g-text-center--xs');
		        			        $('td', row).eq(0).addClass('g-text-left--xs');
		        			    },
		       	 //render: $.fn.table.render.number( ',', '.', 2, '$' )
			    } ); 

		  },

	     
	     

  

  
  loadTranHistoryData : function(){
		$.ajax({
				async: false,
				url: "portfolioHistoryDataAction",
				dataType:"json",
				success: function(jsonResponse){
					
					allFundsInvestmentDetailsData = jsonResponse.allFundsInvestmentDetailsDataModel;
				},
				error : function()  {
		        	window.location='errorPage';
		        }
		});
		
  },
    
 
};
		
	
		
		document.onreadystatechange = function () {
			  var state = document.readyState
			  if (state == 'interactive') {
			       document.getElementById('contents').style.visibility="hidden";
			  } else if (state == 'complete') {
			      setTimeout(function(){
			         document.getElementById('interactive');
			         document.getElementById('load').style.visibility="hidden";
			         document.getElementById('contents').style.visibility="visible"; 
			      },1000);
			  }
			}
		</script>
        

 
    <!-- End Body -->
</html>
