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
    <title>Fund Details | Money Buddy</title>
    <!-- core CSS -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
    
   	
   	<link rel="shortcut icon" href="images/ico/favicon.ico">
   	<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
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
                                <a href="nhome.jsp" class="s-header-v2__logo-link">
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
                                    <li class="s-header-v2__nav-item"><a href="ncontact.jsp" class="s-header-v2__nav-link">Contact Us</a></li>
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
        	<div class=" g-bg-color--sky-light  " style="height:400px">
		 		<div class="container ">
			 		<div class="row  ">
					 		<div class="col-md-8 col-xs-12 ">
					 			<input type="hidden" id="fundId" value="<s:property value="#fundDetails.fundId"/>" />
					 		 	<h1 class="g-font-size-35--xs g-font-size-45--sm g-font-size-50--lg  g-margin-t-20--xs"><s:property value="#fundDetails.fundName"/></h1>
				            </div>
		            		<div class="col-md-1 col-xs-6  g-hor-centered-row__col g-margin-t-25--xs g-margin-b-0--lg ">
		                     	<a  href="javascript:callOneTimeInvestment()" class="text-uppercase s-btn s-btn--md s-btn--white-bg g-radius--30 g-padding-x-10--xs">One time Investment</a>
		                    </div>
		                    <div class="col-md-1 col-xs-6 g-hor-centered-row__col g-margin-t-10--xs g-margin-b-0--lg ">
		                    </div>
		             		<div class="col-md-1 col-xs-6 g-hor-centered-row__col g-margin-t-25--xs g-margin-b-0--lg ">
		                   		<a  href="javascript:callSIPInvestment()" class="text-uppercase s-btn s-btn--md s-btn--white-bg g-radius--30 g-padding-x-10--xs">Regular Investment</a>
		                    </div>
		                    <div class="col-md-1 col-xs-6 g-hor-centered-row__col g-margin-t-10--xs g-margin-b-0--lg ">
		                    </div>
		            </div> 
		            <div class="row ">
					 		<div class="col-md-8 col-xs-12 g-margin-t-25--xs">
					 		 	<table id="portfoliosummary" class="display" cellspacing="0" width="80%">
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
														<td class="" ><span class=" g-font-size-14--xs">Sector: <s:property value="#fundDetails.subSector"/></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs">Category : <s:property value="#fundDetails.sector"/></span></td>
														<td class="" ><span class=" g-font-size-14--xs">Sector: <s:property value="#fundDetails.subSector"/></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs">AAUM : &#8377; 4039.34 Cr as on 31 Jan 2018</span></td>
										                 <td class="" ><span class=" g-font-size-14--xs">Inception: <s:property value="#fundDetails.fundStartDate"/></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs">Min SIP Amount: &#8377;<s:property value="#fundDetails.minSipAmount"/></span></td>
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs">Minimum Lumpsum Amount  : &#8377; <s:property value="#fundDetails.minLumsumAmount"/></span></td>
										            </tr>
										        </tbody>
								</table>
					 		 	 <div class="row g-margin-t-50--xs"><img src="img/riskometer/moderately_high.png" height="100"/></div>
				            	</div>
		            		<div class="col-md-4 col-xs-6  g-full-width--xs     g-margin-t-25--xs  ">
                				<table id="portfoliosummary" class="display" cellspacing="0" width="80%">
										        <tbody>
										            <tr class="g-margin-b-45--xs">
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs">Past Return Calculator1</span><br/><br/></td>
										            </tr>
										            
										            <tr >
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"><input id="range" type="range" min="<s:property value="#fundDetails.minSipAmount"/>" max="150000" step="500" value="<s:property value="#fundDetails.minSipAmount"/>" onchange="showPredictedSipValues(this.value)" style=" width: 100px;"/> </span></td>
														<td class="" >&#8377;<span id="investmentAmount" class=" g-font-size-14--xs"> </span></td>
										            </tr>
										              <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" >&nbsp;</td>
										                 <td class="" ></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs">After 1 yr : </span></td>
														<td class="" ><span class=" g-font-size-14--xs">&#8377;<s:property value="#session.predictedValueForOneYear" /></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs">After 3 yrs :</span></td>
										                 <td class="" ><span class=" g-font-size-14--xs">&#8377;<s:property value="#session.predictedValueForThreeYear" /></span></td>
										            </tr>
										            <tr style=" border-bottom: solid 0.5px gray;">
										                <td class="" ><span class=" g-font-size-14--xs">After 5 yrs: &#8377;<s:property value="#fundDetails.minSipAmount"/></span></td>
										                <td class="" ><span class=" g-font-size-14--xs g-font-size-5--xs"> &#8377;<s:property value="#session.predictedValueForFiveYear" /></span></td>
										            </tr>
										        </tbody>
										    </table>
               				</div>
		            </div> 
				</div>
		    </div> 
		    <div class=" g-bg-color--primary-white " style="height:400px">
		    
		    
		    <div class="row" >
				<div class="col-md-1 col-xs-1" ></div>
				<div class="col-md-10 col-xs-10  g-bg-color--white ">
			    	<div class="profile">
						<div class="name">
					    	<div class="container">
					    	<br/>
		  						<ul class="nav nav-tabs">
		    						<li class="active"><a data-toggle="tab" href="#onetime" onClick="newUpdate('UPFRONT');">Invest Lumsum</a></li>
		   							<li><a data-toggle="tab" href="#sip" onClick="newUpdate('SIP');">Start SIP</a></li>
		 						</ul>
		  					</div>
		  				</div>
		  			</div>
		  		</div>
		  		<div class="col-md-1 col-xs-1" ></div>
  			</div>
  			
  			<div class="row "  >
				<div class="col-md-1 col-xs-1" > </div>
				<div class="col-md-10 col-xs-10  g-bg-color--white ">
			    <div class="tab-content">
		    		<div id="onetime" class="tab-pane fade in active g-margin-t-30--xs">
		      			<div id="upfrontInvestmentDetails">
			    			<!-- <input type="hidden" id="transactionType" value="UPFRONT" /> -->
			        		<div class="name g-margin-t-40--xs">
								<div class="row g-margin-t-50--xs g-margin-b-50--xs">
										<div id="investment-options" class="col-md-4 col-xs-12">
											<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Enter the amount you want to invest</p>
										</div>
										<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
										<input id="upfront-investment-range" type="range" min="<s:property value="#session.minLumsumAmount"/>" max="150000" step="500"
														 value="<s:property value="#session.minLumsumAmount"/>" onchange="showNewUpfrontInvestment(this.value)"/>
										</div>
										<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Rs. <span id="upfrontInvestment" class="g-color--black"></span></p>
										<div class="col-md-5"></div>
									</div>
			  					<div class="row">
									<div class="g-bg-color--gray-lighter " style="height:60px;">
			    						<div class="profile" >
			        						<div class="name g-text-right--xs g-margin-r-10--xs" >
			        							<button type="button" class="btn  g-color--white g-margin-t-15--xs" onClick="createCart();"  style="background-color:black;" >Add to Cart</button>
			            					</div>
			       						</div>
			     					</div>
								</div>
								
							</div>
			       		</div>
		    		</div>
		   		 	<div id="sip" class="tab-pane fade">
		      			<div  id="sipInvestmentDetails" >
		   					<!-- <input type="hidden" id="transactionType" value="SIP" /> -->
			       				<div class="name">
									<div class="row g-margin-t-50--xs g-margin-b-50--xs">
										<div id="investment-options" class="col-md-5 col-xs-12">
											<p class="title g-margin-l-100--md g-margin-l-20--xs  " >How much do you want to invest monthly?</p>
										</div>
										<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
										<input id="sip-amount-range" type="range" min="<s:property value="#session.minSipAmount"/>" max="150000" step="500"
														 value="<s:property value="#session.minSipAmount"/>" onchange="showSipAmountPerMonth(this.value)"/>
										</div>
										<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Rs. <span id="sipPerMonth" class="g-color--black"></span></p>
										<div class="col-md-4"></div>
									</div>
									<div class="row g-margin-t-50--xs g-margin-b-50--xs">
										<div id="investment-options" class="col-md-5 col-xs-12">
											<p class="title g-margin-l-100--md g-margin-l-20--xs  " >How long do you expect to invest for?</p>
										</div>
										<div id="duration-value"  class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
										<input id="sip-duration-range" type="range" min="<s:property value="#session.minSipDuration"/>" max="50" step="1"
														 value="<s:property value="#session.minSipDuration"/>" onchange="showDuration(this.value)"/>
										</div>
										<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Yr. <span id="sip-duration" class="g-color--black"></span></p>
										<div class="col-md-4"></div>
									</div>
									<div class="row g-margin-t-50--xs g-margin-b-50--xs">
										<div id="investment-options" class="col-md-5 col-xs-12">
											<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Select SIP installment Date</p>
										</div>
										<div id="duration-value"  class="col-md-3   col-xs-6 g-margin-l-20--xs">
											<select class="form-control" id="sip-date" name="sipDate" onChange="showDate()">
										        <option value="1">1</option>
										        <option value="5" selected>5</option>
										        <option value="10">10</option>
										        <option value="15">15</option>
										        <option value="20">20</option>
										        <option value="25">25</option>
							      			</select>
										</div>
										<div class="col-md-4"></div>
									</div>
									<div class="row ">
										<%
										System.out.println("kycStaus in session in jsp: "+session.getAttribute("kycStatus"));
								    	System.out.println("custDetUploaded in session in jsp : "+session.getAttribute("custDetUploaded"));
								    	System.out.println("addCustDetUploaded in session in jsp : "+session.getAttribute("addCustDetUploaded"));
										if ("NC".equals(session.getAttribute("kycStatus"))) {
										%>
											<input type="hidden" id="redirectingPage" value="panCardVerifiction" />
										<%
										} else if ("DONE".equals(session.getAttribute("kycStatus"))) {
											if ("Y".equals(session.getAttribute("custDetUploaded")))  {
												System.out.println("bankDetails page ");
										%>
												<input type="hidden" id="redirectingPage" value="bankDetails" />
										<%
											}
											else {
												System.out.println("customerDetails page ");
										%>
												<input type="hidden" id="redirectingPage" value="customerDetails" />
										<%
											}
										} else  {
											if ("Y".equals(session.getAttribute("custDetUploaded")))  {
												if("Y".equals(session.getAttribute("addCustDetUploaded"))) {
													System.out.println("DownloadKycForm page ");
										%>
													<input type="hidden" id="redirectingPage" value="downloadKycForm" />
										<%
												}
												else {
													System.out.println("addCustomerDetails page ");
										%>
													<input type="hidden" id="redirectingPage" value="addCustomerDetails" />
										<%		
												}
											}
											else {
												System.out.println("customerDetails page ");
										%>
												<input type="hidden" id="redirectingPage" value="customerDetails" />
										<%
											}
											
										}
										%>
									</div>
									<div class="row">
										<div class=" g-bg-color--gray-lighter " style="height:60px;">
			    							<div class="profile" >
			        							<div class="name g-text-right--xs g-margin-r-10--xs " >
			        								<button type="button" class="btn g-color--white g-margin-t-15--xs" onClick="openCustomerDetailsPage();"  style="background-color:black;" >Continue</button>
			            						</div>
			       							</div>
			     						</div>
									</div>
									
			  						
							</div>
			       		</div>
    </div>
    
  </div>	
  		</div>
  		<div class="col-md-1 col-xs-1" ></div>
  	</div>
  	
		    
		    </div>
		    
		    
		<input type="hidden" id="transactionType" value="UPFRONT" />	
</div>
</body>

<!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>

       <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script type="text/javascript" src="js/global.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 		<script src="assets/js/jquery.js"></script>
    	<script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
    	<script src="assets/js/main.js"></script>
    	<script src="assets/js/wow.min.js"></script>
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
        
        
        

</html>
