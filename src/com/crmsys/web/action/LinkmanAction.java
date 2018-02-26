package com.crmsys.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crmsys.domain.Customer;
import com.crmsys.domain.Linkman;
import com.crmsys.domain.PageBean;
import com.crmsys.domain.User;
import com.crmsys.service.LinkmanService;
import com.crmsys.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8041841491801394047L;
	
	private Linkman linkman = new Linkman();
	private LinkmanService linkmanService;
	private Integer pageCode = 1;
	private Integer pageSize = 5;
	
	public void setPageCode(Integer pageCode) {
		if(pageCode < 1 || pageCode == null) {
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public LinkmanService getLinkmanService() {
		return linkmanService;
	}

	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}

	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}

	public Linkman getModel() {
		
		return this.linkman;
	}
	
	public String add() {
		User create_user = (User)ActionContext.getContext().getSession().get("user");
		if(create_user == null) {
			return "login";
		}
		linkman.setCreate_user(create_user);
		linkmanService.add(linkman);
		return "list";
	}
	
	public String findByPage() {
		DetachedCriteria criteria = getCriteria(DetachedCriteria.forClass(Linkman.class));
		PageBean<Linkman> page = linkmanService.findByPage(pageCode, pageSize, criteria);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		return "list";
	}
	
	public String findAll() {
		List<Linkman> list = linkmanService.findAll();
		String json = FastJsonUtil.toJson(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.writeJson(response, json);
		return NONE;
	}
	
	public String initUpdate() {
		linkman = linkmanService.findById(linkman.getLink_id());
		
		return "edit";
	}
	
	public String update() {
		linkmanService.update(linkman);
		return "tolist";
	}
	
	public String delete() {
		linkmanService.delete(linkman);
		return "tolist";
	}

	public String findByCriteria() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		Customer customer = linkman.getCustomer();
		if(customer == null || customer.getCust_id().trim().isEmpty()) {
			return NONE;
		}
		criteria.add(Restrictions.eq("customer.cust_id", customer.getCust_id()));
		List<Linkman> list = linkmanService.findByCriteria(criteria);
		String json = FastJsonUtil.toJson(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.writeJson(response, json);
		return NONE;
	}
	
	private DetachedCriteria getCriteria(DetachedCriteria criteria) {
		String linkmanName = linkman.getLink_name();
		if(linkmanName != null && !linkmanName.trim().isEmpty()) {
			criteria.add(Restrictions.like("link_name", "%" + linkmanName + "%"));
		}
		String linkmanPosition = linkman.getLink_position();
		if(linkmanPosition != null && !linkmanPosition.trim().isEmpty()) {
			criteria.add(Restrictions.like("link_position", "%" + linkmanPosition + "%"));
		}
		String linkmanGender = linkman.getLink_gender();
		if(linkmanGender != null && !linkmanGender.trim().isEmpty()) {
			criteria.add(Restrictions.eq("link_gender", linkmanGender));
		}
		String linkmanMobile = linkman.getLink_mobile();
		if(linkmanMobile != null && !linkmanMobile.trim().isEmpty()) {
			criteria.add(Restrictions.like("link_mobile", "%" + linkmanMobile + "%"));
		}
		String linkmanPhone = linkman.getLink_phone();
		if(linkmanPhone != null && !linkmanPhone.trim().isEmpty()) {
			criteria.add(Restrictions.like("link_phone", "%" + linkmanPhone + "%"));
		}
		String linkmanQQ = linkman.getLink_qq();
		if(linkmanQQ != null && !linkmanQQ.trim().isEmpty()) {
			criteria.add(Restrictions.like("link_qq", "%" + linkmanQQ + "%"));
		}
		String linkmanMail = linkman.getLink_mail();
		if(linkmanMail != null && !linkmanMail.trim().isEmpty()) {
			criteria.add(Restrictions.like("link_mail", "%" + linkmanMail + "%"));
		}
		Customer customer = linkman.getCustomer();
		if(customer != null && !customer.getCust_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("customer.cust_id", customer.getCust_id()));
		}
		return criteria;
	}
}
