<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Cache-control" content="max-age=2592000, public">
    <title>Investment Details Page | Money Buddy</title>
    
    <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/prettyPhoto.css" rel="stylesheet">
    <link href="assets/css/bootstrap/main.css" rel="stylesheet">
    <link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
    
    <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
    
    <link rel="stylesheet" href="assets/css/stylePieChart.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">

    </head>
<body class="homepage " onload="abc('<s:property value="businessDashboardData.signUps"/>',
									'<s:property value="businessDashboardData.aofCreation"/>',
									'<s:property value="businessDashboardData.verfiedAccounts"/>',
									'<s:property value="businessDashboardData.activatedAccounts"/>',
									'<s:property value="businessDashboardData.sipRegistered"/>',
									'<s:property value="businessDashboardData.numOfSipClients"/>',
									'<s:property value="businessDashboardData.stpRegistered"/>',
									'<s:property value="businessDashboardData.numOfStpClients"/>');
									bca('<s:property value="businessDashboardData.investedAmount"/>',
									'<s:property value="businessDashboardData.currentAmount"/>',
									'<s:property value="businessDashboardData.monthlyRunningSipValue"/>',
									'<s:property value="businessDashboardData.monthlyRunningStpValue"/>');">
<header id="header">

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <div class="s-header-v2__logo">
                        <a href="<s:url action="adminHome"/>" class="s-header-v2__logo-link">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
                        </a>
                    </div>
                </div>
				
                <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item col-sm-push-7"><a href="<s:url action="adminHome"/>" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item col-sm-push-8"><a href="<s:url action="logOut"/>" class="s-header-v2__nav-link">Log Out</a></li>
                                </ul>
                            </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
   <div >

    <!-- <hr class="my-4"> -->
    <br/><br/>
    <div class="row">
	<div class="col-md-5">
		<canvas id="barChart" style="max-width: 800px;margin-left:50px;"></canvas>
		<br/>
		<table class="table" style="margin-left:50px;margin-right:50px;">
    <tbody>
           
      <tr class="success ">
        <td style="font-size: 20px;">Monthly value of running SIPs</td>
        <td style="font-size: 20px;"><b><s:property value="businessDashboardData.monthlyRunningSipValue"/></b></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
      </tr> 
      <tr class="danger">
        <td style="font-size: 20px;">Monthly value of running STPs</td>
        <td style="font-size: 20px;"><b><s:property value="businessDashboardData.monthlyRunningStpValue"/></b></td>
      </tr>
    </tbody>
  </table>
	</div>
    <div class="col-md-7">
      <canvas id="horBarChart" style="max-width: 800px;"></canvas>
    </div>
    </div>
    <div class="row">
    	<div class="col-md-6"></div>
    	<div class="col-md-6">
    		<p class="text-center " style="color:red;font-size:15px;" ><s:property value="businessDashboardData.errorMsg"/></p>
    	</div>
    </div>
    <section class="bg-light text-center">
    <div class="row">
    	<div class="col-md-3">
    		<b><a href="<s:url action="pendingNavsAction"/>" class="text-success">UploadCustomerNav</a></b>
    	</div>
    	<div class="col-md-3">
    		<b><a href="<s:url action="pendingAofAction"/>" class="text-success">UpdateCustomerAof</a></b>
    	</div>
    	<div class="col-md-6">
    		<s:form  action="existingOldFundData"  method="post" namespace="/">  			
				<div class="col-md-6">
          			<s:textfield name="emailIdOldPortfolio" class="form-control " placeholder="Enter Email Id"/>
          		</div>
          		<div class="col-md-6">
					<b><a href="#" class="text-success pull-left" onclick="$(this).closest('form').submit()">InsertOldPortfolioRecord</a></b>
				</div>
		  	</s:form>
    	</div>
    </div>
    <div class="row">
    	<div class="col-md-3">
    		<b><a href="<s:url action="clientRecordsAction"/>" class="text-success">ClientRecords</a></b>
    	</div>
    	<div class="col-md-3">
    		<b><a href="<s:url action="displayAllAqbAction"/>" class="text-success">ViewAllCustomersAqb</a></b>
    	</div>
    	<div class="col-md-6">
    		<s:form  action="displayDashboardAction"  method="post" namespace="/">  			
				<div class="col-md-6">
          			<s:textfield name="emailIdDashboard" class="form-control" placeholder="Enter Customer email Id"/>
          		</div>
          		<div class="col-md-6">
					<b><a href="#" class="text-success pull-left" onclick="$(this).closest('form').submit()">ViewCustomersDashboard</a></b>
				</div>
		  	</s:form>
    	</div>
    </div>
    <div class="row">
    	<div class="col-md-3">
    		<b><a href="<s:url action="pendingMandateAction"/>" class="text-success">UpdateCustomerMandate</a></b>
    	</div>
    	<div class="col-md-3">
    		<b><a href="<s:url action="pendingAofAction"/>" class="text-success">UpdateCustomerAof</a></b>
    	</div>
    	<div class="col-md-6">
    		<s:form  action="displayCustomerAqbAction"  method="post" namespace="/">  			
				<div class="col-md-6">
          			<s:textfield name="emailIdAqb" class="form-control" placeholder="Enter Customer email Id"/>
          		</div>
          		<div class="col-md-6">
					<b><a href="#" class="text-success pull-left" onclick="$(this).closest('form').submit()">ViewCustomersAqb</a></b>
				</div>
		  	</s:form>
    	</div>
    </div>
    
 
    </section>
   <%--  <section  class="bg-light text-center">
    	   <div class="row">
		<div class="col-md-3">
    	</div>
    	<div class="col-md-3">
    	</div>
		<div class="col-md-6">
		  	<s:form  action="rejectedReverseFeedAction"  method="post" namespace="/">  			
				<div class="col-md-6">
          				<s:textfield name="bseOrderIdDashboard" class="form-control" placeholder="Enter BSE Order Id"/>
          		</div>
          		<div class="col-md-6">
					<b><a href="#" class="text-success pull-left" onclick="$(this).closest('form').submit()">UpdateRejectedTransaction</a></b>
				</div>
		  	</s:form>
		</div>
	</div>
    </section> --%>
    
  </div>
    <script type="text/javascript"  src="assets/js/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script type="text/javascript"  src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
    <script type="text/javascript" src="assets/js/script.js"></script>
    
    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    <script type="text/javascript" src="assets/js/wow.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.js"></script>
	
</body>
</html>