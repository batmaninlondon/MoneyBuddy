<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.Properties" %>
<%@ page language="java" import="java.io.FileInputStream" %>
<%@ page language="java" import="java.io.File" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >

<html lang="en">
<head>



        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta http-equiv="Cache-control" content="max-age=2592000, public">
        <title>MoneyBuddy - Login</title>
		
        <!-- Web Fonts -->
        <!-- <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet"> -->
		<!-- <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" > -->

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>

	      <script src="https://www.google.com/recaptcha/api.js?onload=myCallBack&render=explicit" async defer></script>
    <script>
    
    <%
    
    ServletContext sc=request.getServletContext();
    String path=sc.getRealPath("/properties/jspConfig.properties");
    FileInputStream fis = new FileInputStream(new File(path));
    
    Properties configProperties = new Properties();

	configProperties.load(fis);
	
	String siteKey = configProperties.getProperty("RECAPTHA_SITE_KEY");
	
	System.out.println("siteKey is : "+siteKey);
    
    %>
    
      var recaptchaRegister;
      var recaptchaForgotPswd;
      var recaptchaLogin;
      
      var myCallBack = function() {

        //Render the recaptchaRegister on the element with ID "recaptcha-register"
        recaptchaRegister = grecaptcha.render('recaptcha-register', {
          'sitekey' : '<%=siteKey%>',
          'size' : 'invisible',
          'callback' : submitRegister
        });
        
        //Render the recaptchaForgotPswd on the element with ID "recaptcha-forgot-pswd"
        recaptchaForgotPswd = grecaptcha.render('recaptcha-forgot-pswd', {
        	'sitekey' : '<%=siteKey%>',
            'size' : 'invisible',
            'callback' : submitForgotPassword
        });
        
      //Render the recaptchaLogin on the element with ID "recaptcha-login"
        recaptchaLogin = grecaptcha.render('recaptcha-login', {
            'sitekey' : '<%=siteKey%>',
            'size' : 'invisible',
            'callback' : submitLogin
          });
      };
     
    </script>

  <title>Login/SignUp</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/style4.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script> --%>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  
 
</head>
<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;" >
	<!-- <div id="load" class="load"></div> -->
	<div id="content">
	
	<div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="MoneyBuddy Logo">
		</a>
	</div>
	

	<!--========== PROMO BLOCK ==========-->
		<div class="g-fullheight--xs g-bg-position--center swiper-slide " >
		
		<div class="row" >
				<div class="col-md-3"></div>
				<div class="col-md-5 g-color--white text-center g-font-size-24--xs g-font-family--playfair g-margin-l-60--md">
					
						<s:iterator value="actionMessages">
            				<span class="actionMessage">
                				<s:property />
            				</span>
        				</s:iterator>
       				
				</div>
				<div class="col-md-4"></div>
			</div>  
			
			
			
        	<div class="form  ">
   	
  <ul class="nav nav-tabs card-header-pills">
    <li class="nav-item active">
      <a class="nav-link  active g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" href="#loginTabContent">Log In</a>
    </li>
    <li class="nav-item">
      <a class="nav-link g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" href="#signup">Sign Up</a>
    </li>      
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="loginTabContent" class="container tab-pane active"><br>
                <s:form  action="newLoginAction" method="post" name="formLogin" namespace="/" autocomplete="off"  >
                <%
	
				    if ("TRUE".equals(request.getParameter("OnetimeInvestment"))) {
		    	%>
		    		<s:hidden  name="transactionType" value="UPFRONT"></s:hidden>
				    	<%
				    } else if ("FALSE".equals(request.getParameter("OnetimeInvestment"))) {
				    	%>
				    	<s:hidden  name="transactionType" value="SIP"></s:hidden>
				    	<%
				    }
				%>
          <h1 class="g-font-size-15--xs g-font-size-30--lg g-margin-t-o-10--xs g-margin-t-o-0--lg ">Welcome Back!</h1>
          <p id="loginMessage"></p>
         <!--  <div> -->
          
          <div class="field-wrap   g-margin-t-o-10--xs g-margin-t-o-0--lg">
            <s:fielderror fieldName="emailIdLogin" class="g-color--red" />
            <%
            String userNa = (String) request.getSession().getAttribute("name");
            System.out.println(" userNa: "+userNa);
            
			if (userNa != null){
				pageContext.setAttribute("userName", userNa);
				
			%>
			<s:set var="uName" ><%=userNa %></s:set>
  			<s:textfield class="form-control" name="emailIdLogin" placeholder="Email Address" 
  					 value="%{#uName}" />
            
            <%
			}
			else 
			{
            %>
            <s:textfield class="form-control" name="emailIdLogin" placeholder="Email Address" />
            <%
            }
            %>
          </div>
          
          <div class="field-wrap g-margin-t-o-10--xs g-margin-t-o-0--lg">
            <s:fielderror fieldName="passwordLogin" class="g-color--red" />
  			<s:password class="form-control" name="passwordLogin" placeholder="Password" />
          </div>
          
          <p class="forgot"><button type="button" class=" g-bg-color--primary g-color--white g-font-size-10--xs g-font-size-15--lg"  data-toggle="modal" data-target="#myModal">Forgot Password?</button></p>
          <div class="container">

  <!-- Modal -->
  
  </div>
  
  	<s:hidden id="google-response-login" name="googleResponseLogin"></s:hidden>
          <div>
          	
        	<s:submit id="recaptcha-login" class="g-recaptcha button button-block g-font-size-20--xs g-font-size-30--lg" value="Sign In"  />
           </div>
          </s:form>
    </div>
    <div id="signup" class="container tab-pane fade"><br>
               <s:form  action="register" method="post" name="formRegister" namespace="/" >
          <div id="registration-email-id"  class="field-wrap  g-margin-t-o-10--xs g-margin-t-o-0--lg">
          	<p id="registerMessage"></p>
           	<s:fielderror fieldName="emailIdRegister" class="g-color--red" />
  			<s:textfield class="form-control"  name="emailIdRegister"  autocomplete="false" placeholder="Email Address"/>
          </div>
          
          <div id="registration-mobile-number" class="field-wrap  g-margin-t-o-10--xs g-margin-t-o-0--lg">
            <s:fielderror fieldName="mobileNumberRegister" class="g-color--red" />
  			<s:textfield class="form-control"  name="mobileNumberRegister" autocomplete="off" placeholder="Mobile Number"/>
          </div>
           <div id="registration-password" class="field-wrap  g-margin-t-o-10--xs g-margin-t-o-0--lg">
            <s:fielderror fieldName="passwordRegister" class="g-color--red" />
  			<s:password class="form-control"  name="passwordRegister" autocomplete="off" placeholder="Create Password"/>
          </div>
          <s:hidden id="google-response-register" name="googleResponseRegister"></s:hidden>
          
          <s:submit id="recaptcha-register" class="g-recaptcha button button-block  g-font-size-20--xs g-font-size-30--lg" value="Create Account"  />
          
			<br/><p class="text-center"><span class=" g-font-size-12--xs g-font-size-15--lg  g-color--white-opacity-light">By continuing you agree to our <a class=" g-color--primary" href="terms">Terms &amp; Conditions</a> & <a class="g-font-size-12--xs g-font-size-15--lg g-color--primary" href="privacyPolicy">Privacy Policy</a></span></p>
			<p class=" g-font-size-10--xs g-font-size-12--lg g-margin-t-o-10--xs g-color--white-opacity-light text-center"> <i class="  glyphicon glyphicon-lock"></i> &nbsp;Secure and SEBI registered </p>
          	               
          </s:form>
    </div>
    
              <div class="modal fade" id="myModal" >
    <div class="modal-dialog ">
      <div class="modal-content">
        <div class="modal-header">
          
          
          <h4 class="modal-title g-font-size-15--xs g-font-size-20--lg">Reset Password</h4>
          <p id="forgotPwdMessage"></p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
          <p class="g-color--black g-font-size-10--xs g-font-size-15--lg "  style="color: #000000">Enter the email address associated with your account, and we&#39;ll email you a link to reset your password.</p>
       
        <s:form  action="forgotPassword" method="post" name="formForgotPassword">

			<div class="row" >
				<div class="col-md-3"></div>
				<div class="col-md-5 ">
						<s:actionmessage class="small-text"/> 
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row input-group form-group ">
				<div class="col-md-1"></div>
    			<div class="col-md-10">
	    			<s:fielderror fieldName="emailIdForgotPassword" class="g-color--red" />
		  			<s:textfield class="form-control" placeholder="Email Id" name="emailIdForgotPassword" /> 
		  			<s:hidden id="google-response-forgot-pswd" name="googleResponseFrgtPswd"></s:hidden>
	  			</div>
	  			<div class="col-md-1">
	  			</div>	
  			</div>
	
			
        	<div class="row ">
				<div style="width:5%"></div>
				<div class="  g-color--primary" style="width:40%">
					<a class="g-font-size-11--xs g-font-size-14--lg " href="login">Back to Login</a>
				</div>
				<div style="width:5%"></div>
				<div class="" style="width:45%">
					<s:submit id="recaptcha-forgot-pswd" class="g-recaptcha  g-font-size-11--xs g-font-size-14--lg button button-block" value="Send Reset Link"  />
					
				</div>
				<div style="width:5%"></div>
			</div>
			
			</s:form>
		
		 </div>
		 
        </div>
      </div>
    </div>
    
  </div>
  </div>
  </div>
</div>



		<script type="text/javascript" src="assets/js/javaScript.js"></script>
    	<script src="assets/js/jquery.js"></script>
   	 	<script src="assets/js/main.js"></script>
    	<%-- <script src="assets/js/wow.min.js"></script> --%>


        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
       
        <script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
         
         
         <%-- <script>
         document.onreadystatechange = function () {
			  var state = document.readyState
			  if (state == 'interactive') {
			       document.getElementById('contents').style.visibility="hidden";
			  } else if (state == 'complete') {
			      setTimeout(function(){
			         document.getElementById('interactive');
			         document.getElementById('load').style.visibility="hidden";
			         document.getElementById('contents').style.visibility="visible";
			      },1000);
			  }
			}
         
         </script> --%>
         
</body>
</html>
