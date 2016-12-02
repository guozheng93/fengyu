<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <body>
        <div class="foot">
            <p class="foot-title"><span class="ft-bord"></span><span class="ft-txt">蜂娱文化</span><span class="ft-bord ft-bord-r"></span></p>
            <div class="foot-bg" style="background-image:url(../../statics/images/foot_bg.png);">
                <div class="fm-bound"></div>
                <span class="white-s ws-l"><img src="../../statics/images/white_sr.png"></span>
                <span class="white-s ws-r"><img src="../../statics/images/white_s.png"></span>
                <div class="foot-mid">
                    <dl class="fm-dl">
                        <dt>帮助与条款</dt>
                        <dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=3&sn=f5cd064525e88bf8b69f38f4493f7201&chksm=ec3e466cdb49cf7a215d296a0861349a44f35b47848de908f7a978357e52bc008efe4eba7550&mpshare=1&scene=1&srcid=1012dgLJkF4BWLkXWDeNTk2H#rd" target="_blank">用户服务协议</a></dd>
                        <dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=5&sn=c30b81e8bf9efb2e6709f08de22bade9&chksm=ec3e466cdb49cf7ae7cb9fc7c42f157ad4b2883785042c7b782eb31552b56e383709e26bf4b2&mpshare=1&scene=1&srcid=1012Uf8gtfHjB4Fbg4tNCuej&from=singlemessage&isappinstalled=0#wechat_redirect" target="_blank">支持者指南</dd>
                        <dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=1&sn=4b7078898aa345639ef5a0df64fb9114&chksm=ec3e466cdb49cf7aca256d32bbfded2b0acc63421feb7161b74ce97ea2e1085c501807512a76&mpshare=1&scene=1&srcid=1012wbf2VIMaKoBnVp5Hjsg5#rd" target="_blank">项目规范</a></dd>
                        <dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=4&sn=72ec5433e0c75a2edbab00170188cbfd&chksm=ec3e466cdb49cf7aa7748b15827705a3837fe33bdc466ad58c72eadbe9a15136002f4a607205&mpshare=1&scene=1&srcid=10123FK8KVViYqkz0WcP3QRk#rd" target="_blank">常见问题</a></dd>
                        <dd><a href="http://mp.weixin.qq.com/s?__biz=MzI4ODM5NjM3OA==&mid=2247484249&idx=2&sn=0ef927f91a0b20dae3206124f4fe62b4&chksm=ec3e466cdb49cf7a3bf5ca44dcb29273a61fa2777e38729feb974eac5bbc7468e447bf4131b3&mpshare=1&scene=1&srcid=1012khnHNk8HULOT8xZazDUA#rd" target="_blank">信任和安全</a></dd>
                    </dl>
                    <dl class="fm-dl">
                        <dt>关注我们</dt>
                        <dd><a href="javascript:;">关注蜂娱文化公众号</a></dd>
                        <dd><img src="/statics/images/erweima.jpeg" class="fm-dl-code"></dd>

                    </dl>
                    <dl class="fm-dl">
                        <dt>联系我们</dt>
                        <dd><a href="javascript:;">客服热线（9：00-17：00）</a></dd>
                        <dd><a href="javascript:;" class="fm-phone">400-025-3721<a></dd>
                        <dd><a href="javascript:;">Email：fy_culture@163.com</a></dd>
                        <dd><a href="javascript:;" style="margin:0 10px;display: block;line-height: 18px;">Add：山东省济南市高新区经十东路8000号龙奥金座1号楼1A层</a></dd>
                    </dl>
                    <dl class="fm-dl fm-dl-last">
                        <dt>合作伙伴</dt>
                        <dd class="hezuo-a">
                            <a href="javascript:;">国钰投资 </a>
                            <a href="javascript:;">驷鹿电商</a>
                            <a href="javascript:;">搭伙校园</a>
                            <a href="javascript:;">万数技术</a>
                            <a href="javascript:;">钉钉</a>
                            <a href="javascript:;">阿里云</a>
                        </dd>
                    </dl>
                </div>
                <div class="copyright">
                    <p>Copyright  2016 山东星万蜂娱网络科技有限公司  鲁ICP备16015631号-1  www.360fengyu.com</p>
                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript" src="/statics/js/jquery.SuperSlide.2.1.1.js" ></script>
    <script>
        //jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true,delayTime:300});
        //banner箭头显示隐藏
        $(".banner").hover(function(){
            $(".next,.prev").fadeIn();
        },function(){
            $(".next,.prev").fadeOut();
        })

        $(function(){
            var w_width=$(window).width();
            var ft_width=(w_width-80)/2;
            $(".ft-bord").css("width",ft_width);
            var ws_width=w_width/2;
            $(".white-s").css("width",ws_width);
        })
    </script>
    <script>
        $(function(){
            //发起众筹（没有登录）
            $(".faqi_zhongchou").on('click',function(){
                layer.open({
                    shadeClose:true,
                    closeBtn:1,
                    shift:1,
                    content: '<p>您尚未登录，请先<a href="login.jsp">登录</a></p>',
                    yes:function(){
                        window.location.href='login.jsp';
                    }
                });
            })
            //发起众筹（登录但是第一次发起）
            $(".faqi_zhongchou").on('click',function(){
                parent.layer.open({
                    title:'<b>蜂娱文化项目规范</b>',
                    btn:'同意',
                    area:['800px','500px'],
                    shadeClose:true,
                    closeBtn:1,
                    content:'<p>'+
                    '欢迎您来到蜂娱文化和更多人分享精彩的文化娱乐创意，获得支持，募集资金。已经有无数创意生产者通过众筹的方式找到了志趣相投的伙伴，让点子变成现实。<br>'+
                    '为了营造良好的社区环境，我们为所有创意生产者制定了项目规范。如果您的项目内容不符合此规范，将很有可能无法在蜂娱文化上线。<br>'+
                    '现在，我们无比期待看到您的新想法。<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">1、蜂娱文化欢迎什么项目<br></span>'+
                    '蜂娱文化是一个“泛文化娱乐的创意项目众筹社区”。我们希望所有发起人都在进行基于创意的生产创造。如果您的项目属于游戏、动漫、出版、活动、影视、音乐、设计、科技这八个品类的范畴，将会更容易通过我们的初步审核。<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">2、蜂娱文化不支持什么项目<br></span>'+
                    '发起人申请发起的项目如果包含内容，将基本不予审核通过：<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;烟酒相关；饮食类相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;婴儿用品相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;洗浴和美容；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;化妆品产品相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;保健品、营养补充剂相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;医疗器械、安全用品、成人用品相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;枪支、武器和刀具相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;房地产相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;兑奖、彩票和抽奖活动相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;毒品、类似毒品的物质、吸毒用具等相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;财政奖励(所有权、利润份额、还款贷款等)；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;令人反感的内容(仇恨言论、不适当内容等)；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;情色相关；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;支持或反对政治党派的项目；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;推广或美化暴力行为的项目；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;非创意类公益项目（如呼吁献血、捐款等）；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;开店（如网店、服装店、小卖部、饭店、旅馆等）；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;建设网站；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;涉及宗教类项目；<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;以及其他经摩点判断不宜发布的项目；<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">3、清晰完整地进行自我介绍和项目介绍<br></span>'+
                    '支持者对项目有完全的知情权，他们需要认识您，并且尽可能多地了解关于您项目的一切，才更有可能支持您。因此，在您的项目介绍中，必须用具体清晰的方式展示：<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;1、关于我<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;2、我想要做什么<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;3、创意来源<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;4、项目的进展<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;5、我的承诺与回报<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;6、筹集资金的用途<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;7、风险与挑战<br>'+
                    '并配合项目相关的图片和视频进行介绍。<br>'+
                    '文字、图片的缺失会影响项目内容说明，将有可能无法上线。<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">4、您的项目应该具有可行性<br></span>'+
                    '优秀的创意通过众筹的方式变成现实，这是我们最在乎的事情。<br>'+
                    '因此，在蜂娱文化发起的所有众筹项目内容必须完整、合理、合法并具有可行性。<br>'+
                    '这要求您必须展示:<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;1、具体完整的计划<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;2、较明确的完成时间<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;3、足够的执行能力<br>'+
                    '如果您无法说明项目的可行性，将有可能无法上线。<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">6、您的项目应该是在公众面前首次亮相<br></span>'+
                    '作为支持文化娱乐创意的众筹平台，蜂娱文化致力于保护所有创意生产者的权益。<br>'+
                    '您发起项目中的内容（包括但不限于用于项目展示的文字、图片、视频及相应的项目回报等）不应该侵犯任何第三方的权益，否则将无法通过审核。<br>'+
                    '如果您的项目通过了蜂娱文化团队的初步审核，但是在上线之后收到其他社区成员的侵权举报，蜂娱文化保留将项目中止的权利。<br>'+
                    '如果您的众筹项目是同人作品，希望您先与作品的原作者进行沟通，取得相关授权之后将授权材料发给我们。这样做能够帮我们双方避免很多不必要的麻烦。除非版权方有公开的声明表示开放同人创作授权，并允许基于同人创作内容进行商业变现。<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">7、您发起的应该是一个众筹“项目”，而不是寻求“资助”<br></span>'+
                    '蜂娱文化的目标是帮助人们将新的或有质量的文化娱乐创意变成现实。相应地，您的众筹目标应该是完成一个“具有创新性质，并且可执行的项目”。<br>'+
                    '蜂娱文化不支持以“资助我”为目的的筹资项目。（例如：资助我的学费或债务、资助我旅行或度假、购买物品等。）<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">8、项目的回报规范<br></span>'+
                    '蜂娱文化在做的不是电商，而是文娱创意生产。您的回报应该围绕“创意”的核心。<br>'+
                    '项目回报必须是与项目创意本身相关的产品或者创意的衍生品；<br>'+
                    '不得以股权、期权、分红、利息或任何形式的资金收益作为回报；<br>'+
                    '项目回报不得是与创意无关的附加回报内容（如从第三方处采购的电子产品）；<br>'+
                    '不可以其他不可行、不合理的承诺作为附加回报；；<br>'+
                    '项目回报内容及形式必须符合中华人民共和国法律法规的规定；<br>'+
                    '如果您设置的回报不符合上述规范，将很有可能导致项目无法上线。<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">9、项目的完成度要求<br></span>'+
                    '在邀请公众为您的创意募集资金之前，您应该先向大家展示已经做出的努力。<br>'+
                    '如果您的项目完成度不够高，大家将无法理解项目的创意，这很有可能导致项目筹资失败。因此，我们建议您提交创意产品的 Demo 版本或者实物样品，并由蜂娱团队进行测试。<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">10、项目的创新性要求<br></span>'+
                    '蜂娱文化希望通过众筹带来更多新鲜有趣的文化创意体验，而不是成为一个广告发布的平台。在我们接到的项目申请中，有一些项目虽然是原创的，但是缺乏创新。<br>'+
                    '如果您的项目无法体现足够的创新性，将很有可能无法上线。<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">11、项目发起人资格<br></span>'+
                    '如果您是作为组织、机构发起一次众筹，应该满足如下要求：<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;1、是合法设立并有效存续的、有民事行为能力的法人或其他组织。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;2、拥有能够在中国地区接收人民币汇款的银行卡或者我方规定的第三方支付平台。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;3、提供必要的证明资质认证，根据项目内容，包括但不限于营业执照副本的复印件、经营许可证的复印件、组织机构代码复印件、法人身份证复印件等证明材料。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;4、在项目发布、执行中，根据蜂娱文化的需求提供各项协助，包括但不限于提供项目相关的证明文件、代理人授权书、专利证书、项目说明等。<br>'+
                    '如果您是作为个人发起一次众筹，应该满足如下要求：<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;1、项目发起人必须是年满18周岁，有完全民事责任能力的中国公民。若发起人尚不具备完全民事责任能力，应与网站协商由取得网站认可的代理人进行运作，该代理人承担一切民事责任及法律义务。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;2、拥有能够在中国地区接收人民币汇款的银行卡或者我方规定的第三方支付平台。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;3、提供必要的身份认证和资质认证，根据项目内容，有可能包括但不限于：身份证，护照，学历证明等。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;4、根据项目发布、执行需求，提供项目相关的证明文件、代理人授权书、专利证书、项目说明等。<br>'+
                    '<span style="font-weight:bold;font-size:1.1em">12、如何获得蜂娱文化的推荐以及更多推广资源</span>'+
                    '作为支持创意创新的众筹平台，蜂娱团队会依据以下的标准对项目进行评估:<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;1、清晰程度：项目描述逻辑清晰，细节丰富，有视频、图片或者 Demo 版本进行说明。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;2、制作水准：项目的制作水平比较优秀，能给受众带来良好的感受。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;3、创新性：与市面现有同类型产品相比，项目在某些方面具有独特的创新点。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;4、影响力：项目的发起人或团队具有一定的社会影响力，具有媒体资源或者推广渠道。<br>'+
                    '&nbsp;&nbsp;&nbsp;&nbsp;5、互动性：项目的发起团队能够在众筹页面及社交网络积极与受众进行互动。<br>'+
                    '<span style="font-weight:bold;font-size:1.2em;margin-top:20px;display:block;">如果您的项目满足 3 项以上，我们会将您的项目列为“首页推荐”，并给予更多资源支持。</span>'+
                    '</p>',
                    yes:function(){
                        window.open("/view/push/form01.jsp");
                    }
                })
            })
        })
    </script>

</html>