package com.crmsys.dao;

import java.util.List;

import com.crmsys.domain.Dict;

public interface DictDao extends BaseDao<Dict> {

	List<Dict> findByCode(Dict dict);

}
