<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- head 中 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">
    <title>${ptitle}</title>
</head>

<style>
    .weui-msg__extra-area{
        margin-top: 40px;
    }

   /* .weui-msg__desc{
        text-align: left;
    }*/
</style>
<body>
<div class="weui-msg">
    <div class="weui-msg__icon-area"><i class="weui-icon_msg ${icon}"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">${title}</h2>
        <p class="weui-msg__desc">
            ${content}
        </p>
    </div>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a href="${bhref}" class="weui-btn ${bclass}">${bcontent}</a>
        </p>
    </div>
    <div class="weui-msg__extra-area">
        <div class="weui-footer">
            <p class="weui-footer__text">Copyright © 2019 北城移动应用开发工作室</p>
        </div>
    </div>
</div>
</body>

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>
</html>