<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy-Top Performing Mutual Funds</title>
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
	
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/swiper/swiper.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/bootstrap/font-awesome.min.css" rel="stylesheet"> -->

        <!-- Theme Styles -->
        <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <!-- <link rel="stylesheet" type="text/css" href="css/cardio.css"> -->

        <!-- Favicon -->
        <!-- <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png"> -->
       
                <%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
        <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
 	
  
  <script type="text/javascript" src="assets/js/jquery-latest.js"></script>
  
  
 <script>
		
</script>


<style>
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Raleway:400,500,700);
.snip1418 {
  font-family: 'Raleway', Arial, sans-serif;
  position: relative;
  float: left;
  overflow: hidden;
  margin: 10px 1%;
  text-align: left;
  color: #000000;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  font-size: 16px;
  -webkit-transform: translateZ(0);
  transform: translateZ(0);
  -webkit-perspective: 20em;
  perspective: 20em;
}
.snip1418 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.snip1418 .add-to-cart {
  position: absolute;
  height:50px;
  top: 0;
  right: 0;
  padding-top: 20px;
  padding-left: 10px;
  padding-right: 10px;
  color: #ffffff;
  font-weight: 700;
  text-transform: uppercase;
  font-size: 0.9em;
  opacity: 0;
 // background-color: #409ad5;
   background-color: black;
  -webkit-transform: rotateX(-90deg);
  transform: rotateX(-90deg);
  -webkit-transform-origin: 100% 0;
  -ms-transform-origin: 100% 0;
  transform-origin: 100% 0;
}

.snip1418 figcaption {
//  padding: 20px;
}
.snip1418 h3,
.snip1418 p {
  margin: 0;
}
.snip1418 h3 {
  font-size: 1em;
  font-weight: 700;
  margin-bottom: 10px;
  text-transform: uppercase;
}
.snip1418 p {
  font-size: 0.7em;
  letter-spacing: 1px;
  font-weight: 400;
}
.snip1418 a {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
.snip1418:hover .add-to-cart,
.snip1418.hover .add-to-cart {
  opacity: 1;
  -webkit-transform: rotateX(0deg);
  transform: rotateX(0deg);
}
.snip1418:hover .add-to-cart i,
.snip1418.hover .add-to-cart i {
  background-color: #2980b9;
}

</style>

    </head>
    <!-- End Head -->

    <!-- Body -->
    <body >
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
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
                                </a>
                            </div>
                            <!-- End Logo -->
                        </div>
                        
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col--right g-padding-l-80-md">
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="welcome" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="Fees.jsp" class="s-header-v2__nav-link">Fees</a></li>
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
										 			 <li id="dropdown-selector" class="dropdown s-header-v2__nav-item s-header-v2__dropdown-on-hover">
			                                        	<a href="javascript:void(0);" class="dropdown-toggle s-header-v2__nav-link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cart<span class="g-font-size-10--xs g-margin-l-5--xs ti-angle-down"></span></a>
			                                        	<ul class="dropdown-menu s-header-v2__dropdown-menu" style="min-width: 60px;">
			                                            	<li><a href="<s:url action="customerCartAction"/>" class="s-header-v2__dropdown-menu-link">Investment Cart</a></li>
			                                            	<li><a href="<s:url action="customerRedCartAction"/>" class="s-header-v2__dropdown-menu-link">Redemption Cart</a></li>
			                                        	</ul>
			                                    	</li>
										 			 <li class="s-header-v2__nav-item"><a href="<s:url action="logOffAction"/>" class="s-header-v2__nav-link">Log Out</a></li>
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

        <!--========== PAGE CONTENT ==========-->
       
       <div class="g-bg-color--dark">
            <div class="g-container--md g-text-center--xs g-padding-y-30--xs">
            <br/><br/><br/>
                <div class="g-margin-b-10--xs">
                    <h1 class="g-font-size-20--xs g-font-size-30--sm g-font-size-40--md g-color--white g-letter-spacing--1 g-margin-b-10--xs">Top Performing Mutual Funds</h1>
                     <p class="g-font-size-15--xs g-font-size-30--sm g-font-size-30--md">Fully online investing</p>
                     <input class="form-control" id="myInput" type="text" oninput="showSearch(this.value)" placeholder="Search by entering fund name or category">
				  <br>
				</div>
            </div>
        </div>
        
    <div id="myDiv1" class="g-bg-color--white  " >
    <div id="load" class="load"></div>
		<div id="content">
			<div id="myDiv2" class="row  g-padding-y-40--sm g-container--md  ">
				<s:iterator value="fundDetailsDataModel" var="fundDetailsDataModelElement">
						<div id="myDiv3" class="col-md-4  g-bg-color--white">
							<div  class="  g-line-height--normal  ">
							<s:set var="selectedFundId" value="#fundDetailsDataModelElement.fundId" />
								<figure class="snip1418   swiper-slide " style="width:100%;height:292px;"  onClick="buyFundHandler(<s:property value="selectedFundId" />);" >
									<span id="myDiv5" class="add-to-cart"><span>Select this fund</span></span>
				  					<figcaption >
				    					<article class=" panel panel-heading g-bg-color--primary" style="height:140px;" >
				    						<p class="g-color--white  g-font-size-16--xs " style="font-weight: bold; "><s:property value="#fundDetailsDataModelElement.schemeName"/></p>
				    						 <p class="g-color--white  g-font-size-12--xs" ><b>Scheme Type:</b> <s:property value="#fundDetailsDataModelElement.schemeType"/></p>
				    						<p class="g-color--white  g-font-size-12--xs" ><b>Category:</b> <s:property value="#fundDetailsDataModelElement.category"/></p>
				    						<p class="g-color--white  g-font-size-12--xs" ><b>Inception Date:</b> <s:property value="#fundDetailsDataModelElement.startDate"/></p>
				    					</article>
				    					<article class="g-margin-l-20--xs g-margin-t-20--xs" style="height:110px;"> 
									        <s:if test="#fundDetailsDataModelElement.rating.equals('5'.toString())">
										        <i class="fa fa-star g-color--primary"></i>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
											</s:if>
											<s:if test="#fundDetailsDataModelElement.rating.equals('4'.toString())">
										        <span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star"></span>
											</s:if>
											<s:if test="#fundDetailsDataModelElement.rating.equals('3'.toString())">
										        <i class="fa fa-star g-color--primary"></i>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star"></span>
											</s:if>
											<s:if test="#fundDetailsDataModelElement.rating.equals('2'.toString())">
										        <span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star"></span>
											</s:if>
											<s:if test="#fundDetailsDataModelElement.rating.equals('1'.toString())">
										        <span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star"></span>
											</s:if>
									        <article class="g-margin-t-10--xs g-margin-b-10--xs">  Past returns:</article>
									        <table class="table-bordered" cellspacing="0" width="80%">
										        <thead>
										            <tr class="g-bg-color--white" >
										                <th class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">1 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">3 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">5 yr</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-bg-color--white" >
										                <td class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">
										                	<s:property value="#fundDetailsDataModelElement.returnsOneYear"/>
										                		<s:if test="#fundDetailsDataModelElement.returnsOneYear.equals('NA'.toString())"></s:if>
										                		<s:else>%</s:else>
									                		</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">
															<s:property value="#fundDetailsDataModelElement.returnsThreeYears"/>
															<s:if test="#fundDetailsDataModelElement.returnsThreeYears.equals('NA'.toString())"></s:if>
										                		<s:else>%</s:else>
														</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">
															<s:property value="#fundDetailsDataModelElement.returnsFiveYears"/>
															<s:if test="#fundDetailsDataModelElement.returnsFiveYears.equals('NA'.toString())"></s:if>
										                		<s:else>%</s:else>	
														</span></td>
										            </tr>
										        </tbody>
										    </table>
									       	</article>
									       	
				  				 </figcaption>
		  						 <a href="#"></a>
								</figure>
								
							</div>
						</div>
			</s:iterator> 
		</div>	
		
		<s:form  action="buyFundAction" method="post" name="formBuyFundAction">
	  		<s:hidden id="fund-id-value" name="fundId"></s:hidden>
	  		<s:hidden id="folio-num-value" name="folioNum"></s:hidden>
		</s:form>
  				
	  	</div>
	  	</div>   
	  	<br/>
	  	<br/>
        
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
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="terms.jsp">Terms &amp; Conditions</a></li>
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
                    &copy; 2019 <a href="#" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
                </div>
                </div>
            </div>
            <!-- End Copyright -->
        </footer>
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>


       <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
	    <script src="assets/js/jquery.js"></script>
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
	    <script src="assets/js/sly.min.js"></script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
	    <script src="assets/js/jquery.isotope.min.js"></script>
	    <script src="assets/js/main.js"></script>
	    <script src="assets/js/wow.min.js"></script>
	    <script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
		<!-- Vendor -->
       <%--  <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
        <script type="text/javascript" src="vendor/swiper/swiper.jquery.min.js"></script>
        <script type="text/javascript" src="vendor/waypoint.min.js"></script>
        <script type="text/javascript" src="vendor/counterup.min.js"></script>
        <script type="text/javascript" src="vendor/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.parallax.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.wow.min.js"></script>
        <script src="js/owl.carousel.min.js"></script> --%>
      	

        <!-- General Components and Settings -->
        <%-- <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="js/components/magnific-popup.min.js"></script>
        <script type="text/javascript" src="js/components/swiper.min.js"></script>
        <script type="text/javascript" src="js/components/counter.min.js"></script>
        <script type="text/javascript" src="js/components/portfolio-3-col.js"></script>
        <script type="text/javascript" src="js/components/parallax.min.js"></script>
        <script type="text/javascript" src="js/components/google-map.min.js"></script>
        <script type="text/javascript" src="js/components/wow.min.js"></script> --%>
        <!--========== END JAVASCRIPTS ==========-->
        
 <script>
         document.onreadystatechange = function () {
        	/*  $(myInput).keyup(function() {
		 		    var value = $(this).val().toLowerCase();
		 		    $("#myDiv1 div").filter(function() {
		 		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		 		    });
		 		  }); */
        	 
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
         
        /*  $(document).ready(function(){
 			
 		}); */
         
         </script>
    </body>
    <!-- End Body -->
</html>
