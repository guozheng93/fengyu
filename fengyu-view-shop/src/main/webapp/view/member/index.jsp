<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人中心</title>
		<link rel="stylesheet" href="/statics/js/skin/layer.css" />
		<link rel="stylesheet" href="/statics/css/person.css" />
	</head>
	<body>
		<div class="warpper1">
			<!-------------start head--------------->
			<jsp:include page="/view/member/global/head.jsp"/>
			<!-------------end head--------------->
			<!-------------start nav--------------->
			<jsp:include page="/view/member/global/part/nav.jsp"/>
			<!-------------end nav--------------->
			<div class="person-box">
				<div class="person-mid person-list-menu">
					<!-------------start left--------------->
					<jsp:include page="/view/member/global/left.jsp"/>
					<!-------------end left--------------->
					<div class="per-r">
						<iframe name="ifa" src="/view/member/home.jsp" frameborder="0" class="iframea" id="iframepage" scrolling="no" onload="iFrameHeight(this);"></iframe>
					</div>
				</div>
			</div>
			<div class="push1"></div>
		</div>
		<!---------遮罩层-------->
		<div class="bound"></div>
		<!-------未实名认证提醒----------->
		<div class="no-certification">
			<p class="no-cer-p1">您好！您还未实名认证</p>
			<p class="no-cer-p2">请先进行<a href="real-renzheng.html" target="ifa"><b>实名认证</b></a></p>
			<a href="javascript:;" class="i-know">我知道了</a>
		</div>
		<!---验证码输入3次错误------->
		<div class="authentication-code">
			<p class="auth-p1">为了您的账户安全，请输入下面验证码！</p>
			<p class="auth-p2"><img src="/statics/images/ing_ng.png"></p>
			<p class="auth-p3"><input type="text"></p>
			<p class="auth-p4">输入错误提示信息：你输入的验证码有误，请重新输入</p>
		</div>
		<!--发起项目弹窗--->
		<!--<div id="faqi-popup">
			<img src="images/colse_icon.png">
			<p class="faqi-title">选择发起的项目类型</p>
			<a href="javascript:;" class="init-a">产品众筹</a>
			<p class="gouxuan-xieyi"><input type="checkbox">已阅读并同意蜂娱的<a href="javascript:;" class="protocol">《服务协议》</a></p>
		</div>-->

		<!-----修改地址----------->
		<div class="modify-adres-box">
			<span class="modify-close">×</span>
			<p class="ship-info-title"><b>修改收货地址</b></p>
			    <input type="hidden" id = "id" value =  "1">
		    	<p class="ship-p1"><span>收货人：</span><input id ="editName" type="text"></p>
		    	<p class="ship-p2"><span>所在地地址:</span>
		    		<select id ="editProvince">
		    			<option>请选择</option>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    		</select>
		    		省
		    		<select id ="editCity">
		    			<option>请选择</option>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    		</select>
		    		市
		    		<select id ="editCountry">
		    			<option>请选择</option>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    		</select>
		    		区
		    	</p>
		    	<p class="ship-p3"><span></span><input type="text" id ="editAddress" placeholder="填写详细地址"></p>
		    	<p class="ship-p4"><span>手机号码：</span><input id ="editPhone" type="number" maxlength="11"></p>
		    	<p class="ship-p5"><span>邮箱：</span><input id ="editEmail" type="text"></p>
		    	<p class="ship-p6"><span></span><a href="javascript:;">保存</a></p>
		</div>
		<!------添加新闻动态---------->
		<div class="add-new">
			<img src="/statics/images/colse_icon.png" class="close-btn">
			<h4>发布新动态</h4>
			<textarea class="add-con"></textarea>
			<ul class="list-unstyled">
				<li>
					<a href="javascript:;" class="add-newa"><img src="/statics/images/default2.png"><input type="file" name="" id=""></a>
				</li>
				<li>
					<a href="javascript:;" class="add-newa"><img src="/statics/images/default2.png"><input type="file" name="" id=""></a>
				</li>
				<li>
					<a href="javascript:;" class="add-newa"><img src="/statics/images/default2.png"><input type="file" name="" id=""></a>
				</li>
				<li>
					<a href="javascript:;" class="add-newa"><img src="/statics/images/default2.png"><input type="file" name="" id=""></a>
				</li>
			</ul>
			<p>支持ipg、jpeg、png、gif格式，大小：300*200px<a href="javascript:;" class="fabu">发布</a></p>
		</div>
		<script>
			function iFrameHeight(elm) {
					var ifm= elm || $('#iframepage')[0];
				    var subWeb = document.frames ? elm.document : ifm.contentDocument;
				    if(ifm != null && subWeb != null) {
				        setTimeout(function(){
				            ifm.height = $(subWeb.body).height();
				        },12)
				    }
			    }
			$(function(){
				var type = getQueryString("type");
				  if(type==null || type==""){
				  	//没有参数
				  }else if(type=="2"){
				  	//有参数  说明是跳转过来的

				    $("#iframepage").attr("src","my-faqi-pro.html");

				  }else if(type=="3"){
				  	 $("#iframepage").attr("src","trading-details.html");
				  }else if(type=="6"){
				  	$("#iframepage").attr("src","my-message.html");
				  }

				var w_width=$(window).width();
				var ft_width=(w_width-80)/2;
				$(".ft-bord").css("width",ft_width);
			    var ws_width=w_width/2;
			    $(".white-s").css("width",ws_width);
			    /*dl*/
			   $(".per-l h5").click(function(){
			   	$(".per-l dd").removeClass("active-dd");
			   })
			   $(".per-l dl").last().css("border-bottom",'0px')
			   $(".per-l dd a").click(function(){
			   	$(".per-l dd a").removeClass("active-dd");
			   	$(this).addClass("active-dd");
			   })
			   $(".per-l dl img").click(function(){
			   	if($(this).attr("src")=="images/dl_before.png"){
			   		$(this).attr("src","images/dl_before2.png");
			   		$(this).parents("dl").find("dd").slideUp();
			   	}else{
			   		$(this).attr("src","images/dl_before.png");
			   		$(this).parents("dl").find("dd").slideDown();
			   	}
			   })
			   /*******点击我知道了***********/
			    $(".i-know").click(function(){
					$(".bound").hide();
					$(".no-certification").hide();
				})
			    $(".no-cer-p2 a").click(function(){
			    	$(".bound,.no-certification").hide();
			    });

			    $('.person-list-menu a').on('click', function(){
			    	var interval = setInterval(function(){
			    		iFrameHeight();
			    		$('#iframepage').on('load',function(){
			    			clearInterval(interval);
			    		});
			    	},60);
			    	setTimeout(function(){
						clearInterval(interval);
			    	},2000);
			    });
			    /*右上角关闭修改地址*/
			   $(".modify-close").click(function(){
			   	$(".bound,.modify-adres-box").hide();
			   })

				/*产品众筹
				$(".init-a").click(function(){
					if($(".gouxuan-xieyi input").is(":checked")){
						window.open("initiate-raise.html");
						$(".bound,#faqi-popup").hide();
					}else{
						layer.msg("请先阅读蜂娱的服务协议，并勾选");
					}
				})*/
				/*关闭按钮
				$("#faqi-popup img").click(function(){
					$(".bound,#faqi-popup").hide();
				})*/
			});
			function getQueryString(name) {
		        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		        var r = window.location.search.substr(1).match(reg);
		        if (r != null) return unescape(r[2]); return null;
		    }
		</script>

	</body>
</html>
