$(function() {
    eBg();
    //effect();
    //allItem();
    leftMenuScroll();
    subTitleScroll();
    //answerFun();
    //analysis();
    answerScroll();
    /*goTop();*/
    killIe6();
    $(".answer-bar").click();
});

function eBg() {
    var winW = parseInt(document.documentElement.offsetWidth, 10) + parseInt(document.documentElement.scrollLeft || document.body.scrollLeft, 10);
    $(".e-bg>img").css({"width" : winW});
}

var point="";
var str = "";
//左右滚动
function slideScroll(oBox, prev, next, oUl, speed, autoplay) {
    var oBox = $(oBox),
        prev = $(prev),
        next = $(next),
        oUl = $(oUl).find("ul"),
        ulW = oUl.find("li").outerWidth(true),
        oLi = oUl.find("li").length;
    s = speed,
        timer = null;
    oUl.css("width" , oLi * ulW + "px");
    prev.click(function() {
        oUl.animate({"margin-left" : -ulW}, function() {
            oUl.find("li").eq(0).appendTo(oUl);
            oUl.css("margin-left" , 0);
        });
    });
    next.click(function() {
        oUl.find("li:last").prependTo(oUl);
        oUl.css("margin-left", -ulW);
        oUl.animate({"margin-left" : 0});
    });
    if (autoplay === true) {
        timer = setInterval(function() {
            prev.click();
        }, s * 1000);
        oBox.hover(function() {
            clearInterval(timer);
        }, function() {
            timer = setInterval(function() {
                prev.click();
            }, s * 1000);
        });
    }
}
//事件监听
function stopFunc(e) {
    document.all ? event.cancelBubble = true : e.stopPropagation();
}
//leftMenu scroll
function leftMenuScroll() {
    var lM = function() {
        var sTop = parseInt(document.documentElement.scrollTop || document.body.scrollTop, 10);
        if (sTop > 185) {
            $(".left-float-wrap").css("position" , "fixed");
        } else {
            $(".left-float-wrap").css("position" , "absolute");
        }
    };
    $(window).bind("scroll" , lM);
}
//item subTitle scroll
function subTitleScroll() {
    var sT = function() {
        var sTop = parseInt(document.documentElement.scrollTop || document.body.scrollTop, 10);
        if (sTop > 235) {
            $(".t-p-sub-title").addClass("t-fixed");
        } else {
            $(".t-p-sub-title").removeClass("t-fixed");
        }
    };
    $(window).bind("scroll" , sT);
}
//answer scroll
function answerScroll() {
    var marginBot = 0;
    var aS = function() {
        if (document.compatMode === "CSS1Compat") {
            marginBot = document.documentElement.scrollHeight - (document.documentElement.scrollTop + document.body.scrollTop) - document.documentElement.clientHeight;
        } else {
            marginBot = document.body.scrollHeight - document.body.scrollTop - document.body.clientHeight;
        }
        if (marginBot <= 190) {
            $(".answer").css({"position" : "absolute", "bottom" : "0"});
        } else {
            $(".answer").css({"position" : "fixed", "bottom" : "0"});
        }
    };
    $(window).bind("scroll" , aS);
}

function killIe6() {
    if (!window.XMLHttpRequest) {
        alert("您的浏览器版本太旧，请升级您的浏览器，推荐使用谷歌、火狐浏览器！或IE8以上");
    }
}

function quesCard(){
    var _qBtn=$(".q-card-box").children("dt").children("a"),
        _qBox=$(".q-card-box").children("dd");
    _qBtn.click(function(){
        if(!_qBtn.hasClass("q-car-wrap")){
            _qBox.slideUp();
            _qBtn.addClass("q-car-wrap");
        }else{
            _qBox.slideDown();
            _qBtn.removeClass("q-car-wrap");
        }
    })

}
function leftMenuScroll() {
    var lM = function() {
        var sTop = parseInt(document.documentElement.scrollTop || document.body.scrollTop, 10);
        if (sTop > 165) {
            $("#p-test-box").css("position" , "fixed");
        } else {
            $("#p-test-box").css("position" , "absolute");
        }
    };
    $(window).bind("scroll" , lM);
}
function cTabFun(op) {
    var cTab = op;
    cTab.each(function() {
        var _this = $(this),
            _tName = _this.attr("name");
        _this.click(function() {
            _this.parent().addClass("current").siblings().removeClass("current");
            $("html,body").animate({"scrollTop":$("."+_tName+"-content").offset().top}, 500);
        })
    })
}