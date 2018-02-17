package com.crmsys.web.action;

import org.hibernate.criterion.DetachedCriteria;

import com.crmsys.domain.Customer;
import com.crmsys.domain.PageBean;
import com.crmsys.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1182365763749566845L;
	private Customer customer = new Customer();
	private CustomerService customerService;
	private Integer pageCode = 1;
	private Integer pageSize = 2;
	
	
	
	public void setPageCode(Integer pageCode) {
		this.pageCode = pageCode;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getModel() {
		// TODO Auto-generated method stub
		return this.customer;
	}
	
	public String add() {
		System.out.println("添加客户，客户为：" + customer.getCust_name());
		customerService.save(customer);
		return NONE;
	}
	
	public String findByPage() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		PageBean<Customer> page = customerService.findByPage(pageCode, pageSize, criteria);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		return "list";
	}

}
