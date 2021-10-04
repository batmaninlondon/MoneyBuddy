<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy - Terms and Conditions</title>
		<meta http-equiv="Cache-control" content="max-age=2592000, public">
        <!-- Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i|Montserrat:400,700" rel="stylesheet">
        
        <link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
		<link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <!-- Vendor Styles -->
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/scrollbar/scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css"/> -->

        <!-- Theme Styles -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>

    </head>
    <!-- End Head -->

    <!-- Body -->
    <body>
		<!-- <div id="load" class="load"></div> -->
	<div id="content">
    <!--========== HEADER ==========-->
        <header class="navbar-fixed-top s-header-v2 js__header-sticky">
            <!-- Navbar -->
            <nav class="s-header-v2__navbar">
                <div class="g-padding-l-80-md g-display-table--lg">
                    <!-- Navbar Row -->
                    <div class="s-header-v2__navbar-row">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="s-header-v2__navbar-col">
                            <button type="button" class="collapsed s-header-v2__toggle" data-toggle="collapse" data-target="#nav-collapse" aria-expanded="false">
                                <span class="s-header-v2__toggle-icon-bar"></span>
                            </button>
                        </div>

                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col-width--180">
                            <!-- Logo -->
                            <div class="s-header-v2__logo">
                                <a href="welcome" class="s-header-v2__logo-link">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--default" src="img/logo-white.png" alt="MoneyBuddy Logo">
                                    <img class="s-header-v2__logo-img s-header-v2__logo-img--shrink" src="img/logo.png" alt="MoneyBuddy Logo">
                                </a>
                            </div>
                            <!-- End Logo -->
                        </div>
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col-width--180"></div>
                        
                        <div class="s-header-v2__navbar-col s-header-v2__navbar-col--right g-padding-l-80-md">
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse s-header-v2__navbar-collapse" id="nav-collapse">
                                <ul class="s-header-v2__nav">
                                    <li class="s-header-v2__nav-item"><a href="welcome" class="s-header-v2__nav-link">Home</a></li>
                                    <li class="s-header-v2__nav-item"><a href="saveTax" class="s-header-v2__nav-link">Save Tax</a></li>
                                    <li class="s-header-v2__nav-item"><a href="<s:url action="MFexplorer"/>" class="s-header-v2__nav-link">Funds Explorer</a></li>
                                    <!-- <li class="s-header-v2__nav-item"><a href="aboutUs" class="s-header-v2__nav-link">About Us</a></li> -->
                                    <li class="s-header-v2__nav-item"><a href="https://medium.com/@moneybuddyIndia" class="s-header-v2__nav-link">Blog</a></li>
							         	<%  if(session.getAttribute("customerId") == null)
										 	{   %> 
													<li class="s-header-v2__nav-item"><a href="login" class="s-header-v2__nav-link">Login/SignUp</a></li>
										<%	} else 
										 	{	%>
										 			<li class="s-header-v2__nav-item"><a href="<s:url action="Dashboard"/>" class="s-header-v2__nav-link">Dashboard</a></li>
										 			 <li id="dropdown-selector" class="dropdown s-header-v2__nav-item s-header-v2__dropdown-on-hover">
														<a href="javascript:void(0);" class="dropdown-toggle s-header-v2__nav-link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cart<span class="g-font-size-10--xs g-margin-l-5--xs ti-angle-down"></span></a>
														<ul class="dropdown-menu s-header-v2__dropdown-menu" style="min-width: 60px;">
															<li><a href="<s:url action="Cart"/>" class="s-header-v2__dropdown-menu-link">Investment Cart</a></li>
															<li><a href="<s:url action="RedCart"/>" class="s-header-v2__dropdown-menu-link">Redemption Cart</a></li>
															<li><a href="<s:url action="customerStpCartAction"/>" class="s-header-v2__dropdown-menu-link">Stp Cart</a></li>
															<li><a href="<s:url action="customerSwitchCartAction"/>" class="s-header-v2__dropdown-menu-link">Switch Cart</a></li>
														</ul>
													</li>
										 			 <li class="s-header-v2__nav-item"><a href="<s:url action="logOut"/>" class="s-header-v2__nav-link">Log Out</a></li>
										<%	}	%>  
										<li id="dropdown-selector" class=" btn-group s-header-v2__nav-item dropdown">
	                                        <a href="#" class="s-header-v2__nav-link -is-active dropdown-toggle" data-toggle="dropdown" role="button" >Help<span class="caret"></span></a>
	                                    	<ul  id="dropdown-selection" class="dropdown-menu g-margin-t-o-30--xs " role="menu">
										        <li><a class="dropdown-item s-header-v2__nav-link  g-color--white" href="FAQs">FAQs</a></li>
										        <li><a class="dropdown-item s-header-v2__nav-link g-color--white" href="contactUs">Contact Us</a></li>
									      	</ul>
	                                    
	                                    </li>
                                </ul>
                            </div>
                            <!-- End Nav Menu -->
                        </div>
                    </div>
                    <!-- End Navbar Row -->
                </div>
            </nav>
            <!-- End Navbar -->
        </header>
        <!--========== END HEADER ==========-->

        <!--========== PROMO BLOCK ==========-->
        <!-- <div class="js__parallax-window" style="background: url(img/1920x1080/06.jpg) 50% 0 no-repeat fixed;"> -->
         <div class="g-bg-color--dark">
         
            <div class=" g-text-center--xs g-padding-y-80--xs g-margin-l-50--lg g-margin-r-50--lg">
            <br/><br/>
                <div class="g-margin-b-10--xs">
                    <div  id="contents" class="row" style="padding: 0px;" >
	              		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-40--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
	              			<div class="g-text-center--xs g-margin-b-40--xs">
	                    		<h3 class="g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs"><b>Terms and Conditions</b></h3>
	                    		<div class="g-color--text g-font-family--playfair g-letter-spacing--1" style=" text-align: justify; height : 500px; overflow : auto;" >
	                    			<p>
	                    			This document is an electronic record in terms of the Information Technology Act, 2000 and rules made thereunder as applicable and the amended provisions pertaining to electronic records in various statutes as amended by the Information Technology Act, 2000. This electronic record is generated by a computer system and does not require any physical or digital signatures.
									</p>
									<p>
									This document is published in accordance with the provisions of Rule 3 (1) of the Information Technology (Intermediaries Guidelines) Rules, 2011 that require publishing the rules and regulations, privacy policy and terms of use for access or usage of both, online platform run by Mr. Kamal Wadhwani, SEBI Registered Investment Advisor ( No: INA000013581), including but not limited to <a href="www.MoneyBuddy.co.in">www.MoneyBuddy.co.in</a> webportal as well as any other offline interaction that happens with Mr. Kamal Wadhwani-Sebi Registered Investment Advisor
									</p>
									<p>
									Applicable to all the customers of Mr. Kamal Wadhwani a SEBI registered investment advisors (registration number INA000013581) as well as others dealing with MoneyBuddy Financial Services Private Limited  including but not limited to users of our webportal <a href="www.MoneyBuddy.co.in">www.MoneyBuddy.co.in</a> 
									</p>
									<p>
									Mr. Kamal Wadhwani, is a SEBI registered investment advisor with registration number INA000013581 He is using the portal <a href="www.MoneyBuddy.co.in">www.MoneyBuddy.co.in</a> built in partnership with Bombay Stock Exchange, here in referred to as MoneyBuddy, to offer online investment and tracking facility to his customers. . You are requested to carefully go through the below mentioned Terms and Conditions (&quot;Terms & Conditions&quot;) before availing any of our services. If you continue to browse and use the online platforms of MoneyBuddy, you irrevocably and  unconditionally accept all the obligations stipulated in the Terms & Conditions and agree to abide by and be bound by them. Please note accessing our services through any medium including but not limited to our website <a href="www.MoneyBuddy.co.in">www.MoneyBuddy.co.in</a> , mobile app or offline channels, is also subject to these Terms & Conditions. Additionally, please note that these Terms & Conditions supersede all previous oral and written terms and conditions (if any) communicated to you.
	                    			</p>
									<p>
	                    				<b>DEFINITION of Key Terms used in this agreement</b>
	                    			</p>
									<p>
	                    			<b>&quot;AMC&quot;</b> shall mean and include all the Asset Management Companies in India.
	                    			</p>
									<p>
	                    			<b>&quot;BSE&quot;</b> shall mean Bombay Stock Exchange
	                    			</p>
									<p>
									<b>&quot;MoneyBuddy&quot;</b> or <b>&quot;we&quot;</b> or <b>&quot;our&quot;</b> shall mean and refer to trade name adopted by Mr. Kamal Wadhwani, a SEBI registered investment advisor
	                    			</p>
									<p>
	                    			<b>&quot;User&quot;, &quot;You/you&quot;, &quot;Your/your&quot;</b> means any person whether Registered with us or not, who views or uses the Website or any other online platform of MoneyBuddy;
	                    			</p>
									<p>
									<b>&quot;Services&quot;</b> means the service to carry out purchase, SIP, STP, switch and redemption of mutual fund units through online platforms of MoneyBuddy. This also include the service to modify user details such as email ID/ Phone number in user&apos;s mutual funds
	                    			</p>
									<p>
									<b>&quot;Force Majeure Event&quot;</b> means any event due to any cause beyond the reasonable control of MoneyBuddy, including without limitations, unavailability of any communication systems, breach, or virus in the processes or payment or delivery mechanism, sabotage, fire, flood, explosion, acts of god, civil commotion, strikes or industrial action of any kind, riots, insurrection, war, acts of government, computer hacking, unauthorised access to computer data and storage devices, computer crashes, malfunctioning in the computer terminal or the systems getting affected by any malicious, destructive or corrupting code or program, mechanical or technical errors/failures or power shut down, faults or failures in telecommunication etc.
									</p>
									<p>
									<b>&quot;Website&quot;</b> means and includes all the online platforms of MoneyBuddy whether accessed through a computer or mobile.
									</p>
									<p>
									<b>&quot;SIP&quot;</b> shall mean Systematic Investment Plans
									</p>
									<p>
									<b>&quot;STP&quot;</b> shall mean Systematic Transfer Plans
									</p>
									<p>
									<b>&quot;NAV&quot;</b> shall mean Net Asset Value
									</p>
									<p>
									<b>&quot;RTA&quot;</b> shall mean Registrar and Transfer Agent.
									</p>
									<p>
									<b>&quot;Investment Account&quot;</b> shall mean the account opened with MoneyBuddy for availing services provided by MoneyBuddy as explained above
									</p>
									<p>
									<b>&quot;Registered User&quot; or &quot;Registered Customer&quot;</b> shall mean and include the users or customers who have opened an investment Account with MoneyBuddy for availing our services
									</p>
									<p>
									<b>&quot;Electronic payment gateway&quot;</b> shall mean and include the payment gateways used for processing funds for mutual funds investments via internet banking, One Time Mandate (OTM), Bill Payee facility or any other mode for online processing of funds
									</p>
									<ol>
										<li>
										<p><b>Using the Services of MoneyBuddy</b></p>
										<p>
										I/We hereby agree to avail the service of MoneyBuddy through its online technology platform for the purchase and redemptions of units of mutual funds listed on its Websites/ Mobile Apps. I/We agree that those services are subject to the Terms & Conditions mentioned herein (the &quot;Services&quot;). I/We agree that MoneyBuddy and / or the mutual fund may, at its sole discretion, vary the Terms & Conditions, or withdraw any of the facilities provided herein from time to time. I/We, hereby, irrevocably and unconditionally, grant my/our no objection to MoneyBuddy and the respective mutual funds to collate transaction details relating to the investments in mutual fund units done by me/us on it&apos;s online technology platform, and transmit such transaction data to the concerned Asset Management Company (&quot;AMC&quot;) / mutual fund / BSE for further processing of my/our transactions.We also understand that apart from their online platform, MoneyBuddy is also in the business of distributing mutual funds through physical paperworks or through any other means it deems suitable.
										</p>
										</li>
										<li>
										<p><b>Registration of users on MoneyBuddy&apos;s online platform</b></p>
										<p>
										Access to MoneyBuddy&apos;s online technology platform for purchase, switch, and redemption transactions of mutual fund units will only be limited to the registered customers of MoneyBuddy. I/We agree and acknowledge that the Services provided may be limited to select Mutual Funds only, as per the agreement MoneyBuddy has entered into those Mutual Fund companies as well as per the discretion of MoneyBuddy. 
										</p>
										<p>
										Registered Customers will be able to only purchase, redeem, and switch mutual fund units through this service. I/We agree and understand that other things such as change of address, mobile number, e&#45;mail ID, and / or bank details might require a written request be sent to the AMC / CAMS / POS for signature verification and other formalities. I/We agree that any and / or all information that may be provided by me/us to MoneyBuddy from time to time, including but not limited to contact information, address and tax&#45;related information, or any other information required under existing or future KYC, or other norms & laws, may be shared by MoneyBuddy with the mutual funds/AMCs, or their respective authorized service providers, auditors, legal and tax consultants in compliance with the extant legal provisions from time to time.
										</p>
										<p>
										There may be an exit load applicable to certain mutual fund schemes. This is mentioned in the respective offer documents, including the Scheme Information Document (SID) / Key Information Memorandum (KIM) and addendums issued thereto from time to time (collectively referred to as &quot;scheme related documents&quot;). I/We shall read all the scheme related documents before investing.
										</p>
										<p>
										Investments from persons from the United States of America (&quot;U.S.&quot;) and Canada may not be permitted in certain mutual funds. MoneyBuddy/ AMCs/their respective trustee companies shall not be liable for rejection of an application by mutual funds, where the investor is a U.S. person and/or a Canadian person or such other prohibited investor as may be specified in the respective scheme related document from time to time.
										</p>
										<p>
										Purchase requests made through MoneyBuddy&apos;s online technology platform shall be processed by the respective mutual funds/BSE/AMCs only after funds sufficient to cover the purchase price, and other costs and charges have been received by the respective mutual funds/AMCs. Payments towards the purchase price and other costs and charges shall be made by Registered Customers directly in the name of the respective mutual fund scheme(s) through the payment gateway made available by MoneyBuddy/ BSE on the online technology platform. If, for any reason, the mutual fund is unable to allow a transaction for purchase or redemption of the full quantity of units as transacted by a Registered Customer through MoneyBuddy, the respective mutual fund/AMCs shall be entitled to process a lesser quantity of units being purchased or redeemed (as the case may be). In such case, neither MoneyBuddy nor the AMCs, or their respective trustees shall be responsible for the non&#45;execution of transactions for the entire quantity or the remaining quantity of units.
										</p>
										<p>
										Transaction rights for Systematic Investment Plans (&quot;SIPs&quot;) and Systematic Transfer Plans (&quot;STPs&quot;) will be pursuant to the Registered Customer executing the instructions, in the manner and form as prescribed by MoneyBuddy/ BSE and / or mutual funds on the online technology platform from time to time. The instructions will be applicable to all SIP and STP transactions, whether presently existing, or to be opened in future. I/We agree that, upon granting such instructions for SIP and STP transactions, I/We will be bound by the terms of the relevant SIP scheme of the mutual fund to which I/we subscribe.
										</p>
										<p>
										I/We agree and acknowledge that any transaction done or purported to be done by me/us before the cut&#45;off time on a business day, would be processed on the same day. Any transactions done on the online technology platform of MoneyBuddy after the prescribed cut&#45;off time will be deemed to be received on the next working day and will be processed accordingly. I/We agree and acknowledge that the MoneyBuddy reserves the right to specify a different cut-off time then the one specified by said Mutual Fund / BSE.
										</p>
										<p>
										I/We acknowledge that the units of the scheme shall be allotted, redeemed or switched, as the case may be, by the respective mutual funds / AMCs at the applicable Net Asset Value (&quot;NAV&quot;) of the concerned mutual fund scheme, in consistence with the terms of the scheme. However, MoneyBuddy shall not be liable for any loss that may arise to me/us as a result of incorrect NAV applied on units allotted to me/us by the mutual fund. I/We acknowledge that any transactions done on a holiday would be processed on the next business day and the NAV would be applicable as per the respective scheme related documents.
										</p>
										<p>
										I/We acknowledge that transactions once placed cannot be cancelled. However, depending upon the type of investments, I have the flexibility to withdraw my money after the transaction has been processed as per the applicable loads/charges.
										</p>
										<p>
										I/We acknowledge that any application for redemption, purchase, or exchange, or any other instruction must be correct, complete, clear, and unambiguous in all respects, and should conform to the prescribed procedure/documentation and regulatory requirements, failing which, MoneyBuddy / the AMC reserve the right to reject the same, and in such a case, MoneyBuddy / the AMC / the trustee shall not be responsible for any consequence arising therefrom.
										</p>
										<p>
										I/We have read and understood the contents of the scheme related documents and the details of the scheme, and I/we have not received or been induced by any rebate or gifts, directly or indirectly, in making investments. I/We hereby declare that the amount invested/to be invested by me/us in the scheme(s) of the mutual fund is derived through legitimate sources and is not held or designed for the purpose of contravention of any act, rules, regulations, or any statute or legislation, or any other applicable laws or any notifications, or directions issued by any governmental or statutory authority from time to time.
										</p>
										<p>
										The RIA license holder has disclosed to me that he only deals in direct mutual funds and does not get any commissions (in the form of trail commission or any other mode) from the fund houses/ AMCs. Instead, he charges an advisory fee to his customers, which has been disclosed to each customer before making investments and is subject to change with advanced notice.
										</p>
										</li>
										<li>
										<p><b>Accessing MoneyBuddy online platforms</b></p>
										<p>
										I/We acknowledge that by accessing and using the Services offered by MoneyBuddy, I/We agree to follow the Terms & Conditions for the use of its online platforms and as may be specified on MoneyBuddy&apos;s online platforms from time to time. Notwithstanding such acceptance of those Terms and Conditions, I/we agree to the following:
										</p>
										<ol type="a">
											<li>
											I/We agree that all information, content, materials, products (including, but not limited to text, content, photographs, graphics, video and audio content) on MoneyBuddy&apos;s online platforms, is protected by copyright in favour of MoneyBuddy under applicable copyright laws, and is also protected otherwise under general intellectual property law.
											</li>
											<li>
											I/We agree that all information submitted by me/us to MoneyBuddy, whether through any online platform or otherwise, shall be deemed to be the property of MoneyBuddy and it shall be free to use any ideas, concepts, know&#45; how or techniques provided by me/us in  MoneyBuddy&apos;s Websites, in any manner whatsoever.
											</li>
											<li>
											I/We agree not to copy, reproduce, sell, redistribute, publish, enter into a database, display, perform, modify, transmit, license, create derivative from, transfer, or in any way, exploit any part of any information, content, materials, services available from or through any online platform of MoneyBuddy, except that which I/we may download for my/our own personal, non&#45; commercial use.
											</li>
											<li>
											I/We agree that I/we will not access online platforms of MoneyBuddy for any purpose that is unlawful, or prohibited by these Terms & Conditions. I/We also agree that I/we will not access MoneyBuddy&apos;s online platforms in any manner that could damage, disable or impair the platform, or interfere with any other person&apos;s use or enjoyment of MoneyBuddy&apos;s platform.
											</li>
											<li>
											I/We agree that the software and hardware underlying online platforms of MoneyBuddy, as well as other internet related software which are required for accessing the MoneyBuddy platforms, are the legal property of the respective Vendors. The permission given by MoneyBuddy to access MoneyBuddy&apos;s platform will not convey any proprietary or ownership rights in the above software/hardware. I/We agree that I/we shall not attempt to modify, translate, disassemble, decompile, or reverse engineer the software/hardware underlying MoneyBuddy&apos;s online platforms, or create any derivative product based on the software /hardware.
											</li>
											<li>
											I/We agree that not all the products and services offered by MoneyBuddy are available in all geographic areas, and I/we may not be eligible for all the products or services offered on MoneyBuddy&apos;s online platform. MoneyBuddy reserves the right to determine the availability and eligibility for any product or service and might decline access to any person as per the sole discretion of MoneyBuddy.
											</li>
											<li>
											I/We agree that MoneyBuddy/AMC is not responsible for the availability of content or other services on third party sites linked from any of the MoneyBuddy&apos;s online platforms. I/We are aware that access of hyperlinks to other internet sites are at my/ our own risk and the content, accuracy, opinions expressed, and other links provided by these sites are not verified, monitored, or endorsed by MoneyBuddy in any way. MoneyBuddy does not make any warranties and expressly disclaims all warranties, express or implied, including without limitation, those of merchantability and fitness for a particular purpose, title or non&#45; infringement with respect to any information or services or products that are available or advertised or sold through these third party websites.
											</li>
											<li>
											I/We agree that MoneyBuddy has the absolute discretion to amend or supplement any of MoneyBuddy&apos;s Terms & Conditions at any time, without prior notice for such changes. I/We agree that the information and assistance provided on MoneyBuddy&apos;s online platforms are true to the knowledge of MoneyBuddy, and should not be construed as investment advice, and that MoneyBuddy shall have no liability for any discrepancy in any such information or assistance.											
											</li>
											<li>
											I/We agree that an Account may be created offline, without accessing any of MoneyBuddy&apos;s online platforms. In the event I/we create a MoneyBuddy Investment Account offline, I/we understand and acknowledge that these Terms & Conditions, and the Terms & Conditions of the use of MoneyBuddy&apos;s online platforms will continue to be applicable to me/us for the use of Services.
											</li>
										</ol>
										</li>
										<li>
										<p><b>No objection to MoneyBuddy</b></p>
										<p>
										I/We grant my/our no objection to MoneyBuddy to do or perform upon my/our placing of transaction requests on the online technology platform of MoneyBuddy and at my/our risk and cost, all or any of the following acts, deeds, matters and things:
										</p>
										<ol type="a">
											<li>
											To forward my transaction data and requests to the BSE/respective mutual funds/AMCs with respect to my instructions and orders of sale, purchase, transfer, splitting, and consolidation of mutual funds units.
											</li>
											<li>
											To transmit to the BSE, mutual fund and/or the corresponding AMC, information relating to my/our nomination / changes in investment plan / any other changes made through MoneyBuddy.
											</li>
											<li>
											To obtain and forward to the BSE/AMC/its Authorized Registrar my/our information as available in the KYC records, including my signature. I/We agree that such records may be used by the AMC/Authorised Registrar for authorizing the transactions that may be submitted by me/us in physical/offline mode.
											</li>
											<li>
											To override my registration to DNC/ NDNC and to contact me/us regarding matters pertaining to the operation of my account including, but not limited to, servicing of my requests, communication of special offers, new product launches, and product recommendations.
											</li>
										</ol>
										</li>
										<li>
											<p><b>Multiple Investors in a Single MoneyBuddy Investment Account</b></p>
											<p>
											I/We acknowledge that MoneyBuddy provides the facility, to add multiple investors in a single MoneyBuddy account for separate transactions in different mutual fund schemes, subject to applicable KYC norms for such additional investors. I/We agree that if I am/we are the account holder, I/we must specify the name of investor(s) for every transaction performed in the Account. When I/we are adding such &quot;additional investor(s)&quot; to my/our Account, I/we acknowledge that, the additional investor(s) has also seen and accepted all the Terms and Conditions accepted by the primary account holder. If I am/we are being added to the account as an &quot;additional investor&quot;, I/we acknowledge that I/we have seen and accepted all the Terms and Conditions accepted by the account holder.
											</p>
											<p>
											I/We further acknowledge that if a transaction is performed from a user Account having multiple investors, such transaction will be deemed to be made jointly with the additional investor(s) and will be legally binding on all the investors in that account including but not limited to the investor under whose name the said transaction is being performed.
											</p>
										</li>
										<li>
											<p><b>Communication of instructions</b></p>
											<p>
											In the event an Account has multiple investors mentioned in such Account, I/we acknowledge that all instructions (including instructions for modification of this clause) shall be given only by the first holder of such an Account, on behalf of both/all of us. All instructions given by the first holder above shall be binding on both/all as if given by each of us personally. I/We agree that the instructions may be for the purchase of units in the sole name of the first holder, or in the name of the first holder jointly with another person to the exclusion of the second or the third holder. I/We hereby authorize MoneyBuddy/BSE/AMCs to process and transmit such instructions given from time to time in relation to my/our transactions to the respective mutual funds/AMCs.
											</p>
											<p>
											The transactions for purchase, switch or redemption of units may be done through the online method as defined by MoneyBuddy. I/We agree that MoneyBuddy/BSE/AMC reserves the right to remove or add any method of making instructions for any transactions such as purchase, switch or redemption of the units, change of address, change of email/ phone number at any time as per their discretion.
											</p>
											<p>
											I/We agree and acknowledge that units purchased by giving instructions through any of the above modes will be deemed to be accepted for redemptions through the same mode only.
											</p>
											<p>
											MoneyBuddy may refuse to transmit transaction data for clients unless they are given in a manner and form acceptable to MoneyBuddy and in accordance with its right to verify such transactions. However, MoneyBuddy shall have no responsibility to determine the authenticity of any transactions done or purported to be done by me/us. I/We shall not hold MoneyBuddy liable on account of MoneyBuddy acting in good faith on any of/our transactions done or purported to be done by me/us.
											</p>
											<p>
											The mutual funds/AMCs may, at its discretion, not give effect to my/our transactions where the mutual funds/AMCs/BSE/MoneyBuddy have reason to believe (which decision of mutual funds / AMCs /MoneyBuddy/BSE I/We shall not question or dispute) that the transactions are not genuine or are otherwise improper, ambiguous or unclear or raise a doubt.
											</p>
											<p>
											MoneyBuddy/BSE/AMC/mutual fund/trustee of the AMC shall not be liable for any losses including, but not limited to, the loss of any opportunity costs incurred by me/us, if any, transactions are not carried out for any reason whatsoever.
											</p>
											<p>
											I/We agree to indemnify MoneyBuddy, BSE, AMC, trustees to the AMC, its respective officers, directors, employees, and agents against any improper/ fraudulent transactions, improper/fraudulent fund transfer transactions done or purported to be done by me/us on the online technology platform / payment gateway provided by MoneyBuddy/ BSE. MoneyBuddy/BSE/AMC shall not be obliged to accept from me/us any oral instructions for carrying out any transactions in mutual fund units.
											</p>
											<p>
											Further MoneyBuddy, BSE, AMC, trustees to the AMC, its respective officers, employees, and agents shall be indemnified for and held free and harmless from and against any and all costs, claims, losses or liabilities of any nature (direct or indirect) resulting from the act of purchase, redemption, or switch of mutual fund units, together with any and all the attendant costs and expenses including reasonable legal fees and expenses, that MoneyBuddy, BSE, AMC, trustees to the AMC, its respective officers, employees, and agents may incur or be subject to, in relation to the transactions conducted by me/us on the online platforms of MoneyBuddy. I/We also acknowledge that the security and the control provided by MoneyBuddy are designed to verify the source of communication, and not to detect errors in transmission of content including discrepancies between names on the account numbers, and that MoneyBuddy, or any intermediary, may transmit data or take requisite action by referring to the account number only, even if the name on the account is also provided. Nothing contained herein shall require MoneyBuddy to violate any applicable laws, rules or the procedures/ instructions. MoneyBuddy shall have no duty to verify the content of any transactions, instructions and communication, whether or not authorized, sent in its name and accepted by MoneyBuddy. MoneyBuddy will collate and transmit the transaction data and other details as it is received and stored on its servers, and will not validate the same for holdings, correctness of transaction and any other information.
											</p>
										</li>
										<li>
											<p><b>Holding pattern and customer details</b></p>
											<p>
											I/We acknowledge and agree that the holding pattern of the Registered Customer, as reflected in the MoneyBuddy system, is deemed to be the MoneyBuddy Account holding pattern of the account holder/investor(s).
											</p>
											<p>
											I/We also agree there will be no changes allowed in the holding pattern of the investors associated with the Account once the Account is activated.
											</p>
											<p>
											I/We agree that once an investment is made using the holding pattern, I/We will not be allowed to change the holding pattern for the subscriptions.
											</p>
											<p>
											The other requisite data (which is not part of the form) required to be reported to AMC / authorized registrar of the AMC will be extracted from the Account details maintained for the First holder. The mode of holding in all customer joint accounts is treated as &quot;Anyone or Survivor&quot;.
											</p>
										</li>
										<li>
											<p><b>Account Statement & Charges and fees</b></p>
											<p>
											I/We agree and acknowledge that it shall be the obligation of the AMC to regularly send to the Registered Customer (only to the first holder in cause of multiple / joint holdings) such communications as required under SEBI regulations. MoneyBuddy will not be liable for sending any legally required communication but will strive it&apos;s best to provide required information to users in a simple and easy to understand way.
											</p>
											<p>
											I/we acknowledge that MoneyBuddy reserves the right to change its fee structure in the future for its Services. Any such changes will be communicated via email 14 days ahead of implementation, and will also be displayed on it&apos;s online platforms. Under such circumstances, I/we understand that I/we will be allowed to transfer our assets out of my/our Account without incurring any costs payable to MoneyBuddy.
											</p>
											<p>
											I/We agree and understand that any such charges/fees that MoneyBuddy may choose to levy will be in addition to those levied by the BSE/AMCs, if any. All fees, charges, and reimbursement of expenditure shall be paid or made in full by me / us without any counterclaim, set off, or withholding. All liabilities and obligations of the Registered Customer hereunder to MoneyBuddy/BSE/mutual fund/AMCs/trustees of the AMC shall be joint and/or several, as the case may be.
											</p>
										</li>
										<li>
											<p><b>Third party risk</b></p>
											<p>
											MoneyBuddy shall not be liable for any loss or damage caused by reason of failure or delay of the mutual fund to deliver any units purchased, even though payments have been made for the same, or failure or delay in making payment in respect of any units sold, though they may have been delivered. I/We shall hold MoneyBuddy/BSE harmless and free from any claim in respect thereof.
											</p>
											<p>
											MoneyBuddy/BSE shall also not be liable for any delay, failure, or refusal of the mutual fund in registering or transferring units to my/our names or for any interest, dividend, or other loss caused to me/us arising therefrom.
											</p>
											<p>
											In such instances of third party claims, the AMC/mutual fund/trustees to the mutual fund shall be liable for failure/delay only where such claims/losses arise due to a reason entirely attributable to an error or gross negligence of the AMC. In no event shall the AMC/mutual fund/trustees to the mutual fund be liable for losses/claims arising due to force majeure reasons beyond the reasonable control of the AMC/mutual fund.
											</p>
										</li>
										<li>
											<p><b>Liability of MoneyBuddy</b></p>
											<p>
											MoneyBuddy shall not be liable to me/us for any act, omission, or delay by the BSE/ AMCs/mutual fund, or for any claims which I/we may suffer or incur as a result of, or in the course of discharge of duties by MoneyBuddy, or its employees, officers, directors, nominee, or agent.
											</p>
											<p>
											Without prejudice to the above, MoneyBuddy shall not be held liable for any loss or damage or failure to comply or delay in complying with its obligations under these Terms and Conditions which is caused directly or indirectly by any event or circumstances beyond MoneyBuddy&apos;s reasonable control. These include system failure, network errors, delay, or loss of data due to the above, and in circumstances of acts of God, floods, epidemics, quarantines, riots, civil commotion, and/or war. I/We further agree that MoneyBuddy shall not be held liable for any losses, damages, expenses, costs, liabilities, and claims of whatsoever nature caused by fraudulent or unauthorized use or access of my/our information, and/or signatures. MoneyBuddy will be under no duty to verify compliance with any restrictions on my/our investment powers.
											</p>
											<p>
											MoneyBuddy will not be liable for any loss, damage, cost, charges, or expenses directly or indirectly caused by reasons of any defects or imperfections or mechanical or other failure with relation to computer, cable, telex, telephone, or postal system.
											</p>
											<p>
											While MoneyBuddy will make every effort to have its computer systems available at all times, it makes no guarantees with respect to the availability of such systems. Additionally, MoneyBuddy will make every effort to resolve availability issues such as network problems, virus attacks, etc., in an expeditious manner. Notwithstanding these, MoneyBuddy will as such not be liable for any loss, damage, cost, charges or expenses directly or indirectly caused by reasons of lack of such availability.
											</p>
										</li>
										<li>
											<p><b>Electronic payment gateway</b></p>
											<p>
											I/we understand that funds transfer for purchase of units of mutual funds will be done by using an Electronic Payment Gateway facility for net banking offered through a third party net  banking service provider registered with the Reserve Bank of India. I/we agree not to use or permit the use of the payment gateway or any related services for any illegal or improper purposes.
											</p>
											<p>
											I/We hereby acknowledge that I/we am/are utilizing the Electronic Payment Gateway at my/our risk. I/We agree and understand that these risks would include but not be limited to the following risks, and MoneyBuddy/BSE/AMC/trustees of the AMC, disclaim all liability and responsibility for any claims, losses, damages, and costs of whatsoever nature arising due to such risks:
											</p>
											<ol type="a">
												<li>
													<p><b>Misuse of Password:</b></p>
													<p>
													I/We acknowledge that if any third party obtains access to the password of my MoneyBuddy Investment Account, such third party would be able to transact on MoneyBuddy&apos;s online platform. I/We shall ensure that the Terms & Conditions applicable to the use of the Net Banking password as contained in the Electronic Payment Gateway for Net Banking are complied with at all times.
													</p>
												</li>
												<li>
													<p><b>Internet Frauds:</b></p>
													<p>
													I/We understand that the internet per se is susceptible to a number of frauds, misuse, hacking, and other actions, which could affect payment instructions given using Electronic Payment Gateway or the transactions done using MoneyBuddy&apos;s online technology platform. Whilst MoneyBuddy shall aim to provide best security to prevent the same, there cannot be any guarantee against such internet frauds, hacking and other actions. I/We shall separately evolve/evaluate all risks arising out of same.
													</p>
												</li>
												<li>
													<p><b>Mistakes and Errors:</b></p>
													<p>
													The filling in of applicable data for transfer would require proper, accurate, and complete details. In the event of my/our account receiving an incorrect credit by reason of a mistake committed by any third party, the concerned mutual fund/AMC or the bank shall be entitled to reverse the incorrect credit at any time whatsoever without my/our consent. I/We shall be liable and responsible to MoneyBuddy/BSE/ concerned mutual fund/concerned AMC and accede to accept instructions without questions for any unfair or unjust gain obtained by me/us as a result of the same.
													</p>
												</li>
												<li>
													<p><b>Technology Risks:</b></p>
													<p>
													The technology for enabling the transfer of funds and the other services offered by the Electronic Payment and MoneyBuddy could be affected by a virus or other malicious, destructive, or corrupting code, program, or macro. I/We understand that the online platform of MoneyBuddy or the bank may require maintenance, and during such time, it may not be possible to process my/our request. This could result in delays in the processing of transactions/payment instructions or failure in the processing of transactions/payment instructions and other such failures and inability.
													</p>
													<p>
													I/We understand that MoneyBuddy disclaim all and any liability, whether direct or indirect, whether arising out of loss of profit or otherwise arising out of any failure or inability by MoneyBuddy/BSE/bank/mutual funds/AMCS to process any transaction/payment instructions for whatsoever reason. I/We understand and accept that MoneyBuddy/BSE/AMC/trustee company of the AMC/authorised registrars of the AMC shall not be responsible for any of the aforesaid risks.
													</p>
												</li>
												<li>
													<p><b>Limits:</b></p>
													<p>
													I/We are aware that MoneyBuddy/BSE may, from time to time, impose maximum and minimum limits on funds that may be transferred by virtue of the payment transfer service given. I/We realize and accept and agree that the same is to reduce my/our risks. I/We shall be bound by such limits imposed and shall strictly comply with them.
													</p>
												</li>
												<li>
													<p><b>Indemnity:</b></p>
													<p>
													I/We agree and undertake to indemnify MoneyBuddy/BSE/mutual funds /AMCs /trustees to the AMCs/authorized registrar of the AMC from and against all losses and damages that may be caused as a consequence of breach of any of the Electronic Payment Gateways for net banking, and the Terms & Conditions mentioned herein above.
													</p>
												</li>
												<li>
													<p><b>Withdrawal of Facility:</b></p>
													<p>
													MoneyBuddy shall be entitled to withdraw this service at any time without assigning any reason whatsoever.
													</p>
												</li>
												<li>
													<p><b>Binding nature of the above Terms & Conditions:</b></p>
													<p>
													I/We agree that by use of this facility, I/we shall be deemed to have agreed to all the above Terms & Conditions and such Terms & Conditions shall be bound on me/us in the same manner as if I/we have agreed to the same in writing.
													</p>
												</li>
											</ol>
										</li>
										<li>
											<p><b>Role and responsiblities of MoneyBuddy</b></p>
											<p>
											I/We expressly agree and acknowledge that any information contained in MoneyBuddy&apos;s online platform, emails, brochures or any other materials, or communicated by MoneyBuddy in any form, shall not be construed by me/us as investment advice and that all decisions to purchase or sell units made by me/us shall be on the basis of my/our own personal judgment arrived at after due consideration.
											</p>
											<p>
											I/We understand and agree that MoneyBuddy does not in any manner:
											</p>
											<ol type="a">
												<li>
												Guarantee payments on any units; or
												</li>
												<li>
												Guarantee liquidity of any units; or
												</li>
												<li>
												Make any offer to buy back any units; or
												</li>
												<li>
												Guarantee the redemption or repayment of any units on maturity; or
												</li>
												<li>
												Guarantee the payments of interest or dividend; or
												</li>
												<li>
												Promise, indicate, or guarantee any returns; or
												</li>
												<li>
												Guarantee any goods delivery.
												</li>
											</ol>
											<p>
											I/We further understand and agree that MoneyBuddy/BSE does not in any manner:
											</p>
											<ol type="a">
												<li>
												Subscribe to units of mutual funds on my/our behalf or in my/our name or collect payments from me/us for the units so purchased by me/us for remitting it further to the AMCs; or
												</li>
												<li>
												Redeem/sell the units held by me/us on my/our behalf or in my/our name; or
												</li>
												<li>
												Unilaterally instruct the mutual fund and/or the corresponding AMCs with regards to nomination/changes in investment plan/any other changes; or
												</li>
												<li>
												Sign any document on my/our behalf or in my/our name for purchase, sale, or redemption of units; or
												</li>
												<li>
												Collect, receive, and/or give receipts and discharges for any sum including dividend, interest, or income arising from the units, and does not sign and/or endorse dividend and interest warrants on my/our behalf or in my/our name;or
												</li>
												<li>
												Correspond with, or gives notice to the mutual fund/AMCs on my/our behalf, or in my/our name, except for transmission of transactions done or purported to be done by me/us on the online technology platform.
												</li>
											</ol>
											<p>
											I/We understand and acknowledge that MoneyBuddy does not offer any investment advice, and nothing contained herein or on the online platforms of MoneyBuddy or communicated by MoneyBuddy in any form, shall be construed as investment advice.
											</p>
											<p>
											I/We understand that any sum invested through MoneyBuddy&apos;s Investment Account is not a deposit with MoneyBuddy and is not bank insured. The same is not endorsed or guaranteed, and does not constitute obligations of MoneyBuddy or any of the subsidiaries associates or affiliates companies whose role in only as described in these Terms & Conditions. Investments in mutual fund are subject to investment risk, including the possible loss of principal amount invested. The value of my/our units will fluctuate. If I/we redeem my units/shares, I/we may receive more or less than
											</p>
											<p>
											I/we paid depending upon NAV of the units in the fund or trust at the time of redemption. Past results are not a guarantee to future performance. Past performance may or may not be sustained in the future.
											</p>
										</li>
										<li>
											<p><b>Correspondence</b></p>
											<p>
											Any notice or other correspondence addressed by MoneyBuddy to me/us may be addressed to the first holder at the address given by me/us, or as may be intimated from time to time. If according to me/us, there is any discrepancy in the particular or details of my transaction or Account statement, then I/we shall be obliged to intimate the same to MoneyBuddy, and to the concerned mutual fund/AMC/authorised registrar of the AMC in writing within 7 (seven) working days of the first holder receiving notice thereof, failing which such transaction, statement or account (as the case may be) shall be deemed to be correct and accepted by me/us, and I/we shall not be entitled to question the correctness or accuracy thereof.
											</p>
										</li>
										<li>
											<p><b>Customer Information</b></p>
											<p>
											I/We agree to provide any and all information that may be required by MoneyBuddy/BSE/AMC/authorised service providers of the AMC from time to time in compliance with existing legal norms and regulations, including but not limited to contact information, address and tax&#45;related information, and any information required under existing or future KYC norms and laws. I/We agree that MoneyBuddy/BSE/AMC/authorized service providers of the AMC may take steps to verify the veracity of such information provided by me/us, and I/we agree to cooperate with MoneyBuddy/BSE/AMC/authorized service providers of the AMC in providing all information requested by MoneyBuddy. I/We acknowledge that failure to provide such information in a timely manner may result in my/our ineligibility to avail of some, or all of the services of MoneyBuddy, and that MoneyBuddy/BSE/AMC/Trustees of AMC shall in no way be held liable for any losses of whatsoever nature resulting from such failure to provide information on my/our part. I/We agree that any information provided by me/us may be required to be shared with relevant regulatory / statutory authorities and I/we authorise MoneyBuddy to provide all information to such regulatory / statutory authorities as and when required.
											</p>
										</li>
										<li>
											<p><b>Termination</b></p>
											<p>
											MoneyBuddy may terminate its Services by giving 30 days&apos; prior notice in writing to the Registered Customer, provided that the Registered Customer shall not be relieved of obligations hereunder notwithstanding such termination incurred prior to the date on which such termination shall  become effective.
											</p>
										</li>
										<li>
											<p><b>Governing Law and Jurisdiction Clause</b></p>
											<p>
											All disputes and differences arising out of, under, or in connection with these Terms & Conditions, or anything done hereunder, shall be within the exclusive jurisdiction of the courts of Pune. These Terms & Conditions are subject to and shall be construed in accordance with the laws prevalent in India.
											</p>
										</li>
									</ol>
									<p><b>Questions?</b></p>
									<p>
									Please contact us for any queries wrt our T&Cs.
									</p>
									<p>
									<b><u>Please Note:</u></b> Our Terms and Conditions are subject to change without further notice. Users are requested to refer to the latest version available on our website for up to date information.
									</p>

	                    		</div>
	                    		
	                    		
	                    		
	                		</div>
	                	</div> 
	                
	                	
	                
	             </div>
                </div>
            </div>
        </div>
        
        <!--========== END PROMO BLOCK ==========-->

        <!--========== END PAGE CONTENT ==========-->

        <!--========== FOOTER ==========-->
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
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>

       
	</div>
    </body>
     <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
        <!-- Vendor -->
        <%-- <script>
         document.onreadystatechange = function () {
			  var state = document.readyState
			  if (state == 'interactive') {
			       document.getElementById('contents').style.visibility="hidden";
			  } else if (state == 'complete') {
			      setTimeout(function(){
			         document.getElementById('interactive');
			         document.getElementById('load').style.visibility="hidden";
			         document.getElementById('contents').style.visibility="visible";
			      },1000);
			  }
			}
         </script> --%>
         
         <script type="text/javascript" src="assets/js/javaScript.js"></script>
		<script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
		<script src="assets/js/jquery.js"></script>
	    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    
       	<%-- <script type="text/javascript" src="vendor/jquery.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.migrate.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.smooth-scroll.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.back-to-top.min.js"></script>
        <script type="text/javascript" src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
        <script type="text/javascript" src="vendor/jquery.parallax.min.js"></script>
        <script type="text/javascript" src="vendor/cubeportfolio/js/jquery.cubeportfolio.min.js"></script> --%>
        <%-- <script type="text/javascript" src="assets/js/javaScript.js"></script> --%>

        <!-- General Components and Settings -->
        <%-- <script type="text/javascript" src="js/global.min.js"></script>
        <script type="text/javascript" src="js/components/header-sticky.min.js"></script>
        <script type="text/javascript" src="js/components/scrollbar.min.js"></script>
        <script type="text/javascript" src="js/components/faq.min.js"></script> --%>
        <!--========== END JAVASCRIPTS ==========-->
    <!-- End Body -->
</html>
