<!DOCTYPE html >
<html lang="en">
<head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Megakit - HTML5 Theme</title>
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
      var recaptcha1;
      var recaptcha2;
      var myCallBack = function() {
        //Render the recaptcha1 on the element with ID "recaptcha1"
        recaptcha1 = grecaptcha.render('recaptcha1', {
          'sitekey' : '6LfzbkoUAAAAAMCRHI8BqlBdRlALLUpvYK7EeVID', //Replace this with your Site key
          'size' : 'invisible',
          'callback' : register
        });
        
        //Render the recaptcha2 on the element with ID "recaptcha2"
        recaptcha2 = grecaptcha.render('recaptcha2', {
        	'sitekey' : '6LfzbkoUAAAAAMCRHI8BqlBdRlALLUpvYK7EeVID', //Replace this with your Site key
            'size' : 'invisible',
            'callback' : forgottenPassword
        });
        
        recaptcha3 = grecaptcha.render('recaptcha3', {
            'sitekey' : '6LfzbkoUAAAAAMCRHI8BqlBdRlALLUpvYK7EeVID', //Replace this with your Site key
            'size' : 'invisible',
            'callback' : login
          });
      };
    </script>
    
	    <link rel="stylesheet" href="css/style4.css">
	    <style>
	    	
				.grecaptcha-badge{visibility:hidden;}
	    </style>
</head>

<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;">
<div id="load" class="load"></div>
<div id="content">
	
	<div class="container ">
   		<a href="myIndex" class="s-header-v2__logo-link">
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
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab "><a href="#login">Log In</a></li>
        
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <div >
          <div class="field-wrap">
          	<p id="registerMessage"></p>
            <label> Your Email<span class="req">*</span>  </label>
            <input id="email-id1" type="email"required autocomplete="off"/>
          </div>
          <div class="field-wrap">
            <label>
              Create Password<span class="req">*</span>
            </label>
            <input id="password1"  type="password"required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Mobile Number<span class="req">*</span>
            </label>
            <input id="mobile-number"  type="password"required autocomplete="off"/>
          </div>
          
          <!-- <button type="submit" class="button button-block" onClick="register();">Get Started</button> -->
          <button id="recaptcha1" type="button" class="g-recaptcha button button-block" >Continue</button>
			<!-- <button type="button"  class="button button-block" onClick="register();">Continue</button>  -->       
			<br/><span class=" g-font-size-8--xs g-color--white-opacity-light"><span class="">By continuing you agree to our </span> <a class=" g-color--primary" href="terms.jsp">Terms &amp; Conditions</a> & <a class="g-font-size-15--xs g-color--primary" href="policy.jsp">Privacy Policy</a></span>
			<p class=" g-font-size-8--xs g-color--white-opacity-light"> <i class="  glyphicon glyphicon-lock"></i> &nbsp;Secure and AMFI registered </p>
                              
          </div>

        </div>
        <div id="login">   
          <h1>Welcome Back!</h1>
          <p id="loginMessage"></p>
          <div>
          
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input id="email-id"  type="email" required autocomplete="off"/>
           <!--  <input id="email-id" type="text" class="form-control" name="emailId" placeholder="Email" style="width:600px;"> -->
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input  id="password" type="password" required autocomplete="off"/>
          </div>
          
          <p class="forgot"><a data-toggle="modal" data-target="#myModal">Forgot Password?</a></p>
          <div class="container">

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog ">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <p id="forgotPwdMessage"></p>
          <h4 class="modal-title">Reset Password</h4>
        </div>
        <div class="modal-body">
          <p class="g-color--black"  style="color: #000000">Enter the email address associated with your account, and we&#39;ll email you a link to reset your password.</p>
        </div>
        
			<div class="input-group g-margin-l-20--xs  g-margin-r-60--xs g-margin-b-20--xs">
    			<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    			<input id="emailid" type="text" class="form-control" name="emailId" placeholder="Enter Email Id" >
  			</div>
	
        <div class="modal-footer">
        	<div class="row">
				<div class="col-md-3 g-color--primary">
					<i class="  glyphicon glyphicon-chevron-left"></i><a  data-dismiss="modal">Back to Login</a>
				</div>
				<div class="col-md-5">
				</div>
				<div class="col-md-4">
					<button id="recaptcha2" type="button" class="g-recaptcha g-bg-color--primary g-color--white"   >Send Reset Link</button>
				</div>
			</div>
        </div>
      </div>
    </div>
  </div>
</div>
          <div>
        	  <button id="recaptcha3" type="button" class="g-recaptcha button button-block"  >SIGN IN</button>
           </div>
          
          </div>

        </div>	
      </div><!-- tab-content -->
      
</div>
	</div>		
          </div>
        <!--========== END PROMO BLOCK ==========-->
	
<!--========== END PROMO BLOCK ==========-->
	

		<script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
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







    


	 
	
	
  

