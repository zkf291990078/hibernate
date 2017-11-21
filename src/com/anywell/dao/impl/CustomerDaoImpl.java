package com.anywell.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.anywell.dao.CustomerDao;
import com.anywell.domain.Customer;
import com.anywell.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		session.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();
	}

	@Override
	public Customer getCustomer(long cust_id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		return session.get(Customer.class, cust_id);
	}

}
