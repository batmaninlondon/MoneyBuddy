<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register Page</title>
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
	<div class="row">
		<div class="col-md-12 well-sm large-text login-row-1" >
			<p>SIGN UP</p>
		</div>
	</div>
	<br/><br/><br/>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="first-name">First&nbspName:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="firstName" id="first-name" type="text" placeholder="First Name" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="last-name">Last&nbspName:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="lastName" id="last-name" type="text" placeholder="Last Name" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="email-id">Email&nbspID:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="emailId" id="email-id" type="text" placeholder="Email ID" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="password">Password:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="password" id="password" type="password" placeholder="Password" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="confirm-password">Confirm&nbspPassword:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="confirmPassword" id="confirm-password" type="password" placeholder="Confirm Password" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="mobile-number">Contact&nbspNumber:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="mobileNumber" id="mobile-number" type="text" placeholder="Contact Number" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
	
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<div id="button-5" class="row">
				<button type="button" id="submit-button-5" class="btn btn-info btn-lg sharp raised" onClick="register();" style="margin-top:50px; width:200px;">SIGN UP</button>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="assets/js/JQuery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/javaScript.js"></script>	
</body>
</html>