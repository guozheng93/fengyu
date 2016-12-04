package com.fengyu.common.core.base.service.impl;

import com.fengyu.common.core.base.vo.VoTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 处理entityVo和entity直接转化
 *
 * @author junz
 * @create 2016 12 04 11:33
 */
public class BaseServiceImpl {

    private VoTemplate voTemplate;

    @Autowired
    public final void setVoTemplate(VoTemplate voTemplate) {
        this.voTemplate = voTemplate;
    }

    public final VoTemplate getVoTemplate(){
        return this.voTemplate;
    }
}