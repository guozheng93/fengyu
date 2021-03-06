define(function(require, exports, module){
    var $ = require("jquery"),
        md5 = require("md5"),
        tool = require("common/tool"),
        registerLy = -1,
        register = {},
        countdown=60;
    module.exports = register;

    //初始化
    register.init = function(){
        $("#phone,#code").val("");
        register.event();
    };


    //事件注册
    register.event = function(){
        $("#pwd").keypress(function(e){
            if(e.keyCode==13){
                register.doLogin();
            }
        });

        $("#sendCodeBtn").click(function(){
            register.sendCode();
        });

        $(".rg-p a").click(function(){
            register.registerProtocol();
        });

        $("#registerBtn").click(function(){
            register.validCode();
        });

        $("#fycom").click(function(){
            register.settingPwd();
        });
    };

    register.sendCode = function(){
        registerLy = tool.load();
        var sendTarget = $.trim($("#phone").val()),
            params = {"sendTarget":sendTarget,"verifyCodeType":1,"bizType":"register"};
        if(tool.isEmpty(sendTarget)){
            tool.msg("手机号不能为空",2);
            tool.closeLayer(registerLy);
            return;
        }else{
            var config = {
                url : "/common/send",
                params : params,
                onSuccess : register.doSendCodeSuccess
            };
            tool.apiReq(config);
        };
    };

    register.validCode = function(){
        registerLy = tool.load();
        var sendTarget = $.trim($("#phone").val()),
            verifyCode = $.trim($("#verifyCode").val()),
            params = {"sendTarget":sendTarget,"verifyCodeType":1,"bizType":"register","verifyCode":verifyCode};
        if(tool.isEmpty(sendTarget)) {
            tool.msg("手机号不能为空", 2);
            tool.closeLayer(registerLy);
            return;
        }else if(tool.isEmpty(verifyCode)){
            tool.msg("请输入手机验证码", 2);
            tool.closeLayer(registerLy);
            return;
        }else{
            var config = {
                url : "/common/valid",
                params : params,
                onSuccess : register.doValidCodeSuccess
            };
            tool.apiReq(config);
        };
    };

    register.settingPwd = function(){
        registerLy = tool.load();
        var phone = $.trim($("#phone").val()),
            password = $.trim($("#password").val()),
            repeatpwd = $.trim($("#repeatpwd").val()),
            params = {"phone":phone,"password":password};
        if(!$("#tickagree").is(':checked')){
            tool.msg("请先阅读并同意用户注册协议", 2);
            tool.closeLayer(registerLy);
            return;
        }
        if(tool.isEmpty(phone)) {
            tool.msg("手机号不能为空", 2);
            tool.closeLayer(registerLy);
            return;
        }else if(password.length<6){
            tool.msg("密码不能小于6个字符，请重新输入！", 2);
            tool.closeLayer(registerLy);
            return false;
        }else if(tool.isEmpty(password)){
            tool.msg("密码不能为空", 2);
            tool.closeLayer(registerLy);
            return;
        }else if(password != repeatpwd){
            tool.msg("密码不一致，请重新输入！", 2);
            tool.closeLayer(registerLy);
            return;
        }else{
            var config = {
                url : "/user/register",
                params : params,
                onSuccess : register.doSettingPwdSuccess
            };
            tool.apiReq(config);
        };
    };


    register.doValidCodeSuccess = function(res){
        tool.closeLayer(registerLy);
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            $(".regist-box").hide();
            $(".regist-paswd").show();
        }else if(result.code == 1002){
            tool.msg(result.msg,2);
        }else{
            tool.msg("验证失败",2);
        }
    };
    register.doSendCodeSuccess = function(res){
        tool.closeLayer(registerLy);
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            register.timeOut($("#sendCodeBtn"));
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("登录失败",2);
        }
    };
    register.doSettingPwdSuccess = function(res){
        tool.closeLayer(registerLy);
        var result = eval('(' + res.body + ')');
        if(result.code == 1000 || result.code == 1001){
            tool.msg("注册成功",1);
            setTimeout(location.href="/view/home/index.jsp", 2000);
        }else if(result.code == 1002){
            //接口返回未成功信息
            //login.tip(result.msg);
            tool.msg(result.msg,2);
        }else{
            tool.msg("注册失败",2);
        }
    };


    register.registerProtocol = function(){
        layer.open({
            title:'<b>用户服务协议</b>',
            btn:'同意并继续',
            area:['810px','500px'],
            shadeClose:true,
            closeBtn:1,
            content:'<p>'+
            '蜂娱文化(www.360fengyu.com) 是山东星万蜂娱网络科技有限公司（简称“蜂娱文化”）运营的网络平台，本协议的双方是蜂娱文化的用户（简称“您”）与蜂娱文化。在您登录并使用“蜂娱文化”提供的各项服务之前，请您务必仔细阅读并透彻理解本协议条款。如果您同意登录并使用“蜂娱文化”提供的服务，视为您已经认真阅读、理解并完全接受了本协议全部内容，本协议即时在您与蜂娱文化之间发生法律效力。<br>'+
            '<span style="margin:10px 0;display:block;font-weight:600;">以下为本协议内容：<br></span>'+
            '1、您应是具有完全民事权利能力和民事行为能力的自然人，或依法设立并有效存续的单位（包括企业法人及其他组织）。<br>'+
            '2、您应妥善保管您的登录帐号，使用您的帐号登录蜂娱文化进行的任何操作，将视为您本人的操作，一切后果由您本人承担。<br>'+
            '3、您在登录时及在使用蜂娱文化提供的服务时提供的相关资料及信息应真实、准确、有效、完整，且不存在误导陈述，不侵害其他人的知识产权及合法权益。前述资料及信息包括：您在登录过程中、在任何公共信息区域（包括留言栏或反馈区）或通过任何电邮形式或手机短信向蜂娱文化或其他用户提供的所有内容。<br>'+
            '4、为更好地保护您的合法权益并向您提供优质、高效的服务，蜂娱文化可能将您的信息应用在以下方面：<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;（1）在您登录蜂娱文化时进行必要的身份验证；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;（2）根据您的浏览记录及相关信息，向您推荐您可能感兴趣的项目资料；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;（3）针对您通过蜂娱文化提出的任何问题及时予以回复，并提供必要的协助；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;（4）分析蜂娱文化的用户需求及使用情况，以为您提供更优质的服务；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;（5）在项目众筹成功后，将项目支持人的姓名/名称及联系方式发送给项目发起人，以协助项目发起人兑现对项目支持人的回报；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;（6）用于向您提供的其他相关服务，比如向您发送蜂娱文化的有关通知、服务公告等。<br>'+
            '5、蜂娱文化将针对您的个人交易向您发送相关电子邮件，同时也会将此类邮件的发送控制在最低限度，如果您不选择退订此类邮件，视为您接受蜂娱文化继续向您发送此类邮件。<br>'+
            '6、您在对蜂娱文化发布的项目提供众筹支持时，应认真阅读蜂娱文化发布的有关该项目的一切信息。如果您确定为某项目提供众筹支持，视为您已经完全理解并接受该项目的相关内容及风险，一切后果由您本人承担，蜂娱文化不承担任何责任。<br>'+
            '7、蜂娱文化不保证在蜂娱文化平台发布的所有项目均能够众筹成功，如项目众筹失败，蜂娱文化会协助项目发起人将众筹金额无息返还给项目支持人，项目发起人或项目支持人均不得要求蜂娱文化承担任何责任。<br>'+
            '8、蜂娱文化不保证在蜂娱文化平台发布的所有已众筹成功的项目，能运行或研发成功。如项目运行失败，而导致项目发起人无法发放回报，蜂娱文化会协助、监督项目发起人退款给您，如您与项目发起人因此产生纠纷，应双方协商解决，蜂娱文化可提供必要的协助，但任何一方均不得要求蜂娱文化承担任何责任。<br>'+
            '9、蜂娱文化不保证在蜂娱文化平台发布的所有已众筹成功的项目，发放回报时间准确，如因任何原因导致项目发起人延迟发放回报时间，蜂娱文化会协助、监督项目发起人按时发放回报，如您与项目发起人因此产生纠纷，应双方协商解决，蜂娱文化可提供必要的协助，但任何一方均不得要求蜂娱文化承担任何责任。<br>'+
            '10、蜂娱文化应对您提供的信息履行保密义务，非为本协议约定之目的或按照法律、法规、有权机关的要求进行信息披露外，未经您事先书面同意，蜂娱文化不应向任何第三方披露您的信息。<br>'+
            '11、您在使用蜂娱文化提供的服务时应遵守中华人民共和国相关法律法规、不得将本服务用于任何非法目的，也不得以任何非法方式使用本服务。<br>'+
            '12、当您存在包括但不限于下列情形之一时，蜂娱文化有权立即终止向您提供服务而无需承担任何责任，并有权要求您赔偿蜂娱文化因此遭受的一切损失：<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;12.1违反本协议的约定；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;12.2冒用他人名义使用本服务；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;12.3 利用本服务侵害他人的合法权益；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;12.4 从事非法交易，如洗钱、贩卖枪支、毒品、禁药、盗版软件、淫秽物品等；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;12.5 从事任何可能含有电脑病毒或可能侵害本服务系统之行为；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;12.6 蜂娱文化认为向您提供本服务存在风险的；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;12.7 其他导致蜂娱文化终止向您提供服务的行为。'+
            '14、因以下任一情形导致您无法使用全部或部分服务时，蜂娱文化不承担任何责任，该情形包括但不限于：<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;14.1蜂娱文化在网站公告之系统停机维护期间；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;14.2电信设备出现故障不能进行数据传输的；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;14.3您的银行卡发卡银行的原因导致的服务中断或延迟；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;14.4 因台风、地震、海啸、洪水、停电、战争、恐怖袭击等不可抗力之因素，造成蜂娱文化系统障碍不能执行业务的；<br>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;14.5由于黑客攻击、电信部门技术调整或故障、网站升级等原因而造成的服务中断或者延迟。<br>'+
            '15、蜂娱文化依据本协议约定中止或终止向您提供服务后，并不能免除您在中止或终止前实施的行为应承担的任何法律后果。<br>'+
            '16、本协议的成立、生效、履行，均适用中华人民共和国法律解释。<br>'+
            '17、蜂娱文化发布的各类规则、协议、条款等，构成本协议不可分割的组成部分。蜂娱文化有权适时调整本协议的内容，并在蜂娱文化公布，如您不能接受变更后的协议内容，请立即停止使用蜂娱文化提供的服务。如您继续使用蜂娱文化提供的服务，视为您理解并接受调整后的本协议。<br>'+
            '18、双方在履行本协议的过程中，如发生争议，应协商解决。协商不成的，应提交北京市朝阳区人民法院诉讼解决。<br>'+
            '19、您同意，在发生并购时，蜂娱文化在本协议和所有纳入协议的条款和规则项下的所有或者部分权利和义务，可由蜂娱文化自行酌情决定向第三方进行转让。<br>'+

            '</p>'
        });
    };


    register.timeOut = function(obj){
        if (countdown == 0) {
            $(obj).removeAttr("disabled");
            $(obj).val("获取验证码");

            countdown = 60;
            return flase;
        } else {
            $(obj).attr("disabled", 'disabled');
            $(obj).val("重新发送(" + countdown + ")");

            countdown--;
        }
        setTimeout(function() {
                register.timeOut(obj) }
            ,1000)
    };
});
