template.helper('long2Date', function (longTime) {
    if(longTime)
        var date=new Date(parseInt(longTime));
    else
        var date=new Date();
    return date.dateFormat("YYYY年 M月 D日");
});

template.helper('daysAgo', function (longTime) {
    var date=new Date(parseInt(longTime));
    var days=date.diff(new Date(),"days");
    return days+'天前';
});

template.helper('transToServerUrl', function (filePath) {

    return fileServerUrl+filePath;
});