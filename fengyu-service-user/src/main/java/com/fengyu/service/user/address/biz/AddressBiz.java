package com.fengyu.service.user.address.biz;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.facade.user.address.entity.po.AddressPO;
import com.fengyu.service.user.address.dao.AddressDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/14
 */
@Service("addressBiz")
public class AddressBiz {

    @Autowired
    private AddressDao addressDao;

    public AddressPO getById(Integer id) {

        return addressDao.getById(id);
    }

    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        paramMap.put("pageNum",(pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("pageSize",pageParam.getNumPerPage());
        List<AddressPO> list = addressDao.getList(paramMap);
        Long count = addressDao.getCountList(paramMap);
        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), 0, null);

    }

    public long insert(AddressPO addressPO) {
        addressPO.setCreateTime(new Date());
        return addressDao.insert(addressPO);
    }

    public long update(AddressPO addressPO) {
        return  addressDao.update(addressPO);
    }

    public long delete(Integer id) {
        return  addressDao.delete(id);
    }
}
