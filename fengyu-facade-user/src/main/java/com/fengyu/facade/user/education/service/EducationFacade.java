package com.fengyu.facade.user.education.service;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.education.entity.po.EducationPO;

import java.util.Map;

/**
 * 学历对外接口
 * @author guoz
 * @version V1.0
 * @date 2016/12/14
 */
public interface EducationFacade {

    /**
     * 根据学历编号查询学历信息
     * @param id   学历编号
     * @return AddressPO 查询到的学历信息
     */
    public EducationPO getById(Integer id);
    /**
     * 分页查询
     * @param pageParam
     * @param paramMap
     * @return
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
    /**
     * 添加学历信息.
     * @param educationPO 学历信息
     * @return result 添加结果
     */
    public long insert(EducationPO educationPO);
    /**
     * 更新学历信息.
     * @param educationPO 学历信息
     * @return result 更新结果
     */
    public long update(EducationPO educationPO);
    /**
     * 删除学历信息.
     * @param id 学历编号
     * @return result 删除结果
     */
    public long delete(Integer id);
}
