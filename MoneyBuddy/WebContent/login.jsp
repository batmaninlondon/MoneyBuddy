<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.Properties" %>
<%@ page language="java" import="java.io.FileInputStream" %>
<%@ page language="java" import="java.io.File" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>



        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <!-- <title>Megakit - HTML5 Theme</title> -->
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="Megakit - HTML5 Theme">
        <meta name="author" content="keenthemes.com">

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>

        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
	    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
	    
	      <!-- <script src="https://www.google.com/recaptcha/api.js" async defer></script> -->
	      
	      <script src="https://www.google.com/recaptcha/api.js?onload=myCallBack&render=explicit" async defer></script>
    <script>
    
    <%
    
    ServletContext sc=request.getServletContext();
    String path=sc.getRealPath("/properties/jspConfig.properties");
    FileInputStream fis = new FileInputStream(new File(path));
    
    Properties configProperties = new Properties();

	configProperties.load(fis);
	
	String siteKey = configProperties.getProperty("RECAPTHA_SITE_KEY");
    
    %>
    
      var recaptchaRegister;
      var recaptchaForgotPswd;
      var recaptchaLogin;
      
      var myCallBack = function() {
    	  
    	  alert('Hi There !!!!!!! site key is : '+<%=siteKey%>);
        //Render the recaptchaRegister on the element with ID "recaptcha-register"
        recaptchaRegister = grecaptcha.render('recaptcha-register', {
          'sitekey' : '<%=siteKey%>', //Replace this with your Site key
          'size' : 'invisible',
          'callback' : submitRegister
        });
        
        //Render the recaptchaForgotPswd on the element with ID "recaptcha-forgot-pswd"
        recaptchaForgotPswd = grecaptcha.render('recaptcha-forgot-pswd', {
        	'sitekey' : '<%=siteKey%>', //Replace this with your Site key
            'size' : 'invisible',
            'callback' : submitForgotPassword
        });
        
      //Render the recaptchaLogin on the element with ID "recaptcha-login"
        recaptchaLogin = grecaptcha.render('recaptcha-login', {
            'sitekey' : '<%=siteKey%>', //Replace this with your Site key
            'size' : 'invisible',
            'callback' : submitLogin
          });
      };
     
    </script>
    

	    <style>
	    	
				.grecaptcha-badge{visibility:hidden;}
	    </style>
	    
	    
	    
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style4.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;" >
	<div id="load" class="load"></div>
	<div id="content">
	
	<div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="Dublin Logo">
		</a>
	</div>
	<%
	
	    if ("TRUE".equals(request.getParameter("OnetimeInvestment"))) {
	    	session.setAttribute("OnetimeInvestment", "TRUE");
	    	System.out.println("In login jsp : OnetimeInvestment set to TRUE .");
	    } else if ("FALSE".equals(request.getParameter("OnetimeInvestment"))) {
	    	session.setAttribute("OnetimeInvestment", "FALSE");
	    	System.out.println("In login jsp : OnetimeInvestment set to FALSE .");
	    }
	%>
	<!--========== PROMO BLOCK ==========-->
		<div class="g-fullheight--xs g-bg-position--center swiper-slide " >
        	<div class="form  ">
   	
  <ul class="nav nav-pills nav-tabs card-header-pills">
    <li class="nav-item active">
      <a class="nav-link g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" href="#loginTabContent">LogIn</a>
    </li>
    <li class="nav-item">
      <a class="nav-link g-color--primary font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" href="#signup">SignUp</a>
    </li>       
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="loginTabContent" class="container tab-pane active"><br>
                <s:form  action="newLoginAction" class="g-recaptcha" method="post" name="formLogin" namespace="/" >
          <h1>Welcome Back!</h1>
          <p id="loginMessage"></p>
         <!--  <div> -->
          
          <div class="field-wrap">
            <label id="email-id-label">
              Email Address<span class="req">*</span>
            </label>
            <s:fielderror fieldName="emailIdLogin" class="g-color--red" />
  			<s:textfield class="form-control s-form-v3__inpu" name="emailIdLogin" />
            <!-- <input id="email-id"  type="email" required autocomplete="off"/> -->
           <!--  <input id="email-id" type="text" class="form-control" name="emailId" placeholder="Email" style="width:600px;"> -->
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <s:fielderror fieldName="passwordLogin" class="g-color--red" />
  			<s:password class="form-control s-form-v3__inpu" name="passwordLogin" />
            <!-- <input  id="password" type="password" required autocomplete="off"/> -->
          </div>
          
          <p class="forgot"><button type="button" class="g-recaptcha g-bg-color--primary g-color--white"  data-toggle="modal" data-target="#myModal">Forgot Password?</button></p>
          <div class="container">

  <!-- Modal -->
  
  </div>
  
  	<s:hidden id="google-response-login" name="googleResponseLogin"></s:hidden>
          <div>
          	
        	<s:submit id="recaptcha-login" class="g-recaptcha button button-block" value="SIGN IN"  />
        	<%-- <s:submit class="button button-block" value="SIGN IN"  /> --%>
        	<!-- <button id="recaptcha-login" type="button" class="g-recaptcha button button-block"  >SIGN IN</button> -->
           </div>
          </s:form>
    </div>
    <div id="signup" class="container tab-pane fade"><br>
               <s:form  action="registerAction" class="g-recaptcha" method="post" name="formRegister" namespace="/" >
          <div id="registration-email-id"  class="field-wrap">
          	<p id="registerMessage"></p>
            <%-- <label> 
            	Email Address<span class="req">*</span>  
            </label> --%>
           	<s:fielderror fieldName="emailIdRegister" class="g-color--red" />
  			<s:textfield name="emailIdRegister"  autocomplete="false" placeholder="Email Address"/>
            <!-- <input id="email-id1" type="email"required autocomplete="off"/> -->
          </div>
          <div id="registration-password" class="field-wrap ">
            <%-- <label>
              Create Password<span class="req">*</span>
            </label> --%>
            <s:fielderror fieldName="passwordRegister" class="g-color--red" />
  			<s:password name="passwordRegister" autocomplete="off" placeholder="Create Password"/>
            <!-- <input id="password1"  type="password"required autocomplete="off"/> -->
          </div>
          
          <div id="registration-mobile-number" class="field-wrap">
            <%-- <label>
              Mobile Number<span class="req">*</span>
            </label> --%>
            <s:fielderror fieldName="mobileNumberRegister" class="g-color--red" />
  			<s:textfield name="mobileNumberRegister" autocomplete="off" placeholder="Mobile Number"/>
            <!-- <input id="mobile-number"  type="password"required autocomplete="off"/> -->
          </div>
          <s:hidden id="google-response-register" name="googleResponseRegister"></s:hidden>
          <!-- <p id="registration-text" class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-35--xs"></p> -->
          <!-- <button type="submit" class="button button-block" onClick="register();">Get Started</button> -->
          <s:submit id="recaptcha-register" class="g-recaptcha button button-block" value="Continue"  />
          <!-- <button id="recaptcha-register" type="button" class="g-recaptcha button button-block" >Continue</button> -->
			<!-- <button type="button"  class="button button-block" onClick="register();">Continue</button>  -->       
			<br/><span class=" g-font-size-8--xs g-color--white-opacity-light"><span class="">By continuing you agree to our </span> <a class=" g-color--primary" href="terms">Terms &amp; Conditions</a> & <a class="g-font-size-15--xs g-color--primary" href="policy">Privacy Policy</a></span>
			<p class=" g-font-size-8--xs g-color--white-opacity-light"> <i class="  glyphicon glyphicon-lock"></i> &nbsp;Secure and AMFI registered </p>
          	<div class="row" >
				<div class="col-md-3"></div>
				<div class="col-md-5 ">
						<s:actionmessage class="small-text"/> 
				</div>
				<div class="col-md-4"></div>
			</div>                 
          </s:form>
    </div>
    
              <div class="modal fade" id="myModal" >
    <div class="modal-dialog ">
      <div class="modal-content">
        <div class="modal-header">
          
          
          <h4 class="modal-title">Reset Password</h4>
          <p id="forgotPwdMessage"></p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
          <p class="g-color--black"  style="color: #000000">Enter the email address associated with your account, and we&#39;ll email you a link to reset your password.</p>
       
        <s:form  action="forgottenPasswordAction" class="g-recaptcha" method="post" name="formForgotPassword">

			<div class="row" >
				<div class="col-md-3"></div>
				<div class="col-md-5 ">
						<s:actionmessage class="small-text"/> 
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row input-group form-group">
				<div class="col-md-1"></div>
    			<div class="col-md-10">
	    			<s:fielderror fieldName="emailIdForgotPassword" class="g-color--red" />
		  			<s:textfield class="form-control" placeholder="Enter Email Id" name="emailIdForgotPassword" /> 
		  			<s:hidden id="google-response-forgot-pswd" name="googleResponseFrgtPswd"></s:hidden>
	  			</div>
	  			<div class="col-md-1">
	  			</div>	
    			<!-- <input id="emailid" type="text" class="form-control" name="emailId" placeholder="Enter Email Id" > -->
  			</div>
	
			
        	<div class="row ">
				<div class="col-md-5 g-color--primary">
					<i class="  glyphicon glyphicon-chevron-left"></i><a  data-dismiss="modal">Back to Login</a>
				</div>
				<div class="col-md-3">
				</div>
				<div class="col-md-4">
					<s:submit id="recaptcha-forgot-pswd" class="g-recaptcha g-font-size-14--xs g-bg-color--primary g-color--white" value="Send Reset Link"  />
					<!-- <button id="recaptcha-forgot-pswd" type="button" class="g-recaptcha g-bg-color--primary g-color--white"   >Send Reset Link</button> -->
				</div>
			</div>
			
			</s:form>
		
		 </div>
		 
        </div>
      </div>
    </div>
    
    <!-- <div id="menu2" class="container tab-pane fade"><br>
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div> -->
  </div>
  </div>
  </div>
</div>



		<script type="text/javascript" src="assets/js/javaScript.js"></script>
		<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
    	<script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
   	 	<script src="assets/js/main.js"></script>
    	<script src="assets/js/wow.min.js"></script>


        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.parallax.min.js"></script>
        <script type="text/javascript" src="vendor/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>

        <!-- General Components and Settings -->
        <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="js/components/faq.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
         <script  src="js/index.js"></script>
         
         <script>
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
         
         </script>
         
</body>
</html>
