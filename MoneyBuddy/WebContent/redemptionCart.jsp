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
    
    function redOptionChng(el)  {
    	
    	var theTbl = document.getElementById("redCartData");
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
   			inputs[0].value = inputs[3].value;
   			inputs[1].value = inputs[4].value;
   		}
   		else {

   			inputs[0].value = "0";
   			inputs[1].value = "0";
   			selects[1].disabled = false;
   		}
    }
    
    function redTypeChng(el)  {
    	var theTbl = document.getElementById("redCartData")
    	var r = theTbl.rows[el.parentNode.parentNode.rowIndex];
    	var selects = r.getElementsByTagName("select");
		var inputs = r.getElementsByTagName("input");
			
   		if (selects[1].value == "Select"){ 
   			inputs[0].disabled = true;
   			inputs[1].disabled = true;	
   		}
   		else if (selects[1].value == "Amount"){  
   			inputs[1].value = "0";
   			inputs[0].disabled = false;
   			inputs[1].disabled = true;	
   		}
   		else {
   			inputs[0].value = "0";
   			inputs[0].disabled = true;
   			inputs[1].disabled = false;
   		}
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
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
		</a>
	</div>
	
	
	<s:set var="fundDetails" value="#session.selectedFundDetailsDataModel" />
	
	<div class="row ">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10   " >
	    	<div class="profile">
	    		 <h3 class="g-font-size-32--xs g-font-size-24--md g-font-family--playfair g-letter-spacing--1  text-center font-weight-bold g-hor-divider__solid--white  "><b>Redemption Cart</b></h3>
	       	</div>
	     </div>
	     <div class="col-md-1 col-xs-1"></div>
	</div>
		
	<div class="row g-margin-t-40--xs g-margin-b-20--xs">
		<div class="col-md-1 col-xs-1"></div>
		<div class="col-md-10 col-xs-10   " >

					<s:form  action="editRedemptionCartAction" method="post" name="formEditRedemptionCart">
				  		<s:hidden id="return-type" name="returnType"></s:hidden>
				  	<table id="redCartData" width="100%;" >
						
						<thead class="table-head g-font-size-14--xs g-bg-color--gray-light" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<tr class="g-bg-color--gray-light">
								<th class="text-center col-md-3 g-bg-color--gray-light" height="70">Fund Name</th>
								<th class="text-center col-md-1 g-bg-color--gray-light">Folio No.</th>
								<th class="text-center col-md-1 g-bg-color--gray-light">Redemption Option</th>
								<th class="text-center col-md-1 g-bg-color--gray-light">Redemption Type</th>
								<th class="text-center col-md-1 g-bg-color--gray-light">Amount</th>
								<th class="text-center col-md-1 g-bg-color--gray-light">Units</th>
								<th class="text-center col-md-1 g-bg-color--gray-light hidden"></th>
								<th class="text-center col-md-1 g-bg-color--gray-light hidden"></th>
								<th class="text-center col-md-1 g-bg-color--gray-light hidden"></th>
								<th class="text-center col-md-1 g-bg-color--gray-light hidden"></th>
								<th class="text-center col-md-1 g-bg-color--gray-light hidden"></th>
								<th class="text-center col-md-1 g-bg-color--gray-light hidden"></th>
								<th class="text-center col-md-1 g-bg-color--gray-light"></th>
								
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<s:iterator value="#session.customerRedemptionCartList" var="redCartListElement" >
								<tr class="table-body g-font-size-14--xs " style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
								    <s:if test="productName.equals('Total')">
								    	<td class="text-center col-md-3 g-bg-color--gray-light" height="40">Total Amount</td>
								    	<td class="text-center col-md-1 g-bg-color--gray-light"></td>
										<td class="text-center col-md-1 g-bg-color--gray-light "></td>
										<td class="text-center col-md-1 g-bg-color--gray-light "></td>
										<td class="text-center col-md-1 g-bg-color--gray-light "><s:property value="#redCartListElement.redAmount"/></td>
										<td class="text-center col-md-1 g-bg-color--gray-light "></td>
										<td class="text-center col-md-1 g-bg-color--gray-light hidden"></td>
										<td class="text-center col-md-1 g-bg-color--gray-light hidden"></td>
										<td class="text-center col-md-1 g-bg-color--gray-light hidden"></td>
										<td class="text-center col-md-1 g-bg-color--gray-light hidden"></td>
										<td class="text-center col-md-1 g-bg-color--gray-light hidden"></td>
										<td class="text-center col-md-1 g-bg-color--gray-light hidden"></td>
										<td class="text-center col-md-1 g-bg-color--gray-light "></td>
								    </s:if>
									<s:else>
										<s:set var="selectedRedCartId" value="#redCartListElement.redCartId" />
								    	<s:set var="selRedOption" value="#redCartListElement.redemptionOption" />
								    	<s:set var="selRedType" value="#redCartListElement.redemptionType" />
								    	<td class="text-center" height="70" class="text-center g-font-size-14--xs"><s:property value="#redCartListElement.productName"/></td>
								    	<td class="text-center" height="70" class="text-center g-font-size-14--xs"><s:property value="#redCartListElement.folioNumber"/></td>
								    	<td class="text-center  ">
											<select name="redOptionArr" class="" id="red-option"  style="width:70px;" onchange="redOptionChng(this);" > 
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
										<td class="text-center  ">
											<select name="redTypeArr" id="red-type"  style="width:70px;" disabled onchange="redTypeChng(this);" > 
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
												
										</td>
								    	<td class="text-center ">
									 		<p class="title " >
									 			<input name="amountArr" type="number" id="amt" class="g-color--black "
													value=<s:property value="#redCartListElement.redAmount"/> style="width:80px;" disabled>
											</p>	
										</td>
										<td class="text-center ">
									 		<p class="title " >
									 			<input name="unitsArr" type="number" id="unit" class="g-color--black "
														value=<s:property value="#redCartListElement.redUnits"/> style="width:80px;" disabled>
											</p>	
										</td>
										<td class="text-center  hidden">
											 <input class="hidden" name="minRedAmountArr"  value=<s:property value="#redCartListElement.minRedAmount"/> />
										</td>
										<td class="text-center  hidden">
											 <input class="hidden" name="totalAmountArr"  value=<s:property value="#redCartListElement.totalAmount"/> />
										</td>
										<td class="text-center  hidden">
											 <input class="hidden" name="totalUnitsArr"  value=<s:property value="#redCartListElement.totalUnits"/> />
										</td>
										<td class="text-center  hidden">
											 <input class="hidden" name="redCartIdArr"  value=<s:property value="#redCartListElement.redCartId"/> />
										</td>
										<td class="text-center hidden ">
											 <input class="hidden" name="productIdArr"  value=<s:property value="#redCartListElement.productId"/> />
										</td>
										<td class="text-center hidden ">
											 <input class="hidden" name="folioNumArr"  value=<s:property value="#redCartListElement.folioNumber"/> />
										</td>
										<td class="text-center  ">
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
					
					<s:form  action="deleteCartEntryAction" method="post" name="formDeleteCart">
				  		<s:hidden id="cart-id-value" name="cartId"></s:hidden>
	  				</s:form>
	     </div>
	     
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	    	
			
			<div class="row g-margin-b-50--xs">
  				<div class="col-md-1"></div>
  				<div class="col-md-6 text-left">
  					<a href="javascript:editRedemptionCart('Dashboard');" class=" buttonBlock g-color--white "  >+ Add another fund</a>
  				</div>
  				<div class="col-md-3"></div>
				<div class="col-md-1 text-left">
					<%-- <s:form action="redirectAction" method="post"> --%>
		      			<s:if test="#session.customerCartList.size() == 1 ">
		      				<button type="button"  class="btn buttonBlock g-color--white disabled"  >Next</button>
		      			</s:if>
		      			<s:else>
		      				<a href="javascript:editRedemptionCart('OrderInvoice');" class=" buttonBlock g-color--white "  >Next</a>
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
   			
   		}

		
		</script>
		

</body>
</html>