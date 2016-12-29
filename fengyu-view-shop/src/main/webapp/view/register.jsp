<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册</title>
		<link rel="stylesheet" href="/statics/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/statics/js/skin/layer.css"/>
		<link rel="stylesheet" href="/statics/css/base.css" />
	</head>
	<body>
		<div class="warpper">
			<div class="lr-head"><img src="/statics/images/logo_login.png"><a href="/view/home/index.jsp">返回首页>></a></div>
			<div class="lr-main" style="background-image: url(/statics/images/fy-bg.png);">
				<div class="lr-mid">
					
				    <!----------------------------注册---------------------------------------->
				    <div class="lr-info regist-box">
				    	<p class="lr-i-p">
							<span class="lr-in-p1">蜂娱会员</span>
							<span class="lr-in-p2"><img src="/statics/images/right_arrow.png"><a href="login.jsp" class="go-login">老用户登录</a></span>
						</p>
						<form class="lr-fm regist-fm">
							<div class="input-group f-div">
								  <div class="input-group-addon"><img src="/statics/images/user-hd.png"></div>
								  <input type="text" id="phone" class="form-control input-lg user-name" placeholder="请输入手机号" value="">
							</div>
							<div class="f-div">
								<input type="text" id="verifyCode" placeholder="请输入手机验证码" class="auth-code">
								<input type="button" class="send-ver" value="获取验证码" id="sendCodeBtn">
							</div>
						</form>
						<a href="javascript:;" id="registerBtn" class="btn btn-warning lr-a regist-a">注册</a>
						<div class="third-log">
							<p>使用其他账号登录：</p>
							<a href="javascript:;"><img src="/statics/images/qqkuaijie.png"></a>
							<a href="javascript:;"><img src="/statics/images/weixn.png"></a>
							<a href="javascript:;"><img src="/statics/images/xinlang.png"></a>
						</div>
				    </div>
				    <!----------------------------注册填密码------------------------------------------>
				    <div class="lr-info regist-paswd">
				    	<p class="lr-i-p">
							<span class="lr-in-p1">蜂娱会员</span>
							<span class="lr-in-p2"><img src="/statics/images/right_arrow.png"><a href="login.jsp" class="go-login">老用户登录</a></span>
						</p>
						<form class="lr-fm">
							<div class="input-group f-div">
								  <div class="input-group-addon"><img src="/statics/images/suo.png"></div>
								  <input type="password" id="password"  class="form-control input-lg paswd3p" placeholder="请填写登录密码" value="">
								  <!----为了兼容ie8----->
								  <input type="text"  class="form-control input-lg paswd3" placeholder="请填写登录密码" value="">
							</div>
							<div class="input-group f-div">
								  <div class="input-group-addon"><img src="/statics/images/suo.png"></div>
								  <input type="password" id="repeatpwd" class="form-control input-lg paswd4p" placeholder="请重复登录密码" value="">
								  <!----为了兼容ie8----->
								  <input type="text" class="form-control input-lg paswd4" placeholder="请重复登录密码" value="">
							</div>
						</form>
						<p class="rg-p">
							<input type="checkbox" id="tickagree"><label for="tickagree">我已阅读并同意</label>
							<a href="javascript:;">《蜂娱用户注册协议》</a>
						</p>
						<a href="javascript:;" id="fycom" class="btn btn-warning lr-a regist-a">开启蜂娱之旅</a>
						<div class="third-log">
							<p>使用其他账号登录：</p>
							<a href="javascript:;"><img src="/statics/images/qqkuaijie.png"></a>
							<a href="javascript:;"><img src="/statics/images/weixn.png"></a>
							<a href="javascript:;"><img src="/statics/images/xinlang.png"></a>
						</div>
				    </div>
				    <!-------------------------------------------------------->
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
			seajs.use("/statics/js/pageScript/register.js",function(register){
				register.init();
			});
		</script>
	</body>
</html>
