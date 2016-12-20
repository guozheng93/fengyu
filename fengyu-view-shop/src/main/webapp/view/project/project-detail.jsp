<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>项目详情</title>
		<link rel="stylesheet" href="/statics/css/page/project/project.css" />
	</head>
	<body>
		<div class="warpper1">


			<!--------------------------------------------------------->
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


			<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
			<script type="text/javascript" charset="utf-8" src="/ueditor/uemy.js"> </script>
			<script type="text/javascript" charset="utf-8" src="/ueditor/zh-cn.js"></script>
			<script src="/statics/js/lib/jquery.scrollTo.min.js"></script>
			<script src="/statics/js/jquery-browser.js"></script>
			<script src="/statics/js/jquery.qqFace.js"></script>
			<script src="/statics/js/lib/layer/laypage.js"></script>
			<script type="text/javascript" charset="utf-8" src="/statics/js/pageScript/project/project-detail.js"></script>
			<script id="crdfdEntityRepayList" type="text/html">
				{{each responseBody.recordList as item i}}
				<div repayId="{{item.id}}" class="support-list">
					<p class="sl-title"><span class="sl-t-money">￥{{item.repayPrice}}</span><span class="sl-t-number">{{item.sumOrders4Repay}}位支持者</span></p>
					<div class="sl-p1">
						<h5><b>{{item.repayLimitAmount}}</b></h5>
						<p>{{item.repayDetail}}</p>
						<p class="sl-p2" style="background-image:url({{transToServerUrl item.repayImageThumbnail}})"><img src="/statics/images/magnify.png"></p>
						<p class="sl-p3">配送费用：<span>{{item.repayExpressFee}}</span></p>
						{{each item.crdFdItemProps as itemProp j}}
							<p class="sl-p3">
								<i>{{itemProp.propName}}:</i>
								{{each itemProp.propValues as propValue j}}
									<span>{{propValue.propValueName}}</span>
								{{/each}}
							</p>
						{{/each}}
						<p class="sl-p3">预计回报发送时间：<span>项目成功结束后<span style="color:#ff6162">{{item.repayTime}}</span>天内</span></p>
						<p class="sl-p4">
							<a href="/view/order/order-submit.jsp?prjtId={{item.prjtId}}&repayId={{item.id}}">
								支持￥{{item.repayPrice}}
							</a>
						</p>
					</div>
					<!------------------放大----------------------------------->
					<div><img class="amplification" src="{{transToServerUrl item.repayImage}}"/></div>
				</div>
				{{/each}}
			</script>
			<%--我要支持点击后的 支持列表--%>
			<script id="supportList4ISupport" type="text/html">
				{{each responseBody.recordList as item i}}
					<tr>
						<td class="col-lg-1 sup-check"><input value="{{item.id}}" type="radio" name="sup-check"></td>
						<td class="col-lg-1 text-danger">￥{{item.repayPrice}}</td>
						<td class="col-lg-2">{{item.repayPrice}}</td>
						<td class="col-lg-2">{{item.repayLimitAmount}}</td>
						<td class="col-lg-3 return-con">{{item.repayDetail}}</td>
						<td name="prjtEndTime4Repay" class="col-lg-2"></td>
					</tr>
				{{/each}}
			</script>
			<script id="crdfdEntityDynamicsList" type="text/html">
				{{each responseBody.recordList as item i}}
				<div class="dynamic-list dyl2">
					<img src="/statics/images/lu12.png">
					<span class="dy-time">{{long2Date item.publicityTime}}</span>
					<p>{{item.message}}</p>
					<ul id="" class="list-unstyled dy-tu">
						{{each item.publicityImgs as img i}}
						<li><img src="{{transToServerUrl img.publicityImage}}"></li>
						{{/each}}
					</ul>
				</div>
				{{/each}}
			</script>
			<script id="prjtOrderList" type="text/html">
				{{each responseBody.recordList as item i}}
				<div class="pro-sustain">
					<span style="background-image:url(/statics/images/pro_tu.png)" class="sup-head"></span>
					<span class="sup-name">{{item.orderPartyA}}</span>
					<span class="sup-time">交易时间：<time>{{long2Date item.orderTime}}</time></span>
					<span class="sup-money">支持金额：<span style="color:#ff6162;">{{item.orderAmt}}元</span></span>
				</div>
				{{/each}}
			</script>

			<%--发表主题，评论项目模板--%>
			<!----发表的人----->
			<script id="topicContent" type="text/html">
				<div commentId="{{id}}" class="comm-list-box">
					<span style="background-image:url(/statics/images/pro_tu.png)" class="comm-head"></span>
					<div class="comm-info">
						<p class="comm-p1"><span>{{fromUid}}:</span>{{commentContent}}</p>
						<p class="comm-p2"><span>{{long2Date commentTime}}</span><span fromUid="{{fromUid}}" class="reply">回复</span><%--<span class="comm-zan1">赞（<b>25</b>）</span>--%></p>
					</div>
				</div>
			</script>


			<!---回复内容-------->
			<%--回复主题模板--%>
			<script id="replyContent" type="text/html">
				<div replyId="{{id}}" commentId="{{commentId}}" class="comm-list-replay">
					<span style="background-image:url(/statics/images/pro_tu.png)" class="comm-head"></span>
					<div class="comm-info">
						<p class="comm-p1"><span name="fromUid">{{fromUid}}回复{{toUid}}：</span>{{replyContent}}</p>
						<p class="comm-p2"><span>{{daysAgo replyTime}}</span><span fromUid="{{fromUid}}" class="reply">回复</span><%--<span class="comm-zan1">赞（<b>25</b>）</span>--%></p>
					</div>
				</div>
			</script>

			<%--回复回复模板--%>
			<!------回复对话框------->
			<script id="replayTextArea" type="text/html">
				<div class="comm-reply">
					<textarea id="replyInput" class="comm-reply1" replyType="{{replyType}}" toUid="{{toUid}}"></textarea>
					<p class="word-tip"><span class="demo1" id="replyEmotion" ><img src="/statics/images/smail.png"></span>还可以输入140字<a commentId="{{commentId}}" replyId="{{replyId}}" href="javascript:;">回复</a></p>
				</div>
			</script>
			<%--<div class="head2">
				<div class="head-mid">
					<span>客服热线：400-025-3721</span>
					<p class="head2-r"><a href="register.html">免费注册</a>|<a href="login.html">登录</a><a href="http://form.mikecrm.com/5IplRy" target="_blank">帮助中心</a></p>
				</div>
			</div>
			<div class="head2-nav">
				<div class="head2-mid">
					<a href="index.html"><img src="/statics/images/fy_logo.png"></a>
					<div class="h2-navlist">
						<a href="index.html" >众筹首页</a>
						<a href="products-raise.html" >众筹列表</a>
						<a href="initiate-raise.html">发起众筹</a>
						<a href="latest-news.html" >最新资讯</a>
						<a href="about-us.html" >关于我们</a>
					</div>
					<div class="search2">
						<input type="text" placeholder="搜索感兴趣的项目">
						<img src="/statics/images/search.png">
					</div>
				</div>
			</div>--%>
			
			<!--------------------------------------------------------->
			<div class="pro-d-box">
				<!----------------------------------------------------->
				<div class="pro-d-l">
					<div >
						<img name="entityCoverImage" class="pro-d-tu" src="/statics/images/prodetail.png"/>
					</div>
					<!----------------------------------------->
					<ul class="list-unstyled pro-d-ul">
						<li class="pro-li1"><a href="javascript:;" class="active-proa">项目详情</a></li>
						<li><a href="javascript:;">项目动态</a><p name="prjtDynamics"></p></li>
						<li><a href="javascript:;">项目支持</a><p name="prjtOrders"></p></li>
						<li><a href="javascript:;">评论</a><p name="prjtComments"></p></li>
					</ul>
					
					<div name="prjtDetail" class="pro-d-con pro-detail">
						<img src="/statics/images/prodetaio_tu.png">
					</div>
					<div id="crdfdEntityDynamicsListBox" class="pro-d-con dynamic">

					</div>
					<div id="prjtOrderListBox" class="pro-d-con">


					</div>
					<div class="pro-d-con pro-comments">
						<div class="talk">
							<img src="/statics/images/talk.png" class="talk-tit">
							<textarea class="comm-reply1" id="topicTextArea"></textarea>
							<p class="talk-p1"><span class="emotion" id="topicEmotion"><img src="/statics/images/smail.png"></span><span>您还可以输入140个字</span><a href="javascript:;" class="fabu-huati">发布话题</a></p>
						</div>
						<div class="comm-list">


						</div>
						<!----分页--->
					    <div id="pr-page"></div>
					</div>
				</div>
				<!----------------------------------------------------->
				<div class="pro-d-r">
					<div class="pro-r-txt">
						<p class="pro-state" style="background-image:url(/statics/images/pro_state.png)">
							<span name="prjtStatus">众筹中</span>
							<span style="display: none;">预热中</span>
							<span style="display: none;">项目成功</span>
							<span style="display: none;">项目失败</span>
							<span style="display: none;">众筹成功</span>
							<span style="display: none;">众筹失败</span></p>
						<p name="prjtName" class="pro-t-p1">A Cappella--边走边唱的青春之旅--边走边唱的青春之旅--边走边唱的青春之旅</p>
						<div class="pro-t-p3">
							<span style="background-image:url(/statics/images/qujie2.png)" class="pro-bg1"></span>
							<span style="background-image:url(/statics/images/qujie.png)" class="pro-bg2"></span>
							<p class="pro-t-p4">已筹集：¥<i name="prjtSumAmt"></i></p>
							<p class="pro-t-p5"><span name="prjtTargetScheduleView" style=""></span></p>
							<p class="pro-t-p6"><span  class="pro-s1">当前进度：<i name="prjtTargetSchedule"></i>%</span><span class="pro-s2"><i name="prjtsumSupportors"></i>位支持者</span></p>
						</div>
						<p class="pro-t-p7">此项目必须在 <span name="prjtEndTime"></span>前得到<span name="prjtFundingResidueAmt"></span>的支持才可成功！剩余 <span name="prjtFundingResidueDays"></span>天!</p>
						<p class="pro-t-p8">分享到：
							<a href="javascript:;"><img src="/statics/images/wx.png"></a>
							<a href="javascript:;"><img src="/statics/images/qq.png"></a>
							<a href="javascript:;"><img src="/statics/images/wb.png"></a>
						</p>
						<div class="pro-t-p9">
							<p class="zan-p"><img src="/statics/images/zan.png">赞(<span name="crdFdTotalPraise">0</span>)</p>
							<p class="guan-p"><img src="/statics/images/guanzhu.png">关注(<span name="crdFdTotalFocus">0</span>)</p>
						</div>
						<div style="position: relative;">
							<a href="javascript:;" class="i-support">我要支持</a>
						<!------------------我要支持----------------------------------->
						<div class="support-cpm">
							<table class="table sup-tab">
								<thead>
									<tr>
										<th></th>
										<th>档位</th>
										<th>支持人数</th>
										<th>剩余名额</th>
										<th>回报内容</th>
										<th>截止时间</th>
									</tr>
								</thead>
								<tbody id="supportList4ISupportBox">

								</tbody>
							</table>
							<p class="sup-operate"><a href="#" class="sup-btn">我要支持</a><a href="javascript:;" class="sup-cancel">取消</a></p>
						</div>
						</div>					
					</div>
					<div class="author-info">
						<p class="author-title">发起人信息</p>
						<div class="author-txt">
							<a href="originator-page.html" class="author-tu" style="background-image:url(/statics/images/pro_tu.png)"></a>
							<div class="author-t-r">
								<p class="author-name">果果果果果果<img src="/statics/images/dawei.png"></p>
								<p> 蜂娱文化平台蜂娱文化平台蜂娱文化平台</p>
								<p class="author-r-p1">
									<span class="author-f">发起  19</span><span class="author-z">支持  27</span>
								</p>
								<div style="position: relative;">
									<p class="author-r-p2">
										<a href="javascript:;">发送私信</a>
										<img src="/statics/images/email.png">
								    </p>
								    <!--------------------发送私信--------------------------------->
									<div class="send-mesg">
										<p class="send-m-tit">发送私信</p>
										<div class="send-m-cen">
											<p>收件人：某某人</p>
											<textarea placeholder="在此输入内容"></textarea>
											<div class="send-authcode">
												<input type="text" placeholder="请输入验证码">
												<span><img src="/statics/images/yanzhengma.png">换一张</span>
												<a href="javascript:;" class="send-cancel">取消</a><a href="javascript:;" class="send-btn">发送</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div id="crdfdEntityRepayListBox">

					</div>
					<div class="risk-tip">
						<h4><b>风险提示</b></h4>
						<p>1. 众筹并非商品交易，项目存在一定风险，如项目众筹成功但发放回报出现问题，您需要直接和项目发起方协商解决退款事宜，蜂娱众筹没有帮您追讨资金的义务。</p>
					    <p>2. 如您支付了项目投资款项，即视为您不可撤销地决定投资该项目，且在项目募集期内，您所支付的资金将会被冻结，项目募集失败的除外；支持无私奉献档位，项目一旦募集成功将不予退款</p>
					    <p>3. 蜂娱众筹只提供平台服务，回报由项目发起方为您提供并负责发货，同时项目发起方有为您开具发票的法定义务。</p>
					</div>
				</div>
				<!--------------------遮罩层--------------------------------->
				<div class="bound"></div>
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

			})
		</script>


	</body>
</html>
