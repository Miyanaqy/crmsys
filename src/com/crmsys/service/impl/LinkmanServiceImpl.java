package com.crmsys.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crmsys.dao.LinkmanDao;
import com.crmsys.domain.Linkman;
import com.crmsys.domain.PageBean;
import com.crmsys.service.LinkmanService;

@Transactional
public class LinkmanServiceImpl implements LinkmanService {
	
	private LinkmanDao linkmanDao;

	public LinkmanDao getLinkmanDao() {
		return linkmanDao;
	}

	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}

	public void add(Linkman linkman) {
		linkmanDao.save(linkman);
	}

	public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		Integer totalCount = linkmanDao.getCount(criteria);
		PageBean<Linkman> page = new PageBean<Linkman>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		return linkmanDao.findByPage(page, criteria);
	}

	public Linkman findById(String link_id) {
		// TODO Auto-generated method stub
		return linkmanDao.findById(link_id);
	}

	public void update(Linkman linkman) {
		// TODO Auto-generated method stub
		linkmanDao.update(linkman);
	}

	public Linkman delete(Linkman linkman) {
		// TODO Auto-generated method stub
		linkman = linkmanDao.findById(linkman.getLink_id());
		linkmanDao.delete(linkman);
		return linkman;
	}

	public List<Linkman> findByCriteria(DetachedCriteria criteria) {
		return linkmanDao.findByCriteria(criteria);
	}

	public List<Linkman> findAll() {
		return linkmanDao.findAll();
	}
}
