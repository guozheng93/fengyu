package com.fengyu.facade.other.area.service;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.other.area.entity.po.AreaPO;

import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/25
 */
public interface AreaFacade {
    /**
     * 根据地区编号查询地区信息
     * @param id   地区编号
     * @return AddressPO 查询到的地区信息
     */
    public AreaPO getById(Integer id);
    /**
     * 分页查询
     * @param pageParam
     * @param paramMap
     * @return
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
    /**
     * 添加地区信息.
     * @param areaPO 地区信息
     * @return result 添加结果
     */
    public long insert(AreaPO areaPO);
    /**
     * 更新地区信息.
     * @param areaPO 地区信息
     * @return result 更新结果
     */
    public long update(AreaPO areaPO);
    /**
     * 删除地区信息.
     * @param id 地区编号
     * @return result 删除结果
     */
    public long delete(Integer id);
}
