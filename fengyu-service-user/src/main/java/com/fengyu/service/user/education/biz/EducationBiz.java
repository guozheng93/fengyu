package com.fengyu.service.user.education.biz;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.address.entity.po.AddressPO;
import com.fengyu.facade.user.education.entity.po.EducationPO;
import com.fengyu.service.user.education.dao.EducationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/16
 */
@Service("educationBiz")
public class EducationBiz {

    @Autowired
    private EducationDao educationDao;

    public EducationPO getById(Integer id) {

        return  educationDao.getById(id);
    }

    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        paramMap.put("pageNum",(pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("pageSize",pageParam.getNumPerPage());
        List<EducationPO> list = educationDao.getList(paramMap);
        Long count = educationDao.getCountList(paramMap);
        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
    }

    public long insert(EducationPO educationPO) {
        return educationDao.insert(educationPO);
    }

    public long update(EducationPO educationPO) {
        return educationDao.update(educationPO);
    }

    public long delete(Integer id) {
        return  educationDao.delete(id);
    }
}
