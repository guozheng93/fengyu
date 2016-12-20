<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>产品众筹</title>
	<script src="/statics/js/laypage.js"></script>
</head>
<body>
<div class="warpper1">
	<!---------start head(global)---------->
	<jsp:include page="/view/global/head.jsp"/>
	<!---------end   head(global)---------->
	<!---------start banner(part)---------->
	<jsp:include page="/view/global/part/banner.jsp"/>
	<!---------start banner(part)---------->
	<!---------start nav(part)------------->
	<jsp:include page="/view/global/part/nav.jsp">
		<jsp:param name="index" value="2"/>
	</jsp:include>

	<%--我要支持点击后的 支持列表--%>
	<script id="projectList" type="text/html">
		{{each responseBody.recordList as item i}}
			<div class="pr-list">
				<div class="pr-tu-fu">
					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/pro_tu.png)" class="pr-tu"></a>
					<img src="/statics/images/zhongcouchengg.png">
				</div>
				<div class="pr-info">
					<p class="pr-p1"><b>小刀子品牌一多锂电UU车小刀子品牌一多锂电UU车</b></p>
					<p class="pr-p2"><img src="/statics/images/naozhong.png">剩余时间：<time>30</time>天</p>
					<p class="pr-p3"><span>活动</span></p>
					<p class="pr-p4"><span style="width:80%;" id="per"></span><label class="percent-show" for="per">80%</label></p>
					<ul class="pr-p5 list-unstyled">
						<li>
							<p class="pr-lp">目标金额</p>
							<p><b>¥10000</b></p>
						</li>
						<li>
							<p class="pr-lp">已筹金额</p>
							<p><b>¥10000</b></p>
						</li>
						<li class="pr-li3">
							<p class="pr-lp">支持人数</p>
							<p><b>258</b></p>
						</li>
					</ul>
				</div>
			</div>
		{{/each}}
	</script>
	<!---------start nav(part)------------->
	<!----------------------------------------------------->
	<div class="pr-box">
		<div class="pr-mid">
			<!----------------------------------------------------->
			<div class="pr-title">
				<p>分类:
					<span >全部<img src="/statics/images/yellow_icon.png"></span>
					<span>活动<img src="/statics/images/yellow_icon.png"></span>
					<span> 影视<img src="/statics/images/yellow_icon.png"></span>
					<span> 生活范<img src="/statics/images/yellow_icon.png"></span>
					<span>教育<img src="/statics/images/yellow_icon.png"></span>
					<span>其他<img src="/statics/images/yellow_icon.png"></span>
				</p>
				<p>状态:
					<span > 全部<img src="/statics/images/yellow_icon.png"></span>
					<span> 预热中<img src="/statics/images/yellow_icon.png"></span>
					<span> 众筹中<img src="/statics/images/yellow_icon.png"></span>
					<span> 众筹成功<img src="/statics/images/yellow_icon.png"></span>
					<span>项目成功<img src="/statics/images/yellow_icon.png"></span>
				</p>
				<p>排序:
					<span > 综合排序<img src="/statics/images/yellow_icon.png"></span>
					<span> 最新上线<img src="/statics/images/yellow_icon.png"></span>
					<span> 金额最多<img src="/statics/images/yellow_icon.png"></span>
					<span> 支持最多<img src="/statics/images/yellow_icon.png"></span>
					<span>即将结束<img src="/statics/images/yellow_icon.png"></span>
				</p>
			</div>
			<!----------------------------------------------------->
			<p class="pr-breadnav"><span>全部结果></span>"手机支架"</p>
			<div class="pr-lists" >
				<div id="projectListBox">

				</div>
				<!----分页--->
				<div id="pr-page"></div>
			</div>
		</div>
	</div>
	<div class="push1"></div>
</div>
<jsp:include page="../global/foot.jsp"/>

<script type="text/javascript" src="/statics/js/jquery.easing.1.3.js" ></script>
<script>
$(function(){
	var nums = 5; //每页出现的数量
	var pages =100; //得到总页数
	//调用分页
	laypage({
	cont: 'pr-page',
	pages: pages,
	jump: function(obj){
	// document.getElementById('biuuu_city_list').innerHTML = thisDate(obj.curr);
	}
	})
})
</script>
<script>
	var w_width=$(window).width();
	var ft_width=(w_width-80)/2;
	$(".ft-bord").css("width",ft_width);
	var ws_width=w_width/2;
	$(".white-s").css("width",ws_width);
	//pr-lists
	$(".pr-list").hover(function(){
		$(this).addClass("active-pr");
	},function(){
		$(this).removeClass("active-pr");
	})

	$(".pr-title span").find("img").hide();
	$(".pr-fs").find("img").show();
	//分类选择
	$(".pr-title span").click(function(){
		if($(this).css("border")=="1px solid #ffdd00"){
			$(this).css("border",0);
			$(this).find("img").hide();
		}else{
			$(this).parents("p").find("span").css("border",0);
			$(this).parents("p").find("span").find("img").hide();
			$(this).css("border","1px solid #ffdd00");
			$(this).find("img").show();
		}

	})
	$.each($(".pr-list"), function(i,e) {
		var per_w=$(e).find("#per").css("width");
		$(e).find(".percent-show").css("left",per_w);
	});

</script>
</body>
</html>
