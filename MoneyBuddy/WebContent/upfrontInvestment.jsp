<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
 	<link rel="stylesheet" href="assets/MoneyBuddyStyles.css" />
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

<body class="homepage" onload="setInitialUpfrontInvestment();">
   <header id="header">
        <div class="top-bar">
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
            </div><!--/.container-->
        </div><!--/.top-bar-->

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="myIndex">Home</a></li>
                        <li><a href="whyInvest">Why Invest</a></li>
                        <li><a href="aboutUs">About Us</a></li>
                        <li class="active"><a href="saveTax">Save Tax</a></li>
                        <li ><a href="blog">Blog</a></li> 
                        <li><a href="help">Help</a></li> 
                       
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li><a href="login" >Sign in</a></li>
										<li><a href="register" >Sign up</a></li> 
							<%	} else 
							 	{	%>
							 			 <li><a href="bseDashboard" >Dashboard</a></li> 
							 			 <li><a href="logOff" >Log Out</a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
	<% session.setAttribute("transactionType", "UPFRONT"); %>
	<section class="bg-primary" id="one">
	<div class="row">
		<div  id="investment-options" class="col-md-6">
			<div class="row row-second">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<h2><a>Create Your Plan</a></h2>
				</div>
			</div>
			<div class="row row-third">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="top-number">Do you have a goal in mind?</p>
				</div>
			</div>
			<div id="upfront-text" class="row row-fourth">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="top-number">How much do you want to invest upfront?</p>
				</div>
			</div>
			<div id="upfront-value" class="row row-input row-fifth">
				<div class="col-md-2"></div>
				<div>
					<div class="col-md-6">
						<input id="range" type="range" min="0" max="100" step="10"
							value="0" onchange="showUpfrontInvestment(this.value)" />

					</div>
					<div class="col-md-2"></div>
					<div class="underline small-text col-md-2">
						<p class="top-number"> <span id="upfrontInvestment">0</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.</p>
					</div>
				</div>
			</div>
			 <span id="sipPerMonth" class="hidden">0</span>
			<div id="duration-text" class="row row-eigth">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="top-number">How long do you expect to invest for?</p>
				</div>
			</div>
			<div id="duration-value" class="row row-input row-ninth">
				<div class="col-md-2"></div>
				<div class="form-group">
					<div class="col-md-6">
						<input type="range" min="1" max="50" step="1" value="5"
							onchange="showYears(this.value)" />
					</div>
					<div class="col-md-2"></div>
					<div class="underline small-text col-md-2">
						<p class="top-number"><span id="years">5</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Years </p>
					</div>
				</div>
			</div>
			<div class="row row-tenth">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="top-number">What's your investment style?</p>
				</div>
			</div>
			<div class="row row-input row-eleventh">
				<div class="col-md-2"></div>
				<div class="form-group">
				<p class="top-number">
					<input type="radio" id="risk-category-1" name="riskCategory" value="1"> Cautious 
					<input type="radio" id="risk-category-2" name="riskCategory" value="2"> Tentative 
					<input type="radio" id="risk-category-3" name="riskCategory" value="3" checked> Confident 
					<input type="radio" id="risk-category-4" name="riskCategory" value="4"> Ambitious 
					<input type="radio" id="risk-category-5" name="riskCategory" value="5"> Adventurous
					</p>
						<p id="diamond-text-1" class="top-number" >Use the slider
							and select an investment style to calculate how much your
							investment could make.</p>
				</div>
			</div>
			<%-- <span id="plan-name"><%=request.getParameter("planName")%></span> --%>

	<div class="row row-second">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<h2><a>Create Your Plan</a></h2>
				</div>
			</div>

		</div>
		<div  id="invested-fund-list" class="col-md-6 hidden" style="margin-top:50px;padding-left:70px;padding-right:70px;">
			<div id = "investment-fund-list-data" class ="row col-md-12">
			<table class="table table-striped table-bordered" >
				<thead class="table-head">
					<tr>
						<th>Fund Name</th>
						<th>Percentage</th>
					</tr>
				</thead>
				<tbody>

					<s:iterator value="#session.productList" var="productListElement">
						<tr class="warning">
						    <td><s:property value="#productListElement.key"/></td>
						    <td><s:property value="#productListElement.value"/></td>
						</tr>
					</s:iterator> 

				</tbody>
   			</table>
   			</div>
			<div class ="row col-md-12">
			<div id="button-2" class="row">
			
				<%  if(session.getAttribute("customerId") == null)
				 	{   %> 
				<input type="hidden" id="cusId" value="customerIdNull"/>
				<%	} else 
				 	{	%>
				<input type="hidden" id="cusId" value="customerExists"/>
				<%	}	%>
			
			 
				<button type="button" id="submit-button-2" class="btn btn-info btn-lg sharp raised" onClick="showPanCardVerification();" style="width:200px;">SUBMIT</button>
			</div>
			</div>
			
		</div>
		
		<div  id="login-page" class="col-md-6 hidden" style="margin-top:250px;padding-left:70px;padding-right:70px;">
		
               		<%-- <s:textfield label="Email address" key="emailId" size="90" width="1000" id="email-id"/> --%>
	                <label for="email-id" class="small-text" >Enter Email Id </label>    	
	            	<input class="form-control" name="emailId" id="email-id" type="text" placeholder="Email Id">
	            
	            	<label for="password" class="small-text" >Enter Password </label>
	            	<input class="form-control" name="password" id="password" type="password" placeholder="Password">
	            
	            	<div id="button-5" class="row">
	            	<div class="col-md-1"></div>
	            		<div class="col-md-4">
							<button type="button" id="submit-button-5" class="btn btn-info btn-lg sharp raised" onClick="newLogin();" style="margin-top:50px; width:200px;">Sign in</button>
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-4">
							<button type="button" id="submit-button-5" class="btn btn-info btn-lg sharp raised" onClick="signUp();" style="margin-top:50px; width:200px;">Sign up</button>
						</div>
						<div class="col-md-1"></div>
					</div>

        		
				<br/><br/><br/>
				<a href="forgottenPassword" id="forgot-password-submit-button" class="small-text" style="height:40px;width:300px;color:blue;">Forgot Password?</a>
                
		
		</div> 
		
		<div  id="pancard-verification" class="col-md-6 hidden" style="margin-top:250px;padding-left:70px;padding-right:70px;">

			  <label for="pancard-number" class="medium-text" >Enter your Pan Card Number </label>
			  <input class="form-control" id="pancard-number" type="text" placeholder="Enter PanCard Number">

			<div id="button-3" class="row">
				<button type="button" id="submit-button-3" class="btn btn-info btn-lg sharp raised" onClick="checkKysStatus();" style="margin-top:50px; width:200px;">SUBMIT</button>
			</div>
			
		</div>
		
		<div  id="payment-page" class="col-md-6 hidden" style="margin-top:150px;padding-left:70px;padding-right:70px;">	
						
			<s:form action="payment">
			
			<label for="bank-name" class="small-text">Select Your Bank </label>
			      <select class="form-control" id="bank-name" name="bankName">
			        <option>ICICI</option>
			        <option>HDFC</option>
			        <option>SBI</option>
			        <option>KOTAK</option>
			      </select>
			
            
            <label for="account-number" class="small-text" >Enter Account Number </label>    	
            <input class="form-control" name="accountNumber" id="account-number" type="text" placeholder="Account Number">
            
            <label for="password" class="small-text" >Enter Password </label>
            <input class="form-control" name="accountPassword" id="password" type="password" placeholder="Password">
            
            <label for="cvv-number" class="small-text" >Enter CVV </label>
            <input class="form-control" name="cvvNumber" id="cvv-number" type="text" placeholder="CVV">
            
            <label for="group-name" class="small-text" >Enter Group Name </label>
            <input class="form-control" name="groupName" id="group-name" type="text" placeholder="Group Name">
			
			<br/><br/>
			<s:submit style="color:blue;"/>
			</s:form>
			

		</div>
		
		<div class="diamond-img col-md-6">
				<div class="row">
					<div id="diamond-shape" class="col-md-12">
					


						<p id="diamond-text-2" class="diamond-text-2 hidden">
							Invest Rs. <span id="totalInvestment"></span>
						</p>
						<p id="diamond-text-3" class="diamond-text-3 hidden">PREDICTED VALUE</p>
						<p id="diamond-text-4" class="diamond-text-4 hidden">
							Rs. <span id="predicted-value"><s:property value="#session.predictedValue" /></span>
						</p>
						<p id="diamond-text-5" class="diamond-text-5 hidden">
							after <span id="numberOfYears"></span> Years
						</p>
						<p id="diamond-text-6" class="diamond-text-6 hidden">Risk of
							underperformance</p>
						
						<p id="diamond-text-7" class="diamond-text-3 hidden">PREDICTED VALUE</p><br/>	
						<p id="diamond-text-8" class="diamond-text-8 hidden">AFTER 1 YEAR : Rs. <span id="predicted-value-list-1"><s:property value="#session.predictedValueList1" /></span>
						</p>

						<p id="diamond-text-9" class="diamond-text-9 hidden">AFTER 3 YEARS : Rs. <span id="predicted-value-list-2"><s:property value="#session.predictedValueList3" /></span>
						</p>

						<p id="diamond-text-10" class="diamond-text-10 hidden">AFTER 5 YEARS : Rs. <span id="predicted-value-list-3"><s:property value="#session.predictedValueList5" /></span>
						</p> 
						
					</div>
					 
				</div>
				
<!-- 			</div> -->
		</div>
		
	</div>
	<div id="button-1" class="row">
		<div class="col-md-8"></div>
		<div class="col-md-4">
			<div class="row">
				<!-- <div class="col-md-1"></div>
				<div class="col-md-11"> -->
					<button type="button" id="submit-button-1" class="btn btn-info btn-lg submit-button-1 sharp raised hidden" onClick="showPlan();">SEE YOUR PLAN</button>
				<!-- </div> -->
			</div>
		</div>
	</div>
   </section>
      <footer id="footer" class="midnight-blue">
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
