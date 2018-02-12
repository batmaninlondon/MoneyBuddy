<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%> --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Fund Details | Money Buddy</title>
    <!-- core CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" >
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/font-awesome.min.css" >
   
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
    
    <!-- Commented CSS for testing -->
    <!--  <link href="assets/bootstrap/css/responsive.css" rel="stylesheet"> -->
    <%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> --%>
    <!-- <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet"> -->
    <!-- <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet"> -->
   	<!--  <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet"> -->
   	
   	<!-- <link rel="shortcut icon" href="images/ico/favicon.ico">
   	<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png"> -->
    
</head>

<body  onLoad="showPredictedSipValues(<s:property value="#session.selectedFundDetailsDataModel.minSipAmount"/>)">
	<div id="load" class="load"></div>
	<div id="content">
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
                                <a href="myIndex" class="s-header-v2__logo-link">
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
                                    <li class="s-header-v2__nav-item"><a href="myIndex" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="saveTax" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class=" s-header-v2__nav-item s-header-v2__dropdown-on-hover">
                                        <a href="javascript:getMfData()" class="dropdown-toggle s-header-v2__nav-link -is-active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Funds<span class="g-font-size-10--xs g-margin-l-5--xs "></span></a>
                                    </li>
                                    <li class="s-header-v2__nav-item"><a href="aboutUs" class="s-header-v2__nav-link">About Us</a></li>
                                    <li class="s-header-v2__nav-item"><a href="blog" class="s-header-v2__nav-link">Blog</a></li>
                                    <li class="s-header-v2__nav-item"><a href="help" class="s-header-v2__nav-link">FAQs</a></li>
                                    <li class="s-header-v2__nav-item"><a href="startSip" class="s-header-v2__nav-link">Contact Us</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/Register</a></li>
										<%	} else 
										 	{	%>
										 			 <li class="s-header-v2__nav-item"><a href="javascript:setDashboardData()" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li class="s-header-v2__nav-item"><a href="logOff" class="s-header-v2__nav-link">Log Out</a></li>
										<%	}	%>  
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
		<%session.setAttribute("fundSelected", "TRUE");%>
		<div class="g-bg-color--dark">
            <div class="container g-padding-y-45--xs">
            </div>
        </div>
		<!-- <div class="  g-fullheight--xs g-bg-position--center swiper-slide" style="background: url(img/1920x1080/02.jpg) 50% 0 no-repeat fixed;"> -->
          <div class="row ">
        		<%
					if (session.getAttribute("customerId") == null) {
						System.out.println("customerId is null ");
				%>
				<input type="hidden" id="cusId" value="customerIdNull" />
				<%
					} else {
						System.out.println("customerId is not null ");
				%>
				<input type="hidden" id="cusId" value="customerExists" />
				<%
					}
				%>
        	</div> 
        	<s:set var="fundDetails" value="#session.selectedFundDetailsDataModel" />
        	<div class=" g-bg-color--primary-white  " >
		 		<div class="container ">
			 		<div class="row  ">
					 		<div class="col-md-8 col-xs-12 ">
					 			<input type="hidden" id="fundId" value="<s:property value="#fundDetails.fundId"/>" />
					 		 	<h1 class="g-font-size-35--xs g-font-size-45--sm g-font-size-50--lg  g-margin-t-20--xs"><s:property value="#fundDetails.fundName"/></h1>
				            </div>
		            		<div class="col-md-1 col-xs-6  g-hor-centered-row__col g-margin-t-25--xs g-margin-b-0--lg ">
		                     	<a  href="javascript:callOneTimeInvestment()" class="text-uppercase s-btn s-btn--md g-bg-color--primary  g-color--white g-radius--30 g-padding-x-10--xs">One time Investment</a>
		                    </div>
		                    <div class="col-md-1  g-hor-centered-row__col g-margin-t-10--xs g-margin-b-0--lg ">
		                    </div>
		             		<div class="col-md-1 col-xs-6 g-hor-centered-row__col g-margin-t-25--xs g-margin-b-0--lg ">
		                   		<a  href="javascript:callSIPInvestment()" class="text-uppercase s-btn s-btn--md g-bg-color--primary  g-color--white g-radius--30 g-padding-x-10--xs">Regular Investment</a>
		                    </div>
		                    <div class="col-md-1 col-xs-6 g-hor-centered-row__col g-margin-t-10--xs g-margin-b-0--lg ">
		                    </div>
		            </div> 
		            <div class="row ">
					 		<div class="col-md-8 col-xs-12 g-margin-t-25--xs g-margin-b-25--xs">
					 		 	<table id="portfoliosummary" class="display" >
										        <tbody>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" >
										                	<span class=" g-font-size-14--xs g-font-size-5--xs">
											                	<s:if test="#fundDetails.rating.equals('5'.toString())">
															        <span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																</s:if>
																<s:if test="#fundDetails.rating.equals('4'.toString())">
															        <span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star"></span>
																</s:if>
																<s:if test="#fundDetails.rating.equals('3'.toString())">
															        <span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star "></span>
																	<span class="fa fa-star"></span>
																</s:if>
																<s:if test="#fundDetails.rating.equals('2'.toString())">
															        <span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star "></span>
																	<span class="fa fa-star "></span>
																	<span class="fa fa-star"></span>
																</s:if>
																<s:if test="#fundDetails.rating.equals('1'.toString())">
															        <span class="fa fa-star g-color--primary"></span>
																	<span class="fa fa-star "></span>
																	<span class="fa fa-star "></span>
																	<span class="fa fa-star "></span>
																	<span class="fa fa-star"></span>
																</s:if>
															</span>
										                </td>
														<td class="" ><span class=" g-font-size-14--xs"><b>Risk :</b> <s:property value="#fundDetails.risk"/></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"><b>Category :</b> <s:property value="#fundDetails.sector"/></span></td>
														<td class="" ><span class=" g-font-size-14--xs"><b>Sector :</b> <s:property value="#fundDetails.subSector"/></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"><b>AAUM :</b> &#8377; 4039.34 Cr <small>as on 31 Jan 2018 </small></span></td>
										                 <td class="" ><span class=" g-font-size-14--xs"><b>Inception :</b> <s:property value="#fundDetails.fundStartDate"/></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td ><span class=" g-font-size-14--xs g-margin-r-60--xs"><b>Mins SIP Investment:</b> &#8377;<s:property value="#fundDetails.minSipAmount"/></span></td>
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-3--xs "><b>Min Onetime Investment :</b> &#8377; <s:property value="#fundDetails.minLumsumAmount"/></span></td>
										            </tr>
										        </tbody>
								</table>
								
							</div>
					 		 	<!--  <div class="row g-margin-t-50--xs"></div>
				            	</div> -->
		            		<div class="col-md-4 col-xs-6  g-full-width--xs ">
                				<table id="portfoliosummary" class="display" >
										        <tbody>
										            <tr class="g-margin-b-45--xs">
										                <td colspan="2" class="" ><span class=" g-font-size-16--xs g-font-size-5--xs g-color--primary"><b>Annualised Returnns</b></span><br/><br/></td>
										            </tr>
										            
										            <%-- <tr >
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"><input id="range" type="range" min="<s:property value="#fundDetails.minSipAmount"/>" max="150000" step="500" value="<s:property value="#fundDetails.minSipAmount"/>" onchange="showPredictedSipValues(this.value)" style=" width: 100px;"/> </span></td>
														<td class="" >&#8377;<span id="investmentAmount" class=" g-font-size-14--xs"> </span></td>
										            </tr>
										              <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" >&nbsp;</td>
										                 <td class="" ></td>
										            </tr> --%>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"> 1 YR 	 </span></td>
														<td class="" ><span class=" g-font-size-14--xs">&#8377;<s:property value="#fundDetails.returnsOneYear"/></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"> 3 YR </span></td>
										                 <td class="" ><span class=" g-font-size-14--xs">&#8377;<s:property value="#fundDetails.returnsThreeYears" /></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs"> 5 YR</span></td>
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"> &#8377;<s:property value="#fundDetails.returnsFiveYears" /></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs"> Since Inception</span></td>
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"> &#8377;<s:property value="#fundDetails.returnsSinceInception" /></span></td>
										            </tr>
										        </tbody>
										    </table>
               				</div>
		            </div> 
				</div>
		    </div> 
		    
		    
		    <div class="js__parallax-window "> 
            	<div class="container ">
	               <div class="">
	               <div class="g-text-center--xs ">
	                    	<h3 class="g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--primary text-left font-weight-bold g-hor-divider__solid--heading-light  g-margin-t-40--xs"><b>Fund Details</b></h3>
	                	</div>
	                	  <iframe src="<s:property value="#fundDetails.pdfFilePath" />" style="width:100%; height:800px;" ></iframe>
	               </div> 
	               
	               <!-- <div class="g-box-shadow__dark-lightest-v4">
	                	<div class="row " >
		             		<div class="col-md-12 col-xs-12 g-full-width--xs  g-bg-color--white " >
		             			<div class="g-text-center--xs g-margin-b-10--xs g-margin-t-40--xs">
		                			<ul class="nav nav-tabs">
		    							<li><a data-toggle="tab" href="#funddetails">Fund Details</a></li>
		    							<li class="active"><a data-toggle="tab" href="#pastreturns" >Past Returns</a></li>
		 							</ul>
		                		</div> 
			              		</div>
	                	</div>   
	                	<div class="row" >
	             			<div class="col-md-12 col-xs-12 g-full-width--xs g-bg-color--white " >
	             				<div class="g-text-center--xs g-margin-b-10--xs g-margin-t-40--xs">
	                				<div class="tab-content">
	   		 							<div id="funddetails" class="tab-pane fade">
	   		 								<iframe src="img/riskometer/4373-A-fact-sheet.pdf" style="width:100%; height:500px;" frameborder="0"></iframe>
	   								 	</div>
	   								 	<div id="pastreturns" class="tab-pane fade in active ">
	    									<div class="row g-margin-t-50--xs"><img src="img/riskometer/Low.jpg" height="150"/></div>
	    								</div>
	  								</div>
	                			</div> 
		              		</div>
	                	</div>  
	               </div>  -->
	           	   <br/><br/><br/>
	            </div>
		    </div>
		<input type="hidden" id="transactionType" value="UPFRONT" />	
</div>

        <!--========== FOOTER ==========-->
        <footer class="g-bg-color--dark">
            <!-- Links -->
            <div class="g-hor-divider__dashed--white-opacity-lightest">
                <div class="container g-padding-y-80--xs">
                    <div class="row">
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">About</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Work</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Contact</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Twitter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Facebook</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Instagram</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">YouTube</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2 g-margin-b-40--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Subscribe to Our Newsletter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Privacy Policy</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes">Terms &amp; Conditions</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1 s-footer__logo g-padding-y-50--xs g-padding-y-0--md">
                            <h3 class="g-font-size-18--xs g-color--white">Megakit</h3>
                            <p class="g-color--white-opacity">We are a creative studio focusing on culture, luxury, editorial &amp; art. Somewhere between sophistication and simplicity.</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Links -->

            <!-- Copyright -->
            <div class="container g-padding-y-50--xs">
                <div class="row">
                    <div class="col-xs-6">
                        <a href="index.html">
                            <img class="g-width-100--xs g-height-auto--xs" src="img/logo.png" alt="Megakit Logo">
                        </a>
                    </div>
                    <div class="col-xs-6 g-text-right--xs">
                        <p class="g-font-size-14--xs g-margin-b-0--xs g-color--white-opacity-light"><a href="http://keenthemes.com/preview/Megakit/">Megakit</a> Theme Powered by: <a href="http://www.keenthemes.com/">KeenThemes.com</a></p>
                    </div>
                </div>
            </div>
            <!-- End Copyright -->
        </footer>
       
      </body>
        <!--========== END FOOTER ==========-->

</body>

		<!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>

       <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
		
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
 		<script src="assets/js/jquery.js"></script>
    	<script type="text/javascript" src="js/components/header-sticky.min.js"></script>
    	
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
        <!--========== END JAVASCRIPTS ==========-->
        
        <!--========== Commented JAVASCRIPTS ==========-->
        
       <%--  <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> 
		<script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
    	<script src="assets/js/main.js"></script>
    	<script src="assets/js/wow.min.js"></script> 
    	<script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
    	<script src="assets/js/main.js"></script>
    	<script src="assets/js/wow.min.js"></script> 
        <script type="text/javascript" src="js/global.min.js"></script> 
        <script src="assets/bootstrap/js/bootstrap.min.js"></script> --%>

</html>
