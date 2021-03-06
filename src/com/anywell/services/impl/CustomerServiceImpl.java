package com.anywell.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.anywell.dao.CustomerDao;
import com.anywell.dao.impl.CustomerDaoImpl;
import com.anywell.domain.Customer;
import com.anywell.services.CustomerService;
import com.anywell.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		customerDao.save(customer);
		tx.commit();
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> customers = customerDao.findAll();
		tx.commit();
		return customers;
	}

	@Override
	public List<Customer> findAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> customers = customerDao.findAll(dc);
		tx.commit();
		return customers;
	}

}
