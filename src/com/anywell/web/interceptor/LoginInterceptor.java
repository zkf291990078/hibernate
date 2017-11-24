package com.anywell.web.interceptor;

import com.anywell.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		User user = (User) ActionContext.getContext().getSession().get("user");

		if (user != null) {
			return invocation.invoke();
		} else {
			return "toLogin";
		}

	}

}
