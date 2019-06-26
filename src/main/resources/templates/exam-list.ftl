<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">
</head>

<style>

    h2{
        margin-top: 5px;
        margin-left: 5px;
        color: crimson;
    }

    .examInfo{
        border: 1px solid crimson;
        border-radius: 10px;
        margin: 15px;
        background-image: url("../image/bg.png");
        background-size: cover;
    }

    .examId-div{
        text-align: right;
        font-size: 15px;
        color: yellow;
    }

    .examName-div{
        padding-top: 30%;
        font-size: 20px;
        color: red;
    }

    .examTime-div{
        color: white;
    }
    .examStatus-div{
        color: white;
    }


    .notice{
        margin: 5px;
    }


</style>


<body>
<h2>当前答题</h2>

<#list Session.exam as exam>
    <div class="examInfo" bindid="${exam.examId}" >
        <div class="examId-div notice">No：<span class="examId">${exam.examId}</span></div>
        <div class="examName-div notice"> <b><span class="examName">${exam.examName}</span></b></div>
      <#--  <div class="examTime-div notice"> <b> 考试时间：<span class="examTime">${exam.examTime?datetime!"未指定日期"}</span> </b></div>-->
        <div class="examStatus-div notice"><b>当前状态：<span class="examStatus">
                    <#if exam.examStatus =="0">
                        <span style="color: red">未开放</span>
                <#else>
                        <span style="color: green">已开放</span>
                    </#if></span></b></div>
    </div>
</#list>

</body>

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>
<script>
   $(".examInfo").click(
       function () {
           window.location.href="../exam/info/"+$(this).attr('bindid');
       }
   )
</script>

</html>