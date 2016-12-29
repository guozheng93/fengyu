package com.fengyu.service.other.area.biz;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.other.area.entity.po.AreaPO;
import com.fengyu.service.other.area.dao.AreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/25
 */
@Service("areaBiz")
public class AreaBiz {

    @Autowired
    private AreaDao areaDao;

    public AreaPO getById(Integer id) {

        return areaDao.getById(id);
    }

    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        paramMap.put("pageNum",(pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("pageSize",pageParam.getNumPerPage());
        List<AreaPO> list = areaDao.getList(paramMap);
        Long count = areaDao.getCountList(paramMap);
        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
    }

    public long insert(AreaPO areaPO) {
        return areaDao.insert(areaPO);
    }

    public long update(AreaPO areaPO) {
        return areaDao.update(areaPO);
    }

    public long delete(Integer id) {
        return areaDao.delete(id);
    }
}
