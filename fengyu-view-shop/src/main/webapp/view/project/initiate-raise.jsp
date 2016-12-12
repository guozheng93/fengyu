<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<script id="crdfdEntityItem" type="text/html">
			{{each responseBody.recordList as item i}}
				<span itemId="{{item.id}}">{{item.itemName}}</span>
			{{/each}}
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>发起众筹</title>
		<%--<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/skin/layer.css" />
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/index.css" />--%>
		<jsp:include page="/view/global/base-css.jsp"/>
		<jsp:include page="/view/global/base-js.jsp"/>
		<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
	    <script type="text/javascript" charset="utf-8" src="/ueditor/uemy.js"> </script>
	    <script type="text/javascript" charset="utf-8" src="/ueditor/zh-cn.js"></script>
		<script type="text/javascript" charset="utf-8" src="/statics/js/pageScript/project/initiate-raise.js"></script>
		<!--webuploader 文件上传-->
		<link rel="stylesheet" type="text/css" href="/ueditor/third-party/webuploader/webuploader.css">
		<script type="text/javascript" src="/ueditor/third-party/webuploader/webuploader.js"></script>
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
			<!--------------------------------------------------------->

			<!----------------------------------------------------->
			<div class="ir-box">
				<h3>产品众筹</h3>
				<span class="ir-tip">（*为必填）</span>
				<div class="ir-title">
					<a href="javascript:;" class="ir-a1 active-ir">项目及发起人信息 </a>	
					<a href="javascript:;" class="ir-a2"> 回报设置</a>
					<a href="javascript:;" class="ir-a3">确认信息</a>
					<a href="javascript:;" class="ir-a4">完成</a>
				</div>
				<div class="ir-con">
					<h4 class="faqi"><b>发起项目</b></h4>
					<input belongTo="crdfdEntity" id="prjtOrganiserId" type="hidden" value="">
					<input id="prjtId" type="hidden" value="">
					<div class="ir-info">
						<p class="ir-info-p">项目信息</p>
						<div class="ir-list">
							<span class="ir-l-s">项目类型：</span>
							<p class="ir-l-p" id="crdfdEntityItemContainer"></p>
						</div>
						<div class="ir-list">
							<span class="ir-l-s">项目名称：</span>
							<input belongTo="crdfdEntity" id="prjtName" type="text" placeholder="不超过20个字" class="pro-name">
						</div>
						<div class="ir-list">
							<span class="ir-l-s no-required">项目简介：</span>
							<input belongTo="crdfdEntity" id="prjtSummary" type="text" placeholder="请简要概述您的项目，长度不超过200个字" class="pro-beif">
							<p class="ir-l-tip">项目简介是会显示在蜂娱众筹首页的~</p>
						</div>
						<div class="ir-list">
							<span class="ir-l-s">筹资金额：</span>
							<div class="raise-amout">
							<input belongTo="crdfdEntity" id="prjtRaiseAmount" type="text" placeholder="整数且不少于100元">
							<span >元</span>
							</div>
						</div>
						<div class="ir-list">
							<span class="ir-l-s">筹资上限：</span>
							<div class="raise-amout">
							<input belongTo="crdfdEntity" id="prjtRaiseToplimit" type="text" placeholder="整数且不低于100%">
							<span >%</span>
							<p class="ir-l-tip2">填0是无上限</p>
							</div>
						</div>
						<div class="ir-list">
							<span class="ir-l-s">筹资天数：</span>
							<div class="raise-amout">
							<input belongTo="crdfdEntity" id="prjtFundCycle" type="text" placeholder="10~60天" style="border-right:1px solid #a9a9a9">
							</div>
						</div>
						
						<div class="ir-list le-list">
							<span class="ir-l-s">列表页图片：</span>
							<div id="crdfdListImageContainer" class="ir-le-tu">
								<a id="crdfdListImagePicker" href="javascript:;" class="a-upload"><input type="file"><img src="/statics/images//tu_icon.png">上传列表页图片</a>
								<small class="ir-l-tip3">支持ipg、jpeg、png、gif格式，大小：378pxx280px</small>
							    <div  id="crdfdListImageThumbnail" class="le-tu-show" style="background-image:url(/statics/images//default_tu.png)"><img belongTo="crdfdEntity" id="entityCatalogImage" src=""></div>
							</div>
						</div>
						<div class="ir-list le-list">
							<span class="ir-l-s">设置封面：</span>
							<div class="ir-le-tu">
								<a id="crdfdCoverImagePicker" href="javascript:;" class="a-upload"><input type="file"><img src="/statics/images//tu_icon.png">上传项目封面图片</a>
								<small class="ir-l-tip3">支持ipg、jpeg、png、gif格式，大小：750x600px </small>
							    <div id="crdfdCoverImageThumbnail" class="le-tu-show" style="background-image:url(/statics/images//default_tu.png)"><img belongTo="crdfdEntity" id="entityCoverImage" src=""></div>
							</div>
						</div>
						<div class="ir-list le-list">
							<span class="ir-l-s">项目详情：</span>
							<div class="ir-le-tu">
								<p class="le-advice">建议尺寸：750px宽，高度不限</p>
								<div class="edit-txt">
									 <script id="editor" type="text/plain"  style="width: 100%;min-height:380px"></script>
								</div>
							</div>
						</div>
					</div>
					<div class="ir-info ir-info-2">

						<p class="ir-info-p">发起人信息</p>
						<div class="ir-list">
							<span class="ir-l-s">自我介绍：</span>
							<textarea belongTo="crdfdOrganiser" id="orgnrResume" placeholder="向支持者详细介绍你自己或你的团队，并详细说明你与所发起的项目之间的背景，让支持者能够在最短时间内了解你，以拉近彼此之间的距离，不可超过160字。" class="self-introduce"></textarea>
						</div>
						<div class="ir-list">
							<span class="ir-l-s no-required">微博/博客：</span>
							<input belongTo="crdfdOrganiser" id="orgnrBlog" type="text" placeholder="微博/博客地址(选填)" class="pro-beif">
						</div>
						<div class="ir-list">
							<span class="ir-l-s no-required">至支持者的感谢信：</span>
							<textarea belongTo="crdfdOrganiser" id="orgnrBlessWord" class="self-introduce"></textarea>
						</div>
						<div class="ir-list">
							<span class="ir-l-s">联系电话：</span>
							<input belongTo="crdfdOrganiser" id="orgnrTelephone" type="text" placeholder="此信息不会显示在发起人详情页中" class="pro-beif">
						</div>
					</div>
					<div class="ir-operate">
						<a href="#" class="next-stup">下一步</a><a href="javascript:;" class="save">保存草稿</a>
					</div>
				</div>
			</div>
			<div class="push1"></div>
		</div>
		<div class="foot">
			<p class="foot-title"><span class="ft-bord"></span><span class="ft-txt">蜂娱文化</span><span class="ft-bord ft-bord-r"></span></p>
			<div class="foot-bg" style="background-image:url(/statics/images//foot_bg.png);">
				<div class="fm-bound"></div>
				<span class="white-s ws-l"><img src="/statics/images//white_sr.png"></span>
				<span class="white-s ws-r"><img src="/statics/images//white_s.png"></span>
				<div class="foot-mid">
					<dl class="fm-dl">
						<dt>帮助与条款</dt>
						<dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=3&sn=f5cd064525e88bf8b69f38f4493f7201&chksm=ec3e466cdb49cf7a215d296a0861349a44f35b47848de908f7a978357e52bc008efe4eba7550&mpshare=1&scene=1&srcid=1012dgLJkF4BWLkXWDeNTk2H#rd" target="_blank">用户服务协议</a></dd>
						<dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=5&sn=c30b81e8bf9efb2e6709f08de22bade9&chksm=ec3e466cdb49cf7ae7cb9fc7c42f157ad4b2883785042c7b782eb31552b56e383709e26bf4b2&mpshare=1&scene=1&srcid=1012Uf8gtfHjB4Fbg4tNCuej&from=singlemessage&isappinstalled=0#wechat_redirect" target="_blank">支持者指南</dd>
						<dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=1&sn=4b7078898aa345639ef5a0df64fb9114&chksm=ec3e466cdb49cf7aca256d32bbfded2b0acc63421feb7161b74ce97ea2e1085c501807512a76&mpshare=1&scene=1&srcid=1012wbf2VIMaKoBnVp5Hjsg5#rd" target="_blank">项目规范</a></dd>
						<dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=4&sn=72ec5433e0c75a2edbab00170188cbfd&chksm=ec3e466cdb49cf7aa7748b15827705a3837fe33bdc466ad58c72eadbe9a15136002f4a607205&mpshare=1&scene=1&srcid=10123FK8KVViYqkz0WcP3QRk#rd" target="_blank">常见问题</a></dd>
						<dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=2&sn=0ef927f91a0b20dae3206124f4fe62b4&chksm=ec3e466cdb49cf7a3bf5ca44dcb29273a61fa2777e38729feb974eac5bbc7468e447bf4131b3&mpshare=1&scene=1&srcid=1012khnHNk8HULOT8xZazDUA#rd" target="_blank">信任和安全</a></dd>
					</dl>
					<dl class="fm-dl">
						<dt>关注我们</dt>
						<dd><a href="javascript:;">关注蜂娱文化公众号</a></dd>
						<dd><img src="/statics/images//erweima.jpeg" class="fm-dl-code"></dd>
						
					</dl>
					<dl class="fm-dl">
						<dt>联系我们</dt>
						<dd><a href="javascript:;">客服热线（9：00-17：00）</a></dd>
						<dd><a href="javascript:;" class="fm-phone">400-025-3721<a></dd>
						<dd><a href="javascript:;">Email：fy_culture@163.com</a></dd>
						<dd><a href="javascript:;" style="margin:0 10px;display: block;line-height: 18px;">Add：山东省济南市高新区经十东路8000号龙奥金座1号楼1A层</a></dd>
					</dl>
					<dl class="fm-dl fm-dl-last">
						<dt>合作伙伴</dt>
						<dd class="hezuo-a">
							<a href="javascript:;">国钰投资 </a>
							<a href="javascript:;">驷鹿电商</a>
							<a href="javascript:;">搭伙校园</a>
							<a href="javascript:;">万数技术</a>
							<a href="javascript:;">钉钉</a>
							<a href="javascript:;">阿里云</a>
						</dd>
					</dl>
				</div>
			    <div class="copyright">
			    	<p>Copyright  2016 山东星万蜂娱网络科技有限公司  鲁ICP备16015631号-1  www.360fengyu.com</p>
			    </div>
			</div>
		</div>

		<script>
			$(function(){
				jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true,delayTime:300});
				$(function(){
				var w_width=$(window).width();
					var ft_width=(w_width-80)/2;
					$(".ft-bord").css("width",ft_width);
				    var ws_width=w_width/2;
				    $(".white-s").css("width",ws_width);
				/*导航*/
				$.each($(".navigate a"), function(i,e) {
					if($(e).hasClass("nav-active")){
						$(e).find("p").show();
					}
				});
				  $(".navigate a").click(function(){
				  	$(this).addClass("nav-active").siblings().removeClass("nav-active");
				  	$(".navigate a p").hide();
				  	$(this).children("p").show();
				  })
				  /*选择项目类型*/
				 $(".ir-l-p span").click(function(){
				 	$(this).addClass("active-span").siblings().removeClass("active-span");
				 })
				  //banner箭头显示隐藏
			  $(".banner").hover(function(){
			  	$(".next,.prev").fadeIn();
			  },function(){
			  	$(".next,.prev").fadeOut();
			  })
				 //关注订阅号
				$(".attent-a").click(function(){
					if($(".gz-box").css("display")=="none"){
						$(".gz-box").show();
					}else{
						$(".gz-box").hide();
					}
				})   

				})
			})
		</script>
		<script>
			//实例化编辑器
		    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		    var ue = UE.getEditor('editor'); 
		   
		</script>
	</body>
</html>
