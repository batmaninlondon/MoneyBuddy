<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Dashboard Page</title>
<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="assets/stylesheet.css" />

<script src="assets/js/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">


<script>
var data1;


google.load('visualization', '1', {packages:['table']});


$(document).ready(function()
		{
		 /* $("#myTab li:eq(1) a").tab('show');
		 $('#investmentTypeName').change(function(event) 
						{ */
						/* var investmentTypeName = $("select#investmentTypeName").val(); */
						
						/* $.getJSON('dashboardAction', {investmentTypeName : investmentTypeName}, function(jsonResponse)  */
								$.getJSON('dashboardAction', {}, function(jsonResponse) 
								{
   
									 data1 = new google.visualization.DataTable();
									 data1.addColumn('string', 'Date of Payment');
									 data1.addColumn('string', 'Client Id');
									 data1.addColumn('string', 'Order Id');
									 data1.addColumn('string', 'Paid/Dropped Off');
									 data1.addColumn('string', 'PaymentSuccessful');
									 data1.addColumn('string', 'BSE Payment Id');
									 data1.addColumn('string', 'Amount Paid');
									 data1.addColumn('string', 'Fund Name');
									 data1.addColumn('string', 'Reverse Feed');
									 data1.addColumn('string', 'Client Email Sent');
									 
									 var cusId ="<%=(String)session.getAttribute("customerId")%>";
									 
									 $.each(jsonResponse.dashboardDataModel , function(i,dashboardData) 
											{

												 data1.addRow([dashboardData.transactionDate,
													 			cusId,
												               dashboardData.orderId,
												               "paid",
												               "Y",
												               "bsePaymentId",
												               dashboardData.transactionAmount,
												               dashboardData.productName,
												               dashboardData.reverseFeed,
												               "NO",
												               
												                ]);
											});  
		 
						         var options1 = {
						      	          title: jsonResponse.dummyMsg,
						      	          pieHole: 0.4,
						      	       };			      	
						      	
						    	var chart1 = new google.visualization.Table(document.getElementById('chart_div1'));
						      	chart1.draw(data1, {showRowNumber: true, width: '100%', height: '100%'});  
						      	
			    		
								});
					});
		/* }); */
		

		
</script>
</head>
<body>

	<div id="wrap">
		<img class="bgfade" src="images/backgroundImage1.jpg" /> 
		<img class="bgfade" src="images/backgroundImage2.jpg" />
		<img class="bgfade" src="images/backgroundImage3.jpg" /> 
		<img class="bgfade" src="images/backgroundImage4.jpg" /> 
		<img class="bgfade" src="images/backgroundImage5.jpg" />
	</div>
	<div class="row row-first">
		<div class="col-md-12" id="header">
			<%  if(session.getAttribute("customerId") == null)
			 	{   %> 
			<%@ include file="headerLoggedOff.jsp"%>
			<%	} else 
			 	{	%>
			<%@ include file="headerLoggedIn.jsp"%>
			<%	}	%>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 well-sm large-text dashboard-row-1" >
			<p style="margin-left:50px;">Dashboard</p>
		</div>
	</div>
	<%-- <div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-11">
			<p class="large-text">Select INVESTMENT TYPE NAME from dropdown to View or Edit</p>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-11">
			<s:select list="#session.groupNamesList" name="investmentTypeName" style="height:50px;font-size:20px;"></s:select>
		</div>
	</div> --%>
<!-- 	<div class="row">
		<div class="col-md-12" style="margin:20px;">
			<ul class="nav nav-tabs" id="myTab">
				<li><a data-toggle="tab" class="small-text">Dashboard</a></li>
			</ul>
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
	

	<script type="text/javascript" src="assets/js/JQuery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/javaScript.js"></script>	
</body>
</html>