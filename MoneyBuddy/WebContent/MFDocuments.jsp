<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.Map" %>
<%@ page language="java" import="java.util.LinkedHashMap" %>
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
	                    			
	                    			<p class="g-font-size-17--xs g-font-size-20--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-center font-weight-bold   g-margin-t-20--xs">
		                    			<b>We request you to kindly visit the AMC website to read the latest scheme related documents</b>
	                    			</p>
	                    			<br/>
	                    			<table  class="table table-bordered" style="width:90%" align="center">
	                    				<thead>
	                    					<tr>
		                    					<th class="text-center col-md-1" scope="col">Sl .No.</th>
		                    					<th class="text-center col-md-5" scope="col">Asset Management Company ( AMC) name</th>
		                    					<th class="text-center col-md-6" scope="col">Funds Document</th>
	                    					</tr>
	                    				</thead>
	                    				<tbody>
	                    				<%
								           
								            Map<String, String> fundData = new LinkedHashMap<String, String>();
								            fundData.put("Axis Asset Management Company Ltd.", "https://www.axismf.com/Downloads.aspx");
								            fundData.put("Baroda Pioneer Asset Management Company Limited", "http://www.barodapioneer.in/Downloads/Pages/application-form.aspx");
								            fundData.put("BOI AXA Investment Managers Private Limited", "https://www.boiaxamf.com/regulatory-reports");
								            fundData.put("Birla Sunlife Asset Management Company Limited", "https://mutualfund.adityabirlacapital.com/resources/forms");
								            fundData.put("BNP Paribas Asset Management India Pvt. Ltd.", "https://www.bnpparibasmf.in/downloads");
								            fundData.put("Canara Robeco Asset Management Company Limited", "http://old.canararobeco.com/forms-downloads/pages/SID-Scheme-Information-Document.aspx");
								            fundData.put("DSP BlackRock Investment Managers Private Limited", "https://www.dspblackrock.com/investor-centre/download");
								            fundData.put("Edelweiss Asset Management Limited", "http://www.edelweissmf.com/Download/Forms.aspx");
								            fundData.put("Franklin Templeton Asset Management (India) Private Limited", "https://www.franklintempletonindia.com/investor/resources");
								            fundData.put("HDFC Asset Management Company Limited", "http://www.hdfcfund.com/Downloads/");
								            fundData.put("HSBC Global Asset Management (India) Private Limited", "http://www.assetmanagement.hsbc.com/in/mutual-funds/downloads");
								            fundData.put("ICICI Prudential Asset Management Company Limited", "https://www.icicipruamc.com/Downloads.aspx");
								            fundData.put("IDBI Asset Management Ltd.", "https://www.idbimutual.co.in/Downloads/KIM-Plus-Application-Form");
								            fundData.put("IDFC Asset Management Company Private Limited", "https://www.idfcmf.com/download-centre.aspx?tab=sid");
								            fundData.put("India Infoline Asset Management Co. Ltd.", "http://www.iiflmf.com/downloads/information-documents");
								            fundData.put("Indiabulls Asset Management Company Limited", "http://www.indiabullsamc.com/kim-forms/");
								            fundData.put("JM Financial Asset Management Private Limited", "http://www.jmfinancialmf.com/Downloads/Addenda.aspx?SubReportID=538A8B27-62B1-4CFE-BFF2-65DDFF0D4627");
								            fundData.put("Kotak Mahindra Asset Management Company Limited", "https://assetmanagement.kotak.com/scheme-information-document");
								            fundData.put("L&T Investment Management Limited", "https://www.ltfs.com/companies/lnt-investment-management/downloads.html");
								            fundData.put("LIC Nomura Mutual Fund Asset Management Company Limited", "http://www.licmf.com/downloads/sid_sai");
								            fundData.put("Mirae Asset Global Investment Management (India) Private Limited", "https://www.miraeassetmf.co.in/downloads/forms");
								            fundData.put("Motilal Oswal Asset Management Company Limited", "https://www.motilaloswalmf.com/downloads/mutual-fund");
								            fundData.put("Essel Finance AMC Limited", "https://mutualfund.esselfinance.com/dnd_applicationform.php");
								            fundData.put("PPFAS Asset Management Pvt. Ltd.", "https://amc.ppfas.com/downloads/index.php");
								            fundData.put("DHFL Pramerica Asset Managers Pvt. Ltd", "http://www.dhflpramericamf.com/forms-and-updates");
								            fundData.put("Principal Pnb Asset Management Company Private Limited", "https://www.principalindia.com/downloads-funds.aspx");
								            fundData.put("Quantum Asset Management Company Private Limited", "https://www.quantumamc.com/Downloads.aspx");
								            fundData.put("Reliance Capital Asset Management Limited", "https://www.reliancemutual.com/investor-services/downloads/scheme-information-document/");
								            fundData.put("Invesco Asset Management (India) Private Limited", "https://invescomutualfund.com/literature-and-form?tab=Scheme");
								            fundData.put("SBI Funds Management Private Limited", "https://www.sbimf.com/en-us/forms");
								            fundData.put("Shriram Asset Management Company Limited", "http://www.shriramamc.com/AmcDownloads.aspx");
								            fundData.put("Sundaram Asset Management Company", "https://www.sundarammutual.com/Statutory%20Disclosures");
								            fundData.put("Tata Asset Management Limited", "http://www.tatamutualfund.com/downloads/scheme-information-document");
								            fundData.put("Taurus Asset Management Company Limited", "https://www.taurusmutualfund.com/Download/FMP.html");
								            fundData.put("UTI Asset Management Company Private Limited", "https://www.utimf.com/forms-and-downloads/");
								         
								            
								            request.setAttribute("myMap", fundData);
								        %>
	                    				<s:iterator value="%{#request.myMap}" status="status">
										    <tr>
	                    						<th class="text-center" scope="row"><s:property value="#status.index+1"></s:property></th	>
	                    						<td class="text-center" ><s:property value="key"></s:property></td>
	                    						<td class="text-center" ><a href="<s:property value="value"></s:property>">Link to read documents</a></td>
	                    					</tr>
                    					</s:iterator>
	                    				</tbody>
	                    			
	                    			</table>
		                    			
	                    			

	                    			
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
