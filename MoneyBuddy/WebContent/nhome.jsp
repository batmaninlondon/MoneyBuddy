<!DOCTYPE html>
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
        <style>
      div .typed {
        	display: inline-block;
        	margin: 0;
        }
        div .typed-cursor {
        	font-size: 60px;
        	display: inline-block;
        	margin: 0 10px;
        	color: #00a8ff;
        	-webkit-animation-name: flash;
        	animation-name: flash;
        	-webkit-animation-duration: 1s;
        	animation-duration: 1s;
        	-webkit-animation-iteration-count: infinite;
        	animation-iteration-count: infinite;
        }
        .white {
        	color: white;
        }
        </style> 
        
        
    </head>
    <!-- End Head -->

    <!-- Body -->
    <body>
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
    	
    	
    	
    	
        <!--========== SWIPER SLIDER ==========-->
        <div class="s-swiper js__swiper-one-item">
            <!-- Swiper Wrapper -->
            <div class="swiper-wrapper">
                <div class="g-fullheight--xs g-bg-position--center swiper-slide" style="background: url('img/1920x1080/02.jpg');">
                    <div class="container g-text-center--xs g-ver-center--xs">
                        <div class="g-margin-b-30--xs">
                            <h1 class="g-font-size-35--xs g-font-size-45--sm g-font-size-55--md g-color--white">Give your money<br>A chance to grow</h1>
                            
                            
	                            <!-- <div id="intro" >
							<div class="container">
									<div class="table">
								<div class="header-text">
									<div class="row">
									<div class="col-md-12 text-center">
											<h1 class="white typed">It's the only place you have to live.</h1>
										<span class="typed-cursor">|</span>
							</div>
						</div>
					</div>
				</div> -->
                            
                        </div>
                       
                    </div>
                    
                </div>
                
                <div class="g-fullheight--xs g-bg-position--center swiper-slide" style="background: url(images/slider/bg56.jpg);">
                    <div class="container g-text-center--xs g-ver-center--xs">
                        <div class="g-margin-b-30--xs">
                            <div class="g-margin-b-30--xs">
                                <h2 class="g-font-size-35--xs g-font-size-45--sm g-font-size-55--md g-color--white">Your money with our support<br></h2>
                                <span class ="g-color--white">We will support you to grow your money so that you can focus on what matters most to you<</span>
                            </div>
                            
                        </div>
                    </div>
                </div>
                
                <div class="g-fullheight--xs g-bg-position--center swiper-slide" style="background: url('img/1920x1080/01.jpg');">
                    <div class="container g-text-center--xs g-ver-center--xs">
                        <div class="g-margin-b-30--xs">
                            <div class="g-margin-b-30--xs">
                                <h2 class="g-font-size-35--xs g-font-size-45--sm g-font-size-55--md g-color--white">We Craft Experience<br>That Help Brands<br>Stand Out</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
         
	<!-- 	</div> -->
	<!-- </div> -->
            
            <!-- End Swiper Wrapper -->

            <!-- Arrows -->
            <a href="javascript:void(0);" class="s-swiper__arrow-v1--right s-icon s-icon--md s-icon--white-brd g-radius--circle ti-angle-right js__swiper-btn--next"></a>
            <a href="javascript:void(0);" class="s-swiper__arrow-v1--left s-icon s-icon--md s-icon--white-brd g-radius--circle ti-angle-left js__swiper-btn--prev"></a>
            <!-- End Arrows -->
            
            <a href="#js__scroll-to-section" class="s-scroll-to-section-v1--bc g-margin-b-15--xs">
                <span class="g-font-size-18--xs g-color--white ti-angle-double-down"></span>
                <p class="text-uppercase g-color--white g-letter-spacing--3 g-margin-b-0--xs">Learn More</p>
            </a>
        </div>
        <!--========== END SWIPER SLIDER ==========-->


        <!--========== PAGE CONTENT ==========-->
        <!-- Features -->
        <div id="js__scroll-to-section" class="container g-padding-y-80--xs g-padding-y-125--sm">
            <div class="g-text-center--xs g-margin-b-100--xs">
                <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-25--xs">Welcome to Megakit</p>
                <h2 class="g-font-size-32--xs g-font-size-36--md">We Create Beautiful Experiences <br> That Drive Successful Businesses.</h2>
            </div>
            <div class="row g-margin-b-60--xs g-margin-b-70--md">
                <div class="col-sm-4 g-margin-b-60--xs g-margin-b-0--md">
                    <div class="clearfix">
                        <div class="g-media g-width-30--xs">
                            <div class="wow fadeInDown" data-wow-duration=".3" data-wow-delay=".1s">
                                <i class="g-font-size-28--xs g-color--primary ti-desktop"></i>
                            </div>
                        </div>
                        <div class="g-media__body g-padding-x-20--xs">
                            <h3 class="g-font-size-18--xs">Responsive Layout</h3>
                            <p class="g-margin-b-0--xs">This is where we sit down, grab a cup of coffee and dial in the details.</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 g-margin-b-60--xs g-margin-b-0--md">
                    <div class="clearfix">
                        <div class="g-media g-width-30--xs">
                            <div class="wow fadeInDown" data-wow-duration=".3" data-wow-delay=".2s">
                                <i class="g-font-size-28--xs g-color--primary ti-settings"></i>
                            </div>
                        </div>
                        <div class="g-media__body g-padding-x-20--xs">
                            <h3 class="g-font-size-18--xs">Fully Customizable</h3>
                            <p class="g-margin-b-0--xs">This is where we sit down, grab a cup of coffee and dial in the details.</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="clearfix">
                        <div class="g-media g-width-30--xs">
                            <div class="wow fadeInDown" data-wow-duration=".3" data-wow-delay=".3s">
                                <i class="g-font-size-28--xs g-color--primary ti-ruler-alt-2"></i>
                            </div>
                        </div>
                        <div class="g-media__body g-padding-x-20--xs">
                            <h3 class="g-font-size-18--xs">Pixel Perfect</h3>
                            <p class="g-margin-b-0--xs">This is where we sit down, grab a cup of coffee and dial in the details.</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- // end row  -->
            <div class="row">
                <div class="col-sm-4 g-margin-b-60--xs g-margin-b-0--md">
                    <div class="clearfix">
                        <div class="g-media g-width-30--xs">
                            <div class="wow fadeInDown" data-wow-duration=".3" data-wow-delay=".4s">
                                <i class="g-font-size-28--xs g-color--primary ti-package"></i>
                            </div>
                        </div>
                        <div class="g-media__body g-padding-x-20--xs">
                            <h3 class="g-font-size-18--xs">Endless Possibilities</h3>
                            <p class="g-margin-b-0--xs">This is where we sit down, grab a cup of coffee and dial in the details.</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 g-margin-b-60--xs g-margin-b-0--md">
                    <div class="clearfix">
                        <div class="g-media g-width-30--xs">
                            <div class="wow fadeInDown" data-wow-duration=".3" data-wow-delay=".5s">
                                <i class="g-font-size-28--xs g-color--primary ti-star"></i>
                            </div>
                        </div>
                        <div class="g-media__body g-padding-x-20--xs">
                            <h3 class="g-font-size-18--xs">Powerful Performance</h3>
                            <p class="g-margin-b-0--xs">This is where we sit down, grab a cup of coffee and dial in the details.</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="clearfix">
                        <div class="g-media g-width-30--xs">
                            <div class="wow fadeInDown" data-wow-duration=".3" data-wow-delay=".6s">
                                <i class="g-font-size-28--xs g-color--primary ti-panel"></i>
                            </div>
                        </div>
                        <div class="g-media__body g-padding-x-20--xs">
                            <h3 class="g-font-size-18--xs">Parallax Support</h3>
                            <p class="g-margin-b-0--xs">This is where we sit down, grab a cup of coffee and dial in the details.</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- // end row  -->
        </div>
        <!-- End Features -->
<!-- Process -->
        
        <div class="g-bg-color--dark">
        <!-- <div class="g-bg-color--primary-ltr"> -->
            <div class="container g-padding-y-80--xs g-padding-y-125--sm">
                <div class="g-text-center--xs g-margin-b-100--xs">
                    <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-25--xs">Process</p>
                    <h2 class="g-font-size-32--xs g-font-size-36--md g-color--white">How it Works</h2>
                </div>
                <ul class="list-inline row g-margin-b-100--xs">
                    <!-- Process -->
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
                    <!-- End Process -->

                    <!-- Process -->
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
                    <!-- End Process -->

                    <!-- Process -->
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
                    <!-- End Process -->

                    <!-- Process -->
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
                    <!-- End Process -->
                </ul>

                <div class="g-text-center--xs">
                    <a href="#js__scroll-to-appointment" class="text-uppercase s-btn s-btn--md s-btn--white-bg g-radius--50 g-padding-x-70--xs">TRY IT OUT</a>
                </div>
            </div>
        </div>
        <!-- End Process -->
        <!-- Parallax -->
        <div class="js__parallax-window" style="background: url(img/1920x1080/03.jpg) 50% 0 no-repeat fixed;">
            <div class="container g-text-center--xs g-padding-y-80--xs g-padding-y-125--sm">
                <div class="g-margin-b-80--xs">
                    <h2 class="g-font-size-40--xs g-font-size-50--sm g-font-size-60--md g-color--white">The Fastest Way To Develop</h2>
                </div>
                <a href="http://keenthemes.com/" class="text-uppercase s-btn s-btn--md s-btn--white-brd g-radius--50">Learn More</a>
            </div>
        </div>
        <!-- End Parallax -->

        <!-- Culture -->
        <div class="g-promo-section">
            <div class="container g-padding-y-80--xs g-padding-y-125--sm">
                <div class="row">
                    <div class="col-md-4 g-margin-t-15--xs g-margin-b-60--xs g-margin-b-0--lg">
                        <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-25--xs">Culture</p>
                        <div class="wow fadeInLeft" data-wow-duration=".3" data-wow-delay=".1s">
                            <h2 class="g-font-size-40--xs g-font-size-50--sm g-font-size-60--md">About</h2>
                        </div>
                        <div class="wow fadeInLeft" data-wow-duration=".3" data-wow-delay=".3s">
                            <h2 class="g-font-size-40--xs g-font-size-50--sm g-font-size-60--md">Megakit</h2>
                        </div>
                    </div>
                    <div class="col-md-4 col-md-offset-1">
                        <p class="g-font-size-18--xs">We aim high at being focused on building relationships with our clients and community. Using our creative gifts drives this foundation. The time has come to bring those ideas and plans to life. This is where we really begin to visualize your napkin sketches and make them into beautiful pixels.</p>
                        <p class="g-font-size-18--xs">Now that your brand is all dressed up and ready to party, it's time to release it to the world. By the way, let's celebrate already.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 g-promo-section__img-right--lg g-bg-position--center g-height-100-percent--md js__fullwidth-img">
                <img class="img-responsive" src="img/970x970/03.jpg" alt="Image">
            </div>
        </div>
        <!-- End Culture -->

        <!-- Subscribe -->
        <div class="js__parallax-window" style="background: url(img/1920x1080/07.jpg) 50% 0 no-repeat fixed;">
            <div class="g-container--sm g-text-center--xs g-padding-y-80--xs g-padding-y-125--sm">
                <div class="g-margin-b-80--xs">
                    <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--white-opacity g-letter-spacing--2 g-margin-b-25--xs">Subscribe</p>
                    <h2 class="g-font-size-32--xs g-font-size-36--md g-color--white">Join Over 1000+ People</h2>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                        <form class="input-group">
                            <input type="email" class="form-control s-form-v1__input g-radius--left-50" name="email" placeholder="Enter your email">
                            <span class="input-group-btn">
                                <button type="submit" class="s-btn s-btn-icon--md s-btn-icon--white-brd s-btn--white-brd g-radius--right-50"><i class="ti-arrow-right"></i></button>
                            </span>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Subscribe -->

        <!-- Portfolio Filter -->
        

        <!-- Testimonials -->
        <div class="js__parallax-window" style="background: url(img/1920x1080/04.jpg) 50% 0 no-repeat fixed;">
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

        <!-- Clients -->
        <div class="g-bg-color--sky-light">
            <div class="g-container--md g-padding-y-80--xs g-padding-y-125--sm">
                <!-- Swiper Clients -->
                <div class="s-swiper js__swiper-clients">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide">
                            <div class="wow fadeIn" data-wow-duration=".3" data-wow-delay=".1s">
                                <img class="s-clients-v1" src="img/clients/01-dark.png" alt="Clients Logo">
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="wow fadeIn" data-wow-duration=".3" data-wow-delay=".2s">
                                <img class="s-clients-v1" src="img/clients/02-dark.png" alt="Clients Logo">
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="wow fadeIn" data-wow-duration=".3" data-wow-delay=".3s">
                                <img class="s-clients-v1" src="img/clients/03-dark.png" alt="Clients Logo">
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="wow fadeIn" data-wow-duration=".3" data-wow-delay=".4s">
                                <img class="s-clients-v1" src="img/clients/04-dark.png" alt="Clients Logo">
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="wow fadeIn" data-wow-duration=".3" data-wow-delay=".5s">
                                <img class="s-clients-v1" src="img/clients/05-dark.png" alt="Clients Logo">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Swiper Clients -->
            </div>
        </div>
        <!-- End Clients -->

        <!-- News -->
        <div class="container g-padding-y-80--xs g-padding-y-125--sm">
            <div class="g-text-center--xs g-margin-b-80--xs">
                <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2 g-margin-b-25--xs">Blog</p>
                <h2 class="g-font-size-32--xs g-font-size-36--md">Latest News</h2>
            </div>
            <div class="row">
                <div class="col-sm-4 g-margin-b-30--xs g-margin-b-0--md">
                    <!-- News -->
                    <article>
                        <img class="img-responsive" src="img/970x970/01.jpg" alt="Image">
                        <div class="g-bg-color--white g-box-shadow__dark-lightest-v2 g-text-center--xs g-padding-x-40--xs g-padding-y-40--xs">
                            <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2">News</p>
                            <h3 class="g-font-size-22--xs g-letter-spacing--1"><a href="http://keenthemes.com/">Create Something Great.</a></h3>
                            <p>The time has come to bring those ideas and plans to life.</p>
                        </div>
                    </article>
                    <!-- End News -->
                </div>
                <div class="col-sm-4 g-margin-b-30--xs g-margin-b-0--md">
                    <!-- News -->
                    <article>
                        <img class="img-responsive" src="img/970x970/02.jpg" alt="Image">
                        <div class="g-bg-color--white g-box-shadow__dark-lightest-v2 g-text-center--xs g-padding-x-40--xs g-padding-y-40--xs">
                            <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2">News</p>
                            <h3 class="g-font-size-22--xs g-letter-spacing--1"><a href="http://keenthemes.com/">Jacks of All. Experts in All.</a></h3>
                            <p>The time has come to bring those ideas and plans to life.</p>
                        </div>
                    </article>
                    <!-- End News -->
                </div>
                <div class="col-sm-4">
                    <!-- News -->
                    <article>
                        <img class="img-responsive" src="img/970x970/03.jpg" alt="Image">
                        <div class="g-bg-color--white g-box-shadow__dark-lightest-v2 g-text-center--xs g-padding-x-40--xs g-padding-y-40--xs">
                            <p class="text-uppercase g-font-size-14--xs g-font-weight--700 g-color--primary g-letter-spacing--2">News</p>
                            <h3 class="g-font-size-22--xs g-letter-spacing--1"><a href="http://keenthemes.com/">Finding your Perfect Place.</a></h3>
                            <p>The time has come to bring those ideas and plans to life.</p>
                        </div>
                    </article>
                    <!-- End News -->
                </div>
            </div>
        </div>
        <!-- End News -->

        <!-- Counter -->
        <div class="js__parallax-window" style="background: url(img/1920x1080/06.jpg) 50% 0 no-repeat fixed;">
            <div class="container g-padding-y-80--xs g-padding-y-125--sm">
                <div class="row">
                    <div class="col-md-3 col-xs-6 g-full-width--xs g-margin-b-70--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs">
                            <div class="g-margin-b-10--xs">
                                <figure class="g-display-inline-block--xs g-font-size-70--xs g-color--white js__counter">6</figure>
                                <span class="g-font-size-40--xs g-color--white">k</span>
                            </div>
                            <div class="center-block g-hor-divider__solid--white g-width-40--xs g-margin-b-25--xs"></div>
                            <h4 class="g-font-size-18--xs g-color--white">Lines of Code</h4>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-6 g-full-width--xs g-margin-b-70--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs">
                            <figure class="g-display-block--xs g-font-size-70--xs g-color--white g-margin-b-10--xs js__counter">5</figure>
                            <div class="center-block g-hor-divider__solid--white g-width-40--xs g-margin-b-25--xs"></div>
                            <h4 class="g-font-size-18--xs g-color--white">Award Winners</h4>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-6 g-full-width--xs g-margin-b-70--xs g-margin-b-0--sm">
                        <div class="g-text-center--xs">
                            <figure class="g-display-block--xs g-font-size-70--xs g-color--white g-margin-b-10--xs js__counter">15</figure>
                            <div class="center-block g-hor-divider__solid--white g-width-40--xs g-margin-b-25--xs"></div>
                            <h4 class="g-font-size-18--xs g-color--white">Multiple Pages</h4>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-6 g-full-width--xs">
                        <div class="g-text-center--xs">
                            <div class="g-margin-b-10--xs">
                                <figure class="g-display-inline-block--xs g-font-size-70--xs g-color--white js__counter">2</figure>
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
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBsXUGTFS09pLVdsYEE9YrO2y4IAncAO2U"></script>
        <script type="text/javascript" src="vendor/jquery.wow.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
      	<!-- <script src="js/typewriter.js"></script>
		<script>
		    $(".typed").typewriter({speed: 60});
		</script> -->
		

        <!-- General Components and Settings -->
        <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="js/components/magnific-popup.min.js"></script>
        <script type="text/javascript" src="js/components/swiper.min.js"></script>
        <script type="text/javascript" src="js/components/counter.min.js"></script>
        <script type="text/javascript" src="js/components/portfolio-3-col.min.js"></script>
        <script type="text/javascript" src="js/components/parallax.min.js"></script>
        <script type="text/javascript" src="js/components/google-map.min.js"></script>
        <script type="text/javascript" src="js/components/wow.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->

    </body>
    <!-- End Body -->
</html>
