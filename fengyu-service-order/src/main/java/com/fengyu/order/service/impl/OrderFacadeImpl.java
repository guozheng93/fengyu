package com.fengyu.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.core.base.service.impl.BaseServiceImpl;
import com.fengyu.common.utils.BeanUtils;
import com.fengyu.facade.order.entity.vo.OrderVO;
import com.fengyu.facade.order.service.OrderFacade;
import com.fengyu.order.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service(value = "orderFacade")
@Transactional
public class OrderFacadeImpl extends BaseServiceImpl implements OrderFacade {

    @Autowired
    private OrderDao orderDao;


    @Override
    public OrderVO getOrderOverview(OrderVO orderVO) {
        Map map = JSON.parseObject(JSON.toJSONString(orderVO), HashMap.class);
        Map returnMap = orderDao.getOrderOverview(map);
        returnMap = BeanUtils.transDataMap2BeanMap4FiledName(returnMap);
        return JSON.parseObject(JSON.toJSONString(returnMap), OrderVO.class);
    }

    @Override
    public List<OrderVO> getPageList4Order(OrderVO orderVO) {
        Map map = JSON.parseObject(JSON.toJSONString(orderVO), HashMap.class);
        List<OrderVO> voList =
            super.getObjectTransformer().defaulBatchtExcute(
                orderDao.getPageList4Order(map)
                ,OrderVO.class
        ) ;
        return voList;
    }
}
