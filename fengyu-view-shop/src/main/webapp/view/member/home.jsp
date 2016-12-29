<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>基本信息</title>
	<link rel="stylesheet" href="/statics/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/statics/css/base.css" />
	<link rel="stylesheet" href="/statics/js/skin/layer.css" />
	<link rel="stylesheet" href="/statics/css/person.css" />
</head>
<body>
<div class="pd-show">
	<div class="pd-show-top" id="baseId">
		<%--<div class="pds-list pds-list1">--%>
			<%--<span style="background-image:url(/statics/images/2.png)" class="pds-head"></span>--%>
			<%--<div class="pds-txt">--%>
				<%--<h4><b>某某用户</b></h4>--%>
				<%--<div class="pds-material">资料完整度：<p class="material-bar"><span style="width: 20%;">20%</span></p><a href="index.html" target="ifa">立即完善</a></div>--%>
				<%--<p class="pds-certification">实名认证：未认证<a href="real-renzheng.html" target="ifa">立即认证</a></p>--%>
				<%--<p class="pds-safe">账户安全级别：<span>中</span><a href="safety-info.html" target="ifa">立即提升</a></p>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="pds-list pds-list2">--%>
			<%--<p class="pds-balance">余额:<b>0.00 元</b></p>--%>
		<%--</div>--%>
		<%--<div class="pds-list pds-list3">--%>
			<%--<a href="recharge-one.html" class="pds-chong" target="ifa">充值</a>--%>
			<%--<a href="withdrawal-one.html" class="pds-tixian" target="ifa">提现</a>--%>
		<%--</div>--%>
	</div>
	<div class="pds-info-list">
		<div class="pds-base" id = "infoId">
			<%--<h5><b>基本资料</b></h5>--%>
			<%--<p><span class="pds-sl">昵称：昵称昵称昵称</span><span class="pds-sr">个性签名：签名签名签名签名签名签名签名</span></p>--%>
			<%--<p><span class="pds-sl">年龄：23岁</span><span class="pds-sr">感情状况：未婚</span></p>--%>
			<%--<p><span class="pds-sl">生日：1993-06-06</span><span class="pds-sr">家乡：山东济南</span></p>--%>
			<%--<p><span class="pds-sl">星座：巨蟹座</span><span class="pds-sr">现居地：山东省济南市历下区经十路8000号龙奥金座</span></p>--%>
			<%--<div class="clearfix"></div>--%>
		</div>
		<div class="pds-base pds-xueli" id = "eduId">
			<%--<h5><b>学历信息</b></h5>--%>
			<%--<p><span class="record-no">1</span><span>建筑大学</span><span>本科</span><span>平面设计</span><span>2011年9月</span></p>--%>
			<%--<p><span class="record-no">2</span><span>建筑大学</span><span>本科</span><span>平面设计</span><span>2011年9月</span></p>--%>
			<%--<div class="clearfix"></div>--%>
		</div>
		<div class="pds-base pds-xueli" id ="workId">
			<%--<h5><b>工作信息</b></h5>--%>
			<%--<p><span class="record-no">1</span><span>山东星万蜂娱网络科技有限公司</span><span>平面设计</span><span>2011年9月</span></p>--%>
			<%--<p><span class="record-no">1</span><span>山东星万蜂娱网络科技有限公司</span><span>平面设计</span><span>2011年9月</span></p>--%>
			<%--<div class="clearfix"></div>--%>
		</div>
	</div>
</div>
<script type="text/javascript" src="/statics/js/plugin/seajs/sea.js"></script>
<script type="text/javascript">
	seajs.config({
		base: "/statics/js/",
		alias: {
			"jquery"  :  "plugin/jquery/jquery-1.10.2.min",
			"md5"     :  "plugin/jquery/jquery.md5",
			"template" :  "lib/template.js"
		},
		map: [
			[ /^(.*\/js\/.*\.(?:css|js))(?:.*)$/i, '$1?201605241248']
		]
	});
	seajs.use("/statics/js/pageScript/member/home.js",function(home){
		home.init();
	});
</script>

<%--账户信息--%>
<script id="baseTemp" type="text/html">
	<div class="pds-list pds-list1">
		<span style="background-image:url(/statics/images/2.png)" class="pds-head"></span>
		<div class="pds-txt">
			<h4><b>{{username}}</b></h4>
			<div class="pds-material">
				资料完整度：
				<p class="material-bar">
					{{if username == null}}
					<span style="width: 20%;">20%</span>
					{{else}}
					<span style="width: 50%;">50%</span>
					{{/if}}
				</p>
				<a href="index.html" target="ifa">立即完善</a>
			</div>
			<p class="pds-certification">
				实名认证：
				{{if auth == null}}
				未认证
				<a href="real-renzheng.html" target="ifa">
					立即认证
				</a>
				{{else}}
				已认证
				{{/if}}
			</p>
			<p class="pds-safe">
				账户安全级别：
				{{if auth == null}}
				<span>底</span>
				{{else}}
				中
				{{/if}}
				<a href="safety-info.html" target="ifa">
					立即提升
				</a>
			</p>
		</div>
	</div>
	<div class="pds-list pds-list2">
		<p class="pds-balance">余额:<b>0.00 元</b></p>
	</div>
	<div class="pds-list pds-list3">
		<a href="recharge-one.html" class="pds-chong" target="ifa">充值</a>
		<a href="withdrawal-one.html" class="pds-tixian" target="ifa">提现</a>
	</div>
</script>


<%--基本资料--%>
<script id="infoTemp" type="text/html">
	<h5><b>基本资料</b></h5>
	<p><span class="pds-sl">昵称：{{name}}</span><span class="pds-sr">个性签名：{{info}}</span></p>
	<p><span class="pds-sl">年龄：{{age}}岁</span><span class="pds-sr">感情状况：{{feelingInfo}}</span></p>
	<p><span class="pds-sl">生日：{{birthday}}</span><span class="pds-sr">家乡：{{oldProvince}} {{oldCity}} {{oldCounty}}</span></p>
	<p><span class="pds-sl">星座：{{constellation}}</span><span class="pds-sr">现居地：{{province}} {{city}} {{county}} {{address}}</span></p>
	<div class="clearfix"></div>
</script>

<%--学历信息--%>
<script id="eduTemp" type="text/html">
	<h5><b>学历信息</b></h5>
	{{each recordList as item i}}
	<p><span class="record-no">{{i+1}}</span><span>{{item.school}}</span><span>{{item.title}}</span><span>{{item.major}}</span><span>{{item.startYear}}年{{item.startMonth}}月</span></p>
	{{/each}}
	<div class="clearfix"></div>
</script>

<%--工作信息--%>
<script id="workTemp" type="text/html">
	<h5><b>工作信息</b></h5>
	{{each recordList as item i}}
	<p><span class="record-no">{{i+1}}</span><span>{{item.name}}</span><span>{{item.work}}</span><span>{{item.startYear}}年{{item.startMonth}}月</span></p>
	{{/each}}
	<div class="clearfix"></div>
</script>
</body>
</html>
