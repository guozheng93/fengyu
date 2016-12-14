$(function(){
    initEvent();
    getCrdfdRepayList();
});
function getItemPropFromNode(repayId,prjtId) {
    var itemPropNodes=$(".hb-attr-box");
    var itemPropsArray=new Array();
    for(var i=0;i<itemPropNodes.length;i++)
    {
        var itemPropsJson={repayId:repayId,prjtId:prjtId};
        itemPropsJson["propName"]=$(itemPropNodes[i]).find(".propName").text();
        var itemPropValuesArray=new Array();
        var itemPropValuesNodes=$(itemPropNodes[i]).find(".propValueName");
        for(var j=0;j<itemPropValuesNodes.length;j++)
        {
            var itemPropValuesJson={propValueName:$(itemPropValuesNodes[j]).text()};
            itemPropValuesArray.push(itemPropValuesJson);
        }

        itemPropsJson["propValues"]=itemPropValuesArray;
        itemPropsArray.push(itemPropsJson);
    }
    return itemPropsArray;
}
function clearPropNodes() {
    $(".hb-attr").find("span").remove();
    $(".hb-attr-box").remove();
}
function dynamicAppendItemPropNode(itemProps) {
    clearPropNodes();
    for(var i=0;i<itemProps.length;i++)
    {
        var currentItemPropNode=addItemPropNode(itemProps[i]["propName"]);
        for(var j=0;j<itemProps[i]["propValues"].length;j++)
        {
            addItemPropValuesNode(itemProps[i]["propValues"][j]["propValueName"],currentItemPropNode);
        }
    }
}
function getCrdfdRepayList()
{
    if(sessionStorage.getItem("prjtId"))
    {
        $.ajax({
            url:  serverUrl + "crowdFundingRepay/getList4CrowdFundingRepay",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({prjtId:sessionStorage.getItem("prjtId")}),
            //async: false,
            success: function (data){
                console.log(data);
                if(data.responseBody&&data.responseBody.recordList[0])
                {
                    Tools.renderTemplate("crdfdRepayList","crdfdRepayListContainer",data)
                }
            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }

}

function getList4CrowdfundingItemProps(repayId)
{
    if(sessionStorage.getItem("prjtId"))
    {
        $.ajax({
            url:  serverUrl + "crowdFundingRepay/getList4CrowdfundingItemProps",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({repayId:repayId}),
            //async: false,
            success: function (data){
                console.log(data);
                if(data.responseBody&&data.responseBody.recordList[0])
                {
                    data=data.responseBody.recordList;
                    clearPropNodes();
                    for(var i=0;i<data.length;i++)
                    {
                        var propValues=getList4CrowdfundingItemPropValueByItmPropId(data[i].id);
                        var currentItemPropNode=addItemPropNode(data[i]["propName"]);
                        for(var j=0;j<propValues.length;j++)
                        {
                            addItemPropValuesNode(propValues[j]["propValueName"],currentItemPropNode);
                        }

                    }
                }
            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }

}
function getList4CrowdfundingItemPropValueByItmPropId(propId)
{
    var propValues;
    if(sessionStorage.getItem("prjtId"))
    {
        $.ajax({
            url:  serverUrl + "crowdFundingRepay/getList4CrowdfundingItemPropValueByItmPropId",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({propId:propId}),
            async: false,
            success: function (data){
                console.log(data);
                if(data.responseBody&&data.responseBody.recordList[0])
                {
                    propValues=data.responseBody.recordList;
                }
            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }
    return propValues;
}

function getCrdfdRepayInfoByRepayId(repayId)
{
    if(sessionStorage.getItem("prjtId"))
    {
        $.ajax({
            url:  serverUrl + "crowdFundingRepay/getCrowdFundingRepayInfo",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({id:repayId}),
            //async: false,
            success: function (data){
                console.log(data);
                if(data.responseBody&&data.responseBody.recordList)
                {
                    Tools.autoInjectValue(data.responseBody.recordList[0]);
                    //dynamicAppendItemPropNode(data.responseBody.recordList[0]["propValues"]);
                }
            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }

}
//批量更新propItem 回报属性
function editCrdfdPropItemBatch(repayId,prjtId) {
    var propJson=getItemPropFromNode(repayId,prjtId);
    $.ajax({
        url:  serverUrl + "crowdFundingRepay/newCrowdfundingItemPropsBatch",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(propJson),
        //async: false,
        success: function (data){
        },
        error: function (returndata) {
//            	layer.msg("网络异常，请重试");
        }
    });
}
function initEvent(){
    doCrdfdItemProps();
    doCrdfdItemPropsValue();
    //初始化图片控件
    Tools.webImageUploader("repayImageThumbnailPicker","repayImageThumbnailThumbnail");
    Tools.webImageUploader("repayImagePicker","repayImageThumbnail");

    $("#crdfdRepayListContainer").on("click",".hb-edit",function () {
        var repayId=$(this).parent().attr("repayId");
        sessionStorage.setItem("repayId",repayId);
        getCrdfdRepayInfoByRepayId(repayId);
        getList4CrowdfundingItemProps(repayId);

    });
    $("#crdfdRepayListContainer").on("click",".hb-del",function () {
        var repayId=$(this).parent().attr("repayId");
        $.ajax({
            url:  serverUrl + "crowdFundingRepay/deleteCrowdFundingRepay",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({id:repayId}),
            //async: false,
            success: function (data){
                var messge=Tools.getMessageTipsByName("commonTips.deleteSuccess");
                layer.msg("删除成功");
                getCrdfdRepayList();
            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    });
    $(".next-stup").click(function () {
        window.location.href="/view/project/fa-confirm-info.jsp";
    });
    $(".save").click(function ()
    {
        modifyCrdFdRepay();
    });
    $(".add-true").click(function ()
    {
        modifyCrdFdRepay();
    });
}
function modifyCrdFdRepay() {
    var crdfdRepayVo=Tools.autoNodeValEncaseJson("crdfdRepay");
    crdfdRepayVo["prjtId"]=sessionStorage.getItem("prjtId");

    if(sessionStorage.getItem("repayId"))
    {
        crdfdRepayVo["id"]=sessionStorage.getItem("repayId");
        editCrdfdPropItemBatch(sessionStorage.getItem("repayId"),sessionStorage.getItem("prjtId"));
        $.ajax({
            url:  serverUrl + "crowdFundingRepay/editCrowdFundingRepay",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify(crdfdRepayVo),
            //async: false,
            success: function (data){
                var message=Tools.getMessageTipsByName("commonTips.modifyedSuccess");
                layer.msg(message);
            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }else
    {
        $.ajax({
            url:  serverUrl + "crowdFundingRepay/newCrowdFundingRepay",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify(crdfdRepayVo),
            //async: false,
            success: function (data){
                if(data.responseBody&&data.responseBody.recordList[0])
                {
                    sessionStorage.setItem("repayId",data.responseBody.recordList[0].id)
                    getCrdfdRepayList();
                    editCrdfdPropItemBatch(data.responseBody.recordList[0].id,sessionStorage.getItem("prjtId"));
                }
            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }
}

function doCrdfdItemProps() {
    //添加回报属性
    $(".hb-attr a").click(function(){
        var attrName=$(".hb-attr span").length;
        if(attrName>9){
            layer.msg("对不起，最多只能添加10个回报属性");
            $(".add-input").val("");
            return false;
        }else{
            var adi=$(".add-input").val();
            if(adi!=""){
                addItemPropNode(adi);
            }else{
                layer.msg("请先输入");
            }
        }

    });
    //删除属性
    $(".hb-list").on("click",".hb-closeBtn",function () {
        var index=$(".hb-attr-box").length-1-$(".hb-attr-box").index($(this).parents(".hb-attr-box"));
        $(this).parents(".hb-attr-box").remove();
        $(".hb-attr").find("span").eq(index).remove();
    });
}
function addItemPropNode(itemPropName) {
    //var aa=$(".hb-attr span").last().after("<span style='background-image:none '>"+adi+"</span>");
    //select_return();
    $(".add-input").val("");
    var itemPropValsBox=
        '<div class="hb-attr-box">'+
            '<img src="/statics/images/colse_icon.png" class="hb-closeBtn">'+
            '<b class="propName">'+itemPropName+'</b><i style="font-style: normal;margin-right: 10px;">:</i>'+
            '<input type="text" class="add-attrVal" placeholder="请输入"><a href="javascript:;" class="add-icon">+</a>'+
        '</div>';
    $(itemPropValsBox).insertAfter(".hb-attr");
    $("<span>"+itemPropName+"</span>").insertBefore(".hb-attr input");
    return $(".hb-attr").next(".hb-attr-box");
}

function doCrdfdItemPropsValue() {
    //属性值
    $(".hb-list").on("click",".add-icon",function () {
        var $attr_num=$(this).parents(".hb-attr-box").find("span").length;
        if($attr_num>5){
            layer.msg("对不起，最后添加5个");
            $(".add-attrVal").val("");
            return false;
        }else{
            var attrval_input=$(this).parents(".hb-attr-box").find(".add-attrVal").val();
            if(attrval_input==null ||attrval_input==""){
                layer.msg("请先输入");
            }else{
                addItemPropValuesNode(attrval_input,$(this).parents(".hb-attr-box"));
            }
        }
    });
    $(".hb-list").on("click",".attrval-del",function () {
        $(this).parent().remove();
    });

}
function addItemPropValuesNode(itemPropValue,itemPropNode) {
    $("<span class='propValueName'>"+itemPropValue+"<img src='/statics/images/colse_icon.png' class='attrval-del'>"+"</span>").insertBefore($(itemPropNode).find(".add-attrVal"));
    $(this).parents(".hb-attr-box").find(".attrval-del").click(function(){
        $(this).parents("span").remove();
    });
    $(".add-attrVal").val("");
}

/*选择回报属性的方法*/
function select_return(){
    $(".hb-attr span").unbind().click(function(){
        var $click_span = $(this);
        if($click_span.css("background-image")=='none') {
            $click_span.css("background-image","url(/statics/images/hb_duihao.png)");
            $click_span.css("border","1px solid #ffdd00");
        }else{
            $click_span.css("background-image",'none');
            $click_span.css("border","1px solid #cccccc");
        }
        var d = 0;
        $.each($(".hb-attr span") , function( i , e){
            if($(e).css("background-image").indexOf("hb_duihao.png")>0){
                ++d;
            }
            if(d>3){
                $click_span.css("background-image" , "none");
                $click_span.css("border","1px solid #cccccc");
            }

        });
    })
}