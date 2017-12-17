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
        <nav class="navbar navbar-inverse navbar-fixed-top" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="myIndex"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li id="header-nav-li"><a href="myIndex"><b>Home</b></a></li>
                        <li id="header-nav-li"><a href="saveTax"><b>Save Tax</b></a></li>
                        <li  id="header-nav-li"><a href="aboutUs"><b>About Us</b></a></li>
                        <li class="active" id="header-nav-li"><a href="blog"><b>Blog</b></a></li> 
                        <li id="header-nav-li"><a href="help"><b>FAQs</b></a></li> 
                        <li id="header-nav-li"><a href="startSip"><b>Contact Us</b></a></li>
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li id="header-nav-li"><a href="login" ><b>Sign in</b></a></li>
										<li id="header-nav-li"><a href="register" ><b>Sign up</b></a></li> 
							<%	} else 
							 	{	%>
							 			 <li id="header-nav-li"><a href="bseDashboard" ><b>Dashboard</b></a></li> 
							 			 <li id="header-nav-li"><a href="logOff" ><b>Log Out</b></a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>



 <section id="blog" class="container" >
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
                                <h2><a href="blog-item.html">Why to be a part of MoneyBuddy family?</a></h2>
                                <h3>
                                Wealth creation is as much about saving as it's about growing those savings in a tax efficient manner. We understand there's a limit to how much an individual can save in today's high cost of living environment thus we pay special attention to growing our customer's money in a risk adjusted and tax efficient way.

Following are the key features enjoyed by the members of MoneyBuddy family.

Superior fund selection There are over 1,000 mutual funds in India, We do a lot of data crunching to find funds that are expected to perform better than their peers.
Income Tax optimisation Special attention is paid to the current income tax status of our customers and funds are recommend according to the unique needs of our customers. We've also created algorithm to ensure you pay the least (if any) income tax if and when you withdraw your money and profits.
Easy Liquidity You can withdraw all or part of your money as and when you want; Your bank account will be credited in the next 2-3 working days
Online portfolio tracking You can track the value of your portfolio 24*7 by logging into our website. You can also track the performance of individual funds in your portfolio as well.
Secure and Automated Once your investment planning is complete, everything else is taken care via automated softwares. We use the most secure payment gateway and do the periodic audit of our software to ensure the security of your data.
Impeccable team Customer advisory and fund selection is done by our founder Mr. Kamal Wadhwani himself. He has around 10 years of experience in Indian and International financial markets. He completed his engineering from IIT Bombay and is pursuing CFA, USA.
                                
                                
                                </h3>
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
                                <h3>6th April each year heralds a brand-new tax year in the UK, meaning a brand new tax-free ISA allowance for you to use in any way you see fit. But, with all the new types of ISA now available to choose from, deciding how to use your limit can be a bit of a minefield. Hereâs what you need to know.

 

Your personal tax-free ISA allowance has increased from this year to Â£20,000, up from Â£15,240 last year, so make the most of it, if you can.
 

With the introduction of the Lifetime ISA this year, there are now four main types of ISA for those over 18 â a cash ISA, Investment ISA, Innovative Finance ISA and Lifetime ISA.
 

The Innovative Finance ISA is a tax-efficient wrapper for people using Peer to Peer lending platforms.
 

The Lifetime ISA is designed specifically for people between 18- 40 to help them buy their first home, or save for retirement. Wealthify will be offering Lifetime ISAs later in 2017.
 

Under the current rules, you can only open one of each of the four types of ISA per tax year, but you can split your Â£20,000 annual tax-free ISA allowance between them. The maximum you can put in a Lifetime ISA is Â£4,000.
 

If you want to use some of your 2017/18 ISA allowance to open a Wealthify investment ISA, you can do as long as you are over 18, are a UK tax resident, and youâve not opened another Investment ISA in the current tax year.
 

If youâre planning on using some of your Â£20,000 tax-free allowance to open a stocks & shares ISA this tax year, donât wait until just before the ISA deadline in April to do it, if you can help it. It may seem obvious, but by delaying, your money is missing out on almost 12 months of potentially good stock market growth. And if itâs in a cash savings account or your bank account in the meantime, itâs unlikely to be enjoying an inflation-beating interest rate either. Even if you can only manage to save small amounts at the beginning of the tax year, the earlier you start investing the better, as youâll benefit from the power of compound interest, where you earn interest on your interest (or dividends). It can build up surprisingly fast and give you a solid head-start on your long-term savings goals.

 

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

  
     <footer id="footer" class="midnight-blue  navbar navbar-fixed-bottom">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a href="#" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
                </div>
                
                
                
                <div class="col-sm-6">
                    <ul class="pull-right">
                       <li><a href="https://www.facebook.com/MoneyBuddyIndia"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="https://twitter.com/MoneyBuddyIndia"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="https://www.linkedin.com/in/money-buddy-94a73814a/"><i class="fa fa-linkedin"></i></a></li> 
                                <li><a href="https://www.YouTube.com/MoneyBuddy"><i class="fa fa-youtube"></i></a></li>
                                
                    </ul>
                </div>
            </div>
        </div>
    </footer>


</body>
</html>