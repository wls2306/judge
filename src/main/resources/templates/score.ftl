<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>成绩单</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">
</head>
<#if (Session.user)??>
<#else>
    <script>
        window.location.href="../../"
    </script>
</#if>
<body>
<header class='demos-header'>
    <h1 class="demos-title" id="title1">${exam.examName}</h1>
    <h1 class="demos-title " >成绩单</h1>
</header>
<style>
    .demos-title {
        text-align: center;
        font-size: 30px;
       /* color:red;*/
       /* color: #3cc51f;*/
        font-weight: 400;
        margin: 0 15%;
    }
    #title1{
        color:red;
    }


    .demos-header{
        margin-top: 20px;
        margin-bottom: 20px;
    }

</style>
<div class="weui-form-preview">
    <div class="weui-form-preview__hd">
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">得分</label>
            <em class="weui-form-preview__value">${score.scoreResult} 分</em>
        </div>
    </div>
    <div class="weui-form-preview__bd">
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">姓名</label>
            <span class="weui-form-preview__value">${user.userName}</span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">所属组织</label>
            <span class="weui-form-preview__value">${user.userPart}</span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">考试编号</label>
            <span class="weui-form-preview__value">${exam.examId} </span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">考试名称</label>
            <span class="weui-form-preview__value">${exam.examName}</span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">答题时间</label>
            <span class="weui-form-preview__value"> ${score.scoreTime}秒</span>
        </div>


    </div>
    <div class="weui-form-preview__ft">
        <a class="weui-form-preview__btn weui-form-preview__btn_primary" href="../../../answer/mistake/${exam.examId}/${Session.user.userId}">查看错题</a>
        <a class="weui-form-preview__btn weui-form-preview__btn_primary" href="../../../score/rank/${exam.examId}">查看排名</a>
        <a class="weui-form-preview__btn weui-form-preview__btn_primary" href="javascript:history.go(-1);">返回主页</a>
    </div>

</div>

</body>

<script src="../../../js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>
<script>

</script>
</html>