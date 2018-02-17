package com.crmsys.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crmsys.dao.CustomerDao;
import com.crmsys.domain.Customer;
import com.crmsys.domain.PageBean;
import com.crmsys.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void save(Customer customer) {
		customerDao.save(customer);
		
	}

	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		Integer totalCount = customerDao.getCount(criteria);
		PageBean<Customer> page = new PageBean<Customer>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		return customerDao.findByPage(page, criteria);
	}
	

}
