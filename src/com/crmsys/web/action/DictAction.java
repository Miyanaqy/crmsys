package com.crmsys.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.crmsys.domain.Dict;
import com.crmsys.service.DictService;
import com.crmsys.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DictAction extends ActionSupport implements ModelDriven<Dict> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5738986846526053044L;

	private Dict dict = new Dict();
	private DictService dictService;
	
	
	
	public DictService getDictService() {
		return dictService;
	}

	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}

	public void setDict(Dict dict) {
		this.dict = dict;
	}

	public Dict getModel() {
		// TODO Auto-generated method stub
		return dict;
	}

	public String findByCode() {
		List<Dict> list = dictService.findByCode(dict);
		HttpServletResponse response = ServletActionContext.getResponse();
		String json = FastJsonUtil.toJson(list);
		System.out.println(json);	
		FastJsonUtil.writeJson(response, json);
		
		return NONE;
	}
}
