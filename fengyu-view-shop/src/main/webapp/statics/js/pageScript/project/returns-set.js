$(function(){
    var prjtId=Tools.getQueryString("prjtId");
    if(prjtId)
    {
        sessionStorage.setItem("prjtId",prjtId);
        initEvent();
        getCrdfdRepayList();
    }

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
                Tools.renderTemplate("crdfdRepayList","crdfdRepayListContainer",data);

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
            var createRepayPrjtOperateNode=JSON.parse(sessionStorage.getItem("createRepayPrjtOperateNode"));
            createRepayPrjtOperateNode.crdfdRepayItemProps="done";
            sessionStorage.setItem("createRepayPrjtOperateNode",JSON.stringify(createRepayPrjtOperateNode));
            checkComplete();
        },
        error: function (returndata) {
            var createRepayPrjtOperateNode=JSON.parse(sessionStorage.getItem("createRepayPrjtOperateNode"));
            createRepayPrjtOperateNode.crdfdRepayItemProps="error";
            sessionStorage.setItem("createRepayPrjtOperateNode",JSON.stringify(createRepayPrjtOperateNode));
            var message=Tools.getMessageTipsByName("repay.repayItemPropsError");
            layer.msg(message);
        }
    });
}
function initEvent(){
    //初始化操作进程，用以判断是否完成维护操作
    var createRepayPrjtOperateNode={
        crdfdRepayItemProps:"ready",
        crdfdRepayInfo:"ready"
    };
    sessionStorage.setItem("createRepayPrjtOperateNode",JSON.stringify(createRepayPrjtOperateNode));
    var validateForm=$("#validateForm").validate({
        rules: {
            repayType: {
                required:true
            },
            repayPrice:{
                required:true,
                number:true,
                min:100
            },
            repayDetail:{
                required: true,
                maxlength:200
            },
            repayImageThumbnail: {
                userdefined:"checkImgVal()"
            },
            repayImage: {
                userdefined:"checkImgVal()"
            },
            itemProp:{
                userdefined:"checkItemPropValue()"
            },
            repayNeedRemark :{
                required:true
            },
            repayRemark :{
                userdefined:"checkRepayRemarkVal()"
            },
            repayLimitAmount:{
                required:true,
                number:true
            },
            repayExpressFee:{
                required:true,
                number:true
            },
            repayInvoiceFlag:{
                required:true
            },
            repayInvoiceRemark:{
                userdefined:"checkRepayInvoiceRemarkVal()"
            },
            repayTime:{
                required:true,
                number:true
            }

        },
        messages: {
            repayType: {
                required:Tools.getValidMsgByName("crowd.repay.repayType_notset")
            },
            repayPrice:{
                required:Tools.getValidMsgByName("crowd.repay.repayPrice_notset"),
                number:Tools.getValidMsgByName("crowd.repay.repayPrice_number"),
                min:Tools.getValidMsgByName("crowd.repay.repayPrice_min")
            },
            repayDetail:{
                required: Tools.getValidMsgByName("crowd.repay.repayDetail_notset"),
                maxlength:Tools.getValidMsgByName("crowd.repay.repayDetail_maxlength")
            },
            repayImageThumbnail: {
                userdefined:Tools.getValidMsgByName("crowd.repay.repayImageThumbnail_notset")
            },
            repayImage: {
                userdefined:Tools.getValidMsgByName("crowd.repay.repayImage_notset")
            },
            itemProp:{
                userdefined:Tools.getValidMsgByName("crowd.repay.itemProp_notset")
            },
            repayNeedRemark :{
                required:Tools.getValidMsgByName("crowd.repay.repayNeedRemark_notset")
            },
            repayRemark :{
                userdefined:Tools.getValidMsgByName("crowd.repay.repayRemark_notset")
            },
            repayLimitAmount:{
                required:Tools.getValidMsgByName("crowd.repay.repayLimitAmount_notset"),
                number:Tools.getValidMsgByName("crowd.repay.repayLimitAmount_number")
            },
            repayExpressFee:{
                required:Tools.getValidMsgByName("crowd.repay.repayExpressFee_notset"),
                number:Tools.getValidMsgByName("crowd.repay.repayExpressFee_number")
            },
            repayInvoiceFlag:{
                required:Tools.getValidMsgByName("crowd.repay.repayInvoiceFlag_notset")
            },
            repayInvoiceRemark:{
                userdefined:Tools.getValidMsgByName("crowd.repay.repayInvoiceRemark_notset")
            },
            repayTime:{
                required:Tools.getValidMsgByName("crowd.repay.repayTime_notset"),
                number:Tools.getValidMsgByName("crowd.repay.repayTime_number")
            }

        }/*,
         submitHandler:function(form){
         saveCrowdFunding();
         }*/
    });
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
        layer.open({
            title:'温馨提示',
            content:'确定要删除吗？',
            btn:['确定','取消'],
            yes:function(){
                /*$(e).remove();
                $(".layui-layer-shade,.layer-anim").hide();*/
                if(repayId)
                {
                    $.ajax({
                        url:  serverUrl + "crowdFundingRepay/deleteCrowdFundingRepay",
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        type: "post",
                        data: JSON.stringify({id:repayId}),
                        //async: false,
                        success: function (data){
                            var messge=Tools.getMessageTipsByName("commonTips.deleteSuccess");
                            layer.msg(messge);
                            getCrdfdRepayList();
                        },
                        error: function (returndata) {
                            var messge=Tools.getMessageTipsByName("commonTips.deleteFailed");
                            layer.msg(messge);
                        }
                    });
                }else
                {
                    layer.msg("数据异常");
                }

            }
        })

    });
    $(".next-stup").click(function () {
        if($("#crdfdRepayListContainer").children("tr").length==0)
        {
            layer.msg("请进行回报设置  ");
        }
        var index=layer.open({
                title: '温馨提示',
                content: '是否保存此次填写的内容？',
                btn: ['确定', '取消'],
                yes: function () {
                    layer.close(index);
                    var flag = validateForm.form();
                    if (flag) {
                        modifyCrdFdRepay();
                    }
                },
                btn2: function () {
                    window.location.href = "/view/project/fa-confirm-info.jsp?prjtId="+sessionStorage.getItem("prjtId");
                }
            });


    });
    $(".save").click(function ()
    {
        var index=layer.open({
            title: '温馨提示',
            content: '是否保存此次填写的内容？',
            btn: ['确定', '取消'],
            yes: function () {
                layer.close(index);
                var flag=validateForm.form();
                if(flag)
                {
                    $(this).attr("status","onclick");
                    modifyCrdFdRepay();
                }
            },
            btn2: function () {
                openSuccessWindow();
            }
        });

    });
    $(".add-true").click(function ()
    {
        var flag=validateForm.form();
        if(flag)
        {
            $(this).attr("status","onclick");
            modifyCrdFdRepay();
        }
    });
    $(".add-false").click(function(){
        var index=layer.open({
            title:'温馨提示',
            area:'300px',
            content:'取消后，将清空此档位所填写的信息，确认取消么？',
            btn:['确认取消','暂不取消'],
            yes:function () {
                resetRepayElement();

                layer.close(index);
            }
        })
    })
}
function resetRepayElement() {
    $("#validateForm")[0].reset();
    removeItemProps();
    Tools.resetImgVal();
    sessionStorage.setItem("repayId","");
}

function checkRepayInvoiceRemarkVal()
{
    var value=$("input[name=repayInvoiceFlag]:checked").val();
    if(value=="1")
    {
        return  $("input[name=repayInvoiceRemark]").val().length>1;
    }else
        return true;
}
function checkRepayRemarkVal() {
    var value=$("input[name=repayNeedRemark]:checked").val();
    if(value=="1")
    {
        return $("input[name=repayRemark]").val();
    }else
        return true;
}
function checkImgVal(value,element)
{
    var imgNodeName=$(element).attr("name");
    element=$("img[name='"+imgNodeName+"']");
    var imgSrc= $(element).attr("src");
    return imgSrc.indexOf("/statics/images/default_tu.png")==-1;
}
function checkItemPropValue() {
    if($(".hb-attr-box").length>0)
    {
        return $(".hb-attr-box").find("span").length>0;
    }else {
        return false;
    }
}
function modifyCrdFdRepay() {
    if(sessionStorage.getItem("prjtId"))
    {
        var crdfdRepayVo=Tools.autoNodeValEncaseJson("crdfdRepay");
        crdfdRepayVo["prjtId"]=sessionStorage.getItem("prjtId");
        //更新操作
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
                    var createRepayPrjtOperateNode=JSON.parse(sessionStorage.getItem("createRepayPrjtOperateNode"));
                    createRepayPrjtOperateNode.crdfdRepayInfo="done";
                    sessionStorage.setItem("createRepayPrjtOperateNode",JSON.stringify(createRepayPrjtOperateNode));
                    checkComplete();
                    getCrdfdRepayList();

                },
                error: function (returndata) {
                    var createRepayPrjtOperateNode=JSON.parse(sessionStorage.getItem("createRepayPrjtOperateNode"));
                    createRepayPrjtOperateNode.crdfdRepayInfo="error";
                    sessionStorage.setItem("createRepayPrjtOperateNode",JSON.stringify(createRepayPrjtOperateNode));
                    var message=Tools.getMessageTipsByName("repay.repayInfoError");
                    layer.msg(message);
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
                        //sessionStorage.setItem("repayId",data.responseBody.recordList[0].id);
                        getCrdfdRepayList();
                        editCrdfdPropItemBatch(data.responseBody.recordList[0].id,sessionStorage.getItem("prjtId"));
                        var createRepayPrjtOperateNode=JSON.parse(sessionStorage.getItem("createRepayPrjtOperateNode"));
                        createRepayPrjtOperateNode.crdfdRepayInfo="done";
                        sessionStorage.setItem("createRepayPrjtOperateNode",JSON.stringify(createRepayPrjtOperateNode));
                        checkComplete();
                    }
                },
                error: function (returndata) {
                    var createRepayPrjtOperateNode=JSON.parse(sessionStorage.getItem("createRepayPrjtOperateNode"));
                    createRepayPrjtOperateNode.crdfdRepayInfo="error";
                    sessionStorage.setItem("createRepayPrjtOperateNode",JSON.stringify(createRepayPrjtOperateNode));
                    var message=Tools.getMessageTipsByName("repay.回报基本信息维护失败");
                    layer.msg(message);
                }
            });
        }
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
        removeItemProps(this);
    });
}
function removeItemProps(delNode) {
    if(delNode)
    {
        var index=$(".hb-attr-box").length-1-$(".hb-attr-box").index($(delNode).parents(".hb-attr-box"));
        $(delNode).parents(".hb-attr-box").remove();
        $(".hb-attr").find("span").eq(index).remove();
    }else
    {
        $(".hb-attr-box").remove();
        $(".hb-attr").find("span").remove();
    }

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
function  checkComplete() {
    createRepayPrjtOperateNode=JSON.parse(sessionStorage.getItem("createRepayPrjtOperateNode"));
    var flag=true;
    for (var step in createRepayPrjtOperateNode)
    {
        if(createRepayPrjtOperateNode[step]!="done")
        {
            flag=false;
            break;
        }
    }
    if(flag)
    {
        var createRepayPrjtOperateNode={
            crdfdRepayItemProps:"ready",
            crdfdRepayInfo:"ready"
        };
        sessionStorage.setItem("createRepayPrjtOperateNode",JSON.stringify(createRepayPrjtOperateNode));
        if($(".save").attr("status")=="onclick")
        {
            openSuccessWindow();
            $(".save").attr("status","");
        }else if($(".add-true").attr("status")=="onclick")
        {
            $(".add-true").attr("status","");
            var messge=Tools.getMessageTipsByName("commonTips.modifyedSuccess");
            layer.msg(messge);
            resetRepayElement();
        }
        else
        {
            window.location.href="/view/project/fa-confirm-info.jsp";
        }
    }
    return flag;
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