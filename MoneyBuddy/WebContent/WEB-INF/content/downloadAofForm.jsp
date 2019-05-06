<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy-Top Performing Mutual Funds</title>
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		<link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
	
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/swiper/swiper.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/bootstrap/font-awesome.min.css" rel="stylesheet"> -->

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
        <!-- <link rel="stylesheet" type="text/css" href="css/cardio.css"> -->

        <!-- Favicon -->
        <!-- <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png"> -->
       
                <%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
        <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
 	
  
  <script type="text/javascript" src="assets/js/jquery-latest.js"></script>
  
  
 <script>
		$(document).ready(function(){
		  $("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myDiv1 div").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
</script>


<style>
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Raleway:400,500,700);
.snip1418 {
  font-family: 'Raleway', Arial, sans-serif;
  position: relative;
  float: left;
  overflow: hidden;
  margin: 10px 1%;
  text-align: left;
  color: #000000;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  font-size: 16px;
  -webkit-transform: translateZ(0);
  transform: translateZ(0);
  -webkit-perspective: 20em;
  perspective: 20em;
}
.snip1418 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.snip1418 .add-to-cart {
  position: absolute;
  height:50px;
  top: 0;
  right: 0;
  padding-top: 20px;
  padding-left: 10px;
  padding-right: 10px;
  color: #ffffff;
  font-weight: 700;
  text-transform: uppercase;
  font-size: 0.9em;
  opacity: 0;
 // background-color: #409ad5;
   background-color: black;
  -webkit-transform: rotateX(-90deg);
  transform: rotateX(-90deg);
  -webkit-transform-origin: 100% 0;
  -ms-transform-origin: 100% 0;
  transform-origin: 100% 0;
}

.snip1418 figcaption {
//  padding: 20px;
}
.snip1418 h3,
.snip1418 p {
  margin: 0;
}
.snip1418 h3 {
  font-size: 1em;
  font-weight: 700;
  margin-bottom: 10px;
  text-transform: uppercase;
}
.snip1418 p {
  font-size: 0.7em;
  letter-spacing: 1px;
  font-weight: 400;
}
.snip1418 a {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
.snip1418:hover .add-to-cart,
.snip1418.hover .add-to-cart {
  opacity: 1;
  -webkit-transform: rotateX(0deg);
  transform: rotateX(0deg);
}
.snip1418:hover .add-to-cart i,
.snip1418.hover .add-to-cart i {
  background-color: #2980b9;
}

</style>
 
	<%-- <script>
	function buyFundHandler(fundId)  
    {
			document.getElementById("fund-id-value").value = fundId;
			document.formBuyFundAction.submit();
    }
	</script> --%>
        
    </head>
    <!-- End Head -->

    <!-- Body -->
   <body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;">
   <div class="container ">
   		<a href="welcome.jsp" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="Dublin Logo">
		</a>
	</div>
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:70px;">
	    	<div class="profile">
	        	<div class="name pagination">
	                	<s:set var="disBankName" value="displayBankName" />
	                	<h3 class="title g-color--white">Investor Name:&nbsp;&nbsp;&nbsp;&nbsp;<b><s:property value="#session.customerName" /></b>
	                		
	                	
						<!-- <h3></h3> -->
						<%-- <h6 style="color:white;"><s:property value="#session.customerMobileNumber" /></h6> --%>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	
	<%-- <s:form  action="paymentAction" method="post" name="formPayment"> --%>
	
	
	<div class="row g-height-auto--lg" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
			<div class="row text-center g-margin-t-15--xs">
				<h4 class="title g-margin-l-120--md g-margin-l-20--xs text-center"><u>As required by Govt. regulations, we ask all our users to re-verify their account opening form</u></h4>
			</div>
			<div id="customer-cart-list" class=" g-margin-b-30--xs g-margin-t-10--xs g-margin-r-100--xs g-margin-l-100--xs">
					
			</div>
			
				<h5 class="text-center"> Kindly download your pre-filled account opening form</h5>
				
				<br/>
				
				<h5 class="text-center"> Please email the signed form to admin@MoneyBuddy.co.in</h5>
				
			<br/>
	     </div>
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	

	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:40px;">
			<!-- <div class="col-md-6 col-xs-6"></div>
			<div class="col-md-6 col-xs-6">
				<div class="g-text-right--xs g-margin-r-30--xs ">
					<a href="terms" style="color:black;">I agree to MoneyBuddy's Terms & Privacy Policy  <input id="iAccept" type="checkbox" onchange="activatePayNowButton();" /></a><br>
				</div>
						
			</div> -->

	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>

	
	<div class="row g-margin-t-o-20--xs">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			
			<button type="button"  id="pay-now-button" class="text-center btn btn-home g-color--white g-margin-t-15--xs " 
			onClick="window.open('${pageContext.request.contextPath}/assets/AofForms/<s:property value="aofForm"/>')">
			Download AoF</button>
		</div>
		<div class="col-md-5">
		</div>
	</div>
	
	<%-- <s:hidden id="tran-detail-id-value" name="tranDetailId"></s:hidden>
	</s:form> --%>
	
	
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
	        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
	 	<script src="assets/js/jquery.js"></script>
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
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
    <!-- End Body -->
</html>
