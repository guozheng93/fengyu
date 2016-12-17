package com.fengyu.facade.user.Education.service.impl;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.address.entity.po.AddressPO;
import com.fengyu.facade.user.address.service.AddressFacade;
import com.fengyu.facade.user.education.entity.po.EducationPO;
import com.fengyu.facade.user.education.service.EducationFacade;
import com.fengyu.service.user.address.biz.AddressBiz;
import com.fengyu.service.user.education.biz.EducationBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 学历对外接口实现类
 * @author guoz
 * @version V1.0
 * @date 2016/12/14
 */
@Service("educationFacade")
public class EducationFacadeImpl implements EducationFacade{

    @Autowired
    private EducationBiz educationBiz;

    @Override
    public EducationPO getById(Integer id) {
        return educationBiz.getById(id);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return educationBiz.listPage(pageParam,paramMap);
    }

    @Override
    public long insert(EducationPO educationPO) {
        return educationBiz.insert(educationPO);
    }

    @Override
    public long update(EducationPO educationPO) {
        return educationBiz.update(educationPO);
    }

    @Override
    public long delete(Integer id) {
        return educationBiz.delete(id);
    }
}
