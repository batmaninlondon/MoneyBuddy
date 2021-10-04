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
	width: 50%;
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

<script>

	function handleChange(el)  {
		
		if (el == "Others" )  {
			document.getElementById("other-scheme-name").disabled = false;
			document.getElementById("isin").disabled = false;
		}
		else {
			document.getElementById("other-scheme-name").disabled = true;
			document.getElementById("isin").disabled = true;
		}
		
	}
</script>



</head>

<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;" >
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
                                <a href="<s:url action="adminHome"/>" class="s-header-v2__logo-link">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
                                </a>
                            </div>
                            <!-- End Logo -->
                        </div>
                        
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col--right">
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="adminHome"/>" class="s-header-v2__nav-link">Home</a></li>
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
        
<div class="row g-margin-t-90--xs g-text-right--xs ">   
<s:form action="addOldPortfoioRecord" method="post" id="formAddOldPortfoioRecord" > 	
	<div id="msform" style="text-align: center;">
		<!-- progressbar -->
		<s:hidden name="customerIdOldPortfolio" value="%{customerIdOldPortfolio}" />
		<ul  id="progressbar" class="form1" >
			<li >Fund Details</li>
			<li >Investment Details</li>
		</ul>
	<!-- fieldsets -->
	<fieldset  style="background-color: #cecece !important; ">
		<div style="background-color: white; height:60vh;">
		<input class="form-control g-color--red text-center" id="errorMsg1" value=""  style="font-weight: bold; " readonly />
		<br/>
		<div class="row g-text-left--xs g-margin-t-10--xs" >
        	<div class="col-md-1 col-xs-1 "></div>
        	<div class="col-md-2 col-xs-6 g-margin-l-90--xs">Scheme Name</div>
        	<div class="col-md-6 col-xs-6 ">
				<s:select class="form-control"  id="scheme-name"
					list="availableSchemeNames"
					name="schemeName" value="defaultSchemeName"
					onchange="handleChange(this.value)"
					/>
        	</div>
        	<div class="col-md-3 col-xs-3 "></div>
        </div>
		<div class="row g-text-left--xs " >
        	<div class="col-md-1 col-xs-1 "></div>
        	<div class="col-md-2 col-xs-6 g-margin-l-90--xs ">Scheme Name</div>
        	<div class="col-md-6 col-xs-6 ">
        		<%-- <s:fielderror fieldName="customerName" class="g-color--red" />
		  		<s:textfield class="form-control" id="customer-name" placeholder="Your Full Name: As per Pan Card" name="customerName"/> --%> 
		  		<input class="form-control" name="otherSchemeName" id="other-scheme-name" placeholder="Enter Scheme Name" required />
        	</div>
        	<div class="col-md-3 col-xs-3 "></div>
        </div>
        <div class="row g-text-left--xs " >
        	<div class="col-md-1 col-xs-1 "></div>
        	<div class="col-md-2 col-xs-6 g-margin-l-90--xs ">ISIN</div>
        	<div class="col-md-6 col-xs-6 ">
        		<%-- <s:fielderror fieldName="customerName" class="g-color--red" />
		  		<s:textfield class="form-control" id="customer-name" placeholder="Your Full Name: As per Pan Card" name="customerName"/> --%> 
		  		<input class="form-control" name="isin" id="isin" placeholder="Enter ISIN" required />
        	</div>
        	<div class="col-md-3 col-xs-3 "></div>
        </div>
        </div>
        	<input type="submit" id="nextBtn1" name="next" class="action-button " value="Next" style="width:20% ;float: right;"/>
	</fieldset>
	
	<fieldset  style="background-color: #cecece !important;">
		<div style="background-color: white; height:60vh;">
		<input class="form-control g-color--red text-center" id="errorMsg2" value=""  style="font-weight: bold; " readonly />
		<br/>
		<div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-1 col-xs-1 "></div>
        	<div class="col-md-2 col-xs-6 ">Current Amount</div>
        	<div class="col-md-6 col-xs-6 ">
        		<%-- <s:fielderror fieldName="addressLineOne" class="g-color--red" />
			  	<s:textfield class="form-control" id="address-line-one" placeholder="Address Line 1" name="addressLineOne" requiredLabel="true"/>  --%>
			  	<input class="form-control" name="currentAmount"  id="current-amount" placeholder="Enter Current Amount"  required />
			</div>
        	<div class="col-md-3 col-xs-3 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-1 col-xs-1 "></div>
        	<div class="col-md-2 col-xs-6 ">Current Units</div>
        	<div class="col-md-6 col-xs-6 ">
        		<%-- <s:fielderror fieldName="addressLineTwo" class="g-color--red" /> --%>
			  	<%-- <s:textfield class="form-control" id="address-line-two" placeholder="Address Line 2" name="addressLineTwo" />  --%>
			  	<input class="form-control" name="currentUnits"  id="current-units" placeholder="Enter Units" />
        	</div>
        	<div class="col-md-3 col-xs-3 "></div>
        </div>
		<div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-1 col-xs-1 "></div>
        	<div class="col-md-2 col-xs-6 ">Folio number</div>
        	<div class="col-md-6 col-xs-6 ">
        		<%-- <s:fielderror fieldName="addressLineOne" class="g-color--red" />
			  	<s:textfield class="form-control" id="address-line-one" placeholder="Address Line 1" name="addressLineOne" requiredLabel="true"/>  --%>
			  	<input class="form-control" name="folioNumber"  id="folio-number" placeholder="Enter Folio Number"  required />
			</div>
        	<div class="col-md-3 col-xs-3 "></div>
        </div>
		</div>
		<input type="button" name="previous" class="previous action-button" value="Previous" style="width:20% ;float: left;"/>
		<!-- <input type="submit" id="nextBtn3" class="next action-button" value="SUBMIT" style="width:20% ;float: right;"/> -->
		
		<s:submit class="action-button" value="SUBMIT" style="width:20% ;float: right;" id="submitBtn"/>
	</fieldset>
</div>
</s:form>
</div>

	  
</body>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
		<script src="assets/js/jquery.js"></script>
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
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

		 $("#nextBtn1").click(function(){
				
			var schemeName = document.getElementById("scheme-name");
		 	var otherSchemeName = document.getElementById("other-scheme-name");
		 	var isin = document.getElementById("isin");
		 	
		 	var invalid = (otherSchemeName.value == "") || (isin.value == "") 
		 	if (schemeName.value != "Others")  {
		 		invalid = false;
		 	}
		    
			if ( invalid )  {
				if ( otherSchemeName.value == "" )  {
					/* cusName.focus();
					cusName.style.backgroundColor = "red"; */
					document.getElementById("errorMsg1").value="Error: Please fill Scheme Name";
				}
				else if ( isin.value == "" ) {
					document.getElementById("errorMsg1").value="Error: Please fill ISIN";
				}
			}
			else   {
			 		
		 		if(animating) return false;
			 	animating = true;
			 	
			 	current_fs = $(this).parent();
			 	next_fs = $(this).parent().next();
			 					
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
		 }

		 	
		 });
		 
		 
		 $("#submitBtn").click(function(){
			 var curAmount = document.getElementById("current-amount");
			 var curUnits = document.getElementById("current-units");
			 var folNum = document.getElementById("folio-number");
			 
			 var invalid =  (curAmount.value == "") || (curUnits.value == "")  || (folNum.value == "");
			 
			 if ( invalid )  {
					if ( curAmount.value == "" )  {
						document.getElementById("errorMsg2").value="Error: Please fill Amount";
					}
					else if ( curUnits.value == "" )  {
						document.getElementById("errorMsg2").value="Error: Please fill Units";
					}
					else if ( folNum.value == "" )  {
						document.getElementById("errorMsg2").value="Error: Please fill Folio Number";
					}
			 }
			 else {
				 document.formAddOldPortfoioRecord.submit(); 
			 }
			 
			 
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

/* 		 $(".submit").click(function(){
		 	//alert("add here");
		 	checkKysStatus();
		 	return false;
		 }) */
		 </script>
		 
</html>