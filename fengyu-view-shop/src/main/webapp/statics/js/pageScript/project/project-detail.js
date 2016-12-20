var prjtId=Tools.getQueryString("prjtId");
$(function () {
    if(prjtId)
    {
        sessionStorage.setItem("prjtId",prjtId);
        initEvent();
        getCrfFdEntityInfo();
        getCrfFdEntityDetail();
        getCrdFdEntityProgess();

        //获取赞状态
        getPrjtPraiseStatus();
        //获取关注状态
        getPrjtFocusStatus();

        //查询赞总数
        getCrdFdEntityTotalPraise();
        //查询关注总数
        getCrdFdEntityTotalFocus();

        //等接口
        getCrdFdEntityOrganiserInfo();

        //获取项目回报列表
        getList4CrdFdRepayWithOrder();

        //获取项目动态信息
        getCrdFdEntityDynamics();
        //获取项目订单列表
        getPageList4CrdFdEntityOrder();
        //获取项目评论详情
        getCrdFdEntityComment();
    }
});
function initEvent() {

    /*赞和关注*/
    $(".zan-p img").on('click',function(){
        praiseCrdFdAction();

    });
    $(".guan-p img").on('click',function(){
        focusCrdFdAction();

    });

    /*回复*/
    $(".comm-list").on("click",".reply",function(){
        var commentNode=$(this).parent().parent().parent();
        var commentId=$(commentNode).attr("commentId");
        var replyId=$(commentNode).hasClass("comm-list-replay")?$(commentNode).attr("replyId"):commentId;
        var replyType=$(commentNode).hasClass("comm-list-replay")?"topic":"reply";
        var toUid=$(this).attr("fromUid");
        var replayTextHtml=template("replayTextArea",{commentId:commentId,replyId:replyId,toUid:toUid,replyType:replyType});
        $(".comm-reply").remove();
        $(replayTextHtml).insertAfter($(commentNode));
        $(replayTextHtml).show();
        $('#replyEmotion').qqFace({
            id : 'facebox',
            assign:'replyInput',
            path:'/statics/arclist/'	//表情存放的路径
        });

    });
    //回复评论按钮
    $(".comm-list").on("click",".word-tip a",function(){
        var toUid=$(".comm-reply").find("textarea").attr("toUid");
        var replyType=$(".comm-reply").find("textarea").attr("replyType");
        var replyContent=$(".comm-reply").find("textarea").val();
       /* var user=JSON.parse(sessionStorage.getItem("user"));
        var fromUid=user?user.nickName:"游客";*/
        var commentId=$(this).attr("commentId");
        var replyId=$(this).attr("replyId");
        var replyJson={commentId:commentId,replyId:replyId/*,fromUid:fromUid*/,toUid:toUid,replyType:replyType,replyContent:replyContent,replyTime:new Date().getMilliseconds()};

        commentReply4Prjt(replyJson);

    });
    $(".fabu-huati").click(function () {
        var topicContent=$("#topicTextArea").val();
        if(!topicContent)
        {
            layer.msg("请输入发表内容！");
        }else
        {
            var jsonStr={topicId:sessionStorage.getItem("prjtId"),commentContent:topicContent,topicType:"project"};
            comment4Prjt(jsonStr);
        }
    });
    $('#topicEmotion').qqFace({
        id : 'facebox',
        assign:'topicTextArea',
        path:'/statics/arclist/'	//表情存放的路径
    });
    /*放大*/
    $("#crdfdEntityRepayListBox").on("click",".sl-p2 img",function(){
        $(".amplification").hide();
        $(".bound,.amplification").show();

        /* var this_f=$(this).parents(".sl-p2").css("background-image");
         $(this).parents(".support-list").find(".amplification").show().css("background-image",this_f);*/
    });
    $(".bound").click(function(){
        $(".amplification,.bound").hide();
    });

    /*我要支持*/
    $(".i-support").click(function(){
        $(".bound,.support-cpm").show();
        $("[name=prjtEndTime4Repay]").text($("[name=prjtEndTime]").text());


        $(".sup-btn").click(function(){
            if($(".sup-check input").is(":checked")){
                $(".bound,.support-cpm").hide();
                var repayId=$(".sup-check input:checked").val();
                window.location.href="/view/order/order-submit.jsp?prjtId="+sessionStorage.getItem("prjtId")
                    +"&repayId="+repayId+"";
            }else{
                layer.msg("请选择一个");
                return false;
            }
        });
        $(".sup-cancel").click(function(){
            $(".bound,.support-cpm").hide();

        });
        $(".bound").click(function(){
            $(".bound,.support-cpm").hide();

        });
    });
    var nums = 5; //每页出现的数量
    var pages =100; //得到总页数
    //调用分页
    laypage({
        cont: 'pr-page',
        pages: pages,
        jump: function(obj){
            // document.getElementById('biuuu_city_list').innerHTML = thisDate(obj.curr);
        }
    });

    var w_width=$(window).width();
    var ft_width=(w_width-80)/2;
    $(".ft-bord").css("width",ft_width);
    var ws_width=w_width/2;
    $(".white-s").css("width",ws_width);
    /*导航*/
    $.each($(".navigate a"), function(i,e) {
        if($(e).hasClass("nav-active")){
            $(e).find("p").show();
        }
    });
    $(".navigate a").click(function(){
        $(this).addClass("nav-active").siblings().removeClass("nav-active");
        $(".navigate a p").hide();
        $(this).children("p").show();
    });
    /***********/
    $(".pro-d-ul li").click(function(){
        $(".pro-d-ul li").css("background",'none');
        $(this).css("background","#878787");
        $(".pro-d-ul a").css("color","#666666");
        $(".pro-d-ul a").removeClass("active-proa");
        $(this).children("a").css("color",'#FFFFFF').addClass("active-proa");
        $(".pro-d-ul p").css("color","#666666");
        $(this).children("p").css("color","#FFFFFF");
    });


    /*选项卡*/
    $(".pro-d-con").hide().eq(0).show();
    $(".pro-d-ul li").click(function(){
        $(this).addClass(".pro-li1").siblings().removeClass(".pro-li1");
        var this_index=$(this).index();
        $(".pro-d-con").eq(this_index).show().siblings(".pro-d-con").hide();
    });
    $(".comm-zan1").bind('click',function(){
        $(this).unbind('click');
        var com_zan1=parseInt($(this).find("b").html());
        $(this).find("b").html(com_zan1+1);
    });


    $(".replay2").click(function(){
        if($(".comm-reply").css("display")=="none"){
            $(".comm-reply").show();
            $(".comm-reply textarea").val("");
            $(".comm-reply textarea").prop("placeholder","回复：moumou");
            $(".word-tip a").click(function(){
                $(".comm-list-replay").clone().appendTo(".comm-list-replay").css("margin-left","0px");
                $(".comm-reply").hide();
            })
        }else{
            $(".comm-reply").hide();
        }
    });

    /*发送私信*/
    $(".author-r-p2").click(function(){
        $(".bound,.send-mesg").show();
        $(".send-cancel").click(function(){
            $(".bound,.send-mesg").hide();
        })
        $(".send-btn").click(function(){
            $(".bound,.send-mesg").hide();
            layer.msg("发送成功");
        })
    });
    $(".bound").click(function(){
        $(".bound,.send-mesg").hide();
    });
}


function commentReply4Prjt(replyJson) {
    $.ajax({
        url:  serverUrl + "comment/commentReply4Prjt",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(replyJson),
        //async: false,
        success: function (data){
            if(data.returnCode==returncode.common["00000"].code)
            {
                var html=template("replyContent",data.responseBody.recordList[0]);
                $(".comm-reply").replaceWith(html);
            }else
            {
                //404页面
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function comment4Prjt(replyJson) {
    $.ajax({
        url:  serverUrl + "comment/comment4Prjt",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(replyJson),
        //async: false,
        success: function (data){
            if(data.returnCode==returncode.common["00000"].code)
            {
                var html=template("topicContent",data.responseBody.recordList[0]);
                $(".comm-list").prepend(html);
            }else
            {
                //404页面
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
//获取项目基本信息
function getCrfFdEntityInfo() {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getCrowdFundingEntityInfo",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({id:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                Tools.autoInjectValue(data.responseBody.recordList[0]);
                var prjtStatus=data.responseBody.recordList[0].prjtStatus.toString();
                var descStatus=global.crowdfundingStatus[prjtStatus];
                $("[name=prjtStatus]").text(descStatus);
            }else
            {
                //404页面
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function getCrfFdEntityDetail() {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getCrowdFundingDetail",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({id:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                Tools.autoInjectValue(data.responseBody.recordList[0]);
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function getCrdFdEntityProgess() {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getCrdFdEntityProgess",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({id:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                data=data.responseBody.recordList[0];
                var prjtFundingResidueDays=parseInt(data.prjtEndTime)-parseInt(data.prjtfundingTime)
                    ,prjtFundingResidueAmt=data.prjtRaiseAmount-data.prjtSumAmt<0?0:data.prjtRaiseAmount-data.prjtSumAmt
                    ,prjtTargetSchedule=data.prjtSumAmt/data.prjtRaiseAmount*100;
                data.prjtFundingResidueDays=prjtFundingResidueDays / 1000 / 60 / 60 / 24;
                data.prjtFundingResidueAmt=prjtFundingResidueAmt+"元";
                data.prjtTargetSchedule=prjtTargetSchedule.toFixed(0);
                Tools.autoInjectValue(data);
                $("[name=prjtTargetScheduleView]").css("width",prjtTargetSchedule+"%")
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}

//查询热度信息
function getCrdFdEntityTotalFocus() {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getCrdFdEntityTotalFocus",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({prjtId:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                data=data.responseBody.recordList[0];
                Tools.autoInjectValue(data);
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
//查询热度信息
function getCrdFdEntityTotalPraise() {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getCrdFdEntityTotalPraise",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({prjtId:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                data=data.responseBody.recordList[0];
                Tools.autoInjectValue(data);
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function getPrjtPraiseStatus()
{
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getPrjtPraiseStatus",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({prjtId:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                data=data.responseBody.recordList[0];
                var status=data.status;
                if(status==global.crwFdHeatStatus["normal"].status)
                {
                    $(".zan-p").removeClass("unlight");
                }else
                {
                    $(".zan-p").addClass("unlight");
                }
            }else {
                $(".zan-p").addClass("unlight");
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}

function getPrjtFocusStatus()
{
       $.ajax({
        url:  serverUrl + "crowdFundingEntity/getPrjtFocusStatus",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({prjtId:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                data=data.responseBody.recordList[0];
                var status=data.status;
                if(status==global.crwFdHeatStatus["normal"].status)
                {
                    $(".guan-p").removeClass("unlight");

                }else
                {
                    $(".guan-p").addClass("unlight");
                }
            }else {
                $(".guan-p").addClass("unlight");
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
//赞动作
function praiseCrdFdAction() {
    var status=$(".zan-p").hasClass("unlight")?global.crwFdHeatStatus["normal"].status:global.crwFdHeatStatus["cannel"].status

    $.ajax({
        url:  serverUrl + "crowdFundingEntity/praiseCrdFdAction",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({prjtId:prjtId,status:status}),
        //async: false,
        success: function (data){
            if(data.returnCode==returncode.common["00000"].code)
            {
                if(status==global.crwFdHeatStatus["normal"].status)
                {
                    $(".zan-p").removeClass("unlight");
                    var z_val=parseInt($(".zan-p span").html());
                    $(".zan-p span").html(z_val+1);

                }else
                {
                    $(".zan-p").addClass("unlight");
                    var z_val=parseInt($(".zan-p span").html());
                    $(".zan-p span").html(z_val-1);
                }
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}

//赞动作
function focusCrdFdAction() {
    var status=$(".guan-p").hasClass("unlight")?global.crwFdHeatStatus["normal"].status:global.crwFdHeatStatus["cannel"].status
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/focusCrdFdAction",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({prjtId:prjtId,status:status}),
        //async: false,
        success: function (data){
            if(data.returnCode==returncode.common["00000"].code)
            {
                if(status==global.crwFdHeatStatus["normal"].status)
                {
                    $(".guan-p").removeClass("unlight");
                    var g_val=parseInt($(".guan-p span").html());
                    $(".guan-p span").html(g_val+1);
                    layer.msg("关注成功");

                }else
                {
                    $(".guan-p").addClass("unlight");
                    var g_val=parseInt($(".guan-p span").html());
                    $(".guan-p span").html(g_val-1);
                    layer.msg("取消关注成功");
                }
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}

function getCrdFdEntityOrganiserInfo() {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({id:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {

            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function getList4CrdFdRepayWithOrder() {
    $.ajax({
        url:  serverUrl + "crowdFundingRepay/getList4CrdFdRepayWithOrder",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({prjtId:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                Tools.renderTemplate("crdfdEntityRepayList","crdfdEntityRepayListBox",data);
                Tools.renderTemplate("supportList4ISupport","supportList4ISupportBox",data);
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function getCrdFdEntityDynamics() {
    $.ajax({
        url:  serverUrl + "crowdFundingEntity/getPageList4CrdFdEntityDynamics",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({prjtId:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                Tools.renderTemplate("crdfdEntityDynamicsList","crdfdEntityDynamicsListBox",data);
                $("p[name=prjtDynamics]").text("("+data.responseBody.recordList.length+")");
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function getPageList4CrdFdEntityOrder() {
    $.ajax({
        url:  serverUrl + "order/getPageList4CrdFdEntityOrder",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({prjtId:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                Tools.renderTemplate("prjtOrderList","prjtOrderListBox",data);
                $("p[name=prjtOrders]").text("("+data.responseBody.recordList.length+")");
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}
function getCrdFdEntityComment() {
    $.ajax({
        url:  serverUrl + "comment/getComment4Prjt",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify({topicId:prjtId}),
        //async: false,
        success: function (data){
            if(data.responseBody.recordList)
            {
                data=data.responseBody.recordList;
                //comm-list
                var commentHtml="";
                var commentLength=data.length;
                for(var i=0;i<data.length;i++)
                {
                    var topic=data[i];
                    var replyList=topic.commentReplyList;
                    var replyHtml="";
                    replyHtml=recursionReply("0",replyList,replyHtml);
                    commentHtml+=template("topicContent",topic);
                    commentHtml=commentHtml+replyHtml;
                    commentLength+=replyList.length;
                }
                $("[name=prjtComments]").text("("+commentLength+")");
                $(".comm-list").prepend(commentHtml);
            }
        },
        error: function (returndata) {
            var messge=Tools.getMessageTipsByName("crowd.modifyedFailed");
            layer.msg(messge);
        }
    });
}

function recursionReply(replyId,replyList,replyHtml) {
    for(var j=0;j<replyList.length;j++)
    {
        var targetReply="";
        var curtReply=replyList[j];
        if(curtReply.replyId==replyId)
        {
            targetReply=replyList[j];
            replyHtml+=template("replyContent",targetReply);
            replyHtml=recursionReply(targetReply.id,replyList,replyHtml)
        }
    }
    return replyHtml;
}