<#if (Session.user)??>
<#else>
    <script>
        window.location.href="../../"
    </script>
</#if>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">
    <title>我的信息</title>
</head>
<style>
    .demos-title {
        text-align: center;
        font-size: 30px;
        /* color:red;*/
         color: #3cc51f;
        font-weight: 400;
        margin: 0 15%;
    }
    #btn{
        width: 55%;
    }

    #ba{
        margin-top: 40px;
    }

    .demos-header{
        margin-top: 20px;
        margin-bottom: 20px;
    }
</style>

<body>

<header class='demos-header'>
    <h1 class="demos-title "id="title1">我的信息</h1>
   <#-- <h1 class="demos-title " >成绩单</h1>-->
</header>

<div class="weui-cells">
    <div class="weui-cells__title">您好,${Session.user.userName}! 欢迎使用在线答题系统</div>

        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>编号：</p>
            </div>
            <div class="weui-cell__ft">${Session.user.userId}</div>
        </div>

        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>姓名：</p>
            </div>
            <div class="weui-cell__ft">${Session.user.userName}</div>
        </div>

        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>所属组织编号：</p>
            </div>
            <div class="weui-cell__ft">${Session.user.userPart}</div>
        </div>

</div>
<div id="ba">
    <a href="../" id="btn" class="weui-btn weui-btn_default">退出登录</a>
</div>
</body>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>
</html>