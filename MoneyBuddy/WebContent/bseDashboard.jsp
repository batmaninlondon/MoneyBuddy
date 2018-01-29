<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy | Dashboard</title>
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="Megakit - HTML5 Theme">
        <meta name="author" content="keenthemes.com">

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/main.css" rel="stylesheet">
		<link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
		<link href="assets/js/vendor/dataTables.bootstrap.css" rel="stylesheet">
		
        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/nmoneybuddy.css" rel="stylesheet" type="text/css"/>
        
        <!-- data table CSS-->
         <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
	     
	    
        
 
    </head>
    <!-- End Head -->

    <!-- Body -->
    <body>

        <!--========== HEADER ==========-->
        <header class="navbar-fixed-top s-header-v2 js__header-sticky">
            <!-- Navbar -->
            <nav class="s-header-v2__navbar">
                <div class="container g-display-table--lg">
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
                                <a href="nhome.jsp" class="s-header-v2__logo-link">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
                                </a>
                            </div>
                            <!-- End Logo -->
                        </div>
                        
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col--right">
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="nhome.jsp" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="nsavetax.jsp" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">About Us</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">Blog</a></li>
                                    <li class="s-header-v2__nav-item"><a href="nfaq.jsp" class="s-header-v2__nav-link">FAQs</a></li>
                                    <li class="s-header-v2__nav-item"><a href="ncontact.jsp" class="s-header-v2__nav-link">Contact Us</a></li>
                                   
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Sign in</a></li>
													<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Sign up</a></li>
										<%	} else 
										 	{	%>
										 			 <li class=" s-header-v2__nav-item s-header-v2__dropdown-on-hover">
                                       					 <a href="bseDashboard.jsp" class="dropdown-toggle s-header-v2__nav-link -is-active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dashboard<span class="g-font-size-10--xs g-margin-l-5--xs "></span></a>
                                    				</li>
                                    				<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Log Out</a></li>
                                    				
										<%	}	%>  
                                
                                
                                
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
		
		<div class="g-bg-color--dark" style="padding-bottom: 0.8rem" >
            <div class="g-container--md g-text-center--xs  ">
            <br/><br/><br/>
               
            </div>
        </div>
        
        
        <div class="g-bg-color--primary-ltr">
	 		<div class="container ">
	 		<div class="g-text-center--xs g-margin-b-10--xs">
                    <h3 class="g-font-size-32--xs g-font-size-50--md  g-letter-spacing--1 g-color--white text-left font-weight-bold " style="font-family:brandonText; font-weight:900; letter-spacing:-0.05em">Dashboard</h3>
                </div> 
                </div> 
			</div>
		
       <!-- Counter -->
       	<div class="js__parallax-window" style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;"> 
        <!-- <div style="background-color: #eeeeee"> -->
             <div class="container ">
               <div class="g-text-center--xs g-margin-b-10--xs">
                </div> 
                
              <!--   Total Value and Total Growth Start-->
                
                <div class="row" style="padding: 0px; margin: 20px;">
                	<div class="col-md-1 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg ">
                    </div>
                    <div class="col-md-4 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs  ti-bar-chart g-margin-b-10--xs  g-text-left--xs g-margin-t-20--xs font-weight-bold ">&nbsp;&nbsp;Total Value </h4>
                             <div >
                                <span class="g-font-size-60--xs g-font-family--playfair " style="line-height: 1;">&#8377; </span>
                                <figure class="g-display-inline-block--xs g-font-size-60--xs g-font-family--brandonText js__counter" style="line-height: 1;"><s:property value="#session.totalCurrentAmount" /></figure>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg ">
                    </div>
                    <div class="col-md-4 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg g-bg-color--white g-box-shadow__dark-lightest-v4">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs ti-pulse g-margin-b-10--xs g-text-left--xs g-margin-t-20--xs font-weight-bold g-margin-b-10--xs ">&nbsp;&nbsp;Total Growth </h4>
                             <div >
                                <span class="g-font-size-60--xs g-font-family--playfair " style="line-height: 1;">&#8377; </span>
                                <figure class="g-display-inline-block--xs g-font-size-60--xs g-font-family--brandonText  js__counter" style="line-height: 1;"><s:property value="#session.totalRateOfGrowth" /></figure>
                                 <div class="tooltipOuter">
                                <div class="tooltipInner"></div>
                                </div>
                                 <span class=" icon-help g-font-size-15--xs g-font-family--playfair g-color--white" data-ui-tooltip="We use industry standard<br/>to calculate average return">&nbsp;!&nbsp;</span>
                                  <span class="g-font-size-30--xs g-font-family--playfair g-color--primary">&nbsp;&nbsp; </span>
                            </div>
                        </div>
                    </div>
                  <div class="col-md-1 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg ">
                    </div>
                </div>
                
                <!--   Total Value and Total Growth End-->
                
                <!--  Portfolio Summary Chart Start-->
                
                <div class="row" style="padding: 0px; margin: 20px;">
	              	<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" style="height:70vh;">
	              		<div class="g-text-center--xs g-margin-b-10--xs">
	                    	<h3 class="g-font-size-32--xs g-font-size-36--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  ">Portfolio Summary Chart</h3>
	                	</div>
	                	<canvas id="canvas" style="position: relative; height:40vh; width:80vw"></canvas>
	                </div> 
                </div>
               	<!--  Portfolio Summary Chart End -->
                
                <!--  Portfolio Summary Table Start -->
                
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" style="height:70vh;">
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-36--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  ">Portfolio Summary</h3>
                		</div> 
			         <div class="g-text-center--xs g-padding-y-20--xs table-responsive">
								<table id="portfoliosummary" class="table table-bordered stripe ">
									<thead class="text-center ">
										<tr class="g-bg-color--primary" >
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs ">Unit</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Invested Amount</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Current Amount</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Growth Rate</span></th>
										</tr>
									</thead>
									<tbody class="table-body ">
										<s:iterator value="#session.portfolioDataModel" var="portfolioDataModelElement">
											<tr class="text-center ">
												<s:if test="fundName.equals('Total')">
													<td class="g-bg-color--gray-light ">
												    	<span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.fundName"/></span>
												    </td>
												     <td class="g-bg-color--gray-light "><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.units"/></span></td>
												    <td class="g-bg-color--gray-light " ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.investedAmount"/></span></td>
												    <td class="g-bg-color--gray-light " ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.currentAmount"/></span></td>
												    <td class="g-bg-color--gray-light " ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.rateOfGrowth"/></span></td>
												  </s:if>
												  <s:else>
												    <%-- <td class="g-bg-color--gray-light "><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.fundId"/></span></td> --%>
												    <td>
												    	<s:set var="selectedFundId" value="#portfolioDataModelElement.fundId" />
												    	<span class="g-font-size-14--xs g-font-size-5--xs"> <button type="button" class=" btn-link" onClick="buyFundHandler(<s:property value="selectedFundId" />);" ><s:property value="#portfolioDataModelElement.fundName"/></button></span>
														<%-- <span class="g-font-size-14--xs g-font-size-5--xs g-color--primary " onClick="buyFundHandler(<s:property value="selectedFundId" />);" ><u><s:property value="#portfolioDataModelElement.fundName"/></u></span> --%>
												    </td>
												  
												    <td><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.units"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.investedAmount"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.currentAmount"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.rateOfGrowth"/></span></td>
												  </s:else>
											</tr>
										</s:iterator> 
									</tbody>
								</table>
							</div> 
	              		</div>
                	</div>   
                <!-- Portfolio Summary Table End -->
                
                <!-- Sip Summary Table Start -->
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" style="height:70vh;">
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-36--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  ">SIP Summary</h3>
                		</div> 
			     	<div class=" g-text-center--xs g-padding-y-20--xs table-responsive">
						<table id="siptable" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
							<thead class="text-center g-font-size-5--xs g-font-size-10--sm g-font-size-10--md ">
								<tr class="g-bg-color--primary">
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Invested Amount</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Sip Start Date</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Next Sip Date</span></th>
								</tr>
							</thead>
							<tbody >
								<s:iterator value="#session.sipDataModel" var="sipDataModelElement">
									<tr class="text-center g-font-size-15--xs g-font-size-15--sm g-font-size-15--md ">
										<td ><s:property value="#sipDataModelElement.fundName"/></td>
										<td ><s:property value="#sipDataModelElement.investedAmount"/></td>
										<td ><s:property value="#sipDataModelElement.sipStartDate"/></td>
										<td ><s:property value="#sipDataModelElement.nextSipDate"/></td>
									</tr>
								</s:iterator>
							</tbody>
				   		</table>
						</div> 
	              	</div>
	             </div>
	              
	              <!-- Added Table for SIP - end  -->
	              
	              <!-- Transaction Hidtory Start -->
                
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" style="height:70vh;">
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-36--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  ">Transction History </h3>
                		</div> 
			     	<div class=" g-text-center--xs g-padding-y-20--xs table-responsive">
						<table id="transctionhistory" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
								<thead class="text-center g-font-size-5--xs g-font-size-10--sm g-font-size-10--md ">
									<tr class="g-bg-color--primary">
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Transaction Date</span></th>
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Units</span></th>
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs">NAV</span></th>
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Transaction Type</span></th>
									</tr>
								</thead>
								<tbody >
										<s:iterator value="#session.allFundsInvestmentDetailsDataModel" var="allFundsElement">
											<tr class="text-center g-font-size-15--xs g-font-size-15--sm g-font-size-15--md ">
												    <td ><s:property value="#allFundsElement.fundName"/></td>
												    <td ><s:property value="#allFundsElement.transactionDate"/></td>
												    <td ><s:property value="#allFundsElement.units"/></td>
												    <td ><s:property value="#allFundsElement.navPurchased"/></td>
    												<td ><s:property value="#allFundsElement.buySell"/></td>
											</tr>
										</s:iterator>
								</tbody>
				   			</table>
						</div> 
	              	</div>
	             </div>
                <!-- Transaction History End -->
                
                <!-- Investment Breakdown Chart Start-->
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" style="height:70vh;">
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-36--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  ">Investment Breakdown Chart </h3>
                		</div> 
			     		<div class=" g-text-center--xs g-padding-y-20--xs table-responsive">
						<canvas id="canvas1" style="position: relative; height:40vh;"></canvas>
						</div> 
	              	</div>
	             </div>
                <!-- Investment Breakdown Chart End -->
                    
                
             
                
                 
            </div>
        </div>
        <!-- End Counter -->
     

	

        <!--========== FOOTER ==========-->
        <footer class="g-bg-color--dark">
            <!-- Links -->
            <div class="g-hor-divider__dashed--white-opacity-lightest">
                <div class="container g-padding-y-80--xs">
                    <div class="row">
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">About</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Work</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Contact</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Twitter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Facebook</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Instagram</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">YouTube</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-40--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Subscribe to Our Newsletter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Privacy Policy</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Terms &amp; Conditions</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1 s-footer__logo g-padding-y-50--xs g-padding-y-0--md">
                            <h3 class="g-font-size-18--xs g-color--white">Megakit</h3>
                            <p class="g-color--white-opacity">We are a creative studio focusing on culture, luxury, editorial &amp; art. Somewhere between sophistication and simplicity.</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Links -->

            <!-- Copyright -->
            <div class="container g-padding-y-50--xs">
                <div class="row">
                    <div class="col-xs-6">
                        <a href="index.html">
                            <img class="g-width-100--xs g-height-auto--xs" src="img/logo.png" alt="Megakit Logo">
                        </a>
                    </div>
                    <div class="col-xs-6 g-text-right--xs">
                        <p class="g-font-size-14--xs g-margin-b-0--xs g-color--white-opacity-light"><a href="http://keenthemes.com/preview/Megakit/">Megakit</a> Theme Powered by: <a href="http://www.keenthemes.com/">KeenThemes.com</a></p>
                    </div>
                </div>
            </div>
            <!-- End Copyright -->
        </footer>
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>

        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery-ui.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>

        <!-- General Components and Settings -->
        <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        
        
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
    	<script src="assets/js/main.js"></script>
   	 <script src="assets/js/wow.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
        
        
        
        <!--========== END FOOTER ==========-->

       

        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <script type="text/javascript" src="vendor/waypoint.min.js"></script>
        <script type="text/javascript" src="vendor/counterup.min.js"></script>
        <script type="text/javascript" src="js/components/swiper.min.js"></script>
        <script type="text/javascript" src="js/components/counter.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
         <script type="text/javascript" src="js/nmoneybuddy.js"></script>
         <%-- <script src="assets/js/jquery-1.8.2.js" type="text/javascript"></script> --%>
		 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
		 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		 
		    <!--========== Chart.js scripts ==========-->
		 <script src="assets/js/jquery-ui.js"></script>
		 <!-- <script type="text/javascript" src="assets/js/Chart.js"></script> -->
		 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
		<script type="text/javascript" src="assets/js/ts-chart-script2.js"></script>
		
		<!-- data table -->
		<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		
		<script>
		
		$(document).ready(function() {
		    $('#portfoliosummary').DataTable( {
		        "paging":   true,
		        "ordering": false,
		        "info":     false,
		        "searching": true,
		        "responsive": true,
		        "lengthMenu": [ [ 10, 25, 50, -1], [10, 25, 50, "All"] ]
		    } ),
		    $('#transctionhistory').DataTable( {
		        "paging":   true,
		        "ordering": false,
		        "info":     false,
		        "searching": true,
		        "responsive": true,
		        "lengthMenu": [ [5,  10, 25, 50, -1], [5, 10, 25, 50, "All"] ]
		    } ),
		    $('#siptable').DataTable( {
		        "paging":   true,
		        "ordering": false,
		        "info":     false,
		        "searching": true,
		        "responsive": true,
		        "lengthMenu": [ [5,  10, 25, 50, -1], [5, 10, 25, 50, "All"] ]
		    } );
		} );
		
		</script>
        

    </body>
    <!-- End Body -->
</html>
