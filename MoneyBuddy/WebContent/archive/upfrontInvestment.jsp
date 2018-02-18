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

        <nav class="navbar navbar-inverse" role="banner" >
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
	<% session.setAttribute("transactionType", "UPFRONT"); %>
	<section id="one">
	<div class="row">
		<div  id="investment-options" class="col-md-6">
			
			
<!-- 			<div class="row row-third">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p>Do you have a goal in mind?</p>
				</div>
			</div> -->
			<div id="upfront-text" class="row row-fourth" style="margin-top:40px;margin-bottom:35px;">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p style="font-size:18px;">How much do you want to invest now?</p>
				</div>
			</div>
			<div id="upfront-value" class="row row-input row-fifth">
				<div class="col-md-2"></div>
				<div>
					<div class="col-md-6">
						<input id="range" type="range" min="2000" max="1000000" step="500"
							value="4000" onchange="showNewUpfrontInvestment(this.value)" />

					</div>
					<div class="col-md-2"></div>
					<div class="underline small-text col-md-2"  style="padding:1px;margin-left:20px;margin-top:-10px;">
						<p>Rs. <span id="upfrontInvestment">4000</span></p>
						<!-- <input type="number" min="2000" max="1000000" step="500" value="4000"></input> -->
					</div>
				</div>
			</div>
			
			<div class="row row-second" style="margin-top:30px;">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<h3 >** Use Slider or Enter the Amount</h3>
				</div>
			</div>
			<div class="row row-third">
			
			</div>
			
<%-- 			 <span id="sipPerMonth" class="hidden">0</span>
			<div id="duration-text" class="row row-eigth">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p>How long do you expect to invest for?</p>
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
						<p><span id="years">5</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Years </p>
					</div>
				</div>
			</div>
			<div class="row row-tenth">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p>What's your investment style?</p>
				</div>
			</div> --%>
<!-- 			<div class="row row-input row-eleventh">
				<div class="col-md-2"></div>
				<div class="form-group">
				<p>
					<input type="radio" id="risk-category-1" name="riskCategory" value="1"> Cautious 
					<input type="radio" id="risk-category-2" name="riskCategory" value="2"> Tentative 
					<input type="radio" id="risk-category-3" name="riskCategory" value="3" checked> Confident 
					<input type="radio" id="risk-category-4" name="riskCategory" value="4"> Ambitious 
					<input type="radio" id="risk-category-5" name="riskCategory" value="5"> Adventurous
					</p>
				</div>
			</div> -->
			<%-- <span id="plan-name"><%=request.getParameter("planName")%></span> --%>

<!-- 	<div class="row row-second">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p><b>Use the slider
							and select an investment style to calculate how much your
							investment could make.</p>
				</div>
			</div> -->

		</div>
		<div  id="invested-fund-list" class="col-md-6" style="margin-top:10px;padding-left:70px;padding-right:70px;">
			<div id = "investment-fund-list-data" class ="row col-md-12">
			<table class="table table-bordered" >
				<thead class="table-head">
					<tr>
						<th class="center col-md-10">Fund Name</th>
						<!-- <th class="center">Percentage</th> -->
						<th class="center col-md-2">Amount</th>
					</tr>
				</thead>
				<tbody class="table-body" >

					<%-- <s:iterator value="#session.productList" var="productListElement"> --%>
						<tr>
						    <td class="center">Reliance</td>
						    <%-- <td class="center"><s:property value="#productListElement.value"/></td> --%>
						    <td class="center">
						    <p>Rs. <span id="">100</span></p>
						    </td>
						</tr>
						<tr>
						    <td class="center">Kotak</td>
						    <%-- <td class="center"><s:property value="#productListElement.value"/></td> --%>
						    <td class="center">
						    <p>Rs. <span id="">200</span></p>
						    </td>
						</tr>
						<tr>
						    <td class="center">HDFC</td>
						    <%-- <td class="center"><s:property value="#productListElement.value"/></td> --%>
						    <td class="center">
						    <p>Rs. <span id="">150</span></p>
						    </td>
						</tr>
					<%-- </s:iterator>  --%>

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
			
			
			 
				<!-- <button type="button" id="submit-button-2" class="btn btn-info btn-lg sharp raised" onClick="showPanCardVerification();" style="width:200px;">SUBMIT</button> -->
			</div>
			</div>
			
		</div>
	
	
			<div  id="predicted-values-list" class="col-md-12" style="margin-top:20px;padding-left:130px;padding-right:70px;">
			<div id = "predicted-values-list-data" class ="row col-md-12">
			
			<table class="table table-bordered" style="width:1200px;">
			  <!-- <col>
			  <colgroup span="2"></colgroup>
			  <colgroup span="2"></colgroup> -->
			  <thead class="table-head">
				<tr >
				    <th rowspan="2"  class="center col-md-3" style="vertical-align: middle;padding: 0px;">Invested Amount</th>
				    <th colspan="3" rowspan="1"  class="center col-md-9" style="padding: 1px;">Predicted Future Value</th>
			    </tr>
			    <tr>
				    <th colspan="1" rowspan="1"  class="center" style="font-size:17px;padding: 0px;"><p>After 1 year</p></th>
				    <th colspan="1" rowspan="1"  class="center" style="font-size:17px;padding: 0px;"><p>After 3 year</p></th>
				    <th colspan="1" rowspan="1"  class="center" style="font-size:17px;padding: 0px;"><p>After 5 year</p></th>
				  </tr>
			  </thead>
			  <tbody>
			  	<tr>
			  		<td class="center">
				    	<p>Rs. <span id="investedAmount">2000</span></p>
				    </td>
				    <td class="center">
				    	<p>Rs. <span id="predicted-value-for-one-year"><s:property value="#session.predictedValueForOneYear" /></span></p>
				    </td>
				    <td class="center">
				    	<p>Rs. <span id="predicted-value-for-three-year"><s:property value="#session.predictedValueForThreeYear" /></span></p>
				    </td>
				    <td class="center">
				    	<p>Rs. <span id="predicted-value-for-five-year"><s:property value="#session.predictedValueForFiveYear" /></span></p>
				    </td>
			  	</tr>
			  </tbody>
		  	</table>
<%-- 			<table class="table table-bordered" style="width:1200px;" >
				<thead class="table-head">
					<tr>
						<th class="center col-md-4">Invested Amount</th>
						<th class="col-md-8">
							<table>
								<tr>
									<td class="center"><p>Predicted Future Value</p></td>
								</tr>
								<tr>
									<td class="center"><p>After 1 year</p></td>
									<td class="center"><p>After 3 year</p></td>
									<td class="center"><p>After 5 year</p></td>
								</tr>
							</table>
						</th>
						<!-- <th class="center">After 1 year</th>
						<th class="center">After 3 year</th>
						<th class="center">After 5 year</th> -->
					</tr>
				</thead>
				<tbody class="table-body" >

						<tr>
						    <td class="center">
						    	<p> <span id="">2000</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.</p>
						    </td>
						    <td class="center">
						    	<p> <span id="">2500</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.</p>
						    </td>
						    <td class="center">
						    	<p> <span id="">3000</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.</p>
						    </td>
						    <td class="center">
						    	<p> <span id="">3500</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.</p>
						    </td>
						</tr>

				</tbody>
   			</table> --%>
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
			
			
			 
				<!-- <button type="button" id="submit-button-2" class="btn btn-info btn-lg sharp raised" onClick="showPanCardVerification();" style="width:200px;">SUBMIT</button> -->
			</div>
			</div>
			
		</div>
		
		<div class="row">
			<div class="col-md-5"></div>
			<div class="col-md-2">
				<button type="button" id="submit-button-2" class="btn btn-info btn-lg sharp raised" onClick="showPanCardVerification();" style="width:200px;">Continue</button>
						    
			</div>
			<div class="col-md-5"></div>
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
		
		
		<div class="diamond-img col-md-6 hidden">

				<img src="images/pattern.jpg" id="pattern-image">
				<div class="row">
					<div id="diamond-shape" class="col-md-12">
					

						<p id="diamond-text-1" class="diamond-text-1" >Use the slider
							and select an investment style to calculate how much your
							investment could make.</p>

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
					<button type="button" id="submit-button-1" class="btn btn-info btn-lg submit-button-1 sharp raised hidden" onClick="showUpfrontInvestmentPlan();">SEE YOUR PLAN</button>
				<!-- </div> -->
			</div>
		</div>
	</div>
   </section>
      <footer id="footer" class="midnight-blue navbar navbar-fixed-bottom">
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



		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</body>
</html>