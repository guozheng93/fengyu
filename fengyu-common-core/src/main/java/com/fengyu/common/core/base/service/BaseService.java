package com.fengyu.common.core.base.service;

import java.util.List;

/**
 * service 基本模式接口，实现基本增删该查操作
 *
 * @author junz
 * @create 2016 12 04 11:33
 */
public interface BaseService<EntityVo,PK> {
    /**
     * 增加
     * @param entityVo
     */
    public void save(EntityVo entityVo);
    /**
     * 修改
     * @param entityVo
     */
    public void update(EntityVo entityVo);
    /**
     * 通过主键删除
     * @param pk
     */
    public void deleteByPK(PK pk);
    /**
     * 删除
     * @param entityVo
     */
    public void delete(EntityVo entityVo);
    /**
     * 通过主键查询
     * @param pk
     * @return
     */
    public EntityVo get(PK pk);
    /**
     * 查询全部
     * @return
     */
    public List<EntityVo> findAll();

}
