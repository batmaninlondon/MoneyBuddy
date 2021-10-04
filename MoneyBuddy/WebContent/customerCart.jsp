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
        
        <%-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		<!------ Include the above in your HEAD tag ---------->
		
		<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"  media="screen">
		<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script> --%>
        
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
    
    function checkUpfrontVal(minVal,maxVal,multiplier, el)   {
    	
        if ($(el).val() < minVal){
     	    alert('min value for this fund is : '+minVal);
     	    $(el).val(minVal);
     	  }
    	 else if ($(el).val() > maxVal){
    		alert('max value for this fund is : '+(maxVal - (maxVal%multiplier)));
      	    $(el).val(maxVal - (maxVal%multiplier));
      	  }
    	 else {
    		 
    		 var remainder = ($(el).val()) % multiplier;
    		 
    		 if (remainder != 0 )  {
    			 alert (' Value has to be in the multiplier of '+multiplier+', hence changing the value to the possible multipler value ')
    			 $(el).val(($(el).val())-remainder);
    		 }
     		 
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
   			alert('min value for this fund is : '+minVal);
    	    $(el).val(minVal);
    	  }
   	 	else if ($(el).val() > maxVal){
   			alert('max value for this fund is : '+maxVal);
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
    	
    	var tables = document.getElementsByTagName('table');
    	
		for (var i=0; i<tables.length; i++)  {
			var theTbl = tables[i];
			
   			var r = theTbl.rows[0];
   			var inputs = r.getElementsByTagName("input");
   			
   			if (inputs[0].value == ""|| inputs[0].value ==  null)  {
   	        	alert('value of amount can not be blank \n at Row '+(i+1));
   	        	return false;
   			}
   		}

/* 
var table = tables[tables.length - 1];
        
   		var theTbl = document.getElementById('cartData');
   		
   		alert("theTbl.rows.length : "+theTbl.rows.length);
   		for (var i=1; i<theTbl.rows.length-1; i++)  {
   			
   			var r = theTbl.rows[i];
   			var inputs = r.getElementsByTagName("input");
   			alert("inputs[0].value : "+inputs[0].value);
   			if (inputs[0].value == ""|| inputs[0].value ==  null)  {
   	        	alert('value of amount can not be blank \n at Row '+i);
   	        	return false;
   			}
   		} */

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
	    		 	<b><u>Investment Cart</u></b>
    		 	</h3>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
		
	<div class="row g-margin-t-10--xs g-margin-b-0--xs g-margin-b-20--lg g-margin-l-5--xs g-margin-l-0--lg g-margin-r-10--xs g-margin-r-0--lg">
		<div class="col-lg-1 col-xs-0"></div>
		<div class="col-lg-10 col-xs-12 table-responsive " >

					<s:form  action="editCartAction" method="post" name="formEditCart">
				  		<s:hidden id="return-type" name="returnType"></s:hidden>
				  		<s:set var="anyUpfront" value="anyUpfrontOrder" />
				  		<s:set var="anySip" value="anySipOrder" />
				  	
				  		
				  		
				  		
				  		
				  		<s:iterator value="#session.customerCartList" var="customerCartListElement" >
						<s:if test="schemeName.equals('Total')">
						</s:if>
						<s:else>
						<div class="col-xs-12 col-lg-6   g-bg-color--white">
							<div  class="  g-line-height--normal  ">
							<s:set var="selectedFundId" value="#sipDataModelElement.fundId" />
								<s:set var="selectedCartId" value="#customerCartListElement.cartId" />
						    	<s:set var="folios" value="#customerCartListElement.folioNumList" />
						    	<s:set var="selFolio" value="#customerCartListElement.folioNumber" />
							
								<figure class="snip1419 g-height-130--xs g-height-150--lg  " style="width:100%"   >
									
				  					<!-- <figcaption > -->
				    					<article class=" panel panel-info panel-heading  g-height-60--xs " >
				    						<p class="g-color--black g-line-height--sm  g-font-size-12--xs g-font-size-16--lg " style="font-weight: bold; ">
				    						<s:property value="#customerCartListElement.schemeName"/>
				    						&nbsp;&nbsp;&nbsp;&nbsp;
											
				    						</p>
				    						
											 <p class="g-color--black g-line-height--lg  g-font-size-10--xs g-font-size-12--lg " >
											 	<s:property value="#customerCartListElement.transactionType"/>
											 	<div class="g-margin-t-o-20--xs" style="text-align:right">
										       		<a  href="javascript:deleteCartEntry(<s:property value="selectedCartId" />);"  >
										 				<span class="g-font-size-20--lg g-font-size-15--xs fa fa-trash-o g-color--primary "></span>
									 				</a>
											 	</div>
										 	</p>
										 	
				    						
				    					</article>
				    					<article class="g-margin-l-20--md " > 
									        <table id="cartData"  class="table-borderless g-margin-t-o-10--xs"  width="100%" style="border-collapse: separate;border-spacing: .5em;">
										       <%--  <thead>
										            <tr class="g-bg-color--white g-font-family--playfair text-center " >
										                <th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Folio Num</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Amount</span></th>
														<s:if test="transactionType.equals('SIP')">
															<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Tenure</span></th>
															<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Debit Date</span></th>
														</s:if>
														<s:else>
															<th class="col-xs-0 text-center hidden "></th>
															<th class="col-xs-0 text-center hidden "></th>
														</s:else>
														<th class="col-xs-0 text-center hidden "></th>
														<th class="col-xs-0 text-center hidden"></th>
														<th class="col-xs-0 text-center hidden"></th>
										            </tr>
										        </thead> --%>
										         <tbody>
										            <tr class="g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" >
										                <td class="text-center " ><span class=" ">
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
															<select name="folioNumArr" class="text-center g-width-90--xs g-width-100--lg" id="selectFolioNum"  > 
															    
															    <% 
															    
															    if (a.length != 0)
															    {
															    	for(int i=0;i<a.length;i++){ 
															        String fol= (String)a[i]; 
															        if (fol.equals(selFol))   {%> 
															        <option value="<%=fol%>" selected="selected" >Folio: <%=fol%> 
															        </option>
															        <%}
															        else {
															        %>
															        <option value="<%=fol%>" > Folio: <%=fol%> 
															        </option>
															        <%}}}%> 
															</select>
									                		</span>
								                		</td>
								                		<s:if test="transactionType.equals('UPFRONT')">
														<td class="text-center" ><span >
															<s:if test="upfrontAmount == 0 ">
																Amount: <input name="upfrontAmtArr" type="number" id="upfrontInvestment" class="g-font-size-10--xs g-font-size-14--lg g-color--black g-width-60--xs g-width-90--lg "
																	placeholder="Amount"
																	onblur="checkUpfrontVal(<s:property value="#customerCartListElement.minUpfrontAmount"/>,999999,<s:property value="#customerCartListElement.upfrontMultiplier"/>,this);"
																	onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
															</s:if>
															<s:else>
																Amount: <input name="upfrontAmtArr" type="number" id="upfrontInvestment" class="g-font-size-10--xs g-font-size-14--lg g-color--black g-width-60--xs g-width-90--lg"
																	value=<s:property value="#customerCartListElement.upfrontAmount"/>
																	onblur="checkUpfrontVal(<s:property value="#customerCartListElement.minUpfrontAmount"/>,999999,<s:property value="#customerCartListElement.upfrontMultiplier"/>,this);"
																	onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
															</s:else>
															<select name="sipAmtArr" class="hidden g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg" id="sipInvestment"   > 
														        <option value=""  >0</option>
															</select>		
														</span>
														</td>
														
														</s:if>
														<s:else>
														<td class="text-center" ><span >
															<s:if test="sipAmount == 0 ">
																Amount: <input name="sipAmtArr" type="number" id="sipInvestment" class="g-font-size-10--xs g-font-size-14--lg g-color--black g-width-60--xs g-width-90--lg" 
																	placeholder="Amount"
																	onblur="checkSipVal(<s:property value="#customerCartListElement.minSipAmount"/>,999999,this);"
																	onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
															</s:if>
															<s:else>
																Amount: <input name="sipAmtArr" type="number" id="sipInvestment" class="g-font-size-10--xs g-font-size-14--lg g-color--black g-width-60--xs g-width-90--lg" value=<s:property value="#customerCartListElement.sipAmount"/>
																	onblur="checkSipVal(<s:property value="#customerCartListElement.minSipAmount"/>,999999,this);"
																	onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" >
															</s:else>
															<select name="upfrontAmtArr" class="hidden g-font-size-10--xs g-font-size-14--lg g-width-60--xs g-width-90--lg" id="upfrontInvestment" > 
											        			<option value=""  >0</option>
															</select>
															
															</span>
														</td>
														</s:else>
														</tr>
														<tr 
														class=" g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" 
														style="padding-top: 25px">
														<s:if test="transactionType.equals('SIP')">
														<s:set var="selSipTenure" value="#customerCartListElement.sipDuration" />
														<s:set var="selSipDate" value="#customerCartListElement.sipDate" />
														<td>
														<select name="sipDateArr" class="g-width-90--xs g-width-100--lg" id="sip-date" > 
													        <% 
													        	String selSipDate= (String) pageContext.getAttribute("selSipDate");
													        	String[] sipDates = {"1","5","10","15","20","25"};
													        	for (int i=0;i<sipDates.length;i++)  {
													        		String dat= (String)sipDates[i]; 
													        		if ("1".equals(dat))  {
													        			if (dat.equals(selSipDate))
														        		{
									        				%>
													        				<option value="<%=dat%>" selected="selected">Date: <%=dat%><sup>st</sup></option>
									        				<%
														        		}
													        			else {
									        				%>
													        				<option value="<%=dat%>" >Date: <%=dat%><sup>st</sup></option>
									        				<%
													        			}
													        		}
													        		else {
														        		if (dat.equals(selSipDate))
														        		{
													        %>
														     		 		<option value="<%=dat%>" selected="selected">Date: <%=dat%><sup>th</sup></option>
											     		 	<%
														        		} else {
										        			%>
														        			<option value="<%=dat%>" >Date: <%=dat%><sup>th</sup></option>
										        			<%
														        			
														        		}
													        		}
													     		 }
												     		 %>
														</select>
														</td>
														<td>
															<select name="sipTenureArr" class="g-width-110--xs g-width-120--lg" id="sip-tenure" > 
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
														     		 		<option value="<%=tenureVal%>" selected="selected">Tenure: <%=tenure%></option>
												     		 	<%
														        		} else {
											        			%>
														        			<option value="<%=tenureVal%>" >Tenure: <%=tenure%></option>
											        			<%
														        			
														        		}
														     		 }
													     		 %>
															</select>
														</td>
														
														
														</s:if>
														<s:else>
															<td class="hidden ">
																<select name="sipTenureArr" class="hidden g-width-60--xs g-width-90--lg" id="sip-tenure" > 
															        <option value="" >0</option>
																</select>																	
															</td>
															<td class="hidden ">
																<select name="sipDateArr" class="hidden g-width-60--xs g-width-90--lg" id="sip-date" > 
															        <option value=""  >0</option>
																</select>
															</td>
														</s:else>
														</tr>
														<tr>
														<td class="hidden">
															 <input class="hidden" name="cartIdArr"  value=<s:property value="#customerCartListElement.cartId"/> />
														</td>
														<td class="hidden ">
															 <input class="hidden" name="fundIdArr"  value=<s:property value="#customerCartListElement.fundId"/> />
														</td>
														<td class="hidden ">
															<select name="tranTypeArr" class="hidden g-width-60--xs g-width-90--lg" id="tran-type" > 
														        <option value=""  >0</option>
															</select>
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
					
					<s:form  action="deleteCartEntryAction" method="post" name="formDeleteCart">
				  		<s:hidden id="cart-id-value" name="cartId"></s:hidden>
	  				</s:form>
	     </div>
	     
	     <div class="col-lg-1 col-xs-0" ></div>
	</div>
	    	
			
			<div class="row g-margin-b-50--xs">
  				<div class="col-md-1 col-xs-1"></div>
  				<div class="col-md-6 col-xs-6 text-left">
  					<a href="javascript:editCart('FundExplorer');" class=" btn btn-home g-color--white g-font-size-14--xs g-font-size-18--lg"  >+ Add another fund</a>
  				</div>
  				<div class="col-md-3 col-xs-1"></div>
				<div class="col-md-1 col-xs-4 text-left">
					<%-- <s:form action="redirectAction" method="post"> --%>
		      			<s:if test="#session.customerCartList.size() == 1 ">
		      				<button type="button"  class="btn btn-home g-color--white disabled g-font-size-14--xs g-font-size-18--lg"  >Next</button>
		      			</s:if>
		      			<s:else>
		      				<a href="javascript:checkAmounts();" class=" btn btn-home g-color--white g-font-size-14--xs g-font-size-18--lg"  >Next</a>
		      				<%-- <s:submit class="buttonBlock g-color--white text-left " value="Next" /> --%>
		      			</s:else>
		      		<%-- </s:form> --%>
	      		</div>
	      		<div class="col-md-1 col-xs-0"></div>
	      		
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