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
    var serverUrl="http://127.0.0.1:8080/api/rest/";

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
<script type="text/javascript">
    function ScreenSaver(settings){
        this.settings = settings;

        this.nTimeout = this.settings.timeout;

        document.body.screenSaver = this;
        // link in to body events
        document.body.onmousemove = ScreenSaver.prototype.onevent;
        document.body.onmousedown = ScreenSaver.prototype.onevent;
        document.body.onkeydown = ScreenSaver.prototype.onevent;
        document.body.onkeypress = ScreenSaver.prototype.onevent;

        var pThis = this;
        var f = function(){pThis.timeout();}
        this.timerID = window.setTimeout(f, this.nTimeout);
    }
    ScreenSaver.prototype.timeout = function(){
        if ( !this.saver ){
            localStorage.removeItem("refreshToken");
            localStorage.removeItem("token");
        }
    }
    ScreenSaver.prototype.signal = function(){
        if ( this.saver ){
            this.saver.stop();
        }

        window.clearTimeout(this.timerID);

        var pThis = this;
        var f = function(){pThis.timeout();}
        this.timerID = window.setTimeout(f, this.nTimeout);
    }

    ScreenSaver.prototype.onevent = function(e){
        this.screenSaver.signal();
    }


    var saver;
    function initScreenSaver(){
        //blort;
        saver = new ScreenSaver({timeout:1000*60*30});
    }
    window.onload = initScreenSaver();

</script>

