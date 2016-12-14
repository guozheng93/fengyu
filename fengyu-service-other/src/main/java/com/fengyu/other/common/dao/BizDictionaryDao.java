package com.fengyu.other.common.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.other.common.entity.po.BizDictionaryPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface BizDictionaryDao extends BaseDao<BizDictionaryPO>{

    public List<Map<String,Object>> getList4DicByMap(Map map);
}
