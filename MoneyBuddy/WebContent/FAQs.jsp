<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
		<link type="text/css" rel="stylesheet" href="assets/css/cubeportfolio/cubeportfolio.min.css" />
		<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
	
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Theme Styles -->
        <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
        <!-- <meta name="google-signin-client_id" content="1430357134-g37k6g153rvmu7mlkib4erd0tv3edfmb.apps.googleusercontent.com"> -->
  <%-- <script src="https://apis.google.com/js/platform.js" async defer></script> --%>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script> --%>
  
 	
  
  <script type="text/javascript" src="assets/js/jquery-latest.js"></script>
  
  
 <script>
		
</script>


<style>
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Raleway:400,500,700);


</style>
 <%-- <script type="text/javascript">
 var clicked=false;//Global Variable
 function ClickLogin()
 {
     clicked=true;
 }
            function init() {
            	
                gapi.load('auth2', function() {
                    auth2 = gapi.auth2.init({
                        client_id: '1430357134-g37k6g153rvmu7mlkib4erd0tv3edfmb.apps.googleusercontent.com',
                        fetch_basic_profile: false,
                        scope: 'profile'
                    });
                    
                    gapi.signin2.render("g-signin-btn", {
                            scope: 'email',
                            width: 200,
                            height: 50,
                            longtitle: false,
                            theme: 'dark',
                            onsuccess: onSignIn,
                            onfailure: null
                        });
                });
            }
            function onSignIn(googleUser) {
            	
            	alert('Onsign called ');
                    
                
      		  var profile = googleUser.getBasicProfile();
      		  /* console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
      		  console.log('Name: ' + profile.getName());
      		  console.log('Image URL: ' + profile.getImageUrl());
      		  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present. */
      		  document.getElementById("email-id-login").value = profile.getEmail();
      		  document.getElementById("google-login").value = "GoogleLogin";
      		  
      		  document.formLogin.submit();
                
                /* console.log("on sign in, granted scopes: " + googleUser.getGrantedScopes());
                console.log("ID token: " + googleUser.getAuthResponse().id_token);
                var profile = googleUser.getBasicProfile();
                var message = 'ID: ' + profile.getId() + "\n" 
                    + 'Name: ' + profile.getName() + "\n"
                    + 'Image URL: ' + profile.getImageUrl() + "\n"
                    + 'Email: ' + profile.getEmail();
                document.getElementById("message").value = message;
                setProfileImage(profile.getImageUrl()); */
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
        </script> --%>

    </head>
    <!-- End Head -->

    <!-- Body -->
    <body onload="init()" >
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
                                        	<ul class="dropdown-menu s-header-v2__dropdown-menu">
                                            	<li><a href="FAQs" class="s-header-v2__dropdown-menu-link -is-active">FAQ</a></li>
                                            	<li><a href="contactUs" class="s-header-v2__dropdown-menu-link">Contact Us</a></li>
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
 <!--========== PROMO BLOCK ==========-->
        <!-- <div class="js__parallax-window" style="background: url(img/1920x1080/06.jpg) 50% 0 no-repeat fixed;"> -->
         <div class="g-bg-color--dark">
            <div class="g-container--md g-text-center--xs   ">
            <br/><br/><br/>
            <!-- <div class="g-signin2 " data-onsuccess="onSignIn"  data-width="530" data-height="40" data-longtitle="true"> -->
            <!-- <div class="g-signin2 " onclick="ClickLogin()" data-onsuccess="onSignIn"  data-width="530" data-height="40" data-longtitle="true"> -->
             <!-- <div id="g-signin-btn" ></div> -->
            
            <%-- <s:form  action="newLoginAction" method="post" name="formLogin" namespace="/" autocomplete="off"  >
            <s:hidden id="email-id-login" name="emailIdLogin"></s:hidden>
            <s:hidden id="google-login" name="googleLogin"></s:hidden>
            </s:form> --%>
                <div class="g-margin-b-10--xs   ">
                    <h2 class="g-font-size-20--xs g-font-size-40--lg g-color--white g-letter-spacing--1 g-margin-t-30--xs g-margin-b-0--xs g-margin-b-10--lg"><b>FAQs</b></h2>
                    <p class="text-uppercase g-font-size-12--xs g-font-size-14--lg g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-20--xs">Your Questions. Answered.</p>
                </div>
            </div>
        </div>
        <!--========== END PROMO BLOCK ==========-->

        <!--========== PAGE CONTENT ==========-->

        <!-- Accordion -->
        <div class="s-faq g-bg-color--primary" style=" text-align: justify; height : 600px; overflow : auto;">
            <div class="container g-padding-y-25--xs">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="cbp cbp-l-grid-faq js__grid-faq">
                            <div class="cbp-item buying">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                       <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h2 class="s-faq-grid__title g-font-size-12--xs g-font-size-16--lg">What is MoneyBuddy?</h2>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            MoneyBuddy is an online wealth management platform, built in partnership with Bombay Stock Exchange (BSE).  Our customers get to benefit from the trust worth advisory service of Mr. Kamal Wadhwani, a SEBI registered investment analyst.
                                            <br>
                                            Kamal Wadhwani, CFA has an engineering degree from IIT Bombay. He started working as an international markets trader right after his engineering and has over 10 years of experience in the field of finance.
                                            <br>
                                            Walking the talk on our &quot;Honest Advice Commitment&quot;, we also help our customers earn more returns than other mutual fund platforms through investing in direct mutual funds.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item community">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h3 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">Is MoneyBuddy free?</h3>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Yes and No.  While moneyBuddy is an absolutely free platform for all mutual fund investors, our customers are expected to pay advisory fee of Mr. Kamal Wadhwani, a SEBI registered investment advisor.
                                            <br/>The fee is charged at the end of each quarter.
                                            <br/>
                                            We would like to reiterate, that our customers get to earn upto 1% extra returns due to investing in direct mutual funds. Thus as compared with other so called &#34;free investment portals&#34;, most of our users end up getting more money then they pay in advisory fee.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item buying">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">How much fee do you get from mutual fund companies?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Zero, we do not get any commission or anything else from mutual funds companies. We are very proud of our &#34;Honest Advice Commitment&#34; and have deliberately chosen to forgo any commision that would make us compromise on our &#34;Honest Advice Commitment&#34;
											
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item author">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">How do we select top performing mutual funds?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Our co-founder Mr. Kamal Wadhwani, CFA and a SEBI registered investment advisor, is the person responsible for mutual fund research. He is a signatory of CFA institute code of ethics and committed to ensuring unbiased fund selection. He focuses on following three pillars to ensure higher returns for our investors:
                                            <ol class=" g-font-size-10--xs g-font-size-14--lg">
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	<b>Large selection of funds as the starting points:</b> We have tied up with over 30 fund companies offering over 2,000 mutual fund schemes. This ensures we have access to all the funds to cherry pick the ones expected to perform better.
                                            	</li>
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	<b>Unbiased selection of funds:</b> We have deliberately decided to not take any commission from any mutual fund company. Thus Expected performance is the only criteria we look at before adding any funds to our recommended list.
                                            	</li>
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	<b>Analysis of past performance:</b> We carefully look at and analyse past performance of all the funds as part of our research. Parameters such as volatility of returns and returns for various periods from past 3 months upto 10 years are looked at before adding any fund to our recommended list.
                                            	</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item copyright">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">Do I need a Demat account to purchase mutual fund?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            No, you don&apos;t need to open a demat account for purchasing mutual funds. Just click on the following link to open your MoneyBuddy account and start investing online.
                                            <br>
                                            <a href="www.MoneyBuddy.co.in"><u>www.MoneyBuddy.co.in</u></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item author">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">Can I add nominee to my investments?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Yes, we do offer the facility to add a nominee to all your investments. Furthermore, you can also change nominee name at a later date if needed.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item account">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">Can NRI&apos;s invest through MoneyBuddy?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Yes, we welcome NRIs looking to benefit from India&apos;s economy growth rate. We offer them the flexibility to invest lumpsum in one go or invest via regular monthly SIPs. While the investment process for NRIs is also fully online, we recommend NRI investors to first contact us, for customised advise as per their country/ immigration status. 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item account">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">What are mutual funds?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Mutual funds are SEBI registered entities, which are granted government permission to collect money from different investors and hire experts to invest that money on behalf of their investors. 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item account">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">What are the risks associated with mutual funds?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Mutual funds invest your money in markets and thus money invested with mutual funds can increase or decrease depending upon market conditions.
                                            <br>
                                            However different mutual funds invest in different ways and not all mutual funds give negative returns when stock markets does badly. Following two examples will help you understand different types of funds:
                                            <ol type="a">
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	In the year 2008 low risk (Liquid mf) gave returns of 8 % and gold mutual funds were up by 25% when most equity mutual funds were down by around 30%
                                            	</li>
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	While in the year 2014 low risk (Liquid mf) gave returns of 8 % and gold mutual funds were down by 25% when most equity mutual funds were up around 30%
                                            	</li>
                                            </ol> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item account">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">Is there any lock-in on my money?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            MoneyBuddy doesn&apos;t put any restrictions and you are allowed to withdraw your money just a day after investing.
                                            <br>
                                            Tax saving funds, ELSS, are the only category of funds available on our platform, wherein investor is not allowed to withdraw in less than 3 years time.
                                            <br>
                                            However, some funds levy a small penalty of 0.25% to 1% if you withdraw your money before a specific period.  To help our investors, details of any lock in OR premature withdrawal penalty are available on the funds page before a user invests. 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item account">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">What is Systematic Investment Plan (SIP)</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            SIP is an innovative way of purchasing mutual funds. With SIP, You can invest a fixed amount every month on a specific date in a fund or multiple funds of your choice.
                                            <br>
                                            We have tied-ups with all leading banks to ensure auto-debit of your SIP amount, thus avoiding you hassles of investing every month. 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item account">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">What if I miss my Systematic Investment Plan (SIP) payment?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            We understand sometimes there can be other more pressing expenses. Thus there is no penalty on missing your SIP payment. Moreover unlike EMI&apos;s you&apos;ll not have to pay double amount in the following month either. 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item account">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">How do I withdraw my SIP investments?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            SIP investments can be withdrawn like a regular investment, Just go to your MoneyBuddy dashboard and click on withdraw button. 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="cbp cbp-l-grid-faq js__grid-faq">
                            
                            <div class="cbp-item copyright">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">What is Know Your Customer (KYC)</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            KYC is a government mandated formality for investing in mutual funds. All a user need is a PAN card and an address proof ( aadhar card or any other address proof is okay) along with a passport size photo to complete his KYC.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item copyright">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">Do I need to do KYC before investing through MoneyBuddy?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            KYC is only applicable to investors who&apos;ve never bought a mutual fund before. So if you have a demat account or have invested in mutual funds in the past, you won&apos;t need to do KYC again.
                                            <br>
                                            We have an inbuilt process to check KYC status, We recommend you to create your account and start investing.  If KYC will be needed, you will be informed accordingly. Furthermore, we have the facility to do online KYC, so you can just relax and invest without any hassles.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item copyright">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">Is my money safe?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Yes, We work with reputed Bombay stock exchange to invest your money in a safe and secure environment
                                            <br>
                                            Additionally, we&apos;ve taken following measures for extra safety:
                                            <ol>
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	Your investments are held directly under your name and are always linked to your bank account. They are independent of MoneyBuddy and can be withdrawn by directly calling the mutual fund company even if we were to ever stop functioning.
                                            	</li>
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	When you invest, money is directly transferred from your bank account to the bank account of &quot;Indian Clearing Corporation Limited&quot;.
                                            	</li>
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	When you place a withdrawal request on our platform, mutual fund company directly transfers your money to your bank account.
                                            	</li>
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	By deliberately limiting our role in handling client&apos;s funds, we have de risked client&apos;s investment from any unforeseen issues at our end.
                                            	</li>
                                            	<li class="g-color--white-opacity  g-font-size-10--xs g-font-size-14--lg">
                                            	Finally, while using internet banking, you are only allowed to pay via bank account which is registered with us. Say for example you have registered your HDFC account number ending with ***2345 with us, You&apos;ll need to enter user ID/password linked with ***2345 on the netbanking page. If you had mistakenly entered wrong account number on our website, you will not be able to make payment as you won&apos;t have the USER ID/password linked with that wrong account number
                                            	</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item buying">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">Is my data safe?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            We at MoneyBuddy are fully committed to never share or rent your data to any third party or company unless mandated by the law.
                                            <br>
                                            However we would like to clarify that we do share your details with BSE and the mutual fund company with whom you choose to invest in. We only share details that are mandatory for making mutual fund investments as mandated by SEBI guidelines.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item buying">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">I wish to change the bank account linked to my MoneyBuddy account</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            We request you to contact us, for the same.
                                            <br>
                                            Please note once you place bank account change request, you will not be able to withdraw your existing mf investments till this request is processed ( around 8-10 days ).
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item buying">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">What are liquid mutual funds?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Liquid Mutual funds are used for returning higher return on your surplus cash without getting stuck with lock-in like bank FDs.
                                            <br>
                                            They do not invest in stock markets thus they give consistent returns without ups and downs usually associated with mutual fund investing.
                                            <br>
                                            At present, a liquid fund is giving returns of around 7.5% per year and you can withdraw your money whenever your need funds without any penalty or exit load.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item buying">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">I wish to change the date of my existing SIP</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Please contact us, and we will be happy to do the needful.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item buying">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">What is Net Asset Value (NAV)?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            NAV is the price of one unit of a mutual fund. It changes on a daily basis, it can either go up or go down depending upon fund&apos;s  performance on that day.
                                            <br>
                                            Ex: If NAV of a fund is 25, investor investing Rs. 5000 will be given 200 units and someone else investing Rs. 10,000 in the same fund will be given 400 units.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item buying">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">What is a unit?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            While NAV reflects the price of mutual fund, units signifies the quantity of your mutual funds.
                                            <br>
                                            When you invest your money, you&apos;re allotted units depending upon the NAV of that day.  Until and unless you With time, your units remain the same and NAV is used to calculate the present value of your fund.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="cbp-item community">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">I do not have access to internet banking, can I invest?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            Yes, we are very happy to work with investors who don&apos;t have or don&apos;t want to use internet banking for whatever reasons. They can invest lumpsum or start SIP and use our online platform to track or redeem their investments.
                                            <br>
                                            Please contact us, for further assistance.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item account">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">I have never invested in mutual funds earlier, what should I do?</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            We welcome you to make your first mutual fund investment for as low as Rs. 1000 through our fully online platform.  Please contact us, if you want us to guide you on your first investment.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cbp-item author">
                                <div class="cbp-caption">
                                    <div class="s-faq-grid__divider cbp-caption-defaultWrap">
                                        <svg width="19" height="19" viewbox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg">
                                            <path fill="#fff" d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"/>
                                        </svg>
                                        <h4 class="s-faq-grid__title  g-font-size-12--xs g-font-size-16--lg">I like MoneyBuddy, but I am already investing in mutual funds from some other place.</h4>
                                    </div>
                                    <div class="cbp-caption-activeWrap g-font-size-10--xs g-font-size-14--lg">
                                        <div class="g-color--white-opacity">
                                            We will be happy to help you transfer all your existing investments and SIPs to our platform in a simple, convenient and tax-efficient way. You will also get to earn higher returns with direct mutual funds and benefit from the customised advice of Mr. Kamal Wadhwani, a SEBI registered investment advisor.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Accordion -->
        
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
		<script src="assets/js/index.js"></script>
		<script type="text/javascript" src="assets/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
		<script type="text/javascript" src="assets/js/components/faq.min.js"></script>

 <%-- <script>
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
