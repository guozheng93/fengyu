<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>完成</title>
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
			<script type="text/javascript" charset="utf-8" src="/statics/js/pageScript/project/complete.js"></script>
			<div class="ir-box">
				<h3>产品众筹</h3>
				<span class="ir-tip">（*为必填）</span>
				<div class="ir-title">
					<a href="javascript:;" class="ir-a1 ">项目及发起人信息 </a>	
					<a href="javascript:;" class="ir-a2"> 回报设置</a>
					<a href="javascript:;" class="ir-a3">确认信息</a>
					<a href="javascript:;" class="ir-a4 active-ir2">完成</a>
				</div>
				<div class="comp-box">
					<h4><b>提交</b></h4>
					<div class="comp-mid">
						<img src="/statics/images/chenggong.png">
						<div class="comp-txt">
							<p>发起众筹信息填写完成</p>
                            <p>点击“预览项目”进行项目预览，点击“提交审核”进行审核</p>
						</div>
						<div class="comp-operate">
							<a href="#" class="previous-stup">上一步</a>
							<a href="javascript:;"  class="submit-audit">提交审核</a>
							<a href="#" target="_blank" class="preview-pro">预览项目</a>
						</div>
					</div>
				</div>
			</div>
			<div class="push1"></div>
		</div>
		<div class="foot">
			<p class="foot-title"><span class="ft-bord"></span><span class="ft-txt">蜂娱文化</span><span class="ft-bord ft-bord-r"></span></p>
			<div class="foot-bg" style="background-image:url(/statics/images/foot_bg.png);">
				<div class="fm-bound"></div>
				<span class="white-s ws-l"><img src="/statics/images/white_sr.png"></span>
				<span class="white-s ws-r"><img src="/statics/images/white_s.png"></span>
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
						<dd><img src="/statics/images/erweima.jpeg" class="fm-dl-code"></dd>
						
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
				jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true,delayTime:700});
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
				   //banner箭头显示隐藏
			  $(".banner").hover(function(){
			  	$(".next,.prev").fadeIn();
			  },function(){
			  	$(".next,.prev").fadeOut();
			  })
				  /*/!*提交审核*!/
				 $(".submit-audit").click(function(){
				 	layer.open({
				 		title:'温馨提示',
				 		area:'400px',
				 		content:'您的项目已提交审核，请耐心等待工作人员与您联系。',
				 		btn:'确定',
				 		yes:function(){
				 				window.location.href="person-center.html?type=2";
				 		}
				 	})
				 })*/
				 //关注订阅号
					$(".attent-a").click(function(){
						if($(".gz-box").css("display")=="none"){
							$(".gz-box").show();
						}else{
							$(".gz-box").hide();
						}
					})
			})
		</script>
	</body>
</html>
