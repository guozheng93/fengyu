package com.fengyu.common.core.base.service.impl;

import com.fengyu.common.core.base.service.BaseService;
import com.fengyu.common.core.base.vo.VoTemplate;
import com.fengyu.common.utils.ObjectTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 处理entityVo和entity直接转化
 *
 * @author junz
 * @create 2016 12 04 11:33
 */
public class BaseServiceImpl implements BaseService{
    @Autowired
    private VoTemplate voTemplate;
    @Autowired
    private ObjectTransformer objectTransformer;

    public ObjectTransformer getObjectTransformer() {
        return objectTransformer;
    }

    public void setObjectTransformer(ObjectTransformer objectTransformer) {
        this.objectTransformer = objectTransformer;
    }

    public final void setVoTemplate(VoTemplate voTemplate) {
        this.voTemplate = voTemplate;
    }

    public final VoTemplate getVoTemplate(){
        return this.voTemplate;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void deleteByPK(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}