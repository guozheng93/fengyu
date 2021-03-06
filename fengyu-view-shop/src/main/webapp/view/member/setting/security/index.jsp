<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>安全信息</title>
		<jsp:include page="/view/member/global/base-css.jsp"/>
	</head>
	<body>
		<div class="safety-box">
			<h5><b>安全信息</b></h5>
			<div class="user-level">
				<p>用户名：<span>某某用户</span></p>
				<div>安全级别:<p><span style="width:90%"></span></p><span class="leve-txt">高</span></div>
			</div>
			<div class="safety-lists">
				<div class="safety-list">
					<p class="safe-p1"><img src="/statics/images/bangdingchenggong.png"></p>
					<p class="safe-p2"><img src="/statics/images/shouji.png"></p>
					<div class="safe-p3">
						<p class="safe-p-1">绑定手机</p>
						<p class="safe-p-2">轻松找回密码，验证身份。已绑定：188*****888</p>
					</div>
					<p class="safe-p4"><a href="modifyPhoneNumber-one.html" target="ifa">修改</a></p>
				</div>
				<div class="safety-list">
					<p class="safe-p1"><img src="/statics/images/weibangding.png"></p>
					<p class="safe-p2"><img src="/statics/images/shouji.png"></p>
					<div class="safe-p3">
						<p class="safe-p-1">绑定手机</p>
						<p class="safe-p-2">建议使用常用手机号进行绑定。</p>
					</div>
					<p class="safe-p4 wei-a"><a href="modifyPhoneNumber-one.html" class="phone-bind-a">立即绑定</a></p>
				</div>
				<div class="safety-list">
					<p class="safe-p1"><img src="/statics/images/bangdingchenggong.png"></p>
					<p class="safe-p2"><img src="/statics/images/suo.png"></p>
					<div class="safe-p3">
						<p class="safe-p-1">登录密码</p>
						<p class="safe-p-2">互联网账号存在被盗风险，建议您定期更改密码以保护账户安全。</p>
					</div>
					<p class="safe-p4"><a href="modifyLoginPassword-one.html" target="ifa">修改</a></p>
				</div>
				<div class="safety-list">
					<p class="safe-p1"><img src="/statics/images/weibangding.png"></p>
					<p class="safe-p2"><img src="/statics/images/aite.png"></p>
					<div class="safe-p3">
						<p class="safe-p-1">绑定邮箱</p>
						<p class="safe-p-2">建议使用常用邮箱进行绑定。</p>
					</div>
					<p class="safe-p4 wei-a"><a href="email-bind-one.html" target="ifa">立即绑定</a></p>
				</div>
				<div class="safety-list">
					<p class="safe-p1"><img src="/statics/images/weibangding.png"></p>
					<p class="safe-p2"><img src="/statics/images/shimingzhi.png"></p>
					<div class="safe-p3">
						<p class="safe-p-1">实名认证</p>
						<p class="safe-p-2">用于提升账号的安全性和信任级别。认证后不能修改认证信息。</p>
					</div>
					<p class="safe-p4 wei-a"><a href="real-renzheng.html" target="ifa">立即认证</a></p>
				</div>
				<div class="safety-list">
					<p class="safe-p1"><img src="/statics/images/bangdingchenggong.png"></p>
					<p class="safe-p2"><img src="/statics/images/yinhangk.png"></p>
					<div class="safe-p3">
						<p class="safe-p-1">银行卡绑定</p>
						<p class="safe-p-2">绑定银行卡，使您的支付更便捷。</p>
					</div>
					<p class="safe-p4"><a href="old-boundblank.html" class="blank_a" target="ifa">查看</a></p>
				</div>
				<div class="safety-list">
					<p class="safe-p1"><img src="/statics/images/weibangding.png"></p>
					<p class="safe-p2"><img src="/statics/images/yinhangk.png"></p>
					<div class="safe-p3">
						<p class="safe-p-1">银行卡绑定</p>
						<p class="safe-p-2">绑定银行卡，使您的支付更便捷。</p>
					</div>
					<p class="safe-p4 wei-a"><a href="blank-bind-one.html" class="blank_a" target="ifa">立即绑定</a></p>
				</div>
				<div class="safety-list">
					<p class="safe-p1"><img src="/statics/images/bangdingchenggong.png"></p>
					<p class="safe-p2"><img src="/statics/images/yinhangk.png"></p>
					<div class="safe-p3">
						<p class="safe-p-1">实名认证</p>
						<p class="safe-p-2">用于提升账号的安全性和信任级别。认证后不能修改认证信息。</p>
					</div>
					<p class="safe-p4 "><a href="real-renzheng-show.html"  target="ifa">查看详情</a></p>
				</div>
			</div>
		</div>

		<jsp:include page="/view/member/global/base-js.jsp"/>
		<script>		
			$(function(){
				/*没有进行实名认证的时候
				$(".blank_a").click(function(){
					parent.$(".bound").show();
					parent.$(".no-certification").show();
					return false;
				})*/
			})
		</script>
	</body>
</html>
