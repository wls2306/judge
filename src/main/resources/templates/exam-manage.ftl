<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>答题管理</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">
</head>



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
    #buttonArea{
        margin-top: 100px;
    }
    #buttonArea{
        margin-top: 35px;
        margin-bottom: 35px;
    }
    .btn{
        width: 55%;
    }

    .demos-header{
        margin-top: 20px;
        margin-bottom: 20px;
    }

</style>





<body ontouchstart>

<header class='demos-header'>
    <h1 class="demos-title "id="title1">${exam.examName!'null'}</h1>
    <h1 class="demos-title " >答题管理</h1>
</header>

<div class="weui-cells">

        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>答题编号:${exam.examId!'null'}</p>
            </div>
            <div class="weui-cell__ft">${exam.examId!'null'}</div>
        </div>

    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>答题名称:</p>
        </div>
        <div class="weui-cell__ft">${exam.examName!'null'}</div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>当前状态:</p>
        </div>
        <div class="weui-cell__ft">
            <#if exam.examStatus =="0">
                <span style="color: red">未开放</span>
                <#else>
                    <span style="color: green">已开放</span>
            </#if>
        </div>
    </div>

    <div id="buttonArea">
        <a id="show-actions" class="btn weui-btn weui-btn_primary">操        作</a>
        <a href="javascript:history.go(-1);"  class="btn weui-btn weui-btn_default">返        回</a>
    </div>

</div>

</body>
<script src="../../../js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>

<script>
    $(document).on("click", "#show-actions", function() {
        $.actions({
            title: "选择操作",
            onClose: function() {
                console.log("close");
            },
            actions: [
                {
                    text: "开放答题",
                    className: "color-primary",
                    onClick: function() {
                        openExam();
                    }
                }, {
                    text: "查看未提交者姓名",
                    className: "color-primary",
                    onClick: function() {
                       unSubmit();
                    }
                } ,{
                    text: "关闭答题",
                    className: "color-warn",
                    onClick: function() {
                        closeExam();
                    }
                }, {
                    text: "公布成绩",
                    className: "color-primary",
                    onClick: function() {
                        publishExam();
                    }
                },
                {
                    text: "全体排名",
                    className: "color-warning",
                    onClick: function() {
                        window.location.href='../../../score/rank/${exam.examId}'
                    }
                },
                {
                    text: "分组排名",
                    className: 'color-danger',
                    onClick: function() {
                        window.location.href='../../../score/rank-group/${exam.examId}'
                    }
                },
                {
                    text: "组内排名",
                    className: 'color-danger',
                    onClick: function() {
                        window.location.href='../../../score/rank-ingroup/${exam.examId}'
                    }
                }
            ]
        });
    });


    function openExam() {
        $.ajax({
            url:'../../../exam/manage/open/${exam.examId}',
            method:'get',
            datatype:'JSON',
            success:function (data) {
                if (data.result===true)
                    $.toast("操作成功");
            }
        })

        setTimeout(function () {  window.location.reload(); }, 1000);

    }


    function closeExam() {
        $.ajax({
            url:'../../../exam/manage/close/${exam.examId}',
            method:'get',
            datatype:'JSON',
            success:function (data) {
                if (data.result===true)
                    $.toast("操作成功");
            }
        })
        setTimeout(function () {  window.location.reload(); }, 1000);
    }

    function publishExam() {
        $.ajax({
            url:'../../../score/publish/${exam.examId}',
            method:'get',
            datatype:'JSON',
            success:function (data) {
                if (data.result===true)
                    $.toast("操作成功");
            }
        })
    }

    function unSubmit() {
        $.ajax({
            url:'../../../exam/manage/statistics/${exam.examId}',
            method:'get',
            datatype:'JSON',
            success:function (data) {
                $.alert(data.result)
            }
        })
    }

</script>
</html>