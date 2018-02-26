package com.crmsys.domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class Customer {
	
	private String cust_id;
	private String cust_name;
//	private String cust_level;
//	private String cust_resource;
	private String cust_phone;
	private String cust_mobile;
	private String cust_address;
//	private String cust_zip;
//	private String cust_fax;
	private String cust_filePath;
	
	@JSONField(serialize=false)
	private Dict level;
	@JSONField(serialize=false)
	private Dict source;
	@JSONField(serialize=false)
	private Dict industry;
	@JSONField(serialize=false)
	private User create_user;
	@JSONField(serialize=false)
	private User user;
	
	
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getCust_filePath() {
		return cust_filePath;
	}
	public void setCust_filePath(String cust_filePath) {
		this.cust_filePath = cust_filePath;
	}
	public Dict getLevel() {
		return level;
	}
	public void setLevel(Dict level) {
		this.level = level;
	}
	public Dict getSource() {
		return source;
	}
	public void setSource(Dict source) {
		this.source = source;
	}
	public Dict getIndustry() {
		return industry;
	}
	public void setIndustry(Dict industry) {
		this.industry = industry;
	}
	public User getCreate_user() {
		return create_user;
	}
	public void setCreate_user(User create_user) {
		this.create_user = create_user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
