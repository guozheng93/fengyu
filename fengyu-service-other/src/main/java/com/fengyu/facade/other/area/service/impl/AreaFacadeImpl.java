package com.fengyu.facade.other.area.service.impl;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.other.area.entity.po.AreaPO;
import com.fengyu.facade.other.area.service.AreaFacade;
import com.fengyu.service.other.area.biz.AreaBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/25
 */
@Service("areaFacade")
public class AreaFacadeImpl implements AreaFacade{

    @Autowired
    private AreaBiz areaBiz;

    @Override
    public AreaPO getById(Integer id) {
        return areaBiz.getById(id);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return areaBiz.listPage(pageParam,paramMap);
    }

    @Override
    public long insert(AreaPO areaPO) {
        return areaBiz.insert(areaPO);
    }

    @Override
    public long update(AreaPO areaPO) {
        return areaBiz.update(areaPO);
    }

    @Override
    public long delete(Integer id) {
        return areaBiz.delete(id);
    }
}
