package com.crmsys.service.impl;

import java.util.List;

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

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	public Customer findById(String cust_id) {
		return customerDao.findById(cust_id);
	}

	public Customer delete(String cust_id) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.findById(cust_id);
		customerDao.delete(customer);
		return customer;
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}
	

}
