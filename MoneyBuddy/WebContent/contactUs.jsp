<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.Properties" %>
<%@ page language="java" import="java.io.FileInputStream" %>
<%@ page language="java" import="java.io.File" %>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy-Top Performing Mutual Funds</title>
		<meta http-equiv="Cache-control" content="max-age=2592000, public">
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
	
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Theme Styles -->
        <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
 	
  
  <script type="text/javascript" src="assets/js/jquery-latest.js"></script>
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
    
      var recaptchaContactUs;
      
      var myCallBack = function() {

        //Render the recaptchaContactUs on the element with ID "recaptcha-contact-us"
        recaptchaContactUs = grecaptcha.render('recaptcha-contact-us', {
          'sitekey' : '<%=siteKey%>',
          'size' : 'invisible',
          'callback' : submitContactUsMail
        });

      };
     
    </script>


<style>
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Raleway:400,500,700);


</style>

    </head>
    <!-- End Head -->

    <!-- Body -->
    <body >
<!--========== HEADER ==========-->
        <header class="navbar-fixed-top s-header-v2 js__header-sticky">
            <!-- Navbar -->
            <nav class="s-header-v2__navbar">
                <div class="g-padding-l-80-md g-display-table--lg">
                    <!-- Navbar Row -->
                    <div class="s-header-v2__navbar-row">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="s-header-v2__navbar-col">
                            <button type="button" class="collapsed s-header-v2__toggle" data-toggle="collapse" data-target="#nav-collapse" aria-expanded="false">
                                <span class="s-header-v2__toggle-icon-bar"></span>
                            </button>
                        </div>

                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col-width--180">
                            <!-- Logo -->
                            <div class="s-header-v2__logo">
                                <a href="welcome" class="s-header-v2__logo-link">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
                                </a>
                            </div>
                            <!-- End Logo -->
                        </div>
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col-width--180"></div>
                        
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col--right g-padding-l-80-md">
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="welcome" class="s-header-v2__nav-link">Home</a></li>
                                    <!-- <li class="s-header-v2__nav-item"><a href="Fees" class="s-header-v2__nav-link">Fees</a></li> -->
                                    <li class="s-header-v2__nav-item"><a href="saveTax" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="MFexplorer"/>" class="s-header-v2__nav-link">Funds Explorer</a></li>
                                    <!-- <li class="s-header-v2__nav-item"><a href="aboutUs" class="s-header-v2__nav-link">About Us</a></li> -->
                                    <li class="s-header-v2__nav-item"><a href="https://medium.com/@moneybuddyIndia" class="s-header-v2__nav-link">Blog</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/SignUp</a></li>
										<%	} else 
										 	{	%>
										 			<li class="s-header-v2__nav-item"><a href="<s:url action="Dashboard"/>" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li id="dropdown-selector" class="dropdown s-header-v2__nav-item s-header-v2__dropdown-on-hover">
			                                        	<a href="javascript:void(0);" class="dropdown-toggle s-header-v2__nav-link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cart<span class="g-font-size-10--xs g-margin-l-5--xs ti-angle-down"></span></a>
			                                        	<ul class="dropdown-menu s-header-v2__dropdown-menu" style="min-width: 60px;">
			                                            	<li><a href="<s:url action="Cart"/>" class="s-header-v2__dropdown-menu-link">Investment Cart</a></li>
			                                            	<li><a href="<s:url action="RedCart"/>" class="s-header-v2__dropdown-menu-link">Redemption Cart</a></li>
			                                        		<li><a href="<s:url action="customerStpCartAction"/>" class="s-header-v2__dropdown-menu-link">Stp Cart</a></li>
			                                        		<li><a href="<s:url action="customerSwitchCartAction"/>" class="s-header-v2__dropdown-menu-link">Switch Cart</a></li>
			                                        	</ul>
			                                    	</li>
										 			 <li class="s-header-v2__nav-item"><a href="<s:url action="logOut"/>" class="s-header-v2__nav-link">Log Out</a></li>
										<%	}	%>  
										<li id="dropdown-selector" class="dropdown s-header-v2__nav-item s-header-v2__dropdown-on-hover">
                                        	<a href="javascript:void(0);" class="dropdown-toggle s-header-v2__nav-link -is-active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Help <span class="g-font-size-10--xs g-margin-l-5--xs ti-angle-down"></span></a>
                                        	<ul class="dropdown-menu s-header-v2__dropdown-menu g-margin-t-o-30--xs">
                                            	<li><a href="FAQs" class="s-header-v2__dropdown-menu-link">FAQ</a></li>
                                            	<li><a href="contactUs" class="s-header-v2__dropdown-menu-link -is-active">Contact Us</a></li>
                                        	</ul>
                                    	</li>
                                </ul>
                            </div>
                            <!-- End Nav Menu -->
                        </div>
                    </div>
                    <!-- End Navbar Row -->
                </div>
            </nav>
            <!-- End Navbar -->
        </header>
        <!--========== END HEADER ==========-->

        <!--========== PAGE CONTENT ==========-->

<div class="g-bg-color--dark">
            <div class="g-container--md g-text-center--xs ">
            <br/><br/><br/><br/>
                <div class="g-margin-b-10--xs">
                    <h2 class="g-font-size-20--xs g-font-size-40--lg g-color--white g-letter-spacing--1 g-margin-t-10--xs g-margin-b-0--xs g-margin-b-10--lg"><b>Contact Us</b></h2>
                    <!-- <h1 class="g-font-size-40--xs g-font-size-50--sm g-font-size-60--md g-color--white g-letter-spacing--1 g-margin-b-10--xs">Contact Us</h1> -->
                </div>
            </div>
        </div>

        <!--========== PAGE CONTENT ==========-->
        <!-- Feedback Form -->
        <div class="g-position--relative g-bg-color--primary">
            <div class="g-container--md g-padding-y-50--xs">
                <!-- <div class="g-text-center--xs g-margin-t-50--xs g-margin-b-80--xs">
                    <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-25--xs">Contact Us</p>
                </div> -->
                <div class="row g-row-col--5 g-margin-b-20--xs">
                    <div class="col-xs-4 col-md-4 ">
                        <div class="g-text-center--xs">
                            <p style="color: white;"><b>
                            <a  class="g-font-size-10--xs g-font-size-18--md" href="https://mail.google.com/mail/u/0/?view=cm&fs=1&tf=1&to=ContactUs@MoneyBuddy.co.in" target="_top" style="color: white;">
                            	<i class="g-display-block--xs g-font-size-16--xs g-font-size-40--md g-color--white-opacity g-margin-b-10--xs g-margin-b-30--md ti-email"></i>
                            </a></b>
                            </p>
                            
                            <h4 class="g-font-size-12--xs g-font-size-18--md g-color--white g-margin-b-5--md">Email</h4>
                        	<!-- <p style="color: white;"><b><a  class="g-font-size-10--xs g-font-size-18--md" href="https://mail.google.com/mail/u/0/?view=cm&fs=1&tf=1&to=savita.wadhwani@gmail.com&subject=MISSED%20CALL%20EZTRADER&body=Hello%2C%0A%0AI%20tried%20contacting%20you%20today%20but%20you%20seem%20to%20have%20missed%20my%20call.%20%0A%0APlease%20return%20my%20call%20as%20soon%20as%20you%E2%80%99re%20available.%20%0A%0AIn%20any%20case%2C%20I%20will%20try%20ringing%20you%20at%20a%20later%20time.%0A%0A%0ATy%2C%0A%0A%0A%0A" target="_top" style="color: white;">ContactUs@MoneyBuddy.co.in</a></b></p> -->
                        </div>
                    </div>
                    <div class="col-xs-4 col-md-4 ">
                        <div class="g-text-center--xs">
                            <i class="g-display-block--xs g-font-size-16--xs g-font-size-40--md g-color--white-opacity g-margin-b-10--xs g-margin-b-30--md ti-headphone-alt"></i>
                            <h4 class="g-font-size-12--xs g-font-size-18--md g-color--white g-margin-b-5--md">Call / whats app </h4>
                            <p  class="g-font-size-10--xs g-font-size-18--md" style="color: white;"><b>+91 9971648736</b></p>
                        </div>
                    </div>
                     <div class="col-xs-4 col-md-4 g-margin-b-50--xs g-margin-b-0--sm  ">
                        <div class="g-text-center--xs">
                            <p class="g-color--white-opacity"> <a class="g-font-size-10--xs g-font-size-18--md" href="FAQs"><b>
                            <span style="color: white;">
                             	<i class="g-display-block--xs g-font-size-16--xs g-font-size-40--md g-color--white-opacity g-margin-b-10--xs g-margin-b-30--md ti-files"></i>
                            </span></b></a></p>
                            
                            <h4 class="g-font-size-12--xs g-font-size-18--md g-color--white g-margin-b-5--md">FAQs</h4>
                            
                        </div>
                    </div>
                </div>
                
                <s:form  action="sendMailAction"  method="post" name="formContactUsMail" namespace="/" >
                
                <div id="contact-us-form" class="center-block g-width-500--sm g-width-550--md" >
					<div class="g-margin-b-20--xs">
						<s:actionmessage class="small-text"/> 
                        
                    </div>
                    <div class="g-margin-b-20--xs">
                        <s:fielderror fieldName="senderName" class="g-color--red" />
			  			<s:textfield class="form-control s-form-v3__input" name="senderName" placeholder="* Name" /> 
						<!-- <input type="text" class="form-control s-form-v3__input" id="sender-name" placeholder="* Name"> -->
                    </div>
                    <div class="row g-row-col-5 g-margin-b-50--xs">
                        <div class="col-sm-6 g-margin-b-30--xs g-margin-b-0--md">
                        	<s:fielderror fieldName="senderEmailId" class="g-color--red" />
			  				<s:textfield class="form-control s-form-v3__input" name="senderEmailId" placeholder="* Email" />
                            <!-- <input type="email" class="form-control s-form-v3__input" id="sender-emailId" placeholder="* Email"> -->
                        </div>
                        <div class="col-sm-6">
                        	<s:fielderror fieldName="senderMobileNum" class="g-color--red" />
			  				<s:textfield class="form-control s-form-v3__input" name="senderMobileNum" placeholder="* Phone"  />
                            <!-- <input type="text" class="form-control s-form-v3__input" id="sender-mobile-number" placeholder="* Phone"> -->
                        </div>
                    </div>
                    <div class="g-margin-b-10--xs">
                    	<s:fielderror fieldName="senderMessage" class="g-color--red" />
			  			<s:textfield class="form-control s-form-v3__input" name="senderMessage" placeholder="* Your message" />
                        <!-- <textarea class="form-control s-form-v3__input" id="sender-message" rows="5" placeholder="* Your message"></textarea> -->
                    </div>
                    <s:hidden id="google-response-coontact-us" name="googleResponseContactUs"></s:hidden>
                    
                    <div class="g-text-center--xs">
                    	<s:submit id="recaptcha-contact-us"  class="g-recaptcha text-uppercase s-btn s-btn--md s-btn--white-bg g-radius--50 g-padding-x-70--xs g-margin-b-20--xs" value="Submit"  />
                        <!-- <button id="recaptcha-contact-us" type="submit" class="text-uppercase s-btn s-btn--md s-btn--white-bg g-radius--50 g-padding-x-70--xs g-margin-b-20--xs" >Submit</button> -->
                    </div>
                    
                   
                </div>
                
                </s:form>
                
                <p id="contact-us-text" class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-25--xs"></p>
                
                
            </div>
            <img class="s-mockup-v2" src="img/mockups/pencil-01.png" alt="Mockup Image">
            	</div>

        <!-- End Feedback Form -->
        <!--========== END PAGE CONTENT ==========-->
        
        <!--========== FOOTER ==========-->
        <footer class="g-bg-color--dark">
            <!-- Links -->
            <div class="g-hor-divider__dashed--white-opacity-lightest">
                <div class="container g-padding-y-40--xs">
                    <div class="row">
                    
                        <div class="col-xs-4 col-lg-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs ">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="welcome">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="saveTax">Save Tax</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="<s:url action="MFexplorer"/>">Funds Explorer</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="contactUs">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-4 col-lg-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://twitter.com/MoneyBuddyIndia">Twitter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.facebook.com/MoneyBuddyIndia">Facebook</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.linkedin.com/in/money-buddy-94a73814a/">Linkedin</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.YouTube.com/MoneyBuddy">YouTube</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-4 col-lg-2 g-margin-b-60--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="terms">Terms &amp; Conditions</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="privacyPolicy">Privacy Policy</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="MFDocuments">MFDocuments</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://medium.com/@moneybuddyIndia">Blog</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-12 col-md-4 col-lg-offset-2 s-footer__logo g-padding-y-50--xs g-padding-y-0--md">
                             <h3 class="text-center g-font-size-18--xs g-color--primary g-margin-l-o-25--xs">MoneyBuddy</h3>
                            <br/>
                            <p class="g-color--primary">
                            No complicated jargon, no daunting fees, just straightforward, effortless investing.</p>
                        </div>
                    </div>
                    <div class="row  g-font-size-12--xs g-color--white">
                    <br/>
                    	 Mutual fund investments are subject to market risks. Please read the scheme information and other related documents carefully before investing.
						<br/>Past performance is not indicative of future returns. Please consider your specific investment requirements, risk tolerance, investment goal and time frame associated with the investment before choosing a fund or designing a suitable portfolio.
                    	<br/>MoneyBuddy is the trade name used by Kamal Wadhwani to run his advisory business. SEBI Regn No: INA000013581
                    </div>
                </div>
            </div>
            <!-- End Links -->

            <!-- Copyright -->
            <div class="container g-padding-y-10--xs">
                <div class="row">
                    <div class="col-xs-6">
                        <a href="welcome">
                            <img class="g-width-100--xs g-height-auto--xs" src="img/logo-white.png" alt="MoneyBuddy Logo">
                        </a>
                    </div>
                     <div class="col-xs-6 g-text-right--xs g-color--white">
                    &copy; 2020 <a href="welcome" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
                </div>
                </div>
            </div>
            <!-- End Copyright -->
        </footer>
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>


       <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
	    <script type="text/javascript" src="assets/js/javaScript.js"></script>
	    
	    <script src="assets/js/jquery.js"></script>
	    
	    <script src="assets/js/sly.min.js"></script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
	    <script src="assets/js/jquery.isotope.min.js"></script>
	    <script src="assets/js/main.js"></script>
	    <script src="assets/js/wow.min.js"></script>
        
<%--  <script>
         document.onreadystatechange = function () {
        	/*  $(myInput).keyup(function() {
		 		    var value = $(this).val().toLowerCase();
		 		    $("#myDiv1 div").filter(function() {
		 		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		 		    });
		 		  }); */
        	 
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
         
        /*  $(document).ready(function(){
 			
 		}); */
         
         </script> --%>
    </body>
    <!-- End Body -->
</html>
