package com.crmsys.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crmsys.domain.Customer;
import com.crmsys.domain.Dict;
import com.crmsys.domain.PageBean;
import com.crmsys.domain.User;
import com.crmsys.service.CustomerService;
import com.crmsys.utils.FastJsonUtil;
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
	private Integer pageSize = 5;
	
	
	
	public void setPageCode(Integer pageCode) {
		if(pageCode == null || pageCode < 1) {
			pageCode = 1;
		}
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
		User create_user = (User)ActionContext.getContext().getSession().get("user");
		if(create_user == null) {
			return "login";
		}
		customer.setCreate_user(create_user);
		customerService.save(customer);
		return "tolist";
	}
	
	public String findByPage() {
		DetachedCriteria criteria = getCriteria(DetachedCriteria.forClass(Customer.class));
		PageBean<Customer> page = customerService.findByPage(pageCode, pageSize, criteria);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		return "list";
	}

	public String findAll() {
		List<Customer> list = customerService.findAll();
		String json = FastJsonUtil.toJson(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.writeJson(response, json);
		return NONE;
	}
	
	public String initUpdate() {
		customer = customerService.findById(customer.getCust_id());

		return "edit";
	}
	
	public String update() {
		customerService.update(customer);
		return "tolist";
	}
	
	public String delete() {
		customer = customerService.delete(customer.getCust_id());
		
		return "tolist";
	}
	
	
	
	private DetachedCriteria getCriteria(DetachedCriteria criteria) {
		String custName = customer.getCust_name();
		if(custName != null && !custName.trim().isEmpty()) {
			criteria.add(Restrictions.like("cust_name", "%" + custName + "%"));
		}
		String custMobile = customer.getCust_mobile();
		if(custMobile != null && !custMobile.trim().isEmpty()) {
			criteria.add(Restrictions.like("cust_mobile", "%" + custMobile + "%"));
		}
		String custPhone = customer.getCust_phone();
		if(custPhone != null && !custPhone.trim().isEmpty()) {
			criteria.add(Restrictions.like("cust_phone", "%" + custPhone + "%"));
		}
		String custAddr = customer.getCust_address();
		if(custAddr != null && !custAddr.trim().isEmpty()) {
			criteria.add(Restrictions.like("cust_address", "%" + custAddr + "%"));
		}
		Dict level = customer.getLevel();
		if(level != null && !level.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
		}
		Dict source = customer.getSource();
		if(source != null && !source.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("source.dict_id", source.getDict_id()));
		}
		Dict industry = customer.getIndustry();
		if(industry != null && !industry.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("industry.dict_id", industry.getDict_id()));
		}
		User user = customer.getUser();
		if(user != null && !user.getUser_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("user.user_id", user.getUser_id()));
		}
		return criteria;
	}
}
