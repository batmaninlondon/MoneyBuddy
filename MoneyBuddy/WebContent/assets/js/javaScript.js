

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
//alert('Call update function !!');
update();
}

function changeUploadStatus(el)  
{
	var date = $(el).closest("tr").find('td:eq(0)').text();
	//alert('Call changeUploadStatus function : date : '+date);
	$.ajax({
        url : "fileUploadStatusChangeAction",
        type: 'post',
        
        data: { 'date' : date },

        success : function(result){
        	
        	if (result == "success") {
        		
        		//do nothing 
        	}
        	else {
        		/*alert('Inside resetPassword error !!');*/
        		window.location='errorPage';
        	}

        }
    });
	
}


function downloadDbfFile(el)
{
	/*alert('showPLan function called !! ');*/
	
	var date = $(el).closest("tr").find('td:eq(0)').text();
	
	
	/*alert('Date is : '+date);*/
	
	/*alert('showPLan function riskCategory :'+riskCategory );*/
	
	
    $.ajax({
        url : "downloadDbfFileAction",
        type: 'post',
        
        data: { 'date' : date },

        success : function(result){
        	
        	if (result == "success") {
        		
        		//do nothing 
        	}
        	else {
        		/*alert('Inside resetPassword error !!');*/
        		window.location='errorPage';
        	}

        }
    });
}

function showNewUpfrontInvestment(newValue)
{
document.getElementById("upfrontInvestment").innerHTML=newValue;
document.getElementById("investedAmount").innerHTML=newValue;
//alert('Call new update function !!');
newUpdate();
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
function showUpfrontInvestmentPlan()
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
        		
	        	/*document.getElementById('investment-options').style.display ='none';
	        	document.getElementById('invested-fund-list').style.display ='block';
	        	document.getElementById("submit-button-1").disabled = true;*/
        		
        		document.getElementById('investment-options').className += " hidden";
	        	$("#invested-fund-list").removeClass('hidden');
	        	/*document.getElementById('invested-fund-list').style.display ='block';*/
	        	document.getElementById("submit-button-1").disabled = true;
	        	$("#investment-fund-list-data").load("upfrontInvestment.jsp #investment-fund-list-data");
        	}

        }
    });
}

function showSipPlan()
{
	/*alert('showSipPLan function called !! ');*/
	
	var riskCategory = document.querySelector('input[name="riskCategory"]:checked').value;;
	
	/*alert('showPLan function riskCategory :'+riskCategory );*/
	
	
    $.ajax({
        url : "productListAction",
        type: 'post',
        
        data: { 'riskCategory' : riskCategory },

        success : function(result){
        	
        	if (result == "success") {
        		/*alert('HI There !!!! ');*/
        	
	        	/*document.getElementById('investment-options').style.display ='none';
	        	document.getElementById('invested-fund-list').style.display ='block';
	        	document.getElementById("submit-button-1").disabled = true;*/
        		
        		document.getElementById('investment-options').className += " hidden";
	        	$("#invested-fund-list").removeClass('hidden');
	        	/*document.getElementById('invested-fund-list').style.display ='block';*/
	        	document.getElementById("submit-button-1").disabled = true;
	        	$("#investment-fund-list-data").load("sipInvestment.jsp #investment-fund-list-data");
        	}

        }
    });
}


function paymentStatus()
{
	/*alert('paymentStatus function called !! ');*/
	
	//var riskCategory = document.querySelector('input[name="riskCategory"]:checked').value;;
	
	/*alert('showPLan function riskCategory :'+riskCategory );*/
	
	
    $.ajax({
        url : "paymentStatusAction",
        type: 'post',
        
        //data: { 'riskCategory' : riskCategory },

        success : function(result){
        	
        	//if (result == "success") {

        	
	        	/*document.getElementById('investment-options').style.display ='none';
	        	document.getElementById('invested-fund-list').style.display ='block';
	        	document.getElementById("submit-button-1").disabled = true;*/
        		
        		/*document.getElementById('investment-options').className += " hidden";
	        	$("#invested-fund-list").removeClass('hidden');
	        	document.getElementById('invested-fund-list').style.display ='block';
	        	document.getElementById("submit-button-1").disabled = true;
	        	$("#investment-fund-list-data").load("upfrontInvestment.jsp #investment-fund-list-data");
        	}
*/
        }
    });
}


function forgottenPassword()
{
	/*alert('forgottenPassword function called !! ');*/
	
	var emailId = document.getElementById("email-id").value;
	
	/*alert('forgottenPassword function emailId :'+emailId );*/
	
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
        url : "forgottenPasswordAction",
        type: 'post',
        
        data: { 'emailId' : emailId },

        success : function(result){
        	/*alert('result : '+result);*/
        	if (result == "success") {
        		window.location='thankYouForPasswordReset';
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
        		/*alert('Inside ForgottenPassword error !!');*/
        		window.location='errorPage';
        	}

        }
    });
}

function checkKysStatus()
{
	//alert('checkKysStatus function called !! ');
	
	var fatherName = document.getElementById("father-name").value;
	var motherName = document.getElementById("mother-name").value;
	var dateOfBirth = document.getElementById("date-of-birth").value;
	var panCard = document.getElementById("pancard-number").value;
	
	//alert ("fatherName : "+fatherName);
	
	if ( fatherName == '')  {
		document.getElementById("father-name").className += " formInvalid";
		document.getElementById("father-name").placeholder = "Father's Name can not be blank ";
		document.getElementById("mother-name").className = "form-control";
		document.getElementById("mother-name").placeholder = "Enter Mother's Name";
		document.getElementById("date-of-birth").className = "form-control";
		document.getElementById("date-of-birth").placeholder = "Enter DoB";
		document.getElementById("pancard-number").className = "form-control";
		document.getElementById("pancard-number").placeholder = "Enter Pancard Number";
		return;
	}
	else if ( motherName == '')  {
		document.getElementById("mother-name").className += " formInvalid";
		document.getElementById("mother-name").placeholder = "Mother's Name can not be blank ";
		document.getElementById("father-name").className = "form-control";
		document.getElementById("father-name").placeholder = "Enter Father's Name";
		document.getElementById("date-of-birth").className = "form-control";
		document.getElementById("date-of-birth").placeholder = "Enter DoB";
		document.getElementById("pancard-number").className = "form-control";
		document.getElementById("pancard-number").placeholder = "Enter Pancard Number";
		return;
	}
	else if ( dateOfBirth == '')  {
		document.getElementById("date-of-birth").className += " formInvalid";
		document.getElementById("date-of-birth").placeholder = "DoB can not be blank ";
		document.getElementById("father-name").className = "form-control";
		document.getElementById("father-name").placeholder = "Enter Father's Name";
		document.getElementById("mother-name").className = "form-control";
		document.getElementById("mother-name").placeholder = "Enter Mother's Name";
		document.getElementById("pancard-number").className = "form-control";
		document.getElementById("pancard-number").placeholder = "Enter Pancard Number";
		return;
	}
	else if ( panCard == '')  {
		document.getElementById("pancard-number").className += " formInvalid";
		document.getElementById("pancard-number").placeholder = "Pancard Number can not be blank ";
		document.getElementById("mother-name").className = "form-control";
		document.getElementById("mother-name").placeholder = "Enter Mother's Name";
		document.getElementById("father-name").className = "form-control";
		document.getElementById("father-name").placeholder = "Enter Father's Name";
		document.getElementById("date-of-birth").className = "form-control";
		document.getElementById("date-of-birth").placeholder = "Enter DoB";
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
        
        data: { 'fatherName' : fatherName , 'motherName' : motherName , 'dateOfBirth' : dateOfBirth , 'panCard' : panCard},

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
        		window.location='kycNotDone';
        	}
        	else if (result == "success") {
        		/*alert('Inside kycCheck success !! ');*/
        		window.location='bankDetails';
        	}	
        	else {
        		/*alert('Inside kycCheck error !! ');*/
        		window.location='errorPage';
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
		$("#residential-pin").removeClass('formInvalid');
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

        		window.location='paymentFailure';
        	}
        	else if (result == "allOrderFailed") {

        		window.location='errorPage';
        	}
        	else {
        		/*alert('Inside checkDetails error !! ');*/
        		window.location='errorPage';
        	}
        },
    });
}

/*function setType() 
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

	document.getElementById("years").innerHTML= '5';
	document.getElementById("sipPerMonth").innerHTML = '2000';
	document.getElementById("upfrontInvestment").innerHTML = '10000'; 

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
}*/

function setInitialUpfrontInvestment() 
{


	document.getElementById("submit-button-1").disabled = false;
	document.getElementById("submit-button-2").disabled = false;
	document.getElementById("submit-button-3").disabled = false;
	document.getElementById("forgot-password-submit-button").disabled = false;
	/*document.getElementById("years").innerHTML= '5';
	document.getElementById("sipPerMonth").innerHTML = '0';
	document.getElementById("upfrontInvestment").innerHTML = '10000';*/
}


function setData() 
{
	$.ajax({

        url : "populateAdminDashboardDataAction",
        type: 'post',

        data: {},
        
        success : function(result){
        	
        	if (result == "success") {
        		// do nothing
        	}
        	else {
        		/*alert('Inside resetPassword error !!');*/
        		window.location='errorPage';
        	}

        },

    });
}

function setInitialSipInvestment() 
{
	document.getElementById("submit-button-1").disabled = false;
	document.getElementById("submit-button-2").disabled = false;
	document.getElementById("submit-button-3").disabled = false;
	document.getElementById("forgot-password-submit-button").disabled = false;
	/*document.getElementById("years").innerHTML= '5';
	document.getElementById("sipPerMonth").innerHTML = '2000';
	document.getElementById("upfrontInvestment").innerHTML = '0';*/
	
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
		/*alert('newPassword : '+newPassword);*/
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
	        		window.location='login';
	        	}
	        	else {
	        		/*alert('Inside resetPassword error !!');*/
	        		window.location='errorPage';
	        	}

	        },

	    });
}


function showCustomerDetails()  
{

	var cusId = document.getElementById('cusId').value;
	//alert('showPanCardVerification : cusId : '+cusId);
	if (cusId == "customerIdNull") {
		/*alert('Inside showPanCardVerification customerIdNotExist !! ');*/
		document.getElementById('investment-options').className += " hidden";	
		$("#login-page").removeClass('hidden');
	} 
	else  {
		
	    $.ajax({

	        url : "kycStatusCheckAction",
	        type: 'post',
	        
	        data: {},
	        
	        success : function(result){
	        	
	        	/*alert('result : '+result);*/
	        	
	        	if (result == "kycNotDone") {
	        		
	        		window.location='customerDetails';
	        	}
	        	else if (result == "success") {
	        		
	        		window.location='bankDetails';
	        	}
	        	else {
	        		/*alert('Inside newLogin error !!');*/
	        		window.location='errorPage';
	        	}
	        	
	        },

	    });
		

	}
	
}
function showPanCardVerification()
{
	//alert('showPanCardVerification function called !! ');
	var cusId = document.getElementById('cusId').value;
	//alert('showPanCardVerification : cusId : '+cusId);
	if (cusId == "customerIdNull") {
		/*alert('Inside showPanCardVerification customerIdNotExist !! ');*/
		document.getElementById('invested-fund-list').className += " hidden";	
		$("#login-page").removeClass('hidden');
	} 
	else  {
		/*alert('Inside showPanCardVerification customerIdExist !! ');*/
		document.getElementById('invested-fund-list').className += " hidden";
		$("#pancard-verification").removeClass('hidden');
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
        		window.location='errorPage';
        	}	
    
        }
    });*/
    	
}

function newLogin() {	
	var emailId = document.getElementById("email-id").value;
	var password = document.getElementById("password").value;
	var login = "loopedLogin";

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
	
	/*alert ('newLogin() : emailId : '+emailId);*/
    $.ajax({

        url : "newLoginAction",
        type: 'post',
        
        data: {'emailId' : emailId , 'password' : password , 'login' : login },
        
        success : function(result){
        	
        	/*alert('result : '+result);*/
        	
        	if (result == "kycAlreadyDone") {
        		/*document.getElementById('login-page').className += " hidden";	
        		$("#pancard-verification").removeClass('hidden');*/
        		
        		window.location='bankDetails';
        	}
        	else if (result == "success") {
        		/*document.getElementById('login-page').className += " hidden";	
        		$("#pancard-verification").removeClass('hidden');*/
        		
        		window.location='customerDetails';
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
        		/*alert('Inside newLogin error !!');*/
        		window.location='errorPage';
        	}
        	
        		

        },

    });
	
}

function signUp(){
	window.location='register';
	
}

function login() {
	
	var emailId = document.getElementById("email-id").value;
	var password = document.getElementById("password").value;
	var login = "login";
	
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
        
        data: {'emailId' : emailId , 'password' : password , 'login' : login},
        
        success : function(result){
        	
        	/*alert('result : '+result);*/
        	
        	if (result == "success") {
        		/*alert('login success !! ');*/
        		window.location='myIndex';
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
        		/*alert('Inside login error !!');*/
        		window.location='errorPage';
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
        		window.location='thankYouForRegistration';
        	}
        	else if (result == "UserAlreadyExists")  {
        		document.getElementById("email-id").className += " formInvalid";
        		document.getElementById("email-id").placeholder = document.getElementById("email-id").value + " - already registered with MoneyBuddy ";
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
        	else if (result == "MobileNumberAlreadyExists")  {
        		document.getElementById("mobile-number").className += " formInvalid";
        		document.getElementById("mobile-number").placeholder = document.getElementById("mobile-number").value + " - already registered with MoneyBuddy ";
        		document.getElementById("mobile-number").value = null;
        		document.getElementById("first-name").className = "form-control";
        		document.getElementById("first-name").placeholder = "First Name";
        		document.getElementById("last-name").className = "form-control";
        		document.getElementById("last-name").placeholder = "Last Name";
        		document.getElementById("password").className = "form-control";
        		document.getElementById("password").placeholder = "Password";
        		document.getElementById("confirm-password").className = "form-control";
        		document.getElementById("confirm-password").placeholder = "Confirm Password";
        		document.getElementById("email-id").className = "form-control";
        		document.getElementById("email-id").placeholder = "Email ID";
        	}
        	else {
        		/*alert('Inside newLogin error !!');*/
        		window.location='errorPage';
        	}
        },

    });
	
}

$("input[name=riskCategory]").click(function(){
	update();
});

function update(){

/*	alert('update called !! ');
	var investment = document.getElementById("upfrontInvestment").innerHTML;
	var sip = document.getElementById("sipPerMonth").innerHTML;
	var riskCategory = document.querySelector('input[name="riskCategory"]:checked').value;;
	var riskCategory = "3";
	var planName = "SAVE_TAX";
	var years = document.getElementById("years").innerHTML;
	
	var totalInvestment = parseInt(sip)+parseInt(investment);

	alert('sip : '+sip);
	alert ('estimate function called ');
    $.ajax({
  	
        url : "estimateAction",
        type: 'post',
        
        data: {'upfrontInvestment' : investment , 'sip' : sip ,'planName' : planName , 'riskCategory' : riskCategory },
        
        success : function(result){
        	if (result == "success") {
        	    	
        	  document.getElementById('diamond-text-1').style.display ='none';
        	  alert ('success');
        	  if (sip != 0) {
        		  alert ('SIP is not 0 ');
        		  $("#diamond-text-7").removeClass('hidden');
				  $("#diamond-text-8").removeClass('hidden');
				  $("#diamond-text-9").removeClass('hidden');
				  $("#diamond-text-10").removeClass('hidden');

        		  $("#predicted-value-list-1").load("sipInvestment.jsp #predicted-value-list-1");
        		  $("#predicted-value-list-2").load("sipInvestment.jsp #predicted-value-list-2");
        		  $("#predicted-value-list-3").load("sipInvestment.jsp #predicted-value-list-3");
        	  }
        	  else {
        		  alert ('SIP is 0 ');
	        	  $("#diamond-text-2").removeClass('hidden');
	        	  $("#diamond-text-3").removeClass('hidden');
	        	  $("#diamond-text-4").removeClass('hidden');
	        	  $("#diamond-text-5").removeClass('hidden');
	        	  $("#diamond-text-6").removeClass('hidden');
	        	  $("#predicted-value").load("upfrontInvestment.jsp #predicted-value");
	           	  
	         		document.getElementById("totalInvestment").innerHTML= totalInvestment;
	       		document.getElementById("numberOfYears").innerHTML= years;
	        	  
        	  }
        	  $("#submit-button-1").removeClass('hidden');
    		
        	}
        	else {
        		alert('Inside estimate error !!');
        		window.location='errorPage';
        	}  

        }
    });*/
	
	var investment = document.getElementById("upfrontInvestment").innerHTML;
	var sip = document.getElementById("sipPerMonth").innerHTML;
	var riskCategory = "3";
	var planName = "SAVE_TAX";
	
	var totalInvestment = parseInt(sip)+parseInt(investment);

	$.ajax({
  	
        url : "estimateAction",
        type: 'post',
        
        data: {'upfrontInvestment' : investment , 'sip' : sip ,'planName' : planName , 'riskCategory' : riskCategory },
        
        success : function(result){
        	if (result == "success") {
        	    	
        	  //document.getElementById('diamond-text-1').style.display ='none';
        	  /*alert ('success');*/
        	  if (sip != 0) {
        		 /* alert ('SIP is not 0 ');*/
        		  $("#diamond-text-7").removeClass('hidden');
				  $("#diamond-text-8").removeClass('hidden');
				  $("#diamond-text-9").removeClass('hidden');
				  $("#diamond-text-10").removeClass('hidden');

        		  $("#predicted-value-list-1").load("sipInvestment.jsp #predicted-value-list-1");
        		  $("#predicted-value-list-2").load("sipInvestment.jsp #predicted-value-list-2");
        		  $("#predicted-value-list-3").load("sipInvestment.jsp #predicted-value-list-3");
        	  }
        	  else {
        		 /* alert ('SIP is 0 ');*/
	        	  /*$("#diamond-text-2").removeClass('hidden');
	        	  $("#diamond-text-3").removeClass('hidden');
	        	  $("#diamond-text-4").removeClass('hidden');
	        	  $("#diamond-text-5").removeClass('hidden');
	        	  $("#diamond-text-6").removeClass('hidden');*/
	        	  $("#predicted-value-for-one-year").load("upfrontInvestment.jsp #predicted-value-for-one-year");
	           	  
	         	//document.getElementById("totalInvestment").innerHTML= totalInvestment;
	       		//document.getElementById("numberOfYears").innerHTML= years;
	        	  
        	  }
        	  //$("#submit-button-1").removeClass('hidden');
    		
        	}
        	else {
        		/*alert('Inside estimate error !!');*/
        		window.location='errorPage';
        	}  

        }
    });
}


function newUpdate(){

	//alert('new update called !! ');
	var investment = document.getElementById("upfrontInvestment").innerHTML;
	var sip = "0";
	var riskCategory = "3";
	var planName = "SAVE_TAX";
	
	var totalInvestment = parseInt(sip)+parseInt(investment);

	$.ajax({
  	
        url : "newEstimateAction",
        type: 'post',
        
        data: {'upfrontInvestment' : investment , 'sip' : sip ,'planName' : planName , 'riskCategory' : riskCategory },
        
        success : function(result){
        	if (result == "success") {
        	    	
        	  //document.getElementById('diamond-text-1').style.display ='none';
        	  /*alert ('success');*/
        	  if (sip != 0) {
        		 /* alert ('SIP is not 0 ');*/
        		  $("#diamond-text-7").removeClass('hidden');
				  $("#diamond-text-8").removeClass('hidden');
				  $("#diamond-text-9").removeClass('hidden');
				  $("#diamond-text-10").removeClass('hidden');

        		  $("#predicted-value-list-1").load("sipInvestment.jsp #predicted-value-list-1");
        		  $("#predicted-value-list-2").load("sipInvestment.jsp #predicted-value-list-2");
        		  $("#predicted-value-list-3").load("sipInvestment.jsp #predicted-value-list-3");
        		  $("#investment-fund-list-data").load("sipInvestment.jsp #investment-fund-list-data");
        	  }
        	  else {
        		 /* alert ('SIP is 0 ');*/
	        	  /*$("#diamond-text-2").removeClass('hidden');
	        	  $("#diamond-text-3").removeClass('hidden');
	        	  $("#diamond-text-4").removeClass('hidden');
	        	  $("#diamond-text-5").removeClass('hidden');
	        	  $("#diamond-text-6").removeClass('hidden');*/
	        	  $("#predicted-value-for-one-year").load("newUpfrontInvestment.jsp #predicted-value-for-one-year");
	        	  $("#predicted-value-for-three-year").load("newUpfrontInvestment.jsp #predicted-value-for-three-year");
	        	  $("#predicted-value-for-five-year").load("newUpfrontInvestment.jsp #predicted-value-for-five-year");
	        	  $("#investment-fund-list-data").load("newUpfrontInvestment.jsp #investment-fund-list-data");
	           	  
	         	//document.getElementById("totalInvestment").innerHTML= totalInvestment;
	       		//document.getElementById("numberOfYears").innerHTML= years;
	        	  
        	  }
        	  //$("#submit-button-1").removeClass('hidden');
    		
        	}
        	else {
        		/*alert('Inside estimate error !!');*/
        		window.location='errorPage';
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
/*$("#ex1").slider({
		formatter: function(value) {
		return 'Current value: ' + value;
	}
});

    $("#slider-right").slider()

    // initializes the input fields
    $("#slider-right").sliderTextInput()
	
*/
	
/* .trigger('change');*/
    
function populateBankDetails() 
{
	
	var bankName = document.getElementById("bank-name").value;
	var accountNumber = document.getElementById("account-number").value;
	var reAccountNumber = document.getElementById("re-account-number").value;
	var ifscCode = document.getElementById("ifsc-code").value;
	
	if ( accountNumber == '')  {
		
		document.getElementById("account-number").className += " formInvalid";
		document.getElementById("account-number").placeholder = "Account Number can not be blank!";
		document.getElementById("re-account-number").className = "form-control";
		document.getElementById("re-account-number").placeholder = "Enter Account Number";
		document.getElementById("ifsc-code").className = "form-control";

		return;
	}
	else if ( reAccountNumber == '')  {
		
		document.getElementById("re-account-number").className += " formInvalid";
		document.getElementById("re-account-number").placeholder = "Account Number can not be blank!";
		document.getElementById("account-number").className = "form-control";
		document.getElementById("account-number").placeholder = "Enter Account Number";
		document.getElementById("ifsc-code").className = "form-control";
		
		return;
	}
	
	else if (accountNumber != reAccountNumber) {
		
		document.getElementById("re-account-number").className += " formInvalid";
		document.getElementById("re-account-number").placeholder = "Account Number does not match!";
		document.getElementById("account-number").className = "form-control";
		document.getElementById("account-number").placeholder = "Enter Account Number";
		document.getElementById("ifsc-code").className = "form-control";
		
		return;
	}
	else if ( ifscCode == '')  {
		
		document.getElementById("ifsc-code").className += " formInvalid";
		document.getElementById("ifsc-code").placeholder = "IFSC Code can not be blank!";
		document.getElementById("re-account-number").className = "form-control";
		document.getElementById("account-number").className = "form-control";
		
		return;
	}
	
	
	$.ajax({
	  	
        url : "populateBankDetailsAction",
        type: 'post',
        
        data: {'bankName' : bankName , 'accountNumber' : accountNumber ,'reAccountNumber' : reAccountNumber , 'ifscCode' : ifscCode },
        
        success : function(result){
        	if (result == "success") {

        		window.location='thankYou';
    		
        	}
        	else {
        		/*alert('Inside estimate error !!');*/
        		window.location='errorPage';
        	}  

        }
    });
	
	
	
	
	
}




function testDummyEkyc () {
	//alert("testDummyEkyc called !! ");
	
	var callingUrl =window.location.href;
	
	var pan = "AAXPW9277C";
	var mobileno = '';
	var email = '';
	var APP_ID = "MoneyBuddy";
	var USER_ID = "ECH_MBUDDY";
	var password = "nc$81MC";
	var INTERMEDIARY_ID = "B";
	var RETURN_DATA_STRU = '';
/*	var Sess_id="svsdsdqw21dscsddsvsdvsdvsdvsd";*/
	var Sess_id = '';
	var Aadhar='';
	var ekyctype='';
	
	var kycdatatext = pan + "|" + email + "|" + mobileno + "|" + APP_ID + "|" + USER_ID + "|" + password + "|" + INTERMEDIARY_ID ;
	
	var url = 'https://eiscuat1.camsonline.com/ekycuat3/eKYCVal_Aadhar.aspx';
	var form = $('<form action="' + url + '" method="post">' +
	  '<input type="hidden" name="url" value="' + callingUrl + '" />' +
	  '<input type="hidden" name="ekyctype" value="' + ekyctype + '" />' +
	  '<input type="hidden" name="kyc_data" value="' + kycdatatext + '" />' +
	  '</form>');
	$('body').append(form);
	form.attr('target', '_top').submit();
	
	
/*	$.ajax({
        type: 'POST',
        url: "https://eiscuat1.camsonline.com/ekycuat3/eKYCVal_Aadhar.aspx",
        dataType: JSON,
        data: {
        	"sess_id": Sess_id,
        	"Aadhar": Aadhar,
            "url": callingUrl,
            "ekyctype": ekyctype,
            "kyc_data": kycdatatext

            
        },
        success: function (data) {
            alert("success");
        }

    });*/
	
}


    

		
		
		