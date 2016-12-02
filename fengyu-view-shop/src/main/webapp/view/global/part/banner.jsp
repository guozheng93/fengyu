<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<body>
    <div class="banner">
        <div id="slideBox" class="slideBox">
            <div class="hd">
                <ul class="list-unstyled"><li class="on"></li><li class=""></li><li class=""></li></li><li class=""></li><li class=""></li></li><li class=""></li></ul>
            </div>
            <div class="bd">
                <ul class="list-unstyled">
                    <li style="display: none;"><a href="project-detail.html" target="_blank"><img src="../../statics/images/banner.png"></a></li>
                    <li style="display:list-item;"><a href="project-detail.html" target="_blank"><img src="../../statics/images/banner.png"></a></li>
                    <li style="display: none;"><a href="project-detail.html" target="_blank"><img src="../../statics/images/banner.png"></a></li>
                    <li style="display: none;"><a href="project-detail.html" target="_blank"><img src="../../statics/images/banner.png"></a></li>
                    <li style="display:list-item;"><a href="project-detail.html" target="_blank"><img src="../../statics/images/banner.png"></a></li>
                    <li style="display: none;"><a href="project-detail.html" target="_blank"><img src="../../statics/images/banner.png"></a></li>
                </ul>
            </div>
            <a class="prev" href="javascript:void(0)"></a>
            <a class="next" href="javascript:void(0)"></a>
        </div>
        <div class="b-search"><input type="text"><img src="../../statics/images/sousuo.png"></div>
    </div>
</body>
<script type="text/javascript" src="/statics/js/jquery.SuperSlide.2.1.1.js" ></script>
<script>
    jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true,delayTime:300});
    //banner箭头显示隐藏
    $(".banner").hover(function(){
        $(".next,.prev").fadeIn();
    },function(){
        $(".next,.prev").fadeOut();
    })
</script>
