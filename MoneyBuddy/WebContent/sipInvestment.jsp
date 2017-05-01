<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html >
<html lang="en">
<head>
<title>Investment Details Page</title>

<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="assets/stylesheet.css" />

<script>

</script>

</head>

<body background="images/backgroundImage5.jpg" onload="setInitialSipInvestment();">

	<% session.setAttribute("transactionType", "SIP"); %>
	<div id="wrap">
		<img class="bgfade" src="images/backgroundImage1.jpg" /> 
		<img class="bgfade" src="images/backgroundImage2.jpg" />
		<img class="bgfade" src="images/backgroundImage3.jpg" /> 
		<img class="bgfade" src="images/backgroundImage4.jpg" /> 
		<img class="bgfade" src="images/backgroundImage5.jpg" />
	</div>
	<div class="row row-first">
		<div class="col-md-12" id="header">
			<%  if(session.getAttribute("customerId") == null)
			 	{   %> 
			<%@ include file="headerLoggedOff.jsp"%>
			<%	} else 
			 	{	%>
			<%@ include file="headerLoggedIn.jsp"%>
			<%	}	%>
		
		</div>
	</div>

	<div class="row">
		<div  id="investment-options" class="col-md-6">

			<div class="row row-second">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="large-text" style="margin-top:80px;">CREATE YOUR PLAN</p>
				</div>
			</div>
			<div class="row row-third">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="medium-text">Do you have a goal in mind?</p>
				</div>
			</div>
			<%-- <div id="upfront-text" class="row row-fourth">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="small-text">How much do you want to invest upfront?</p>
				</div>
			</div>
			<div id="upfront-value" class="row row-input row-fifth">
				<div class="col-md-2"></div>
				<div class="form-group">
					<div class="col-md-6">
						<input id="range" type="range" min="5000" max="100000" step="1000"
							value="7000" onchange="showUpfrontInvestment(this.value)" />

					</div>
					<div class="col-md-2"></div>
					<div class="underline small-text col-md-2">
						 <span id="upfrontInvestment"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.
					</div>
				</div>
			</div> --%>
			
			<span id="upfrontInvestment" class="hidden">0</span>
			<%-- <span id="years" class="hidden">5</span> --%>
			
			<div id="sip-text" class="row row-sixth">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="small-text">How much do you want to invest monthly?</p>
				</div>
			</div>
			<div id="sip-value" class="row row-input row-seventh">
				<div class="col-md-2"></div>
				<div class="form-group">
					<div class="col-md-6">
						<input type="range" min="0" max="100" step="10" value="0"
							onchange="showSipPerMonth(this.value)" />
					</div>
					<div class="col-md-2"></div>
					<div class="underline small-text col-md-2">
						 <span id="sipPerMonth">0</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.
					</div>
				</div>
			</div>
			<div id="duration-text" class="row row-eigth">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="small-text">How long do you expect to invest for?</p>
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
						<span id="years">5</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Years 
					</div>
				</div>
			</div>
			<div class="row row-tenth">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<p class="small-text">What's your investment style?</p>
				</div>
			</div>
			<div class="row row-input row-eleventh">
				<div class="col-md-2"></div>
				<div class="form-group">
					<input type="radio" id="risk-category-1" name="riskCategory" value="1"> Cautious 
					<input type="radio" id="risk-category-2" name="riskCategory" value="2"> Tentative 
					<input type="radio" id="risk-category-3" name="riskCategory" value="3" checked> Confident 
					<input type="radio" id="risk-category-4" name="riskCategory" value="4"> Ambitious 
					<input type="radio" id="risk-category-5" name="riskCategory" value="5"> Adventurous
				</div>
			</div>
			<span id="plan-name"><%=request.getParameter("planName")%></span>

		</div>
		<div  id="invested-fund-list" class="col-md-6 hidden" style="margin-top:50px;padding-left:70px;padding-right:70px;">
			<div id="investment-fund-list-data" class ="row col-md-12">
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
			
			<!-- <div id="button-4" class="row">
				<button type="button" id="submit-button-4" class="btn btn-info btn-lg sharp raised" onClick="payment();" style="margin-top:50px;margin-left:200px;width:200px;">SUBMIT</button>
			</div> --> 
			<br/><br/>
			<s:submit style="color:blue;"/>
			</s:form>
			
<%-- 			<s:form action="payment">

					<select name="bankName" id="bankName">
					    <option value="-1">Select Your Bank</option>
					    <option value="ICICI">ICICI</option>
					    <option value="HDFC">HDFC</option>
					    <option value="SBI">SBI</option>
					    <option value="KOTAK">KOTAK</option>
					</select>
                	<s:textfield key="accountNumber" label ="Account Number" size="90" width="1000"/>
                	<s:password label="Password" key="accountPassword" size="90" width="1000"/>
                	<s:textfield label="CVV number" key="cvvNumber" size="90" width="1000"/>
                	<s:textfield label="Group Name" key="groupName" size="90" width="1000"/>
                	
                	
                	<br/><br/><br/>

                <s:submit/>
             </s:form> --%>
		</div>
		
		<div class="diamond-img col-md-6">
<!-- 			<div class=""> -->
				<img src="images/pattern.jpg" id="pattern-image">
				<div class="row">
					<div id="diamond-shape" class="col-md-12">
						<p id="diamond-text-1" class="diamond-text-1 " >Use the slider
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
		<button type="button" id="submit-button-1" class="btn btn-info btn-lg submit-button-1 sharp raised hidden" onClick="showPlan();">SEE YOUR PLAN</button>
	</div>

		<script type="text/javascript" src="assets/js/JQuery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</body>
</html>
