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
		    <div class="shipp-lists" id = "addressListId" style="height: 100%">
		    	<div class="shipp-list">
		    		<span class="ship-adres" style="background: rgb(0, 177, 187);">默认地址</span>
		    		<h4><b>谭某某</b></h4>
		    		<p>收货地址：<span>某某省 某某市 某某区 </span></p>
		    		<p>手机号码：151-0000-0000</p>
                    <p>邮箱：25341171@163.com</p>
                    <span class="shipp-operation"><span class="shipp-modify">修改</span><span class="shipp-del">删除</span></span>
		    	</div>
		    </div>
		    <div class="ship-info">
		    	<p class="ship-info-title"><b>新增收货地址</b></p>
		    	<p class="ship-p1"><span>收货人：</span><input type="text" id ="name"></p>
		    	<p class="ship-p2"><span>所在地地址:</span>
		    		<select id="province">
		    			<option>请选择</option>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    		</select>
		    		省
		    		<select id="city">
		    			<option>请选择</option>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    		</select>
		    		市
		    		<select id="country">
		    			<option>请选择</option>
		    			<option>请选择</option>
		    			<option>请选择</option>
		    		</select>
		    		区
		    	</p>
		    	<p class="ship-p3"><span></span><input type="text" id="address" placeholder="填写详细地址"></p>
		    	<p class="ship-p4"><span>手机号码：</span><input id="phone" type="number" maxlength="11"></p>
		    	<p class="ship-p5"><span>邮箱：</span><input id="email" type="text"></p>
		    	<p class="ship-p6"><span></span><a href="javascript:;" id="submit">保存</a></p>
		    </div>
		</div>

		<script type="text/javascript" src="/statics/js/plugin/seajs/sea.js"></script>
		<script type="text/javascript">
			seajs.config({
				base: "/statics/js/",
				alias: {
					"jquery"  :  "plugin/jquery/jquery-1.10.2.min",
					"md5"     :  "plugin/jquery/jquery.md5",
					"template" :  "lib/template.js"
				},
				map: [
					[ /^(.*\/js\/.*\.(?:css|js))(?:.*)$/i, '$1?201605241248']
				]
			});
			seajs.use("/statics/js/pageScript/member/setting/address/index.js",function(login){
//				login.init();
			});
		</script>
		<%--我要支持点击后的 支持列表--%>
		<script id="addressTemp" type="text/html">
			{{each recordList as item i}}
			<div class="shipp-list">
				{{if item.default}}
					<span class="ship-adres" addid = "{{item.id}}">默认地址</span>
				{{else}}
					<span class="ship-adres" addid = "{{item.id}}">设置为默认地址</span>
				{{/if}}
				<h4><b>{{item.name}}</b></h4>
				<p>收货{{item.default}}地址：<span>{{item.provinceId}} {{item.cityId}} {{item.countryId}}{{item.address}} </span></p>
				<p>手机号码：{{item.phone}}</p>
				<p>邮箱：{{item.email}}</p>
				<span class="shipp-operation"><span addid = "{{item.id}}" class="shipp-modify">修改</span><span addid = "{{item.id}}" class="shipp-del">删除</span></span>
			</div>
			{{/each}}
		</script>
		<!-----修改地址----------->
		<div class="modify-adres-box">
			<span class="modify-close">×</span>
			<p class="ship-info-title"><b>修改收货地址</b></p>
			<input type="hidden" id = "id">
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
	</body>
</html>
