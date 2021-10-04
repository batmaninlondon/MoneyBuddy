<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Blog | Money Buddy</title>
   	<meta http-equiv="Cache-control" content="max-age=2592000, public">
   	<!-- core CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" >
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
    <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    


</head>

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
                                        	<a href="javascript:void(0);" class="dropdown-toggle s-header-v2__nav-link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Help <span class="g-font-size-10--xs g-margin-l-5--xs ti-angle-down"></span></a>
                                        	<ul class="dropdown-menu s-header-v2__dropdown-menu">
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
        
        <div class="g-bg-color--dark">
            <div class="container g-padding-y-45--xs">
            </div>
        </div>


 <section id="blog" class="container g-margin-b-40--xs " >
	<h1 class="g-font-size-15--xs g-font-size-25--sm g-font-size-30--lg  g-color--primary  g-margin-t-20--xs">Blogs</h1>

        <div class="blog">
            <div class="row">
                 <div class="col-md-10">
                    <div class="blog-item">
                        <div class="row">
                            <div class="col-xs-12 col-sm-2 text-center">
                                <div class="entry-meta">
                                    <span id="publish_date">07  NOV</span>
                                    <span><i class="fa fa-user"></i> <a href="#">Kamal Wadhwani</a></span>
                                </div>
                            </div>
                                
                            <div class="col-xs-12 col-sm-10 ">
                                <a href="#"><img class="img-responsive img-blog" src="images/blog/blog1.jpg" width="100%" alt="" /></a>
                                <h2><a href="blog-item.html">Why to be a part of MoneyBuddy family?</a></h2>
                                <p class="g-font-size-14--xs g-font-size-10--sm g-font-size-16--lg   g-margin-t-20--xs" style="text-align: justify;">
                                Wealth creation is as much about saving as it's about growing those savings in a tax efficient manner. We understand there's a limit to how much an individual can save in today's high cost of living environment thus we pay special attention to growing our customer's money in a risk adjusted and tax efficient way.

Following are the key features enjoyed by the members of MoneyBuddy family.

Superior fund selection There are over 1,000 mutual funds in India, We do a lot of data crunching to find funds that are expected to perform better than their peers.
Income Tax optimisation Special attention is paid to the current income tax status of our customers and funds are recommend according to the unique needs of our customers. We've also created algorithm to ensure you pay the least (if any) income tax if and when you withdraw your money and profits.
Easy Liquidity You can withdraw all or part of your money as and when you want; Your bank account will be credited in the next 2-3 working days
Online portfolio tracking You can track the value of your portfolio 24*7 by logging into our website. You can also track the performance of individual funds in your portfolio as well.
Secure and Automated Once your investment planning is complete, everything else is taken care via automated softwares. We use the most secure payment gateway and do the periodic audit of our software to ensure the security of your data.
Impeccable team Customer advisory and fund selection is done by our founder Mr. Kamal Wadhwani himself. He has around 10 years of experience in Indian and International financial markets. He completed his engineering from IIT Bombay and is pursuing CFA, USA.
                                
                                
                                </p>
                                <a class="s-btn s-btn--md g-bg-color--primary  g-color--white" href="https://medium.com/@moneybuddyIndia">Read More <i class="fa fa-angle-right"></i></a>
                            </div>
                        </div>    
                    </div>
                    
<%-- Savita Wadhwani - Commented this section for bse testing - Start --%>
                        
                    <!-- <div class="blog-item">
                        <div class="row">
                             <div class="col-sm-2 text-center">
                                <div class="entry-meta"> 
                                    <span id="publish_date">07  NOV</span>
                                    <span><i class="fa fa-user"></i> <a href="#">John Doe</a></span>
                                </div>
                            </div>
                             <div class="col-xs-12 col-sm-10 blog-content">
                                <a href="#"><img class="img-responsive img-blog" src="images/blog/blog1.jpg" width="100%" alt="" /></a>
                                <h2><a href="blog-item.html">Happy New Tax Year!</a></h2>
                                <h3>6th April each year heralds a brand-new tax year in the UK, meaning a brand new tax-free ISA allowance for you to use in any way you see fit. But, with all the new types of ISA now available to choose from, deciding how to use your limit can be a bit of a minefield. Hereâs what you need to know.

 

Your personal tax-free ISA allowance has increased from this year to Â£20,000, up from Â£15,240 last year, so make the most of it, if you can.
 

With the introduction of the Lifetime ISA this year, there are now four main types of ISA for those over 18 â a cash ISA, Investment ISA, Innovative Finance ISA and Lifetime ISA.
 

The Innovative Finance ISA is a tax-efficient wrapper for people using Peer to Peer lending platforms.
 

The Lifetime ISA is designed specifically for people between 18- 40 to help them buy their first home, or save for retirement. Wealthify will be offering Lifetime ISAs later in 2017.
 

Under the current rules, you can only open one of each of the four types of ISA per tax year, but you can split your Â£20,000 annual tax-free ISA allowance between them. The maximum you can put in a Lifetime ISA is Â£4,000.
 

If you want to use some of your 2017/18 ISA allowance to open a Wealthify investment ISA, you can do as long as you are over 18, are a UK tax resident, and youâve not opened another Investment ISA in the current tax year.
 

If youâre planning on using some of your Â£20,000 tax-free allowance to open a stocks & shares ISA this tax year, donât wait until just before the ISA deadline in April to do it, if you can help it. It may seem obvious, but by delaying, your money is missing out on almost 12 months of potentially good stock market growth. And if itâs in a cash savings account or your bank account in the meantime, itâs unlikely to be enjoying an inflation-beating interest rate either. Even if you can only manage to save small amounts at the beginning of the tax year, the earlier you start investing the better, as youâll benefit from the power of compound interest, where you earn interest on your interest (or dividends). It can build up surprisingly fast and give you a solid head-start on your long-term savings goals.

 

If you have any questions about the 2017/18 ISA allowance, you can contact us on 0800 802 1800 or by Live Chat.

The tax treatment depends on your individual circumstances and maybe subject to change in the future.

Please remember that the value of your investments can go down as well as up and you can get back less than invested.

If you're unsure which ISA types is suitable for you, please seek financial advice.</h3>
                                <a class="btn btn-primary readmore" href="blog-item.html">Read More <i class="fa fa-angle-right"></i></a>
                            </div>
                        </div>    
                    </div>/.blog-item -->
                    
<%-- Savita Wadhwani - Commented this section for bse testing - End --%>
                        
                </div><!--/.col-md-8-->

                
            </div><!--/.row-->
        </div>
    </section><!--/#blog-->

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
		<!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>
        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
       <%--  <script>
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
		<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
 		<script src="assets/js/jquery.js"></script>
    	<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
</html>