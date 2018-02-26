package com.crmsys.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crmsys.domain.Linkman;
import com.crmsys.domain.PageBean;

public interface LinkmanService {

	void add(Linkman linkman);

	PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

	Linkman findById(String link_id);

	void update(Linkman linkman);

	Linkman delete(Linkman linkman);

	List<Linkman> findByCriteria(DetachedCriteria criteria);

	List<Linkman> findAll();

}
