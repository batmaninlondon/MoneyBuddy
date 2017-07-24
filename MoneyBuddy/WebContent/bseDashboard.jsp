<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Dashboard | Money Buddy</title>
    <!-- core CSS -->
    
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="assets/js/jquery-ui.js"></script>
  
  
  
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<%-- <script src="assets/js/jquery.js"></script> --%>
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
    

<script src="assets/js/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<%-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	
</script> --%>

<script>

var data;

//google.load('visualization', '1', {packages:['table']});

google.charts.load('current', {'packages':['table']});

google.charts.setOnLoadCallback(drawTable);


//$(document).ready(function()
		function drawTable()
		{
								$.getJSON('portfolioAction', {}, function(jsonResponse) 
								{
									 data = new google.visualization.DataTable();
									 data.addColumn('string', 'Fund Name');
									 data.addColumn('string', 'InvestmentStartDate');
									 data.addColumn('string', 'Unit');
									 data.addColumn('string', 'Invested Amount');
									 data.addColumn('string', 'Current Amount');
									 data.addColumn('string', 'Rate Of Growth');
									 
									 var cusId ="<%=(String)session.getAttribute("customerId")%>";
									 
									 $.each(jsonResponse.portfolioDataModel , function(i,portfolioData) 
											{

												 data.addRow([portfolioData.fundName,
											 			portfolioData.transactionStartDate,
											 			portfolioData.units,
											 			portfolioData.investedAmount,
											 			portfolioData.currentAmount,
											 			portfolioData.rateOfGrowth,
												               
												                ]);
											});  
		 
						        /*  var options1 = {
						      	          title: jsonResponse.dummyMsg,
						      	          pieHole: 0.4,
						      	       }; */			      	
						      	
						    	var table = new google.visualization.Table(document.getElementById('chart_div1'));
						      	       
						      	     google.visualization.events.addListener(table, 'ready', onReady);

						      	table.draw(data, {showRowNumber: true, width: '100%', height: '100%'}); 
						      	
						      	function onReady() {
						      		//alert("On ready function called !!");
								    google.visualization.events.addListener(table, 'select', fundDetailHandler);
								  }

								  // Called
								  function fundDetailHandler() {
								    //alert("Select event!");
								    
								    var selectedItem = table.getSelection()[0];
								    
								    if (selectedItem) {
								      var value = data.getValue(selectedItem.row, 0);

								      //alert("The user selected " + value);
								    }
								    
								    var selectedItem =null;
								    
								    $.getJSON('investmentDetailsAction', {productName:value}, function(jsonResponse) 
											{
												 data1 = new google.visualization.DataTable();
												 data1.addColumn('string', 'Date Of Purchase');
												 data1.addColumn('string', 'Units Purchased');
												 data1.addColumn('string', 'NAV Purchased');
												 data1.addColumn('string', 'Purchase Type');
												 
												 var cusId ="<%=(String)session.getAttribute("customerId")%>";
												 
												 $.each(jsonResponse.investmentDetailsDataModel , function(i,investmentDetailsData) 
														{

															 data1.addRow([investmentDetailsData.transactionDate,
																 investmentDetailsData.units,
																 investmentDetailsData.navPurchased,
																 investmentDetailsData.transactionType,
															               
															                ]);
														});  
					 
		      	
									      	
									    	var chart = new google.visualization.Table(document.getElementById('chart_div2'));


									      	chart.draw(data1, {showRowNumber: true, width: '100%', height: '100%'}); 
									      	



											});
								    
								    
								    $( "#dialog" ).dialog({autoOpen: true,
								    	title:value,
								    	width: 800,
								    	height:300,
								    	scrollable: true});
								    
								    
								    
								    
								   // window.open("test.jsp",null,"height=200,width=400,status=yes,toolbar=no,menubar=no,location=no");
								  }


								});
								
								  
								
								
					}


</script>
    
  <script>

$( function() {
	 
	 $( "#dialog" ).dialog({autoOpen: false});
  } );
  
</script>  
    
    
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
                        <li ><a href="saveTax">Save Tax</a></li>
                        <li ><a href="blog">Blog</a></li> 
                        <li><a href="help">Help</a></li> 
                       
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li><a href="login" >Sign in</a></li>
										<li><a href="register" >Sign up</a></li> 
							<%	} else 
							 	{	%>
							 			 <li class="active"><a href="bseDashboard" >Dashboard</a></li> 
							 			 <li><a href="logOff" >Log Out</a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>

	<ul class="nav nav-tabs">
	    <li class="active"><a data-toggle="tab" href="#dashboard">Portfolio</a></li>
	    <!-- <li><a data-toggle="tab" href="#portfolio">Portfolio</a></li> -->

  	</ul>
  <!-- <div class="tab-content"> -->
	<div id="dashboard" class="tab-pane active">
		<!-- <div class="row">
			<div class="col-md-12 well-sm large-text dashboard-row-1" >
				<p style="margin-left:50px;">PortFolio</p>
			</div>
		</div> -->
		<div class="row">
			<div class="col-md-12" style="margin:20px;">
				<div class="tab-pane fade-in active">
					<div id="ajaxResponse"></div>
					<div class="col-md-12">
						<div id="chart_div1" class="chart"></div>
					</div>
				</div>
			</div>
		</div>
		
		<div id="dialog" title="Basic dialog" style="display:none;">
  			<!-- <table class="table table-striped table-bordered" >
				<thead class="table-head">
					<tr>
						<th>Date</th>
						<th>Units Purchased</th>
						<th>NAV Purchased</th>
						
					</tr>
				</thead>
				<tbody class="table-body" >
					<tr>
						<td>2017-01-01</td>
					    <td>10</td>
					    <td>10</td>
					</tr>
					<tr>
						<td>2017-01-05</td>
					    <td>8</td>
					    <td>8</td>
					</tr>
					<tr>
						<td>2017-01-10</td>
					    <td>-6</td>
					    <td>20</td>
					</tr>
					<tr>
						<td>2017-01-15</td>
					    <td>-7</td>
					    <td>18</td>
					</tr>
					<tr>
						<td>2017-01-25</td>
					    <td>5</td>
					    <td>20</td>
					</tr>
					<tr>
						<td>2017-01-30</td>
					    <td>4</td>
					    <td>22</td>
					</tr>
					

				</tbody>
   			</table> -->
   			
   			<div class="row">
				<div class="col-md-12" style="margin:20px;">
					<div class="tab-pane fade-in active">
						<div id="ajaxResponse"></div>
						<div class="col-md-12">
							<div id="chart_div2" class="chart"></div>
						</div>
					</div>
				</div>
			</div>
		
		
		</div>
		
		
	</div>
<!-- 	<div id="portfolio" class="tab-pane">
		<div class="row">
			<div class="col-md-12 well-sm large-text dashboard-row-1" >
				<p style="margin-left:50px;">PortFolio</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12" style="margin:20px;">
				<div class="tab-pane fade-in active">
					<div id="ajaxResponse"></div>
					<div class="col-md-12">
						<div id="chart_div2" class="chart"></div>
					</div>
				</div>
			</div>
		</div>
	</div> -->
  <!-- </div> -->
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











