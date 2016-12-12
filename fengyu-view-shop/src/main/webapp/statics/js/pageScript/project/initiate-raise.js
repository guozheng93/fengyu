//done ,ready,fail
var createEntityPrjtOperateNode={

};
$(function(){

    var ue = UE.getEditor("editor");
    //初始化node监听事件
    initEvent();
    //获取项目类型种类
    getCrdFdItemList();

    //初始化图片控件
    Tools.webImageUploader("crdfdListImagePicker","crdfdListImageThumbnail");
    Tools.webImageUploader("crdfdCoverImagePicker","crdfdCoverImageThumbnail");

    if($("#prjtId").val())
    {
        getCrowdFundingEntityInfo();
        getCrowdFundingDetail();
        getCrowdFundingOrganiserInfo();
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
    createEntityPrjtOperateNode=sessionStorage.getItem("createEntityPrjtOperateNode")?
        JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"))
        :{
            crdfdEntity:"ready",
            crdfdDetail:"ready",
            crdfdOrganiser:"ready"
        };

    itemClickEvent();
    $(".save").click(function () {
        $(this).attr("status","onclick");
        saveCrowdFunding();
    });
    $(".next-stup").click(function () {
        $(this).attr("status","onclick");
        if(checkComplete())
            window.location.href="/view/project/returns-set.jsp";
        else
            saveCrowdFunding();
    });

}

function itemClickEvent() {
    $("#crdfdEntityItemContainer").on("click","span",function () {
        $(this).addClass("active-span").siblings().removeClass("active-span");
    });
}


function getCrowdFundingEntityInfo()
{
    if($("#prjtId").val())
    {
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/getCrowdFundingEntityInfo",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({id:$("#prjtId").val()}),
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
function getCrowdFundingDetail() {
    if($("#prjtId").val())
    {
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/getCrowdFundingDetail",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({id:$("#prjtId").val()}),
            //async: false,
            success: function (data){
                console.log(data.responseBody);
                if(data.responseBody&&data.responseBody.recordList[0])
                {
                    UE.getEditor('editor').setContent(data.responseBody.recordList[0]);

                }

            },
            error: function (returndata) {
//            	layer.msg("网络异常，请重试");
            }
        });
    }
}
function getCrowdFundingOrganiserInfo() {
    if($("#prjtOrganiserId").val())
    {
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/getCrowdFundingOrganiserInfo",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify({id:$("#prjtOrganiserId").val()}),
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
    //插入
    if(!$("#prjtId").val())
    {

        //首先插入发起人信息表
        newCrowdFundingOrganiser();

    }else {
        editCrowdFundingInfo();
    }
}

function editCrowdFundingInfo() {
    if($("#prjtId").val())
    {
        var crdfdEntity=Tools.autoNodeValEncaseJson("crdfdEntity");
        crdfdEntity["prjtItemId"]=$("#crdfdEntityItemContainer").find(".active-span").attr("itemid");
        crdfdEntity["id"]=$("#prjtId").val();
        //更新项目基本信息
        $.ajax({
            url:  serverUrl + "crowdFundingEntity/editCrowdFundingEntity",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "post",
            data: JSON.stringify(crdfdEntity),
            //async: false,
            success: function (data){
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
//            	layer.msg("网络异常，请重试");
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
        data: JSON.stringify({id:$("#prjtId").val(),prjtDetail:UE.getEditor('editor').getContent()}),
        //async: false,
        success: function (data){
            createEntityPrjtOperateNode.crdfdDetail="done";
            sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
            checkComplete();
        },
        error: function (returndata) {
//            	layer.msg("网络异常，请重试");
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
            createEntityPrjtOperateNode.crdfdOrganiser="done";
            sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
            checkComplete();
            console.log(data.responseBody);
            if(data.responseBody&&data.responseBody.recordList[0])
            {
                organiserId=data.responseBody.recordList[0].id;
                $("#prjtOrganiserId").val(organiserId);
                var crdfdEntity=Tools.autoNodeValEncaseJson("crdfdEntity");
                crdfdEntity["prjtItemId"]=$("#crdfdEntityItemContainer").find(".active-span").attr("itemid");
                $.ajax({
                    url:  serverUrl + "crowdFundingEntity/newCrowdFundingEntity",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    type: "post",
                    data: JSON.stringify(crdfdEntity),
                    //async: false,
                    success: function (data){
                        createEntityPrjtOperateNode.crdfdEntity="done";
                        sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
                        checkComplete();
                        console.log(data.responseBody);
                        if(data.responseBody&&data.responseBody.recordList[0])
                        {
                            var id=data.responseBody.recordList[0].id;
                            $("#prjtId").val(id);
                            sessionStorage.setItem("prjtId",id);
                        }
                        editCrowdFundingDetail();
                        

                    },
                    error: function (returndata) {
//            	layer.msg("网络异常，请重试");
                    }
                });
            }

        },
        error: function (returndata) {
//            	layer.msg("网络异常，请重试");
        }
    });
}
function editCrowdFundingOrganiser() {
    var crowdFundingOrganiser=Tools.autoNodeValEncaseJson("crdfdOrganiser");
    crowdFundingOrganiser["id"]=$("#prjtOrganiserId").val();
    //更新项目发起人信息
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/editCrowdFundingOrganiser",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(crowdFundingOrganiser),
        //async: false,
        success: function (data){
            createEntityPrjtOperateNode.crdfdOrganiser="done";
            sessionStorage.setItem("createEntityPrjtOperateNode",JSON.stringify(createEntityPrjtOperateNode));
            checkComplete();
           /*console.log(data.responseBody);
            if(data.responseBody&&data.responseBody.recordList[0])
            {
                Tools.autoInjectValue(data.responseBody.recordList[0]);
            }*/

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
function  checkComplete() {
    createEntityPrjtOperateNode=JSON.parse(sessionStorage.getItem("createEntityPrjtOperateNode"));
    var flag=true;
    for (var step in createEntityPrjtOperateNode)
    {
        if(createEntityPrjtOperateNode[step]!=done)
        {
            flag=false;
            break;
        }
    }
    if( $(".save").attr("status")=="onclick")
    {
        openSuccessWindow();
    }
    return flag;
}