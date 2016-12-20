package com.fengyu.service.user.info.biz;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.address.entity.po.AddressPO;
import com.fengyu.facade.user.info.entity.po.InfoPO;
import com.fengyu.service.user.info.dao.InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoz
 * @version V1.0
 * @date 2016/12/16
 */
@Service("infoBiz")
public class InfoBiz {

    @Autowired
    private InfoDao infoDao;

    public InfoPO getById(Integer id) {
        return infoDao.getById(id);
    }

    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        paramMap.put("pageNum",(pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("pageSize",pageParam.getNumPerPage());
        List<InfoPO> list = infoDao.getList(paramMap);
        Long count = infoDao.getCountList(paramMap);
        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
    }

    public long insert(InfoPO infoPO) {
        return infoDao.insert(infoPO);
    }

    public long update(InfoPO infoPO) {
        return  infoDao.update(infoPO);
    }

    public long delete(Integer id) {
        return  infoDao.delete(id);
    }
}
