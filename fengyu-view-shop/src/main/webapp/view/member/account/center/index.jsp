<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>账户明细</title>
		<jsp:include page="/view/member/global/base-css.jsp"/>
	</head>
	<body>
		<div class="account-box">
			<p class="zhang-title"><b>账户明细</b></p>
			<div class="zhang-con">
				<div class="zhang-left">
					<p class="zhang-p1">余额：<b>¥0</b></p>
					<p class="zhang-p2">为了保证您账户余额的安全，如需提现，请致电蜂娱客服进行申请和审核：400-025-3721</p>
				</div>
				<div class="zhang-oper">
					<a href="recharge-one.html" class="zhang-chong" target="ifa">充值</a><a href="withdrawal-one.html" class="zhang-tixian" target="ifa">提现</a>
				</div>
			</div>
			<div class="balance-con">
				<p class="zhang-title"><b>收支明细</b></p>
				<div class="balance-mid">
					<div class="pro-mag-tab balance-mag-tab">
						<a href="javascript:;" class="active-tab">全部</a>
						<a href="javascript:;">一个月</a>
						<a href="javascript:;">三个月</a>
						<a href="javascript:;">六个月</a>
						<a href="javascript:;">一年</a>
					</div>
					<div class="balance-data">
					      从<input class="laydate-icon" id="demo" value="">到<input class="laydate-icon" id="demo2" value=""> 
					</div>
				</div>
				<table class="table table-bordered balance-tab">
					<thead>
						<tr>
							<th>时间</th>
							<th>交易单号</th>
							<th>名称</th>
							<th>收入</th>
							<th>支出</th>
							<th>状态准备</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="bal-time">2016-06-04<br>15:40:00</td>
							<td class="bal-odd">oooooooooo</td>
							<td class="bal-name"><span>充值</span></td>
							<td class="bal-in">55</td>
							<td class="text-danger bal-out">0</td>
							<td class="bal-state">交易成功</td>
						</tr>
						<tr>
							<td class="bal-time">2016-06-04<br>15:40:00</td>
							<td class="bal-odd">oooooooooo</td>
							<td class="bal-name"><span>提现</span><span class="bal-tip">（提现后三日内到账）</span></td>
							<td class="bal-in">0</td>
							<td class="text-danger">55</td>
							<td class="bal-state">交易成功</td>
						</tr>
						<tr>
							<td class="bal-time">2016-06-04<br>15:40:00</td>
							<td class="bal-odd">oooooooooo</td>
							<td class="bal-name"><span>项目支持</span></td>
							<td class="bal-in">0</td>
							<td class="text-danger">55</td>
							<td class="bal-state">交易成功</td>
						</tr>
						<tr>
							<td class="bal-time">2016-06-04<br>15:40:00</td>
							<td class="bal-odd">oooooooooo</td>
							<td class="bal-name"><span>提现</span><span class="bal-tip">（提现后三日内到账）</span></td>
							<td class="bal-in">0</td>
							<td class="text-danger">55</td>
							<td class="bal-state">交易失败</td>
						</tr>
						<tr>
							<td class="bal-time">2016-06-04<br>15:40:00</td>
							<td class="bal-odd">oooooooooo</td>
							<td class="bal-name"><span>提现</span><span class="bal-tip">（提现后三日内到账）</span></td>
							<td class="bal-in">0</td>
							<td class="text-danger">55</td>
							<td class="bal-state">提现中</td>
						</tr>
					</tbody>
				</table>
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
				/*$(".zhang-oper img").popover({
					placement:'bottom',
					html:true,
					content:'1-3个工作日',
				})*/
				/*小分类样式*/
				$(".pro-mag-tab a").click(function(){
					$(this).addClass("active-tab").siblings().removeClass("active-tab");
				})
				$("#demo2").click(function(){
					$("#laydate_box").css("left","670px");
				})
			})
		</script>
		<script>
			!function(){
				laydate.skin('default');//切换皮肤，请查看skins下面皮肤库
				laydate({elem: '#demo'});//绑定元素
				laydate({elem: '#demo2'});
				$("#laydate_box").css("left","670px");
			}();
				//日期范围限制
			var start = {
			    elem: '#start',
			    format: 'YYYY-MM-DD',
			    min: laydate.now(), //设定最小日期为当前日期
			    max: '2099-06-16', //最大日期
			    istime: true,
			    istoday: false,
			    choose: function(datas){
			         end.min = datas; //开始日选好后，重置结束日的最小日期
			         end.start = datas //将结束日的初始值设定为开始日
			    }
			};
			
			var end = {
			    elem: '#end',
			    format: 'YYYY-MM-DD',
			    min: laydate.now(),
			    max: '2099-06-16',
			    istime: true,
			    istoday: false,
			    choose: function(datas){
			        start.max = datas; //结束日选好后，充值开始日的最大日期
			    }
			};
			laydate(start);
			laydate(end);
			
			//自定义日期格式
			laydate({
			    elem: '#test1',
			    format: 'YYYY年MM月DD日',
			    festival: true, //显示节日
			    choose: function(datas){ //选择日期完毕的回调
			        alert('得到：'+datas);
			    }
			});
			
			//日期范围限定在昨天到明天
			laydate({
			    elem: '#hello3',
			    min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
			    max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
			});	
		</script>
	</body>
</html>
