$(document).ready(function(){
	
var dg_H = $(window).height();
var dg_W = $(window).width();
$('#wrap').css({'height':dg_H,'width':dg_W});
function anim() {
    $("#wrap img.bgfade").first().appendTo('#wrap').fadeOut(3000);
    $("#wrap img").first().fadeIn(3000);
    setTimeout(anim, 6000);
}
anim();
});

function getURLParameter(name) {
	  return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
	}

function showUpfrontInvestment(newValue)
{
document.getElementById("upfrontInvestment").innerHTML=newValue;
update();
}

function changeUploadStatus(el)  
{
	var date = $(el).closest("tr").find('td:eq(0)').text();
	var rta = $(el).closest("tr").find('td:eq(1)').text();
	var fileType = $(el).closest("tr").find('td:eq(2)').text();
	$.ajax({
        url : "fileUploadStatusChangeAction",
        type: 'post',
        
        data: { 'date' : date , 'rta' : rta , 'fileType' : fileType},

        success : function(result){
        	
        	if (result == "success") {
        		
        		//do nothing 
        	}
        	else {
        		window.location='errorPage';
        	}

        }
    });
	
}

function fundDetailHandler(el) {

	    var selectedItem = $(el).closest("tr").find('td:eq(0)').text().trim();

	    $.ajax({
	        url : "investmentDetailsAction",
	        type: 'post',
	        
	        data: { 'productId' : selectedItem  },
	        
	        success : function(result){
	        	
	        	if (result == "success") {

	        		$("#investment-details-data-list").load("bseDashboard.jsp #investment-details-data-list");
	        		$( "#dialog" ).dialog({autoOpen: true,
	        	    	title:selectedItem,
	        	    	width: 800,
	        	    	height:300,
	        	    	scrollable: true});
	        	}
	        	else {
	        		window.location='errorPage';
	        	}

	        }
	    });
	    
	    
	  }

function buyFundHandler(fundId) {

    $.ajax({
        url : "buyFundAction",
        type: 'post',
        
        data: { 'fundId' : fundId  },
          
        success : function(result){
        	
        	if (result == "success") {
        		window.location='selectedFundDetails';
        	}
        	else {
        		window.location='errorPage';
        	}

        }
    });
    
    
  }

function downloadDbfFile(el)
{
	var date = $(el).closest("tr").find('td:eq(0)').text();

    $.ajax({
        url : "downloadDbfFileAction",
        type: 'post',
        
        data: { 'date' : date },

        success : function(result){
        	
        	if (result == "success") {
        		
        		//do nothing 
        	}
        	else {
        		window.location='errorPage';
        	}

        }
    });
}

function showNewUpfrontInvestment(newValue)
{
	document.getElementById("upfrontInvestment").innerHTML=newValue;
	var transactionType="UPFRONT";
	newUpdate(transactionType);
}

function fillSipData(minSipAmt,minSipDur)
{
	document.getElementById("sip-duration").innerHTML=minSipDur;
	showSipAmountPerMonth(minSipAmt);
	
}
function showSipAmountPerMonth(newValue)
{
	document.getElementById("sipPerMonth").innerHTML=newValue;
	var transactionType="SIP";
	newUpdate(transactionType);
}

function showDuration(newValue)
{
	document.getElementById("sip-duration").innerHTML=newValue;
	var transactionType="SIP";
	newUpdate(transactionType);

}
function showDate()
{
	var transactionType="SIP";
	newUpdate(transactionType);
}

function showPredictedSipValues(newValue)
{
	document.getElementById("investmentAmount").innerHTML=newValue;

	var sipAmount = newValue;
	var fundId = document.getElementById("fundId").value;
	$.ajax({
	    url : "sipCalculatorAction",
	    type: 'post',
	    
	    data: { 'sipAmount' : sipAmount , 'fundId' : fundId },
	
	    success : function(result){
	    	
	    	if (result == "success") {
	    		
	        	$("#predicted-values-list-data").load("selectedFundDetails.jsp #predicted-values-list-data");
	    	}
	    	else {
        		window.location='errorPage';
        	}
	
	    }
	});
}


function showUpfrontInvestmentPlan()
{	
	var riskCategory = document.querySelector('input[name="riskCategory"]:checked').value;;
	
	$.ajax({
        url : "productListAction",
        type: 'post',
        
        data: { 'riskCategory' : riskCategory },

        success : function(result){
        	
        	if (result == "success") {
        		
        		document.getElementById('investment-options').className += " hidden";
	        	$("#invested-fund-list").removeClass('hidden');
	        	document.getElementById("submit-button-1").disabled = true;
	        	$("#investment-fund-list-data").load("upfrontInvestment.jsp #investment-fund-list-data");
        	}

        }
    });
}

function ongoingSipList()
{

    $.ajax({
        url : "ongoingSipListAction",
        type: 'post',
        
        data: { },

        success : function(result){
        	
        	if (result == "success") {
        		window.location='ongoingSips';
        	}
        	else {
        		window.location='errorPage';
        	}

        }
    });
}

function showSipPlan()
{
	var riskCategory = document.querySelector('input[name="riskCategory"]:checked').value;;
	
	$.ajax({
        url : "productListAction",
        type: 'post',
        
        data: { 'riskCategory' : riskCategory },

        success : function(result){
        	
        	if (result == "success") {
        		
        		document.getElementById('investment-options').className += " hidden";
	        	$("#invested-fund-list").removeClass('hidden');
	        	document.getElementById("submit-button-1").disabled = true;
	        	$("#investment-fund-list-data").load("sipInvestment.jsp #investment-fund-list-data");
        	}

        }
    });
}


function paymentStatus()
{
	$.ajax({
        url : "paymentStatusAction",
        type: 'post',
        
        //data: { 'riskCategory' : riskCategory },

        success : function(result){
        	
        	if (result == "success") {
        		// Do nothing
        	}

        }
    });
}


function forgottenPassword()
{
	var emailId = document.getElementById("email-id").value;

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
        		window.location='errorPage';
        	}

        }
    });
}

function checkKysStatus()
{
	var customerName = document.getElementById("customer-name").value;
	var dateOfBirth = document.getElementById("date-of-birth").value;
	var gender = document.getElementById("gender").value;
	var occupation = document.getElementById("occupation").value;
	var taxStatus = document.getElementById("tax-status").value;
	var addressLineOne = document.getElementById("address-line-one").value;
	var addressLineTwo = document.getElementById("address-line-two").value;
	var addressLineThree = document.getElementById("address-line-three").value;
	var residentialCity = document.getElementById("residential-city").value;
	var residentialState = document.getElementById("residential-state").value;
	var residentialPin = document.getElementById("residential-pin").value;
	var residentialCountry = document.getElementById("residential-country").value;


	if ( customerName == '')  {
		document.getElementById("customer-name").className += " formInvalid";
		document.getElementById("customer-name").placeholder = "Customer Name can not be blank ";
		$("#customer-name").removeClass('formInvalid');
		$("#address-line-one").removeClass('formInvalid');
		$("#address-line-two").removeClass('formInvalid');
		$("#address-line-three").removeClass('formInvalid');
		$("#residential-pin").removeClass('formInvalid');

		return;
	}
	else if ( addressLineOne == '')  {
		document.getElementById("address-line-one").className += " formInvalid";
		document.getElementById("address-line-one").placeholder = "Address Line One can not be blank ";
		$("#customer-name").removeClass('formInvalid');
		$("#address-line-two").removeClass('formInvalid');
		$("#address-line-three").removeClass('formInvalid');
		$("#residential-pin").removeClass('formInvalid');

		return;
	}
	else if ( addressLineTwo == '')  {
		document.getElementById("address-line-two").className += " formInvalid";
		document.getElementById("address-line-two").placeholder = "Address Line Two can not be blank ";
		$("#customer-name").removeClass('formInvalid');
		$("#address-line-one").removeClass('formInvalid');
		$("#address-line-three").removeClass('formInvalid');
		$("#residential-pin").removeClass('formInvalid');

		return;
	}
	else if ( addressLineThree == '')  {
		document.getElementById("address-line-three").className += " formInvalid";
		document.getElementById("address-line-three").placeholder = "Address Line Three can not be blank ";
		$("#customer-name").removeClass('formInvalid');
		$("#address-line-one").removeClass('formInvalid');
		$("#address-line-two").removeClass('formInvalid');
		$("#residential-pin").removeClass('formInvalid');

		return;
	}
	else if ( residentialPin == '')  {
		document.getElementById("residential-pin").className += " formInvalid";
		document.getElementById("residential-pin").placeholder = "Residential Pin can not be blank ";
		$("#customer-name").removeClass('formInvalid');
		$("#address-line-one").removeClass('formInvalid');
		$("#address-line-two").removeClass('formInvalid');
		$("#address-line-three").removeClass('formInvalid');

		return;
	}
	
    $.ajax({
      	
        url : "kycCheckAction",
        type: 'post',
        
        data: { 'customerName' : customerName , 'dateOfBirth' : dateOfBirth , 'gender' : gender , 'occupation' : occupation , 'taxStatus' : taxStatus, 'addressLineOne' : addressLineOne , 'addressLineTwo' : addressLineTwo , 'addressLineThree' : addressLineThree , 'residentialCity' : residentialCity , 'residentialState' : residentialState , 'residentialPin' : residentialPin , 'residentialCountry' : residentialCountry},

        success : function(result){

        	if (result == "kycDone") {
        		window.location='bankDetails';
        	} 
        	else if (result == "kycNotDone")  {
        		window.location='additionalCustomerDetails';
        	}

        	else {
        		window.location='errorPage';
        	}
        },

    });

}

function prepareKyc()
{
	var fatherName = document.getElementById("father-name").value;
	var maritalStatus = document.getElementById("marital-status").value;
	var nationality = document.getElementById("nationality").value;
	var status = document.getElementById("status").value;
	var grossAnnualIncome = document.getElementById("gross-annual-income").value;
	var politicallyExposed = document.getElementById("politically-exposed").value;


	if ( fatherName == '')  {
		document.getElementById("father-name").className += " formInvalid";
		document.getElementById("father-name").placeholder = "Father's name can not be blank ";

		return;
	}
	

    $.ajax({
      	
        url : "prepareKycFormAction",
        type: 'post',
    	
        data: { 'fatherName' : fatherName ,  'maritalStatus' : maritalStatus , 'nationality' : nationality , 'status' : status ,'grossAnnualIncome' : grossAnnualIncome ,'politicallyExposed' : politicallyExposed },

        success : function(result){
        	if (result == "success") {
        		
        		window.location='downloadKycForm';
        	}	
        	else {
        		window.location='errorPage';
        	}
        },

    });

}

function checkDetails()
{
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

        	if (result.startsWith("success")) {
       		
        		var paymentUrl = result.substring(8);
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
        		window.location='errorPage';
        	}
        },
    });
}

function setInitialUpfrontInvestment() 
{


	document.getElementById("submit-button-1").disabled = false;
	document.getElementById("submit-button-2").disabled = false;
	document.getElementById("submit-button-3").disabled = false;
	document.getElementById("forgot-password-submit-button").disabled = false;
}


function setData() 
{
	
	$.ajax({

        url : "populateAdminDashboardDataAction",
        type: 'post',

        data: {},
        
        success : function(result){
        	
        	if (result == "success") {
        		$('#body_holder').show();
        	}
        	else {
        		window.location='errorPage';
        	}

        },

    });
}

function setDashboardData() 
{
	$.ajax({

        url : "portfolioAction",
        type: 'post',

        data: {},
        
        success : function(result){
        	if (result == "success") {
        		window.location='bseDashboard';
        	}
        	else {
        		window.location='errorPage';
        	}
        },

    }); 
}

function getMfData() 
{
	$.ajax({

        url : "fetchFundDetailsAction",
        type: 'post',

        data: {},
        
        success : function(result){
        	
        	if (result == "success") {
        		window.location='allFunds';
        	}
        	else {
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
	        		window.location='errorPage';
	        	}

	        },

	    });
}


function showCustomerDetails()  
{

	var cusId = document.getElementById('cusId').value;
	if (cusId == "customerIdNull") {
		document.getElementById('investment-options').className += " hidden";	
		$("#login-page").removeClass('hidden');
	} 
	else  {
		
	    $.ajax({

	        url : "kycStatusCheckAction",
	        type: 'post',
	        
	        data: {},
	        
	        success : function(result){

	        	if (result == "kycNotDone") {
	        		
	        		window.location='customerDetails';
	        	}
	        	else if (result == "success") {
	        		window.location='clientDetails';
	        	}
	        	else {
	        		window.location='errorPage';
	        	}
	        	
	        },

	    });
	}
	
}

function createCart()  
{

	$.ajax({

        url : "createCartAction",
        type: 'post',
        
        data: {},
        
        success : function(result){
        	if (result == "success") {
        		window.location='customerCart';
        	}
        	else {
        		window.location='errorPage';
        	}
        	
        },

    });	

}

function deleteCartEntry(cartId)  
{
	var cartId = cartId;

	$.ajax({

        url : "deleteCartEntryAction",
        type: 'post',
        
        data: { 'cartId' : cartId },
        
        success : function(result){
        	if (result == "success") {
        		window.location='customerCart';

        	}
        	else {
        		window.location='errorPage';
        	}
        	
        },

    });	

}

function openCustomerDetailsPage()  
{
	var redirectingPage = document.getElementById('redirectingPage').value;

	if (redirectingPage == "panCardVerifiction") {
		window.location='panCardVerification';
	} 
	else if (redirectingPage == "bankDetails"){
		window.location='bankDetails';
	}
	else if (redirectingPage == "addCustomerDetails"){
		window.location='additionalCustomerDetails';
	}
	else if (redirectingPage == "downloadKycForm"){
		window.location='downloadKycForm';
	}
	else {
		window.location='customerDetails';
	}
	
}

function callOneTimeInvestment()  
{
	var cusId = document.getElementById('cusId').value;
	var OnetimeInvestment = "TRUE";
	if (cusId == "customerIdNull") {
		window.location='login.jsp?OnetimeInvestment='+OnetimeInvestment;
	} 
	else {
		window.location='amountConfirmation.jsp?OnetimeInvestment='+OnetimeInvestment;
	}
	
}


function callSIPInvestment()  
{
      
	var cusId = document.getElementById('cusId').value;
	var OnetimeInvestment = "FALSE";
	if (cusId == "customerIdNull") {
		window.location='login.jsp?OnetimeInvestment='+OnetimeInvestment;
	} 
	else {
		window.location='amountConfirmation.jsp?OnetimeInvestment='+OnetimeInvestment;
	}
	
}

function verifyPancard()  
{
      
	var panCard = document.getElementById("pancard-number").value;
	if ( panCard == '')  {
		document.getElementById("pancard-number").className += " formInvalid";
		document.getElementById("pancard-number").placeholder = "Pancard Number can not be blank ";

		return;
	}
	else if (!validatePanCard(panCard)) {
		document.getElementById("pancard-number").className += " formInvalid";
		document.getElementById("pancard-number").placeholder = document.getElementById("pancard-number").value + " - is not a valid Pan Card Number ";
		document.getElementById("pancard-number").value = null;
		
		return;
	}

	$.ajax({

        url : "panCardVerificationAction",
        type: 'post',
        
        data: {'panCard' : panCard },
        
        success : function(result){
        	if (result == "kycDone") {
        		window.location='customerDetails';
        	}
        	else if (result == "kycNotDone")  {
        		window.location='customerDetails';
        	}
        	else {
        		window.location='errorPage';
        	}

        },
    });
	
}

function showPanCardVerification()
{
	var cusId = document.getElementById('cusId').value;
	if (cusId == "customerIdNull") {
		document.getElementById('invested-fund-list').className += " hidden";	
		$("#login-page").removeClass('hidden');
	} 
	else  {
		document.getElementById('invested-fund-list').className += " hidden";
		$("#pancard-verification").removeClass('hidden');
	}
    	
}

function signUp(){
	window.location='register';
	
}

function saveSubscriber() {
	
	var emailId = document.getElementById("subscriber-email-id").value;
	var mobileNumber = null;

	if ( emailId == '')  {
		
		document.getElementById("subscriber-email-id").className += " formInvalid";
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

        url : "saveSubscriberAction",
        type: 'post',
        
        data: {'emailId' : emailId , 'mobileNumber' : mobileNumber},
        
        success : function(result){
        	if (result == "success") {
        		window.location='thankYouForSubscribing';
        	}
        	else {
        		window.location='errorPage';
        	}

        },
    });	
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
        
        data: {'emailId' : emailId , 'password' : password },
        
        success : function(result){
        	if (result == "success") {
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
        	else if (result == "fundSelected")  {
        		window.location='investmentStyle';
        	}
        	else if (result == "fundOnetimeSelected")  {
        		window.location='amountConfirmation';
        	}
        	else if (result == "fundSIPSelected")  {
        		window.location='amountConfirmation';
        	}
        	else {
        		window.location='errorPage';
        	}

        },
    });	
}

function generatePackage() {

	$.ajax({
	
	    url : "generatePackageAction",
	    type: 'post',
	    
	    data: {},
	    
	    success : function(result){
	    	if (result == "success") {
	    		window.location='selectedFundDetails';
	    	}
	    	else {
	    		window.location='errorPage';
	    	}
	
	    },
	});	
}


function register() {

	var emailId = document.getElementById("email-id1").value;
	var password = document.getElementById("password1").value;
	var mobileNumber = document.getElementById("mobile-number").value;

	if ( emailId == '')  {
		
		document.getElementById("email-id1").className += " formInvalid";
		document.getElementById("email-id1").placeholder = "Email Id can not be blank!";
		document.getElementById("password1").className = "form-control";
		document.getElementById("password1").placeholder = "Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( !validateEmail(emailId) )  {
		
		document.getElementById("email-id1").className += " formInvalid";
		document.getElementById("email-id1").placeholder = document.getElementById("email-id").value + " - Not a valid Email Id";
		document.getElementById("email-id1").value = null;
		document.getElementById("password1").className = "form-control";
		document.getElementById("password1").placeholder = "Password";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( password == '')  {
	
		document.getElementById("password1").className += " formInvalid";
		document.getElementById("password1").placeholder = "Password can not be blank!";
		document.getElementById("email-id1").className = "form-control";
		document.getElementById("email-id1").placeholder = "Email ID";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( !validatePassword(password))  {
	
		document.getElementById("password").className += " formInvalid";
		document.getElementById("password").placeholder = "Password shall contain min 8 charcters";
		document.getElementById("password").value = null;
		document.getElementById("email-id1").className = "form-control";
		document.getElementById("email-id1").placeholder = "Email ID";
		document.getElementById("mobile-number").className = "form-control";
		document.getElementById("mobile-number").placeholder = "Contact Number";
		return;
	}
	else if ( mobileNumber == '')  {
		
		document.getElementById("mobile-number").className += " formInvalid";
		document.getElementById("mobile-number").placeholder = "Mobile Number can not be blank!";
		document.getElementById("email-id1").className = "form-control";
		document.getElementById("email-id1").placeholder = "Email ID";
		document.getElementById("password1").className = "form-control";
		document.getElementById("password1").placeholder = "Password";
		return;
	}
	else if ( !validateMobileNumber(mobileNumber))  {
		
		document.getElementById("mobile-number").className += " formInvalid";
		document.getElementById("mobile-number").placeholder = document.getElementById("mobile-number").value + " - Not a valid mobile number";
		document.getElementById("mobile-number").value = null;
		document.getElementById("email-id1").className = "form-control";
		document.getElementById("email-id1").placeholder = "Email ID";
		document.getElementById("password1").className = "form-control";
		document.getElementById("password1").placeholder = "Password";
		return;
	}

    $.ajax({
      	
        url : "registerAction",
        type: 'post',
        
        data: {'emailId' : emailId, 'password' : password,'mobileNumber' : mobileNumber},
        
        success : function(result){
        	if (result == "success") {
        		window.location='thankYouForRegistration';
        	}
        	else if (result == "UserAlreadyExists")  {
        		document.getElementById("email-id1").className += " formInvalid";
        		document.getElementById("email-id1").placeholder = document.getElementById("email-id").value + " - already registered with MoneyBuddy ";
        		document.getElementById("email-id1").value = null;
        		document.getElementById("password1").className = "form-control";
        		document.getElementById("password1").placeholder = "Password";
        		document.getElementById("mobile-number").className = "form-control";
        		document.getElementById("mobile-number").placeholder = "Contact Number";
        	}
        	else if (result == "MobileNumberAlreadyExists")  {
        		document.getElementById("mobile-number").className += " formInvalid";
        		document.getElementById("mobile-number").placeholder = document.getElementById("mobile-number").value + " - already registered with MoneyBuddy 123";
        		document.getElementById("mobile-number").value = null;
        		document.getElementById("password1").className = "form-control";
        		document.getElementById("password1").placeholder = "Password";
        		document.getElementById("email-id1").className = "form-control";
        		document.getElementById("email-id1").placeholder = "Email ID";
        	}
        	else {
        		window.location='errorPage';
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
	var riskCategory = "3";
	var planName = "SAVE_TAX";
	
	var totalInvestment = parseInt(sip)+parseInt(investment);

	$.ajax({
  	
        url : "estimateAction",
        type: 'post',
        
        data: {'upfrontInvestment' : investment , 'sip' : sip ,'planName' : planName , 'riskCategory' : riskCategory },
        
        success : function(result){
        	if (result == "success") {

        	  if (sip != 0) {
        		  $("#diamond-text-7").removeClass('hidden');
				  $("#diamond-text-8").removeClass('hidden');
				  $("#diamond-text-9").removeClass('hidden');
				  $("#diamond-text-10").removeClass('hidden');

        		  $("#predicted-value-list-1").load("sipInvestment.jsp #predicted-value-list-1");
        		  $("#predicted-value-list-2").load("sipInvestment.jsp #predicted-value-list-2");
        		  $("#predicted-value-list-3").load("sipInvestment.jsp #predicted-value-list-3");
        	  }
        	  else {
	        	  $("#predicted-value-for-one-year").load("upfrontInvestment.jsp #predicted-value-for-one-year");
	        	  
        	  }
        	}
        	else {
        		window.location='errorPage';
        	}  

        }
    });
}


function newUpdate(transactionType){

	var transactionType = transactionType;
	
	if (transactionType == "SIP") {
		var sipAmount = document.getElementById("sipPerMonth").innerHTML;
		var investment = "0";
		var sipDuration = document.getElementById('sip-duration').innerHTML; // in years
		var sipDate = document.getElementById('sip-date').value;
		var planName = "SIP";
	} else{
		var sipAmount = "0";
		var investment = document.getElementById("upfrontInvestment").innerHTML;
		var sipDuration = "0"; // in years
		var sipDate = "0";
		var planName = "SAVE_TAX";
	}

	var riskCategory = "3";

	$.ajax({
  	
        url : "newEstimateAction",
        type: 'post',
        
        data: {'upfrontInvestment' : investment , 'sipAmount' : sipAmount , 'sipDuration' : sipDuration , 'sipDate' : sipDate ,'planName' : planName , 'riskCategory' : riskCategory , 'transactionType' : transactionType },
        
        success : function(result){
        	if (result == "success") {

        	  if (sipAmount != 0) {
        		  $("#diamond-text-7").removeClass('hidden');
				  $("#diamond-text-8").removeClass('hidden');
				  $("#diamond-text-9").removeClass('hidden');
				  $("#diamond-text-10").removeClass('hidden');

				  $("#predicted-value-for-one-year").load("newSipInvestment.jsp #predicted-value-for-one-year");
	        	  $("#predicted-value-for-three-year").load("newSipInvestment.jsp #predicted-value-for-three-year");
	        	  $("#predicted-value-for-five-year").load("newSipInvestment.jsp #predicted-value-for-five-year");
	        	  $("#investment-fund-list-data").load("newSipInvestment.jsp #investment-fund-list-data");
        	  }
        	  else {
	        	  $("#predictedValue1").load("newUpfrontInvestment.jsp #predictedValue1");
	        	  $("#predictedValue2").load("newUpfrontInvestment.jsp #predictedValue2");
	        	  $("#predictedValue3").load("newUpfrontInvestment.jsp #predictedValue3");
	        	  $("#investmentFundData").load("newUpfrontInvestment.jsp #investmentFundData");
	        	  
        	  }
        	}
        	else {
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
 
function populateBankDetails() 
{
	var bankName = document.getElementById("bank-name").value;
	var accountType = document.getElementById("account-type").value;
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
        
		url : "paymentAction",
        type: 'post',
        
        data: {'bankName' : bankName , 'accountNumber' : accountNumber , 'accountType' : accountType , 'neftCode' : ifscCode },
        
        success : function(result){
        	if (result.startsWith("success")) {
        		var paymentUrl = result.substring(8);
        		alert('paymentUrl   : '+paymentUrl);
        		window.open(paymentUrl, "_self");
        	}
        	else {
        		window.location='errorPage';
        	}  

        }
    });

}

function uploadCutsomerNav() 
{
	
	var bseOrderId = document.getElementById("bse-order-id").value;
	var navValue = document.getElementById("nav-value").value;
	var unitsPurchased = document.getElementById("units-purchased").value;
	
	if ( bseOrderId == '')  {
		
		document.getElementById("bse-order-id").className += " formInvalid";
		document.getElementById("bse-order-id").placeholder = "Bse Order Id can not be blank!";
		document.getElementById("nav-value").className = "form-control";
		document.getElementById("units-purchased").className = "form-control";

		return;
	}
	else if ( navValue == '')  {
		
		document.getElementById("nav-value").className += " formInvalid";
		document.getElementById("nav-value").placeholder = "NAV Value can not be blank!";
		document.getElementById("bse-order-id").className = "form-control";
		document.getElementById("units-purchased").className = "form-control";
		
		return;
	}

	else if ( unitsPurchased == '')  {
		
		document.getElementById("units-purchased").className += " formInvalid";
		document.getElementById("units-purchased").placeholder = "NAV Value can not be blank!";
		document.getElementById("bse-order-id").className = "form-control";
		document.getElementById("nav-value").className = "form-control";
		
		return;
	}
	
	
	$.ajax({
	  	
        url : "uploadCustomerNavAction",
        type: 'post',
        
        data: {'bseOrderId' : bseOrderId , 'navValue' : navValue ,'unitsPurchased' : unitsPurchased  },
        
        success : function(result){
        	if (result == "success") {

        		document.getElementById('upload-nav').className += " hidden";
	        	$("#successfully-uploaded-nav").removeClass('hidden');
    		
        	}
        	else {
        		window.location='errorPage';
        	}  

        }
    });

}

function testDummyEkyc () {
	
	var callingUrl =window.location.href;
	
	var pan = "AAXPW9277C";
	var mobileno = '';
	var email = '';
	var APP_ID = "MoneyBuddy";
	var USER_ID = "ECH_MBUDDY";
	var password = "nc$81MC";
	var INTERMEDIARY_ID = "B";
	var RETURN_DATA_STRU = '';
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

}


    

		
		
		