<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Investment Details Page | Money Buddy</title>
    <meta http-equiv="Cache-control" content="max-age=2592000, public">
    <!-- core CSS -->
    <link href="assets/css/bootstrap/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
 	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
 	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.dataTables.min.css" />
  		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"/>
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/prettyPhoto.css" rel="stylesheet">
    <link href="assets/css/bootstrap/main.css" rel="stylesheet">
    <link href="assets/css/bootstrap/responsive.css" rel="stylesheet">
    
    <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" rel="stylesheet" href="assets/css/style2.css">
    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
    
	<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
	<%-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script> --%>

<script>

	function uploadCutsomerNav(el) 
	{		
		var bseOrderId = $(el).closest("tr").find("td:eq(1) input[type='text']").val();
		var bseRegNum = $(el).closest("tr").find("td:eq(2) input[type='text']").val();
		var transactionType = $(el).closest("tr").find("td:eq(3) input[type='text']").val();
		var folioNum = $(el).closest("tr").find("td:eq(7) input[type='text']").val();
		var navValue = $(el).closest("tr").find("td:eq(8) input[type='text']").val();
		var unitsPurchased = $(el).closest("tr").find("td:eq(9) input[type='text']").val();
		var transactionDate = $(el).closest("tr").find("td:eq(10) input[type='text']").val();
		
		if ("" == folioNum) {
			alert('folioNum can not be blank');
			return false
		}
		else if ("" == navValue) {
			alert('navValue can not be blank');
			return false
		}
		else if ("" == unitsPurchased) {
			alert('unitsPurchased can not be blank');
			return false
		}
		
		document.getElementById("action-bse-order-id").value = bseOrderId;
		document.getElementById("action-bse-reg-num").value = bseRegNum;
		document.getElementById("action-transaction-type").value = transactionType;
		document.getElementById("action-transaction-date").value = transactionDate;
		document.getElementById("action-folio-number").value = folioNum;
		document.getElementById("action-nav-value").value = navValue;
		document.getElementById("action-units-purchased").value = unitsPurchased;
		
		document.formUploadNav.submit();
		
		
		
	}

</script>


</head>

<body class="homepage bg-warning" onload="setInitialUpfrontInvestment();">

	<header id="header">

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <div class="s-header-v2__logo">
                        <a href="<s:url action="adminHome"/>" class="s-header-v2__logo-link">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
                            <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
                        </a>
                    </div>
                </div>
				
                <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item col-sm-push-7"><a href="<s:url action="adminHome"/>" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item col-sm-push-8"><a href="<s:url action="logOut"/>" class="s-header-v2__nav-link">Log Out</a></li>
                                </ul>
                            </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
    
	<section id="bankDetails">
	
	
	<div id="upload-nav" class="">
		<div class="row" style="margin-top:-60px;margin-bottom:50px;">
			
				<h2 class="text-center" style="font-family:Aparajita;font-size:35px; "><b>Upload NAV</b></h2>
			
		</div>	
		
		
		<div class="row" style="margin-top:-60px;margin-bottom:50px;">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<s:actionmessage class="small-text g-color--red"/> 
			</div>
			<div class="col-md-3">
			</div>
		</div>
		
		
		
		<div class="row" >
			<!-- <div class="col-md-1"></div> -->
			<div class="col-md-12 text-center">
				<table id="navtable" class="table table-bordered stripe " style="width:95%" align="center">
						<thead class="table-head " style="font-size:17px;">
							<tr>
								<th class="center col-md-1 g-bg-color--gray-light">CustomerId</th>
								<th class="center col-md-1 g-bg-color--gray-light">BseOrderId</th>
								<th class="center col-md-1 g-bg-color--gray-light">BseRegNum</th>
								<th class="center col-md-2 g-bg-color--gray-light">TrnsType</th>
								<th class="center col-md-1 g-bg-color--gray-light hidden">RTA</th>
								<th class="center col-md-1 g-bg-color--gray-light hidden">SchemeType</th>
								<th class="center col-md-1 g-bg-color--gray-light">TransactionDate</th>
								<th class="center col-md-2 g-bg-color--gray-light">FolioNum</th>
								<th class="center col-md-1 g-bg-color--gray-light">NAV</th>
								<th class="center col-md-1 g-bg-color--gray-light">Units</th>	
								<th class="center col-md-2 g-bg-color--gray-light"></th>
							</tr>
						</thead>
						<tbody class="table-body g-font-size-14--xs">
							<%-- <s:set var="pendingNavOrders" <s:property value="pendingNavOrders"/> /> --%>
							
								<s:iterator value="pendingNavOrders" var="pendingNavOrdersElement">
									<tr>
									    <td>
									    	<s:property value="#pendingNavOrdersElement.customerId"/>
								    	</td>
									    <td class="center g-font-size-14--xs">
									    	<s:if test="#pendingNavOrdersElement.bseOrderId == ''  || #pendingNavOrdersElement.bseOrderId == null ">
  											  	<input class="form-control" id="folio-num" type="text" placeholder="Enter BSE Order Id" >
											</s:if>
									    	<s:else>
									    		<input class="form-control" type="text" value ="<s:property value="#pendingNavOrdersElement.bseOrderId"/>" readonly>
									    	</s:else>
								    	</td>
									    <td class="center g-font-size-14--xs">
									    	<s:if test="#pendingNavOrdersElement.bseRegNum == ''  || #pendingNavOrdersElement.bseRegNum == null ">
  											  	<input class="form-control" type="text" value ="NA" readonly>
											</s:if>
									    	<s:else>
									    		<input class="form-control" type="text" value ="<s:property value="#pendingNavOrdersElement.bseRegNum"/>" readonly>
									    	</s:else>
							    		</td>
									    <td class="center g-font-size-14--xs">
									    	<input class="form-control" type="text" value ="<s:property value="#pendingNavOrdersElement.transactionType"/>" readonly>
									    </td>
									    <td class="center hidden g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="emailId" class="g-color--red" /> --%>
			  								<%-- <s:textfield class="form-control" id="bse-order-id" readonly ><s:property value="#pendingNavOrdersElement.key"/></s:textfield> --%>
									    	<s:property value="#pendingNavOrdersElement.rta"/>
									    </td>
									    <td class="center hidden g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="emailId" class="g-color--red" /> --%>
			  								<%-- <s:textfield class="form-control" id="bse-order-id" readonly ><s:property value="#pendingNavOrdersElement.key"/></s:textfield> --%>
									    	<s:property value="#pendingNavOrdersElement.schemeType"/>
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="emailId" class="g-color--red" /> --%>
			  								<%-- <s:textfield class="form-control" id="bse-order-id" readonly ><s:property value="#pendingNavOrdersElement.key"/></s:textfield> --%>
									    	<s:property value="#pendingNavOrdersElement.frmtTransactionDate"/>
									    </td>
									    
									    <td class="center g-font-size-14--xs">
									    	<s:if test="#pendingNavOrdersElement.transactionFolioNum == ''  || #pendingNavOrdersElement.transactionFolioNum == null ">
									    		<%-- <s:fielderror fieldName="folioNum" class="g-color--red" /> --%>
											  	<%-- <s:textfield class="form-control" id="folio-num" placeholder="Enter Folio Num"  /> --%>
											  	<input class="form-control" id="folio-num" type="text" placeholder="Enter Folio Num" >
									    	</s:if>
									    	<s:else>
									    		<s:set var="folNum" value="#pendingNavOrdersElement.transactionFolioNum" />
									    		<%-- <s:fielderror fieldName="folioNum" class="g-color--red" /> --%>
											  	<%-- <s:textfield class="form-control" id="folio-num" placeholder="Enter Folio Num" value="#FolNum" /> --%>
									    		<input class="form-control" type="text" value ="<s:property value="#pendingNavOrdersElement.transactionFolioNum"/>" readonly>
									    	</s:else>
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="folioNum" class="g-color--red" /> --%>
										  	<%-- <s:textfield class="form-control" id="nav-value" placeholder="Enter NAV" /> --%>
									    	<input class="form-control" id="nav-value" type="text" placeholder="Enter NAV" >
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<%-- <s:fielderror fieldName="unitsPurchased" class="g-color--red" /> --%>
										  	<%-- <s:textfield class="form-control" id="units-purchased" placeholder="Enter Units" /> --%>
									    	<input class="form-control" id="units-purchased" type="text" placeholder="Enter Units" >
									    	
									    </td>
									    <td class="center g-font-size-14--xs">
									    	<input class="form-control hidden" id="transaction-date" type="text" value ="<s:property value="#pendingNavOrdersElement.transactionDate"/>" >
									    	<s:submit class="btn btn-home readmore submit-button-1" style="padding:5px 15px 5px 15px;" value="Upload NAV"  onCLick="uploadCutsomerNav(this)" />
									    	<!-- <button type="button" class="btn btn-primary readmore submit-button-1" onClick="uploadCutsomerNav(this);">Upload NAV</button> -->
									    </td>
									</tr>
								</s:iterator>
								
							 
						</tbody>
					</table>
					<s:form  action="uploadCustomerNavAction" method="post" name="formUploadNav" >
						<s:hidden id="action-bse-order-id" name="bseOrderId"></s:hidden>
						<s:hidden id="action-bse-reg-num" name="bseRegNum"></s:hidden>
						<s:hidden id="action-transaction-type" name="transactionType"></s:hidden>
						<s:hidden id="action-transaction-date" name="transactionDate"></s:hidden>
						<s:hidden id="action-folio-number" name="folioNum"></s:hidden>
						<s:hidden id="action-nav-value" name="navValue"></s:hidden>
						<s:hidden id="action-units-purchased" name="unitsPurchased"></s:hidden>
					</s:form>
				</div>
				<!-- <div class="col-md-1"></div> -->
		</div>

		<div class="row" style="margin-top:20px;">
			<div class="col-md-6"></div>
			<div class="col-md-6">
				
			</div>
	
		</div>
	
	</div>
	
	<div id="successfully-uploaded-nav" class="row hidden" style="margin-top:-60px;margin-bottom:50px;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h2 style="font-family:Aparajita;font-size:35px;"><b>Successfully Uploaded NAV</b></h2>
		</div>
		<div class="col-md-3"></div>
	</div>
	
	
   </section>
      <footer class="g-bg-color--dark">
            <!-- Links -->
            <div class="g-hor-divider__dashed--white-opacity-lightest">
                <div class="container g-padding-y-40--xs">
                    <div class="row">
                    
                        <div class="col-xs-4 col-lg-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs ">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="welcome">Home</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="saveTax">Save Tax</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="<s:url action="MFexplorer"/>">Funds Explorer</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="contactUs">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-4 col-lg-2 g-margin-b-20--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://twitter.com/MoneyBuddyIndia">Twitter</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.facebook.com/MoneyBuddyIndia">Facebook</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.linkedin.com/in/money-buddy-94a73814a/">Linkedin</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://www.YouTube.com/MoneyBuddy">YouTube</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-4 col-lg-2 g-margin-b-60--xs g-margin-b-0--md">
                            <ul class="list-unstyled g-ul-li-tb-5--xs g-margin-b-0--xs">
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="terms">Terms &amp; Conditions</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="privacyPolicy">Privacy Policy</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="MFDocuments">MFDocuments</a></li>
                                <li><a class="g-font-size-15--xs g-color--white-opacity" href="https://medium.com/@moneybuddyIndia">Blog</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-12 col-md-4 col-lg-offset-2 s-footer__logo g-padding-y-50--xs g-padding-y-0--md">
                             <h3 class="text-center g-font-size-18--xs g-color--primary g-margin-l-o-25--xs">MoneyBuddy</h3>
                            <br/>
                            <p class="g-color--primary">
                            No complicated jargon, no daunting fees, just straightforward, effortless investing.</p>
                        </div>
                    </div>
                    <div class="row  g-font-size-12--xs g-color--white">
                    <br/>
                    	 Mutual fund investments are subject to market risks. Please read the scheme information and other related documents carefully before investing.
						<br/>Past performance is not indicative of future returns. Please consider your specific investment requirements, risk tolerance, investment goal and time frame associated with the investment before choosing a fund or designing a suitable portfolio.
                    	<br/>MoneyBuddy is the trade name used by Kamal Wadhwani to run his advisory business. SEBI Regn No: INA000013581
                    </div>
                </div>
            </div>
            <!-- End Links -->

            <!-- Copyright -->
            <div class="container g-padding-y-10--xs">
                <div class="row">
                    <div class="col-xs-6">
                        <a href="welcome">
                            <img class="g-width-100--xs g-height-auto--xs" src="img/logo-white.png" alt="MoneyBuddy Logo">
                        </a>
                    </div>
                     <div class="col-xs-6 g-text-right--xs g-color--white">
                    &copy; 2020 <a href="welcome" title="MoneyBuddy">Moneybuddy</a>. All Rights Reserved.
                </div>
                </div>
            </div>
            <!-- End Copyright -->
        </footer>


		<script type="text/javascript"  src="assets/js/jquery.js"></script>
	    <script type="text/javascript"  src="assets/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
	    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
	    <script type="text/javascript" src="assets/js/main.js"></script>
	    <script type="text/javascript" src="assets/js/wow.min.js"></script>
		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		
		
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/datetime-moment.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/numeric-comma.js"></script>
		<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
		
		<script>
		
		$(document).ready(function() {
		    TUTORIAL_SAVVY.initChart()
		} );
		
		var TUTORIAL_SAVVY ={
				
		  		/* Initalization render chart */
		  		initChart : function(){
		  		TUTORIAL_SAVVY.loadNavdata();
		  		},
		  		
		  		
		  		loadNavdata : function()
				  {
					 var table =  $('#navtable').DataTable( {
					    	
						 "ordering": true,
						 "paging": false,
						 "searching": false,
						 "info":false,
						 
						 "columnDefs": [
							    {"orderable": false, "targets": 1},
							    {"orderable": false, "targets": 2},
							    {"orderable": false, "targets": 3},
							    {"orderable": false, "targets": 7},
							    {"orderable": false, "targets": 8},
							   	{"orderable": false, "targets": 9},
							    {"orderable": false, "targets": 10}
						    	
							  ]
					  	     							
					    } ); 

				  },
				  
		  		
		};
		
		</script>
		
		
		
		
</body>
</html>