package com.crmsys.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crmsys.domain.PageBean;

public interface BaseDao<T> {
	public void save(T t);
	
	public T delete(T t);
	
	public void update(T t);
	
	public T findById(Long id);
	
	public T findById(String id);
	
	public List<T> findAll();
	
	public int getCount(DetachedCriteria criteria);
	
	public PageBean<T> findByPage(PageBean<T> pagebean, DetachedCriteria criteria);
	
	public List<T> findByCriteria(DetachedCriteria criteria);

}
