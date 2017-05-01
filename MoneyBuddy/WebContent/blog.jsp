<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Blog | Money Buddy</title>
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
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
</head>

<body class="homepage">
   <header id="header">
        <div class="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-4">
                        <div class="top-number"><p><i class="fa fa-phone-square"></i>  +91 9971648736</p></div>
                    </div>
                    <div class="col-sm-6 col-xs-8">
                       <div class="social">
                            <ul class="social-share">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li> 
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-skype"></i></a></li>
                            </ul>
                       </div>
                    </div>
                </div>
            </div><!--/.container-->
        </div><!--/.top-bar-->

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="myIndex">Home</a></li>
                        <li><a href="whyInvest">Why Invest</a></li>
                        <li><a href="aboutUs">About Us</a></li>
                        <li><a href="saveTax">Save Tax</a></li>
                        <li class="active"><a href="blog">Blog</a></li> 
                        <li><a href="help">Help</a></li> 
                       
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li><a href="login" >Sign in</a></li>
										<li><a href="register" >Sign up</a></li> 
							<%	} else 
							 	{	%>
							 			 <li><a href="bseDashboard" >Dashboard</a></li> 
							 			 <li><a href="logOff" >Log Out</a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>


 <section id="blog" class="container">
        <div class="center">
            <h2>Blogs</h2>
        </div>

        <div class="blog">
            <div class="row">
                 <div class="col-md-8">
                    <div class="blog-item">
                        <div class="row">
                            <div class="col-xs-12 col-sm-2 text-center">
                                <div class="entry-meta">
                                    <span id="publish_date">07  NOV</span>
                                    <span><i class="fa fa-user"></i> <a href="#">John Doe</a></span>
                                </div>
                            </div>
                                
                            <div class="col-xs-12 col-sm-10 blog-content">
                                <a href="#"><img class="img-responsive img-blog" src="images/blog/blog1.jpg" width="100%" alt="" /></a>
                                <h2><a href="blog-item.html">Could you save enough for your dream holiday in 5 years?</a></h2>
                                <h3>Everyone loves escaping the hum-drum of modern life once in a while. For most of us, two weeks relaxing around the pool in the sun is enough to keep us ticking over from one year to the next. Sometimes though, it’s nice to dream about that once-in-a-lifetime ‘when I win the lottery’ super-holiday. We each have our own version of what it is, from reading Robinson Crusoe on a palm fringed beach to that back-packing trip you never made after university. Whatever it is, it won’t be cheap. But, if you don’t fancy waiting until retirement to satisfy your urge, you could start saving now and be off on your foreign adventures sooner than you think. For some inspiration, we’ve looked at five unique experiences and worked out what you might need to invest, if you’re willing to take a moderate level of risk with your money, to reach your goal in the next 5 years.</h3>
                                <a class="btn btn-primary readmore" href="blog-item.html">Read More <i class="fa fa-angle-right"></i></a>
                            </div>
                        </div>    
                    </div>
                    
                    
                        
                    <div class="blog-item">
                        <div class="row">
                             <div class="col-sm-2 text-center">
                                <div class="entry-meta"> 
                                    <span id="publish_date">07  NOV</span>
                                    <span><i class="fa fa-user"></i> <a href="#">John Doe</a></span>
                                </div>
                            </div>
                             <div class="col-xs-12 col-sm-10 blog-content">
                                <a href="#"><img class="img-responsive img-blog" src="images/blog/blog1.jpg" width="100%" alt="" /></a>
                                <h2><a href="blog-item.html">Happy New Tax Year!</a></h2>
                                <h3>6th April each year heralds a brand-new tax year in the UK, meaning a brand new tax-free ISA allowance for you to use in any way you see fit. But, with all the new types of ISA now available to choose from, deciding how to use your limit can be a bit of a minefield. Here’s what you need to know.

 

Your personal tax-free ISA allowance has increased from this year to £20,000, up from £15,240 last year, so make the most of it, if you can.
 

With the introduction of the Lifetime ISA this year, there are now four main types of ISA for those over 18 – a cash ISA, Investment ISA, Innovative Finance ISA and Lifetime ISA.
 

The Innovative Finance ISA is a tax-efficient wrapper for people using Peer to Peer lending platforms.
 

The Lifetime ISA is designed specifically for people between 18- 40 to help them buy their first home, or save for retirement. Wealthify will be offering Lifetime ISAs later in 2017.
 

Under the current rules, you can only open one of each of the four types of ISA per tax year, but you can split your £20,000 annual tax-free ISA allowance between them. The maximum you can put in a Lifetime ISA is £4,000.
 

If you want to use some of your 2017/18 ISA allowance to open a Wealthify investment ISA, you can do as long as you are over 18, are a UK tax resident, and you’ve not opened another Investment ISA in the current tax year.
 

If you’re planning on using some of your £20,000 tax-free allowance to open a stocks & shares ISA this tax year, don’t wait until just before the ISA deadline in April to do it, if you can help it. It may seem obvious, but by delaying, your money is missing out on almost 12 months of potentially good stock market growth. And if it’s in a cash savings account or your bank account in the meantime, it’s unlikely to be enjoying an inflation-beating interest rate either. Even if you can only manage to save small amounts at the beginning of the tax year, the earlier you start investing the better, as you’ll benefit from the power of compound interest, where you earn interest on your interest (or dividends). It can build up surprisingly fast and give you a solid head-start on your long-term savings goals.

 

If you have any questions about the 2017/18 ISA allowance, you can contact us on 0800 802 1800 or by Live Chat.

The tax treatment depends on your individual circumstances and maybe subject to change in the future.

Please remember that the value of your investments can go down as well as up and you can get back less than invested.

If you're unsure which ISA types is suitable for you, please seek financial advice.</h3>
                                <a class="btn btn-primary readmore" href="blog-item.html">Read More <i class="fa fa-angle-right"></i></a>
                            </div>
                        </div>    
                    </div><!--/.blog-item-->
                        
                </div><!--/.col-md-8-->

                
            </div><!--/.row-->
        </div>
    </section><!--/#blog-->

  
      <footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2013 <a target="_blank" href="http://shapebootstrap.net/" title="Free Twitter Bootstrap WordPress Themes and HTML templates">ShapeBootstrap</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Faq</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>


</body>
</html>