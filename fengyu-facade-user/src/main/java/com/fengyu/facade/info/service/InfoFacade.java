package com.fengyu.facade.info.service;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.address.entity.po.AddressPO;
import com.fengyu.facade.info.entity.po.InfoPO;

import java.util.Map;

/**
 * 用户信息对外接口实现类
 * @author guoz
 * @version V1.0
 * @date 2016/12/16
 */
public interface InfoFacade {

    /**
     * 根据用户资料编号查询收货用户资料信息
     * @param id   用户资料编号
     * @return AddressPO 查询到的用户资料信息
     */
    public InfoPO getById(Integer id);
    /**
     * 分页查询
     * @param pageParam
     * @param paramMap
     * @return
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
    /**
     * 添加用户资料.
     * @param infoPO 用户资料信息
     * @return result 添加结果
     */
    public long insert(InfoPO infoPO);
    /**
     * 更新用户资料.
     * @param infoPO 用户资料信息
     * @return result 更新结果
     */
    public long update(InfoPO infoPO);
    /**
     * 删除用户资料.
     * @param id 用户资料编号
     * @return result 删除结果
     */
    public long delete(Integer id);
}
