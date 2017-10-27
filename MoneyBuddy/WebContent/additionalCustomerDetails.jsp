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
    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    <script type="text/javascript" src="assets/js/wow.min.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">

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
                        <li id="header-nav-li"><a href="whyInvest">Why Invest</a></li>
                        <li id="header-nav-li"><a href="aboutUs">About Us</a></li>
                        <li id="header-nav-li"><a href="saveTax">Save Tax</a></li>
                        <li id="header-nav-li"><a href="blog">Blog</a></li> 
                        <li id="header-nav-li"><a href="help">Help</a></li> 
                       
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
	<% session.setAttribute("transactionType", "UPFRONT"); %>
	<section  id="one">

	<div class="row" style="margin-top:-60px;margin-bottom:20px;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h2 style="font-family:Aparajita;font-size:35px;"><b>Please provide additional details</b></h2>
		</div>
		<div class="col-md-3"></div>
	</div>
	
	<div class="row" >
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="father-name"  class="small-text pull-right">Father's Name</label></div>
			<div  class="col-md-6" >
				  
				  <input class="form-control" id="father-name" type="text" placeholder="Enter Father's Name" style="margin-top:-10px;">
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
				  
				  <input class="form-control" name = "date" id="date-of-birth" type="text" placeholder="Enter Date of Birth" style="margin-top:-10px;">
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
		
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="marital-status" class="small-text pull-right">Marital Status</label>
	      	</div>

			<div  class="col-md-6" >
				  
			  	<select class="form-control" id="marital-status" style="margin-top:-10px;">
			        <option value="Single">Single</option>
			        <option value="Married" selected>Married</option>
	
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
			<div class="col-md-4"><label for="nationality" class="small-text pull-right">Nationality</label>
	      	</div>

			<div  class="col-md-6" >
				  
			  	<select class="form-control" id="nationality" style="margin-top:-10px;">
			        <option value="Indian" selected>Indian</option>
			        <option value="Other">Other</option>
	
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
			<div class="col-md-4"><label for="status" class="small-text pull-right">Status</label>
	      	</div>

			<div  class="col-md-6" >
				  
			  	<select class="form-control" id="status" style="margin-top:-10px;">
			        <option value="LivInInd" selected>Living in India</option>
			        <option value="NonResInd">Non Resident Indian (NRI)</option>
					<option value="ForNat">Foreign National</option>
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
			<div class="col-md-4"><label for="residential-city" class="small-text pull-right">City</label></div>
			<div class="col-md-6" >
				  
				  <input class="form-control" id="residential-city" type="text" placeholder="Enter City" style="margin-top:-10px;">
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
			<button type="button" id="submit-button-1" class="btn btn-primary readmore submit-button-1" onClick="prepareKyc();">Continue</button>
		</div>
		<div class="col-md-5"></div>
	</div>
   </section>
      <footer id="footer" class="midnight-blue navbar navbar-fixed-bottom" >
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2013 <a target="_blank" href="http://shapebootstrap.net/" title="Free Twitter Bootstrap WordPress Themes and HTML templates">ShapeBootstrap</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Faq</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>



		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</body>
</html>