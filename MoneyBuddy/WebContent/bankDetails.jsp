<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<!DOCTYPE html >
<html lang="en">
<head>
	<meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Investment Details Page | Money Buddy</title>
 	<link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    
    <!-- Web Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">

	<!-- Vendor Styles -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
    <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
    <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />

    <!-- Theme Styles -->
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
    <link href="css/material-kit.css" rel="stylesheet"/>

    <!-- Favicon -->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="img/apple-touch-icon.png">

	<link rel="shortcut icon" href="images/ico/favicon.ico">
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head>

<body style="background-color:#cecece" onload="setInitialUpfrontInvestment();">
   <div class="container ">
   		<a href="nhome.jsp" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
		</a>
	</div>
	<br/>
	<br/>
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark ">
	    	<div class="profile">
	    		<s:iterator value="#session.productList" var="productListElement">
	        	</s:iterator> 
	        	<div class="name g-color--white">
	                	<h3 class="title g-color--white">Payment Page</h3>
	                	<s:iterator value="#session.productList" var="productListElement">
							<div>
							    <h3 class="center g-color--white"><s:property value="#productListElement.key"/></h3>
							</div>
						</s:iterator>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<div class="row" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " style="height:500px">
	    	<div class="profile">
	        	<div class="name">
	        			<br/>
						<div class="row">
							<div id="investment-options" class="col-md-3 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Total Amount to Pay</h6>
							</div>
							<div id="investment-options" class="col-md-4 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Rs. <s:property value="#productListElement.value"/></h6>
							</div>
							<div id="investment-options" class="col-md-5 ">
							</div>
	  					</div>
	  					<div class="row">
							<div id="investment-options" class="col-md-3 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Select your Bank</h6>
							</div>
							<div id="investment-options" class="col-md-4 ">
								<select class="form-control" id="bank-name" name="bankName">
							        <option value="ICICI">ICICI Bank</option>
							        <option value="SBI">SBI Bank</option>
							        <option value="HDFC">HDFC Bank</option>
							        <option value="KOTAK">KOTAK Bank</option>
					      		</select>
							</div>
							<div id="investment-options" class="col-md-5 ">
							</div>
	  					</div>
	  					<div class="row">
							<div id="investment-options" class="col-md-3 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Account Type</h6>
							</div>
							<div id="investment-options" class="col-md-4 ">
								<select class="form-control" id="account-type" name="accountType">
							        <option value="CB">Current Account</option>
							        <option value="SB">Saving Account</option>
							        <option value="NE">NRI - Repatriable (NRE)</option>
							        <option value="NO">NRI - Repatriable (NRO)</option>
					      		</select>
							</div>
							<div id="investment-options" class="col-md-5 ">
							</div>
	  					</div>
	  					<div class="row">
							<div id="investment-options" class="col-md-3 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Account Number</h6>
							</div>
							<div id="investment-options" class="col-md-4 ">
								<input class="form-control" id="account-number" type="text" placeholder="Enter Account Number" style="margin-top:-10px;">
							</div>
							<div id="investment-options" class="col-md-5 ">
							</div>
	  					</div>
	  					<div class="row">
							<div id="investment-options" class="col-md-3 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Re-enter Account Number</h6>
							</div>
							<div id="investment-options" class="col-md-4 ">
								<input class="form-control" id="re-account-number" type="password" placeholder="Enter Account Number" style="margin-top:-10px;">
							</div>
							<div id="investment-options" class="col-md-5 ">
							</div>
	  					</div>
	  					<div class="row">
							<div id="investment-options" class="col-md-3 ">
								<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">IFSC Code </h6>
							</div>
							<div id="investment-options" class="col-md-4 ">
								<input class="form-control" id="account-number" type="text" placeholder="Enter Account Number" style="margin-top:-10px;">
							</div>
							<div id="investment-options" class="col-md-5 ">
							</div>
	  					</div>
	  					
	  					<div class="row">
							<div id="investment-options" class="col-md-6 ">
								<button type="button" id="submit-button-1" class="btn " onClick="populateBankDetails();"  style="background-color:black; margin-top: 20px; margin-bottom: 35px;">Pay Now</button>
							</div>
	  					</div>
					</div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1" style="height:500px"></div>
	</div>
	
	<%-- <section id="bankDetails">
	
	
	<div class="row" style="margin-top:-20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="bank-name" style="font-family:Aparajita;font-size:25px;" class="pull-right">Select your Bank </label></div>
			<div  class="col-md-6" >				  
				<select class="form-control" id="bank-name" name="bankName">
			        <option value="ICICI">ICICI Bank</option>
			        <option value="SBI">SBI Bank</option>
			        <option value="HDFC">HDFC Bank</option>
			        <option value="KOTAK">KOTAK Bank</option>
	      		</select>
			</div>
		</div>
		<div class="col-md-3">

		</div>

	</div>
	
	<div class="row" style="margin-top:-20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="account-type" style="font-family:Aparajita;font-size:25px;" class="pull-right">Account Type </label></div>
			<div  class="col-md-6" >				  
				<select class="form-control" id="account-type" name="accountType">
			        <option value="CB">Current Account</option>
			        <option value="SB">Saving Account</option>
			        <option value="NE">NRI - Repatriable (NRE)</option>
			        <option value="NO">NRI - Repatriable (NRO)</option>
	      		</select>
			</div>
		</div>
		<div class="col-md-3">

		</div>

	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="account-number" style="font-family:Aparajita;font-size:25px;" class="pull-right" >Account Number </label></div>
			<div  class="col-md-6" >
				  
				  <input class="form-control" id="account-number" type="text" placeholder="Enter Account Number" style="margin-top:-10px;">
			</div>
		</div>
		<div class="col-md-3">
		</div>
	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="re-account-number" style="font-family:Aparajita;font-size:25px;" class="pull-right" >Re-enter Account Number </label></div>
			<div class="col-md-6" >
				  
				  <input class="form-control" id="re-account-number" type="password" placeholder="Enter Account Number" style="margin-top:-10px;">
			</div>
		</div>
		<div class="col-md-3">
		</div>
	</div>

	<div class="row" style="margin-top:20px;">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-5"><label for="ifsc-code" style="font-family:Aparajita;font-size:25px;" class="pull-right" >IFSC Code </label></div>
			<div class="col-md-6" >
				  
				  <input class="form-control" id="ifsc-code" type="text" placeholder="Enter IFSC Code" style="margin-top:-10px;">
			</div>
		</div>
		<div class="col-md-3">
		</div>
	</div>
		<div  id="invested-fund-list" class="row" style="margin-top:20px;padding-left:70px;padding-right:70px;">
			<div class="col-md-2"></div>
			<div id = "investment-fund-list-data" class ="col-md-8">
			<table class="table table-bordered" >
				<thead class="table-head">
					<tr>
						<th class="center col-md-9">Fund Name</th>
						<!-- <th class="center">Percentage</th> -->
						<th class="center col-md-3">Amount</th>
					</tr>
				</thead>
				<tbody class="table-body" >

						<s:iterator value="#session.productList" var="productListElement">
							<tr>
							    <td class="center"><s:property value="#productListElement.key"/></td>
							    <td class="center"><s:property value="#productListElement.value"/></td>
							</tr>
						</s:iterator>
						<tr>
						    <td class="center" style="padding:0px;vertical-align: middle;"><b>Total : Rs. <s:property value="#session.totalInvestment"/></b></td>
						    <td class="center"><s:property value="#productListElement.value"/></td>
						    <td class="center" style="padding:0px;">
						    <button type="button" id="submit-button-1" class="btn btn-primary readmore submit-button-1" onClick="populateBankDetails();">Pay Now</button>
						    </td>
						</tr>


				</tbody>
   			</table>
   			</div>
			<div class="col-md-2"></div>
		</div>
   </section>
       --%>



		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</body>
</html>