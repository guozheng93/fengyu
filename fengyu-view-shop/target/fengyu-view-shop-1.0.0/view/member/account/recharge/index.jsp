<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>充值</title>
		<jsp:include page="/view/member/global/base-css.jsp"/>
	</head>
	<body>
		<div class="recharge-box">
			<h5><b>填写充值金额</b></h5>
			<div class="recharge-info">
				<p class="rech-p1">充值账户：某某某用户</p>
				<p class="rech-p2">充值金额：<input type="number"><span>元</span></p>
				<div class="rech-tip">
					<p><img src="/statics/images/deng2.png">温馨提示：</p>
					<p>1、充值金额不得少于10元；</p>
					<p>2、您只能使用储蓄卡进行充值；</p>
					<p>3、充值完成后，您可以进入账户充值记录页面进行查看余额充值状态；</p>
					<p>4、充值成功后，余额可能存在延迟现象，一般1到5分钟内到账，如有问题，请咨询客服；</p>
					<p>5、客服服务热线：400-025-3721。</p>
				</div>
				<a href="recharge-two.html" class="rech-sub" target="ifa">下一步</a>
			</div>
		</div>
	</body>
</html>
