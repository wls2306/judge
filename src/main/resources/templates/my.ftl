<#if (Session.user)??>
<#else>
    <script>
        window.location.href="../"
    </script>
</#if>
<!DOCTYPE html>
<html>
<head>
    <title>在线答题系统 欢迎您 ${(Session.user.userName)!'请登录'} !</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">

    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">

</head>

<style>

    body, html {
        height: 100%;
        -webkit-tap-highlight-color: transparent;
    }

</style>

<#if (Session.user)??>
<#else>
    <script>
        window.location.href="../../"
    </script>
</#if>


<body ontouchstart>

<div class="weui-tab" >
    <div class="weui-tab__bd">
        <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
            <#include "exam-list.ftl">
           <#-- <h1>页面一</h1>-->
        </div>
        <div id="tab2" class="weui-tab__bd-item">
              <#-- <h1>页面二</h1>-->
        </div>
        <div id="tab3" class="weui-tab__bd-item">
            <#include "my-info.ftl">
            <#--<h1>页面三</h1>-->
        </div>
    </div>

    <div class="weui-tabbar">
        <a href="#tab1" class="weui-tabbar__item weui-bar__item--on">
            <div class="weui-tabbar__icon">
                <img src="../image/paper.png" alt="">
            </div>
            <p class="weui-tabbar__label">当前考试</p>
        </a>
        <a href="#tab2" class="weui-tabbar__item">
            <div class="weui-tabbar__icon">
                <img src="../image/history.png" alt="">
            </div>
            <p class="weui-tabbar__label">考试历史</p>
        </a>
        <a href="#tab3" class="weui-tabbar__item">
            <div class="weui-tabbar__icon">
                <img src="../image/me.png" alt="">
            </div>
            <p class="weui-tabbar__label">我的</p>
        </a>

    </div>
</div>

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>

<script>
    $(document).ready(function () {
        $.ajax({
            url:'../score/select/${Session.user.userId}',
            method:'get',
            datatype:'html',
            success:function (data) {
                $("#tab2").html(data);
            }
        })
    })

</script>

</body>
</html>
