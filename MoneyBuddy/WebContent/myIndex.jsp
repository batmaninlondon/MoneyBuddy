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
    <title>Home | Money Buddy</title>
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
     <script src="assets/js/sly.min.js"></script>
    <script src="assets/js/jquery.prettyPhoto.js"></script>
    <script src="assets/js/jquery.isotope.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <link href="assets/css/table.css" rel="stylesheet">
       <link rel="stylesheet" href="assets/Sly/style.css">
  <script src="assets/js/index.js"></script>
  
  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
  
 <!-- Le styles -->
    <link href="assets/css/flexslider.css" rel="stylesheet"> 
  
</head>

<body class="homepage">
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
                    <a class="navbar-brand" href="myIndex"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class ="active" id="header-nav-li"><a href="myIndex"><b>Home</b></a></li>
                        <li id="header-nav-li"><a href="saveTax"><b>Save Tax</b></a></li>
                        <li id="header-nav-li"><a href="aboutUs"><b>About Us</b></a></li>
                        <li id="header-nav-li"><a href="blog"><b>Blog</b></a></li> 
                        <li id="header-nav-li"><a href="help"><b>FAQs</b></a></li> 
                        <li id="header-nav-li"><a href="startSip"><b>Contact Us</b></a></li>
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
   
   


 <section id="main-slider" class="no-margin" style="margin-top:50px">
 	
        <div class="carousel slide">
            <ol class="carousel-indicators">
                <li data-target="#main-slider" data-slide-to="0" class="active"></li>
                <li data-target="#main-slider" data-slide-to="1"></li>
                <li data-target="#main-slider" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">

                <div class="item active" style="background-image: url(images/slider/bg78.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Make your dreams reality</h1>
                                    <h2 class="animation animated-item-2"> The best thing money can buy is .....money</h2>
                                    <a class="btn-slide animation animated-item-3" href="investmentStyle">Try it out</a>
                                    <br/><p id="slogan-4" class="small-text box" style="margin-top:10px;"> with investing your capital is at risk</p>
                                </div>
                            </div>

                           

                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item" style="background-image: url(images/slider/bg56.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Your money with our support</h1>
                                    <h2 class="animation animated-item-2">We will support you to grow your money so that you can focus on what matters most to you</h2>
                                    <a class="btn-slide animation animated-item-3" href="investmentStyle">Try it out</a>
                                    <br/><p id="slogan-4" class="small-text box" style="margin-top:10px;"> with investing your capital is at risk</p>
                                </div>
                            </div>

                           
                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item" style="background-image: url(images/slider/bg67.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Give your money the chance to grow</h1>
                                    <h2 class="animation animated-item-2">Tired of poor returns from banks? Let our experts match you with a portfolio that could give your money the chance to perform better.</h2>
                                    <a class="btn-slide animation animated-item-3" href="investmentStyle">Try it out</a>
                                    <br/><p id="slogan-4" class="small-text box" style="margin-top:10px;"> with investing your capital is at risk</p>
                                </div>
                            </div>
                           
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



 <%-- Savita Wadhwani - Commented this section for bse testing - Start --%>   

<%--      <section id="services" class="service-item">
	   <div class="container">
            <div class="center wow fadeInDown">
           
          <h2>Some of our most populor Portfolios</h2>
          <br/>
          <br/>
          <br/>
          <br/>
          
            </div>

            <div class="row">
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/portfolio1.png" >
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Daredevils</a> </h3>
                                <p>This is a perfect portfolio for someone willing to take higher risk for better returns </p>
                                <a class="preview" href="images/portfolio/full/item1.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Select this portfolio</a>
                            </div> 
                        </div>
                    </div>
                </div>  
                
                
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/portfolio1.png" >
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Reasonable</a> </h3>
                                <p>This is a perfect portfolio for someone willing to take higher risk for better returns </p>
                                <a class="preview" href="images/portfolio/full/item1.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Select this portfolio</a>
                            </div> 
                        </div>
                    </div>
                </div>   
                
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/portfolio1.png" >
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Balanced</a> </h3>
                                <p>This is a perfect portfolio for someone willing to take higher risk for better returns </p>
                                <a class="preview" href="images/portfolio/full/item1.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Select this portfolio</a>
                            </div> 
                        </div>
                    </div>
                </div>   
                
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/portfolio1.png" >
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Cautious</a> </h3>
                                <p>This is a perfect portfolio for someone willing to take higher risk for better returns </p>
                                <a class="preview" href="images/portfolio/full/item1.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Select this portfolio</a>
                            </div> 
                        </div>
                    </div>
                </div>    	

              

                 
            </div><!--/.row-->
        </div><!--/.container-->
        
        
      
        
        
        
        
    </section><!--/#recent-works--> --%>
    
<%-- Savita Wadhwani - Commented this section for bse testing - End --%>    

<section id="services" class="service-item">
	   <div class="container">
            <div class="center wow fadeInDown">
   </div>     </div>     
   </section><!--/#recent-works-->          
            
            
   <section id="feature" >
        <div class="container">
            <div class="row">
            <br/>
          <br/>
          <br/>
          <br/> <br/>
                   
                <div class="features">
                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-bullhorn"></i>
                            <h2>Transparent</h2>
                            <h3>See exactly what you’re invested in and how you’re performing— any time of day</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-comments"></i>
                            <h2>No Fee at all</h2>
                            <h3>No subscription fees. No trading fees. No exit fees. No management fee.</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-cloud-download"></i>
                            <h2>Anywhere, anytime</h2>
                            <h3>Our experienced investment professionals monitor your portfolio.</h3>
                        </div>
                    </div><!--/.col-md-4-->
                
                    
                </div><!--/.services-->
                 <br/>
 <br/>
          <br/>
          <br/>
            </div><!--/.row-->    
             <br/>
 <br/>
        </div><!--/.container-->
    </section><!--/#feature--> 

    

    <section id="content">
    <div class="center wow fadeInDown">  <h2>Why MoneyBuddy</h2> </div>
        <div class="container">
        
            <div class="row">
                <div class="col-xs-12 col-sm-8 wow fadeInDown">
                   <div class="tab-wrap"> 
                        <div class="media">
                            <div class="parrent pull-left">
                                <ul class="nav nav-tabs nav-stacked">
                                    <li class=""><a href="#tab1" data-toggle="tab" class="analistic-01">Experience</a></li>
                                    <li class="active"><a href="#tab2" data-toggle="tab" class="analistic-02">Expertise</a></li>
                                    <li class=""><a href="#tab3" data-toggle="tab" class="tehnical">Relavance</a></li>
                                    <li class=""><a href="#tab4" data-toggle="tab" class="tehnical">Research</a></li>
                                    <li class=""><a href="#tab5" data-toggle="tab" class="tehnical">Technology</a></li>
                                </ul>
                            </div>

                            <div class="parrent media-body">
                                <div class="tab-content">
                                    <div class="tab-pane fade" id="tab1">
                                        <div class="media">
                                            <div class="media-body">
                                                  <p>Our team has years of experience in investment in indian market</p>
                                            </div>
                                        </div>
                                    </div>

                                     <div class="tab-pane fade active in" id="tab2">
                                        <div class="media">
                                           <div class="pull-left">
                                            </div>
                                            <div class="media-body">
                                                 <p> Our team has expertise in analysing market and designing...
                                                 </p>
                                            </div>
                                        </div>
                                     </div>

                                     <div class="tab-pane fade" id="tab3">
                                        <p> We leverage technology to assess your specific needs and recommend a bespoke portfolio meeting your needs and requirements
                            </p>
                                     </div>
                                     
                                     <div class="tab-pane fade" id="tab4">
                                        <p>  We spend thousands of hour researching and selecting...</p>
                                     </div>

                                     <div class="tab-pane fade" id="tab5">
										  <p>  We spend thousands of hour researching and selecting...</p>
                                     </div>
                                </div> <!--/.tab-content-->  
                            </div> <!--/.media-body--> 
                        </div> <!--/.media-->     
                    </div><!--/.tab-wrap-->               
                </div><!--/.col-sm-6-->

<%-- Savita Wadhwani - Commented this section for bse testing - Start --%>

                <%-- <div class="col-xs-12 col-sm-4 wow fadeInDown">
                    <div class="testimonial">
                        <h2>What our customer says</h2>
                         <div class="media testimonial-inner">
                            <div class="pull-left">
                                <img class="img-responsive img-circle" src="images/testimonials1.png">
                            </div>
                            <div class="media-body">
                                <p>MoneyBuddy truly helped me make most of my investments, while giving back hours back </p>
                                <span><strong>-John Doe/</strong> Director, Amazon India</span>
                            </div>
                         </div>

                         <div class="media testimonial-inner">
                            <div class="pull-left">
                                <img class="img-responsive img-circle" src="images/testimonials1.png">
                            </div>
                             <div class="media-body">
                                <p>MoneyBuddy truly helped me make most of my investments, while giving back hours back </p>
                                <span><strong>-John Doe/</strong> Director, Amazon India</span>
                            </div>
                         </div>

                    </div>
                </div> --%>

<%-- Savita Wadhwani - Commented this section for bse testing - End --%>

            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#content-->






<section id="services" class="service-item">
	   <div class="container">
            <div class="center wow fadeInDown">
           


            
               <h2>Our Partners</h2>
                <p class="lead">
We use funds from leading providers to build your portfolio</p>

            <marquee behavior="scroll" direction="left">
				 
 				  <img src="images/partners/birla.jpg"  height="42" alt="Birla">
 				   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
				<img src="images/partners/kotak.jpg"  height="42" alt="Kotak">
 				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				<img src="images/partners/icici.jpg" height="42" alt="ICICI">
 				  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
 				  <img src="images/partners/dhfl_fd.png" height="35" alt="DHFL">
 				  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/reliance.png"  height="42" alt="Reliance">
                  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/BSE.jpg"  height="42" alt="BSE">
 				   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/axis.jpg"  height="42" alt="Axix">
 				    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/dhfl_fd.jpg"  height="42" alt="dhfl_fd">
 				    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/dsp.jpg"  height="42" alt="Dsp">
 				    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/franklin.jpg"  height="42" alt="Franklin">
 				    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/grun_fd.jpg"  height="42" alt="Grun_fd">
 				    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/housing_fd.jpg"  height="42" alt="Housing">
 				    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/birla.jpg"  height="42" alt="Birla">
 				  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/kotak.jpg"  height="42" alt="Kotak">
 				  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/icici.jpg"  height="42" alt="ICICI">
 				   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/mahindra_fd.jpg"  height="42" alt="Mahindra">
 				   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
 				  <img src="images/partners/hdfc.jpg"  height="42" alt="HDFS">
 				  
 				  
			</marquee>
          
          
            </div>

          
                
        </div><!--/.container-->
    </section><!--/#services-->





  
<%-- Savita Wadhwani - Changes done on this section for bse testing - Start --%>

    <section id="conatcat-info">
        <div class="container">
            <div class="row" style="margin-bottom:40px;">
                <div class="col-sm-8">
                    <div class="media contact-info wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="pull-left">
                            <i class="fa fa-phone"></i>
                        </div>
                        <div class="media-body">
                            <h2>Have a question, contact us on </h2>
                            <p>
                            +91 9971648736 / info.moneybuddy@gmail.com
                           </p>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/.container-->    
    </section><!--/#conatcat-info-->

<%-- Savita Wadhwani - Changes done on this section for bse testing - End --%>  

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


</body>
</html>
