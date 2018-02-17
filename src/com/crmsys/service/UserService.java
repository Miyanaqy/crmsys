package com.crmsys.service;

import com.crmsys.domain.User;

public interface UserService {

	void add(User user);

	User checkUsername(User user);

	User login(User user);
	
}
