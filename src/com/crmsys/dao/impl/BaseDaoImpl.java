package com.crmsys.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crmsys.dao.BaseDao;
import com.crmsys.domain.PageBean;

@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;
	
	public BaseDaoImpl() {
		Class c = this.getClass();
		Type type = c.getGenericSuperclass();
		if(type instanceof ParameterizedType) {
			ParameterizedType ptype = (ParameterizedType)type;
			Type [] types = ptype.getActualTypeArguments();
			this.clazz = (Class) types[0];
		}
	}
	
	public void save(T t) {
		this.getHibernateTemplate().save(t);
		
	}

	public T delete(T t) {
		this.getHibernateTemplate().delete(t);
		return t;
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
		
	}

	public T findById(Long id) {
		
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	public T findById(String id) {
		
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	public List<T> findAll() {
		List<T> beanList = (List<T>) this.getHibernateTemplate().find("from " + clazz.getSimpleName());
		return beanList;
	}

	public PageBean<T> findByPage(PageBean pageBean, DetachedCriteria criteria) {
		List<T> beanList = (List<T>) this.getHibernateTemplate().findByCriteria(criteria, (pageBean.getPageCode()-1) * pageBean.getPageSize(), pageBean.getPageSize());
		pageBean.setBeanList(beanList);
		return pageBean;
	}

	public int getCount(DetachedCriteria criteria) {
		int pageCount = 0;
		criteria.setProjection(Projections.rowCount());
		List<Number> list =  (List<Number>)  this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0) {
			pageCount = list.get(0).intValue();
		}
		criteria.setProjection(null);
		return pageCount;
	}

	public List<T> findByCriteria(DetachedCriteria criteria) {
		return  (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
	}

}
