package com.fengyu.service.other.verifycode.biz;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.other.verifycode.entity.VerifyCodePO;
import com.fengyu.service.other.verifycode.dao.VerifyCodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/17
 */
@Service("verifyCodeBiz")
public class VerifyCodeBiz {

    @Autowired
    private VerifyCodeDao verifyCodeDao;

    public VerifyCodePO getById(Integer id) {
        return verifyCodeDao.getById(id);
    }

    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        paramMap.put("pageNum",(pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("pageSize",pageParam.getNumPerPage());
        List<VerifyCodePO> list = verifyCodeDao.getList(paramMap);
        Long count = verifyCodeDao.getCountList(paramMap);
        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
    }

    public long insert(VerifyCodePO verifyCodePO) {
        return verifyCodeDao.insert(verifyCodePO);
    }

    public long update(VerifyCodePO verifyCodePO) {
        return verifyCodeDao.update(verifyCodePO);
    }

    public long delete(Integer id) {
        return verifyCodeDao.delete(id);
    }


    public VerifyCodePO getByCondition(String sendTarget, int verifyCodeType, String bizType, String verifyCode) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("sendTarget",sendTarget);
        paramMap.put("verifyCodeType",verifyCodeType);
        paramMap.put("bizType",bizType);
        paramMap.put("verifyCode",verifyCode);
        return verifyCodeDao.getBy(paramMap);
    }
}
