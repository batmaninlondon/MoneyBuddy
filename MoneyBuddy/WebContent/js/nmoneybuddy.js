$(document).ready(function(){
      tooltipObj.init();   
    });

var tooltipObj = {
    init: function(){
        this.events();
    },
    events: function(){
        var _this = this;
        $('[data-ui-tooltip]').on('mouseenter',function(e){
 
            var $el = $(this),
                text = $el.data("ui-tooltip");
            _this.mouseenterEvent(e, text, $el);
        });
 
        $('[data-ui-tooltip]').on('mouseleave click',function(e){
            _this.mouseleaveEvent(e);
        });
    },
    mouseenterEvent: function(e, text, $el){
 
        if(typeof text != 'undefined'){
 
            var tt      = $('.tooltipOuter').clone().addClass("temp"),
                ttCon   = $('.tooltipInner').clone(),
                offset  = $el.offset();
 
            tt.empty()
                .append(ttCon.html(text))
                .appendTo("body");
 
            //Calculate after append
            var bWidth  = tt.width() > $el.width() ? tt.width() :  $el.width(),
                lWidth  = tt.width() < $el.width() ? tt.width() :  $el.width(),
                dWidth  = bWidth - lWidth,
                topVal  = (offset.top - tt.height()) - 8,
                leftVal = (offset.left - (dWidth / 2));
 
            tt.css({
                top:topVal,
                left:leftVal
            }).fadeIn("fast");
        }
    },
    mouseleaveEvent: function(e){
        $('.tooltipOuter.temp').remove();
    }
}

var TUTORIAL_SAVVY ={
        
		  /*Makes the AJAX calll (synchronous) to load a Student Data*/
		  loadStudentData : function(){
		   
		   var formattedstudentListArray =[];
		    
		    $.ajax({
		      
		      async: false,
		       
		      url: "StudentJsonDataServlet",
		       
		      dataType:"json",
		       
		      success: function(studentJsonData) {
		  
		    console.log(studentJsonData);
		      
		     $.each(studentJsonData,function(index,aStudent){
		        
		      formattedstudentListArray.push([aStudent.mathematicsMark,aStudent.computerMark,aStudent.historyMark,aStudent.litratureMark,aStudent.geographyMark]);
		     });
		      }
		    });
		   return formattedstudentListArray;
		  },
		  /*Crate the custom Object with the data*/
		  createChartData : function(jsonData){
		    
		  console.log(jsonData);
		    
		   
		   return {
		     
		    labels : ["Mathematics", "Computers", "History","Literature", "Geography"],
		     
		    datasets : [
		     {
		      fillColor : "rgba(255,0,0,0.3)",
		       
		      strokeColor : "rgba(0,255,0,1)",
		       
		      pointColor : "rgba(0,0,255,1)",
		       
		      pointStrokeColor : "rgba(0,0,255,1)",
		       
		      /*As Ajax response data is a multidimensional array, we have 'student' data in 0th position*/
		      data : jsonData[0]
		     }
		    ]
		   };
		  },
		  /*Renders the Chart on a canvas and returns the reference to chart*/
		  renderStudenrRadarChart:function(radarChartData){
		  
		   var context2D = document.getElementById("canvas").getContext("2d"),
		    
		    myRadar = new Chart(context2D).
		     
		            Radar(radarChartData,{
		              
		               scaleShowLabels : false,
		                
		               pointLabelFontSize : 10
		        });
		             
		         
		    return myRadar;
		  },
		  /*Initalization Student render chart*/
		  initRadarChart : function(){
		     
		   var studentData = TUTORIAL_SAVVY.loadStudentData();
		    
		    chartData = TUTORIAL_SAVVY.createChartData(studentData);
		     
		    radarChartObj = TUTORIAL_SAVVY.renderStudenrRadarChart(chartData);
		     
		  }
		};
		 
		 
		$(document).ready(function(){
		   
		 TUTORIAL_SAVVY.initRadarChart();
		});