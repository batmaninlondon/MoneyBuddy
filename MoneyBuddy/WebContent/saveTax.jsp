<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
    	<meta charset="utf-8"/>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	    <meta name="description" content=""/>
	    <meta name="viewport" content="width=device-width, initial-scale=1"/>
	    <title>Save Tax | Money Buddy</title>
	    <meta http-equiv="Cache-control" content="max-age=2592000, public">
	    <!-- core CSS -->
	    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" >
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
	 	<!-- <link type="text/css" rel="stylesheet" href="assets/css/bootstrap/font-awesome.min.css" > -->
	 	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
	    <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/animate.min.css">
	   <link type="text/css" rel="stylesheet" href="assets/css/themify/themify.css"/>
	   
	    <link type="text/css" rel="stylesheet" href="assets/css/global/global.css"/>
	    <link type="text/css" rel="stylesheet" href="assets/css/style.css"/>
	    <link type="text/css" rel="stylesheet" href="assets/css/style2.css"/>
	    
    
        <!-- CSS -->
        
       

        <!-- Theme Styles -->
        <!-- <link href="css/global/global.css" rel="stylesheet" type="text/css"/> -->
        
       
        <!-- Vendor Styles -->
        
        <link type="text/css" rel="stylesheet" href="assets/css/scrollbar.min.css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/swiper.min.css"/>
        <link type="text/css" rel="stylesheet" href="assets/cubeportfolio/css/cubeportfolio.min.css" />

    </head>

    <body>
	<!-- <div id="load" class="load"></div> -->
	<div id="content">
    <!--========== HEADER ==========-->
                <header class="navbar-fixed-top s-header-v2 js__header-sticky">
            <!-- Navbar -->
            <nav class="s-header-v2__navbar">
                <div class="g-padding-l-40-md g-padding-l-80-lg g-display-table--lg">
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
                                    <!-- <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo"> -->
                                </a>
                            </div>
                            <!-- End Logo -->
                        </div>
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col-width--180"></div>
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col--right " >
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="welcome" class="s-header-v2__nav-link">Home</a></li>
                                    <!-- <li class="s-header-v2__nav-item"><a href="Fees" class="s-header-v2__nav-link">Fees</a></li> -->
                                    <li class="s-header-v2__nav-item"><a href="saveTax" class="s-header-v2__nav-link -is-active">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="MFexplorer"/>" class="s-header-v2__nav-link">Funds Explorer</a></li>
                                    <!-- <li class="s-header-v2__nav-item"><a href="aboutUs" class="s-header-v2__nav-link">About Us</a></li> -->
                                    <li class="s-header-v2__nav-item"><a href="https://medium.com/@moneybuddyIndia" class="s-header-v2__nav-link">Blog</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/SignUp</a></li>
										<%	} else 
										 	{	%>
										 			<li class="s-header-v2__nav-item"><a href="<s:url action="Dashboard"/>" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <%-- <li class="s-header-v2__nav-item"><a href="<s:url action="Cart"/>" class="s-header-v2__nav-link">Cart</a></li> --%>
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
                                        	<a href="javascript:void(0);" class="dropdown-toggle s-header-v2__nav-link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Help <span class="g-font-size-10--xs g-margin-l-5--xs ti-angle-down"></span></a>
                                        	<ul class="dropdown-menu s-header-v2__dropdown-menu"  style="min-width: 60px;">
                                            	<li><a href="FAQs" class="s-header-v2__dropdown-menu-link">FAQ</a></li>
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
        <!--========== END HEADER ==========-->
    	
        <section class="hero-area bg-1">
	        <div class="container g-margin-t-100--xs g-margin-t-o-230--md">
	        <div class="row  ">
	        	<div class="col-xs-12 col-md-7">
	        		<div class="block ">
	                        <p class="wow fadeInDown g-color--primary" data-wow-delay="0.3s" data-wow-duration=".2s" ><b>ENJOY TAX-EFFICIENT SAVINGS</b></p><br/>
	                        <p class="wow fadeInDown g-font-size-14--xs g-font-size-20--md" data-wow-delay="0.5s" data-wow-duration=".5s">Did you Know? ELSS funds are the best way to create wealth and save income tax; Invest upto  
	                        <span class="g-color--primary g-font-size-16--xs g-font-size-24--md"> <b>Rs. 150,000</b></span> 
	                         in our top performing ELSS funds and save tax upto 
	                        <span class="g-color--primary g-font-size-16--xs g-font-size-24--md"> <b>Rs. 46,350</b></span> </p>
	                        <div class="wow fadeInDown" data-wow-delay="0.7s" data-wow-duration=".7s">
	                        	<a class="btn btn-home" href="<s:url action="MFexplorer"/>" role="button">Get Started</a>
	                        </div>
	                    </div>
	        	</div>
	        	<div class="col-xs-12 col-md-5 g-margin-t-40--xs g-margin-t-0--md">
	        		<div class="block">
	                        <div class="counter text-center">
	                            
                                   <div class="dash days_dash">
                                       <p class="title "><span class="g-color--white">Use it or lose it</span></p>
                                        <p class="  g-font-size-14--xs  "><span class="g-color--white">Use your income tax allowance by 31st March 2020, or lose it forever.</span></p>
                                        <br/>
                                   </div>
	                                <ul id="countdown_dashboard">
                                    <li>
	                                    <div class="dash days_dash">
	                                        <span class="digit g-font-size-10--xs g-font-size-20--md">0</span>
	                                        <span class="digit g-font-size-10--xs g-font-size-20--md">0</span>
	                                        <span class="digit g-font-size-10--xs g-font-size-20--md">0</span>
	                                        <span class="dash_title g-font-size-10--xs g-font-size-20--md">Days</span>
	                                    </div>
	                                </li>
	                                <li>
	                                    <div class="dash hours_dash">
	                                        <span class="digit g-font-size-10--xs g-font-size-20--md">0</span>
	                                        <span class="digit g-font-size-10--xs g-font-size-20--md">0</span>
	                                        <span class="dash_title g-font-size-10--xs g-font-size-20--md">Hours</span>
	                                    </div>
	                                </li>
	                                <li>
	                                    <div class="dash minutes_dash">
	                                        <span class="digit g-font-size-10--xs g-font-size-20--md">0</span>
	                                        <span class="digit g-font-size-10--xs g-font-size-20--md">0</span>
	                                        <span class="dash_title g-font-size-10--xs g-font-size-20--md">Minutes</span>
	                                    </div>
	                                </li>
	                                <li>
	                                    <div class="dash seconds_dash">
	                                        <span class="digit g-font-size-10--xs g-font-size-20--md">0</span>
	                                        <span class="digit g-font-size-10--xs g-font-size-20--md">0</span>
	                                        <span class="dash_title g-font-size-10--xs g-font-size-20--md">Seconds</span>
	                                    </div>
	                                </li>
	                            </ul>
	                            </div>
	                            </div>
	        	</div>
	        </div>
	            
	        </div><!-- .container close -->
	    </section><!-- header close -->
		
        <!-- Tab -->
        <div class="container  g-margin-t-o-230--md g-margin-b-10--xs g-margin-b-80--md">
            <div class="row g-row-col--0">
                <div class="col-xs-6 col-sm-6">
                    <!-- Filter -->
                    <div class="g-bg-position--center g-padding-x-30--xs g-padding-x-40--sm g-padding-y-30--xs g-padding-y-40--sm js__tab-eqaul-height-v1" style="background: url('img/970x970/04.jpg') no-repeat;">
                        <div class="g-hor-border-1__solid--primary g-padding-x-10--xs g-padding-x-50--md g-padding-y-40--xs g-padding-y-120--md js__filters-tabs">
                            <div data-filter=".-is-active" class="s-tab__filter-v1 g-font-family--playfair cbp-filter-item-active cbp-filter-item">
                                <span class="text-uppercase g-display-block--xs g-font-size-18--xs g-font-size-24--md g-color--primary">01</span>
                               <p class="g-font-size-18--xs g-font-size-24--md g-color--primary">Save tax upto Rs. 46,350</p>
                            </div>
                            <div data-filter=".service" class="s-tab__filter-v1 g-font-family--playfair cbp-filter-item">
                                <span class="text-uppercase g-display-block--xs g-font-size-18--xs g-font-size-24--md g-color--primary">02</span>
                                <p class="g-font-size-18--xs g-font-size-24--md g-color--primary">Lock in period of 3 years vs 15 years for PPF</p>
                            </div>
                            <div data-filter=".pages" class="s-tab__filter-v1 g-font-family--playfair cbp-filter-item">
                                <span class="text-uppercase g-display-block--xs g-font-size-18--xs g-font-size-24--md g-color--primary">03</span>
                               <p class="g-font-size-18--xs g-font-size-24--md g-color--primary">Avg 3 year returns of 15% vs 8.5% for PPF</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Filter -->

                <!-- Grid -->
                <div class="col-xs-6 col-sm-6">
                    <div class="g-bg-color--white g-box-shadow__dark-lightest-v2 g-padding-x-10--xs g-padding-x-60--sm g-padding-y-60--xs g-padding-y-80--sm js__tab-eqaul-height-v1">
                        <div class="cbp js__grid-tabs">
                            <div class="s-tab__grid-v1-item cbp-item -is-active">
                                <div class="g-margin-b-20--xs">
                                    <!-- <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-25--xs">Save tax upto Rs. 46,350</p> -->
                                    <h2 class="g-font-size-18--xs g-font-size-32--md g-font-family--playfair">Save tax upto Rs. 46,350</h2>
                                </div>
                                <p class="g-font-size-14--xs g-font-size-16--md">With MoneyBuddy, You can invest in ELSS funds online and submit receipt to your office next day itself, this will help reduce your TDS burden and your cash in hand will increase.</p>
                                <br/>
                                <p class="g-font-size-14--xs g-font-size-16--md">If you've missed your office deadline, you should still invest in ELSS funds before 31st March 2020. You can submit the investment proof while filing income tax in June 2020 and claim the refund for excess tax paid.</p>
                            </div>
                            <div class="s-tab__grid-v1-item cbp-item service">  
                                <div class="g-margin-b-20--xs">
                                    <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-25--xs">
                                    <%-- <span style="text-align: left;">Lock in period of 3 yrs vs 15 yrs for PPF</span></p> --%>
                                    <h2 class="g-font-size-18--xs g-font-size-32--md g-font-family--playfair text-left">Lock in period of 3 years vs 15 years for PPF</h2>
                                </div>
                                <p class="g-font-size-14--xs g-font-size-16--md text-left">Pertaining to the performance of the mutual funds, good mutual fund portfolios are constructed for long term investments, however, they are not bound with the lock in periods. But in case of ELSS, the funds are locked in for at least 3 years.</p>
                                <br/>
                                <p class="g-font-size-14--xs g-font-size-16--md text-left">Which means, in ELSS fund you are obligated to stay invested for 3 years or more to exempt from taxes applicable on returns. This forcefully embeds a good habit to stay invested for a longer period.</p>
                            </div>
                            <div class="s-tab__grid-v1-item cbp-item pages">
                                <div class="g-margin-b-20--xs">
                                    <!-- <p class="text-left g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-25--xs">Avg 3 yr returns of 15% vs 8.5% for PPF</p> -->
                                    <h2 class="g-font-size-18--xs g-font-size-32--md g-font-family--playfair">Avg 3 year returns of 15% vs 8.5% for PPF</h2>
                                </div>
                                <p class="g-font-size-14--xs g-font-size-16--md">Although, the lock in period for ELSS is 3 years, you can allow the continuous growth of your fund for longer or redeem after 3 years. Inherently, equity investments are subject to market risk. </p>
                                <br/>
                                <p class="g-font-size-14--xs g-font-size-16--md">But since these funds invest your money in equity, you possess chances of higher returns with tax exemption.</p>
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
   </div>
    </body>
       <!-- Js -->
        <script src="assets/js/vendor/jquery-2.1.1.min.js"></script>
        <script src="assets/js/jquery.lwtCountdown-1.0.js"></script>
        <script src="assets/js/jquery.nav.js"></script>
        <script src="assets/js/wow.min.js"></script>
    	<script src="assets/js/jquery.validate.js"></script>

        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
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
         
        <script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
        <script type="text/javascript" src="assets/js/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="assets/js/swiper.jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/waypoint.min.js"></script>
        <script type="text/javascript" src="assets/js/components/counter.min.js"></script>
        <script type="text/javascript" src="assets/js/counterup.min.js"></script>
        <script type="text/javascript" src="assets/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.parallax.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.equal-height.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.wow.min.js"></script>

        <!-- General Components and Settings -->
        <script type="text/javascript" src="assets/js/global.min.js"></script>
        
        <script type="text/javascript" src="assets/js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="assets/js/swiper.min.js"></script>
        
        
        <script type="text/javascript" src="assets/js/components/parallax.min.js"></script>
        <script type="text/javascript" src="assets/js/tab.min.js"></script>
        <script type="text/javascript" src="assets/js/components/equal-height.min.js"></script>
        <script type="text/javascript" src="assets/js/wow.min.js"></script>
        <script type="text/javascript" src="assets/js/owl.carousel.js"></script>
        <script type="text/javascript" src="assets/js/main2.js"></script>
        
        <%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
        <!--========== END JAVASCRIPTS ==========-->
</html>
