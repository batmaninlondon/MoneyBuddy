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

        <!-- <link rel="icon" type="image/png" href="../assets/img/favicon.png"> -->
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
        
        <!-- <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />
 -->
        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
        <!-- <link href="css/material-kit.css" rel="stylesheet"/> -->
        
        <%-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		<!------ Include the above in your HEAD tag ---------->
		
		<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"  media="screen">
		<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script> --%>
        
        

        <!-- Favicon -->
        <!-- <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"> -->
        <!-- <link rel="apple-touch-icon" href="img/apple-touch-icon.png"> -->
        <!-- <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/> -->
        
        
        
        <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script> --%>
	<%-- <script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>
 	
  
  	<%-- <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> --%>
  
  
  
  	<%-- <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script> --%>
		<%-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script> --%>
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

<body style="background: url(img/1920x1080/10111.jpg) 50% 0 no-repeat fixed;" onload="filldata('<s:property value="#session.minSipAmount"/>','<s:property value="#session.minSipDuration"/>','<s:property value="#session.minPurchaseAmount"/>');">
<%-- <%session.setAttribute("transactionType", "SIP");%>; --%>
	<%
	
	    /* if ("TRUE".equals(request.getParameter("OnetimeInvestment"))) {
	    	session.setAttribute("OnetimeInvestment", "TRUE");
	    	System.out.println("In login jsp : OnetimeInvestment set to TRUE .");

	    	
	    } else if ("FALSE".equals(request.getParameter("OnetimeInvestment"))) {
	    	session.setAttribute("OnetimeInvestment", "FALSE");
	    	System.out.println("In login jsp : OnetimeInvestment set to FALSE .");
	    } */
	session.setAttribute("OnetimeInvestment", "TRUE");
	%>
	
	<input type="hidden" id="investmentType" value="<s:property value="#session.OnetimeInvestment"/>" />
	<!-- <input type="hidden" id="transactionType" value="UPFRONT" /> -->
	
	<div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
		</a>
	</div>
	
	
	<s:set var="fundDetails" value="#session.selectedFundDetailsDataModel" />
	
	<div class="row g-margin-t-40--xs">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10   " >
	    	<div class="profile">
	    		 <h3 class="g-font-size-32--xs g-font-size-24--md g-font-family--playfair g-letter-spacing--1  text-left font-weight-bold g-hor-divider__solid--white  ">Your investment choices</h3>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
	
	
	<%-- <div class="row g-margin-t-20--xs ">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10   " style="background-color:#efece3">
	    	<div class="profile g-margin-t-5--xs g-margin-b-5--xs ">
	  			<span class="g-color--black container " >Please ensure you have read the Key investor information document. 
	  			Remember the value of investments, and any income from them, 
	  			can go down as well as up and you may get back less than you invest.</span>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div> --%>
	
	<div class="row g-margin-t-40--xs g-margin-b-20--xs">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10   " >
					<s:form  action="editCartAction" method="post" name="formEditCart">
				  		<%-- <s:hidden id="select-cart-id" name="cartId"></s:hidden>
				  		<s:hidden id="updated-value" name="upfrontInvestment"></s:hidden>
						<s:hidden id="updated-field" name="updatedField"></s:hidden> --%>
				  		<s:hidden id="return-type" name="returnType"></s:hidden>
				  	<table id="cartData" width="100%;" >
						<thead class="table-head g-font-size-14--xs" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<tr >
								<th class="text-left col-md-5 " height="70"></th>
								<th class="text-left col-md-2 ">Investment Folio</th>
								<th class="text-left col-md-2 ">Lumpsum Amount</th>
								<th class="text-right col-md-2 ">SIP Amount</th>
								<th class="text-left col-md-2 ">SIP Tenure (yrs)</th>
								<th class="text-left col-md-2 ">SIP Debit Date</th>
								<th class="text-center col-md-1 "></th>
								<th class="text-center col-md-1 "></th>
								<th class="text-center col-md-1 "></th>
								
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<s:iterator value="#session.customerCartList" var="customerCartListElement" >
								<tr class="table-body g-font-size-14--xs " style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
								    <s:if test="productName.equals('Total')">
								    	<th class="text-left col-md-5 g-bg-color--gray-light" height="70"></th>
										<th class="text-right col-md-2 g-bg-color--gray-light "><s:property value="#customerCartListElement.productName"/></th>
										<th class="text-right col-md-2 g-bg-color--gray-light "><b><span class="title  text-right" >&#8377; &ensp; </span><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.amount]})}"/></b></th>
										<th class="text-right col-md-2  g-bg-color--gray-light"></th>
										<th class="text-left col-md-2  g-bg-color--gray-light"></th>
										<th class="text-left col-md-2 g-bg-color--gray-light"></th>
										<th class="text-center col-md-1 g-bg-color--gray-light"></th>
										<th class="text-center col-md-1 g-bg-color--gray-light"></th>
										<th class="text-center col-md-1 g-bg-color--gray-light"></th>
								    </s:if>
									<s:else>
								    	<s:set var="selectedCartId" value="#customerCartListElement.cartId" />
								    	<s:set var="folios" value="#customerCartListElement.folioNumList" />
								    	<s:set var="selFolio" value="#customerCartListElement.folioNumber" />
								    	<td class="text-left" height="70" class="text-center g-font-size-14--xs"><s:property value="#customerCartListElement.productName"/></td>
								    	<td class="text-left col-md-2 ">
											<%
											 	
												System.out.println("FolioNumList is : "+pageContext.getAttribute("folios"));
										    	String arr1= (String) pageContext.getAttribute("folios"); 
										    	String selFol= (String) pageContext.getAttribute("selFolio"); 
										    	System.out.println("arr1 : "+arr1);
										    	
										    	if ( arr1 == null)  {
										    		arr1 = "New";
										    	}
										    		String[] a = arr1.split(":");
										    	
										    		System.out.println("a length : "+a.length);
										    	
										    	
										    	 /* if (a.length != 1)  { */
									    		 %>
												<select name="folioNumArr" class="text-right" id="selectFolioNum" style="width:120px;" > 
												    
												    <% 
												    
												    if (a.length != 0)
												    {
												    	for(int i=0;i<a.length;i++){ 
												        String fol= (String)a[i]; 
												        if (fol.equals(selFol))   {%> 
												        <option value="<%=fol%>" selected="selected" > <%=fol%> 
												        </option>
												        <%}
												        else {
												        %>
												        <option value="<%=fol%>" > <%=fol%> 
												        </option>
												        <%}}}%> 
												</select>
												
										</td>
								    	
								    	
								    	<td class="text-right col-md-2 ">
											<%-- <a  href="<s:property value="#customerCartListElement.pdfFilePath"/>" >
										 		<span class="g-font-size-20--xs g-font-size-15--xs fa fa-file-pdf-o g-color--primary"></span>
									 		</a> --%>
									 		<p class="title  " >&#8377;
												<input name="sipAmtArr" type="number" id="sipInvestment" class="g-color--black text-right" value=<s:property value="#customerCartListElement.amount"/>
														min="1"  max="999999"  
														onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
											</p>
										</td>
										<td class="text-right col-md-2 ">
											<p class="title  text-right" >&#8377;
												<input name="investmentAmtArr" type="number" id="upfrontInvestment" class="g-color--black text-right" value=<s:property value="#customerCartListElement.amount"/>
														min="1"  max="999999"  
														onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
														<%-- <input name="upfrontAmtArr" type="number" id="upfrontInvestment" class="g-color--black" value=<s:property value="#customerCartListElement.amount"/>
														min="1"  max="999999" onChange="editCart(<s:property value="selectedCartId" />,this.value,'AMOUNT')" 
														onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" > --%>
											</p>
										</td>
										
										<s:if test="transactionType.equals('UPFRONT')">
										<td class="text-left col-md-2 ">
											<select name="sipTenureArr" class="hidden" id="sip-tenure" style="width:60px;" > 
										        <option value="" >0</option>
											</select>
												
										</td>
										<td class="text-left col-md-2 ">
											<select name="sipDateArr" class="hidden" id="sip-date"  style="width:60px;" > 
										        <option value=""  >0</option>
											</select>
										</td>
										</s:if>
										<s:else>
										<s:set var="selSipTenure" value="#customerCartListElement.sipDuration" />
										<s:set var="selSipDate" value="#customerCartListElement.sipDate" />
										<td class="text-left col-md-2 ">
											<select name="sipTenureArr" class="" id="sip-tenure" style="width:120px;" > 
										        <% 
										        	String selSipTen= (String) pageContext.getAttribute("selSipTenure");
										        	if ("99".equals(selSipTen)) {
										        		selSipTen = "until Stopped";
										        	}
										        	String[] sipTen = {"1 yr","2 yr","5 yr","10 yr","Until Stopped"};
										        	for (int i=0;i<sipTen.length;i++)  {
										        		String tenure= (String)sipTen[i]; 
										        		if (tenure.equals(selSipTen))
										        		{
										        %>
										     		 		<option value="<%=tenure%>" selected="selected"><%=tenure%></option>
								     		 	<%
										        		} else {
							        			%>
										        			<option value="<%=tenure%>" ><%=tenure%></option>
							        			<%
										        			
										        		}
										     		 }
									     		 %>
											</select>
												
										</td>
										<td class="text-left col-md-2 ">
											<select name="sipDateArr" class="" id="sip-date"  style="width:100px;" > 
										        <% 
										        	String selSipDate= (String) pageContext.getAttribute("selSipDate");
										        	String[] sipDates = {"1","5","10","20"};
										        	for (int i=0;i<sipDates.length;i++)  {
										        		String dat= (String)sipDates[i]; 
										        		if ("1".equals(dat))  {
										        			if (dat.equals(selSipDate))
											        		{
						        				%>
										        				<option value="<%=dat%>" selected="selected"><%=dat%><sup>st</sup></option>
						        				<%
											        		}
										        			else {
						        				%>
										        				<option value="<%=dat%>" ><%=dat%><sup>st</sup></option>
						        				<%
										        			}
										        		}
										        		else {
											        		if (dat.equals(selSipDate))
											        		{
										        %>
											     		 		<option value="<%=dat%>" selected="selected"><%=dat%><sup>th</sup></option>
								     		 	<%
											        		} else {
							        			%>
											        			<option value="<%=dat%>" ><%=dat%><sup>th</sup></option>
							        			<%
											        			
											        		}
										        		}
										     		 }
									     		 %>
											</select>
												
										</td>
										</s:else>
										<td class="text-center col-md-1 ">
											 <input class="hidden" name="cartIdArr"  value=<s:property value="#customerCartListElement.cartId"/> />
										</td>
										<td class="text-center col-md-1 ">
											 <input class="hidden" name="productIdArr"  value=<s:property value="#customerCartListElement.productId"/> />
										</td>
										<td class="text-right col-md-1 ">
											 
											 	<a  href="javascript:deleteCartEntry(<s:property value="selectedCartId" />);" >
											 		<span class="g-font-size-20--xs g-font-size-15--xs fa fa-trash-o g-color--primary text-right"></span>
										 		</a>
							    				<%-- <button type="button" class="text-center g-font-size-20--xs g-font-size-15--xs fa fa-trash-o g-color--primary" onClick="deleteCartEntry(<s:property value="selectedCartId" />);" >Remove</button> --%>
							    			
										</td>
										

								    </s:else>
								</tr>
							</s:iterator> 
							
						</tbody>
					</table>
					</s:form>
					
					<s:form  action="deleteCartEntryAction" method="post" name="formDeleteCart">
				  		<s:hidden id="cart-id-value" name="cartId"></s:hidden>
	  				</s:form>
	     </div>
	     
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	    	
			
			<div class="row g-margin-b-50--xs">
  				<div class="col-md-1"></div>
  				<div class="col-md-6 text-left">
  					<a href="javascript:editCart('FundExplorer');" class=" buttonBlock g-color--white "  >+ Add more investments</a>
  				</div>
  				<div class="col-md-3"></div>
				<div class="col-md-1 text-left">
					<s:form action="redirectAction" method="post">
		      			<s:if test="#session.customerCartList.size() == 1 ">
		      				<button type="button"  class="btn buttonBlock g-color--white disabled"  >Next</button>
		      			</s:if>
		      			<s:else>
		      				<s:submit class="buttonBlock g-color--white text-left " value="Next" />
		      			</s:else>
		      		</s:form>
	      		</div>
	      		<div class="col-md-1"></div>
	      		
			</div>

	<%-- <div class="row" >
		<div class="col-md-1 col-xs-1" ></div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
	    	<div class="profile">
				<div class="name">
			    	<div class="container">
			    	<br/>
  						<ul class="nav nav-tabs card-header-pills">
    						<li class="nav-item active"><a class="nav-link  active font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" href="#onetime" onClick="setTransactionType('UPFRONT');">Invest Lumpsum</a></li>
   							<s:if test="#session.selectedFundDetailsDataModel.sipFlag.equals('Y'.toString())">
   								<li class="nav-item "><a class="nav-link font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" href="#sip" onClick="setTransactionType('SIP');">Start SIP</a></li>
 							</s:if>
 						</ul>
 						<!-- <ul class="nav nav-tabs card-header-pills">
    <li class="nav-item active">
      <a class="nav-link  active g-bg-color--primary g-color--white font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" href="#loginTabContent">Log In</a>
    </li>
    <li class="nav-item">
      <a class="nav-link g-bg-color--primary g-color--white font-weight-bold g-box-shadow__dark-lightest-v4" data-toggle="pill" href="#signup">Sign Up</a>
    </li>      
  </ul> -->
  					</div>
  				</div>
  			</div>
  		</div>
  		<div class="col-md-1 col-xs-1" ></div>
  	</div> --%>
<%--   	
  	<s:form  action="newEstimateAction" method="post" name="formEstimate">
  		<s:hidden id="select-folio-num-value" name="selectFolioNum"></s:hidden>
  		<s:hidden id="upfront-investment-value" name="upfrontInvestment"></s:hidden>
		<s:hidden id="sip-amount-value" name="sipAmount"></s:hidden>
		<s:hidden id="sip-duration-value" name="sipDuration"></s:hidden>
		<s:hidden id="sip-plan-value" name="sipPlan"></s:hidden>
		<s:hidden id="sip-date-value" name="sipDate"></s:hidden>
		<s:hidden id="transaction-type-value" name="transactionType" value="UPFRONT"></s:hidden>
  	</s:form>
  	
  	<div class="row "  >
		<div class="col-md-1 col-xs-1" > </div>
		<div class="col-md-10 col-xs-10  g-bg-color--white " >
	    <div class="tab-content">
    		<div id="onetime" class="tab-pane fade in active g-margin-t-20--xs">
      			<div id="upfrontInvestmentDetails">
	    			<!-- <input type="hidden" id="transactionType" value="UPFRONT" /> -->
	        		<div class="name ">
	        			<div class="row ">
					  		<h3 class="title g-margin-l-120--md g-margin-l-20--xs ">You are investing in: <u><s:property value="#fundDetails.schemeName"/></u></h3>
						</div>
						<div class="row g-margin-t-70--xs g-margin-b-20--xs">
							<div id="investment-options" class="col-md-3 col-xs-12">
								<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Investment Amount</p>
							</div>
							<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
							  <input type="range" min="<s:property value="#session.minPurchaseAmount"/>" max="150000" step="500" class="slider" id="myRange">
							</div>
							
							<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
							  Rs.<span id="upfrontInvestment" name="totalInvestment1"></span>
							</div>
							 <s:hidden id="upfrontInvestment" name="totalInvestment"></s:hidden>
							 
							<div class="col-md-4  g-margin-t-10--xs col-xs-6 ">
							<input id="upfront-investment-range" type="range" min="<s:property value="#session.minPurchaseAmount"/>" max="150000" step="500"
											 value="10000" oninput="showNewUpfrontInvestment(this.value)"/>
							</div>
							
							<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Rs. 
								<input type="number" id="upfrontInvestment" class="g-color--black" value="10000"
											min="1"  max="999999" oninput="changeSliderValue(this.value)" 
											onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
								<span id="upfrontInvestment" class="g-color--black"></span>
							</p>
							<div class="col-md-6"></div>
						</div>
						
						
						<s:form action="createCartAction" method="post" >
		  					<div class="row">
								<div class=" " style="height:30px;">
								<s:hidden id="tot-investment-id-value" name="totalInvestment"></s:hidden>
		    						<div class="profile" >
		        						<div class="name g-text-right--xs g-margin-r-10--xs" >
		        							
		        							<s:submit class="tn  g-color--white g-margin-t-15--xs" style="background-color:black;" value="Add to Cart" />
		        							<button type="button" class="btn  g-color--white g-margin-t-15--xs" onClick="newUpdate();"  style="background-color:black;" >Add to Cart</button>
		            					</div>
		       						</div>
		     					</div>
							</div>
						</s:form>
						
					</div>
	       		</div>
    		</div>
   		 	<div id="sip" class="tab-pane fade g-margin-t-20--xs">
      			<div  id="sipInvestmentDetails" >
   					<!-- <input type="hidden" id="transactionType" value="SIP" /> -->
	       				<div class="name">
	       					<div class="row ">
						  		<h3 class="title g-margin-l-120--md g-margin-l-20--xs ">You are investing in: <u><s:property value="#fundDetails.schemeName"/></u></h3>
							</div>
							<div class="row g-margin-t-50--xs g-margin-b-50--xs">
								<div id="investment-options" class="col-md-3 col-xs-12">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " >SIP Amount</p>
								</div>
								<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								  <input type="range" min="<s:property value="#session.minPurchaseAmount"/>" max="150000" step="500" class="slider" id="myRange">
								</div>
								
								<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								  Rs.<span id="sipPerMonth" name="totalInvestment1"></span>
								</div>
								<div class="col-md-4  g-margin-t-10--xs col-xs-4 g-margin-l-o-30--lg">
								<input id="sip-amount-range" type="range" min="<s:property value="#session.minSipAmount"/>" max="150000" step="100"
												 value="10000" oninput="showSipAmountPerMonth(this.value)"/>
								
								</div>
								<p class="title g-margin-l-80--md g-margin-l-20--xs  " >Rs.
								 <input type="number" id="sipPerMonth" class="g-color--black" value="10000"
											min="1"  max="999999" oninput="changeSliderSipValue(this.value)" 
											onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
								<span id="sipPerMonth" class="g-color--black"></span>
								 </p>
								 
								<div class="col-md-6"></div>
							</div>
							<div class="row g-margin-t-50--xs g-margin-b-50--xs">
								<div id="investment-options" class="col-md-3 col-sm-3 col-3">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " >SIP Tenure(years)</p>
								</div>
								<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								  <input type="range" min="<s:property value="#session.minPurchaseAmount"/>" max="150000" step="500" class="slider" id="myRange">
								</div>
								
								<div class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								  Rs.<span id="sipDuration" name="totalInvestment1"></span>
								</div>
								<div class="col-md-9  col-sm-9 col-9">
									
									<div id="sip-duration-range" >
									  	<div class="row">
										  	<form class="col-md-5" onClick="enableTextBox();">
											  	<label class="radio-inline g-margin-l-50--md">
												  	<input type="radio" id="d1" name="sipDuration" value="untilStopped" checked="checked" >until Stopped&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											  	</label>
											  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											  	<label class="radio-inline ">
												  <input type="radio" id="d2" name="sipDuration" value="custom" > Custom
												</label>
										  	</form>
										  	<div class="col-md-3">
										    	 <input type="number" id="sip-duration-in-years" class="g-margin-l-o-100--sm g-color--black" value="99"
												min="1"  max="99999" name="sipDurationText" 
												onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
												<input class="g-margin-t-o-10--md" disabled autofocus type="number" id="sip-duration-in-years" name="sipDurationText" min="0" max="99999" step="1" value="99" 
										    			onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
								    			&nbsp;&nbsp;years
										    </div>
										</div>
									</div>
								</div>
								
										<div id="duration-value"  class="col-md-3  g-margin-t-10--xs col-xs-6 g-margin-l-20--xs">
								<input id="sip-duration-range" type="range" min="<s:property value="#session.minSipDuration"/>" max="50" step="1"
												 value="<s:property value="#session.minSipDuration"/>" onchange="showDuration(this.value)"/>
								</div>
								<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Yr. <span id="sip-duration" class="g-color--black"></span></p>
								<!-- <div class="col-md-4  "></div> -->
							</div>
							<div class="row g-margin-t-50--xs g-margin-b-50--xs">
								<div id="investment-options" class="col-md-3 col-xs-12">
									<p class="title g-margin-l-100--md g-margin-l-20--xs  " >SIP debit date</p>
								</div>
								<div id="duration-value"  class="col-md-3   col-xs-6 g-margin-l-20--xs">
									 
									  <div id="sip-date row">
									  	<form>
										  	<label class="radio-inline g-margin-l-30--xs col-md-2">
											  	<input type="radio" id="s1" name="sipDate" value="1" checked="checked" > 1<sup>st</sup>
										  	</label>
										  	<label class="radio-inline col-md-2">
											  <input type="radio" id="s2" name="sipDate" value="5"> 5<sup>th</sup>
											</label>
										  	<label class="radio-inline col-md-2">
											  <input type="radio" id="s3" name="sipDate" value="10"> 10<sup>th</sup>
											</label>
										  	<label class="radio-inline col-md-2">
											  <input type="radio" id="s4" name="sipDate" value="20"> 20<sup>th</sup>
											</label>
									  	</form>
										</div>

									  <select class="form-control" id="sip-date" name="sipDate" >
								        <option value="1">1</option>
								        <option value="5" selected>5</option>
								        <option value="10">10</option>
								        <option value="15">15</option>
								        <option value="20">20</option>
					      			</select>
								</div>
								<div class="col-md-4"></div>
							</div>
							<div class="row g-margin-t-50--xs g-margin-b-50--xs">
						<!-- <div class="col-md-1"></div>
						<div id="investment-options" class="col-md-4 "> -->
										<%
										
										System.out.println("FolioNumList is : "+pageContext.getAttribute("folios"));
								    	String arr1= (String) pageContext.getAttribute("folios"); 
								    	System.out.println("arr1 : "+arr1);
								    	
								    	if ( arr1 == null)  {
								    		arr1 = "New";
								    	}
								    		String[] a = arr1.split(":");
								    	
								    		System.out.println("a length : "+a.length);
								    	
								    		
										if (a.length != 1)  {
							    		 %>
								    	 <div class="col-md-3 col-xs-3">
											<p class="title g-margin-l-100--md g-margin-l-20--xs  " >Investment Folio</p>
										</div>
										<div  class="col-md-9 col-xs-9">
										<select class="g-margin-l-40--md g-margin-l-15--xs" id="selectSipFolioNum" name="selectSipFolioNum" style="width:150px;" > 
										    
										    <% 
										    
										    if (a.length != 0)
										    {
										    	for(int i=0;i<a.length;i++){ 
										        String fol= (String)a[i]; %> 
										        <option value="<%=fol%>" > <%=fol%> 
										        </option>
										    <%}}%> 
										</select>
										</div>
										<%
										}
								    	 
										%>
										<!-- </div> -->
										<div class="col-md-7"></div>
						</div>
							<div class="row ">
								<%
								System.out.println("kycStaus in session in jsp: "+session.getAttribute("kycStatus"));
						    	System.out.println("custDetUploaded in session in jsp : "+session.getAttribute("custDetUploaded"));
						    	System.out.println("addCustDetUploaded in session in jsp : "+session.getAttribute("addCustDetUploaded"));
								if ("NC".equals(session.getAttribute("kycStatus"))) {
								%>
									<input type="hidden" id="redirectingPage" value="panCardVerifiction" />
								<%
								} else if ("DONE".equals(session.getAttribute("kycStatus"))) {
									if ("Y".equals(session.getAttribute("custDetUploaded")))  {
										System.out.println("bankDetails page ");
								%>
										<input type="hidden" id="redirectingPage" value="bankDetails" />
								<%
									}
									else {
										System.out.println("customerDetails page ");
								%>
										<input type="hidden" id="redirectingPage" value="customerDetails" />
								<%
									}
								} else  {
									if ("Y".equals(session.getAttribute("custDetUploaded")))  {
										if("Y".equals(session.getAttribute("addCustDetUploaded"))) {
											System.out.println("DownloadKycForm page ");
								%>
											<input type="hidden" id="redirectingPage" value="downloadKycForm" />
								<%
										}
										else {
											System.out.println("addCustomerDetails page ");
								%>
											<input type="hidden" id="redirectingPage" value="addCustomerDetails" />
								<%		
										}
									}
									else {
										System.out.println("customerDetails page ");
								%>
										<input type="hidden" id="redirectingPage" value="customerDetails" />
								<%
									}
									
								}
								%>
							</div>
	  						
					</div>
	       		</div>
    </div>
    	
    
  </div>	
  		</div>
  		<div class="col-md-1 col-xs-1" ></div>
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
		
		
		
		
		<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
		<%-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> --%>
		<%-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> --%>
		<!------ Include the above in your HEAD tag ---------->
		
		<%-- <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"  media="screen">
		<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script> --%>
		
		
<%--     		<script>
				var slider = document.getElementById("myRange");
				var output = document.getElementById("upfrontInvestment");
				var output1 = document.getElementById("tot-investment-id-value");
				output.innerHTML = slider.value;
				output1.innerHTML = slider.value;
				
				slider.oninput = function() {
				  output.innerHTML = this.value;
				  output1.innerHTML = this.value;
				  
				}
			</script> --%>
</body>
</html>