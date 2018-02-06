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
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
   	<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
    
    
    
    
    
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

<body class="homepage" onLoad="showPredictedSipValues(<s:property value="#session.selectedFundDetailsDataModel.minSipAmount"/>)">
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
                                    <li class="s-header-v2__nav-item"><a href="nhome.jsp" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="nsavetax.jsp" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">About Us</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">Blog</a></li>
                                    <li class=" s-header-v2__nav-item s-header-v2__dropdown-on-hover">
                                        <a href="nfaq.jsp" class="dropdown-toggle s-header-v2__nav-link -is-active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">FAQs<span class="g-font-size-10--xs g-margin-l-5--xs "></span></a>
                                    </li>
                                    <li class="s-header-v2__nav-item"><a href="ncontact.jsp" class="s-header-v2__nav-link">Contact Us</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Sign in</a></li>
													<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Sign up</a></li>
										<%	} else 
										 	{	%>
										 			 <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">Log Out</a></li>
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
			<%
		session.setAttribute("fundSelected", "TRUE");
	%>
	<%-- <%session.setAttribute("fundSIPSelected", "TRUE");%> --%>
	<%-- <%session.setAttribute("fundOnetimeSelected", "TRUE");%> --%>
	
	
		<div class="g-fullheight--xs g-bg-position--center swiper-slide" style="background: url(img/1920x1080/10.jpg) 50% 0 no-repeat fixed;">
		
        	<br/>
        	 <br/>
        	 <br/>
        	 
        	<br/>
        	 <br/>
        	 <br/>
          <div class="row">
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
        	
        	<div class="g-bg-color--primary-ltr">
		 		<div class="container ">
			 		<div class="row g-text-center--xs ">
					 		<div class="col-md-8 col-xs-12 ">
				             	<h3 class="g-font-size-32--xs g-font-size-50--md  g-letter-spacing--1 g-color--white text-left font-weight-bold " style="font-family:brandonText; font-weight:900; letter-spacing:-0.05em"><s:property value="#fundDetails.fundName"/></h3>
				            </div>
		            		<div class="col-md-2 col-xs-6  g-hor-centered-row__col g-margin-b-10--xs g-margin-b-0--lg ">
		                     	<button name ="onetime" type="button" class="btn btn-primary readmore" onClick="callOneTimeInvestment();" style="margin-top:30px;padding:5px 15px 5px 15px;">Invest Lumsum</button>
		                    </div>
		             		<div class="col-md-2 col-xs-6 g-hor-centered-row__col g-margin-b-10--xs g-margin-b-0--lg ">
		                    	<button name= "sip" type="button" class="btn btn-primary readmore" onClick="callSIPInvestment();" style="margin-top:30px;padding:5px 15px 5px 15px;">Start SIP</button>
		                    </div>
		            </div> 
	             </div> 
			</div>
			<br/><br/>
			<div class="row g-text-center--xs ">
			 	<div class="col-md-1 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg  ">
                </div>
			 	
			 	<div class="col-md-5 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg g-bg-color--white g-box-shadow__dark-lightest-v4">
              		
              		<div class="g-padding-x-40--xs g-padding-y-40--xs" >
              			<input type="hidden" id="fundId" value="<s:property value="#fundDetails.fundId"/>" />
				    	<p class=" g-font-size-14--xs g-font-weight--700 g-letter-spacing--2"> <s:property value="#fundDetails.fundName"/></p>
				        <h3 class="g-font-size-22--xs g-letter-spacing--1 "><s:property value="#fundDetails.sector"/></h3>
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
                 <div class="col-md-1 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg  ">
                </div>
                <div class="col-md-4 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg  g-box-shadow__dark-lightest-v4" style="background-color: #eeeeee">
                	
                	<div class="row">
                		<div class="col-md-12 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg  ">
                			<p >Past Return Calculator</p>
                		</div>
                		<div class="col-md-1 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg  ">
                		</div>
                	</div>
                	
                	<div class="row">
                		<div class="col-md-4 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg  ">
                			<input id="range" type="range" min="<s:property value="#fundDetails.minSipAmount"/>" max="150000" step="500"
							value="<s:property value="#fundDetails.minSipAmount"/>" onchange="showPredictedSipValues(this.value)"/>
                		</div>
                		<div class="col-md-4 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg  ">
                		</div>
                		<div class="col-md-4 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg  ">
                			<p>Rs. <span id="investmentAmount"></span></p>
                		</div>
                	</div>
                	
                	
                	
					<div id="predicted-values-list" class="col-md-12"
				style="margin-top: 20px; padding-left: 130px; padding-right: 70px;">
				<div id="predicted-values-list-data" class="row col-md-12">

					<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
						<thead class="text-center g-font-size-5--xs g-font-size-10--sm g-font-size-10--md ">
							<tr class="g-bg-color--primary">
								<th rowspan="2" class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Invested Amount</span></th>
								<th colspan="3" rowspan="1" class="text-center" ><span class="g-color--white g-font-size-14--xs g-font-size-5--xs">Predicted Amount</span></th>
							</tr>
							<tr>
								<th colspan="1" rowspan="1" class="text-center" ><span class=" g-font-size-8--xs g-font-size-5--xs">After 1 year</span></th>
								<th colspan="1" rowspan="1" class="text-center" ><span class=" g-font-size-8--xs g-font-size-5--xs">After 3 year</span></th>
								<th colspan="1" rowspan="1" class="text-center" ><span class= g-font-size-8--xs g-font-size-5--xs">After 5 year</span></th>
							</tr>
						</thead>
						
						<tbody>
							<tr class="text-center g-font-size-15--xs g-font-size-15--sm g-font-size-15--md g-color--white">
								<td class="center">
									<p>Rs. <span id="sipAmount"><s:property value="#session.sipAmount" /></span></p>
								</td>
								<td class="center">
									<div id="predictedValue1">
										<p>Rs. <span id="predicted-value-for-one-year"><s:property value="#session.predictedValueForOneYear" /></span></p>
									</div>
								</td>
								<td class="center">
									<div id="predictedValue2">
										<p>Rs. <span id="predicted-value-for-three-year"><s:property value="#session.predictedValueForThreeYear" /></span></p>
									</div>
								</td>
								<td class="center">
									<div id="predictedValue3">
										<p>Rs. <span id="predicted-value-for-five-year"><s:property value="#session.predictedValueForFiveYear" /></span></p>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
                 </div>
                 <div class="col-md-1 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg  ">
                </div>
                
                
		    </div> 
        	
                
            </div>                     			
	
  
  
<input type="hidden" id="transactionType" value="UPFRONT" />	
  
  
  
      

</body>
</html>
