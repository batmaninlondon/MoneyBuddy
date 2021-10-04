<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<!DOCTYPE html >
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
        <!-- <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet"> -->

		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
	
        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> -->
        <!-- <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
 
<style>
/*form styles*/
#msform {
	position: relative;
}
#msform fieldset {
	background: white;
	border: 0 none;
	border-radius: 3px;
	box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
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
/*progressbar*/
#progressbar {
	margin-bottom: 0px;
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
	
.form1 {
  background: rgba(19, 35, 47, 0.9);
  padding: 20px;
 width: 80%;
  margin: 20px auto;
  border-radius: 4px;
  -webkit-box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
   box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
}
</style> 

</head>

<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;" onload="setInitialUpfrontInvestment();">
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
        
<div class="row g-margin-t-90--xs g-text-right--xs ">   
<s:form action="prepareKycFormAction" method="post" > 	
	<div id="msform" style="text-align: center;">
		<!-- progressbar -->
		<ul  id="progressbar" class="form1" >
			<li class="active">Additional Details 1</li>
			<li>Additional Details 2</li>
		</ul>
	<!-- fieldsets -->
	<fieldset  style="background-color: #cecece !important; ">
		<div style="background-color: white;"  class="g-height-450--xs">
		<div class="row g-text-left--xs g-margin-t-30--lg" >
			<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg ">Father's Name</div>
        	<div class="col-md-6 col-xs-8 ">
        		<s:fielderror fieldName="fatherName" class="g-color--red" />
			  	<s:textfield class="form-control g-font-size-10--xs g-font-size-14--lg" id="father-name" placeholder="Enter Father's Name" name="fatherName" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Marital Status</div>
        	<div class="col-md-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="marital-status"  
					list="#{'Married':'Married', 'Single':'Single'}" 
					name="maritalStatus" 
					value="Married" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Nationality</div>
        	<div class="col-md-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="nationality" 
					list="#{'Indian':'Indian', 'Other':'Other'}" 
					name="nationality" 
					value="Indian" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        </div>
        	<input type="button" name="next" class=" next action-button " value="Next" style="width:23% ;float: right;"/>
	</fieldset>
	<fieldset  style="background-color: #cecece !important;">
		<div style="background-color: white;"  class="g-height-450--xs">
		
		<div class="row g-text-left--xs g-margin-t-30--lg" >
			<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Status</div>
        	<div class="col-md-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="status" 
					list="#{'LivInInd':'Living in India', 'NonResInd':'Non Resident Indian (NRI)', 'ForNat':'Foreign National'}" 
					name="status" 
					value="LivInInd" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Gross Annual Income</div>
        	<div class="col-md-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="gross-annual-income"  
					list="#{'LesThaOneLak':'less than 1 lakh', 'OneToFivLak':'1 to 5 lakhs', 'FivToTenLak':'5 to 10 lakhs',
					'TenToTweFivLak':'10 to 25 lakhs','MorThaTweFivLak':'More Than 25 lakhs' }" 
					name="grossAnnualIncome" 
					value="LesThaOneLak" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Politically Exposed?</div>
        	<div class="col-md-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="politically-exposed" 
					list="#{'No':'No', 'PoliticExposed':'Politically Exposed Person', 
					'RelToPoliticExposed':'Related to a Politically Exposed Person' }" 
					name="politicallyExposed" 
					value="No" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
		
         </div>
			<input type="button" name="previous" class="previous action-button" value="Previous" style="width:23% ;float: left;" />
			<s:submit class="next action-button" value="Continue" style="width:23% ;float: right;"/>
	</fieldset>
</div>
</s:form>
</div>	  
</body>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
		<%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
    	<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
		<script src="assets/js/jquery.js"></script>
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
   	 	<script src="assets/js/main.js"></script>
    	<script src="assets/js/wow.min.js"></script>


        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <%-- <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.parallax.min.js"></script>
        <script type="text/javascript" src="vendor/cubeportfolio/js/jquery.cubeportfolio.min.js"></script> --%>

        <!-- General Components and Settings -->
        <%-- <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="js/components/faq.min.js"></script> --%>
        <!--========== END JAVASCRIPTS ==========-->
         <%-- <script  src="js/index.js"></script>	 --%>
         
         
		<!-- jQuery easing plugin -->
		<script src="assets/js/jquery.easing.min.js" type="text/javascript"></script>
		    	
		 <script>
		 
		//jQuery time
		 var current_fs, next_fs, previous_fs; //fieldsets
		 var left, opacity, scale; //fieldset properties which we will animate
		 var animating; //flag to prevent quick multi-click glitches

		 $(".next").click(function(){
		 	if(animating) return false;
		 	animating = true;
		 	
		 	current_fs = $(this).parent();
		 	next_fs = $(this).parent().next();
		 	
		 	//activate next step on progressbar using the index of next_fs
		 	$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
		 	
		 	//show the next fieldset
		 	next_fs.show(); 
		 	//hide the current fieldset with style
		 	current_fs.animate({opacity: 0}, {
		 		step: function(now, mx) {
		 			//as the opacity of current_fs reduces to 0 - stored in "now"
		 			//1. scale current_fs down to 80%
		 			scale = 1 - (1 - now) * 0.2;
		 			//2. bring next_fs from the right(50%)
		 			left = (now * 50)+"%";
		 			//3. increase opacity of next_fs to 1 as it moves in
		 			opacity = 1 - now;
		 			current_fs.css({'transform': 'scale('+scale+')'});
		 			next_fs.css({'left': left, 'opacity': opacity});
		 		}, 
		 		duration: 800, 
		 		complete: function(){
		 			current_fs.hide();
		 			animating = false;
		 		}, 
		 		//this comes from the custom easing plugin
		 		easing: 'easeInOutBack'
		 	});
		 });

		 $(".previous").click(function(){
		 	if(animating) return false;
		 	animating = true;
		 	
		 	current_fs = $(this).parent();
		 	previous_fs = $(this).parent().prev();
		 	
		 	//de-activate current step on progressbar
		 	$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
		 	
		 	//show the previous fieldset
		 	previous_fs.show(); 
		 	//hide the current fieldset with style
		 	current_fs.animate({opacity: 0}, {
		 		step: function(now, mx) {
		 			//as the opacity of current_fs reduces to 0 - stored in "now"
		 			//1. scale previous_fs from 80% to 100%
		 			scale = 0.8 + (1 - now) * 0.2;
		 			//2. take current_fs to the right(50%) - from 0%
		 			left = ((1-now) * 50)+"%";
		 			//3. increase opacity of previous_fs to 1 as it moves in
		 			opacity = 1 - now;
		 			current_fs.css({'left': left});
		 			previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
		 		}, 
		 		duration: 800, 
		 		complete: function(){
		 			current_fs.hide();
		 			animating = false;
		 		}, 
		 		//this comes from the custom easing plugin
		 		easing: 'easeInOutBack'
		 	});
		 });

		 $(".submit").click(function(){
		 	//alert("add here");
		 	checkKysStatus();
		 	return false;
		 })
		 </script>
		 
</html>