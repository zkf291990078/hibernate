package com.anywell.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.domain.Customer;

public interface CustomerDao {

	public void save(Customer customer);

	public List<Customer> findAll();

	public Customer getCustomer(long cust_id);

	public List<Customer> findAll(DetachedCriteria dc);

}
