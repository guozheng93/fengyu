// define(function(require, exports, module){
//     var $ = require("jquery"),
//         template = require("template"),
//         tool = require("common/tool"),
//         tools = require("common/tools"),
//         infoLy = -1,
//         info = {};
//     module.exports = info;
//
//     //初始化
//     info.init = function(){
//         $("#name,#email,#info,#phone").val("");
//         $("#province,#city,#country").val("0");
//         info.event();
//         info.initProvince();
//     };
//
//     //事件注册
//     info.event = function(){
//         $("#submit").click(function(){
//             info.submit();
//         });
//
//         $("#birDay").click(function(){
//             info.changeBirDay(true);
//         });
//         $("#birMon").click(function(){
//             info.changeBirDay(false);
//         });
//
//     };
//
//     info.changeBirDay = function (flag) {
//         var year = $("#birYear").val();
//         var mon = $("#birMon").val();
//         var day;
//         if(year == 0){
//             tool.msg("请先选择生日年份",2);
//             return;
//         }
//         if(mon == 0 && flag == 'true'){
//             tool.msg("请先选择生日月份",2);
//             return;
//         }
//         if(mon == 4 || mon == 6 || mon == 9 || mon == 11){
//             day = 30;
//         }else if(mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12){
//             day = 31;
//         }else if(year%4==0 && mon == 2){
//             day = 29;
//         }else{
//             day = 28;
//         }
//         if(!flag){
//             var birDay = $("#birDay");
//             var birHTML = '<option value="0">请选择</option>';
//             for(var i = 1;i<=day; i++){
//                 birHTML+= '<option value="'+i+'">'+i+'</option>';
//             }
//             birDay.html(birHTML);
//         }
//     }
//
//     info.initProvince = function () {
//         alert("init province");
//         var params = {};
//         var config = {
//             url : "/common/area/list",
//             params : params,
//             onSuccess : info.doInitProvinceSuccess()
//         };
//         tool.apiReq(config);
//     }
//     info.doInitProvinceSuccess = function(res){
//         alert("success province");
//         var result = eval('(' + res.body + ')');
//         if(result.code == 1000 || result.code == 1001){
//             console.log(result);
//         }else if(result.code == 1002){
//             tool.msg(result.msg,2);
//         }else{
//             tool.msg("操作超时",2);
//         }
//     };
// });
