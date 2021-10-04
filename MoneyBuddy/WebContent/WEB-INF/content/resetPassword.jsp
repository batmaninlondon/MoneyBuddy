<%@page import="com.myMoneyBuddy.DAOClasses.QueryCustomer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <!-- Begin Head -->
    <head>
        <!-- Basic -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MoneyBuddy - Reset Password</title>
       	<meta http-equiv="Cache-control" content="max-age=2592000, public">
		<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
        
        <!-- Theme Styles -->
        <link href="assets/css/themify/themify.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/global/global.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" rel="stylesheet" href="assets/css/style2.css">

        <script src="https://www.google.com/recaptcha/api.js?onload=myCallBack&render=explicit" async defer></script>

    <script>

    
    function showAlert()   {
    	
    	var newPswd = document.getElementById("new-password");
		 var confirmPswd = document.getElementById("confirm-password");
		 
		 var invalid =  (newPswd.value == "") ||
		 			(!new RegExp(newPswd.getAttribute("pattern")).test(newPswd.value)) ||
		 			(!(newPswd.value == confirmPswd.value));
		 
		 if ( invalid )  {
				if ( newPswd.value == "" )  {
					alert('Password can not be blankk ');
					return false;
				}
				else if ( !new RegExp(newPswd.getAttribute("pattern")).test(newPswd.value)) {
					alert('Password must contain at least 8 characters ');
					return false;
				}
				else if ( !(newPswd.value == confirmPswd.value)) {
					alert('Passwords must match.');
					return false;
				}
		 }
		 else {
			 alert('Your password has been successfully reset ! ');
			 document.getElementById("new-pswd").value = newPswd.value;

			 document.formResetPassword.submit(); 
		 }
		 
		 
    }
</script>


    </head>
    <!-- End Head -->

    <!-- Body -->
    <body>

       <!-- <div id="load" class="load"></div> -->
	<div id="content">
    <!--========== HEADER ==========-->
        <header class="navbar-fixed-top s-header-v2 js__header-sticky">
            <!-- Navbar -->
            <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="welcome"><img src="img/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="s-header-v2__nav">
                       	<li class="s-header-v2__nav-item"><a href="welcome" class="s-header-v2__nav-link">Home</a></li>
                   	</ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
            <!-- End Navbar -->
        </header>
        <!--========== END HEADER ==========-->
        <div class="g-bg-color--dark">
         
            <div class=" g-text-center--xs g-padding-y-80--xs g-margin-l-150--lg g-margin-r-150--lg">
            <br/><br/>
                <div class="g-margin-b-10--xs">
                    <div  id="contents" class="row" style="padding: 0px;" >
	              		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-40--xs g-margin-b-10--lg  g-bg-color--white g-box-shadow__dark-lightest-v4" >
	              			<div class="g-text-center--xs g-margin-b-40--xs">
	                    		<%
							   	    String hashedPassword = (String)request.getParameter("Hp");
								    System.out.println("hello from  jsp : value of hashedPassword : "+hashedPassword);
								    QueryCustomer queryCustomer = new QueryCustomer();
								    String emailId = queryCustomer.getEmailId(hashedPassword);
								%>	
								<%
									if ( !"NotExist".equals(emailId))  {
								%>
								<h3 class="text-center g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs"><b>Reset Password</b></h3>
	                    		<div class="g-color--text g-font-family--playfair g-letter-spacing--1" style=" text-align: justify; height : 300px; overflow : auto;" >
	                    		
                
                <s:form  action="resetPasswordAction" method="post" name="formResetPassword" namespace="/">
				<s:set var="cusEmailId" ><%=emailId%></s:set>
				<s:set var="cusPswd" ><%=hashedPassword%></s:set>
				<s:hidden id="email-id" name="emailId" value="%{#cusEmailId}" />
				<s:hidden id="hashed-password" name="hashedPassword" value="%{#cusPswd}" />
				<s:hidden id="new-pswd" name="newPassword" />
                </s:form>
                <div id="reset-password-form" class="center-block g-width-500--sm g-width-550--md" >
					<div class="g-margin-b-20--xs">
						<s:actionmessage class="small-text"/> 
                        
                    </div>
                    <div class="g-margin-t-100--xs">
			  			<s:password class="form-control " id="new-password" pattern=".{8}$" placeholder="* Password" /> 
                    </div>
                    <div class="g-margin-t-10--xs">
			  			<s:password class="form-control" id="confirm-password" placeholder="* Confirm Password" />
                    </div>
                    <br/>
                    
                    <div class="g-text-center--xs">
                    	<s:submit class="text-uppercase btn btn-home g-margin-b-20--xs" onClick="showAlert();" value="RESET PASSWORD"  />
                        
                    </div>
                    
                   
                </div>
                
                
                
                <%
									}
									else {
										
									
                %>
                	<h3 class="text-center g-font-size-20--xs g-font-size-32--md g-font-family--playfair g-letter-spacing--1 g-color--dark text-left font-weight-bold   g-margin-t-20--xs"><b>Link has expired</b></h3>
                	<%
									}
                	%>
	                    		</div>
	                    		
	                    		
	                    		
	                		</div>
	                	</div> 
	                
	                	
	                
	             </div>
                </div>
            </div>
        </div>

        <!--========== FOOTER ==========-->
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
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="s-back-to-top js__back-to-top"></a>

        
	</div>
    </body>
    <!--========== JAVASCRIPTS (Load javascripts at bottom, this will reduce page load time) ==========-->
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

		<script src="assets/js/jquery.js"></script>
    	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <!-- General Components and Settings -->
        <script type="text/javascript" src="assets/js/header-sticky.min.js"></script>
        <!--========== END JAVASCRIPTS ==========-->
    <!-- End Body -->
</html>
