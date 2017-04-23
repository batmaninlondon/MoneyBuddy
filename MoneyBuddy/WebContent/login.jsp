<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login Page</title>
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
			<p>SIGN IN TO YOUR ACCOUNT</p>
		</div>
	</div>
	<br/><br/><br/>
	
	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-10">
			<div class="input-group input-group-lg">
    			<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    			<input id="email-id" type="text" class="form-control" name="emailId" placeholder="Email" style="width:600px;">
	
  			</div>
		</div>
	</div>
	<div class="row">
	
		<div class="col-md-2"></div>
		<div class="col-md-10">
			<div class="input-group input-group-lg">
    			<span class="input-group-addon" ><i class="glyphicon glyphicon-lock"></i></span>
    			<input id="password" type="password" class="form-control" name="password" placeholder="Password" style="width:600px;">
  			</div>
		</div>
	</div>
	<div class="row">
	
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<div id="button-5" class="row">
				<button type="button" id="submit-button-5" class="btn btn-info btn-lg sharp raised" onClick="login();" style="margin-top:50px; width:200px;">SIGN IN</button>
			</div>
		</div>
	</div>
	<br/>
	<div class="row">
	
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<a href="forgottenPassword" id="forgot-password-submit-button" class="small-text" style="height:40px;width:300px;color:blue;">Forgot Password?</a>
		</div>

	</div>

	<script type="text/javascript" src="assets/js/JQuery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/javaScript.js"></script>	
</body>
</html>