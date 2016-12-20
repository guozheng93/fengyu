$(function () {
    var prjtId=Tools.getQueryString("prjtId");
    if(prjtId)
    {
        sessionStorage.setItem("prjtId",prjtId);
        initEvent();
    }

});

function initEvent() {
    //提交审核
    $(".submit-audit").click(function () {
        submitPrjt();

    });
    //预览项目
    $(".preview-pro").click(function () {
        window.location.href="/view/project/project-detail.jsp?prjtId="+sessionStorage.getItem("prjtId");
    });
}
function submitPrjt() {
    var prjtId=sessionStorage.getItem("prjtId");
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/submitPrjt",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({id:prjtId}),
        //async: false,
        success: function (data){
            openSuccessWindow();
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("commonTips.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function openSuccessWindow()
{
    layer.open({
        shadeClose:true,
        closeBtn:1,
        area:'600px',
        title:'',
        content:'<p class="save-tip">您的项目已经提交审核</p>'+'<p class="save-tip">审核信息将会短信发送给您</p>'+'<p class="save-tip">您可到<a href="javascript:;">“个人中心”</a>——<a href="javascript:;">“我发起的项目”</a>，查看项目信息</p>',
        btn:['我知道了']
    })
}