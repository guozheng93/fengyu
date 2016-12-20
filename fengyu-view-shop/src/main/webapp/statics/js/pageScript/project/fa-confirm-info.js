$(function () {
    var prjtId=Tools.getQueryString("prjtId");
    if(prjtId)
    {
        sessionStorage.setItem("prjtId",prjtId);
        initEvent();
        getBankList();
        getList4AcctByUserId();
        getProvince();
        getAcctInfoByMap({prjtId:sessionStorage.getItem("prjtId")});
    }


});
function initEvent() {
    var validateForm=$("#validateForm").validate({
        rules: {
            acctName: {
                required: true
            },
            bankId: {
                required: true
            },
            acctOpenBank: {
                required: true
            },
            openBankProvince: {
                required: true
            },
            openBankCity: {
                required: true
            },
            acctNo: {
                required: true
            }
        },
        messages: {
            acctName: {
                required: Tools.getValidMsgByName("crowd.acct.acctName_notset")
            },
            bankId: {
                required: Tools.getValidMsgByName("crowd.acct.bankId_notset")
            },
            acctOpenBank: {
                required: Tools.getValidMsgByName("crowd.acct.acctOpenBank_notset")
            },
            openBankProvince: {
                required: Tools.getValidMsgByName("crowd.acct.openBankProvince_notset")
            },
            openBankCity: {
                required: Tools.getValidMsgByName("crowd.acct.openBankCity_notset")
            },
            acctNo: {
                required: Tools.getValidMsgByName("crowd.acct.acctNo_notset")
            }

        }
    });
    $(".add-true").click(function () {
        $(".add-true").attr("status","onclick");
        var flag=validateForm.form();
        if(flag)
        {
            saveAcct();
        }

    });
    $(".save").click(function () {

        var flag=validateForm.form();
        if(flag)
        {
            saveAcct();
        }

    });
    $(".next-stup").click(function () {
        $(".next-stup").attr("status","onclick");
        var flag=validateForm.form();
        if(flag)
        {
            saveAcct();
        }

    });
    $(".new-acct").click(function () {
        resetForm();
    });
    $(".submenu").on("click","li",function () {
        var acctId=$(this).attr("acctId");
        $("#crdFdAcctContainer").attr("acctId",acctId);
        getAcctInfoByMap({id:acctId});
    });
    $("#provinceSelectContainer").change(function () {
       getCityByProvince($(this).children('option:selected').val());
    });
}
function saveAcct() {
    var acctId=$("#crdFdAcctContainer").attr("acctId");
    var acctInfo=Tools.autoNodeValEncaseJson("crdFdAcct");
    var url=acctId?"editCrowdFundingAcct":"newCrowdFundingAcct";
    acctInfo.prjtId=sessionStorage.getItem("prjtId");
    acctInfo.id=acctId;
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/"+url,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(acctInfo),
        //async: false,
        success: function (data){
            if($(".next-stup").attr("status")=="onclick")
            {
                $(".next-stup").attr("status","");
                window.location.href = "/view/project/complete.jsp?prjtId="+sessionStorage.getItem("prjtId");
            }else if($(".add-true").attr("status")=="onclick")
            {
                $(".add-true").attr("status","");
                var messge=Tools.getMessageTipsByName("commonTips.modifyedSuccess");
                layer.msg(messge);
                $(".crdFdAcctContainer").attr("acctId",data.responseBody.recordList[0].id);
                getList4AcctByUserId();
            }else {
                openSuccessWindow();
            }

        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("commonTips.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function resetForm() {
    $("#validateForm")[0].reset();
    $("#citySelectContainer").children().remove();
    $("#citySelectContainer").append('<option selected="selected">请选择市...</option>');
    $("#crdFdAcctContainer").attr("acctId","");
}
function getAcctInfoByMap(acctParam) {
    if(sessionStorage.getItem("prjtId"))
    {
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/getCrowdFundingAcctInfo",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify(acctParam),
            //async: false,
            success: function (data){
                if(data.responseBody&&data.responseBody.recordList)
                {
                    getCityByProvince(data.responseBody.recordList[0].openBankProvince);
                    Tools.autoInjectValue(data.responseBody.recordList[0]);
                    $("#crdFdAcctContainer").attr("acctId",data.responseBody.recordList[0].id);
                    //dynamicAppendItemPropNode(data.responseBody.recordList[0]["propValues"]);
                }
            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }

    
}
function getList4AcctByUserId() {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getList4AcctByMap",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({}),
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
function openSuccessWindow() {
    layer.open({
        shadeClose:true,
        closeBtn:1,
        area:'600px',
        title:'',
        content:'<p class="save-tip">您的信息已更新保存成功</p>'+'<p class="save-tip">点击“下一步”将默认保存填写信息</p>'+'<p class="save-tip">您可到<a href="javascript:;">“个人中心”</a>——<a href="javascript:;">“我发起的项目”</a>，查看与编辑保存的信息</p>',
        btn:['我知道了']
    })

}
