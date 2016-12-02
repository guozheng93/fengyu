<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的订单</title>
		<jsp:include page="/view/member/global/base-css.jsp"/>
	</head>
	<body>
		<div class="order-box">
			<div class="order-title">
			   <ul class="list-unstyled">
			   	<li class="order-li1"><a href="javascript:;"><span>近三个月的订单</span>
				   		<dl>
				   			<dd>近三个月的订单</dd>
				   			<dd>近六个月的订单</dd>
				   			<dd>全部</dd>
				   		</dl>
			   	</a><img src="/statics/images/daosanjiao.png">
			   		<a href="javascript:;" class="order-good">商品</a>
			   	</li>
			   	
			   	<li class="order-li2"><a href="javascript:;">收货人</a></li>
			   	<li class="order-li3"><a href="javascript:;">订单总额</a></li>
			   	<li class="order-li4"><a href="javascript:;">订单状态
			   		<dl>
			   			<dd>待付款</dd>
			   			<dd>已付款</dd>
			   			<dd>已关闭</dd>
			   			<dd>待退款</dd>
			   			<dd>退款成功</dd>
			   			<dd>待收货</dd>
			   			<dd>收货失败</dd>
			   			<dd>已完成(待评价)</dd>
			   			<dd>已完成(已评价)</dd>
			   		</dl>
			   	</a><img src="/statics/images/daosanjiao.png">
			   	</li>
			   	<li class="order-li5"><a href="javascript:;">操作</a></li>
			   	<div class="clearfix"></div>
			   </ul>
			   
			</div>
			<div class="order-lists">
				<div class="order-list">
				 	<p class="order-p1"><span>2016-06-02  13:28:00</span><span class="order-serial">订单编号：<b style="color:#31bfc7">0000000000</b></span></p>
				    <table>
				    	<tbody>
				    		<tr>
				    			<td class="order-li1">
				    				<div class="order-base">
				    					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/2.png)" class="order-tu"></a>
				    					<p class="order-name">Acappella夏令营</p>
				    				</div>
				    			</td>
				    			<td class="order-li2">陈某某</td>
				    			<td class="order-li3" style="color:#00b1bb">¥0.01</td>
				    			<td class="order-li4 order-td4"><a href="javascript:;">待付款</a></td>
				    			<td class="order-li5 order-td5"><a href="javascript:;" class="order-del">删除订单</a><a href="order-pay.html" target="_blank" class="go-pay">去支付</a><a href="javascript:;" class="my-pro-cancel">取消订单</a><a href="trading-details.html" class="order-detail" target="ifa">交易详情</a></td>
				    		</tr>
				    	</tbody>
				    </table>
				</div>
				<div class="order-list">
				 	<p class="order-p1"><span>2016-06-02  13:28:00</span><span class="order-serial">订单编号：<b style="color:#31bfc7">0000000000</b></span></p>
				    <table>
				    	<tbody>
				    		<tr>
				    			<td class="order-li1">
				    				<div class="order-base">
				    					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/2.png)" class="order-tu"></a>
				    					<p class="order-name">Acappella夏令营</p>
				    				</div>
				    			</td>
				    			<td class="order-li2">陈某某</td>
				    			<td class="order-li3" style="color:#00b1bb">¥0.01</td>
				    			<td class="order-li4 order-td4"><a href="javascript:;">已付款</a></td>
				    			<td class="order-li5 order-td5"><a href="trading-details.html" class="order-detail" target="ifa">交易详情</a></td>
				    		</tr>
				    	</tbody>
				    </table>
				</div>
				<div class="order-list">
				 	<p class="order-p1"><span>2016-06-02  13:28:00</span><span class="order-serial">订单编号：<b style="color:#31bfc7">0000000000</b></span></p>
				    <table>
				    	<tbody>
				    		<tr>
				    			<td class="order-li1">
				    				<div class="order-base">
				    					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/2.png)" class="order-tu"></a>
				    					<p class="order-name">Acappella夏令营</p>
				    				</div>
				    			</td>
				    			<td class="order-li2">陈某某</td>
				    			<td class="order-li3" style="color:#00b1bb">¥0.01</td>
				    			<td class="order-li4 order-td4"><a href="javascript:;">已关闭</a></td>
				    			<td class="order-li5 order-td5"><a href="javascript:;" class="order-del">删除订单</a><a href="trading-details.html" class="order-detail" target="ifa">交易详情</a></td>
				    		</tr>
				    	</tbody>
				    </table>
				</div>
				<div class="order-list">
				 	<p class="order-p1"><span>2016-06-02  13:28:00</span><span class="order-serial">订单编号：<b style="color:#31bfc7">0000000000</b></span></p>
				    <table>
				    	<tbody>
				    		<tr>
				    			<td class="order-li1">
				    				<div class="order-base">
				    					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/2.png)" class="order-tu"></a>
				    					<p class="order-name">Acappella夏令营</p>
				    				</div>
				    			</td>
				    			<td class="order-li2">陈某某</td>
				    			<td class="order-li3" style="color:#00b1bb">¥0.01</td>
				    			<td class="order-li4 order-td4"><a href="javascript:;">待退款</a></td>
				    			<td class="order-li5 order-td5"><a href="trading-details.html" class="order-detail" target="ifa">交易详情</a></td>
				    		</tr>
				    	</tbody>
				    </table>
				</div>
				<div class="order-list">
				 	<p class="order-p1"><span>2016-06-02  13:28:00</span><span class="order-serial">订单编号：<b style="color:#31bfc7">0000000000</b></span></p>
				    <table>
				    	<tbody>
				    		<tr>
				    			<td class="order-li1">
				    				<div class="order-base">
				    					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/2.png)" class="order-tu"></a>
				    					<p class="order-name">Acappella夏令营</p>
				    				</div>
				    			</td>
				    			<td class="order-li2">陈某某</td>
				    			<td class="order-li3" style="color:#00b1bb">¥0.01</td>
				    			<td class="order-li4 order-td4"><a href="javascript:;">退款成功</a></td>
				    			<td class="order-li5 order-td5"><a href="trading-details.html" class="order-detail" target="ifa">交易详情</a></td>
				    		</tr>
				    	</tbody>
				    </table>
				</div>
				<div class="order-list">
				 	<p class="order-p1"><span>2016-06-02  13:28:00</span><span class="order-serial">订单编号：<b style="color:#31bfc7">0000000000</b></span></p>
				    <table>
				    	<tbody>
				    		<tr>
				    			<td class="order-li1">
				    				<div class="order-base">
				    					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/2.png)" class="order-tu"></a>
				    					<p class="order-name">Acappella夏令营</p>
				    				</div>
				    			</td>
				    			<td class="order-li2">陈某某</td>
				    			<td class="order-li3" style="color:#00b1bb">¥0.01</td>
				    			<td class="order-li4 order-td4"><a href="javascript:;">待收货</a></td>
				    			<td class="order-li5 order-td5"><a href="javascript:;" class="is-harvest">确认收货</a><a href="logistics-information.html" target="ifa" class="find-logistics">查看物流</a><a href="trading-details.html" class="order-detail" target="ifa">交易详情</a></td>
				    		</tr>
				    	</tbody>
				    </table>
				</div>
				<div class="order-list">
				 	<p class="order-p1"><span>2016-06-02  13:28:00</span><span class="order-serial">订单编号：<b style="color:#31bfc7">0000000000</b></span></p>
				    <table>
				    	<tbody>
				    		<tr>
				    			<td class="order-li1">
				    				<div class="order-base">
				    					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/2.png)" class="order-tu"></a>
				    					<p class="order-name">Acappella夏令营</p>
				    				</div>
				    			</td>
				    			<td class="order-li2">陈某某</td>
				    			<td class="order-li3" style="color:#00b1bb">¥0.01</td>
				    			<td class="order-li4 order-td4"><a href="javascript:;">收货失败</a></td>
				    			<td class="order-li5 order-td5"><a href="trading-details.html" class="order-detail" target="ifa">交易详情</a></td>
				    		</tr>
				    	</tbody>
				    </table>
				</div>
				<div class="order-list">
				 	<p class="order-p1"><span>2016-06-02  13:28:00</span><span class="order-serial">订单编号：<b style="color:#31bfc7">0000000000</b></span></p>
				    <table>
				    	<tbody>
				    		<tr>
				    			<td class="order-li1">
				    				<div class="order-base">
				    					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/2.png)" class="order-tu"></a>
				    					<p class="order-name">Acappella夏令营</p>
				    				</div>
				    			</td>
				    			<td class="order-li2">陈某某</td>
				    			<td class="order-li3" style="color:#00b1bb">¥0.01</td>
				    			<td class="order-li4 order-td4"><a href="javascript:;">已完成(待评价)</a></td>
				    			<td class="order-li5 order-td5"><a href="product-evaluation.html" target="ifa" class="order-eval">去评价</a><a href="trading-details.html" class="order-detail" target="ifa">交易详情</a></td>
				    		</tr>
				    	</tbody>
				    </table>
				</div>
				<div class="order-list">
				 	<p class="order-p1"><span>2016-06-02  13:28:00</span><span class="order-serial">订单编号：<b style="color:#31bfc7">0000000000</b></span></p>
				    <table>
				    	<tbody>
				    		<tr>
				    			<td class="order-li1">
				    				<div class="order-base">
				    					<a href="project-detail.html" target="_blank" style="background-image:url(/statics/images/2.png)" class="order-tu"></a>
				    					<p class="order-name">Acappella夏令营</p>
				    				</div>
				    			</td>
				    			<td class="order-li2">陈某某</td>
				    			<td class="order-li3" style="color:#00b1bb">¥0.01</td>
				    			<td class="order-li4 order-td4"><a href="javascript:;">已完成(已评价)</a></td>
				    			<td class="order-li5 order-td5"><a href="trading-details.html" class="order-detail" target="ifa">交易详情</a></td>
				    		</tr>
				    	</tbody>
				    </table>
				</div>
				<!----分页--->
				<div id="pr-page"></div>
			</div>
		</div>
		<jsp:include page="/view/member/global/base-js.jsp"/>
		<script>
			$(function(){
				var nums = 5; //每页出现的数量
				var pages =100; //得到总页数
				//调用分页
				laypage({
				    cont: 'pr-page',
				    pages: pages,
				    jump: function(obj){
				       // document.getElementById('biuuu_city_list').innerHTML = thisDate(obj.curr);
				    }
				})
			})
		</script>
		<script>
			$(function(){
				$(".order-title li a").click(function(){
					$(this).find("dl").slideToggle(400);
				})
				$(".order-li1 dd").click(function(){
					var dd_val=$(this).html();
					$(".order-li1 a span").html(dd_val);
				})
				$.each($(".order-list"), function(i,e) {
					$(e).find(".my-pro-cancel").siblings(".order-del").hide();
	                /*取消订单*/
					$(e).find(".my-pro-cancel").click(function(){
						$(e).find(".my-pro-cancel").remove();
							  $(e).find(".order-del").show();
							  $(e).find(".go-pay").remove();
							  $(e).find(".order-td4").html("已关闭");
							  parent.$(".layui-layer-shade,.layer-anim").hide();
						
					})
					/*删除订单*/
					$(e).find(".order-del").click(function(){
						parent.layer.open({
					   		title:['删除订单','background:#ffdd00;color:#ffffff;'],
					   		content:'<p class="is-order">订单删除后不可恢复<br>确定取消？<p>',
					   		btn:['确定','取消'],
					   		yes: function(index, layero){
					   		  parent.$(".layui-layer-shade,.layer-anim").hide();
							  $(e).remove();
							 }
				   	    })
					})
					
					/*确认收货*/
					$(e).find(".is-harvest").click(function(){
						parent.layer.open({
						title:'确认收货',
						content:'<p style="text-align:center">是否确认收货？</p>',
						yes:function(index, layero){
							$(e).find(".find-logistics").hide();
							$(e).find(".is-harvest").html("<a href='product-evaluation.html' target='ifa' class='order-eval'>去评价</a>");
							$(e).find(".is-harvest").click(function(){
								parent.$(".layui-layer-shade,.layer-anim").hide();
							})
							$(e).find(".order-li4").html("已完成(待评价)");
							parent.$(".layui-layer-shade,.layer-anim").hide();
						}
					})
					})
				});
			})
		</script>
		<!---todo------->
		<script>
				window.onbeforeunload = function(){
				    parent.$(".layui-layer-shade").hide();
					parent.$(".layer-anim").hide();				   
				}
		</script>
	</body>
</html>
