<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Investment Details Page | Money Buddy</title>
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/datepicker.css"/>
 	<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script type="text/javascript"  src="assets/js/jquery.js"></script>
    <script type="text/javascript"  src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    <script type="text/javascript" src="assets/js/wow.min.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">

	<style type="text/css">
		.ui-datepicker {
		   background: #333;
		   border: 1px solid #555;
		   color: #EEE;
		   width:200px;
		   heigth:300px;
		 }
	</style>
	<script type="text/javascript">
		$(function(){
			$('.datepicker').datepicker({
				dateFormat: "yy-mm-dd"
				
			});
		});
	</script>
</head>

<body class="homepage bg-warning" onload="setInitialUpfrontInvestment();">
   <header id="header">
<!--         <div class="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-4">
                        <div class="top-number"><p><i class="fa fa-phone-square"></i>  +91 9971648736</p></div>
                    </div>
                    <div class="col-sm-6 col-xs-8">
                       <div class="social">
                            <ul class="social-share">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li> 
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-skype"></i></a></li>
                            </ul>
                       </div>
                    </div>
                </div>
            </div>/.container
        </div>/.top-bar -->

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="myIndex"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="active" id="header-nav-li"><a href="myIndex">Home</a></li>
                        <li id="header-nav-li"><a href="startSip">Start SIP</a></li>
                        <li id="header-nav-li"><a href="saveTax">Save Tax</a></li>
                        <li id="header-nav-li"><a href="aboutUs">About Us</a></li>
                        <li id="header-nav-li"><a href="blog">Blog</a></li> 
                        <li id="header-nav-li"><a href="help">Contact Us</a></li>  
                       
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li id="header-nav-li"><a href="login" >Sign in</a></li>
										<li id="header-nav-li"><a href="register" >Sign up</a></li> 
							<%	} else 
							 	{	%>
							 			 <li id="header-nav-li"><a href="bseDashboard" >Dashboard</a></li> 
							 			 <li id="header-nav-li"><a href="logOff" >Log Out</a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
	
	<section  id="one">

	<div class="row" style="margin-top:-60px;margin-bottom:20px;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h2 style="font-family:Aparajita;font-size:35px;"><b>Please provide basic details</b></h2>
		</div>
		<div class="col-md-3"></div>
	</div>	
	<div class="row">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="customer-name" class="small-text pull-right">Name </label></div>

			<div  class="col-md-6" >
				  
				  <input class="form-control" id="customer-name" type="text" placeholder="Enter Name as per PAN CARD" style="margin-top:-10px;">
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="date-of-birth"  class="small-text pull-right">Date of Birth</label></div>
			<div  class="col-md-6" >
                <input class="form-control datepicker" name = "date" id="date-of-birth"  placeholder="Enter Date of Birth" style="margin-top:-10px;">
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="gender" class="small-text pull-right">Gender</label>
	      	</div>

			<div  class="col-md-6" >
				  
			  	<select class="form-control" id="gender" style="margin-top:-10px;">
			        <option value="M" selected>Male</option>
			        <option value="F">Female</option>
	
		      	</select>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>

	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="occupation" class="small-text pull-right">Occupation</label>
	      	</div>

			<div  class="col-md-6" >
				  
			  	<select class="form-control" id="occupation" style="margin-top:-10px;">
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
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>
		<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="tax-status" class="small-text pull-right">Tax Status</label>
	      	</div>

			<div  class="col-md-6" >
				  
			  	<select class="form-control" id="tax-status" style="margin-top:-10px;">
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
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>
	
	
	<div class="row" >
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<h2 class="small-text"><b>Address, as per the address proof**</b></h2>
		</div>
	</div>
	
	<div class="row" style="margin-top:10px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="address-line-one"  class="small-text pull-right">Line 1</label></div>
			<div  class="col-md-6" >
				  
				  <input class="form-control" id="address-line-one" type="text" placeholder="Enter Address Line 1" style="margin-top:-10px;">
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="address-line-two"  class="small-text pull-right">Line 2</label></div>
			<div  class="col-md-6" >
				  
				  <input class="form-control" id="address-line-two" type="text" placeholder="Enter Address Line 2" style="margin-top:-10px;">
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="address-line-three"  class="small-text pull-right">Line 3</label></div>
			<div  class="col-md-6" >
				  
				  <input class="form-control" id="address-line-three" type="text" placeholder="Enter Address Line 3" style="margin-top:-10px;">
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="residential-city" class="small-text pull-right">City</label></div>
			<div class="col-md-6" >
				  
			  	<select class="form-control" id="residential-city" style="margin-top:-10px;">
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
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>

	</div>

	<div class="row" style="margin-top:20px;">
		
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="residential-state" class="small-text pull-right">State</label></div>
			<div  class="col-md-6" >
				  
			  	<select class="form-control" id="residential-state" style="margin-top:-10px;">
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
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>

	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="residential-country" class="small-text pull-right">Country</label></div>
			<div class="col-md-6" >
				  
				  <input class="form-control" id="residential-country" type="text" placeholder="Enter Country" style="margin-top:-10px;">
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>

	</div>
	
		
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="residential-pin" class="small-text pull-right">Pin</label></div>
			<div class="col-md-6" >
				  
				  <input class="form-control" id="residential-pin" type="text" placeholder="Enter Pin" style="margin-top:-10px;">
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>

	</div>
	



	<div id="button-1" class="row" style="margin-top:25px;">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<button type="button" id="submit-button-1" class="btn btn-primary readmore submit-button-1" onClick="checkKysStatus();">SUBMIT</button>
		</div>
		<div class="col-md-5"></div>
	</div>
   </section>
      <footer id="footer" class="midnight-blue navbar navbar-fixed-bottom" >
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a target="_blank" href="http://quantwealth.in/" title="MoneyBuddy">MoneyBuddy</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="myIndex">Home</a></li>
                        <li><a href="aboutUs">About Us</a></li>
                        <li><a href="help">Contact Us</a></li>
                        <li><a href="register">Sign Up</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>



<%-- 		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script> --%>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</body>
</html>