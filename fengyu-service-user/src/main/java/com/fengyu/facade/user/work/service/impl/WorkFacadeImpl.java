package com.fengyu.facade.user.work.service.impl;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.work.entity.po.WorkPO;
import com.fengyu.facade.user.work.service.WorkFacade;
import com.fengyu.service.user.work.biz.WorkBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author guoz
 * @version V1.0
 * @date 2016/12/17
 */
@Service("workFacade")
public class WorkFacadeImpl implements WorkFacade{

    @Autowired
    private WorkBiz workBiz;

    @Override
    public long delete(Integer id) {
        return workBiz.delete(id);
    }

    @Override
    public long update(WorkPO workPO) {
        return workBiz.update(workPO);
    }

    @Override
    public long insert(WorkPO workPO) {
        return workBiz.insert(workPO);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return workBiz.listPage(pageParam,paramMap);
    }

    @Override
    public WorkPO getById(Integer id) {
        return workBiz.getById(id);
    }
}
