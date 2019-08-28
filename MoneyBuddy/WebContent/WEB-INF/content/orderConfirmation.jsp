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
        
        <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" /> -->
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        <!-- <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet"> -->
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
	
        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->
        
       <!--  <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />
 -->
        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style2.css" rel="stylesheet" type="text/css"/>
       <!--  <link href="css/material-kit.css" rel="stylesheet"/> -->
        
        
        

        <!-- Favicon -->
        <!-- <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/> -->
        
        
        
		
		<script>
		
		
		
		function checkRadio(selection)  {
			
			if (selection == "Yes") 
				var totalPayableAmount = parseInt(document.getElementById("totUpfrontAmt").innerHTML) +parseInt(document.getElementById("totSipAmt").innerHTML);
			else 
				var totalPayableAmount = parseInt(document.getElementById("totUpfrontAmt").innerHTML) ;
			/* var totalUpfrontAmount = "${totalUpfrontAmount}"; */
       	  	
       	 	document.getElementById("payable-amount").innerHTML = totalPayableAmount;
       	 
		}
		
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



<body style="background: url(img/1920x1080/01.jpg) 50% 0 no-repeat fixed;">
   <div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo-white.png" alt="MoneyBuddy Logo">
		</a>
	</div>
	<div class="row">
		<div class="col-xs-1"></div>
		<div class="col-xs-10 g-height-70--xs g-height-80--lg  g-bg-color--dark " >
	    	<div class="profile">
	        	<div class="name pagination">
	                	<s:set var="disBankName" value="displayBankName" />
	                	<h3 class="title g-font-size-15--xs g-font-size-20--lg g-color--white">Investor Name:&nbsp;&nbsp;&nbsp;&nbsp;<b><s:property value="#session.customerName" /></b>
	                	<br/>Paying via:&nbsp;&nbsp;&nbsp;&nbsp;<b><s:property value="#disBankName"/></b></h3>
	                	
						<!-- <h3></h3> -->
						<%-- <h6 style="color:white;"><s:property value="#session.customerMobileNumber" /></h6> --%>
	            </div>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
	
	<s:form  action="paymentAction" method="post" name="formPayment">
	
	
	<div class="row g-height-auto--lg g-height-auto--xs" >
		<div class="col-xs-1" ></div>
		<div class="col-xs-10  g-bg-color--white " >
			<div class="row text-center g-margin-t-15--xs">
				<h3 class=" g-font-size-15--xs g-font-size-22--lg "><b><u>Order Confirmation</u></b></h3>
			</div>
			<div id="customer-cart-list" class=" g-margin-b-30--xs g-margin-t-10--xs g-margin-r-100--lg g-margin-l-100--lg">
					<s:set var="anyUpfront" value="#session.anyUpfrontOrder" />
			  		<s:set var="anySip" value="#session.anySipOrder" />
				  		<table id="cartData" class="table table-bordered stripe ">
										<thead class="table-head g-font-size-12--xs g-font-size-14--lg g-bg-color--gray-light center text-center">
											<tr>
												<th class="col-xs-3">Fund Name</th>
												<th class="col-xs-3">Transaction Type</th>
												<s:if test="'TRUE'.equals(#anyUpfront) ">
													<th class="col-xs-3">Lumpsum Amount<br/>(Rs.)</th>
												</s:if>
												<s:else>
													<th class="col-xs-3 hidden">Lumpsum Amount<br/>(Rs.)</th>
												</s:else>
												<s:if test="'TRUE'.equals(#anySip) ">
													<th class="col-xs-3">SIP Amount<br/>(Rs/month)</th>
												</s:if>
												<s:else>
													<th class="col-xs-3 hidden">SIP Amount<br/>(Rs/month)</th>
												</s:else>
												
											</tr>
										</thead>
										<tbody class="table-body g-font-size-12--xs g-font-size-14--lg center text-center">
												<%
													boolean anySipInvestment = false;
												%>
												<s:iterator value="#session.customerCartList" var="customerCartListElement">
													<tr>
													    <s:if test="schemeName.equals('Total')">
													    	
													    	<p class="hidden" id="totUpfrontAmt"><s:property value="#customerCartListElement.upfrontAmount"/></p>
													    	<p class="hidden" id="totSipAmt"><s:property value="#customerCartListElement.sipAmount"/></p>

														    <td>
														    	<b><s:property value="#customerCartListElement.schemeName"/></b>
													    	</td>
													    	<td></td>
													    	<s:if test="'TRUE'.equals(#anyUpfront) ">
															    <td>
															    	<b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/></b>
														    	</td>
													    	</s:if>
													    	<s:else>
														    	<td class="hidden">
															    	<b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/></b>
														    	</td>
													    	</s:else>
													    	<s:if test="'TRUE'.equals(#anySip) ">
														    	<td>
														    		<b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/></b>
														    	</td>
													    	</s:if>
													    	<s:else>
														    	<td class="hidden">
														    		<b><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/></b>
														    	</td>
													    	</s:else>
												    	</s:if>
												    	<s:else>
												    		<s:set var="transactionType" value="#customerCartListElement.transactionType" />
												    		<td>
												    			<s:property value="#customerCartListElement.schemeName"/>
											    			</td>
											    			<td>
													    		<s:property value="#customerCartListElement.transactionType"/>
												    		</td>
											    			<s:if test="('TRUE'.equals(#anyUpfront)) && ('TRUE'.equals(#anySip)) ">
												    			<s:if test="transactionType.equals('UPFRONT')">
																   <td>
																    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/>
															    	</td>
															    	<td>NA</td>
														    	</s:if>
														    	<s:else>
															    	<td>NA</td>
															    	<td>
																    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/>
															    	</td>
													    		</s:else>
													    	</s:if>
													    	<s:else>
														    	<s:if test="'TRUE'.equals(#anyUpfront) ">
														    		<td>
																    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/>
															    	</td>
															    	<td class="hidden"></td>
																    	
														    	</s:if>
														    	<s:else>
														    		<td class="hidden"></td>
															    	<td>
																    	<s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/>
															    	</td>
														    	</s:else>
												    		</s:else>
													    	
													    	
													    	
												    		
												    		<%
												    		String transType = (String) pageContext.getAttribute("transactionType"); 
												    		if ("SIP".equals(transType))
												    			anySipInvestment = true;
												    		%>
												    	</s:else>
													</tr>
												</s:iterator>
											 
										</tbody>
									</table>
			</div>
			
			<%-- <div class="row text-center g-margin-t-10--xs">
				<s:set var="disBankName" value="displayBankName" />
				<h3><b>Paying via:&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#disBankName"/></b></h3>
			</div> --%>
			<br/>
	     </div>
	     <div class="col-xs-1" ></div>
	</div>
	<div class="row">
		<div class="col-xs-1"></div>
		
		<div class="col-xs-10  g-bg-color--white" style="height:40px;">
			<div class="row g-font-size-10--xs g-font-size-14--lg">
					<div class="col-md-1 col-xs-0"></div>
					<div id="investment-options" class="col-md-3 col-xs-6 ">
						<b>Amount Payable Today</b>
					</div>
					<div class="col-md-3 col-xs-6">
						<b><span id="payable-amount"></span>&nbsp;&nbsp;Rs.</b>
					</div>
		        </div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
	
	<div class="row">
		<div class="col-xs-1"></div>
		
		<div class="col-xs-10  g-bg-color--white" style="height:40px;">
			<%
 					if (anySipInvestment)  {
 					%>
 					<div class="row g-font-size-10--xs g-font-size-14--lg">
					<div class="col-md-1 col-xs-0"></div>
					<div id="investment-options" class="col-md-3 col-xs-5 ">
						<b>First SIP payment</b>
					</div>
					<div class="col-md-8 col-xs-7">
						<div id="investment-options" class=" g-margin-b-5--xs">
							<label class="radio-inline ">
							  	<input class="g-font-size-8--xs g-font-size-14--lg" type="radio" id="f1" name="firstOrderFlag" value="Y" checked="checked"  onclick="checkRadio('Yes');" >Today via netbanking
						  	</label>
						  	<label class="radio-inline ">
							  <input class="g-font-size-8--xs g-font-size-14--lg" type="radio" id="f2" name="firstOrderFlag" value="N"  onclick="checkRadio('No');" >Next month via autodebit
							</label>
		        		</div>
					</div>
		        </div>
		        <%
 					}
 					%>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
	
	
	
	<div class="row" >
		<div class="col-xs-4">
			<s:actionmessage class="small-text g-color--red"/> 
		</div>
		<div class="col-xs-6"></div>
	</div>
	<div class="row">
		<div class="col-xs-1"></div>
		
		<div class="col-xs-10  g-bg-color--gray-lighter " style="height:40px;">
			
	     </div>
	     <div class="col-xs-1"></div>
	</div>
	<div class="row g-margin-t-40--xs">
		<div class="text-center">
			<a href="MFDocuments" >I/We have read the scheme related document  <input id="mfDocuments" type="checkbox" onchange="activatePayNowButton();" checked/></a>
		</div>
	</div>
	<div class="row g-margin-t-20--xs">
		<div class="text-center">
			<a href="terms" >I/We agree to MoneyBuddy's Terms</a><a href="privacyPolicy" > & Privacy Policy  <input id="iAccept" type="checkbox" onchange="activatePayNowButton();" checked/></a><br>
		</div>
	</div>
	
	<div class="row g-margin-t-o-20--xs">
		<div class="col-sm-5 col-xs-4"></div>
		<div class="col-sm-2 col-xs-4">
			<button type="button"  id="pay-now-button" class="g-display-table--xs btn btn-home g-color--white g-margin-t-15--xs " onClick="populateBankDetails('<s:property value="tranDetailId"/>');" >Invest Now</button>
		</div>
		<div class="col-sm-5 col-xs-4">
		</div>
	</div>
	<br/>
	<br/>
	<s:hidden id="tran-detail-id-value" name="tranDetailId"></s:hidden>
	</s:form>
	
	
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
		<script>
		
		var totalPayableAmount = parseInt(document.getElementById("totUpfrontAmt").innerHTML) +parseInt(document.getElementById("totSipAmt").innerHTML);
		document.getElementById("payable-amount").innerHTML = totalPayableAmount;
		
		</script>
		
</body>


</html>
