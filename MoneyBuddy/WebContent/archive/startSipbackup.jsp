<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Investment Details Page | Money Buddy</title>
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script type="text/javascript"  src="assets/js/jquery.js"></script>
    <script type="text/javascript"  src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    <script type="text/javascript" src="assets/js/wow.min.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">

</head>

<body class="homepage bg-warning" onload="setInitialUpfrontInvestment();">
   <header id="header">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="welcome"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li id="header-nav-li"><a href="welcome"><b>Home</b></a></li>
                        <li id="header-nav-li"><a href="saveTax"><b>Save Tax</b></a></li>
                        <li  id="header-nav-li"><a href="aboutUs"><b>About Us</b></a></li>
                        <li id="header-nav-li"><a href="blog"><b>Blog</b></a></li> 
                        <li id="header-nav-li"><a href="help"><b>FAQs</b></a></li> 
                        <li class="active" id="header-nav-li"><a href="contactUs"><b>Contact Us</b></a></li>
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li id="header-nav-li"><a href="login" ><b>Sign in</b></a></li>
										<li id="header-nav-li"><a href="register" ><b>Sign up</b></a></li> 
							<%	} else 
							 	{	%>
							 			 <li id="header-nav-li"><a href="bseDashboard" ><b>Dashboard</b></a></li> 
							 			 <li id="header-nav-li"><a href="logOff" ><b>Log Out</b></a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>



		
<!-- 		<div id="kycDetails">
			
				<button type="button" id="submit-button-vivek" class="btn btn-info btn-lg submit-button-vivek sharp raised " onClick="testDummyEkyc();">Click for kyc</button>
				
		
		</div> -->
		
 <section id="main-slider" class="no-margin" >
 	
        <div class="carousel slide">
            <ol class="carousel-indicators">
                <li data-target="#main-slider" data-slide-to="0" class="active"></li>
                <li data-target="#main-slider" data-slide-to="1"></li>
                <li data-target="#main-slider" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">

                <div class="item" style="background-image: url(images/slider/SmartWayToInvestBackground.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1" style="color:black;">The smart way to invest</h1>
                                    <h2 class="animation animated-item-2" style="color:black;">Best Funds + Fully automated along with Income tax optamization</h2>
                                    <a class="btn-slide animation animated-item-3 sharp" href="investmentStyle">Get started</a>
                                    <!-- <br/><p id="slogan-4" class="small-text box" style="margin-top:10px;"> with investing your capital is at risk</p> -->
                                </div>
                            </div>

                            <!-- <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="images/slider/img11.png" class="img-responsive">
                                </div>
                            </div> -->

                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item active" style="background-image: url(images/slider/AutomatedSipBackground.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1" style="color:black;">Automated SIP Platform</h1>
             	                       <h2 class="animation animated-item-2" style="color:black;">Start/Stop whenever you want + No penality on missing any installment</h2>
                                    <a class="btn-slide animation animated-item-3" href="investmentStyle">Create your MoneyBuddy Account</a>
                                    <!-- <br/><p id="slogan-4" class="small-text box" style="margin-top:10px;"> with investing your capital is at risk</p> -->
                                </div>
                            </div>

                            <!-- <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="images/slider/img233.png" class="img-responsive">
                                </div>
                            </div> -->

                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item" style="background-image: url(images/slider/SaveTaxBackground.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1" style="color:black;">Tax Saving</h1>
                                    <h2 class="animation animated-item-2" style="color:black;">Save upto 46500 under section 80C + no more income tax/TDS on bank deposits</h2>
                                    <a class="btn-slide animation animated-item-3" href="investmentStyle">Try it out</a>
                                    <!-- <br/><p id="slogan-4" class="small-text box" style="margin-top:10px;"> with investing your capital is at risk</p> -->
                                </div>
                            </div>
                            <!-- <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="images/slider/img34.png" class="img-responsive">
                                </div>
                            </div> -->
                        </div>
                    </div>
                </div><!--/.item-->
            </div><!--/.carousel-inner-->
        </div><!--/.carousel-->
        <a class="prev hidden-xs" href="#main-slider" data-slide="prev">
            <i class="fa fa-chevron-left"></i>
        </a>
        <a class="next hidden-xs" href="#main-slider" data-slide="next">
            <i class="fa fa-chevron-right"></i>
        </a>
    </section><!--/#main-slider-->

    <section id="feature" >
        <div class="container">
           <div class="center wow fadeInDown">
      
                <h2>Features</h2>
                <p class="lead">We’ve done extensive research to make MoneyBuddy the most convenient investment platform for you. Additionally a lot of algorithms run in the background to maximise your returns in a tax efficient way</p>
            </div>

            <div class="row">
                <div class="features">
                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-bullhorn"></i>
                            <h2>Top Performing Funds</h2>
                            <h3>Chosen from over 1,000 mutual funds</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-comments"></i>
                            <h2>Save Income Tax </h2>
                            <h3>Money saved is money earned</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-cloud-download"></i>
                            <h2>Easy Liquidity</h2>
                            <h3>No lock-in, no penalty, Just withdraw when you want</h3>
                        </div>
                    </div><!--/.col-md-4-->
                
                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-leaf"></i>
                            <h2>24*7 Online portfolio</h2>
                            <h3>Access your portfolio from anywhere</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-cogs"></i>
                            <h2>Secure and Automated</h2>
                            <h3>One time setup, hassle free investing forever</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-heart"></i>
                            <h2>Impeccable Team</h2>
                            <h3>IIT Bombay,  PwC, Infosys; We’ve  learned from the best</h3>
                        </div>
                    </div><!--/.col-md-4-->
                </div><!--/.services-->
            </div><!--/.row-->    
        </div><!--/.container-->
    </section><!--/#feature-->
<%-- 
    <section id="recent-works">
        <div class="container">
            <div class="center wow fadeInDown">
                <h2>Recent Works</h2>
                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut <br> et dolore magna aliqua. Ut enim ad minim veniam</p>
            </div>

            <div class="row">
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item1.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Piece of mind</a> </h3>
                                <p>With Mutual Funds you don’t have to worry about the day to day volatility of stocks and you can focus on your work</p>
                                <!-- <a class="preview" href="images/portfolio/full/item1.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a> -->
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item2.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Professional Management</a></h3>
                                <p>With Mutual funds your money is under the supervision of highly skilled professionals, thus giving you piece of mind</p>
                                <!-- <a class="preview" href="images/portfolio/full/item2.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a> -->
                            </div> 
                        </div>
                    </div>
                </div> 

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item3.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Diversification</a></h3>
                                <p>With Mutual Funds you can own a portfolio of 15-20 top performing stocks in one go</p>
                                <!-- <a class="preview" href="images/portfolio/full/item3.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a> -->
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item4.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Multiple types of funds</a></h3>
                                <p>You can spread your money across different mutual funds to further diversify your portfolio</p>
                                <!-- <a class="preview" href="images/portfolio/full/item4.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a> -->
                            </div> 
                        </div>
                    </div>
                </div>   
                
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item5.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Build a corpus</a></h3>
                                <p>You can start an SIP with as low as 1,000 and create savings with complete peace of mind</p>
                                <!-- <a class="preview" href="images/portfolio/full/item5.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a> -->
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item6.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">No lock in</a></h3>
                                <p>While It’s advisable to let your savings grow over long period of time, in case of any requirement you can withdraw full/ partial money anytime you want</p>
                                <!-- <a class="preview" href="images/portfolio/full/item6.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a> -->
                            </div> 
                        </div>
                    </div>
                </div> 

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item7.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">No premature withdrawal penalty</a></h3>
                                <p>Most mutual funds do not charge any penalty when you withdraw, however for the few funds that do you can clearly see the penalty amount </p>
                                <!-- <a class="preview" href="images/portfolio/full/item7.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a> -->
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item8.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Better returns</a></h3>
                                <p>Better returns than Bank Fixed Deposits</p>
                                <!-- <a class="preview" href="images/portfolio/full/item8.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a> -->
                            </div> 
                        </div>
                    </div>
                </div>   
            </div><!--/.row-->
        </div><!--/.container-->
     
    </section><!--/#recent-works--> --%>

    <section id="content">
        <div class="container">
        <div class="center wow fadeInDown">
      
                <h2>Why Mutual Funds</h2>
                <!-- <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut <br> et dolore magna aliqua. Ut enim ad minim veniam</p> -->
       </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 wow fadeInDown">
                   <div class="tab-wrap"> 
                        <div class="media">
                            <div class="parrent pull-left">
                                <ul class="nav nav-tabs nav-stacked">
                                    <li class="active"><a href="#tab1" data-toggle="tab" class="analistic-01">Professional Management</a></li>
                                    <li class=""><a href="#tab2" data-toggle="tab" class="analistic-02">Diversification</a></li>
                                    <li class=""><a href="#tab3" data-toggle="tab" class="tehnical">Fund for every need</a></li>
                                    <li class=""><a href="#tab4" data-toggle="tab" class="tehnical">No lock in</a></li>
                                    <li class=""><a href="#tab5" data-toggle="tab" class="tehnical">Tax benefits</a></li>
                                </ul>
                            </div>

                            <div class="parrent media-body">
                                <div class="tab-content">
                                    <div class="tab-pane fade active in" id="tab1">
                                        <div class="media">
                                           <div class="pull-left">
                                                <img class="img-responsive" src="images/tab2.png">
                                            </div>
                                            <div class="media-body">
                                                 <p>With Mutual funds your money is under the supervision of highly skilled professionals. They not only have superior knowledge then common person, they also give their 100% efforts to ensure your money is growing at a fast place.</p>
                                            </div>
                                        </div>
                                    </div>

                                     <div class="tab-pane fade " id="tab2">
                                        <div class="media">
                                           <div class="pull-left">
                                                <img class="img-responsive" src="images/tab1.png">
                                            </div>
                                            <div class="media-body">
                                                 <!-- <h2>Adipisicing elit</h2> -->
                                                 <p>When you buy one mutual fund, you are basically buying a portfolio of 20-30 stocks. All the stocks are researched buy the experienced team. Thus you’re more likely to earn profits if you buy one mutual fund then if you buy the stock told by your friends/ family
                                                 </p>
                                            </div>
                                        </div>
                                     </div>

                                     <div class="tab-pane fade" id="tab3">
                                     <div class="media">
                                     	<div class="pull-left">
                                        	<img class="img-responsive" src="images/tab1.png">
                                        </div>
                                            <div class="media-body">
                                            	<!-- <h2>Adipisicing elit</h2> -->
                                        		<p>Depending upon the type, a Mutual funds can be highly volatile or can offer you consistent return like a fixed deposit. That’s why we’ve created algorithms to create an ideal selection of mutual funds as per your unique needs.</p>
                                     		</div>
                                        </div>
                                     </div>
                                     
                                     <div class="tab-pane fade" id="tab4">
                                     <div class="media">
                                     	<div class="pull-left">
                                        	<img class="img-responsive" src="images/tab1.png">
                                        </div>
                                            <div class="media-body">
                                            	<!-- <h2>Adipisicing elit</h2> -->
                                        		<p>Majority of funds have no lock in and you can withdraw your money as and when you want. Only if you want to claim additional tax benefit of 80C, and for the record we’re an unbiased 80C expert, your money will be subjected to a lock in period of 3 years.</p>
                                        	</div>
                                        </div>
                                     </div>

                                     <div class="tab-pane fade" id="tab5">
                                     <div class="media">
                                     	<div class="pull-left">
                                        	<img class="img-responsive" src="images/tab1.png">
                                        </div>
                                            <div class="media-body">
                                            	<!-- <h2>Adipisicing elit</h2> -->
                                        		<p>The government of India has created favourable income tax regime for mutual funds investors. You don’t have to pay any income tax on your profits if you’ve invested in equity mutual funds for more than 1 year.. Even for other types of funds, income tax can be very less if you invest for more than 3 years.</p>
                                     		</div>
                                        </div>
                                     </div>
                                </div> <!--/.tab-content-->  
                            </div> <!--/.media-body--> 
                        </div> <!--/.media-->     
                    </div><!--/.tab-wrap-->               
                </div><!--/.col-sm-6-->

            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#content-->

    <section id="partner">
        <div class="container">
            <div class="center wow fadeInDown" style="margin-top:-110px;">
                <h2 style="color:black;">Our Partners</h2>
                <p class="lead" style="color:black;">All the leading financial services firms in India have entered into partnership agreements with MoneyBuddy. Thus providing our customers widest range of mutual funds to chose from (For the record, we’ve over 25 AMCs and 1200 Mutual funds on our website at the moment)</p>
            </div>    

            <div class="partners">
                <ul>
                    <li> <a href="#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms" src="images/partners/partner1.png"></a></li>
                    <li> <a href="#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms" src="images/partners/partner2.png"></a></li>
                    <li> <a href="#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="900ms" src="images/partners/partner3.png"></a></li>
                    <li> <a href="#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="1200ms" src="images/partners/partner4.png"></a></li>
                    <li> <a href="#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="1500ms" src="images/partners/partner5.png"></a></li>
                </ul>
            </div>        
        </div><!--/.container-->
    </section><!--/#partner-->

    <section id="conatcat-info" >
        <div class="container" style="margin-bottom:-50px;">
                    <div class="media contact-info wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="row">
                        
                        <div class="pull-left col-md-1">
                            <i class="fa fa-phone"></i>
                        </div>
                        
                        
                        	<div class="col-md-4">
                            	<h2 style="font-size:25px;">Learn with MoneyBuddy</h2>
                            	<p>Interested in learning about personal finance to maximise your wealth and to protect your near and dear ones?  Subscribe to our newsletter and we’ll periodically send you curated list of articles/ videos prepared exclusively by our founding team PS: We create wealth not spam</p>
							</div>
							<div class="col-md-5">
									<div class="row input-group input-group-lg" style="margin-top:20px;">
						    			<%-- <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> --%>
						    			<input id="email-id" type="text" class="form-control" name="emailId" placeholder="Provide us your email/phone, we will get back to you!" style="width:500px;" >
						    			
						  			</div>
						  			<div class="row">
						 	<div class="center col-md-12">
						  		<button type="button" class="btn btn-primary readmore" style="margin-top:50px; width:200px;">SUBMIT</button>
						  	</div>
						 </div>
						  	</div>
						  	
						 </div>
						 
						
                    </div>
        </div><!--/.container-->    
    </section><!--/#conatcat-info-->
    <section id="whatMakesUsSpecial">
    	<div class="container">
    	
    		<div class="row center wow fadeInDown" style="margin-top:-50px;">
                <h2 style="color:black;">What makes us special</h2>
                <p class="lead" style="color:black;">It’s more than fabulous!</p>
            </div>    

            <div class="row partners">
                <ul style="margin-top:-40px;">
                    <li style="margin-left:200px;"> 
                    	<h2>Best in Tech</h2>
                    	<a href="#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms" src="images/ads/ad1.png"></a>
                    	<br>
                    	<p>Latest technology for best experience and data safety</p>
                    </li>
                    <li> 
                    	<h2>Best in Finance</h2>
                    	<a href="#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms" src="images/ads/ad2.png"></a>
                    	<br>
                    	<p>IIT Bombay + CFA + 10 years of investing experience</p>
                    </li>
                    <li> 
                    	<h2>Best in service</h2>
                    	<a href="#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="900ms" src="images/ads/ad3.png"></a>
                    	<br>
                    	<p>Because customer > Employee > Founders</p>
                    </li>
             	</ul>
            </div>     
			<div class="row" id="follow_us" >
				<div class="center wow fadeInDown">
                	<h2 style="color:black;">Follow US</h2>
                
            	</div> 
            	
			</div>
			<div class="row" style="margin-top:-50px;margin:bottom:30px;">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<ul class="social-share center">
		                <li style="padding:20px;" class="btn btn-lg"><a href="https://www.FaceBook.com/MoneyBuddy" ><i class="fa fa-facebook"></i></a></li>
		                <li style="padding:20px;" class="btn btn-lg"><a href="https://www.YouTube.com/c/MoneyBuddy" ><i class="fa fa-youtube"></i></a></li>
		                <li style="padding:20px;" class="btn btn-lg"><a href="https://www.Twitter.com/MoneyBuddyIndia" ><i class="fa fa-twitter"></i></a></li>
		                <!-- <li style="padding:20px;" class="btn btn-lg"><a href="https://www.Medium.com/MoneyBuddyIndia" ><i class="fa fa-medium"></i></a></li> -->
	                </ul>
                </div>
                <div class="col-md-4"></div>

			</div>
    	
    	</div>
    
    
    </section>
    
    

     <footer id="footer" class="midnight-blue  navbar navbar-fixed-bottom">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a href="#" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
                </div>
                
                
                
                <div class="col-sm-6">
                    <ul class="pull-right">
                       <li><a href="https://www.facebook.com/MoneyBuddyIndia"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="https://twitter.com/MoneyBuddyIndia"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="https://www.linkedin.com/in/money-buddy-94a73814a/"><i class="fa fa-linkedin"></i></a></li> 
                                <li><a href="https://www.YouTube.com/MoneyBuddy"><i class="fa fa-youtube"></i></a></li>
                                
                    </ul>
                </div>
            </div>
        </div>
    </footer>



		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</body>
</html>