package com.crmsys.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crmsys.dao.UserDao;
import com.crmsys.domain.User;

@SuppressWarnings("all")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public User checkUsername(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_name=?", user.getUser_name());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
		
	}

	public User login(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_name", user.getUser_name()));
		criteria.add(Restrictions.eq("user_password", user.getUser_password()));
		List<User> list = (List<User>)this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() >0) {
			return list.get(0);
		}
		return null;
	}

}
