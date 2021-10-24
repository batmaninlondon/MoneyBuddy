<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.DAOClasses.Trading"%>
<!doctype html>
<html lang="en">
<head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>DemoProject - Future with Technologies</title>
        <meta http-equiv="Cache-control" content="max-age=2592000, public">
	        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        
        <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
	
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style2.css" rel="stylesheet" type="text/css"/>

		<script>
		
		$(document).ready(function() {
		    $('#cartData').DataTable( {
		        "paging":   false,
		        "ordering": false,
		        "info":     false,
		        "searching": false,
		        "responsive": true,
		        "lengthMenu": [ [5, 10, 25, 50, -1], [5, 10, 25, 50, "All"] ]
		        
		        
		    } );
		} );
		
		</script>
		

    </head>

<body style="background: url(img/123.jpg) 50% 0 no-repeat fixed;">
    
   <div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <h1><img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/verinite.png" alt="Verinite Logo"></h1>
		   <!-- <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/verinite.png" alt="Verinite Logo"> -->
		</a>
	</div>
	<div class="row g-height-auto--lg" >
		<div class="col-xs-1" ></div>
		<div class="col-xs-10  g-bg-color--white " >
			<div class="row text-center g-margin-t-5--xs g-margin-b-15--lg">
				<h3 class=" g-font-size-15--xs g-font-size-22--lg "><b>Project Details</b></h3>
			</div>
			<div id="customer-cart-list" class=" g-margin-t-5--xs g-margin-b-30--lg   g-margin-r-100--lg g-margin-l-100--lg">
					<s:set var="anyUpfront" value="#session.anyUpfrontOrder" />
			  		<s:set var="anySip" value="#session.anySipOrder" />
			  		<table id="cartData" class="table table-hover table-bordered stripe">
										<thead class="table-head g-font-size-12--xs g-font-size-14--lg center text-center g-bg-color--gray-light">
											<tr>
												<th class="col-xs-2 text-center">Project Id</th>
												<th class="col-xs-10 text-center">Project Description</th>
												
											</tr>
										</thead>
										<tbody class="table-body g-font-size-10--xs g-font-size-14--lg center  text-center">
											<tr><td>ProjectId 1</td><td>First Description</td></tr>
											<tr><td>ProjectId 2</td><td>Second Description</td></tr>
											<tr><td>ProjectId 3</td><td>Third Description</td></tr>
											<tr><td>ProjectId 4</td><td>Fourth Description</td></tr>
											<tr><td>ProjectId 5</td><td>Fifth Description</td></tr>
											<tr><td>ProjectId 6</td><td>Sixth Description</td></tr> 
										</tbody>
									</table>
			</div>
	     </div>
	     <div class="col-xs-1" ></div>
	</div>
	 	<script src="assets/js/jquery.js"></script>
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
	  	<script type="text/javascript" src="assets/js/jquery-latest.js"></script>
	  	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
</body>
	

</html>
