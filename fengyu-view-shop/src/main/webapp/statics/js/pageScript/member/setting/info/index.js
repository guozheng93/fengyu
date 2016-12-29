define(function(require, exports, module){
    var $ = require("jquery"),
        template = require("template"),
        tool = require("common/tool"),
        tools = require("common/tools"),
        infoLy = -1,
        info_js = {};
    module.exports = info_js;

    //初始化
    info_js.init = function(){
        info_js.event();
        info_js.initOldProvince();
        info_js.initProvince();

    };

    //事件注册
    info_js.event = function(){
        $("#submit").click(function(){
            info_js.submit();
        });


        $("#oldProvince").change(function(){
            info_js.changeOldProvince($("#oldProvince").val());
        });

        $("#oldCity").change(function(){
            info_js.changeOldCity($("#oldProvince").val(),$("#oldCity").val());
        });

        $("#oldCounty").change(function(){
            info_js.changeOldCounty($("#oldCounty").val());
        });

        $("#province").change(function(){
            info_js.changeProvince($("#province").val());
        });

        $("#city").change(function(){
            info_js.changeCity($("#province").val(),$("#city").val());
        });

        $("#county").change(function(){
            info_js.changeCounty($("#city").val());
        });

    };



    info_js.initOldProvince = function(){
        var name = $.trim($("#name").val()),
            params = {
                "currentPage":1,
                "numPerPage":100,
                "level":1
            };
        if(false) {

        }else{
            var config = {
                url : "/common/area/list",
                params : params,
                onSuccess : info_js.doInfoOldProvinceSuccess
            };
            tool.apiReq(config);
        };
    };

    info_js.doInfoOldProvinceSuccess = function(res){
        tool.closeLayer(infoLy);
        var provinceHTML = "<option value='0'>请选择</option>";
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            for(var i = 0;i<result.data.recordList.length;i++){
                provinceHTML+= "<option value='"+result.data.recordList[i]['id']+"'>"+result.data.recordList[i]['name']+"</option>";
            }
            $("#oldProvince").html(provinceHTML);
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    };

    info_js.changeOldProvince = function(parentid){
        var name = $.trim($("#name").val()),
            params = {
                "currentPage":1,
                "numPerPage":100,
                "parentid":parentid
            };
        if(false) {
        }else{
            var config = {
                url : "/common/area/list",
                params : params,
                onSuccess : info_js.doInfoChangeOldProvinceSuccess
            };
            tool.apiReq(config);
        };
    };

    info_js.doInfoChangeOldProvinceSuccess = function(res){
        tool.closeLayer(infoLy);
        var HTMl = "<option value='0'>请选择</option>";
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            for(var i = 0;i<result.data.recordList.length;i++){
                HTMl+= "<option value='"+result.data.recordList[i]['id']+"'>"+result.data.recordList[i]['name']+"</option>";
            }
            $("#oldCity").html(HTMl);
            $("#oldcounty").html("<option value='0'>请选择</option>");
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    };




    info_js.changeOldCity = function(province,city){
        var name = $.trim($("#name").val()),
            params = {
                "currentPage":1,
                "numPerPage":100,
                "parentid":city
            };
        if(province == 0) {
            tool.msg("请选择家乡所在省",2);
            return;
        }else{
            var config = {
                url : "/common/area/list",
                params : params,
                onSuccess : info_js.doInfoChangeOldCitySuccess
            };
            tool.apiReq(config);
        };
    };

    info_js.doInfoChangeOldCitySuccess = function(res){
        tool.closeLayer(infoLy);
        var HTMl = "<option value='0'>请选择</option>";
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            for(var i = 0;i<result.data.recordList.length;i++){
                HTMl+= "<option value='"+result.data.recordList[i]['id']+"'>"+result.data.recordList[i]['name']+"</option>";
            }
            $("#oldCounty").html(HTMl);
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    };

    info_js.changeOldCounty = function(city){
        if(city == 0) {
            tool.msg("请选择家乡所在市",2);
            return;
        }
    };


    info_js.initProvince = function(){
        var name = $.trim($("#name").val()),
            params = {
                "currentPage":1,
                "numPerPage":100,
                "level":1
            };
        if(false) {

        }else{
            var config = {
                url : "/common/area/list",
                params : params,
                onSuccess : info_js.doInfoProvinceSuccess
            };
            tool.apiReq(config);
        };
    };

    info_js.doInfoProvinceSuccess = function(res){
        tool.closeLayer(infoLy);
        var HTMl = "<option value='0'>请选择</option>";
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            for(var i = 0;i<result.data.recordList.length;i++){
                HTMl+= "<option value='"+result.data.recordList[i]['id']+"'>"+result.data.recordList[i]['name']+"</option>";
            }
            $("#province").html(HTMl);
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    };

    info_js.changeProvince = function(parentid){
        var name = $.trim($("#name").val()),
            params = {
                "currentPage":1,
                "numPerPage":100,
                "parentid":parentid
            };
        if(false) {
        }else{
            var config = {
                url : "/common/area/list",
                params : params,
                onSuccess : info_js.doInfoChangeProvinceSuccess
            };
            tool.apiReq(config);
        };
    };

    info_js.doInfoChangeProvinceSuccess = function(res){
        tool.closeLayer(infoLy);
        var HTMl = "<option value='0'>请选择</option>";
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            for(var i = 0;i<result.data.recordList.length;i++){
                HTMl+= "<option value='"+result.data.recordList[i]['id']+"'>"+result.data.recordList[i]['name']+"</option>";
            }
            $("#city").html(HTMl);
            $("#county").html("<option value='0'>请选择</option>");
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    };




    info_js.changeCity = function(province,city){
        var name = $.trim($("#name").val()),
            params = {
                "currentPage":1,
                "numPerPage":100,
                "parentid":city
            };
        if(province == 0) {
            tool.msg("请选择家乡所在省",2);
            return;
        }else{
            var config = {
                url : "/common/area/list",
                params : params,
                onSuccess : info_js.doInfoChangeCitySuccess
            };
            tool.apiReq(config);
        };
    };

    info_js.doInfoChangeCitySuccess = function(res){
        tool.closeLayer(infoLy);
        var HTMl = "<option value='0'>请选择</option>";
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            for(var i = 0;i<result.data.recordList.length;i++){
                HTMl+= "<option value='"+result.data.recordList[i]['id']+"'>"+result.data.recordList[i]['name']+"</option>";
            }
            $("#county").html(HTMl);
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    };

    info_js.changeCounty = function(city){
        if(city == 0) {
            tool.msg("请选择家乡所在市",2);
            return;
        }
    };



});
