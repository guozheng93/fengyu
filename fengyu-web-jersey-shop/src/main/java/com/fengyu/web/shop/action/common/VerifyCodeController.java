package com.fengyu.web.shop.action.common;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.facade.other.verifycode.entity.po.VerifyCodePO;
import com.fengyu.facade.other.verifycode.service.VerifyCodeFacade;
import com.fengyu.web.shop.util.API.Phone.AliMsgApi;
import com.fengyu.web.shop.util.API.Phone.enums.PhoneCode;
import com.fengyu.web.shop.util.token.ResponseUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guoz
 * @version V1.0
 * @date 2016/12/17
 */
@Component
@Path("/common")
public class VerifyCodeController extends BaseController{

    private static final Logger logger = LogManager.getLogger(VerifyCodeController.class);

    private static final int  CODETIME = 30;   //验证码失效时间   毫秒

    @Autowired
    private VerifyCodeFacade verifyCodeFacade;

    @POST
    @Path("send")
    public String get(String args)
    {
        try {
            VerifyCodePO verifyCodePO = JSON.parseObject(args, VerifyCodePO.class);
            String codeType = verifyCodePO.getBizType();
            Map<String,String> paramMap = tempString(codeType);
            String result = new AliMsgApi().sendMsg(verifyCodePO.getSendTarget(), tempCode(codeType),paramMap);
            Map<String,Object> map = JSON.parseObject(result);
            long errorCode = -1;
            String errorMsg = "";
            if(map.get("alibaba_aliqin_fc_sms_num_send_response") != null){
                errorCode = 0;
            }else{
                Map<String,Object> response = JSON.parseObject(map.get("error_response").toString());
                errorCode = Integer.parseInt(response.get("code").toString());
                errorMsg = response.get("sub_msg").toString();
            }
            Calendar nowTime = Calendar.getInstance();
            nowTime.add(Calendar.MINUTE, CODETIME);//30分钟后的时间
            verifyCodePO.setVerifyCode(paramMap.get("code")!=null?paramMap.get("code"):null);
            verifyCodePO.setGenTime(new Date());
            verifyCodePO.setDeadTime(nowTime.getTime());
            verifyCodePO.setSendResult(errorCode+":"+errorMsg);
            verifyCodePO.setStatus(false);
            errorCode = verifyCodeFacade.insert(verifyCodePO);
            if(errorCode == 0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception(errorMsg);
            }
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }

    @POST
    @Path("valid")
    public String list(String args) {
        try {
            VerifyCodePO verifyCodePO = JSON.parseObject(args, VerifyCodePO.class);
            if (verifyCodePO.getSendTarget() == null) {
                return ResponseUtil.exception("手机号不合法");
            }
            if (verifyCodePO.getVerifyCode() == null) {
                return ResponseUtil.exception("验证码错误");
            }
            VerifyCodePO result = verifyCodeFacade.getByCondition(verifyCodePO.getSendTarget(), verifyCodePO.getVerifyCodeType(), verifyCodePO.getBizType(), verifyCodePO.getVerifyCode());
            if (result != null && result.getDeadTime().after(new Date())) {
                result.setStatus(true);
                verifyCodeFacade.update(result);
                return ResponseUtil.success();
            } else {
                return ResponseUtil.exception("验证码错误或者超时");
            }
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }

    public String tempCode(String type){
        switch (type){
            case "register":{
                return "SMS_8551007";
            }default:{
                return null;
            }
        }
    }

    public Map<String,String> tempString(String type){
        Map<String,String> paramMap =new HashMap<String,String>();
        switch (type){
            case "register":{
                paramMap.put("code", PhoneCode.getPhoneCode());
                paramMap.put("product","蜂娱文化");
                return paramMap;
            }default:{
                return paramMap;
            }
        }
    }
}
