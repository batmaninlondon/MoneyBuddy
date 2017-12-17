
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
                        <li id="header-nav-li"><a href="blog"><b>Blog</b></a></li> 
                        <li id="header-nav-li"><a href="help"><b>FAQs</b></a></li> 
                        <li id="header-nav-li"><a href="startSip"><b>Contact Us</b></a></li>
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li id="header-nav-li"><a href="login" ><b>Sign in</b></a></li>
										<li class="active" id="header-nav-li"><a href="register" ><b>Sign up</b></a></li> 
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


	
	
<div class="row" style="margin-top:100px">
		
	
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="form-group">
	    		<label class="control-label col-md-2 small-text" for="first-name" >First&nbspName:</label>
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