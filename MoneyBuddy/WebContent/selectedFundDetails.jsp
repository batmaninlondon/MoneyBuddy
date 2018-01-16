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
    <title>Try it | Money Buddy</title>
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
    <script src="assets/js/jquery.prettyPhoto.js"></script>
    <script src="assets/js/jquery.isotope.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    
		<%-- <script type="text/javascript" src="assets/js/jquery.js"></script> --%>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</head>

<body class="homepage">
   <header id="header">
        <!-- <div class="top-bar">
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
            </div>/.container
        </div>/.top-bar -->

        <nav class="navbar navbar-inverse" role="banner">
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
                        <li class="active" id="header-nav-li"><a href="myIndex">Home</a></li>
                        <li id="header-nav-li"><a href="startSip">Start SIP</a></li>
                        <li id="header-nav-li"><a href="saveTax">Save Tax</a></li>
                        <li id="header-nav-li"><a href="aboutUs">About Us</a></li>
                        <li id="header-nav-li"><a href="blog">Blog</a></li> 
                        <li id="header-nav-li"><a href="help">Contact Us</a></li>  
                       
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li style="margin-top:-10px;margin-bottom:-20px;"><a href="login" >Sign in</a></li>
										<li style="margin-top:-10px;margin-bottom:-20px;"><a href="register" >Sign up</a></li> 
							<%	} else 
							 	{	%>
							 			 <li style="margin-top:-10px;margin-bottom:-20px;"><a href="bseDashboard" >Dashboard</a></li> 
							 			 <li style="margin-top:-10px;margin-bottom:-20px;"><a href="logOff" >Log Out</a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>

	
  
  <%
		session.setAttribute("fundSelected", "TRUE");
	%>
  <section class="pricing-page">
        <div class="container">
        	<div class="row">
        		<%
					if (session.getAttribute("customerId") == null) {
				%>
				<input type="hidden" id="cusId" value="customerIdNull" />
				<%
					} else {
				%>
				<input type="hidden" id="cusId" value="customerExists" />
				<%
					}
				%>
        	</div>
  
          <div class="container g-margin-b-100--xs g-hor-border-4__solid--white ">
  <div id="js__grid-portfolio-gallery" class="cbp">
            
                 
            
                <!-- ITEM 1 -->
		                <div class="s-portfolio__item cbp-item motion graphic">
		                    <div class="s-portfolio__img-effect">
		                        <img src="images/portfolio/recent/portfolio2.png"  alt="Portfolio Image">
		                        			<s:set var="fundDetails" value="#session.selectedFundDetailsDataModel" />
				                           <div class="	 g-box-shadow__dark-lightest-v2 g-text-center--xs g-padding-x-40--xs g-padding-y-40--xs" style="background-color: #eeeeee">
				                            <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2"> <s:property value="#fundDetails.fundId"/> . <s:property value="#fundDetailsDataModelElement.fundName"/></p>
				                            <h3 class="g-font-size-22--xs g-letter-spacing--1"><s:property value="#fundDetails.sector"/></h3>
				                          	<p class="g-text-left--xs "><s:property value="#fundDetails.subSector"/></p>
				                            <p class="g-text-left--xs ">Start Date : <s:property value="#fundDetails.fundStartDate"/></p>
				                            <p class="g-text-left--xs ">Rating : <s:property value="#fundDetails.rating"/></p>
				                            <p class="g-text-left--xs ">Risk : <s:property value="#fundDetails.risk"/></p>
				                            <p class="g-text-left--xs ">3 yrs returns : <s:property value="#fundDetails.returnsThreeYears"/>%</p>
				                            <p class="g-text-left--xs ">Minimum SIP Amount : <s:property value="#fundDetails.minSipAmount"/>INR </p>
				                            <p class="g-text-left--xs ">Minimum SIP time : <s:property value="#fundDetails.minSipYears"/> years</p>
				                            <p class="g-text-left--xs ">Minimum Lumpsup Amount : <s:property value="#fundDetails.minLumsumAmount"/> INR</p>
				                            <p class="g-text-left--xs ">Fund Category : <s:property value="#fundDetails.fundCategory"/></p>
				                        </div>
		                    </div>
		                    <div class="s-portfolio__caption-hover--cc">
		                        <div class="g-margin-b-25--xs">
		                            <h4 class="g-font-size-18--xs g-color--white g-margin-b-5--xs">Portfolio Item</h4>
		                            <p class="g-color--white-opacity">by KeenThemes Inc.</p>
		                        </div>
		                        <ul class="list-inline g-ul-li-lr-5--xs g-margin-b-0--xs">
		                            <li>
		                            <s:set var="sector" value="#fundDetailsDataModelElement.sector" />
		                            <s:if test="sector.equals('Equity')">
		                                <a href="images/portfolio/recent/slide/Slide1.jpg" class="cbp-lightbox s-icon s-icon--sm s-icon--white-bg g-radius--circle" data-title="Portfolio Item  <br/>  by KeenThemes Inc.">
		                             	<i class="ti-fullscreen"></i>
		                                </a>
		                             </s:if>
		                             <s:else>
		                             	<a href="images/portfolio/recent/slide/Slide2.jpg" class="cbp-lightbox s-icon s-icon--sm s-icon--white-bg g-radius--circle" data-title="Portfolio Item  <br/>  by KeenThemes Inc.">
		                             	<i class="ti-fullscreen"></i>
		                                </a>
		                             
									 </s:else>       
		                                    
		                                    
		                           		<br/>
		                           		<br/>
		                           		<button type="button" class="btn btn-link" onClick="buyFundHandler(<s:property value="selectedFundId" />);">Invest Now</button>
		                                 <!-- <a class="text-uppercase btn-block s-btn s-btn--md s-btn--white-bg g-radius--50 g-padding-x-50--xs g-margin-b-20--xs" href="investmentStyle">Try it out</a> -->
		                            </li>
		                        </ul>
		                    </div>
		                </div>
                <!-- End ITEM -->
               
	              
	           
                
            </div>
            </div>
            <div class="pricing-area text-center">
                <div class="row">
                    <div class="col-sm-6 plan price-one wow fadeInDown">
                                <!-- <a class="btn btn-primary" href="newUpfrontInvestment" >Select this option</a> -->
                                <button type="button" class="btn btn-primary readmore" onClick="checkLoggedInStatus();" style="margin-top:20px;padding:5px 15px 5px 15px;">Investment now</button>
                    </div>

                  </div>
            </div><!--/pricing-area-->
        </div><!--/container-->
    </section><!--/pricing-page-->
  
  
  
  
  
  
  
      <footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a target="_blank" href="http://quantwealth.in/" title="MoneyBuddy">MoneyBuddy</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="myIndex">Home</a></li>
                        <li><a href="aboutUs">About Us</a></li>
                        <li><a href="help">Contact Us</a></li>
                        <li><a href="register">Sign Up</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>


</body>
</html>
