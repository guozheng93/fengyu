<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<% String platPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"platform/";%>
<%--<% String jsonPath = "http://47.88.190.192:8088/silu_api/rest/"; %>--%>
<% String jsonPath = "http://47.88.190.192:8088/silu_api/rest/"; %>
<% String picPath = "http://47.88.190.192:8787/"; %>
<script>
    var basePath = "${basePath }";
    var platPath = "${platPath }";
    var picPath = "${picPath }";
    //var fileServerUrl="http://47.88.190.192:8787/";
    var fileServerUrl="http://ocr6w6mo0.bkt.clouddn.com/";
    var serverUrl="http://127.0.0.1:8181/rest/";

</script>
<script type="text/javascript" src="/statics/js/common/config.js" ></script>
<script type="text/javascript" src="/statics/js/common/returncode.js" ></script>
<script type="text/javascript" src="/statics/js/jquery1.11.3.min.js" ></script>
<script type="text/javascript" src="/statics/js/lib/DP_DateExtensions.js" ></script>
<script type="text/javascript" src="/statics/js/common/exception.js" ></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="/statics/js/lib/layer/layer.js" ></script>
<script type="text/javascript" src="/statics/js/lib/template.js" ></script>
<script type="text/javascript" src="/statics/js/common/template-helper.js" ></script>
<script type="text/javascript" src="/statics/js/common/tools.js" ></script>

