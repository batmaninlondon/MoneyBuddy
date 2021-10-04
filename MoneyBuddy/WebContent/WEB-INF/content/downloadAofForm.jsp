<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
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
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
        <script type="text/javascript" src="assets/js/jquery-latest.js"></script>
        



    </head>
    <!-- End Head -->

    <!-- Body -->
    <body>
		<!-- <div id="load" class="load"></div> -->
	<div id="content">
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
										<li id="dropdown-selector" class=" btn-group s-header-v2__nav-item dropdown">
	                                        <a href="#" class="s-header-v2__nav-link -is-active dropdown-toggle" data-toggle="dropdown" role="button" >Help<span class="caret"></span></a>
	                                    	<ul  id="dropdown-selection" class="dropdown-menu g-margin-t-o-30--xs " role="menu">
										        <li><a class="dropdown-item s-header-v2__nav-link  g-color--white" href="FAQs">FAQs</a></li>
										        <li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="contactUs">Contact Us</a></li>
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

        <!--========== PROMO BLOCK ==========-->
        <!-- <div class="js__parallax-window" style="background: url(img/1920x1080/06.jpg) 50% 0 no-repeat fixed;"> -->
         <div class="g-bg-color--dark">
         
            <div class=" g-text-center--xs g-padding-y-80--xs g-margin-l-50--lg g-margin-r-50--lg">
            <br/><br/>

	<!-- <div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:70px;">
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div> -->

	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:40px;">

	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	
	
	<div class="row g-height-auto--lg" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
		
			
			<div class="text-center row g-margin-t-15--xs">
				<div>
					<h4 class="title text-center ">Dear <s:property value="#session.customerName" />,</h4>
				</div>
			</div>
			<br/>
			
			<div id="customer-cart-list" class=" g-margin-b-30--xs g-margin-t-10--xs g-margin-r-100--xs g-margin-l-100--xs">
					
			</div>
			
				
				<p class="text-center g-font-size-20--xs"> Kindly download your Account Opening Form</p>
				<br/>
				<div class="row g-margin-t-o-20--xs">
					<div class="col-md-5"></div>
					<div class="col-md-2">
						
						<button type="button"  id="pay-now-button" class="text-center btn btn-home g-color--white g-margin-t-15--xs " 
						onClick="window.open('${pageContext.request.contextPath}/assets/AofForms/<s:property value="aofForm"/>')">
						Download AoF</button>
					</div>
					<div class="col-md-5">
					</div>
				</div> 
				<br/>
				<br/>
				<p class="text-center g-font-size-20--xs"> Please verify your details & Email the signed form to admin@MoneyBuddy.co.in</p>
				<br/>
				<p class="text-center g-font-size-20--xs"> <b>PS:</b> This is a One time process to comply with SEBI regulations</p>
				
			<br/>
	     </div>
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	
		<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:40px;">

	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	
	
            </div>
        </div>
        
        <!--========== END PROMO BLOCK ==========-->

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

       
	</div>
    </body>
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
         		<script type="text/javascript" src="assets/js/javaScript.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
	 	<script src="assets/js/jquery.js"></script>
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
     	<script src="assets/js/sly.min.js"></script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
	    <script src="assets/js/jquery.isotope.min.js"></script>
	    <script src="assets/js/main.js"></script>
	    <script src="assets/js/wow.min.js"></script>
	    <script src="assets/js/index.js"></script>
	  	<script type="text/javascript" src="assets/js/jquery-latest.js"></script>
	  	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    
    	<%-- <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.parallax.min.js"></script>
        <script type="text/javascript" src="vendor/cubeportfolio/js/jquery.cubeportfolio.min.js"></script> --%>
        <%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>

        <!-- General Components and Settings -->
        <%-- <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="js/components/faq.min.js"></script> --%>
        <!--========== END JAVASCRIPTS ==========-->
    <!-- End Body -->
</html>
