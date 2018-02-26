package com.crmsys.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crmsys.domain.Customer;
import com.crmsys.domain.Linkman;
import com.crmsys.domain.PageBean;
import com.crmsys.domain.Visit;
import com.crmsys.service.VisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class VisitAction extends ActionSupport implements ModelDriven<Visit> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7923157699663569114L;
	
	private Visit visit = new Visit();
	private VisitService visitService;
	private Integer pageCode = 1;
	private Integer pageSize = 5;
	private String beginDate;
	private String endDate;
	private String beginNextDate;
	private String endNextDate;
	
	
	
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setBeginNextDate(String beginNextDate) {
		this.beginNextDate = beginNextDate;
	}

	public void setEndNextDate(String endNextDate) {
		this.endNextDate = endNextDate;
	}

	public void setPageCode(Integer pageCode) {
		if(pageCode < 1 || pageCode == null) {
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public VisitService getVisitService() {
		return visitService;
	}

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit;
	}

	public String add() {
		visitService.save(visit);
		return NONE;
	}
	
	public String findByPage() {
		DetachedCriteria criteria = getCriteria(DetachedCriteria.forClass(Visit.class));
		PageBean<Visit> page = visitService.findByPage(pageCode, pageSize, criteria);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		vs.set("beginDate", beginDate);
		vs.set("endDate", endDate);
		return "list";
	}
	
	private DetachedCriteria getCriteria(DetachedCriteria criteria) {
		if(beginDate != null && !beginDate.trim().isEmpty()) {
			criteria.add(Restrictions.ge("visit_time", beginDate));
		}
		if(endDate != null && !endDate.trim().isEmpty()) {
			criteria.add(Restrictions.le("visit_time", endDate));
		}
		if(beginNextDate != null && !beginNextDate.trim().isEmpty()) {
			criteria.add(Restrictions.ge("visit_nexttime", beginNextDate));
		}
		if(endNextDate != null && !endNextDate.trim().isEmpty()) {
			criteria.add(Restrictions.le("visit_nexttime", endNextDate));
		}
		String visitAddr = visit.getVisit_address();
		if(visitAddr != null && !visitAddr.trim().isEmpty()) {
			criteria.add(Restrictions.like("visit_address", "%" + visitAddr + "%"));
		}
		Customer customer = visit.getCustomer();
		if(customer != null && !customer.getCust_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("customer.cust_id", customer.getCust_id()));
		}
		/*
		Linkman linkman = visit.getLinkman();
		System.out.println(linkman);
		System.out.println(linkman.getLink_id());
		if(linkman != null && !linkman.getLink_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("linkman.link_id", linkman.getLink_id()));
		}
		*/
		return criteria;
	}
}
