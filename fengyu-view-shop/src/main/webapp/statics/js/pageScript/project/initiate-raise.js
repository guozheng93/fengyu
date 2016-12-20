//done ,ready,fail
var createEntityPrjtOperateNode={
};

$(function(){
    var prjtId=Tools.getQueryString("prjtId");
    if(prjtId)
    {
        sessionStorage.setItem("prjtId",prjtId);
        var ue = UE.getEditor("editor");

        if(Tools.getQueryString("prjtId"))
        {
            sessionStorage.setItem("prjtId",Tools.getQueryString("prjtId"));
        }
        //初始化node监听事件
        initEvent();
        //获取项目类型种类
        getCrdFdItemList();

        //初始化图片控件
        Tools.webImageUploader("crdfdListImagePicker","crdfdListImageThumbnail");
        Tools.webImageUploader("crdfdCoverImagePicker","crdfdCoverImageThumbnail");

        if(sessionStorage.getItem("prjtId"))
        {
            getCrowdFundingEntityInfo();
            getCrowdFundingDetail();
            getCrowdFundingOrganiserInfo();
        }
    }


});
//获取项目类型
function getCrdFdItemList() {
    $.ajax({
        url:  serverUrl + "crowdFundingItem/getList4CrdFdBottomItem",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        //data: JSON.stringify(paramJson),
        //async: false,
        success: function (data){
            console.log(data.responseBody);
            Tools.renderTemplate("crdfdEntityItem","crdfdEntityItemContainer",data);
            /*var html =template("crdfdEntityItem",data);
            $("#crdfdEntityItemContainer").html(html);*/
        },
        error: function (returndata) {
//            	layer.msg("网络异常，请重试");
        }
    });
}

function initEvent() {
    //初始化验证对象
    var crowdfundingInfoForm=$("#crowdfundingInfoForm").validate({
        rules: {
            crdfdEntityItem: {
                userdefined:"checkCrdFdItemValue()"
            },
            prjtName:{
                required:true,
                maxlength:20
            },
            prjtSummary:{
                maxlength:200
            },
            prjtRaiseAmount: {
                required: true
                ,min: 100
                /*,equalTo: "#password"*/
            },
            prjtRaiseToplimit:{
                userdefined:"checkPrjtRaiseToplimitValue()"
            },
            prjtFundCycle:{
                required:true,
                min:10,
                max:60
            },
            entityCatalogImage:{
                userdefined:"checkImgVal()"
            },
            entityCoverImage:{
                userdefined:"checkImgVal()"
            },
            crdFdDetail:{
                userdefined:"checkUeVal()"
            },
            orgnrResume:{
                required:true,
                maxlength:160
            },
            orgnrTelephone:{
                required:true,
                number:true,
            }

        },
        messages: {
            crdfdEntityItem:{userdefined:Tools.getValidMsgByName("crowd.entity.crdfditem-notset")},
            prjtName:{
                required:Tools.getValidMsgByName("crowd.entity.prjtName-notset"),
                maxlength:Tools.getValidMsgByName("crowd.entity.prjtName-maxlength")
            },
            prjtSummary:{
                /*required:Tools.getValidMsgByName("crowd.entity.prjtSummary-notset"),*/
                maxlength:Tools.getValidMsgByName("crowd.entity.prjtSummary-maxlength")
            },
            prjtRaiseAmount: {
                required: Tools.getValidMsgByName("crowd.entity.prjtRaiseAmount-notset")
                ,min: Tools.getValidMsgByName("crowd.entity.prjtRaiseAmount-min")
                /* ,equalTo: "两次密码输入不一致"*/
            },
            prjtRaiseToplimit:{
                userdefined:Tools.getValidMsgByName("crowd.entity.prjtRaiseToplimit-notset")
            },
            prjtFundCycle:{
                required:Tools.getValidMsgByName("crowd.entity.prjtFundCycle-notset"),
                min:Tools.getValidMsgByName("crowd.entity.prjtFundCycle-min"),
                max:Tools.getValidMsgByName("crowd.entity.prjtFundCycle-max")
            },
            entityCatalogImage:{
                userdefined:Tools.getValidMsgByName("crowd.entity.entityCatalogImage-notset")
            },
            entityCoverImage:{
                userdefined:Tools.getValidMsgByName("crowd.entity.entityCoverImage-notset")
            },
            crdFdDetail:{
                userdefined:Tools.getValidMsgByName("crowd.entity.crdFdDetail-notset")
            },
            orgnrResume:{
                required:Tools.getValidMsgByName("crowd.entity.orgnrResume-notset"),
                maxlength:Tools.getValidMsgByName("crowd.entity.orgnrResume-maxlength")
            },
            orgnrTelephone:{
                required:Tools.getValidMsgByName("crowd.entity.orgnrTelephone-notset"),
                number:Tools.getValidMsgByName("crowd.entity.orgnrTelephone-number")
            }

        }/*,
         submitHandler:function(form){
         saveCrowdFunding();
         }*/
    });
    //初始化验证异常缓存信息，用于处理缓存异常
    sessionStorage.setItem("validateErrors","");

    //初始化操作进程，用以判断是否完成维护操作
    createEntityPrjtOperateNode={
        crdfdEntity:"ready",
        crdfdDetail:"ready",
        crdfdOrganiser:"ready"
    };
    sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
    //初始化项目类型点击事件
    itemClickEvent();

    //保存草稿点击
    $(".save").click(function () {

        //启动验证
        var flag=crowdfundingInfoForm.form();
        //判断是否验证成功，成功则进行业务动作
        if(flag)
        {
            //设置保存草稿按钮被点击
            $(this).attr("status","onclick");
            saveCrowdFunding();
        }
    });

    //下一步按钮
    $(".next-stup").click(function () {
        //启动验证
        var flag=crowdfundingInfoForm.form();
        //判断是否验证成功，成功则进行业务动作
        if(flag)
        {
            saveCrowdFunding();
        }
    });

}
function checkUeVal(value,element)
{
    var ueValue=UE.getEditor('editor').getContent();
    return ueValue.length>0;
}
function checkImgVal(value,element)
{
    var imgNodeName=$(element).attr("name");
    element=$("img[name='"+imgNodeName+"']");
    var imgSrc= $(element).attr("src");
    return imgSrc.indexOf("/statics/images/default_tu.png")==-1;
}
function checkCrdFdItemValue() {
    var checkItemList=$("#crdfdEntityItemContainer").children(".active-span");
    if(checkItemList.length<1)
        return false;
    else
        return true;
}
function checkPrjtRaiseToplimitValue(value) {
    if(value!="0")
    {
        return value>=100;
    }else if(value==0)
        return true;
}

function itemClickEvent() {
    $("#crdfdEntityItemContainer").on("click","span",function () {
        $(this).addClass("active-span").siblings().removeClass("active-span");
    });
}


function getCrowdFundingEntityInfo()
{
    if(sessionStorage.getItem("prjtId"))
    {
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/getCrowdFundingEntityInfo",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({id:sessionStorage.getItem("prjtId")}),
            //async: false,
            success: function (data){
                console.log(data.responseBody);
                if(data.responseBody&&data.responseBody.recordList[0])
                {
                    data=data.responseBody.recordList[0];
                    Tools.autoInjectValue(data);
                    $("#crdfdEntityItemContainer").find("span[itemid='"+data.prjtItemId+"']").addClass("active-span");

                }

            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }

}
function    getCrowdFundingDetail() {
    if(sessionStorage.getItem("prjtId"))
    {
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/getCrowdFundingDetail",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({id:sessionStorage.getItem("prjtId")}),
            //async: false,
            success: function (data){
                console.log(data.responseBody);
                if(data.responseBody&&data.responseBody.recordList[0])
                {
                    var prjtDetail=data.responseBody.recordList[0].prjtDetail;
                    UE.getEditor('editor').ready(function() {
                        UE.getEditor('editor').setContent(prjtDetail);
                    });
                }

            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }
}
function getCrowdFundingOrganiserInfo() {
    if(sessionStorage.getItem("prjtOrganiserId"))
    {
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/getCrowdFundingOrganiserInfo",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({id:sessionStorage.getItem("prjtOrganiserId")}),
            //async: false,
            success: function (data){
                console.log(data.responseBody);
                if(data.responseBody&&data.responseBody.recordList[0])
                {
                    Tools.autoInjectValue(data.responseBody.recordList[0]);
                }

            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }
}

function saveCrowdFunding() {
    /*var serverInterfaceUrl=prjtId?"crowdfundingEntity/edi",""*/
    //判断prjtId 是否存在，若不存在则是新增动作，插入
    if(!sessionStorage.getItem("prjtId"))
    {
        //首先插入发起人信息表
        newCrowdFundingOrganiser();
    }else {
        editCrowdFundingInfo();
    }
}

function editCrowdFundingInfo() {
    if(sessionStorage.getItem("prjtId"))
    {
        var crdfdEntity=Tools.autoNodeValEncaseJson("crdfdEntity");
        crdfdEntity["prjtItemId"]=$("#crdfdEntityItemContainer").find(".active-span").attr("itemid");
        crdfdEntity["id"]=sessionStorage.getItem("prjtId");
        //更新项目基本信息
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/editCrowdFundingEntity",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify(crdfdEntity),
            //async: false,
            success: function (data){

                var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
                createEntityPrjtOperateNode.crdfdEntity="done";
                sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
                checkComplete();
                /*console.log(data.responseBody);
                if(data.responseBody&&data.responseBody.recordList[0])
                {
                    Tools.autoInjectValue(data.responseBody.recordList[0]);
                }*/

            },
            error: function (returndata) {
                layer.msg(Tools.getMessageTipsByName("crowd.entityError"));
                var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
                createEntityPrjtOperateNode.crdfdEntity="error";
                sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
                checkComplete();
            }
        });

        editCrowdFundingDetail();
        editCrowdFundingOrganiser();
    }
}
function editCrowdFundingDetail() {
    console.log(UE.getEditor('editor').getContent());
    //更新项目详情
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/editCrowdFundingDetail",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({id:sessionStorage.getItem("prjtId"),prjtDetail:UE.getEditor('editor').getContent()}),
        //async: false,
        success: function (data){
            var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
            createEntityPrjtOperateNode.crdfdDetail="done";
            sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
            checkComplete();
        },
        error: function (returndata) {
            layer.msg(Tools.getMessageTipsByName("crowd.entityDetailError"));
            var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
            createEntityPrjtOperateNode.crdfdDetail="error";
            sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
        }
    });
    
}
function newCrowdFundingOrganiser() {
    var crowdFundingOrganiser=Tools.autoNodeValEncaseJson("crdfdOrganiser");
    //更新项目发起人信息
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/newCrowdFundingOrganiser",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(crowdFundingOrganiser),
        //async: false,
        success: function (data){
            //设置发起人节点操作结束
            var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
            createEntityPrjtOperateNode.crdfdOrganiser="done";
            sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));

            //checkComplete();
            //console.log(data.responseBody);
            if(data.responseBody&&data.responseBody.recordList[0])
            {
                organiserId=data.responseBody.recordList[0].id;
                sessionStorage.setItem("prjtOrganiserId",organiserId);
                var crdfdEntity=Tools.autoNodeValEncaseJson("crdfdEntity");
                crdfdEntity["prjtItemId"]=$("#crdfdEntityItemContainer").find(".active-span").attr("itemid");
                crdfdEntity["prjtOrganiserId"]=organiserId;

                $.ajax({
                    url:  serverUrl + "crowdFundingEntity/newCrowdFundingEntity",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    type: "post",
                    data: JSON.stringify(crdfdEntity),
                    //async: false,
                    success: function (data){
                        var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
                        createEntityPrjtOperateNode.crdfdEntity="done";
                        sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
                        checkComplete();
                        console.log(data.responseBody);
                        if(data.responseBody&&data.responseBody.recordList[0])
                        {
                            var id=data.responseBody.recordList[0].id;
                            sessionStorage.setItem("prjtId",id);
                        }
                        editCrowdFundingDetail();
                        

                    },
                    error: function (returndata) {
                        layer.msg(Tools.getMessageTipsByName("crowd.entityError"));
                        var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
                        createEntityPrjtOperateNode.crdfdEntity="error";
                        sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
                    }
                });
            }

        },
        error: function (returndata) {
            layer.msg(Tools.getMessageTipsByName("crowd.organiserError"));
            //设置发起人节点操作结束
            var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
            createEntityPrjtOperateNode.crdfdOrganiser="error";
            sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
        }
    });
}
function editCrowdFundingOrganiser() {
    var crowdFundingOrganiser=Tools.autoNodeValEncaseJson("crdfdOrganiser");
    crowdFundingOrganiser["id"]=sessionStorage.getItem("prjtOrganiserId");
    //更新项目发起人信息
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/editCrowdFundingOrganiser",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(crowdFundingOrganiser),
        //async: false,
        success: function (data){
            var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
            createEntityPrjtOperateNode.crdfdOrganiser="done";
            sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
            checkComplete();
        },
        error: function (returndata) {
            layer.msg(Tools.getMessageTipsByName("crowd.organiserError"));
            var createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
            createEntityPrjtOperateNode.crdfdOrganiser="error";
            sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
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
function  checkComplete() {
    createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
    var flag=true;
    for (var step in createEntityPrjtOperateNode)
    {
        if(createEntityPrjtOperateNode[step]!="done")
        {
            flag=false;
            break;
        }
    }
    if(flag)
    {
        var createEntityPrjtOperateNode={
            crdfdEntity:"ready",
            crdfdDetail:"ready",
            crdfdOrganiser:"ready"
        };
        sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
        if($(".save").attr("status")=="onclick")
        {
            openSuccessWindow();
            $(".save").attr("status","");
        }else
        {
            window.location.href="/view/project/returns-set.jsp?prjtId="+sessionStorage.getItem("prjtId");
        }
    }
    return flag;
}