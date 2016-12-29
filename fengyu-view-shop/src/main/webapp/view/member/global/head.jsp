<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="base-css.jsp"/>
<jsp:include page="base-js.jsp"/>
<script>
    $(function(){
        var username = sessionStorage.getItem("username");
        if(username == null){
            $(".head2-r a:eq(0)").show();
            $(".head2-r a:eq(1)").show();
            $(".head2-r a:eq(2)").show();
            $(".head2-r a:eq(3)").hide();
            $(".head2-r a:eq(4)").hide();
        }else{
            $("#nicheng").html(username);
            $(".head2-r a:eq(0)").hide();
            $(".head2-r a:eq(1)").hide();
            $(".head2-r a:eq(2)").hide();
            $(".head2-r a:eq(3)").show();
            $(".head2-r a:eq(4)").show();
        }
    });
</script>
<body>
<div class="head2">
    <div class="head-mid">
        <span>客服热线：400-025-3721</span>
        <p class="head2-r">
            <a href="register.html">免费注册</a>
            <a href="javascript:void(0);">|</a>
            <a href="login.html" style="display: none;">登录</a>
            <a href="login.html" id ="nicheng">ddb</a></a>
            <a href="javascript:void(0);" onclick="loginOut()">退出</a>
            <a href="http://form.mikecrm.com/5IplRy" target="_blank">帮助中心</a>
        </p>
    </div>
</div>
</body>
<script>
    function loginOut() {
        localStorage.removeItem("refreshToken");
        localStorage.removeItem("token");
        location.href = "/view/login.jsp";
    }
</script>
</html>
