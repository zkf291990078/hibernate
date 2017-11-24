package com.anywell.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.anywell.dao.UserDao;
import com.anywell.domain.User;
import com.anywell.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUser(String code) {
		// TODO Auto-generated method stub
		Session session= HibernateUtils.getCurrentSession();
		String Hql="from User where user_code=?";
		Query query= session.createQuery(Hql);
		query.setParameter(0, code);
		return (User) query.uniqueResult();
	}

}
