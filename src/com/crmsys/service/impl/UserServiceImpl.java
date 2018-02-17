package com.crmsys.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.crmsys.common.Constance;
import com.crmsys.dao.UserDao;
import com.crmsys.domain.User;
import com.crmsys.service.UserService;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add(User user) {
		System.out.println("service≤„±ª∑√Œ °§°§°§");
		String fullpwd = user.getUser_name() + user.getUser_password() + Constance.KEY;
		String md5pwd = DigestUtils.md5DigestAsHex(fullpwd.getBytes());
		user.setUser_password(md5pwd);
		userDao.save(user);
		
	}

	public User checkUsername(User user) {
		return userDao.checkUsername(user);
		
	}

	public User login(User user) {
		String fullpwd = user.getUser_name() + user.getUser_password() + Constance.KEY;
		String md5pwd = DigestUtils.md5DigestAsHex(fullpwd.getBytes());
		user.setUser_password(md5pwd);
		User findUser = userDao.login(user);
		return findUser;
	}

}
