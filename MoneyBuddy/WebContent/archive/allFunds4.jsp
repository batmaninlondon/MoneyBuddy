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
        <title>Megakit - HTML5 Theme</title>
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="Megakit - HTML5 Theme">
        <meta name="author" content="keenthemes.com">

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/swiper/swiper.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>
        

        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
        <!-- <link rel="stylesheet" type="text/css" href="css/cardio.css"> -->

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
       
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
    <script src="assets/js/index.js"></script>
  
  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
  
 <script>
		$(document).ready(function(){
		  $("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myDiv1 div ").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
</script>


<style>
.filterDiv {
  float: left;
  //background-color: #2196F3;
  color: #ffffff;
 // width: 100px;
  //line-height: 100px;
  text-align: center;
 // margin: 2px;
  display: none;
}

.show {
  display: block;
}


/* Style the buttons */
.btn {
  border: none;
  outline: none;
//  padding: 12px 16px;
  background-color: #f1f1f1;
  cursor: pointer;
}

.btn:hover {
  background-color: #ddd;
}

.btn.active {
  background-color: #666;
  color: white;
}
</style>

<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 400px;
  margin: auto;
  text-align: left;
  font-family: arial;
  padding: 12px 16px;
}

.title {
  height:60px;
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #13b1cd;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
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
                                     <li class=" s-header-v2__nav-item s-header-v2__dropdown-on-hover">
                                        <a href="nhome.jsp" class="dropdown-toggle s-header-v2__nav-link -is-active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Home<span class="g-font-size-10--xs g-margin-l-5--xs "></span></a>
                                    </li>
                                    <li class="s-header-v2__nav-item"><a href="nsavetax.jsp" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">About Us</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">Blog</a></li>
                                    <li class="s-header-v2__nav-item"><a href="nfaq.jsp" class="s-header-v2__nav-link">FAQs</a></li>
                                    <li class="s-header-v2__nav-item"><a href="ncontact.jsp" class="s-header-v2__nav-link">Contact Us</a></li>
                                   <!--  <li class="s-header-v2__nav-item"><a href="contacts.html" class="s-header-v2__nav-link s-header-v2__nav-link--dark">Contact Us</a></li> -->
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Sign in</a></li>
													<li class="s-header-v2__nav-item"><a href="nlogin.jsp" class="s-header-v2__nav-link">Sign up</a></li>
										<%	} else 
										 	{	%>
										 			 <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">Log Ouu</a></li>
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

        <!--========== PAGE CONTENT ==========-->
       
       <div class="g-bg-color--dark">
            <div class="g-container--md g-text-center--xs g-padding-y-40--xs">
            <br/><br/>
                <div class="g-margin-b-10--xs">
                    <h1 class="g-font-size-40--xs g-font-size-30--sm g-font-size-70--md g-color--white g-letter-spacing--1 g-margin-b-30--xs">Mutual Funds</h1>
                     <input class="form-control" id="myInput" type="text" placeholder="ENTER FUND A">
				  <br>
                <div id="myBtnContainer">
				  <div class="btn active" onclick="filterSelection('all')"> Show all</div>
				  <div class="btn" onclick="filterSelection('high')"> High Risk</div>
				  <div class="btn" onclick="filterSelection('medium')"> Medium Risk</div>
				  <div class="btn" onclick="filterSelection('low')"> Low Risk</div>
				  
				</div>
				</div>
            </div>
        </div>
        
    <div id="myDiv1" class="g-bg-color--white  ">
			<div id="myDiv2" class="row g-container--md  ">
				<s:iterator value="#session.fundDetailsDataModel" var="fundDetailsDataModelElement">
				<s:if test="#fundDetailsDataModelElement.risk.equals('High')">
					<div id="myDiv3" class="col-md-4  ">
						<div  class=" g-line-height--normal s-portfolio__item cbp-item  ">
							<s:set var="selectedFundId" value="#fundDetailsDataModelElement.fundId" />
							<div class="card">
		    					<p class="title"><s:property value="#fundDetailsDataModelElement.fundName"/> - High</p>
		    					<p><s:property value="#fundDetailsDataModelElement.sector"/>. <s:property value="#fundDetailsDataModelElement.subSector"/></p>	
						    	<p>Start Date : <s:property value="#fundDetailsDataModelElement.fundStartDate"/></p>                       
						        <p >Rating : <s:property value="#fundDetailsDataModelElement.rating"/></p>
						        <p >Risk : <s:property value="#fundDetailsDataModelElement.risk"/></p>
						        <p >3 yrs returns ss: <s:property value="#fundDetailsDataModelElement.returnsThreeYears"/>%</p>
						        <p >Minimum SIP Amount : <s:property value="#fundDetailsDataModelElement.minSipAmount"/>INR </p>
						        <p >Minimum SIP time : <s:property value="#fundDetailsDataModelElement.minSipYears"/> years</p>
						       	<p >Minimum One time Amount : <s:property value="#fundDetailsDataModelElement.minLumsumAmount"/> INR</p>
						       	<button  onClick="buyFundHandler(<s:property value="selectedFundId" />);" > Invest on this fund </button> 
							</div>
						</div>
					</div>
				 </s:if> 
		         <s:if test="#fundDetailsDataModelElement.risk.equals('Medium')">
		         	<div id="myDiv3" class="col-md-4 	">
						<div  class="  g-line-height--normal s-portfolio__item cbp-item  ">
							<s:set var="selectedFundId" value="#fundDetailsDataModelElement.fundId" />
							<div class="card">
		    					<p class="title"><s:property value="#fundDetailsDataModelElement.fundName"/> - Medium</p>
		    					<p><s:property value="#fundDetailsDataModelElement.sector"/>. <s:property value="#fundDetailsDataModelElement.subSector"/></p>	
						    	<p>Start Date : <s:property value="#fundDetailsDataModelElement.fundStartDate"/></p>                       
						        <p >Rating : <s:property value="#fundDetailsDataModelElement.rating"/></p>
						        <p >Risk : <s:property value="#fundDetailsDataModelElement.risk"/></p>
						        <p >3 yrs returns ss: <s:property value="#fundDetailsDataModelElement.returnsThreeYears"/>%</p>
						        <p >Minimum SIP Amount : <s:property value="#fundDetailsDataModelElement.minSipAmount"/>INR </p>
						        <p >Minimum SIP time : <s:property value="#fundDetailsDataModelElement.minSipYears"/> years</p>
						       	<p >Minimum One time Amount : <s:property value="#fundDetailsDataModelElement.minLumsumAmount"/> INR</p>
						       	<button  onClick="buyFundHandler(<s:property value="selectedFundId" />);" > Invest on this fund </button> 
							</div>
						</div>
					</div>
				 </s:if> 
		        <s:if test="#fundDetailsDataModelElement.risk.equals('Low')">
					<div id="myDiv3" class="col-md-4 ">
						<div  class="  g-line-height--normal s-portfolio__item cbp-item  ">
							<s:set var="selectedFundId" value="#fundDetailsDataModelElement.fundId" />
							<div class="card">
		    					<p class="title"><s:property value="#fundDetailsDataModelElement.fundName"/> - Low</p>
		    					<p><s:property value="#fundDetailsDataModelElement.sector"/>. <s:property value="#fundDetailsDataModelElement.subSector"/></p	>	
						    	<p>Start Date : <s:property value="#fundDetailsDataModelElement.fundStartDate"/></p>                       
						        <p >Rating : <s:property value="#fundDetailsDataModelElement.rating"/></p>
						        <p >Risk : <s:property value="#fundDetailsDataModelElement.risk"/></p>
						        <p >3 yrs returns ss: <s:property value="#fundDetailsDataModelElement.returnsThreeYears"/>%</p>
						        <p >Minimum SIP Amount : <s:property value="#fundDetailsDataModelElement.minSipAmount"/>INR </p>
						        <p >Minimum SIP time : <s:property value="#fundDetailsDataModelElement.minSipYears"/> years</p>
						       	<p >Minimum One time Amount : <s:property value="#fundDetailsDataModelElement.minLumsumAmount"/> INR</p>
						       	<button  onClick="buyFundHandler(<s:property value="selectedFundId" />);" > Invest on this fund </button> 
							</div>
						</div>
					</div>
				</s:if> 
			</s:iterator> 
			
			
		</div>	
	  	</div>  
	  	<br/>
	  	<br/>
		
	
		 
		<%-- <div id="myDiv1" class="g-bg-color--white  ">
			<div id="myDiv2" class="row   g-container--md  ">
				<s:iterator value="#session.fundDetailsDataModel" var="fundDetailsDataModelElement">
					<div id="myDiv3" class="col-md-4 ">
						<div  class=" filterDiv cars g-line-height--normal    ">
						<s:set var="selectedFundId" value="#fundDetailsDataModelElement.fundId" />
						<figure class="snip1418" onClick="buyFundHandler(<s:property value="selectedFundId" />);" >
	  					<figcaption>
	    					<h3><s:property value="#fundDetailsDataModelElement.fundName"/></h3>
	    					<h3>
	      						<s:property value="#fundDetailsDataModelElement.sector"/>. <s:property value="#fundDetailsDataModelElement.subSector"/>
	      					</h3>	
					    	<p>Start Date : <s:property value="#fundDetailsDataModelElement.fundStartDate"/></p>                       
					        <p >Rating : <s:property value="#fundDetailsDataModelElement.rating"/></p>
					        <p >Risk : <s:property value="#fundDetailsDataModelElement.risk"/></p>
					        <p >3 yrs returns ss: <s:property value="#fundDetailsDataModelElement.returnsThreeYears"/>%</p>
					        <p >Minimum SIP Amount : <s:property value="#fundDetailsDataModelElement.minSipAmount"/>INR </p>
					        <p >Minimum SIP time : <s:property value="#fundDetailsDataModelElement.minSipYears"/> years</p>
					       	<p >Minimum One time Amount : <s:property value="#fundDetailsDataModelElement.minLumsumAmount"/> INR</p>
	  				 </figcaption>
	  					<button  onClick="buyFundHandler(<s:property value="selectedFundId" />);" > Invest on this fund </button> 
					</figure>
				</div></div>
			</s:iterator> 
			
			
		</div>	
	  	</div>    --%>
		 
		 
   <!-- Portfolio Gallery -->
      <%--  <div  id="myDIV" class="container g-margin-b-100--xs g-hor-border-4__solid--white ">
            	<div id="js__grid-portfolio-gallery" class="cbp">
            
                <!-- ITEM 1 -->
                <s:iterator value="#session.fundDetailsDataModel" var="fundDetailsDataModelElement">
                	<s:if test="#fundDetailsDataModelElement.risk.equals('High')">
                	 		<div  class="s-portfolio__item cbp-item  HighRisk g-line-height--normal">
                	 		<div class="s-portfolio__img-effect g-line-height--normal">
		                        <!-- <img src="images/portfolio/recent/portfolio2.png"  alt="Portfolio Image"> -->
				                           <div class="	 g-box-shadow__dark-lightest-v2 g-text-center--xs g-padding-x-40--xs g-padding-y-20--xs g-line-height--normal" style="background-color: #eeeeee">
				                           <s:set var="selectedFundId" value="#fundDetailsDataModelElement.fundId" />
				                            <p class=" g-font-size-14--xs g-font-weight--700 g-color--primary g-line-height--exs"><s:property value="#fundDetailsDataModelElement.fundName"/></p>
				                            <h3 class="g-font-size-22--xs g-line-height--exs "><s:property value="#fundDetailsDataModelElement.sector"/>. <s:property value="#fundDetailsDataModelElement.subSector"/></h3>
				                            <p class="g-text-left--xs g-line-height--exs">Start Date : <s:property value="#fundDetailsDataModelElement.fundStartDate"/></p>
				                            <p class="g-text-left--xs g-line-height--exs">Rating : <s:property value="#fundDetailsDataModelElement.rating"/></p>
				                            <p class="g-text-left--xs g-line-height--exs">Risk : <s:property value="#fundDetailsDataModelElement.risk"/></p>
				                            <p class="g-text-left--xs g-line-height--exs">3 yrs returns : <s:property value="#fundDetailsDataModelElement.returnsThreeYears"/>%</p>
				                            <p class="g-text-left--xs g-line-height--exs">Minimum SIP Amount : <s:property value="#fundDetailsDataModelElement.minSipAmount"/>INR </p>
				                            <p class="g-text-left--xs g-line-height--exs">Minimum SIP time : <s:property value="#fundDetailsDataModelElement.minSipYears"/> years</p>
				                            <p class="g-text-left--xs g-line-height--exs">Minimum Lumpsup Amount : <s:property value="#fundDetailsDataModelElement.minLumsumAmount"/> INR</p>
				                            <p class="g-text-left--xs g-line-height--exs">Fund Category : <s:property value="#fundDetailsDataModelElement.fundCategory"/></p>
				                        </div>
		                    </div>
		                    <span class="s-portfolio__caption-hover--cc">
		                        <ul class="list-inline">
		                            <li>
		                             	<a href="images/portfolio/recent/slide/Slide2.jpg" class="cbp-lightbox s-icon s-icon--sm s-icon--white-bg g-radius--circle" data-title="Portfolio Item  <br/>  by KeenThemes Inc.">
		                             	<i class="ti-fullscreen"></i>
		                                </a>
		                           		<br/>
		                           		<br/>
		                           		<button type="button" class="btn " onClick="buyFundHandler(<s:property value="selectedFundId" />);">Invest Now</button>
		                			</li>
		                     </ul>
		                    </span> 
		                    </div>
		             </s:if> 
		             
		             <s:if test="#fundDetailsDataModelElement.risk.equals('Medium')">
                	 		<div  class="s-portfolio__item cbp-item  MediumRisk g-line-height--normal">
                	 		<div class="s-portfolio__img-effect g-line-height--normal">
		                        <!-- <img src="images/portfolio/recent/portfolio2.png"  alt="Portfolio Image"> -->
				                           <div class="	 g-box-shadow__dark-lightest-v2 g-text-center--xs g-padding-x-40--xs g-padding-y-20--xs g-line-height--normal" style="background-color: #eeeeee">
				                           <s:set var="selectedFundId" value="#fundDetailsDataModelElement.fundId" />
				                            <p class=" g-font-size-14--xs g-font-weight--700 g-color--primary g-line-height--exs"><s:property value="#fundDetailsDataModelElement.fundName"/></p>
				                            <h3 class="g-font-size-22--xs g-line-height--exs "><s:property value="#fundDetailsDataModelElement.sector"/>. <s:property value="#fundDetailsDataModelElement.subSector"/></h3>
				                            <p class="g-text-left--xs g-line-height--exs">Start Date : <s:property value="#fundDetailsDataModelElement.fundStartDate"/></p>
				                            <p class="g-text-left--xs g-line-height--exs">Rating : <s:property value="#fundDetailsDataModelElement.rating"/></p>
				                            <p class="g-text-left--xs g-line-height--exs">Risk : <s:property value="#fundDetailsDataModelElement.risk"/></p>
				                            <p class="g-text-left--xs g-line-height--exs">3 yrs returns : <s:property value="#fundDetailsDataModelElement.returnsThreeYears"/>%</p>
				                            <p class="g-text-left--xs g-line-height--exs">Minimum SIP Amount : <s:property value="#fundDetailsDataModelElement.minSipAmount"/>INR </p>
				                            <p class="g-text-left--xs g-line-height--exs">Minimum SIP time : <s:property value="#fundDetailsDataModelElement.minSipYears"/> years</p>
				                            <p class="g-text-left--xs g-line-height--exs">Minimum Lumpsup Amount : <s:property value="#fundDetailsDataModelElement.minLumsumAmount"/> INR</p>
				                            <p class="g-text-left--xs g-line-height--exs">Fund Category : <s:property value="#fundDetailsDataModelElement.fundCategory"/></p>
				                        </div>
		                    </div>
		                    <div class="s-portfolio__caption-hover--cc">
		                        <ul class="list-inline">
		                            <li>
		                             	<a href="images/portfolio/recent/slide/Slide2.jpg" class="cbp-lightbox s-icon s-icon--sm s-icon--white-bg g-radius--circle" data-title="Portfolio Item  <br/>  by KeenThemes Inc.">
		                             	<i class="ti-fullscreen"></i>
		                                </a>
		                           		<br/>
		                           		<br/>
		                           		<button type="button" class="btn " onClick="buyFundHandler(<s:property value="selectedFundId" />);">Invest Now</button>
		                			</li>
		                     </ul>
		                    </div>
		                    </div>
		             </s:if> 
		             
		             
		             
		             
		             <s:if test="#fundDetailsDataModelElement.risk.equals('Low')">
                	 		<div  class="s-portfolio__item cbp-item  LowRisk g-line-height--normal">
                	 		<div class="s-portfolio__img-effect g-line-height--normal">
		                        <!-- <img src="images/portfolio/recent/portfolio2.png"  alt="Portfolio Image"> -->
				                           <div class="	 g-box-shadow__dark-lightest-v2 g-text-center--xs g-padding-x-40--xs g-padding-y-20--xs g-line-height--normal" style="background-color: #eeeeee">
				                           <s:set var="selectedFundId" value="#fundDetailsDataModelElement.fundId" />
				                            <p class=" g-font-size-14--xs g-font-weight--700 g-color--primary g-line-height--exs"><s:property value="#fundDetailsDataModelElement.fundName"/></p>
				                            <h3 class="g-font-size-22--xs g-line-height--exs "><s:property value="#fundDetailsDataModelElement.sector"/>. <s:property value="#fundDetailsDataModelElement.subSector"/></h3>
				                            <p class="g-text-left--xs g-line-height--exs">Start Date : <s:property value="#fundDetailsDataModelElement.fundStartDate"/></p>
				                            <p class="g-text-left--xs g-line-height--exs">Rating : <s:property value="#fundDetailsDataModelElement.rating"/></p>
				                            <p class="g-text-left--xs g-line-height--exs">Risk : <s:property value="#fundDetailsDataModelElement.risk"/></p>
				                            <p class="g-text-left--xs g-line-height--exs">3 yrs returns : <s:property value="#fundDetailsDataModelElement.returnsThreeYears"/>%</p>
				                            <p class="g-text-left--xs g-line-height--exs">Minimum SIP Amount : <s:property value="#fundDetailsDataModelElement.minSipAmount"/>INR </p>
				                            <p class="g-text-left--xs g-line-height--exs">Minimum SIP time : <s:property value="#fundDetailsDataModelElement.minSipYears"/> years</p>
				                            <p class="g-text-left--xs g-line-height--exs">Minimum Lumpsup Amount : <s:property value="#fundDetailsDataModelElement.minLumsumAmount"/> INR</p>
				                            <p class="g-text-left--xs g-line-height--exs">Fund Category : <s:property value="#fundDetailsDataModelElement.fundCategory"/></p>
				                        </div>
		                    </div>
		                    <span class="s-portfolio__caption-hover--cc">
		                        <ul class="list-inline">
		                            <li>
		                             	<a href="images/portfolio/recent/slide/Slide2.jpg" class="cbp-lightbox s-icon s-icon--sm s-icon--white-bg g-radius--circle" data-title="Portfolio Item  <br/>  by KeenThemes Inc.">
		                             	<i class="ti-fullscreen"></i>
		                                </a>
		                           		<br/>
		                           		<br/>
		                           		<button type="button" class="btn " onClick="buyFundHandler(<s:property value="selectedFundId" />);">Invest Now</button>
		                			</li>
		                     </ul>
		                    </span>
		                    </div>
		             </s:if> 
		            
                	
                 </s:iterator>
                <!-- End ITEM -->
            </div>
            <!-- End Portfolio Gallery -->
        </div> --%> 
        <!-- End Portfolio -->
        
        

        
        <!--========== END PAGE CONTENT ==========-->

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
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>

       <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <script type="text/javascript" src="vendor/jquery.min.js"></script>
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
        <script src="js/owl.carousel.min.js"></script>
      	

        <!-- General Components and Settings -->
        <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="js/components/magnific-popup.min.js"></script>
        <script type="text/javascript" src="js/components/swiper.min.js"></script>
        <script type="text/javascript" src="js/components/counter.min.js"></script>
        <script type="text/javascript" src="js/components/portfolio-3-col.js"></script>
        <script type="text/javascript" src="js/components/parallax.min.js"></script>
        <script type="text/javascript" src="js/components/google-map.min.js"></script>
        <script type="text/javascript" src="js/components/wow.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
        
        <script>
filterSelection("all")
function filterSelection(c) {
  var x, i;
  x = document.getElementsByClassName("filterDiv");
  if (c == "all") c = "";
  for (i = 0; i < x.length; i++) {
    w3RemoveClass(x[i], "show");
    if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
  }
}

function w3AddClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
  }
}

function w3RemoveClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    while (arr1.indexOf(arr2[i]) > -1) {
      arr1.splice(arr1.indexOf(arr2[i]), 1);     
    }
  }
  element.className = arr1.join(" ");
}

// Add active class to the current button (highlight it)
var btnContainer = document.getElementById("myBtnContainer");
var btns = btnContainer.getElementsByClassName("btn");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function(){
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}
</script>

    </body>
    <!-- End Body -->
</html>
