var maxtime = 100;// 最大时间每个页面要自己覆盖此值
var timer;
var timeFalg = true;
var testTime = 0;

// 计时增加
function CountUp() {
    var date = new Date();
    date.setTime(date.getTime() + (10 * 1000));
    var minutes = Math.floor(testTime / 60);
    var seconds = Math.floor(testTime % 60);
    var msg = "" + minutes + "分" + seconds + "秒";
    document.all["timer"].innerHTML = msg;
    $(".examTimerShow").html(msg);
    if (timeFalg) {
        ++testTime;
    }
    $("#testTime").val(testTime);

}
//倒计时
function CountDown(){
    var date = new Date();
    date.setTime(date.getTime() + (10 * 1000));
    if(maxtime>=0){
        var minutes = Math.floor(maxtime/60);
        var seconds = Math.floor(maxtime%60);
        var msg = ""+minutes+"分"+seconds+"秒";
        document.all["timer"].innerHTML=msg;
        $("#testTime").val(++testTime);
        if(minutes == 0){
            $("#timer").attr("style","color:red");
        }
        if(timeFalg)--maxtime;
    }else{
        clearInterval(timer);
        submitMustPaper();//交卷
    }
}
// 点击下一部分
var titleheiddenNum = 0;
var titleheiddenNum_size = 1;// 最大数量,每个页面要覆盖此值
function nexttitleshow() {
    titleheiddenNum = titleheiddenNum + 1;
    if (titleheiddenNum == titleheiddenNum_size) {
        titleheiddenNum = 0;
    }
    $(".titleHeiddenAndShow" + titleheiddenNum).click();
}

function titleHeiddenAndShow(id, obj) {
    titleheiddenNum = parseInt($(obj).attr("indexNum"));
    var titleValue = $(obj).attr("titlevalue");
    if (paperType != 7) {
        $("#showTitleValue").html(titleValue);
    }
    $(obj).parent().attr("class", "current");
    $(obj).parent().siblings().each(function() {
        $(this).attr("class", "");
    });
    $("#titleHidden" + id).show();
    $("#titleHidden" + id).siblings().hide();
    $("html,body").animate({
        scrollTop : $(".nextTitleAnchor").offset().top
    }, 0);
}
// 答题卡点击
function datikaAnchor(titleheiddenNum, num) {
    $(".titleHeiddenAndShow" + titleheiddenNum).click();
    var top = $(".datikaQstAnchor" + num).offset();
    if(top!=null && top!=''){
        $("html,body").animate({
            scrollTop : $(".datikaQstAnchor" + num).offset().top - 200
        }, 600);
    }
}
// 下一题
function nextqst(num) {
    // 选择答题卡 点击答题卡
    if (num % 51 == 1 && num != 1) {
        nextQuestionListShow();
    }
    if ($("#datikaCurrent" + num).children("a")[0]) {
        $("#datikaCurrent" + num).children("a")[0].click();
    } else {
        $("#datikaCurrent1").children("a")[0].click();
    }
}