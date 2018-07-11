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
        <title>Megakit - HTML5 Theme</title>
        <meta name="keywords" content="HTML5 Theme" />
        <meta name="description" content="Megakit - HTML5 Theme">
        <meta name="author" content="keenthemes.com">
    	<link rel="icon" type="image/png" href="../assets/img/favicon.png">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">

        <!-- Vendor Styles -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/>
        
       <!--  <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />
 -->
        <!-- Theme Styles -->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/global/global.css" rel="stylesheet" type="text/css"/>
       <!--  <link href="css/material-kit.css" rel="stylesheet"/> -->
        
        
        

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        
        
        <script type="text/javascript" src="assets/js/javaScript.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
     <script src="assets/js/sly.min.js"></script>
    <script src="assets/js/jquery.prettyPhoto.js"></script>
    <script src="assets/js/jquery.isotope.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <script src="assets/js/index.js"></script>
  
  	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
  
  
  
  	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		
		<script>
		
		$(document).ready(function() {
		    $('#cartData').DataTable( {
		        "paging":   true,
		        "ordering": false,
		        "info":     true,
		        "searching": false,
		        "responsive": true,
		        "lengthMenu": [ [5, 10, 25, 50, -1], [5, 10, 25, 50, "All"] ]
		        
		        
		    } );
		} );
		
		</script>

	
    </head>

<body style="background: url(img/1920x1080/10.jpg) 50% 0 no-repeat fixed;">
	<%
	System.out.println("transactionType : "+session.getAttribute("transactionType"));
	/* System.out.println("kycStaus in session in jsp: "+session.getAttribute("kycStatus")); */
	%>
   <!--  <div class="g-fullheight--xs g-bg-position--center swiper-slide" style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;"> -->

   <div class="container ">
   		<a href="myIndex" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="Dublin Logo">
		</a>
	</div>
	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--dark " style="height:100px;">
	    	<div class="profile">
	        	<div class="name">
	                	<h3 class="title g-color--white"><s:property value="#session.emailId" /></h3>
						<h6 style="color:white;">Payment Page </h6>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	
	<s:form  action="paymentAction" method="post" name="formPayment">
	
	<div class="row" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
	    	<div class="profile">
			        	<div class="name">
			        		<div class="row">
			        			<div  class="col-md-6 g-margin-t-40--xs" >

								<s:set var="respMsgvalue" value="respMsg" />
			  					<s:if test="'bankDetailsExists'.equals(#respMsgvalue) ">
			  					<div class="row">
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Bank Name</h6>
									</div>
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<s:set var="selBankName" value="selectedBankName" />
										<s:set var="disBankName" value="displayBankName" />
										
										<select class="form-control" id="bank-name" name="bankName" >
									        <option value="<s:property value="#selBankName"/>"><s:property value="#disBankName"/></option>
							      		</select>
									</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs">
									</div>
			  					</div>
			  					<div class="row ">
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Account Type</h6>
									</div>
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<s:set var="selAccType" value="selectedAccType" />
										<s:set var="disAccType" value="displayAccType" />
										
										<select class="form-control" id="account-type" name="accountType"  >
									        <option value="<s:property value="#selAccType"/>"><s:property value="#disAccType"/></option>
							      		</select>
									</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs">
									</div>
			  					</div>
			  					<div class="row">
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs ">
										<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Account Number</h6>
									</div>
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs ">
										<s:set var="selAccNum" value="selectedAccNum" />
										<s:set var ="astrics" value="'********'" />
										<s:set var="selAccNumDisplay" value="#astrics+selectedAccNum.substring(8,12)" />

										<s:fielderror fieldName="accountNumber" class="g-color--red" />
										<s:textfield id="account-number" name="accountNumber" value="%{selAccNum}" class="field left hidden" readonly="true" />
			  							<s:textfield id="account-number-dis" name="accountNumberDis" value="%{selAccNumDisplay}" class="field left" readonly="true" /> 
										<%-- <input type="text" id="account-number"  name="accountNumber" value="<s:property value="#selAccNum"/>" class="field left" readonly> --%>
									</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs ">
									</div>
			  					</div>
									<s:fielderror fieldName="reAccountNumber" class="g-color--red" />
		  							<s:textfield id="re-account-number" name="reAccountNumber" value="%{selAccNum}" class="field left hidden" readonly="true" /> 
									<%-- <input class="hidden" type="text" id="re-account-number" name="reAccountNumber" value="<s:property value="#selAccNum"/>" class="field left" readonly> --%>
			  					<div class="row">
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<h6 class="title" >IFSC Code </h6>
									</div>
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<s:set var="selIfscCode" value="selectedIfscCode" />
										<s:fielderror fieldName="ifscCode" class="g-color--red" />
										<s:textfield id="ifsc-code" name="ifscCode" value="%{selIfscCode}" class="field left" readonly="true"/> 
										<%-- <input type="text" id="ifsc-code" name="ifscCode" value="<s:property value="#selIfscCode"/>" class="field left" readonly> --%>
									</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs">
									</div>
			  					</div>
			  					<s:set var="transactionType" value="#session.transactionType" />
								<s:if test="#transactionType.equals('UPFRONT')">
			  					</s:if>
			  					<s:else>
			  					<div class="row">
			  						<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
			  							First Order Today
		  							</div>
						        	<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<s:select class="form-control"  id="firstOrderFlag"
											list="#{'Y':'Yes', 'N':'No'}" 
											name="firstOrderFlag" 
											value="Y" />
						        	</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs">
									</div>
			  					</div>
			  					</s:else>
							</s:if>
							<s:else>
							
								<div class="row">
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Bank Name</h6>
									</div>
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
						      			<select class="form-control" id="bank-name" name="bankName" >
									        <option value="ICI">ICICI Bank</option>
									        <option value="SBI">SBI Bank</option>
									        <option value="HDF">HDFC Bank</option>
									        <option value="162">KOTAK Bank</option>
									        <option value="UTI">Axis Bank</option>
									        <option value="PNB">Punjab National Bank</option>
									        <option value="SIB">South Indian Bank</option>
									        <option value="SCB">Standard Chartered Bank</option>
									        <option value="UBI">Union Bank Of India</option>
									        <option value="UNI">United Bank Of India</option>
									        <option value="YBK">Yes Bank Ltd</option>
									        <option value="RBL">Ratnakar Bank</option>
									        <option value="DCB">DCB</option>
							      		</select>
									</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs">
									</div>
			  					</div>
			  					<div class="row ">
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Account Type</h6>
									</div>
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<select class="form-control" id="account-type" name="accountType">
									        <option value="CB">Current Account</option>
									        <option value="SB">Saving Account</option>
									        <option value="NE">NRI - Repatriable (NRE)</option>
									        <option value="NO">NRI - Repatriable (NRO)</option>
							      		</select>
									</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs">
									</div>
			  					</div>
			  					<div class="row">
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs ">
										<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Account Number</h6>
									</div>
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs ">
										<s:fielderror fieldName="accountNumber" class="g-color--red" />
			  							<s:textfield id="account-number" placeholder="Enter Account Number" name="accountNumber" class="form-control" /> 
										<!-- <input class="form-control" id="account-number" name="accountNumber" type="text" placeholder="Enter Account Number" > -->
									</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs ">
									</div>
			  					</div>
			  					<div class="row">
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<h6 class="title" style="margin-top: 20px; margin-bottom: 15px;">Re-enter Account Number</h6>
									</div>
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<s:fielderror fieldName="reAccountNumber" class="g-color--red" />
		  								<s:password class="form-control" id="re-account-number" name="reAccountNumber" placeholder="Enter Account Number" /> 
										<!-- <input class="form-control" id="re-account-number" name="reAccountNumber" type="password" placeholder="Enter Account Number" "> -->
									</div>
									<div id="investment-options" class="col-md-2">
									</div>
			  					</div>
			  					<div class="row">
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<h6 class="title" >IFSC Code </h6>
									</div>
									<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<s:fielderror fieldName="ifscCode" class="g-color--red" />
		  								<s:textfield class="form-control" id="ifsc-code" name="ifscCode" placeholder="Enter IFSC Code"/> 
										<!-- <input class="form-control" id="ifsc-code" name="ifscCode" type="text" placeholder="Enter IFSC Code"> -->
									</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs">
									</div>
			  					</div>
			  					<s:set var="transactionType" value="#session.transactionType" />
			  					<s:if test="#transactionType.equals('UPFRONT')">
			  					</s:if>
			  					<s:else>
			  					<div class="row">
			  						<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
			  							First Order Today
		  							</div>
						        	<div id="investment-options" class="col-md-5 g-margin-b-5--xs">
										<s:select class="form-control"  id="firstOrderFlag"
											list="#{'Y':'Yes', 'N':'No'}" 
											name="firstOrderFlag" 
											value="Y" />
						        	</div>
									<div id="investment-options" class="col-md-2 g-margin-b-5--xs">
									</div>
			  					</div>
			  					</s:else>
							
							</s:else>
							
							</div>
							<div  class="col-md-6 g-margin-t-40--xs" >
								<div class=" g-margin-b-30--xs g-margin-t-30--xs g-margin-r-100--xs g-margin-l-100--xs">
									<table id="cartData" class="table table-bordered stripe ">
										<thead class="table-head g-font-size-14--xs">
											<tr>
												<th class="center col-md-3 g-bg-color--gray-light">Fund Name</th>
												<th class="center col-md-3 g-bg-color--gray-light">Amount</th>
											</tr>
										</thead>
										<tbody class="table-body g-font-size-14--xs">
											<%-- <s:set var="transactionType" value="#session.transactionType" /> --%>
											<s:if test="#transactionType.equals('UPFRONT')">
												<% System.out.println("Inside Upfront"); %>
												<s:iterator value="#session.customerCartList" var="customerCartListElement">
													<tr>
													    <td class="center g-font-size-14--xs"><s:property value="#customerCartListElement.productName"/></td>
													    <td class="center g-font-size-14--xs"><s:property value="#customerCartListElement.amount"/></td>
													</tr>
												</s:iterator>
											</s:if>
											<s:else>
												<% System.out.println("Inside Sip"); %>
												<s:iterator value="#session.productList" var="productListElement">
													<tr>
													    <td class="center g-font-size-14--xs"><s:property value="#productListElement.key"/></td>
													    <td class="center g-font-size-14--xs"><s:property value="#productListElement.value"/></td>
													</tr>
												</s:iterator>
											</s:else>
											 
										</tbody>
									</table>
							</div>
							</div>
							
							
					</div>
					<div class="row" >
						<div class="col-md-6 col-xs-4">
							<s:actionmessage class="small-text g-color--red"/> 
						</div>
						<div class="col-md-6 col-xs-6"></div>
					</div>
	
				     <div class="row">
						<div class="col-md-6 col-xs-4">
							<div class="checkbox">
				  				<label><input id="iAccept" type="checkbox" onchange="activatePayNowButton();" />I accept terms & condition</label>
							</div>
						</div>
					</div>
		
					</div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1" ></div>
	
	</div>
	

	<div class="row">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10  g-bg-color--gray-lighter " style="height:60px;">
	    	<div class="profile">
	        	<div class="name g-text-right--xs g-margin-r-10--xs" >
	        		<%-- <s:set var="tranDetailIdvalue" value="tranDetailId" /> --%>
        			<button type="button"  id="pay-now-button" class="disabled btn g-color--white g-margin-t-15--xs " onClick="populateBankDetails('<s:property value="tranDetailId"/>');" style="background-color:black; ">Pay Now</button>
	            </div>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	<s:hidden id="tran-detail-id-value" name="tranDetailId"></s:hidden>
	</s:form>
	
</body>
	

</html>
