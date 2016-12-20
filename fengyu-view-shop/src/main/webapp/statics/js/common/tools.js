var Tools={
    getQueryString:function (paramName) {
        var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if(r != null){
            return unescape(r[2]);
        };
        return null;
    },
    renderTemplate:function (templateId,htmlNodeId,data) {
        var html =template(templateId,data);
        $("#"+htmlNodeId).html(html);
    },
    //上传图片通用方法，按钮id，缩略图容器id
    webImageUploader:function (pickerId,thumbnailId)
    {
        var BASE_URL="/ueditor/third-party/webuploader/";
        // 优化retina, 在retina下这个值是2
        var ratio = window.devicePixelRatio || 1,

        // 缩略图大小
            thumbnailWidth = $("#"+thumbnailId).width() * ratio,
            thumbnailHeight = $("#"+thumbnailId).height() * ratio;
        // 初始化Web Uploader
        var uploader = WebUploader.create({

            // 选完文件后，是否自动上传。
            auto: true,

            // swf文件路径
            swf: BASE_URL + '/Uploader.swf',

            // 文件接收服务端。
            server: serverUrl + "common/uploadimage/crowd",

            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#'+pickerId,

            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        // 当有文件添加进来的时候
        uploader.on( 'fileQueued', function( file ) {
            $("#"+thumbnailId).addClass("webuploader-pick-thumbnail");
            var img=$("#"+thumbnailId).find("img");
            if(!$(img).length)
            {
                $("#"+thumbnailId).append('<img src="">');
                img=$("#"+thumbnailId).find("img");
            }
            $("#"+thumbnailId).append('<div class="webuploader-pick-uploadfileinfo">' + file.name + '</div>')

            // 创建缩略图
            uploader.makeThumb( file, function( error, src ) {
                if ( error ) {
                    $(img).replaceWith('<span>不能预览</span>');
                    return;
                }

                $(img).attr( 'src', src );
            }, thumbnailWidth, thumbnailHeight );
        });

        // 文件上传过程中创建进度条实时显示。
        uploader.on( 'uploadProgress', function( file, percentage ) {
            var li = $( '#'+thumbnailId ),
                percent = $(li).find('.progress span');

            // 避免重复创建
            if ( !$(percent).length ) {
                percent = $('<p class="progress"><span></span></p>')
                    .appendTo( $(li) )
                    .find('span');
            }

            $(percent).css( 'width', percentage * 100 + '%' );
        });

        // 文件上传成功，给item添加成功class, 用样式标记上传成功。
        uploader.on( 'uploadSuccess', function( file ,response) {
            var fileServerPath=response._raw;
            $( '#'+thumbnailId ).addClass('upload-state-done');
            //$( '#'+thumbnailId ).find("img").attr("fileServerUrl",fileServerUrl);
            $( '#'+thumbnailId ).find("img").attr("src",fileServerUrl+fileServerPath);
        });

        // 文件上传失败，现实上传出错。
        uploader.on( 'uploadError', function( file ) {
            var li = $( '#'+thumbnailId ),
                error = $(li).find('div.error');

            // 避免重复创建
            if ( !$(error).length ) {
                error = $('<div class="webuploader-pick-uploadfile-error"></div>').appendTo( $(li) );
            }

            $(error).text('上传失败');
        });

        // 完成上传完了，成功或者失败，先删除进度条。
        uploader.on( 'uploadComplete', function( file ) {
            $( '#'+thumbnailId ).find('.progress').remove();
        });
    },
    autoInjectValue :function (data)
    {
        for(var value in data)
        {

            var tagNode=$("[name='"+value+"']");
            if($(tagNode).length>1)
            {
                tagNode=$(tagNode).eq(0);
            }
            if(tagNode.length>0)
            {
                var tagName=$(tagNode)[0].tagName.toString().toLowerCase();
                if(value&&data[value].length>11&&parseInt(data[value]))
                {
                    var date=new Date(parseInt(data[value]));
                    data[value]=date.dateFormat("YYYY年 M月 D日");
                }

                switch(tagName)
                {
                    case "input":
                        var inputType=$(tagNode).attr("type");
                        switch(inputType) {
                            case "text":
                                $(tagNode).val(data[value]);
                                break;
                            case "radio":
                                $("input[name='"+value+"'][value='"+data[value]+"']").attr("checked","checked");;
                                break;
                            case "number":
                                $(tagNode).val(data[value]);
                                break;

                            /*case "checkbox":
                             nodeVal=$(tagNode).val();
                             break;*/
                        }
                        break;
                    case "select":
                        $(tagNode).val(data[value]);
                        break;
                    case "img":
                        $(tagNode).attr("src",fileServerUrl+data[value]);
                        break;
                    case "textarea":
                        $(tagNode).val(data[value]);
                        break;
                    default:
                        $(tagNode).html(data[value]);
                        break;
                }
            }
        }
    },
    //自动根据筛选属性belongTo，装入Json
    //过滤查找器，含有belongTo属性的标签，筛选belongTo=filter
    //filter为空时，默认筛选所有包含belongTo的属性
    //filter可为array 可为字符
    autoNodeValEncaseJson:function (filter) {
        var json={};
        if(filter)
        {
            if(jQuery.isArray(filter))
            {
                for(var i=0;i<filter.length;i++)
                {
                    var nodes=$("[belongTo='"+filter[i]+"']");
                    for(var j=0;j<nodes.length;j++)
                    {
                        if(this.isNotAllowedNull($(nodes[j]).attr("name"),"元素必须包含name"))
                            json[$(nodes[j]).attr("name")]=this.getNodeVal4Encase(nodes[j]);
                    }
                }
            }
            else
            {
                var nodes=$("[belongTo='"+filter+"']");
                for(var j=0;j<nodes.length;j++)
                {
                    if(this.isNotAllowedNull($(nodes[j]).attr("name"),"元素必须包含name"))
                        json[$(nodes[j]).attr("name")]=this.getNodeVal4Encase(nodes[j]);
                }
            }
        }else
        {
            var nodes=$("[belongTo]");
            for(var j=0;j<nodes.length;j++)
            {
                if(this.isNotAllowedNull($(nodes[j]).attr("name"),"元素必须包含name"))
                    json[$(nodes[j]).attr("name")]=this.getNodeVal4Encase(nodes[j]);
            }
        }
        return json;
    },
    getNodeVal4Encase:function (tagNode) {
        if($(tagNode).length>1)
        {
            tagNode=$(tagNode).eq(0);
        }
        var nodeVal;
        var tagName=$(tagNode)[0].tagName.toString().toLowerCase();
        switch(tagName)
        {
            case "input":
                var inputType=$(tagNode).attr("type");
                switch(inputType) {
                    case "text":
                        nodeVal=$(tagNode).val();
                        break;
                    case "radio":
                        nodeVal=$("input[name='"+$(tagNode).attr("name")+"']:checked").val();
                        break;
                    case "number":
                        nodeVal=$(tagNode).val();
                        break;
                    /*case "checkbox":
                        nodeVal=$(tagNode).val();
                        break;*/
                }
                break;
            case "select":
                nodeVal=$(tagNode).val();
                break;
            case "img":
                nodeVal=$(tagNode).attr("src");
                nodeVal=nodeVal.replace(fileServerUrl,"");
                break;
            case "textarea":
                nodeVal=$(tagNode).val();
                break;
        }
        return nodeVal;
    },
    isNotAllowedNull:function (args,msg) {
        if(!args)
        {
            throw new Exception.NullPointerException(msg);
            return false;
        }
        return true;

    },
    getMessageTipsByName:function (jsonNodeName) {
        var jsonNodes=jsonNodeName.split(".");
        var messageTips;
        $.ajaxSettings.async = false;
        $.getJSON("/statics/js/common/message.json",messageTips,function(data){
            var jsonNode=data;
            for(var i=0;i<jsonNodes.length;i++)
            {
                jsonNode=jsonNode[jsonNodes[i]];
            }
            messageTips=jsonNode;
        });
        return messageTips;
    }
    ,
    getValidMsgByName:function (jsonNodeName) {
        var jsonNodes=jsonNodeName.split(".");
        var messageTips;
        $.ajaxSettings.async = false;
        $.getJSON("/statics/js/common/validate-message.json",messageTips,function(data){
            var jsonNode=data;
            for(var i=0;i<jsonNodes.length;i++)
            {
                jsonNode=jsonNode[jsonNodes[i]];
            }
            messageTips=jsonNode;
        });
        return messageTips;
    },
    setVal2Session:function (key,value) {
        var isjson = typeof(value) == "object" && Object.prototype.toString.call(value).toLowerCase() == "[object object]" && !value.length;
        if(isjson)
        {
            sessionStorage.setItem(key,JSON.stringify(value));
        }else
        {
            sessionStorage.setItem(key,value);
        }
    },
    getVal2Session:function (key) {
        return key;
    },
    resetImgVal:function () {
        $("img[belongto]").attr("src",global.defaultImg);
        $("img[belongto]").nextAll().remove();
    },

}
