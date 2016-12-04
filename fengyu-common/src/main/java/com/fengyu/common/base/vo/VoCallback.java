package com.fengyu.common.base.vo;

/**
 * vo 注入po 回调函数接口
 *
 * @author junz
 * @create 2016 12 04 11:57
 */
public interface VoCallback<T> {
    T doInVo();
}