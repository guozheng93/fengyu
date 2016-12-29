<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
		<meta charset="UTF-8">
		<title></title>
		<jsp:include page="/view/member/global/base-css.jsp"/>

		<div class="pd-head">
			<a href="javascript:;" class="active-pda">个人资料</a>
			<a href="javascript:;">头像照片</a>
		</div>
		<div class="pd-main">
			<h5><b>基本资料</b></h5>
			<div class="pd-info">
				<div class="pd-base">
					<span style="background-image: url(/statics/images/ln_tu.png);" class="pd-toux"></span>
					<div class="pd-r">
						<p class="pd-r-p1">昵称：<span>某某用户</span></p>
						<div class="pd-r-p2">资料完整度：<p><span style="width:50%" class="pd-span"></span></p><span class="pd-stxt">50%</span></div>
					</div>
				</div>
				<div class="pd-plist">
					<p class="pd-p1"><span>昵称：</span><input id="name" type="text"></p>
					<p class="pd-p2"><span>年龄：</span><input id="age" type="number"><b>岁</b></p>
					<p class="pd-p3">
						<span>生日：</span>
						<select id ="birYear">
							<option value="0">请选择</option>
							<option value="1976">1976</option>
							<option value="1977">1977</option>
							<option value="1978">1978</option>
							<option value="1979">1979</option>
							<option value="1980">1980</option>
							<option value="1981">1981</option>
							<option value="1982">1982</option>
							<option value="1983">1983</option>
							<option value="1984">1984</option>
							<option value="1985">1985</option>
							<option value="1986">1986</option>
							<option value="1987">1987</option>
							<option value="1988">1988</option>
							<option value="1989">1989</option>
							<option value="1990">1990</option>
							<option value="1991">1991</option>
							<option value="1992">1992</option>
							<option value="1993">1993</option>
							<option value="1994">1994</option>
							<option value="1995">1995</option>
							<option value="1996">1996</option>
							<option value="1997">1997</option>
							<option value="1998">1998</option>
							<option value="1999">1999</option>
							<option value="2000">2000</option>
							<option value="2001">2001</option>
							<option value="2002">2002</option>
							<option value="2003">2003</option>
							<option value="2004">2004</option>
							<option value="2005">2005</option>
							<option value="2006">2006</option>
							<option value="2007">2007</option>
							<option value="2008">2008</option>
							<option value="2009">2009</option>
							<option value="2010">2010</option>
							<option value="2011">2011</option>
							<option value="2012">2012</option>
							<option value="2013">2013</option>
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
						</select>
						年
						<select id="birMon">
							<option value="0">请选择</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
						月
						<select id="birDay">
							<option>请选择</option>
						</select>
						日
					</p>
					<p class="pd-p4">
						<span>星座：</span>
						<select id ="constellation">
							<option>白羊座</option>
							<option>金牛座</option>
							<option>双子座</option>
							<option>狮子座</option>
							<option>巨蟹座</option>
							<option>处女座</option>
							<option>天秤座</option>
							<option>天蝎座</option>
							<option>射手座</option>
							<option>摩羯座</option>
							<option>水瓶座</option>
							<option>双鱼座</option>
						</select>
					</p>
					<p class="pd-p5">
						<span>个性签名：</span>
						<input type="text" id ="info" placeholder="一句话描述~">
					</p>
					<p class="pd-p6">
						<span>感情状态：</span>
						<input id ="feelingInfo" type="text">
					</p>
					<p class="pd-p7"><span>家乡：</span>
						<select id ="oldProvince">
							<option>请选择</option>
						</select>
						<select id ="oldCity">
							<option>请选择</option>
						</select>
						<select id ="oldCounty">
							<option>请选择</option>
						</select>
					</p>
					<p class="pd-p8"><span>现居地：</span>
						<select id ="province">
							<option>请选择</option>
						</select>
						<select id ="city">
							<option>请选择</option>
						</select>
						<select id ="county">
							<option>请选择</option>
						</select>
						<%--<select>--%>
							<%--<option>乡镇／街道</option>--%>
							<%--<option>乡镇／街道</option>--%>
							<%--<option>乡镇／街道</option>--%>
						<%--</select>--%>
					</p>
					<p class="pd-p9">
						<span></span>
						<input id ="address" type="text" placeholder="详细地址">
					</p>
			    </div>
			    <!------------------------------>
			    <div class="education-info">
			    	<h5><b>学历信息</b></h5>
			    	<p class="edui-p1"><span>学校：</span><input type="text"><span>学历：</span><input type="text"><span>专业:</span><input type="text"></p>
			    	<p class="edui-p2"><span>时间：</span>
			    		<select>
			    			<option>2011</option>
			    			<option>2011</option>
			    			<option>2011</option>
			    			<option>2011</option>
			    		</select>
			    		年
			    		<select>
			    			<option>9</option>
			    			<option>9</option>
			    			<option>9</option>
			    			<option>9</option>
			    		</select>
			    		月-
			    		<select>
			    			<option>2012</option>
			    			<option>2012</option>
			    			<option>2012</option>
			    			<option>2012</option>
			    		</select>
			    		年
			    		<select>
			    			<option>8</option>
			    			<option>8</option>
			    			<option>8</option>
			    			<option>8</option>
			    		</select>
			    		月
			    	</p>
			    	<!----------tianjia---------------->
			    	<div class="add-con data-add">
			    		<p class="edui-p1"><span>学校：</span><input type="text"><span>学历：</span><input type="text"><span>专业:</span><input type="text"></p>
			    	<p class="edui-p2"><span>时间：</span>
			    		<select>
			    			<option>2011</option>
			    			<option>2011</option>
			    			<option>2011</option>
			    			<option>2011</option>
			    		</select>
			    		年
			    		<select>
			    			<option>9</option>
			    			<option>9</option>
			    			<option>9</option>
			    			<option>9</option>
			    		</select>
			    		月-
			    		<select>
			    			<option>2012</option>
			    			<option>2012</option>
			    			<option>2012</option>
			    			<option>2012</option>
			    		</select>
			    		年
			    		<select>
			    			<option>8</option>
			    			<option>8</option>
			    			<option>8</option>
			    			<option>8</option>
			    		</select>
			    		月
			    	</p>
			    	<a href="javascript:;" class="add-del">删除</a>
			    	</div>
			    	<div class="edui-add">
			    		<img src="/statics/images/tianjia.png">点击添加学历
			    	</div>
			    </div>
			    <div class="work-info">
			    	<h5><b>工作信息</b></h5>
			    	<p class="work-p1">
			    		<span>公司:</span><input type="text">
			    	    <span>职位:</span><input type="text">
			    	</p>
			    	<p class="work-p2"><span>时间：</span>
			    		<select>
			    			<option>2011</option>
			    			<option>2011</option>
			    			<option>2011</option>
			    			<option>2011</option>
			    		</select>
			    		年
			    		<select>
			    			<option>9</option>
			    			<option>9</option>
			    			<option>9</option>
			    			<option>9</option>
			    		</select>
			    		月-
			    		<select>
			    			<option>2012</option>
			    			<option>2012</option>
			    			<option>2012</option>
			    			<option>2012</option>
			    		</select>
			    		年
			    		<select>
			    			<option>8</option>
			    			<option>8</option>
			    			<option>8</option>
			    			<option>8</option>
			    		</select>
			    		月
			    	</p>
			    	<div class="work-add">
			    		<img src="/statics/images/tianjia.png">点击添加工作信息
			    	</div>
			    	<!----------tianjia---------------->
			    	<div class="add-con2">
				    	<p class="work-p1">
				    		<span>公司:</span><input type="text">
				    	    <span>职位:</span><input type="text">
				    	</p>
				    	<p class="work-p2"><span>时间：</span>
				    		<select>
				    			<option>2011</option>
				    			<option>2011</option>
				    			<option>2011</option>
				    			<option>2011</option>
				    		</select>
				    		年
				    		<select>
				    			<option>9</option>
				    			<option>9</option>
				    			<option>9</option>
				    			<option>9</option>
				    		</select>
				    		月-
				    		<select>
				    			<option>2012</option>
				    			<option>2012</option>
				    			<option>2012</option>
				    			<option>2012</option>
				    		</select>
				    		年
				    		<select>
				    			<option>8</option>
				    			<option>8</option>
				    			<option>8</option>
				    			<option>8</option>
				    		</select>
				    		月
				    	</p>
				    	<a href="javascript:;" class="add-del">删除</a>
			    	</div>
			    </div>
			</div>
			<a href="javascript:;" class="pd-save">保存</a>
		</div>
		<div class="pd-main">
			<p class="upload-p">
				<a href="javascript:;" class="a-upload"><input type="file"><img src="/statics/images/tu_icon.png">点击上传头像图片</a>
				<span>仅支持JPG、GIF、PNG、JPEG、BMP格式，文件小于4M</span>
			</p>
			<div class="pd-edithead">
			   <span style="background-image:url(/statics/images/foot_bg.png)" class="pd-editl"></span>
			   <div class="pd-editr">
			   	<p>头像预览</p>
			   	<span style="background-image:url(/statics/images/foot_bg.png)"></span>
			   </div>
			</div>
			<div class="recommended-head">
				<h5><b>推荐头像：</b></h5>
				<div class="rec-h-list">
					<a href="javascript:;" style="background-image:url(/statics/images/tui1.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui2.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui3.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui4.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui5.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui6.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui7.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui8.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui9.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui10.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui11.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui12.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui13.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui14.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui15.png)"></a>
					<a href="javascript:;" style="background-image:url(/statics/images/tui16.png)"></a>
				</div>
			</div>
			<a href="javascript:;" class="pd-save">保存</a>
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
	seajs.use("/statics/js/pageScript/member/setting/info/index.js",function(index){
		index.init();
	});
</script>
<%--<script type="text/javascript">--%>
	<%--seajs.config({--%>
		<%--base: "/statics/js/",--%>
		<%--alias: {--%>
			<%--"jquery"  :  "plugin/jquery/jquery-1.10.2.min",--%>
			<%--"md5"     :  "plugin/jquery/jquery.md5",--%>
			<%--"template" :  "lib/template.js"--%>
		<%--},--%>
		<%--map: [--%>
			<%--[ /^(.*\/js\/.*\.(?:css|js))(?:.*)$/i, '$1?201605241248']--%>
		<%--]--%>
	<%--});--%>
	<%--seajs.use("/statics/js/pageScript/member/setting/info/info.js",function(index){--%>
		<%--index.init();--%>
	<%--});--%>
<%--</script>--%>
		<%--<script>--%>
			<%--$(function(){--%>
		        <%--/**/--%>
		        <%--$(".pd-main").hide().eq(0).show();--%>
		        <%--$(".pd-head a").click(function(){--%>
		        <%----%>
		       	<%--$(this).addClass("active-pda").siblings().removeClass("active-pda");--%>
		       	<%--var pd_indexa=$(this).index();--%>
		       	<%--$(".pd-main").eq(pd_indexa).show().siblings(".pd-main").hide();--%>
		       	<%----%>
		        <%--})--%>
				<%--$(".edui-add").click(function(){--%>
					<%--$(".add-con").show();--%>
					<%--parent.iFrameHeight();--%>
					<%--$(".add-del").click(function(){--%>
					<%--$(".add-con,.add-con2").hide();--%>
					<%--})--%>
				<%--})--%>
				<%--$(".work-add").click(function(){--%>
					<%--$(".add-con2").show();--%>
					<%--parent.iFrameHeight();--%>
					<%--$(".add-del").click(function(){--%>
						<%--$(".add-con").hide();--%>
					<%--})--%>
				<%--})--%>
				<%--/*资料保存成功提示*/--%>
				<%--$(".pd-save").click(function(){--%>
					<%--layer.msg("恭喜，您的资料保存成功");--%>
				<%--})--%>
			<%--})--%>
		<%--</script>--%>

