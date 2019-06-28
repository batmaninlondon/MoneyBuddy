		$("input").each(function() {
			//alert('Hi');
		  var $this = $(this);
		  // add empty class on initial run
		  if ($(this).val().trim() == "") {
		      $(this).addClass("input-empty");
		    } else {
		      $(this).removeClass("input-empty");
		    }
		  // add empty class on input change
		  $this.on("change", function() {
		    if ($(this).val().trim() == "") {
		      $(this).addClass("input-empty");
		    } else {
		      $(this).removeClass("input-empty");
		    }
		  });
		});
		
		function showDuration(newValue)
		{
			document.getElementById("sip-duration").innerHTML=newValue;

		}
		function showSipAmountPerMonth(newValue)
		{
			document.getElementById("sipPerMonth").value=newValue;
		}
		function showStpAmountPerMonth(newValue)
		{
			document.getElementById("stpPerMonth").innerHTML=newValue;
		}
		function filldata(minSipAmt,minSipDur,minPurchaseAmount)
		{
			/*document.getElementById("sip-duration").innerHTML=minSipDur;*/
			document.getElementById("sipPerMonth").innerHTML=minSipAmt;
			document.getElementById("upfrontInvestment").innerHTML=minPurchaseAmount;
			document.getElementById("tot-investment-id-value").innerHTML=minPurchaseAmount;
			document.getElementById("transaction-type-value").value = 'UPFRONT';
		}
		function showNewUpfrontInvestment(newValue)
		{
			document.getElementById("upfrontInvestment").value=newValue;
			document.getElementById("tot-investment-id-value").innerHTML=newValue;
		}
		
		function showSearch(val)
		{
	 		    var value = val.toLowerCase();
	 		    $("#myDiv1 div").filter(function() {
	 		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	 		    });

		}

		function setTransactionType(transactionType)  {
			
			//alert('setTransactionType called : transactionType : '+transactionType);
			document.getElementById("transaction-type-value").value = transactionType;
			
			
		}
		
		function enableTextBox()  {
			var result = document.querySelector('input[name="sipDuration"]:checked').value;
		    if(result=="custom"){
		    	document.getElementById("sip-duration-in-years").value = "0";
		    	document.getElementById("sip-duration-in-years").disabled = false;
		    }
		    else{
		    	document.getElementById("sip-duration-in-years").value = "99";
		    	document.getElementById("sip-duration-in-years").disabled = true;
		    }	
		}
		
		function editCart(val)   {

        	document.getElementById("return-type").value = val;
        	
        	document.formEditCart.submit();
        	
		}
		
		function editRedemptionCart(val)   {

        	document.getElementById("return-type").value = val;
        	
        	document.formEditRedemptionCart.submit();
        	
		}
		
		function editStpCart(val)   {

        	document.getElementById("return-type").value = val;
        	
        	document.formEditStpCart.submit();
        	
		}
		
		function changeSliderValue(val)   {
			
			if (val == "" || val == null )   {
				document.getElementById("upfront-investment-range").value = "0";
			}
			else if ( val > 150000 ) {
				document.getElementById("upfront-investment-range").value = "150000";
			}
			else {
				document.getElementById("upfront-investment-range").value = val;
			}
		}
		
		function changeSliderSipValue(val)   {
			
			if (val == "" || val == null )   {
				document.getElementById("sip-amount-range").value = "0";
			}
			else if ( val > 150000 ) {
				document.getElementById("sip-amount-range").value = "150000";
			}
			else {
				document.getElementById("sip-amount-range").value = val;
			}
		}
				
		function newUpdate(){
			
			var transactionType = document.getElementById("transaction-type-value").value;
			var e = document.getElementById("selectUpfrontFolioNum");
			var strFolio;
			if (e == null ) 
				strFolio = "New";
			else 
				strFolio = e.options[e.selectedIndex].value;
						
			var eSip = document.getElementById("selectSipFolioNum");
			var strSipFolio;
			if (eSip == null)
				strSipFolio = "New";
			else
				strSipFolio = eSip.options[eSip.selectedIndex].value;
			
			
			
		    
			if (transactionType == "SIP") {
				var sipDuration;
				var result = document.querySelector('input[name="sipDuration"]:checked').value;
			    if(result=="custom"){
			    	sipDuration = document.getElementById('sip-duration-in-years').value;
					
					if (sipDuration == "" || sipDuration == null || sipDuration == "0")  {
						sipDuration="5";
					}
			    }
			    else{
			    	sipDuration = "99";
			    	document.getElementById("sip-plan-value").value = "UntilStopped";
			    }	
			    
				document.getElementById("sip-amount-value").value = document.getElementById("sipPerMonth").value;
				document.getElementById("upfront-investment-value").value = "0";
				document.getElementById("select-folio-num-value").value = strSipFolio;
				document.getElementById("sip-duration-value").value = sipDuration;
				document.getElementById("sip-date-value").value = $("input[type='radio'][name='sipDate']:checked").val();
			} else{
				document.getElementById("sip-amount-value").value = "0";
				document.getElementById("upfront-investment-value").value = document.getElementById("upfrontInvestment").value;
				document.getElementById("select-folio-num-value").value = strFolio;
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
		
		function callRedemptionAction()  
	    {
				document.formRedemption.submit();
	    }
		function callStpAction()  
	    {
				document.formStp.submit();
	    }
		
		function redeem(fundId,schemeName,folioNumber,totalAmount,totalQuantity)  
	    {
				document.getElementById("redeem-fund-id").value = fundId;
				document.getElementById("redeem-scheme-name").value = schemeName;
				document.getElementById("redeem-folio-num").value = folioNumber;
				document.getElementById("redeem-total-amount").value = totalAmount;
				document.getElementById("redeem-total-quantity").value = totalQuantity;
				
				
				document.formRedeem.submit();
	    }
			
		function showAmtQuanOptions(selectedValue)  
		{

			if (selectedValue == "2") {
				$("#amount-or-quantity").removeClass('hidden');
				$("#redeem-amount-option").removeClass('hidden');
				$("#redeem-quantity-option").addClass('hidden');
			}
			else {
				$("#amount-or-quantity").addClass('hidden');
				$("#redeem-amount-option").addClass('hidden');
				$("#redeem-quantity-option").addClass('hidden');
			}
		}
		
		function showAmtOrQuanOptions(selectedValue)  
		{

			if (selectedValue == "1")  {
				$("#redeem-amount-option").removeClass('hidden');
				$("#redeem-quantity-option").addClass('hidden');
			}
			else {
				$("#redeem-quantity-option").removeClass('hidden');
				$("#redeem-amount-option").addClass('hidden');
			}
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
		
		function buyFundHandler(fundId,folioNum)  
	    {
				document.getElementById("fund-id-value").value = fundId;
				document.getElementById("folio-num-value").value = folioNum;
				document.formBuyFundAction.submit();
	    }
		
		function stpFundHandler(fundId,folioNum,amount)  
	    {
				document.getElementById("fund-id-stp-value").value = fundId;
				document.getElementById("folio-num-stp-value").value = folioNum;
				document.getElementById("cur-amount-stp-value").value = amount;
				
				document.formAddToStpCartAction.submit();
	    }
		
		function redeemFundHandler(fundId,folioNum,totalAmount,totalQuantity)  
	    {
				document.getElementById("fund-id-redeem-value").value = fundId;
				document.getElementById("folio-num-redeem-value").value = folioNum;
				document.getElementById("total-amount-redeem-value").value = totalAmount;
				document.getElementById("total-quantity-redeem-value").value = totalQuantity;
				
				document.formAddToRedemptionCartAction.submit();
	    }
		
        function deleteCartEntry(cartId)  
        {
			document.getElementById("cart-id-value").value = cartId;
			document.formDeleteCart.submit();
        }
        
        function deleteStpCartEntry(stpCartId)  
        {
			document.getElementById("stp-cart-id-value").value = stpCartId;
			document.formDeleteStpCart.submit();
        }
        
        function deleteRedCartEntry(redCartId)  
        {
			document.getElementById("red-cart-id-value").value = redCartId;
			document.formDeleteRedCart.submit();
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
                    	document.getElementById("transaction-type").value = "UPFRONT";
                    	if (cusId == "customerIdNull") {
                    		window.location='login.jsp?OnetimeInvestment='+OnetimeInvestment;
                    	} 
                    	else {
                    		document.formAddToCart.submit();
                    	}
                    	
                    }
                    
                    function callSIPInvestment()  
                    {
                          
                    	var cusId = document.getElementById('cusId').value;
                    	var OnetimeInvestment = "FALSE";
                    	document.getElementById("transaction-type").value = "SIP";
                    	if (cusId == "customerIdNull") {
                    		window.location='login.jsp?OnetimeInvestment='+OnetimeInvestment;
                    	} 
                    	else {
                    		document.formAddToCart.submit();
                    	}
                    	
                    }
                    
                    
                    function submitContactUsMail(googleResponse){
                    	
                  	  
                    	document.getElementById("google-response-coontact-us").value = googleResponse;
                    	
                    	document.formContactUsMail.submit();
                      };
                      

                    

