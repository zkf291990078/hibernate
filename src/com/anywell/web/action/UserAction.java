package com.anywell.web.action;

import com.anywell.domain.User;
import com.anywell.services.UserService;
import com.anywell.services.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private UserService us = new UserServiceImpl();

	public String login() throws Exception {
		// TODO Auto-generated method stub
		// 1 调用Service 执行登陆操作
		User u = us.login(user);
		// 2 将返回的User对象放入session域作为登陆标识
		ActionContext.getContext().getSession().put("user", u);
		// 3 重定向到项目的首页
		return "toHome";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
