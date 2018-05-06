<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java"
	import="com.myMoneyBuddy.GAT.PredictedValueCalculation"%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Investment Details Page | Money Buddy</title>
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/datepicker.css"/>
 	<!-- <link rel="stylesheet" href="assets/MoneyBuddyStyles.css" /> -->
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
	<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script type="text/javascript"  src="assets/js/jquery.js"></script>
    <script type="text/javascript"  src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript"  src="assets/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    <script type="text/javascript" src="assets/js/wow.min.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    
    <link href="css/global/global.css" rel="stylesheet" type="text/css"/>

	<style type="text/css">
		.ui-datepicker {
		   background: #333;
		   border: 1px solid #555;
		   color: #EEE;
		   width:200px;
		   heigth:300px;
		 }
	</style>
	<script type="text/javascript">
		$(function(){
			$('.datepicker').datepicker({
				dateFormat: "yy-mm-dd"
				
			});
		});
	</script>
</head>

<body class="homepage bg-warning">
   <header id="header">

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="myIndex"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="active" id="header-nav-li"><a href="myIndex">Home</a></li>
                        <li id="header-nav-li"><a href="startSip">Start SIP</a></li>
                        <li id="header-nav-li"><a href="saveTax">Save Tax</a></li>
                        <li id="header-nav-li"><a href="aboutUs">About Us</a></li>
                        <li id="header-nav-li"><a href="blog">Blog</a></li> 
                        <li id="header-nav-li"><a href="help">Contact Us</a></li>  
                       
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li id="header-nav-li"><a href="login" >Sign in</a></li>
										<li id="header-nav-li"><a href="register" >Sign up</a></li> 
							<%	} else 
							 	{	%>
							 			 <li id="header-nav-li"><a href="bseDashboard" >Dashboard</a></li> 
							 			 <li id="header-nav-li"><a href="logOff" >Log Out</a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>
	
	<section  id="one">

	<div class="row" style="margin-top:-60px;margin-bottom:20px;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h2 style="font-family:Aparajita;font-size:35px;"><b>Please provide basic details</b></h2>
		</div>
		<div class="col-md-3"></div>
	</div>	
	<div >
	<s:form action="kycCheckAction" method="post" >
		
	<div class="row">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4">
			
			<label for="customer-name" class="small-text pull-right">Name </label>
			</div> 

			<div class="col-md-6">
				<s:fielderror fieldName="customerName" class="g-color--red" />
			  	<s:textfield class="form-control" id="customer-name" placeholder="Enter Name as per PAN CARD" name="customerName" style="margin-top:-10px;"/> 
				  <!-- <input class="form-control" id="customer-name" name="customerName" type="text" placeholder="Enter Name as per PAN CARD" style="margin-top:-10px;"> -->
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="date-of-birth"  class="small-text pull-right">Date of Birth</label></div>
			<div  class="col-md-6" >
                <input class="form-control datepicker" id="date-of-birth" name="dateOfBirth" placeholder="Enter Date of Birth" style="margin-top:-10px;">
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="gender" class="small-text pull-right">Gender</label>
	      	</div>

			<div  class="col-md-6" >
				 <s:select class="form-control"  id="gender" style="margin-top:-10px;" 
					list="#{'M':'Male', 'F':'Female'}" 
					name="gender" 
					value="M" /> 
			  	<%-- <select class="form-control" id="gender" name="gender" style="margin-top:-10px;">
			        <option value="M" selected>Male</option>
			        <option value="F">Female</option>
	
		      	</select> --%>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>

	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="occupation" class="small-text pull-right">Occupation</label>
	      	</div>

			<div  class="col-md-6" >
			  	<s:select class="form-control"  id="occupation" style="margin-top:-10px;"
					list="#{'PriSecJob':'Private Sector job', 'PubSecJob':'Public Sector job', 'GovSer':'Government Service',
					'Business':'Business', 'Professional':'Professional', 'Agriculturist':'Agriculturist',
					'Retired':'Retired', 'Student':'Student', 'ForexDeal':'Forex Dealer',
					'HouseWife':'Housewife', 'Others':'Others' }" 
					name="occupation" 
					value="PriSecJob" /> 
			  	<%-- <select class="form-control" id="occupation" name="occupation" style="margin-top:-10px;">
			        <option value="PriSecJob" selected>Private Sector job</option>
			        <option value="PubSecJob">Public Sector job</option>
			        <option value="GovSer">Government Service</option>
			        <option value="Business">Business</option>
			        <option value="Professional">Professional</option>
			        <option value="Agriculturist">Agriculturist</option>
			        <option value="Retired">Retired</option>
			        <option value="Student">Student</option>
			        <option value="ForexDeal">Forex Dealer</option>
			        <option value="HouseWife">Housewife</option>
			        <option value="Others">Others</option>
	
		      	</select> --%>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>
		<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="tax-status" class="small-text pull-right">Tax Status</label>
	      	</div>

			<div  class="col-md-6" >
				<s:select class="form-control"  id="tax-status" style="margin-top:-10px;"
					list="#{'Individual':'Individual', 'OnBeOfMinor':'On Behalf Of Minor', 'Huf':'HUF', 'Company':'Company',
					'AopBoi':'AOP/BOI', 'Partnership':'Partnership', 'BodyCorporate':'Body Corporate', 'Trust':'Trust',
					'Society':'Society', 'NriNre':'NRI - Repatriable(NRE)', 'OverCorpoBody':'Oversea Corporate Body', 'ForeInstiInvest':'Foreign Institutional Investor',
					'OverCorpoBodyOthers':'Oversea Corporate Body - Others', 'ProviFundEpf':'Provident Fund - EPF', 'SuperAnnuFund':'Super Annuation Fund', 'GratuityFund':'Gratuity Fund',
					'BankFinanInsti':'Bank/Finanacial Institution', 'SolePropri':'Sole Proprietorship', 'PensionFund':'Pension Fund', 'NriNro':'NRI - Repatriable(NRO)',
					'NriMinorNre':'NRI - Minor (NRE)', 'NriHufNro':'NRI-HUF(NRO)', 'NriThruNroAc':'NRI Through NRO A/c', 'GloDevelopNet':'Global Development Network',
					'NriHufNre':'NRI-HUF(NRE)', 'LimLiaParter':'Limited Liability Partnership', 'PubLimCompany':'Public Limited Company', 'PriLimCompany':'Private Limited Company',
					'UnlisCompany':'Unlisted Company', 'OciRepatri':'OCI - Repatriation', 'OciNonRepatri':'OCI - Non Repatriation', 'Pio':'Person of Indian Origin [PIO]',
					'Ngo':'Non-Government Organisation [NGO]', 'Others':'Others' }" 
					name="taxStatus" 
					value="Individual" /> 
			  	<%-- <select class="form-control" id="tax-status" name="taxStatus" style="margin-top:-10px;">
			        <option value="Individual" selected>Individual</option>
			        <option value="OnBeOfMinor">On Behalf Of Minor</option>
			        <option value="Huf">HUF</option>
			        <option value="Company">Company</option>
			        <option value="AopBoi">AOP/BOI</option>
			        <option value="Partnership">Partnership</option>
			        <option value="BodyCorporate">Body Corporate</option>
			        <option value="Trust">Trust</option>
			        <option value="Society">Society</option>
			        <option value="NriNre">NRI - Repatriable(NRE)</option>
			        <option value="OverCorpoBody">Oversea Corporate Body</option>
			        <option value="ForeInstiInvest">Foreign Institutional Investor</option>
			        <option value="OverCorpoBodyOthers">Oversea Corporate Body - Others</option>
			        <option value="ProviFundEpf">Provident Fund - EPF</option>
			        <option value="SuperAnnuFund">Super Annuation Fund</option>
			        <option value="GratuityFund">Gratuity Fund</option>
			        <option value="BankFinanInsti">Bank/Finanacial Institution</option>
			        <option value="SolePropri">Sole Proprietorship</option>
			        <option value="PensionFund">Pension Fund</option>
			        <option value="NriNro">NRI - Repatriable(NRO)</option>
			        <option value="NriMinorNre">NRI - Minor (NRE)</option>
			        <option value="NriHufNro">NRI-HUF(NRO)</option>
			        <option value="NriThruNroAc">NRI Through NRO A/c</option>
			        <option value="GloDevelopNet">Global Development Network</option>
			        <option value="NriHufNre">NRI-HUF(NRE)</option>
			        <option value="LimLiaParter">Limited Liability Partnership</option>
			        <option value="PubLimCompany">Public Limited Company</option>
			        <option value="PriLimCompany">Private Limited Company</option>
			        <option value="UnlisCompany">Unlisted Company</option>
			        <option value="OciRepatri">OCI - Repatriation</option>
			        <option value="OciNonRepatri">OCI - Non Repatriation</option>
			        <option value="Pio">Person of Indian Origin [PIO]</option>
			        <option value="Ngo">Non-Government Organisation [NGO]</option>
			        <option value="Others">Others</option>
			        
		      	</select> --%>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">

		</div>

	</div>
	
	
	<div class="row" >
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<h2 class="small-text"><b>Address, as per the address proof**</b></h2>
		</div>
	</div>
	
	<div class="row" style="margin-top:10px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="address-line-one"  class="small-text pull-right">Line 1</label></div>
			<div  class="col-md-6" >
				<s:fielderror fieldName="addressLineOne" class="g-color--red" />
			  	<s:textfield class="form-control" id="address-line-one" placeholder="Enter Address Line 1" name="addressLineOne" style="margin-top:-10px;"/> 
				<!-- <input class="form-control" id="address-line-one" name="addressLineOne" type="text" placeholder="Enter Address Line 1" style="margin-top:-10px;"> -->
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="address-line-two"  class="small-text pull-right">Line 2</label></div>
			<div  class="col-md-6" >
			  	<s:fielderror fieldName="addressLineTwo" class="g-color--red" />
			  	<s:textfield class="form-control" id="address-line-two" placeholder="Enter Address Line 2" name="addressLineTwo" style="margin-top:-10px;"/> 
				 <!-- <input class="form-control" id="address-line-two" name="addressLineTwo" type="text" placeholder="Enter Address Line 2" style="margin-top:-10px;"> -->
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="address-line-three"  class="small-text pull-right">Line 3</label></div>
			<div  class="col-md-6" >
			  	<s:fielderror fieldName="addressLineThree" class="g-color--red" />
			  	<s:textfield class="form-control" id="address-line-three" placeholder="Enter Address Line 3" name="addressLineThree" style="margin-top:-10px;"/> 
				<!-- <input class="form-control" id="address-line-three" name="addressLineThree" type="text" placeholder="Enter Address Line 3" style="margin-top:-10px;"> -->
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="residential-city" class="small-text pull-right">City</label></div>
			<div class="col-md-6" >
				<%-- <s:select class="form-control"  id="tax-status" style="margin-top:-10px;"
					list="#{'Individual':'Individual', 'OnBeOfMinor':'On Behalf Of Minor', 'Huf':'HUF', 'Company':'Company',
					'AopBoi':'AOP/BOI', 'Partnership':'Partnership', 'BodyCorporate':'Body Corporate', 'Trust':'Trust',
					'Society':'Society', 'NriNre':'NRI - Repatriable(NRE)', 'OverCorpoBody':'Oversea Corporate Body', 'ForeInstiInvest':'Foreign Institutional Investor',
					'OverCorpoBodyOthers':'Oversea Corporate Body - Others', 'ProviFundEpf':'Provident Fund - EPF', 'SuperAnnuFund':'Super Annuation Fund', 'GratuityFund':'Gratuity Fund',
					'BankFinanInsti':'Bank/Finanacial Institution', 'SolePropri':'Sole Proprietorship', 'PensionFund':'Pension Fund', 'NriNro':'NRI - Repatriable(NRO)',
					'NriMinorNre':'NRI - Minor (NRE)', 'NriHufNro':'NRI-HUF(NRO)', 'NriThruNroAc':'NRI Through NRO A/c', 'GloDevelopNet':'Global Development Network',
					'NriHufNre':'NRI-HUF(NRE)', 'LimLiaParter':'Limited Liability Partnership', 'PubLimCompany':'Public Limited Company', 'PriLimCompany':'Private Limited Company',
					'UnlisCompany':'Unlisted Company', 'OciRepatri':'OCI - Repatriation', 'OciNonRepatri':'OCI - Non Repatriation', 'Pio':'Person of Indian Origin [PIO]',
					'Ngo':'Non-Government Organisation [NGO]', 'Others':'Others' }" 
					name="taxStatus" 
					value="Individual" />  --%>
				<s:select class="form-control"  id="residential-city" style="margin-top:-10px;"
					list="#{'Agra':'Agra', 'Ahmedabad':'Ahmedabad', 'Ajmer':'Ajmer', 'Allahabad':'Allahabad', 
					'Amritsar':'Amritsar', 'Anand':'Anand', 'Asansol':'Asansol', 'Aurangabad':'Aurangabad', 'Bangalore':'Bangalore', 
					'Baroda':'Baroda', 'Bharuch':'Bharuch', 'Bhavnagar':'Bhavnagar', 'Bhopal':'Bhopal', 'Bhubaneswar':'Bhubaneswar', 
					'Calicut':'Calicut', 'Chandigarh':'Chandigarh', 'Chennai':'Chennai', 'Coimbatore':'Coimbatore', 'Dehradun':'Dehradun', 
					'Dharwad':'Dharwad', 'Dubai':'Dubai<', 'Durgapur':'Durgapur', 'Erode':'Erode', 'Guntur':'Guntur', 
					'Guwahati':'Guwahati', 'Hubli':'Hubli', 'Hyderabad':'Hyderabad', 'Indore':'Indore', 'Jaipur':'Jaipur', 
					'Jalandhar':'Jalandhar', 'Jalgaon':'Jalgaon', 'Jamnagar':'Jamnagar', 'Jamshedpur':'Jamshedpur', 'Jodpur':'Jodpur', 
					'Kanpur':'Kanpur', 'Karaikudi':'Karaikudi', 'Kochi':'Kochi', 'Kolkata':'Kolkata', 'Kota':'Kota', 'Kottayam':'Kottayam', 
					'Lucknow':'Lucknow', 'Ludhiana':'Ludhiana', 'Mangalore':'Mangalore', 'Meerut':'Meerut', 'Moradabad':'Moradabad', 
					'Mumbai':'Mumbai', 'Mysore':'Mysore<', 'Nagpur':'Nagpur', 'Nasik':'Nasik', 'NewDelhi':'New Delhi<', 'Panjim':'Panjim', 
					'Patna':'Patna', 'Pondicherry':'Pondicherry', 'Pune':'Pune', 'Raipur':'Raipur', 'Rajahmundry':'Rajahmundry', 
					'Rajkot':'Rajkot', 'Ranchi':'Ranchi', 'Salem':'Salem', 'Siliguri':'Siliguri', 'Surat':'Surat', 'Tirunelveli':'Tirunelveli', 
					'Tirupur':'Tirupur', 'Trichy':'Trichy', 'Trivandrum':'Trivandrum', 'Udaipur':'Udaipur', 'Varanasi':'Varanasi', 
					'Vashi':'Vashi', 'Vijayawada':'Vijayawada', 'Others':'Others' }" 
					name="residentialCity" 
					value="Agra" />     
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>

	</div>

	<div class="row" style="margin-top:20px;">
		
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="residential-state" class="small-text pull-right">State</label></div>
			<div  class="col-md-6" >
				  
			  	<s:select class="form-control"  id="residential-state" style="margin-top:-10px;"
					list="#{'AndamanAndNicobar':'Andaman & Nicobar', 'ArunachalPradesh':'Arunachal Pradesh', 'AndhraPradesh':'Andhra Pradesh', 
			        'Assam':'Assam', 'Bihar':'Bihar', 'Chandigarh':'Chandigarh', 'Chhattisgarh':'Chhattisgarh', 'GOA':'GOA', 'Gujarat':'Gujarat', 
			        'Haryana':'Haryana', 'HimachalPradesh':'Himachal Pradesh', 'JammuAndKashmir':'Jammu & Kashmir', 'Jharkhand':'Jharkhand', 
			        'Karnataka':'Karnataka', 'Kerala':'Kerala', 'MadhyaPradesh':'Madhya Pradesh', 'Maharashtra':'Maharashtra', 'Manipur':'Manipur', 
			        'Meghalaya':'Meghalaya', 'Mizoram':'Mizoram', 'Nagaland':'Nagaland', 'NewDelhi':'New Delhi', 'Orissa':'Orissa', 
			        'Pondicherry':'Pondicherry', 'Punjab':'Punjab', 'Rajasthan':'Rajasthan', 'Sikkim':'Sikkim', 'Telengana':'Telengana', 
			        'TamilNadu':'Tamil Nadu', 'Tripura':'Tripura', 'UttarPradesh':'Uttar Pradesh', 'Uttaranchal':'Uttaranchal', 
			        'WestBengal':'West Bengal', 'DadraAndNagarHaveli':'Dadra and Nagar Haveli', 'DamanAndDiu':'Daman and Diu', 
			        'Lakshadweep':'Lakshadweep', 'Others':'Others' }" 
					name="residentialState" 
					value="AndamanAndNicobar" />
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>
	</div>

	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="residential-country" class="small-text pull-right">Country</label></div>
			<div class="col-md-6" >
			  	<s:fielderror fieldName="residentialCountry" class="g-color--red" />
			  	<s:textfield class="form-control" id="residential-country" placeholder="Enter Country" name="residentialCountry" value="India" style="margin-top:-10px;"/> 
				<!-- <input class="form-control" id="residential-country" name="residentialCountry" type="text" placeholder="Enter Country" style="margin-top:-10px;" value="India"> -->
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>

	</div>
	
		
	<div class="row" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="col-md-1"></div>
			<div class="col-md-4"><label for="residential-pin" class="small-text pull-right">Pin</label></div>
			<div class="col-md-6" >
			  	<s:fielderror fieldName="residentialPin" class="g-color--red" />
			  	<s:textfield class="form-control" id="residential-pin" placeholder="Enter Pin" name="residentialPin" style="margin-top:-10px;"/> 
				<!-- <input class="form-control" id="residential-pin" name="residentialPin" type="text" placeholder="Enter Pin" style="margin-top:-10px;"> -->
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-4">
		</div>

	</div>
	<div class="row" style="margin-top:25px;">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			 <s:submit class="center btn btn-primary readmore submit-button-1" value="SUBMIT" />
		</div>
		<div class="col-md-5"></div>
	</div>
	
	</s:form>
</div>

   </section>
      <footer id="footer" class="midnight-blue navbar navbar-fixed-bottom" >
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2017 <a target="_blank" href="http://quantwealth.in/" title="MoneyBuddy">MoneyBuddy</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="myIndex">Home</a></li>
                        <li><a href="aboutUs">About Us</a></li>
                        <li><a href="help">Contact Us</a></li>
                        <li><a href="register">Sign Up</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
		<%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>
</body>
</html>