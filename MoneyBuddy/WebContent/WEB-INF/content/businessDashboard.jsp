<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="en">
<head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy - Top Performing Mutual Funds</title>

        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
        <!-- <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/> -->
        <link href="assets/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>
        

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
       		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		
		
	<style>
input[type="range"] { 
    margin: auto;
    -webkit-appearance: none;
    position: relative;
   	overflow: hidden; 
    height: 15px;
    width: 250px;
    cursor: pointer;
    border-radius: 30px; /* iOS */
}

::-webkit-slider-runnable-track {
    background: #ddd;
}

/*
 * 1. Set to 0 width and remove border for a slider without a thumb
 */
::-webkit-slider-thumb {
    -webkit-appearance: none;
    width: 10px; 
    height: 10px;
    background: #fff;
    box-shadow: -100vw 0 0 100vw #4ee0e4;
    border-radius: 50%;
    background: #4CAF50;
    border: 10px solid #13b1cd; /* 1 */
}

::-moz-range-track {
    height: 400px;
    background: #ddd;
}

::-moz-range-thumb {
    background: #fff;
    height: 10px;
    width: 10px;
    background: #fff;
    box-shadow: -100vw 0 0 100vw #4ee0e4;
    border-radius: 50%;
    background: #4CAF50;
    border: 10px solid #13b1cd; /* 1 */
}

::-ms-fill-lower { 
    background: #13b1cd;
}

::-ms-thumb { 
    background: #fff;
    height: 10px;
    width: 10px;
    background: #fff;
    box-shadow: -100vw 0 0 100vw #4ee0e4;
    border-radius: 50%;
    background: #4CAF50;
    border: 10px solid #13b1cd; /* 1 */
}

::-ms-ticks-after { 
    display: none; 
}

::-ms-ticks-before { 
    display: none; 
}

::-ms-track { 
    background: #ddd;
    color: transparent;
    height: 20px;
    border: none;
}

::-ms-tooltip { 
    display: none;
}

.buttonBlock {
  background-color: #13b1cd !important;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
    </style>	
    
    
<style>

	input[type='number'] {
	    -moz-appearance:textfield;
	}
	
	input::-webkit-outer-spin-button,
	input::-webkit-inner-spin-button {
	    -webkit-appearance: none;
	}


</style>    
    
    <script>
    (function(h,o,t,j,a,r){
        h.hj=h.hj||function(){(h.hj.q=h.hj.q||[]).push(arguments)};
        h._hjSettings={hjid:1416665,hjsv:6};
        a=o.getElementsByTagName('head')[0];
        r=o.createElement('script');r.async=1;
        r.src=t+h._hjSettings.hjid+j+h._hjSettings.hjsv;
        a.appendChild(r);
    })(window,document,'https://static.hotjar.com/c/hotjar-','.js?sv=');
</script>

    </head>

<body class="homepage bg-warning" onload="setInitialUpfrontInvestment();">

	<header id="header">

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <div class="s-header-v2__logo">
                        <a href="<s:url action="adminHome"/>" class="s-header-v2__logo-link">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
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
    
	<section id="businessDashboardSection">
	
	
	<div id="business-dashboard" class="">

	<div class="row g-margin-t-40--xs g-margin-b-20--xs">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10   " >

				  	<table id="businessDashboardData" width="100%;" class="table table-bordered" >
						
						<thead class="table-head g-font-size-14--xs g-bg-color--gray-light" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<tr class="g-bg-color--gray-light">
								<th class="text-center col-md-9 g-bg-color--gray-light" height="10"></th>
								<th class="text-center col-md-3 g-bg-color--gray-light"></th>
							</tr>
						</thead>
						<tbody class="table-body " style=" border: solid 0.5px #dbdbdb;">
							<tr class="table-body  ">
							    	<td  class="text-center g-font-size-16--xs" 	>
							    		Total no of Signups
						    		</td>
						    		<td  class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.signUps"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Total no of AoFs downloaded/created
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.aofCreation"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Total no of active accounts ( account verified)
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.verfiedAccounts"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Total no of active accounts ( aof activated)
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.activatedAccounts"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Gross value of money invested
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.investedAmount"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Gross current value of total investments
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.currentAmount"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Total no of SIPs registered
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.sipRegistered"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Total no of clients running SIPs
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.numOfSipClients"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Gross cumulative monthly value of all the running SIPs
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.monthlyRunningSipValue"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Total no of STPs registered
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.stpRegistered"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Total no of clients running STPs
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.numOfStpClients"/>
						    		</td>
							</tr>
							<tr class="table-body  " >
							    	<td class="text-center g-font-size-16--xs" 	>
							    		Gross cumulative monthly value of all the running SIPs
						    		</td>
						    		<td class="text-center g-font-size-16--xs" 	>
							    		<s:property value="businessDashboardData.monthlyRunningStpValue"/>
						    		</td>
							</tr>	
							
						</tbody>
						<tfoot class="table-head g-font-size-14--xs g-bg-color--gray-light" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<tr class="g-bg-color--gray-light">
								<th class="text-center col-md-9 g-bg-color--gray-light" height="10"></th>
								<th class="text-center col-md-3 g-bg-color--gray-light"></th>
							</tr>
						</tfoot>
					</table>
	     </div>
	     
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	</div>
	</section>
	    	


  
  		<script type="text/javascript" src="assets/js/javaScript.js"></script>
        <script src="assets/js/jquery.js"></script>
    	<script src="assets/js/bootstrap.min.js"></script>
     	<script src="assets/js/sly.min.js"></script>
	    <script src="assets/js/jquery.prettyPhoto.js"></script>
	    <script src="assets/js/jquery.isotope.min.js"></script>
	    <script src="assets/js/main.js"></script>
	    <script src="assets/js/wow.min.js"></script>
	    <script src="assets/js/index.js"></script>
	    
	    <script type="text/javascript" src="assets/js/jquery-latest.js"></script>
  
  
  
  	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		

</body>
</html>