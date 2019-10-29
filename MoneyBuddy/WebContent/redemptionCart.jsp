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
    
    function redOptionChng(el)  {
    	
    	var theTbl = document.getElementById("redCartData"), sumAmountVal = 0.0;
    	var rowNum = el.parentNode.parentNode.rowIndex;
    	var r = theTbl.rows[rowNum];
    	var selects = r.getElementsByTagName("select");
		var inputs = r.getElementsByTagName("input");

   		if (selects[0].value == "Select"){  
   			selects[1].value = "Select";
   			inputs[0].value = "0";
   			inputs[1].value = "0";
			selects[1].disabled = true;
   			inputs[0].disabled = true;
   			inputs[1].disabled = true;	
   		}
   		else if (selects[0].value == "Full"){  
   			selects[1].value = "Select";
			selects[1].disabled = true;
   			inputs[0].disabled = true;
   			inputs[1].disabled = true;	
   			inputs[0].value = inputs[5].value;
   			inputs[1].value = inputs[6].value;
   			inputs[2].value = inputs[0].value;
   			inputs[3].value = inputs[1].value;
   			
   		}
   		else {

   			inputs[0].value = "";
   			inputs[1].value = "";
   			inputs[0].placeholder = "Enter Amount";
   			inputs[1].placeholder = "Enter Units";
   			selects[1].disabled = false;
   		}
   		
   		for(var i = 1; i < theTbl.rows.length-1; i++)
	        {
	        	r = theTbl.rows[i];
	   			inputs = r.getElementsByTagName("input");
	   				if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
	   					sumAmountVal = sumAmountVal + parseFloat(inputs[0].value);
	   					
	        		}
			}
   		
   			sumAmountVal = Math.round(sumAmountVal * 10000.0) / 10000.0;
	        theTbl.rows[theTbl.rows.length-1].cells[4].innerHTML = sumAmountVal;
	        
    }
    
    function redTypeChng(el)  {
    	var theTbl = document.getElementById("redCartData")
    	var r = theTbl.rows[el.parentNode.parentNode.rowIndex];
    	var selects = r.getElementsByTagName("select");
		var inputs = r.getElementsByTagName("input");
		selects[2].value = selects[1].value;
		
   		if (selects[1].value == "Select"){ 
   			inputs[0].value = "";
   			inputs[1].value = "";
   			inputs[0].placeholder = "Enter Amount";
   			inputs[1].placeholder = "Enter Units";
   			inputs[0].disabled = true;
   			inputs[1].disabled = true;	
   		}
   		else if (selects[1].value == "Amount"){  
   			inputs[1].value = "";
   			inputs[1].placeholder = "Enter Units";
   			inputs[0].disabled = false;
   			inputs[1].disabled = true;	
   		}
   		else {
   			inputs[0].value = "";
   			inputs[0].placeholder = "Enter Amount";
   			inputs[0].disabled = true;
   			inputs[1].disabled = false;
   		}
   		
   		for(var i = 1; i < theTbl.rows.length-1; i++)
	        {
	        	r = theTbl.rows[i];
	   			inputs = r.getElementsByTagName("input");
	   				if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
	   					sumAmountVal = sumAmountVal + parseFloat(inputs[0].value);
	   					
	        		}
	   				
   				
			}
   		sumAmountVal = Math.round(sumAmountVal * 10000.0) / 10000.0;
        theTbl.rows[theTbl.rows.length-1].cells[4].innerHTML = sumAmountVal;
	        
    }
    
    
	function checkAmountVal(minVal,maxVal, el)   {

		var amount = $(el).val();
		amount = Math.round(amount * 10000.0) / 10000.0;
		$(el).val(amount);
		
		var theTbl = document.getElementById("redCartData"), sumAmountVal = 0.0;
        var r = theTbl.rows[el.parentNode.parentNode.parentNode.rowIndex];
        var inputs = r.getElementsByTagName("input");
        inputs[2].value = amount;
        var unit = amount / inputs[7].value;
        
        if (amount < minVal){
     	    alert('min value for the amount for this row is : '+minVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
     	    $(el).val(minVal);
     	   inputs[2].value = minVal;
     	  unit = minVal / inputs[7].value;
     	  }
    	 else if (amount > maxVal){
    		alert('max value for the amount for this row is : '+maxVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
      	    $(el).val(maxVal);
      	  inputs[2].value = maxVal;
      		unit = maxVal / inputs[7].value;
      	  }
		
        unit = Math.round(unit * 10000.0) / 10000.0;
        
        inputs[1].value = unit;
        inputs[3].value = unit;
               
        
        for(var i = 1; i < theTbl.rows.length-1; i++)
        {
        	r = theTbl.rows[i];
   			inputs = r.getElementsByTagName("input");
   				if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
   					sumAmountVal = sumAmountVal + parseFloat(inputs[0].value);
   					
        		}
		}
        sumAmountVal = Math.round(sumAmountVal * 10000.0) / 10000.0;
        theTbl.rows[theTbl.rows.length-1].cells[4].innerHTML = sumAmountVal;
        
    	
    }
    
    function checkUnitVal(minVal,maxVal, el)   {
    	
    	var unit = $(el).val();
    	unit = Math.round(unit * 10000.0) / 10000.0;
		$(el).val(unit);
    	
    	var theTbl = document.getElementById("redCartData"), sumAmountVal = 0.0;
        var r = theTbl.rows[el.parentNode.parentNode.parentNode.rowIndex];
        var inputs = r.getElementsByTagName("input");
        inputs[3].value = unit;
        var amount = unit * inputs[7].value;

        if ($(el).val() < minVal){
     	    alert('min value for the units for this row is : '+minVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
     	    $(el).val(minVal);
     	   inputs[3].value = minVal;
     	  amount = minVal * inputs[7].value;
     	   
     	  }
    	 else if ($(el).val() > maxVal){
    		alert('max value for the units for this row is : '+maxVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
      	    $(el).val(maxVal);
      	  inputs[3].value = maxVal;
      	amount = maxVal * inputs[7].value;
      	  }
        
        amount = Math.round(amount * 10000.0) / 10000.0;
        
        inputs[0].value = amount;
        inputs[2].value = amount;
        
        for(var i = 1; i < theTbl.rows.length-1; i++)
        {
        	r = theTbl.rows[i];
   			inputs = r.getElementsByTagName("input");
   				if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
   					sumAmountVal = sumAmountVal + parseFloat(inputs[0].value);
   					
        		}
		}
        sumAmountVal = Math.round(sumAmountVal * 10000.0) / 10000.0;
        theTbl.rows[theTbl.rows.length-1].cells[4].innerHTML = sumAmountVal;
   	
   }
    
    function checkAmountAndUnits()  {
    	
    	
   		var theTbl = document.getElementById('redCartData');
   		
   		for (var i=1; i<theTbl.rows.length-1; i++)  {
   			
   			var r = theTbl.rows[i];
   			var selects = r.getElementsByTagName("select");
   			var inputs = r.getElementsByTagName("input");
   			
   			if (selects[0].value == "Select"){  
	   			
	   	        	alert('Please select Full or Partial in Redemption Option  \n at Row'+i);
	   	        	return false;
	   			
   			}
   			else if (selects[0].value == "Partial" && selects[1].value == "Select"){  
	   			
	   	        	alert('Please select Amount or Units in Redemption Type  \n at Row '+i);
	   	        	return false;
	   			
   			}
   			else if (selects[1].value == "Amount"){  
	   			if (inputs[0].value == ""|| inputs[0].value ==  null)  {
	   	        	alert('value of amount can not be blank \n at Row '+i);
	   	        	return false;
	   			}
   			}
   			else if (selects[1].value == "Units"){  
	   			if (inputs[1].value == ""|| inputs[1].value ==  null)  {
	   	        	alert('value of units can not be blank \n at Row '+i);
	   	        	return false;
	   			}
   			}
   		}

   		editRedemptionCart('orderConfirmation');

    }
    
    </script>
    


    </head>

<body style="background: url(img/1920x1080/10111.jpg) 50% 0 no-repeat fixed;" >
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
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
		</a>
	</div>
	
	
	<s:set var="fundDetails" value="#session.selectedFundDetailsDataModel" />
	
	<div class="row ">
		<div class="col-xs-1"></div>
		<div class="col-xs-10   " >
	    	<div class="profile">
	    		 <h3 class="g-font-size-20--xs g-font-size-24--lg g-font-family--playfair g-letter-spacing--1  text-center font-weight-bold g-hor-divider__solid--white  "><b>Redemption Cart</b></h3>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
		
	<div class="row g-margin-t-40--xs g-margin-b-0--xs g-margin-b-20--lg g-margin-l-5--xs g-margin-l-0--lg g-margin-r-10--xs g-margin-r-0--lg">
		<div class="col-lg-1 col-xs-0"></div>
		<div class="col-lg-10 col-xs-12 table-responsive" >

					<s:form  action="editRedemptionCartAction" method="post" name="formEditRedemptionCart">
				  		<s:hidden id="return-type" name="returnType"></s:hidden>
				  		
				  	<table id="redCartData" class="g-width-100-percent--xs g-margin-l-5--xs g-margin-l-0--lg g-margin-r-5--xs g-margin-r-0--lg" >
						
						<thead class="table-head g-font-size-10--xs g-font-size-14--lg g-bg-color--gray-light text-center" height="70" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<tr>
								<th class="col-xs-3 text-center">Fund Name</th>
								<th class="col-xs-1 text-center">Folio No.</th>
								<th class="col-xs-1 text-center">Redemption Option</th>
								<th class="col-xs-1 text-center">Redemption Type</th>
								<th class="col-xs-1 text-center">Amount</th>
								<th class="col-xs-1 text-center">Units</th>
								<th class="col-xs-1 text-center hidden"></th>
								<th class="col-xs-1 text-center hidden"></th>
								<th class="col-xs-1 text-center hidden"></th>
								<th class="col-xs-1 text-center hidden"></th>
								<th class="col-xs-1 text-center hidden"></th>
								<th class="col-xs-1 text-center hidden"></th>
								<th class="col-xs-1 text-center"></th>
								
							</tr>
						</thead>
						<tbody class="table-body  g-font-size-10--xs g-font-size-14--lg  text-center" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<s:iterator value="#session.customerRedemptionCartList" var="redCartListElement" >
								<tr >
								    <s:if test="schemeName.equals('Total')">
								    	<td class="col-xs-3 g-bg-color--gray-light" height="40">Total Amount</td>
								    	<td class="col-xs-1 g-bg-color--gray-light"></td>
										<td class="col-xs-1 g-bg-color--gray-light"></td>
										<td class="col-xs-1 g-bg-color--gray-light"></td>
										<td class="col-xs-1 g-bg-color--gray-light"><s:property value="#redCartListElement.redAmount"/></td>
										<td class="col-xs-1 g-bg-color--gray-light"></td>
										<td class="col-xs-1 g-bg-color--gray-light hidden"></td>
										<td class="col-xs-1 g-bg-color--gray-light hidden"></td>
										<td class="col-xs-1 g-bg-color--gray-light hidden"></td>
										<td class="col-xs-1 g-bg-color--gray-light hidden"></td>
										<td class="col-xs-1 g-bg-color--gray-light hidden"></td>
										<td class="col-xs-1 g-bg-color--gray-light hidden"></td>
										<td class="col-xs-1 g-bg-color--gray-light"></td>
								    </s:if>
									<s:else>
										<s:set var="selectedRedCartId" value="#redCartListElement.redCartId" />
								    	<s:set var="selRedOption" value="#redCartListElement.redemptionOption" />
								    	<s:set var="selRedType" value="#redCartListElement.redemptionType" />
								    	<td class="text-left" height="70"><s:property value="#redCartListElement.schemeName"/></td>
								    	<td><s:property value="#redCartListElement.folioNumber"/></td>
								    	<td>
											<select name="redOptionArr" class="g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg" id="red-option" onchange="redOptionChng(this);" > 
										        <% 
										        	String selRedOption= (String) pageContext.getAttribute("selRedOption");
										        	String[] redOptions = {"Select","Full","Partial"};
										        	for (int i=0;i<redOptions.length;i++)  {
										        		String optn= (String)redOptions[i]; 
										        		
										        			if (optn.equals(selRedOption))
											        		{
						        				%>
										        				<option value="<%=optn%>" selected="selected"><%=optn%></option>
						        				<%
											        		}
										        			else {
						        				%>
										        				<option value="<%=optn%>" ><%=optn%></option>
						        				<%
										        			}
										        		
										     		 }
									     		 %>
											</select>
												
										</td>
										<td>
											<select class="g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg" disabled onchange="redTypeChng(this);" > 
										        <% 
										        	String selRedType= (String) pageContext.getAttribute("selRedType");
										        	String[] redTypes = {"Select","Amount","Units"};
										        	for (int i=0;i<redTypes.length;i++)  {
										        		String typ= (String)redTypes[i]; 
										        		
										        			if (typ.equals(selRedType))
											        		{
						        				%>
										        				<option value="<%=typ%>" selected="selected"><%=typ%></option>
						        				<%
											        		}
										        			else {
						        				%>
										        				<option value="<%=typ%>" ><%=typ%></option>
						        				<%
										        			}
										        		
										     		 }
									     		 %>
											</select>
											<select name="redTypeArr" class="hidden" id="red-type" > 
										        <option value="Select"  >Select</option>
										        <option value="Amount"  >Amount</option>
										        <option value="Units"  >Units</option>
											</select>
												
										</td>
								    	<td>
									 		<p class="title " >
									 			
									 			<s:if test="redAmount == 0 ">
										 			<input  type="number" id="amt" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg"
														onblur="checkAmountVal(<s:property value="#redCartListElement.minRedAmount"/>,<s:property value="#redCartListElement.totalAmount"/>,this);"
														placeholder="Enter Amount" disabled step=".01">
												</s:if>
												<s:else>
													<input  type="number" id="amt" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg"
														value=<s:property value="#redCartListElement.redAmount"/> 
														onblur="checkAmountVal(<s:property value="#redCartListElement.minRedAmount"/>,<s:property value="#redCartListElement.totalAmount"/>,this);"
														disabled step=".01">
												</s:else>
											</p>	
										</td>
										<td>
									 		<p class="title " >
									 			<s:if test="redUnits == 0 ">
										 			<input  type="number" id="unit" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg"
										 				onblur="checkUnitVal(0,<s:property value="#redCartListElement.totalUnits"/>,this);"
														placeholder="Enter Units" disabled>
												</s:if>
												<s:else>
													<input  type="number" id="unit" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg"
									 					onblur="checkUnitVal(0,<s:property value="#redCartListElement.totalUnits"/>,this);"
														value=<s:property value="#redCartListElement.redUnits"/> disabled>
												</s:else>
												<input name="amountArr" type="number" id="amt" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg hidden"
														value=<s:property value="#redCartListElement.redAmount"/> >
												<input name="unitsArr" type="number" id="unit_to_send" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg hidden "
														value=<s:property value="#redCartListElement.redUnits"/> >
											</p>	
										</td>
										<td class="hidden">
											 <input class="hidden" name="minRedAmountArr"  value=<s:property value="#redCartListElement.minRedAmount"/> />
										</td>
										<td class="hidden">
											 <input class="hidden" name="totalAmountArr"  value=<s:property value="#redCartListElement.totalAmount"/> />
										</td>
										<td class="hidden">
											 <input class="hidden" name="totalUnitsArr"  value=<s:property value="#redCartListElement.totalUnits"/> />
										</td>
										<td class="hidden ">
											 <input class="hidden" name="latestNavArr"  value=<s:property value="#redCartListElement.latestNav"/> />
										</td>
										<td class="hidden">
											 <input class="hidden" name="redCartIdArr"  value=<s:property value="#redCartListElement.redCartId"/> />
										</td>
										<td class="hidden ">
											 <input class="hidden" name="fundIdArr"  value=<s:property value="#redCartListElement.fundId"/> />
										</td>
										<td class="hidden ">
											 <input class="hidden" name="folioNumArr"  value=<s:property value="#redCartListElement.folioNumber"/> />
										</td>
										<td>
										 	<a  href="javascript:deleteRedCartEntry(<s:property value="selectedRedCartId" />);" >
										 		<span class="g-font-size-20--xs g-font-size-15--xs fa fa-trash-o g-color--primary text-right"></span>
									 		</a>
										</td>
										

								    </s:else>
								</tr>
							</s:iterator> 
							
						</tbody>
					</table>
					</s:form>
					
					<s:form  action="deleteRedCartEntryAction" method="post" name="formDeleteRedCart">
				  		<s:hidden id="red-cart-id-value" name="redCartId"></s:hidden>
	  				</s:form>
	     </div>
	     
	     <div class="col-lg-1 col-xs-0" ></div>
	</div>
	    	
			
			<div class="row g-margin-b-50--xs">
  				<div class="col-md-1 col-xs-1"></div>
  				<div class="col-md-6 col-xs-6  text-left">
  					<a href="javascript:editRedemptionCart('Dashboard');" class=" btn btn-home g-color--white "  >+ Add another fund</a>
  				</div>
  				<div class="col-md-3 col-xs-1"></div>
				<div class="col-md-1 col-xs-4  text-left">
					<%-- <s:form action="redirectAction" method="post"> --%>
		      			<s:if test="#session.customerRedemptionCartList.size() == 1 ">
		      				<button type="button"  class="btn btn-home g-color--white disabled"  >Next</button>
		      			</s:if>
		      			<s:else>
		      				<a href="javascript:checkAmountAndUnits();" class=" btn btn-home g-color--white "  >Next</a>
		      			</s:else>
		      		<%-- </s:form> --%>
	      		</div>
	      		<div class="col-md-1 col-xs-0"></div>
	      		
			</div>
			
			
			<div class="row g-margin-b-50--xs">
  				<div class="col-lg-1 col-xs-0"></div>
  				<div class="col-lg-10 col-xs-12 text-left">
  					<p class="g-font-size-12--xs g-font-size-14--lg" > Disclaimer: The amounts/units displayed are based on the last NAV declared. Actual values may vary.  </p>
  				</div>
	      		<div class="col-lg-1 col-xs-0"></div>
	      		
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
		
		<script>
			
		var theTbl = document.getElementById('redCartData');
   		
   		for (var i=1; i<theTbl.rows.length-1; i++)  {
   			
   			var r = theTbl.rows[i];
   			var selects = r.getElementsByTagName("select");
   			var inputs = r.getElementsByTagName("input");
   			   			
   			if (selects[0].value == "Partial")  {
   				if ( selects[1].value == "Amount" ) 
   					inputs[0].disabled = false;
   				else if ( selects[1].value == "Units" )
   					inputs[1].disabled = false;
   				
   				selects[1].disabled = false;
   			}
   			selects[2].value = selects[1].value;
   			
   		}

   		
   		
		</script>
		

</body>
</html>