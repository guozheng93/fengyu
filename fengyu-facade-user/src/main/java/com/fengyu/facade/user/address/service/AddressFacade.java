package com.fengyu.facade.user.address.service;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.address.entity.po.AddressPO;

import java.util.Map;

/**
 * 收货地址对外接口
 * @author guoz
 * @version V1.0
 * @date 2016/12/14
 */
public interface AddressFacade {

    /**
     * 根据收货地址编号查询收货地址信息
     * @param id   收货地址编号
     * @return AddressPO 查询到的收货地址信息
     */
    public AddressPO getById(Integer id);
    /**
     * 分页查询
     * @param pageParam
     * @param paramMap
     * @return
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
    /**
     * 添加收货地址信息.
     * @param addressPO 收货地址信息
     * @return result 添加结果
     */
    public long insert(AddressPO addressPO);
    /**
     * 更新收货地址信息.
     * @param addressPO 收货地址信息
     * @return result 更新结果
     */
    public long update(AddressPO addressPO);
    /**
     * 删除收货地址信息.
     * @param id 收货地址编号
     * @return result 删除结果
     */
    public long delete(Integer id);


}
