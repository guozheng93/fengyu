package com.fengyu.order.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.order.entity.po.OrderPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface OrderDao extends BaseDao<OrderPO> {
    public Map getOrderOverview(Map map);

    public List<Map<String,Object>> getPageList4Order(Map map);

}
