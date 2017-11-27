package com.anywell.services.impl;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.anywell.dao.UserDao;
import com.anywell.dao.impl.UserDaoImpl;
import com.anywell.domain.User;
import com.anywell.services.UserService;
import com.anywell.utils.HibernateUtils;

public class UserServiceImpl implements UserService {
	private UserDao ud;

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		ud = (UserDao) ac.getBean("ud");
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User exitUser = ud.findUser(user.getUser_code());
		tx.commit();
		if (exitUser == null) {
			throw new RuntimeException("用户不存在");
		}
		if (!user.getUser_password().equals(exitUser.getUser_password())) {
			throw new RuntimeException("密码不正确");
		}

		return exitUser;
	}

}
