package com.anywell.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.anywell.domain.Customer;
import com.anywell.services.CustomerService;
import com.anywell.services.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	public String list() throws Exception {
		// TODO Auto-generated method stub
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(cust_name)) {
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
		}
		CustomerService service = new CustomerServiceImpl();
		List<Customer> list = service.findAll(dc);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
}
