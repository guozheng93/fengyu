<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>账号绑定</title>
		<jsp:include page="/view/member/global/base-css.jsp"/>
	</head>
	<body>
		<div class="account-box">
			<h5><b>第三方账户绑定</b></h5>
			<p class="account-title">绑定主流社交网站账号，可以快速地将您觉得有趣的内容分享给相应网站上的朋友们。赶紧开始你的分享之旅吧!</p>
			<div class="account-lists">
				<div class="account-list">
					<img src="/statics/images/weixinzhifu.png" class="account-tu">
					<div class="account-r">
						<p>微信<span class="no-bang">未绑定</span></p>
						<a href="javascript:;" class="go-bang">立即绑定</a>
					</div>
				</div>
				<div class="account-list">
					<img src="/statics/images/big_qq.png" class="account-tu">
					<div class="account-r">
						<p>腾讯QQ</p>
						<a href="javascript:;" class="old-bang">已绑定</a>
					</div>
				</div>
				<div class="account-list">
					<img src="/statics/images/big_xinlang.png" class="account-tu">
					<div class="account-r">
						<p>新浪微博<span class="no-bang">未绑定</span></p>
						<a href="javascript:;" class="go-bang">立即绑定</a>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
