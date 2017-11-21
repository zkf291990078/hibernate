package com.anywell.services;

import java.util.List;

import com.anywell.domain.Customer;

public interface CustomerService {

	public void save(Customer customer);

	public List<Customer> findAll();
}
