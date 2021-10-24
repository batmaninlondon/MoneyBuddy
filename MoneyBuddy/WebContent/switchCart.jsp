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
        
        <!-- <link href="css/material-bootstrap-wizard.css" rel="stylesheet" />
 -->
        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
        <!-- <link href="css/material-kit.css" rel="stylesheet"/> -->

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

	    /*custom font*/
@import url(http://fonts.googleapis.com/css?family=Montserrat);
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Raleway:400,500,700);
.snip1419 {
  font-family: 'Raleway', Arial, sans-serif;
  position: relative;
  float: left;
  overflow: hidden;
  margin: 10px 1%;
  text-align: left;
  color: #000000;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.9);
  font-size: 16px;
  -webkit-transform: translateZ(0);
  transform: translateZ(0);
  -webkit-perspective: 20em;
  perspective: 20em;
}
.snip1419 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.3s ease-out;
  transition: all 0.3s ease-out;
}

.snip1419 figcaption {
  padding: 20px;
}
.snip1419 h3,
.snip1419 p {
  margin: 0;
}
.snip1419 h3 {
  font-size: 1em;
  font-weight: 700;
  margin-bottom: 10px;
  text-transform: uppercase;
}
.snip1419 p {
  font-size: 0.7em;
  letter-spacing: 1px;
  font-weight: 400;
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
    
    function switchOptionChng(el)  {
    	
    	var theTbl = el.parentNode.parentNode.parentNode.parentNode;
    	var sumAmountVal = 0.0;
    	var r1 = theTbl.rows[0];
    	var selects0 = r1.getElementsByTagName("select");
    	var r2 = theTbl.rows[1];
		var selects1 = r2.getElementsByTagName("select");
		var inputs = r2.getElementsByTagName("input");
		var r3 = theTbl.rows[2];
		var inputs1 = r3.getElementsByTagName("input");

   		if (selects0[1].value == "Select"){  
   			selects1[0].value = "Select";
   			inputs[0].value = "0";
   			inputs[1].value = "0";
			selects1[0].hidden = true;
   			inputs[0].parentNode.hidden = true;
   			inputs[1].parentNode.hidden = true;	
   			var tr = inputs[0].parentNode.parentNode;
			var td = tr.getElementsByTagName("td")[0];
			td.hidden = false;
   		}
   		else if (selects0[1].value == "Full"){  
   			selects1[0].value = "Select";
			selects1[0].hidden = true;
   			inputs[0].parentNode.hidden = true;
   			inputs[1].parentNode.hidden = true;	
   			inputs[0].value = inputs1[1].value;
   			inputs[1].value = inputs1[2].value;
   			inputs[2].value = inputs[0].value;
   			inputs[3].value = inputs[1].value;
   			var tr = inputs[0].parentNode.parentNode;
			var td = tr.getElementsByTagName("td")[0];
			td.hidden = false;
   		}
   		else {

   			inputs[0].value = "";
   			inputs[1].value = "";
   			inputs[0].placeholder = "Enter Amount";
   			inputs[1].placeholder = "Enter Units";
   			selects1[0].hidden = false;
   			var tr = inputs[0].parentNode.parentNode;
			var td = tr.getElementsByTagName("td")[0];
			td.hidden = true;
   		}
   		
		var tables = document.getElementsByTagName('table');
    	
		for (var i=0; i<tables.length; i++)  {
			var theTbl = tables[i];
			
			var r1 = theTbl.rows[1];
   			var inputs = r1.getElementsByTagName("input");
   			if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
					sumAmountVal = sumAmountVal + parseFloat(inputs[0].value);
					
    		}
		}
   			
   		sumAmountVal = Math.round(sumAmountVal * 10000.0) / 10000.0;
	        
    }
    
   function switchTypeChng(el)  {
    	
    	var theTbl = el.parentNode.parentNode.parentNode.parentNode;
    	var sumAmountVal = 0.0;
    	var r1 = theTbl.rows[0];
    	var selects0 = r1.getElementsByTagName("select");
    	var r2 = theTbl.rows[1];
		var selects1 = r2.getElementsByTagName("select");
		var inputs = r2.getElementsByTagName("input");

   		if (selects1[0].value == "Select"){ 
   			inputs[0].value = "";
   			inputs[1].value = "";
   			inputs[0].placeholder = "Enter Amount";
   			inputs[1].placeholder = "Enter Units";
   			inputs[0].parentNode.hidden = true;
   			inputs[1].parentNode.hidden = true;
   			var tr = inputs[0].parentNode.parentNode;
			var td = tr.getElementsByTagName("td")[0];
			td.hidden = true;
   		}
   		else if (selects1[0].value == "Amount"){  
   			inputs[1].value = "";
   			inputs[1].placeholder = "Enter Units";
   			inputs[0].parentNode.hidden = false;
   			inputs[1].parentNode.hidden = true;	
   			var tr = inputs[0].parentNode.parentNode;
			var td = tr.getElementsByTagName("td")[0];
			td.hidden = true;
   		}
   		else {
   			inputs[0].value = "";
   			inputs[0].placeholder = "Enter Amount";
   			inputs[0].parentNode.hidden = true;
   			inputs[1].parentNode.hidden = false;
   			var tr = inputs[0].parentNode.parentNode;
			var td = tr.getElementsByTagName("td")[0];
			td.hidden = true;
   		}
   		
		var tables = document.getElementsByTagName('table');
    	
		for (var i=0; i<tables.length; i++)  {
			var theTbl = tables[i];
			
			var r1 = theTbl.rows[1];
   			var inputs = r1.getElementsByTagName("input");
   			if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
					sumAmountVal = sumAmountVal + parseFloat(inputs[0].value);
					
    		}
		}
   			
   		sumAmountVal = Math.round(sumAmountVal * 10000.0) / 10000.0;
	        
    }
    
    
   function checkAmountVal(minVal,maxVal, el)   {

	   
		var amount = $(el).val();
		amount = Math.round(amount * 10000.0) / 10000.0;
		$(el).val(amount);
		
		var theTbl = el.parentNode.parentNode.parentNode.parentNode;
		var sumAmountVal = 0.0;
       var r1 = theTbl.rows[0];
   		var selects0 = r1.getElementsByTagName("select");
   		var r2 = theTbl.rows[1];
		var selects1 = r2.getElementsByTagName("select");
		var inputs = r2.getElementsByTagName("input");
		
       var r3 = theTbl.rows[2];
		var inputs1 = r3.getElementsByTagName("input");
		inputs[2].value = amount;
       var unit = amount / inputs1[3].value;
       
       /* alert (' nav is : '+inputs1[3].value);
       alert(' unit is : '+unit); */
       
       if ( maxVal < minVal)   {
    	   if ( amount != maxVal)   {
    		   alert(' amount value for this fund shall be full amount : '+maxVal);
    		   $(el).val(maxVal);
	    	   inputs[2].value = maxVal;
	    	  unit = maxVal / inputs1[3].value;
    	   }
       }
       else {
       		if (amount < minVal){
	    	    alert('min amount value for this fund is : '+minVal);
	    	    $(el).val(minVal);
	    	   inputs[2].value = minVal;
	    	  unit = minVal / inputs1[3].value;
	    	  }
	   	 else if (amount > maxVal){
	   		alert('max amount value for this fund is : '+maxVal);
	     	    $(el).val(maxVal);
	     	  	inputs[2].value = maxVal;
	     		unit = maxVal / inputs1[3].value;
	     	  }
       }
       unit = Math.round(unit * 10000.0) / 10000.0;
       /* alert(' now unit is : '+unit); */
       
       /* alert (' inputs[3].value : before : '+inputs[3].value); */
       inputs[1].value = unit;
       inputs[3].value = unit;
       
       /* alert (' inputs[3].value : after : '+inputs[3].value); */
              
       
		var tables = document.getElementsByTagName('table');
   	
		for (var i=0; i<tables.length; i++)  {
			var theTbl = tables[i];
			
			var r1 = theTbl.rows[1];
  			var inputs = r1.getElementsByTagName("input");
  			if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
					sumAmountVal = sumAmountVal + parseFloat(inputs[0].value);
					
   		}
		}
  			
  		sumAmountVal = Math.round(sumAmountVal * 10000.0) / 10000.0;
       
   	
   }
    
   function checkUnitVal(minAmtVal,maxVal, el)   {
	   
   	var unit = $(el).val();
   	
   	
   	unit = Math.round(unit * 10000.0) / 10000.0;
		$(el).val(unit);
		
   	var theTbl = el.parentNode.parentNode.parentNode.parentNode;
   	var sumAmountVal = 0.0;
		
       var r1 = theTbl.rows[0];
   	var selects = r1.getElementsByTagName("select");
   	var r2 = theTbl.rows[1];
		var inputs = r2.getElementsByTagName("input");
		
       var r3 = theTbl.rows[2];
		var inputs1 = r3.getElementsByTagName("input");
		
		var minVal = minAmtVal / inputs1[3].value;
		minVal = Math.round(minVal * 10000.0) / 10000.0;
		
		inputs[3].value = unit;
       var amount = unit * inputs1[3].value;
       inputs[2].value = amount;
       
       if ( maxVal < minVal)   {
    	   if ( amount != maxVal)   {
    		   alert(' Unit value for this fund shall be full units : '+maxVal);
    		   $(el).val(maxVal);
	    	   inputs[3].value = maxVal;
	    	   amount = maxVal * inputs1[3].value;
    	   }
       }
       else {
       if ($(el).val() < minVal){
    	    alert('min Unit value for this fund is : '+minVal);
    	    $(el).val(minVal);
    	   inputs[3].value = minVal;
    	  amount = minVal * inputs1[3].value;
    	   
    	  }
   	 else if ($(el).val() > maxVal){
   		alert('max Unit value for this fund is : '+maxVal);
     	    $(el).val(maxVal);
     	  inputs[3].value = maxVal;
     	amount = maxVal * inputs1[3].value;
     	  }
       }
       
       amount = Math.round(amount * 10000.0) / 10000.0;
       
       inputs[0].value = amount;
       inputs[2].value = amount;
       
      /*  for(var i = 1; i < theTbl.rows.length-1; i++)
       {
       	r = theTbl.rows[i];
  			inputs = r.getElementsByTagName("input");
  				if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
  					sumAmountVal = sumAmountVal + parseFloat(inputs[0].value);
  					
       		}
		}
       sumAmountVal = Math.round(sumAmountVal * 10000.0) / 10000.0;
       theTbl.rows[theTbl.rows.length-1].cells[4].innerHTML = sumAmountVal; */
  	
  }
    
   function checkAmountAndUnits()  {
   	
		var tables = document.getElementsByTagName('table');
   	
		for (var i=0; i<tables.length; i++)  {
			var theTbl = tables[i];
			
			var r = theTbl.rows[0];
			var selects0 = r.getElementsByTagName("select");
			var r1 = theTbl.rows[1];
			var selects1 = r1.getElementsByTagName("select");
  			var inputs = r1.getElementsByTagName("input");
  			
  			if (selects0[1].value == "Select"){  
	   			
  	        	alert('Please select Full or Partial in Switch Option  \n at Row'+(i+1));
  	        	return false;
  			
			}
			else if (selects0[1].value == "Partial" && selects1[0].value == "Select"){  
  			
  	        	alert('Please select Amount or Units in Switch Type  \n at Row '+(i+1));
  	        	return false;
  			
			}
			else if (selects1[0].value == "Amount"){  
	   			if (inputs[0].value == ""|| inputs[0].value ==  null || inputs[0].value == "0")  {
	   	        	alert('value of amount can not be blank or zero \n at Row '+(i+1));
	   	        	return false;
	   			}
			}
			else if (selects1[0].value == "Units"){  
	   			if (inputs[1].value == ""|| inputs[1].value ==  null || inputs[1].value == "0")  {
	   	        	alert('value of units can not be blank or zero \n at Row '+(i+1));
	   	        	return false;
	   			}
			}
  		}

   		editSwitchCart('orderConfirmation');

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
	    		 <h3 class="g-font-size-20--xs g-font-size-24--lg g-font-family--playfair g-letter-spacing--1  text-center font-weight-bold g-hor-divider__solid--white  ">
	    		 	<b><u>Switch Cart</u></b>
    		 	</h3>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
		
	<div class="row g-margin-t-10--xs g-margin-b-0--xs g-margin-b-20--lg g-margin-l-5--xs g-margin-l-0--lg g-margin-r-10--xs g-margin-r-0--lg">
		<div class="col-lg-1 col-xs-0"></div>
		<div class="col-lg-10 col-xs-12 table-responsive" >

					<s:form  action="editSwitchCartAction" method="post" name="formEditSwitchCart">
				  		<s:hidden id="return-type" name="returnType"></s:hidden>
				  		
				  	<s:iterator value="#session.customerSwitchCartList" var="switchCartListElement" >
						<s:if test="withdrawalSchemeName.equals('Total')">
						</s:if>
						<s:else>
						<div class="col-xs-12 col-lg-6   g-bg-color--white">
							<div  class="  g-line-height--normal  ">
								<s:set var="selectedSwitchCartId" value="#switchCartListElement.switchCartId" />
						    	<s:set var="selFolio" value="#switchCartListElement.folioNumber" />
						    	<s:set var="selName" value="#switchCartListElement.purchaseFundSchemeName" />
						    	<s:set var="fundNames" value="#switchCartListElement.purchaseSchemeNameList" />
						    	<s:set var="selSwitchOption" value="#switchCartListElement.switchOption" />
					    		<s:set var="selSwitchType" value="#switchCartListElement.switchType" />
							
								<figure class="snip1419 g-height-130--xs g-height-150--lg  " style="width:100%" >
									
				  					<!-- <figcaption > -->
				    					<article class=" panel panel-info panel-heading  g-height-60--xs " >
				    						<p class="g-color--black g-line-height--sm  g-font-size-12--xs g-font-size-16--lg " style="font-weight: bold; ">
				    						<s:property value="#switchCartListElement.withdrawalSchemeName"/>
				    						&nbsp;&nbsp;&nbsp;&nbsp;
											
				    						</p>
				    						
											 <p class="g-color--black g-line-height--lg  g-font-size-10--xs g-font-size-12--lg " >
											 	<s:property value="#switchCartListElement.folioNumber"/>
											 	<div class="g-margin-t-o-20--xs" style="text-align:right">
										       		<a  href="javascript:deleteSwitchCartEntry(<s:property value="selectedSwitchCartId" />);"  >
										 				<span class="g-font-size-20--lg g-font-size-15--xs fa fa-trash-o g-color--primary "></span>
									 				</a>
											 	</div>
										 	</p>
										 	
				    						
				    					</article>
				    					<article > 
									        <table id="cartData"  class="table-borderless g-margin-t-o-20--xs"  width="100%" style="border-collapse: separate;border-spacing: .5em;">
     										    <tbody>
										            <tr class="g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg " >
										                <td>
																<%
																 	
																	System.out.println("purchaseSchemeNameList is : "+pageContext.getAttribute("fundNames"));
															    	String arr1= (String) pageContext.getAttribute("fundNames"); 
															    	String selName= (String) pageContext.getAttribute("selName"); 
															    	System.out.println("arr1 : "+arr1);
															    	
														    	
														    		String[] a = arr1.split(":");
														    	
														    		System.out.println("a length : "+a.length);
															    	
														    		 %>
																	<select name="purchaseFundNameArr" class="text-center g-font-size-10--xs g-font-size-14--lg g-width-150--xs g-width-150--lg" id="selectFundName" > 
																	    
																	    <% 
																	    
																	    if (a.length != 0)
																	    {
																	    	for(int i=0;i<a.length;i++){ 
																	        String fundName= (String)a[i]; 
																	        if (fundName.equals(selName))   {%> 
																	        <option value="<%=fundName%>" selected="selected" > <%=fundName%> 
																	        </option>
																	        <%}
																	        else {
																	        %>
																	        <option value="<%=fundName%>" > <%=fundName%> 
																	        </option>
																	        <%}}}%> 
																	</select>
																	
															</td>
															<td class="text-left ">
															<select name="switchOptionArr" class="g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg" 
																id="switch-option" onchange="switchOptionChng(this);" > 
														        <% 
														        	String selSwitchOption= (String) pageContext.getAttribute("selSwitchOption");
														        	String[] switchOptions = {"Select","Full","Partial"};
														        	for (int i=0;i<switchOptions.length;i++)  {
														        		String optn= (String)switchOptions[i]; 
														        			if (optn.equals(selSwitchOption))
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
								                		
														</tr>
														<tr 
														class=" g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" 
														style="padding-top: 25px">
														<td class="text-left">
														 Current Amount : <s:property value="#switchCartListElement.totalWithdrawalAmount"/> and
														 Units : <s:property value="#switchCartListElement.totalWithdrawalUnit"/>
														</td>
														<td class="text-left">
															<select name="switchTypeArr" class="g-font-size-10--xs g-font-size-14--lg g-width-60-xs g-width-90--lg" hidden 
																onchange="switchTypeChng(this);" > 
														        <% 
														        	String selSwitchType= (String) pageContext.getAttribute("selSwitchType");
														        	String[] switchTypes = {"Select","Amount","Units"};
														        	for (int i=0;i<switchTypes.length;i++)  {
														        		String typ= (String)switchTypes[i]; 
														        		
														        			if (typ.equals(selSwitchType))
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
																
														</td>
														<td hidden class="text-left">
													 			Amount : 
													 			<s:if test="switchAmount == 0 ">
														 			<input  type="number" id="amt" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-90--xs g-width-110--lg"
																		onblur="checkAmountVal(<s:property value="#switchCartListElement.minSwitchAmount"/>,<s:property value="#switchCartListElement.totalWithdrawalAmount"/>,this);"
																		placeholder="Enter Amount" step=".01">
																</s:if>
																<s:else>
																	<input  type="number" id="amt" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-90--xs g-width-110--lg"
																		value=<s:property value="#switchCartListElement.switchAmount"/> 
																		onblur="checkAmountVal(<s:property value="#switchCartListElement.minSwitchAmount"/>,<s:property value="#switchCartListElement.totalWithdrawalAmount"/>,this);"
																		step=".01">
																</s:else>	
														</td>
														<td hidden class="text-left">
													 		Units : 
													 			<s:if test="switchUnit == 0 ">
														 			<input  type="number" id="unit" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-90--xs g-width-110--lg"
														 				onblur="checkUnitVal(<s:property value="#switchCartListElement.minSwitchAmount"/>,<s:property value="#switchCartListElement.totalWithdrawalUnit"/>,this);"
																		placeholder="Enter Units"  step=".01">
																</s:if>
																<s:else>
																	<input  type="number" id="unit" class="g-color--black g-font-size-10--xs g-font-size-14--lg g-width-90--xs g-width-110--lg"
													 					onblur="checkUnitVal(<s:property value="#switchCartListElement.minSwitchAmount"/>,<s:property value="#switchCartListElement.totalWithdrawalUnit"/>,this);"
																		value=<s:property value="#switchCartListElement.switchUnit"/> 
																		 step=".01" >
																</s:else>
																<input name="switchAmtArr" type="number" id="amt" class="hidden"
																		value=<s:property value="#switchCartListElement.switchAmount"/> >
																<input name="switchUnitsArr" type="number" id="unit_to_send" class="hidden "
																		value=<s:property value="#switchCartListElement.switchUnit"/> >
														</td>
														</tr>
														
														<tr>
														<td class="hidden">
															 <input class="hidden" name="minSwitchAmountArr"  value=<s:property value="#switchCartListElement.minSwitchAmount"/> />
														</td>
														<td class="hidden">
															 <input class="hidden" name="totalAmountArr"  value=<s:property value="#switchCartListElement.totalWithdrawalAmount"/> />
														</td>
														<td class="hidden">
															 <input class="hidden" name="totalUnitsArr"  value=<s:property value="#switchCartListElement.totalWithdrawalUnit"/> />
														</td>
														<td class="hidden ">
															 <input class="hidden" name="latestNavArr"  value=<s:property value="#switchCartListElement.latestNav"/> />
														</td>
														<td class="hidden">
															 <input class="hidden" name="switchCartIdArr"  value=<s:property value="#switchCartListElement.switchCartId"/> />
														</td>
														<td class="hidden ">
															 <input class="hidden" name="fundIdArr"  value=<s:property value="#switchCartListElement.fundId"/> />
														</td>
														<td class="hidden ">
															 <input class="hidden" name="folioNumArr"  value=<s:property value="#switchCartListElement.folioNumber"/> />
														</td>
													
										            </tr>
										        </tbody>
										    </table>
									       	</article>
									       	
				  				 
								</figure>
								
							</div>
						</div>
						</s:else>
			</s:iterator> 
			
			
					</s:form>
					
					<s:form  action="deleteSwitchCartEntryAction" method="post" name="formDeleteSwitchCart">
				  		<s:hidden id="switch-cart-id-value" name="switchCartId"></s:hidden>
	  				</s:form>
	     </div>
	     
	     <div class="col-lg-1 col-xs-0" ></div>
	</div>
	    	
			
			<div class="row g-margin-b-50--xs">
  				<div class="col-md-1 col-xs-1"></div>
  				<div class="col-md-6 col-xs-6  text-left">
  					<a href="javascript:editSwitchCart('Dashboard');" class=" btn btn-home g-color--white g-font-size-14--xs g-font-size-18--lg"  >+ Add another fund</a>
  				</div>
  				<div class="col-md-3 col-xs-1"></div>
				<div class="col-md-1 col-xs-4  text-left">
					<%-- <s:form action="redirectAction" method="post"> --%>
		      			<s:if test="#session.customerSwitchCartList.size() == 1 ">
		      				<button type="button"  class="btn btn-home g-color--white disabled g-font-size-14--xs g-font-size-18--lg"  >Next</button>
		      			</s:if>
		      			<s:else>
		      				<a href="javascript:checkAmountAndUnits();" class=" btn btn-home g-color--white g-font-size-14--xs g-font-size-18--lg"  >Next</a>
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
			
		var tables = document.getElementsByTagName('table');
		
		for (var i=0; i<tables.length; i++)  {
			
			var theTbl = tables[i];
	    	var r1 = theTbl.rows[0];
	    	var selects0 = r1.getElementsByTagName("select");
	    	var r2 = theTbl.rows[1];
	    	var selects1 = r2.getElementsByTagName("select");
			var inputs = r2.getElementsByTagName("input");
			
   			if (selects0[1].value == "Partial")  {
   				if ( selects1[0].value == "Amount" ) {
   					var tr = inputs[0].parentNode.parentNode;
   					var td = tr.getElementsByTagName("td")[0];
   					td.hidden = true;
   					inputs[0].parentNode.hidden = false;
   				}
   				
   				else if ( selects1[0].value == "Units" )  {
					var tr = inputs[0].parentNode.parentNode;
   					var td = tr.getElementsByTagName("td")[0];
   					td.hidden = true;
   					inputs[1].parentNode.hidden = false;
					}
   				
   				selects1[0].hidden = false;
   			}
   			
   			
		}
   		

   		
   		
		</script>
		

</body>
</html>