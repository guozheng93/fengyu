package com.fengyu.facade.other.common.service;

import com.fengyu.common.core.base.service.BaseService;
import com.fengyu.facade.other.common.entity.vo.BizDictionaryVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/2.
 */
public interface BizDictionaryFacade extends BaseService{
    public List<BizDictionaryVO> getList4DicByMap(Map bizDictionaryVO);



}
