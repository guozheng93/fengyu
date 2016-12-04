package com.fengyu.common.core.base.vo;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 本类的作用是解决service层传递的EntityVo对象与dao层
 * 使用的Entity对象转换的问题，更轻松，更规范的处理该问题
 * @author junz
 * @create 2016 12 04 11:56
 */
@Component
public class VoTemplate {
    /**
     * 由程序员自己提供一个回调方法
     * @param vo
     * @return
     */
    public <T> T execute(VoCallback<T> vo){
        return vo.doInVo();
    }

    /**
     * 默认的回调方法，将v的属性值复制给t，并将t返回
     * @param t    回调对象
     * @param v    目标对象
     * @return
     */
    public <T,V> T defaultExcute(final T t,final V v){

        return this.execute(new VoCallback<T>(){

            @Override
            public T doInVo() {
                if(v==null) return null;
                BeanUtils.copyProperties(v,t);
                return t;
            }

        });
    }


}