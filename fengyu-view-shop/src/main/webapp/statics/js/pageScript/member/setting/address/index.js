define(function(require, exports, module){
    var $ = require("jquery"),
        template = require("template"),
        tool = require("common/tool"),
        tools = require("common/tools"),
        addressLy = -1,
        address_js = {};
    module.exports = address_js;

    //初始化
    address_js.init = function(){
        $("#name,#email,#address,#phone").val("");
        $("#province,#city,#country").val("0");
        address_js.event();
        address_js.mainlList();

    };

    //事件注册
    address_js.event = function(){
        $("#submit").click(function(){
            address_js.submit();
        });
    };
    address_js.changeAddress = function(){
        $.each($(".shipp-list"), function(i,e) {
            if($(e).find(".ship-adres").html()=="默认地址"){
                $(e).find(".ship-adres").css("background","#00b1bb");
                $(e).find(".shipp-del").hide();
            }else{
                $(e).find(".ship-adres").css("background","#7fd8dd");
                $(e).find(".shipp-del").show();
            }
        });
    }

    address_js.submit = function(){
        addressLy = tool.load();
        var name = $.trim($("#name").val()),
            province = $.trim($("#province").val()),
            city = $.trim($("#city").val()),
            country = $.trim($("#country").val()),
            address = $.trim($("#address").val()),
            phone = $.trim($("#phone").val()),
            email = $.trim($("#email").val()),
            params = {
                "name":name,
                "province":province,
                "city":city,
                "country":country,
                "address":address,
                "phone":phone,
                "email":email
            };
        if(tool.isEmpty(name)) {
            tool.msg("收货人不能为空", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(province)){
            tool.msg("请选择省", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(city)){
            tool.msg("请选择市", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(country)){
            tool.msg("请选择区", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(phone)){
            tool.msg("手机号不能为空", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(email)){
            tool.msg("邮箱不能为空", 2);
            tool.closeLayer(addressLy);
            return;
        }else{
            var config = {
                url : "/member/setting/address/insert",
                params : params,
                onSuccess : address_js.doAddressSubmitSuccess
            };
            tool.apiReq(config);
        };
    };

    address_js.edit = function(){
        addressLy = tool.load();
        var name = $.trim($("#editName").val()),
            province = $.trim($("#editProvince").val()),
            city = $.trim($("#editCity").val()),
            country = $.trim($("#editCountry").val()),
            address = $.trim($("#editAddress").val()),
            phone = $.trim($("#editPhone").val()),
            email = $.trim($("#editEmail").val()),
            id = $.trim($("#id").val()),
            params = {
                "id":id,
                "name":name,
                "province":province,
                "city":city,
                "country":country,
                "address":address,
                "phone":phone,
                "email":email
            };
        if(tool.isEmpty(name)) {
            tool.msg("收货人不能为空", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(province)){
            tool.msg("请选择省", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(city)){
            tool.msg("请选择市", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(country)){
            tool.msg("请选择区", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(phone)){
            tool.msg("手机号不能为空", 2);
            tool.closeLayer(addressLy);
            return;
        }else if(tool.isEmpty(email)){
            tool.msg("邮箱不能为空", 2);
            tool.closeLayer(addressLy);
            return;
        }else{
            var config = {
                url : "/member/setting/address/edit",
                params : params,
                onSuccess : address_js.doAddressSubmitSuccess
            };
            tool.apiReq(config);
        };
    };

    address_js.mainlList = function(){
        var name = $.trim($("#name").val()),
            params = {
                "currentPage":1,
                "numPerPage":8
            };
        if(false) {

        }else{
            var config = {
                url : "/member/setting/address/list",
                params : params,
                onSuccess : address_js.doAddressMainListSuccess
            };
            tool.apiReq(config);
        };
    };

    address_js.settingDefault = function(id,flag){
        var name = $.trim($("#name").val()),
            params = {
                "id":id,
                "default":flag
            };
        if(false) {

        }else{
            var config = {
                url : "/member/setting/address/edit",
                params : params,
                onSuccess : address_js.doAddressSettingDefaultSuccess
            };
            tool.apiReq(config);
        };
    };

    address_js.delete = function(id){
        var name = $.trim($("#name").val()),
            params = {
                "id":id
            };
        if(false) {

        }else{
            var config = {
                url : "/member/setting/address/delete",
                params : params,
                onSuccess : address_js.doAddressSettingDefaultSuccess
            };
            tool.apiReq(config);
        };
    };

    address_js.get = function(id){
        var name = $.trim($("#name").val()),
            params = {
                "id":id
            };
        if(false) {

        }else{
            var config = {
                url : "/member/setting/address/get",
                params : params,
                onSuccess : address_js.doAddressGetSuccess
            };
            tool.apiReq(config);
        };
    };

    address_js.doAddressSubmitSuccess = function(res){
        tool.closeLayer(addressLy);
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
           // tool.msg("保存成功",1);
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    };

    address_js.doAddressMainListSuccess = function(res){
        tool.closeLayer(addressLy);
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            var html = template("addressTemp",result.data);
            $("#addressListId").html(html);
            address_js.changeAddress();
            $(".ship-adres").click(function(){
                var addressId = $(this).attr("addid");
                if($(this).html()=="默认地址"){
                    $(this).html("设置为默认地址");
                    address_js.settingDefault(addressId,false);
                    address_js.changeAddress();
                }else if($(this).html()=="设置为默认地址"){
                    $(".ship-adres").html("设置为默认地址");
                    $(this).html("默认地址");
                    address_js.settingDefault(addressId,true);
                    address_js.changeAddress();
                }
            })

            /*修改地址*/
            $(".shipp-modify").click(function(){
                var addressId = $(this).attr("addid");
                address_js.get(addressId);
            })
            /*修改地址保存*/
            parent.$(".ship-p6 a").click(function(){
                parent.$(".bound,.modify-adres-box").hide();
                address_js.edit();
            })
            /*删除地址*/
            $(".shipp-del").click(function(){
                $(this).parents(".shipp-list").remove();
                var addressId = $(this).attr("addid");
                address_js.delete(addressId)
            })
            // tool.msg("保存成功",1);
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    };

    address_js.doAddressSettingDefaultSuccess = function(res){
        tool.closeLayer(addressLy);
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            tool.msg("保存成功",1);
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    };
    
    address_js.doAddressGetSuccess = function (res) {
        tool.closeLayer(addressLy);
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            parent.$(".bound").show();
            parent.$(".modify-adres-box").show();
            console.log(result);
            console.log(result["data"]["name"]);
            $("#editName").val(result["data"]["name"]);
            $("#editAddress").val(result.data.address);
            $("#editPhone").val(result.data.phone);
            $("#editEmail").val(result.data.email);
            $("#editProvince").val(result.data.province);
            $("#editCity").val(result.data.city);
            $("#editCountry").val(result.data.country);
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("操作失败",2);
        }
    }
});
