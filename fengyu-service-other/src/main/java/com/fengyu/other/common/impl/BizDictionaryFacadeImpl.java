package com.fengyu.other.common.impl;

import com.fengyu.common.core.base.service.impl.BaseServiceImpl;
import com.fengyu.facade.other.common.entity.vo.BizDictionaryVO;
import com.fengyu.facade.other.common.service.BizDictionaryFacade;
import com.fengyu.other.common.dao.BizDictionaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service(value = "bizDictionaryFacade")
@Transactional
public class BizDictionaryFacadeImpl extends BaseServiceImpl implements BizDictionaryFacade {

    @Autowired
    private BizDictionaryDao bizDictionaryDao;


    /**
     * @author Administrator
     * @date 2016/12/13 22:45
     * @description 获取字典列表 根据map
     * @param
     * @return
    **/

    @Override
    public List<BizDictionaryVO> getList4DicByMap(Map bizDictionaryVO) {
        List<BizDictionaryVO> voList=null;
        List list=bizDictionaryDao.getList4DicByMap(bizDictionaryVO);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,BizDictionaryVO.class
        ) ;
        return voList;
    }
}
