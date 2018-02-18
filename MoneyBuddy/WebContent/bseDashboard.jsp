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
       <!--  <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/main.css" rel="stylesheet"> -->
		<link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
		<link href="assets/js/vendor/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
		<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
		
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.dataTables.min.css" />
  		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"/>	

        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/> 
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
       <!--  <link href="css/global/nmoneybuddy.css" rel="stylesheet" type="text/css"/>
       
         -->
        <!-- data table CSS-->
        

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
	    <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
	    
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
                                <a href="myIndex" class="s-header-v2__logo-link">
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
        
        
        
        
        <div class="g-bg-color--dark">
           <!-- <div class="container g-padding-y-80--xs g-padding-y-125--sm"> -->
             <div class="container ">
               <div class="g-text-center--xs g-margin-b-10--xs">
					<br/><br/><br/><br/>
                    <h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--primary text-left font-weight-bold g-hor-divider__solid--white  ">Dashboard</h3>
                </div> 
                <div class="row" style="padding: 0px; margin: 0px;">
                    <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-bar-chart g-margin-b-30--xs font-weight-bold ">&nbsp;&nbsp;Total Value </h4>
                             <div >
                                <span class="g-font-size-60--xs g-font-family--playfair g-color--primary" style="line-height: 1;">&#8377; </span>
                                <figure class="g-display-inline-block--xs g-font-size-70--xs g-font-family--brandonText g-color--primary js__counter" style="line-height: 1;"><s:property value="#session.totalCurrentAmount" /></figure>
                            </div>
                           
                        </div>
                    </div>
                    
                    <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-pulse g-margin-b-30--xsfont-weight-bold g-margin-b-10--xs ">&nbsp;&nbsp;Total Growth </h4>
                             <div >
                                <span class="g-font-size-60--xs g-font-family--playfair g-color--primary" style="line-height: 1;">&#8377; </span>
                                <figure class="g-display-inline-block--xs g-font-size-70--xs g-font-family--brandonText g-color--primary js__counter" style="line-height: 1;"><s:property value="#session.totalRateOfGrowth" /></figure>
                                 <div class="tooltipOuter">
                                <div class="tooltipInner"></div>
                                </div>
                            
                                 <span class=" icon-help g-font-size-15--xs g-font-family--playfair g-color--white" data-ui-tooltip="We use industry standard<br/>to calculate average return">&nbsp;!&nbsp;</span>
                                  <span class="g-font-size-30--xs g-font-family--playfair g-color--white">&nbsp;&nbsp;10% </span>
                            </div>
                           
                        </div>
                    </div>
                    
                    
                    
                </div>
                 <h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--white text-left font-weight-bold g-hor-divider__solid--white  "></h3>
                 <div class="row" >
                     <div class="col-md-1 col-xs-0" >&nbsp;</div>
                      <div class="col-md-4 col-xs-12 g-full-width--xs g-margin-b-30--xs g-margin-b-0--lg g-color--white">
                        <div class="g-color--white g-text-center--xs ">
                                 <ul class="list-inline ">
                                <li class="g-color--white">
                                    <a class="g-color--white" href="https://www.behance.net/keenthemes">
                                        <i class="g-padding-r-5--xs ti-arrow-circle-up"></i>
                                        <span class="font-weight-bold"><a href="javascript:getMfData()"><b><span class="g-color--primary">Topup</span></b></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
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
                    
                </div>
                  
            </div>
              
            
            
        </div>
        
        
		
		<!-- <div class="g-bg-color--dark" style="padding-bottom: 0.8rem" >
            <div class="g-container--md g-text-center--xs  ">
            <br/>
               
            </div>
        </div> -->
        
        
        <!-- <div class="g-bg-color--primary-ltr">
	 		<div class="container ">
	 		<div class="g-text-center--xs g-margin-b-10--xs">
                    <h3 class="g-font-size-32--xs g-font-size-50--md  g-letter-spacing--1 g-color--white text-left font-weight-bold " style="font-family:brandonText; font-weight:900; letter-spacing:-0.05em">Dashboard</h3>
                </div> 
                </div> 
			</div> -->
		
       <!-- Counter -->
       	<div class="js__parallax-window" style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;"> 
        <!-- <div style="background-color: #eeeeee"> -->
             <div class="container ">
               <div class="g-text-center--xs g-margin-b-10--xs">
                </div> 
                
              <!--   Total Value and Total Growth Start-->
                
                <%-- <div class="row" style="padding: 0px; margin: 20px;">
                	<div class="col-md-1 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg ">
                    </div>
                    <div class="col-md-4 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" style="height:20vh;">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-16--xs  ti-bar-chart g-margin-b-10--xs  g-text-left--xs g-margin-t-20--xs font-weight-bold ">&nbsp;&nbsp;Total Value </h4>
                             <div >
                                <span class="g-font-size-40--md g-font-size-20--xs g-font-family--playfair " style="line-height: 1;">&#8377; </span>
                                 <figure class="g-display-inline-block--xs g-font-size-50--md g-font-size-30--xs g-font-family--brandonText  js__counter g-margin-t-10--xs" style="line-height: 1;"><s:property value="#session.totalCurrentAmount" /></figure>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg ">
                    </div>
                    <div class="col-md-4 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg g-bg-color--white g-box-shadow__dark-lightest-v4" style="height:20vh;">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-16--xs ti-pulse g-margin-b-10--xs g-text-left--xs g-margin-t-20--xs font-weight-bold g-margin-b-10--xs ">&nbsp;&nbsp;Total Growth </h4>
                             <div >
                                <span class="g-font-size-40--xs g-font-family--playfair" style="line-height: 1;">&#8377; </span>
                                <figure class="g-display-inline-block--xs g-font-size-50--md g-font-size-30--xs g-font-family--brandonText  js__counter g-margin-t-10--xs" style="line-height: 1;"><s:property value="#session.totalRateOfGrowth" /></figure>
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
                </div> --%>
                
                <!--   Total Value and Total Growth End-->
                
                <!--  Portfolio Summary Chart Start-->
                
                <div  id="contents" class="row" style="padding: 0px; margin: 20px;" style=" height:70vh;">
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
	             </div>
	                
                </div>
               	<!--  Portfolio Summary Chart End -->
                
                
               <!--  Portfolio Summary Table Start -->
                
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  g-margin-t-20--xs">Portfolio Summary</h3>
                		</div> 
			         <div class="g-text-center--xs g-padding-y-20--xs table-responsive">
								<!-- <table id="portfoliosummary" cellpadding="0" cellspacing="0" border="0" class="display"></table> -->
								<table id="portfoliosummary" class="table-bordered" cellspacing="0" width="100%">
							        <thead>
							            <tr class="g-bg-color--primary" >
							            	<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Id</span></th>
							                <th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs ">Unit</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Invested Amount</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Current Amount</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Growth Rate</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Invest More</span></th>
							            </tr>
							        </thead>
							    </table>
							</div> 
	              		</div>
                	</div>   
                <!-- Portfolio Summary Table End -->
                
                 
               <!--  Pending Order Table Start -->
                
                <div class="row" style="padding: 0px; margin: 20px;">
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
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Invested Amount</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Transaction Date</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Pay</span></th>
							            </tr>
							        </thead>
							    </table>
							</div> 
	              		</div>
                	</div>   
                <!-- Pending Order Table End -->               
                
                <!--  Portfolio Summary Table Start -->
                
               <%--  <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  g-margin-t-20--xs">Portfolio Summary</h3>
                		</div> 
			         <div class="g-text-center--xs g-padding-y-20--xs table-responsive">
								<!-- <table id="portfoliosummary" cellpadding="0" cellspacing="0" border="0" class="display"></table> -->
								<table id="portfoliosummary" class="table-bordered" cellspacing="0" width="100%">
							        <thead>
							            <tr class="g-bg-color--primary" >
							                <th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs ">Unit</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Invested Amount</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Current Amount</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Growth Rate</span></th>
											<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Invest More</span></th>
							            </tr>
							        </thead>
    								<tbody class="table-body ">
										<s:iterator value="#session.portfolioDataModel" var="portfolioDataModelElement">
											<tr class="g-text-right--xs ">
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
												    <td>
												    	<s:set var="selectedFundId" value="#portfolioDataModelElement.fundId" />
												    	<span class="g-font-size-14--xs g-font-size-5--xs "> <button type="button" class="  btn-link" onClick="buyFundHandler(<s:property value="selectedFundId" />);" ><s:property value="#portfolioDataModelElement.fundName"/></button></span>
												    </td>
												  
												    <td><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.units"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.investedAmount"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.currentAmount"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.rateOfGrowth"/> %</span></td>
												  </s:else>
											</tr>
										</s:iterator> 
									</tbody> 
							    </table>
							</div> 
	              		</div>
                	</div>    --%>
                <!-- Portfolio Summary Table End -->
                
                
                 <!--  Portfolio Summary Table Start -->
                
<%--                 <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  g-margin-t-20--xs">Portfolio Summary</h3>
                		</div> 
							<div class="g-text-center--xs g-padding-y-20--xs table-responsive">
								<table id="portfoliosummary1" class="display" cellspacing="0" width="100%">
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
											<tr class="g-text-right--xs ">
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
												    <td>
												    	<s:set var="selectedFundId" value="#portfolioDataModelElement.fundId" />
												    	<span class="g-font-size-14--xs g-font-size-5--xs "> <button type="button" class="  btn-link" onClick="buyFundHandler(<s:property value="selectedFundId" />);" ><s:property value="#portfolioDataModelElement.fundName"/></button></span>
												    </td>
												  
												    <td><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.units"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.investedAmount"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.currentAmount"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#portfolioDataModelElement.rateOfGrowth"/> %</span></td>
												  </s:else>
											</tr>
										</s:iterator> 
									</tbody> 
								</table>
							</div> 
	              		</div>
                	</div>   --%> 
                <!-- Portfolio Summary Table End -->
                
                <!-- Sip Summary Table Start -->
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light g-margin-t-20--xs ">Running SIP</h3>
                		</div> 
			     	<div class=" g-text-center--xs g-padding-y-20--xs table-responsive">
						<table id="siptable" class="display" cellspacing="0" width="100%">
							<thead class="text-center g-font-size-5--xs g-font-size-10--sm g-font-size-10--md ">
								<tr class="g-bg-color--primary">
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Invested Amount</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Sip Start Date</span></th>
									<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Next Sip Date</span></th>
								</tr>
							</thead>
<%-- 							<tbody class="table-body " >
								<s:iterator value="#session.sipDataModel" var="sipDataModelElement">
									<tr class="class="g-text-right--xs ">
										<td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#sipDataModelElement.fundName"/></span></td>
										<td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#sipDataModelElement.investedAmount"/></span></td>
										<td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#sipDataModelElement.sipStartDate"/></span></td>
										<td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#sipDataModelElement.nextSipDate"/></span></td>
									</tr>
								</s:iterator>
							</tbody> --%>
				   		</table>
						</div> 
	              	</div>
	             </div>
	              
	              <!-- Added Table for SIP - end  -->
	              
	              <!-- Transaction Hidtory Start -->
                
                <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light g-margin-t-20--xs ">Transction History </h3>
                		</div> 
			     	<div class=" g-text-center--xs g-padding-y-20--xs table-responsive">
						<table id="transctionhistory" class="display" cellspacing="0" width="100%">
								<thead class="text-center g-font-size-5--xs g-font-size-10--sm g-font-size-10--md ">
									<tr class="g-bg-color--primary">
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Transaction Id</span></th>
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Fund Name</span></th>
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Transaction Date</span></th>
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Units</span></th>
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs">NAV</span></th>
										<th class="text-center" ><span class="g-color--white g-font-size-14--xs">Transaction Type</span></th>
									</tr>
								</thead>
								<%-- <tbody table-body>
										<s:iterator value="#session.allFundsInvestmentDetailsDataModel" var="allFundsElement">
											<tr class="class="g-text-right--xs ">
													<td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#allFundsElement.fundId"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#allFundsElement.fundName"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#allFundsElement.transactionDate"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#allFundsElement.units"/></span></td>
												    <td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#allFundsElement.navPurchased"/></span></td>
    												<td ><span class="g-font-size-14--xs g-font-size-5--xs"><s:property value="#allFundsElement.buySell"/></span></td>
											</tr>
										</s:iterator>
								</tbody> --%>
				   			</table>
						</div> 
	              	</div>
	             </div>
                <!-- Transaction History End -->
                
                <!-- Investment Breakdown Chart Start-->
                <!-- <div class="row" style="padding: 0px; margin: 20px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" style="height:70vh;">
             			<div class="g-text-center--xs g-margin-b-10--xs">
                    		<h3 class="g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold g-hor-divider__solid--heading-light  ">Investment Breakdown Chart </h3>
                		</div> 
			     		<div class=" g-text-center--xs g-padding-y-20--xs table-responsive">
						<canvas id="canvas1" style="position: relative; height:40vh;"></canvas>
						</div> 
	              	</div>
	             </div> -->
                <!-- Investment Breakdown Chart End -->
                    
                
             
                
                 
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
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="myIndex">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="saveTax">Save Tax</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="allFunds">Funds</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="FAQs">Help</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://twitter.com/MoneyBuddyIndia">Twitter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.facebook.com/MoneyBuddyIndia">Facebook</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.linkedin.com/in/money-buddy-94a73814a/">Linkedin</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.YouTube.com/MoneyBuddy">YouTube</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-40--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="terms.jsp">Terms &amp; Conditions</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="policy.jsp">Privacy Policy</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1 s-footer__logo g-padding-y-50--xs g-padding-y-0--md">
                             <h3 class="g-font-size-18--xs g-color--white">MoneyBuddy</h3>
                            <p class="g-color--white-opacity">
                            No complicated jargon, no daunting fees, just straightforward, effortless investing.</p>
                        </div>
                    </div>
                    <div class="row  g-font-size-12--xs g-color--white-opacity">
                    <br/>
                    	 Mutual fund investments are subject to market risks. Please read the scheme information and other related documents carefully before investing.
						<br/>Past performance is not indicative of future returns. Please consider your specific investment requirements, risk tolerance, investment goal, time frame, risk and reward balance and the cost associated with the investment before choosing a fund, or designing a portfolio that suits your needs.
                    </div>
                </div>
            </div>
            <!-- End Links -->

            <!-- Copyright -->
            <div class="container g-padding-y-50--xs">
                <div class="row">
                    <div class="col-xs-6">
                        <a href="index.html">
                            <img class="g-width-100--xs g-height-auto--xs" src="img/logo-white.png" alt="MoneyBuddy Logo">
                        </a>
                    </div>
                     <div class="col-sm-6 g-text-right--xs g-color--white-opacity">
                    &copy; 2018 <a href="#" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
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
		
		
		
	 <script>
		
		$(document).ready(function() {
		    TUTORIAL_SAVVY.initChart()
		} );
		
		var portfolioData;	
		var pendingOrderData;
		var sipData;
		var investmentDetailData;
		var allFundsInvestmentDetailsData;
		var portfolioDataArray = [];
		var pendingOrderDataArray = [];
		var sipDataArray = [];
		var transctionhistoryDataArray = [];
		
		var TUTORIAL_SAVVY ={
				
				  		/* Initalization render chart */
				  		initChart : function(){
				  			/*Makes the AJAX calll (synchronous) to load a All Data*/
				  		TUTORIAL_SAVVY.loadData();
				  		TUTORIAL_SAVVY.createPortfolioDataArray(portfolioData);
				  		TUTORIAL_SAVVY.createPendingOrderDataArray(pendingOrderData);
				  		TUTORIAL_SAVVY.createSipDataArray(sipData);
				  		TUTORIAL_SAVVY.createTransctionhistoryDataArray(allFundsInvestmentDetailsData);
				  		
						barChartData 		= TUTORIAL_SAVVY.createBarChartData(portfolioDataArray);
					    BarChartObj 		= TUTORIAL_SAVVY.renderBarChart(barChartData);
					    DoughnutChartData 	= TUTORIAL_SAVVY.createDoughnutChartData(portfolioDataArray);
					    DoughnutChartObj 	= TUTORIAL_SAVVY.renderDoughnutChart(DoughnutChartData);
					    portfolioTable   	= TUTORIAL_SAVVY.loadPortfoliodata();
					    pendingOrdersTable   = TUTORIAL_SAVVY.loadPendingOrdersData();
					    sipTable   			= TUTORIAL_SAVVY.loadSipdata();
					    transctionhistoryTable = TUTORIAL_SAVVY.loadTransctionhistoryData();

				  },
				  
				  
				  createPortfolioDataArray : function(portfolioData)
				  {
					  $.each(portfolioData,function(index,dataElement){
						  portfolioDataArray.push([dataElement.fundId,dataElement.fundName,dataElement.units,dataElement.investedAmount,dataElement.currentAmount,dataElement.rateOfGrowth]);
						});
					  
				  },
				  
				  createPendingOrderDataArray : function(pendingOrderData)
				  {
					  $.each(pendingOrderData,function(index,dataElement){
						  pendingOrderDataArray.push([dataElement.transactionId,dataElement.fundName,dataElement.investedAmount,dataElement.transactionStartDate]);
						});  
				  },
				  
				  createSipDataArray : function(sipData)
				  {
					  $.each(sipData,function(index,dataElement){
						  sipDataArray.push([dataElement.fundName,dataElement.investedAmount,dataElement.sipStartDate,dataElement.nextSipDate]);
						});
					  
				  },
				  
				  createTransctionhistoryDataArray : function(transctionhistoryData)
				  {
					  $.each(transctionhistoryData,function(index,dataElement){
						  transctionhistoryDataArray.push([dataElement.transactionId,dataElement.fundName,dataElement.transactionDate,dataElement.units,dataElement.navPurchased,dataElement.transactionType]);
						});
					  
				  },
				  
				  loadSipdata : function()
				  {
					 var table =  $('#siptable').DataTable( {
					    	data: sipDataArray,
					    	"paging":   true,
					        "ordering": false,
					        "info":     false,
					        "searching": true,
					        "responsive": true,
					        "lengthMenu": [ [5,  10, 25, 50, -1], [5, 10, 25, 50, "All"] ],
							dom: 'lBfrtip',
					        
					        
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
					 var table =  $('#transctionhistory').DataTable( {
						 
						 
					    	data: transctionhistoryDataArray,
					    	"paging":   true,
					        "ordering": false,
					        "info":     false,
					        "searching": true,
					        "responsive": true,
					        "lengthMenu": [ [5,  10, 25, 50, -1], [5, 10, 25, 50, "All"] ],
					  		dom: 'lBfrtip',
					        
					        
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
					 var table =  $('#portfoliosummary').DataTable( {
					    	data: portfolioDataArray,
					    	"paging":   true,
					        "ordering": false,
					        "info":     false,
					        "searching": true,
					        "responsive": true,
					        "lengthMenu": [ [5,  10, 25, 50, -1], [5, 10, 25, 50, "All"] ],
					  		"columnDefs": [ {"targets": 0,"visible": false}, { "targets": -1, "data": null, "defaultContent": "<button>Top up!</button>" }  ],
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
					        	{
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
					        	},
					        	{
					        	extend: 'pdfHtml5',
					        	text: '<i class="fa fa-file-pdf-o"></i> PDF',
					        	titleAttr: 'PDF',
					        	title: 'Money Buddy - Account Statement',
					        	exportOptions: {
					        	columns: ':not(:last-child)',
					        	},
					        	},
					        	{
					        	extend: 'print',
					        	exportOptions: {
					        	columns: ':visible'
					        	},
					        	customize: function(win) {
					        	$(win.document.body).find( 'table' ).find('td:last-child, th:last-child').remove();
					        	}
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
					 
				  
					 $('#portfoliosummary tbody').on( 'click', 'button', function () {
					        var data = table.row( $(this).parents('tr') ).data();
					        var fundId = data[0];
					        buyFundHandler(fundId);
					    } ); 
					  
				
				  },
				  
				  loadPendingOrdersData : function()
				  {
					 var table =  $('#pendingOrders').DataTable( {
					    	data: pendingOrderDataArray,
					    	"paging":   true,
					        "ordering": false,
					        "info":     false,
					        "searching": true,
					        "responsive": true,
					        "lengthMenu": [ [5,  10, 25, 50, -1], [5, 10, 25, 50, "All"] ],
					  		"columnDefs": [ { "targets": -1, "data": null, "defaultContent": "<button>Pay Now!</button>" }  ],
					  		dom: 'lBfrtip',
					        
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
					 
				  
/* 					 $('#pendingOrders tbody').on( 'click', 'button', function () {
					        var data = table.row( $(this).parents('tr') ).data();
					        alert( data[0] +"'s Fund ID is: "+ data[ 1 ] );
					        buyFundHandler('32');
					    } );  */
					  
				
				  },
		  
		  loadData : function(){
			  
				$.ajax({
						async: false,
						url: "portfolioAction",
						dataType:"json",
						success: function(jsonResponse){
							
							portfolioData  = jsonResponse.portfolioDataModel;
							pendingOrderData = jsonResponse.pendingOrderDataModel;
							sipData = jsonResponse.sipDataModel;
							investmentDetailData = jsonResponse.investmentDetailsDataModel;
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
					    investedValue.push(obj[2]);
					    currentValue.push(obj[3]);
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
						funds.push(obj[0]);
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
