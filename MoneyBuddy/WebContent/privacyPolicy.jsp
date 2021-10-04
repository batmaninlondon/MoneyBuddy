<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy - Privacy Policy</title>
		<meta http-equiv="Cache-control" content="max-age=2592000, public">
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <!-- <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet"> -->
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		
        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>

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
                <div class="g-margin-b-10--xs">
                    <div  id="contents" class="row" style="padding: 0px;" >
	              		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-40--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
	              			<div class="g-text-center--xs g-margin-b-40--xs">
	                    		
	                    		<div class="g-color--text g-font-family--playfair g-letter-spacing--1" style=" text-align: justify; height : 500px; overflow : auto;" >
	                    			
	                    			<ul>
	                    			<li>
			                    		<p class="g-font-size-17--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs">
			                    			<b>Brief Overview</b>
		                    			</p>
		                    			<p>
		                    			Your privacy is very important to us. So we've developed a well defined Privacy Policy that covers how we collect, use, disclose, and store your personal information. Please take a moment to read through this policy and let us know if you have any questions.
										</p>
										<p>
										By visiting <a href="www.MoneyBuddy.co.in"><u>www.MoneyBuddy.co.in</u></a> operated by Mr. Kamal Wadhwani, SEBI registered investment advisor ( registration number INA000013581 ) or by working with his advisory service in any other way, you are accepting this policy. 
										</p>
									</li>
                    				<li>
                    					<p class="g-font-size-17--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs">
		                    				<b>What data we collect and Why?</b>
	                    				</p>
	                    				<p>
		                    			We would like to reiterate that MoneyBuddy and it&apos;s affiliated entities are involved in the business of providing financial services and products to its customers. 
										</p>
										<p>
										We are not in the business of hoarding and selling or renting user data to any third party. Thus any data we ask you for or collect is for either of the two reasons only: 
										</p>
										<ol >
											<li>
												Information is needed for processing your mutual fund investments:
												<ol>
													<li type="a">This includes information like your name, date or birth, address, Pan card, bank account details etc</li>
												</ol>
											</li>
											<li>
												Information is needed for improving your investing experience:
												<ol>
													<li type="a">This includes information like your age, gender, life stage, IP address, details of purchase/ redemptions of mutual funds  etc</li>
												</ol>
											</li>
										</ol>
									</li>
									<li>
			                    		<p class="g-font-size-17--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs">
			                    			<b>What do we do with your data?</b>
		                    			</p>
		                    			<p>
		                    			We need your PAN card number to check your KYC status as per the SEBI guidelines. Your PAN card number is shared with NSDL KRA (<a href="https://kra.ndml.in">https://kra.ndml.in</a>) for this purpose. NSDL is one of the five organizations approved by SEBI for verifying KYC status of the user. 
										</p>
										<p>
										We share your personal information like name, pan card number, email ID, phone number, bank details, KYC status etc with Bombay Stock Exchange (BSE) for processing your mutual fund investments. This information is mandatory as per the SEBI regulations and also enhances the safety and security of your investment.  
										</p>
										<p>
										We share your personal information with all the mutual fund companies where you chose to invest in. This is necessary as they store your investments directly under your name using these details. Moreover these details are mandatory as per the SEBI regulation.
										</p>
										<p>
										We use Amazon Web Services (AWS) servers to host all user data. AWS data centers undergo annual certifications to ensure they meet the highest standards of physical and virtual security. 
										</p>
										<p>
										We store details of all your investments, redemptions, SIPs etc to help you visualise all your investments in one place and place withdrawal or any other request wrt your investments.
										</p>
										<p>
										Along with the above-mentioned situations, we use your data for various other uses such as helping you chose funds as per your needs, computing your tax burden, improve your user experience by storing cookies etc.
										</p>
										<p>
										Finally, we would like to reiterate that we do not sell, distribute or lease your personal information to third parties unless we are required to share such information under the terms and conditions of the products and services you avail, or we are required to do so by law.
										</p>
									</li>
									<li>
			                    		<p class="g-font-size-17--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs">
			                    			<b>Security of your data</b>
		                    			</p>
		                    			<p>
		                    			We are fully committed to ensuring the safety and security of your data. We follow a three-stage strategy to achieve that goal.
										</p>
										<ol>
											<li >
												By collecting the least amount of data/ information needed for a smooth investing experience
											</li>
											<li>
												By using bank-grade security/ encryptions to store all your data
											</li>
											<li>
												By not sharing your data with any third party unless mandated by law or the terms and conditions of product that you have invested in
											</li>
										</ol>
									</li>
									<li>
			                    		<p class="g-font-size-17--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs">
			                    			<b>Correcting your personal information</b>
		                    			</p>
		                    			<p>
		                    			We encourage you to verify all your personal information carefully. Providing and ensuring correct information is used for processing your investments is your responsibility. Please contact us immediately if you notice any incorrect information or would like to change any information that we have in store.
										</p>
									</li>
									<li>
			                    		<p class="g-font-size-17--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs">
			                    			<b>Links to other websites</b>
		                    			</p>
		                    			<p>
		                    			Our website may have links to other websites of interest. Once you use any such link to leave our website, we will not have any control or responsibility for any information that you may share with such websites.
										</p>
									</li>
									<li>
			                    		<p class="g-font-size-17--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs">
			                    			<b>Questions on our Privacy Policy?</b>
		                    			</p>
		                    			<p>
		                    			Please contact us immediately, If you have any questions or concerns on how we use your data.
										</p>
										<p>
										<b><u>Please Note:</u></b> Our Privacy Policy is subject to change without further notice. Users are requested to refer to the latest version available on our website for up to date information.
										</p>
									</li>
                    			</ul>
	                    			
	                    			
	                    			
	                    			
	                    			
	                    			
	                    			
	                    			
	                    			
	                    			
	                    			
	                    			
	                    		</div>
	                    		
	                    		
	                    		
	                		</div>
	                	</div> 
	                
	                	
	                
	             </div>
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
		<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
		<script src="assets/js/jquery.js"></script>
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    
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
