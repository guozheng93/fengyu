package com.fengyu.facade.other.verifycode.service;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.other.verifycode.entity.po.VerifyCodePO;

import java.util.Map;

/**
 * 通知信息对外接口
 * @author guoz
 * @version V1.0
 * @date 2016/12/14
 */
public interface VerifyCodeFacade {

    /**
     * 根据通知编号查询通知信息
     * @param id   通知编号
     * @return AddressPO 查询到的通知信息
     */
    public VerifyCodePO getById(Integer id);
    /**
     * 根据条件查询通知信息
     * @param sendTarget              发送目标
     * @param bizType                 业务类型
     * @param verifyCodeType         通知类型   1 手机通知   2 邮箱通知
     * @param verifyCode              验证码
     */
    public VerifyCodePO getByCondition(String sendTarget,int verifyCodeType,String bizType,String verifyCode);
    /**
     * 分页查询
     * @param pageParam
     * @param paramMap
     * @return
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
    /**
     * 添加通知信息.
     * @param verifyCodePO 通知信息
     * @return result 添加结果
     */
    public long insert(VerifyCodePO verifyCodePO);
    /**
     * 更新通知信息.
     * @param verifyCodePO 通知信息
     * @return result 更新结果
     */
    public long update(VerifyCodePO verifyCodePO);
    /**
     * 删除通知信息.
     * @param id 通知编号
     * @return result 删除结果
     */
    public long delete(Integer id);
}
