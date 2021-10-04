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
	
	String signInKey = configProperties.getProperty("GOOGLE_SIGN_IN_KEY");
	
	System.out.println("signInKey is : "+signInKey);
    
    %>
    
      var recaptchaRegister;
      var recaptchaForgotPswd;
      var recaptchaLogin;
      var recaptchaGoogleLogin;
      var recaptchaGoogleRegister;
      
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
      
        //Render the recaptchaLogin on the element with ID "recaptcha-login"
        recaptchaGoogleLogin = grecaptcha.render('recaptcha-google-login', {
	                'sitekey' : '<%=siteKey%>',
	                'size' : 'invisible',
	                'callback' : verifyCallbackLogin
	              });
        
        recaptchaGoogleRegister = grecaptcha.render('recaptcha-google-register', {
            'sitekey' : '<%=siteKey%>',
            'size' : 'invisible',
            'callback' : verifyCallbackRegister
          });
        
        document.getElementById('recaptcha-google-login').click();
        document.getElementById('recaptcha-google-register').click();
        
      };
     
    </script>

  <title>Login/SignUp</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- Google Sign In Code Integration - Begin -->
  
  <meta name="google-signin-client_id" content="<%=signInKey%>">
  <script src="https://apis.google.com/js/platform.js" async defer></script>
  
  <!-- Google Sign In Code Integration - End -->
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/style4.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script> --%>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
 
 <script type="text/javascript">
 
 var clickedLogin=false;//Global Variable
 var clickedRegister=false;//Global Variable
 var tokenResLogin="notSet";//Global Variable 
 var tokenResRegister="notSet";//Global Variable 
 
 function verifyCallbackLogin( googleResponse ) {
	 tokenResLogin = googleResponse;
    
};

function verifyCallbackRegister( googleResponse ) {
	tokenResRegister = googleResponse;
   
};


 function ClickLogin()
 {
	 this.clickedLogin=true;
	 
 }
 
 function ClickRegister()
 {
	 this.clickedRegister=true;
	 
 }
            function init() {
            	
            	/* alert("init callled !! "); */
            	
            	/* document.getElementById('recaptcha-google-login').click();
        		
        		alert("onSignIn : tokenRes is : "+tokenRes); */
            	
            	/* document.getElementById('recaptcha-google-login').click(); */
            	
            	/* alert( " button clicked from inside the init call !!! "); */
            	
            	
               /*  gapi.load('auth2', function() {
                    auth2 = gapi.auth2.init({
                        client_id: '1430357134-g37k6g153rvmu7mlkib4erd0tv3edfmb.apps.googleusercontent.com',
                        fetch_basic_profile: false,
                        scope: 'profile'
                    }); */
                    
                    /* gapi.signin2.render("g-signin-btn", {
                            scope: 'email',
                            width: 200,
                            height: 50,
                            longtitle: false,
                            theme: 'dark',
                            onfailure: null
                        }); */
              /*   }); */
                
                
            }
            function onSignInLogin(googleUser) {
            	
            	if (clickedLogin) {
            	var profile = googleUser.getBasicProfile();
          		
          		document.getElementById("email-id-login-1").value = profile.getEmail();
       		  	document.getElementById("google-login-1").value = "GoogleLogin";
       		 	document.getElementById("google-response-login-1").value = tokenResLogin; 
     		  	document.formGoogleLogin.submit();
            	}
     		  
            }
            
			function onSignInRegister(googleUser) {
            	
            	if (clickedRegister) {
            	
            	var profile = googleUser.getBasicProfile();
          		
          		document.getElementById("registration-email-id-1").value = profile.getEmail();
       		  	document.getElementById("google-register-1").value = "GoogleLogin";
       		 	document.getElementById("google-response-register-1").value = tokenResRegister; 
     		  
     		  	document.formGoogleRegister.submit();
            	}
     		  
            }
            
            function signOut() {
                var auth2 = gapi.auth2.getAuthInstance();
                auth2.signOut().then(function () {
                    console.log("on sign out");
                    setMessage("User signed out");
                    setProfileImage(null);
                });
            }
            function disconnect() {
                console.log("on disconnect");
                var auth2 = gapi.auth2.getAuthInstance();
                if (!auth2.isSignedIn.get()) {
                    setMessage("Not signed in, cannot disconnect");
                    return;
                }
                auth2.disconnect();
                setProfileImage(null);
                setMessage("Disconnected");
            }
            function setMessage(message) {
                document.getElementById("message").value = message;
            }
            function setProfileImage(srcUrl) {
                var element = document.getElementById("profileImage");
                if (srcUrl == null) {
                    element.style.display = "none";
                    element.src = "";
                } else {
                    element.style.display = "block";
                    element.src = srcUrl;
                }
            }
        </script>
 
 <style>
 
.g-signin2{
  width: 100%;
}

.g-signin2 > div{
  margin: 0 auto;
}
    
  </style>
</head>
<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;"  onload="init()" >
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
			<!-- <div class="g-signin2 " data-onsuccess="onSignIn"  data-width="530" data-height="40" data-longtitle="true">
			</div> -->
			 <!-- <div id="g-signin-btn" onclick="ClickLogin()" class="g-recaptcha" ></div> --> 
			<!-- <div id="g-signin-btn" onclick="ClickLogin()" id="recaptcha-login" class="g-recaptcha button button-block g-font-size-20--xs g-font-size-30--lg"></div> -->
          <!-- <h1 class="g-font-size-15--xs g-font-size-30--lg g-margin-t-o-10--xs g-margin-t-o-0--lg ">Welcome Back!</h1> -->
         
			
			<p id="loginMessage" ></p>
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
            <s:textfield class="form-control" name="emailIdLogin" placeholder="Email Address"  id="email-id-login"/>
            <%
            }
            %>
          </div>
          
          <div class="field-wrap g-margin-t-o-10--xs g-margin-t-o-0--lg">
            <s:fielderror fieldName="passwordLogin" class="g-color--red" />
  			<s:password class="form-control" name="passwordLogin" placeholder="Password"  id="password-login"/>
          </div>
          
          <p class="forgot"><button type="button" class=" g-bg-color--primary g-color--white g-font-size-10--xs g-font-size-15--lg"  data-toggle="modal" data-target="#myModal">Forgot Password?</button></p>
          <div class="container">

  <!-- Modal -->
  
  </div>
  
  	<s:hidden id="google-response-login" name="googleResponseLogin"></s:hidden>
  	<s:hidden id="google-login" name="googleLogin"></s:hidden>
          <div>
          	
        	<s:submit id="recaptcha-login" class="g-recaptcha button button-block g-font-size-20--xs g-font-size-30--lg" value="Sign In"  />
           </div>
          <%--  <s:hidden id="email-id-login" name="emailIdLogin"></s:hidden>
  				<s:hidden id="google-response-login" name="googleResponseLogin"></s:hidden>
  				<s:hidden id="google-login" name="googleLogin"></s:hidden>
  				<div>
          	
        	<s:submit id="recaptcha-login" class="g-recaptcha button button-block g-font-size-20--xs g-font-size-30--lg" value="Sign In"  />
           </div> --%>
          </s:form>
          
          
          <s:form  action="newLoginAction" method="post" name="formGoogleLogin" namespace="/"  autocomplete="off"   >
           		
           		<s:hidden id="email-id-login-1" name="emailIdLogin"></s:hidden>
  				<s:hidden id="google-response-login-1" name="googleResponseLogin"></s:hidden>
  				<s:hidden id="google-login-1" name="googleLogin"></s:hidden>
  				<br/>
  				<div  class="g-signin2 "   data-onsuccess="onSignInLogin" data-width="300"
  					data-height="40" data-longtitle="false" data-theme="dark"   onclick="ClickLogin()">
  				<!-- <div id="g-signin-btn" onclick="ClickLogin()"  > -->
  				</div>
  				<div class="hidden">
           		<s:submit class="g-recaptcha " id="recaptcha-google-login" style="display:none;"  />
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
          
         <%--  <div id="registration-mobile-number" class="field-wrap  g-margin-t-o-10--xs g-margin-t-o-0--lg">
            <s:fielderror fieldName="mobileNumberRegister" class="g-color--red" />
  			<s:textfield class="form-control"  name="mobileNumberRegister" autocomplete="off" placeholder="Mobile Number"/>
          </div> --%>
           <div id="registration-password" class="field-wrap  g-margin-t-o-10--xs g-margin-t-o-0--lg">
            <s:fielderror fieldName="passwordRegister" class="g-color--red" />
  			<s:password class="form-control"  name="passwordRegister" autocomplete="off" placeholder="Create Password"/>
          </div>
          <s:hidden id="google-response-register" name="googleResponseRegister"></s:hidden>
          
          <s:submit id="recaptcha-register" class="g-recaptcha button button-block  g-font-size-20--xs g-font-size-30--lg" value="Create Account"  />
          
			              
          </s:form>
          
          <s:form  action="newLoginAction" method="post" name="formGoogleRegister" namespace="/"  autocomplete="off"   >
           		
           		<s:hidden id="registration-email-id-1" name="emailIdLogin"></s:hidden>
  				<s:hidden id="google-response-register-1" name="googleResponseLogin"></s:hidden>
  				<s:hidden id="google-register-1" name="googleLogin"></s:hidden>
  				<br/>
  				<div  class="g-signin2 "   data-onsuccess="onSignInRegister" data-width="300"
  					data-height="40" data-longtitle="false" data-theme="dark"   onclick="ClickRegister()">
  				<!-- <div id="g-signin-btn" onclick="ClickLogin()"  > -->
  				</div>
  				<div class="hidden">
           		<s:submit class="g-recaptcha " id="recaptcha-google-register" style="display:none;"  />
           		</div>
           		
           </s:form>
           
           <br/><p class="text-center"><span class=" g-font-size-12--xs g-font-size-15--lg  g-color--white-opacity-light">By continuing you agree to our <a class=" g-color--primary" href="terms">Terms &amp; Conditions</a> & <a class="g-font-size-12--xs g-font-size-15--lg g-color--primary" href="privacyPolicy">Privacy Policy</a></span></p>
			<p class=" g-font-size-10--xs g-font-size-12--lg g-margin-t-o-10--xs g-color--white-opacity-light text-center"> <i class="  glyphicon glyphicon-lock"></i> &nbsp;Secure and SEBI registered </p>
          	 
           
           
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
