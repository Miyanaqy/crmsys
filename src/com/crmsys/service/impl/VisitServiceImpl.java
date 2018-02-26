package com.crmsys.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crmsys.dao.VisitDao;
import com.crmsys.domain.PageBean;
import com.crmsys.domain.Visit;
import com.crmsys.service.VisitService;

@Transactional
public class VisitServiceImpl implements VisitService {
	
	private VisitDao visitDao;

	public VisitDao getVisitDao() {
		return visitDao;
	}

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	public void save(Visit visit) {
		visitDao.save(visit);
	}

	public PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		Integer totalCount = visitDao.getCount(criteria);
		PageBean<Visit> page = new PageBean<Visit>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		return visitDao.findByPage(page, criteria);
	}
	

}
