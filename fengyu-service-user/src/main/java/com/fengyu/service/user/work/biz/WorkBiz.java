package com.fengyu.service.user.work.biz;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.info.entity.po.InfoPO;
import com.fengyu.facade.user.work.entity.po.WorkPO;
import com.fengyu.service.user.work.dao.WorkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoz
 * @version V1.0
 * @date 2016/12/17
 */
@Service("workBiz")
public class WorkBiz {

    @Autowired
    private WorkDao workDao;

    public long delete(Integer id) {
        return workDao.delete(id);
    }

    public long update(WorkPO workPO) {
        return workDao.update(workPO);
    }

    public long insert(WorkPO workPO) {
        return workDao.insert(workPO);
    }

    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        paramMap.put("pageNum",(pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("pageSize",pageParam.getNumPerPage());
        List<WorkPO> list = workDao.getList(paramMap);
        Long count = workDao.getCountList(paramMap);
        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
    }

    public WorkPO getById(Integer id) {
        return workDao.getById(id);
    }
}
