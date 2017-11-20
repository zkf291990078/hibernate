package com.anywell.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.anywell.domain.Customer;

public class TestInstance {

	@Test
	public void testAddCustomer() {
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer customer = new Customer();
		customer.setCust_name("阿里巴巴");
		session.save(customer);
		transaction.commit();
		session.close();
	}
}
