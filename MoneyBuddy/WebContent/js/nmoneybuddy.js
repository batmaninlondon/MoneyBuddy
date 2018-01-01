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

