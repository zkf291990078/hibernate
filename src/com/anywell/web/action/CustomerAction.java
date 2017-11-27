package com.anywell.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.anywell.domain.Customer;
import com.anywell.services.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String list() throws Exception {
		// TODO Auto-generated method stub
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		customerService = (CustomerService) ac.getBean("customerService");

		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(cust_name)) {
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
		}

		List<Customer> list = customerService.findAll(dc);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}

	public String add() throws Exception {
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		customerService = (CustomerService) ac.getBean("customerService");
		customerService.save(customer);
		return "toList";
	}

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
}
