var Exception={
    NullPointerException:function (message,level) {
        if(level)
            layer.msg("发生NullPointerException异常，详细信息["+message+"]", {icon: 5});
        else
            console.log("发生NullPointerException异常，详细信息["+message+"]");
    }
};