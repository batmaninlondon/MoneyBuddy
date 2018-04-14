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
	<div id="msform" style="text-align: center;">
		<!-- progressbar -->
		<ul  id="progressbar" class="form1" >
			<li class="active">Basic Details</li>
			<li>Professional Details</li>
			<li>Address Details</li>
		</ul>
	<!-- fieldsets -->
	<fieldset  style="background-color: #cecece !important; ">
		<div style="background-color: white; height:55vh;">
		<br/>
		<div class="row g-text-left--xs " >
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs ">Name</div>
        	<div class="col-md-6 col-xs-6 "><input class="form-control" id="customer-name" type="text" placeholder="Enter Name as per PAN CARD" ></div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs g-margin-l-70--xs">Date of Birth</div>
        	<div class="col-md-6 col-xs-6 "><input class="form-control datepicker" name = "date" id="date-of-birth"  placeholder="Enter Date of Birth" ></div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs">Gender</div>
        	<div class="col-md-6 col-xs-6 ">
				<select class="form-control" id="gender">
			        <option value="M" selected>Male</option>
			        <option value="F">Female</option>
		      	</select>
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
        	<div class="col-md-2 col-xs-6 g-margin-l-70--xs">Occupation</div>
        	<div class="col-md-6 col-xs-6 ">
        		<select class="form-control" id="occupation" >
					<option value="PriSecJob" selected>Private Sector job</option>
					<option value="PubSecJob">Public Sector job</option>
					<option value="GovSer">Government Service</option>
					<option value="Business">Business</option>
					<option value="Professional">Professional</option>
					<option value="Agriculturist">Agriculturist</option>
					<option value="Retired">Retired</option>
					<option value="Student">Student</option>
					<option value="ForexDeal">Forex Dealer</option>
					<option value="HouseWife">Housewife</option>
					<option value="Others">Others</option>
				</select>
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
        <div class="row g-text-left--xs" >
        	<div class="col-md-2 col-xs-6 g-text-left--xs  g-margin-l-70--xs">Tax Status</div>
        	<div class="col-md-6 col-xs-6 ">
				<select class="form-control" id="tax-status" >
				        <option value="Individual" selected>Individual</option>
				        <option value="OnBeOfMinor">On Behalf Of Minor</option>
				        <option value="Huf">HUF</option>
				        <option value="Company">Company</option>
				        <option value="AopBoi">AOP/BOI</option>
				        <option value="Partnership">Partnership</option>
				        <option value="BodyCorporate">Body Corporate</option>
				        <option value="Trust">Trust</option>
				        <option value="Society">Society</option>
				        <option value="NriNre">NRI - Repatriable(NRE)</option>
				        <option value="OverCorpoBody">Oversea Corporate Body</option>
				        <option value="ForeInstiInvest">Foreign Institutional Investor</option>
				        <option value="OverCorpoBodyOthers">Oversea Corporate Body - Others</option>
				        <option value="ProviFundEpf">Provident Fund - EPF</option>
				        <option value="SuperAnnuFund">Super Annuation Fund</option>
				        <option value="GratuityFund">Gratuity Fund</option>
				        <option value="BankFinanInsti">Bank/Finanacial Institution</option>
				        <option value="SolePropri">Sole Proprietorship</option>
				        <option value="PensionFund">Pension Fund</option>
				        <option value="NriNro">NRI - Repatriable(NRO)</option>
				        <option value="NriMinorNre">NRI - Minor (NRE)</option>
				        <option value="NriHufNro">NRI-HUF(NRO)</option>
				        <option value="NriThruNroAc">NRI Through NRO A/c</option>
				        <option value="GloDevelopNet">Global Development Network</option>
				        <option value="NriHufNre">NRI-HUF(NRE)</option>
				        <option value="LimLiaParter">Limited Liability Partnership</option>
				        <option value="PubLimCompany">Public Limited Company</option>
				        <option value="PriLimCompany">Private Limited Company</option>
				        <option value="UnlisCompany">Unlisted Company</option>
				        <option value="OciRepatri">OCI - Repatriation</option>
				        <option value="OciNonRepatri">OCI - Non Repatriation</option>
				        <option value="Pio">Person of Indian Origin [PIO]</option>
				        <option value="Ngo">Non-Government Organisation [NGO]</option>
				        <option value="Others">Others</option>
			      	</select>
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
		
         </div>
			<input type="button" name="previous" class="previous action-button" value="Previous" style="width:20% ;float: left;" />
			<input type="button" name="next" class="next action-button" value="Next" style="width:20% ;float: right;"/>
	</fieldset>
	<fieldset  style="background-color: #cecece !important;">
		<div style="background-color: white; height:55vh;">
		<br/>
		<div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-2 col-xs-6 ">Line 1</div>
        	<div class="col-md-6 col-xs-6 ">
        		<input class="form-control" id="address-line-one" type="text" placeholder="Enter Address Line 1">
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
        <div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-2 col-xs-6 ">Line 2</div>
        	<div class="col-md-6 col-xs-6 ">
        		<input class="form-control" id="address-line-two" type="text" placeholder="Enter Address Line 2">
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>
		<div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-2 col-xs-6 ">Line 3</div>
        	<div class="col-md-6 col-xs-6 ">
        		<input class="form-control" id="address-line-three" type="text" placeholder="Enter Address Line 3" >
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>	
        <div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-2 col-xs-6 ">City</div>
        	<div class="col-md-6 col-xs-6 ">
        		<select class="form-control" id="residential-city" >
	  		      	<option value="Agra">Agra</option>
					<option value="Ahmedabad">Ahmedabad</option>
					<option value="Ajmer">Ajmer</option>
					<option value="Allahabad">Allahabad</option>
					<option value="Amritsar">Amritsar</option>
					<option value="Anand">Anand</option>
					<option value="Asansol">Asansol</option>
					<option value="Aurangabad">Aurangabad</option>
					<option value="Bangalore">Bangalore</option>
					<option value="Baroda">Baroda</option>
					<option value="Bharuch">Bharuch</option>
					<option value="Bhavnagar">Bhavnagar</option>
					<option value="Bhopal">Bhopal</option>
					<option value="Bhubaneswar">Bhubaneswar</option>
					<option value="Calicut">Calicut</option>
					<option value="Chandigarh">Chandigarh</option>
					<option value="Chennai">Chennai</option>
					<option value="Coimbatore">Coimbatore</option>
					<option value="Dehradun">Dehradun</option>
					<option value="Dharwad">Dharwad</option>
					<option value="Dubai">Dubai</option>
					<option value="Durgapur">Durgapur</option>
					<option value="Erode">Erode</option>
					<option value="Guntur">Guntur</option>
					<option value="Guwahati">Guwahati</option>
					<option value="Hubli">Hubli</option>
					<option value="Hyderabad">Hyderabad</option>
					<option value="Indore">Indore</option>
					<option value="Jaipur">Jaipur</option>
					<option value="Jalandhar">Jalandhar</option>
					<option value="Jalgaon">Jalgaon</option>
					<option value="Jamnagar">Jamnagar</option>
					<option value="Jamshedpur">Jamshedpur</option>
					<option value="Jodpur">Jodpur</option>
					<option value="Kanpur">Kanpur</option>
					<option value="Karaikudi">Karaikudi</option>
					<option value="Kochi">Kochi</option>
					<option value="Kolkata">Kolkata</option>
					<option value="Kota">Kota</option>
					<option value="Kottayam">Kottayam</option>
					<option value="Lucknow">Lucknow</option>
					<option value="Ludhiana">Ludhiana</option>
					<option value="Mangalore">Mangalore</option>
					<option value="Meerut">Meerut</option>
					<option value="Moradabad">Moradabad</option>
					<option value="Mumbai">Mumbai</option>
					<option value="Mysore">Mysore</option>
					<option value="Nagpur">Nagpur</option>
					<option value="Nasik">Nasik</option>
					<option value="NewDelhi">New Delhi</option>
					<option value="Panjim">Panjim</option>
					<option value="Patna">Patna</option>
					<option value="Pondicherry">Pondicherry</option>
					<option value="Pune">Pune</option>
					<option value="Raipur">Raipur</option>
					<option value="Rajahmundry">Rajahmundry</option>
					<option value="Rajkot">Rajkot</option>
					<option value="Ranchi">Ranchi</option>
					<option value="Salem">Salem</option>
					<option value="Siliguri">Siliguri</option>
					<option value="Surat">Surat</option>
					<option value="Tirunelveli">Tirunelveli</option>
					<option value="Tirupur">Tirupur</option>
					<option value="Trichy">Trichy</option>
					<option value="Trivandrum">Trivandrum</option>
					<option value="Udaipur">Udaipur</option>
					<option value="Varanasi">Varanasi</option>
					<option value="Vashi">Vashi</option>
					<option value="Vijayawada">Vijayawada</option>
					<option value="Others">Others</option>
			  </select>
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>	
		<div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-2 col-xs-6 ">State</div>
        	<div class="col-md-6 col-xs-6 ">
        		<select class="form-control" id="residential-state" >
			        <option value="AndamanAndNicobar">Andaman & Nicobar</option>
			        <option value="ArunachalPradesh">Arunachal Pradesh</option>
			        <option value="AndhraPradesh">Andhra Pradesh</option>
			        <option value="Assam">Assam</option>
			        <option value="Bihar">Bihar</option>
			        <option value="Chandigarh">Chandigarh</option>
			        <option value="Chhattisgarh">Chhattisgarh</option>
			        <option value="GOA">GOA</option>
			        <option value="Gujarat" selected>Gujarat</option>
			        <option value="Haryana">Haryana</option>
			        <option value="HimachalPradesh">Himachal Pradesh</option>
			        <option value="JammuAndKashmir">Jammu & Kashmir</option>
			        <option value="Jharkhand">Jharkhand</option>
			        <option value="Karnataka">Karnataka</option>
			        <option value="Kerala">Kerala</option>
			        <option value="MadhyaPradesh">Madhya Pradesh</option>
			        <option value="Maharashtra">Maharashtra</option>
			        <option value="Manipur">Manipur</option>
			        <option value="Meghalaya">Meghalaya</option>
			        <option value="Mizoram">Mizoram</option>
			        <option value="Nagaland">Nagaland</option>
			        <option value="NewDelhi">New Delhi</option>
			        <option value="Orissa">Orissa</option>
			        <option value="Pondicherry">Pondicherry</option>
			        <option value="Punjab">Punjab</option>
			        <option value="Rajasthan">Rajasthan</option>
			        <option value="Sikkim">Sikkim</option>
			        <option value="Telengana">Telengana</option>
			        <option value="TamilNadu">Tamil Nadu</option>
			        <option value="Tripura">Tripura</option>
			        <option value="UttarPradesh">Uttar Pradesh</option>
			        <option value="Uttaranchal">Uttaranchal</option>
			        <option value="WestBengal">West Bengal</option>
			        <option value="DadraAndNagarHaveli">Dadra and Nagar Haveli</option>
			        <option value="DamanAndDiu">Daman and Diu</option>
			        <option value="Lakshadweep">Lakshadweep</option>
			        <option value="Others">Others</option>
		     </select>
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>	
		<div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-2 col-xs-6 ">Country</div>
        	<div class="col-md-6 col-xs-6 ">
        		<input class="form-control" id="residential-country" type="text" placeholder="Enter Country">
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div>	
		<div class="row g-text-left--xs g-margin-l-70--xs" >
        	<div class="col-md-2 col-xs-6 previous">Pin</div>
        	<div class="col-md-6 col-xs-6 ">
        		<input class="form-control" id="residential-pin" type="text" placeholder="Enter Pin" >
        	</div>
        	<div class="col-md-6 col-xs-6 "></div>
        </div></div>
		<input type="button" name="previous" class="previous action-button" value="Previous" style="width:20% ;float: left;"/>
		<input type="submit" name="submit" class="submit action-button" value="Submit"  style="width:20% ;float: right;"/>
	</fieldset>
</div>
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