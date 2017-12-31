$(document).ready(function(){
	TUTORIAL_SAVVY.initChart();
});



var TUTORIAL_SAVVY ={
  /*Makes the AJAX calll (synchronous) to load a Student Data*/
		loadData : function(){
		var portfolioDataModelListArray =[];
		$.ajax({
				async: false,
				url: "portfolioAction",
				dataType:"json",
				success: function(jsonResponse){
					console.log(jsonResponse);
					$.each(jsonResponse.portfolioDataModel,function(index,dataElement){
						portfolioDataModelListArray.push([dataElement.fundName,dataElement.units,dataElement.investedAmount,dataElement.currentAmount,dataElement.rateOfGrowth]);
					});
						$.each(jsonResponse.newPortfolioDataModel,function(index,dataElement){
					});
						$.each(jsonResponse.investmentDetailsDataModel,function(index,dataElement){
					});
				}
		});
   return portfolioDataModelListArray;
  },
  
  
  
  /*Crate the custom Object with the data*/
  createBarChartData : function(jsonData)
  {

	 // console.log(jsonData);
	  var funds =[];
	  var investedValue =[];
	  var currentValue =[];
	  
	  for(var i = 0; i < jsonData.length; i++) {
		    var obj = jsonData[i];
		    console.log(obj[0]);
		    funds.push(obj[0]);
		    investedValue.push(obj[2]);
		    currentValue.push(obj[3]);
		}
	 
	  return {
		  		labels: funds,
		  		datasets: [
								{
										label: 'Invested Value',
										backgroundColor: "#26B99A",
										data: investedValue
								}, 
								{
										label: 'Current Value',
										backgroundColor: "#03586A",
										data: currentValue
								}
							],
							options: {
							    legend: {
							      display: true,
							      position: 'left',
							      labels: {
							        fontColor: "#000080",
							      }
							    },
							    scales: {
							      yAxes: [{
							        ticks: {
							          beginAtZero: true
							        }
							      }]
							    }
							  }		
	  		};
  },
  
  /*Renders the BarChart on a canvas and returns the reference to chart*/
  renderBarChart:function(ChartData)
  {
	  var context2D = document.getElementById("canvas").getContext("2d");
	  var myChart = new Chart(context2D,{
		  type: 'bar',
		  data: ChartData,
		  scaleShowLabels : false,
	      pointLabelFontSize : 10
	});
  return myChart;
  },
  

	  createDoughnutChartData : function(jsonData) {
		var funds = [];
		var currentValue = [];
		var colors = [ "Red", "Blue", "Yellow", "Green", "Purple", "Orange" ];
		var bgColorArray = [];
		var hoverBgColorArray = [];

		for (var i = 0; i < jsonData.length; i++) {
			var obj = jsonData[i];
			funds.push(obj[0]);
			currentValue.push(obj[3]);
			var bgClrIndex = 0;
			if (i > 6) {
				bgClrIndex = i - 6;

			} else
				(bgClrIndex = i);
			bgColorArray.push(colors[bgClrIndex]);
		}

		return {
			labels : funds,
			datasets : [ {
				data : currentValue,
				backgroundColor : bgColorArray,
			// hoverBackgroundColor: hoverBgColorArray
			}, ]
		};
	},

	/* Renders the Doughnut Chart on a canvas and returns the reference to chart */
	renderDoughnutChart : function(ChartData) {
		var context2D = document.getElementById("canvas1").getContext("2d");
		var myChart = new Chart(context2D, {
			type : 'doughnut',
			tooltipFillColor : "rgba(51, 51, 51, 0.55)",
			data : ChartData,
			legend : {
				display : false,
				position : "right",
			// labels: {fontColor: 'rgb(255, 99, 132)'},
			},
		});
		return myChart;
	},
  
  
  /* Initalization Student render chart */
  	initChart : function(){
	var rawData 		= TUTORIAL_SAVVY.loadData();
	barChartData 		= TUTORIAL_SAVVY.createBarChartData(rawData);
    BarChartObj 		= TUTORIAL_SAVVY.renderBarChart(barChartData);
    DoughnutChartData 	= TUTORIAL_SAVVY.createDoughnutChartData(rawData);
    DoughnutChartObj 	= TUTORIAL_SAVVY.renderDoughnutChart(DoughnutChartData);
  }
};

