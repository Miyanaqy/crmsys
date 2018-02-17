package com.crmsys.service;

import java.util.List;

import com.crmsys.domain.Dict;

public interface DictService {

	List<Dict> findByCode(Dict dict);

}
