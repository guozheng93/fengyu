package com.fengyu.facade.address.service.impl;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.address.entity.po.AddressPO;
import com.fengyu.facade.address.service.AddressFacade;
import com.fengyu.service.address.biz.AddressBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 收货地址对外接口实现类
 * @author guoz
 * @version V1.0
 * @date 2016/12/14
 */
@Service("addressFacade")
public class AddressFacadeImpl implements AddressFacade{

    @Autowired
    private AddressBiz addressBiz;

    @Override
    public AddressPO getById(Integer id) {
        return addressBiz.getById(id);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return addressBiz.listPage(pageParam,paramMap);
    }

    @Override
    public long insert(AddressPO addressPO) {
        return addressBiz.insert(addressPO);
    }

    @Override
    public long update(AddressPO addressPO) {
        return addressBiz.update(addressPO);
    }

    @Override
    public long delete(Integer id) {
        return addressBiz.delete(id);
    }
}
