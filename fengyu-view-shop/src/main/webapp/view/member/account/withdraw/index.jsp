<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>提现</title>
		<jsp:include page="/view/member/global/base-css.jsp"/>
	</head>
	<body>
		<div class="withdrawal-box">
			<h5><b>提现</b><span class="with-yu">账户余额：<b>0.00</b> 元</span></h5>
		    <div class="blank-card">
		    	<span class="card-select">选择银行卡：</span>
		    	<div class="blank-list active-blank">
		    		<p class="bl-p1"><img src="/statics/images/blank_logo.png"><span class="bl-car-kind">信用卡</span><span class="bl-weihao">尾号003</span></p>
		    	    <p class="bl-p2">持卡人姓名：*辰辰</p>
		    	    <p class="bl-p3">手机号：156****6521</p>
		    	</div>
		    	<div class="blank-list">
		    		<p class="bl-p1"><img src="/statics/images/blank_logo.png"><span class="bl-car-kind">信用卡</span><span class="bl-weihao">尾号003</span></p>
		    	    <p class="bl-p2">持卡人姓名：*辰辰</p>
		    	    <p class="bl-p3">手机号：156****6521</p>
		    	</div>
		    	<div class="blank-list">
		    		<p class="bl-p1"><img src="/statics/images/blank_logo.png"><span class="bl-car-kind">信用卡</span><span class="bl-weihao">尾号003</span></p>
		    	    <p class="bl-p2">持卡人姓名：*辰辰</p>
		    	    <p class="bl-p3">手机号：156****6521</p>
		    	</div>
		    	<div class="blank-list">
		    		<p class="bl-p1"><img src="/statics/images/blank_logo.png"><span class="bl-car-kind">储蓄卡</span><span class="bl-weihao">尾号003</span></p>
		    	    <p class="bl-p2">持卡人姓名：*辰辰</p>
		    	    <p class="bl-p3">手机号：156****6521</p>
		    	</div>
		    	 <a href="blank-bind-one.html" target="ifa" class="add-newcard">+添加新的银行卡</a>
		    </div>
		    <p class="withdrawal-num">提现金额：<input type="number"><span>元</span></p>
		    <p class="daozhang-time">到账时间：<input type="radio"><b>1-3个工作日</b><span style="color:#CCCCCC;margin-left: 6px;">(无手续费)</span></p>
		    <a href="withdrawal-two.html" target="ifa" class="rech-sub">下一步</a>
		    <div class="rech-risk">
				<p><img src="/statics/images/light.png">温馨提示：</p>
				<p class="rech-risk-con">
					<span>1.提现到账时间与该账户处理的速度有关，一般会在1-3个工作日内到账;</span>
					<span>2.余额提现后，处理中的余额暂不可以使用，目前不支持申请成功后取消提现，请您谅解;</span>
					<span>3.提现过程中如有问题，请您致电咨询客服，谢谢。</span>
				</p>
			</div>
		</div>
		<jsp:include page="/view/member/global/base-js.jsp"/>
		<script>
			$(function(){
				$.each($(".blank-list"), function(i,e) {
					$(".blank-list").first().css("margin-left",0);
					if(i%2==0){
						$(e).css("margin-left","88px");
					}
				});
				$(".blank-list").click(function(){			
					$(this).addClass("active-blank").siblings(".blank-list").removeClass("active-blank");
				})
				
				/*到账时间*/
				$(".daozhang-time input").click(function(){
					if($(this).attr("checked")){
						$(this).attr("checked",false);
					}else{
						$(this).attr("checked",true);
					}
				})
			})
		</script>
	</body>
</html>
