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
		<meta http-equiv="Cache-control" content="max-age=2592000, public">
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
	
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Theme Styles -->
        <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
 	
  
  <script type="text/javascript" src="assets/js/jquery-latest.js"></script>
  
  
<style>
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Raleway:400,500,700);

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

        <!--========== PAGE CONTENT ==========-->
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
        	<div  >
		 		<div class="container ">
			 		<div class="row  ">
					 		<div class="col-md-12 col-xs-12 g-text-center--sm ">
					 			<input type="hidden" id="fundId" value="<s:property value="#fundDetails.fundId"/>" />
					 		 	<p class="text-center g-line-height--sm g-font-size-12--xs g-font-size-22--lg  g-margin-t-20--xs g-color--primary " ><b><s:property value="#fundDetails.schemeName"/></b></p>
				            </div>
		            </div> 
		            <br>
		            <div class="row ">
					 		<div class="col-md-8 col-xs-12  g-margin-b-25--xs">
					 		 	<table id="portfoliosummary" class="display" >
										        <tbody>
										         <tr  >
										                <td colspan="2" ><span class=" g-color--primary g-font-size-12--xs g-font-size-16--lg "><b>Fund Details</b></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;" class="g-font-size-14--lg g-font-size-10--xs">
										                <td>
										                	<span>
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
														<td><span><b>Risk :</b> <s:property value="#fundDetails.risk"/></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;" class="g-font-size-14--lg g-font-size-10--xs">
										                <td><span><b>Scheme Type :</b> <s:property value="#fundDetails.schemeType"/></span></td>
														<td><span><b>Category :</b> <s:property value="#fundDetails.category"/></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;" class="g-font-size-14--lg g-font-size-10--xs">
										                <td><span><b>AUM :</b> Rs. 4,039.34 Cr </span></td>
										                <td><span><b>Inception Date:</b> <s:property value="#fundDetails.startDate" /></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;" class="g-font-size-14--lg g-font-size-10--xs">
										                <td ><span class="g-margin-r-60--xs"><b>Min SIP Investment :</b> Rs.<s:property value="%{getText('{0,number,#,##0}',{#attr[#fundDetails.minSipAmount]})}"/><small> /month</small></span></td>
										                <td><span><b>Min Onetime Investment :</b> Rs. <s:property value="%{getText('{0,number,#,##0}',{#attr[#fundDetails.minPurchaseAmount]})}"/></span></td>
										            </tr>
										        </tbody>
								</table>
								
							</div>
					 		 	<!--  <div class="row g-margin-t-50--xs"></div>
				            	</div> -->
		            		<div class="col-md-4 col-xs-6  g-full-width--xs ">
                				<table id="portfoliosummary" class="display" >
										        <tbody>
										            <tr  >
										                <td colspan="2" ><span class=" g-color--primary  g-font-size-12--xs g-font-size-16--lg "><b>Past Returns (% per year)</b></span></td>
										            </tr>
										            
										            <%-- <tr >
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"><input id="range" type="range" min="<s:property value="#fundDetails.minSipAmount"/>" max="150000" step="500" value="<s:property value="#fundDetails.minSipAmount"/>" onchange="showPredictedSipValues(this.value)" style=" width: 100px;"/> </span></td>
														<td class="" >Rs.<span id="investmentAmount" class=" g-font-size-14--xs"> </span></td>
										            </tr>
										              <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" >&nbsp;</td>
										                 <td class="" ></td>
										            </tr> --%>
										            <tr style=" border-bottom: solid 0.5px gray;" class="g-font-size-14--lg g-font-size-10--xs">
										                <td><span> 1 Year 	 </span></td>
										                <td></td>
														<td><span><s:property value="#fundDetails.returnsOneYear"/>&nbsp;&nbsp;%</span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;" class="g-font-size-14--lg g-font-size-10--xs">
										                <td><span> 3 Year </span></td>
										                <td></td>
										                 <td><span><s:property value="#fundDetails.returnsThreeYears" />&nbsp;&nbsp;%</span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;" class="g-font-size-14--lg g-font-size-10--xs">
										                <td><span> 5 Year</span></td>
										                <td></td>
										                <td><span> <s:property value="#fundDetails.returnsFiveYears" />&nbsp;&nbsp;%</span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;" class="g-font-size-14--lg g-font-size-10--xs">
										                <td><span> Since Inception</span></td>
										                <td></td>
										                <td><span><s:property value="#fundDetails.returnsSinceInception" />&nbsp;&nbsp;%</span></td>
										            </tr>
										        </tbody>
										    </table>
               				</div>
		            </div> 
		            
		            <s:form  action="addToCartAction" method="post" name="formAddToCart" namespace="/">
                   		<s:hidden id="transaction-type" name="transactionType"></s:hidden>
                	 </s:form>
                      <div class="row ">
		            	<div class="col-xs-1 col-md-4 ">
		                    </div>
		                    <div class="col-xs-5 col-md-2 g-hor-centered-row__col g-margin-t-15--xs g-margin-b-0--lg ">
		                     	<%-- <s:form  action="newEstimateAction" method="post" name="formEstimate">
							  		<s:hidden id="select-folio-num-value" name="selectFolioNum"></s:hidden>
							  		<s:hidden id="upfront-investment-value" name="upfrontInvestment"></s:hidden>
									<s:hidden id="sip-amount-value" name="sipAmount"></s:hidden>
									<s:hidden id="sip-duration-value" name="sipDuration"></s:hidden>
									<s:hidden id="sip-plan-value" name="sipPlan"></s:hidden>
									<s:hidden id="sip-date-value" name="sipDate"></s:hidden>
									<s:hidden id="transaction-type-value" name="transactionType" value="UPFRONT"></s:hidden>
							  	</s:form> --%>
							  	<a  href="javascript:callOneTimeInvestment()" class="btn btn-home g-padding-x-10--xs g-font-size-14--xs g-font-size-18--lg" >Invest Lumpsum</a>
		                    </div>
		                    
		                    <s:if test="#fundDetails.sipFlag.equals('Y'.toString())">
			             		<div class="col-md-2 col-xs-5 g-hor-centered-row__col g-margin-t-15--xs g-margin-b-0--lg ">
			                   		<a  href="javascript:callSIPInvestment()" class="btn btn-home g-padding-x-10--xs g-font-size-14--xs g-font-size-18--lg">Start SIP</a>
			                    </div>
		                    </s:if>
		                    <div class="col-md-2 col-xs-1">
		                    </div>
		            </div>
				</div>
		    </div> 
		    
		    
		    <div class="js__parallax-window "> 
            	<div class="container ">
	               <div class="">
	               <div class="g-text-center--xs ">
	                    	<!-- <h3 class="g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--primary text-left font-weight-bold g-hor-divider__solid--heading-light  g-margin-t-40--xs"><b>Additional Fund Details</b></h3> -->
	                		
	                		<!-- document.getElementById(objFRM).href = local_src; -->
	                	</div>
	                	<%-- <link rel="import" href="<s:property value="#fundDetails.pdfFilePath" />"> --%>
	                		<%-- <embed src="<s:property value="#fundDetails.pdfFilePath" />"  /> --%>
	                		<br/>
	                	  <iframe class="g-height-500--xs g-height-600--lg" src="<s:property value="#fundDetails.pdfFilePath" />" style="width:100%;" ></iframe>
	               </div> 
	               
	           	   <br/><br/><br/>
	            </div>
		    </div>
		<!-- <input type="hidden" id="transactionType" value="UPFRONT" />	 -->

        
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


       <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
	    <script type="text/javascript" src="assets/js/javaScript.js"></script>
	    
	    <script src="assets/js/jquery.js"></script>
	    
	    <script src="assets/js/sly.min.js"></script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
	    <script src="assets/js/jquery.isotope.min.js"></script>
	    <script src="assets/js/main.js"></script>
	    <script src="assets/js/wow.min.js"></script>
	    
        <!--========== END JAVASCRIPTS ==========-->
        
 <%-- <script>
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
         
         </script> --%>
    </body>
    <!-- End Body -->
</html>
