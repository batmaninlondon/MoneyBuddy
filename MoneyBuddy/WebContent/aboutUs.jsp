
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>About Us | Money Buddy</title>
    <!-- core CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" >
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >

    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
</head>
<body>
	<div id="load" class="load"></div>
	<div id="content">
    <!--========== HEADER ==========-->
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
                                    <li class="s-header-v2__nav-item"><a href="aboutUs" class="s-header-v2__nav-link">About Us</a></li>
                                    <li class="s-header-v2__nav-item"><a href="blog" class="s-header-v2__nav-link">Blog</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/Register</a></li>
										<%	} else 
										 	{	%>
										 			<li class="s-header-v2__nav-item"><a href="customerDashboard" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li class="s-header-v2__nav-item"><a href="<s:url action="customerCartAction"/>" class="s-header-v2__nav-link">Cart</a></li>
										 			 <li class="s-header-v2__nav-item"><a href="logOff" class="s-header-v2__nav-link">Log Out</a></li>
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
        
        <div class="g-bg-color--dark">
            <div class="container g-padding-y-45--xs">
            </div>
        </div>
        
 			<section id="about-us" class="g-margin-b-30--xs">
        <div class="container">
			<div class="g-margin-t-15--xs wow fadeInDown">
				<h2 ><b>Who we are</b></h2>
				<p >
					We are a bootstrap startup, helping people improve their financial status through better planning and investing.
				</p>
				<p >
					We offer our customers the convenience of fully secure and online investing, tracking and redemption facility. Yet we pride ourselves on not being a tech first company instead capitalising our efforts on growing our investors wealth through disciplined investing and superior fund selection by leveraging behavioral finance and our deep understanding of markets.
				</p>
				<p>
					We are registered with Association of Mutual Funds in India (AMFI), regulatory body responsible for granting license to financial distributors like us. Additionally, we work with Bombay Stock Exchange (BSE) to ensure safe and secure transactions for our customers.
				</p>
			</div>
			
			<div class=" wow fadeInDown">
				<h2><b>Our Vision</b></h2>
				<p > 
					To ensure everyone has access to the right financial advice and tools required to ensure financial well being of their loved ones.
				</p>
			</div>
			
			<div class=" wow fadeInDown">
				<h2><b>Our Mission</b></h2>
				<p > 
					To make a genuine positive impact, however small, in the life of each and every user.
				</p>
			</div>
			
			<!-- our-team -->
			<div class="team" class="left">
				<div class="left wow fadeInDown">
					<h2><b>Our Team</b></h2>
					<p >
						We are run by a small team of three individuals with complimentary skills and common mission. Together, we aim to build an ethical company with zero tolerance for any mis-selling of investment products. Instead the company should thrive by keeping it&apos;s costs low and by providing quality service at a reasonable price.
					</p>
				</div>
				<div class="row clearfix">
					<div class="col-md-4 col-sm-6">	
						<div class="single-profile-top wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
							<div class="media">
								<div class="pull-left">
									<a href="#"><img class="media-object" src="images/Kamal.jpg" alt=""></a>
								</div>
								<div class="media-body">
									<h5>Kamal Wadhwani</h5>
									<h6>Co-Founder and CEO</h6>
									<ul class="tag clearfix">
										<li class="btn"><a href="#">Investment</a></li>
										<li class="btn"><a href="#">Tax</a></li>
										<li class="btn"><a href="#">Growth</a></li>
									</ul>
									
									<ul class="social_icons">
										<li><a href="#"><i class="fa fa-facebook"></i></a></li>
										<li><a href="#"><i class="fa fa-twitter"></i></a></li> 	
										<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
									</ul>
								</div>
							</div><!--/.media -->
							<p>Kamal is an IIT allumuns with over 10 years of investment experiences. He has managed over $10 millions in last five years.</p>
						</div>
					</div><!--/.col-lg-4 -->
					
					
					<div class="col-md-4 col-sm-6 col-md-offset-2">	
						<div class="single-profile-top wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
							<div class="media">
								<div class="pull-left">
									<a href="#"><img class="media-object" src="images/Sail.jpg" ></a>
								</div>
								<div class="media-body">
									<h5>Sail Wadhwani</h5>
									<h6>Co-Founder and CTO</h6>
									<ul class="tag clearfix">
										<li class="btn"><a href="#">Investment</a></li>
										<li class="btn"><a href="#">Technology</a></li>
										<li class="btn"><a href="#">Strategy</a></li>
									</ul>
									<ul class="social_icons">
										<li><a href="#"><i class="fa fa-facebook"></i></a></li>
										<li><a href="#"><i class="fa fa-twitter"></i></a></li> 
										<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
									</ul>
								</div>
							</div><!--/.media -->
							<p>A born entrepreneurs. With over twelve years of international consulting experience. Sail has spend most of his time working with C suites. </p>
						</div>
					</div><!--/.col-lg-4 -->					
				</div> <!--/.row -->
				<div class="row team-bar">
					<div class="first-one-arrow hidden-xs">
						<hr>
					</div>
					<div class="first-arrow hidden-xs">
						<hr> <i class="fa fa-angle-up"></i>
					</div>
					<div class="second-arrow hidden-xs">
						<hr> <i class="fa fa-angle-down"></i>
					</div>
					<div class="third-arrow hidden-xs">
						<hr> <i class="fa fa-angle-up"></i>
					</div>
				</div> <!--skill_border-->       

				<div class="row clearfix">   
					<div class="col-md-4 col-sm-6 col-md-offset-2">	
						<div class="single-profile-bottom wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="600ms">
							<div class="media">
								<div class="pull-left">
									<a href="#"><img class="media-object" src="images/Savvy.jpg" alt=""></a>
								</div>

								<div class="media-body">
									<h5>Savita Wadhwani</h5>
									<h6>Co-Founder and CTO</h6>
									<ul class="tag clearfix">
										<li class="btn"><a href="#">Web</a></li>
										<li class="btn"><a href="#">Technology</a></li>
										<li class="btn"><a href="#">Data Analysis</a></li>
									</ul>
									<ul class="social_icons">
										<li><a href="#"><i class="fa fa-facebook"></i></a></li>
										<li><a href="#"><i class="fa fa-twitter"></i></a></li> 
										<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
									</ul>
								</div>
							</div><!--/.media -->
							<p>Savvy has over ten years of experience in software development. She believed that the only constant in technology is change.</p>
						</div>
					</div>
					
				</div>	<!--/.row-->
			</div><!--section-->
		</div><!--/.container-->
    </section><!--/about-us-->
	
	
	
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
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="<s:url action="MFexplorer"/>">Funds Explorer</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="contactUs">Contact Us</a></li>
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
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="terms">Terms &amp; Conditions</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="privacyPolicy">Privacy Policy</a></li>
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
		<!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>
       <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
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
		<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
 		<script src="assets/js/jquery.js"></script>
    	<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
    	<script src="assets/js/main.js"></script>
    	<script src="assets/js/wow.min.js"></script>
</html>