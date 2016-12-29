package com.fengyu.facade.other.verifycode.impl;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.other.verifycode.entity.po.VerifyCodePO;
import com.fengyu.facade.other.verifycode.service.VerifyCodeFacade;
import com.fengyu.service.other.verifycode.biz.VerifyCodeBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/17
 */
@Service("verifyCodeFacade")
public class VerifyCodeFacadeImpl implements VerifyCodeFacade{

    @Autowired
    private VerifyCodeBiz verifycodeBiz;

    @Override
    public VerifyCodePO getById(Integer id) {
        return verifycodeBiz.getById(id);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return verifycodeBiz.listPage(pageParam,paramMap);
    }

    @Override
    public long insert(VerifyCodePO verifyCodePO) {
        return verifycodeBiz.insert(verifyCodePO);
    }

    @Override
    public long update(VerifyCodePO verifyCodePO) {
        return verifycodeBiz.update(verifyCodePO);
    }

    @Override
    public long delete(Integer id) {
        return verifycodeBiz.delete(id);
    }

    @Override
    public VerifyCodePO getByCondition(String sendTarget, int verifyCodeType, String bizType, String verifyCode) {
        return verifycodeBiz.getByCondition(sendTarget,verifyCodeType,bizType,verifyCode);
    }
}
