package com.fengyu.facade.user.service;

import com.fengyu.facade.user.entity.vo.UserVO;

/**用户对外接口实现类
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
public interface UserFacade {
    /**
     * 根据登录名返回用户实体
     * @param loginName  登录名
     * @return
     */
    UserVO findByLoginName(String loginName);
}
