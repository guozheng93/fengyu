<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的消息</title>
		<jsp:include page="/view/member/global/base-css.jsp"/>
	</head>
	<body>
		<div class="message-box">
			<div class="message-title">
				<a href="javascript:;" class="private-letter active-letter">私信<img src="/statics/images/daosanjiao.png"><span></span>
					<dl>
						<dd>已收到的私信（4）</dd>
						<dd>已发送的私信（4）</dd>
					</dl>
				</a>
				<a href="/view/member/message/sys/index.jsp" class="inside-letter">站内信<span class="badge">9</span></a>
				<span class="mesg-del"><input type="checkbox">选择全部 | <a href="javascript:;" class="del-btn">删除</a></span>
			</div>
			<div class="mesg-lists">
				<div class="mesg-list">
					<div class="ml-top">
						<img src="/statics/images/gray_duihao.png" class="ml-check">
						<span style="background-image: url(/statics/images/guanzhu.png);" class="ml-tu"></span>
						<span class="ml-name">名字</span>
						<div class="ml-r">
							<a href="javascript:;"><time>2016-06-06  15：30</time><img src="/statics/images/daosanjiao.png" class="ml-d">
							  <dl>
							  	<dd class="shield">屏蔽私信</dd>
							  	<dd class="reply">回复私信</dd>
							  </dl>
							</a>
						</div>
					</div>
					<p class="ml-brief"><a href="message-detail.html" target="ifa">私信私信私信私信私信私信私信私信私信私信私信私信</a></p>
				</div>
				<div class="mesg-list">
					<div class="ml-top">
						<img src="/statics/images/gray_duihao.png" class="ml-check">
						<span style="background-image: url(/statics/images/guanzhu.png);" class="ml-tu"></span>
						<span class="ml-name">名字</span>
						<div class="ml-r">
							<a href="javascript:;"><time>2016-06-06  15：30</time><img src="/statics/images/daosanjiao.png" class="ml-d">
							  <dl>
							  	<dd class="shield">屏蔽私信</dd>
							  	<dd class="reply">回复私信</dd>
							  </dl>
							</a>
						</div>
					</div>
					<p class="ml-brief"><a href="message-detail.html" target="ifa">私信私信私信私信私信私信私信私信私信私信私信私信</a></p>
				</div>
				<div class="mesg-list">
					<div class="ml-top">
						<img src="/statics/images/gray_duihao.png" class="ml-check">
						<span style="background-image: url(/statics/images/guanzhu.png);" class="ml-tu"></span>
						<span class="ml-name">名字</span>
						<div class="ml-r">
							<a href="javascript:;"><time>2016-06-06  15：30</time></a>
						</div>
					</div>
					<p class="ml-brief"><a href="message-detail.html" target="ifa">私信私信私信私信私信私信私信私信私信私信私信私信</a></p>
				</div>
				<div class="mesg-list">
					<div class="ml-top">
						<img src="/statics/images/gray_duihao.png" class="ml-check">
						<span style="background-image: url(/statics/images/guanzhu.png);" class="ml-tu"></span>
						<span class="ml-name">名字</span>
						<div class="ml-r">
							<a href="javascript:;"><time>2016-06-06  15：30</time><img src="/statics/images/daosanjiao.png" class="ml-d">
							  <dl>
							  	<dd class="shield">屏蔽私信</dd>
							  	<dd class="reply">回复私信</dd>
							  </dl>
							</a>
						</div>
					</div>
					<p class="ml-brief"><a href="message-detail.html" target="ifa">私信私信私信私信私信私信私信私信私信私信私信私信</a></p>
				</div>
				<div class="mesg-list">
					<div class="ml-top">
						<img src="/statics/images/gray_duihao.png" class="ml-check">
						<span style="background-image: url(/statics/images/guanzhu.png);" class="ml-tu"></span>
						<span class="ml-name">名字</span>
						<div class="ml-r">
							<a href="javascript:;"><time>2016-06-06  15：30</time></a>
						</div>
					</div>
					<p class="ml-brief"><a href="message-detail.html" target="ifa">私信私信私信私信私信私信私信私信私信私信私信私信</a></p>
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
				$(".private-letter img").click(function(){
					$(this).parents(".private-letter").find("dl").slideToggle(400);
					return false;
				})
				/*回复私信跳转*/
				$(".reply").click(function(){
					window.location.href="message-detail.html?type=1";
					
				})
				/*回复屏蔽操作*/
				$(".ml-d").click(function(){
					if($(this).parents("a").find("dl").css("display")=="none"){
						$(this).parents("a").find("dl").slideDown(400);
					}else{
						$(this).parents("a").find("dl").slideUp();
					}
					return false;
				})
				$.each($(".mesg-list"), function(i,e) {
					$(e).find(".shield").click(function(){
						parent.layer.open({
							title:'屏蔽私信',
							content:'<p class="mesg-tip">确定要屏蔽该条私信么？<br>屏蔽后不再接收该条私信。</p>',
							btn:['确定','取消'],
							yes:function(){
								$(e).find(".shield").html("已屏蔽");
								$(e).find(".shield").unbind('click');
								parent.$(".layui-layer-shade,.layer-anim").hide();	
							    $(e).find(".ml-d").parents("a").find('dl').hide();
							   
							},
							btn2:function(){
								parent.$(".layui-layer-shade,.layer-anim").hide();	
							     $(e).find(".ml-d").parents("a").find('dl').hide();
							}
						})
				    })
				});
			    /*删除*/
			   	$(".ml-check").click(function(){
			   		if($(this).attr("src")=="images/gray_duihao.png"){
			   			$(this).attr("src","images/queding.png");
			   			/*选中删除*/
			   			$(".del-btn").click(function(){
			   				parent.layer.open({
			   					title:'删除私信',
			   					content:'<p class="mesg-tip">确定要删除该条私信么？<br>删除后内容将不可恢复。</p>',
			   					btn:['确定','取消'],
			   					yes:function(){
			   						$.each($(".mesg-list"), function(i,e) {
			   							if($(e).find(".ml-check").attr("src")=="images/queding.png"){
			   								$(e).remove();
			   							}
			   						});
			   						parent.$(".layui-layer-shade,.layer-anim").hide();
			   					},
			   					btn2:function(){
			   						$(".ml-check").attr("src","images/gray_duihao.png");
			   					}
			   				})
			   			})
			   			
			   		}else{
			   			$(this).attr("src","images/gray_duihao.png");
			   		}
			   	})
			   /*全部删除*/
			   $(".mesg-del input").click(function(){
				   	if($(this).is(":checked")){
				   		$.each($(".mesg-list"), function(i,e) {
				   			$(e).find(".ml-check").attr("src","images/queding.png");
				   		});
				   	}else{
				   		$.each($(".mesg-list"), function(i,e) {
				   			$(e).find(".ml-check").attr("src","images/gray_duihao.png");
				   		});
				   	}
				   	$(".del-btn").click(function(){
				   		if($(".mesg-del input").is(":checked")){
				   			parent.layer.open({
				   				title:'删除私信',
			   					content:'<p class="mesg-tip">确定要删除所有的私信么？<br>删除后内容将不可恢复。</p>',
			   					btn:['确定','取消'],
			   					yes:function(){
			   						$(".mesg-list").remove();
			   						$(".mesg-del input").attr("checked",false);
			   						parent.$(".layui-layer-shade,.layer-anim").hide();
			   						$(".pr-page").remove();
			   					},
			   					btn2:function(){
			   						$(".ml-check").attr("src","images/gray_duihao.png");
			   						$(".mesg-del input").attr("checked",false);
			   					}
				   			})
				   		}else{
				   			return false;
				   		}
				   	})
			   })
				$(document).click(function(){
					$(".private-letter dl,.ml-r dl").css("display","none");
				})
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
