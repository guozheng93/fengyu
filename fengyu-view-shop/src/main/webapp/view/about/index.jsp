<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>关于我们</title>
	</head>
	<body>
		<div class="warpper1">
			<!---------start head(global)---------->
			<jsp:include page="/view/global/head.jsp"/>
			<!---------end   head(global)---------->
			<!---------start banner(part)---------->
			<jsp:include page="/view/global/part/banner.jsp"/>
			<!---------start banner(part)---------->
			<!---------start nav(part)------------->
			<jsp:include page="/view/global/part/nav.jsp">
				<jsp:param name="index" value="5"/>
			</jsp:include>
			<!---------start nav(part)------------->
			<!----------------------------------------------------->
			<div class="ab-box" style="width: 900px;margin:0 auto;margin-top:50px;">
				<img src="/statics/images/about-img.png" style="width: 100%;">
			</div>
			<!----------------------------------------------------->
			<div class="push1"></div>
		</div>
		<jsp:include page="/view/global/foot.jsp"/>
	</body>
</html>
