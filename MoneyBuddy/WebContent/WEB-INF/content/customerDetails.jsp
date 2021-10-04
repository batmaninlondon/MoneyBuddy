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
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
	    
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
	width: 20%;
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
        
<div class="row g-margin-t-90--xs g-text-right--xs ">   
<s:form action="kycCheckAction" method="post" id="formKycCheckAction" > 	
	<div id="msform" style="text-align: center;">
		<!-- progressbar -->
		
		<ul  id="progressbar" class="form1" >
			<li class="active">Basic Details</li>
			<li >Address</li>
			<li class="hidden" id="nri-address-tab">Address-Nri</li>
			<li >FATCA Details</li>
			<li >Payment</li>
		</ul>
	<!-- fieldsets -->
	<fieldset  style="background-color: #cecece !important; " id="basic-details-tab">
		<div style="background-color: white; " class="g-height-450--xs">
		<input class="form-control g-color--red text-center" id="errorMsg1" value=""  style="font-weight: bold; " readonly />
		
		<div class="row g-text-left--xs g-margin-t-10--lg" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg ">Name</div>
        	<div class="col-lg-6 col-xs-8 ">
		  		<input class="form-control g-font-size-10--xs g-font-size-14--lg "
		  			name="customerName" id="customer-name" placeholder="Your Full Name: As per Pan Card" required />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg ">Mobile</div>
        	<div class="col-lg-6 col-xs-8 ">
		  		<input class="form-control g-font-size-10--xs g-font-size-14--lg "
		  			name="mobileNumber" id="mobile-number" placeholder="10 digit Indian Mobile no" required />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg ">PAN</div>
        	<div class="col-lg-6 col-xs-8 ">
		  		<input class="form-control g-font-size-10--xs g-font-size-14--lg "
		  			name="panCard" pattern="^[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}$" id="pancard-number" placeholder="Pancard Number" required   />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg ">Date of Birth</div>
        	<div class="col-lg-6 col-xs-8 ">
        		<input class="form-control datepicker g-font-size-10--xs g-font-size-14--lg "
        			id="date-of-birth" pattern="^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$" name="dateOfBirth" 
        						 placeholder="DD/MM/YYYY Format" required  >
        		
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Gender</div>
        	<div class="col-lg-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg "  id="gender"
					list="#{'M':'Male', 'F':'Female'}" 
					name="gender" 
					value="F" />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-t-10--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Working as</div>
        	<div class="col-lg-6 col-xs-8 ">
        		<s:select class="form-control g-font-size-10--xs g-font-size-14--lg "  id="occupation" 
					list="#{'PriSecJob':'Private Sector job', 'PubSecJob':'Public Sector job', 'GovSer':'Government Service',
					'Business':'Business', 'Professional':'Professional', 
					'Retired':'Retired', 'Student':'Student', 
					'HouseWife':'Housewife', 'Others':'Others' }" 
					name="occupation" 
					value="PriSecJob" />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-t-10--lg" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">You are</div>
        	<div class="col-lg-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg "  id="tax-status"
					list="#{'Individual':'Resident Individual', 'NriNre':'NRI with NRE a/c', 'NriNro':'NRI with NRO a/c'}" 
					name="taxStatus" 
					value="Individual" />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-t-10--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Nominee Name</div>
        	<div class="col-lg-6 col-xs-8 ">
		  		<input class="form-control g-font-size-10--xs g-font-size-14--lg " 
		  			name="nomineeName" id="nominee-name" placeholder="Nominee Name" required />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs  " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Relationship</div>
        	<div class="col-lg-6 col-xs-8 ">
		  		<input class="form-control g-font-size-10--xs g-font-size-14--lg "
		  			name="nomineeRelationship" id="nominee-relationship" placeholder="Nominee Relationship" required  />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        </div>
        	<input type="submit" id="nextBtn1" name="next" class="action-button " value="Next" style="width:23% ;float: right;"/>
	</fieldset>
	<fieldset  style="background-color: #cecece !important;" id="address-details-tab" >

		<div style="background-color: white; "  class="g-height-450--xs">
				
		<input class="form-control g-color--red text-center" id="errorMsg2" value=""  style="font-weight: bold; " readonly />
		
		<div class="row g-text-left--xs g-margin-t-30--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg"> Line 1</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg "
			  		name="addressLineOne"  id="address-line-one" placeholder="Address Line 1"  required  />
			</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg"> Line 2</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg " 
			  		name="addressLineTwo"  id="address-line-two" placeholder="Address Line 2"  required />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
		<div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg"> Line 3</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg "
			  		name="addressLineThree"  id="address-line-three" placeholder="Address Line 3"   />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>	
        <div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">City</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg " 
			  		id="residential-city" placeholder="City" name="residentialCity" required  />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>	
		<div class="row g-text-left--xs  " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">State</div>
        	<div class="col-lg-6 col-xs-8 ">
        		<s:select class="form-control g-font-size-10--xs g-font-size-14--lg "  id="residential-state"
					list="#{'AndamanAndNicobar':'Andaman & Nicobar', 'ArunachalPradesh':'Arunachal Pradesh', 'AndhraPradesh':'Andhra Pradesh', 
			        'Assam':'Assam', 'Bihar':'Bihar', 'Chandigarh':'Chandigarh', 'Chhattisgarh':'Chhattisgarh', 'GOA':'GOA', 'Gujarat':'Gujarat', 
			        'Haryana':'Haryana', 'HimachalPradesh':'Himachal Pradesh', 'JammuAndKashmir':'Jammu & Kashmir', 'Jharkhand':'Jharkhand', 
			        'Karnataka':'Karnataka', 'Kerala':'Kerala', 'MadhyaPradesh':'Madhya Pradesh', 'Maharashtra':'Maharashtra', 'Manipur':'Manipur', 
			        'Meghalaya':'Meghalaya', 'Mizoram':'Mizoram', 'Nagaland':'Nagaland', 'NewDelhi':'New Delhi', 'Orissa':'Orissa', 
			        'Pondicherry':'Pondicherry', 'Punjab':'Punjab', 'Rajasthan':'Rajasthan', 'Sikkim':'Sikkim', 'Telengana':'Telengana', 
			        'TamilNadu':'Tamil Nadu', 'Tripura':'Tripura', 'UttarPradesh':'Uttar Pradesh', 'Uttaranchal':'Uttaranchal', 
			        'WestBengal':'West Bengal', 'DadraAndNagarHaveli':'Dadra and Nagar Haveli', 'DamanAndDiu':'Daman and Diu', 
			        'Lakshadweep':'Lakshadweep', 'Others':'Others' }" 
					name="residentialState" 
					value="AndamanAndNicobar" />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>	
		<div class="row g-text-left--xs g-margin-t-10--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Country</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg "  id="residential-country" placeholder="Country" 
			  			name="residentialCountry" value="India" required/>
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>	
		<div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Pin</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg "
			  		id="residential-pin" pattern="^[0-9]{6}$"  placeholder="Pin" name="residentialPin" required  />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-t-20--xs" >
        	<div class="col-lg-1 col-xs-1 "></div>
        	<div class="col-lg-11 col-xs-11 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg"><b><u>* Address proof not required</u></b></div>
        </div>
		
         </div>
			<input type="button" name="previous" class="previous action-button" value="Previous" style="width:23% ;float: left;" />
			
			<input type="submit" id="nextBtn2" name="next"  class="action-button" value="Next" style="width:23% ;float: right;"/>
			
	</fieldset>
	
		<fieldset  style="background-color: #cecece !important;" id="address-nri-details-tab" >

		<div style="background-color: white; "  class="g-height-450--xs">
				
		<input class="form-control g-color--red text-center" id="errorMsg3" value=""  style="font-weight: bold; " readonly />
		
		<div class="row g-text-left--xs g-margin-t-30--xs" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg"> Line 1</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg "
			  		name="addressLineOneNri"  id="address-line-one-nri" placeholder="Address Line 1"  required />
			</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg"> Line 2</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg " 
			  		name="addressLineTwoNri"  id="address-line-two-nri" placeholder="Address Line 2" required />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
		<div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg"> Line 3</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg "
			  		name="addressLineThreeNri"  id="address-line-three-nri" placeholder="Address Line 3" />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>	
        <div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">City</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg " 
			  		id="residential-city-nri" placeholder="City" name="residentialCityNri" required/>
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">State</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg " 
			  		id="residential-state-nri" placeholder="State" name="residentialStateNri" required/>
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>	
        <div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Country</div>
        	<div class="col-lg-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg "  id="residential-country-nri"
					list="#{'014':'Australia', '229':'United Kingdom', '230':'United States of America'}" 
					name="residentialCountryNri" 
					value="Individual" />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>	
		<div class="row g-text-left--xs g-margin-t-10--lg" >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Pin</div>
        	<div class="col-lg-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg "
			  		id="residential-pin-nri"  placeholder="Pin" name="residentialPinNri" required/>
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs " >
        	<div class="col-lg-1 col-xs-0 "></div>
        	<div class="col-lg-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg ">Phone</div>
        	<div class="col-lg-6 col-xs-8 ">
		  		<input class="form-control g-font-size-10--xs g-font-size-14--lg "
		  			name="mobileNumberNri" id="mobile-number-nri" placeholder="Mobile no" required />
        	</div>
        	<div class="col-lg-3 col-xs-1 "></div>
        </div>
		
         </div>
			<input type="button" name="previous" class="previous action-button" value="Previous" style="width:23% ;float: left;" />
			
			<input type="submit" id="nextBtn3" name="next"  class="action-button" value="Next" style="width:23% ;float: right;"/>
			
	</fieldset>
	
	<fieldset  style="background-color: #cecece !important;" id="fatca-details-tab" >

		<div style="background-color: white;" class="g-height-450--xs">
				
		<input class="form-control g-color--red text-center" id="errorMsg4" value=""  style="font-weight: bold; " readonly />
			
		<div class="row g-text-left--xs g-margin-t-30--xs" >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">City of Birth</div>
        	<div class="col-md-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg" name="placeOfBirth"  
			  			id="place-of-birth" placeholder="Place (City) of Birth"  required  />
			</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Country of Birth</div>
        	<div class="col-md-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="country-of-birth"
					list="#{'IN':'India','AU':'Australia', 'GB':'United Kingdom', 'US':'United States',  'ZZ':'Other'}" 
					name="countryOfBirth" 
					value="IN" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-t-10--xs" >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Tax Residency</div>
        	<div class="col-md-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="tax-residency"
					list="#{'IN':'India','AU':'Australia', 'GB':'United Kingdom', 'US':'United States',  'ZZ':'Other'}" 
					name="taxResidency" 
					value="IN" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-t-10--xs" >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Income slab</div>
        	<div class="col-md-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="income-slab"
					list="#{'31':'Below 1 Lac','32':'1 Lac - 5 Lac','33':'5 Lac - 10 Lac','34':'10 Lac - 25 Lac','35':'25 Lac - 1 Cr','36':'Above 1 Cr' }" 
					name="incomeSlab" 
					value="33" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-t-10--xs" >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Politically Exposed?</div>
        	<div class="col-md-6 col-xs-8 ">
				<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="politically-exposed"
					list="#{'N':'No','Y':'Yes', 'R':'Related to PEP'}" 
					name="politicallyExposed" 
					value="N" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-t-10--xs hidden" id="tax-identification-number-row">
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Tax Identification no</div>
        	<div class="col-md-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg" name="taxIdentificationNumber"  
			  			id="tax-identification-number" placeholder="Of your residential country"  required  />
			</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
		
         </div>
			<input type="button" name="previous" class="previous action-button" value="Previous" style="width:23% ;float: left;" />
			
			<input type="submit" id="nextBtn4" name="next"  class="action-button" value="Next" style="width:23% ;float: right;"/>
			
	</fieldset>
	<fieldset  style="background-color: #cecece !important;" id="payment-details-tab" >
		<div style="background-color: white;" class="g-height-450--xs">
		<input class="form-control g-color--red text-center" id="errorMsg5" value=""  style="font-weight: bold; " readonly />
		
		<div class="row g-text-left--xs g-margin-t-30--xs " >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Bank Name</div>
        	<div class="col-md-6 col-xs-8 ">
        		<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="bank-name"
					list="#{'ICI':'ICICI Bank', 'SBI':'SBI Bank', 'HDF':'HDFC Bank', 
			        '162':'KOTAK Bank', 'UTI':'Axis Bank', 'PNB':'Punjab National Bank', 'SIB':'South Indian Bank', 
			        'SCB':'Standard Chartered Bank', 'UBI':'Union Bank Of India', 'UNI':'United Bank Of India', 
			        'YBK':'Yes Bank Ltd', 'RBL':'Ratnakar Bank', 'DCB':'DCB','DEN':'DENA Bank','BBR':'Bank of Baroda',
			        'IDS':'IndusInd Bank','IDB':'IDBI Bank','CNB':'Canara Bank'}" 
					name="bankName" 
					value="ICI" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>	
		<div class="row g-text-left--xs g-margin-t-10--xs " >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Account Type</div>
        	<div class="col-md-6 col-xs-8 ">
        		<s:select class="form-control g-font-size-10--xs g-font-size-14--lg"  id="account-type"
					list="#{'SB':'Saving', 'CB':'Current', 'NE':'NRE', 
			        'NO':'NRO'}" 
					name="accountType" 
					value="SB" />
        	</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>	
		<div class="row g-text-left--xs g-margin-t-10--xs" >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Account Number</div>
        	<div class="col-md-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg"  id="account-number"  onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57"  placeholder="Account Number" name="accountNumber" required/>
			</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
		<div class="row g-text-left--xs" >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">Re-enter Account Number</div>
        	<div class="col-md-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg"  id="re-account-number" onpaste="return false" onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57"  placeholder="Account Number" name="reAccountNumber" required/>
			</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
        <div class="row g-text-left--xs " >
        	<div class="col-md-1 col-xs-0 "></div>
        	<div class="col-md-2 col-xs-3 g-margin-l-10--xs g-margin-l-90--lg g-font-size-12--xs g-font-size-16--lg">IFSC Code</div>
        	<div class="col-md-6 col-xs-8 ">
			  	<input class="form-control g-font-size-10--xs g-font-size-14--lg"  id="ifsc-code" placeholder="IFSC Code" name="ifscCode" required/> 
			</div>
        	<div class="col-md-3 col-xs-1 "></div>
        </div>
		
		</div>
		<input type="button" name="previous" class="previous action-button" value="Previous" style="width:23% ;float: left;"/>
		
		<s:submit class="action-button" value="SUBMIT" style="width:23% ;float: right;" id="submitBtn"/>
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
		 var nri = false;

		 $("#nextBtn1").click(function(){
				
			var cusName = document.getElementById("customer-name");
		 	var panNum = document.getElementById("pancard-number");
		 	var dateOfBir = document.getElementById("date-of-birth");
		 	var nomName = document.getElementById("nominee-name");
		 	var nomRel = document.getElementById("nominee-relationship");
		 	var taxStatus = document.getElementById("tax-status");
		 	
		 	if ( taxStatus.value == "Individual" )  {
		 		$("#nri-address-tab").addClass('hidden');	
		 		$("#tax-identification-number-row").addClass('hidden');	
		 	}
		 	else {
		 		nri = true;
		 		$("#nri-address-tab").removeClass('hidden');
		 		$("#tax-identification-number-row").removeClass('hidden');
		 	}
		 	
		 	var DOB = dateOfBir.value;
		 	DOB = DOB.substr(6)+"-"+DOB.substr(3,2)+"-"+DOB.substr(0,2);
			var today = new Date();
		    var birthDate = new Date(DOB);
		    
		    var age = today.getFullYear() - birthDate.getFullYear();
		    var m = today.getMonth() - birthDate.getMonth();
		    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
		        age--;
		    } 
		 	var invalid =  (cusName.value == "") || (panNum.value == "") || (dateOfBir.value == "") ||
				(nomName.value == "") || (nomRel.value == "") || (!new RegExp(panNum.getAttribute("pattern")).test(panNum.value)) ||
				(!new RegExp(dateOfBir.getAttribute("pattern")).test(dateOfBir.value)) || (age < 18) ;


			if ( invalid )  {
				if ( cusName.value == "" )  {
					/* cusName.focus();
					cusName.style.backgroundColor = "red"; */
					document.getElementById("errorMsg1").value="Error: Please fill Name";
				}
				else if ( panNum.value == "" ) {
					document.getElementById("errorMsg1").value="Error: Please fill Pan";
				}
				else if ( !new RegExp(panNum.getAttribute("pattern")).test(panNum.value)) {
					document.getElementById("errorMsg1").value="Error: Please fill Valid Pan Num (without spaces)";
				}
				else if ( dateOfBir.value == "" ) {
					document.getElementById("errorMsg1").value="Error: Please fill Date Of Birth ";
				}
				else if ( age < 18) {
					document.getElementById("errorMsg1").value="Error: Age shall be 18+";
				}
				else if ( !new RegExp(dateOfBir.getAttribute("pattern")).test(dateOfBir.value)) {
					document.getElementById("errorMsg1").value="Error: Please fill Valid Date Of Birth (without spaces)";
				}
				else if ( nomName.value == "" ) {
					document.getElementById("errorMsg1").value="Error: Please fill Nominee Name";
				}
				else if ( nomRel.value == "" ) {
					document.getElementById("errorMsg1").value="Error: Please fill Nominee Relation";
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
		 
		 $("#nextBtn2").click(function(){

			var add1 = document.getElementById("address-line-one");
		 	var city = document.getElementById("residential-city");
		 	var country = document.getElementById("residential-country");
		 	var pin = document.getElementById("residential-pin");
		 	  
		 	var invalid =  (add1.value == "") || (city.value == "") || (country.value == "") ||
		 					(pin.value == "") || (!new RegExp(pin.getAttribute("pattern")).test(pin.value));
		 	
		 	
		 	if ( invalid )  {
		 		if ( add1.value == "" )  {
		 			document.getElementById("errorMsg2").value="Error: Please fill Address";
		 		}
		 		else if ( city.value == "" ) {
		 			document.getElementById("errorMsg2").value="Error: Please fill City";
		 		}
		 		else if ( country.value == "" ) {
		 			document.getElementById("errorMsg2").value="Error: Please fill Country";
		 		}
		 		else if ( pin.value == "" ) {
		 			document.getElementById("errorMsg2").value="Error: Please fill Pin";
		 		}
		 		else if ( !new RegExp(pin.getAttribute("pattern")).test(pin.value)) {
		 			document.getElementById("errorMsg2").value="Error: Please fill Valid pin (without spaces)";
		 		}
		 	}
		 	        
		 	/* if ( add1.value != "" && city.value != "" && country.value != "" && pin.value != "" )    {
		 		
		 		var invalid =  new RegExp(pin.getAttribute("pattern")).test(pin.value); */
		 		
		 		else {

		 			document.getElementById("errorMsg2").value="";
				//activate next step on progressbar using the index of next_fs
				
				
				
				 if(animating) return false;
				 	animating = true;
				 	
				 	if ( nri == false )  {
				 		
				 		
					 	current_fs = $(this).parent();
					 	next_fs = $(this).parent().next().next();
				 	}
				 	else {
				 		
				 		
				 		current_fs = $(this).parent();
					 	next_fs = $(this).parent().next();
				 	}
				
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
			 	return false;
		 		}
			/*  }
		 	 */
		 });
		 
		 $("#nextBtn3").click(function(){

				var add1Nri = document.getElementById("address-line-one-nri");
			 	var cityNri = document.getElementById("residential-city-nri");
			 	var stateNri = document.getElementById("residential-state-nri");
			 	var pinNri = document.getElementById("residential-pin-nri");
			 	var mobileNri = document.getElementById("mobile-number-nri");
			 	  
			 	var invalid =  (add1Nri.value == "") || (cityNri.value == "") || (stateNri.value == "") || (pinNri.value == "") ||
			 					(mobileNri.value == "") ;
			 	
			 	
			 	if ( invalid )  {
			 		if ( add1Nri.value == "" )  {
			 			document.getElementById("errorMsg3").value="Error: Please fill Address";
			 		}
			 		else if ( cityNri.value == "" ) {
			 			document.getElementById("errorMsg3").value="Error: Please fill City";
			 		}
			 		else if ( stateNri.value == "" ) {
			 			document.getElementById("errorMsg3").value="Error: Please fill Country";
			 		}
			 		else if ( pinNri.value == "" ) {
			 			document.getElementById("errorMsg3").value="Error: Please fill Pin";
			 		}
			 		else if ( mobileNri.value == "" ) {
			 			document.getElementById("errorMsg3").value="Error: Please fill Mobile Number";
			 		}
			 	}
			 	        
			 	/* if ( add1.value != "" && city.value != "" && country.value != "" && pin.value != "" )    {
			 		
			 		var invalid =  new RegExp(pin.getAttribute("pattern")).test(pin.value); */
			 		
			 		else {

			 			document.getElementById("errorMsg3").value="";
					//activate next step on progressbar using the index of next_fs
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
				 	return false;
			 		}
				/*  }
			 	 */
			 });
		 
		 $("#nextBtn4").click(function(){

				var placeOfBirth = document.getElementById("place-of-birth");
				var invalid = "";
				
				if ( nri == true )  {
					var taxIdentificationNum = document.getElementById("tax-identification-number");
					var invalid =  (placeOfBirth.value == "") || (taxIdentificationNum.value == "") ;
				}
				else {
					var invalid =  (placeOfBirth.value == "") ;
				}
			 	  
			 	
			 	
			 	
			 	if ( invalid )  {
			 		if ( placeOfBirth.value == "" )  {
			 			document.getElementById("errorMsg4").value="Error: Please fill Place of Birth";
			 		}
			 		else if ( taxIdentificationNum.value == "" )  {
			 			document.getElementById("errorMsg4").value="Error: Please fill Tax Identification Number";
			 		}
			 	}
			 	else {

			 		document.getElementById("errorMsg4").value="";
					//activate next step on progressbar using the index of next_fs
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
				 	return false;
			 		}
				/*  }
			 	 */
			 });
		 
		 $("#submitBtn").click(function(){
			 var accNum = document.getElementById("account-number");
			 var reAccNum = document.getElementById("re-account-number");
			 var ifscCode = document.getElementById("ifsc-code");
			 
			 var invalid =  (accNum.value == "") || (reAccNum.value == "") ||
			 			(ifscCode.value == "") || (!(accNum.value == reAccNum.value));
			 
			 if ( invalid )  {
					if ( accNum.value == "" )  {
						document.getElementById("errorMsg5").value="Error: Please fill Account Number";
					}
					else if ( reAccNum.value == "" )  {
						document.getElementById("errorMsg5").value="Error: Please fill Account Number";
					}
					else if ( !(accNum.value == reAccNum.value)) {
						document.getElementById("errorMsg5").value="Error: Account number does not match( make sure there are no spaces)";
					}
					else if ( ifscCode.value == "" )  {
						document.getElementById("errorMsg5").value="Error: Please fill IFSC Code";
					}
			 }
			 else {
				 document.formKycCheckAction.submit(); 
			 }
			 
			 
		 });

		 $(".previous").click(function(){
			 
			 
		 	if(animating) return false;
		 	animating = true;
		 	
		 	current_fs = $(this).parent();
		 	previous_fs = $(this).parent().prev();
		 	
		 	if ($("#nri-address-tab").hasClass("hidden") && ( current_fs.attr('id') == "fatca-details-tab"))   {
		 		previous_fs = $(this).parent().prev().prev();
		 	}
		 	
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