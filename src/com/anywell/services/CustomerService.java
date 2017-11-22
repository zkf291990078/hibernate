package com.anywell.services;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.domain.Customer;

public interface CustomerService {

	public void save(Customer customer);

	public List<Customer> findAll();

	public List<Customer> findAll(DetachedCriteria dc);
}
