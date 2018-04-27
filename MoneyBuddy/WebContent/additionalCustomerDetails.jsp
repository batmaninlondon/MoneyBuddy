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
        <title>Megakit - HTML5 Theme</title>
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="Megakit - HTML5 Theme">
        <meta name="author" content="keenthemes.com">

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->

        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
	    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
		    
	    
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
		<div style="background-color: white; height:55vh;">
		<br/>
		<div class="row g-text-left--xs " >
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs ">Father's Name</div>
        	<div class="col-md-6 col-xs-6 ">
        		<s:fielderror fieldName="fatherName" class="g-color--red" />
			  	<s:textfield class="form-control" id="father-name" placeholder="Enter Father's Name" name="fatherName" />
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs">Marital Status</div>
        	<div class="col-md-6 col-xs-6 ">
				<s:select class="form-control"  id="marital-status"  
					list="#{'Married':'Married', 'Single':'Single'}" 
					name="maritalStatus" 
					value="Married" />
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs">Nationality</div>
        	<div class="col-md-6 col-xs-6 ">
				<s:select class="form-control"  id="nationality" 
					list="#{'Indian':'Indian', 'Other':'Other'}" 
					name="nationality" 
					value="Indian" />
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
        </div>
        	<input type="button" name="next" class=" next action-button " value="Next" style="width:20% ;float: right;"/>
	</fieldset>
	<fieldset  style="background-color: #cecece !important;">
		<div style="background-color: white; height:55vh;">
		<br/>
		<div class="row g-text-left--xs" >
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs">Status</div>
        	<div class="col-md-6 col-xs-6 ">
				<s:select class="form-control"  id="status" 
					list="#{'LivInInd':'Living in India', 'NonResInd':'Non Resident Indian (NRI)', 'ForNat':'Foreign National'}" 
					name="status" 
					value="LivInInd" />
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs">Gross Annual Income</div>
        	<div class="col-md-6 col-xs-6 ">
				<s:select class="form-control"  id="gross-annual-income"  
					list="#{'LesThaOneLak':'less than 1 lakh', 'OneToFivLak':'1 to 5 lakhs', 'FivToTenLak':'5 to 10 lakhs',
					'TenToTweFivLak':'10 to 25 lakhs','MorThaTweFivLak':'More Than 25 lakhs' }" 
					name="grossAnnualIncome" 
					value="LesThaOneLak" />
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs">Politically Exposed Person</div>
        	<div class="col-md-6 col-xs-6 ">
				<s:select class="form-control"  id="politically-exposed" 
					list="#{'No':'No', 'PoliticExposed':'Politically Exposed Person', 
					'RelToPoliticExposed':'Related to a Politically Exposed Person' }" 
					name="politicallyExposed" 
					value="No" />
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
		
         </div>
			<input type="button" name="previous" class="previous action-button" value="Previous" style="width:20% ;float: left;" />
			<!-- <input type="button" name="next" class="next action-button" value="Next" style="width:20% ;float: right;"/> -->
			<s:submit class="next action-button" value="Continue" style="width:20% ;float: right;"/>
	</fieldset>
</div>
</s:form>
</div>	  
</body>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
    	<script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
   	 	<script src="assets/js/main.js"></script>
    	<script src="assets/js/wow.min.js"></script>


        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.parallax.min.js"></script>
        <script type="text/javascript" src="vendor/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>

        <!-- General Components and Settings -->
        <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="js/components/faq.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
         <script  src="js/index.js"></script>	
         
         
		<!-- jQuery easing plugin -->
		<script src="http://thecodeplayer.com/uploads/js/jquery.easing.min.js" type="text/javascript"></script>
		    	
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
		 	alert("add here");
		 	checkKysStatus();
		 	return false;
		 })
		 </script>
		 
</html>