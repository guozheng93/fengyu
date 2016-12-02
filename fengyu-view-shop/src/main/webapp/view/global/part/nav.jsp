<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
    <div class="navigate">
        <a href="/view/home/index.jsp" <c:if test="${param.index == 1}">class='nav-active'</c:if>>众筹首页<p class="nav-active2" <c:if test='${param.index == 1}'>style="display: block;"</c:if>><span></span></p></a>
        <a href="/view/project/index.jsp" <c:if test="${param.index == 2}">class='nav-active'</c:if> >众筹列表<p class="nav-active2" <c:if test="${param.index == 2}">style="display: block;"</c:if>><span></span></p></a>
        <a href="javascript:;" class="faqi_zhongchou" target="push " <c:if test="${param.index ==3}">class='nav-active'</c:if>>发起众筹<p class="nav-active2" <c:if test="${param.index == 3}">style="display: block;"</c:if>><span></span></p></a>
        <a href="/view/news/index.jsp" <c:if test="${param.index ==4}">class='nav-active'</c:if>>最新资讯<p class="nav-active2" <c:if test="${param.index == 4}">style="display: block;"</c:if>><span></span></p> </a>
        <a href="/view/about/index.jsp" <c:if test="${param.index ==5}">class='nav-active'</c:if>>关于我们<p class="nav-active2" <c:if test="${param.index == 5}">style="display: block;"</c:if>><span></span></p></a>
    </div>
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
