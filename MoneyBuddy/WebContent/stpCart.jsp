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
        

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
       		
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

    function checkStpVal(minVal,maxVal, el)   {
    	
    	var amount = $(el).val();
		amount = Math.round(amount * 10000.0) / 10000.0;
		$(el).val(amount);
		var theTbl = document.getElementById("stpCartData"), sumStpVal = 0.0;
        var r = theTbl.rows[el.parentNode.parentNode.parentNode.rowIndex];
        var inputs = r.getElementsByTagName("input");
		inputs[1].value = amount;
		
		if ($(el).val() < minVal){
   			alert('min stp value for the fund is : '+minVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
    	    $(el).val(minVal);
    	    inputs[1].value = minVal;
    	  }
   	 	else if ($(el).val() > maxVal){
   			alert('max stp value for the fund is : '+maxVal+'\n at Row '+ el.parentNode.parentNode.parentNode.rowIndex);
     	    $(el).val(maxVal);
     	   inputs[1].value = maxVal;
     	  }
   	 	
     
	     for(var i = 1; i < theTbl.rows.length-1; i++)
	     {
	     	r = theTbl.rows[i];
			inputs = r.getElementsByTagName("input");
				
					if (!(inputs[0].value == ""|| inputs[0].value ==  null))  {
						sumStpVal = sumStpVal + parseFloat(inputs[0].value);
	     		
					}
	     
			sumStpVal = Math.round(sumStpVal * 10000.0) / 10000.0;
	   	 	theTbl.rows[theTbl.rows.length-1].cells[3].innerHTML = sumStpVal;
	   	
	   	}
    }
    
    function checkAmounts()  {
    	
   		var theTbl = document.getElementById('stpCartData');
   		
   		for (var i=1; i<theTbl.rows.length-1; i++)  {
   			
   			var r = theTbl.rows[i];
   			var inputs = r.getElementsByTagName("input");
   			
   			if (inputs[0].value == ""|| inputs[0].value ==  null)  {
   	        	alert('value of amount can not be blank \n at Row '+i);
   	        	return false;
   			}
   		}

   		editStpCart('orderConfirmation');

    
    }
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

<body style="background: url(img/1920x1080/10111.jpg) 50% 0 no-repeat fixed;" >
	
	<div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="Dublin Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="Dublin Logo">
		</a>
	</div>

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

					<s:form  action="editStpCartAction" method="post" name="formEditStpCart">
				  		<s:hidden id="return-type" name="returnType"></s:hidden>
				  	<table id="stpCartData" width="100%;" >
						
						<thead class="table-head g-font-size-14--xs g-bg-color--gray-light" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<tr class="g-bg-color--gray-light">
								<th class="text-center col-md-3 g-bg-color--gray-light" height="70">Fund Name A</th>
								<th class="text-center col-md-1 g-bg-color--gray-light">Folio No.</th>
								<th class="text-center col-md-3 g-bg-color--gray-light">Fund Name B</th>
								<th class="text-center col-md-1 g-bg-color--gray-light">STP Amount</th>
								<th class="text-center col-md-2 g-bg-color--gray-light">STP Tenure<br/>(in years)</th>
								<th class="text-center col-md-1 g-bg-color--gray-light">STP Debit Date</th>
								<th class="text-center col-md-0 g-bg-color--gray-light hidden "></th>
								<th class="text-center col-md-0 g-bg-color--gray-light hidden"></th>
								<th class="text-center col-md-0 g-bg-color--gray-light hidden"></th>
								<th class="text-center col-md-1 g-bg-color--gray-light"></th>
								
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs" style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
							<s:iterator value="#session.customerStpCartList" var="customerStpCartListElement" >
								<tr class="table-body g-font-size-14--xs " style=" border-bottom: solid 0.5px #dbdbdb;border-top: solid 0.5px gray;">
								    <s:if test="withdrawalSchemeName.equals('Total')">
								    	<td class="text-center col-md-3 g-bg-color--gray-light" height="40">Total</td>
								    	<td class="text-center col-md-1 g-bg-color--gray-light"></td>
										<td class="text-center col-md-3 g-bg-color--gray-light "></td>
										<td class="text-center col-md-1 g-bg-color--gray-light "><s:property value="#customerStpCartListElement.stpAmount"/></td>
										<td class="text-center col-md-2 g-bg-color--gray-light "></td>
										<td class="text-center col-md-1 g-bg-color--gray-light "></td>
										<td class="text-center col-md-0 g-bg-color--gray-light hidden"></td>
										<td class="text-center col-md-0 g-bg-color--gray-light hidden"></td>
										<td class="text-center col-md-0 g-bg-color--gray-light hidden"></td>
										<td class="text-center col-md-1 g-bg-color--gray-light"></td>
								    </s:if>
									<s:else>
								    	<s:set var="selectedStpCartId" value="#customerStpCartListElement.stpCartId" />
								    	<s:set var="selFolio" value="#customerStpCartListElement.folioNumber" />
								    	<s:set var="selName" value="#customerStpCartListElement.purchaseFundSchemeName" />
								    	<s:set var="fundNames" value="#customerStpCartListElement.purchaseSchemeNameList" />
								    	<td class="text-left" height="70" class="text-center g-font-size-14--xs" 	>
								    		<s:property value="#customerStpCartListElement.withdrawalSchemeName"/>
							    		</td>
								    	<td class="text-center" height="70" class="text-center g-font-size-14--xs"><s:property value="#customerStpCartListElement.folioNumber"/></td>
								    	<td class="text-center  ">
											<%
											 	
												System.out.println("purchaseSchemeNameList is : "+pageContext.getAttribute("fundNames"));
										    	String arr1= (String) pageContext.getAttribute("fundNames"); 
										    	String selName= (String) pageContext.getAttribute("selName"); 
										    	System.out.println("arr1 : "+arr1);
										    	
									    	
									    		String[] a = arr1.split(":");
									    	
									    		System.out.println("a length : "+a.length);
										    	
									    		 %>
												<select name="purchaseFundNameArr" class="text-center" id="selectFundName" style="width:200px;" > 
												    
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
								    	
								    	<td class="text-center ">
									 		<p class="title " >
												<s:if test="stpAmount == 0 ">
										 			<input type="number"  id="stp-amt" class="g-color--black "
														onblur="checkStpVal(<s:property value="#customerStpCartListElement.minStpAmount"/>,<s:property value="#customerStpCartListElement.totalWithdrawalAmount"/>,this);"
														placeholder="Enter Amount" style="width:110px;" step=".01">
												</s:if>
												<s:else>
													<input type="number"  id="stp-amt" class="g-color--black "
														value=<s:property value="#customerStpCartListElement.stpAmount"/> 
														onblur="checkStpVal(<s:property value="#customerStpCartListElement.minStpAmount"/>,<s:property value="#customerStpCartListElement.totalWithdrawalAmount"/>,this);"
														style="width:110px;" step=".01">
												</s:else>
												<input name="stpAmtArr" type="number" id="amt" class="g-color--black hidden"
														value=<s:property value="#customerStpCartListElement.stpAmount"/> >
											</p>	
										</td>
								    	
								    	
								    	<s:set var="selStpTenure" value="#customerStpCartListElement.stpDuration" />
										<s:set var="selStpDate" value="#customerStpCartListElement.stpDate" />
										<td class="text-center  ">
											<select name="stpTenureArr" class="" id="stp-tenure" style="width:110px;" > 
										        <% 
										        	String selStpTen= (String) pageContext.getAttribute("selStpTenure");
										        	/* if ("99".equals(selSipTen)) {
										        		selSipTen = "Until Stopped";
										        	} */
										        	String[] stpTen = {"1 yr","2 yr","5 yr","10 yr","Until Stopped"};
										        	String[] stpTenVal = {"1","2","5","10","99"};
										        	for (int i=0;i<stpTen.length;i++)  {
										        		String tenure= (String)stpTen[i]; 
										        		String tenureVal = (String)stpTenVal[i];
										        		if (tenureVal.equals(selStpTen))
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
											<select name="stpDateArr" class="" id="stp-date"  style="width:70px;" > 
										        <% 
										        	String selStpDate= (String) pageContext.getAttribute("selStpDate");
										        	String[] stpDates = {"1","5","10","20"};
										        	for (int i=0;i<stpDates.length;i++)  {
										        		String dat= (String)stpDates[i]; 
										        		if ("1".equals(dat))  {
										        			if (dat.equals(selStpDate))
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
											        		if (dat.equals(selStpDate))
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
										
										
										
										
										<td class="text-center  hidden">
											 <input class="hidden" name="stpCartIdArr"  value=<s:property value="#customerStpCartListElement.stpCartId"/> />
										</td>
										<td class="text-center hidden ">
											 <input class="hidden" name="withdrawalFundIdArr"  value=<s:property value="#customerStpCartListElement.withdrawalFundId"/> />
										</td>
										<td class="text-center hidden ">
											 <input class="hidden" name="folioNumArr"  value=<s:property value="#customerStpCartListElement.folioNumber"/> />
										</td>
										<td class="text-center  ">
											 	<a  href="javascript:deleteStpCartEntry(<s:property value="selectedStpCartId" />);" >
											 		<span class="g-font-size-20--xs g-font-size-15--xs fa fa-trash-o g-color--primary text-right"></span>
										 		</a>
										</td>
										

								    </s:else>
								</tr>
							</s:iterator> 
							
						</tbody>
					</table>
					</s:form>
					
					<s:form  action="deleteStpCartEntryAction" method="post" name="formDeleteStpCart">
				  		<s:hidden id="stp-cart-id-value" name="stpCartId"></s:hidden>
	  				</s:form>
	     </div>
	     
	     <div class="col-md-1 col-xs-1" ></div>
	</div>
	    	
			
			<div class="row g-margin-b-50--xs">
  				<div class="col-md-1"></div>
  				<div class="col-md-6 text-left">
  					<a href="javascript:editStpCart('Dashboard');" class=" buttonBlock g-color--white "  >+ Add another fund</a>
  				</div>
  				<div class="col-md-3"></div>
				<div class="col-md-1 text-left">
					<%-- <s:form action="redirectAction" method="post"> --%>
		      			<s:if test="#session.customerStpCartList.size() == 1 ">
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