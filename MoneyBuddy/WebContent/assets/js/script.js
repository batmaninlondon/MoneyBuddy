//pie

	function abc(TotSignUps,TotAof,VerifiedAcc,ActiveAof,TotSip,RunSip,TotStp,RunStp)  {
		
		 var ctxP = document.getElementById("horBarChart").getContext('2d');
		    var myPieChart = new Chart(ctxP, {
		      type: 'horizontalBar',
		      data: {
		        labels: ["Total Signups","Total AOF downloaded/created","Active accounts (account verified)","Active accounts (AOF activated)","SIPs registered","Running SIPs","STPs registered","Running STPs"],
		        datasets: [{
		          label: '',
		          data: [TotSignUps,TotAof,VerifiedAcc,ActiveAof,TotSip,RunSip,TotStp,RunStp],
		          backgroundColor: ["#fc90a7", "#83d676", "#ba7d9f","#e3a77d", "#a2cef2", "#e7e8a5","#c3c4c0", "#94d4ce"],
		          hoverBackgroundColor: ["#fa4168", "#2ba818","#b52274", "#de6612", "#1e7bc7", "#dcde6d","#868784", "#58c7bc"],
		          		   borderColor: ["#fa4168", "#2ba818","#b52274", "#de6612", "#1e7bc7", "#dcde6d","#868784", "#58c7bc"],
		          borderWidth: 1
		        }]
		      },
		      options: {
		        responsive: true,
		        /*legend: {
		          position: 'right',
		          labels: {
		            padding: 30,
		            boxWidth: 20
		          }
		        },*/
		        legend: {
		        	display: false
		        },

		      }
		    })
	}
	
	
	function bca(MoneyInvested,CurValue,RunningSipValue,RunningStpValue)  {
		
		 var ctxP = document.getElementById("barChart").getContext('2d');
		    var myPieChart = new Chart(ctxP, {
		      type: 'bar',
		      data: {
		        labels: ["Gross invested value","Gross current value"],
		        datasets: [{
		          label: '',
		          data: [MoneyInvested,CurValue,RunningSipValue,RunningStpValue],
		          backgroundColor: ["#fc90a7", "#83d676"],
		          hoverBackgroundColor: ["#fa4168", "#2ba818"],
		          		   borderColor: ["#fa4168", "#2ba818"],
		          borderWidth: 1
		        }]
		      },
		      options: {
		        responsive: true,
		        legend: {
		        	display: false
		        },
		        scales: {
		            yAxes: [
		              {
		                ticks: {
		                  callback: function (value, index, values) {
		                	  return 'Rs.' + value/10000000+'Cr';
		                  },
		                },
		              },
		            ],
		          },	

		      }
		    })
	}