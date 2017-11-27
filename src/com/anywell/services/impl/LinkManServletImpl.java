package com.anywell.services.impl;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.anywell.dao.CustomerDao;
import com.anywell.dao.impl.CustomerDaoImpl;
import com.anywell.domain.Customer;
import com.anywell.domain.LinkMan;
import com.anywell.services.LinkManDao;
import com.anywell.services.LinkManService;
import com.anywell.services.UserService;
import com.anywell.utils.HibernateUtils;

public class LinkManServletImpl implements LinkManService {

	private CustomerDao cd;
	private LinkManDao lmd;

	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public LinkManDao getLmd() {
		return lmd;
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	@Override
	public void save(LinkMan linkMan) {
		// TODO Auto-generated method stub
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		cd = (CustomerDao) ac.getBean("cd");
		lmd = (LinkManDao) ac.getBean("lmd");
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			long cust_id = linkMan.getCust_id();
			Customer customer = cd.getCustomer(cust_id);
			// 2 将客户放入LinkMan中表达关系
			linkMan.setCustomer(customer);
			lmd.save(linkMan);
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		tx.commit();

	}

}
