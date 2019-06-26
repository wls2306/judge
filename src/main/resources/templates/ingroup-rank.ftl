<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>组内排名</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">
</head>
<body>

<style>
    #img{
        text-align: center;
    }
    .demos-title {
        text-align: center;
        font-size: 30px;
        /* color:red;*/
        /*  color: #3cc51f;*/
        font-weight: 400;
        margin: 0 15%;
    }
    #title1{
        color:red;
    }
    #ba{
        margin-top: 35px;
    }
    #btn{
        width: 55%;
    }

    .list{
        margin: 5px;
    }

</style>

<body>
<header class='demos-header'>
    <h1 class="demos-title "id="title1">${exam.examName}</h1>
    <h1 class="demos-title " >组内排名表</h1>
</header>
<div>
    <div id="img"><img src="../../image/champion.png"> </div><#---->
</div>

<div class="weui-cells  list">
    <#list list as list>

        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>${list_index+1}、 ${list.name} (${list.part},${list.time}秒)</p>
            </div>
            <div class="weui-cell__ft">得分：${list.score}分</div>
        </div>

    </#list>
</div>

<div id="ba">
    <a href="javascript:history.go(-1);" id="btn" class="weui-btn weui-btn_primary">返        回</a>
</div>
</body>
<script src="../../js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>
</html>