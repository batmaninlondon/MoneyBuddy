<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
    	<meta charset="utf-8"/>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	    <meta name="description" content=""/>
	    <meta name="viewport" content="width=device-width, initial-scale=1"/>
	    <title>Save Tax | Money Buddy</title>
	    <!-- core CSS -->
	    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" >
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
	 	<link type="text/css" rel="stylesheet" href="assets/css/bootstrap/font-awesome.min.css" >
	    <link type="text/css" rel="stylesheet" href="assets/css/bootstrap/animate.min.css">
	   
	    <link type="text/css" rel="stylesheet" href="assets/css/global/global.css"/>
	    <link type="text/css" rel="stylesheet" href="assets/css/style.css"/>
	    
    
        <!-- CSS -->
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
       

        <!-- Theme Styles -->
        <!-- <link href="css/global/global.css" rel="stylesheet" type="text/css"/> -->
        
       
        <!-- Vendor Styles -->
        <link type="text/css" rel="stylesheet" href="assets/css/themify.css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/scrollbar.min.css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/swiper.min.css"/>
        <link type="text/css" rel="stylesheet" href="assets/cubeportfolio/css/cubeportfolio.min.css" />

        <!-- Theme Styles -->
        <!-- Favicon -->
        <!-- <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png"> -->

    </head>

    <body>
	<div id="load" class="load"></div>
	<div id="content">
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
                                <a href="welcome" class="s-header-v2__logo-link">
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
                                    <li class="s-header-v2__nav-item"><a href="welcome" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="saveTax" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="MFexplorer"/>" class="s-header-v2__nav-link">Funds Explorer</a></li>
                                    <li class="s-header-v2__nav-item"><a href="contactUs" class="s-header-v2__nav-link">Contact Us</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
										 			<li id="dropdown-selector" class=" btn-group s-header-v2__nav-item dropdown">
				                                        <a href="#" class="s-header-v2__nav-link -is-active dropdown-toggle" data-toggle="dropdown" role="button" >List <span class="caret"></span></a>
				                                    	<ul  id="dropdown-selection" class="dropdown-menu g-margin-t-o-30--xs " role="menu">
				                                    		<li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="aboutUs">About Us</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="blog">Blog</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link  g-color--white" href="FAQs">FAQs</a></li>
													      </ul>
				                                    
				                                    </li>
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/Register</a></li>
										<%	} else 
										 	{	%>
										 			<li class="s-header-v2__nav-item"><a href="customerDashboard" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li class="s-header-v2__nav-item"><a href="<s:url action="customerCartAction"/>" class="s-header-v2__nav-link">Cart</a></li>
										 			 <li id="dropdown-selected" class=" btn-group s-header-v2__nav-item dropdown">
				                                        <a href="#" class="s-header-v2__nav-link -is-active dropdown-toggle" data-toggle="dropdown" role="button" >List <span class="caret"></span></a>
				                                    	<ul  id="dropdown-selection" class="dropdown-menu g-margin-t-o-30--xs " role="menu">
				                                    		<li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="aboutUs">About Us</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="blog">Blog</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link  g-color--white" href="FAQs">FAQs</a></li>
													      </ul>
				                                    
				                                    </li>
										 			 <li class="s-header-v2__nav-item"><a href="logOff" class="s-header-v2__nav-link">Log Out</a></li>
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
        <!--========== END HEADER ==========-->
    	
        <section class="hero-area bg-1">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-7">
	                    <div class="block">
	                        <p class="wow fadeInDown g-color--primary" data-wow-delay="0.3s" data-wow-duration=".2s" ><b>ENJOY TAX-EFFICIENT SAVINGS</b></p>
	                        <p class="wow fadeInDown g-font-size-20--xs" data-wow-delay="0.5s" data-wow-duration=".5s">Investments in ELSS qualify for tax deduction under section 80C of the income tax. You can invest into ELSS and deduct upto
	                        <span class="g-color--primary g-font-size-24--xs"> <b>Rs. 1,50,000/-</b></span> 
	                        from your taxable income to effectively reduce your tax liability.</p>
	                        <div class="wow fadeInDown" data-wow-delay="0.7s" data-wow-duration=".7s">
	                        	<a class="btn btn-home" href="<s:url action="MFexplorer"/>" " role="button">Get Started</a>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-md-5 wow zoomIn">
	                    <div class="block">
	                        <div class="counter text-center">
	                            <ul id="countdown_dashboard">
	                                    <div class="dash days_dash">
	                                        <p class="title "><span class="g-color--white">Time left before tax filing</span></p>
	                                    </div>
	                                
                                    <li>
	                                    <div class="dash days_dash">
	                                        <div class="digit">0</div>
	                                        <div class="digit">0</div>
	                                        <div class="digit">0</div>
	                                        <span class="dash_title">Days</span>
	                                    </div>
	                                </li>
	                                <li>
	                                    <div class="dash hours_dash">
	                                        <div class="digit">0</div>
	                                        <div class="digit">0</div>
	                                        <span class="dash_title">Hours</span>
	                                    </div>
	                                </li>
	                                <li>
	                                    <div class="dash minutes_dash">
	                                        <div class="digit">0</div>
	                                        <div class="digit">0</div>
	                                        <span class="dash_title">Minutes</span>
	                                    </div>
	                                </li>
	                                <li>
	                                    <div class="dash seconds_dash">
	                                        <div class="digit">0</div>
	                                        <div class="digit">0</div>
	                                        <span class="dash_title">Seconds</span>
	                                    </div>
	                                </li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
	            </div><!-- .row close -->
	        </div><!-- .container close -->
	    </section><!-- header close -->
		
        <!-- Tab -->
        <div class="container g-margin-t-o-100--xs g-margin-b-80--xs">
            <div class="row g-row-col--0">
                <div class="col-sm-6">
                    <!-- Filter -->
                    <div class="g-bg-position--center g-padding-x-30--xs g-padding-x-40--sm g-padding-y-30--xs g-padding-y-40--sm js__tab-eqaul-height-v1" style="background: url('img/970x970/04.jpg') no-repeat;">
                        <div class="g-hor-border-1__solid--primary g-padding-x-40--xs g-padding-x-50--sm g-padding-y-100--xs g-padding-y-120--sm js__filters-tabs">
                            <div data-filter=".-is-active" class="s-tab__filter-v1 g-font-family--playfair cbp-filter-item-active cbp-filter-item">
                                <span class="text-uppercase g-display-block--xs g-font-size-24--xs g-color--primary">01</span>
                               Tax Benefit
                            </div>
                            <div data-filter=".service" class="s-tab__filter-v1 g-font-family--playfair cbp-filter-item">
                                <span class="text-uppercase g-display-block--xs g-font-size-24--xs g-color--primary">02</span>
                                Lock in period
                            </div>
                            <div data-filter=".pages" class="s-tab__filter-v1 g-font-family--playfair cbp-filter-item">
                                <span class="text-uppercase g-display-block--xs g-font-size-24--xs g-color--primary">03</span>
                               Long term value growth
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Filter -->

                <!-- Grid -->
                <div class="col-sm-6">
                    <div class="g-bg-color--white g-box-shadow__dark-lightest-v2 g-padding-x-30--xs g-padding-x-60--sm g-padding-y-60--xs g-padding-y-80--sm js__tab-eqaul-height-v1">
                        <div class="cbp js__grid-tabs">
                            <div class="s-tab__grid-v1-item cbp-item -is-active">
                                <div class="g-margin-b-20--xs">
                                    <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-25--xs">Tax Benefit</p>
                                    <h2 class="g-font-size-32--xs g-font-family--playfair">How your can reduce your tax obligations</h2>
                                </div>
                                <p>One of the primary reasons to invest in ELSS is to save tax. Investments in ELSS qualify for tax deduction under section 80C of the income tax act of 1961. But any dividend or long term capital gain earned by the investor is exempted from income tax. </p>
                                <p>Simply, your returns from ELSS become tax free. Government of India also provides tax rebate for equity linked saving schemes (ELSS) u/s 80C of Income Tax Act 1961. You can invest into ELSS and deduct upto Rs. 1,50,000/- from your taxable income to effectively reduce your tax liability.</p>
                            </div>
                            <div class="s-tab__grid-v1-item cbp-item service">  
                                <div class="g-margin-b-20--xs">
                                    <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-25--xs">
                                    <span style="text-align: left;">Lock in period</span></p>
                                    <h2 class="g-font-size-32--xs g-font-family--playfair">Simulate inculcate saving habit</h2>
                                </div>
                                <p>Pertaining to the performance of the mutual funds, good mutual fund portfolios are constructed for long term investments, however, they are not bound with the lock in periods. But in case of ELSS, the funds are locked in for at least 3 years.</p>
                                <p>Which means, in ELSS fund you are obligated to stay invested for 3 years or more to exempt from taxes applicable on returns. This forcefully embeds a good habit to stay invested for a longer period.</p>
                            </div>
                            <div class="s-tab__grid-v1-item cbp-item pages">
                                <div class="g-margin-b-20--xs">
                                    <p class="text-left g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-25--xs">Long term value growth</p>
                                    <h2 class="g-font-size-32--xs g-font-family--playfair">Equity invested funds</h2>
                                </div>
                                <p>Although, the lock in period for ELSS is 3 years, you can allow the continuous growth of your fund for longer or redeem after 3 years. Inherently, equity investments are subject to market risk. </p>
                                <p>But since these funds invest your money in equity, you possess chances of higher returns with tax exemption.</p>
                            </div>
                        </div> 
                    </div>
                    <!-- End Grid -->
                </div>
            </div>
        </div>
        <!-- End Tab -->
        
        <!--========== FOOTER ==========-->
        <footer class="g-bg-color--dark">
            <!-- Links -->
            <div class="g-hor-divider__dashed--white-opacity-lightest">
                <div class="container g-padding-y-80--xs">
                    <div class="row">
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="welcome">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="saveTax">Save Tax</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="allFunds">Funds Explorer</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="FAQs">Help</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://twitter.com/MoneyBuddyIndia">Twitter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.facebook.com/MoneyBuddyIndia">Facebook</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.linkedin.com/in/money-buddy-94a73814a/">Linkedin</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.YouTube.com/MoneyBuddy">YouTube</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-40--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="terms.jsp">Terms &amp; Conditions</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="policy.jsp">Privacy Policy</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1 s-footer__logo g-padding-y-50--xs g-padding-y-0--md">
                             <h3 class="g-font-size-18--xs g-color--white">MoneyBuddy</h3>
                            <p class="g-color--white-opacity">
                            No complicated jargon, no daunting fees, just straightforward, effortless investing.</p>
                        </div>
                    </div>
                    <div class="row  g-font-size-12--xs g-color--white">
                    <br/>
                    	 Mutual fund investments are subject to market risks. Please read the scheme information and other related documents carefully before investing.
						<br/>Past performance is not indicative of future returns. Please consider your specific investment requirements, risk tolerance, investment goal, time frame, risk and reward balance and the cost associated with the investment before choosing a fund, or designing a portfolio that suits your needs.
                    </div>
                </div>
            </div>
            <!-- End Links -->

            <!-- Copyright -->
            <div class="container g-padding-y-50--xs">
                <div class="row">
                    <div class="col-xs-6">
                        <a href="index.html">
                            <img class="g-width-100--xs g-height-auto--xs" src="img/logo-white.png" alt="MoneyBuddy Logo">
                        </a>
                    </div>
                     <div class="col-sm-6 g-text-right--xs g-color--white">
                    &copy; 2018 <a href="#" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
                </div>
                </div>
            </div>
            <!-- End Copyright -->
        </footer>
        <!--========== END FOOTER ==========-->
    	
    	 <!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>
   </div>
    </body>
       <!-- Js -->
        <script src="js/vendor/jquery-2.1.1.min.js"></script>
        <script src="js/jquery.lwtCountdown-1.0.js"></script>
        <script src="js/jquery.nav.js"></script>
        <script src="js/wow.min.js"></script>
    	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>

        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
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
        <script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="assets/js/swiper.jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/waypoint.min.js"></script>
        <script type="text/javascript" src="assets/js/counterup.min.js"></script>
        <script type="text/javascript" src="assets/js/cubeportfolio/jquery.cubeportfolio.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.parallax.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.equal-height.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.wow.min.js"></script>

        <!-- General Components and Settings -->
        <script type="text/javascript" src="assets/js/global.min.js"></script>
        <script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
        <script type="text/javascript" src="assets/js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="assets/js/swiper.min.js"></script>
        <script type="text/javascript" src="assets/js/counter.min.js"></script>
        <script type="text/javascript" src="assets/js/components/parallax.min.js"></script>
        <script type="text/javascript" src="assets/js/tab.min.js"></script>
        <script type="text/javascript" src="assets/js/components/equal-height.min.js"></script>
        <script type="text/javascript" src="assets/js/wow.min.js"></script>
        <script type="text/javascript" src="assets/js/owl.carousel.js"></script>
        <script type="text/javascript" src="assets/js/main.js"></script>
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
        <%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
        <!--========== END JAVASCRIPTS ==========-->
</html>
