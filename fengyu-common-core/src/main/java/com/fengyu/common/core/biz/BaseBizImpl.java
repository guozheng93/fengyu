package com.fengyu.common.core.biz;

import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.common.entity.BaseEntity;
import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;

import java.util.List;
import java.util.Map;


/**
 * 基类Biz接口实现类
 * 
 * @author Hill
 * 
 */
public abstract class BaseBizImpl<T extends BaseEntity> implements BaseBiz<T> {

	protected abstract BaseDao<T> getDao();

	public Integer create(T entity) {
		return getDao().insert(entity);
	}

	public Integer create(List<T> list) {
		return getDao().insert(list);
	}

	public Integer update(T entity) {
		return getDao().update(entity);
	}

	public Integer update(List<T> list) {
		return getDao().update(list);
	}

	public T getById(Integer id) {
		return this.getDao().getById(id);
	}

	/**
	 * 根据ID删除记录.
	 * 
	 * @param id
	 *            .
	 * @return
	 */
	public Integer deleteById(Integer id) {
		return this.getDao().delete(id);
	}

	/**
	 * 分页查询 .
	 * 
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            业务条件查询参数.
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return this.getDao().listPage(pageParam, paramMap);
	}

	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
		return this.getDao().listPage(pageParam, paramMap, sqlId);
	}

	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回集合
	 */
	public List<T> listBy(Map<String, Object> paramMap) {
		return this.getDao().listBy(paramMap);
	}

	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		return this.getDao().listBy(paramMap, sqlId);
	}

	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回实体
	 */
	public T getBy(Map<String, Object> paramMap) {
		return this.getDao().getBy(paramMap);
	}

	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		return this.getDao().getBy(paramMap, sqlId);
	}

//	/**
//	 * 根据序列名称获取下一个值
//	 *
//	 * @return
//	 */
//	public String getSeqNextValue(String seqName) {
//		return this.getDao().getSeqNextValue(seqName);
//	}

}
