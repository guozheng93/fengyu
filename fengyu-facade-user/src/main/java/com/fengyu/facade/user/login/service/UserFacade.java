package com.fengyu.facade.user.login.service;

import com.fengyu.facade.user.login.entity.po.UserPO;
import com.fengyu.facade.user.login.entity.vo.UserVO;
import org.springframework.http.ResponseEntity;

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
    UserPO findByLoginName(String loginName);

    long update(UserPO userPO);

    long insert(UserPO userPO);
}
