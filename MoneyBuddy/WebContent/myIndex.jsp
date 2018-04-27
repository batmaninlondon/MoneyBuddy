<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.Properties" %>
<%@ page language="java" import="java.io.FileInputStream" %>
<%@ page language="java" import="java.io.File" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy - Home</title>
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="MoneyBuddy - Effortless Investing">
        <meta name="author" content=moneybuddy.in>

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/swiper/swiper.min.css" rel="stylesheet" type="text/css"/>

        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        
        <%-- <script src="https://www.google.com/recaptcha/api.js" async defer></script> --%>
        
	<script src="https://www.google.com/recaptcha/api.js?onload=myCallBack&render=explicit" async defer></script>
    <script>
    
    <%
    
    ServletContext sc=request.getServletContext();
    String path=sc.getRealPath("/properties/jspConfig.properties");
    FileInputStream fis = new FileInputStream(new File(path));
    
    Properties configProperties = new Properties();

	configProperties.load(fis);
	
	String siteKey = configProperties.getProperty("RECAPTHA_SITE_KEY");
    
    %>
      var recaptchaSubscriber;
      var recaptchaContactUs;
      
      var myCallBack = function() {

        //Render the recaptchaSubscriber on the element with ID "recaptcha-subscriber"
        recaptchaSubscriber = grecaptcha.render('recaptcha-subscriber', {
          'sitekey' : '<%=siteKey%>', //Replace this with your Site key
          'size' : 'invisible',
          'callback' : submitSubscriber
        });
      
      };
  
    </script>
    
   	<script>
	function buyFundHandler(fundId)  
    {
			document.getElementById("fund-id-value").value = fundId;
			document.formBuyFundAction.submit();
    }
	</script>
        
    </head>
    <!-- End Head -->

    <!-- Body -->
    <body >
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
                                     <li class=" s-header-v2__nav-item s-header-v2__dropdown-on-hover">
                                        <a href="myIndex.jsp" class="dropdown-toggle s-header-v2__nav-link -is-active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Home<span class="g-font-size-10--xs g-margin-l-5--xs "></span></a>
                                    </li>
                                    <li class="s-header-v2__nav-item"><a href="saveTax" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="fetchFundDetailsAction"/>" class="s-header-v2__nav-link">Funds</a></li>
                                    <li class="s-header-v2__nav-item"><a href="aboutUs" class="s-header-v2__nav-link">About Us</a></li>
                                    <li class="s-header-v2__nav-item"><a href="blog" class="s-header-v2__nav-link">Blog</a></li>
                                    <li class="s-header-v2__nav-item"><a href="help" class="s-header-v2__nav-link">FAQs</a></li>
                                    <li class="s-header-v2__nav-item"><a href="startSip" class="s-header-v2__nav-link">Contact Us</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/Register</a></li>
										<%	} else 
										 	{	%>
										 			 <li class="s-header-v2__nav-item"><a href="bseDashboard.jsp" class="s-header-v2__nav-link">Dashboard</a></li>
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
    	
    	
    	
    	
        <!--========== SWIPER SLIDER ==========-->
        <div class="s-swiper js__swiper-one-item">
            <!-- Swiper Wrapper -->
            <div class="swiper-wrapper">
                <div class="g-fullheight--xs g-bg-position--center swiper-slide" style="background: url('img/970x970/04.jpg');">
                    <div class="container g-text-center--xs g-ver-center--xs">
                        <div class="g-margin-b-30--xs">
                            <h1 class="g-font-size-35--xs g-font-size-45--sm g-font-size-55--md g-color--white">Give your money<br>A chance to grow</h1>
                             <h2 class="g-font-size-10--xs g-font-size-10--sm g-font-size-15--md g-color--white" >Tired of poor returns from banks? Let our experts match you with a portfolio that could give your money the chance to perform better.</h2>
                        </div>
						<div class="g-text-center--xs">
                       		<a  href="<s:url action="fetchFundDetailsAction"/>" class="text-uppercase s-btn s-btn--md s-btn--white-bg g-radius--50 g-padding-x-70--xs">TRY IT OUT</a>
                       		<br/><br/><p id="slogan-4" class="small box g-text-right--xs  g-color--gray-light" > <span class="glyphicon">&#xe086;</span> with investing your capital is at risk</p>
               		   </div>
                    </div>
                </div>
                
                <div class="g-fullheight--xs g-bg-position--center swiper-slide" style="background: url(images/slider/bg56.jpg);">
                    <div class="container g-text-center--xs g-ver-center--xs">
                        <div class="g-margin-b-30--xs">
                            <div class="g-margin-b-30--xs">
                                <h1 class="g-font-size-35--xs g-font-size-45--sm g-font-size-55--md g-color--white">Your money with our support<br></h1>
                                <h2 class="g-font-size-10--xs g-font-size-10--sm g-font-size-15--md g-color--white" >We will support you to grow your money so that you can focus on what matters most to you</h2>
                            </div>
                            <div class="g-text-center--xs">
                            	<button  onclick="<s:url action="fetchFundDetailsAction"/>" class="text-uppercase s-btn button2 s-btn--md s-btn--white-bg g-radius--50 g-padding-x-70--xs">TRY IT OUT1</button>
                       			<br/><p id="slogan-4" class="small box g-text-right--xs  g-color--gray-light" > <span class="glyphicon">&#xe086;</span> with investing your capital is at risk</p>
               		  		</div>
                        </div>
                    </div>
                </div>
                
                <div class="g-fullheight--xs g-bg-position--center swiper-slide" style="background: url('img/1920x1080/01.jpg');">
                    <div class="container g-text-center--xs g-ver-center--xs">
                        <div class="g-margin-b-30--xs">
                            <div class="g-margin-b-30--xs">
                                <h1 class="g-font-size-35--xs g-font-size-45--sm g-font-size-55--md g-color--white">Make your dreams reality</h1>
                                <h2 class="g-font-size-10--xs g-font-size-10--sm g-font-size-15--md g-color--white" >The best thing money can buy is .....money</h2>
                            </div>
                            <div class="g-text-center--xs">
                       			<a  href="<s:url action="fetchFundDetailsAction"/>" class="text-uppercase s-btn s-btn--md s-btn--white-bg g-radius--50 g-padding-x-70--xs">TRY IT OUT</a>
                       			<br/><p id="slogan-4" class="small box g-text-right--xs  g-color--gray-light" > <span class="glyphicon">&#xe086;</span> with investing your capital is at risk</p>
               		  		</div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Swiper Wrapper -->

            <!-- Arrows -->
            <a href="javascript:void(0);" class="s-swiper__arrow-v1--right s-icon s-icon--md s-icon--white-brd g-radius--circle ti-angle-right js__swiper-btn--next"></a>
            <a href="javascript:void(0);" class="s-swiper__arrow-v1--left s-icon s-icon--md s-icon--white-brd g-radius--circle ti-angle-left js__swiper-btn--prev"></a>
            <!-- End Arrows -->
            
            <a href="<s:url action="fetchFundDetailsAction"/>"  class="s-scroll-to-section-v1--bc g-margin-b-15--xs">
                <span class="g-font-size-18--xs g-color--white ti-angle-double-down"></span>
                <p class="text-uppercase g-color--white g-letter-spacing--3 g-margin-b-0--xs">Learn More</p>
            </a>
        </div>
        <!--========== END SWIPER SLIDER ==========-->

		<div class="container-fluid g-padding-y-10--xs g-padding-y-20--sm">
            <div class="g-text-center--xs g-margin-b-10--xs">
                <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-5--xs">Some of Our Most Popular Funds</p>
            </div>

            <!-- Swiper -->
            <div class="s-swiper js__swiper-news">
                <!-- Wrapper -->
                <div class="swiper-wrapper g-margin-b-3s0--xs">
                	<div id="myDiv3" class="col-md-4  g-bg-color--white   swiper-slide">
							<div  class="  g-line-height--normal  ">
								<figure class="snip1418   swiper-slide" style="height:300px;">
									<span id="myDiv5" class="add-to-cart"><span>Select this fund</span></span>
				  					<figcaption>
				    					<article class="panel  panel-heading g-bg-color--primary" style="height:120px;" >
				    						<p class="g-color--white  g-font-size-16--xs g-margin-b-40--xs" style="font-weight: bold; height:40px;">Fund Name</p>
				    						<br/>
				    						<p class="g-color--white  g-font-size-12--xs" style="font-weight: bold;">Equity.Wealth</p>
				    						<p class="g-color--white  g-font-size-12--xs" style="font-weight: bold;">13 March 2010</p> 
				    					</article>
				    					<article class="g-margin-l-20--xs "> 
										        <span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star"></span>
									        <article class="g-margin-t-10--xs g-margin-b-10--xs">  Past returns:</article>
									        <table id="portfoliosummary" class="table-bordered" cellspacing="0" width="80%">
										        <thead>
										            <tr class="g-bg-color--white" >
										                <th class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">1 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">3 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">5 yr</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-bg-color--white" >
										                <td class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">10%</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">10%</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">10%</span></td>
										            </tr>
										        </tbody>
										    </table>
									       	</article>
				  				 </figcaption>
		  						 <a href="#"></a>
								</figure>
								
							</div>
						</div>
                
                <div id="myDiv3" class="col-md-4  g-bg-color--white   swiper-slide">
							<div  class="  g-line-height--normal  ">
								<figure class="snip1418   swiper-slide"  onClick="buyFundHandler('1');" style="height:300px;">
									<span id="myDiv5" class="add-to-cart"><span>Select this fund</span></span>
				  					<figcaption>
				    					<article class="panel  panel-heading g-bg-color--primary" style="height:120px;" >
				    						<p class="g-color--white  g-font-size-16--xs g-margin-b-40--xs" style="font-weight: bold; height:40px;">Fund Name - 1</p>
				    						<br/>
				    						<p class="g-color--white  g-font-size-12--xs" style="font-weight: bold;">Equity.Wealth</p>
				    						<p class="g-color--white  g-font-size-12--xs" style="font-weight: bold;">13 March 2010</p> 
				    					</article>
				    					<article class="g-margin-l-20--xs "> 
										        <span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star"></span>
									        <article class="g-margin-t-10--xs g-margin-b-10--xs">  Past returns:</article>
									        <table id="portfoliosummary" class="table-bordered" cellspacing="0" width="80%">
										        <thead>
										            <tr class="g-bg-color--white" >
										                <th class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">1 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">3 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">5 yr</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-bg-color--white" >
										                <td class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">10%</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">10%</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">10%</span></td>
										            </tr>
										        </tbody>
										    </table>
									       	</article>
				  				 </figcaption>
		  						 <a href="#"></a>
								</figure>
								
							</div>
							<s:form  action="buyFundAction" method="post" name="formBuyFundAction">
	  							<s:hidden id="fund-id-value" name="fundId"></s:hidden>
							</s:form>
							
						</div>
						<div id="myDiv3" class="col-md-4  g-bg-color--white   swiper-slide">
							<div  class="  g-line-height--normal  ">
								<figure class="snip1418   swiper-slide" style="height:300px;">
									<span id="myDiv5" class="add-to-cart"><span>Select this fund</span></span>
				  					<figcaption>
				    					<article class="panel  panel-heading g-bg-color--primary" style="height:120px;" >
				    						<p class="g-color--white  g-font-size-16--xs g-margin-b-40--xs" style="font-weight: bold; height:40px;">Fund Name</p>
				    						<br/>
				    						<p class="g-color--white  g-font-size-12--xs" style="font-weight: bold;">Equity.Wealth</p>
				    						<p class="g-color--white  g-font-size-12--xs" style="font-weight: bold;">13 March 2010</p> 
				    					</article>
				    					<article class="g-margin-l-20--xs "> 
										        <span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star"></span>
									        <article class="g-margin-t-10--xs g-margin-b-10--xs">  Past returns:</article>
									        <table id="portfoliosummary" class="table-bordered" cellspacing="0" width="80%">
										        <thead>
										            <tr class="g-bg-color--white" >
										                <th class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">1 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">3 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">5 yr</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-bg-color--white" >
										                <td class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">10%</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">10%</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">10%</span></td>
										            </tr>
										        </tbody>
										    </table>
									       	</article>
				  				 </figcaption>
		  						 <a href="#"></a>
								</figure>
								
							</div>
						</div>
						<div id="myDiv3" class="col-md-4  g-bg-color--white   swiper-slide">
							<div  class="  g-line-height--normal  ">
								<figure class="snip1418   swiper-slide" style="height:300px;">
									<span id="myDiv5" class="add-to-cart"><span>Select this fund</span></span>
				  					<figcaption>
				    					<article class="panel  panel-heading g-bg-color--primary" style="height:120px;" >
				    						<p class="g-color--white  g-font-size-16--xs g-margin-b-40--xs" style="font-weight: bold; height:40px;">Fund Name</p>
				    						<br/>
				    						<p class="g-color--white  g-font-size-12--xs" style="font-weight: bold;">Equity.Wealth</p>
				    						<p class="g-color--white  g-font-size-12--xs" style="font-weight: bold;">13 March 2010</p> 
				    					</article>
				    					<article class="g-margin-l-20--xs "> 
										        <span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star g-color--primary"></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star "></span>
												<span class="fa fa-star"></span>
									        <article class="g-margin-t-10--xs g-margin-b-10--xs">  Past returns:</article>
									        <table id="portfoliosummary" class="table-bordered" cellspacing="0" width="80%">
										        <thead>
										            <tr class="g-bg-color--white" >
										                <th class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">1 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">3 yr</span></th>
														<th class="text-center" ><span class=" g-font-size-14--xs">5 yr</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-bg-color--white" >
										                <td class="text-center" ><span class=" g-font-size-14--xs g-font-size-5--xs">10%</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">10%</span></td>
														<td class="text-center" ><span class="g-font-size-14--xs">10%</span></td>
										            </tr>
										        </tbody>
										    </table>
									       	</article>
				  				 </figcaption>
		  						 <a href="#"></a>
								</figure>
								
							</div>
						</div>
                
                </div>
                <!-- End Wrapper -->

                <!-- Pagination -->
                <div class="s-swiper__pagination-v1 s-swiper__pagination-v1--dark g-text-center--xs js__swiper-pagination"></div>
            </div>
            <!-- End Swiper -->
        </div>


		
		<!-- Mutual Funds -->
        
        <!-- End News -->

       
<!-- Process -->
        
        <!-- <div class="g-bg-color--dark">
        <div class="g-bg-color--primary-ltr">
            <div class="container g-padding-y-80--xs g-padding-y-125--sm">
                <div class="g-text-center--xs g-margin-b-100--xs">
                    <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-25--xs">Process</p>
                    <h2 class="g-font-size-32--xs g-font-size-36--md g-color--white">How it Works</h2>
                </div>
                <ul class="list-inline row g-margin-b-100--xs">
                    Process
                    <li class="col-sm-3 col-xs-6 g-full-width--xs s-process-v1 g-margin-b-60--xs g-margin-b-0--md">
                        <div class="center-block g-text-center--xs">
                            <div class="g-margin-b-30--xs">
                                <span class="g-display-inline-block--xs g-width-100--xs g-height-100--xs g-font-size-38--xs g-color--primary g-bg-color--white g-box-shadow__dark-lightest-v4 g-padding-x-20--xs g-padding-y-20--xs g-radius--circle">01</span>
                            </div>
                            <div class="g-padding-x-20--xs">
                                <h3 class="g-font-size-18--xs g-color--white">Assess</h3>
                                <p class="g-color--white-opacity">The first step is to assess your special characteristics by understanding your financial situation, your economic goals and your short to medium term commitments.</p>
                            </div>
                        </div>
                    </li>
                    End Process

                    Process
                    <li class="col-sm-3 col-xs-6 g-full-width--xs s-process-v1 g-margin-b-60--xs g-margin-b-0--md">
                        <div class="center-block g-text-center--xs">
                            <div class="g-margin-b-30--xs">
                                <span class="g-display-inline-block--xs g-width-100--xs g-height-100--xs g-font-size-38--xs g-color--primary g-bg-color--white g-box-shadow__dark-lightest-v4 g-padding-x-20--xs g-padding-y-20--xs g-radius--circle">02</span>
                            </div>
                            <div class="g-padding-x-20--xs">
                                <h3 class="g-font-size-18--xs g-color--white">Measure</h3>
                                <p class="g-color--white-opacity">This is where we use intelligence questionnaire based algorithm to assess your risk appetite</p>
                            </div>
                        </div>
                    </li>
                    End Process

                    Process
                    <li class="col-sm-3 col-xs-6 g-full-width--xs s-process-v1 g-margin-b-60--xs g-margin-b-0--sm">
                        <div class="center-block g-text-center--xs">
                            <div class="g-margin-b-30--xs">
                                <span class="g-display-inline-block--xs g-width-100--xs g-height-100--xs g-font-size-38--xs g-color--primary g-bg-color--white g-box-shadow__dark-lightest-v4 g-padding-x-20--xs g-padding-y-20--xs g-radius--circle">03</span>
                            </div>
                            <div class="g-padding-x-20--xs">
                                <h3 class="g-font-size-18--xs g-color--white">Design</h3>
                                <p class="g-color--white-opacity">We use Artificial Intelligence and machine learning to design your investment portfolio by picking the funds matching your goals and risks appetite </p>
                            </div>
                        </div>
                    </li>

                    <li class="col-sm-3 col-xs-6 g-full-width--xs s-process-v1">
                        <div class="center-block g-text-center--xs">
                            <div class="g-margin-b-30--xs">
                                <span class="g-display-inline-block--xs g-width-100--xs g-height-100--xs g-font-size-38--xs g-color--primary g-bg-color--white g-box-shadow__dark-lightest-v4 g-padding-x-20--xs g-padding-y-20--xs g-radius--circle">04</span>
                            </div>
                            <div class="g-padding-x-20--xs">
                                <h3 class="g-font-size-18--xs g-color--white">Monitor</h3>
                                <p class="g-color--white-opacity">Pro-active monitoring to ensure your investment remains in-line with your goals and risk appetite.</p>
                            </div>
                        </div>
                    </li>
                </ul>

                <div class="g-text-center--xs">
                    <a href="#js__scroll-to-appointment" class="text-uppercase s-btn s-btn--md s-btn--white-bg g-radius--50 g-padding-x-70--xs">TRY IT OUT</a>
                </div>
            </div>
        </div> -->
        <!-- End Process -->
        <!-- Parallax -->
        <div class="js__parallax-window" style="background: url(img/1920x1080/031.jpg) 50% 0 no-repeat fixed;">
            <div class="container g-text-center--xs g-padding-y-80--xs g-padding-y-125--sm">
                <div class="g-margin-b-80--xs">
                    <h2 class="g-font-size-40--xs g-font-size-50--sm g-font-size-60--md g-color--primary">The Most Efficient and Easiest Way to Save Tax</h2>
                </div>
                <a  href="saveTax" class="text-uppercase s-btn s-btn--md s-btn--white-bg g-radius--50 g-padding-x-70--xs">Learn More</a>
            </div>
        </div>
        <!-- End Parallax -->

        <!-- Culture -->
        <div class="g-promo-section">
            <div class="container g-padding-y-80--xs g-padding-y-60--sm">
                <div class="row">
                    <div class="col-md-4 g-margin-t-15--xs g-margin-b-60--xs g-margin-b-0--lg">
                        <div class="wow fadeInLeft" data-wow-duration=".3" data-wow-delay=".1s">
                            <h2 class="g-font-size-30--xs g-font-size-40--sm g-font-size-50--md g-letter-spacing--2 g-color--primary g-font-weight--700">Why</h2>
                        </div>
                        <div class="wow fadeInLeft" data-wow-duration=".3" data-wow-delay=".3s">
                            <h2 class="g-font-size-30--xs g-font-size-40--sm g-font-size-50--md g-letter-spacing--2 g-color--primary g-font-weight--700">MoneyBuddy</h2>
                        </div>
                    </div>
                    <div class="col-md-4 col-md-offset-1">
                        <p class="g-font-size-16--xs">We aim high at being focused on building relationships with our clients and community. </p>
                        <p class="g-font-size-16--xs">With more than 40 years of experience in financial investments, consulting and technology, we deliver results to help grow your money. Our comprehensive one stop shops for all your funds needs allow you to do what you do best and leave your financial planning with us.</p>
                    	<div class="row ">
                        <ul class="list-unstyled col-xs-6 g-full-width--xs g-ul-li-tb-5--xs g-margin-b-20--xs g-margin-b-0--sm">
                            <li class="g-font-size-12--xs"><i class="g-font-size-12--xs g-color--primary g-margin-r-10--xs ti-check"></i>Wealth Management</li>
                            <li class="g-font-size-12--xs"><i class="g-font-size-12--xs g-color--primary g-margin-r-10--xs ti-check"></i>Tax Saving</li>
                            <li class="g-font-size-12--xs"><i class="g-font-size-12--xs g-color--primary g-margin-r-10--xs ti-check"></i>Portfolio Tracking</li>
                            <li class="g-font-size-12--xs"><i class="g-font-size-12--xs g-color--primary g-margin-r-10--xs ti-check"></i>Financial Planning</li>
                        </ul>
                  		<ul class="list-unstyled col-xs-6 g-full-width--xs g-ul-li-tb-5--xs g-margin-b-20--xs g-margin-b-0--sm">
                            <li class="g-font-size-12--xs"><i class="g-font-size-12--xs g-color--primary g-margin-r-10--xs ti-check"></i>No Fee</li>
                            <li class="g-font-size-12--xs"><i class="g-font-size-12--xs g-color--primary g-margin-r-10--xs ti-check"></i>Any time, any where</li>
                            <li class="g-font-size-12--xs"><i class="g-font-size-12--xs g-color--primary g-margin-r-10--xs ti-check"></i>Proven Track Record</li>
                            <li class="g-font-size-12--xs"><i class="g-font-size-12--xs g-color--primary g-margin-r-10--xs ti-check"></i>Mobile, web and more</li>
                        </ul> 
                    </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 g-promo-section__img-right--lg g-bg-position--center g-height-100-percent--md js__fullwidth-img">
                <img class="img-responsive" src="img/970x970/03.jpg" alt="Image">
            </div>
        </div>
        <!-- End Culture -->

        
        <!-- Portfolio Filter -->
        
        <!-- Counter -->
        <div class="js__parallax-window" style="background: url(img/1920x1080/06.jpg) 50% 0 no-repeat fixed;">
            <div class="container g-padding-y-80--xs g-padding-y-125--sm">
                <div class="row">
                    <div class="col-md-4 col-xs-6 g-full-width--xs g-margin-b-70--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs">
                            <div class="g-margin-b-10--xs">
                                <figure class="g-display-inline-block--xs g-font-size-70--xs g-color--white js__counter">30</figure>
                            </div>
                            <div class="center-block g-hor-divider__solid--white g-width-40--xs g-margin-b-25--xs"></div>
                            <h4 class="g-font-size-18--xs g-color--white">Mutual Funds</h4>
                        </div>
                    </div>
                    <div class="col-md-4 col-xs-6 g-full-width--xs">
                        <div class="g-text-center--xs">
                            <div class="g-margin-b-10--xs">
                                <figure class="g-display-inline-block--xs g-font-size-70--xs g-color--white js__counter">40</figure>
                                <span class="g-font-size-40--xs g-color--white">+</span>
                            </div>
                            <div class="center-block g-hor-divider__solid--white g-width-40--xs g-margin-b-25--xs"></div>
                            <h4 class="g-font-size-18--xs g-color--white">Yrs experience</h4>
                        </div>
                    </div>
                    <div class="col-md-4 col-xs-6 g-full-width--xs">
                        <div class="g-text-center--xs">
                            <div class="g-margin-b-10--xs">
                                <figure class="g-display-inline-block--xs g-font-size-70--xs g-color--white js__counter">4</figure>
                                <span class="g-font-size-40--xs g-color--white">x</span>
                            </div>
                            <div class="center-block g-hor-divider__solid--white g-width-40--xs g-margin-b-25--xs"></div>
                            <h4 class="g-font-size-18--xs g-color--white">Faster Support</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Counter -->

        <section id="services" class="g-bg-color--dark">
	   		<div class="container ">
	            <div class="center wow fadeInDown g-margin-t-50--xs g-margin-b-50--xs ">
	            	<h2 class="g-color--white g-text-center--xs">Our Partners..</h2>
	                <p class="g-color--white g-text-center--xs">We use funds from leading providers to build your portfolio</p>
	            	<marquee behavior="scroll" direction="left" >
	 					<img src="images/partners/birla.jpg"  height="42" alt="Birla">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
						<img src="images/partners/kotak.jpg"  height="42" alt="Kotak">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 					<img src="images/partners/icici.jpg" height="42" alt="ICICI"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	 				  	<!-- <img src="images/partners/dhfl_fd.png" height="35" alt="DHFL"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/reliance.png"  height="42" alt="Reliance"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   -->
	 				  	<img src="images/partners/BSE.jpg"  height="42" alt="BSE"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				 	<!-- <img src="images/partners/axis.jpg"  height="42" alt="Axix">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; -->  
	 				  	<img src="images/partners/dhfl_fd.jpg"  height="42" alt="dhfl_fd">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/dsp.jpg"  height="42" alt="Dsp"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/franklin.jpg"  height="42" alt="Franklin"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/grun_fd.jpg"  height="42" alt="Grun_fd">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/housing_fd.jpg"  height="42" alt="Housing">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/birla.jpg"  height="42" alt="Birla">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/kotak.jpg"  height="42" alt="Kotak">  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/icici.jpg"  height="42" alt="ICICI">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/mahindra_fd.jpg"  height="42" alt="Mahindra">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
	 				  	<img src="images/partners/hdfc.jpg"  height="42" alt="HDFS">
					</marquee>
	            </div>
        </div><!--/.container-->
    </section><!--/#services-->
    
    <!-- Subscribe -->
    
        <div class="js__parallax-window" style="background: url(img/1920x1080/07.jpg) 50% 0 no-repeat fixed;" id="subscriber">
            <div class="g-container--sm g-text-center--xs g-padding-y-80--xs g-padding-y-125--sm">
                <div class="g-margin-b-80--xs">
                    <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-25--xs">Subscribe</p>
                    <h2 class="g-font-size-32--xs g-font-size-36--md g-color--white">Join Over 1000+ People</h2>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                        <div class="input-group">
                        	<s:form  action="saveSubscriberAction" class="g-recaptcha" method="post" name="formSubscriber" namespace="/">
	                        	<s:hidden id="google-response-subscriber" name="googleResponse"></s:hidden>
	                        	<s:fielderror fieldName="emailId" class="g-color--red" />
			  					<s:textfield class="form-control s-form-v1__input g-radius--left-50" id="subscriber-email-id" placeholder="Enter your email" name="emailId" /> 
			  					<!-- <input type="email" class="form-control s-form-v1__input g-radius--left-50" name="email" id="subscriber-email-id" placeholder="Enter your email"> -->
	                            <span class="input-group-btn">
	                            	<s:submit id="recaptcha-subscriber" class="g-recaptcha s-btn s-btn-icon--md s-btn-icon--white-brd s-btn--white-brd g-radius--right-50" value="Submit"></s:submit>
	                                <!-- <button id="recaptcha-subscriber" type="submit" class="g-recaptcha s-btn s-btn-icon--md s-btn-icon--white-brd s-btn--white-brd g-radius--right-50" ><i class="ti-arrow-right"></i></button> -->
	                            </span>
	                            
	                            <s:actionmessage class="g-font-size-32--xs g-font-size-36--md g-color--white"/> 
	                            
                            </s:form>
                        </div>
                        <br/><br/>
                        <p id="subscription-text" class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-25--xs"></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Subscribe -->
    

	<div id="js__scroll-to-appointment" class="g-bg-color--sky-light g-padding-y-80--xs g-padding-y-125--sm">
            <div class="container g-bg-color--white g-box-shadow__dark-lightest-v3">
                <div class="row">
                    <!-- Form -->
                    <div class="col-md-8 js__form-eqaul-height-v1 ">
                        <div class="g-padding-x-40--xs g-padding-y-50--xs">
                            <h2 class="g-font-size-24--xs g-color--primary ">Have a question? Write to us</h2>
	                        <div id="contact-us-form" class="center-block g-width-500--sm g-width-550--md g-bg-color--primary" >
			                    <div class="g-margin-b-20--xs g-color--primary">
			                        <input type="text" class="form-control s-form-v3__input" id="sender-name" placeholder="* Name">
			                    </div>
			                    <div class="row g-row-col-5 g-margin-b-50--xs g-color--primary">
			                        <div class="g-color--primary col-sm-6 g-margin-b-30--xs g-margin-b-0--md">
			                            <input type="email" class="g-color--primary form-control s-form-v3__input" id="sender-emailId" placeholder="* Email">
			                        </div>
			                        <div class="col-sm-6">
			                            <input type="text" class="form-control s-form-v3__input" id="sender-mobile-number" placeholder="* Phone">
			                        </div>
			                    </div>
			                    <div class="g-margin-b-10--xs">
			                        <textarea class="form-control s-form-v3__input" id="sender-message" rows="5" placeholder="* Your message"></textarea>
			                    </div>
			                    <div class="g-text-center--xs">
			                        <button id="recaptcha-contact-us" type="submit" class="g-recaptcha g-bg-color--primary g-color--white text-uppercase s-btn s-btn--md g-radius--50 g-padding-x-70--xs g-margin-b-20--xs" >Submit</button>
			                    </div>
	                		</div>
	                		<div class ="center-block g-width-500--sm g-width-550--md g-bg-color--primary">
	                			<p id="contact-us-text" class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-25--xs"></p>
                        	</div>
                        </div>
                    </div>
                    <!-- End Form -->

                    <!-- Contacts -->
                    <div class="col-md-4 g-bg-color--primary-ltr js__form-eqaul-height-v1">
                        <div class="g-overflow--hidden g-padding-x-40--xs g-padding-y-50--xs">
                            <h2 class="g-font-size-24--xs g-color--white g-margin-b-50--xs">Contact Us</h2>
                            <ul class="list-unstyled g-margin-b-70--xs">
                                <li class="clearfix g-color--white g-margin-b-40--xs">
                                    <div class="g-media g-width-40--xs g-margin-t-5--xs">
                                        <i class="g-font-size-20--xs g-color--white-opacity-light ti-location-pin"></i>
                                    </div>
                                    <div class="g-media__body">
                                        A 1204, Partk Royale, <br> Rahantani, Pune 411017, India
                                    </div>
                                </li>
                                <li class="clearfix g-color--white g-margin-b-40--xs">
                                    <div class="g-media g-width-40--xs g-margin-t-5--xs">
                                        <i class="g-font-size-20--xs g-color--white-opacity-light ti-headphone-alt"></i>
                                    </div>
                                    <div class="g-media__body">
                                        + (91) 997 164 8736
                                    </div>
                                </li>
                                <li class="clearfix g-color--white g-margin-b-40--xs">
                                    <div class="g-media g-width-40--xs g-margin-t-5--xs">
                                        <i class="g-font-size-20--xs g-color--white-opacity-light ti-email"></i>
                                    </div>
                                    <div class="g-media__body">
                                        info.moneybuddy@gmail.com
                                    </div>
                                </li>
                            </ul>
                            <ul class="list-inline g-ul-li-lr-15--xs">
                                <li><a href="https://www.facebook.com/MoneyBuddyIndia"><i class="g-font-size-20--xs g-color--white-opacity ti-facebook"></i></a></li>
                                <li><a href="https://twitter.com/MoneyBuddyIndia"><i class="g-font-size-20--xs g-color--white-opacity ti-twitter"></i></a></li>
                                <li><a href="https://www.linkedin.com/in/money-buddy-94a73814a/"><i class="g-font-size-20--xs g-color--white-opacity fa fa-linkedin"></i></a></li>
                                <li><a href="https://www.YouTube.com/MoneyBuddy"><i class="g-font-size-20--xs g-color--white-opacity fa fa-youtube"></i></a></li>
                            </ul>
                            <i class="g-font-size-150--xs g-color--white-opacity-lightest ti-comments" style="position: absolute; bottom: -1.25rem; right: -1.25rem;"></i>
                        </div>
                    </div>
                    <!-- End Contacts -->
                </div>
            </div>
        </div>
     
        <!--========== END PAGE CONTENT ==========-->

        <!--========== FOOTER ==========-->
        <footer class="g-bg-color--dark">
            <!-- Links -->
            <div class="g-hor-divider__dashed--white-opacity-lightest">
                <div class="container g-padding-y-80--xs">
                    <div class="row">
                        <div class="col-sm-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="myIndex">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="saveTax">Save Tax</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="allFunds">Funds</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="help">Help</a></li>
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
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="policy.jsp">Privacy Policy</a></li>
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
                    &copy; 2018 <a href="#" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
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
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
    
        <!-- General Components and Settings -->
       <!--  <script type="text/javascript" src="js/global.min.js"></script> -->
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="vendor/swiper/swiper.jquery.min.js"></script>
        <script type="text/javascript" src="js/components/swiper.min.js"></script>
        <script type="text/javascript" src="vendor/waypoint.min.js"></script>
        <script type="text/javascript" src="vendor/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
        <script type="text/javascript" src="vendor/counterup.min.js"></script>
        <script type="text/javascript" src="js/components/counter.min.js"></script>
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
        
        <!--========== END JAVASCRIPTS ==========-->
       
	</div>
    </body>
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
         
<%--      <script>
       function onSubmit(token) {
         alert(token);
         saveSubscriber(token);
       }
     </script>  --%>
         
        
    <!-- End Body -->
</html>
