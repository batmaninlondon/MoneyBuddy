<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Investment Details Page | Money Buddy</title>
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
 	<link href="assets/css/bootstrap/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/bootstrap/animate.min.css" rel="stylesheet">
    <link href="assets/prettyPhoto.css" rel="stylesheet">
    <link href="assets/css/bootstrap/main.css" rel="stylesheet">
    <link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
	<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
	<%-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
 	
    <!-- <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png"> -->



</head>

<body class="homepage bg-warning">
   <header id="header">

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="welcome"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="welcome" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="saveTax" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="MFexplorer"/>" class="s-header-v2__nav-link">Funds Explorer</a></li>
                                    <li class="s-header-v2__nav-item"><a href="contactUs" class="s-header-v2__nav-link">Contact Us</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
										 			<li id="dropdown-selector" class=" btn-group s-header-v2__nav-item dropdown">
				                                        <a href="#" class="s-header-v2__nav-link -is-active dropdown-toggle" data-toggle="dropdown" role="button" >List <span class="caret"></span></a>
				                                    	<ul  id="dropdown-selection" class="dropdown-menu g-margin-t-o-30--xs " role="menu">
				                                    		<li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="aboutUs">About Us</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="blog">Blog</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link  g-color--white" href="FAQs">FAQs</a></li>
													      </ul>
				                                    
				                                    </li>
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/Register</a></li>
										<%	} else 
										 	{	%>
										 			<li class="s-header-v2__nav-item"><a href="customerDashboard" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li class="s-header-v2__nav-item"><a href="<s:url action="customerCartAction"/>" class="s-header-v2__nav-link">Cart</a></li>
										 			 <li id="dropdown-selected" class=" btn-group s-header-v2__nav-item dropdown">
				                                        <a href="#" class="s-header-v2__nav-link -is-active dropdown-toggle" data-toggle="dropdown" role="button" >List <span class="caret"></span></a>
				                                    	<ul  id="dropdown-selection" class="dropdown-menu g-margin-t-o-30--xs " role="menu">
				                                    		<li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="aboutUs">About Us</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="blog">Blog</a></li>
													        <li><a class="dropdown-item s-header-v2__nav-link  g-color--white" href="FAQs">FAQs</a></li>
													      </ul>
				                                    
				                                    </li>
										 			 <li class="s-header-v2__nav-item"><a href="logOff" class="s-header-v2__nav-link">Log Out</a></li>
										<%	}	%>  
                                </ul>
                            </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
	
	<section id="one">
	
	<div class="row" style="margin-top:-60px;margin-bottom:50px;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h2 style="font-family:Aparajita;font-size:35px;"><b>Admin Dashboard</b></h2>
		</div>
		<div class="col-md-3"></div>
	</div>	
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-3">
			<a href="<s:url action="pendingNavsAction"/>">
				<button type="button"  class="btn g-color--white g-margin-t-15--xs ">UploadCustomerNav</button>
			</a>
		</div>
		<div class="col-md-3">
			<s:form  action="displayDashboardAction"  method="post" namespace="/">
				<div id="email-id"  >
		          	
		            <label> Customer Email<span class="req">*</span>  </label>
		           	<%-- <s:fielderror fieldName="emailIdDashboard" class="g-color--red" /> --%>
		  			<s:textfield name="emailIdDashboard" />
		  			<%-- <s:textfield class="form-control" id="pancard-number" placeholder="Enter Pancard Number" name="emailIdDashboard"  /> --%>
		            <!-- <input id="email-id1" type="email"required autocomplete="off"/> -->
	          	</div>
	          	<!-- <button type="button" class="g-bg-color--primary g-color--white"  >ViewCustomersDashboard</button> -->
	          	<s:submit class="btn btn-primary" value="ViewCustomersDashboard" style="padding:5px 15px 5px 15px;"/>
	          	<%-- <a href="<s:url action="displayDashboardAction"/>">
					
					<button type="button"  class="btn g-color--white g-margin-t-15--xs ">ViewCustomersDashboard</button>
				</a> --%>
			</s:form>
		</div>
		<div class="col-md-3"></div>
	
	</div>

<%-- 		<div  id="invested-fund-list" class="row" style="margin-top:20px;padding-left:70px;padding-right:70px;">
			<div class="col-md-1"></div>
			<div  class ="col-md-10">
			<table class="table table-bordered" >
				<thead class="table-head">
					<tr>
						<th class="center col-md-2">Date</th>
						<th class="center col-md-2">RTA</th>
						<th class="center col-md-2">FileType</th>
						<th class="center col-md-3">Download Button</th>
						<th class="center col-md-3">Upload Status Button</th>
					</tr>
				</thead>
				<tbody class="table-body" >

					 <s:iterator value="#session.dbfStatusDataModel" var="dbfStatusDataModelElement">
					 <s:property value="#session.dbfStatusDataModel.size"/>
						<tr >
						    <td class="center date" style="padding:0px;vertical-align: middle;"><s:property value="#dbfStatusDataModelElement.dbfDataDate"/></td>
						    <td class="center date" style="padding:0px;vertical-align: middle;"><s:property value="#dbfStatusDataModelElement.rta"/></td>
						    <td class="center date" style="padding:0px;vertical-align: middle;"><s:property value="#dbfStatusDataModelElement.dbfFileType"/></td>
						    <td class="center"><s:property value="#productListElement.value"/></td>
						    <td class="center" style="padding:0px;">
						    	<button type="button" id="submit-button-1" class="btn btn-info btn-lg submit-button-1 sharp raised " onClick="downloadDbfFile(this);">Download DBF File</button>
						    </td>
						    <td class="center" style="padding:0px;">
						    	<button type="button" id="submit-button-2" class="btn btn-info btn-lg submit-button-1 sharp raised " onClick="changeUploadStatus(this);">Update Uploaded Status</button>
						    </td>
						</tr>
						<tr >
						    <td class="center" style="padding:0px;vertical-align: middle;">2 Sep 17</td>
						    <td class="center"><s:property value="#productListElement.value"/></td>
						    <td class="center" style="padding:0px;">
						    	<button type="button" id="submit-button-1" value="2" class="btn btn-info btn-lg submit-button-1 sharp raised " onClick="downloadDbfFile(this);">Download DBF File</button>
						    </td>
						    <td class="center" style="padding:0px;">
						    	<button type="button" id="submit-button-2" class="btn btn-info btn-lg submit-button-1 sharp raised " onClick="">Update Uploaded Status</button>
						    </td>
						</tr>
					</s:iterator>
				</tbody>
   			</table>
   			</div>
			<div class="col-md-1"></div>
		</div> --%>
   </section>
      <footer id="footer" class="midnight-blue navbar navbar-fixed-bottom" >
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a target="_blank" href="http://quantwealth.in/" title="MoneyBuddy">MoneyBuddy</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="welcome">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="saveTax">Save Tax</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="allFunds">Funds Explorer</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="FAQs">Help</a></li>
                            </ul>
                </div>
            </div>
        </div>
    </footer>


		<script type="text/javascript"  src="assets/js/jquery.js"></script>
	    <script type="text/javascript"  src="assets/js/bootstrap/bootstrap.min.js"></script>
	    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
	    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
	    <script type="text/javascript" src="assets/js/main.js"></script>
	    <script type="text/javascript" src="assets/js/wow.min.js"></script>
		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
</body>
</html>