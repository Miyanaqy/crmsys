package com.crmsys.domain;

public class Visit {
	
	private String visit_id;
	private User create_user;
	private Customer customer;
	private Linkman linkman;
	private String visit_time;
	private String visit_address;
	private String visit_detail;
	private String visit_nexttime;
	
	
	public String getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}
	public User getCreate_user() {
		return create_user;
	}
	public void setCreate_user(User create_user) {
		this.create_user = create_user;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Linkman getLinkman() {
		return linkman;
	}
	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}
	public String getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}
	public String getVisit_address() {
		return visit_address;
	}
	public void setVisit_address(String visit_address) {
		this.visit_address = visit_address;
	}
	public String getVisit_detail() {
		return visit_detail;
	}
	public void setVisit_detail(String visit_detail) {
		this.visit_detail = visit_detail;
	}
	public String getVisit_nexttime() {
		return visit_nexttime;
	}
	public void setVisit_nexttime(String visit_nexttime) {
		this.visit_nexttime = visit_nexttime;
	}
	
	

}
