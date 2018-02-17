package com.crmsys.dao.impl;

import java.util.List;

import com.crmsys.dao.DictDao;
import com.crmsys.domain.Dict;

public class DictDaoImpl extends BaseDaoImpl<Dict> implements DictDao {

	@SuppressWarnings("unchecked")
	public List<Dict> findByCode(Dict dict) {
		List<Dict> list = (List<Dict>)this.getHibernateTemplate().find("from Dict where dict_type_code=?", dict.getDict_type_code());
		return list;
	}



}
