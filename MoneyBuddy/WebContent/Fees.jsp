<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy-FAQs</title>
        <meta http-equiv="Cache-control" content="max-age=2592000, public">
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		<link type="text/css" rel="stylesheet" href="assets/css/cubeportfolio/cubeportfolio.min.css" />
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/themify.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        
        <link href="assets/css/swiper.min.css" rel="stylesheet" type="text/css"/>
        

    </head>
    <!-- End Head -->

    <!-- Body -->
    <body >
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

        <!--========== PROMO BLOCK ==========-->
         <div class=" g-bg-position--center " style="background: url('img/1920x1080/bckgrnd.jpg'); height:400px;">
                    <div class="container g-text-center--xs g-ver-center--xs ">
                        <div class=" ">
                            <h3 class="g-font-size-35--xs g-font-size-45--sm g-font-size-55--md g-color--white font-weight-bold ">LOW FEES AND NO HIDDEN COSTS</h3>
                        	<br/><br/><br/>
                        	<br/><br/><br/>
                        	<br/><br/><br/>
                        </div>
                    </div>
                </div> 
        <!--========== END PROMO BLOCK ==========-->

        <!--========== PAGE CONTENT ==========-->

        <!-- Accordion -->
        <div class="s-faq " style=" text-align: justify; ">
            <div class="container g-padding-y-25--xs">
                <div class="row">
                	 <h3 class="g-font-size-32--xs g-font-size-32--sm g-font-size-32--md  font-weight-bold g-color--primary ">AFFORDABLE INVESTING</h3>
                       We make sure the cost of investing is clear and affordable, with no surprises.MoneyBuddy charges a simple annual fee for managing your investments. Its never more than 0.3% and can be as low as 0.175%, depending on the total value of all Investment Plans you hold with us.
                       <br/><br/>
                                            <table class="table table-bordered ">
                                            	<thead class="thead-light">
													<tr>
														<th class="text-center g-bg-color--heading "> <span class = "g-color--white"> Amount Invested</span></th>
														<th class="text-center g-bg-color--heading "> <span class = "g-color--white"> Advisory Fee (% per year)</span></th>
														<th class="text-center g-bg-color--heading "> <span class = "g-color--white"> Advisory Fee (% per Quarter)</span></th>
													</tr>
												</thead>
												<tbody >
													<tr>
														<td class="text-center">1 lac- 10 lac</td>
														<td class="text-center">1.2 %</td>
														<td class="text-center">0.3 %</td>
													</tr>
													<tr>
														<td class="text-center">10 lac-50 lac</td>
														<td class="text-center">1 %</td>
														<td class="text-center">0.25 %</td>
													</tr>
													<tr>
														<td class="text-center">50 lac- 2 crore</td>
														<td class="text-center">0.9 %</td>
														<td class="text-center">0.225 %</td>
													</tr>
													<tr>
														<td class="text-center">> 2 crore</td>
														<td class="text-center">0.8 %</td>
														<td class="text-center">0.2 %</td>
													</tr>
													<tr>
														<td class="text-center">> 5 crore</td>
														<td class="text-center">0.7 %</td>
														<td class="text-center">0.175 %</td>
													</tr>
												</tbody>
                                            
                                            </table>
                                            
                                            PS: NRI&#39;s are charged 0.1% per year extra on top of the fee mentioned above
                                            <br/><br/>
                                            We would like to reiterate, that our customers get to earn upto 1% extra returns due to investing in direct mutual funds. Thus as compared with other so called &#34;free investment portals&#34;, most of our users end up getting more money then they pay in advisory fee.
                                        </div>
                                        
                                        
                                    </div>
                                </div>
                            
                            
               <div class="g-bg-color--primary-to-blueviolet-ltr">
	             <div class="container"  >
	               <div class="g-text-center--xs g-margin-b-10--xs">
						<br/><br/>
	                    <h3 class="text-center  g-font-size-32--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--white font-weight-bold   ">WHAT DO I GET FOR MY FEE?</h3>
	           			<br/><br/>
	           			
	           			<div class="row g-margin-b-50--xs"  >
                    		<div class="col-sm-6 text-left">
                    			<div class="g-margin-b-20--xs ">
                                        <h2 class="s-faq-grid__title"><span class="g-font-size-20--xs g-font-size-15--xs fa fa-check-square-o g-color--white text-left"></span>&ensp;&ensp;&ensp;Your Personal Investment Plan built by experts</h2>
                                 </div>
                            	<div class=" g-margin-b-20--xs ">
                                        <h2 class="s-faq-grid__title"><span class="g-font-size-20--xs g-font-size-15--xs fa fa-check-square-o g-color--white text-left"></span>&ensp;&ensp;&ensp;Option to adjustments to your Plan to keep it on track</h2>
                                 </div>
                                 <div class=" g-margin-b-20--xs ">
                                        <h2 class="s-faq-grid__title"><span class="g-font-size-20--xs g-font-size-15--xs fa fa-check-square-o g-color--white text-left"></span>&ensp;&ensp;&ensp;24/7 access to your money online </h2>
                                 </div>
                                 <div class=" g-margin-b-20--xs ">
                                        <h2 class="s-faq-grid__title"><span class="g-font-size-20--xs g-font-size-15--xs fa fa-check-square-o g-color--white text-left"></span>&ensp;&ensp;&ensp;Phone and email support</h2>
                                 </div>
                          	</div>  
                          	
                          	<div class="col-sm-6 text-left">
                    			<div class="g-margin-b-20--xs ">
                                        <h2 class="s-faq-grid__title"><span class="g-font-size-20--xs g-font-size-15--xs fa fa-check-square-o g-color--white text-left"></span>&ensp;&ensp;&ensp;365 days-a-year market monitoring</h2>
                                 </div>
                            	<div class=" g-margin-b-20--xs">
                                        <h2 class="s-faq-grid__title"><span class="g-font-size-20--xs g-font-size-15--xs fa fa-check-square-o g-color--white text-left"></span>&ensp;&ensp;&ensp;Buying and selling investments for your Plan</h2>
                                 </div>
                                 <div class=" g-margin-b-20--xs">
                                        <h2 class="s-faq-grid__title"><span class="g-font-size-20--xs g-font-size-15--xs fa fa-check-square-o g-color--white text-left"></span>&ensp;&ensp;&ensp;Free withdrawals</h2>
                                 </div>
                                 <div class=" g-margin-b-20--xs">
                                        <h2 class="s-faq-grid__title"><span class="g-font-size-20--xs g-font-size-15--xs fa fa-check-square-o g-color--white text-left"></span>&ensp;&ensp;&ensp;No Commitment</h2>
                                 </div>
                          	</div>  
                          
                           
                     </div> 
	           		</div>  
	           	</div> 
           		</div>             
                            
               
               
                            
                   <section id="services" class="g-bg-color--dark">
	   		<div class="container ">
	            <div class="center wow fadeInDown g-margin-t-50--xs g-margin-b-50--xs ">
	            	<h2 class="g-color--white g-text-center--xs">Our Partners</h2>
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
    </section>
    
    
    <!-- Testimonials -->
        <div class="" style="background: url('img/1920x1080/04.jpg');">
            <div class="container g-text-center--xs g-padding-y-80--xs g-padding-y-125--sm">
                <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-50--xs">Testimonials</p>
                <div class="s-swiper js__swiper-testimonials">
                    <!-- Swiper Wrapper -->
                    <div class="swiper-wrapper g-margin-b-50--xs">
                        <div class="swiper-slide g-padding-x-130--sm g-padding-x-150--lg">
                            <div class="g-padding-x-20--xs g-padding-x-50--lg">
                                <div class="g-margin-b-40--xs">
                                    <p class="g-font-size-22--xs g-font-size-28--sm g-color--white"><i>" I have purchased many great templates over the years but this product and this company have taken it to the next level. Exceptional customizability. "</i></p>
                                </div>
                                <div class="center-block g-hor-divider__solid--white-opacity-lightest g-width-100--xs g-margin-b-30--xs"></div>
                                <h4 class="g-font-size-15--xs g-font-size-18--sm g-color--white-opacity-light g-margin-b-5--xs">Jake Richardson / Google</h4>
                            </div>
                        </div>
                        <div class="swiper-slide g-padding-x-130--sm g-padding-x-150--lg">
                            <div class="g-padding-x-20--xs g-padding-x-50--lg">
                                <div class="g-margin-b-40--xs">
                                    <p class="g-font-size-22--xs g-font-size-28--sm g-color--white"><i>" I have purchased many great templates over the years but this product and this company have taken it to the next level. Exceptional customizability. "</i></p>
                                </div>
                                <div class="center-block g-hor-divider__solid--white-opacity-lightest g-width-100--xs g-margin-b-30--xs"></div>
                                <h4 class="g-font-size-15--xs g-font-size-18--sm g-color--white-opacity-light g-margin-b-5--xs">Jake Richardson / Google</h4>
                            </div>
                        </div>
                        <div class="swiper-slide g-padding-x-130--sm g-padding-x-150--lg">
                            <div class="g-padding-x-20--xs g-padding-x-50--lg">
                                <div class="g-margin-b-40--xs">
                                    <p class="g-font-size-22--xs g-font-size-28--sm g-color--white"><i>" I have purchased many great templates over the years but this product and this company have taken it to the next level. Exceptional customizability. "</i></p>
                                </div>
                                <div class="center-block g-hor-divider__solid--white-opacity-lightest g-width-100--xs g-margin-b-30--xs"></div>
                                <h4 class="g-font-size-15--xs g-font-size-18--sm g-color--white-opacity-light g-margin-b-5--xs">Jake Richardson / Google</h4>
                            </div>
                        </div>
                        <div class="swiper-slide g-padding-x-130--sm g-padding-x-150--lg">
                            <div class="g-padding-x-20--xs g-padding-x-50--lg">
                                <div class="g-margin-b-40--xs">
                                    <p class="g-font-size-22--xs g-font-size-28--sm g-color--white"><i>" I have purchased many great templates over the years but this product and this company have taken it to the next level. Exceptional customizability. "</i></p>
                                </div>
                                <div class="center-block g-hor-divider__solid--white-opacity-lightest g-width-100--xs g-margin-b-30--xs"></div>
                                <h4 class="g-font-size-15--xs g-font-size-18--sm g-color--white-opacity-light g-margin-b-5--xs">Jake Richardson / Google</h4>
                            </div>
                        </div>
                        <div class="swiper-slide g-padding-x-130--sm g-padding-x-150--lg">
                            <div class="g-padding-x-20--xs g-padding-x-50--lg">
                                <div class="g-margin-b-40--xs">
                                    <p class="g-font-size-22--xs g-font-size-28--sm g-color--white"><i>" I have purchased many great templates over the years but this product and this company have taken it to the next level. Exceptional customizability. "</i></p>
                                </div>
                                <div class="center-block g-hor-divider__solid--white-opacity-lightest g-width-100--xs g-margin-b-30--xs"></div>
                                <h4 class="g-font-size-15--xs g-font-size-18--sm g-color--white-opacity-light g-margin-b-5--xs">Jake Richardson / Google</h4>
                            </div>
                        </div>
                    </div>
                    <!-- End Swipper Wrapper -->

                    <!-- Arrows -->
                    <div class="g-font-size-22--xs g-color--white-opacity js__swiper-fraction"></div>
                    <a href="javascript:void(0);" class="g-display-none--xs g-display-inline-block--sm s-swiper__arrow-v1--right s-icon s-icon--md s-icon--white-brd g-radius--circle ti-angle-right js__swiper-btn--next"></a>
                    <a href="javascript:void(0);" class="g-display-none--xs g-display-inline-block--sm s-swiper__arrow-v1--left s-icon s-icon--md s-icon--white-brd g-radius--circle ti-angle-left js__swiper-btn--prev"></a>
                    <!-- End Arrows -->
                </div>
            </div>
        </div>
        <!-- End Testimonials -->      
                            
               
                            
                            
                            </div>
                            
                            
                            
                            
        
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

       
    </body>
     <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
       <%--  <script>
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
         
         
         
         <%-- 
         <script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
		<script src="assets/js/jquery.js"></script>
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/js/sly.min.js"></script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
	    <script src="assets/js/jquery.isotope.min.js"></script>
	    <script src="assets/js/main.js"></script>
	    <script src="assets/js/wow.min.js"></script>
	    <script type="text/javascript" src="assets/js/header-sticky.min.js"></script> --%>
	    
	    
	    <%-- 
    
     	<script type="text/javascript" src="assets/js/swiper.jquery.min.js"></script>
     	<script type="text/javascript" src="assets/js/swiper.min.js"></script>
    
         <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
       <script type="text/javascript" src="assets/js/jquery.parallax.min.js"></script> 
        <script type="text/javascript" src="vendor/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
        <script type="text/javascript" src="assets/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
        <script type="text/javascript" src="assets/js/javaScript.js"></script>

        <!-- General Components and Settings -->
        <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="assets/js/components/faq.min.js"></script> --%>
        
        
        
        <script type="text/javascript" src="assets/js/jquery.min.js"></script>
       <script type="text/javascript" src="assets/js/jquery.scrollbar.min.js"></script>
       <script src="assets/bootstrap/js/bootstrap.min.js"></script>
       <script type="text/javascript" src="assets/js/jquery.back-to-top.min.js"></script>
       <script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
       <script type="text/javascript" src="assets/js/swiper.jquery.min.js"></script>
       <script type="text/javascript" src="assets/js/swiper.min.js"></script>
       <script type="text/javascript" src="assets/js/jquery.parallax.min.js"></script>
       <script type="text/javascript" src="assets/js/components/parallax.min.js"></script>
       <script type="text/javascript" src="assets/js/waypoint.min.js"></script>
       <script type="text/javascript" src="assets/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
       <script type="text/javascript" src="assets/js/counterup.min.js"></script>
       <script type="text/javascript" src="assets/js/components/counter.min.js"></script>
       <script type="text/javascript" src="assets/js/javaScript.js"></script>
       
       
        <!--========== END JAVASCRIPTS ==========-->
    <!-- End Body -->
    
    
    
    
</html>
