package com.crmsys.service;

import org.hibernate.criterion.DetachedCriteria;

import com.crmsys.domain.PageBean;
import com.crmsys.domain.Visit;

public interface VisitService {

	void save(Visit visit);

	PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

}
