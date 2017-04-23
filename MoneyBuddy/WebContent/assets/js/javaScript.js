

$(document).ready(function(){

	
/*$('img.bgfade').hide();*/
var dg_H = $(window).height();
var dg_W = $(window).width();
$('#wrap').css({'height':dg_H,'width':dg_W});
function anim() {
    $("#wrap img.bgfade").first().appendTo('#wrap').fadeOut(3000);
    $("#wrap img").first().fadeIn(3000);
    setTimeout(anim, 6000);
}
anim();

/*  $("#footer").load("footer.html");*/

});

function getURLParameter(name) {
	  return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
	}

function showUpfrontInvestment(newValue)
{
document.getElementById("upfrontInvestment").innerHTML=newValue;
update();
}

function showSipPerMonth(newValue)
{

document.getElementById("sipPerMonth").innerHTML=newValue;
update();
}

function showYears(newValue)
{
document.getElementById("years").innerHTML=newValue;
update();

}
function showPlan()
{
	/*alert('showPLan function called !! ');*/
	
	var riskCategory = document.querySelector('input[name="riskCategory"]:checked').value;;
	
	/*alert('showPLan function riskCategory :'+riskCategory );*/
	
    $.ajax({
        url : "productListAction",
        type: 'post',
        
        data: { 'riskCategory' : riskCategory },

        success : function(result){
        	
        	if (result == "success") {
        	
	        	document.getElementById('investment-options').style.display ='none';
	        	document.getElementById('invested-fund-list').style.display ='block';
	        	document.getElementById("submit-button-1").disabled = true;
	        	
	        	$("#invested-fund-list").load("upfrontInvestment.jsp #invested-fund-list");
        	}

        }
    });
}

function forgottenPassword()
{
	alert('forgottenPassword function called !! ');
	
	var emailId = document.getElementById("email-id").value;
	
	alert('forgottenPassword function emailId :'+emailId );
	
	if ( emailId == '')  {
		
		document.getElementById("email-id").className += " formInvalid";
		document.getElementById("email-id").placeholder = "Email Id can not be blank!";
		
		return;
	}
	else if (!validateEmail(emailId)) {
		document.getElementById("email-id").className += " formInvalid";
		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + " - Not a valid Email Id ";
		document.getElementById("email-id").value = null;
		return;
	}

    $.ajax({
        url : "ForgottenPasswordAction",
        type: 'post',
        
        data: { 'emailId' : emailId },

        success : function(result){
        	
        	if (result == "success") {
        		window.location='/MoneyBuddy/thankYouForPasswordReset';
        	}
        	else if (result == "verificationNotDone")  {
        		document.getElementById("email-id").className += " formInvalid";
        		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + "Verification pending for this Email Id ";
        		document.getElementById("email-id").value = null;
        	}
        	else if (result == "emailIdDoesNotExists")  {
        		document.getElementById("email-id").className += " formInvalid";
        		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + " is not registered with MoneyBuddy";
        		document.getElementById("email-id").value = null;
        	}
        	else {
        		alert('Inside newLogin error !!');
        		window.location='/MoneyBuddy/errorPage';
        	}

        }
    });
}

function checkKysStatus()
{
	/*alert('checkKysStatus function called !! ');*/
	
	var panCard = document.getElementById("pancard-number").value;
	if ( panCard == '')  {
		document.getElementById("pancard-number").className += " formInvalid";
		document.getElementById("pancard-number").placeholder = "Pan Card Number can not be blank ";
		return;
	}
	else if (!validatePanCard(panCard)) {
		document.getElementById("pancard-number").className += " formInvalid";
		document.getElementById("pancard-number").placeholder = document.getElementById("pancard-number").value + " - is not a valid Pan Card Number ";
		document.getElementById("pancard-number").value = null;
		return;
	}
	
	/*alert('checkKysStatus function panCard :'+panCard);*/
	
    $.ajax({
      	
        url : "kycCheckAction",
        type: 'post',
        
        data: { 'panCard' : panCard },

        success : function(result){

        	/*alert('Inside Success ');*/
        	/*alert('result : '+result);*/
        	
        	if (result == "invalid") {
        		document.getElementById("pancard-number").className += " formInvalid";
        		document.getElementById("pancard-number").placeholder = document.getElementById("pancard-number").value + " - is not a valid Pan Card Number ";
        		document.getElementById("pancard-number").value = null;
        	} 
        	else if (result == "kycNotDone")  {
        		/*alert('KYC not done for this pan card !! ');*/
        		window.location='/MoneyBuddy/kycNotDone';
        	}
        	else if (result == "success") {
        		/*alert('Inside kycCheck success !! ');*/
        		window.location='/MoneyBuddy/clientDetails';
        	}	
        	else {
        		/*alert('Inside kycCheck error !! ');*/
        		window.location='/MoneyBuddy/errorPage';
        	}
        },

    });
    

	
}

function checkDetails()
{
	/*alert('checkDetails function called !!');*/
	
	var clientHolding = document.getElementById("client-holding").value;
	var taxStatus = document.getElementById("tax-status").value;
	var occupationName = document.getElementById("occupation-name").value;
	var genderType = document.getElementById("gender-type").value;
	var dateOfBirth = document.getElementById("date-of-birth").value;
	var accountType = document.getElementById("account-type").value;
	var residentialAddress = document.getElementById("residential-address").value;
	
	var accountNumber = document.getElementById("account-number").value;
	var residentialCity = document.getElementById("residential-city").value;
	var neftCode = document.getElementById("neft-code").value;
	var residentialState = document.getElementById("residential-state").value;
	var residentialPin = document.getElementById("residential-pin").value;
	var residentialCountry = document.getElementById("residential-country").value;
	var groupName = document.getElementById("group-name").value;
	
	/*alert('payment function clientHolding :'+clientHolding);*/
	
	if ( accountNumber == '')  {
		document.getElementById("account-number").className += " formInvalid";
		document.getElementById("account-number").placeholder = "Acc No can not be blank!";
		document.getElementById("residential-address").className = "form-control";
		document.getElementById("residential-address").placeholder = "Enter Residential Address ";
		document.getElementById("residential-city").className = "form-control";
		document.getElementById("residential-city").placeholder = "Enter City ";
		document.getElementById("neft-code").className = "form-control";
		document.getElementById("neft-code").placeholder = "Enter NEFT Code ";
		document.getElementById("group-name").className = "form-control";
		document.getElementById("group-name").placeholder = "Group Name ";
		document.getElementById("residential-pin").className = "form-control";
		document.getElementById("residential-pin").placeholder = "Enter Pin ";
		return;
	}
	else if ( neftCode == '')  {
		document.getElementById("neft-code").className += " formInvalid";
		document.getElementById("neft-code").placeholder = "NEFT can\'t be blank!";
		document.getElementById("residential-address").className = "form-control";
		document.getElementById("residential-address").placeholder = "Enter Residential Address ";
		document.getElementById("residential-city").className = "form-control";
		document.getElementById("residential-city").placeholder = "Enter City ";
		document.getElementById("account-number").className = "form-control";
		document.getElementById("account-number").placeholder = "Enter Account Number ";
		document.getElementById("group-name").className = "form-control";
		document.getElementById("group-name").placeholder = "Group Name ";
		document.getElementById("residential-pin").className = "form-control";
		document.getElementById("residential-pin").placeholder = "Enter Pin ";
		return;
	}
	else if (!validateNEFT(neftCode)) {
		document.getElementById("neft-code").className += " formInvalid";
		document.getElementById("neft-code").placeholder = document.getElementById("neft-code").value + " - is not a valid NEFT";
		document.getElementById("neft-code").value = null;
		document.getElementById("residential-address").className = "form-control";
		document.getElementById("residential-address").placeholder = "Enter Residential Address ";
		document.getElementById("residential-city").className = "form-control";
		document.getElementById("residential-city").placeholder = "Enter City ";
		document.getElementById("account-number").className = "form-control";
		document.getElementById("account-number").placeholder = "Enter Account Number ";
		document.getElementById("group-name").className = "form-control";
		document.getElementById("group-name").placeholder = "Group Name ";
		document.getElementById("residential-pin").className = "form-control";
		document.getElementById("residential-pin").placeholder = "Enter Pin ";
		return;
	}
	else if ( groupName == '')  {
		document.getElementById("group-name").className += " formInvalid";
		document.getElementById("group-name").placeholder = "GrpName can\'t be blank!";
		document.getElementById("residential-address").className = "form-control";
		document.getElementById("residential-address").placeholder = "Enter Residential Address ";
		document.getElementById("residential-city").className = "form-control";
		document.getElementById("residential-city").placeholder = "Enter City ";
		document.getElementById("account-number").className = "form-control";
		document.getElementById("account-number").placeholder = "Enter Account Number ";
		document.getElementById("neft-code").className = "form-control";
		document.getElementById("neft-code").placeholder = "Enter NEFT Code ";
		document.getElementById("residential-pin").className = "form-control";
		document.getElementById("residential-pin").placeholder = "Enter Pin ";
		return;
	}
	else if ( residentialAddress == '')  {
		document.getElementById("residential-address").className += " formInvalid";
		document.getElementById("residential-address").placeholder = "Address can not be blank!";
		document.getElementById("residential-city").className = "form-control";
		document.getElementById("residential-city").placeholder = "Enter City ";
		document.getElementById("account-number").className = "form-control";
		document.getElementById("account-number").placeholder = "Enter Account Number ";
		document.getElementById("neft-code").className = "form-control";
		document.getElementById("neft-code").placeholder = "Enter NEFT Code ";
		document.getElementById("group-name").className = "form-control";
		document.getElementById("group-name").placeholder = "Group Name ";
		document.getElementById("residential-pin").className = "form-control";
		document.getElementById("residential-pin").placeholder = "Enter Pin ";
		return;
	}
	else if ( residentialCity == '')  {
		document.getElementById("residential-city").className += " formInvalid";
		document.getElementById("residential-city").placeholder = "City can not be blank!";
		document.getElementById("residential-address").className = "form-control";
		document.getElementById("residential-address").placeholder = "Enter Residential Address ";
		document.getElementById("account-number").className = "form-control";
		document.getElementById("account-number").placeholder = "Enter Account Number ";
		document.getElementById("neft-code").className = "form-control";
		document.getElementById("neft-code").placeholder = "Enter NEFT Code ";
		document.getElementById("group-name").className = "form-control";
		document.getElementById("group-name").placeholder = "Group Name ";
		document.getElementById("residential-pin").className = "form-control";
		document.getElementById("residential-pin").placeholder = "Enter Pin ";
		return;
	}
	else if ( residentialPin == '')  {
		document.getElementById("residential-pin").className += " formInvalid";
		document.getElementById("residential-pin").placeholder = "Pin can\'t be blank!";
		document.getElementById("residential-address").className = "form-control";
		document.getElementById("residential-address").placeholder = "Enter Residential Address ";
		document.getElementById("residential-city").className = "form-control";
		document.getElementById("residential-city").placeholder = "Enter City ";
		document.getElementById("account-number").className = "form-control";
		document.getElementById("account-number").placeholder = "Enter Account Number ";
		document.getElementById("neft-code").className = "form-control";
		document.getElementById("neft-code").placeholder = "Enter NEFT Code ";
		document.getElementById("group-name").className = "form-control";
		document.getElementById("group-name").placeholder = "Group Name ";
		return;
	}
	
    $.ajax({
      	
        url : "paymentAction",
        type: 'post',
        
        data: { 'clientHolding' : clientHolding,'taxStatus' : taxStatus,'occupationName' : occupationName,'genderType' : genderType,'dateOfBirth' : dateOfBirth ,'accountType' : accountType,'residentialAddress' : residentialAddress,'accountNumber' : accountNumber,'residentialCity' : residentialCity,'neftCode' : neftCode,'residentialState' : residentialState,'residentialPin' : residentialPin,'residentialCountry' : residentialCountry,'groupName' : groupName },

        success : function(result){

        	/*alert('Inside Success ');
        	alert('result : '+result);*/
        	
        	if (result.startsWith("success")) {
        		
        		/*var paymentUrl1 = document.getElementById("payment-url1").value;
        		alert('paymentUrl1 is : '+paymentUrl1);

        		$("#payment-url-div").load("clientDetails.jsp #payment-url-div"); 
        		$("#payment-url").load("clientDetails.jsp #payment-url");
        		
        		var paymentUrl = document.getElementById("payment-url").value;*/
        		
        		var paymentUrl = result.substring(8);
        		
        		/*alert (' result : ' + result);
        		alert (' Fetching paymentUrl from result : ' + paymentUrl);*/
	
        		window.location=paymentUrl;
        	}
        	else if (result == "groupNameAlreadyExists")  {
        		document.getElementById("group-name").className += " formInvalid";
        		document.getElementById("group-name").placeholder = document.getElementById("group-name").value + "Group Name already exist!";
        		document.getElementById("group-name").value = null;
        		document.getElementById("residential-address").className = "form-control";
        		document.getElementById("residential-address").placeholder = "Enter Residential Address ";
        		document.getElementById("residential-city").className = "form-control";
        		document.getElementById("residential-city").placeholder = "Enter City ";
        		document.getElementById("account-number").className = "form-control";
        		document.getElementById("account-number").placeholder = "Enter Account Number ";
        		document.getElementById("neft-code").className = "form-control";
        		document.getElementById("neft-code").placeholder = "Enter NEFT Code ";
        		document.getElementById("residential-pin").className = "form-control";
        		document.getElementById("residential-pin").placeholder = "Enter Pin ";
        		return;
        	}
        	else if (result == "paymentFailure") {

        		window.location='/MoneyBuddy/paymentFailure';
        	}
        	else {
        		/*alert('Inside checkDetails error !! ');*/
        		window.location='/MoneyBuddy/errorPage';
        	}
        },
    });
}

function setType() 
{

	document.getElementById('diamond-text-2').style.display ='none';
	document.getElementById('diamond-text-3').style.display ='none';
	document.getElementById('diamond-text-4').style.display ='none';
	document.getElementById('diamond-text-5').style.display ='none';
	document.getElementById('diamond-text-6').style.display ='none';
	document.getElementById('diamond-text-7').style.display ='none';
	document.getElementById('diamond-text-8').style.display ='none';
	document.getElementById('diamond-text-9').style.display ='none';
	document.getElementById('diamond-text-10').style.display ='none';

	document.getElementById("submit-button-1").disabled = false;
	document.getElementById('submit-button-1').style.display ='none';
	document.getElementById('invested-fund-list').style.display ='none';
	document.getElementById('pancard-verification').style.display ='none';
	document.getElementById('payment-page').style.display ='none';
	document.getElementById('login-page').style.display ='none';

/*	document.getElementById("years").innerHTML= '5';
	document.getElementById("sipPerMonth").innerHTML = '2000';
	document.getElementById("upfrontInvestment").innerHTML = '10000'; */

	document.getElementById("submit-button-2").disabled = false;
	document.getElementById("submit-button-3").disabled = false;
	document.getElementById("forgot-password-submit-button").disabled = false;

	
	var type = getURLParameter('type');
	
	if (type == "ONE_TIME")  {

		document.getElementById("years").innerHTML= '5';
		document.getElementById("sipPerMonth").innerHTML = '0';
		document.getElementById("upfrontInvestment").innerHTML = '10000'; 
		
		document.getElementById('sip-text').style.display ='none';
		document.getElementById('sip-value').style.display ='none';
	}
	
	else {
		document.getElementById("years").innerHTML= '5';
		document.getElementById("sipPerMonth").innerHTML = '2000';
		document.getElementById("upfrontInvestment").innerHTML = '0'; 
		
		document.getElementById('upfront-text').style.display ='none';
		document.getElementById('upfront-value').style.display ='none';
		document.getElementById('duration-text').style.display ='none';
		document.getElementById('duration-value').style.display ='none';
	}
}

function resetPassword() {

	var emailId = document.getElementById("email-id").value;
	var hashedPassword = document.getElementById("hashed-password").value;
	var newPassword = document.getElementById("new-password").value;
	var confirmPassword = document.getElementById("confirm-password").value;
	
	if ( newPassword == '')  {
		document.getElementById("new-password").className += " formInvalid";
		document.getElementById("new-password").placeholder = "Password can not be blank!";
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		return;
	}
	else if ( !validatePassword(newPassword) )  {
		alert('newPassword : '+newPassword);
		document.getElementById("new-password").className += " formInvalid";
		document.getElementById("new-password").placeholder = "Password shall contain min 8 charcters";
		document.getElementById("new-password").value = null;
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		return;
	}
	else if ( confirmPassword == '')  {
		document.getElementById("confirm-password").className += " formInvalid";
		document.getElementById("confirm-password").placeholder = "Confirm Password can not be blank!";
		document.getElementById("new-password").className = "form-control";
		document.getElementById("new-password").placeholder = "Password";
		return;
	}
	else if ( !comparePasswords(newPassword,confirmPassword) )  {
		document.getElementById("confirm-password").className += " formInvalid";
		document.getElementById("confirm-password").placeholder = "Password and Confirm Password shall be same";
		document.getElementById("confirm-password").value = null;
		document.getElementById("new-password").className = "form-control";
		document.getElementById("new-password").placeholder = "Password";
		return;
	}
	
	$.ajax({

	        url : "resetPasswordAction",
	        type: 'post',

	        data: {'emailId' : emailId , 'hashedPassword' : hashedPassword , 'newPassword' : newPassword , 'confirmPassword' : confirmPassword},
	        
	        success : function(result){
	        	
	        	if (result == "success") {
	        		window.location='/MoneyBuddy/login';
	        	}
	        	else {
	        		alert('Inside resetPassword error !!');
	        		window.location='/MoneyBuddy/errorPage';
	        	}

	        },

	    });
}

function showPanCardVerification()
{
	/*alert('showPanCardVerification function called !! ');*/
	var cusId = document.getElementById('cusId').value;
	/*alert('showPanCardVerification : cusId : '+cusId);*/
	if (cusId == "customerIdNull") {
		/*alert('Inside showPanCardVerification customerIdNotExist !! ');*/
		document.getElementById('invested-fund-list').style.display ='none';	
		document.getElementById('login-page').style.display ='block';
	} 
	else  {
		/*alert('Inside showPanCardVerification customerIdExist !! ');*/
		document.getElementById('invested-fund-list').style.display ='none';	
		document.getElementById('pancard-verification').style.display ='block';
	}
	
/*	var fundChoice = "UserChoice";
    $.ajax({
      	
        url : "panCardVerification",
        type: 'post',
        
        data: {'fundChoice' : fundChoice },
        
        success : function(result){
        	alert('Inside showPanCardVerification Success ');
        	alert('result : '+result);
        	if (result == "customerIdNotExist") {
        		alert('Inside showPanCardVerification customerIdNotExist !! ');
        		document.getElementById('invested-fund-list').style.display ='none';	
        		document.getElementById('login-page').style.display ='block';
        	} 
        	else if (result == "customerIdExist") {
        		alert('Inside showPanCardVerification customerIdExist !! ');
        		document.getElementById('invested-fund-list').style.display ='none';	
        		document.getElementById('pancard-verification').style.display ='block';
        	}
        	else {
        		alert('Inside showPanCardVerification error !! ');
        		window.location='/MoneyBuddy/errorPage.jsp';
        	}	
    
        }
    });*/
    	
}

function newLogin() {	
	var emailId = document.getElementById("email-id").value;
	var password = document.getElementById("password").value;

	if ( emailId == '')  {
		document.getElementById("email-id").className += " formInvalid";
		document.getElementById("email-id").placeholder = "Email Id can not be blank!";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Enter Password ";
		return;
	}
	else if (!validateEmail(emailId)) {
		document.getElementById("email-id").className += " formInvalid";
		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + " - Not a valid Email Id ";
		document.getElementById("email-id").value = null;
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Enter Password ";
		return;
	}
	else if ( password == '') {
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Enter Email Id ";
		document.getElementById("password").className += " formInvalid";
		document.getElementById("password").placeholder = "Password can not be blank!";
		return;
	}
    $.ajax({

        url : "newLoginAction",
        type: 'post',
        
        data: {'emailId' : emailId , 'password' : password},
        
        success : function(result){
        	
        	if (result == "success") {
        		document.getElementById('login-page').style.display ='none';	
        		document.getElementById('pancard-verification').style.display ='block';
        	}
        	else if (result == "verificationNotDone")  {
        		document.getElementById("email-id").className += " formInvalid";
        		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + "Verification pending for this Email Id ";
        		document.getElementById("email-id").value = null;
        		document.getElementById("password").className = "form-control";
        		document.getElementById("password").placeholder = "Enter Password ";
        	}
        	else if (result == "emailIdDoesNotExists")  {
        		document.getElementById("email-id").className += " formInvalid";
        		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + " is not registered with MoneyBuddy";
        		document.getElementById("email-id").value = null;
        		document.getElementById("password").className = "form-control";
        		document.getElementById("password").placeholder = "Enter Password ";
        	}
        	else if (result == "incorrectPassword")  {
        		document.getElementById("email-id").className = "form-control";
        		document.getElementById("email-id").placeholder = "Enter Email Id ";
        		document.getElementById("password").className += " formInvalid";
        		document.getElementById("password").placeholder = "Incorrect Password";
        		document.getElementById("password").value = null;
        	}
        	else {
        		alert('Inside newLogin error !!');
        		window.location='/MoneyBuddy/errorPage';
        	}
        	
        		

        },

    });
	
}

function signUp(){
	window.location='/MoneyBuddy/register';
	
}

function login() {
	
	var emailId = document.getElementById("email-id").value;
	var password = document.getElementById("password").value;
	
	if ( emailId == '')  {
		
		document.getElementById("email-id").className += " formInvalid";
		document.getElementById("email-id").placeholder = "Email Id can not be blank!";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		return;
	}
	else if (!validateEmail(emailId)) {
		document.getElementById("email-id").className += " formInvalid";
		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + " - Not a valid Email Id ";
		document.getElementById("email-id").value = null;
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		return;
	}
	else if ( password == '') {
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Email";
		document.getElementById("password").className += " formInvalid";
		document.getElementById("password").placeholder = "Password can not be blank!";
		return;
	}
	
	$.ajax({

        url : "newLoginAction",
        type: 'post',
        
        data: {'emailId' : emailId , 'password' : password},
        
        success : function(result){
        	
        	if (result == "success") {
        		/*alert('login success !! ');*/
        		window.location='/MoneyBuddy/myIndex';
        	}
        	else if (result == "verificationNotDone")  {
        		document.getElementById("email-id").className += " formInvalid";
        		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + "Verification pending for this Email Id ";
        		document.getElementById("email-id").value = null;
        		document.getElementById("password").className = "form-control";
        		document.getElementById("password").placeholder = "Password";
        	}
        	else if (result == "emailIdDoesNotExists")  {
        		document.getElementById("email-id").className += " formInvalid";
        		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + " is not registered with MoneyBuddy";
        		document.getElementById("email-id").value = null;
        		document.getElementById("password").className = "form-control";
        		document.getElementById("password").placeholder = "Password";
        	}
        	else if (result == "incorrectPassword")  {
        		document.getElementById("email-id").className = "form-control";
        		document.getElementById("email-id").placeholder = "Email";
        		document.getElementById("password").className += " formInvalid";
        		document.getElementById("password").placeholder = "Incorrect Password";
        		document.getElementById("password").value = null;
        	}
        	else {
        		alert('Inside newLogin error !!');
        		window.location='/MoneyBuddy/errorPage';
        	}

        },
    });	
}

function register() {
	
	/*alert('register function called !! ');*/
    
	var firstName = document.getElementById("first-name").value;
	var lastName = document.getElementById("last-name").value;
	var emailId = document.getElementById("email-id").value;
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirm-password").value;
	var mobileNumber = document.getElementById("mobile-number").value;
	
	if ( firstName == '')  {
		
		document.getElementById("first-name").className += " formInvalid";
		document.getElementById("first-name").placeholder = "First Name can not be blank!";
		document.getElementById("last-name").className = "form-control";
		document.getElementById("last-name").placeholder = "Last Name";
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Email ID";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( lastName == '')  {
		
		document.getElementById("last-name").className += " formInvalid";
		document.getElementById("last-name").placeholder = "Last Name can not be blank!";
		document.getElementById("first-name").className = "form-control";
		document.getElementById("first-name").placeholder = "First Name";
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Email ID";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( emailId == '')  {
		
		document.getElementById("email-id").className += " formInvalid";
		document.getElementById("email-id").placeholder = "Email Id can not be blank!";
		document.getElementById("first-name").className = "form-control";
		document.getElementById("first-name").placeholder = "First Name";
		document.getElementById("last-name").className = "form-control";
		document.getElementById("last-name").placeholder = "Last Name";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( !validateEmail(emailId) )  {
		
		document.getElementById("email-id").className += " formInvalid";
		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + " - Not a valid Email Id";
		document.getElementById("email-id").value = null;
		document.getElementById("first-name").className = "form-control";
		document.getElementById("first-name").placeholder = "First Name";
		document.getElementById("last-name").className = "form-control";
		document.getElementById("last-name").placeholder = "Last Name";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( password == '')  {
	
		document.getElementById("password").className += " formInvalid";
		document.getElementById("password").placeholder = "Password can not be blank!";
		document.getElementById("first-name").className = "form-control";
		document.getElementById("first-name").placeholder = "First Name";
		document.getElementById("last-name").className = "form-control";
		document.getElementById("last-name").placeholder = "Last Name";
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Email ID";
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( !validatePassword(password))  {
	
		document.getElementById("password").className += " formInvalid";
		document.getElementById("password").placeholder = "Password shall contain min 8 charcters";
		document.getElementById("password").value = null;
		document.getElementById("first-name").className = "form-control";
		document.getElementById("first-name").placeholder = "First Name";
		document.getElementById("last-name").className = "form-control";
		document.getElementById("last-name").placeholder = "Last Name";
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Email ID";
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( confirmPassword == '')  {
		
		document.getElementById("confirm-password").className += " formInvalid";
		document.getElementById("confirm-password").placeholder = "Password can not be blank!";
		document.getElementById("first-name").className = "form-control";
		document.getElementById("first-name").placeholder = "First Name";
		document.getElementById("last-name").className = "form-control";
		document.getElementById("last-name").placeholder = "Last Name";
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Email ID";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( !comparePasswords(password,confirmPassword) )  {
		
		document.getElementById("confirm-password").className += " formInvalid";
		document.getElementById("confirm-password").placeholder = "Password and Confirm Password shall be same";
		document.getElementById("confirm-password").value = null;
		document.getElementById("first-name").className = "form-control";
		document.getElementById("first-name").placeholder = "First Name";
		document.getElementById("last-name").className = "form-control";
		document.getElementById("last-name").placeholder = "Last Name";
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Email ID";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( mobileNumber == '')  {
		
		document.getElementById("mobile-number").className += " formInvalid";
		document.getElementById("mobile-number").placeholder = "Mobile Number can not be blank!";
		document.getElementById("first-name").className = "form-control";
		document.getElementById("first-name").placeholder = "First Name";
		document.getElementById("last-name").className = "form-control";
		document.getElementById("last-name").placeholder = "Last Name";
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Email ID";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		return;
	}
	else if ( !validateMobileNumber(mobileNumber))  {
		
		document.getElementById("mobile-number").className += " formInvalid";
		document.getElementById("mobile-number").placeholder = document.getElementById("mobile-number").value + " - Not a valid mobile number";
		document.getElementById("mobile-number").value = null;
		document.getElementById("first-name").className = "form-control";
		document.getElementById("first-name").placeholder = "First Name";
		document.getElementById("last-name").className = "form-control";
		document.getElementById("last-name").placeholder = "Last Name";
		document.getElementById("email-id").className = "form-control";
		document.getElementById("email-id").placeholder = "Email ID";
		document.getElementById("password").className = "form-control";
		document.getElementById("password").placeholder = "Password";
		document.getElementById("confirm-password").className = "form-control";
		document.getElementById("confirm-password").placeholder = "Confirm Password";
		return;
	}
	
	/*alert('emailId : '+emailId);*/
	
    $.ajax({
      	
        url : "registerAction",
        type: 'post',
        
        data: {'firstName' : firstName , 'lastName' : lastName, 'emailId' : emailId, 'password' : password, 'confirmPassword' : confirmPassword, 'mobileNumber' : mobileNumber},
        
        success : function(result){
        	if (result == "success") {
        		window.location='/MoneyBuddy/thankYouForRegistration';
        	}
        	else if (result == "UserAlreadyExists")  {
        		document.getElementById("email-id").className += " formInvalid";
        		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + " - already registered with MoneyBuddy.com ";
        		document.getElementById("email-id").value = null;
        		document.getElementById("first-name").className = "form-control";
        		document.getElementById("first-name").placeholder = "First Name";
        		document.getElementById("last-name").className = "form-control";
        		document.getElementById("last-name").placeholder = "Last Name";
        		document.getElementById("password").className = "form-control";
        		document.getElementById("password").placeholder = "Password";
        		document.getElementById("confirm-password").className = "form-control";
        		document.getElementById("confirm-password").placeholder = "Confirm Password";
        		document.getElementById("mobile-number").className = "form-control";
        		document.getElementById("mobile-number").placeholder = "Contact Number";
        	}
        	else {
        		/*alert('Inside newLogin error !!');*/
        		window.location='/MoneyBuddy/errorPage';
        	}
        },

    });
	
}

$("input[name=riskCategory]").click(function(){
	update();
});

function update(){

	   
	var investment = document.getElementById("upfrontInvestment").innerHTML;
	var sip = document.getElementById("sipPerMonth").innerHTML;
	var riskCategory = document.querySelector('input[name="riskCategory"]:checked').value;;
	var planName = "SAVE_TAX";
	var years = document.getElementById("years").innerHTML;
	
	var totalInvestment = parseInt(sip * years * 12)+parseInt(investment);

	/*alert ('estimate function called ');*/
    $.ajax({
  	
        url : "estimateAction",
        type: 'post',
        
        data: {'upfrontInvestment' : investment , 'sip' : sip , 'years' : years , 'planName' : planName , 'riskCategory' : riskCategory },
        
        success : function(result){
        	if (result == "success") {
        	    	
        	  document.getElementById('diamond-text-1').style.display ='none';
        	  /*alert ('success');*/
        	  if (sip != 0) {
        		  /*alert ('SIP is not 0 ');*/
        		  document.getElementById('diamond-text-7').style.display ='block';
        		  document.getElementById('diamond-text-8').style.display ='block';
        		  document.getElementById('diamond-text-9').style.display ='block';
        		  document.getElementById('diamond-text-10').style.display ='block';

        		  $("#predicted-value-list-1").load("upfrontInvestment.jsp #predicted-value-list-1");
        		  $("#predicted-value-list-2").load("upfrontInvestment.jsp #predicted-value-list-2");
        		  $("#predicted-value-list-3").load("upfrontInvestment.jsp #predicted-value-list-3");
        	  }
        	  else {
        		  /*alert ('SIP is 0 ');*/
	        	  document.getElementById('diamond-text-2').style.display ='block';
	        	  document.getElementById('diamond-text-3').style.display ='block';
	        	  document.getElementById('diamond-text-4').style.display ='block';
	        	  document.getElementById('diamond-text-5').style.display ='block';
	        	  document.getElementById('diamond-text-6').style.display ='block';
	        	  $("#predicted-value").load("upfrontInvestment.jsp #predicted-value");
	           	  
	         		document.getElementById("totalInvestment").innerHTML= totalInvestment;
	       		document.getElementById("numberOfYears").innerHTML= years;
	        	  
        	  }
        	  document.getElementById('submit-button-1').style.display ='block';
    		
        	}
        	else {
        		alert('Inside newLogin error !!');
        		window.location='/MoneyBuddy/errorPage';
        	}  

        }
    });
}

function validateEmail(emailId) {
    var re = /^(.+)@(.+)$/;
    return re.test(emailId);
}

function validatePanCard(panCard) {
    var re = /^[a-zA-Z][a-zA-Z][a-zA-Z][a-zA-Z][a-zA-Z][0-9][0-9][0-9][0-9][a-zA-Z]$/;
    return re.test(panCard);
}

function validateNEFT(neftCode) {
    var re = /^\w{11,11}$/;
    return re.test(neftCode);
}

function validatePassword(password) {
    var re = /^\S{8,20}$/;
    return re.test(password);
}

function validateMobileNumber(mobileNumber) {
    var re = /^[0-9]{10,10}$/;
    return re.test(mobileNumber);
}

function comparePasswords(password1,password2) {
    if (password1 == password2 ) {
    	return true;
    }
    return false;
}

//sleep time expects milliseconds
/*function sleep (time) {
	alert('Inside sleep function !');
  return new Promise((resolve) => setTimeout(resolve, time));
}*/

// With JQuery
$("#ex1").slider({
		formatter: function(value) {
		return 'Current value: ' + value;
	}
});

    $("#slider-right").slider()

    // initializes the input fields
    $("#slider-right").sliderTextInput()
	

	
/* .trigger('change');*/
    
    
    
    

		
		
		