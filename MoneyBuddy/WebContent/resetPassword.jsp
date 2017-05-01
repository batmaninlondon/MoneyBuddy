<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Reset Password Page</title>
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
			<p>Reset Password</p>
		</div>
	</div>
	<br/><br/><br/>
	
	
<%
    //URL url = new URL(request.getRequestURL());
    //if (request.getAttribute("hash")!=null) {
    String hashedPassword = (String)session.getAttribute("hashedPassword");
    System.out.println("value of hashedPassword : "+hashedPassword);

    String emailId = (String)session.getAttribute("emailId");
    System.out.println("value of hash emailId: "+emailId);

%>

	<input type="hidden" id="email-id" name="emailId" value="<%=emailId%>">
	<input type="hidden" id="hashed-password" name="hashedPassword" value="<%=hashedPassword%>">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-10">
			<div class="input-group input-group-lg">
    			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    			<input id="new-password" type="password" class="form-control" name="newPassword" placeholder="Password" style="width:600px;">
	
  			</div>
		</div>
	</div>
	<div class="row">
	
		<div class="col-md-2"></div>
		<div class="col-md-10">
			<div class="input-group input-group-lg">
    			<span class="input-group-addon" ><i class="glyphicon glyphicon-lock"></i></span>
    			<input id="confirm-password" type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" style="width:600px;">
  			</div>
		</div>
	</div>
	<div class="row">
	
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<div id="button-5" class="row">
				<button type="button" id="submit-button-5" class="btn btn-info btn-lg sharp raised" onClick="resetPassword();" style="margin-top:50px; width:200px;">RESET PASSWORD</button>
			</div>
		</div>
	</div>
        
	<br/>

	<script type="text/javascript" src="assets/js/jquery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/javaScript.js"></script>	
</body>
</html>