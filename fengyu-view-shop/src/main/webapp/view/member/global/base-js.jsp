<script type="text/javascript" src="/statics/js/jquery1.11.3.min.js" ></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="/statics/js/lib/layer/layer.js" ></script>
<script src="/statics/js/laydate.js"></script>
<script src="/statics/js/lib/layer/laypage.js"></script>
<script type="text/javascript">

    // 当遇到 401 状态码时，清空 cookie 中的 token，并跳转到登录页面
    $.ajaxSetup({
        statusCode: {
            401: function () {
                $.removeCookie(Cookie.TOKEN);
                location.href = '/view/login.jsp';
            }
        }
    });


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
            //window.location = 'http://www.baidu.com';
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
        var timeout = 1000*60*30;
        saver = new ScreenSaver({timeout:timeout});
    }
    window.onload = initScreenSaver();

</script>