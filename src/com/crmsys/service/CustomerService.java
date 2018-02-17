package com.crmsys.service;

import org.hibernate.criterion.DetachedCriteria;

import com.crmsys.domain.Customer;
import com.crmsys.domain.PageBean;

public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
	

}
