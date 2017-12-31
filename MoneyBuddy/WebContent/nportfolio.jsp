<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
    	<%
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma","no-cache");
		%>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy | Dashboard</title>
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="Megakit - HTML5 Theme">
        <meta name="author" content="keenthemes.com">

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/main.css" rel="stylesheet">
		<link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
		
        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/nmoneybuddy.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
 
    </head>
    <!-- End Head -->

    <!-- Body -->
    <body g-bg-color--dark>

        <!--========== HEADER ==========-->
        <header class="navbar-fixed-top s-header-v2 js__header-sticky">
            <!-- Navbar -->
            <nav class="s-header-v2__navbar">
                <div class="container g-display-table--lg">
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
                                <a href="nhome.jsp" class="s-header-v2__logo-link">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
                                </a>
                            </div>
                            <!-- End Logo -->
                        </div>
                        
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col--right">
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="nhome.jsp" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="nsavetax.jsp" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">About Us</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">Blog</a></li>
                                    <li class="s-header-v2__nav-item"><a href="nfaq.jsp" class="s-header-v2__nav-link">FAQs</a></li>
                                    <li class="s-header-v2__nav-item"><a href="nfaq.jsp" class="s-header-v2__nav-link">Contact Us</a></li>
                                   <!--  <li class="s-header-v2__nav-item"><a href="contacts.html" class="s-header-v2__nav-link s-header-v2__nav-link--dark">Contact Us</a></li> -->
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Sign in</a></li>
													<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Sign up</a></li>
										<%	} else 
										 	{	%>
										 			 <li class=" s-header-v2__nav-item s-header-v2__dropdown-on-hover">
                                       					 <a href="bseDashboard.jsp" class="dropdown-toggle s-header-v2__nav-link -is-active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dashboard<span class="g-font-size-10--xs g-margin-l-5--xs "></span></a>
                                    				</li>
                                    				<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Log Out</a></li>
                                    				
										<%	}	%>  
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
		
		 <div class="g-bg-color--dark" style="padding-bottom: 0.8rem" >
            <div class="g-container--md g-text-center--xs  ">
            <br/><br/><br/>
               
            </div>
        </div>
        
        
        <div class="g-bg-color--primary-ltr">
	 		<div class="container ">
	 		<div class="g-text-center--xs g-margin-b-10--xs">
                    <h3 class="g-font-size-32--xs g-font-size-50--md  g-letter-spacing--1 g-color--white text-left font-weight-bold " style="font-family:brandonText; font-weight:900; letter-spacing:-0.05em;">Your MoneyBuddy Portfolio</h3>
                </div> 
                </div> 
			</div>
		
       <!-- Counter -->
        <div style="background-color: #eeeeee">
             <div class="container ">
                <div class="row" style="padding: 10px; margin: 20px;" >
                    <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg" >
                             <span class="g-font-size-16--xs   g-margin-b-30--xs font-weight-bold " >Initial investment<br/></span>
                                <span class="g-font-size-20--xs g-font-family--playfair " style="font-family:brandonText; font-weight:900; letter-spacing:-0.0.02em">&#8377; </span>
                                <figure class="g-display-inline-block--xs g-font-size-30--xs g-font-family--brandonText  js__counter"  style="font-family:brandonText; font-weight:900; letter-spacing:-0.0.02em">500</figure>
                    </div>
                    <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                             <span class="g-font-size-16--xs   g-margin-b-30--xsfont-weight-bold " >Monthly Payment<br/></span>
                                <span class="g-font-size-20--xs g-font-family--playfair " style="font-family:brandonText; font-weight:900; letter-spacing:-0.0.02em">&#8377; </span>
                                <figure class="g-display-inline-block--xs g-font-size-30--xs g-font-family--brandonText  js__counter"  style="font-family:brandonText; font-weight:900; letter-spacing:-0.0.02em">40</figure>
                    </div>
                    <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                             <span class="g-font-size-16--xs   g-margin-b-30--xsfont-weight-bold" >Timeframe<br/></span>
                                <figure class="g-display-inline-block--xs g-font-size-30--xs g-font-family--brandonText  js__counter"  style="font-family:brandonText; font-weight:900; letter-spacing:-0.0.02em">10</figure>
                             	<span class="g-font-size-20--xs g-font-family--playfair " style="font-family:brandonText; font-weight:900; letter-spacing:-0.0.02em"> yrs</span>
                                
                    </div>
                     <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                             <span class="g-font-size-16--xs   g-margin-b-30--xsfont-weight-bold"  >Investment Style<br/></span>
                                <span class="g-font-size-30--xs g-font-family--playfair "  style="font-family:brandonText; font-weight:900; letter-spacing:-0.0.02em">Balanced </span>
                                <%-- <span class="g-display-inline-block--xs g-font-size-30--xs g-font-family--brandonText  js__counter" style="line-height: 1;">500</span> --%>
                    </div>
                    <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                             <span class="g-font-size-16--xs   g-margin-b-30--xsfont-weight-bold"   style="font-family:brandonText; font-weight:900; ">Tax Saving<br/></span>
                                <span class="g-font-size-30--xs g-font-family--playfair "  style="font-family:brandonText; font-weight:900; letter-spacing:-0.0.02em">Yes</span>
                                <%-- <span class="g-display-inline-block--xs g-font-size-30--xs g-font-family--brandonText  js__counter" style="line-height: 1;">500</span> --%>
                    </div>
                    <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                             
                    </div>
                    
                    </div>
                </div>
            </div>
        <!-- End Counter -->

		<div class="g-bg-color--white">
             <div class="container ">
                <div class="row" style="padding: 10px; margin: 20px;" >
                    <div class="col-md-2 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg" >
                       <div class="card" style="width: 20rem;">
							  <img class="card-img-top" src="img/logo.png" alt="Card image cap">
							  <div class="card-block">
							    <h4 class="card-title">Card title</h4>
							    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							  </div>
							  <ul class="list-group list-group-flush">
							    <li class="list-group-item">Cras justo odio</li>
							    <li class="list-group-item">Dapibus ac facilisis in</li>
							    <li class="list-group-item">Vestibulum at eros</li>
							  </ul>
							  <div class="card-block">
							    <a href="#" class="card-link">Card link</a>
							    <a href="#" class="card-link">Another link</a>
							  </div>
							</div>

                    </div>
                    
                    </div>
                </div>
            </div>
	


        <!--========== FOOTER ==========-->
        <footer class="g-bg-color--dark">
            <!-- Links -->
            <div class="g-hor-divider__dashed--white-opacity-lightest">
                <div class="container g-padding-y-80--xs">
                    <div class="row">
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">About</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Work</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Contact</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Twitter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Facebook</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Instagram</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">YouTube</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-40--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Subscribe to Our Newsletter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Privacy Policy</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Terms &amp; Conditions</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1 s-footer__logo g-padding-y-50--xs g-padding-y-0--md">
                            <h3 class="g-font-size-18--xs g-color--white">Megakit</h3>
                            <p class="g-color--white-opacity">We are a creative studio focusing on culture, luxury, editorial &amp; art. Somewhere between sophistication and simplicity.</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Links -->

            <!-- Copyright -->
            <div class="container g-padding-y-50--xs">
                <div class="row">
                    <div class="col-xs-6">
                        <a href="index.html">
                            <img class="g-width-100--xs g-height-auto--xs" src="img/logo.png" alt="Megakit Logo">
                        </a>
                    </div>
                    <div class="col-xs-6 g-text-right--xs">
                        <p class="g-font-size-14--xs g-margin-b-0--xs g-color--white-opacity-light"><a href="http://keenthemes.com/preview/Megakit/">Megakit</a> Theme Powered by: <a href="http://www.keenthemes.com/">KeenThemes.com</a></p>
                    </div>
                </div>
            </div>
            <!-- End Copyright -->
        </footer>
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>

        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery-ui.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>

        <!-- General Components and Settings -->
        <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        
        
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
    	<script src="assets/js/main.js"></script>
   	 <script src="assets/js/wow.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
        
        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <script type="text/javascript" src="vendor/waypoint.min.js"></script>
        <script type="text/javascript" src="vendor/counterup.min.js"></script>
        <script type="text/javascript" src="js/components/swiper.min.js"></script>
        <script type="text/javascript" src="js/components/counter.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
         <script type="text/javascript" src="js/nmoneybuddy.js"></script>
         <script src="assets/js/jquery-1.8.2.js" type="text/javascript"></script>
		 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
		 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		 
		 

    </body>
    <!-- End Body -->
</html>
