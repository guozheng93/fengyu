$(function () {
    initEvent();
    getList4AcctByUserId();
    getAcctInfoByMap({prjtId:sessionStorage.getItem("prjtId")});
    getProvince();
});
function initEvent() {
    $(".add-true").click(function () {
       var acctId=$(".crdFdAcctContainer").attr("acctId");
        var acctInfo=Tools.autoNodeValEncaseJson("crdFdAcct");
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/"+acctId?"editCrowdFundingAcct":"newCrowdFundingAcct",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify(acctInfo),
            //async: false,
            success: function (data){
                var messge=Tools.getMessageTipsByName("commonTips.modifyedSuccess");
                layer.msg(messge);
                if($(".crdFdAcctContainer").attr("acctId"))
                {
                    getList4AcctByUserId();
                }

            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    });
    $(".submenu").on("click","span",function () {
        var acctId=$(this).parent().attr("acctId");
        $(".crdFdAcctContainer").attr("acctId",acctId);
        getAcctInfoByMap({id:acctId});
    });
    $("#provinceSelectContainer").change(function () {
       getCityByProvince($(this).children('option:selected').val());
    });
}
function getAcctInfoByMap(acctParam) {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getCrowdFundingAcctInfo",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(acctParam),
        //async: false,
        success: function (data){



        },
        error: function (returndata) {
//            	layer.msg("网络异常，请重试");
        }
    });
    
}
function getList4AcctByUserId() {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getList4AcctByMap",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(""),
        //async: false,
        success: function (data){
            Tools.renderTemplate("crdFdAcctList","crdFdAcctListContainer",data);
        },
        error: function (returndata) {
//            	layer.msg("网络异常，请重试");
        }
    });


}
/*function newCrdFdAcct() {
    
}
function editCrdFdAcct() {

}*/
function getProvince() {
    $.ajax({
        url:  serverUrl + "common/dic/getList4DicByMap",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({type:"SEAT",label:"PROVINCE"}),
        //async: false,
        success: function (data){
            Tools.renderTemplate("provinceSelect","provinceSelectContainer",data);
        },
        error: function (returndata) {
//            	layer.msg("网络异常，请重试");
        }
    });
}
function getCityByProvince(provinceId) {
    $.ajax({
        url:  serverUrl + "common/dic/getList4DicByMap",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({type:"SEAT",label:"CITY",parentId:provinceId}),
        //async: false,
        success: function (data){
            Tools.renderTemplate("citySelect","citySelectContainer",data);
        },
        error: function (returndata) {
//            	layer.msg("网络异常，请重试");
        }
    });
}
function getBankList() {
    $.ajax({
        url:  serverUrl + "common/dic/getList4DicByMap",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({type:"ACCT",label:"BANKNAME"}),
        //async: false,
        success: function (data){
            Tools.renderTemplate("bankList","bankListContainer",data);
        },
        error: function (returndata) {
//            	layer.msg("网络异常，请重试");
        }
    });
}

