package com.fengyu.facade.order.service;

import com.fengyu.common.core.base.service.BaseService;
import com.fengyu.facade.order.entity.vo.OrderVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/2.
 */
public interface OrderFacade extends BaseService{
    public OrderVO getOrderOverview(OrderVO orderVO);

    public List<OrderVO> getPageList4Order(OrderVO orderVO);



}
