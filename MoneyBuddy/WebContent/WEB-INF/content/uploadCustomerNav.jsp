<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
	
<%@ taglib prefix="s" uri="/struts-tags" %>
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
 	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/prettyPhoto.css" rel="stylesheet">
    <link href="assets/css/bootstrap/main.css" rel="stylesheet">
    <link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
    
    <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
    
	<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
	<%-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
 	
    <!-- <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png"> -->

<script>

	function uploadCutsomerNav(el) 
	{		
		var bseOrderId = $(el).closest("tr").find("td:eq(0) input[type='text']").val();
		var bseRegNum = $(el).closest("tr").find("td:eq(1) input[type='text']").val();
		var transactionType = $(el).closest("tr").find("td:eq(2) input[type='text']").val();
		var folioNum = $(el).closest("tr").find("td:eq(6) input[type='text']").val();
		var navValue = $(el).closest("tr").find("td:eq(7) input[type='text']").val();
		var unitsPurchased = $(el).closest("tr").find("td:eq(8) input[type='text']").val();
		var transactionDate = $(el).closest("tr").find("td:eq(9) input[type='text']").val();
		
		//alert('unitsPurchased : '+unitsPurchased);
		document.getElementById("action-bse-order-id").value = bseOrderId;
		document.getElementById("action-bse-reg-num").value = bseRegNum;
		document.getElementById("action-transaction-type").value = transactionType;
		document.getElementById("action-transaction-date").value = transactionDate;
		document.getElementById("action-folio-number").value = folioNum;
		document.getElementById("action-nav-value").value = navValue;
		document.getElementById("action-units-purchased").value = unitsPurchased;
		
		document.formUploadNav.submit();
		
	}

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
                                    <li class="s-header-v2__nav-item col-sm-push-8"><a href="logOff" class="s-header-v2__nav-link">Log Out</a></li>
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
		
		
		
		<div class="row" >
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<table id="cartData" class="table table-bordered stripe ">
						<thead class="table-head " style="font-size:17px;">
							<tr>
								<th class="center col-md-1 g-bg-color--gray-light">BseOrderId</th>
								<th class="center col-md-1 g-bg-color--gray-light">BseRegNum</th>
								<th class="center col-md-1 g-bg-color--gray-light">TrnsType</th>
								<th class="center col-md-1 g-bg-color--gray-light">RTA</th>
								<th class="center col-md-1 g-bg-color--gray-light">SchemeType</th>
								<th class="center col-md-2 g-bg-color--gray-light">TransactionDate</th>
								<th class="center col-md-2 g-bg-color--gray-light">FolioNum</th>
								<th class="center col-md-2 g-bg-color--gray-light">NAV</th>
								<th class="center col-md-2 g-bg-color--gray-light">Units</th>	
								<th class="center col-md-1 g-bg-color--gray-light"></th>
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs">
							<%-- <s:set var="pendingNavOrders" <s:property value="pendingNavOrders"/> /> --%>
							<s:form  action="uploadCustomerNavAction" method="post" name="formUploadNav" namespace="/" >
								<s:iterator value="pendingNavOrders" var="pendingNavOrdersElement">
									<tr>
									    <td class="center g-font-size-14--xs">
									    	<s:if test="#pendingNavOrdersElement.bseOrderId == ''  || #pendingNavOrdersElement.bseOrderId == null ">
  											  	<input class="form-control" id="folio-num" type="text" placeholder="Enter BSE Order Id" >
											</s:if>
									    	<s:else>
									    		<input class="form-control" type="text" value ="<s:property value="#pendingNavOrdersElement.bseOrderId"/>" readonly>
									    	</s:else>
								    	</td>
									    <td class="center g-font-size-14--xs">
									    	<s:if test="#pendingNavOrdersElement.bseRegNum == ''  || #pendingNavOrdersElement.bseRegNum == null ">
  											  	<input class="form-control" type="text" value ="NA" readonly>
											</s:if>
									    	<s:else>
									    		<input class="form-control" type="text" value ="<s:property value="#pendingNavOrdersElement.bseRegNum"/>" readonly>
									    	</s:else>
							    		</td>
									    <td class="center g-font-size-14--xs">
									    	<input class="form-control" type="text" value ="<s:property value="#pendingNavOrdersElement.transactionType"/>" readonly>
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="emailId" class="g-color--red" /> --%>
			  								<%-- <s:textfield class="form-control" id="bse-order-id" readonly ><s:property value="#pendingNavOrdersElement.key"/></s:textfield> --%>
									    	<s:property value="#pendingNavOrdersElement.rta"/>
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="emailId" class="g-color--red" /> --%>
			  								<%-- <s:textfield class="form-control" id="bse-order-id" readonly ><s:property value="#pendingNavOrdersElement.key"/></s:textfield> --%>
									    	<s:property value="#pendingNavOrdersElement.schemeType"/>
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="emailId" class="g-color--red" /> --%>
			  								<%-- <s:textfield class="form-control" id="bse-order-id" readonly ><s:property value="#pendingNavOrdersElement.key"/></s:textfield> --%>
									    	<s:property value="#pendingNavOrdersElement.frmtTransactionDate"/>
									    </td>
									    
									    <td class="center g-font-size-14--xs">
									    	<s:if test="#pendingNavOrdersElement.transactionFolioNum == ''  || #pendingNavOrdersElement.transactionFolioNum == null ">
									    		<%-- <s:fielderror fieldName="folioNum" class="g-color--red" /> --%>
											  	<%-- <s:textfield class="form-control" id="folio-num" placeholder="Enter Folio Num"  /> --%>
											  	<input class="form-control" id="folio-num" type="text" placeholder="Enter Folio Num" >
									    	</s:if>
									    	<s:else>
									    		<s:set var="folNum" value="#pendingNavOrdersElement.transactionFolioNum" />
									    		<%-- <s:fielderror fieldName="folioNum" class="g-color--red" /> --%>
											  	<%-- <s:textfield class="form-control" id="folio-num" placeholder="Enter Folio Num" value="#FolNum" /> --%>
									    		<input class="form-control" type="text" value ="<s:property value="#pendingNavOrdersElement.transactionFolioNum"/>" readonly>
									    	</s:else>
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="folioNum" class="g-color--red" /> --%>
										  	<%-- <s:textfield class="form-control" id="nav-value" placeholder="Enter NAV" /> --%>
									    	<input class="form-control" id="nav-value" type="text" placeholder="Enter NAV" >
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="unitsPurchased" class="g-color--red" /> --%>
										  	<%-- <s:textfield class="form-control" id="units-purchased" placeholder="Enter Units" /> --%>
									    	<input class="form-control" id="units-purchased" type="text" placeholder="Enter Units" >
									    	
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<input class="form-control hidden" id="transaction-date" type="text" value ="<s:property value="#pendingNavOrdersElement.transactionDate"/>" >
									    	<s:submit class="btn btn-home readmore submit-button-1" style="padding:5px 15px 5px 15px;" value="Upload NAV"  onCLick="uploadCutsomerNav(this)" />
									    	<!-- <button type="button" class="btn btn-primary readmore submit-button-1" onClick="uploadCutsomerNav(this);">Upload NAV</button> -->
									    </td>
									</tr>
								</s:iterator>
								<s:hidden id="action-bse-order-id" name="bseOrderId"></s:hidden>
								<s:hidden id="action-bse-reg-num" name="bseRegNum"></s:hidden>
								<s:hidden id="action-transaction-type" name="transactionType"></s:hidden>
								<s:hidden id="action-transaction-date" name="transactionDate"></s:hidden>
								<s:hidden id="action-folio-number" name="folioNum"></s:hidden>
								<s:hidden id="action-nav-value" name="navValue"></s:hidden>
								<s:hidden id="action-units-purchased" name="unitsPurchased"></s:hidden>
								</s:form>
							 
						</tbody>
					</table>
				</div>
				<div class="col-md-1"></div>
		</div>

		<div class="row" style="margin-top:20px;">
			<div class="col-md-6"></div>
			<div class="col-md-6">
				
			</div>
	
		</div>
	
	</div>
	
	<div id="successfully-uploaded-nav" class="row hidden" style="margin-top:-60px;margin-bottom:50px;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h2 style="font-family:Aparajita;font-size:35px;"><b>Successfully Uploaded NAV</b></h2>
		</div>
		<div class="col-md-3"></div>
	</div>
	
	
   </section>
      <footer id="footer" class="midnight-blue navbar navbar-fixed-bottom" >
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a target="_blank" href="https://moneybuddy.co.in/" title="MoneyBuddy">MoneyBuddy</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="welcome">Home</a></li>
                        <li><a href="aboutUs">About Us</a></li>
                        <li><a href="help">Contact Us</a></li>
                        <li><a href="register">Sign Up</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>


		<script type="text/javascript"  src="assets/js/jquery.js"></script>
	    <script type="text/javascript"  src="assets/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
	    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
	    <script type="text/javascript" src="assets/js/main.js"></script>
	    <script type="text/javascript" src="assets/js/wow.min.js"></script>
		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
</body>
</html>