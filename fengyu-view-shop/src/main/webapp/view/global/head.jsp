<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<body>
<div class="head">
    <div class="head-mid">
        <span class="hd-phone">客服热线：400-025-3721</span>
        <ul class="list-unstyled nav hd-r">
            <li><a href="register.html" class="hd-regist">注册</a></li>
            <li><a href="login.html" class="hd-login">登录</a></li>
            <li><a href="/view/member/index.jsp" target="_blank" class="nicheng">我的昵称</a></li>
            <li><a href="index.html" >退出</a></li>
            <li><a href="javascript:;" class="mesage-link" target="_blank">我的消息<span class="badge">1</span></a></li>
            <li class="attent-a"><a href="javascript:;" >关注公众号</a>
                <!-------------------------------------------------------->
                <div class="gz-box">
                    <div class="gz-list">
                        <a href="javascript:;"><img src="../../statics/images/erweima.jpeg"></a>
                        <p>订阅号</p>
                        <span>每天了解泛文化咨询</span>
                    </div><div class="gz-list">
                    <a href="javascript:;"><img src="../../statics/images/erweima-server.jpeg"></a>
                    <p>服务号</p>
                    <span> 随时关注项目与活动</span>
                </div>
                </div>
            </li>
            <li><a href="http://form.mikecrm.com/5IplRy" target="_blank">意见反馈</a></li>
            <div class="clearfix"></div>
        </ul>
    </div>
</div>
</body>
<script>
    //关注订阅号
    $(".attent-a").click(function(){
        if($(".gz-box").css("display")=="none"){
            $(".gz-box").show();
        }else{
            $(".gz-box").hide();
        }
    })
    //我的消息
    $(".mesage-link").click(function(){
        window.open("index.jsp?type=6");
    })
</script>
</html>
