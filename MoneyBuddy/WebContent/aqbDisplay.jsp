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
		<meta http-equiv="Cache-control" content="max-age=2592000, public">
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

    </head>

<body class="homepage bg-warning" onload="setInitialUpfrontInvestment();">

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
    
	<section id="bankDetails">
	
	
	<div id="upload-nav" class="">
		<div class="row" style="margin-top:-60px;margin-bottom:50px;">
			
				<h2 class="text-center" style="font-family:Aparajita;font-size:35px; "><b>Upload NAV</b></h2>
			
		</div>	
		
		<div class="row" style="margin-top:-60px;margin-bottom:50px;">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<s:actionmessage class="small-text g-color--red"/> 
			</div>
			<div class="col-md-3">
			</div>
		</div>
		
	<div class="row g-margin-t-40--xs g-margin-b-20--xs">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10   " >

					<s:form  action="editStpCartAction" method="post" name="formEditStpCart">
				  		<s:hidden id="return-type" name="returnType"></s:hidden>
				  	<table id="stpCartData" width="100%;" >
						
						<thead class="table-head g-font-size-14--xs g-bg-color--gray-light" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<tr class="g-bg-color--gray-light">
								<th class="text-center col-md-3 g-bg-color--gray-light" height="70">CustomerId</th>
								<th class="text-center col-md-3 g-bg-color--gray-light">Quarter</th>
								<th class="text-center col-md-3 g-bg-color--gray-light">Year</th>
								<th class="text-center col-md-3 g-bg-color--gray-light">Aqb Amount</th>
								<th class="text-center col-md-3 g-bg-color--gray-light">Quaterly Fee</th>
								
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<%-- <s:iterator value="#session.customerStpCartList" var="customerStpCartListElement" > --%>
							<s:iterator value="aqbDataModelList" var="aqbDataModelElement">
								<tr class="table-body g-font-size-14--xs " style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
								    	<td height="70" class="text-center g-font-size-14--xs" 	>
								    		<s:property value="#aqbDataModelElement.customerId"/>
							    		</td>
							    		<td height="70" class="text-center g-font-size-14--xs" 	>
							    			<s:if test="quarter == 1">
								    			<s:property value="#aqbDataModelElement.quarter"/> (Jan-Mar)
								    		</s:if>
								    		<s:elseif test="quarter == 2">
								    			<s:property value="#aqbDataModelElement.quarter"/> (Apr-June)
							    			</s:elseif>
							    			<s:elseif test="quarter == 3">
								    			<s:property value="#aqbDataModelElement.quarter"/> (July-Sep)
							    			</s:elseif>
							    			<s:else >
								    			<s:property value="#aqbDataModelElement.quarter"/> (Oct-Dec)
							    			</s:else>
							    		</td>
							    		<td height="70" class="text-center g-font-size-14--xs" 	>
								    		<s:property value="#aqbDataModelElement.year"/>
							    		</td>
							    		<td height="70" class="text-center g-font-size-14--xs" 	>
								    		<s:property value="#aqbDataModelElement.aqbAmount"/>
							    		</td>
							    		<td height="70" class="text-center g-font-size-14--xs" 	>
								    		<s:property value="#aqbDataModelElement.qurterlyFee"/>
							    		</td>
								</tr>
							</s:iterator> 
							
						</tbody>
					</table>
					</s:form>
					
					<s:form  action="deleteStpCartEntryAction" method="post" name="formDeleteStpCart">
				  		<s:hidden id="stp-cart-id-value" name="stpCartId"></s:hidden>
	  				</s:form>
	     </div>
	     
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	    	
			
		<%-- 	<div class="row g-margin-b-50--xs">
  				<div class="col-md-1"></div>
  				<div class="col-md-6 text-left">
  					<a href="javascript:editStpCart('Dashboard');" class=" btn btn-home g-color--white "  >+ Add another fund</a>
  				</div>
  				<div class="col-md-3"></div>
				<div class="col-md-1 text-left">
					<s:form action="redirectAction" method="post">
		      			<s:if test="#session.customerStpCartList.size() == 1 ">
		      				<button type="button"  class="btn btn-home g-color--white disabled"  >Next</button>
		      			</s:if>
		      			<s:else>
		      				<a href="javascript:checkAmounts();" class=" btn btn-home g-color--white "  >Next</a>
		      				<s:submit class="buttonBlock g-color--white text-left " value="Next" />
		      			</s:else>
		      		</s:form>
	      		</div>
	      		<div class="col-md-1"></div>
	      		
			</div> --%>

  
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