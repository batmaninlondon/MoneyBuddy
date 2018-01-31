<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
    	<%
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma","no-cache");
		%>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy | Dashboard</title>
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="Megakit - HTML5 Theme">
        <meta name="author" content="keenthemes.com">

        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    	<link href="assets/bootstrap/css/main.css" rel="stylesheet">
		<link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
		
        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/nmoneybuddy.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
	        
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
<%-- 								  function fundDetailHandler() {
								    alert("Select event!");
								    
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
								  } --%>


								});
								
								  
								
								
					}


<%-- 		  function fundDetailHandler(el) {
			    //alert("Select event!");
			    
			    //var selectedItem = table.getSelection()[0];
			    var selectedItem = $(el).closest("tr").find('td:eq(0)').text();
			    //var selectedItem = $(el).closest("tr").find('td:eq(1)').text();
			    
			    //alert("selectedItem " + selectedItem);
			    /* if (selectedItem) {
			    //	alert("HI");
			      var value = selectedItem;

			      //alert("The user selected " + value);
			    } */
			    
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
			    	title:selectedItem,
			    	width: 800,
			    	height:300,
			    	scrollable: true});
			    
			    
			    
			    
			   // window.open("test.jsp",null,"height=200,width=400,status=yes,toolbar=no,menubar=no,location=no");
			  } --%>
</script>
    
  <script>

$( function() {
	 
	 $( "#dialog" ).dialog({autoOpen: false});
  } );
  
</script>  
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
                                    <li class="s-header-v2__nav-item"><a href="nhome.jsp" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="nsavetax.jsp" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">About Us</a></li>
                                    <li class="s-header-v2__nav-item"><a href="index_portfolio.html" class="s-header-v2__nav-link">Blog</a></li>
                                    <li class="s-header-v2__nav-item"><a href="nfaq.jsp" class="s-header-v2__nav-link">FAQs</a></li>
                                    <li class=" s-header-v2__nav-item s-header-v2__dropdown-on-hover">
                                        <a href="ncontact.jsp" class="dropdown-toggle s-header-v2__nav-link -is-active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contact Us<span class="g-font-size-10--xs g-margin-l-5--xs "></span></a>
                                    </li>
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
		
		
       <!-- Counter -->
         <!-- <div class="js__parallax-window" style="background: url(img/1920x1080/12.jpg) 50% 0 no-repeat fixed;"> -->
        <div class="g-bg-color--dark">
           <!-- <div class="container g-padding-y-80--xs g-padding-y-125--sm"> -->
             <div class="container ">
               <div class="g-text-center--xs g-margin-b-10--xs">
                    <br/>
					<br/>
					<br/>
					<br/>
					<br/>
                    <h3 class="g-font-size-32--xs g-font-size-36--md g-font-family--playfair g-letter-spacing--1 g-color--primary text-left font-weight-bold g-hor-divider__solid--white  ">Dashboard</h3>
                </div> 
                <div class="row" style="padding: 0px; margin: 0px;">
                    <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-bar-chart g-margin-b-30--xsfont-weight-bold ">&nbsp;&nbsp;Total Value </h4>
                             <div >
                                <span class="g-font-size-60--xs g-font-family--playfair g-color--primary" style="line-height: 1;">&#8377; </span>
                                <figure class="g-display-inline-block--xs g-font-size-100--xs g-font-family--brandonText g-color--primary js__counter" style="line-height: 1;">500</figure>
                            </div>
                           
                        </div>
                    </div>
                    
                    <div class="col-md-6 col-xs-6 g-full-width--xs g-margin-b-10--xs g-margin-b-0--lg">
                        <div class="g-text-center--xs" >
                             <h4 class="g-font-size-18--xs g-color--white ti-pulse g-margin-b-30--xsfont-weight-bold g-margin-b-10--xs ">&nbsp;&nbsp;Total Growth </h4>
                             <div >
                                <span class="g-font-size-60--xs g-font-family--playfair g-color--primary" style="line-height: 1;">&#8377; </span>
                                <figure class="g-display-inline-block--xs g-font-size-100--xs g-font-family--brandonText g-color--primary js__counter" style="line-height: 1;">40</figure>
                                 <div class="tooltipOuter">
                                <div class="tooltipInner"></div>
                                </div>
                            
                                 <span class=" icon-help g-font-size-15--xs g-font-family--playfair g-color--white" data-ui-tooltip="We use industry standard<br/>to calculate average return">&nbsp;!&nbsp;</span>
                                  <span class="g-font-size-30--xs g-font-family--playfair g-color--white">&nbsp;&nbsp;10% </span>
                            </div>
                           
                        </div>
                    </div>
                    
                    
                    
                </div>
                 <h3 class="g-font-size-32--xs g-font-size-36--md g-font-family--playfair g-letter-spacing--1 g-color--white text-left font-weight-bold g-hor-divider__solid--white  "></h3>
                 
                 <div class="row" >
                     <div class="col-md-1 col-xs-0" >&nbsp;</div>
                      <div class="col-md-4 col-xs-12 g-full-width--xs g-margin-b-30--xs g-margin-b-0--lg g-color--white">
                        <div class="g-color--white g-text-center--xs ">
                                 <ul class="list-inline ">
                                <li class="g-color--white">
                                    <a class="g-color--white" href="https://www.behance.net/keenthemes">
                                        <i class="g-padding-r-5--xs ti-arrow-circle-up"></i>
                                        <span class="font-weight-bold">Topup&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                    </a>
                                </li>
                                <li class="g-color--white">
                                    <a class="g-color--white" href="https://twitter.com/keenthemes">
                                        <i class="g-padding-r-5--xs ti-arrow-circle-down"></i>
                                        <span class="font-weight-bold">Withdraw</span>
                                     </a>
                                </li>
                    
                                </ul>
                                 
                                 </div>
                        </div>
                    
                        <div class="col-md-7 col-xs-0 g-full-width--xs g-">
                        &nbsp;
                        &nbsp;
                        </div>
                    
                </div>
                  
            </div>
              
            
            
        </div>
        <!-- End Counter -->

	<div class="g-bg-color--white">
            <div class="g-container--md g-text-center--xs g-padding-y-20--xs">
				<table class="table table-striped table-condensed" cellspacing="0" width="100%">
					<thead class="text-center g-font-size-15--xs g-font-size-15--sm g-font-size-15--md ">
						<tr>
							<th class="text-center" >Fund Name</th>
							<th class="text-center" >Unit</th>
							<th class="text-center" >Invested Amount</th>
							<th class="text-center" >Current Amount</th>
							<th class="text-center" >Rate Of Growth</th>
						</tr>
					</thead>
					<tbody class="table-body" >
							<s:iterator value="#session.portfolioDataModel" var="portfolioDataModelElement">
								<tr class="text-center g-font-size-15--xs g-font-size-15--sm g-font-size-15--md ">
								    <td>
								    	<s:set var="fundName" value="#portfolioDataModelElement.fundName" />
								    	<s:if test="fundName.equals('Total')">
								    		<button type="button" class="btn btn-link" onClick=""><s:property value="#portfolioDataModelElement.fundName"/></button>
								    	</s:if>
								    	<s:else>
								    		<button type="button" class="btn btn-link" onClick="fundDetailHandler(this);"><s:property value="#portfolioDataModelElement.fundName"/></button>
								    	</s:else>
								    </td>
								    <td ><s:property value="#portfolioDataModelElement.units"/></td>
								    <td ><s:property value="#portfolioDataModelElement.investedAmount"/></td>
								    <td ><s:property value="#portfolioDataModelElement.currentAmount"/></td>
								    <td ><s:property value="#portfolioDataModelElement.rateOfGrowth"/></td>
								</tr>
							</s:iterator>
					</tbody>
	   			</table>
	   			<div id="dialog" title="Basic dialog" >
				<div class="row" id="fund-history">
				<div class="col-md-12" style="margin:20px;">
					<div class="tab-pane fade-in active" id="investment-details-data-list">
					<table class="table table-striped table-inverse" >
						<thead >
							<tr>
								<th >Date Of Purchase</th>
								<th >Units Purchased</th>
								<th >NAV Purchased</th>
								<th >Transaction Type</th>
							</tr>
						</thead>
						<tbody  >
								<s:iterator value="#session.investmentDetailsDataModel" var="investmentDetailsDataModelElement">
									<tr>
									    <td ><s:property value="#investmentDetailsDataModelElement.transactionDate"/></td>
									    <td ><s:property value="#investmentDetailsDataModelElement.units"/></td>
									    <td ><s:property value="#investmentDetailsDataModelElement.navPurchased"/></td>
									    <td ><s:property value="#investmentDetailsDataModelElement.transactionType"/></td>
									</tr>
								</s:iterator>
						</tbody>
		   			</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12" style="margin:20px;">
					<div class="tab-pane fade-in active">
						<div id="ajaxResponse"></div>
						<div class="col-md-12">
							<div id="chart_div2" class="chart">this is amazing</div>
						</div>
					</div>
				</div>
			</div>
		</div>
				</div>
			</div>


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
        <script type="text/javascript" src="assets/js/jquery-ui.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>

        <!-- General Components and Settings -->
        <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        
        
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
    	<script src="assets/js/jquery.isotope.min.js"></script>
    	<script src="assets/js/main.js"></script>
   	 <script src="assets/js/wow.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
        
        
        
        <!--========== END FOOTER ==========-->

       

        <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <script type="text/javascript" src="vendor/waypoint.min.js"></script>
        <script type="text/javascript" src="vendor/counterup.min.js"></script>
        <script type="text/javascript" src="js/components/swiper.min.js"></script>
        <script type="text/javascript" src="js/components/counter.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
         <script type="text/javascript" src="js/nmoneybuddy.js"></script>
         <script src="assets/js/jquery-1.8.2.js" type="text/javascript"></script>
		 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
		 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        

    </body>
    <!-- End Body -->
</html>
