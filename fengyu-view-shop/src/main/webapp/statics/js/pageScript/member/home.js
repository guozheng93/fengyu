define(function(require, exports, module){
    var $ = require("jquery"),
        md5 = require("md5"),
        tool = require("common/tool"),
        loginLy = -1,
        login = {};
    module.exports = login;

    //初始化
    login.init = function(){
        $("#loginName,#pwd").val("");
        login.event();
        login.loadTopWindow();
    };

    //判断当前窗口是否有顶级窗口，如果有就让当前的窗口的地址栏发生变化，
    login.loadTopWindow = function (){
        if(window.top!=null && window.top.document.URL!=document.URL){
            window.top.location= document.URL; //这样就可以让登陆窗口显示在整个窗口了
        }
    }

    //事件注册
    login.event = function(){
        $("#pwd").keypress(function(e){
            if(e.keyCode==13){
                login.doLogin();
            }
        });

        $("#loginBtn").click(function(){
            login.doLogin();
        });
    };

    login.doLogin = function(){
        loginLy = tool.load();
        var loginName = $.trim($("#loginName").val()),
            pwd = $.trim($("#pwd").val()),
            params = {"loginName":loginName, 'password':pwd};
        if(false){
            tool.msg("账号密码不允许为空",2);
            tool.closeLayer(loginLy);
            return;
        }else{
            var config = {
                url : "/member/user/list",
                params : params,
                onSuccess : login.doLoginSuccess
            };
            tool.apiReq(config);
        };
    };

    login.doLoginSuccess = function(res){
        tool.closeLayer(loginLy);
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            localStorage.setItem("token", result.data.token);
            localStorage.setItem("refreshToken", result.data.refreshToken);
            //跳转到主界面
            location.href ="/view/member/index.jsp";
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("登录失败",2);
        }
    };
});
