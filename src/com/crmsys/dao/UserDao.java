package com.crmsys.dao;

import com.crmsys.domain.User;

public interface UserDao extends BaseDao<User>{

	User checkUsername(User user);

	User login(User user);

}
