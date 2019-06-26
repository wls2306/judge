<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${exam.examName}</title>


    <link rel="stylesheet" href="https://www.2306.tech/judge/css/weui.css">
    <link rel="stylesheet" href="https://www.2306.tech/judge/css/jquery-weui.css">
    <link rel="stylesheet" href="https://www.2306.tech/judge/css/swiper.css">
    <link rel="stylesheet" href="https://www.2306.tech/judge/css/my.css">

    <script src="https://www.2306.tech/judge/js/jquery-2.1.4.js"></script>
    <script src="https://www.2306.tech/judge/js/jquery-weui.js"></script>
    <script src="https://www.2306.tech/judge/js/layer.js"></script>
    <script src="https://www.2306.tech/judge/js/swiper.js"></script>
    <script src="https://www.2306.tech/judge/js/common.js"></script>
    <script src="https://www.2306.tech/judge/js/jquery.form.js"></script>
    <script src="https://www.2306.tech/judge/js/common2.js"></script>
    <script type="text/javascript" src="https://www.2306.tech/judge/js/exam-test.js" charset="utf-8"></script>
    <script type="text/javascript" src="https://www.2306.tech/judge/js/calculator.js" charset="utf-8"></script>
    <script type="text/javascript" src="https://www.2306.tech/judge/js/examJs.js" charset="utf-8"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <#if (Session.user)??>
        <#else>
            <script>
                window.location.href="../../../"
            </script>
    </#if>


    <script type="text/javascript">
        //答题卡点击
        $(function() {
            document.body.onbeforeunload = "ConfirmClose";
            var qstsize = parseInt('15');
            maxtime = "1200";//最大时间每个页面要自己覆盖此值
            timer = setInterval("CountDown()",1000);
            $('input:radio').click(function() {
                var numinder = $(this).parent().attr("numinder");
                if (numinder != null) {
                    $("html,body").animate({
                        scrollTop : $(this).parent().offset().top + 50
                    }, 600);
                }
            });
        });
        function option(id,value,pid){
            $("#complete-"+id).html("（已做过）");
            $("#answer-"+id).val(value.value);
            console.log($("#answer-"+id).val());
        }
        function optionCheck(id,pid){
            var chk_value = [];    //获得正确答案
            $('input[name="answer/'+id+'"]:checked').each(function(){
                chk_value.push($(this).val());
            });
            $("#answer-"+id).val(chk_value.join(","));
            console.log( $("#answer-"+id).val())
        }
        function optionBlank(id,value,pid){
            $("#answer"+id).val(value);
        }

        function submitMustPaper(){
            $.alert("亲，时间到了，您必须交卷了！");
            var form = $("form[name=paperForm]");
            form.submit();
            /*var options  = {
                url:'123',
                type:'post',
                success:function(result){
                    result = $.parseJSON(result);
                    if(result.success){
                        $.alert(result.msg);
                        location.href="http://www.bj-online.com:80/frontmobile/paper/detail?id="+result.obj;
                    }else{
                        $.alert(result.msg);
                    }
                }
            };
            form.ajaxSubmit(options);*/
        }
        function submitPaper() {


                $.confirm("您确认要提交试卷吗？",

                    function () {
                        $("#paperForm").submit();
                  /*  //点击确认后的回调函数
                    $.showLoading("正在提交试卷...");
                    var form = $("form[name=paperForm]");
                    var options = {
                        url: '123',
                        type: 'post',
                        success: function (result) {
                            $.hideLoading();
                            result = $.parseJSON(result);
                            if (result.success) {
                                $.alert(result.msg);
                                location.href = "123" + result.obj;
                            } else {
                                $.alert(result.msg);
                            }
                        },
                        failture: function (e) {
                            $.hideLoading();
                            $.alert(e);
                        }
                    };
                    form.ajaxSubmit(options);*/
                }, function () {
                    //点击取消后的回调函数
                });
            }

    </script>
</head>

<body>
<div class="page-title">${exam.examName}</div>  <#--考试名次在此填写！-->

<form action="../../end" id="paperForm" name="paperForm" method="post"> <!-- 表单信息 -->
    <!-- 试卷ID -->
    <input type="hidden" name="paperId" value="${exam.examPaperId}">  <!-- 试卷编号在此填写 -->
    <input type="hidden" name="examId" value="${exam.examId}">  <!-- 考试编号在此填写 -->
    <input type="hidden" name="userId" value="${userId}">  <!-- 考试编号在此填写 -->
    <input type="hidden" name="userPart" value="${(Session.user.userPart)}">  <!-- 考试编号在此填写 -->
    <!-- 用时 -->
    <input type="hidden" name="testTime" id="testTime"/> <!--考试用时 -->
    <div class="weui_panel">
        <!-- 倒计时 -->
        <div class="weui_panel_hd">姓名：<span id="username">${(Session.user.userName)!'<span style="color:red">未登录</span>'}</span></div>
        <div class="weui_panel_hd">倒计时：<span id="timer">0分0秒</span></div>

        <div class="weui_panel_bd">

            <!-- 正常试题（非案例题） -->

                <!-- 题干 -->

                <#list question as list>
                  <div class="weui_media_box weui_media_text">
                    <h4 class="weui_media_title_auto">
                        ${list_index+1}、(
                            <#switch list.queType>
                                <#case "1"> 单选题 <#break>
                                <#case "2"> 多选题 <#break>
                                <#case "3"> 填空题 <#break>
                                <#case "4"> 问答题 <#break>
                            </#switch>
                        ) ( ${list.queScore}分 )
                        <p><span style="FONT-FAMILY: 宋体; FONT-SIZE: 16px">${list.queContent}</span></p><#--<p></p>--><!-- 已做过 -->
                       <#-- <font color="red" id="complete5850"></font>-->

                        <!-- 试题答案-->
                        <input type="hidden" name="finalanswers-${list.queId}" value="${list.queAnswer}">

                        <!-- 用户回答 -->
                        <input type="hidden" id="answer-${list.queId}" name="answer-${list.queId}">
                    </h4>


                    <#switch list.queType>
                        <#case "1">
                            <!-- 单选题 -->
                            <label for="${list_index+1}_A" numinder="${list_index+1}">
                                &nbsp;
                                <input style="opacity:100;height:25px;width:25px;" type="radio"
                                        name="answer/${list.queId}" id="${list_index+1}_A" value="A"
                                       onclick="option(${list.queId},this,'')">
                                <span style="font-size:30px;">A</span>
                            </label>
                            <label for="${list_index+1}_B" numinder="${list_index+1}">
                                &nbsp;
                                <input style="opacity:100;height:25px;width:25px;" type="radio"
                                        name="answer/${list.queId}" id="${list_index+1}_B" value="B"
                                       onclick="option(${list.queId},this,'')">
                                <span style="font-size:30px;">B</span>
                            </label>
                            <label for="${list_index+1}_C" numinder="${list_index+1}">
                                &nbsp;
                                <input style="opacity:100;height:25px;width:25px;" type="radio"
                                       name="answer/${list.queId}" id="${list_index+1}_C" value="C"
                                       onclick="option(${list.queId},this,'')">
                                <span style="font-size:30px;">C</span>
                            </label>
                            <label for="${list_index+1}_D" numinder="${list_index+1}">
                                &nbsp;
                                <input style="opacity:100;height:25px;width:25px;" type="radio"
                                        name="answer/${list.queId}" id="${list_index+1}_D" value="D"
                                       onclick="option(${list.queId},this,'')">
                                <span style="font-size:30px;">D</span>
                            </label>
                            </div>
                            <#break>

                        <#case "2">
                            <!-- 多选题 -->
                            <input style="opacity:100;height:25px;width:25px;" type="checkbox"
                                   name="answer/${list.queId}" id="${list_index+1}_A" value="A"
                                   onclick="optionCheck(${list.queId},'');">
                            <span style="font-size:30px;">A</span>
                            <input style="opacity:100;height:25px;width:25px;" type="checkbox"
                                   name="answer/${list.queId}" id="${list_index+1}_B" value="B"
                                   onclick="optionCheck(${list.queId},'');">
                            <span style="font-size:30px;">B</span>
                            <input style="opacity:100;height:25px;width:25px;" type="checkbox"
                                   name="answer/${list.queId}" id="${list_index+1}_C" value="C"
                                   onclick="optionCheck(${list.queId},'');">
                            <span style="font-size:30px;">C</span>
                            <input style="opacity:100;height:25px;width:25px;" type="checkbox"
                                   name="answer/${list.queId}" id="${list_index+1}_D" value="D"
                                   onclick="optionCheck(${list.queId},'');">
                            <span style="font-size:30px;">D</span>
                             </div>
                        <#break>
                        <#case "3">
                            <input style="opacity:100;height:25px;width:125px;" type="text" name="answer-${list.queId}"  id="${list_index+1}" value=""
                                   onblur="option(${list.queId},this)">
                            </div>
                        <#break>
                        <#case "4"> 问答题 <#break>
                    </#switch>

                </#list>

        </div>

    </div>

</form>
<div class='content-padded'>
    <a href="javascript:submitPaper();" class="weui_btn weui_btn_primary">提交试卷</a>
    <a href="javascript:history.go(-1);" class="weui_btn weui_btn_default">返        回</a>
</div>

</body>
</html>