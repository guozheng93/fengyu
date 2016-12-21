<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>蜂娱文化登录</title>
		<link rel="stylesheet" href="/statics/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/statics/js/skin/layer.css"/>
		<link rel="stylesheet" href="/statics/css/base.css" />
	</head>
	<body>
		<div class="warpper">
			<div class="lr-head"><img src="/statics/images/logo_login.png"><a href="/view/home/index.jsp">返回首页>></a></div>
			<div class="lr-main" style="background-image: url(/statics/images/fy-bg.png);">
				<div class="lr-mid">
					<!-----------------------登录---------------------------------->
					<div class="lr-info log-box">
						<p class="lr-i-p">
							<span class="lr-in-p1">蜂娱会员</span>
							<span class="lr-in-p2"><img src="/statics/images/right_arrow.png"><a href="register.jsp" class="go-regist">立即注册</a></span>
						</p>
						<form class="lr-fm">
							<div class="input-group f-div">
								  <div class="input-group-addon"><img src="/statics/images/user-hd.png"></div>
								  <input type="text" id="loginName" class="form-control input-lg user-name" placeholder="手机/绑定邮箱" value="">
							</div>
							<div class="input-group f-div">
								  <div class="input-group-addon"><img src="/statics/images/suo.png"></div>
								  <input type="password" id="pwd" class="form-control input-lg paswd" placeholder="密码">
								  <!----为了兼容ie8----->
								  <input type="text" class="form-control input-lg paswd2" placeholder="密码" value="">
								  <!--------->
							</div>
						</form>
						<p class="lr-i-p">
							<span class="auto-log"><input type="checkbox" id="tick"><label for="tick">自动登录</label></span>
							<span class="foget-a"><a href="forgetPassword-one.html">忘记密码？</a></span>
						</p>
						<a href="javascript:;" id="loginBtn" class="btn btn-warning lr-a">登录</a>
						<%--<a href="/view/home/index.jsp" class="btn btn-warning lr-a">登录</a>--%>
						<div class="third-log">
							<p>使用其他账号登录：</p>
							<a href="javascript:;"><img src="/statics/images/qqkuaijie.png"></a>
							<a href="javascript:;"><img src="/statics/images/weixn.png"></a>
							<a href="javascript:;"><img src="/statics/images/xinlang.png"></a>
						</div>
				    </div>
				</div>
			</div>
			<div class="push"></div>
		</div>
		<div class="footer-lo">
			<p>Copyright  2016 山东星万蜂娱网络科技有限公司  鲁ICP备16015631号-1 www.360fengyu.com</p>
		</div>
		<script type="text/javascript" src="/statics/js/plugin/seajs/sea.js"></script>
		<script type="text/javascript">
			seajs.config({
				base: "/statics/js/",
				alias: {
					"jquery"  :  "plugin/jquery/jquery-1.10.2.min",
					"md5"     :  "plugin/jquery/jquery.md5"
				},
				map: [
					[ /^(.*\/js\/.*\.(?:css|js))(?:.*)$/i, '$1?201605241248']
				]
			});
			seajs.use("/statics/js/pageScript/login.js",function(login){
				login.init();
			});
		</script>
	</body>
</html>
