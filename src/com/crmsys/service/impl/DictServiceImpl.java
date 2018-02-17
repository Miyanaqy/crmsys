package com.crmsys.service.impl;

import java.util.List;

import com.crmsys.dao.DictDao;
import com.crmsys.domain.Dict;
import com.crmsys.service.DictService;

public class DictServiceImpl implements DictService{
	private DictDao dictDao;

	public DictDao getDictDao() {
		return dictDao;
	}

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	public List<Dict> findByCode(Dict dict) {
		
		return dictDao.findByCode(dict);
	}
	
	

}
