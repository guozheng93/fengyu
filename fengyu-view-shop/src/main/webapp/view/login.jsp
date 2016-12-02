<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>蜂娱文化登录</title>
		<link rel="stylesheet" href="/statics/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/statics/css/skin/layer.css"/>
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
								  <input type="text" class="form-control input-lg user-name" placeholder="手机/绑定邮箱" value="">
							</div>
							<div class="input-group f-div">
								  <div class="input-group-addon"><img src="/statics/images/suo.png"></div>
								  <input type="password" class="form-control input-lg paswd" placeholder="密码">
								  <!----为了兼容ie8----->
								  <input type="text" class="form-control input-lg paswd2" placeholder="密码" value="">
								  <!--------->
							</div>
						</form>
						<p class="lr-i-p">
							<span class="auto-log"><input type="checkbox" id="tick"><label for="tick">自动登录</label></span>
							<span class="foget-a"><a href="forgetPassword-one.html">忘记密码？</a></span>
						</p>
						<a href="/view/home/index.jsp" class="btn btn-warning lr-a">登录</a>
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
		<script type="text/javascript" src="/statics/js/jquery1.11.3.min.js" ></script>
		<script type="text/javascript" src="/statics/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="/statics/js/layer.js" ></script>
		<!--[if lt IE 10]>
		<script type="text/javascript" src="/statics/js/ie8.js" ></script>
        <![endif]-->
        <script>
        	$(function(){
        		/*简单登录*/        		
        		$(".lr-a").click(function(){
        			var phone_number=$(".user-name").val();
        		    var login_paswd=$(".paswd").val();
        			if(phone_number!=""&&login_paswd!=""){
	        			window.location.href="/view/home/index.jsp";
	        		}else{
	        			layer.msg("用户名和登录密码不能为空");
	        			return false;
	        		}
        		})
        	})
        </script>
	</body>
</html>
