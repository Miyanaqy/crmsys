package com.crmsys.domain;

import java.util.List;

public class PageBean<T> {
	private int pageCode;
	private int totalCount;
	private int pageSize;
	private List<T> beanList;
	
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		int totalPage = totalCount / pageSize;
		if(totalCount % pageSize != 0 ) {
			totalPage =+ 1;
		}
		return totalPage;
	}

}
