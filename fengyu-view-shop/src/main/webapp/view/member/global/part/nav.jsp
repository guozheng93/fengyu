<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<div class="head2-nav">
    <div class="head2-mid">
        <a href="index.html"><img src="/statics/images/fy_logo.png"></a>
        <div class="h2-navlist">
            <a href="/view/home/index.jsp">众筹首页</a>
            <a href="/view/project/index.jsp">众筹列表</a>
            <a href="/view/push/form01.jsp" >发起众筹</a>
            <a href="/view/news/index.jsp" >最新资讯</a>
            <a href="/view/about/index.jsp" >关于我们</a>
        </div>
        <div class="search2">
            <input type="text" placeholder="搜索感兴趣的项目">
            <img src="/statics/images/search.png">
        </div>
    </div>
</div>
    <%--<div class="navigate">--%>
        <%--<a href="/view/home/index.jsp" <c:if test="${param.index == 1}">class='nav-active'</c:if>>众筹首页<p class="nav-active2" <c:if test='${param.index == 1}'>style="display: block;"</c:if>><span></span></p></a>--%>
        <%--<a href="/view/crowd/index.jsp" <c:if test="${param.index == 2}">class='nav-active'</c:if> >众筹列表<p class="nav-active2" <c:if test="${param.index == 2}">style="display: block;"</c:if>><span></span></p></a>--%>
        <%--<a href="javascript:;" class="faqi_zhongchou" target="push " <c:if test="${param.index ==3}">class='nav-active'</c:if>>发起众筹<p class="nav-active2" <c:if test="${param.index == 3}">style="display: block;"</c:if>><span></span></p></a>--%>
        <%--<a href="/view/news/index.jsp" <c:if test="${param.index ==4}">class='nav-active'</c:if>>最新资讯<p class="nav-active2" <c:if test="${param.index == 4}">style="display: block;"</c:if>><span></span></p> </a>--%>
        <%--<a href="/view/about/index.jsp" <c:if test="${param.index ==5}">class='nav-active'</c:if>>关于我们<p class="nav-active2" <c:if test="${param.index == 5}">style="display: block;"</c:if>><span></span></p></a>--%>
    <%--</div>--%>
</body>
<script>
    /*导航*/
    //$(".navigate a p").hide().first().show();
    $(".navigate a").click(function(){
        $(this).addClass("nav-active").siblings().removeClass("nav-active");
        $(".navigate a p").hide();
        $(this).children("p").show();
    })
</script>
