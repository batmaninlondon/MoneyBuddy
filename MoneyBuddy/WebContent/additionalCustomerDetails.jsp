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
	<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script type="text/javascript"  src="assets/js/jquery.js"></script>
    <script type="text/javascript"  src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    <script type="text/javascript" src="assets/js/wow.min.js"></script>
    <%-- <script type="text/javascript" src="assets/js/jquery-ui.js"></script> --%>
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
			<h2 style="font-family:Aparajita;font-size:35px;"><b>Please provide additional details</b></h2>
		</div>
		<div class="col-md-3"></div>
	</div>
	
	<div>
	<s:form action="prepareKycFormAction" method="post" >
	
	<div class="row" >
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="father-name"  class="small-text pull-right">Father's Name</label></div>
			<div  class="col-md-6" >
				<s:fielderror fieldName="fatherName" class="g-color--red" />
			  	<s:textfield class="form-control" id="father-name" placeholder="Enter Father's Name" name="fatherName" style="margin-top:-10px;"/> 
				  
				  <!-- <input class="form-control" id="father-name" type="text" placeholder="Enter Father's Name" style="margin-top:-10px;"> -->
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
				<s:select class="form-control"  id="marital-status" style="margin-top:-10px;" 
					list="#{'Married':'Married', 'Single':'Single'}" 
					name="maritalStatus" 
					value="Married" />  
			  	<%-- <select class="form-control" id="marital-status" style="margin-top:-10px;">
			        <option value="Single">Single</option>
			        <option value="Married" selected>Married</option>
	
		      	</select> --%>
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
				<s:select class="form-control"  id="nationality" style="margin-top:-10px;" 
					list="#{'Indian':'Indian', 'Other':'Other'}" 
					name="nationality" 
					value="Indian" />
			  	<%-- <select class="form-control" id="nationality" style="margin-top:-10px;">
			        <option value="Indian" selected>Indian</option>
			        <option value="Other">Other</option>
	
		      	</select> --%>
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
				<s:select class="form-control"  id="status" style="margin-top:-10px;" 
					list="#{'LivInInd':'Living in India', 'NonResInd':'Non Resident Indian (NRI)', 'ForNat':'Foreign National'}" 
					name="status" 
					value="LivInInd" />	  
			  	<%-- <select class="form-control" id="status" style="margin-top:-10px;">
			        <option value="LivInInd" selected>Living in India</option>
			        <option value="NonResInd">Non Resident Indian (NRI)</option>
					<option value="ForNat">Foreign National</option>
		      	</select> --%>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>
		<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="gross-annual-income" class="small-text pull-right">Gross Annual Income</label>
	      	</div>

			<div  class="col-md-6" >
				<s:select class="form-control"  id="gross-annual-income" style="margin-top:-10px;" 
					list="#{'LesThaOneLak':'less than 1 lakh', 'OneToFivLak':'1 to 5 lakhs', 'FivToTenLak':'5 to 10 lakhs',
					'TenToTweFivLak':'10 to 25 lakhs','MorThaTweFivLak':'More Than 25 lakhs' }" 
					name="grossAnnualIncome" 
					value="LesThaOneLak" />	  
			  	<%-- <select class="form-control" id="gross-annual-income" style="margin-top:-10px;">
			        <option value="LesThaOneLak">less than 1 lakh</option>
			        <option value="OneToFivLak">1 to 5 lakhs</option>
			        <option value="FivToTenLak">5 to 10 lakhs</option>
			        <option value="TenToTweFivLak" selected>10 to 25 lakhs</option>
			        <option value="MorThaTweFivLak">More Than 25 lakhs</option>
	
		      	</select> --%>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>
		
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="politically-exposed" class="small-text pull-right">Politically Exposed Person</label>
	      	</div>

			<div  class="col-md-6" >
				<s:select class="form-control"  id="politically-exposed" style="margin-top:-10px;" 
					list="#{'No':'No', 'PoliticExposed':'Politically Exposed Person', 
					'RelToPoliticExposed':'Related to a Politically Exposed Person' }" 
					name="politicallyExposed" 
					value="No" />
			  	<%-- <select class="form-control" id="politically-exposed" style="margin-top:-10px;">
			        <option value="No" selected>No</option> 
			        <option value="PoliticExposed">Politically Exposed Person</option>
			        <option value="RelToPoliticExposed">Related to a Politically Exposed Person</option>
	
		      	</select> --%>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>
	<div class="row" style="margin-top:25px;">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<s:submit class="center btn btn-primary readmore submit-button-1" value="Continue" />
		</div>
		<div class="col-md-5"></div>
	</div>
	</s:form>
	</div>
<!-- 	<div id="button-1" class="row" style="margin-top:25px;">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<button type="button" id="submit-button-1" class="btn btn-primary readmore submit-button-1" onClick="prepareKyc();">Continue</button>
		</div>
		<div class="col-md-5"></div>
	</div> -->
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

		<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
</body>
</html>