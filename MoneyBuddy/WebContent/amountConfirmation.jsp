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
    
    function checkUpfrontVal(minVal,maxVal, el)   {
    	
    	
        
        
        if ($(el).val() < minVal){
     	    alert('min value for the fund is : '+minVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
     	    $(el).val(minVal);
     	  }
    	 else if ($(el).val() > maxVal){
    		alert('max value for the fund is : '+maxVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
      	    $(el).val(maxVal);
      	  }
		
        var theTbl = document.getElementById("cartData"), sumUpfrontVal = 0;
        
        for(var i = 1; i < theTbl.rows.length-1; i++)
        {
        	var r = theTbl.rows[i];
   			var inputs = r.getElementsByTagName("input");
   			if (r.cells[1].innerHTML == "UPFRONT")  
   				if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
   					sumUpfrontVal = sumUpfrontVal + parseInt(inputs[0].value);
   					
        		}
		}
        theTbl.rows[theTbl.rows.length-1].cells[3].innerHTML = sumUpfrontVal;
        
    	
    }
    
    function checkSipVal(minVal,maxVal, el)   {
    	
		
        
   	 	if ($(el).val() < minVal){
   			alert('min value for the fund is : '+minVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
    	    $(el).val(minVal);
    	  }
   	 	else if ($(el).val() > maxVal){
   			alert('max value for the fund is : '+maxVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
     	    $(el).val(maxVal);
     	  }
   	 	
   	 var theTbl = document.getElementById("cartData"), sumSipVal = 0;
     
     for(var i = 1; i < theTbl.rows.length-1; i++)
     {
     	var r = theTbl.rows[i];
			var inputs = r.getElementsByTagName("input");
			if (r.cells[1].innerHTML == "SIP")  
				if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
					sumSipVal = sumSipVal + parseInt(inputs[0].value);
     		}
		}
     
   	 	theTbl.rows[theTbl.rows.length-1].cells[4].innerHTML = sumSipVal;
   	
   }
    
    function checkAmounts()  {
    	
    	
   		var theTbl = document.getElementById('cartData');
   		
   		for (var i=1; i<theTbl.rows.length-1; i++)  {
   			
   			var r = theTbl.rows[i];
   			var inputs = r.getElementsByTagName("input");
   			
   			if (inputs[0].value == ""|| inputs[0].value ==  null)  {
   	        	alert('value of amount can not be blank \n at Row '+i);
   	        	return false;
   			}
   		}

   		editCart('Redirect');

    
    }
    </script>
    
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
	
	<div class="row ">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10   " >
	    	<div class="profile">
	    		 <h3 class="g-font-size-32--xs g-font-size-24--md g-font-family--playfair g-letter-spacing--1  text-center font-weight-bold g-hor-divider__solid--white  "><b>Investment Cart</b></h3>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
		
	<div class="row g-margin-t-40--xs g-margin-b-20--xs">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10   " >

					<s:form  action="editCartAction" method="post" name="formEditCart">
				  		<s:hidden id="return-type" name="returnType"></s:hidden>
				  		<s:set var="anyUpfront" value="anyUpfrontOrder" />
				  		<s:set var="anySip" value="anySipOrder" />
				  	<table id="cartData" width="100%;" >
						
						<thead class="table-head g-font-size-14--xs g-bg-color--gray-light" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<tr class="g-bg-color--gray-light">
								<th class="text-center col-md-3 g-bg-color--gray-light" height="70">Fund Name</th>
								<th class="text-center col-md-1 g-bg-color--gray-light" height="70">Txn Type</th>
								<th class="text-center col-md-1 g-bg-color--gray-light">Folio No.</th>
								<s:if test="'TRUE'.equals(#anyUpfront) ">
									<th class="text-center col-md-2 g-bg-color--gray-light">Lumpsum Amount<br/>(Rs.)</th>
								</s:if>
								<s:else>
									<th class="text-center col-md-2 g-bg-color--gray-light hidden">Lumpsum Amount<br/>(Rs.)</th>
								</s:else>
								<s:if test="'TRUE'.equals(#anySip) ">
									<th class="text-center col-md-2 g-bg-color--gray-light">SIP Amount<br/>(Rs/month)</th>
									<th class="text-center col-md-1 g-bg-color--gray-light">SIP Tenure<br/>(in years)</th>
									<th class="text-center col-md-1 g-bg-color--gray-light">SIP Debit Date</th>
								</s:if>
								<s:else>
									<th class="text-center col-md-2 g-bg-color--gray-light hidden">SIP Amount<br/>(Rs/month)</th>
									<th class="text-center col-md-1 g-bg-color--gray-light hidden">SIP Tenure<br/>(in years)</th>
									<th class="text-center col-md-1 g-bg-color--gray-light hidden">SIP Debit Date</th>
								</s:else>
								<th class="text-center col-md-0 g-bg-color--gray-light hidden "></th>
								<th class="text-center col-md-0 g-bg-color--gray-light hidden"></th>
								<th class="text-center col-md-1 g-bg-color--gray-light"></th>
								
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<s:iterator value="#session.customerCartList" var="customerCartListElement" >
								<tr class="table-body g-font-size-14--xs " style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
								    <s:if test="productName.equals('Total')">
								    	<th class="text-center col-md-3 g-bg-color--gray-light" height="40">Total</th>
								    	<th class="text-center col-md-1 g-bg-color--gray-light"></th>
										<th class="text-center col-md-1 g-bg-color--gray-light "></th>
										<s:if test="'TRUE'.equals(#anyUpfront) ">
											<th class="text-center col-md-2 g-bg-color--gray-light "><b><span class="title " >&#8377; &ensp; </span><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.upfrontAmount]})}"/></b></th>
										</s:if>
										<s:else>
											<th class="text-center col-md-0 g-bg-color--gray-light hidden"></th>
										</s:else>
										<s:if test="'TRUE'.equals(#anySip) ">
											<th class="text-center col-md-2 g-bg-color--gray-light "><b><span class="title " >&#8377; &ensp; </span><s:property value="%{getText('{0,number,#,##0}',{#attr[#customerCartListElement.sipAmount]})}"/></b></th>
											<th class="text-center col-md-1 g-bg-color--gray-light "></th>
											<th class="text-center col-md-1 g-bg-color--gray-light"></th>
										</s:if>
										<s:else>
											<th class="text-center col-md-1 g-bg-color--gray-light hidden"></th>
											<th class="text-center col-md-1 g-bg-color--gray-light hidden"></th>
											<th class="text-center col-md-1 g-bg-color--gray-light hidden"></th>
										</s:else>
										<th class="text-center col-md-0 g-bg-color--gray-light hidden"></th>
										<th class="text-center col-md-0 g-bg-color--gray-light hidden"></th>
										<th class="text-center col-md-1 g-bg-color--gray-light"></th>
								    </s:if>
									<s:else>
								    	<s:set var="selectedCartId" value="#customerCartListElement.cartId" />
								    	<s:set var="folios" value="#customerCartListElement.folioNumList" />
								    	<s:set var="selFolio" value="#customerCartListElement.folioNumber" />
								    	<td class="text-left" height="70" class="text-center g-font-size-14--xs"><s:property value="#customerCartListElement.productName"/></td>
								    	<td class="text-center" height="70" class="text-center g-font-size-14--xs"><s:property value="#customerCartListElement.transactionType"/></td>
								    	<td class="text-center  ">
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
												<select name="folioNumArr" class="text-center" id="selectFolioNum" style="width:100px;" > 
												    
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
								    	
										<s:if test="transactionType.equals('UPFRONT')">
										
										<td class="text-center ">
									 		<p class="title " >
												<s:if test="upfrontAmount == 0 ">
													<input name="upfrontAmtArr" type="number" id="upfrontInvestment" class="g-color--black "
														placeholder="Amount"
														onblur="checkUpfrontVal(<s:property value="#customerCartListElement.minUpfrontAmount"/>,999999,this);"
														onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
												</s:if>
												<s:else>
													<input name="upfrontAmtArr" type="number" id="upfrontInvestment" class="g-color--black "
														value=<s:property value="#customerCartListElement.upfrontAmount"/>
														onblur="checkUpfrontVal(<s:property value="#customerCartListElement.minUpfrontAmount"/>,999999,this);"
														onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
												</s:else>
												
											</p>	
										</td>
										<s:if test="'TRUE'.equals(#anySip) ">
										<td class="text-center ">
											<select name="sipAmtArr" class="hidden" id="sipInvestment"  style="width:60px;" > 
										        <option value=""  >0</option>
											</select>
											<p class="title  text-center" >
												<b>NA</b>
											</p>
										</td>
										<td class="text-center  ">
											<select name="sipTenureArr" class="hidden" id="sip-tenure" style="width:60px;" > 
										        <option value="" >0</option>
											</select>
											<p class="title  text-center" >
												<b>NA</b>
											</p>
												
										</td>
										<td class="text-center  ">
											<select name="sipDateArr" class="hidden" id="sip-date"  style="width:60px;" > 
										        <option value=""  >0</option>
											</select>
											<p class="title  text-center" >
												<b>NA</b>
											</p>
										</td>
										</s:if>
										<s:else>
										<td class="text-center hidden ">
											<select name="sipAmtArr" class="hidden" id="sipInvestment"  style="width:60px;" > 
										        <option value=""  >0</option>
											</select>
											<p class="title  text-center" >
												<b>NA</b>
											</p>
										</td>
										<td class="text-center hidden ">
											<select name="sipTenureArr" class="hidden" id="sip-tenure" style="width:60px;" > 
										        <option value="" >0</option>
											</select>
											<p class="title  text-center" >
												<b>NA</b>
											</p>
												
										</td>
										<td class="text-center hidden ">
											<select name="sipDateArr" class="hidden" id="sip-date"  style="width:60px;" > 
										        <option value=""  >0</option>
											</select>
											<p class="title  text-center" >
												<b>NA</b>
											</p>
										</td>
										
										</s:else>
										</s:if>
										<s:else>
										<s:if test="'TRUE'.equals(#anyUpfront) ">
											<td class="text-center  ">
											<select name="upfrontAmtArr" class="hidden" id="upfrontInvestment"  style="width:60px;" > 
											        <option value=""  >0</option>
												</select>
										 		<p class="title  text-center" >
													<b>NA</b>
												</p>	
											</td>
										</s:if>
										<s:else>
											<td class="text-center  hidden">
											<select name="upfrontAmtArr" class="hidden" id="upfrontInvestment"  style="width:60px;" > 
											        <option value=""  >0</option>
												</select>
										 		<p class="title  text-center" >
													<b>NA</b>
												</p>	
											</td>
										</s:else>
										<td class="text-center  ">
											<p class="title  " >
												<s:if test="sipAmount == 0 ">
													<input name="sipAmtArr" type="number" id="sipInvestment" class="g-color--black " placeholder="Amount"
														onblur="checkSipVal(<s:property value="#customerCartListElement.minSipAmount"/>,999999,this);"
														onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
												</s:if>
												<s:else>
													<input name="sipAmtArr" type="number" id="sipInvestment" class="g-color--black " value=<s:property value="#customerCartListElement.sipAmount"/>
														onblur="checkSipVal(<s:property value="#customerCartListElement.minSipAmount"/>,999999,this);"
														onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
												</s:else>
											</p>
										</td>
										<s:set var="selSipTenure" value="#customerCartListElement.sipDuration" />
										<s:set var="selSipDate" value="#customerCartListElement.sipDate" />
										<td class="text-center  ">
											<select name="sipTenureArr" class="" id="sip-tenure" style="width:100px;" > 
										        <% 
										        	String selSipTen= (String) pageContext.getAttribute("selSipTenure");
										        	/* if ("99".equals(selSipTen)) {
										        		selSipTen = "Until Stopped";
										        	} */
										        	String[] sipTen = {"1 yr","2 yr","5 yr","10 yr","Until Stopped"};
										        	String[] sipTenVal = {"1","2","5","10","99"};
										        	for (int i=0;i<sipTen.length;i++)  {
										        		String tenure= (String)sipTen[i]; 
										        		String tenureVal = (String)sipTenVal[i];
										        		if (tenureVal.equals(selSipTen))
										        		{
										        %>
										     		 		<option value="<%=tenureVal%>" selected="selected"><%=tenure%></option>
								     		 	<%
										        		} else {
							        			%>
										        			<option value="<%=tenureVal%>" ><%=tenure%></option>
							        			<%
										        			
										        		}
										     		 }
									     		 %>
											</select>
												
										</td>
										<td class="text-center  ">
											<select name="sipDateArr" class="" id="sip-date"  style="width:70px;" > 
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
										<td class="text-center  hidden">
											 <input class="hidden" name="cartIdArr"  value=<s:property value="#customerCartListElement.cartId"/> />
										</td>
										<td class="text-center hidden ">
											 <input class="hidden" name="productIdArr"  value=<s:property value="#customerCartListElement.productId"/> />
										</td>
										<td class="text-center  ">
											 
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
  					<a href="javascript:editCart('FundExplorer');" class=" buttonBlock g-color--white "  >+ Add another fund</a>
  				</div>
  				<div class="col-md-3"></div>
				<div class="col-md-1 text-left">
					<%-- <s:form action="redirectAction" method="post"> --%>
		      			<s:if test="#session.customerCartList.size() == 1 ">
		      				<button type="button"  class="btn buttonBlock g-color--white disabled"  >Next</button>
		      			</s:if>
		      			<s:else>
		      				<a href="javascript:checkAmounts();" class=" buttonBlock g-color--white "  >Next</a>
		      				<%-- <s:submit class="buttonBlock g-color--white text-left " value="Next" /> --%>
		      			</s:else>
		      		<%-- </s:form> --%>
	      		</div>
	      		<div class="col-md-1"></div>
	      		
			</div>

  
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