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

    function checkStpVal(minVal,maxVal, el)   {
    	
    	var amount = $(el).val();
		amount = Math.round(amount * 10000.0) / 10000.0;
		$(el).val(amount);
		var theTbl = el.parentNode.parentNode.parentNode.parentNode;
        var r = theTbl.rows[1];
        var inputs = r.getElementsByTagName("input");
		inputs[1].value = amount; 
		
		if (amount < minVal){
   			alert('min stp value for this fund is : '+minVal);
    	    $(el).val(minVal);
    	    inputs[1].value = minVal;
    	  }
   	 	else if (amount > maxVal){
   			alert('max stp value for this fund is : '+maxVal);
     	    $(el).val(maxVal);
     	   inputs[1].value = maxVal;
     	  }
   	 	
    }
    
    function checkAmounts()  {
    	
		var tables = document.getElementsByTagName('table');
    	
		for (var i=0; i<tables.length; i++)  {
			var theTbl = tables[i];
			var r = theTbl.rows[1];
   			var inputs = r.getElementsByTagName("input");
   			
   			if (inputs[0].value == ""|| inputs[0].value ==  null)  {
   	        	alert('value of amount can not be blank \n at Row '+(i+1));
   	        	return false;
   			}
		}

   		editStpCart('orderConfirmation');

    
    }
    </script>
    
    

    </head>

<body style="background: url(img/1920x1080/10111.jpg) 50% 0 no-repeat fixed;" >
	
	<div class="container ">
   		<a href="welcome" class="s-header-v2__logo-link">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo.png" alt="MoneyBuddy Logo">
		   <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
		</a>
	</div>

	<div class="row ">
		<div class="col-xs-1"></div>
		<div class="col-xs-10   " >
	    	<div class="profile">
	    		 <h3 class="g-font-size-20--xs g-font-size-24--lg g-font-family--playfair g-letter-spacing--1  text-center font-weight-bold g-hor-divider__solid--white  ">
	    		 	<b><u>STP Cart</u></b>
    		 	</h3>
	       	</div>
	     </div>
	     <div class="col-xs-1"></div>
	</div>
		
	<div class="row g-margin-t-10--xs g-margin-b-0--xs g-margin-b-20--lg g-margin-l-5--xs g-margin-l-0--lg g-margin-r-10--xs g-margin-r-0--lg">
		<div class="col-lg-1 col-xs-0"></div>
		<div class="col-lg-10 col-xs-12 table-responsive " >

					<s:form  action="editStpCartAction" method="post" name="formEditStpCart">
				  		<s:hidden id="return-type" name="returnType"></s:hidden>
				  	
				  		<s:iterator value="#session.customerStpCartList" var="customerStpCartListElement" >
							<s:if test="withdrawalSchemeName.equals('Total')">
							</s:if>
							<s:else>
							
							<div class="col-xs-12 g-bg-color--white 
							<s:if test="#session.customerStpCartList.size() != 2 ">
								col-lg-6
							</s:if>
							">
								<div  class="  g-line-height--normal  ">
								<s:set var="selectedStpCartId" value="#customerStpCartListElement.stpCartId" />
						    	<s:set var="selFolio" value="#customerStpCartListElement.folioNumber" />
						    	<s:set var="selName" value="#customerStpCartListElement.purchaseFundSchemeName" />
						    	<s:set var="fundNames" value="#customerStpCartListElement.purchaseSchemeNameList" />
								
									<figure class="snip1419 g-height-150--xs g-height-150--lg  " style="width:100%"   >
										
					  					<!-- <figcaption > -->
					    					<article class=" panel panel-info panel-heading  g-height-60--xs " >
					    						<p class="g-color--black g-line-height--sm  g-font-size-12--xs g-font-size-16--lg " style="font-weight: bold; ">
					    						<s:property value="#customerStpCartListElement.withdrawalSchemeName"/>
					    						&nbsp;&nbsp;&nbsp;&nbsp;
												
					    						</p>
					    						
												 <p class="g-color--black g-line-height--lg  g-font-size-10--xs g-font-size-12--lg" >
												 	Folio Number: <s:property value="#customerStpCartListElement.folioNumber"/>
												 	<div class="g-margin-t-o-20--xs" style="text-align:right">
											       		<a  href="javascript:deleteStpCartEntry(<s:property value="selectedStpCartId" />);"  >
											 				<span class="g-font-size-20--lg g-font-size-15--xs fa fa-trash-o g-color--primary "></span>
										 				</a>
												 	</div>
											 	</p>
					    						
					    					</article>
					    					<article class="g-margin-l-20--md " > 
										        <table id="cartData"  class="g-margin-t-o-25--lg table-borderless g-margin-t-o-20--xs"  width="100%" style="border-collapse: separate;border-spacing: .5em;">
											         <tbody>
											            <tr class=" g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" >
											            	<td class="text-center"><b>Purchase Fund Name</b></td>
											            	<td class="text-center"><b>Amount</b></td>
											            </tr>
											            <tr class="g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" >
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
									                		<td>
																	<s:if test="stpAmount == 0 ">
															 			<input type="number"  id="stpAmt" class="g-font-size-10--xs g-font-size-14--lg g-color--black g-width-60--xs g-width-90--lg"
																			placeholder="Amount"
																			onblur="checkStpVal(<s:property value="#customerStpCartListElement.minStpAmount"/>,<s:property value="#customerStpCartListElement.totalWithdrawalAmount"/>,this);"
																			onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" 
																			 step=".01">
																	</s:if>
																	<s:else>
																		
																		<input type="number"  id="stpAmt" class="g-font-size-10--xs g-font-size-14--lg g-color--black g-width-60--xs g-width-90--lg"
																			value=<s:property value="#customerStpCartListElement.stpAmount"/> 
																			onblur="checkStpVal(<s:property value="#customerStpCartListElement.minStpAmount"/>,<s:property value="#customerStpCartListElement.totalWithdrawalAmount"/>,this);"
																			onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" 
																			step=".01">
																	</s:else>
																	<input name="stpAmtArr" type="number" id="amt" class=" hidden"
																			value=<s:property value="#customerStpCartListElement.stpAmount"/> >
																	
															</td>
															</tr>
															<tr 
															class=" g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" 
															style="padding-top: 25px">
															<s:set var="selStpTenure" value="#customerStpCartListElement.stpDuration" />
															<s:set var="selStpDate" value="#customerStpCartListElement.stpDate" />
															<td>
																<select name="stpTenureArr" class="g-font-size-10--xs g-font-size-14--lg g-width-110--xs g-width-120--lg" id="stp-tenure"> 
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
															<td>
																<select name="stpDateArr" class="g-font-size-10--xs g-font-size-14--lg g-width-90--xs g-width-100--lg" id="stp-date"> 
															        <% 
															        	String selStpDate= (String) pageContext.getAttribute("selStpDate");
															        	String[] stpDates = {"1","5","10","15","20","25"};
															        	for (int i=0;i<stpDates.length;i++)  {
															        		String dat= (String)stpDates[i]; 
															        		if ("1".equals(dat))  {
															        			if (dat.equals(selStpDate))
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
																        		if (dat.equals(selStpDate))
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
														
											            </tr>
											            <tr>
											            	<td class="hidden">
																 <input class="hidden" name="stpCartIdArr"  value=<s:property value="#customerStpCartListElement.stpCartId"/> />
															</td>
															<td class="hidden ">
																 <input class="hidden" name="withdrawalFundIdArr"  value=<s:property value="#customerStpCartListElement.withdrawalFundId"/> />
															</td>
															<td class="hidden ">
																 <input class="hidden" name="folioNumArr"  value=<s:property value="#customerStpCartListElement.folioNumber"/> />
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
					
					<s:form  action="deleteStpCartEntryAction" method="post" name="formDeleteStpCart">
				  		<s:hidden id="stp-cart-id-value" name="stpCartId"></s:hidden>
	  				</s:form>
	     </div>
	     
	     <div class="col-lg-1 col-xs-0" ></div>
	</div>
	    	
			
			<div class="row g-margin-b-50--xs">
  				<div class="col-md-1 col-xs-1"></div>
  				<div class="col-md-6 col-xs-6  text-left">
  					<a href="javascript:editStpCart('Dashboard');" class=" btn btn-home g-color--white g-font-size-14--xs g-font-size-18--lg"  >+ Add another fund</a>
  				</div>
  				<div class="col-md-3 col-xs-1"></div>
				<div class="col-md-1 col-xs-4 text-left">
					<%-- <s:form action="redirectAction" method="post"> --%>
		      			<s:if test="#session.customerStpCartList.size() == 1 ">
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