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
    <title>考试须知</title>
</head>

<style>
    .weui-msg__extra-area{
        margin-top: 40px;
    }

    .weui-msg__desc{
        text-align: left;
    }
</style>
<body>
<div class="weui-msg">
    <div class="weui-msg__icon-area"><i class="weui-icon-info weui-icon_msg"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">${(exam.examName)!'非法访问'}</h2>
        <h2 class="weui-msg__title">答题须知</h2>
        <p class="weui-msg__desc">
            ${(exam.examDesc)!'非法访问'}
        <h3>祝您取得好成绩！</h3>
        </p>
    </div>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a href="../start/${exam.examId}/${Session.user.userId}" class="weui-btn weui-btn_primary">开始答题</a>
            <a href="../../user/my" class="weui-btn weui-btn_default">返回主页</a>
        </p>
    </div>
    <div class="weui-msg__extra-area">
        <div class="weui-footer">
            <p class="weui-footer__text">Copyright © 2019 北城移动应用开发工作室</p>
        </div>
    </div>
</div>
</body>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>
</html>