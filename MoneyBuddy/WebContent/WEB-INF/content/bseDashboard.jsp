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
        <title>MoneyBuddy - Top Performing Mutual Funds</title>
      	<meta http-equiv="Cache-control" content="max-age=2592000, public">

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        
         
        <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
		<link href="assets/css/bootstrap/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.dataTables.min.css" />
  		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"/>	

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/> 
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
       <!--  <link href="css/global/nmoneybuddy.css" rel="stylesheet" type="text/css"/>
       
         -->

    </head>
    
         <style>
	    
	    
	    /*custom font*/
@import url(http://fonts.googleapis.com/css?family=Montserrat);

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
										<li id="dropdown-selector" class=" btn-group s-header-v2__nav-item dropdown">
	                                        <a href="#" class="s-header-v2__nav-link -is-active dropdown-toggle" data-toggle="dropdown" role="button" >Help<span class="caret"></span></a>
	                                    	<ul  id="dropdown-selection" class="dropdown-menu g-margin-t-o-30--xs " role="menu">
										        <li><a class="dropdown-item s-header-v2__nav-link  g-color--white" href="FAQs">FAQs</a></li>
										        <li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="contactUs">Contact Us</a></li>
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
        <!--========== END HEADER ==========-->
        
        
        
        
        <div class="g-bg-color--dark">
           <!-- <div class="container g-padding-y-80--xs g-padding-y-125--sm"> -->
             <div class="container ">
               <div class="g-text-center--xs g-margin-b-10--xs">
					<br/><br/><br/><br/>
                    <h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--primary text-left font-weight-bold g-hor-divider__solid--white  ">Dashboard11</h3>
                </div> 
                <div id="tot-values" class="row" style="padding: 0px; margin: 0px;">
                    <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-bar-chart g-margin-b-30--xs font-weight-bold ">&nbsp;&nbsp;Invested Amount </h4>
                             <div >
                                <span class="g-font-size-40--xs g-font-family--playfair g-color--primary" >Rs. </span>
                                <figure id="tot-inv-amt" class="g-display-inline-block--xs g-font-size-40--xs g-font-family--brandonText g-color--primary js__counter"></figure>
                            </div>
                           
                        </div>
                    </div>
                    
                    <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-bar-chart g-margin-b-30--xs font-weight-bold ">&nbsp;&nbsp;Profit </h4>
                             <div >
                                <span class="g-font-size-40--xs g-font-family--playfair g-color--primary" >Rs. </span>
                                <figure id="tot-prof-amt" class="g-display-inline-block--xs g-font-size-40--xs g-font-family--brandonText g-color--primary js__counter" ></figure>
                            </div>
                           
                        </div>
                    </div>
                    
                  <%--   <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-pulse g-margin-b-30--xsfont-weight-bold g-margin-b-10--xs ">&nbsp;&nbsp;Profit </h4>
                             <div >
                                <span class="g-font-size-40--xs g-font-family--playfair g-color--primary" style="line-height: 1;">Rs. </span>
                                <figure id="tot-prof-amt" class="g-display-inline-block--xs g-font-size-40--xs g-font-family--brandonText g-color--primary js__counter" style="line-height: 1;"></figure>
                                 <!-- <div class="tooltipOuter">
                                <div class="tooltipInner"></div>
                                </div> -->
                            
                                 <span class=" icon-help g-font-size-15--xs g-font-family--playfair g-color--white" data-ui-tooltip="We use industry standard<br/>to calculate average return">&nbsp;&nbsp;</span>
                                  <span class="g-font-size-30--xs g-font-family--playfair g-color--white">&nbsp;&nbsp; </span>
                            </div>
                           
                        </div>
                    </div> --%>
                    
                    
                    
                </div>
                
                <div id="tot-values" class="row" style="padding: 0px; margin: 0px;">
                    <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-bar-chart g-margin-b-30--xs font-weight-bold ">&nbsp;&nbsp;Current Value </h4>
                             <div >
                                <span class="g-font-size-40--xs g-font-family--playfair g-color--primary" >Rs. </span>
                                <figure id="tot-cur-amt" class="g-display-inline-block--xs g-font-size-40--xs g-font-family--brandonText g-color--primary js__counter" ></figure>
                            </div>
                           
                        </div>
                    </div>
                    
                    <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-bar-chart g-margin-b-30--xs font-weight-bold ">&nbsp;&nbsp;Growth Rate </h4>
                             <div >
                                <figure id="tot-grwth-amt" class="g-display-inline-block--xs g-font-size-40--xs g-font-family--brandonText g-color--primary js__counter" ></figure>
                            	<span class="g-font-size-40--xs g-font-family--playfair g-color--primary" style="line-height: 1;">&#37; </span>
                            </div>
                           
                        </div>
                    </div>
                    
                   <%--  <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-pulse g-margin-b-30--xsfont-weight-bold g-margin-b-10--xs ">&nbsp;&nbsp;Growth Rate</h4>
                             <div >
                                
                                <figure id="tot-grwth-amt" class="g-display-inline-block--xs g-font-size-40--xs g-font-family--brandonText g-color--primary js__counter" style="line-height: 1;"></figure>
                                 
                                 <div class="tooltipOuter">
                                <div class="tooltipInner"></div>
                                </div>
                            
                                 <span class=" icon-help g-font-size-15--xs g-font-family--playfair g-color--white" data-ui-tooltip="We use industry standard<br/>to calculate average return">&nbsp;&nbsp;</span>
                                  <span class="g-font-size-30--xs g-font-family--playfair g-color--white">&nbsp;&nbsp; </span>
                            </div>
                           
                        </div>
                    </div> --%>
                    
                    
                    
                </div>
                
                
                <%--  <h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--white text-left font-weight-bold g-hor-divider__solid--white  "></h3>
                 <div class="row" >
                     <div class="col-md-1 col-xs-0" >&nbsp;</div>
                      <div class="col-md-4 col-xs-12 g-full-width--xs g-margin-b-30--xs g-margin-b-0--lg g-color--white">
                        <div class="g-color--white g-text-center--xs ">
                                 <ul class="list-inline ">
                                <li class="g-color--white">
                                    <a class="g-color--white" href="https://www.behance.net/keenthemes">
                                        <i class="g-padding-r-5--xs ti-arrow-circle-up"></i>
                                        <span class="font-weight-bold"><a href="<s:url action="MFexplorer"/>"><b><span class="g-color--primary">Topup</span></b></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                    </a>
                                </li>
                                <li class="g-color--white">
                                    <a class="g-color--white" href="https://twitter.com/keenthemes">
                                        <i class="g-padding-r-5--xs ti-arrow-circle-down"></i>
                                        <span class="font-weight-bold">Withdraw</span>
                                     </a>
                                </li>
                    
                                </ul>
                                 
                                 </div>
                        </div>
                    
                        <div class="col-md-7 col-xs-0 g-full-width--xs g-">
                        &nbsp;
                        &nbsp;
                        </div>
                    
                </div> --%>
                  
            </div>
       
        </div>
        
	
       <!-- Counter -->
       	<div class="js__parallax-window" style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;"> 
        <!-- <div style="background-color: #eeeeee"> -->
             <div class="container ">
               <div class="g-text-center--xs g-margin-b-10--xs">
                </div> 
                
                
                <!--  Portfolio Summary Chart Start-->
                
                <!-- <div  id="contents" class="row" style="padding: 0px; margin: 20px;" style=" height:70vh;">
	              	<div class="col-md-5 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" style=" height:70vh;">
	              		<div class="g-text-center--xs g-margin-b-10--xs">
	                    	<h3 class="g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  g-margin-t-20--xs">Portfolio Summary Chart</h3>
	                	</div>
	                	<canvas id="canvas" style="position: relative; height:40vh;"></canvas>
	                </div> 
	                
	                <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg ">
                    </div>
	                
             		<div class="col-md-5 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" style=" height:70vh;">
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light g-margin-t-20--xs ">Investment Breakdown Chart </h3>
                		</div> 
			     		<div class=" g-text-center--xs g-padding-y-20--xs table-responsive">
							<canvas id="canvas1" style="position: relative; height:40vh;"></canvas>
						</div> 
	              	</div>
	             </div> -->
	                
               
               	<!--  Portfolio Summary Chart End -->
                 </div>
                
               <!--  Portfolio Summary Table Start -->
                
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  g-margin-t-20--xs">Portfolio Details</h3>
                		</div> 
			         <div class="g-text-center--xs g-padding-y-20--xs table-responsive">
								<!-- <table id="portfoliosummary" cellpadding="0" cellspacing="0" border="0" class="display"></table> -->
								<table id="portfoliosummary" class="table-bordered" cellspacing="0" width="100%">
							        <thead>
							            <tr class="g-bg-color--primary" >
							            	<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Sl. no.</span></th>
							                <th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
							                <th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Folio Num</span></th>
											<th class="text-center add-comma" ><span class="g-color--white g-font-size-14--xs">Invested Amount</span></th>
											<th class="text-center add-comma" ><span class="g-color--white g-font-size-14--xs ">Total units held</span></th>
											<th class="text-center add-comma" ><span class="g-color--white g-font-size-14--xs">Current Value</span></th>
											<th class="text-center add-comma" ><span class="g-color--white g-font-size-14--xs ">Profit</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Growth Rate<br/>(% per year)</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Invest More</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Redeem</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">STP</span></th>
							            </tr>
							        </thead>
							    </table>
							</div> 
	              		</div>
                	</div>   
                <!-- Portfolio Summary Table End -->
                
                 
               <!--  Pending Order Table Start -->
                
                <div class="row" style="padding: 0px; margin: 20px;" id="pendingOrderTableRow">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  g-margin-t-20--xs">Pending Orders</h3>
                		</div> 
			         <div class="g-text-center--xs g-padding-y-20--xs table-responsive">
								<!-- <table id="portfoliosummary" cellpadding="0" cellspacing="0" border="0" class="display"></table> -->
								<table id="pendingOrders" class="table-bordered" cellspacing="0" width="100%">
							        <thead>
							            <tr class="g-bg-color--primary" >
							            	<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Transaction Id</span></th>
							                <th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
											<th class="text-center add-comma" ><span class="g-color--white g-font-size-14--xs">Invested Amount</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Transaction Status</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Transaction Date</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Pay</span></th>
							            </tr>
							        </thead>
							    </table>
							</div> 
	              		</div>
                	</div>   
                <!-- Pending Order Table End -->               

                
                <!-- Sip Summary Table Start -->
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light g-margin-t-20--xs ">Active SIP's</h3>
                		</div> 
			     	<div class=" g-text-center--xs g-padding-y-20--xs table-responsive">
						<table id="siptable" class="display" cellspacing="0" width="100%">
							<thead class="text-center g-font-size-5--xs g-font-size-10--sm g-font-size-10--md ">
								<tr class="g-bg-color--primary">
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Sl. no.</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Folio Num</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Fund Category</span></th>
									<th class="text-center add-comma" ><span class="g-color--white g-font-size-14--xs">SIP Amount</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Sip Debit Date</span></th>
								</tr>
							</thead>
				   		</table>
						</div> 
	              	</div>
	             </div>
	              
        		<s:form  action="buyFundAction" method="post" name="formBuyFundAction">
  					<s:hidden id="fund-id-value" name="fundId"></s:hidden>
  					<s:hidden id="folio-num-value" name="folioNum"></s:hidden>
				</s:form>
				
				<s:form  action="fetchAvailableStpFundsAction" method="post" name="formFetchAvailableStpFundsAction">
  					<s:hidden id="fund-id-stp-value" name="stpFundId"></s:hidden>
  					<s:hidden id="cur-amount-stp-value" name="stpAmount"></s:hidden>
				</s:form>
				
				<s:form  action="redeemFundAction" method="post" name="formRedeemFundAction">
  					<s:hidden id="fund-id-redeem-value" name="redeemFundId"></s:hidden>
  					<s:hidden id="folio-num-redeem-value" name="folioNum"></s:hidden>
  					<s:hidden id="total-amount-redeem-value" name="totalAmount"></s:hidden>
  					<s:hidden id="total-quantity-redeem-value" name="totalQuantity"></s:hidden>
				</s:form>
				
				
	              <!-- Added Table for SIP - end  -->
	              
	              <!-- Transaction Hidtory Start -->
                
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light g-margin-t-20--xs ">Transaction History </h3>
                		</div> 
			     	<div class=" g-text-center--xs g-padding-y-20--xs table-responsive">
						<table id="transctionhistory" class="display" cellspacing="0" width="100%">
								<thead class="text-center g-font-size-5--xs g-font-size-10--sm g-font-size-10--md ">
									<tr class="g-bg-color--primary">
										<th class="text-center no-sort" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Sl. no.</span></th>
										<th class="text-center no-sort" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
										<th class="text-center no-sort" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Folio Num</span></th>
										<th class="text-center sort-date" ><span class="g-color--white g-font-size-14--xs">Transaction Date</span></th>
										<th class="text-center no-sort add-comma" ><span class="g-color--white g-font-size-14--xs">Amount</span></th>
										<th class="text-center no-sort add-comma" ><span class="g-color--white g-font-size-14--xs">Units</span></th>
										<th class="text-center no-sort add-comma" ><span class="g-color--white g-font-size-14--xs">NAV</span></th>
										<th class="text-center no-sort" ><span class="g-color--white g-font-size-14--xs">Transaction Type</span></th>
									</tr>
								</thead>
				   			</table>
						</div> 
	              	</div>
	             </div>
                <!-- Transaction History End -->
                
            </div>
        <!-- End Counter -->
     



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
                        <a href="welcome">
                            <img class="g-width-100--xs g-height-auto--xs" src="img/logo-white.png" alt="MoneyBuddy Logo">
                        </a>
                    </div>
                     <div class="col-xs-6 g-text-right--xs g-color--white">
                    &copy; 2020 <a href="welcome" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
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
        <!-- Vendor -->
    
		  <script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
		
		<script type="text/javascript" src="vendor/jquery.min.js"></script>
       <%--  <script type="text/javascript" src="assets/js/jquery-ui.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script> --%>
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
   	 
   	 
		    <!--========== Chart.js scripts ==========-->
		 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
		
		
		<!-- data table -->
		
		 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		
		
		
		
		
		<%-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script> --%>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.print.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/datetime-moment.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/numeric-comma.js"></script>
		
		
	 <script>
		
		$(document).ready(function() {
		    TUTORIAL_SAVVY.initChart()
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
		var sipData;
		/* var investmentDetailData; */
		var allFundsInvestmentDetailsData;
		var portfolioDataArray = [];
		var pendingOrderDataArray = [];
		var sipDataArray = [];
		var transctionhistoryDataArray = [];
		
		var TUTORIAL_SAVVY ={
				
				  		/* Initalization render chart */
				  		initChart : function(){
				  			
				  		TUTORIAL_SAVVY.loadData();
				  		$("#tot-inv-amt").html(TUTORIAL_SAVVY.addCommas(totalInvAmt));
				  		$("#tot-prof-amt").html(TUTORIAL_SAVVY.addCommas(totalProAmt));
				  		$("#tot-cur-amt").html(TUTORIAL_SAVVY.addCommas(totalCurrAmt));
				  		$("#tot-grwth-amt").html(totalGrwthAmt);
				  		TUTORIAL_SAVVY.createPortfolioDataArray(portfolioData);
				  		TUTORIAL_SAVVY.createPendingOrderDataArray(pendingOrderData);
				  		TUTORIAL_SAVVY.createSipDataArray(sipData);
				  		TUTORIAL_SAVVY.createTransctionhistoryDataArray(allFundsInvestmentDetailsData);
				  		
						//barChartData 		= TUTORIAL_SAVVY.createBarChartData(portfolioDataArray);
					    //BarChartObj 		= TUTORIAL_SAVVY.renderBarChart(barChartData);
					    //DoughnutChartData 	= TUTORIAL_SAVVY.createDoughnutChartData(portfolioDataArray);
					    //DoughnutChartObj 	= TUTORIAL_SAVVY.renderDoughnutChart(DoughnutChartData);
					    portfolioTable   	= TUTORIAL_SAVVY.loadPortfoliodata();
					    pendingOrdersTable   = TUTORIAL_SAVVY.loadPendingOrdersData();
					    sipTable   			= TUTORIAL_SAVVY.loadSipdata();
					    transctionhistoryTable = TUTORIAL_SAVVY.loadTransctionhistoryData();

				  },
				  
				  addCommas : function ( num ) {
	  	        		var parts = num.toString().split(".");
	  	        		parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	  	        		return parts.join(".");
	  	        		
	                 },
				  
				  
				  createPortfolioDataArray : function(portfolioData)
				  {
					  $.each(portfolioData,function(index,dataElement){
						  portfolioDataArray.push([dataElement.fundId,dataElement.schemeName,dataElement.folioNumber,dataElement.investedAmount,dataElement.units,dataElement.currentAmount,dataElement.profit,dataElement.rateOfGrowth,dataElement.schemeType]);
						});
					  
				  },
				  
				  createPendingOrderDataArray : function(pendingOrderData)
				  {
					  $.each(pendingOrderData,function(index,dataElement){
						  pendingOrderDataArray.push([dataElement.transactionId,dataElement.schemeName,dataElement.investedAmount,dataElement.transactionStatus,dataElement.transactionStartDate]);
						});  
				  },
				  
				  createSipDataArray : function(sipData)
				  {
					  $.each(sipData,function(index,dataElement){
						  sipDataArray.push([dataElement.fundId,dataElement.schemeName,dataElement.folioNumber,dataElement.schemeType,dataElement.investedAmount,dataElement.nextSipDate]);
						});
					  
				  },
				  
				  createTransctionhistoryDataArray : function(transctionhistoryData)
				  {
					  $.each(transctionhistoryData,function(index,dataElement){
						  transctionhistoryDataArray.push([dataElement.transactionId,dataElement.schemeName,dataElement.folioNumber,dataElement.transactionDate,dataElement.transactionAmount,dataElement.units,dataElement.navPurchased,dataElement.transactionType]);
						});
					  
				  },
				  
				  loadSipdata : function()
				  {
					 var table =  $('#siptable').DataTable( {
					    	data: sipDataArray,
					    	"paging":   false,
					        "ordering": false,
					        "info":     false,
					        "searching": false,
					        "responsive": true,
					        /* "lengthMenu": [ [5,  10, 25, 50, -1], [5, 10, 25, 50, "All"] ], */
					        "columnDefs": [ 
					        	{"className": "dt-center", "targets": "_all"},
					  			{
					  	            "searchable": false,
					  	            "orderable": false,
					  	            "targets": 0
					  	        },
					  	      	{
					  	        	 "mRender": function ( data, type, row ) {
					  	        		var parts = data.toString().split(".");
					  	        		parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
					  	        		return parts.join(".");
					  	        		
					                 },
					                 "targets": 'add-comma'
					  	        }],
					  	      "fnRowCallback": function (nRow, aData, iDisplayIndex) {
					  	        $("td:nth-child(1)", nRow).html(iDisplayIndex + 1);
					  	        return nRow;
					  	    },
							dom: 'lBfrtip',
							"buttons": [
					        	
					        	{
					        	extend: 'pdfHtml5',
					        	text: '<i class="fa fa-file-pdf-o"></i> Download your SIP details in PDF format',
					        	titleAttr: 'PDF',
					        	title: 'Money Buddy - Account Statement',
					        	exportOptions: {
					        	columns: ':not(:last-child)',
					        	},
					        	},
					        	],
					        
					        
							"language": {
							            "lengthMenu": "Display _MENU_ records per page",
							            "zeroRecords": "Nothing found - sorry",
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
				  
				  
				  loadTransctionhistoryData : function()
				  {
					  $.fn.dataTable.moment( 'D MMM YYYY' );
					  
					  $('#transctionhistory').DataTable( {
						 
						 
					    	data: transctionhistoryDataArray,
					    	"paging":   true,
					        "ordering": true,
					        "info":     false,
					        "searching": false,
					        "responsive": true,
					        "lengthMenu": [ [ 10, 25, 50, -1], [10, 25, 50, "All"] ],
					        "columnDefs": [ 
					        	{"className": "dt-center", "targets": "_all"},
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
					  	      order: [[ 2, 'asc' ]],
					  	      
					  	      "fnRowCallback": function (nRow, aData, iDisplayIndex) {
					  	        $("td:nth-child(1)", nRow).html(iDisplayIndex + 1);
					  	        return nRow;
					  	    },
					  		dom: 'lBfrtip',
							"buttons": [
								{
					        	extend: 'excelHtml5',
					        	text: '<i class="fa fa-file-excel-o"></i> Download Transaction details in Excel format',
					        	titleAttr: 'Export to Excel',
					        	title: 'Money Buddy - Account Statement',
					        	exportOptions: {
					        	columns: ':not(:last-child)',
					        	}
					        	},
					        	{
					        	extend: 'pdfHtml5',
					        	text: '<i class="fa fa-file-pdf-o"></i> Download Transaction details in PDF format',
					        	titleAttr: 'PDF',
					        	title: 'Money Buddy - Account Statement',
					        	exportOptions: {
					        	columns: ':not(:last-child)',
					        	},
					        	},
					        	],
					        
							"language": {
							            "lengthMenu": "Display _MENU_ records per page",
							            "zeroRecords": "Nothing found - sorry",
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
				  
				  loadPortfoliodata : function()
				  {
					  var email='kamalwadhwani@gmail.com';
					  var phoneNum='+91-9971648736';

					 var table =  $('#portfoliosummary').DataTable( {
						 
					    	data: portfolioDataArray,
					    	"paging":   false,
					        "ordering": false,
					        "info":     false,
					        "searching": false,
					        "responsive": true,
					        /* "lengthMenu": [ [5,  10, 25, 50, -1], [5, 10, 25, 50, "All"] ], */
					  		"columnDefs": [ 
					  			{"className": "dt-center", "targets": "_all"},
					  			{ "targets": -1, "data": null, "defaultContent": "<button id='stpButton'>STP</button>" },
					  			{ "targets": -2, "data": null, "defaultContent": "<button id='redeemButton'>Redeem</button>" },
					  			{ "targets": -3, "data": null, "defaultContent": "<button id='topUpButton'>Top up!</button>" },
					  			{
					  	            "searchable": false,
					  	            "orderable": false,
					  	            "targets": 0
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
								

					  	    	if ( aData[1] == "Total" ) {
					  	    		
					  	    	  	$('td:nth-child(2)', nRow).addClass('g-font-weight--700');
					  	    	  	$('td:nth-child(4)', nRow).addClass('g-font-weight--700');
					  	    		$('td:nth-child(6)', nRow).addClass('g-font-weight--700');
					  	    		$('td:nth-child(7)', nRow).addClass('g-font-weight--700');
					  	    		$('td:nth-child(8)', nRow).addClass('g-font-weight--700');
					  	    		$('td:nth-child(3)', nRow).html(null);
					  	    		$('td:nth-child(5)', nRow).html(null);
					  	    		$('td:nth-child(9)', nRow).html(null);
					  	    		$('td:nth-child(10)', nRow).html(null);
					  	    		$('td:nth-child(11)', nRow).html(null);
					  	    	  	return nRow;	
				  	    	  	}
					  	    	else {
					  	    		if ( aData[8] != "Debt" ) {
						  	    		
		  	    	  		    		$('td:nth-child(11)', nRow).html(null);
						  	    	  
					  	    	  	}
					  	        	$("td:nth-child(1)", nRow).html(iDisplayIndex + 1);
					  	        	return nRow;
					  	      	}
				  	    	},
				  	    	
				  	    	
					  		dom: 'lBfrtip',
					  		//buttons: [ 'print', 'excelHtml5', 'csvHtml5', 'pdfHtml5'],
					  		/* "buttons": [
					            {
					                extend: 'collection',
					                text: 'Export',
					                buttons: [
					                    'copy',
					                    'excel',
					                    'csv',
					                    'pdf',
					                    'print'
					                ]
					            }
					        ], */
					        
					        
					        "buttons": [
					        	/* {
					        	extend: 'excelHtml5',
					        	text: '<i class="fa fa-file-excel-o"></i> Excel',
					        	titleAttr: 'Export to Excel',
					        	title: 'Money Buddy - Account Statement',
					        	exportOptions: {
					        	columns: ':not(:last-child)',
					        	}
					        	},
					        	{
					        	extend: 'csvHtml5',
					        	text: '<i class="fa fa-file-text-o"></i> CSV',
					        	titleAttr: 'CSV',
					        	title: 'Money Buddy - Account Statement',
					        	exportOptions: {
					        	columns: ':not(:last-child)',
					        	}
					        	}, */
					        	{
					        	extend: 'pdfHtml5',
					        	text: '<i class="fa fa-file-pdf-o"></i> Download Portfolio in PDF',
					        	titleAttr: 'PDF',
					        	title: 'Money Buddy Financial Services Private Limited',
					        	messageTop: '<u>Investment statement of '+customerName+'</u>\nGiven below is a quick summary of your investments with us',
					        	messageBottom: '\n\nCurrent value of your investments: Rs. '+totalCurrAmt+'\n\n Your investments are '
					        			+profitDir+' by: Rs. '+totalProAmt+'\n\nYour investments have grown at a rate of : '+profitValue+' % per year',
					        	exportOptions: {
					        		columns: [  1, 3, 4, 5, 6, 7 ],
					        	},
					        	customize: function(doc){
				        			doc.styles.title.alignment = 'center';
				        			doc.styles.title.bold = true;
				        			doc.styles.title.fontSize = '20';
				        			doc.styles.message.alignment = 'center';
				        			doc.styles.message.fontSize = '14';
				        			doc.styles.tableHeader.fillColor = '#8DB3E2';
				        			/* doc.styles.message.decoration='underline'; */
				        			
					        	},
					        	},
					        	/* {
					        	extend: 'print',
					        	exportOptions: {
					        	columns: ':visible'
					        	},
					        	customize: function(win) {
					        	$(win.document.body).find( 'table' ).find('td:last-child, th:last-child').remove();
					        	}
					        	}, */
					        	],
					        
							"language": {
							            "lengthMenu": "Display _MENU_ records per page",
							            "zeroRecords": "Nothing found - sorry",
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
					 
					 
				  
					 $('#portfoliosummary tbody').on('click','#topUpButton',function () {
					        var data = table.row( $(this).parents('tr') ).data();
					        var fundId = data[0];
					        var folioNum = data[2];
					        buyFundHandler(fundId,folioNum);
					    } ); 
					  
					 $('#portfoliosummary tbody').on('click','#stpButton',function () {
					        var data = table.row( $(this).parents('tr') ).data();
					        var fundId = data[0];
					        var amount = data[4];
					        alert('fundId : '+fundId+' : amount : '+amount+' data[2] : '+data[2]);
					        stpFundHandler(fundId,amount);
					    } );
					 
					 $('#portfoliosummary tbody').on('click','#redeemButton',function () {
					        var data = table.row( $(this).parents('tr') ).data();
					        var fundId = data[0];
					        var folioNum = data[2];
					        var totalAmount = data[5];
					        var totalQuantity = data[3];
					        alert('fundId : '+fundId+' : folioNum : '+folioNum+' : totalAmount : '+totalAmount+' : totalQuantity : '+totalQuantity);
					        redeemFundHandler(fundId,folioNum,totalAmount,totalQuantity);
					    } );

				  },
				  
				  loadPendingOrdersData : function()
				  {
					 var table =  $('#pendingOrders').DataTable( {
					    	data: pendingOrderDataArray,
					    	"paging":   false,
					        "ordering": false,
					        "info":     false,
					        "searching": false,
					        "responsive": true,
					        /* "lengthMenu": [ [5,  10, 25, 50, -1], [5, 10, 25, 50, "All"] ], */
					  		"columnDefs": [
					  			{"className": "dt-center", "targets": "_all"},
					  			{ "targets": -1, "data": null, "defaultContent": "<button>Pay Now!</button>" },
					  			{
					  	        	 "mRender": function ( data, type, row ) {
					  	        		var parts = data.toString().split(".");
					  	        		parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
					  	        		return parts.join(".");
					  	        		
					                 },
					                 "targets": 'add-comma'
					  	        }
					  			],
					  		dom: 'lBfrtip',
							
					  		"buttons": [
					        	
					        	{
					        	extend: 'pdfHtml5',
					        	text: '<i class="fa fa-file-pdf-o"></i> Download your Pending Orders in PDF format',
					        	titleAttr: 'PDF',
					        	title: 'Money Buddy - Account Statement',
					        	exportOptions: {
					        	columns: ':not(:last-child)',
					        	},
					        	},
					        	],
					        	
							"language": {
							            "lengthMenu": "Display _MENU_ records per page",
							            "zeroRecords": TUTORIAL_SAVVY.fnPendingOrdersRedraw(),
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
					 
				  
/* 					 $('#pendingOrders tbody').on( 'click', 'button', function () {
					        var data = table.row( $(this).parents('tr') ).data();
					        alert( data[0] +"'s Fund ID is: "+ data[ 1 ] );
					        buyFundHandler('32');
					    } );  */
					    
					 $('#pendingOrders tbody').on( 'click', 'button', function () {
					        var data = table.row( $(this).parents('tr') ).data();
					        var transactionDetailId = data[0];
					        //alert('transactionDetailId : '+transactionDetailId);
					        window.location='checkBankDetailsAction?tranDetailId='+transactionDetailId; 
					        /* window.location='bankDetails?tranDetailId='+transactionDetailId; */
					    } ); 
					  
				
				  },
				  
				  fnPendingOrdersRedraw: function () { 
					  
					  $('#pendingOrderTableRow').addClass("hidden");
			     },
				  
				  
		  
		  loadData : function(){
			  
				$.ajax({
						async: false,
						url: "portfolioAction",
						dataType:"json",
						success: function(jsonResponse){
							
							customerName = jsonResponse.customerName;
							profitDir = jsonResponse.profitDir;
							profitValue = jsonResponse.profitValue;
							curDate = jsonResponse.curDate;
							totalCurrAmt = jsonResponse.totalCurrentAmount;
							totalGrwthAmt = jsonResponse.totalRateOfGrowth;
							totalInvAmt = jsonResponse.totalInvestedAmount;
							totalProAmt = jsonResponse.totalProfitAmount;
							portfolioData  = jsonResponse.portfolioDataModel;
							pendingOrderData = jsonResponse.pendingOrderDataModel;
							sipData = jsonResponse.sipDataModel;
							/* investmentDetailData = jsonResponse.investmentDetailsDataModel; */
							allFundsInvestmentDetailsData = jsonResponse.allFundsInvestmentDetailsDataModel;
						},
						error : function()  {
				        	window.location='errorPage';
				        }
				});
				
		  },
		  
		  
		  
		  /*Crate the custom Object with the data*/
		  createBarChartData : function(jsonData)
		  {

			  var funds =[];
			  var investedValue =[];
			  var currentValue =[];
			  
			  for(var i = 0; i < jsonData.length; i++) {
				  var obj = jsonData[i];
				  if(obj[0]!="Total")
					  {	
					   // console.log(obj[0]);
					    funds.push(obj[0]);
					    investedValue.push(obj[3]);
					    currentValue.push(obj[4]);
					   }
				}
			 
			  return {
				  		labels: funds,
				  		datasets: [
										{
												label: 'Invested Value',
												backgroundColor: "##1a49fb",
												data: investedValue
										}, 
										{
												label: 'Current Value',
												backgroundColor: "#13b1cd",
												data: currentValue
										}
									],
						options: {
									    legend: {
									      display: true,
									      position: 'left',
									      labels: {
									        fontColor: "#000080",
									        maintainAspectRatio: false
									      }
									    },
									    scales: {
									      yAxes: [{
									        ticks: {
									          beginAtZero: true
									        }
									      }]
									    }
									  }		
			  		};
		  },
		  
		  /*Renders the BarChart on a canvas and returns the reference to chart*/
		  renderBarChart:function(ChartData)
		  {
			  var context2D = document.getElementById("canvas").getContext("2d");
			  var myChart = new Chart(context2D,{
				  type: 'bar',
				  data: ChartData,
				  scaleShowLabels : false,
			      pointLabelFontSize : 10
			});
			  window.addEventListener('resize', function () {
				  myChart.resize()
		      })
		  return myChart;
		  },
		  

			  createDoughnutChartData : function(jsonData) {
				var funds = [];
				var currentValue = [];
				var colors = [ "Red", "Blue", "Yellow", "Green", "Purple", "Orange" ];
				var bgColorArray = [];
				var hoverBgColorArray = [];

				for (var i = 0; i < jsonData.length; i++) {
					var obj = jsonData[i];
					if(obj[0]!="Total")
					{
						funds.push(obj[1]);
						currentValue.push(obj[3]);
						var bgClrIndex = 0;
						if (i > 6) {
							bgClrIndex = i - 6;
			
						} else
							(bgClrIndex = i);
						bgColorArray.push(colors[bgClrIndex]);
					}
				}

				return {
					labels : funds,
					datasets : [ {
						data : currentValue,
						backgroundColor : bgColorArray,
					// hoverBackgroundColor: hoverBgColorArray
					}, ]
					
				
				
				};
			},

			/* Renders the Doughnut Chart on a canvas and returns the reference to chart */
			renderDoughnutChart : function(ChartData) {
				var context2D = document.getElementById("canvas1").getContext("2d");
				var myChart = new Chart(context2D, {
					type : 'doughnut',
					tooltipFillColor : "rgba(51, 51, 51, 0.55)",
					data : ChartData,
					options: {
		                maintainAspectRatio: false
		              },
					legend : {
						display : true,
						position : "right",
					// labels: {fontColor: 'rgb(255, 99, 132)'},
					},
				});
				window.addEventListener('resize', function () {
					myChart.resize()
				 })
				return myChart;
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
