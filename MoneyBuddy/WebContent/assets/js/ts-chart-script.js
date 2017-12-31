$(document).ready(function(){
	TUTORIAL_SAVVY.initRadarChart();
});


var TUTORIAL_SAVVY ={
  /*Makes the AJAX calll (synchronous) to load a Student Data*/
		loadStudentData : function(){
	  //alert('inside loadStudentData func!!');
		var portfolioDataModelListArray =[];
   //alert('Calling portfoilio action class !! ');
		
		$.ajax({

			async: false,
			url: "portfolioAction",
			 dataType:"json",
			 success: function(jsonResponse){
			  console.log(jsonResponse);
			  
			
            $.each(jsonResponse.portfolioDataModel,function(index,dataElement){
            	//alert('fund name : '+dataElement.fundName);
           	 portfolioDataModelListArray.push([dataElement.fundName,dataElement.units,dataElement.investedAmount,dataElement.currentAmount,dataElement.rateOfGrowth]);
            });
            $.each(jsonResponse.newPortfolioDataModel,function(index,dataElement){
            	//alert('new fundName : '+dataElement.fundName);
            });
            $.each(jsonResponse.investmentDetailsDataModel,function(index,dataElement){
            	//alert('transaction Date : '+dataElement.transactionDate);
            });
			 }
            
    });
   //alert('Calling portfoilio action class ---at last !! ');
   //alert(portfolioDataModelListArray.length);
   return portfolioDataModelListArray;
  },
  /*Crate the custom Object with the data*/
  createChartData : function(jsonData){
	  
	  //alert('inside createChartData func!!');
   
  console.log(jsonData);
   
  
   return {
    
    labels : ["FundName", "Units", "InvestedAmount","CurrentAmount", "RateOfGrowth"],
    
    datasets : [
     {
      fillColor : "rgba(255,0,0,0.3)",
      
      strokeColor : "rgba(0,255,0,1)",
      
      pointColor : "rgba(0,0,255,1)",
      
      pointStrokeColor : "rgba(0,0,255,1)",
      
      /*As Ajax response data is a multidimensional array, we have 'student' data in 0th position*/
      data : jsonData[0]  
     
     	
     
     
     }
    ]   };
  },
  /*Renders the Chart on a canvas and returns the reference to chart*/
  renderStudenrRadarChart:function(radarChartData){
	  
	  //alert('inside renderStudenrRadarChart func!!');
 
   var context2D = document.getElementById("canvas").getContext("2d");
   
   var myChart = new Chart(context2D,{
	    type: 'bar',
	    data: radarChartData,
	    scaleShowLabels : false,
	       
	      pointLabelFontSize : 10
	});

       return myChart;
  },
  
  
  
  
  
  
  /*Initalization Student render chart*/
  		initRadarChart : function(){
	  
	  var studentData = TUTORIAL_SAVVY.loadStudentData();
	  //alert('chart data loaded here here here' + studentData.length);
   
	  chartData = TUTORIAL_SAVVY.createChartData(studentData);
	  //alert('chart created');
    
    radarChartObj = TUTORIAL_SAVVY.renderStudenrRadarChart(chartData);
    
  }
};

