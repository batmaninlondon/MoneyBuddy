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
        <div class="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-4">
                        <div class="top-number"><p><i class="fa fa-phone-square"></i>  +91 9971648736</p></div>
                    </div>
                    <div class="col-sm-6 col-xs-8">
                       <div class="social">
                            <ul class="social-share">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li> 
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-skype"></i></a></li>
                            </ul>
                       </div>
                    </div>
                </div>
            </div><!--/.container-->
        </div><!--/.top-bar-->

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="active"  id="header-nav-li"><a href="myIndex">Home</a></li>
                        <li id="header-nav-li"><a href="whyInvest">Why Invest</a></li>
                        <li id="header-nav-li"><a href="aboutUs">About Us</a></li>
                        <li id="header-nav-li"><a href="saveTax">Save Tax</a></li>
                        <li id="header-nav-li"><a href="blog">Blog</a></li> 
                        <li id="header-nav-li"><a href="help">Help</a></li> 
                      
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li id="header-nav-li"><a href="login" >Sign in</a></li>
										<li id="header-nav-li"><a href="register" >Sign up</a></li> 
							<%	} else 
							 	{	%>
							 			   <li id="header-nav-li"><a href="bseDashboard" >Dashboard</a></li> 
							 			   <li id="header-nav-li"><a href="logOff" >Log Out</a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>


 <section id="main-slider" class="no-margin">
 	
        <div class="carousel slide">
            <ol class="carousel-indicators">
                <li data-target="#main-slider" data-slide-to="0" class="active"></li>
                <li data-target="#main-slider" data-slide-to="1"></li>
                <li data-target="#main-slider" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">

                <div class="item active" style="background-image: url(images/slider/bg4.jpg)">
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

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="images/slider/img11.png" class="img-responsive">
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item" style="background-image: url(images/slider/bg6.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">The smart way to invest</h1>
                                    <h2 class="animation animated-item-2">We take the best elements of a high-end investing service, strip out the complexity and cost, and provide it to you online.</h2>
                                    <a class="btn-slide animation animated-item-3" href="investmentStyle">Try it out</a>
                                    <br/><p id="slogan-4" class="small-text box" style="margin-top:10px;"> with investing your capital is at risk</p>
                                </div>
                            </div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="images/slider/img233.png" class="img-responsive">
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item" style="background-image: url(images/slider/bg3.jpg)">
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
                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="images/slider/img34.png" class="img-responsive">
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

    <section id="feature" >
        <div class="container">
           <div class="center wow fadeInDown">
           
           
        
           <div class="container">
      		<div class="row">
      			<div class="col-sm-3 col-lg-3">
      				<div id="hosting-table">
						<div class="table_style4"> 
							<div class="column">
								<ul>
				                  	<li><strong>Select Your Portfolio</strong></li>
									<li class="header_row">
										 <div class="pull-left">
                        </div>
                        High Risk High Returns Portfolio
									</li>
									<li>
						
                         <img class="img-responsive" src="images/services/services1.png"><div class="progress-wrap">
                         Risk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
									</li>
									
									
									<li class="footer_row">
									
									<a href="#" class="hosting-button">Select this portfolio</a>
									
									
									</li>
								</ul>
							</div><!--/ column-->
						</div><!--/ Table Style-->
					</div><!--/ Hosting Table-->	
      			</div><!-- /span3 -->	
      			
      			
      			<div class="col-sm-3 col-lg-3">
      				<div id="hosting-table">
						<div class="table_style4"> 
							<div class="column">
								<ul>
				                  	<li><strong>Select Your Portfolio</strong></li>
									<li class="header_row">
										 <div class="pull-left">
                        </div>
                        High Risk High Returns Portfolio
									</li>
									<li>
						
                         <img class="img-responsive" src="images/services/services2.png"><div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        
                        
                        
									</li>
									
									
									<li class="footer_row"><a href="#" class="hosting-button">Select this portfolio</a></li>
								</ul>
							</div><!--/ column-->
						</div><!--/ Table Style-->
					</div><!--/ Hosting Table-->	
      			</div><!-- /span3 -->
      			
      			
      			<div class="col-sm-3 col-lg-3">
      				<div id="hosting-table">
						<div class="table_style4"> 
							<div class="column">
								<ul>
				                  	<li><strong>Select Your Portfolio</strong></li>
									<li class="header_row">
										 <div class="pull-left">
                        </div>
                        High Risk High Returns Portfolio
									</li>
									<li>
						
                         <img class="img-responsive" src="images/services/services3.png"><div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
									</li>
									
									
									<li class="footer_row"><a href="#" class="hosting-button">Select this portfolio</a></li>
								</ul>
							</div><!--/ column-->
						</div><!--/ Table Style-->
					</div><!--/ Hosting Table-->	
      			</div><!-- /span3 -->
      			
      			
      			<div class="col-sm-3 col-lg-3">
      				<div id="hosting-table">
						<div class="table_style4"> 
							<div class="column">
								<ul>
				                  	<li><strong>Select Your Portfolio</strong></li>
									<li class="header_row">
										 <div class="pull-left">
                        </div>
                        High Risk High Returns Portfolio
									</li>
									<li>
						
                         <img class="img-responsive" src="images/services/services4.png"><div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
									</li>
									
									
									<li class="footer_row"><a href="#" class="hosting-button">Select this portfolio</a></li>
								</ul>
							</div><!--/ column-->
						</div><!--/ Table Style-->
					</div><!--/ Hosting Table-->	
      			</div><!-- /span3 -->
      			
      			
      			

      		</div><!-- /row -->
      	</div>
        
           
           
                <h2>Features</h2>
                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut <br> et dolore magna aliqua. Ut enim ad minim veniam</p>
            </div>

            <div class="row">
                <div class="features">
                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-bullhorn"></i>
                            <h2>Fresh and Clean</h2>
                            <h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-comments"></i>
                            <h2>Retina ready</h2>
                            <h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-cloud-download"></i>
                            <h2>Easy to customize</h2>
                            <h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h3>
                        </div>
                    </div><!--/.col-md-4-->
                
                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-leaf"></i>
                            <h2>Adipisicing elit</h2>
                            <h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-cogs"></i>
                            <h2>Sed do eiusmod</h2>
                            <h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h3>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap">
                            <i class="fa fa-heart"></i>
                            <h2>Labore et dolore</h2>
                            <h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h3>
                        </div>
                    </div><!--/.col-md-4-->
                </div><!--/.services-->
            </div><!--/.row-->    
        </div><!--/.container-->
    </section><!--/#feature-->

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
                                <h3><a href="#">Business theme</a> </h3>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority</p>
                                <a class="preview" href="images/portfolio/full/item1.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item2.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Business theme</a></h3>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority</p>
                                <a class="preview" href="images/portfolio/full/item2.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a>
                            </div> 
                        </div>
                    </div>
                </div> 

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item3.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Business theme </a></h3>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority</p>
                                <a class="preview" href="images/portfolio/full/item3.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item4.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Business theme </a></h3>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority</p>
                                <a class="preview" href="images/portfolio/full/item4.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a>
                            </div> 
                        </div>
                    </div>
                </div>   
                
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item5.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Business theme</a></h3>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority</p>
                                <a class="preview" href="images/portfolio/full/item5.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item6.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Business theme </a></h3>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority</p>
                                <a class="preview" href="images/portfolio/full/item6.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a>
                            </div> 
                        </div>
                    </div>
                </div> 

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item7.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Business theme </a></h3>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority</p>
                                <a class="preview" href="images/portfolio/full/item7.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item8.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Business theme </a></h3>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority</p>
                                <a class="preview" href="images/portfolio/full/item8.png" rel="prettyPhoto"><i class="fa fa-eye"></i> View</a>
                            </div> 
                        </div>
                    </div>
                </div>   
            </div><!--/.row-->
        </div><!--/.container-->
        
        
      
        
        
        
        
    </section><!--/#recent-works-->

    <section id="services" class="service-item">
	   <div class="container">
            <div class="center wow fadeInDown">
            
            
            <div class="frame">
	<div class="slidee">
		<h2>This in here...</h2>
		<p>...can be anything. <strong>Anything!</strong></p>
	</div>
</div>
<div class="wrap">

			<div class="scrollbar">
				<div class="handle">
					<div class="mousearea"></div>
				</div>
			</div>

			<div class="frame" id="forcecentered">
				<ul class="clearfix">
					<li>0</li><li>1</li><li>2</li><li>3</li><li>4</li><li>5</li><li>6</li><li>7</li><li>8</li><li>9</li>
					<li>10</li><li>11</li><li>12</li><li>13</li><li>14</li><li>15</li><li>16</li><li>17</li><li>18</li>
					<li>19</li><li>20</li><li>21</li><li>22</li><li>23</li><li>24</li><li>25</li><li>26</li><li>27</li>
					<li>28</li><li>29</li>
				</ul>
			</div>

			<div class="controls center">
				<button class="btn prev"><i class="icon-chevron-left"></i> prev</button>
				<button class="btn next">next <i class="icon-chevron-right"></i></button>
			</div>
		</div>



            
                <h2>Our Service</h2>
                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut <br> et dolore magna aliqua. Ut enim ad minim veniam</p>
            </div>

            <div class="row">

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services1.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">High Risk High Returns Portfolio 11</h3>
                            
                        </div>
				         <br/>
				             <br/>
				         <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        <br/>
				             <br/>
                        <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        
                        
                    </div>
     
     
     	
                </div>

<div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services2.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">High Risk High Returns Portfolio 12</h3>
                            
                        </div>
				         <br/>
				             <br/>
				         <div class="progress-wrap">
                         RIsk 11
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        <br/>
				             <br/>
                        <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        
                        
                    </div>
     
                </div>
                
                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services3.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">High Risk High Returns Portfolio</h3>
                            
                        </div>
				         <br/>
				             <br/>
				         <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        <br/>
				             <br/>
                        <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        
                        
                    </div>
     
                </div>


  <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services4.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">High Risk High Returns Portfolio</h3>
                            
                        </div>
				         <br/>
				             <br/>
				         <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        <br/>
				             <br/>
                        <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        
                        
                    </div>
     
                </div>
                
                
                  <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services5.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">High Risk High Returns Portfolio</h3>
                            
                        </div>
				         <br/>
				             <br/>
				         <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        <br/>
				             <br/>
                        <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        
                        
                    </div>
     
                </div>
                
                
                  <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services6.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">High Risk High Returns Portfolio</h3>
                            
                        </div>
				         <br/>
				             <br/>
				         <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        <br/>
				             <br/>
                        <div class="progress-wrap">
                         RIsk
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="10" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                        
                        
                    </div>
     
                </div>
                
              
           
                

                

                                                              
            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#services-->

    <section id="middle">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 wow fadeInDown">
                    <div class="skill">
                        <h2>Our Skills</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

                        <div class="progress-wrap">
                            <h3>Graphic Design</h3>
                            <div class="progress">
                              <div class="progress-bar  color1" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 85%">
                                <span class="bar-width">85%</span>
                              </div>

                            </div>
                        </div>

                        <div class="progress-wrap">
                            <h3>HTML</h3>
                            <div class="progress">
                              <div class="progress-bar color2" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 95%">
                               <span class="bar-width">95%</span>
                              </div>
                            </div>
                        </div>

                        <div class="progress-wrap">
                            <h3>CSS</h3>
                            <div class="progress">
                              <div class="progress-bar color3" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                <span class="bar-width">80%</span>
                              </div>
                            </div>
                        </div>

                        <div class="progress-wrap">
                            <h3>Wordpress</h3>
                            <div class="progress">
                              <div class="progress-bar color4" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
                                <span class="bar-width">90%</span>
                              </div>
                            </div>
                        </div>
                    </div>

                </div><!--/.col-sm-6-->

                <div class="col-sm-6 wow fadeInDown">
                    <div class="accordion">
                        <h2>Why People like us?</h2>
                        <div class="panel-group" id="accordion1">
                          <div class="panel panel-default">
                            <div class="panel-heading active">
                              <h3 class="panel-title">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#collapseOne1">
                                  Lorem ipsum dolor sit amet
                                  <i class="fa fa-angle-right pull-right"></i>
                                </a>
                              </h3>
                            </div>

                            <div id="collapseOne1" class="panel-collapse collapse in">
                              <div class="panel-body">
                                  <div class="media accordion-inner">
                                        <div class="pull-left">
                                            <img class="img-responsive" src="images/accordion1.png">
                                        </div>
                                        <div class="media-body">
                                             <h4>Adipisicing elit</h4>
                                             <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore</p>
                                        </div>
                                  </div>
                              </div>
                            </div>
                          </div>

                          <div class="panel panel-default">
                            <div class="panel-heading">
                              <h3 class="panel-title">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#collapseTwo1">
                                  Lorem ipsum dolor sit amet
                                  <i class="fa fa-angle-right pull-right"></i>
                                </a>
                              </h3>
                            </div>
                            <div id="collapseTwo1" class="panel-collapse collapse">
                              <div class="panel-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.
                              </div>
                            </div>
                          </div>

                          <div class="panel panel-default">
                            <div class="panel-heading">
                              <h3 class="panel-title">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#collapseThree1">
                                  Lorem ipsum dolor sit amet
                                  <i class="fa fa-angle-right pull-right"></i>
                                </a>
                              </h3>
                            </div>
                            <div id="collapseThree1" class="panel-collapse collapse">
                              <div class="panel-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.
                              </div>
                            </div>
                          </div>

                          <div class="panel panel-default">
                            <div class="panel-heading">
                              <h3 class="panel-title">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#collapseFour1">
                                  Lorem ipsum dolor sit amet
                                  <i class="fa fa-angle-right pull-right"></i>
                                </a>
                              </h3>
                            </div>
                            <div id="collapseFour1" class="panel-collapse collapse">
                              <div class="panel-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.
                              </div>
                            </div>
                          </div>
                        </div><!--/#accordion1-->
                    </div>
                </div>

            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#middle-->

    <section id="content">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-8 wow fadeInDown">
                   <div class="tab-wrap"> 
                        <div class="media">
                            <div class="parrent pull-left">
                                <ul class="nav nav-tabs nav-stacked">
                                    <li class=""><a href="#tab1" data-toggle="tab" class="analistic-01">Responsive Web Design</a></li>
                                    <li class="active"><a href="#tab2" data-toggle="tab" class="analistic-02">Premium Plugin Included</a></li>
                                    <li class=""><a href="#tab3" data-toggle="tab" class="tehnical">Predefine Layout</a></li>
                                    <li class=""><a href="#tab4" data-toggle="tab" class="tehnical">Our Philosopy</a></li>
                                    <li class=""><a href="#tab5" data-toggle="tab" class="tehnical">What We Do?</a></li>
                                </ul>
                            </div>

                            <div class="parrent media-body">
                                <div class="tab-content">
                                    <div class="tab-pane fade" id="tab1">
                                        <div class="media">
                                           <div class="pull-left">
                                                <img class="img-responsive" src="images/tab2.png">
                                            </div>
                                            <div class="media-body">
                                                 <h2>Adipisicing elit</h2>
                                                 <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use.</p>
                                            </div>
                                        </div>
                                    </div>

                                     <div class="tab-pane fade active in" id="tab2">
                                        <div class="media">
                                           <div class="pull-left">
                                                <img class="img-responsive" src="images/tab1.png">
                                            </div>
                                            <div class="media-body">
                                                 <h2>Adipisicing elit</h2>
                                                 <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use.
                                                 </p>
                                            </div>
                                        </div>
                                     </div>

                                     <div class="tab-pane fade" id="tab3">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit.</p>
                                     </div>
                                     
                                     <div class="tab-pane fade" id="tab4">
                                        <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words</p>
                                     </div>

                                     <div class="tab-pane fade" id="tab5">
                                        <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures,</p>
                                     </div>
                                </div> <!--/.tab-content-->  
                            </div> <!--/.media-body--> 
                        </div> <!--/.media-->     
                    </div><!--/.tab-wrap-->               
                </div><!--/.col-sm-6-->

                <div class="col-xs-12 col-sm-4 wow fadeInDown">
                    <div class="testimonial">
                        <h2>Testimonials</h2>
                         <div class="media testimonial-inner">
                            <div class="pull-left">
                                <img class="img-responsive img-circle" src="images/testimonials1.png">
                            </div>
                            <div class="media-body">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt</p>
                                <span><strong>-John Doe/</strong> Director of corlate.com</span>
                            </div>
                         </div>

                         <div class="media testimonial-inner">
                            <div class="pull-left">
                                <img class="img-responsive img-circle" src="images/testimonials1.png">
                            </div>
                            <div class="media-body">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt</p>
                                <span><strong>-John Doe/</strong> Director of corlate.com</span>
                            </div>
                         </div>

                    </div>
                </div>

            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#content-->

    <section id="partner">
        <div class="container">
            <div class="center wow fadeInDown">
                <h2>Our Partners</h2>
                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut <br> et dolore magna aliqua. Ut enim ad minim veniam</p>
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

    <section id="conatcat-info">
        <div class="container">
            <div class="row">
                <div class="col-sm-8">
                    <div class="media contact-info wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="pull-left">
                            <i class="fa fa-phone"></i>
                        </div>
                        <div class="media-body">
                            <h2>Have a question or need a custom quote?</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation +0123 456 70 80</p>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/.container-->    
    </section><!--/#conatcat-info-->

    <section id="bottom">
        <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Company</h3>
                        <ul>
                            <li><a href="#">About us</a></li>
                            <li><a href="#">We are hiring</a></li>
                            <li><a href="#">Meet the team</a></li>
                            <li><a href="#">Copyright</a></li>
                            <li><a href="#">Terms of use</a></li>
                            <li><a href="#">Privacy policy</a></li>
                            <li><a href="#">Contact us</a></li>
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->

                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Support</h3>
                        <ul>
                            <li><a href="#">Faq</a></li>
                            <li><a href="#">Blog</a></li>
                            <li><a href="#">Forum</a></li>
                            <li><a href="#">Documentation</a></li>
                            <li><a href="#">Refund policy</a></li>
                            <li><a href="#">Ticket system</a></li>
                            <li><a href="#">Billing system</a></li>
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->

                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Developers</h3>
                        <ul>
                            <li><a href="#">Web Development</a></li>
                            <li><a href="#">SEO Marketing</a></li>
                            <li><a href="#">Theme</a></li>
                            <li><a href="#">Development</a></li>
                            <li><a href="#">Email Marketing</a></li>
                            <li><a href="#">Plugin Development</a></li>
                            <li><a href="#">Article Writing</a></li>
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->

                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Our Partners</h3>
                        <ul>
                            <li><a href="#">Adipisicing Elit</a></li>
                            <li><a href="#">Eiusmod</a></li>
                            <li><a href="#">Tempor</a></li>
                            <li><a href="#">Veniam</a></li>
                            <li><a href="#">Exercitation</a></li>
                            <li><a href="#">Ullamco</a></li>
                            <li><a href="#">Laboris</a></li>
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->
            </div>
        </div>
    </section><!--/#bottom-->

      <footer id="footer" class="midnight-blue  navbar navbar-fixed-bottom">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a target="_blank" href="http://quantwealth.in/" title="MoneyBuddy">MoneyBuddy</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Faq</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>


</body>
</html>