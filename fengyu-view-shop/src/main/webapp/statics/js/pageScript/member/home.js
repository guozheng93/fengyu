define(function(require, exports, module){
    var $ = require("jquery"),
        template = require("template"),
        md5 = require("md5"),
        tool = require("common/tool"),
        homeLy = -1,
        home = {};
    module.exports = home;

    //初始化
    home.init = function(){
        home.event();
        home.initBase();
        home.initEdu();
        home.initInfo();
        home.initWork();
    };

    //事件注册
    home.event = function(){
        // $("#pwd").keypress(function(e){
        //     if(e.keyCode==13){
        //         home.doLogin();
        //     }
        // });
        //
        // $("#homeBtn").click(function(){
        //     home.doLogin();
        // });
    };

    home.initInfo = function(){
        var params = {};
        var config = {
            url : "/member/info/get",
            params : params,
            onSuccess : home.doInitInfoSuccess
        };
        tool.apiReq(config);
    };

    home.doInitInfoSuccess = function(res){
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            var html = template("infoTemp",result.data);
            $("#infoId").html(html);
        }else if(result.code == 1002){
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作超时",2);
        }
    };

    home.initBase = function(){
        var data = new Array();
        data.username = sessionStorage.getItem("username");
        data.auth = sessionStorage.getItem("auth");
        var html = template("baseTemp",data);
        $("#baseId").html(html);
    };

    home.doInitBaseSuccess = function(res){
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            var html = template("eduTemp",result.data);
            $("#eduId").html(html);
        }else if(result.code == 1002){
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作超时",2);
        }
    };

    home.initEdu = function(){
        var params = {"currentPage":1,"numPerPage":5};
        var config = {
            url : "/member/setting/education/list",
            params : params,
            onSuccess : home.doInitEduSuccess
        };
        tool.apiReq(config);
    };

    home.doInitEduSuccess = function(res){
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            var html = template("eduTemp",result.data);
            $("#eduId").html(html);
        }else if(result.code == 1002){
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作超时",2);
        }
    };

    home.initWork = function(){
        var params = {"currentPage":1,"numPerPage":5};
        var config = {
            url : "/member/setting/work/list",
            params : params,
            onSuccess : home.doInitWorkSuccess
        };
        tool.apiReq(config);
    };

    home.doInitWorkSuccess = function(res){
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            var html = template("workTemp",result.data);
            $("#workId").html(html);
        }else if(result.code == 1002){
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作超时",2);
        }
    };
});
