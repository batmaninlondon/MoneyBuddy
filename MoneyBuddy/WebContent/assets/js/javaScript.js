		function showDuration(newValue)
		{
			document.getElementById("sip-duration").innerHTML=newValue;

		}
		function showSipAmountPerMonth(newValue)
		{
			document.getElementById("sipPerMonth").innerHTML=newValue;
		}
		function filldata(minSipAmt,minSipDur,minLumsumAmount)
		{
			document.getElementById("sip-duration").innerHTML=minSipDur;
			document.getElementById("sipPerMonth").innerHTML=minSipAmt;
			document.getElementById("upfrontInvestment").innerHTML=minLumsumAmount;
			document.getElementById("tot-investment-id-value").innerHTML=minLumsumAmount;
			document.getElementById("transaction-type-value").value = 'UPFRONT';
		}
		function showNewUpfrontInvestment(newValue)
		{
			document.getElementById("upfrontInvestment").innerHTML=newValue;
			document.getElementById("tot-investment-id-value").innerHTML=newValue;
		}
		

		function setTransactionType(transactionType)  {
			
			//alert('setTransactionType called : transactionType : '+transactionType);
			document.getElementById("transaction-type-value").value = transactionType;
			
			
		}
				
		function newUpdate(){
			
			var transactionType = document.getElementById("transaction-type-value").value;
			//alert('newUpdate called : transactionType : '+transactionType);
			//alert('transactionType : '+transactionType);
			if (transactionType == "SIP") {
				document.getElementById("sip-amount-value").value = document.getElementById("sipPerMonth").innerHTML;
				document.getElementById("upfront-investment-value").value = "0";
				document.getElementById("sip-duration-value").value = document.getElementById('sip-duration').innerHTML; // in years
				document.getElementById("sip-date-value").value = document.getElementById('sip-date').value;
			} else{
				document.getElementById("sip-amount-value").value = "0";
				document.getElementById("upfront-investment-value").value = document.getElementById("upfrontInvestment").innerHTML;
				document.getElementById("sip-duration-value").value = "0"; // in years
				document.getElementById("sip-date-value").value = "0";
			}
			
			document.formEstimate.submit();
			
		}
		
		function populateBankDetails(tranDetailId)  
	    {
				document.getElementById("tran-detail-id-value").value = tranDetailId;
				document.formPayment.submit();
	    }
		

		function activatePayNowButton()
		{
			var iAccept = document.getElementById("iAccept").checked;
			
			if (iAccept)  {
				
				$("#pay-now-button").removeClass('disabled');
			}
			else {
				$("#pay-now-button").addClass('disabled');
			}
			
		}
		
		function buyFundHandler(fundId)  
	    {
				document.getElementById("fund-id-value").value = fundId;
				document.formBuyFundAction.submit();
	    }
        function deleteCartEntry(cartId)  
        {
			document.getElementById("cart-id-value").value = cartId;
			document.formDeleteCart.submit();
        }
        function submitForgotPassword(googleResponse){
      	  
        	document.getElementById("google-response").value = googleResponse;
        	document.formForgotPswd.submit();
          };
          
          function submitForgotPassword(googleResponse){
        	  
            	document.getElementById("google-response-forgot-pswd").value = googleResponse;
            	document.formForgotPassword.submit();
            	
              };
              
              function submitRegister(googleResponse){
              	
                	document.getElementById("google-response-register").value = googleResponse;
                	document.formRegister.submit();
                	
               };
              
               function submitLogin(googleResponse){
              	 
                 	document.getElementById("google-response-login").value = googleResponse;
                 	document.formLogin.submit();
                 	
                };
                
                function submitSubscriber(googleResponse){
                  	document.getElementById("google-response-subscriber").value = googleResponse;
                  	
                  	document.formSubscriber.submit();
                    };
                    
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
                    
                    
                    function submitContactUsMail(googleResponse){
                  	  
                    	document.getElementById("google-response-coontact-us").value = googleResponse;
                    	
                    	document.formContactUsMail.submit();
                      };
                      

                    

