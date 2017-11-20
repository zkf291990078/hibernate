package com.anywell.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anywell.dao.CustomerDao;
import com.anywell.domain.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(customer);

		tx.commit();
		session.close();
	}

}
