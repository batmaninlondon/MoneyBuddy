
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Register | Money Buddy</title>
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
                    <a class="navbar-brand" href="myIndex"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="myIndex">Home</a></li>
                        <li><a href="whyInvest">Why Invest</a></li>
                        <li><a href="aboutUs">About Us</a></li>
                        <li><a href="saveTax">Save Tax</a></li>
                        <li ><a href="blog">Blog</a></li> 
                        <li><a href="help">Help</a></li> 
                       
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li><a href="login" >Sign in</a></li>
										<li class="active"><a href="register" >Sign up</a></li> 
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


	
	
<div class="row">
		<div class="col-md-12 well-sm large-text login-row-1" >
		<div class="col-md-2"></div>
			<p>Register</p>
		</div>
	</div>
	<br/><br/><br/>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="first-name">First&nbspName:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="firstName" id="first-name" type="text" placeholder="First Name" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="last-name">Last&nbspName:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="lastName" id="last-name" type="text" placeholder="Last Name" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="email-id">Email&nbspID:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="emailId" id="email-id" type="text" placeholder="Email ID" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="password">Password:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="password" id="password" type="password" placeholder="Password" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="confirm-password">Confirm&nbspPassword:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="confirmPassword" id="confirm-password" type="password" placeholder="Confirm Password" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="mobile-number">Contact&nbspNumber:</label>
	    		<div class="col-md-10">
	    			<input class="form-control" name="mobileNumber" id="mobile-number" type="text" placeholder="Contact Number" style="margin-left:50px;">
	      			
	    		</div>
	  		</div>
  		</div>
  		<div class="col-md-5"></div>
	</div>
	<div class="row">
	
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<div id="button-5" class="row">
				<button type="button" id="btn btn-primary readmore" class="btn btn-primary readmore" onClick="register();" style="margin-top:50px; width:200px;">Register</button>
			</div>
		</div>
	</div>
  <br/>
    <br/>  <br/>
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











