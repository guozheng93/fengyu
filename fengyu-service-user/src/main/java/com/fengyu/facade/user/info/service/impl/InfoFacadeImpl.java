package com.fengyu.facade.user.info.service.impl;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.info.entity.po.InfoPO;
import com.fengyu.facade.user.info.service.InfoFacade;
import com.fengyu.service.user.info.biz.InfoBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author guoz
 * @version V1.0
 * @date 2016/12/16
 */
@Service("infoFacade")
public class InfoFacadeImpl implements InfoFacade{

    @Autowired
    private InfoBiz infoBiz;

    @Override
    public InfoPO getById(Integer id) {
        return infoBiz.getById(id);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return infoBiz.listPage(pageParam,paramMap);
    }

    @Override
    public long insert(InfoPO infoPO) {
        return infoBiz.insert(infoPO);
    }

    @Override
    public long update(InfoPO infoPO) {
        return infoBiz.update(infoPO);
    }

    @Override
    public long delete(Integer id) {
        return infoBiz.delete(id);
    }
}
