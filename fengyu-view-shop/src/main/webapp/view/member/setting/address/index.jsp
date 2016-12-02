<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>收货地址</title>
		<jsp:include page="/view/member/global/base-css.jsp"/>
	</head>
	<body>
		<div class="shipp-box">
			<h5><b>收货地址</b></h5>
			<p class="shipp-title"><span style="font-weight: bold;margin-right:12px;">已保存的收货地址</span>您已创建<span style="color:#00b1bb">6</span>个收货地址，最多能创建<span style="color:#00b1bb;">20</span>个！</p>
		    <div class="shipp-lists">
		    	<div class="shipp-list">
		    		<span class="ship-adres">默认地址</span>
		    		<h4><b>谭某某</b></h4>
		    		<p>收货地址：<span>某某省 某某市 某某区 </span></p>
		    		<p>手机号码：151-0000-0000</p>
                    <p>邮箱：25341171@163.com</p>
                    <span class="shipp-operation"><span class="shipp-modify">修改</span><span class="shipp-del">删除</span></span>
		    	</div>
		    	<div class="shipp-list">
		    		<span class="ship-adres">设置为默认地址</span>
		    		<h4><b>谭某某</b></h4>
		    		<p>收货地址：<span>某某省 某某市 某某区 某某地 某某小区几号楼几单元几零几</span></p>
		    		<p>手机号码：当日放假混凝土管那</p>
                    <p>邮箱：25341171@163.com</p>
                    <span class="shipp-operation"><span class="shipp-modify">修改</span><span class="shipp-del">删除</span></span>
		    	</div>
		    	<div class="shipp-list">
		    		<span class="ship-adres">设置为默认地址</span>
		    		<h4><b>谭某某</b></h4>
		    		<p>收货地址：<span>某某省 某某市 某某区 某某地 某某小区几号楼几单元几零几</span></p>
		    		<p>手机号码：151-0000-0000</p>
                    <p>邮箱：25341171@163.com</p>
                    <span class="shipp-operation"><span class="shipp-modify">修改</span><span class="shipp-del">删除</span></span>
		    	</div>
		    	<div class="shipp-list">
		    		<span class="ship-adres">设置为默认地址</span>
		    		<h4><b>谭某某</b></h4>
		    		<p>收货地址：<span>某某省 某某市 某某区 某某地 某某小区几号楼几单元几零几</span></p>
		    		<p>手机号码：151-0000-0000</p>
                    <p>邮箱：25341171@163.com</p>
                    <span class="shipp-operation"><span class="shipp-modify">修改</span><span class="shipp-del">删除</span></span>
		    	</div>
		    	<div class="shipp-list">
		    		<span class="ship-adres">设置为默认地址</span>
		    		<h4><b>谭某某</b></h4>
		    		<p>收货地址：<span>某某省 某某市 某某区 某某地 某某小区几号楼几单元几零几</span></p>
		    		<p>手机号码：151-0000-0000</p>
                    <p>邮箱：25341171@163.com</p>
                    <span class="shipp-operation"><span class="shipp-modify">修改</span><span class="shipp-del">删除</span></span>
		    	</div>
		    	<div class="shipp-list">
		    		<span class="ship-adres">设置为默认地址</span>
		    		<h4><b>谭某某</b></h4>
		    		<p>收货地址：<span>某某省 某某市 某某区 某某地 某某小区几号楼几单元几零几</span></p>
		    		<p>手机号码：151-0000-0000</p>
                    <p>邮箱：25341171@163.com</p>
                    <span class="shipp-operation"><span class="shipp-modify">修改</span><span class="shipp-del">删除</span></span>
		    	</div>
		    </div>
		    <div class="ship-info">
		    	<p class="ship-info-title"><b>新增收货地址</b></p>
		    	<p class="ship-p1"><span>收货人：</span><input type="text"></p>
		    	<p class="ship-p2"><span>所在地地址:</span>
		    		<select>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    		</select>
		    		省
		    		<select>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    		</select>
		    		市
		    		<select>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    		</select>
		    		区
		    	</p>
		    	<p class="ship-p3"><span></span><input type="text" placeholder="填写详细地址"></p>
		    	<p class="ship-p4"><span>手机号码：</span><input type="number" maxlength="11"></p>
		    	<p class="ship-p5"><span>邮箱：</span><input type="text"></p>
		    	<p class="ship-p6"><span></span><a href="javascript:;">保存</a></p>
		    </div>
		</div>

		<jsp:include page="/view/member/global/base-js.jsp"/>
		<script>
			$(function(){
				adres();
				$(".ship-adres").click(function(){
					if($(this).html()=="默认地址"){
						$(this).html("设为默认地址");
						adres();	
					}else if($(this).html()=="设置为默认地址"){
					     $(".ship-adres").html("设置为默认地址");
					     $(this).html("默认地址");
					     adres();
					}
				})
				function adres(){
					$.each($(".shipp-list"), function(i,e) {
					if($(e).find(".ship-adres").html()=="默认地址"){
						$(e).find(".ship-adres").css("background","#00b1bb");
						$(e).find(".shipp-del").hide();
					}else{
						$(e).find(".ship-adres").css("background","#7fd8dd");
						$(e).find(".shipp-del").show();
					}
				});
				}
				/*修改地址*/
				$(".shipp-modify").click(function(){
					parent.$(".bound").show();
					parent.$(".modify-adres-box").show();
				})
				/*修改地址保存*/
				parent.$(".ship-p6 a").click(function(){
					parent.$(".bound,.modify-adres-box").hide();
				})
				/*删除地址*/
				$(".shipp-del").click(function(){
					$(this).parents(".shipp-list").remove();
					layer.msg("删除成功");
				})
			})
		</script>
		<!---todo------->
		<script>
				window.onbeforeunload = function(){
				    parent.$(".bound").hide();
					parent.$(".modify-adres-box").hide();				   
				}
		</script>
	</body>
</html>
