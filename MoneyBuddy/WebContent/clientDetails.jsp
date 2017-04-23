<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>client Details Page</title>
<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="assets/stylesheet.css" />
</head>
<body>
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
	
	<div class="row" style="margin-top:10px;">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<label for="client-holding" class="small-text">Client Holding </label>
	      	<select class="form-control" id="client-holding" name="clientHolding">
		        <option value="SI" selected>Single</option>
		        <option value="JO">Joint</option>
	      	</select>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<label for="tax-status" class="small-text">Client Tax Status </label>
	      	<select class="form-control" id="tax-status" name="taxStatus">
		        <option value="01" selected>Individual</option>
		        <option value="04">Company</option>
	      	</select>
		</div>
		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<label for="occupation-name" class="small-text">Client Occupation </label>
	      	<select class="form-control" id="occupation-name" name="occupationName">
		        <option value="01">Business</option>
		        <option value="02" selected>Service</option>
		        <option value="03">Professional</option>
		        <option value="04">Agriculture</option>
		        <option value="05">Retired</option>
		        <option value="06">Housewife</option>
		        <option value="07">Student</option>
		        <option value="08">Other</option>
	      	</select>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<label for="gender-type" class="small-text">Client Gender </label>
	      	<select class="form-control" id="gender-type" name="genderType">
		        <option value="M" selected>Male</option>
		        <option value="F">Female</option>
	      	</select>
		</div>
		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<label for="date-of-birth" class="small-text"  >DOB - DD/MM/YYYY </label>    	
            <input class="form-control" value="01/01/1990" name="dateOfBirth" id="date-of-birth" type="text" placeholder="DOB in DD/MM/YYYY Format">
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<label for="residential-address" class="small-text" >Enter Residential Address </label>    	
            <input class="form-control" value="abcd" name="residentialAddress" id="residential-address" type="text" placeholder="Residential Address">
		</div>
		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<label for="account-type" class="small-text">Client Account Type </label>
	      	<select class="form-control" id="account-type" name="accountType">
		        <option value="SB" selected>Saving</option>
		        <option value="CB">Current</option>
	      	</select>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<label for="residential-city" class="small-text" >Enter City </label>    	
            <input class="form-control" value="abc" name="residentialCity" id="residential-city" type="text" placeholder="City">
		</div>
		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<label for="account-number" class="small-text" >Enter Account Number </label>    	
            <input class="form-control" value="1234567890" name="accountNumber" id="account-number" type="text" placeholder="Account Number">
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<label for="residential-state" class="small-text">Client State </label>
	      	<select class="form-control" id="residential-state" name="residentialState">
		        <option value="AN">Andaman & Nicobar</option>
		        <option value="AR">Arunachal Pradesh</option>
		        <option value="AP">Andhra Pradesh</option>
		        <option value="AS">Assam</option>
		        <option value="BH">Bihar</option>
		        <option value="CH">Chandigarh</option>
		        <option value="CG">Chhattisgarh</option>
		        <option value="GO">GOA</option>
		        <option value="GU" selected>Gujarat</option>
		        <option value="HA">Haryana</option>
		        <option value="HP">Himachal Pradesh</option>
		        <option value="JM">Jammu & Kashmir</option>
		        <option value="JK">Jharkhand</option>
		        <option value="KA">Karnataka</option>
		        <option value="KE">Kerala</option>
		        <option value="MP">Madhya Pradesh</option>
		        <option value="MA">Maharashtra</option>
		        <option value="MN">Manipur</option>
		        <option value="ME">Meghalaya</option>
		        <option value="MI">Mizoram</option>
		        <option value="NA">Nagaland</option>
		        <option value="ND">New Delhi</option>
		        <option value="OR">Orissa</option>
		        <option value="PO">Pondicherry</option>
		        <option value="PU">Punjab</option>
		        <option value="RA">Rajasthan</option>
		        <option value="SI">Sikkim</option>
		        <option value="TG">Telengana</option>
		        <option value="TN">Tamil Nadu</option>
		        <option value="TR">Tripura</option>
		        <option value="UP">Uttar Pradesh</option>
		        <option value="UC">Uttaranchal</option>
		        <option value="WB">West Bengal</option>
		        <option value="DN">Dadra and Nagar Haveli</option>
		        <option value="DD">Daman and Diu</option>
		        <option value="LD">Lakshadweep</option>
		        <option value="OH">Others</option>
	      	</select>
		</div>
		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<label for="neft-code" class="small-text" >Enter NEFT Code </label>    	
            <input class="form-control" value="ICIC0001656" name="neftCode" id="neft-code" type="text" placeholder="NEFT Code">
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<label for="residential-pin" class="small-text" >Enter Pin </label>    	
            <input class="form-control" value="111111" name="residentialPin" id="residential-pin" type="text" placeholder="Pin">
		</div>
		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<label for="group-name" class="small-text" >Group Name </label>    	
            <input class="form-control" name="groupName" id="group-name" type="text" placeholder="Group Name">
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<label for="residential-country" class="small-text">Client Country </label>
	      	<select class="form-control" id="residential-country" name="residentialCountry">
		        <option selected>India</option>
	      	</select>
		</div>
		<div class="col-md-5"></div>
	</div>
	
	<div id="button-3" class="row">
		<div class="col-md-2"></div>
		<div class="col-md-4">
			<button type="button" id="client-details-submit-button" class="btn btn-info btn-lg sharp raised" onClick="checkDetails();" style="margin-top:50px; width:200px;">SUBMIT</button>
		</div>
		<div class="col-md-6"></div>
	</div>
	
	<script type="text/javascript" src="assets/js/JQuery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/javaScript.js"></script>

</body>
</html>