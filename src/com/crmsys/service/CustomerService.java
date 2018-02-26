package com.crmsys.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crmsys.domain.Customer;
import com.crmsys.domain.PageBean;

public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

	List<Customer> findAll();

	Customer findById(String cust_id);

	Customer delete(String cust_id);

	void update(Customer customer);
	

}
