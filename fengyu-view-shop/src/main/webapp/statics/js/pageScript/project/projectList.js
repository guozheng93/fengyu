$(function () {
    
});

function  getProjectList() {
    $.ajax({
        url:  serverUrl + "crowdfundingEntity/commentReply4Prjt",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "post",
        data: JSON.stringify(replyJson),
        //async: false,
        success: function (data){
            if(data.returnCode==returncode.common["00000"].code)
            {
                Tools.renderTemplate("projectList","projectListBox",data);
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