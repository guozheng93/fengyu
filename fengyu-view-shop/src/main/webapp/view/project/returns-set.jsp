<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>回报设置</title>
		<jsp:include page="/view/global/base-css.jsp"/>
		<jsp:include page="/view/global/base-js.jsp"/>
		<!--webuploader 文件上传-->

	</head>
	<body>
		<script id="crdfdRepayList" type="text/html">
			{{each responseBody.recordList as item i}}
				<tr>
					<td class="col-lg-1">{{i+1}}</td>
					<td class="col-lg-1 zhifu-money">{{item.repayPrice}}元</td>
					<td class="col-lg-1">{{item.repayLimitAmount}}</td>
					<td class="col-lg-4 hb-txt">{{item.repayDetail}}</td>
					<td class="col-lg-2">项目结束后{{item.repayTime}}天 </td>
					<td class="col-lg-1 zhifu-money">
						{{if item.repayExpressFee=='0'}}
							包邮
						{{else}}
							{{item.repayExpressFee}}
						{{/if}}
					</td>
					<td repayId="{{item.id}}" class="col-lg-2"><a href="javascript:;" class="hb-edit">编辑</a><a href="javascript:;" class="hb-del">删除</a></td>
				</tr>
			{{/each}}
		</script>
		<form id="validateForm">
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
			<script src="/statics/js/lib/jquery.scrollTo.min.js"></script>
			<script src="/statics/js/lib/jquery-validate/jquery.validate.min.js"></script>
			<script  src="/statics/js/lib/jquery-validate/messages_zh.js"></script>
			<script type="text/javascript" charset="utf-8" src="/statics/js/lib/jquery-validate/additional-methods.js"></script>
			<link rel="stylesheet" type="text/css" href="/ueditor/third-party/webuploader/webuploader.css">
			<script type="text/javascript" src="/ueditor/third-party/webuploader/webuploader.js"></script>
			<script type="text/javascript" charset="utf-8" src="/statics/js/pageScript/project/returns-set.js"></script>
			<div class="ir-box">
				<h3>产品众筹</h3>
				<span class="ir-tip">（*为必填）</span>
				<div class="ir-title">
					<a href="javascript:;" class="ir-a1">项目及发起人信息 </a>	
					<a href="javascript:;" class="ir-a2 active-ir"> 回报设置</a>
					<a href="javascript:;" class="ir-a3">确认信息</a>
					<a href="javascript:;" class="ir-a4">完成</a>
				</div>
				<div class="rs-main">
					<h4 class="huibao"><b>回报设置</b></h4>
					<table class="table">
						<thead>
							<th>序号</th>
							<th>支付金额</th>
							<th>名额</th>
							<th>回报内容</th>
							<th>回报时间</th>
							<th>运费</th>
							<th>操作</th>
						</thead>
						<tbody class="rs-tbody" id="crdfdRepayListContainer">

						</tbody>
					</table>
					<p class="add-hb">添加回报选项</p>
					<div class="hb-cen">
						<div class="hb-list">
							<span class="hb-l">回报类别:</span>
							<div class="hb-r"><span  class="hb-kind"><input name="repayType" value="entity" belongTo="crdfdRepay" type="radio" name="kind" checked="checked">实物回报</span><span  class="hb-kind"><input name="repayType" belongTo="crdfdRepay" value="virtual" type="radio" name="kind">虚拟物品回报(电子码等)</span></div>
						</div>
						<div class="hb-list">
							<span class="hb-l">支付金额:</span>
							<div class="hb-r pay-num">
							<input name="repayPrice" belongTo="crdfdRepay" type="text" placeholder="整数且不少于100元">
							<span>元</span>
							</div>
							<span style="color: red;">"0"为不限金额</span>
						</div>
						<div class="hb-list">
							<span class="hb-l">回报内容:</span>
							<div class="hb-r">
							   <textarea name="repayDetail" belongTo="crdfdRepay" placeholder="请简要概述该档位的回报内容(最多不要超过200字)"></textarea>
							</div>
						</div>
						<div class="hb-list">
							<span class="hb-l">回报缩略图:</span>
							<div class="hb-r">
								<a id="repayImageThumbnailPicker" href="javascript:;" class="a-upload"><input type="file"><img src="/statics/images/tu_icon.png">上传列表页图片</a>
								<small class="ir-l-tip3">支持jpg、jpeg、png、gif格式，大小： 80px*50px </small>
							    <div id="repayImageThumbnailThumbnail" class="le-tu-show" style="background-image:url(/statics/images/default_tu.png)">
									<img name="repayImageThumbnail" belongTo="crdfdRepay" src="/statics/images/default_tu.png">
								</div>
							</div>
						</div>
						<div class="hb-list">
							<span class="hb-l">回报大图:</span>
							<div class="hb-r">
								<a id="repayImagePicker" href="javascript:;" class="a-upload"><input type="file"><img src="/statics/images/tu_icon.png">上传列表页图片</a>
								<small class="ir-l-tip3">支持jpg、jpeg、png、gif格式，大小： 800px*500px </small>
							    <div id="repayImageThumbnail" class="le-tu-show" style="background-image:url(/statics/images/default_tu.png)">
									<img name="repayImage" belongTo="crdfdRepay" src="/statics/images/default_tu.png">
								</div>
							</div>
						</div>
						<div class="hb-list">
							<span class="hb-l">添加回报属性:</span>
							<div name="itemProp" class="hb-r hb-attr">
								<input  type="text" class="add-input"><a href="javascript:;">+添加</a>
							</div>
						</div>
						<div class="hb-list">
							<span class="hb-l">支持者备注填写提示:</span>
							<div class="hb-r beizhu-info">
								<p class="beizhu1"><input name="repayNeedRemark" belongTo="crdfdRepay" value="1" type="radio" checked="checked" name="is-beizhu">是<input name="repayRemark" belongTo="crdfdRepay" type="text" placeholder="此处填写内容为支持者提交订单填写备注时，在他们在备注栏看到的提示信息。" class="beizhu-txt"><span style="color:red;margin-left: 4px;">友情提示:请确认该信息为支持者必填.</span></p>
							    <p class="beizhu2"><input name="repayNeedRemark" belongTo="crdfdRepay" value="0" type="radio"  name="is-beizhu">否</p>
							</div>
						</div>
						<%--<div class="hb-list">
							<span class="hb-l">是否限定名额:</span>
							<div class="hb-r xiane-in">
								<span><input name="repayLimitAmount" belongTo="crdfdRepay" value="0" type="radio" name="xiane" checked="checked">否</span><span><input type="radio" name="repayType" belongTo="crdfdRepay" value="1" name="xiane">是</span><span style="color:#CCCCCC;">（限定名额不能为"0")</span>
							</div>
						</div>--%>
						<div class="hb-list">
							<span class="hb-l">限定名额:</span>
							<div class="hb-r set-e">
								<input name="repayLimitAmount" belongTo="crdfdRepay" type="text" placeholder="0"><span style="color: #CCCCCC;">“0”位不限名额</span>
							</div>
						</div>
						<div class="hb-list">
							<span class="hb-l">运费:</span>
							<div class="hb-r yunfei">
								<input name="repayExpressFee" belongTo="crdfdRepay" type="text" placeholder="0"><span class="yuan-btn">元</span><span style="color: #CCCCCC">“0”为包邮</span>
							</div>
						</div>
						<div class="hb-list">
							<span class="hb-l">发票:</span>
							<div class="hb-r fapiao-select">
								<span><input name="repayInvoiceFlag" belongTo="crdfdRepay" value="0" type="radio" name="fapiao" checked="checked">不可开发票</span><span><input name="repayInvoiceFlag" belongTo="crdfdRepay" value="1" type="radio" name="fapiao">可开发票  （包括个人发票和自定义抬头发票）<input name="repayInvoiceRemark" belongTo="crdfdRepay" type="text" placeholder="发票抬头"></span>
							</div>
						</div>
						<div class="hb-list">
							<span class="hb-l">回报时间:</span>
							<div class="hb-r">
								<p>项目结束后<input name="repayTime" belongTo="crdfdRepay" type="number" class="tianshu" placeholder="0">天，将会向支持者发送回报</p>
							</div>
						</div>
						<div class="add-hb-btn">
							<a href="javascript:;" class="add-true">确定</a>
							<a href="javascript:;" class="add-false">取消</a>
						</div>
					</div>
				    <div class="warm-prompt">
				    	<h5><b>温馨提示：</b></h5>
				    	<p>您可以设置多个回报呦，多些选择能提高项目的支持率；多个回报建议为不同档次的回报，能让你的项目更快成功。</p>
				    	<p>回报内容最好是项目的衍生品，与项目内容有关的回报更能吸引到大家的支持.</p>
				    </div>
				    <div class="rs-operate">
					<a href="initiate-raise.html" class="previous-stup">上一步</a><a href="javascript:;" class="save">保存草稿</a><a href="#" class="next-stup">下一步</a>
				    </div>
				</div>
			</div>
			<div class="push1"></div>
		</div>
		</form>
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
			  /*选择回报属性*/
			 $(".hb-attr span").css("background-image",'none');
			 select_return();
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
		</script>
		<script>
			$(function(){
				 /*/!*删除操作*!/
				$.each($(".rs-tbody tr"), function(i,e) {
					$(e).find(".hb-del").click(function(){
						layer.open({
							title:'温馨提示',
							content:'确定要删除吗？',
							btn:['确定','取消'],
							yes:function(){
								$(e).remove();
								$(".layui-layer-shade,.layer-anim").hide();
							}
						})	
					})
				});*/
			
			 /*/!*保存*!/
			$(".save").click(function(){
				layer.open({
					shadeClose:true,
        			closeBtn:1,
        			area:'600px',
        			title:'',
					content:'<p class="save-tip">您的信息已更新保存成功</p>'+'<p class="save-tip">点击“下一步”将默认保存填写信息</p>'+'<p class="save-tip">您可到<a href="javascript:;">“个人中心”</a>——<a href="javascript:;">“我发起的项目”</a>，查看与编辑保存的信息</p>',
				    btn:['我知道了','不再提示']
				})
			})
			  /!*取消*!/
 			   $(".add-false").click(function(){
 			   	layer.open({
 			   		title:'温馨提示',
 			   		area:'300px',
 			   		content:'取消后，将清空此档位所填写的信息，确认取消么？',
 			   		btn:['确认取消','暂不取消']
 			   	})
 			   })*/
			})
		</script>
	</body>
</html>
