<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;%>
<% String platPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"platform";%>
<%--<% String jsonPath = "http://47.88.190.192:8088/silu_api/rest/"; %>--%>
<% String jsonPath = "http://47.88.190.192:8088/silu_api/rest"; %>
<% String picPath = "http://47.88.190.192:8787"; %>
<body>
    <div class="navigate">
        <a href="<%=basePath%>/view/home/index.jsp"> 众筹首页<p><span></span></p></a>
        <a href="<%=basePath%>/view/project/index.jsp"> 众筹列表<p><span></span></p></a>
        <a href="javascript:;"> 发起众筹<p><span></span></p></a>
        <a href="<%=basePath%>/view/news/index.jsp"> 最新资讯<p><span></span></p></a>
        <a href="<%=basePath%>/view/about/index.jsp"> 关于我们<p><span></span></p></a>
    </div>
</body>
<script>
    //用于切换nav栏选中效果
    function navCheckStyleAction(curNavNode) {
        var otherNavNode=$(curNavNode).siblings();
        $(otherNavNode).children("p").removeClass("nav-active2");
        $(otherNavNode).children("p").fadeOut();
        $(curNavNode).addClass("nav-active").siblings().removeClass("nav-active");;
        $(curNavNode).children("p").addClass("nav-active2");
        $(curNavNode).children("p").fadeIn();
    }
    //获取当前地址栏，通过地址栏判断点击对象
    var browserAddress=window.location.pathname;
    var curNavNode=$(".navigate").children("a[href$='"+browserAddress+"']");
    navCheckStyleAction(curNavNode);
    /*导航*/
    //$(".navigate a p").hide().first().show();
    $(".navigate a").click(function(){
        //判断是否重复点击
        if($(curNavNode).html()==$(this).html())
            return false;
        else
            navCheckStyleAction($(this));

    })
</script>
