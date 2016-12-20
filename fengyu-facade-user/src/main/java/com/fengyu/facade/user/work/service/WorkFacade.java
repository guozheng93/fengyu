package com.fengyu.facade.user.work.service;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.work.entity.po.WorkPO;

import java.util.Map;

/**
 * 工作信息对外接口
 * @author guoz
 * @version V1.0
 * @date 2016/12/14
 */
public interface WorkFacade {

    /**
     * 根据工作编号查询工作信息
     * @param id   工作编号
     * @return AddressPO 查询到的工作信息
     */
    public WorkPO getById(Integer id);
    /**
     * 分页查询
     * @param pageParam
     * @param paramMap
     * @return
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
    /**
     * 添加工作信息.
     * @param workPO 工作信息
     * @return result 添加结果
     */
    public long insert(WorkPO workPO);
    /**
     * 更新工作信息.
     * @param workPO 工作信息
     * @return result 更新结果
     */
    public long update(WorkPO workPO);
    /**
     * 删除工作信息.
     * @param id 工作编号
     * @return result 删除结果
     */
    public long delete(Integer id);
}
