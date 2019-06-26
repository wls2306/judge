
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
<#if (Session.user)??>
<#else>
    <script>
        window.location.href="../../"
    </script>
</#if>
<style>

    h2{
        margin-top: 5px;
        margin-left: 5px;
        color: crimson;
    }

    .scoreList{
        border: 1px solid crimson;
        border-radius: 5px;
        margin: 15px;
        background-image: url("../image/bg.png");
        background-size: cover;
    }

    .score-examId-div{
        text-align: right;
        font-size: 15px;
        color: gold;
    }

    .score-examName-div{

        font-size: 20px;
        color: red;
    }


    .examStatus-div{
        color: gold;
    }


    .score-notice{
        margin: 5px;
    }

    .score-examScore-div{
        font-size: 35px;
        text-align: right;
        color:red;
    }

</style>


<body>
<h2>答题历史</h2>

<#list list as list>
    <div class="scoreList" bindid="${list.examId}">
        <div class="score-examId-div score-notice">No：<span class=score-examId">${list.examId}</span></div>
        <div class="score-examScore-div score-notice"> <b><span class="score-examScore">
                    <#if list.status == '1'>
                        ${list.score} 分
                    <#else>
                        未公布
                    </#if></span></b></div>
        <div class="score-examName-div score-notice"> <b><span class="score-examName"> ${list.examName}</span></b></div>

    </div>
</#list>

</body>

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>
<script>


    $(".scoreList").click(
        function (value) {
            window.location.href="../score/select/"+$(this).attr("bindid")+"/"+${Session.user.userId};
        }
    )
</script>

</html>