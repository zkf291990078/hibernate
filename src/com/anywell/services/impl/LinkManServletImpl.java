package com.anywell.services.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.anywell.dao.CustomerDao;
import com.anywell.dao.impl.CustomerDaoImpl;
import com.anywell.domain.Customer;
import com.anywell.domain.LinkMan;
import com.anywell.services.LinkManDao;
import com.anywell.services.LinkManService;
import com.anywell.utils.HibernateUtils;

public class LinkManServletImpl implements LinkManService {

	private CustomerDao cd = new CustomerDaoImpl();
	private LinkManDao lmd = new LinkManDaoImpl();

	@Override
	public void save(LinkMan linkMan) {
		// TODO Auto-generated method stub
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
