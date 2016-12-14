package com.fengyu.facade.user.service;

import com.fengyu.facade.user.entity.po.UserPO;
import com.fengyu.facade.user.entity.vo.UserVO;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
public interface UserFacade {

    UserVO findByLoginName(String loginName);
}
