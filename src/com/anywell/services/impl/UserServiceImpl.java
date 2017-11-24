package com.anywell.services.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.anywell.dao.UserDao;
import com.anywell.dao.impl.UserDaoImpl;
import com.anywell.domain.User;
import com.anywell.services.UserService;
import com.anywell.utils.HibernateUtils;

public class UserServiceImpl implements UserService {
	private UserDao ud = new UserDaoImpl();

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx= session.beginTransaction();
		User exitUser=ud.findUser(user.getUser_code());
		tx.commit();
		if(exitUser==null){
			throw new RuntimeException("用户不存在");
		}
		if(!user.getUser_password().equals(exitUser.getUser_password())){
			throw new RuntimeException("密码不正确");
		}
		
		return exitUser;
	}

}
